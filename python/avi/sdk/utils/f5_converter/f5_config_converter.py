import json
import copy
import numbers
import logging
import os
import shlex
import subprocess

LOG = logging.getLogger("converter-log")


def convert_servers_config(servers_config, nodes):
    """
    Converts the config of servers in the pool
    :param servers_config: F5 servers config for particular pool
    :param nodes: F5 node config to resolve IP of the server
    :return: List of Avi server configs
    """
    server_list = []
    for server_name in servers_config.keys():
        server = servers_config[server_name]
        parts = server_name.split(':')
        ip_addr = nodes[parts[0]]["address"]
        port = parts[1] if len(parts) == 2 else 80
        enabled = True
        state = server.get("state", 'enabled')
        if state == "user-down":
            enabled = False
        server_list.append({
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        })
    return server_list


def get_avi_pool_down_action(action):
    """
    Maps Pool down action from F5 config to Avi Config
    :param action: F5 action string
    :return: Avi action String
    """
    if action == "reset":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    if action == "reselect":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    else:
        return "POOL_DOWN_ACTION_CLOSE_CONN"


def get_monitor_obj(monitor_name, monitor_config_list):
    """
    Search monitor by name from list of monitors
    """
    for monitor in monitor_config_list:
        if monitor["name"] == monitor_name:
            return monitor
    return None


def convert_pool_config(pool_config, nodes, tenant, monitor_config_list):
    """
    Convert list of pools from F5 config to Avi config
    :param pool_config: F5 pool config
    :param nodes: F5 node list to resolve server IPs
    :param tenant: name of tenant for default objects
    :param monitor_config_list: Avi monitor config list
    :return: List of pools converted to Avi configuration
    """
    pool_list = []
    for pool_name in pool_config.keys():
        f5_pool = pool_config[pool_name]
        if not f5_pool:
            LOG.debug("Empty pool skiped for conversion :"+pool_name)
            continue
        servers = convert_servers_config(f5_pool.get("members", {}), nodes)
        sd_action = f5_pool.get("service-down-action", "")
        pd_action = get_avi_pool_down_action(sd_action)
        pool_obj = {
                "name": pool_name,
                "servers": servers,
                "pd_action_type": pd_action
            }
        monitor_names = f5_pool.get("monitor", None)
        default_monitors = {"http": "System-HTTP", "https": "System-HTTPS",
                            "dns": "System-DNS", "tcp": "System-TCP",
                            "udp": "System-UDP","gateway_icmp": "System-Ping",
                            "icmp": "System-Ping"}
        is_ssl = False
        if monitor_names:
            monitors = monitor_names.split(" and ")
            monitor_refs = []
            for monitor in monitors:
                monitor = monitor.strip()
                monitor_obj = get_monitor_obj(monitor, monitor_config_list)
                if monitor_obj:
                    monitor_refs.append(monitor_obj["name"])
                    if monitor_obj["type"] == "HEALTH_MONITOR_HTTPS":
                        is_ssl = True
                elif monitor in default_monitors.keys():
                    if monitor == "https":
                        is_ssl = True
                    monitor = tenant+":"+default_monitors[monitor]
                    monitor_refs.append(monitor)
                else:
                    LOG.warning("Skiping non supported monitor: %s for pool %s"
                                % (monitor, pool_name))
            pool_obj["health_monitor_refs"] = monitor_refs
        if is_ssl:
            pool_obj["ssl_profile_ref"] = "admin:System-Standard"
        pool_list.append(pool_obj)
        del pool_config[pool_name]
    return pool_list


def get_ssl_profile(profiles, type, profile_config):
    profile_names = []
    if not profiles:
        return []
    for name in profiles.keys():
        profile = profiles.get(name, None)
        if profile:
            profile_obj = [obj for obj in profile_config if obj['name'] == name]
            if name not in ("clientssl", "serverssl") and not profile_obj:
                continue
            context = profile.get("context", None)
            if context == type:
                profile_names.append(name)
    return profile_names


def is_pool_shared(pool_ref, vs_list):
    """
    F5 supports shared pool here we validate for if pool in VS
    is shared with other VS or not
    :param pool_ref: Name of the pool
    :param vs_list: List of existing converted VS
    :return: Boolean for shared pool
    """
    for vs in vs_list:
        if vs["pool_ref"] == pool_ref:
            return True
    return False


