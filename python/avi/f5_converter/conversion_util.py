import copy
import csv
import logging

import converter_constants as final

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
    except UnicodeDecodeError as ude:
        try:
            file_str = file_str.decode('latin-1')
        except:
            LOG.error("Error to read file %s" % file_path, exc_info=True)
    except:
        LOG.error("Error to read file %s" % file_path, exc_info=True)
    return file_str


def update_skipped_attributes(skipped, indirect_list, ignore_dict, object):
    indirect_mappings = [attr for attr in indirect_list if attr in skipped]
    skipped = [attr for attr in skipped if attr not in indirect_list]
    for key in ignore_dict.keys():
        if key in object and key in skipped and object[key] == ignore_dict[key]:
            skipped.remove(key)
    return skipped, indirect_mappings


def remove_dup_key(obj_list):
    for obj in obj_list:
        obj.pop('dup_of', None)


def check_for_duplicates(src_obj, obj_list):
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
    avi_algo_val = "CC_ALGO_NEW_RENO"
    if cc_algo == "high-speed":
        avi_algo_val = "CC_ALGO_HTCP"
    elif cc_algo == "cubic":
        avi_algo_val = "CC_ALGO_CUBIC"
    return avi_algo_val


def add_status_row(f5_type, f5_sub_type, f5_id, status, skipped_params=None,
                   avi_object=None, indirect_params=None):
    """
    Adds as status row in conversion status csv
    :param f5_type: Object type
    :param f5_sub_type: Object sub type
    :param f5_id: Name of object
    :param status: conversion status
    :param skipped_params: skipped params if partial conversion
    :param indirect_params: List of attributes have indirect mappings
    :param avi_object: converted avi object
    """
    global csv_writer
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type,
        'F5 ID': f5_id,
        'Status': status,
        'Indirect mapping': indirect_params,
        'Skipped settings': str(skipped_params),
        'Avi Object': str(avi_object)
    }
    csv_writer.writerow(row)


def get_port_by_protocol(protocol):
    """
    Instead of default ports for protocols F5 config has protocol in
    destination value for Avi object need to conver it to port number
    :param protocol: protocol name
    :return: integer value for protocol
    """
    port = final.DEFAULT_PORT
    if protocol == "https":
        port = final.HTTPS_PORT
    elif protocol == "ftp":
        port = final.FTP_PORT
    elif protocol == "smtp":
        port = final.SMTP_PORT
    elif protocol == "snmp":
        port = final.SNMP_PORT
    elif protocol == "telnet":
        port = final.TELNET_PORT
    elif protocol == "snmp-trap":
        port = final.SNMP_TRAP_PORT
    elif protocol == "ssh":
        port = final.SSH_PORT
    return port


def add_csv_headers(csv_file):
    global csv_writer
    fieldnames = ['F5 type', 'F5 SubType', 'F5 ID', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Avi Object']
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames,
                                lineterminator='\n',)
    csv_writer.writeheader()


def update_skip_duplicates(obj, obj_list, obj_type, converted_objs):
    dup_of = check_for_duplicates(obj, obj_list)
    if dup_of:
        converted_objs.append({obj_type: "Duplicate of %s" % dup_of})
        LOG.info("Duplicate profiles: %s merged in %s" % (obj['name'], dup_of))
    else:
        obj_list.append(obj)
        converted_objs.append({obj_type: obj})


def get_containt_string_group(name, content_types):
    sg_obj = {"name": name+"-content_type", "type": "SG_TYPE_STRING"}
    kv = []
    for content_type in content_types:
        uri = {"key": content_type}
        kv.append(uri)
    sg_obj["kv"] = kv
    return sg_obj


def get_profiles_for_vs(profiles, avi_config):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param profile_config: avi profile config
    :return: returns list of profile refs assigned to VS in avi config
    """
    vs_ssl_profile_names = []
    pool_ssl_profile_names = []
    app_profile_names = []
    network_profile_names = []
    if not profiles:
        return []
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for name in profiles.keys():
        ssl_profile_list = avi_config.get("SSLProfile", [])
        ssl_profiles = [obj for obj in ssl_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if ssl_profiles:
            ssl_key_cert_list = avi_config.get("SSLKeyAndCertificate", [])
            key_cert = [obj for obj in ssl_key_cert_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
            key_cert = key_cert[0]['name'] if key_cert else None
            profile = profiles.get(name, None)
            context = profile.get("context", None)
            pki_list = avi_config.get("PKIProfile", [])
            pki_profiles = [obj for obj in pki_list if (obj['name'] == name or
                                                name in obj.get("dup_of", []))]
            pki_profile = pki_profiles[0]['name'] if pki_profiles else None
            if context == "clientside":
                vs_ssl_profile_names.append({"profile": ssl_profiles[0]["name"],
                                             "cert": key_cert,
                                             "pki": pki_profile})
            elif context == "serverside":
                pool_ssl_profile_names.append(
                    {"profile": ssl_profiles[0]["name"], "cert": key_cert,
                     "pki": pki_profile})
        app_profile_list = avi_config.get("ApplicationProfile", [])
        app_profiles = [obj for obj in app_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if app_profiles:
            app_profile_names.append(app_profiles[0]['name'])
        ntwk_prof_lst = avi_config.get("NetworkProfile")
        network_profiles = [obj for obj in ntwk_prof_lst if (
            obj['name'] == name or name in obj.get("dup_of", []))]
        if network_profiles:
            network_profile_names.append(network_profiles[0]['name'])
    if not app_profile_names:
        app_profile_names.append("http")
    return vs_ssl_profile_names, pool_ssl_profile_names, \
           app_profile_names, network_profile_names


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
            if port not in [final.PORT_START, final.PORT_END]:
                new_end = service['port_range_end']
                service['port_range_end'] = int(port)-1
                new_service = {'port': int(port)+1,
                               'port_range_end': new_end,
                               'enable_ssl': enable_ssl}
                vs['services'].append(new_service)
            elif port == final.PORT_START:
                service['port'] = 2
            elif port == final.PORT_END:
                service['port_range_end'] = (final.PORT_START - 1)
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
    port = parts[1] if len(parts) == 2 else final.DEFAULT_PORT
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
            if final.PORT_END not in used_ports:
                used_ports.append(final.PORT_END+1)
            used_ports = sorted(used_ports, key=int)
            start = final.PORT_START
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
            services_obj = [{'port': 1, 'port_range_end': final.PORT_END,
                             'enable_ssl': enable_ssl}]
    return services_obj, ip_addr


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