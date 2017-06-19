import copy
import logging
import os
import urlparse
import pandas
import json
import re
import random
import avi.migrationtools.f5_converter.converter_constants as conv_const

from xlsxwriter import Workbook
from openpyxl import load_workbook
from OpenSSL import crypto
from socket import gethostname
from pkg_resources import parse_version

LOG = logging.getLogger(__name__)
csv_writer_dict_list = []
tenants = []


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
        status = conv_const.STATUS_PARTIAL
    else:
        status = conv_const.STATUS_SUCCESSFUL
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
    global csv_writer_dict_list
    # Added space if f5_sub_type None for pivot table
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type if f5_sub_type else ' ',
        'F5 ID': f5_id,
        'Status': conv_status.get('status', ''),
        'Skipped settings': str(conv_status.get('skipped', '')),
        'Skipped for defaults': str(conv_status.get('default_skip', '')),
        'Indirect mapping': str(conv_status.get('indirect', '')),
        'Not Applicable': str(conv_status.get('na_list', '')),
        'User Ignored': str(conv_status.get('user_ignore', '')),
        'Avi Object': str(avi_object)
    }
    csv_writer_dict_list.append(row)


def add_status_row(f5_type, f5_sub_type, f5_id, status):
    """
    Adds as status row in conversion status csv
    :param f5_type: Object type
    :param f5_sub_type: Object sub type
    :param f5_id: Name of object
    :param status: conversion status
    """
    global csv_writer_dict_list
    # Added space if f5_sub_type None for pivot table
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type if f5_sub_type else ' ',
        'F5 ID': f5_id,
        'Status': status,
    }
    csv_writer_dict_list.append(row)


def add_complete_conv_status(output_dir, avi_config, report_name):
    global csv_writer_dict_list
    for status in conv_const.STATUS_LIST:
        status_list = [row for row in csv_writer_dict_list if
                       row['Status'] == status]
        print '%s: %s' % (status, len(status_list))
    vs_per_skipped_setting_for_references(avi_config)
    write_status_report_and_pivot_table_in_xlsx(output_dir, report_name)


def get_port_by_protocol(protocol):
    """
    Instead of default ports for protocols F5 config has protocol in
    destination value for Avi object need to conver it to port number
    :param protocol: protocol name
    :return: integer value for protocol
    """

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
    elif protocol == "xfer":
        port = conv_const.XFER_PORT
    elif protocol == "pcsync-https":
        port = conv_const.PCSYNC_HTTPS_PORT
    elif protocol == "macromedia-fcs":
        port = conv_const.MACROMEDIA_FCS_PORT
    elif protocol == "any":
        port = None
    else:
        return None
    return port