def clone_pool(pool_name, vs_name, avi_pool_list):
    """
    If pool is shared with other VS pool is cloned for other VS as Avi dose not
    support shared pools with new pool name as <pool_name>-<vs_name>
    :param pool_name: Name of the pool to be cloned
    :param vs_name: Name of the VS for pool to be cloned
    :param avi_pool_list: new pool to be added to this list
    :return: new pool object
    """
    new_pool = None
    for pool in avi_pool_list:
        if pool["name"] == pool_name:
            new_pool = copy.deepcopy(pool)
            break
    if new_pool:
        new_pool["name"] = pool_name+"-"+vs_name
        avi_pool_list.append(new_pool)
        return new_pool["name"]


def add_ssl_profile_to_pool(avi_pool_list, pool_ref, pool_ssl_profiles, tenant):
    """
    F5 serverside SSL need to be added to pool if VS contains serverside SSL
    profile this method add that profile to pool
    :param avi_pool_list: List of pools to search pool object
    :param pool_ref: name of the pool
    :param pool_ssl_profiles: ssl profiles to be added to pool
    :param tenant: tenant name for default object
    """
    if pool_ssl_profiles == "serverssl":
        pool_ssl_profiles = tenant+":"+"System-Default-Cert"
    for pool in avi_pool_list:
        if pool_ref == pool["name"]:
            pool["ssl_key_and_certificate_ref"] = pool_ssl_profiles
            if not pool.get("ssl_profile_ref", None):
                pool["ssl_profile_ref"] = "admin:System-Standard"


def convert_vs_config(vs_congig, vs_state, tenant, avi_pool_list,
                      profile_config):
    """
    F5 virtual server object conversion to Avi VS object
    :param vs_congig: F5 virtual server config list
    :param vs_state: state of new VS to be created in Avi
    :param tenant: tenant name for default object
    :param avi_pool_list: List of pools to handle shared pool scenario
    :param profile_config: Avi profile config
    referenced in vs
    :return: List of Avi VS configs
    """
    vs_list = []
    for vs_name in vs_congig.keys():
        f5_vs = vs_congig[vs_name]
        enabled = (vs_state == 'enable')
        client_ssl_profiles = get_ssl_profile(f5_vs.get("profiles", None),
                                              "clientside", profile_config["ssl_key_cert_list"])
        enable_ssl = False
        if client_ssl_profiles:
            enable_ssl = True
        parts = f5_vs["destination"].split(':')
        ip_addr = parts[0]
        port = parts[1] if len(parts) == 2 else 80
        if int(port) > 0:
            services_obj = [{'port': port, 'enable_ssl': enable_ssl}]
        else:
            services_obj = [{'port': 1, 'port_range_end': 65535,
                             'enable_ssl': enable_ssl}]

        pool_ref = f5_vs.get("pool", None)
        if pool_ref and is_pool_shared(pool_ref, vs_list):
            pool_ref = clone_pool(pool_ref, vs_name, avi_pool_list)

        pool_ssl_profiles = get_ssl_profile(f5_vs.get("profiles", None),
                                            "serverside", profile_config["ssl_key_cert_list"])
        if pool_ref and pool_ssl_profiles:
            add_ssl_profile_to_pool(avi_pool_list, pool_ref,
                                    pool_ssl_profiles[0], tenant)

        vs_obj = {
            'name': vs_name,
            'type': 'VS_TYPE_NORMAL',
            'ip_address': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'enabled': enabled,
            'services': services_obj,
            'ssl_profile_name': 'System-Standard',
            'application_profile_name': 'System-HTTP',
            'pool_ref': pool_ref
        }
        if enable_ssl:
            default_cert = tenant+":"+"System-Default-Cert"
            client_ssl_profiles = [word.replace('clientssl', default_cert)
                                   for word in client_ssl_profiles]
            vs_obj['application_profile_name'] = 'System-Secure-HTTP'
            vs_obj['ssl_key_and_certificate_refs'] = client_ssl_profiles

        vs_list.append(vs_obj)
        del vs_congig[vs_name]
    return vs_list


def get_defaults(type, f5_monitor, monitor_config):
    """
    Monitor can have inheritance used by attribute defaults-from in F5
    configuration this method recursively gets all the attributes from the
    default objects and forms complete object
    :param type: Monitor type
    :param f5_monitor: F5 monitor object
    :param monitor_config: List of F5 monitor configs
    :return:
    """
    parent_name = f5_monitor.get("defaults-from", None)
    if parent_name:
        parent_monitor = monitor_config.get(type+" "+parent_name, None)
        if parent_monitor:
            parent_monitor = get_defaults(type, parent_monitor, monitor_config)
            parent_monitor = copy.deepcopy(parent_monitor)
            parent_monitor.update(f5_monitor)
            f5_monitor = parent_monitor
    return f5_monitor


