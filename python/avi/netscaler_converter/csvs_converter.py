import logging
import copy
import re
from avi.netscaler_converter import ns_util
from avi.netscaler_converter.lbvs_converter import Redirect_Pools
from avi.netscaler_converter.ns_constants import STATUS_SKIPPED

LOG = logging.getLogger(__name__)

tmp_pool_ref = []
tmp_policy_ref = []
class CsvsConverter(object):
    skip_attrs = ['td', 'IPPattern', 'IPMask', 'dnsRecordType', 'persistenceId',
                  'cacheable', 'redirectURL', 'precedence',
                  'caseSensitive ', 'soMethod', 'soPersistence', 'rtspNat',
                  'soPersistenceTimeOut', 'soThreshold', 'soBackupAction',
                  'redirectPortRewrite', 'downStateFlush', 'Listenpolicy',
                  'insertVserverIPPort', 'disablePrimaryOnDown', 'authnVsName',
                  'AuthenticationHost', 'Authentication', 'Listenpriority',
                  'authn401',  'push', 'pushVserver', 'pushLabel',
                  'pushMultiClients', 'comment', 'mssqlServerVersion ',
                  'l2Conn', 'netProfile', 'icmpVsrResponse', 'RHIstate',
                  'authnProfile', 'dnsProfileName']
    na_attrs = ['dbProfileName', 'oracleServerVersion', 'stateupdate',
                'backupVServer', 'mysqlProtocolVersion', 'mysqlServerVersion',
                'mysqlCharacterSet', 'mysqlServerCapabilities', 'appflowLog']

    bind_skipped = ['vServer', 'type', 'domainName ',
                    'gotoPriorityExpression', 'TTL', 'backupIP', 'cookieDomain',
                    'cookieTimeout', 'sitedomainTTL']

    supported_types = ['HTTP', 'SSL', 'TCP', 'DNS', 'DNS_TCP']

    ignore_vals = {'Listenpolicy': 'None'}

    def convert(self, ns_config, avi_config, vs_state):
        cs_vs_conf = ns_config.get('add cs vserver', {})
        bindings = ns_config.get('bind cs vserver', {})
        policy_lables = ns_config.get('bind cs policylabel', {})
        policy_config = ns_config.get('add cs policy', {})
        responder_policy_config = ns_config.get('add responder policy', {})
        rewrite_policy_config = ns_config.get('add rewrite policy', {})
        responder_action_config = ns_config.get('add responder action', {})
        rewrite_action_config = ns_config.get('add rewrite action', {})

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
            cmd = 'add cs vserver'
            full_cmd = ns_util.get_netscalar_full_command(cmd, cs_vs)
            if not cs_vs['attrs'][1] in self.supported_types:
                LOG.warn('Unsupported type %s of Context switch VS: %s' %
                         (cs_vs['attrs'][1], key))
                ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
                continue
            tt = cs_vs.get('targetType', None)
            if tt and tt == 'GSLB':
                LOG.warn('Unsupported target type %s of Context switch VS: %s' %
                         (cs_vs['attrs'][1], key))
                ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
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
            updated_vs_name = re.sub('[:]', '-', vs_name)
            vs_obj = {
                'name': updated_vs_name,
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
                vs_obj['application_profile_ref'] = http_prof
                clttimeout = cs_vs.get('cltTimeout', None)
                if clttimeout:
                    ns_util.add_clttimeout_for_http_profile(http_prof, avi_config, clttimeout)
                    clt_cmd = cmd + ' cltTimeout %s' % clttimeout
                    LOG.info('Conversion successful : %s' % clt_cmd)
            ntwk_prof = cs_vs.get('tcpProfileName', None)
            if ntwk_prof:
                if ns_util.object_exist('NetworkProfile', ntwk_prof, avi_config):
                    LOG.info('Conversion successful: Added network profile %s for %s' % (ntwk_prof, vs_name))
                    vs_obj['network_profile_ref'] = ntwk_prof
                else:
                    vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'
                    LOG.error('Error: Not found Network profile %s for %s' % (ntwk_prof, vs_name))

            if not http_prof and (cs_vs['attrs'][1]).upper() == 'DNS':
                vs_obj['application_profile_ref'] = 'admin:System-DNS'
                vs_obj['network_profile_ref'] = 'admin:System-UDP-Per-Pkt'
            elif not http_prof and (cs_vs['attrs'][1]).upper() == 'UDP':
                vs_obj['application_profile_ref'] = 'admin:System-L4-Application'
                vs_obj['network_profile_ref'] = 'admin:System-UDP-Fast-Path'
            elif not http_prof and (cs_vs['attrs'][1]).upper() == 'DNS_TCP':
                vs_obj['application_profile_ref']= 'admin:System-L4-Application'
                vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'
            bind_conf_list = bindings.get(vs_name, None)
            if not bind_conf_list:
                continue
            if isinstance(bind_conf_list, dict):
                bind_conf_list = [bind_conf_list]
            cs_vs_policies = []
            default_pool = None
            policy_name = ''
            for bind_conf in bind_conf_list:
                b_cmd = 'bind cs vserver'
                full_cmd = ns_util.get_netscalar_full_command(b_cmd, bind_conf)
                found = False
                if len(bind_conf['attrs']) > 1:
                    lbvs_bindings.append(bind_conf['attrs'][1])
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
                                LOG.info('Conversion successful : %s' % pl_cmd)

                if 'policyName' in bind_conf:
                    policy_name = bind_conf['policyName']
                    c_policy = policy_config.get(policy_name, None)
                    rewrite_policy = rewrite_policy_config.get(policy_name, None)
                    responder_policy = responder_policy_config.get(policy_name, None)

                    if c_policy and bind_conf.get('targetLBVserver', None):
                        lbvs_bindings.append(bind_conf['targetLBVserver'])
                        found = True
                        policy = policy_config[policy_name]
                        policy = copy.deepcopy(policy)
                        policy['policy_type'] = 'cs_policy'
                        policy['targetLBVserver'] = bind_conf['targetLBVserver']
                        if bind_conf.get('priority', None):
                            policy['priority'] = bind_conf.get('priority')
                        cs_vs_policies.append(policy)

                    elif rewrite_policy:
                        policy = rewrite_policy_config[policy_name]
                        policy = copy.deepcopy(policy)
                        policy['policy_type'] = 'rewrite_policy'
                        if bind_conf.get('priority', None):
                            policy['priority'] = bind_conf.get('priority')

                        cs_vs_policies.append(policy)

                    elif responder_policy:
                        policy = responder_policy_config[policy_name]
                        policy = copy.deepcopy(policy)
                        policy['policy_type'] = 'responder_policy'
                        if bind_conf.get('priority', None):
                            policy['priority'] = bind_conf.get('priority')
                        cs_vs_policies.append(policy)

                if 'lbvserver' in bind_conf:
                    lbvs_bindings.append(bind_conf['lbvserver'])
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

                    ns_util.add_conv_status(b_cmd, vs_name, full_cmd, conv_status, vs_obj)
                else:
                    ns_util.add_status_row(b_cmd, vs_name, full_cmd, STATUS_SKIPPED)

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

            if cs_vs_policies:
                new_rule_index, policy = ns_util.policy_converter(cs_vs_policies, rule_index, bind_patset,
                                                                  patset_config, avi_config, rewrite_action_config,
                                                                  responder_action_config, tmp_pool_ref, Redirect_Pools,
                                                                  self.skip_attrs, self.na_attrs, b_cmd)
                if policy:
                    if policy['name'] in tmp_policy_ref:
                        ns_util.clone_http_policy_set(policy, avi_config)
                    tmp_policy_ref.append(policy['name'])
                    http_policies = {
                        'index': 11,
                        'http_policy_set_ref': policy['name']
                    }
                    vs_obj['http_policies'] = []
                    vs_obj['http_policies'].append(http_policies)
                    avi_config['HTTPPolicySet'].append(policy)
                    rule_index = new_rule_index

            if default_pool and default_pool in lb_config:
                pool_ref = '%s-pool' % default_pool
                updated_pool_ref = re.sub('[:]', '-', pool_ref)
                pools = [obj['name'] for obj in avi_config['Pool'] if obj['name'] == updated_pool_ref]
                if pools:
                    if updated_pool_ref in tmp_pool_ref:
                        updated_pool_ref = ns_util.clone_pool(updated_pool_ref, vs_name, avi_config)
                    vs_obj['pool_ref'] = updated_pool_ref
                    tmp_pool_ref.append(updated_pool_ref)
            is_shared = ns_util.is_shared_same_vip(vs_obj, avi_config)
            if is_shared:
                ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
                LOG.warning('Skipped: %s Same vip shares another virtual service' % vs_name)
                continue
            cs_vs_list.append(vs_obj)
            conv_status = ns_util.get_conv_status(
                cs_vs, self.skip_attrs, self.na_attrs, [],
                ignore_for_val=self.ignore_vals)
            ns_util.add_conv_status(cmd, key, full_cmd, conv_status, vs_obj)
            LOG.debug("Context Switch VS conversion completed for: %s" % key)

        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list += cs_vs_list
        avi_config['VirtualService'] = vs_list
        ns_util.get_vs_if_shared_vip(avi_config)
        ns_util.set_rules_index_for_http_policy_set(avi_config)

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
