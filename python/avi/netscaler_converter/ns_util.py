import csv
import logging
import os
import copy
import re

from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED, STATUS_SUCCESSFUL,
                                               STATUS_INDIRECT, STATUS_NOT_APPLICABLE,
                                               STATUS_PARTIAL, STATUS_DATASCRIPT,
                                                  STATUS_COMMAND_NOT_SUPPORTED)

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


def add_conv_status(cmd, object_type, full_command, conv_status, avi_object=None):
    """
    Adds as status row in conversion status csv
    :param cmd: netscaler command
    :param conv_status: dict of conversion status
    :param avi_object: Converted objectconverted avi object
    """
    global csv_writer
    row = {
        'Netscaler Command': cmd if cmd else '',
        'Object Type': object_type if object_type else '',
        'Full Command': full_command if full_command else '',
        'Status': conv_status.get('status', ''),
        'Skipped settings': str(conv_status.get('skipped', '')),
        'Indirect mapping': str(conv_status.get('indirect', '')),
        'Not Applicable': str(conv_status.get('na_list', '')),
        'User Ignored': str(conv_status.get('user_ignore', '')),
        'AVI Object': str(avi_object) if avi_object else ''
    }
    csv_writer.writerow(row)


def add_status_row(cmd, object_type, full_command, status, avi_object=None):
    """
    Adds as status row in conversion status csv
    :param cmd: netscaler command
    :param status: conversion status
    """
    global csv_writer
    row = {
        'Netscaler Command': cmd,
        'Object Type': object_type,
        'Full Command': full_command,
        'Status': status,
        'AVI Object': str(avi_object) if avi_object else ''
    }
    csv_writer.writerow(row)


def add_csv_headers(csv_file):
    """
    Adds header line in conversion status file
    :param csv_file: File to which header is to be added
    """
    global csv_writer
    fieldnames = ['Netscaler Command', 'Object Type', 'Full Command', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Not Applicable',
                  'User Ignored', 'AVI Object']
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames,
                                lineterminator='\n',)
    csv_writer.writeheader()


def get_avi_lb_algorithm(ns_algorithm):
    """
    Converts f5 LB algorithm to equivalent avi LB algorithm
    :param ns_algorithm: f5 algorithm name
    :return: Avi LB algorithm enum value
    """
    avi_algorithm = 'LB_ALGORITHM_ROUND_ROBIN'
    if not ns_algorithm or ns_algorithm == 'ROUNDROBIN':
        avi_algorithm = 'LB_ALGORITHM_ROUND_ROBIN'
    elif ns_algorithm in ['LEASTRESPONSETIME', 'LRTM']:
        avi_algorithm = 'LB_ALGORITHM_FASTEST_RESPONSE'
    elif ns_algorithm == 'SOURCEIPHASH':
        avi_algorithm = 'LB_ALGORITHM_CONSISTENT_HASH'
    elif ns_algorithm == 'URLHASH':
        avi_algorithm = 'LB_ALGORITHM_CONSISTENT_HASH_URI'
    return avi_algorithm


def get_avi_resp_code(respCode):
    avi_resp_codes = []
    codes = respCode.split(' ')
    for code in codes:
        if code < 200:
            avi_resp_codes.append({"code": "HTTP_1XX"})
        elif code < 300:
            avi_resp_codes.append({"code": "HTTP_2XX"})
        elif code < 400:
            avi_resp_codes.append({"code": "HTTP_3XX"})
        elif code < 500:
            avi_resp_codes.append({"code": "HTTP_4XX"})
        elif code < 600:
            avi_resp_codes.append({"code": "HTTP_5XX"})
    return list(set(avi_resp_codes))


def get_conv_status(ns_object, skipped_list, na_list, indirect_list,
                    ignore_for_val=None, indirect_commands = None):
    skipped = [attr for attr in ns_object.keys() if attr in skipped_list]
    na = [attr for attr in ns_object.keys() if attr in na_list]
    indirect = [attr for attr in ns_object.keys() if attr in indirect_list]
    if ignore_for_val:
        for key in ignore_for_val.keys():
            if key not in ns_object:
                continue
            ns_val = ns_object.get(key)
            ignore_val = ignore_for_val.get(key)
            if key in skipped and str(ns_val) == str(ignore_val):
                skipped.remove(key)
    if skipped:
        status = STATUS_PARTIAL
    else:
        status = STATUS_SUCCESSFUL

    conv_status = {
        'skipped': skipped,
        'indirect': indirect,
        'na_list': na,
        'status': status
    }
    return conv_status