def convert_monitor_entity(type, name, f5_monitor):
    """
    Conversion of single F5 monitor object to Avi health monitor object
    :param type: Health monitor type
    :param name: name of health monitor
    :param f5_monitor: F5 monitor config object
    :return: Avi monitor config object
    """
    timeout = int(f5_monitor.get("timeout", 16))
    interval = int(f5_monitor.get("interval", 5))
    time_until_up = int(f5_monitor.get("time-until-up", 1))
    successful_checks = int(timeout/interval)
    if time_until_up > 0:
        failed_checks = int(time_until_up/interval)
    else:
        failed_checks = 1
    description = f5_monitor.get("description", None)
    monitor_dict = dict()
    monitor_dict["name"] = name
    monitor_dict["receive_timeout"] = interval-1
    monitor_dict["failed_checks"] = failed_checks
    monitor_dict["send_interval"] = interval
    monitor_dict["successful_checks"] = successful_checks
    if description:
        monitor_dict["description"] = description

    if type == "http":
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": "HEAD / HTTP/1.0",
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
    elif type == "https":
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": "HEAD / HTTP/1.0",
            "http_response_code": [
            {"code": "HTTP_2XX"},{"code": "HTTP_3XX"}
            ]}
    elif type == "dns":
        accept_rcode = f5_monitor.get("accept-rcode", None)
        if accept_rcode and accept_rcode == "no-error":
            rcode = "RCODE_NO_ERROR"
        else:
            rcode = "RCODE_ANYTHING"
        monitor_dict["type"] = "HEALTH_MONITOR_DNS"
        dns_monitor = {"rcode": rcode}
        dns_monitor["query_name"] = f5_monitor.get("qname", None)
        dns_monitor["qtype"] = "DNS_QUERY_TYPE"
        monitor_dict["dns_monitor"] = dns_monitor
    elif type == "tcp":
        destination = f5_monitor.get("destination", "*:*")
        str = destination.split(":")
        if len(str) > 1 and isinstance(str[1], numbers.Integral):
            monitor_dict["monitor_port"] = str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_TCP"
        request = f5_monitor.get("send", None)
        response = f5_monitor.get("recv", None)
        if request or response:
            tcp_monitor = {"tcp_request": request, "tcp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
    elif type == "udp":
        destination = f5_monitor.get("destination", "*:*")
        str = destination.split(":")
        if len(str) > 1 and isinstance(str[1], numbers.Integral):
            monitor_dict["monitor_port"] = str[1]
        monitor_dict["type"]="HEALTH_MONITOR_UDP"
        request = f5_monitor.get("send", None)
        response = f5_monitor.get("recv", None)
        if request or response:
            tcp_monitor = {"udp_request": request, "udp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
    elif type in ["gateway-icmp", "icmp"]:
        monitor_dict["type"]="HEALTH_MONITOR_PING"
    elif type == "external":
        monitor_dict["type"]="HEALTH_MONITOR_EXTERNAL"
        ext_monitor = {
            "command_code": f5_monitor.get("run", None),
            "command_parameters": f5_monitor.get("args", None),
            "command_variables": f5_monitor.get("user-defined", None)
        }
        monitor_dict["external_monitor"] = ext_monitor
    return monitor_dict


def convert_monitor_config(monitor_config):
    """
    Convert F5 monitor config dict to Avi health monitor config list
    :param monitor_config: F5 monitor config dict
    :return: List of Avi health monitor objects
    """
    monitor_list = []
    supported_types = ["http", "https", "dns", "external", "tcp", "udp",
                       "gateway-icmp", "icmp"]
    for key in monitor_config.keys():
        type, name = key.split(" ")
        if type not in supported_types:
            LOG.debug("Monitor type not supported by Avi : "+name)
            continue
        f5_monitor = monitor_config[key]
        if not f5_monitor:
            continue
        f5_monitor = get_defaults(type, f5_monitor, monitor_config)
        avi_monitor = convert_monitor_entity(type, name, f5_monitor)
        monitor_list.append(avi_monitor)
        del monitor_config[key]
    return monitor_list


def get_key_cert_obj(name, key_file_name, cert_file_name, folder_path, option):
    """
    Read key and cert files from given location and construct avi
    SSLKeyAndCertificate objects
    :param name: SSLKeyAndCertificate object name
    :param key_file_name: key file name
    :param cert_file_name: cert file name
    :param folder_path: location of key and cert files
    :param option: api-upload or cli-file both requires different
    object structure
    :return:SSLKeyAndCertificate object
    """
    print option
    key = None
    cert = None
    folder_path = folder_path+os.path.sep
    try:
        key_file = open(folder_path+key_file_name, "r")
        key = key_file.read()
    except:
        LOG.error("Error to read file" + folder_path+key_file_name)
    try:
        cert_file = open(folder_path+cert_file_name, "r")
        cert = cert_file.read()
    except:
        LOG.error("Error to read file" + folder_path+cert_file_name)
    ssl_kc_obj = None
    if key and cert:
        if option == "cli-upload":
            cert = {"certificate": cert}
        ssl_kc_obj = {
                'name': name,
                'key': key,
                'certificate': cert,
                'key_passphrase': ''
            }
    return ssl_kc_obj


def update_with_default_profile(type, profile, profile_config):
    """
    Profiles can have inheritance used by attribute defaults-from in F5
    configuration this method recursively gets all the attributes from the
    default objects and forms complete object
    :param type: type of profile
    :param profile: currant profile object
    :param profile_config: F5 profile config dict
    :return: Complete profile with updated attributes from defaults
    """
    parent_name = profile.get("defaults-from", None)
    if parent_name:
        parent_profile = profile_config.get(type+" "+parent_name, None)
        if parent_profile:
            parent_profile = get_defaults(type, parent_profile, profile_config)
            parent_profile = copy.deepcopy(parent_profile)
            parent_profile.update(profile)
            profile = parent_profile
    return profile


def convert_profile_config(profile_config, certs_location, option):
    ssl_key_cert_list = []
    app_profile_list = []
    ssl_profile_list = []
    pki_profile_list = []
    network_profile_list = []
    for key in profile_config.keys():
        type, name = key.split(" ")
        if type in ("client-ssl", "server-ssl"):
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            cert_obj = profile.get("cert-key-chain", None)
            key_file = None
            cert_file = None
            key_cert_obj = None
            if cert_obj:
                key_file = cert_obj["default"]["key"]
                cert_file = cert_obj["default"]["cert"]
            elif profile.get("cert", None):
                cert_file = profile["cert"]
                key_file = profile["key"]
            if key_file and cert_file:
                key_cert_obj = get_key_cert_obj(name, key_file, cert_file,
                                    certs_location, option)
            if key_cert_obj:
                ssl_key_cert_list.append(key_cert_obj)
            # try:
            #     ciphers = profile.get('ciphers', 'DEFAULT')
            #     ciphers = 'AES:3DES:RC4' if ciphers == 'DEFAULT' else ciphers
            #     cmd = "openssl ciphers '%s'" % ciphers
            #     print cmd
            #     output = subprocess.check_output(shlex.split(cmd))
            #     if not output:
            #         valid = False
            # except subprocess.CalledProcessError:
            #     LOG.error('err')
            ciphers = profile.get('ciphers', 'DEFAULT')
            ciphers = 'AES:3DES:RC4' if ciphers == 'DEFAULT' else ciphers
            valid = True
            if valid:
                ssl_profile = dict()
                ssl_profile['name'] = name
                ssl_profile['accepted_ciphers'] = ciphers
                close_notify = profile.get('unclean-shutdown', None)
                if close_notify and close_notify == 'enabled':
                    ssl_profile['send_close_notify'] = True
                else:
                    ssl_profile['send_close_notify'] = False
                ssl_profile_list.append(ssl_profile)
                options = profile.get("options", "")
                options = options.keys()+options.values()
                print options
                accepted_versions = []
                if not "no-tls" in options:
                    accepted_versions.append({"type": "SSL_VERSION_TLS1"})
                if not "no-tlsv1.1" in options:
                    accepted_versions.append({"type": "SSL_VERSION_TLS1_1"})
                if not "no-tlsv1.2" in options:
                    accepted_versions.append({"type": "SSL_VERSION_TLS1_2"})
                if accepted_versions:
                    ssl_profile["accepted_versions"] = accepted_versions

            crl_file_name = profile.get('crl-file', None)
            ca_file_name = profile.get('ca-file', None)
            crl_file_name = None if crl_file_name == 'none' else crl_file_name
            ca_file_name = None if ca_file_name == 'none' else ca_file_name
            if not ca_file_name and crl_file_name:
                LOG.warning("Skipped PKI profile for profile %s "
                            "because of missing CA file" % name)
            elif ca_file_name:
                pki_profile = dict()
                file_path = certs_location+os.path.sep+ca_file_name
                pki_profile["name"] = name
                try:
                    ca_file = open(file_path, "r")
                    ca = ca_file.read()
                    pki_profile["ca_certs"] = [{'certificate': ca}]
                except:
                    LOG.error("Error to read file" +
                              certs_location+os.path.sep+crl_file_name)
                if crl_file_name:
                    file_path = certs_location+os.path.sep+crl_file_name
                    try:
                        crl_file = open(file_path, "r")
                        crl = crl_file.read()
                        pki_profile["crls"] =[{'body': crl}]
                    except:
                        LOG.error("Error to read file" +
                                  certs_location+os.path.sep+crl_file_name)
                pki_profile_list.append(pki_profile)
        elif type == 'http':
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            http_profile = dict()
            http_profile['x_forwarded_proto_enabled'] = \
                profile.get('insert-xforwarded-for', False)
            http_profile['xff_alternate_name'] = \
                profile.get('xff-alternative-names', None)
            enforcement = profile.get('enforcement', None)
            if enforcement:
                header_size = enforcement.get('max-header-size', 49152)
                http_profile['client_max_header_size'] = int(header_size)/1024
            app_profile["http_profile"] = http_profile
            app_profile_list.append(app_profile)
        elif type == 'dns':
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_DNS'
            app_profile['description'] = profile.get('description', None)
            app_profile_list.append(app_profile)
        elif type == 'web-acceleration':
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            cache_config = dict()
            cache_config['min_object_size'] = profile.get(
                'cache-object-min-size', 100)
            cache_config['query_cacheable'] = True
            cache_config['max_object_size'] = profile.get(
                'cache-object-max-size', 4194304)
            age_header = profile.get('cache-insert-age-header', 'disabled')
            if age_header == 'enabled':
                cache_config['age_header'] = True
            else:
                cache_config['age_header'] = False
            cache_config['enabled'] = True
            cache_config['default_expire'] = profile.get('cache-max-age', 600)
            max_entities = profile.get('cache-max-entries', 0)
            # cache_config['max_cache_size'] = \
            #     (int(max_entities) * int(cache_config['max_object_size']))
            app_profile_list.append(app_profile)
        elif type == 'web-acceleration':
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            netwk_profile = dict()
            network_profile_list.append(netwk_profile)
        else:
            LOG.warning("Not supported profile type: %s"%type)
            continue
        del profile_config[key]
    avi_profiles = dict()
    avi_profiles["ssl_key_cert_list"] = ssl_key_cert_list
    avi_profiles["app_profile_list"] = app_profile_list
    avi_profiles["ssl_profile_list"] = ssl_profile_list
    avi_profiles["pki_profile_list"] = pki_profile_list
    avi_profiles["network_profile_list"] = network_profile_list
    return avi_profiles


def convert_to_avi_dict(f5_config_dict, output_file_path,
                        vs_state, certs_location, tenant, option):
    avi_config_dict = {}
    monitor_config_list = convert_monitor_config(f5_config_dict.get(
        "monitor", {}))
    avi_config_dict["HealthMonitor"] = monitor_config_list
    LOG.debug("Converted health monitors")
    avi_pool_list = convert_pool_config(f5_config_dict.get("pool", {}),
                                        f5_config_dict.get("node", {}), tenant,
                                        monitor_config_list)
    avi_config_dict["Pool"] = avi_pool_list
    LOG.debug("Converted pools")
    f5_profile_dict = f5_config_dict.get("profile", {})
    avi_profiles = convert_profile_config(f5_profile_dict,
                                                 certs_location, option)
    avi_config_dict["SSLKeyAndCertificate"] = avi_profiles["ssl_key_cert_list"]
    avi_config_dict["SSLProfile"] = avi_profiles["ssl_profile_list"]
    avi_config_dict["PKIProfile"] = avi_profiles["pki_profile_list"]
    avi_config_dict["ApplicationProfile"] = avi_profiles["app_profile_list"]
    avi_config_dict["NetworkProfile"] = avi_profiles["network_profile_list"]
    LOG.debug("Converted ssl profiles")
    avi_vs_list = convert_vs_config(f5_config_dict.get("virtual", {}), vs_state,
                                    tenant, avi_pool_list, avi_profiles)
    avi_config_dict["VirtualService"] = avi_vs_list
    LOG.debug("Converted VS")
    text_file = open(output_file_path+os.path.sep+"skipedConversion.json", "w")
    json.dump(f5_config_dict, text_file, indent=4)
    text_file.close()
    return avi_config_dict