def update_skip_duplicates(obj, obj_list, obj_type, converted_objs, name,
                           default_profile_name):
    """
    Merge duplicate profiles
    :param obj: Source object to find duplicates for
    :param obj_list: List of object to search duplicates in
    :param obj_type: Type of object to add in converted_objs status
    :param converted_objs: Converted avi object or merged object name
    :param name: Name of the object
    :param default_profile_name : Name of root parent default profile
    :return:
    """
    dup_of = None
    # root default profiles are skipped for merging
    if not name == default_profile_name or obj_type == 'ssl_profile':
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
    :param tenant: tenant name to add tenant reference
    :return:
    """
    sg_obj = {"name": name + "-content_type", "type": "SG_TYPE_STRING"}
    kv = []
    for content_type in content_types:
        if content_type is None:
            LOG.warning('%s content_types %s has none', name, content_types)
            continue
        uri = {"key": content_type}
        kv.append(uri)
    sg_obj["kv"] = kv
    sg_obj['tenant_ref'] = tenant
    return sg_obj


def get_vs_ssl_profiles(profiles, avi_config, prefix):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :param prefix: prefix for objects
    :return: returns list of profile refs assigned to VS in avi config
    """
    vs_ssl_profile_names = []
    pool_ssl_profile_names = []
    if not profiles:
        return vs_ssl_profile_names, pool_ssl_profile_names
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for key in profiles.keys():
        tenant, name = get_tenant_ref(key)
        # Added prefix for objects
        if prefix:
            name = prefix + '-' + name
        ssl_profile_list = avi_config.get("SSLProfile", [])
        ssl_profiles = [obj for obj in ssl_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if ssl_profiles:
            ssl_key_cert_list = avi_config.get("SSLKeyAndCertificate", [])
            key_cert = [obj for obj in ssl_key_cert_list if
                        (obj['name'] == name or obj['name'] == name + '-dummy'
                         or name in obj.get("dup_of", []))]
            # key_cert = key_cert[0]['name'] if key_cert else None
            if key_cert:
                key_cert = get_object_ref(
                    key_cert[0]['name'], 'sslkeyandcertificate',
                    tenant=get_name_from_ref(key_cert[0]['tenant_ref']))
            profile = profiles.get(key, None)
            context = profile.get("context", None)
            if (not context) and isinstance(profile, dict):
                if 'serverside' in profile:
                    context = 'serverside'
                elif 'clientside' in profile:
                    context = 'clientside'
            pki_list = avi_config.get("PKIProfile", [])
            pki_profiles = [obj for obj in pki_list if (
                obj['name'] == name or name in obj.get("dup_of", []))]
            pki_profile = pki_profiles[0]['name'] if pki_profiles else None
            mode = 'SSL_CLIENT_CERTIFICATE_NONE'
            if pki_profile:
                mode = pki_profiles[0].pop('mode',
                                           'SSL_CLIENT_CERTIFICATE_NONE')
                pki_profile = get_object_ref(
                    pki_profiles[0]["name"], 'pkiprofile',
                    tenant=get_name_from_ref(pki_profiles[0]['tenant_ref']))
            if context == "clientside":
                ssl_prof_ref = get_object_ref(
                    ssl_profiles[0]["name"], 'sslprofile',
                    tenant=get_name_from_ref(ssl_profiles[0]['tenant_ref']))
                vs_ssl_profile_names.append({"profile": ssl_prof_ref,
                                             "cert": key_cert,
                                             "pki": pki_profile,
                                             'mode': mode})
            elif context == "serverside":
                ssl_prof_ref = get_object_ref(
                    ssl_profiles[0]["name"], 'sslprofile',
                    tenant=get_name_from_ref(ssl_profiles[0]['tenant_ref']))
                pool_ssl_profile_names.append(
                    {"profile": ssl_prof_ref, "cert": key_cert,
                     "pki": pki_profile, 'mode': mode})
    return vs_ssl_profile_names, pool_ssl_profile_names


def get_vs_app_profiles(profiles, avi_config, tenant_ref, prefix, oc_prof):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :param: prefix: prefix for objects
    :return: returns list of profile refs assigned to VS in avi config
    """
    app_profile_refs = []
    policy_set = []
    f_host = None
    realm = None
    app_profile_list = avi_config.get("ApplicationProfile", [])
    unsupported_profiles = avi_config.get('UnsupportedProfiles', [])
    if not profiles:
        profiles = {}
    if isinstance(profiles, str):
        profiles = profiles.replace(" {}", "")
        profiles = {profiles: None}
    for name in profiles.keys():
        # Added prefix for objects
        if prefix:
            name = '%s-%s' % (prefix, name)
        app_profiles = [obj for obj in app_profile_list if
                        (obj['name'] == name or name in obj.get("dup_of", []))]
        if app_profiles:
            app_prof_name = app_profiles[0]['name']
            app_profile_refs.append(get_object_ref(
                app_prof_name, 'applicationprofile',
                tenant=get_name_from_ref(app_profiles[0]['tenant_ref'])))

            if app_profiles[0].get('HTTPPolicySet', None):
                policy_name = app_profiles[0].pop('HTTPPolicySet')
                policy_set_list = avi_config.get('HTTPPolicySet', [])
                policy_set_obj = [p for p in policy_set_list if
                                  p['name'] == policy_name]
                policy_set.append(
                    {
                        "index": 12,
                        "http_policy_set_ref": get_object_ref(
                            policy_name, 'httppolicyset',
                            tenant=get_name_from_ref(
                                policy_set_obj[0]['tenant_ref']))
                    })
            if app_profiles[0].get('fallback_host', None):
                f_host = app_profiles[0].pop('fallback_host')
            # prerequisite user need to create default auth profile
            if app_profiles[0].get('realm', None):
                realm = {
                    "type": "HTTP_BASIC_AUTH",
                    "auth_profile_ref": get_object_ref(
                        'System-Default-Auth-Profile', 'authprofile',
                        tenant=get_name_from_ref(
                            app_profiles[0]['tenant_ref'])),
                    "realm": app_profiles[0].pop('realm')
                }

    if not app_profile_refs:
        not_supported = [key for key in profiles.keys() if
                         key in unsupported_profiles]
        if not_supported:
            LOG.warning('Profiles not supported by Avi : %s' % not_supported)
            return app_profile_refs, f_host, realm, policy_set
        if oc_prof:
            value = 'http'
        else:
            value = 'fastL4'
        # Added prefix for objects
        if prefix:
            value = '%s-%s' % (prefix, value)
        default_app_profile = [obj for obj in app_profile_list if (
            obj['name'] == value or value in obj.get("dup_of", []))]
        tenant = get_name_from_ref(default_app_profile[0]['tenant_ref']) if \
            default_app_profile else '/api/tenant/?name=admin'
        app_profile_refs.append(get_object_ref(value, 'applicationprofile',
                                               tenant=tenant))
    return app_profile_refs, f_host, realm, policy_set


def get_vs_ntwk_profiles(profiles, avi_config, prefix):
    """
    Searches for profile refs in converted profile config if not found creates
    default profiles
    :param profiles: profiles in f5 config assigned to VS
    :param avi_config: converted avi config
    :param: prefix: prefix for objects
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
        # Added prefix for objects
        if prefix:
            name = prefix + '-' + name
        ntwk_prof_lst = avi_config.get("NetworkProfile")
        network_profiles = [obj for obj in ntwk_prof_lst if (
            obj['name'] == name or name in obj.get("dup_of", []))]
        if network_profiles:
            network_profile_ref = get_object_ref(
                network_profiles[0]['name'], 'networkprofile',
                tenant=get_name_from_ref(network_profiles[0]['tenant_ref']))
            network_profile_names.append(network_profile_ref)
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
                service['port_range_end'] = int(port) - 1
                new_service = {'port': int(port) + 1,
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


def get_service_obj(destination, avi_config, enable_ssl, controller_version,
                    tenant_name, cloud_name, prefix):
    """
    Checks port overlapping scenario for port value 0 in F5 config
    :param destination: IP and Port destination of VS
    :param avi_config: Dict of avi config
    :param enable_ssl: value to put in service objects
    :param controller_version: Version of controller
    :param tenant_name: Name of tenant
    :param cloud_name: Name of cloud
    :return: services_obj, ip_addr of vs and ref of vsvip
    """

    parts = destination.split(':')
    ip_addr = parts[0]
    ip_addr = ip_addr.strip()
    # Removed unwanted string from ip address
    if '%' in ip_addr:
        ip_addr = ip_addr.split('%')[0]
    # Added support to skip virtualservice with ip address any
    if ip_addr == 'any':
        LOG.debug("Skipped:VS with IP address: %s" % str(destination))
        return None, None, None
    # Added check for IP V4
    matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', ip_addr)
    if not matches or ip_addr == '0.0.0.0':
        LOG.warning('Avi does not support IPv6 Generated random ipv4 for vs:'
                    ' %s' % (ip_addr))
        ip_addr = ".".join(map(str, (
            random.randint(0, 255) for _ in range(4))))
    port = parts[1] if len(parts) == 2 else conv_const.DEFAULT_PORT
    # Get the list of vs which shared the same vip
    if parse_version(controller_version) >= parse_version('17.1'):
        vs_dup_ips = \
            [vs for vs in avi_config['VirtualService'] if
             vs['vip'][0]['ip_address']['addr'] ==
             ip_addr]
    else:
        vs_dup_ips = \
            [vs for vs in avi_config['VirtualService'] if
             vs['ip_address']['addr'] == ip_addr]

    if port == 'any':
        port = 0
    if isinstance(port, str) and (not port.isdigit()):
        port = get_port_by_protocol(port)
    # Port is None then skip vs
    if not port:
        LOG.debug("Skipped:Port not supported %s" % str(parts[1]))
        return None, None, None
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
                end = int(used_ports[i]) - 1
                services_obj.append({'port': start,
                                     'port_range_end': end,
                                     'enable_ssl': enable_ssl})
                start = int(used_ports[i]) + 1
        else:
            services_obj = [{'port': 1, 'port_range_end': conv_const.PORT_END,
                             'enable_ssl': enable_ssl}]

    updated_vsvip_ref = None
    if parse_version(controller_version) >= parse_version('17.1'):
        vs_vip_name = create_update_vsvip(
            ip_addr, avi_config['VsVip'], get_object_ref(tenant_name, 'tenant'),
            get_object_ref(cloud_name, 'cloud', tenant=tenant_name), prefix)
        # VS VIP object to be put in admin tenant to shared across tenants
        updated_vsvip_ref = get_object_ref(vs_vip_name, 'vsvip', 'admin',
                                           cloud_name, prefix)
    return services_obj, ip_addr, updated_vsvip_ref


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
    pool_ref = None
    new_pool = None
    for pool in avi_pool_list:
        if pool["name"] == pool_name:
            new_pool = copy.deepcopy(pool)
            break
    if new_pool:
        new_pool["name"] = pool_name + "-" + vs_name
        if tenant:
            new_pool["tenant_ref"] = get_object_ref(tenant, 'tenant')
        # removing config added from VS config to pool
        new_pool["application_persistence_profile_ref"] = None
        new_pool["ssl_profile_ref"] = None
        new_pool["ssl_key_and_certificate_ref"] = None
        new_pool["pki_profile_ref"] = None
        avi_pool_list.append(new_pool)
        pool_ref = new_pool["name"]
        return pool_ref


def remove_https_mon_from_pool(avi_config, pool_ref, tenant):
    pool = [p for p in avi_config['Pool'] if p['name'] == pool_ref]
    if pool:
        hm_refs = pool[0].get('health_monitor_refs', [])
        for hm_ref in hm_refs:
            hm = [h for h in avi_config['HealthMonitor'] if
                  get_object_ref(h['name'], 'healthmonitor',
                                 tenant=tenant) == hm_ref]
            if hm and hm[0]['type'] == 'HEALTH_MONITOR_HTTPS':
                pool[0]['health_monitor_refs'].remove(hm_ref)
                LOG.warning(
                    'Skipping %s this reference from %s pool because of health '
                    'monitor type is HTTPS and VS has no ssl profile.'
                    % (hm_ref, pool_ref))


def remove_http_mon_from_pool(avi_config, pool_ref, tenant):
    pool = [p for p in avi_config['Pool'] if p['name'] == pool_ref]
    if pool:
        hm_refs = pool[0].get('health_monitor_refs', [])
        for hm_ref in hm_refs:
            hm = [h for h in avi_config['HealthMonitor'] if
                  get_object_ref(h['name'], 'healthmonitor',
                                 tenant=tenant) == hm_ref]

            if hm and hm[0]['type'] == 'HEALTH_MONITOR_HTTP':
                pool[0]['health_monitor_refs'].remove(hm_ref)
                LOG.warning('Skipping %s this reference from %s pool because of'
                            ' health monitor type is HTTPS and VS has no ssl '
                            'profile.' % (hm_ref, pool_ref))


def remove_https_mon_from_pool_group(avi_config, poolgroup_ref, tenant):
    poolgroup = [p for p in avi_config['PoolGroup'] if get_object_ref(
        p['name'], 'poolgroup', tenant=tenant) == poolgroup_ref]
    if poolgroup:
        pool_members = [p['pool_ref'] for p in poolgroup[0]['members']]
        for pool_ref in pool_members:
            pool_ref = get_name_from_ref(pool_ref)
            remove_https_mon_from_pool(avi_config, pool_ref, tenant)


def remove_http_mon_from_pool_group(avi_config, poolgroup_ref, tenant):
    poolgroup = [p for p in avi_config['PoolGroup'] if get_object_ref(
        p['name'], 'poolgroup', tenant=tenant) == poolgroup_ref]
    if poolgroup:
        pool_members = [p['pool_ref'] for p in poolgroup[0]['members']]
        for pool_ref in pool_members:
            pool_name = get_name_from_ref(pool_ref)
            remove_http_mon_from_pool(avi_config, pool_name, tenant)


def add_ssl_to_pool(avi_pool_list, pool_ref, pool_ssl_profiles, tenant='admin'):
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


def add_ssl_to_pool_group(avi_config, pool_group_ref, ssl_pool, tenant_ref):
    pool_group = [obj for obj in avi_config['PoolGroup']
                  if obj['name'] == pool_group_ref]
    if pool_group:
        pool_group = pool_group[0]
        for member in pool_group['members']:
            pool_name = get_name_from_ref(member['pool_ref'])
            add_ssl_to_pool(avi_config['Pool'], pool_name,
                            ssl_pool, tenant_ref)


def update_pool_for_persist(avi_pool_list, pool_ref, persist_profile,
                            hash_profiles, persist_config, tenant):
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
        obj_tenant = persist_profile_obj[0]['tenant_ref']
        pool_obj[persist_ref_key] = get_object_ref(
            persist_profile, 'applicationpersistenceprofile',
            tenant=get_name_from_ref(obj_tenant))
    elif persist_profile == "hash" or persist_profile in hash_profiles:
        del pool_obj["lb_algorithm"]
        hash_algorithm = "LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS"
        pool_obj["lb_algorithm_hash"] = hash_algorithm
    else:
        pool_updated = False
    return pool_updated


def update_pool_group_for_persist(avi_config, pool_ref, persist_profile,
                                  hash_profiles, persist_config, tenant):
    pool_group_updated = True
    pool_group = [obj for obj in avi_config['PoolGroup']
                  if obj['name'] == pool_ref]
    if pool_group:
        pool_group = pool_group[0]
        for member in pool_group['members']:
            pool_name = get_name_from_ref(member['pool_ref'])
            pool_updated = update_pool_for_persist(
                avi_config['Pool'], pool_name, persist_profile, hash_profiles,
                persist_config, tenant)
            if not pool_updated:
                pool_group_updated = False
    return pool_group_updated


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
    ips = []
    if isinstance(members, dict):
        ips = members.keys() + members.values()
    elif isinstance(members, str):
        ips = [members]
    ips = [ip for ip in ips if ip]
    for ip in ips:
        # Removed unwanted string from ip address
        if '/' in ip or '%' in ip:
            ip = ip.split('/')[-1]
            ip = ip.split('%')[-2]
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
    avi_config.pop('OneConnect', [])
    avi_config.pop('UnsupportedProfiles',[])
    for profile in avi_config['ApplicationProfile']:
        profile.pop('HTTPPolicySet', None)
        profile.pop('realm', [])
        profile.pop('fallback_host', [])
    for profile in avi_config.get('PKIProfile', []):
        profile.pop('mode', None)


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


def create_network_security_rule(name, ip, mask, tenant):
    if '%' in ip:
        ip = ip.split('%')[0]
    rule = {
        "name": name,
        "tenant_ref": get_object_ref(tenant, 'tenant'),
        "rules": [
            {
                "index": 1,
                "enable": True,
                "name": "Rule 1",
                "age": 0,
                "action": "NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY",
                "match": {
                    "client_ip": {
                        "prefixes": [
                            {
                                "ip_addr": {
                                    "type": "V4",
                                    "addr": ip
                                },
                                "mask": mask
                            }
                        ],
                        "match_criteria": "IS_NOT_IN"
                    }
                },
                "log": False
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
    tenant = 'admin'
    if name and name.startswith('/'):
        parts = name.split('/', 2)
        tenant = parts[1]
        if not parts[2]:
            LOG.warning('Invalid tenant ref : %s' % name)
        name = parts[2]
    elif name and '/' in name:
        parts = name.split('/')
        tenant = parts[0]
        name = parts[1]
    if tenant.lower() == 'common':
        tenant = 'admin'

    return tenant, name


def get_app_profile_type(profile_name, avi_config):
    profiles = avi_config.get('ApplicationProfile', [])
    profile = [obj for obj in profiles if obj['name'] == profile_name]
    if profile:
        return profile[0]['type']
    else:
        return 'APPLICATION_PROFILE_TYPE_HTTP'


def update_pool_for_service_port(pool_list, pool_name):
    pool = [obj for obj in pool_list if obj['name'] == pool_name]
    if pool:
        pool[0]['use_service_port'] = True


def rreplace(s, old, new, occurrence):
    li = s.rsplit(old, occurrence)
    return new.join(li)


def get_project_path():
    return os.path.abspath(os.path.dirname(__file__))


def clone_pool_if_shared(ref, avi_config, vs_name, tenant, p_tenant,
                         cloud_name='Default-Cloud', prefix=None):
    """
    clones pool or pool group if its shard between multiple VS or partitions
    in F5
    :param ref: reference of pool or pool group
    :param avi_config: Avi configuration cloned pool or pool groups to be added
    :param vs_name: Name of the vs to be added
    :param tenant: tenant name of vs
    :param p_tenant: tenant name of pool
    :return:
    """
    is_pool_group = False
    pool_group_obj = None
    # Added prefix for objects
    if prefix:
        ref = prefix + '-' + ref
    # Search the pool or pool group with name in avi config for the same
    # tenant as VS
    pool_obj = [pool for pool in avi_config['Pool'] if pool['name'] == ref
                and pool['tenant_ref'] == get_object_ref(tenant,'tenant')]
    if not pool_obj:
        pool_group_obj = [pool for pool in avi_config['PoolGroup']
                          if pool['name'] == ref and
                          pool['tenant_ref'] == get_object_ref(tenant,'tenant')]
    if pool_group_obj:
        is_pool_group = True
    if p_tenant:
        shared_vs = [obj for obj in avi_config['VirtualService']
                     if obj.get("pool_ref", "") == get_object_ref(
                ref, 'pool', tenant=p_tenant, cloud_name=cloud_name)]
        if not shared_vs:
            shared_vs = [obj for obj in avi_config['VirtualService']
                         if obj.get("pool_group_ref", "") == get_object_ref(
                    ref, 'poolgroup', tenant=p_tenant, cloud_name=cloud_name)]
    else:
        shared_vs = [obj for obj in avi_config['VirtualService']
                     if obj.get("pool_ref", "") == get_object_ref(
                ref, 'pool', tenant=tenant, cloud_name=cloud_name)]
        if not shared_vs:
            shared_vs = [obj for obj in avi_config['VirtualService']
                         if obj.get("pool_group_ref", "") == get_object_ref(
                    ref, 'poolgroup', tenant=tenant, cloud_name=cloud_name)]
    if not tenant == p_tenant:
        if is_pool_group:
            ref = clone_pool_group(
                ref, vs_name, avi_config, tenant, cloud_name=cloud_name)
        else:
            ref = clone_pool(ref, vs_name, avi_config['Pool'], tenant)
    if shared_vs:
        if is_pool_group:
            ref = clone_pool_group(
                ref, vs_name, avi_config, tenant, cloud_name=cloud_name)
        else:
            ref = clone_pool(ref, vs_name, avi_config['Pool'], tenant)

    return ref, is_pool_group


def clone_pool_group(pool_group_name, vs_name, avi_config, tenant='admin',
                     cloud_name='Default-Cloud'):
    """
    If pool is shared with other VS pool is cloned for other VS as Avi dose not
    support shared pools with new pool name as <pool_name>-<vs_name>
    :param pool_group_name: Name of the pool group to be cloned
    :param vs_name: Name of the VS for pool group to be cloned
    :param avi_config: new pool to be added to avi config
    :param tenant: if f5 pool is shared across partition then coned for tenant
    :return: new pool group name
    """
    pg_ref = None
    new_pool_group = None
    for pool_group in avi_config['PoolGroup']:
        if pool_group["name"] == pool_group_name:
            new_pool_group = copy.deepcopy(pool_group)
            break
    if new_pool_group:
        new_pool_group["name"] = pool_group_name + "-" + vs_name
        pg_ref = new_pool_group["name"]
        new_pool_group["tenant_ref"] = get_object_ref(tenant, 'tenant')
        avi_config['PoolGroup'].append(new_pool_group)
        for member in new_pool_group['members']:
            pool_name = get_name_from_ref(member['pool_ref'])
            pool_name = clone_pool(
                pool_name, vs_name, avi_config['Pool'], tenant)
            member['pool_ref'] = get_object_ref(
                pool_name, 'pool', tenant=tenant, cloud_name=cloud_name)
    return pg_ref


def get_name_from_ref(url):
    parsed = urlparse.urlparse(url)
    return urlparse.parse_qs(parsed.query)['name'][0]


def create_self_signed_cert():
    # create a key pair
    key = crypto.PKey()
    key.generate_key(crypto.TYPE_RSA, 2048)

    # create a self-signed cert
    cert = crypto.X509()
    cert.get_subject().C = "US"
    cert.get_subject().O = "Avi Networks"
    cert.get_subject().CN = gethostname()
    cert.set_serial_number(1000)
    cert.gmtime_adj_notBefore(0)
    cert.gmtime_adj_notAfter(10 * 365 * 24 * 60 * 60)
    cert.set_issuer(cert.get_subject())
    cert.set_pubkey(key)
    cert.sign(key, 'sha256')
    cert = crypto.dump_certificate(crypto.FILETYPE_PEM, cert)
    key = crypto.dump_privatekey(crypto.FILETYPE_PEM, key)
    return key, cert


def get_object_ref(object_name, object_type, tenant='admin',
                   cloud_name='Default-Cloud', prefix=None):
    """
    This function defines that to genarte object ref in the format of
    /api/object_type/?tenant=tenant_name&name=object_name&cloud=cloud_name
    :param object_name: Name of object
    :param object_type: Type of object
    :param tenant: Name of tenant
    :param cloud_name: Name of cloud
    :param prefix : Prefix for objects
    :return: Return generated object ref
    """
    global tenants
    # Added prefix for objects
    if prefix:
        object_name = prefix + '-' + object_name

    cloud_supported_types = ['pool', 'poolgroup', 'vsvip']
    if not cloud_name:
        cloud_name = "Default-Cloud"

    if object_type == 'tenant':
        ref = '/api/tenant/?name=%s' % object_name
        if object_name not in tenants:
            tenants.append(object_name)
    elif object_type == 'cloud':
        ref = '/api/cloud/?tenant=admin&name=%s' % object_name
    elif object_type in cloud_supported_types:
        ref = '/api/%s/?tenant=%s&name=%s&cloud=%s' % (
            object_type, tenant, object_name, cloud_name)
    else:
        ref = '/api/%s/?tenant=%s&name=%s' % (object_type, tenant, object_name)
    # if cloud_name:
    #     ref += '&cloud=%s' % cloud_name
    return ref


def add_tenants(avi_config_dict):
    global tenants
    if tenants:
        avi_config_dict['Tenant'] = []
        for tenant in tenants:
            avi_config_dict['Tenant'].append({
                'name': tenant,
                'local': True
            })


def write_status_report_and_pivot_table_in_xlsx(output_dir, report_name):
    """
    This function defines that add status sheet and pivot table sheet in xlsx
    format
    :param output_dir: Path of output directory
    :return: None
    """

    # List of fieldnames for headers
    fieldnames = ['F5 type', 'F5 SubType', 'F5 ID', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Not Applicable',
                  'User Ignored', 'Skipped for defaults', 'Complexity Level',
                  'VS Reference', 'Overall skipped settings', 'Avi Object']

    # xlsx workbook
    report_path = output_dir + os.path.sep + "%s-ConversionStatus.xlsx" % \
                                             report_name
    status_wb = Workbook(report_path)
    # xlsx worksheet
    status_ws = status_wb.add_worksheet("Status Sheet")
    first_row = 0
    for header in fieldnames:
        col = fieldnames.index(header)
        status_ws.write(first_row, col, header)
    row = 1
    for row_data in csv_writer_dict_list:
        for _key, _value in row_data.items():
            col = fieldnames.index(_key)
            status_ws.write(row, col, _value)
        row += 1
    status_wb.close()
    # create dataframe for row list
    df = pandas.DataFrame(csv_writer_dict_list, columns=fieldnames)
    # create pivot table using pandas
    pivot_table = \
        pandas.pivot_table(df, index=["Status", "F5 type", "F5 SubType"],
                           values=[], aggfunc=[len], fill_value=0)
    # create dataframe for pivot table using pandas
    pivot_df = pandas.DataFrame(pivot_table)
    master_book = \
        load_workbook(report_path)
    master_writer = pandas.ExcelWriter(report_path, engine='openpyxl')
    master_writer.book = master_book
    # Add pivot table in Pivot sheet
    pivot_df.to_excel(master_writer, 'Pivot Sheet')
    master_writer.save()


def get_name(url):
    """
    This function defines that return name object from url
    :param url:
    :return: Name of object
    """
    parsed = urlparse.urlparse(url)
    return urlparse.parse_qs(parsed.query)['name'][0]


def format_string_to_json(avi_string):
    """
    This function defines that it convert string into json format to
    convert into dict
    :param avi_string: string to be converted
    :return: Return converted string
    """
    avi_string = avi_string.split('__/__')[0]
    avi_string = re.sub(r"\"(.)+\"", "''", avi_string)
    repls = ('True', 'true'), ('False', 'false'), ("\"", ""), ("'", "\""), \
            ("None", "null"), ('u"', '"')
    avi_string = reduce(lambda a, kv: a.replace(*kv), repls, avi_string)
    try:
        return json.loads(avi_string)
    except Exception as e:
        LOG.error(e)
        pass


def get_csv_object_list(csv_writer_dict_list, command_list):
    """
    This method is used for getting csv object
    :param csv_writer_dict_list: CSV row of object from xlsx report
    :param command_list: List of netscaler commands
    :return: List of CSV rows
    """

    csv_object = [row for row in csv_writer_dict_list if
                  row['Status'] in [conv_const.STATUS_PARTIAL,
                                    conv_const.STATUS_SUCCESSFUL] and
                  '->' not in row['Avi Object'] and
                  row['F5 type'] in command_list]
    return csv_object


def get_and_update_csv_row(csv_object, vs_ref):
    """
    This function defines that update csv row.
    :param csv_object: csv object
    :param vs_ref: Name of VS
    :return: Skipped attribute list
    """

    if 'VS Reference' in csv_object and \
                    vs_ref not in csv_object['VS Reference']:
        csv_object['VS Reference'] += ',' + vs_ref
    else:
        csv_object['VS Reference'] = vs_ref
    repls = ('[', ''), (']', '')
    skipped_setting_csv = reduce(
        lambda a, kv: a.replace(*kv), repls, csv_object['Skipped settings'])
    if skipped_setting_csv:
        return [skipped_setting_csv]


def get_csv_skipped_list(csv_objects, name_of_object, vs_ref, field_key=None):
    """
    This method is used for getting skipped list from vs.
    :param csv_objects: CSV row of object from xlsx report
    :param name_of_object: Name of object
    :param vs_ref: Name of VS
    :param field_key: Key fromm avi json which is specific for object type
    :return: Return skipped attribute list
    """

    for csv_object in csv_objects:
        avi_objects = format_string_to_json(csv_object['Avi Object'])
        if isinstance(avi_objects, dict):
            avi_objects = [avi_objects]
        if not avi_objects:
            avi_objects = []
        for avi_object_json in avi_objects:
            object_found = False
            if field_key:
                if field_key in avi_object_json and 'Duplicate' not in \
                        avi_object_json[field_key] and \
                                avi_object_json[field_key]['name'] == \
                                name_of_object:
                    object_found = True
            else:
                if avi_object_json.get('name') and \
                                avi_object_json['name'] == name_of_object:
                    object_found = True

            if object_found:
                return get_and_update_csv_row(csv_object, vs_ref)


def get_ssl_profile_skipped(profile_csv_list, ssl_profile_ref, vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param profile_csv_list: List of profile(F5 type) csv rows
    :param ssl_profile_ref: Reference of ssl profile
    :param vs_ref: Name of VS
    :return: ssl profile name and skipped sttribute list
    """

    ssl_profile_name = get_name(ssl_profile_ref)
    skipped_list = get_csv_skipped_list(
        profile_csv_list, ssl_profile_name, vs_ref, field_key='ssl_profile')
    return ssl_profile_name, skipped_list


def get_application_profile_skipped(profile_csv_list, app_profile_ref, vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param profile_csv_list: List of profile(F5 type) csv rows
    :param app_profile_ref: Reference of application profile
    :param vs_ref: Name of VS
    :return: application profile name and skipped sttribute list
    """

    app_profile_name = get_name(app_profile_ref)
    skipped_list = get_csv_skipped_list(profile_csv_list, app_profile_name,
                                        vs_ref, field_key='app_profile')
    return app_profile_name, skipped_list


def get_network_profile_skipped(profile_csv_list, network_profile_ref, vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param profile_csv_list: List of profile(F5 type) csv rows
    :param network_profile_ref: Reference of Network profile
    :param vs_ref: Name of VS
    :return: network profile name and skipped sttribute list
    """

    network_profile_name = get_name(network_profile_ref)
    skipped_list = get_csv_skipped_list(profile_csv_list, network_profile_name,
                                        vs_ref, field_key='network_profile')
    return network_profile_name, skipped_list


def get_policy_set_skipped(profile_csv_list, policy_set_ref, vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param profile_csv_list: List of profile(F5 type) csv rows
    :param policy_set_ref: Reference of policy set
    :param vs_ref: Name of VS
    :return: policy set name and skipped sttribute list
    """

    policy_set_name = get_name(policy_set_ref)
    skipped_list = get_csv_skipped_list(profile_csv_list, policy_set_name,
                                        vs_ref, field_key='policy_set')
    return policy_set_name, skipped_list


def get_app_persistence_profile_skipped(csv_writer_dict_list, pool_object,
                                        vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param csv_writer_dict_list: List of csv rows
    :param pool_object: object of pool
    :param vs_ref: Name of VS
    :return: profile name and skipped attribute list
    """

    app_persistence_profile_name = get_name(
        pool_object['application_persistence_profile_ref'])
    csv_object = get_csv_object_list(
        csv_writer_dict_list, ['persistence'])
    skipped_list = get_csv_skipped_list(
        csv_object, app_persistence_profile_name, vs_ref)
    return app_persistence_profile_name, skipped_list


def get_pool_skipped(csv_objects, pool_name, vs_ref):
    """
    This functions defines that get the skipped list of CSV row
    :param csv_objects: CSV row of object from xlsx report
    :param pool_name: Name of pool
    :param vs_ref: Name of VS
    :return: Skipped list of csv row
    """

    for csv_object in csv_objects:
        avi_object = format_string_to_json(csv_object['Avi Object'])
        if 'pools' in avi_object:
            pool_object = [pool for pool in avi_object['pools']
                           if pool['name'] == pool_name]
            if pool_object:
                return get_and_update_csv_row(csv_object, vs_ref)


def get_pool_skipped_list(avi_config, pool_group_name, csv_pool_rows,
                          csv_writer_dict_list, vs_ref, profile_csv_list):
    """
    This method is used for getting pool skipped list.
    :param avi_config: AVI dict
    :param pool_group_name: Name of Pool group
    :param csv_pool_rows: List of pool(F5 type) csv rows
    :param csv_writer_dict_list: List of F5 csv rows
    :param vs_ref: Name of VS
    :param profile_csv_list: List of profile(F5 type) csv rows
    :return:
    """

    pool_group_objects = [pool_group_object for pool_group_object in
                          avi_config['PoolGroup'] if pool_group_object['name']
                          == pool_group_name]
    pool_members = pool_group_objects[0]['members']
    skipped_setting = {
        'pools': []
    }
    for pool_member in pool_members:
        pool_skipped_setting = {}
        pool_name = get_name(pool_member['pool_ref'])
        skipped_list = get_pool_skipped(csv_pool_rows, pool_name, vs_ref)
        pool_object = [pool for pool in avi_config["Pool"]
                       if pool['name'] == pool_name]
        if skipped_list:
            pool_skipped_setting['pool_name'] = pool_name
            pool_skipped_setting['pool_skipped_list'] = skipped_list

        if 'health_monitor_refs' in pool_object[0]:
            health_monitor_skipped_setting = []
            for health_monitor_ref in pool_object[0]['health_monitor_refs']:
                health_monitor_ref = get_name(health_monitor_ref)
                monitor_csv_object = get_csv_object_list(
                    csv_writer_dict_list, ['monitor'])
                skipped_list = get_csv_skipped_list(
                    monitor_csv_object, health_monitor_ref, vs_ref)
                if skipped_list:
                    health_monitor_skipped_setting.append(
                        {'health_monitor_name': health_monitor_ref,
                         'monitor_skipped_list': skipped_list})
            if health_monitor_skipped_setting:
                pool_skipped_setting['pool_name'] = pool_name
                pool_skipped_setting['health_monitor'] = \
                    health_monitor_skipped_setting
        if 'ssl_key_and_certificate_ref' in pool_object[0] and \
                pool_object[0]['ssl_key_and_certificate_ref']:
            ssl_key_cert = get_name(
                pool_object[0]['ssl_key_and_certificate_ref'])
            get_csv_skipped_list(profile_csv_list, ssl_key_cert, vs_ref,
                                 field_key='key_cert')
        if 'ssl_profile_ref' in pool_object[0] and \
                pool_object[0]['ssl_profile_ref']:
            name, skipped = get_ssl_profile_skipped(
                profile_csv_list, pool_object[0]['ssl_profile_ref'], vs_ref)
            if skipped:
                pool_skipped_setting['pool_name'] = pool_name
                pool_skipped_setting['ssl profile'] = {}
                pool_skipped_setting['ssl profile']['name'] = name
                pool_skipped_setting['ssl profile']['skipped_list'] = skipped

        if 'application_persistence_profile_ref' in pool_object[0] and \
                pool_object[0]['application_persistence_profile_ref']:
            name, skipped = get_app_persistence_profile_skipped(
                csv_writer_dict_list, pool_object[0], vs_ref)
            if skipped:
                pool_skipped_setting['pool_name'] = pool_name
                pool_skipped_setting['Application Persistence profile'] = {}
                pool_skipped_setting['Application Persistence profile'][
                    'name'] = name
                pool_skipped_setting['Application Persistence profile'][
                    'skipped_list'] = skipped

        if pool_skipped_setting:
            skipped_setting['pools'].append(pool_skipped_setting)
            return skipped_setting


def vs_per_skipped_setting_for_references(avi_config):
    """
    This functions defines that Add the skipped setting per VS CSV row
    :param avi_config: this method use avi_config for checking vs skipped
    :return: None
    """

    # Get the count of vs fully migrated
    global fully_migrated
    fully_migrated = 0
    # Get the VS object list which is having status successful and partial.
    vs_csv_objects = [row for row in csv_writer_dict_list
                      if row['Status'] in [conv_const.STATUS_PARTIAL,
                                           conv_const.STATUS_SUCCESSFUL]
                      and row['F5 type'] == 'virtual']
    # Get the list of csv rows which has profile as F5 Type
    profile_csv_list = get_csv_object_list(
        csv_writer_dict_list, ['profile'])
    for vs_csv_object in vs_csv_objects:
        skipped_setting = {}
        virtual_service = format_string_to_json(vs_csv_object['Avi Object'])
        # Update the complexity level of VS as Basic or Advanced
        update_vs_complexity_level(vs_csv_object, virtual_service)
        vs_ref = virtual_service['name']
        repls = ('[', ''), (']', '')
        # Get list of skipped setting attributes
        skipped_setting_csv = reduce(lambda a, kv: a.replace(*kv), repls,
                                     vs_csv_object['Skipped settings'])
        if skipped_setting_csv:
            skipped_setting['virtual_service'] = [skipped_setting_csv]
        # Get the skipped list for ssl key and cert
        if 'ssl_key_and_certificate_refs' in virtual_service:
            for ssl_key_and_certificate_ref in \
                    virtual_service['ssl_key_and_certificate_refs']:
                ssl_key_cert = get_name(ssl_key_and_certificate_ref)
                get_csv_skipped_list(profile_csv_list, ssl_key_cert, vs_ref,
                                     field_key='key_cert')

        # Get the skipped list for ssl profile name.
        if 'ssl_profile_name' in virtual_service:
            name, skipped = get_ssl_profile_skipped(
                profile_csv_list, virtual_service['ssl_profile_name'], vs_ref)
            if skipped:
                skipped_setting['ssl profile'] = {}
                skipped_setting['ssl profile']['name'] = name
                skipped_setting['ssl profile']['skipped_list'] = skipped
        # Get the skipped list for pool group.
        if 'pool_group_ref' in virtual_service:
            pool_group_name = get_name(virtual_service['pool_group_ref'])
            csv_pool_rows = get_csv_object_list(csv_writer_dict_list, ['pool'])
            pool_group_skipped_settings = get_pool_skipped_list(
                avi_config, pool_group_name, csv_pool_rows,
                csv_writer_dict_list, vs_ref, profile_csv_list)
            if pool_group_skipped_settings:
                skipped_setting['Pool Group'] = pool_group_skipped_settings
        # Get the skipepd list for http policy.
        if 'http_policies' in virtual_service:
            for http_ref in virtual_service['http_policies']:
                policy_set_name, skipped_list = get_policy_set_skipped(
                    profile_csv_list, http_ref['http_policy_set_ref'], vs_ref)
                if skipped_list:
                    skipped_setting['Httppolicy'] = {}
                    skipped_setting['Httppolicy']['name'] = policy_set_name
                    skipped_setting['Httppolicy']['skipped_list'] = skipped_list
                # Get the http policy name
                pool_csv_rows = \
                    get_csv_object_list(csv_writer_dict_list, ['pool'])
                for each_http_policy in avi_config['HTTPPolicySet']:
                    if each_http_policy['name'] == policy_set_name:
                        for http_req in \
                                each_http_policy['http_request_policy'][
                                    'rules']:
                            if http_req.get('switching_action'):
                                pool_group_name = \
                                    get_name(http_req['switching_action']
                                             ['pool_group_ref'])
                                pool_group_skipped_settings = \
                                    get_pool_skipped_list(
                                        avi_config, pool_group_name,
                                        pool_csv_rows, csv_writer_dict_list,
                                        vs_ref, profile_csv_list)
                                if pool_group_skipped_settings:
                                    skipped_setting['Httppolicy']['Pool Group'] \
                                        = pool_group_skipped_settings

        # # Get the skipped list for application_profile_ref.
        if 'application_profile_ref' in virtual_service and 'admin:System' \
                not in virtual_service['application_profile_ref']:
            name, skipped = get_application_profile_skipped(
                profile_csv_list, virtual_service['application_profile_ref'],
                vs_ref)
            if skipped:
                skipped_setting['Application profile'] = {}
                skipped_setting['Application profile'][
                    'name'] = name
                skipped_setting['Application profile'][
                    'skipped_list'] = skipped
        # # Get the skipped list for network profile ref.
        if 'network_profile_ref' in virtual_service and 'admin:System' \
                not in virtual_service['network_profile_ref']:
            name, skipped = get_network_profile_skipped(
                profile_csv_list, virtual_service['network_profile_ref'],
                vs_ref)
            if skipped:
                skipped_setting['Network profile'] = {}
                skipped_setting['Network profile'][
                    'name'] = name
                skipped_setting['Network profile'][
                    'skipped_list'] = skipped
        # Update overall skipped setting of VS csv row
        if skipped_setting:
            vs_csv_object.update(
                {'Overall skipped settings': str(skipped_setting)})
        else:
            vs_csv_object.update(
                {'Overall skipped settings': "FULLY MIGRATION"})
            fully_migrated += 1

    csv_objects = [row for row in csv_writer_dict_list
                   if row['Status'] in [conv_const.STATUS_PARTIAL,
                                        conv_const.STATUS_SUCCESSFUL]
                   and row['F5 type'] != 'virtual']

    # Update the vs reference not in used if objects are not attached to
    # VS directly or indirectly
    for row in csv_objects:
        if 'VS Reference' not in row or row['VS Reference'] == '':
            row['VS Reference'] = conv_const.STATUS_NOT_IN_USE


def update_vs_complexity_level(vs_csv_row, virtual_service):
    """
    This function defines that update complexity level of VS objects.
    if it has reference of VS Datascript or Http policies -> Advanced
    else
    level -> Basic
    :param vs_csv_row: csv row of VS
    :param virtual_service: dict of Virtual service
    :return: None
    """

    if ('http_policies' in virtual_service and
            virtual_service['http_policies']) or \
            ('vs_datascripts' in virtual_service and
                 virtual_service['vs_datascripts']):
        vs_csv_row['Complexity Level'] = conv_const.COMPLEXITY_ADVANCED
    else:
        vs_csv_row['Complexity Level'] = conv_const.COMPLEXITY_BASIC


def create_update_vsvip(vip, vsvip_config, tenant_ref, cloud_ref, prefix):
    """
    This functions defines that create or update VSVIP object.
    :param vip: vip of VS
    :param vsvip_config: List of vs object
    :param tenant_ref: tenant reference
    :param cloud_ref: cloud reference
    :return: None
    """

    name = vip + '-vsvip'
    # Added prefix for objects
    if prefix:
        name = '%s-%s' % (prefix, name)
    # Get the exsting vsvip object list if present
    vsvip = [vip_obj for vip_obj in vsvip_config
             if vip_obj['name'] == name]
    # If VSVIP object not present then create new VSVIP object.
    if not vsvip:
        vsvip_object = {
            "name": name,
            "tenant_ref": get_object_ref('admin', 'tenant'),
            "cloud_ref": cloud_ref,
            "vip": [
                {
                    "vip_id": "0",
                    "ip_address": {
                        "type": "V4",
                        "addr": vip
                    }
                }
            ],
        }
        vsvip_config.append(vsvip_object)

    return name
