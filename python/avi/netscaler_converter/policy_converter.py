"""
This file is used to convert the policies.
"""
import logging
import re
import copy
import avi.netscaler_converter.ns_constants as ns_constants

from avi.netscaler_converter import ns_util
from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED,
                                                  STATUS_SUCCESSFUL,
                                                  STATUS_DATASCRIPT,
                                                  OBJECT_TYPE_POOL_GROUP)



LOG = logging.getLogger(__name__)


class PolicyConverter(object):
    """
    This class is used to convert the policy
    """
    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 bind_skipped, na_attrs, ignore_vals):
        self.policyconverter_policy_types = \
        ns_constants.netscalar_command_status['policyconverter_policy_types']
        self.policyconverter_bind_skipped = \
        ns_constants.netscalar_command_status['policyconverter_bind_skipped']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
        self.bind_skipped = bind_skipped
        self.na_attrs = na_attrs
        self.ignore_vals = ignore_vals

    def convert(self, bind_conf_list, ns_config, avi_config, tmp_pool_ref,
                redirect_pools, netscalar_command, case_sensitive):
        """
        This function defines that convert netscalar policy to http policy set
        in AVI
        :param bind_conf_list: Binding policy to vs
        :param ns_config: Dict of netscaler parsed config
        :param avi_config: Dict of AVI
        :param tmp_pool_ref: List temporary pool reference
        :param redirect_pools: List of pools which are redirect
        :param skip_attrs: list of skipped attribute
        :param na_attrs: List of na attributes
        :param netscalar_command: netscalar command
        :return: Http policy set object
        """

        policy_lables = ns_config.get('bind cs policylabel', {})
        policy_config = ns_config.get('add cs policy', {})
        responder_policy_config = ns_config.get('add responder policy', {})
        rewrite_policy_config = ns_config.get('add rewrite policy', {})
        responder_action_config = ns_config.get('add responder action', {})
        rewrite_action_config = ns_config.get('add rewrite action', {})
        bind_patset = ns_config.get('bind policy patset', {})
        patset_config = ns_config.get('add policy patset', {})
        policy_expression_config = ns_config.get('add policy expression', {})
        http_request_policy = {
            'rules': []
        }
        http_security_policy = {
            'rules': []
        }

        policy_obj = {
            'name': '',
            'tenant_ref': self.tenant_ref,
            'enable': 'false',
        }

        is_policy_obj = False
        rule_index = 0
        vs_policy_name = ''
        for bind_conf in bind_conf_list:
            policy_name = ''
            bind_lb_netscalar_complete_command = \
                ns_util.get_netscalar_full_command(netscalar_command, bind_conf)
            targetVserver = None
            if 'lbvserver' in bind_conf:
                continue
            if 'policylabel' in bind_conf:
                policyLabelName = bind_conf['policylabel']
                if policyLabelName in policy_lables.keys():
                    policyLabels = policy_lables[policyLabelName]
                    if isinstance(policyLabels, dict):
                        policyLabels = [policyLabels]
                    targetVserver = \
                        self.get_targetvserver_policylabel(policyLabels,
                                                           policy_lables)
                    policy_label_netscalar_command = "bind cs policylabel"
                    policy_label_netscalar_full_command = \
                        ns_util.get_netscalar_full_command(
                            policy_label_netscalar_command, policyLabels[0])
                    if targetVserver:
                        # Add status successful in CSV/report for bind if it has
                        # targetVserver
                        ns_util.add_status_row(policyLabels[0]['line_no'],
                                               policy_label_netscalar_command,
                                               policyLabelName,
                                               policy_label_netscalar_full_command,
                                               STATUS_SUCCESSFUL,
                                               policyLabels[0])
                        LOG.info('Conversion successful : %s %s' %
                                 (policy_label_netscalar_command,
                                  policyLabelName))
                    else:
                        # Skipped this bind if it does not have targetVserver
                        skipped_status = 'Skipped: Do not have target vserver' \
                                         ' %s %s' % (
                            policy_label_netscalar_command, policyLabelName)
                        ns_util.add_status_row(policyLabels[0]['line_no'],
                                               policy_label_netscalar_command,
                                               policyLabelName,
                                               policy_label_netscalar_full_command,
                                               STATUS_SKIPPED, skipped_status)
                        LOG.warning(skipped_status)
            if 'policyName' in bind_conf:
                policy_name = bind_conf['policyName']
            elif netscalar_command == 'bind lb vserver':
                continue
            else:
                skipped_status = 'Skipped:Policy Name attribute not present %s'\
                                 % bind_lb_netscalar_complete_command
                LOG.warning(skipped_status)
                # Skipped this bind if it does not attach any policy
                ns_util.add_status_row(bind_conf['line_no'], netscalar_command,
                                       bind_conf['attrs'][0],
                                       bind_lb_netscalar_complete_command,
                                       STATUS_SKIPPED, skipped_status)
                continue
            targetLBVserver = bind_conf.get('targetLBVserver', )
            if not targetLBVserver and targetVserver:
                targetLBVserver = targetVserver

            priority_index = int(bind_conf.get('priority', rule_index))
            policy, policy_type = \
                self.get_policy_from_policy_name(policy_name, policy_config,
                                                 rewrite_policy_config,
                                                 responder_policy_config)

            if not policy or not type:
                skipped_status = 'Skipped: Policy is not created %s' \
                                 % bind_lb_netscalar_complete_command
                if not policy_type:
                    skipped_status = 'Skipped: Policy not supported %s' \
                                 % bind_lb_netscalar_complete_command
                LOG.warning(skipped_status)
                # Skipped this bind if it does not have policy
                ns_util.add_status_row(bind_conf['line_no'], netscalar_command,
                                       bind_conf['attrs'][0],
                                       bind_lb_netscalar_complete_command,
                                       STATUS_SKIPPED, skipped_status)
                continue
            rule, rule_index = self.rule_converter(policy, policy_type,
                                                   priority_index,
                                                   redirect_pools, bind_patset,
                                                   patset_config,
                                                   rewrite_action_config,
                                                   responder_action_config,
                                                   policy_expression_config,
                                                   avi_config, tmp_pool_ref,
                                                   targetLBVserver,
                                                   case_sensitive)
            conv_status = ns_util.get_conv_status(
                bind_conf, self.bind_skipped, self.na_attrs, [],
                ignore_for_val=self.ignore_vals)
            # TODO add support for || rules as datascript
            if rule == STATUS_DATASCRIPT:
                # Add status datascript in CSV/report if policy has status
                # datascript
                datascript_status = 'Datascript: %s' % \
                                    bind_lb_netscalar_complete_command
                ns_util.add_status_row(bind_conf['line_no'], netscalar_command,
                                        bind_conf['attrs'][0],
                                        bind_lb_netscalar_complete_command,
                                        STATUS_DATASCRIPT)
                LOG.warning(datascript_status)
                continue

            if rule and policy_type in ['cs', 'rewrite', 'responder']:
                # Add status successful in CSV/report if policy is converted
                # successfully in to AVI
                ns_util.add_conv_status(bind_conf['line_no'], netscalar_command,
                                       bind_conf['attrs'][0],
                                       bind_lb_netscalar_complete_command,
                                        conv_status, rule)
                http_request_policy['rules'].append(rule)
                vs_policy_name += policy_name
            elif rule and policy_type in ['policy_expression']:
                # Add status successful in CSV/report if policy is converted
                # successfully in to AVI
                ns_util.add_conv_status(bind_conf['line_no'], netscalar_command,
                                        bind_conf['attrs'][0],
                                        bind_lb_netscalar_complete_command,
                                        conv_status, rule)
                http_security_policy['rules'].append(rule)
                vs_policy_name += policy_name
            else:
                # Add status Skipped in CSV/report if policy is converted in to
                #  AVI
                skipped_status = 'Skipped:  Policy not supported %s' \
                                 % bind_lb_netscalar_complete_command
                LOG.warning(skipped_status)
                ns_util.add_status_row(bind_conf['line_no'], netscalar_command,
                                       bind_conf['attrs'][0],
                                       bind_lb_netscalar_complete_command,
                                       STATUS_SKIPPED, skipped_status)
                continue
        if len(http_request_policy['rules']) > 0:
            is_policy_obj = True
            policy_obj['http_request_policy'] = http_request_policy
        elif len(http_security_policy['rules']) > 0:
            policy_obj['http_request_policy'] = http_security_policy
            is_policy_obj = True
        if is_policy_obj:
            policy_obj['name'] = vs_policy_name
            return policy_obj


    def get_targetvserver_policylabel(self, policyLabel, policy_lables,
                                      depth=100):
        """
        This functions defines that return the target vserver ref from
        policylabel with max depth is 100 for recursion
        :param policyLabel: name policy label
        :param policy_lables: dict of add cs policy label
        :param depth: recursion  loop depth
        :return: return target vserver ref
        """

        if depth == 0:
            return None

        target_vserver = [x['targetVserver'] for x in policyLabel
                          if 'targetVserver' in x]
        if target_vserver:
            return target_vserver[0]
        else:
            policy_label = [x['invoke'] for x in policyLabel if x in 'invoke']
            if policy_label and policy_label[0] in policy_lables.keys():
                policyLabelName = policy_label[0]
                policyLabels = policy_lables[policyLabelName]
                if isinstance(policyLabels, dict):
                    policyLabels = [policyLabels]
                self.get_targetvserver_policylabel(self, policyLabels,
                                                   policy_lables,
                                                   depth=depth-1)


    def rule_converter(self, policy, policy_type, priority_index,
                       redirect_pools, bind_patset, patset_config,
                       rewrite_action_config, responder_action_config,
                       policy_expression_config, avi_config, tmp_pool_ref,
                       targetLBVserver=None, case_sensitive=True):
        """
        This function defines to convert netscalar rule to http policy rule
        :param policy: Object of policy
        :param policy_type: Type of policy(CS, Rewrite, Responder,
        policy expression)
        :param redirect_pools: List of rediredt pools
        :param bind_patset: dict of bind patset netscalar command
        :param patset_config: dict of patset config
        :param rewrite_action_config: dict of rewrite action
        :param avi_config: dict of AVI
        :param targetLBVserver: name tarhet lb vserver
        :return:  http policy rule
        """

        netscalar_command = None
        rule_name = policy['attrs'][0]
        ns_rule = policy.get('rule', None)
        if policy_type == 'cs':
            netscalar_command = 'add cs policy'
        elif policy_type == 'rewrite':
            netscalar_command = 'add rewrite policy'
        elif policy_type == 'responder':
            netscalar_command = 'add responder policy'
        elif policy_type == 'expression':
            netscalar_command = 'add expression policy'
        ns_policy_complete_cmd = \
            ns_util.get_netscalar_full_command(netscalar_command, policy)

        if policy_type == 'cs' and not (targetLBVserver and ns_rule):
            skipped_status = 'Skipped policy Does not have ' \
                             'rules or target lb vserver: %s' % rule_name
            LOG.warning(skipped_status)
            # Skipped this policy if rule is not supported by tool
            ns_util.add_status_row(policy['line_no'], netscalar_command,
                                   rule_name, ns_policy_complete_cmd,
                                   STATUS_SKIPPED, skipped_status)
            return None, priority_index
        elif policy_type in ['rewrite', 'responder', 'expression']:

            ns_rule = policy['attrs'][1]

        name = '%s-rule-%s' % (rule_name, priority_index)
        # TODO add support for || rules as datascript
        if '||' in ns_rule:
            skipped_status = 'Datascript: %s ' % ns_policy_complete_cmd
            LOG.warning(skipped_status)
            ns_util.add_status_row(policy['line_no'], netscalar_command,
                                   rule_name, ns_policy_complete_cmd,
                                   STATUS_DATASCRIPT)
            return STATUS_DATASCRIPT, priority_index


        conditional_rules = ns_rule.split("&&")
        match = {}
        for rule in conditional_rules:
            exression_policy = policy_expression_config.get(rule.strip(), None)
            if exression_policy:
                rule = exression_policy['attrs'][1]
                LOG.error('Policy expression : %s' % rule)
            rule_match = self.query_converter(rule, name, bind_patset,
                                              patset_config, avi_config,
                                              case_sensitive)
            if rule_match:
                match.update(rule_match)

        if not match:
            skipped_status = 'Skipped:Rule not supported: %s' % rule_name
            LOG.warning(skipped_status)
            # Skipped this policy if rule is not supported by tool
            ns_util.add_status_row(policy['line_no'], netscalar_command,
                                   rule_name, ns_policy_complete_cmd,
                                   STATUS_SKIPPED, skipped_status)
            return None, priority_index

        policy_rules = {
            'name': name,
            "index": priority_index,
            'match': match,
        }

        if policy_type == 'cs':
            cs_action, redirect_uri = self.get_cs_policy_action(
                name, targetLBVserver, redirect_pools, avi_config, tmp_pool_ref)
            if cs_action:
                if redirect_uri:
                    policy_rules['redirect_action'] = cs_action
                    ns_util.update_status_target_lb_vs_to_indirect(
                        targetLBVserver)
                else:
                    policy_rules['switching_action'] = cs_action
                LOG.info('Conversion successful : %s %s' % (netscalar_command,
                                                            rule_name))
                # Add status successful in CSV/report if rule is supported by
                # tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_SUCCESSFUL, policy_rules)
            else:
                skipped_status = 'Skipped:PoolGroup not found : %s %s %s ' \
                                 '-PoolGroup' % (netscalar_command,
                                                 rule_name, targetLBVserver)
                LOG.warning(skipped_status)
                # Skipped this policy if rule is not supported by tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_SKIPPED, skipped_status)
                policy_rules = None
        elif policy_type == 'rewrite':
            policy_rules = self.get_rewrite_action(policy['attrs'][2],
                                                   policy_rules,
                                                   rewrite_action_config)
            if policy_rules:
                LOG.info('Conversion successful : %s %s' % (netscalar_command,
                                                            rule_name))
                # Add status successful in CSV/report if rule is supported by
                # tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_SUCCESSFUL, policy_rules)
            else:
                skipped_status = 'Skipped:Rules are not supported: %s %s' \
                                 % (netscalar_command, rule_name)
                LOG.warning(skipped_status)
                # Skipped this policy if rule is not supported by tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_SKIPPED, skipped_status)
        elif policy_type == 'responder':
            policy_rules = self.get_responder_action(policy['attrs'][2],
                                                     policy_rules,
                                                     responder_action_config)
            if policy_rules:
                LOG.info('Conversion successful : %s %s' % (
                    netscalar_command, rule_name))
                # Add status successful in CSV/report if rule is supported by
                # tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_SUCCESSFUL, policy_rules)
            else:
                LOG.warning('Datascript : %s %s' % (netscalar_command,
                                                    rule_name))
                # Skipped this policy if rule is not supported by tool
                ns_util.add_status_row(policy['line_no'], netscalar_command,
                                       rule_name, ns_policy_complete_cmd,
                                       STATUS_DATASCRIPT)
        else:
            policy_rules = None

        if policy_rules:
            priority_index = priority_index + 1
        return policy_rules, priority_index


    def query_converter(self, rule, policy_name, bind_patset, patset_config,
                        avi_config, case_sensitive):
        """
        this function defines that convert netscalar rule to http policy match
        :param rule: netscalar rule
        :param policy_name: name of policy
        :param bind_patset: dict of bind patset
        :param patset_config: dict of patset config
        :param avi_config: dict of AVI
        :return: http policy match
        """

        query = rule.strip('"')
        query = query.strip()
        match = None
        path_query = {
            "match_str": [],
            "match_criteria": ''
        }
        if case_sensitive:
            path_query['match_case'] = 'INSENSITIVE'
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

        if 'REQ.HTTP.URL ==' in query.upper():
            match = {"query": path_query}
            match["query"]["match_criteria"] = "EQUALS"
            matches = query.split('||')
            matches = list(set(matches))
            for element in matches:
                element = element.split('==')
                if len(element) > 1:
                    match["query"]["match_str"].append(element)
            if not match["query"]["match_str"]:
                LOG.warning('No Matches found for %s' % query)
                return None
        elif 'URL ==' in query.upper():
            a, b = query.split("==")
            b = b.strip()
            match_str = b.strip("\\'")
            if not match_str:
                LOG.warning('No Matches found for %s' % query)
                return None
            match = {"path": path_query}
            match["path"]["match_str"].append(match_str)
            match["path"]["match_criteria"] = "EQUALS"

        elif 'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' in query.upper() or \
                        'HTTP.REQ.URL.QUERY.CONTAINS' in query.upper() or \
                        'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper() or \
                        'HTTP.REQ.URL.STARTSWITH' in query.upper():
            match = {"query": path_query}
            match["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                if 'HTTP.REQ.URL.PATH.STARTSWITH' in query.upper() or \
                                'HTTP.REQ.URL.STARTSWITH' in query.upper() or \
                                'HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS' \
                                in query.upper():
                    element = re.sub('[\\\/]', '', element)
                    match["query"]["match_str"].append(element)

        elif 'REQ.IP.SOURCEIP' in query.upper():
            match = {"client_ip": client_ip}
            matches = re.findall('\REQ.IP.SOURCEIP == [0-9.]+', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                a, b = element.split("==")
                match["client_ip"]["addrs"].append(
                    {"type": 'V4', "addr": b.strip()})

        elif 'CLIENT.IP.SRC.EQ' in query.upper() or \
                        'CLIENT.IP.SRC.NE' in query.upper():
            match = {"client_ip": client_ip}
            if 'CLIENT.IP.SRC.NE' in query.upper():
                match['client_ip']['match_criteria'] = 'IS_NOT_IN'
            matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                match["client_ip"]["addrs"].append(
                    {"type": 'V4', "addr": element})

        elif ('HTTP.REQ.HEADER' in query.upper() and \
                          '.CONTAINS' in query.upper()) or \
                        'HTTP.REQ.FULL_HEADER.CONTAINS' in query.upper():
            match = {"hdrs": [header]}
            match["hdrs"][0]["match_criteria"] = "HDR_CONTAINS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) < 2 or matches[0] is None or matches[1] is None:
                LOG.warning('No Matches found for %s' % query)
                return None
            match["hdrs"][0]["hdr"] = matches[0]
            match["hdrs"][0]["value"].append(matches[1])

        elif 'HTTP.REQ.HEADER' in query.upper() and ".EXISTS" in query.upper():
            header_copy = copy.deepcopy(header)
            header_copy.pop("match_case")
            header_copy.pop("value")
            match = {"hdrs": [header]}
            match["hdrs"][0]["match_criteria"] = "HDR_EXISTS"
            matches = re.findall('\\\\(.+?)\\\\', query)
            if matches[0] is None:
                LOG.warning('No Matches found for %s' % query)
                return None
            match["hdrs"][0]["hdr"] = matches[0]

        elif ('HTTP.REQ.HOSTNAME.EQ' in query.upper()) or \
                ('HTTP.REQ.HOSTNAME.SET_TEXT_MODE' in query.upper() and
                 'EQ' in query.upper()):
            match = {"host_hdr": host_header}
            match["host_hdr"]["match_criteria"] = "HDR_EQUALS"
            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["host_hdr"]["value"].append(element)

        elif ('HTTP.REQ.COOKIE' in query.upper() and 'CONTAINS' in query.upper()) \
                or ('HTTP.REQ.COOKIE' in query.upper() and 'EQ(' in query.upper()):
            match = {"cookie": cookie}
            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) != 2:
                LOG.warning('No Matches found for %s' % query)
                return None
            if 'HTTP.REQ.COOKIE' in query.upper() and 'CONTAINS' in query.upper():
                match["cookie"]["match_criteria"] = "HDR_CONTAINS"
            elif 'HTTP.REQ.COOKIE' in query.upper() and 'EQ' in query.upper():
                match["cookie"]["match_criteria"] = "HDR_EQUALS"
            match["cookie"]["value"] = matches[1]
            match["cookie"]["name"] = matches[0]

        elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and \
                        'REGEX_MATCH' in query.upper():
            match = {"path": path_regex}
            match["path"]["match_criteria"] = "REGEX_MATCH"
            exact_match = re.search(r'\((\d+?)\)', query).group(1)
            matches = re.findall('\(re(.*?)\)', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            regex_match = []
            for element in matches:
                regex = '.*/'
                if int(exact_match) == 1:
                    regex = '^%s://.*' % element
                elif int(exact_match) > 1:
                    for index in range(int(exact_match), 2, -1):
                        regex += '/\w+'
                    regex += '/%s' % element + '.*'
                else:
                    LOG.warning("%s Rule GET for regex match is not supported" %
                                query)
                    continue
                regex_match.append(regex)
            string_group_ref = self.add_string_group_for_policy(
                '%s-string_group_object' % policy_name, regex_match, avi_config)
            match["path"]["string_group_refs"].append(string_group_ref)

        elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQ(' in query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "EQUALS"
            match["path"]["match_str"] = []
            exact_match = re.search(r'\((\d+?)\)', query).group(1)
            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            for element in matches:
                regex = '.*/'
                element = re.sub('[\\\/]', '', element)
                if int(exact_match) == 1:
                    regex = '^%s://.*' % element
                elif int(exact_match) > 1:
                    if int(exact_match) == 1:
                        regex = '^%s://.*' % element
                    elif int(exact_match) > 1:
                        for index in range(int(exact_match), 2, -1):
                            regex += '/\w+'
                        regex += '/%s' % element + '.*'
                else:
                    LOG.warning("%s Rule GET for Equal match is not supported" %
                                query)
                    continue
                match["path"]["match_str"].append(regex)

        elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQUALS_ANY(' in \
                query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "EQUALS"
            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            patsets = []
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                patset = self.get_patset_collection(element, bind_patset,
                                                    patset_config)
                if patset:
                    patsets += patset
            match["path"]["match_str"] = list(set(patsets))

        elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'CONTAINS(' in \
                query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "CONTAINS"
            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["path"]["match_str"].append(element)

        elif 'HTTP.REQ.URL.PATH.CONTAINS' in query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "CONTAINS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["path"]["match_str"].append(element)

        elif 'HTTP.REQ.URL.PATH.EQ' in query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "EQUALS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["path"]["match_str"].append(element)

        elif 'HTTP.REQ.URL.PATH' in query.upper():
            match = {"path": path_query}
            match["path"]["match_criteria"] = "EQUALS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["path"]["match_str"].append(element)

        elif 'HTTP.REQ.URL.EQ' in query.upper():
            match = {"query": path_query}
            match["query"]["match_criteria"] = "QUERY_MATCH_CONTAINS"

            matches = re.findall('\\\\(.+?)\\\\', query)
            if len(matches) == 0:
                LOG.warning('No Matches found for %s' % query)
                return None
            matches = list(set(matches))
            for element in matches:
                element = re.sub('[\\\/]', '', element)
                match["query"]["match_str"].append(element)

        else:
            LOG.warning("%s Rule is not supported" % query)
            return None
        if match:
            return match


    def add_string_group_for_policy(self, string_group_name, matches,
                                    avi_config):
        """
        This function defines that to convert netscalar string to string group
        onject
        :param string_group_name: Name of string group onject
        :param matches: List of match string
        :param avi_config: dict of AVI
        :return: StringGroup object
        """

        if not matches:
            return None
        stringgroup_object = {
            "name": string_group_name,
            "kv": [],
            "tenant_ref": self.tenant_ref
        }

        for match in matches:
            stringgroup_object['kv'].append({"key": match})
        avi_config['StringGroup'].append(stringgroup_object)
        LOG.info('Conversion successful : %s' % string_group_name)
        return string_group_name


    def get_patset_collection(self, match, bind_patset, patset_config):
        """
        This function defines that return the list of patset attribute
        :param match: list of match
        :param bind_patset: dict of bind patset
        :param patset_config: dict patset config
        :return: patset attributes
        """

        if match in patset_config and match in bind_patset:
            patsets = bind_patset[match]
            patset_attrs = []
            for patset in patsets:
                attrs = [x for x in patset['attrs'] if x != match]
                patset_attrs += attrs
            if patset_attrs:
                return patset_attrs

        LOG.warning("%s Patset policy is not supported" % match)

    def get_cs_policy_action(self, name, targetLBVserver, redirect_pools,
                             avi_config, tmp_pool_ref):
        """
        This function defines that return the http request policy action
        :param targetLBVserver: name of terget lb vserver
        :param redirect_pools: list of redirect pools
        :param avi_config: dict of AVI
        :return: http policy action
        """

        if targetLBVserver in redirect_pools:
            action = {
                'protocol': 'HTTP',
                'host': {
                    'type': 'URI_PARAM_TYPE_TOKENIZED',
                    'tokens': [{
                        'type': 'URI_TOKEN_TYPE_HOST',
                        'str_value': redirect_pools[targetLBVserver],
                        'start_index': '1',
                        'end_index': '65535'
                    }]
                }
            }

            return action, True

        else:
            pool_group_ref = targetLBVserver + '-poolgroup'
            pool_group_ref = re.sub('[:]', '-', pool_group_ref)
            pool_group = [pg for pg in avi_config['PoolGroup']
                          if pg['name'] == pool_group_ref]
            if pool_group and pool_group_ref in tmp_pool_ref:
                pool_group_ref = ns_util.clone_pool_group(pool_group_ref, name,
                                                          avi_config,
                                                          self.tenant_name,
                                                          self.cloud_name)

            updated_pool_group_ref = \
                ns_util.get_object_ref(pool_group_ref, OBJECT_TYPE_POOL_GROUP,
                                       self.tenant_name, self.cloud_name)
            action = {
                'action': 'HTTP_SWITCHING_SELECT_POOLGROUP',
                'status_code': 200,
                'pool_group_ref': updated_pool_group_ref
            }
            if not pool_group:
                action = None
            else:
                tmp_pool_ref.append(pool_group_ref)

            return action, False


    def get_rewrite_action(self, policy_name, policy_rules,
                           rewrite_action_config):
        """
        This functions defines that return rewrite policy action
        :param policy_name: name of policy
        :param policy_rules: rules of policy
        :param rewrite_action_config: dict of rewrite action
        :return: rewrite policy action
        """

        policy_action = rewrite_action_config.get(policy_name, None)
        policy_rule = None
        ns_action_command = 'add rewrite action'
        if not policy_action:
            LOG.warning('No responder action found: %s' % policy_name)
            return
        ns_action_complete_command = \
            ns_util.get_netscalar_full_command(ns_action_command, policy_action)

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
                    LOG.info('Conversion successful: %s %s' % (
                        ns_action_command, policy_name))
                    # Add status successful in CSV/report for policy action
                    ns_util.add_status_row(policy_action['line_no'],
                                           ns_action_command, policy_name,
                                           ns_action_complete_command,
                                           STATUS_SUCCESSFUL, policy_rule)

        elif policy_action and policy_action['attrs'][1] == 'replace':
            policy_rule = copy.deepcopy(policy_rules)
            path_matches = \
                re.findall('\\\\(.+?)\\\\',
                           policy_action['attrs'][3].strip('"').strip())
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
            LOG.info('Conversion successful: %s %s' % (ns_action_command,
                                                       policy_name))
            # Add status successful in CSV/report for policy action
            ns_util.add_status_row(policy_action['line_no'], ns_action_command,
                                   policy_name, ns_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)

        elif policy_action and policy_action['attrs'][1] == 'insert_before':
            policy_rule = copy.deepcopy(policy_rules)
            path_matches = re.findall('\\\\(.+?)\\\\',
                                      policy_action['attrs'][3])
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
            LOG.info('Conversion successful: %s %s' % (ns_action_command,
                                                       policy_name))
            # Add status successful in CSV/report for policy action
            ns_util.add_status_row(policy_action['line_no'], ns_action_command,
                                   policy_name, ns_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)
        else:
            skipped_status = 'Skipped:Policy action not supported: %s %s' \
                             % (ns_action_command, policy_name)
            LOG.warning(skipped_status)
            # Add status Skipped in CSV/report for policy action if rule is not
            # supported by tool
            ns_util.add_status_row(policy_action['line_no'], ns_action_command,
                                   policy_name, ns_action_complete_command,
                                   STATUS_SKIPPED, skipped_status)

        return policy_rule


    def get_responder_action(self, policy_name, policy_rules,
                             responder_action_config):
        """
        This functions defines that return responder policy action
        :param policy_name: name of policy
        :param policy_rules: rules of policy
        :param rewrite_action_config: dict of rewrite action
        :return: responder policy action
        """

        policy_action = responder_action_config.get(policy_name, None)
        if not policy_action:
            LOG.warning('No responder action found: %s' % policy_name)
            return

        policy_rule = None
        ns_responder_action_command = 'add responder action'
        ns_responder_action_complete_command = \
            ns_util.get_netscalar_full_command(ns_responder_action_command,
                                               policy_action)

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
            LOG.info('Conversion successful: %s %s' %
                     (ns_responder_action_command, policy_name))
            # Add successful status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)

        elif policy_action and policy_action['attrs'][1] == 'replace':
            policy_rule = copy.deepcopy(policy_rules)
            path_matches = \
                re.findall('\\\\(.+?)\\\\',
                           policy_action['attrs'][3].strip('"').strip())
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
            LOG.info('Conversion successful: %s %s' %
                     (ns_responder_action_command, policy_name))
            # Add successful status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)

        elif policy_action and policy_action['attrs'][1] == 'insert_before':
            policy_rule = copy.deepcopy(policy_rules)
            path_matches = re.findall('\\\\(.+?)\\\\',
                                      policy_action['attrs'][3])
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
            LOG.info('Conversion successful: %s %s' %
                     (ns_responder_action_command, policy_name))
            # Add successful status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)
        elif policy_action and policy_action['attrs'][1] == 'redirect':
            policy_rule = copy.deepcopy(policy_rules)
            path_matches = \
                re.findall('\\\\(.+?)\\\\',
                           policy_action['attrs'][2].strip('"').strip())
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
            LOG.info('Conversion successful: %s %s' %
                     (ns_responder_action_command, policy_name))
            # Add successful status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)
        elif policy_action and policy_action['attrs'][1] == 'respondwith':
            policy_rule = copy.deepcopy(policy_rules)
            attrs = policy_action['attrs'][2].split(' ')
            if attrs[0].startswith('q{'):
                return
            if attrs[1] == '301':
                redirect_action = {
                    'port': 80,
                    'protocol': 'HTTP',
                    'status_code': 'HTTP_REDIRECT_STATUS_CODE_301',
                    'keep_query': False,

                    'path': {
                        'type': 'URI_PARAM_TYPE_TOKENIZED',
                        'tokens': [{
                            'type': 'URI_TOKEN_TYPE_STRING',
                            'str_value': attrs[4]
                        }]
                    },
                    'query': {
                        'keep_query': False
                    }
                }
                policy_rule['redirect_action'] = redirect_action
            elif policy_action['attrs'][3] in ['403', '429', '200', '404']:
                switching_action ={
                    'action': 'HTTP_SWITCHING_SELECT_LOCAL',
                    'status_code': 'HTTP_LOCAL_RESPONSE_STATUS_CODE_' +
                                   policy_action['attrs'][3]
                }
                policy_rule['switching_action'] = switching_action

            else:
                LOG.warning('Datascript: %s %s' % (ns_responder_action_command,
                                                   policy_name))
                # Add Datascript status for responder action
                ns_util.add_status_row(policy_action['line_no'],
                                       ns_responder_action_command, policy_name,
                                       ns_responder_action_complete_command,
                                       STATUS_DATASCRIPT)
            LOG.info('Conversion successful: %s %s' %
                     (ns_responder_action_command, policy_name))
            # Add successful status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_SUCCESSFUL, policy_rule)
        else:
            LOG.warning('Datascript: %s %s' % (ns_responder_action_command,
                                               policy_name))
            # Add Datascript status for responder action
            ns_util.add_status_row(policy_action['line_no'],
                                   ns_responder_action_command, policy_name,
                                   ns_responder_action_complete_command,
                                   STATUS_DATASCRIPT)

        return policy_rule


    def get_policy_from_policy_name(self, policy_name, policy_config,
                                    rewrite_policy_config,
                                    responder_policy_config):
        """

        :param policy_name: name of policy
        :param policy_config: dict cs policy config
        :param rewrite_policy_config: dict of rewrite policy
        :param responder_policy_config: dict of responder policy
        :return: Policy and policy type
        """

        cs_policy = policy_config.get(policy_name, None)
        if cs_policy:
            return cs_policy, 'cs'
        rewrite_policy = rewrite_policy_config.get(policy_name, None)
        if rewrite_policy:
            return rewrite_policy, 'rewrite'
        responder_policy = responder_policy_config.get(policy_name, None)
        if responder_policy:
            return responder_policy, 'responder'
        return None, None


