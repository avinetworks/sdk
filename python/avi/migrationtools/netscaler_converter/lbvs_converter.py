import logging
import re
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants
from pkg_resources import parse_version
from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_SKIPPED, STATUS_INDIRECT, STATUS_INCOMPLETE_CONFIGURATION,
            OBJECT_TYPE_SSL_PROFILE, OBJECT_TYPE_APPLICATION_PROFILE,
            OBJECT_TYPE_HTTP_POLICY_SET, OBJECT_TYPE_POOL_GROUP,
            OBJECT_TYPE_NETWORK_PROFILE, OBJECT_TYPE_PKI_PROFILE,
            OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
            OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE, OBJECT_TYPE_POOL)
from avi.migrationtools.netscaler_converter.policy_converter \
    import PolicyConverter
from avi.migrationtools.netscaler_converter.ns_service_converter \
    import app_per_merge_count
from avi.migrationtools.netscaler_converter.monitor_converter \
    import merge_object_mapping
from avi.migrationtools.netscaler_converter.ns_util import NsUtil

LOG = logging.getLogger(__name__)
redirect_pools = {}
tmp_avi_config = {}
used_pool_group_ref = []
# Creating  object for util library.
ns_util = NsUtil()
tmp_policy_ref = []

class LbvsConverter(object):

    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 object_merge_check, controller_version, user_ignore, prefix):
        """
        Construct a new 'LbvsConverter' object.
        :param tenant_name: Name of tenant
        :param cloud_name: Name of cloud
        :param tenant_ref: Tenant reference
        :param cloud_ref: Cloud Reference
        :param object_merge_check: Bool value for object merge
        :param user_ignore: Dict of user ignore attributes
        :param prefix: prefix for objects
        """

        self.lbvs_skip_attrs = \
            ns_constants.netscalar_command_status['lbvs_skip_attrs']
        self.lbvs_na_attrs = \
            ns_constants.netscalar_command_status['lbvs_na_attrs']
        self.lbvs_indirect_list = \
            ns_constants.netscalar_command_status['lbvs_indirect_list']
        self.lbvs_supported_persist_types = \
            ns_constants.netscalar_command_status[
                'lbvs_supported_persist_types']
        self.lbvs_ignore_vals = \
            ns_constants.netscalar_command_status['lbvs_ignore_vals']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
        self.object_merge_check = object_merge_check
        self.controller_version = controller_version
        # List of ignore val attributes for add lbvs netscaler command.
        self.lbvs_user_ignore = user_ignore.get('lbvs', [])
        # Added prefix for objects
        self.prefix = prefix
        # Progressbar count and total size.
        self.progressbar_count = 0
        self.total_size = 0

    def convert(self, ns_config, avi_config, vs_state, sysdict, vs_name_dict,
                vrf=None, segroup=None):

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
        cs_vs_conf = ns_config.get('add cs vserver', {})
        ns_service = ns_config.get('add service', {})
        ns_sg = ns_config.get('add serviceGroup', {})
        avi_config['VirtualService'] = []
        avi_config['Lbvs'] = []
        tmp_avi_config['VirtualService'] = []
        # get the total size of object.
        self.total_size = len(lb_vs_conf) + len(cs_vs_conf)
        avi_config['HTTPPolicySet'] = []
        if parse_version(self.controller_version) >= parse_version('17.1'):
            avi_config['VsVip'] = []
        supported_types = ['HTTP', 'TCP', 'UDP', 'SSL', 'SSL_BRIDGE',
                           'SSL_TCP', 'DNS', 'DNS_TCP']

        policy_converter = PolicyConverter(
            self.tenant_name, self.cloud_name, self.tenant_ref, self.cloud_ref,
            self.lbvs_skip_attrs, self.lbvs_na_attrs, self.lbvs_ignore_vals,
            self.lbvs_user_ignore, self.prefix)

        print "Converting VirtualServices..."
        for key in lb_vs_conf.keys():
            try:
                LOG.debug('LB VS conversion started for: %s' % key)
                # Increment the count
                self.progressbar_count += 1
                lb_vs = lb_vs_conf[key]
                type = lb_vs['attrs'][1]
                cmd = 'add lb vserver'
                full_cmd = ns_util.get_netscalar_full_command(cmd, lb_vs)
                # Skipped this lb vs if it has type which are not supported
                if type not in supported_types:
                    skipped_status = 'Skipped:Unsupported type %s of LB VS: ' \
                                     '%s' % (type, key)
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        lb_vs['line_no'], cmd, key, full_cmd, STATUS_SKIPPED,
                        skipped_status)
                    continue
                # Skipped VS if type is not SSL but persistence is of SSL type
                if type != 'SSL' and lb_vs.get('persistenceType') == \
                  'SSLSESSION':
                    skipped_status = "Skipped:Secure persistence is applicable"\
                                     " only if SSL is enabled for Virtual " \
                                     "Service %s" % key
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        lb_vs['line_no'], cmd, key, full_cmd, STATUS_SKIPPED,
                        skipped_status)
                    continue
                enable_ssl = False
                # removing 'SSL_BRIDGE' 'SSL_TCP' so as to have L4 app profile
                if type in ['SSL']:
                    enable_ssl = True
                vs_name = key
                ip_addr = lb_vs['attrs'][2]
                port = lb_vs['attrs'][3]

                if vs_state == 'enable':
                    enabled = (lb_vs.get('state', 'ENABLED') == 'ENABLED')
                else:
                    enabled = False

                pool_group_name = '%s-poolgroup' % vs_name
                # Added prefix for objects
                if self.prefix:
                    pool_group_name = self.prefix + '-' + pool_group_name
                pool_group_name = re.sub('[:]', '-', pool_group_name)
                pool_group = [pool_group for pool_group in
                              avi_config.get("PoolGroup", [])
                              if pool_group['name'] == pool_group_name]
                pool_group_ref = None
                if pool_group:
                    pool_group_ref = pool_group_name
                redirect_url = lb_vs.get('redirectURL', None)
                backup_server = lb_vs.get('backupVServer', None)
                updated_vs_name = re.sub('[:]', '-', vs_name)
                # Added ns vs dict
                vs_name_dict['lbvs'][updated_vs_name] = vs_name
                # Added prefix for objects
                if self.prefix:
                    updated_vs_name = self.prefix + '-' + updated_vs_name
                # # Regex to check Vs has IPV6 address if yes the Skipped
                # if re.findall(ns_constants.IPV6_Address, ip_addr) or \
                #                 ip_addr == '0.0.0.0':
                #     if redirect_url:
                #         redirect_dict = {updated_vs_name: redirect_url}
                #         avi_config['Lbvs'].append(redirect_dict)
                #     if backup_server:
                #         backup_server_name = {}
                #     skipped_status = "Skipped:Invalid VIP %s" % full_cmd
                #     LOG.warning(skipped_status)
                #     ns_util.add_status_row(
                #         lb_vs['line_no'], cmd, key, full_cmd, STATUS_SKIPPED,
                #         skipped_status)
                #     continue

                # VIP object for virtual service
                vip = {
                    'ip_address': {
                        'addr': ip_addr,
                        'type': 'V4'
                    },
                    'vip_id': 0
                }

                vs_obj = {
                    'name': updated_vs_name,
                    'type': 'VS_TYPE_NORMAL',
                    'tenant_ref': self.tenant_ref,
                    'cloud_ref': self.cloud_ref,
                    'enabled': enabled,
                    'services': [],
                }
                if vrf:
                    vrf_ref = ns_util.get_object_ref(vrf, 'vrfcontext',
                                                     tenant=self.tenant_name,
                                                     cloud_name=self.cloud_name)
                    vs_obj['vrf_ref'] = vrf_ref
                if se_group:
                    se_group_ref = ns_util.get_object_ref(se_group,
                                                    'serviceenginegroup',
                                                    tenant=self.tenant_name,
                                                    cloud_name=self.cloud_name)
                    vs_obj['se_group_ref'] = se_group_ref
                if parse_version(self.controller_version) >= \
                        parse_version('17.1'):
                    vs_obj['vip'] = [vip]
                else:
                    vs_obj['ip_address'] = vip['ip_address']
                bind_conf_list = bind_lb_vs_config.get(key, None)
                # Skipped this lb vs if it do not have any bind lb vserver
                if (not bind_conf_list) and (not redirect_url):
                    continue
                if isinstance(bind_conf_list, dict):
                    bind_conf_list = [bind_conf_list]

                policy = None

                if bind_conf_list:
                    # Convert netscalar policy to AVI http policy set
                    # Sending enable_ssl to policy in order to have protocol
                    # in case it is not provided thru redirect action url
                    policy = policy_converter.convert(
                        bind_conf_list, ns_config, avi_config, [],
                        redirect_pools, 'bind lb vserver', True, enable_ssl)
                # TODO move duplicate code for adding policy to vs in ns_util
                # Convert netscalar policy to AVI http policy set
                if policy:
                    if policy['name'] in tmp_policy_ref:
                        # Cloned the policy if it is already used
                        policy = ns_util.clone_http_policy_set(policy,
                                 updated_vs_name, avi_config, self.tenant_name,
                                 self.cloud_name, used_pool_group_ref,
                                 userprefix=self.prefix)
                    tmp_policy_ref.append(policy['name'])
                    updated_http_policy_ref = ns_util.get_object_ref(
                        policy['name'], OBJECT_TYPE_HTTP_POLICY_SET,
                        self.tenant_name)
                    http_policies = {
                        'index': 11,
                        'http_policy_set_ref': updated_http_policy_ref
                    }
                    vs_obj['http_policies'] = []
                    vs_obj['http_policies'].append(http_policies)
                    avi_config['HTTPPolicySet'].append(policy)
                if pool_group:
                    # clone the pool group if it is referenced to other
                    # VS ot http policy set
                    if pool_group_ref in used_pool_group_ref:
                        pool_group_ref = ns_util.clone_pool_group(
                                            pool_group_ref, vs_name, avi_config,
                                            self.tenant_name, self.cloud_name,
                                            userprefix=self.prefix)
                    pool_group_ref = re.sub('[:]', '-', pool_group_ref)
                    updated_pool_group = [pg for pg in
                                          avi_config.get('PoolGroup', [])
                                          if pg['name'] == pool_group_ref]
                    vs_obj['pool_group_ref'] = ns_util.get_object_ref(
                                        pool_group_ref, OBJECT_TYPE_POOL_GROUP,
                                        self.tenant_name, self.cloud_name)
                    pool_group = updated_pool_group[0]
                http_prof = lb_vs.get('httpProfileName', None)
                persistence_attached = False
                persistence_type = lb_vs.get('persistenceType', '')
                if http_prof:
                    # Added prefix for objects
                    if self.prefix:
                        http_prof = self.prefix + '-' + http_prof
                    # Get the merge application profile name
                    if self.object_merge_check:
                        http_prof = merge_object_mapping['app_profile'].get(
                                    http_prof)
                    if ns_util.object_exist('ApplicationProfile', http_prof,
                       sysdict) or ns_util.object_exist('ApplicationProfile',
                       http_prof, avi_config):
                        LOG.info(
                            'Conversion successful: Added application profile '
                            '%s for %s' % (http_prof, updated_vs_name))
                        http_prof_ref = \
                            ns_util.get_object_ref(http_prof,
                                                   OBJECT_TYPE_APPLICATION_PROFILE,
                                                   self.tenant_name)
                        vs_obj['application_profile_ref'] = http_prof_ref
                        # Added additional attribute like xff_enabled etc to
                        # application profile on basis of service or service
                        # group command
                        addition_attr = {}
                        if bind_conf_list:
                            for bindlist in bind_conf_list:
                                if bindlist.get('attrs') and len(bindlist[
                                  'attrs']) == 2:
                                    ser_conf = ns_service.get(bindlist[
                                                                'attrs'][1])
                                    ser_cmd = 'add service'
                                    if not ser_conf:
                                        ser_conf = ns_sg.get(bindlist[
                                                                'attrs'][1])
                                        ser_cmd = 'add serviceGroup'
                                    command =\
                                        ns_util.get_netscalar_full_command(
                                        ser_cmd, ser_conf) if ser_conf else ''
                                    if 'x-forwarded-for' in command:
                                        addition_attr['xff_enabled'] = True
                                        addition_attr[
                                            'ssl_everywhere_enabled'] = True
                        clttimeout = lb_vs.get('cltTimeout', None)
                        if clttimeout:
                            addition_attr['clttimeout'] = clttimeout
                            clt_cmd = cmd + '%s cltTimeout %s' % (key,
                                                                  clttimeout)
                            LOG.info('Conversion successful : %s' % clt_cmd)
                        ns_util.add_prop_for_http_profile(
                            http_prof, avi_config, sysdict, addition_attr)
                    else:
                        LOG.warning("%s application profile doesn't exist for "
                                    "%s vs" %(http_prof, updated_vs_name))
                ntwk_prof = lb_vs.get('tcpProfileName', None)
                if ntwk_prof:
                    # Added prefix for objects
                    if self.prefix:
                        ntwk_prof = self.prefix + '-' + ntwk_prof
                    # Get the merge network profile name
                    if self.object_merge_check:
                        ntwk_prof = merge_object_mapping['network_profile'].get(
                            ntwk_prof)
                    if ns_util.object_exist('NetworkProfile', ntwk_prof,
                                            sysdict) or ns_util.object_exist(
                        'NetworkProfile',
                        ntwk_prof, avi_config):
                        LOG.info('Conversion successful: Added network profile '
                                 '%s for %s' % (ntwk_prof, updated_vs_name))
                        ntwk_prof_ref = \
                            ns_util.get_object_ref(ntwk_prof,
                                                   OBJECT_TYPE_NETWORK_PROFILE,
                                                   self.tenant_name)
                        vs_obj['network_profile_ref'] = ntwk_prof_ref
                    else:
                        LOG.warning("%s netwrok profile doesn't exist for "
                                    "%s vs" % (ntwk_prof, updated_vs_name))
                if not http_prof and (lb_vs['attrs'][1]).upper() == 'DNS':
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        'System-DNS', 'applicationprofile', tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                        'System-UDP-Per-Pkt', 'networkprofile', tenant='admin')
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'UDP':
                    vs_obj[
                        'application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                        'System-UDP-Fast-Path', 'networkprofile',
                        tenant='admin')
                elif not http_prof and (
                        lb_vs['attrs'][1]).upper() in ['DNS_TCP', 'TCP']:
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                        'System-TCP-Proxy', 'networkprofile', tenant='admin')
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'SSL':
                    # Added Custom Profile with http to https redirect enable
                    ns_migration_profile = ns_util.create_http_to_https_custom_profile()
                    app_name = [app_p for app_p in avi_config[
                        'ApplicationProfile'] if app_p[
                                    'name'] == ns_migration_profile['name']]
                    if not app_name:
                        avi_config['ApplicationProfile'].append(
                            ns_migration_profile)
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        ns_migration_profile['name'], 'applicationprofile',
                        tenant='admin')
                # Adding L4 as a default profile when SSL_BRIDGE and SSL_TCP
                elif not http_prof and (lb_vs['attrs'][1]).upper() \
                        in ['SSL_BRIDGE', "SSL_TCP"]:
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                    LOG.debug("Defaulted to L4 profile for '%s' VS of type %s" %
                              (updated_vs_name, lb_vs['attrs'][1]))
                    # Defaulting to 'client ip' persistence profile
                    if pool_group and persistence_type != 'NONE':
                        persistence_attached = self.update_pool_for_persist(
                                                avi_config, pool_group,
                                                'System-Persistence-Client-IP')
                        LOG.debug("Defaulted to Client IP persistence profile "
                                  "for '%s' Pool group in '%s' VS of type %s" %
                                  (pool_group_ref, updated_vs_name,
                                   lb_vs['attrs'][1]))
                if pool_group_ref and not persistence_attached:
                    if persistence_type in self.lbvs_supported_persist_types:
                        profile_name = '%s-persistance-profile' % vs_name
                        # Added prefix for objects
                        if self.prefix:
                            profile_name = self.prefix + '-' + profile_name
                        persist_profile = ns_util.convert_persistance_prof(
                                           lb_vs, profile_name, self.tenant_ref)
                        persist_profile_name = persist_profile['name']
                        if self.object_merge_check:
                            dup_of = ns_util.update_skip_duplicates(
                                persist_profile,
                                avi_config['ApplicationPersistenceProfile'],
                                'app_persist_profile', merge_object_mapping,
                                persist_profile_name, persistence_type,
                                self.prefix, sysdict[
                                'ApplicationPersistenceProfile'])
                            if dup_of:
                                app_per_merge_count['count'] += 1
                                persist_profile_name = merge_object_mapping[
                                    'app_persist_profile'].get(
                                    persist_profile_name, None)
                            else:
                                avi_config[
                                    'ApplicationPersistenceProfile'].append(
                                    persist_profile)
                        else:
                            avi_config[
                                'ApplicationPersistenceProfile'].append(
                                persist_profile)
                        self.update_pool_for_persist(avi_config, pool_group,
                                                     persist_profile_name)
                    elif not persistence_type == 'NONE':
                        LOG.warning('Persistance type %s not supported by Avi' %
                                    persistence_type)
                # Update fail action of pool as FAIL_ACTION_HTTP_REDIRECT in AVI
                # if lb vs has redirect url
                if redirect_url:
                    fail_action = ns_util.get_redirect_fail_action(redirect_url)
                    if pool_group:
                        pool_group["fail_action"] = fail_action

                backup_configured = False
                if backup_server:

                    # Add backup pool of poolgroup if this lb vs has an ip
                    # backup vserver
                    try:
                        backup_pool_group_ref = backup_server + '-poolgroup'
                        backup_pool_group_ref = re.sub('[:]', '-',
                                                       backup_pool_group_ref)
                        # Added prefix for objects
                        if self.prefix:
                            backup_pool_group_ref = self.prefix + '-' + \
                                                    backup_pool_group_ref
                        backup_pool_group = [
                            pg for pg in avi_config.get("PoolGroup", [])
                            if pg['name'] == backup_pool_group_ref]

                        backup_pool_ref = ns_util.get_name(
                            backup_pool_group[0]['members'][0]['pool_ref']
                        )
                        # Added backupvserver to poolgroup
                        new_backup_pool_ref = ns_util.clone_pool(
                            backup_pool_ref, pool_group['name'], avi_config,
                            userprefix=self.prefix)
                        new_backup_pool_ref = ns_util.get_object_ref(
                            new_backup_pool_ref, OBJECT_TYPE_POOL,
                            self.tenant_name, self.cloud_name)
                        backup_pool = {
                            'type': 'FAIL_ACTION_BACKUP_POOL',
                            'backup_pool': {
                                'backup_pool_ref': new_backup_pool_ref
                            }
                        }
                        pool_group['fail_action'] = backup_pool
                        backup_configured = True
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
                    if pool_group:
                        ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                               full_cmd, STATUS_INDIRECT)
                        LOG.warning(
                            '%s %s Skipped VS, Service point to %s server'
                            ' and not have redirect action and backup '
                            'vserver' % (cmd, key, ip_addr)
                        )
                    else:
                        msg = ('%s %s Skipped VS, Invalid VIP %s and do not '
                               'have service assigned, redirect action and  '
                               'backup vserver' % (cmd, key, ip_addr))
                        ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                               full_cmd, STATUS_SKIPPED,
                                               avi_object=msg)
                        LOG.warning(msg)

                    continue
                # Regex to check Vs has IPV6 address if yes the Skipped
                if re.findall(ns_constants.IPV6_Address, ip_addr) \
                        or ip_addr == '0.0.0.0':
                    # Added condition to handel redirect_url and backupvserver
                    if redirect_url:
                        redirect_dict = {
                            updated_vs_name:
                                {
                                    "redirect_url": redirect_url
                                }
                        }
                        avi_config['Lbvs'].append(redirect_dict)
                    if backup_server:
                        backup_server_name = {
                            updated_vs_name:
                                {
                                    "backupvserver":
                                        pool_group['name']
                                }
                        }
                        avi_config['Lbvs'].append(backup_server_name)
                    vs_conv_status = STATUS_SKIPPED
                    if backup_configured:
                        vs_conv_status = STATUS_INDIRECT
                    skipped_status = "Skipped:Invalid VIP %s" % full_cmd
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        lb_vs['line_no'], cmd, key, full_cmd, vs_conv_status,
                        skipped_status)
                    continue

                service = {'port': port, 'enable_ssl': enable_ssl}
                if port in ("0", "*"):
                    service['port'] = "1"
                    service['port_range_end'] = "65535"
                vs_obj['services'].append(service)
                if redirect_url and not pool_group:
                    redirect_pools.update({vs_obj['name']: redirect_url})
                    ns_util.create_http_policy_set_for_redirect_url(
                        vs_obj, redirect_url, avi_config, self.tenant_name,
                        self.tenant_ref, enable_ssl)
                if redirect_url:
                    if parse_version(self.controller_version) >= parse_version(
                            '17.1'):
                        ns_util.create_update_vsvip(
                            ip_addr, avi_config['VsVip'], self.tenant_ref,
                            self.cloud_ref, prefix=self.prefix)
                        # Added prefix for objects
                        if self.prefix:
                            ip_addr = self.prefix + '-' + ip_addr
                        updated_vsvip_ref = ns_util.get_object_ref(
                            ip_addr + '-vsvip', 'vsvip', self.tenant_name,
                            self.cloud_name)
                        vs_obj['vsvip_ref'] = updated_vsvip_ref
                    tmp_avi_config['VirtualService'].append(vs_obj)
                    # Marked redirect url as status indirect
                    ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                           full_cmd, STATUS_INDIRECT, vs_obj)
                else:
                    # Verify that this lb vs has share the same VIP of another
                    # vs If yes then skipped this lb vs
                    is_shared = ns_util.is_shared_same_vip(
                        vs_obj, avi_config['VirtualService'], avi_config,
                        self.tenant_name, self.cloud_name, self.tenant_ref,
                        self.cloud_ref, self.controller_version, self.prefix)
                    if is_shared:
                        skipped_status = 'Skipped: %s Same vip shared by ' \
                                         'another virtual service' % vs_name
                        LOG.warning(skipped_status)
                        ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                               full_cmd, STATUS_SKIPPED,
                                               skipped_status)
                        continue
                if enable_ssl:
                    ssl_mappings = ns_config.get('bind ssl vserver', {})
                    ssl_bindings = ssl_mappings.get(key, [])
                    if isinstance(ssl_bindings, dict):
                        ssl_bindings = [ssl_bindings]
                    for mapping in ssl_bindings:
                        if 'CA' in mapping:
                            pki_ref = mapping['attrs'][0]
                            # Added prefix for objects
                            if self.prefix:
                                pki_ref = self.prefix + '-' + pki_ref
                            if self.object_merge_check:
                                pki_ref = merge_object_mapping[
                                    'pki_profile'].get(pki_ref)
                            if [pki_profile for pki_profile in (sysdict[
                               "PKIProfile"] + avi_config["PKIProfile"]) if
                               pki_profile['name'] == pki_ref]:
                                pki_ref = ns_util.get_object_ref(
                                    pki_ref, OBJECT_TYPE_PKI_PROFILE,
                                    self.tenant_name)
                                app_profile_name = \
                                    ns_util.update_application_profile(
                                        http_prof, pki_ref, self.tenant_ref,
                                        updated_vs_name, avi_config, sysdict)
                                if app_profile_name:
                                    app_profile_with_pki_profile_ref = \
                                        ns_util.get_object_ref(app_profile_name,
                                                OBJECT_TYPE_APPLICATION_PROFILE,
                                                               self.tenant_name)
                                    vs_obj['application_profile_ref'] = \
                                        app_profile_with_pki_profile_ref
                                    LOG.info(
                                        'Added: %s PKI profile %s' % (pki_ref,
                                                                      key))
                        elif 'certkeyName' in mapping:
                            avi_ssl_ref = 'ssl_key_and_certificate_refs'
                            ckname = mapping['certkeyName']
                            if self.prefix:
                                ckname = self.prefix + '-' + ckname
                            if [obj for obj in
                                avi_config['SSLKeyAndCertificate']
                                if obj['name'] == ckname]:
                                updated_ssl_ref = ns_util.get_object_ref(ckname,
                                    OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                    self.tenant_name)
                                vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                            elif [obj for obj in
                                  avi_config['SSLKeyAndCertificate']
                                  if obj['name'] == ckname + '-dummy']:
                                updated_ssl_ref = ns_util.get_object_ref(
                                    ckname + '-dummy',
                                    OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                    self.tenant_name)
                                vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                            else:
                                LOG.warning(
                                    'Could not find ssl key cert, so adding '
                                    'default cert as system default insted')
                                vs_obj[avi_ssl_ref] = [ns_util.get_object_ref(
                                    'System-Default-Cert',
                                    'sslkeyandcertificate', 'admin')]
                                continue
                            vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                    ssl_vs_mapping = ns_config.get('set ssl vserver', {})
                    mapping = ssl_vs_mapping.get(key, None)
                    ssl_profile_name = re.sub('[:]', '-', key)
                    # Added prefix for objects
                    if self.prefix:
                        ssl_profile_name = self.prefix + '-' + ssl_profile_name
                    # Get the merge ssl profile name
                    if self.object_merge_check:
                        ssl_profile_name = \
                            merge_object_mapping['ssl_profile'].get(
                                ssl_profile_name, None)
                    if mapping and [ssl_profile for ssl_profile in (sysdict[
                       'SSLProfile'] + avi_config["SSLProfile"]) if
                       ssl_profile['name'] == ssl_profile_name]:
                        updated_ssl_profile_ref = ns_util.get_object_ref(
                            ssl_profile_name, OBJECT_TYPE_SSL_PROFILE,
                            self.tenant_name)
                        # Changed ssl profile name to ssl profile ref.
                        vs_obj['ssl_profile_ref'] = updated_ssl_profile_ref
                        LOG.debug('Added: %s SSL profile %s' % (key, key))
                # Added code to skipped L4 VS if pool or pool group not present
                if vs_obj.get('application_profile_ref'):
                    app_name = ns_util.get_name(vs_obj[
                                                    'application_profile_ref'])
                    application_profile_obj = [obj for obj in (sysdict[
                                              'ApplicationProfile'] +
                                              avi_config['ApplicationProfile'])
                                              if obj['name'] == app_name]
                    if (application_profile_obj and application_profile_obj[0][
                      'type'] == 'APPLICATION_PROFILE_TYPE_L4') or app_name == \
                      'System-L4-Application':
                        if not vs_obj.get('pool_ref', vs_obj.get(
                                'pool_group_ref')):
                            vs_conv_status = STATUS_SKIPPED
                            skipped_status = "Skipped:Failed to convert L4 VS "\
                                             "dont have pool or pool group ref"\
                                             " %s" % full_cmd
                            LOG.debug(skipped_status)
                            ns_util.add_status_row(lb_vs['line_no'], cmd, key,
                                    full_cmd, vs_conv_status, skipped_status)
                            continue
                # Added this line here in order to track if a pool group is
                # used in VS directly or through policy
                if vs_obj.get('pool_group_ref'):
                    used_pool_group_ref.append(pool_group_ref)
                avi_config['VirtualService'].append(vs_obj)
                # Add summery of this lb vs in CSV/report
                conv_status = ns_util.get_conv_status(
                    lb_vs, self.lbvs_skip_attrs, self.lbvs_na_attrs,
                    self.lbvs_indirect_list,
                    ignore_for_val=self.lbvs_ignore_vals,
                    user_ignore_val=self.lbvs_user_ignore)
                ns_util.add_conv_status(lb_vs['line_no'], cmd, key,
                                        full_cmd, conv_status, vs_obj)
                LOG.debug('LB VS conversion completed for: %s' % key)
            except:
                LOG.error('Error in lb vs conversion for: %s' %
                          key, exc_info=True)
            # Calling progress bar function.
            msg = "VirtualService Conversion started..."
            ns_util.print_progress_bar(self.progressbar_count, self.total_size,
                                     msg, prefix='Progress', suffix='')

    def update_pool_for_persist(self, avi_config, pool_group, profile_name):
        """
        This function defines that update pool group to add persistent
        profile ref
        :param avi_config: Dict of vi object
        :param pool_group: Object of pool group
        :param profile_name: Name of persistent profile ref
        :return: None
        """
        attached_flag = False
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
                attached_flag = True
        return attached_flag
