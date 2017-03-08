import logging
import re
import avi.netscaler_converter.ns_constants as ns_constants

from avi.netscaler_converter import ns_util
from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED, STATUS_INDIRECT,
                                                  STATUS_INCOMPLETE_CONFIGURATION,
                                                  OBJECT_TYPE_SSL_PROFILE,
                                                  OBJECT_TYPE_APPLICATION_PROFILE,
                                                  OBJECT_TYPE_HTTP_POLICY_SET,
                                                  OBJECT_TYPE_POOL_GROUP,
                                                  OBJECT_TYPE_NETWORK_PROFILE,
                                                  OBJECT_TYPE_PKI_PROFILE,
                                                  OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                                  OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
                                                  OBJECT_TYPE_POOL)

from avi.netscaler_converter.policy_converter import PolicyConverter

LOG = logging.getLogger(__name__)
redirect_pools = {}
tmp_avi_config = {}
used_pool_group_ref = []


class LbvsConverter(object):


    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref):
        self.lbvs_skip_attrs = \
            ns_constants.netscalar_command_status['lbvs_skip_attrs']
        self.lbvs_na_attrs = \
            ns_constants.netscalar_command_status['lbvs_na_attrs']
        self.lbvs_indirect_list = \
            ns_constants.netscalar_command_status['lbvs_indirect_list']
        self.lbvs_supported_persist_types = \
            ns_constants.netscalar_command_status['lbvs_supported_persist_types']
        self.lbvs_ignore_vals = \
            ns_constants.netscalar_command_status['lbvs_ignore_vals']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
    def convert(self, ns_config, avi_config, vs_state):
        """
        This function defines that it convert netscalar lb vs config to vs
        config of AVI
        :param ns_config: It is dict of all netscalar commands which are
        supported by AVI
        :param avi_config: It is dict of AVI output config
        :param vs_state: state of vs
        :return: None
        """

        lb_vs_conf = ns_config.get('add lb vserver', {})
        bind_lb_vs_config = ns_config.get('bind lb vserver', {})
        avi_config['VirtualService'] = []
        tmp_avi_config['VirtualService'] = []
        avi_config['HTTPPolicySet'] = []
        supported_types = ['HTTP', 'TCP', 'UDP', 'SSL', 'SSL_BRIDGE',
                           'SSL_TCP', 'DNS', 'DNS_TCP']

        policy_converter = PolicyConverter(self.tenant_name, self.cloud_name,
                                           self.tenant_ref, self.cloud_ref,
                                           self.lbvs_skip_attrs,
                                           self.lbvs_na_attrs,
                                           self.lbvs_ignore_vals)
        tmp_policy_ref = []
        for key in lb_vs_conf.keys():
            try:
                LOG.debug('LB VS conversion started for: %s' % key)
                lb_vs = lb_vs_conf[key]
                type = lb_vs['attrs'][1]
                cmd = 'add lb vserver'
                full_cmd = ns_util.get_netscalar_full_command(cmd, lb_vs)
                # Skipped this lb vs if it has type which are not supported
                if type not in supported_types:
                    skipped_status = 'Skipped:Unsupported type %s of LB VS: ' \
                                     '%s' % (type, key)
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                           full_cmd, STATUS_SKIPPED,
                                           skipped_status)
                    continue
                enable_ssl = False
                if type in ['SSL', 'SSL_BRIDGE', 'SSL_TCP']:
                    enable_ssl = True
                vs_name = key
                ip_addr = lb_vs['attrs'][2]
                port = lb_vs['attrs'][3]

                if vs_state == 'enable':
                    enabled = (lb_vs.get('state', 'ENABLED') == 'ENABLED')
                else:
                    enabled = False

                pool_group_name = '%s-poolgroup' % vs_name
                pool_group_name = re.sub('[:]', '-', pool_group_name)
                pool_group = [pool_group for pool_group in
                              avi_config.get("PoolGroup", [])
                              if pool_group['name'] == pool_group_name]
                pool_group_ref = None
                if pool_group:
                    pool_group_ref = pool_group_name
                # else:
                #     # Skipped this lb vs if pool group not found in AVI config
                #     LOG.warning('Pool group not found in avi config for LB VS '
                #                 '%s' % key)
                #     ns_util.add_status_row(lb_vs['line_no'], cmd, key, full_cmd,
                #                            STATUS_INCOMPLETE_CONFIGURATION)
                #     continue

                redirect_url = lb_vs.get('redirectURL', None)

                http_prof = lb_vs.get('httpProfileName', None)
                app_profile = None
                if http_prof:
                    clttimeout = lb_vs.get('cltTimeout', None)
                    app_profile = http_prof
                    if clttimeout:
                        ns_util.add_clttimeout_for_http_profile(http_prof,
                                                                avi_config,
                                                                clttimeout)
                        clt_cmd = cmd + '%s cltTimeout %s' % (key, clttimeout)
                        LOG.info('Conversion successful : %s' % clt_cmd)

                updated_vs_name = re.sub('[:]', '-', vs_name)

                # Regex to check Vs has IPV6 address if yes the Skipped
                if re.findall(ns_constants.IPV6_Address, ip_addr):
                    skipped_status = "Skipped:IPV6 not Supported %s" %full_cmd
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                           full_cmd, STATUS_SKIPPED,
                                           skipped_status)
                    continue
                vs_obj = {
                    'name': updated_vs_name,
                    'type': 'VS_TYPE_NORMAL',
                    'tenant_ref': self.tenant_ref,
                    'cloud_ref': self.cloud_ref,
                    'ip_address': {
                        'addr': ip_addr,
                        'type': 'V4'
                    },
                    'enabled': enabled,
                    'services': [],
                }
                bind_conf_list = bind_lb_vs_config.get(key, None)
                # Skipped this lb vs if it doen not have any bind lb vserver
                if (not bind_conf_list) and (not redirect_url):
                    continue
                if isinstance(bind_conf_list, dict):
                    bind_conf_list = [bind_conf_list]

                policy = None

                if bind_conf_list:
                    # Convert netscalar policy to AVI http policy set
                    policy = policy_converter.convert(bind_conf_list, ns_config,
                                                      avi_config, [],
                                                      redirect_pools,
                                                      'bind lb vserver', True)

                # TODO move duplicate code for adding policy to vs in ns_util
                # Convert netscalar policy to AVI http policy set
                if policy:
                    if policy['name'] in tmp_policy_ref:
                        policy = ns_util.clone_http_policy_set(policy,
                                                               updated_vs_name,
                                                               avi_config,
                                                               self.tenant_name,
                                                               self.cloud_name)
                    tmp_policy_ref.append(policy['name'])
                    updated_http_policy_ref = \
                        ns_util.get_object_ref(policy['name'],
                                               OBJECT_TYPE_HTTP_POLICY_SET,
                                               self.tenant_name)
                    http_policies = {
                        'index': 11,
                        'http_policy_set_ref': updated_http_policy_ref
                    }
                    vs_obj['http_policies'] = []
                    vs_obj['http_policies'].append(http_policies)
                    avi_config['HTTPPolicySet'].append(policy)

                if app_profile:
                    app_profile = \
                        ns_util.get_object_ref(app_profile,
                                               OBJECT_TYPE_APPLICATION_PROFILE,
                                               self.tenant_name)
                    vs_obj['application_profile_ref'] = app_profile
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'DNS':
                    vs_obj['application_profile_ref'] = 'admin:System-DNS'
                    vs_obj['network_profile_ref'] = 'admin:System-UDP-Per-Pkt'
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'UDP':
                    vs_obj[
                        'application_profile_ref'] = \
                        'admin:System-L4-Application'
                    vs_obj['network_profile_ref'] = 'admin:System-UDP-Fast-Path'
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'DNS_TCP':
                    vs_obj[
                        'application_profile_ref'] = \
                        'admin:System-L4-Application'
                    vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'

                if pool_group:
                    # clone the pool group if it is referenced to other
                    # VS ot http policy set
                    if pool_group_ref in used_pool_group_ref:
                        pool_group_ref = \
                            ns_util.clone_pool_group(pool_group_ref, vs_name,
                                                     avi_config,
                                                     self.tenant_name,
                                                     self.cloud_name)
                    pool_group_ref = re.sub('[:]', '-', pool_group_ref)
                    used_pool_group_ref.append(pool_group_ref)
                    updated_pool_group = [pg for pg in
                                          avi_config.get('PoolGroup',
                                                         [])
                                          if pg['name'] == pool_group_ref]

                    vs_obj['pool_group_ref'] = \
                        ns_util.get_object_ref(pool_group_ref,
                                               OBJECT_TYPE_POOL_GROUP,
                                               self.tenant_name,
                                               self.cloud_name)
                    pool_group = updated_pool_group[0]

                backup_server = lb_vs.get('backupVServer', None)
                # Update fail cation of pool as FAIL_ACTION_HTTP_REDIRECT in AVI
                # if lb vs has redirect url
                if redirect_url:
                    fail_action = {
                        "redirect":
                            {
                                "status_code": "HTTP_REDIRECT_STATUS_CODE_302",
                                "host": redirect_url,
                                "protocol": "HTTP"
                            },
                        "type": "FAIL_ACTION_HTTP_REDIRECT"
                    }
                    if pool_group:
                        for member in pool_group['members']:
                            pool_ref = \
                            (member['pool_ref'].split('&')[1].split('=')[1])
                            # pool_ref = ns_util.\
                            #     get_name_from_reference(member['pool_ref'])
                            pool = [pool for pool in avi_config['Pool'] if
                                    pool['name'] == pool_ref]
                            if pool:
                                pool[0]["fail_action"] = fail_action

                elif ip_addr == '0.0.0.0' and not redirect_url \
                        and backup_server:
                    # Add baclup pool of poolgroup if this lb vs has an ip
                    # 0.0.0.0 with backup vserver
                    try:
                        backup_pool_group_ref = backup_server + '-poolgroup'
                        backup_pool_group_ref = re.sub('[:]', '-',
                                                       backup_pool_group_ref)
                        backup_pool_group = [pool_group for pool_group in
                                             avi_config.get("PoolGroup", [])
                                             if pool_group['name'] ==
                                             backup_pool_group_ref]
                        backup_pool_ref = backup_pool_group[0]['members']
                        [0]['pool_ref']
                        backup_pool_ref = \
                            backup_pool_group[0]['members'][0]['pool_ref']. \
                                split('&')[1].split('=')[1]
                        for index, pool_ref in enumerate(pool_group['members']):
                            pool_ref = pool_ref.split('&')[1].split('=')[1]
                            pool = [pool for pool in avi_config['Pool']
                                    if pool['name'] == pool_ref]
                            if pool:
                                new_backup_pool_ref = \
                                    ns_util.clone_pool(backup_pool_ref, index,
                                                       avi_config)
                                new_backup_pool_ref = \
                                    ns_util.get_object_ref(new_backup_pool_ref,
                                                           OBJECT_TYPE_POOL,
                                                           self.tenant_name,
                                                           self.cloud_name)
                                backup_pool = {
                                    'type': 'FAIL_ACTION_BACKUP_POOL',
                                    'backup_pool': {
                                        'backup_pool_uuid': new_backup_pool_ref
                                    }
                                }
                                pool[0]['fail_action'] = backup_pool
                    except Exception as e:
                        # Skipped lb vs if backup pool is found in AVI
                        LOG.error('No Backup pool found: %s' % full_cmd)
                        ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                               full_cmd, STATUS_INDIRECT)
                        continue
                elif ip_addr == "0.0.0.0" and not redirect_url and not \
                        backup_server:
                    # Skipped lb vs if it has ip 0.0.0.0 and does not have
                    # backup pool and redirect url
                    ns_util.add_status_row(lb_vs['line_no'], cmd, key, full_cmd,
                                           STATUS_INDIRECT)
                    LOG.error('%s %s Skipped VS, Service point to %s server '
                              'and not have redirect action and backup vserver'
                              % (cmd, key, ip_addr))
                    continue

                service = {'port': port, 'enable_ssl': enable_ssl}
                if port in ("0", "*"):
                    service['port'] = "1"
                    service['port_range_end'] = "65535"
                vs_obj['services'].append(service)

                persistenceType = lb_vs.get('persistenceType', '')
                if pool_group_ref and persistenceType in \
                        self.lbvs_supported_persist_types:

                    profile_name = '%s-persistance-profile' % vs_name
                    persist_profile = \
                        ns_util.convert_persistance_prof(lb_vs, profile_name,
                                                         self.tenant_ref)
                    avi_config['ApplicationPersistenceProfile'].append(
                        persist_profile)
                    self.update_pool_for_persist(avi_config, pool_group,
                                                 profile_name)
                elif not persistenceType == 'NONE':
                    LOG.warning('Persistance type %s not supported by Avi' %
                             persistenceType)
                ntwk_prof = lb_vs.get('tcpProfileName', None)
                if ntwk_prof:
                    if ns_util.object_exist('NetworkProfile', ntwk_prof,
                                            avi_config):
                        LOG.info('Conversion successful: Added network profile '
                                 '%s for %s' % (ntwk_prof, vs_name))
                        ntwk_prof = \
                            ns_util.get_object_ref(ntwk_prof,
                                                   OBJECT_TYPE_NETWORK_PROFILE,
                                                   self.tenant_name)
                        vs_obj['network_profile_ref'] = ntwk_prof

                if redirect_url and not pool_group:
                    redirect_pools.update({vs_obj['name']: redirect_url})
                    ns_util.create_http_policy_set_for_redirect_url(
                        vs_obj, redirect_url, avi_config, self.tenant_name,
                        self.tenant_ref)
                if redirect_url:
                    avi_config['VirtualService'].append(vs_obj)
                    tmp_avi_config['VirtualService'].append(vs_obj)
                else:
                    # Verify that this lb vs has share the same VIP of another
                    # vs If yes then skipped this lb vs
                    is_shared = ns_util.is_shared_same_vip(vs_obj, avi_config)
                    if is_shared:
                        skipped_status = 'Skipped: %s Same vip shared by ' \
                                         'another virtual service' % vs_name
                        LOG.warning(skipped_status)
                        ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                               full_cmd, STATUS_SKIPPED,
                                               skipped_status)
                        continue
                    avi_config['VirtualService'].append(vs_obj)
                # Add summery of this lb vs in CSV/report
                conv_status = ns_util.get_conv_status(
                    lb_vs, self.lbvs_skip_attrs, self.lbvs_na_attrs,\
                    self.lbvs_indirect_list,
                    ignore_for_val=self.lbvs_ignore_vals)
                ns_util.add_conv_status(lb_vs['line_no'], cmd, key, full_cmd,
                                        conv_status, vs_obj)

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
                                    ns_util.get_object_ref(
                                        pki_ref, OBJECT_TYPE_PKI_PROFILE,
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
                            if [obj for obj in
                                avi_config['SSLKeyAndCertificate']
                                if obj['name'] == mapping['certkeyName']]:
                                updated_ssl_ref = \
                                    ns_util.get_object_ref(
                                        mapping['certkeyName'],
                                        OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                        self.tenant_name)
                                vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                            elif not [obj for obj in
                                  avi_config['SSLKeyAndCertificate']
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

                LOG.debug('LB VS conversion completed for: %s' % key)
            except:
                LOG.error('Error in lb vs conversion for: %s' %
                          key, exc_info=True)


    def update_pool_for_persist(self, avi_config, pool_group, profile_name):
        """
        This function defines that update pool group to add persistent
        profile ref
        :param avi_config: Dict of vi object
        :param pool_group: Object of pool group
        :param profile_name: Name of persistent profile ref
        :return: None
        """

        for pool_ref in pool_group['members']:
            pool_ref = pool_ref['pool_ref'].split('&')[1].split('=')[1]
            pool = [pool for pool in avi_config['Pool'] if
                    pool['name'] == pool_ref]
            if pool:
                pool_obj = pool[0]
                persist_ref_key = "application_persistence_profile_ref"
                persist_ref = \
                    ns_util.get_object_ref(
                        profile_name,
                        OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
                        self.tenant_name)
                pool_obj[persist_ref_key] = persist_ref
