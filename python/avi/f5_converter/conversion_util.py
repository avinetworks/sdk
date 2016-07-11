import copy
import csv
import logging

import converter_constants as conv_const

LOG = logging.getLogger(__name__)
csv_writer = None


def upload_file(file_path):
    """
    Reads the given file and returns the UTF-8 string
    :param file_path: Path of file to read
    :return: UTF-8 string read from file
    """
    file_str = None
    try:
        with open(file_path, "r") as file_obj:
            file_str = file_obj.read()
            file_str = file_str.decode("utf-8")
    except UnicodeDecodeError:
        try:
            file_str = file_str.decode('latin-1')
        except:
            LOG.error("Error to read file %s" % file_path, exc_info=True)
    except:
        LOG.error("Error to read file %s" % file_path, exc_info=True)
    return file_str


def get_conv_status(skipped, indirect_list, ignore_dict, f5_object,
                    user_ignore=None, na_list=None):
    """
    Update skipped list for conversion status
    :param skipped: All skipped attributes after conversion
    :param indirect_list: List of attrs to be mapped as indirect mapping
    :param ignore_dict: Dict of default values for column skipped for defaults
    :param f5_object: Currant F5 object
    :param user_ignore: List of attributes user wants not to be shown in skipped
    :param na_list: List of attributes marked as not applicable
    :return: Conversion status dict
    """
    conv_status = dict()
    user_ignore = [] if not user_ignore else user_ignore
    na_list = [] if not na_list else na_list

    conv_status['user_ignore'] = [val for val in skipped if val in user_ignore]
    skipped = [attr for attr in skipped if attr not in user_ignore]

    conv_status['indirect'] = [val for val in skipped if val in indirect_list]
    skipped = [attr for attr in skipped if attr not in indirect_list]

    conv_status['na_list'] = [val for val in skipped if val in na_list]
    skipped = [attr for attr in skipped if attr not in na_list]

    default_skip = []
    for key in ignore_dict.keys():
        f5_val = f5_object.get(key)
        default_val = ignore_dict.get(key)
        if key in skipped and f5_val == default_val:
            default_skip.append(key)
    if default_skip:
        skipped = [attr for attr in skipped if attr not in default_skip]

    conv_status['skipped'] = skipped
    conv_status['default_skip'] = default_skip
    if skipped:
        status = 'partial'
    else:
        status = 'successful'
    conv_status['status'] = status
    return conv_status


def remove_dup_key(obj_list):
    for obj in obj_list:
        obj.pop('dup_of', None)


def check_for_duplicates(src_obj, obj_list):
    """
    Checks for duplicate objects except name and description values
    :param src_obj: Object to be checked for duplicate
    :param obj_list: List of oll objects to search in
    :return: Name of object for which given object is duplicate of
    """
    for tmp_obj in obj_list:
        src_cp = copy.deepcopy(src_obj)
        tmp_cp = copy.deepcopy(tmp_obj)
        del src_cp["name"]
        if "description" in src_cp:
            del src_cp["description"]
        del tmp_cp["name"]
        if "description" in tmp_cp:
            del tmp_cp["description"]
        dup_lst = tmp_cp.pop("dup_of", [])
        if cmp(src_cp, tmp_cp) == 0:
            dup_lst.append(src_obj["name"])
            tmp_obj["dup_of"] = dup_lst
            return tmp_obj["name"]
    return None


def get_avi_pool_down_action(action):
    """
    Maps Pool down action from F5 config to Avi Config
    :param action: F5 action string
    :return: Avi action String
    """
    action_close_con = {
        "type": "FAIL_ACTION_CLOSE_CONN"
    }
    if action == "reset":
        return action_close_con
    if action == "reselect":
        return action_close_con
    else:
        return action_close_con


def get_cc_algo_val(cc_algo):
    """
    congestion-control algorithm conversion
    :param cc_algo: F5 algorithm value
    :return: Avi algorithm value
    """
    avi_algo_val = "CC_ALGO_NEW_RENO"
    if cc_algo == "high-speed":
        avi_algo_val = "CC_ALGO_HTCP"
    elif cc_algo == "cubic":
        avi_algo_val = "CC_ALGO_CUBIC"
    return avi_algo_val


