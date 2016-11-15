import logging
import copy
import re
from avi.netscaler_converter import ns_util

LOG = logging.getLogger(__name__)


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
        lbvs_avi_conf = avi_config['VirtualService']
        lb_vs_mapped = []
        cs_vs_list = []
        avi_config['HTTPPolicySet'] = []
        rule_index = 0
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
            if port < int(port):
                port = "1"
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
                'services': [{'port': port, 'enable_ssl': enable_ssl}]
            }

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
            if default_pool:
                vs_obj['pool_ref'] = '%s-pool' % default_pool
            for cs_vs_policy in cs_vs_policies:
                new_rule_index, policy = self.policy_converter(cs_vs_policy, rule_index)
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
            cs_vs_list.append(vs_obj)
            conv_status = ns_util.get_conv_status(
                cs_vs, self.skip_attrs, self.na_attrs, [])
            ns_util.add_conv_status(cmd, conv_status, vs_obj)
            LOG.debug("Context Switch VS conversion completed for: %s" % key)

        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list += cs_vs_list
        avi_config['VirtualService'] = vs_list

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

    def policy_converter(self, policy, rule_index):
        policy_name = policy['attrs'][0]
        ns_rule = policy['rule']
        path_query = {
            "match_case": 'INSENSITIVE',
            "match_str": [],
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
        policy_rules = {
            'name': policy_name + '-rule' + rule_index,
            "index": rule_index,
            'match': {},
            'switching_action': {
                'action': 'HTTP_SWITCHING_SELECT_POOL',
                'status_code': 200,
                'pool_ref': policy['targetLBVserver'] + '-pool'
            }
        }
        policy_obj = {
            'name': policy_name + '-http-request-policy',
            'tenant_uuid': 'admin',
            'enable': 'false',
            'http_request_policy': {
                'rules': []
            },
        }
        rules = ns_rule.split("&&")
        for index, rule in enumerate(rules):
            query = rule.strip('"')
            query = query.strip()
            policy_rule = copy.deepcopy(policy_rules)
            policy_rule["index"] = rule_index
            policy_rule["name"] += rule_index
            if 'URL ==' in rule:
                a, b = query.split("==")
                b = b.strip()
                match_str = b.strip("\\'")
                if match_str is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"].update({"path": path_query})
                policy_rule["match"]["path"]["match_str"].append(match_str)
                policy_rule["match"]["path"]["match_criteria"] = "EQUAL"
                policy_obj["http_request_policy"]["rules"].append(policy_rule)
                rule_index += 1

            elif 'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in query or \
                            'HTTP.REQ.URL.QUERY.CONTAINS' in query or \
                            'HTTP.REQ.URL.PATH.STARTSWITH' in query:

                policy_rule["match"].update({"query": path_query})
                policy_rule["match"]["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

                matches = re.findall('\"(.+?)\"', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                matches = list(set(matches))
                for match in matches:
                    if 'HTTP.REQ.URL.PATH.STARTSWITH' in query or \
                                    'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in query:
                        match = re.sub('[\\\/]', '', match)
                        policy_rule["match"]["query"]["match_str"].append(match)
                rule_index += 1

            elif 'REQ.IP.SOURCEIP' in query:
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

            elif 'CLIENT.IP.SRC.EQ' in query:
                policy_rule["match"].update({"client_ip": client_ip})
                matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                for match in matches:
                    policy_rule["match"]["client_ip"]["addrs"].append({"type": 'V4', "addr": match})
                rule_index += 1

            elif 'HTTP.REQ.HEADER' in query and \
                            ".CONTAINS" in query:
                policy_rule["match"].update({"hdrs": header})
                policy_rule["match"]["hdrs"][0]["match_criteria"] = "HDR_EQUALS"

                matches = re.findall('\"(.+?)\"', query)
                if matches[0] is None or matches[1] is None:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                policy_rule["match"]["hdrs"][0]["hdr"] = matches[0]
                policy_rule["match"]["hdrs"][0]["value"].append(matches[1])
                rule_index += 1

            elif 'HTTP.REQ.HEADER' in query and ".EXISTS" in query:
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

            elif 'HTTP.REQ.HOSTNAME.EQ' in query:
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

            elif 'HTTP.REQ.COOKIE.CONTAINS' in query or \
                            'HTTP.REQ.COOKIE.CONTAINS' in query:
                policy_rule["match"].update({"cookie": cookie})
                matches = re.findall('\"(.+?)\"', query)
                if len(matches) != 2:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                if 'HTTP.REQ.COOKIE.CONTAINS' in query:
                    policy_rule["match"]["cookie"]["match_criteria"] = "HDR_CONTAINS"
                elif 'HTTP.REQ.COOKIE.CONTAINS' in query:
                    policy_rule["match"]["cookie"]["match_criteria"] = "HDR_EQUALS"
                policy_rule["match"]["cookie"]["value"] = matches[1]
                policy_rule["match"]["cookie"]["name"] = matches[0]
                rule_index += 1

            elif ('HTTP.REQ.URL.PATH.GET' in query and  'CONTAINS' in query) or \
                            'HTTP.REQ.URL.PATH.CONTAINS' in query:
                policy_rule["match"].update({"query": path_query})
                if 'HTTP.REQ.URL.PATH.GET' in query:
                    policy_rule["match"]["query"]["match_criteria"] = "EQUALS"
                elif 'HTTP.REQ.URL.PATH.CONTAINS' in query:
                    policy_rule["match"]["query"]["match_criteria"] = "CONTAINS"
                matches = re.findall('\"(.+?)\"', query)
                if len(matches) == 0:
                    LOG.warning('No Matches found for %s' % query)
                    continue
                for match in matches:
                    policy_rule["match"]["query"]["match_str"].append(match)
                rule_index += 1

            else:
                LOG.warning("%s Rule is not supported" % query)
                continue
            policy_obj["http_request_policy"]["rules"].append(policy_rule)

        if len(policy_obj["http_request_policy"]["rules"]) > 0:
            return rule_index, policy_obj
        return rule_index, None







