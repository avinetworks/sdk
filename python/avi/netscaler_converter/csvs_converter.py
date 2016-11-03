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

        for key in cs_vs_conf:
            #print key
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
            for bind_conf in bind_conf_list:
                b_cmd = 'bind cs vserver %s' % vs_name
                found = False
                if len(bind_conf['attrs']) > 1:
                    lbvs_bindings.append(bind_conf['attrs'][1])
                    b_cmd += ' %s' % bind_conf['attrs'][1]
                    found = True
                if 'policyName' in bind_conf:
                    b_cmd += ' -policyName %s' % bind_conf['policyName']
                    if 'targetLBVserver' in bind_conf:
                        lbvs_bindings.append(bind_conf['targetLBVserver'])
                        found = True
                        policy = policy_config[bind_conf['policyName']]
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
            policy = self.policy_converter(cs_vs_policies, vs_name)
            cs_vs_list.append(vs_obj)
            conv_status = ns_util.get_conv_status(
                cs_vs, self.skip_attrs, self.na_attrs, [])
            ns_util.add_conv_status(cmd, conv_status, vs_obj)
            LOG.debug("Context Switch VS conversion completed for: %s" % key)

        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list.append(cs_vs_list)
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

    def policy_converter(self, policies, vs_name):
        rules = []
        for policy in policies:
            policy_name = policy['attrs'][0]
            ns_rule = policy['rule']
            if 'URL ==' in ns_rule:
                query = ns_rule.strip('"')
                a, b = query.split("==")
                b = b.strip()
                b = b.strip("\\'")
                final = b
                policy_obj = {
                    'name': name+'-http-request-policy',
                    'enable': 'false',
                    'http_request_policy': {
                        'rules': [{
                            'name': policy_name+'-rule',
                            'match': {
                                'match_case': 'INSENSITIVE',
                                'match_str': final,
                                'match_criteria': 'CONTAINS'
                            },
                            'switching_action': {
                                'action': 'HTTP_POLICY_SET_REF',
                                'status_code': 200,
                                'pool_ref': policy_config[
                                                'targetLBVserver']+'-pool'
                            }
                        }]
                    },
                    'is_internal_policy': 'false'
                }
                print policy_obj

            elif 'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in ns_rule:
                query= ns_rule.strip('"')
                match = re.findall('\"(.+?)\"', query)
                for m in match:
                    policy_obj = {
                        'enable': 'false',
                        'name': name+'-http-request-policy',
                        'match':
                            {
                                'path':
                                    {
                                        'match_case': 'INSENSITIVE',
                                        'match_str': m,
                                        'match_criteria': 'CONTAINS'
                                    }
                            },
                        'switching_action': {
                                    'action': 'HTTP_POLICY_SET_REF',
                                    'status_code': 200,
                                    'pool_ref': policy_config[
                                                    'targetLBVserver']+'-pool'
                                }
                            }
                print policy_obj

            elif 'REQ.IP.SOURCEIP' in ns_rule:
                query = ns_rule.strip('"')
                a, b = query.split("==")
                b = b.strip()
                policy_obj = {
                    'enable': 'false',
                    'name': name+'-http-request-policy',
                    'match':
                        {
                            'path':
                            {
                                'match_case': 'INSENSITIVE',
                                'match_str': b,
                                'match_criteria': 'EQUALS'
                            }
                        },
                        'switching_action': {
                                    'action': 'HTTP_POLICY_SET_REF',
                                    'status_code': 200,
                                    'pool_ref': policy_config[
                                                    'targetLBVserver']+'-pool'
                                }
                            }
                print policy_obj

            elif 'CLIENT.IP.SRC.EQ' in ns_rule:
                print "in ip if"
                query = ns_rule.strip('"')
                match = re.findall('\((.*?)\)', query)
                for m in match:
                    policy_obj = {
                        'enable': 'false',
                        'name': name+'-http-request-policy',
                        'match':
                            {
                                'path':
                                {
                                    'match_case': 'INSENSITIVE',
                                    'match_str': m,
                                    'match_criteria': 'EQUALS'
                                }
                            },
                            'switching_action': {
                                        'action': 'HTTP_POLICY_SET_REF',
                                        'status_code': 200,
                                        'pool_ref': policy_config[
                                                        'targetLBVserver']+'-pool'
                                    }
                                }
                print policy_obj