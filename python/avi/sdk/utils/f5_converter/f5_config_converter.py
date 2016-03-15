import json
import copy
import numbers
import logging
import os

LOG = logging.getLogger("converter-log")


def convert_servers_config(servers_config, nodes):
    server_list = []
    for server_name in servers_config.keys():
        server = servers_config[server_name]
        parts = server_name.split(':')
        ip_addr = nodes[parts[0]]["address"]
        port = parts[1] if len(parts) == 2 else 80
        enabled = True
        if server.has_key("state") and server["state"] == "user-down":
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
    if action == "reset":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    if action == "reselect":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    else:
        return "POOL_DOWN_ACTION_CLOSE_CONN"


def get_monitor_obj(monitor_name, monitor_config_list):
    for monitor in monitor_config_list:
        if monitor["name"] == monitor_name:
            return monitor
    return None


def convert_pool_config(pool_config, nodes, tenant, monitor_config_list):
    pool_list = []
    for pool_name in pool_config.keys():
        f5_pool = pool_config[pool_name]
        if not f5_pool:
            LOG.debug("Empty pool skiped for conversion :"+pool_name)
            continue
        servers = None
        pd_action = None
        servers = convert_servers_config(f5_pool.get("members", {}), nodes)
        pd_action = get_avi_pool_down_action(f5_pool.get(
            "service-down-action", ""))
        pool_obj = {
                "name": pool_name,
                "servers": servers,
                "pd_action_type": pd_action
            }
        monitor_names = f5_pool.get("monitor", None)
        default_monitors = {"http":"System-HTTP", "https":"System-HTTPS",
                            "dns":"System-DNS", "tcp":"System-TCP",
                            "udp":"System-UDP","gateway_icmp":"System-Ping",
                            "icmp":"System-Ping"}
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
                                %(monitor,pool_name))
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
    for vs in vs_list:
        if vs["pool_ref"] == pool_ref:
            return True
    return False


def clone_pool(pool_name, vs_name, avi_pool_list):
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
    if pool_ssl_profiles == "serverssl":
        pool_ssl_profiles = tenant+":"+"System-Default-Cert"
    for pool in avi_pool_list:
        if pool_ref == pool["name"]:
            pool["ssl_key_and_certificate_ref"] = pool_ssl_profiles
            if not pool.get("ssl_profile_ref",None):
                pool["ssl_profile_ref"] = "admin:System-Standard"


def convert_vs_config(vs_congig, vs_state, tenant, avi_pool_list,
                      profile_config_list):
    vs_list = []
    for vs_name in vs_congig.keys():
        f5_vs = vs_congig[vs_name]
        enabled = (vs_state == 'enable')
        client_ssl_profiles = get_ssl_profile(f5_vs.get("profiles", None),
                                              "clientside", profile_config_list)
        enable_ssl = False
        if client_ssl_profiles:
            enable_ssl = True
        parts = f5_vs["destination"].split(':')
        ip_addr = parts[0]
        port = parts[1] if len(parts) == 2 else 80
        if int(port) > 0:
            services_obj = [{'port': port, 'enable_ssl': enable_ssl}]
        else:
            services_obj = [{'port': 1, 'port_range_end' : 65535,
                             'enable_ssl': enable_ssl}]


        pool_ref = f5_vs.get("pool", None)
        if pool_ref and is_pool_shared(pool_ref, vs_list):
            pool_ref = clone_pool(pool_ref, vs_name, avi_pool_list)

        pool_ssl_profiles = get_ssl_profile(f5_vs.get("profiles", None),
                                      "serverside", profile_config_list)
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
            for ssl_profile_name in client_ssl_profiles:
                if ssl_profile_name == "clientssl":
                    ssl_profile_name = tenant+":"+"System-Default-Cert"
            vs_obj['application_profile_name'] = 'System-Secure-HTTP'
            vs_obj['ssl_key_and_certificate_refs'] = client_ssl_profiles

        vs_list.append(vs_obj)
        del vs_congig[vs_name]
    return vs_list


def get_defaults(type, f5_monitor, monitor_config):
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
    timeout = int(f5_monitor.get("timeout", 16))
    interval = int(f5_monitor.get("interval", 5))
    time_until_up = int(f5_monitor.get("time-until-up", 1))
    successful_checks = int(timeout/interval)
    if time_until_up > 0:
        failed_checks = int(time_until_up/interval)
    else:
        failed_checks = 1
    description = f5_monitor.get("description", None)
    monitor_dict = {"name": name}
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
        monitor_dict["type"]="HEALTH_MONITOR_TCP"
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
            cert = {"certificate":cert}
        ssl_kc_obj = {
                'name': name,
                'key': key,
                'certificate': cert,
                'key_passphrase': ''
            }
    return ssl_kc_obj


def update_with_default_profile(type, profile, profile_config):
    parent_name = profile.get("defaults-from", None)
    if parent_name:
        parent_profile = profile_config.get(type+" "+parent_name, None)
        if parent_profile:
            parent_profile = get_defaults(type, parent_profile, profile_config)
            parent_monitor = copy.deepcopy(parent_profile)
            parent_monitor.update(profile)
            profile = parent_monitor
    return profile


def convert_profile_config(profile_config, certs_location, option):
    ssl_key_cert_list = []
    for key in profile_config.keys():
        type, name = key.split(" ")
        if type in ("client-ssl", "server-ssl"):
            profile = profile_config[key]
            profile = update_with_default_profile(type, profile, profile_config)
            cert_obj = profile.get("cert-key-chain", None)
            if cert_obj:
                key_file = cert_obj["default"]["key"]
                cert_file = cert_obj["default"]["cert"]
            elif profile.get("cert", None):
                cert_file = profile["cert"]
                key_file = profile["key"]
            else:
                continue
        else:
            continue
        key_cert_obj = get_key_cert_obj(name, key_file, cert_file,
                                        certs_location, option)
        if key_cert_obj:
            ssl_key_cert_list.append(key_cert_obj)
            del profile_config[key]
    return ssl_key_cert_list


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
    profile_config_list = convert_profile_config(f5_profile_dict,
                                                 certs_location, option)
    avi_config_dict["SSLKeyAndCertificate"] = profile_config_list
    LOG.debug("Converted ssl profiles")
    avi_vs_list = convert_vs_config(f5_config_dict.get("virtual", {}), vs_state,
                                    tenant, avi_pool_list, profile_config_list)
    avi_config_dict["VirtualService"] = avi_vs_list
    LOG.debug("Converted VS")
    text_file = open(output_file_path+os.path.sep+"skipedConversion.json", "w")
    json.dump(f5_config_dict, text_file, indent=4)
    text_file.close()
    return avi_config_dict
