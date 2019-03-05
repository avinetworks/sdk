import logging
import copy
import re
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants
from pkg_resources import parse_version
from avi.migrationtools.netscaler_converter.lbvs_converter \
    import (redirect_pools, used_pool_group_ref)
from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_SKIPPED, OBJECT_TYPE_APPLICATION_PROFILE,
            OBJECT_TYPE_SSL_PROFILE, OBJECT_TYPE_HTTP_POLICY_SET,
            OBJECT_TYPE_POOL_GROUP, OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
            OBJECT_TYPE_PKI_PROFILE, OBJECT_TYPE_NETWORK_PROFILE)
from avi.migrationtools.netscaler_converter.policy_converter \
    import PolicyConverter
from avi.migrationtools.netscaler_converter.monitor_converter \
    import merge_object_mapping
from avi.migrationtools.netscaler_converter.profile_converter import \
    app_merge_count
from avi.migrationtools.netscaler_converter.ns_util import NsUtil
from avi.migrationtools.avi_migration_utils import update_count

LOG = logging.getLogger(__name__)
tmp_policy_ref = []
tmp_used_pool_group_ref = used_pool_group_ref
# Creating object for util library.
ns_util = NsUtil()


class CsvsConverter(object):

    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 object_merge_check, controller_version, user_ignore, prefix):
        """
        Construct a new 'CsvsConverter' object.
        :param tenant_name: Name of tenant
        :param cloud_name: Name of cloud
        :param tenant_ref: Tenant reference
        :param cloud_ref: Cloud Reference
        :param object_merge_check: Bool value for object merge
        :param user_ignore: Dict of user ignore attributes
        :param prefix: prefix for object
        """

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
        self.object_merge_check = object_merge_check
        self.controller_version = controller_version
        # List of ignore val attributes for add csvs netscaler command.
        self.csvs_user_ignore = user_ignore.get('csvs', [])
        # List of ignore val attributes for bind csvs netscaler comma
        self.csvs_bind_user_ignore = user_ignore.get('csvs_bind', [])
        # Added prefix for objects
        self.prefix = prefix
        # Progressbar count and total size.
        self.progressbar_count = 0
        self.total_size = 0

    def convert(self, ns_config, avi_config, vs_state, sysdict, vs_name_dict,
                vrf=None, se_group=None):
        """
        This function defines that it convert netscalar cs vs config to vs
        config of AVI
        :param ns_config: It is dict of all netscalar commands which are
        supported by AVI
        :param avi_config: It is dict of AVI output config
        :param vs_state: state of vs
        :return: None
        """
        policy_converter = PolicyConverter(
            self.tenant_name, self.cloud_name, self.tenant_ref, self.cloud_ref,
            self.csvs_bind_skipped, self.csvs_na_attrs, self.csvs_ignore_vals,
            self.csvs_bind_user_ignore, self.prefix)
        cs_vs_conf = ns_config.get('add cs vserver', {})
        lb_vs_conf = ns_config.get('add lb vserver', {})
        bindings = ns_config.get('bind cs vserver', {})
        ns_service = ns_config.get('add service', {})
        ns_sg = ns_config.get('add serviceGroup', {})
        lbvs_avi_conf = avi_config['VirtualService']
        lb_vs_mapped = []
        cs_vs_list = []
        # get the total size of object.
        self.progressbar_count = len(lb_vs_conf)
        self.total_size = len(lb_vs_conf) + len(cs_vs_conf)
        avi_config['VirtualService'] = ns_util.remove_duplicate_objects(
            'VirtualService', avi_config['VirtualService'])
        for cs_vs_index, key in enumerate(cs_vs_conf):
            try:
                # Increment count
                self.progressbar_count += 1
                LOG.debug("Context Switch VS conversion started for: %s" % key)
                lbvs_bindings = []
                cs_vs = cs_vs_conf[key]
                ns_add_cs_vserver_command = 'add cs vserver'
                ns_add_cs_vserver_complete_command = \
                    ns_util.get_netscalar_full_command(
                        ns_add_cs_vserver_command, cs_vs)
                # Skipped this CS VS if it has type which are not supported
                if not cs_vs['attrs'][1] in self.csvs_supported_types:
                    skipped_status = 'Skipped:Unsupported type %s of Context ' \
                                     'switch VS: %s' % (cs_vs['attrs'][1], key)
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(cs_vs['line_no'],
                                           ns_add_cs_vserver_command, key,
                                           ns_add_cs_vserver_complete_command,
                                           STATUS_SKIPPED, skipped_status)
                    continue
                tt = cs_vs.get('targetType', None)
                if tt and tt == 'GSLB':
                    skipped_status = 'Skipped:Unsupported target type %s of ' \
                                     'Context switch VS: %s' % (tt, key)
                    LOG.warning(skipped_status)
                    # Skipped this CS VS if targetType is GSLB
                    ns_util.add_status_row(cs_vs['line_no'],
                                           ns_add_cs_vserver_command, key,
                                           ns_add_cs_vserver_complete_command,
                                           STATUS_SKIPPED, skipped_status)
                    continue
                vs_name = cs_vs['attrs'][0]
                if len(cs_vs['attrs']) < 3:
                    skipped_status = 'Skipped:No IP, port found for Context ' \
                                     'switch VS: %s' % key
                    LOG.warning(skipped_status)
                    # Skipped this CS VS if there is no IP address and port
                    ns_util.add_status_row(cs_vs['line_no'],
                                           ns_add_cs_vserver_command, key,
                                           ns_add_cs_vserver_complete_command,
                                           STATUS_SKIPPED, skipped_status)
                    continue
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
                # Added prefix for objects
                if self.prefix:
                    updated_vs_name = self.prefix + '-' + updated_vs_name
                # Regex to check Vs has IPV6 address if yes the Skipped
                if re.findall(ns_constants.IPV6_Address, ip_addr) \
                        or ip_addr == '0.0.0.0':
                    skipped_status = "Skipped:Invalid VIP %s" \
                                     % ns_add_cs_vserver_command
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        cs_vs['line_no'], ns_add_cs_vserver_command,
                        key, ns_add_cs_vserver_complete_command, STATUS_SKIPPED,
                        skipped_status)
                    continue

                vs_name_dict['csvs'][updated_vs_name] = vs_name

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
                    'tenant_ref': self.tenant_ref,
                    'cloud_ref': self.cloud_ref,
                    'type': 'VS_TYPE_NORMAL',
                    'enabled': True,
                    'traffic_enabled': enabled,
                    'services': []
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
                if parse_version(self.controller_version) >= parse_version(
                        '17.1'):
                    vs_obj['vip'] = [vip]
                else:
                    vs_obj['ip_address'] = vip['ip_address']

                service = {'port': port, 'enable_ssl': enable_ssl}
                if port in ("0", "*"):
                    service['port'] = "1"
                    service['port_range_end'] = "65535"
                vs_obj['services'].append(service)
                bind_conf_list = bindings.get(vs_name, None)
                if not bind_conf_list:
                    continue
                if isinstance(bind_conf_list, dict):
                    bind_conf_list = [bind_conf_list]
                http_prof = cs_vs.get('httpProfileName', None)
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
                        LOG.info('Conversion successful: Added application '
                                 'profile %s for %s' % (http_prof,
                                                        updated_vs_name))
                        http_prof_ref = ns_util.get_object_ref(http_prof,
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
                                    command = \
                                        ns_util.get_netscalar_full_command(
                                            ser_cmd, ser_conf)
                                    if 'x-forwarded-for' in command:
                                        addition_attr['xff_enabled'] = True
                                        addition_attr[
                                            'ssl_everywhere_enabled'] = True
                        clttimeout = cs_vs.get('cltTimeout', None)
                        if clttimeout:
                            addition_attr['clttimeout'] = clttimeout
                            clt_cmd = ns_add_cs_vserver_command + \
                                      ' cltTimeout %s' % clttimeout
                            LOG.info('Conversion successful : %s' % clt_cmd)
                        ns_util.add_prop_for_http_profile(
                            http_prof, avi_config, sysdict, addition_attr)
                    else:
                        LOG.warning("%s application profile doesn't exist for "
                                    "%s vs" % (http_prof, updated_vs_name))
                ntwk_prof = cs_vs.get('tcpProfileName', None)
                if ntwk_prof:
                    # Added prefix for objects
                    if self.prefix:
                        ntwk_prof = self.prefix + '-' + ntwk_prof
                    # Get the merge network profile name
                    if self.object_merge_check:
                        ntwk_prof = merge_object_mapping['network_profile'].get(
                                    ntwk_prof)
                    if ns_util.object_exist('NetworkProfile', ntwk_prof,
                       sysdict) or ns_util.object_exist('NetworkProfile',
                       ntwk_prof, avi_config):
                        LOG.info('Conversion successful: Added network profile '
                                 '%s for %s' % (ntwk_prof, updated_vs_name))
                        ntwk_prof_ref = \
                            ns_util.get_object_ref(ntwk_prof,
                                                   OBJECT_TYPE_NETWORK_PROFILE,
                                                   self.tenant_name)
                        vs_obj['network_profile_ref'] = ntwk_prof_ref
                    else:
                        vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                           'System-TCP-Proxy', 'networkprofile', tenant='admin')
                        LOG.error('Error: Not found Network profile %s for %s' %
                                  (ntwk_prof, updated_vs_name))

                if not http_prof and (cs_vs['attrs'][1]).upper() == 'DNS':
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        'System-DNS', 'applicationprofile', tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                        'System-UDP-Per-Pkt', 'networkprofile', tenant='admin')
                elif not http_prof and (cs_vs['attrs'][1]).upper() == 'UDP':
                    vs_obj[
                        'application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                       'System-UDP-Fast-Path', 'networkprofile', tenant='admin')
                elif not http_prof and (
                        cs_vs['attrs'][1]).upper() in ['DNS_TCP', 'TCP']:
                    vs_obj[
                        'application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                    vs_obj['network_profile_ref'] = ns_util.get_object_ref(
                        'System-TCP-Proxy', 'networkprofile', tenant='admin')
                elif not http_prof and (cs_vs['attrs'][1]).upper() == 'SSL':
                    # Added Custom Profile with http to https redirect enable
                    ns_migration_profile = ns_util.create_http_to_https_custom_profile()
                    app_name = [app_p for app_p in avi_config[
                        'ApplicationProfile'] if app_p[
                        'name']==ns_migration_profile['name']]
                    if not app_name:
                        avi_config['ApplicationProfile'].append(ns_migration_profile)
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        ns_migration_profile['name'], 'applicationprofile',
                        tenant='admin')
                # Adding L4 as a default profile when SSL_BRIDGE
                elif not http_prof and (cs_vs['attrs'][1]).upper() == \
                        'SSL_BRIDGE':
                    vs_obj['application_profile_ref'] = ns_util.get_object_ref(
                        'System-L4-Application', 'applicationprofile',
                        tenant='admin')
                default_pool_group = None
                lb_vserver_bind_conf = None

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
                               'PKIProfile'] + avi_config["PKIProfile"]) if
                               pki_profile['name'] == pki_ref]:
                                pki_ref = ns_util.get_object_ref(pki_ref,
                                          OBJECT_TYPE_PKI_PROFILE,
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
                                    LOG.info('Added: %s PKI profile %s' % (
                                              pki_ref, key))
                        elif 'certkeyName' in mapping:
                            avi_ssl_ref = 'ssl_key_and_certificate_refs'
                            ckname = mapping['certkeyName']
                            # Added prefix for objects
                            if self.prefix:
                                ckname = self.prefix + '-' + ckname
                            if [obj for obj in avi_config[
                                'SSLKeyAndCertificate'] if obj['name'] ==
                                ckname]:
                                updated_ssl_ref = \
                                    ns_util.get_object_ref(ckname,
                                        OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                        self.tenant_name)
                                vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                            elif [obj for obj in avi_config[
                                  'SSLKeyAndCertificate'] if obj['name'] ==
                                  ckname + '-dummy']:
                                updated_ssl_ref = \
                                    ns_util.get_object_ref(ckname + '-dummy',
                                        OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                        self.tenant_name)
                                vs_obj[avi_ssl_ref] = [updated_ssl_ref]
                            else:
                                LOG.warning(
                                    'Could not find ssl key cert, so adding '
                                    'default cert as system default insted')
                                vs_obj[avi_ssl_ref] = [ns_util.get_object_ref(
                                  'System-Default-Cert', 'sslkeyandcertificate',
                                  'admin')]
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
                        ssl_profile_name = merge_object_mapping[
                                           'ssl_profile'].get(ssl_profile_name,
                                                            None)
                    if mapping and [ssl_profile for ssl_profile in (sysdict[
                       'SSLProfile'] + avi_config["SSLProfile"]) if
                       ssl_profile['name'] == ssl_profile_name]:
                        updated_ssl_profile_ref = ns_util.get_object_ref(
                            ssl_profile_name, OBJECT_TYPE_SSL_PROFILE,
                            self.tenant_name)
                        # Changed ssl profile name to ssl profile ref.
                        vs_obj['ssl_profile_ref'] = updated_ssl_profile_ref
                        LOG.debug('Added: %s SSL profile %s' % (key, key))

                for bind_conf in bind_conf_list:
                    if 'lbvserver' in bind_conf:
                        lbvs_bindings.append(bind_conf['lbvserver'])
                        default_pool_group = bind_conf['lbvserver']
                        lb_vserver_bind_conf = bind_conf

                LOG.debug("CS VS %s context switch between lb vs: %s" %
                          (key, lbvs_bindings))

                case_sensitive = False \
                    if cs_vs.get('caseSensitive', '') == 'OFF' else True
                # Convert netscalar policy to AVI http policy set
                # Sending enable_ssl to policy in order to have protocol in case
                # it is not provided thru redirect action url
                policy = policy_converter.convert(bind_conf_list, ns_config,
                            avi_config, tmp_used_pool_group_ref,
                            redirect_pools, 'bind cs vserver', case_sensitive,
                            enable_ssl)

                for binding in lbvs_bindings:
                    if self.prefix:
                        binding = '%s-%s' % (self.prefix, binding)
                    lb_vs_obj = [obj for obj in lbvs_avi_conf
                                 if obj['name'] == binding]

                    if lb_vs_obj:
                        lb_vs_obj = lb_vs_obj[0]
                        lb_vs_mapped.append(lb_vs_obj)
                        lb_vs_obj = copy.deepcopy(lb_vs_obj)
                        lb_vs_obj.update(vs_obj)
                        vs_obj = lb_vs_obj
                    else:
                        policy_vs = [obj for obj in avi_config['Lbvs']
                                     if binding in obj and obj[binding].get(
                                'redirect_url', None)]
                        if policy_vs:
                            redirect_rule = {
                                'index': 999,
                                'redirect_action': {
                                    'keep_query': True,
                                    'status_code':
                                        "HTTP_REDIRECT_STATUS_CODE_302",
                                    'host': {
                                        'tokens': [{
                                            'str_value': policy_vs[0][
                                                binding]['redirect_url'],
                                            'type': "URI_TOKEN_TYPE_HOST",
                                            'start_index': 0,
                                            'end_index': 65535
                                        }],
                                        'type': "URI_PARAM_TYPE_TOKENIZED"
                                    },
                                    'protocol': "HTTPS",
                                    'port': 443
                                },
                                'enable': True,
                                "name": '%s-default-redirect' % updated_vs_name
                            }
                            if policy and policy.get('http_request_policy',
                                                     None):
                                policy['http_request_policy']['rules'].append(
                                    redirect_rule)
                            elif policy:
                                policy['http_request_policy']['rules'] = [
                                    redirect_rule]
                            else:
                                policy ={
                                    'name': "vs-%s-HTTP-Policy-Set"
                                            % updated_vs_name,
                                    'tenant_ref': self.tenant_ref,
                                    'http_request_policy': {
                                        'rules': [redirect_rule]
                                    },
                                    'is_internal_policy': False
                                }
                            ns_util.update_status_target_lb_vs_to_indirect(
                                binding)
                        else:
                            continue
                vs_obj.pop('pool_group_ref', None)
                # Took lbvs policy if any and clone for csvs
                lbvs_policy = vs_obj.pop('http_policies', [])
                if lbvs_policy:
                    for policy_attr in lbvs_policy:
                        policy_ref = policy_attr.get('http_policy_set_ref')
                        policy_name = ns_util.get_name(policy_ref) if \
                                        policy_ref else None
                        policy_objs = [ob for ob in avi_config['HTTPPolicySet']
                                      if ob['name'] == policy_name]
                        policy_obj = policy_objs[0] if policy_objs else {}
                        if policy_obj:
                            ns_util.add_policy(policy_obj, updated_vs_name,
                                 avi_config, tmp_policy_ref, vs_obj,
                                 self.tenant_name, self.cloud_name, self.prefix,
                                 tmp_used_pool_group_ref)
                # Add the http policy set reference to VS in AVI
                if policy:
                    policy['name'] = policy['name'] + updated_vs_name
                    # Added fix for same policy referred in multiple vs
                    ns_util.add_policy(policy, updated_vs_name, avi_config,
                                     tmp_policy_ref, vs_obj, self.tenant_name,
                                     self.cloud_name, self.prefix,
                                     tmp_used_pool_group_ref)
                # Add reference of pool group to VS
                if default_pool_group:
                    pool_group_ref = '%s-poolgroup' % default_pool_group
                    updated_pool_group_ref = re.sub('[:]', '-', pool_group_ref)
                    # Added prefix for objects
                    if self.prefix:
                        updated_pool_group_ref = self.prefix + '-' + \
                                                 updated_pool_group_ref
                    pools = [pool_group['name'] for pool_group in
                             avi_config['PoolGroup']
                             if pool_group['name'] == updated_pool_group_ref]
                    if pools:
                        ns_util.update_status_target_lb_vs_to_indirect(
                            default_pool_group)
                        # clone the pool group if it is referenced to other VS
                        # to http policy set
                        if updated_pool_group_ref in tmp_used_pool_group_ref:
                            updated_pool_group_ref = ns_util.clone_pool_group(
                                updated_pool_group_ref, vs_name, avi_config,
                                self.tenant_name, self.cloud_name,
                                userprefix=self.prefix)
                        avi_pool_group_ref = ns_util.get_object_ref(
                            updated_pool_group_ref, OBJECT_TYPE_POOL_GROUP,
                            self.tenant_name, self.cloud_name)
                        vs_obj['pool_group_ref'] = avi_pool_group_ref
                if lb_vserver_bind_conf:
                    bind_cs_vserver_command = 'bind cs vserver'
                    bind_cs_vserver_complete_command = ns_util. \
                        get_netscalar_full_command(bind_cs_vserver_command,
                                                   lb_vserver_bind_conf)
                    LOG.debug('Conversion successful : %s' %
                              bind_cs_vserver_complete_command)
                    conv_status = ns_util.get_conv_status(
                        bind_conf, self.csvs_bind_skipped, [], [],
                        user_ignore_val=self.csvs_bind_user_ignore)
                    ns_util.add_conv_status(lb_vserver_bind_conf['line_no'],
                        bind_cs_vserver_command, lb_vserver_bind_conf[
                        'attrs'][0], bind_cs_vserver_complete_command,
                        conv_status, vs_obj)
                # Verify that this cs vs has share the same VIP of another vs
                # If yes then skipped this cs vs
                is_shared = ns_util.is_shared_same_vip(
                    vs_obj, cs_vs_list, avi_config, self.tenant_name,
                    self.cloud_name, self.tenant_ref, self.cloud_ref,
                    self.controller_version, self.prefix)
                if is_shared:
                    skipped_status = 'Skipped: %s Same vip shared by another ' \
                                     'virtual service' % vs_name
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        cs_vs['line_no'], ns_add_cs_vserver_command, key,
                        ns_add_cs_vserver_complete_command, STATUS_SKIPPED,
                        skipped_status)
                    continue
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
                                             " %s" % vs_name
                            LOG.debug(skipped_status)
                            ns_util.add_status_row(cs_vs['line_no'],
                                            ns_add_cs_vserver_command, key,
                                            ns_add_cs_vserver_complete_command,
                                            vs_conv_status, skipped_status)
                            continue
                if vs_obj.get('pool_group_ref'):
                    tmp_used_pool_group_ref.append(updated_pool_group_ref)
                cs_vs_list.append(vs_obj)
                # Add summery of this cs vs in CSV/report
                conv_status = ns_util.get_conv_status(
                    cs_vs, self.csvs_skip_attrs, self.csvs_na_attrs, [],
                    ignore_for_val=self.csvs_ignore_vals,
                    user_ignore_val=self.csvs_user_ignore)
                ns_util.add_conv_status(cs_vs['line_no'],
                    ns_add_cs_vserver_command, key,
                    ns_add_cs_vserver_complete_command, conv_status, vs_obj)
                LOG.debug("Context Switch VS conversion completed for: %s"
                          % key)
            except:
                update_count('error')
                LOG.error('Error in cs vs conversion for: %s' % key,
                          exc_info=True)
            # Calling progress bar function.
            msg = "VirtualService Conversion started..."
            ns_util.print_progress_bar(self.progressbar_count, self.total_size,
                                     msg, prefix='Progress', suffix='')
        vs_list = [obj for obj in lbvs_avi_conf if obj not in lb_vs_mapped]
        vs_list += cs_vs_list
        avi_config['VirtualService'] = vs_list
        ns_util.get_vs_if_shared_vip(avi_config, self.controller_version)
        # Update the index value of all policy rules as per their priority
        ns_util.set_rules_index_for_http_policy_set(avi_config)
        ns_util.clean_virtual_service_from_avi_config(
            avi_config, self.controller_version)