def get_key_cert_obj(name, key_file_name, cert_file_name, input_dir):
        folder_path = input_dir+os.path.sep
        key = upload_file(folder_path + key_file_name)
        cert = upload_file(folder_path + cert_file_name)
        ssl_kc_obj = None
        if key and cert:
            cert = {"certificate": cert}
            ssl_kc_obj = {
                    'name': name,
                    'key': key,
                    'certificate': cert,
                    'key_passphrase': ''
                }
        return ssl_kc_obj


def get_command_from_line(line):
    cmd = ''
    for member in line:
        if isinstance(member, str):
            cmd += ' %s' % member
        else:
            cmd += ' -%s' % ' '.join(member)
    return cmd


def update_status_for_skipped(skipped_cmds):
    na_cmds = ['set system', 'set interface', 'set ns config', 'set snmp']
    indirect_cmds = ['add cmp global', 'bind cmp global']
    if not skipped_cmds:
        return
    for cmd in skipped_cmds:
        cmd = cmd.strip()
        is_na = False
        is_id = False
        for na_cmd in na_cmds:
            if cmd.startswith(na_cmd):
                add_status_row(na_cmd, None, cmd, STATUS_NOT_APPLICABLE)
                is_na = True
                break
        for id_cmd in indirect_cmds:
            if cmd.startswith(id_cmd):
                add_status_row(id_cmd, None, cmd, STATUS_INDIRECT)
                is_id = True
                break
        if not is_na and not is_id:
            add_status_row(cmd, None, None, STATUS_COMMAND_NOT_SUPPORTED)

def remove_duplicate_objects(obj_type, obj_list):
    """
    Remove duplicate objects from list
    :param obj_type: Object type
    :param obj_list: list of all objects
    :return: return list which has no duplicates objects
    """
    if len(obj_list) == 1:
        return obj_list
    for source_obj in obj_list:
        for index, tmp_obj in enumerate(obj_list):
            if tmp_obj["name"] == source_obj["name"]:
                continue
            src_cp = copy.deepcopy(source_obj)
            tmp_cp = copy.deepcopy(tmp_obj)
            del src_cp["name"]
            if "description" in src_cp:
                del src_cp["description"]

            del tmp_cp["name"]
            if "description" in tmp_cp:
                del tmp_cp["description"]
            if cmp(src_cp, tmp_cp) == 0:
                LOG.warn('Remove duplicate %s object : %s' % (obj_type, tmp_obj["name"]))
                del obj_list[index]
                remove_duplicate_objects(obj_type, obj_list)
    return obj_list

def cleanup_config(config):
    del config

def clone_pool(pool_name, prefix, avi_config):
    pools = [pool for pool in avi_config['Pool'] if pool['name'] == pool_name]
    if pools:
        pool_obj = copy.deepcopy(pools[0])
        pool_obj['name'] = prefix + pool_obj['name']
        avi_config['Pool'].append(pool_obj)
        LOG.info("Same pool reference to other object. Clone Pool %s for %s" % (pool_name, prefix))
        return pool_obj['name']
    return None

def get_vs_if_shared_vip(avi_config):
    vs_list = [v for v in avi_config['VirtualService'] if 'port_range_end' in v['services'][0]]
    for vs in vs_list:
        vs_port_list = [int(v['services'][0]['port']) for v in avi_config['VirtualService']
                        if v['ip_address']['addr'] == vs['ip_address']['addr'] and
                        'port_range_end' not in v['services'][0]]
        if vs_port_list:
            min_port = min(vs_port_list)
            max_port = max(vs_port_list)
            vs['services'][0]['port_range_end'] = str(min_port - 1)
            service = {
                'enable_ssl': False,
                'port': str(max_port + 1),
                'port_range_end': '65535'
            }
            vs['services'].append(service)


