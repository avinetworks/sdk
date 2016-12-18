import logging
import copy
import re
from avi.netscaler_converter import ns_util
from lbvs_converter import Redirect_Pools

LOG = logging.getLogger(__name__)

tmp_pool_ref = []
class CsvsConverter(object):
    skip_attrs = ['td', 'IPPattern', 'IPMask', 'dnsRecordType', 'persistenceId',
                  'cacheable', 'redirectURL', 'cltTimeout', 'precedence',
                  'caseSensitive ', 'soMethod', 'soPersistence', 'rtspNat',
                  'soPersistenceTimeOut', 'soThreshold', 'soBackupAction',
                  'redirectPortRewrite', 'downStateFlush', 'Listenpolicy',
                  'insertVserverIPPort', 'disablePrimaryOnDown', 'authnVsName',
                  'AuthenticationHost', 'Authentication', 'Listenpriority',
                  'authn401',  'push', 'pushVserver', 'pushLabel', 'appflowLog',
                  'pushMultiClients', 'comment', 'mssqlServerVersion ',
                  'l2Conn', 'netProfile', 'icmpVsrResponse', 'RHIstate',
                  'authnProfile', 'dnsProfileName']
    na_attrs = ['dbProfileName', 'oracleServerVersion', 'stateupdate',
                'backupVServer', 'mysqlProtocolVersion', 'mysqlServerVersion',
                'mysqlCharacterSet', 'mysqlServerCapabilities']

    bind_skipped = ['vServer', 'priority', 'type', 'domainName ',
                    'gotoPriorityExpression', 'TTL', 'backupIP', 'cookieDomain',
                    'cookieTimeout', 'sitedomainTTL']

    supported_types = ['HTTP', 'SSL', 'TCP']

    def convert(self, ns_config, avi_config, vs_state):
        cs_vs_conf = ns_config.get('add cs vserver', {})
        bindings = ns_config.get('bind cs vserver', {})
        policy_lables = ns_config.get('bind cs policylabel', {})
        policy_config = ns_config.get('add cs policy', {})
        bind_patset = ns_config.get('bind policy patset', {})
        patset_config = ns_config.get('add policy patset', {})
        lb_config = ns_config.get('bind lb vserver', {})
        lbvs_avi_conf = avi_config['VirtualService']
        lb_vs_mapped = []
        cs_vs_list = []
        avi_config['HTTPPolicySet'] = []
        avi_config['StringGroup'] = []
        rule_index = 0
        avi_config['VirtualService'] = ns_util.remove_duplicate_objects('VirtualService', avi_config['VirtualService'])
        for cs_vs_index, key in enumerate(cs_vs_conf):
            LOG.debug("Context Switch VS conversion started for: %s" % key)
            lbvs_bindings = []
            cs_vs = cs_vs_conf[key]
            cmd = 'add cs vserver %s' % key
            if not cs_vs['attrs'][1] in self.supported_types:
                LOG.warn('Unsupported type %s of Context switch VS: %s' %
                         (cs_vs['attrs'][1], key))
                ns_util.add_status_row(cmd, 'skipped')
                continue
            tt = cs_vs.get('targetType', None)
            if tt and tt == 'GSLB':
                LOG.warn('Unsupported target type %s of Context switch VS: %s' %
                         (cs_vs['attrs'][1], key))
                ns_util.add_status_row(cmd, 'skipped')
            vs_name = cs_vs['attrs'][0]
            ip_addr = cs_vs['attrs'][2]
            port = cs_vs['attrs'][3]

            enable_ssl = False
            if vs_state == 'enable':
                enabled = (lb_vs.get('state', 'ENABLED') == 'ENABLED')
            else:
                enabled = False

            if cs_vs['attrs'][1] == 'SSL':
                enable_ssl = True
            vs_obj = {
                'name': vs_name,
                'type': 'VS_TYPE_NORMAL',
                'ip_address': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'enabled': enabled,
                'services': []
            }

            service = {'port': port, 'enable_ssl': enable_ssl}
            if port in ("0", "*"):
                service['port'] = "1"
                service['port_range_end'] = "65535"
            vs_obj['services'].append(service)

            http_prof = cs_vs.get('httpProfileName', None)
            if http_prof:
                vs_obj['application_profile_ref'] = http_prof,
            ntwk_prof = cs_vs.get('tcpProfileName', None)
            if ntwk_prof:
                vs_obj['network_profile_ref'] = ntwk_prof
            bind_conf_list = bindings.get(vs_name, None)
            if not bind_conf_list:
                continue
            if isinstance(bind_conf_list, dict):
                bind_conf_list = [bind_conf_list]
            cs_vs_policies = []
            default_pool = None
            policy_name = ''
            for bind_conf in bind_conf_list:
                b_cmd = 'bind cs vserver %s' % vs_name
                found = False
                if len(bind_conf['attrs']) > 1:
                    lbvs_bindings.append(bind_conf['attrs'][1])
                    b_cmd += ' %s' % bind_conf['attrs'][1]
                    found = True

                if 'policylabel' in bind_conf:
                    policyLabelName = bind_conf['policylabel']
                    if policyLabelName in policy_lables.keys():
                        policyLabels = policy_lables[policyLabelName]
                        if isinstance(policyLabels, dict):
                            policyLabels = [policyLabels]
                        targetVserver = self.get_targetvserver_policylabel(policyLabels, policy_lables)
                        if targetVserver:
                            pl_cmd = "bind cs policylabel : %s" % policyLabelName
                            if 'policyName' in bind_conf:
                                policy_name = bind_conf['policyName']
                                lbvs_bindings.append(targetVserver)
                                found = True
                                policy = policy_config[policy_name]
                                policy = copy.deepcopy(policy)
                                policy['targetLBVserver'] = targetVserver
                                cs_vs_policies.append(policy)
                                ns_util.add_status_row(pl_cmd, 'successful')

                if 'policyName' in bind_conf:
                    policy_name = bind_conf['policyName']
                    b_cmd += ' -policyName %s' % policy_name

                    if 'targetLBVserver' in bind_conf:
                        lbvs_bindings.append(bind_conf['targetLBVserver'])
                        found = True
                        policy = policy_config[policy_name]
                        policy = copy.deepcopy(policy)

                        policy['targetLBVserver'] = bind_conf['targetLBVserver']
                        cs_vs_policies.append(policy)

                if 'lbvserver' in bind_conf:
                    lbvs_bindings.append(bind_conf['lbvserver'])
                    b_cmd += ' -lbvserver %s' % bind_conf['lbvserver']
                    default_pool = bind_conf['lbvserver']
                    found = True
                if 'invoke' in bind_conf:
                    parts = bind_conf['invoke'].split(' ')
                    if parts[0] != 'policylabel' or len(parts) < 2:
                        continue
                    before_len = size = len(lbvs_bindings)
                    self.get_target_vs_from_policy(policy_lables, parts[1],
                                                   lbvs_bindings)
                    if len(lbvs_bindings) > before_len:
                        found = True
                conv_status = ns_util.get_conv_status(
                    bind_conf, self.bind_skipped, [], [])
                if found:
                    ns_util.add_conv_status(b_cmd, conv_status, None)
                else:
                    ns_util.add_status_row(b_cmd, 'skipped')

            LOG.debug("CS VS %s context switch between lb vs: %s" %
                      (key, lbvs_bindings))

            for binding in lbvs_bindings:
                lb_vs_obj = [obj for obj in lbvs_avi_conf
                             if obj['name'] == binding]
                if lb_vs_obj:
                    lb_vs_obj = lb_vs_obj[0]
                else:
                    continue
                lb_vs_mapped.append(lb_vs_obj)
                lb_vs_obj = copy.deepcopy(lb_vs_obj)
                lb_vs_obj.update(vs_obj)
                vs_obj = lb_vs_obj
            vs_obj.pop('pool_ref', None)

            for cs_vs_policy in cs_vs_policies:
                if cs_vs_policy['targetLBVserver'] in lb_config:
                    new_rule_index, policy = self.policy_converter(cs_vs_policy, rule_index, bind_patset, patset_config, avi_config)
                    if policy:
                        http_policies = {
                            'index': 11,
                            'http_policy_set_ref': policy['name']
                        }
                        vs_obj['http_policies'] = []
                        vs_obj['http_policies'].append(http_policies)
                        avi_config['HTTPPolicySet'].append(policy)
                        p_cmd = 'add cs policy %s' % policy_name
                        policy_conv = policy_config.get(policy_name)
                        conv_status = ns_util.get_conv_status(
                            cs_vs_policy, self.skip_attrs, self.na_attrs, [])
                        ns_util.add_conv_status(p_cmd, conv_status, policy)
                        rule_index = new_rule_index
                else:
                    ns_util.add_status_row(b_cmd, 'skipped')
                    LOG.warning('%s is not bind with any service or service group so skipped policyset' %  cs_vs_policy['targetLBVserver'])

            if default_pool and default_pool in lb_config:
                pool_ref = '%s-pool' % default_pool
                pools = [obj['name'] for obj in avi_config['Pool'] if obj['name'] == pool_ref]
                if pools:
                    if pool_ref in tmp_pool_ref:
                        pool_ref = ns_util.clone_pool(pool_ref, vs_name, avi_config)
                    vs_obj['pool_ref'] = pool_ref
                    tmp_pool_ref.append(pool_ref)
            cs_vs_list.append(vs_obj)
            conv_status = ns_util.get_conv_status(
                cs_vs, self.skip_attrs, self.na_attrs, [])
            ns_util.add_conv_status(cmd, conv_status, vs_obj)
            LOG.debug("Context Switch VS conversion completed for: %s" % key)

        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list += cs_vs_list
        avi_config['VirtualService'] = vs_list
        ns_util.get_vs_if_shared_vip(avi_config)

    def get_target_vs_from_policy(self, policy_lables, name, lbvs_bindings):
        policy_grp = policy_lables.get(name, None)
        if not policy_grp:
            return None
        if isinstance(policy_grp, dict):
            policy_grp = [policy_grp]
        for policy in policy_grp:
            if 'invoke' in policy:
                parts = policy['invoke'].split(' ')
                self.get_target_vs_from_policy(policy_lables, parts[1],
                                               lbvs_bindings)
            elif 'targetVserver' in policy:
                lbvs_bindings.append(policy['targetVserver'])

    def policy_converter(self, policy, rule_index, bind_patset, patset_config, avi_config):
        policy_name = policy['attrs'][0]
        ns_rule = policy['rule']
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

        policy_rules = {
            'name': policy_name + '-rule',
            "index": rule_index,
            'match': {},
        }

        if redirect_uri:
            LOG.info("Add redirect Action %s for policy %s" % (redirect_uri, policy_name))
            policy_rules['redirect_action'] = redirect_action
        else:
            pools = [obj['name'] for obj in avi_config['Pool'] if obj['name'] == pool_ref]
            if not pools:
                LOG.error("Policy Skipped. Pool not found in config %s for policy %s" % (pool_ref, policy_name))
                return rule_index, None
            LOG.info("Add switching Action for policy %s" % policy_name)
            policy_rules['switching_action'] = switching_action

        updated_policy_name = policy_name + '-http-request-policy-%s' % rule_index
        policy_obj = {
            'name': updated_policy_name,
            'tenant_uuid': 'admin',
            'enable': 'false',
            'http_request_policy': {
                'rules': []
            },
        }

        conditional_rules = ns_rule.split("&&")
        for rule in conditional_rules:
            query = rule.strip('"')
            query = query.strip()
            policy_rule = copy.deepcopy(policy_rules)
            policy_rule["index"] = rule_index
            policy_rule["name"] += str(rule_index)
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
                 'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper():
                policy_rule["match"].update({"query": path_query})
                policy_rule["match"]["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

                matches = re.findall('\"(.+?)\"', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    if 'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper() or \
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
                    policy_rule["match"]["client_ip"]["addrs"].append({"type": 'V4',"addr": b.strip()})
                rule_index += 1

            elif 'CLIENT.IP.SRC.EQ' in query.upper():
                policy_rule["match"].update({"client_ip": client_ip})
                matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    policy_rule["match"]["client_ip"]["addrs"].append({"type": 'V4', "addr": match})
                rule_index += 1

            elif 'HTTP.REQ.HEADER' in query.upper() and \
                 '.CONTAINS' in query.upper():
                policy_rule["match"].update({"hdrs": header})
                policy_rule["match"]["hdrs"][0]["match_criteria"] = "HDR_CONTAINS"

                matches = re.findall('\"(.+?)\"', query)
                if matches[0] is None or matches[1] is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"]["hdrs"][0]["hdr"] = matches[0]
                policy_rule["match"]["hdrs"][0]["value"].append(matches[1])
                rule_index += 1

            elif 'HTTP.REQ.HEADER' in query.upper() and ".EXISTS" in query.upper():
                header_copy = copy.deepcopy(header)
                header_copy.pop("match_case")
                header_copy.pop("value")
                policy_rule["match"].update({"hdrs": header})
                policy_rule["match"]["hdrs"][0]["match_criteria"] = "HDR_EXISTS"
                matches = re.findall('\"(.+?)\"', query)
                if matches[0] is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"]["hdrs"][0]["hdr"] = matches[0]
                rule_index += 1

            elif ('HTTP.REQ.HOSTNAME.EQ' in query.upper()) or ('HTTP.REQ.HOSTNAME.SET_TEXT_MODE' in query.upper() and 'EQ' in query.upper()):
                policy_rule["match"].update({"host_hdr": host_header})
                policy_rule["match"]["host_hdr"]["match_criteria"] = "HDR_EQUALS"
                matches = re.findall('\"(.+?)\"', query)
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
                matches = re.findall('\"(.+?)\"', query)
                if len(matches) != 2:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                if ('HTTP.REQ.COOKIE' in query.upper() and 'CONTAINS' in query.upper()):
                    policy_rule["match"]["cookie"]["match_criteria"] = "HDR_CONTAINS"
                elif ('HTTP.REQ.COOKIE' in query.upper() and 'EQ' in query.upper()):
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
                string_group_ref = self.add_string_group_for_policy('%s-string_group_object-%s' % (policy_name, rule_index), regex_match, avi_config)
                policy_rule["match"]["path"]["string_group_refs"].append(string_group_ref)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQ(' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "EQUALS"
                exact_match = re.search(r'\((\d+?)\)', query).group(1)
                matches = re.findall('\"(.+?)\"', query)
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
                matches = re.findall('\"(.+?)\"', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                patsets = []
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    patset = self.get_patset_collection(match, bind_patset, patset_config)
                    patsets += patset
                policy_rule["match"]["path"]["match_str"] = list(set(patsets))
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'CONTAINS(' in query.upper():
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_criteria"] = "CONTAINS"
                matches = re.findall('\"(.+?)\"', query)
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

                matches = re.findall('\"(.+?)\"', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    match = re.sub('[\\\/]', '', match)
                    policy_rule["match"]["path"]["match_str"].append(match)
                rule_index += 1

            else:
                LOG.warning("%s Rule is not supported" % query)
                continue

            if 'switching_action' in policy_rule:
                p_ref = policy_rule['switching_action']['pool_ref']
                if p_ref in tmp_pool_ref:
                    p_ref = ns_util.clone_pool(p_ref, policy_name, avi_config)
                    policy_rule['switching_action']['pool_ref'] = p_ref
                tmp_pool_ref.append(p_ref)
            policy_obj["http_request_policy"]["rules"].append(policy_rule)

        if len(policy_obj["http_request_policy"]["rules"]) > 0:
            return rule_index, policy_obj
        return rule_index, None

    def get_targetvserver_policylabel(self, policyLabel, policy_lables, depth=100):
        if depth == 0:
            return None

        target_vserver = [x['targetVserver'] for x in policyLabel if 'targetVserver' in x]
        if target_vserver:
            return target_vserver[0]
        else:
            policy_label = [x['invoke'] for x in policyLabel if x in 'invoke']
            if policy_label and policy_label[0] in policy_lables.keys():
                policyLabelName = policy_label[0]
                policyLabels = policy_lables[policyLabelName]
                if isinstance(policyLabels, dict):
                    policyLabels = [policyLabels]
                self.get_targetvserver_policylabel(self, policyLabels, policy_lables, depth=depth-1)

    def get_patset_collection(self, match, bind_patset, patset_config):
        if match in patset_config and match in bind_patset:
            patsets = bind_patset[match]
            patset_attrs = []
            for patset in patsets:
                attrs = [x for x in patset['attrs'] if x != match]
                patset_attrs += attrs
            if patset_attrs:
                return patset_attrs

        LOG.warning("%s Patset policy is not supported" % match)

    def add_string_group_for_policy(self, string_group_name, matches, avi_config):
        if not matches:
            return None
        stringgroup_object = {
            "name": string_group_name,
            "kv": [],
        }

        for match in matches:
            stringgroup_object['kv'].append({"key": match})
        avi_config['StringGroup'].append(stringgroup_object)
        ns_util.add_status_row(string_group_name, "Successful")
        return string_group_name
