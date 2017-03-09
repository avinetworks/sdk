import logging
import copy
import re
import avi.netscaler_converter.ns_constants as ns_constants

from avi.netscaler_converter import ns_util
from avi.netscaler_converter.lbvs_converter import (redirect_pools,
                                                    used_pool_group_ref)
from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED,
                                                  OBJECT_TYPE_APPLICATION_PROFILE,
                                                  OBJECT_TYPE_SSL_PROFILE,
                                                  OBJECT_TYPE_HTTP_POLICY_SET,
                                                  OBJECT_TYPE_POOL_GROUP,
                                                  OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                                  OBJECT_TYPE_PKI_PROFILE,
                                                  OBJECT_TYPE_NETWORK_PROFILE)
from avi.netscaler_converter.policy_converter import PolicyConverter

LOG = logging.getLogger(__name__)

tmp_used_pool_group_ref = used_pool_group_ref
tmp_policy_ref = []


class CsvsConverter(object):


    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref):
        self.csvs_skip_attrs = \
            ns_constants.netscalar_command_status['csvs_skip_attrs']
        self.csvs_na_attrs = \
            ns_constants.netscalar_command_status['csvs_na_attrs']
        self.csvs_bind_skipped = \
            ns_constants.netscalar_command_status['csvs_bind_skipped']
        self.csvs_supported_types = \
            ns_constants.netscalar_command_status['csvs_supported_types']
        self.csvs_ignore_vals = \
            ns_constants.netscalar_command_status['csvs_ignore_vals']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref

    def convert(self, ns_config, avi_config, vs_state):
        """
        This function defines that it convert netscalar cs vs config to vs
        config of AVI
        :param ns_config: It is dict of all netscalar commands which are
        supported by AVI
        :param avi_config: It is dict of AVI output config
        :param vs_state: state of vs
        :return: None
        """
        policy_converter = PolicyConverter(self.tenant_name, self.cloud_name,
                                           self.tenant_ref, self.cloud_ref,
                                           self.csvs_bind_skipped,
                                           self.csvs_na_attrs,
                                           self.csvs_ignore_vals)
        cs_vs_conf = ns_config.get('add cs vserver', {})
        bindings = ns_config.get('bind cs vserver', {})
        lbvs_avi_conf = avi_config['VirtualService']
        lb_vs_mapped = []
        cs_vs_list = []
        avi_config['StringGroup'] = []
        avi_config['VirtualService'] = ns_util.remove_duplicate_objects(
            'VirtualService', avi_config['VirtualService'])
        for cs_vs_index, key in enumerate(cs_vs_conf):
            LOG.debug("Context Switch VS conversion started for: %s" % key)
            lbvs_bindings = []
            cs_vs = cs_vs_conf[key]
            ns_add_cs_vserver_command = 'add cs vserver'
            ns_add_cs_vserver_complete_command = \
                ns_util.get_netscalar_full_command(ns_add_cs_vserver_command,
                                                   cs_vs)
            # Skipped this CS VS if it has type which are not supported
            if not cs_vs['attrs'][1] in self.csvs_supported_types:
                skipped_status = 'Skipped:Unsupported type %s of Context ' \
                                 'switch VS: %s' %(cs_vs['attrs'][1], key)
                LOG.warning(skipped_status)
                ns_util.add_status_row(cs_vs['line_no'],
                                       ns_add_cs_vserver_command, key,
                                       ns_add_cs_vserver_complete_command,
                                       STATUS_SKIPPED, skipped_status)
                continue
            tt = cs_vs.get('targetType', None)
            if tt and tt == 'GSLB':
                skipped_status = 'Skipped:Unsupported target type %s of ' \
                                 'Context switch VS: %s' % (cs_vs['attrs'][1],
                                                            key)
                LOG.warning(skipped_status)
                # Skipped this CS VS if targetType is GSLB
                ns_util.add_status_row(cs_vs['line_no'],
                                       ns_add_cs_vserver_command,
                                       key, ns_add_cs_vserver_complete_command,
                                       STATUS_SKIPPED, skipped_status)
            vs_name = cs_vs['attrs'][0]
            ip_addr = cs_vs['attrs'][2]
            port = cs_vs['attrs'][3]

            enable_ssl = False
            if vs_state == 'enable':
                enabled = (cs_vs.get('state', 'ENABLED') == 'ENABLED')
            else:
                enabled = False

            if cs_vs['attrs'][1] == 'SSL':
                enable_ssl = True
            updated_vs_name = re.sub('[:]', '-', vs_name)

            # Regex to check Vs has IPV6 address if yes the Skipped
            if re.findall(ns_constants.IPV6_Address, ip_addr):
                skipped_status = "Skipped:IPV6 not Supported %s" \
                                 % ns_add_cs_vserver_command
                LOG.warning(skipped_status)
                ns_util.add_status_row(cs_vs['line_no'],
                                       ns_add_cs_vserver_command,
                                       key, ns_add_cs_vserver_complete_command,
                                       STATUS_SKIPPED,
                                       skipped_status)
                continue

            vs_obj = {
                'name': updated_vs_name,
                'tenant_ref': self.tenant_ref,
                'cloud_ref': self.cloud_ref,
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
                http_prof = \
                    ns_util.get_object_ref(http_prof,
                                           OBJECT_TYPE_APPLICATION_PROFILE,
                                           self.tenant_name)
                vs_obj['application_profile_ref'] = http_prof
                clttimeout = cs_vs.get('cltTimeout', None)
                if clttimeout:
                    ns_util.add_clttimeout_for_http_profile(http_prof,
                                                            avi_config,
                                                            clttimeout)
                    clt_cmd = ns_add_cs_vserver_command + ' cltTimeout %s' % \
                                                          clttimeout
                    LOG.info('Conversion successful : %s' % clt_cmd)
            ntwk_prof = cs_vs.get('tcpProfileName', None)
            if ntwk_prof:
                if ns_util.object_exist('NetworkProfile', ntwk_prof,
                                        avi_config):
                    LOG.info('Conversion successful: Added network profile %s '
                             'for %s' % (ntwk_prof, vs_name))
                    ntwk_prof = \
                        ns_util.get_object_ref(ntwk_prof,
                                               OBJECT_TYPE_NETWORK_PROFILE,
                                               self.tenant_name)

                    vs_obj['network_profile_ref'] = ntwk_prof
                else:
                    vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'
                    LOG.error('Error: Not found Network profile %s for %s' %
                              (ntwk_prof, vs_name))

            if not http_prof and (cs_vs['attrs'][1]).upper() == 'DNS':
                vs_obj['application_profile_ref'] = 'admin:System-DNS'
                vs_obj['network_profile_ref'] = 'admin:System-UDP-Per-Pkt'
            elif not http_prof and (cs_vs['attrs'][1]).upper() == 'UDP':
                vs_obj[
                    'application_profile_ref'] = 'admin:System-L4-Application'
                vs_obj['network_profile_ref'] = 'admin:System-UDP-Fast-Path'
            elif not http_prof and (cs_vs['attrs'][1]).upper() == 'DNS_TCP':
                vs_obj[
                    'application_profile_ref'] = 'admin:System-L4-Application'
                vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'
            bind_conf_list = bindings.get(vs_name, None)
            if not bind_conf_list:
                continue
            if isinstance(bind_conf_list, dict):
                bind_conf_list = [bind_conf_list]
            default_pool_group = None
            policy_name = ''
            lb_vserver_bind_conf = None

            if enable_ssl:
                ssl_mappings = ns_config.get('bind ssl vserver', {})
                ssl_bindings = ssl_mappings.get(key, [])
                if isinstance(ssl_bindings, dict):
                    ssl_bindings = [ssl_bindings]
                for mapping in ssl_bindings:
                    if 'CA' in mapping:
                        pki_ref = mapping['attrs'][0]
                        if [pki_profile for pki_profile in
                            avi_config["PKIProfile"] if
                            pki_profile['name'] == pki_ref]:
                            pki_ref = \
                                ns_util.get_object_ref(pki_ref,
                                                       OBJECT_TYPE_PKI_PROFILE,
                                                       self.tenant_name)

                            app_profile_with_pki_profile = \
                                ns_util.update_application_profile(
                                    http_prof, pki_ref, self.tenant_ref,
                                    vs_name, avi_config)
                            app_profile_with_pki_profile_ref = \
                                ns_util.get_object_ref(
                                    app_profile_with_pki_profile['name'],
                                    OBJECT_TYPE_APPLICATION_PROFILE,
                                    self.tenant_name)
                            vs_obj['application_profile_ref'] = \
                                app_profile_with_pki_profile_ref
                            LOG.info(
                                'Added: %s PKI profile %s' % (pki_ref, key))
                    elif 'certkeyName' in mapping:
                        avi_ssl_ref = 'ssl_key_and_certificate_refs'
                        if [obj for obj in avi_config['SSLKeyAndCertificate']
                            if obj['name'] == mapping['certkeyName']]:
                            updated_ssl_ref = \
                                ns_util.get_object_ref(
                                    mapping['certkeyName'],
                                    OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                    self.tenant_name)
                            vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                        elif not [obj for obj in avi_config['SSLKeyAndCertificate']
                              if obj['name'] == mapping['certkeyName'] +
                                    '-dummy']:
                            updated_ssl_ref = \
                                ns_util.get_object_ref(
                                    mapping['certkeyName'] + '-dummy',
                                    OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                    self.tenant_name)
                            vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                        else:
                            LOG.warning(
                                'Could not find ssl key cert, so adding '
                                'default cert as system default insted')
                            vs_obj[avi_ssl_ref] = [
                                'admin:System-Default-Cert']
                            continue

                        vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                ssl_vs_mapping = ns_config.get('set ssl vserver', {})
                mapping = ssl_vs_mapping.get(key, None)
                ssl_profile_name = re.sub('[:]', '-', key)
                if mapping and [ssl_profile for ssl_profile in
                                avi_config["SSLProfile"] if
                                ssl_profile['name'] == ssl_profile_name]:
                    updated_ssl_profile_ref = \
                        ns_util.get_object_ref(ssl_profile_name,
                                               OBJECT_TYPE_SSL_PROFILE,
                                               self.tenant_name)
                    vs_obj['ssl_profile_name'] = updated_ssl_profile_ref
                    LOG.debug('Added: %s SSL profile %s' % (key, key))

            for bind_conf in bind_conf_list:
                if 'lbvserver' in bind_conf:
                    lbvs_bindings.append(bind_conf['lbvserver'])
                    default_pool_group = bind_conf['lbvserver']
                    lb_vserver_bind_conf = bind_conf

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
            vs_obj.pop('pool_group_ref', None)

            case_sensitive = False \
                if cs_vs.get('caseSensitive', '') == 'OFF' else True

            # Convert netscalar policy to AVI http policy set
            policy = policy_converter.convert(bind_conf_list, ns_config,
                                              avi_config,
                                              tmp_used_pool_group_ref,
                                              redirect_pools,
                                              'bind cs vserver', case_sensitive)

            # TODO move duplicate code for adding policy to vs in ns_util
            # Add the http policy set reference to VS in AVI
            if policy:
                if policy['name'] in tmp_policy_ref:
                    # clone the http policy set if it is referenced to other VS
                    policy = ns_util.clone_http_policy_set(policy,
                                                           updated_vs_name,
                                                           avi_config,
                                                           self.tenant_name,
                                                           self.cloud_name)
                updated_http_policy_ref = \
                    ns_util.get_object_ref(policy['name'],
                                           OBJECT_TYPE_HTTP_POLICY_SET,
                                           self.tenant_name)

                tmp_policy_ref.append(policy['name'])

                http_policies = {
                    'index': 11,
                    'http_policy_set_ref': updated_http_policy_ref
                }
                vs_obj['http_policies'] = []
                vs_obj['http_policies'].append(http_policies)
                avi_config['HTTPPolicySet'].append(policy)

            # Add reference of pool group to VS
            if default_pool_group:
                pool_group_ref = '%s-poolgroup' % default_pool_group
                updated_pool_group_ref = re.sub('[:]', '-', pool_group_ref)
                pools = [pool_group['name'] for pool_group in
                         avi_config['PoolGroup']
                         if pool_group['name'] == updated_pool_group_ref]
                if pools:
                    # clone the pool group if it is referenced to other VS ot
                    # http policy set
                    if updated_pool_group_ref in tmp_used_pool_group_ref:
                        updated_pool_group_ref = \
                            ns_util. clone_pool_group(updated_pool_group_ref,
                                                      vs_name, avi_config,
                                                      self.tenant_name,
                                                      self.cloud_name)
                    avi_pool_group_ref = \
                        ns_util.get_object_ref(updated_pool_group_ref,
                                               OBJECT_TYPE_POOL_GROUP,
                                               self.tenant_name,
                                               self.cloud_name)
                    vs_obj['pool_group_ref'] = avi_pool_group_ref
                    tmp_used_pool_group_ref.append(updated_pool_group_ref)
            if lb_vserver_bind_conf:
                bind_cs_vserver_command = 'bind cs vserver'
                bind_cs_vserver_complete_command = ns_util. \
                    get_netscalar_full_command(bind_cs_vserver_command,
                                               lb_vserver_bind_conf)
                LOG.debug('Conversion successful : %s' %
                          bind_cs_vserver_complete_command)
                conv_status = ns_util.get_conv_status(
                    bind_conf, self.csvs_bind_skipped, [], [])
                ns_util.add_conv_status(lb_vserver_bind_conf['line_no'],
                                        bind_cs_vserver_command,
                                        lb_vserver_bind_conf['attrs'][0],
                                        bind_cs_vserver_complete_command,
                                        conv_status, vs_obj)
            # Verify that this cs vs has share the same VIP of another vs
            # If yes then skipped this cs vs
            is_shared = ns_util.is_shared_same_vip(vs_obj, avi_config)
            if is_shared:
                skipped_status = 'Skipped: %s Same vip shared by another ' \
                                 'virtual service' % vs_name
                LOG.warning(skipped_status)
                ns_util.add_status_row(cs_vs['line_no'],
                                       ns_add_cs_vserver_command, key,
                                       ns_add_cs_vserver_complete_command,
                                       STATUS_SKIPPED, skipped_status)
                continue
            cs_vs_list.append(vs_obj)
            # Add summery of this cs vs in CSV/report
            conv_status = ns_util.get_conv_status(
                cs_vs, self.csvs_skip_attrs, self.csvs_na_attrs, [],
                ignore_for_val=self.csvs_ignore_vals)
            ns_util.add_conv_status(cs_vs['line_no'], ns_add_cs_vserver_command,
                                    key, ns_add_cs_vserver_complete_command,
                                    conv_status, vs_obj)
            LOG.debug("Context Switch VS conversion completed for: %s" % key)

        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list += cs_vs_list
        avi_config['VirtualService'] = vs_list
        ns_util.get_vs_if_shared_vip(avi_config)
        # Update the index value of all policy rules as per their priority
        ns_util.set_rules_index_for_http_policy_set(avi_config)
        ns_util.clean_virtual_service_from_avi_config(avi_config)