def add_clttimeout_for_http_profile(profile_name, avi_config, cltimeout):
    profile = [p for p in avi_config['ApplicationProfile'] if p['name'] == profile_name]
    if profile:
        profile[0]['client_header_timeout'] = int(cltimeout)
        profile[0]['client_body_timeout'] = int(cltimeout)

def object_exist(object_type, name, avi_config):
    data = avi_config[object_type]
    obj_list = [obj for obj in data if obj['name'] == name]
    if obj_list:
        return True
    return False


def policy_converter(policies, rule_index1, bind_patset, patset_config,
                      avi_config, rewrite_action_config, responder_action_config,
                     tmp_pool_ref, Redirect_Pools, skip_attrs, na_attrs, b_cmd):
    rule_index = 0
    path_query = {
        "match_case": 'INSENSITIVE',
        "match_str": [],
        "match_criteria": ''
    }
    path_regex = {
        "match_case": 'INSENSITIVE',
        "string_group_refs": [],
        "match_criteria": ''
    }
    client_ip = {
        "addrs": [],
        "match_criteria": 'IS_IN'
    }
    header = {
        "match_case": 'INSENSITIVE',
        "hdr": '',
        "value": [],
        "match_criteria": ''
    }
    host_header = {
        "match_case": 'INSENSITIVE',
        "value": [],
        "match_criteria": ''
    }
    cookie = {
        "match_case": 'INSENSITIVE',
        "name": '',
        "value": 'needthismissingvalue',
        "match_criteria": ''
    }

    updated_policy_name = ''

    policy_obj = {
        'name': '',
        'tenant_uuid': 'admin',
        'enable': 'false',
        'http_request_policy': {
            'rules': []
        },
    }

    for policy in policies:
        policy_name = policy['attrs'][0]
        ns_rule = policy.get('rule', None)
        if (not ns_rule or not policy.get('targetLBVserver', None)) and policy['policy_type'] == 'cs_policy':
            return rule_index, None
        elif policy.get('policy_type', None) == 'rewrite_policy' or policy.get('policy_type', None) == 'responder_policy':
            ns_rule = policy['attrs'][1]

        pool_ref = None
        if policy.get('targetLBVserver', None):
            pool_ref = policy['targetLBVserver'] + '-pool'
        redirect_uri = None
        if pool_ref in Redirect_Pools:
            pools = [obj for obj in avi_config['Pool'] if obj['name'] == pool_ref]
            redirect_uri = pools[0]['fail_action']['redirect']['host']

        switching_action = {
            'action': 'HTTP_SWITCHING_SELECT_POOL',
            'status_code': 200,
            'pool_ref': pool_ref
        }

        redirect_action = {
            'protocol': 'HTTP',
            'host': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_HOST',
                    'str_value': redirect_uri,
                    'start_index': '1',
                    'end_index': '65535'
                }]
            }
        }

        priority_index = policy.get('priority', None)
        if not priority_index:
            priority_index = rule_index

        policy_rules = {
            'name': policy_name + '-rule-%s' % priority_index,
            "index": priority_index,
            'match': {},
        }

        if redirect_uri:
            LOG.info("Add redirect Action %s for policy %s" % (redirect_uri, policy_name))
            policy_rules['redirect_action'] = redirect_action
        elif policy.get('targetLBVserver', None):
            pools = [obj['name'] for obj in avi_config['Pool'] if obj['name'] == pool_ref]
            if not pools:
                LOG.error("Policy Skipped. Pool not found in config %s for policy %s" % (pool_ref, policy_name))
                continue
            LOG.info("Add switching Action for policy %s" % policy_name)
            policy_rules['switching_action'] = switching_action

        is_policy_successful = True
        policy_rule = copy.deepcopy(policy_rules)
        conditional_rules = ns_rule.split("&&")
        for rule in conditional_rules:
            query = rule.strip('"')
            query = query.strip()
            if 'URL ==' in query.upper():
                a, b = query.split("==")
                b = b.strip()
                match_str = b.strip("\\'")
                if match_str is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_str"].append(match_str)
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in query.upper() or \
                            'HTTP.REQ.URL.QUERY.CONTAINS' in query.upper() or \
                            'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper() or \
                            'HTTP.REQ.URL.STARTSWITH' in query.upper():
                policy_rule["match"].update({"query": path_query})
                policy_rule["match"]["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    if 'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper() or \
                                    'HTTP.REQ.URL.STARTSWITH' in query.upper() or \
                                    'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in query.upper():
                        match = re.sub('[\\\/]', '', match)
                        policy_rule["match"]["query"]["match_str"].append(match)
                rule_index += 1

            elif 'REQ.IP.SOURCEIP' in query.upper():
                policy_rule["match"].update({"client_ip": client_ip})
                matches = re.findall('\REQ.IP.SOURCEIP == [0-9.]+', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    a, b = match.split("==")
                    policy_rule["match"]["client_ip"]["addrs"].append({"type": 'V4', "addr": b.strip()})
                rule_index += 1

            elif 'CLIENT.IP.SRC.EQ' in query.upper() or \
                            'CLIENT.IP.SRC.NE' in query.upper():
                policy_rule["match"].update({"client_ip": client_ip})
                if 'CLIENT.IP.SRC.NE' in query.upper():
                    policy_rule["match"]['client_ip']['match_criteria'] = 'IS_NOT_IN'
                matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    policy_rule["match"]["client_ip"]["addrs"].append({"type": 'V4', "addr": match})
                rule_index += 1

            elif ('HTTP.REQ.HEADER' in query.upper() and \
                            '.CONTAINS' in query.upper()) or \
                            'HTTP.REQ.FULL_HEADER.CONTAINS' in query.upper():
                policy_rule["match"].update({"hdrs": [header]})
                policy_rule["match"]["hdrs"][0]["match_criteria"] = "HDR_CONTAINS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0 or matches[0] is None or matches[1] is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"]["hdrs"][0]["hdr"] = matches[0]
                policy_rule["match"]["hdrs"][0]["value"].append(matches[1])
                rule_index += 1

            elif 'HTTP.REQ.HEADER' in query.upper() and ".EXISTS" in query.upper():
                header_copy = copy.deepcopy(header)
                header_copy.pop("match_case")
                header_copy.pop("value")
                policy_rule["match"].update({"hdrs": [header]})
                policy_rule["match"]["hdrs"][0]["match_criteria"] = "HDR_EXISTS"
                matches = re.findall('\\\\(.+?)\\\\', query)
                if matches[0] is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"]["hdrs"][0]["hdr"] = matches[0]
                rule_index += 1

            elif ('HTTP.REQ.HOSTNAME.EQ' in query.upper()) or (
                    'HTTP.REQ.HOSTNAME.SET_TEXT_MODE' in query.upper() and 'EQ' in query.upper()):
                policy_rule["match"].update({"host_hdr": host_header})
                policy_rule["match"]["host_hdr"]["match_criteria"] = "HDR_EQUALS"
                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["host_hdr"]["value"].append(match)
                rule_index += 1

            elif ('HTTP.REQ.COOKIE' in query.upper() and 'CONTAINS' in query.upper()) or \
                    ('HTTP.REQ.COOKIE' in query.upper() and 'EQ(' in query.upper()):
                policy_rule["match"].update({"cookie": cookie})
                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) != 2:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                if 'HTTP.REQ.COOKIE' in query.upper() and 'CONTAINS' in query.upper():
                    policy_rule["match"]["cookie"]["match_criteria"] = "HDR_CONTAINS"
                elif 'HTTP.REQ.COOKIE' in query.upper() and 'EQ' in query.upper():
                    policy_rule["match"]["cookie"]["match_criteria"] = "HDR_EQUALS"
                policy_rule["match"]["cookie"]["value"] = matches[1]
                policy_rule["match"]["cookie"]["name"] = matches[0]
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'REGEX_MATCH' in query.upper():
                policy_rule["match"].update({"path": path_regex})
                policy_rule["match"]["path"]["match_criteria"] = "REGEX_MATCH"
                exact_match = re.search(r'\((\d+?)\)', query).group(1)
                matches = re.findall('\(re(.*?)\)', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                regex_match = []
                for match in matches:
                    regex = '.*/'
                    if int(exact_match) == 1:
                        regex = '^%s://.*' % match
                    elif int(exact_match) > 1:
                        for index in range(int(exact_match), 2, -1):
                            regex += '/\w+'
                        regex += '/%s' % match + '.*'
                    else:
                        LOG.warning("%s Rule GET for regex match is not supported" % query)
                        continue
                    regex_match.append(regex)
                string_group_ref = add_string_group_for_policy(
                    '%s-string_group_object-%s' % (policy_name, rule_index), regex_match, avi_config)
                policy_rule["match"]["path"]["string_group_refs"].append(string_group_ref)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQ(' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"
                policy_rule["match"]["path"]["match_str"] = []
                exact_match = re.search(r'\((\d+?)\)', query).group(1)
                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                for match in matches:
                    regex = '.*/'
                    match = re.sub('[\\\/]', '', match)
                    if int(exact_match) == 1:
                        regex = '^%s://.*' % match
                    elif int(exact_match) > 1:
                        if int(exact_match) == 1:
                            regex = '^%s://.*' % match
                        elif int(exact_match) > 1:
                            for index in range(int(exact_match), 2, -1):
                                regex += '/\w+'
                            regex += '/%s' % match + '.*'
                    else:
                        LOG.warning("%s Rule GET for Equal match is not supported" % query)
                        continue
                    policy_rule["match"]["path"]["match_str"].append(regex)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQUALS_ANY(' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"
                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                patsets = []
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    patset = get_patset_collection(match, bind_patset, patset_config)
                    if patset:
                        patsets += patset
                policy_rule["match"]["path"]["match_str"] = list(set(patsets))
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'CONTAINS(' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "CONTAINS"
                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["path"]["match_str"].append(match)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.CONTAINS' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "CONTAINS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["path"]["match_str"].append(match)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.EQ' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["path"]["match_str"].append(match)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["path"]["match_str"].append(match)
                rule_index += 1

            elif 'HTTP.REQ.URL.EQ' in query.upper():
                policy_rule["match"].update({"query": path_query})
                policy_rule["match"]["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

                matches = re.findall('\\\\(.+?)\\\\', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["query"]["match_str"].append(match)
                rule_index += 1

            else:
                LOG.warning("%s Rule is not supported" % query)
                continue

        if 'switching_action' in policy_rule:
            p_ref = policy_rule['switching_action']['pool_ref']
            if p_ref in tmp_pool_ref:
                p_ref = clone_pool(p_ref, policy_name, avi_config)
                policy_rule['switching_action']['pool_ref'] = p_ref
            tmp_pool_ref.append(p_ref)

        elif policy.get('policy_type', None) == 'rewrite_policy' and policy['attrs'][1] != 'true':
            r_cmd = 'add rewrite policy'
            policy_rule = get_rewrite_action(policy['attrs'][2], policy_rule, rewrite_action_config)
            full_cmd = get_netscalar_full_command(r_cmd, policy)
            if policy_rule:
                add_status_row(r_cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)
            else:
                add_status_row(r_cmd, policy_name, full_cmd, STATUS_SKIPPED)

        elif policy.get('policy_type', None) == 'responder_policy' and policy['attrs'][1] != 'true':
            r_cmd = 'add responder policy'
            policy_rule = get_responder_action(policy['attrs'][2], policy_rule, responder_action_config)
            full_cmd = get_netscalar_full_command(r_cmd, policy)
            if policy_rule:
                add_status_row(r_cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

        if policy_rule and policy_rule['match']:
            policy_obj["http_request_policy"]["rules"].append(policy_rule)
            updated_policy_name += policy_name
            p_cmd = 'add cs policy'
            LOG.info('Conversion successful : %s %s' % (p_cmd, policy_name))
            conv_status = get_conv_status(policy, skip_attrs, na_attrs, [])
            full_cmd = get_netscalar_full_command(p_cmd, policy)
            add_conv_status(p_cmd, policy_name, full_cmd, conv_status, policy_rule)
        elif policy['policy_type'] == 'responder_policy' and not policy_rule:
            r_cmd = 'add responder policy'
            full_cmd = get_netscalar_full_command(r_cmd, policy)
            LOG.warning('Datascript: %s %s' % (r_cmd, policy_name))
            add_status_row(r_cmd, policy_name, full_cmd, STATUS_DATASCRIPT)
            is_policy_successful = False

    if len(policy_obj["http_request_policy"]["rules"]) > 0:
        bind_cmd = 'bind cs vserver'
        full_cmd = get_netscalar_full_command(bind_cmd, policy)
        if not is_policy_successful:
            LOG.info('Datascript : %s %s' % (bind_cmd, b_cmd))
            add_status_row(bind_cmd, b_cmd, full_cmd, STATUS_DATASCRIPT)
        else:
            LOG.info('Conversion successful: %s %s' % (bind_cmd, b_cmd))
            add_status_row(bind_cmd, b_cmd, full_cmd, STATUS_SUCCESSFUL, policy_obj)

        updated_policy_name += '-http-request-policy-%s' % rule_index
        policy_obj['name'] = updated_policy_name
        return rule_index, policy_obj

    return rule_index, None

def get_rewrite_action(policy_name, policy_rules, rewrite_action_config):
    policy_action = rewrite_action_config.get(policy_name, None)
    policy_rule = None
    cmd = 'add rewrite action'
    if not policy_action:
        LOG.warning('No responder action found: %s' % policy_name)
        return
    full_cmd = get_netscalar_full_command(cmd, policy_action)

    if policy_action and policy_action['attrs'][1] == 'insert_http_header':
        hdr_action = [{
            'action': 'HTTP_ADD_HDR',
            'hdr': {
                'name': policy_action['attrs'][1],
                'value': {}
            }
        }]
        policy_rule = copy.deepcopy(policy_rules)
        policy_rule['hdr_action'] = hdr_action
        if len(policy_action['attrs']) > 3:
            matches = [policy_action['attrs'][3]]
            if matches:
                value = {'val': matches[0]}
                policy_rule['hdr_action'][0]['hdr']['value'].update(value)
                LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
                add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

    elif policy_action and policy_action['attrs'][1] == 'replace':
        policy_rule = copy.deepcopy(policy_rules)
        path_matches = re.findall('\\\\(.+?)\\\\', policy_action['attrs'][3].strip('"').strip())
        url_action = {
            'action': 'HTTP_ADD_HDR',
            'host_hdr': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': policy_action['attrs'][2]
                }]
            },
            'path': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': path_matches[0]
                }]
            },
            'query': {
                'keep_query': False
            }
        }
        policy_rule['rewrite_url_action'] = url_action
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

    elif policy_action and policy_action['attrs'][1] == 'insert_before':
        policy_rule = copy.deepcopy(policy_rules)
        path_matches = re.findall('\\\\(.+?)\\\\', policy_action['attrs'][3])
        url_action = {
            'action': 'HTTP_ADD_HDR',
            'host_hdr': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': policy_action['attrs'][2]
                }]
            },
            'path': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': path_matches[0] + str(path_matches[0:])
                }]
            },
            'query': {
                'keep_query': False
            }
        }
        policy_rule['rewrite_url_action'] = url_action
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)
    else:
        LOG.warning('Skipped: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SKIPPED)

    return policy_rule

def get_responder_action(policy_name, policy_rules, responder_action_config):
    policy_action = responder_action_config.get(policy_name, None)
    if not policy_action:
        LOG.warning('No responder action found: %s' % policy_name)
        return

    policy_rule = None
    cmd = 'add responder action'
    full_cmd = get_netscalar_full_command(cmd, policy_action)

    if policy_action and policy_action['attrs'][1] == 'insert_http_header':
        hdr_action = [{
            'action': 'HTTP_ADD_HDR',
            'hdr': {
                'name': policy_action['attrs'][1],
                'value': []
            }
        }]
        policy_rule = copy.deepcopy(policy_rules)
        policy_rule['hdr_action'] = hdr_action
        matches = [policy_action['attrs'][3]]
        value = {'val': matches[0]}
        policy_rule['hdr_action'][0]['hdr']['value'].append(value)
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

    elif policy_action and policy_action['attrs'][1] == 'replace':
        policy_rule = copy.deepcopy(policy_rules)
        path_matches = re.findall('\\\\(.+?)\\\\', policy_action['attrs'][3].strip('"').strip())
        url_action = {
            'action': 'HTTP_ADD_HDR',
            'host_hdr': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': policy_action['attrs'][2]
                }]
            },
            'path': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': path_matches[0]
                }]
            },
            'query': {
                'keep_query': False
            }
        }
        policy_rule['rewrite_url_action'] = url_action
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

    elif policy_action and policy_action['attrs'][1] == 'insert_before':
        policy_rule = copy.deepcopy(policy_rules)
        path_matches = re.findall('\\\\(.+?)\\\\', policy_action['attrs'][3])
        url_action = {
            'action': 'HTTP_ADD_HDR',
            'host_hdr': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': policy_action['attrs'][2]
                }]
            },
            'path': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': path_matches[0] + str(path_matches[0:])
                }]
            },
            'query': {
                'keep_query': False
            }
        }
        policy_rule['rewrite_url_action'] = url_action
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)
    elif policy_action and policy_action['attrs'][1] == 'redirect':
        policy_rule = copy.deepcopy(policy_rules)
        path_matches = re.findall('\\\\(.+?)\\\\', policy_action['attrs'][2].strip('"').strip())
        redirect_action = {
            'port': 80,
            'protocol': 'HTTP',
            'status_code': 'HTTP_REDIRECT_STATUS_CODE_302',
            'keep_query': False,

            'path': {
                'type': 'URI_PARAM_TYPE_TOKENIZED',
                'tokens': [{
                    'type': 'URI_TOKEN_TYPE_STRING',
                    'str_value': path_matches[0]
                }]
            },
            'query': {
                'keep_query': False
            }
        }
        policy_rule['redirect_action'] = redirect_action
        LOG.info('Conversion successful: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_SUCCESSFUL, policy_rule)

    else:
        LOG.warning('Datascript: %s %s' % (cmd, policy_name))
        add_status_row(cmd, policy_name, full_cmd, STATUS_DATASCRIPT)

    return policy_rule


def get_patset_collection(match, bind_patset, patset_config):
    if match in patset_config and match in bind_patset:
        patsets = bind_patset[match]
        patset_attrs = []
        for patset in patsets:
            attrs = [x for x in patset['attrs'] if x != match]
            patset_attrs += attrs
        if patset_attrs:
            return patset_attrs

    LOG.warning("%s Patset policy is not supported" % match)


def add_string_group_for_policy(string_group_name, matches, avi_config):
    if not matches:
        return None
    stringgroup_object = {
        "name": string_group_name,
        "kv": [],
    }

    for match in matches:
        stringgroup_object['kv'].append({"key": match})
    avi_config['StringGroup'].append(stringgroup_object)
    LOG.info('Conversion successful : %s' % string_group_name)
    return string_group_name

def is_shared_same_vip(vs, avi_config):
    shared_vip = [v for v in avi_config['VirtualService'] if v['ip_address']['addr'] == vs['ip_address']['addr'] and v['services'][0]['port'] == vs['services'][0]['port']]
    if shared_vip:
        return True

def clone_http_policy_set(policy, avi_config):
    policy_name = policy['name']
    for rule in policy['http_request_policy']['rules']:
        if rule.get('switching_action', None):
            pool_ref = clone_pool(rule['switching_action']['pool_ref'], policy_name, avi_config)
            if pool_ref:
                rule['switching_action']['pool_ref'] = pool_ref
    policy['name'] += '-clone'

def set_rules_index_for_http_policy_set(avi_config):
    http_policy_sets = avi_config['HTTPPolicySet']
    for http_policy_set in http_policy_sets:
        rules = http_policy_set['http_request_policy']['rules']
        rules = sorted(rules, key=lambda d: int(d['index']))
        for index, rule in enumerate(rules):
            rule['index'] = index

def get_netscalar_full_command(netscalar_command, obj):
    for attr in obj['attrs']:
        netscalar_command += ' %s' % attr
    for key in obj:
        if isinstance(obj[key], list):
            continue
        netscalar_command += ' -%s %s' % (key, obj[key])
    return netscalar_command