def add_conv_status(f5_type, f5_sub_type, f5_id, conv_status, avi_object=None):
    """
    Adds as status row in conversion status csv
    :param f5_type: Object type
    :param f5_sub_type: Object sub type
    :param f5_id: Name oconv_f object
    :param conv_status: dict of conversion status
    :param avi_object: Converted objectconverted avi object
    """
    global csv_writer
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type,
        'F5 ID': f5_id,
        'Status': conv_status.get('status', ''),
        'Skipped settings': str(conv_status.get('skipped', '')),
        'Skipped for defaults': str(conv_status.get('default_skip', '')),
        'Indirect mapping': str(conv_status.get('indirect', '')),
        'Not Applicable': str(conv_status.get('na_list', '')),
        'User Ignored': str(conv_status.get('user_ignore', '')),
        'Avi Object': str(avi_object)
    }
    csv_writer.writerow(row)


def add_status_row(f5_type, f5_sub_type, f5_id, status):
    """
    Adds as status row in conversion status csv
    :param f5_type: Object type
    :param f5_sub_type: Object sub type
    :param f5_id: Name of object
    :param status: conversion status
    """
    global csv_writer
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type,
        'F5 ID': f5_id,
        'Status': status,
    }
    csv_writer.writerow(row)


def add_csv_headers(csv_file):
    """
    Adds header line in conversion status file
    :param csv_file: File to which header is to be added
    """
    global csv_writer
    fieldnames = ['F5 type', 'F5 SubType', 'F5 ID', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Not Applicable',
                  'User Ignored', 'Skipped for defaults', 'Avi Object']
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames,
                                lineterminator='\n',)
    csv_writer.writeheader()


def get_port_by_protocol(protocol):
    """
    Instead of default ports for protocols F5 config has protocol in
    destination value for Avi object need to conver it to port number
    :param protocol: protocol name
    :return: integer value for protocol
    """
    port = conv_const.DEFAULT_PORT
    if protocol == "https":
        port = conv_const.HTTPS_PORT
    elif protocol == "ftp":
        port = conv_const.FTP_PORT
    elif protocol == "smtp":
        port = conv_const.SMTP_PORT
    elif protocol == "snmp":
        port = conv_const.SNMP_PORT
    elif protocol == "telnet":
        port = conv_const.TELNET_PORT
    elif protocol == "snmp-trap":
        port = conv_const.SNMP_TRAP_PORT
    elif protocol == "ssh":
        port = conv_const.SSH_PORT
    return port


def update_skip_duplicates(obj, obj_list, obj_type, converted_objs):
    """
    Merge duplicate profiles
    :param obj: Source object to find duplicates for
    :param obj_list: List of object to search duplicates in
    :param obj_type: Type of object to add in converted_objs status
    :param converted_objs: Converted avi object or merged object name
    :return:
    """
    dup_of = check_for_duplicates(obj, obj_list)
    if dup_of:
        converted_objs.append({obj_type: "Duplicate of %s" % dup_of})
        LOG.info("Duplicate profiles: %s merged in %s" % (obj['name'], dup_of))
    else:
        obj_list.append(obj)
        converted_objs.append({obj_type: obj})


def get_content_string_group(name, content_types, tenant):
    """
    Creates Avi String group object
    :param name: name of string group
    :param content_types: list of content type
    :return:
    """
    sg_obj = {"name": name+"-content_type", "type": "SG_TYPE_STRING"}
    kv = []
    for content_type in content_types:
        uri = {"key": content_type}
        kv.append(uri)
    sg_obj["kv"] = kv
    if tenant:
        sg_obj['tenant_ref'] = tenant
    return sg_obj


def get_vs_ssl_profiles(profiles, avi_config):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :return: returns list of profile refs assigned to VS in avi config
    """
    vs_ssl_profile_names = []
    pool_ssl_profile_names = []
    if not profiles:
        return []
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for key in profiles.keys():
        tenant, name = get_tenant_ref(key)
        ssl_profile_list = avi_config.get("SSLProfile", [])
        ssl_profiles = [obj for obj in ssl_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if ssl_profiles:
            ssl_key_cert_list = avi_config.get("SSLKeyAndCertificate", [])
            key_cert = [obj for obj in ssl_key_cert_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
            key_cert = key_cert[0]['name'] if key_cert else None
            if key_cert and tenant:
               key_cert = '%s:%s' % (tenant, key_cert)
            profile = profiles.get(key, None)
            context = profile.get("context", None)
            pki_list = avi_config.get("PKIProfile", [])
            pki_profiles = [obj for obj in pki_list if (
                obj['name'] == name or name in obj.get("dup_of", []))]
            pki_profile = pki_profiles[0]['name'] if pki_profiles else None
            if pki_profile and tenant:
               pki_profile = '%s:%s' % (tenant, pki_profile)
            if context == "clientside":
                ssl_prof_ref = ssl_profiles[0]["name"]
                if tenant:
                    ssl_prof_ref = '%s:%s' % (tenant, ssl_prof_ref)
                vs_ssl_profile_names.append({"profile": ssl_prof_ref,
                                             "cert": key_cert,
                                             "pki": pki_profile})
            elif context == "serverside":
                ssl_prof_ref = ssl_profiles[0]["name"]
                if tenant:
                    ssl_prof_ref = '%s:%s' % (tenant, ssl_prof_ref)
                pool_ssl_profile_names.append(
                    {"profile": ssl_prof_ref, "cert": key_cert,
                     "pki": pki_profile})
    return vs_ssl_profile_names, pool_ssl_profile_names


def get_vs_app_profiles(profiles, avi_config):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :return: returns list of profile refs assigned to VS in avi config
    """
    app_profile_names = []
    policy_set = []
    f_host = None
    realm = None

    if not profiles:
        return []
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for name in profiles.keys():
        tenant, name = get_tenant_ref(name)
        app_profile_list = avi_config.get("ApplicationProfile", [])
        app_profiles = [obj for obj in app_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if app_profiles:
            if tenant:
                app_prof_name = '%s:%s' % (tenant, app_profiles[0]['name'])
            else:
                app_prof_name = app_profiles[0]['name']
            app_profile_names.append(app_prof_name)
            if app_profiles[0].get('HTTPPolicySet', None):
                policy_name = app_profiles[0].pop('HTTPPolicySet')
                policy_set.append({"index": 12,
                                   "http_policy_set_ref":  policy_name})
            if app_profiles[0].get('fallback_host', None):
                f_host = app_profiles[0].pop('fallback_host')
            if app_profiles[0].get('realm', None):
                realm = {
                    "type": "HTTP_BASIC_AUTH",
                    "auth_profile_ref": "System-Default-Auth-Profile",
                    "realm": app_profiles[0].pop('realm')
                }
    if not app_profile_names:
        app_profile_names.append("http")
    return app_profile_names, f_host, realm,  policy_set


def get_vs_ntwk_profiles(profiles, avi_config):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :return: returns list of profile refs assigned to VS in avi config
    """
    network_profile_names = []
    if not profiles:
        return []
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for name in profiles.keys():
        tenant, name = get_tenant_ref(name)
        ntwk_prof_lst = avi_config.get("NetworkProfile")
        network_profiles = [obj for obj in ntwk_prof_lst if (
            obj['name'] == name or name in obj.get("dup_of", []))]
        if network_profiles:
            if tenant:
                network_profile_ref = '%s:%s' % (
                    tenant, network_profiles[0]['name'])
            else:
                network_profile_ref = network_profiles[0]['name']
            network_profile_names.append(network_profiles[0]['name'])
    return network_profile_names


def update_service(port, vs, enable_ssl):
    """
    iterates over services of existing vs in converted list to update
    services for port overlapping scenario
    :param port: port for currant VS
    :param vs: VS from converted config list
    :param enable_ssl: value to put in service object
    :return: boolean if service is updated or not
    """
    service_updated = False
    for service in vs['services']:
        port_end = service.get('port_range_end', None)
        if port_end and (service['port'] <= int(port) <= port_end):
            if port not in [conv_const.PORT_START, conv_const.PORT_END]:
                new_end = service['port_range_end']
                service['port_range_end'] = int(port)-1
                new_service = {'port': int(port)+1,
                               'port_range_end': new_end,
                               'enable_ssl': enable_ssl}
                vs['services'].append(new_service)
            elif port == conv_const.PORT_START:
                service['port'] = 2
            elif port == conv_const.PORT_END:
                service['port_range_end'] = (conv_const.PORT_START - 1)
            service_updated = True
            break
    return service_updated


def get_service_obj(destination, vs_list, enable_ssl):
    """
    Checks port overlapping scenario for port value 0 in F5 config
    :param destination: IP and Port destination of VS
    :param vs_list: List of existing vs converted to avi config
    :param enable_ssl: value to put in service objects
    :return: List of services for VS
    """
    parts = destination.split(':')
    ip_addr = parts[0]
    port = parts[1] if len(parts) == 2 else conv_const.DEFAULT_PORT
    vs_dup_ips = [vs for vs in vs_list if vs['ip_address']['addr'] == ip_addr]

    if port == 'any':
        port = 0
    if isinstance(port, str) and (not port.isdigit()):
        port = get_port_by_protocol(port)

    if int(port) > 0:
        for vs in vs_dup_ips:
            service_updated = update_service(port, vs, enable_ssl)
            if service_updated:
                break
        services_obj = [{'port': port, 'enable_ssl': enable_ssl}]
    else:
        used_ports = []
        for vs in vs_dup_ips:
            for service in vs['services']:
                used_ports.append(service['port'])
        if used_ports:
            services_obj = []
            if conv_const.PORT_END not in used_ports:
                used_ports.append(conv_const.PORT_END + 1)
            used_ports = sorted(used_ports, key=int)
            start = conv_const.PORT_START
            for i in range(len(used_ports)):
                if start == used_ports[i]:
                    start += 1
                    continue
                end = int(used_ports[i])-1
                services_obj.append({'port': start,
                                     'port_range_end': end,
                                     'enable_ssl': enable_ssl})
                start = int(used_ports[i])+1
        else:
            services_obj = [{'port': 1, 'port_range_end': conv_const.PORT_END,
                             'enable_ssl': enable_ssl}]
    return services_obj, ip_addr


def clone_pool(pool_name, vs_name, avi_pool_list, tenant=None):
    """
    If pool is shared with other VS pool is cloned for other VS as Avi dose not
    support shared pools with new pool name as <pool_name>-<vs_name>
    :param pool_name: Name of the pool to be cloned
    :param vs_name: Name of the VS for pool to be cloned
    :param avi_pool_list: new pool to be added to this list
    :param tenant: if pool is shared across partition then coned for tenant
    :return: new pool object
    """
    new_pool = None
    for pool in avi_pool_list:
        if pool["name"] == pool_name:
            new_pool = copy.deepcopy(pool)
            break
    if new_pool:
        new_pool["name"] = pool_name+"-"+vs_name
        if tenant:
            new_pool["tenant_ref"] = tenant
        # removing config added from VS config to pool
        new_pool["application_persistence_profile_ref"] = None
        new_pool["ssl_profile_ref"] = None
        new_pool["ssl_key_and_certificate_ref"] = None
        new_pool["pki_profile_ref"] = None
        avi_pool_list.append(new_pool)
        return new_pool["name"]


def add_ssl_to_pool(avi_pool_list, pool_ref, pool_ssl_profiles):
    """
    F5 serverside SSL need to be added to pool if VS contains serverside SSL
    profile this method add that profile to pool
    :param avi_pool_list: List of pools to search pool object
    :param pool_ref: name of the pool
    :param pool_ssl_profiles: ssl profiles to be added to pool
    """
    for pool in avi_pool_list:
        if pool_ref == pool["name"]:
            if pool_ssl_profiles["profile"]:
                pool["ssl_profile_ref"] = pool_ssl_profiles["profile"]
            if pool_ssl_profiles["pki"]:
                pool["pki_profile_ref"] = pool_ssl_profiles["pki"]
            if pool_ssl_profiles["cert"]:
                pool["ssl_key_and_certificate_ref"] = pool_ssl_profiles["cert"]


def update_pool_for_persist(avi_pool_list, pool_ref, persist_profile,
                            hash_profiles, persist_config):
    """
    Updates pool for persistence profile assigned in F5 VS config
    :param avi_pool_list: List of all converted pool objects to avi config
    :param pool_ref: pool name to be updated
    :param persist_profile: persistence profile to be added to pool
    :param hash_profiles: list of profile name for which pool's lb algorithm
    updated to hash
    :param persist_config: list of all converted persistence profiles
    :return: Boolean of is pool updated successfully
    """
    pool_updated = True
    pool_obj = [pool for pool in avi_pool_list if pool["name"] == pool_ref]
    if not pool_obj:
        LOG.error("Pool %s not found to add profile %s" %
                  (pool_ref, persist_profile))
        return False
    pool_obj = pool_obj[0]
    persist_profile_obj = [obj for obj in persist_config
                           if obj["name"] == persist_profile]
    persist_ref_key = "application_persistence_profile_ref"
    if persist_profile_obj:
        pool_obj[persist_ref_key] = persist_profile
    elif persist_profile == "hash" or persist_profile in hash_profiles:
        del pool_obj["lb_algorithm"]
        hash_algorithm = "LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS"
        pool_obj["lb_algorithm_hash"] = hash_algorithm
    else:
        pool_updated = False
    return pool_updated


def update_pool_for_fallback(host, avi_pool_list, pool_ref):
    """
    Update pool for fallback host config
    :param host: Redirect url
    :param avi_pool_list: List of all converted pools
    :param pool_ref: Name of the pool for which config is to be added
    """
    pool_obj = [pool for pool in avi_pool_list if pool["name"] == pool_ref]
    if pool_obj:
        pool_obj = pool_obj[0]
        fail_action = {
            "redirect":
            {
              "status_code": "HTTP_REDIRECT_STATUS_CODE_302",
              "host": host,
              "protocol": "HTTPS"
            },
            "type": "FAIL_ACTION_HTTP_REDIRECT"
        }
        pool_obj["fail_action"] = fail_action


def get_snat_list_for_vs(snat_pool):
    """
    Converts the f5 snat pool config object to Avi snat list
    :param snat_pool: f5 snat pool config
    :return: Avi snat list
    """
    snat_list = []
    members = snat_pool.get("members")
    ips = members.keys()+members.values()
    if None in ips:
        ips.remove(None)
    for ip in ips:
        snat_obj = {
          "type": "V4",
          "addr": ip
        }
        snat_list.append(snat_obj)
    return snat_list


def cleanup_config(avi_config):
    remove_dup_key(avi_config["SSLKeyAndCertificate"])
    remove_dup_key(avi_config["ApplicationProfile"])
    remove_dup_key(avi_config["NetworkProfile"])
    remove_dup_key(avi_config["SSLProfile"])
    avi_config.pop('hash_algorithm', [])
    for profile in avi_config['ApplicationProfile']:
        profile.pop('HTTPPolicySet', None)
        profile.pop('realm', [])
        profile.pop('fallback_host', [])

def create_hdr_erase_rule(name, hdr_name, rule_index):
    return create_header_rule(name, hdr_name, "HDR_DOES_NOT_EXIST",
                              "HTTP_REPLACE_HDR", "000000", rule_index)


def create_hdr_insert_rule(name, hdr_name, val, rule_index):
    return create_header_rule(name, hdr_name, "HDR_EXISTS", "HTTP_ADD_HDR",
                              val, rule_index)


def create_header_rule(name, hdr_name, match, action, val, rule_index):
    rule = {
        "name": name,
        "index": rule_index,
        "match": {
            "hdrs": [
                {
                    "hdr": hdr_name,
                    "match_criteria": match
                }
            ]
        },
        "hdr_action": [
            {
                "action": action,
                "hdr": {
                    "name": hdr_name,
                    "value": {
                        "val": val
                    }
                }
            }
        ]
    }
    return rule


def add_vrf(avi_config, vrf):
    vrf_name = 'vrf-%s' % vrf
    vrf_list = avi_config['VrfContext']
    vrf_obj = [obj for obj in vrf_list if obj['name'] == vrf_name]
    if not vrf_obj:
        vrf_obj = {
            "name": vrf_name,
            "system_default": False
        }
        vrf_list.append(vrf_obj)


def get_tenant_ref(name):
    tenant = None
    if name.startswith('/'):
        parts = name.split('/', 2)
        tenant = parts[1]
        name = parts[2]
    return tenant, name



