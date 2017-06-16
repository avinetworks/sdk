import logging
import copy
import random
import re
import avi.migrationtools.f5_converter.conversion_util as conv_utils
import avi.migrationtools.f5_converter.converter_constants as final

from pkg_resources import parse_version

LOG = logging.getLogger(__name__)


class VSConfigConv(object):
    @classmethod
    def get_instance(cls, version, f5_virtualservice_attributes, prefix, con_snatpool):
        if version == '10':
            return VSConfigConvV10(f5_virtualservice_attributes, prefix, con_snatpool)
        if version in ['11', '12']:
            return VSConfigConvV11(f5_virtualservice_attributes, prefix, con_snatpool)

    def get_persist_ref(self, f5_vs):
        pass

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        pass

    def convert(self, f5_config, avi_config, vs_state, user_ignore, tenant,
                cloud_name, controller_version):
        f5_snat_pools = f5_config.get("snatpool", {})
        vs_config = f5_config.get("virtual", {})
        avi_config['VirtualService'] = []
        avi_config['VSDataScriptSet'] = []
        avi_config['NetworkSecurityPolicy'] = []
        avi_config['VsVip'] = []

        for vs_name in vs_config.keys():
            try:
                LOG.debug("Converting VS: %s" % vs_name)
                f5_vs = vs_config[vs_name]
                vs_type = [key for key in f5_vs.keys()
                           if key in self.unsupported_types]
                if vs_type:
                    LOG.warn("VS type: %s not supported by Avi skipped VS: %s" %
                             (vs_type, vs_name))
                    conv_utils.add_status_row('virtual', None, vs_name,
                                              final.STATUS_SKIPPED)
                    continue
                # Added prefix for objects
                if self.prefix:
                    vs_name = self.prefix + '-' + vs_name
                vs_obj = self.convert_vs(vs_name, f5_vs, vs_state, avi_config,
                                         f5_snat_pools, user_ignore, tenant,
                                         cloud_name, controller_version)
                if vs_obj:
                    avi_config['VirtualService'].append(vs_obj)
                    LOG.debug("Conversion successful for VS: %s" % vs_name)
            except:
                LOG.error("Failed to convert VS: %s" % vs_name, exc_info=True)

        LOG.debug("Converted %s VS" % len(avi_config['VirtualService']))
        f5_config.pop("virtual", {})

    def convert_vs(self, vs_name, f5_vs, vs_state, avi_config, snat_config,
                   user_ignore, tenant_ref, cloud_name, controller_version):
        tenant, vs_name = conv_utils.get_tenant_ref(vs_name)
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        hash_profiles = avi_config.get('hash_algorithm', [])
        description = f5_vs.get("description", None)
        skipped = [key for key in f5_vs.keys()
                   if key not in self.supported_attr]
        enabled = (vs_state == 'enable')
        if enabled:
            enabled = False if "disabled" in f5_vs.keys() else True
        profiles = f5_vs.get("profiles", {})
        ssl_vs, ssl_pool = conv_utils.get_vs_ssl_profiles(profiles, avi_config,
                                                          self.prefix)
        oc_prof = False
        for prof in profiles:
            if prof in avi_config.get('OneConnect', []):
                oc_prof = True
        app_prof, f_host, realm, policy_set = conv_utils.get_vs_app_profiles(
            profiles, avi_config, tenant, self.prefix, oc_prof)

        if not app_prof:
            LOG.warning('Profile type not supported by Avi Skipping VS : %s'
                        % vs_name)
            conv_utils.add_status_row('virtual', None, vs_name,
                                      final.STATUS_SKIPPED)
            return None

        ntwk_prof = conv_utils.get_vs_ntwk_profiles(profiles, avi_config,
                                                    self.prefix)

        # If one connect profile is not assigned to f5 VS and avi app profile
        # assigned to VS has connection_multiplexing_enabled value True then
        # clone profile and make connection_multiplexing_enabled as False
        pool_ref = f5_vs.get("pool", None)
        app_prof_obj = [obj for obj in avi_config['ApplicationProfile']
                        if obj['name'] == app_prof[0]]
        cme = True
        app_prof_type = None
        if app_prof_obj:
            app_prof_type = app_prof_obj[0].get('type')
        if app_prof_type == 'APPLICATION_PROFILE_TYPE_HTTP':
            cme = app_prof_obj[0]['http_profile'].get(
                'connection_multiplexing_enabled', False)
        if not (cme or oc_prof):
            # Check if already cloned profile present
            app_prof_cmd = [obj for obj in avi_config['ApplicationProfile']
                            if obj['name'] == '%s-cmd' % app_prof[0]]
            if app_prof_cmd:
                app_prof[0] = app_prof_cmd[0]['name']
            else:
                app_prof_cmd = copy.deepcopy(app_prof_obj[0])
                app_prof_cmd['name'] = '%s-cmd' % app_prof_cmd['name']
                app_prof_cmd['connection_multiplexing_enabled'] = False
                avi_config['ApplicationProfile'].append(app_prof_cmd)
                app_prof[0] = app_prof_cmd['name']

        enable_ssl = False
        if ssl_vs:
            enable_ssl = True
        destination = f5_vs.get("destination", None)
        d_tenant, destination = conv_utils.get_tenant_ref(destination)
        # if destination is not present then skip vs.
        services_obj, ip_addr, vsvip_ref = conv_utils.get_service_obj(
            destination, avi_config, enable_ssl, controller_version, tenant,
            cloud_name, self.prefix)
        # Added Check for if port is no digit skip vs.
        if not services_obj and not ip_addr and not vsvip_ref:
            LOG.debug("Skipped: Virtualservice: %s" % vs_name)
            conv_utils.add_status_row('virtual', None, vs_name,
                                      final.STATUS_SKIPPED)
            return
        if '%' in ip_addr:
            ip_addr, vrf = ip_addr.split('%')
            conv_utils.add_vrf(avi_config, vrf)
        is_pool_group = False
        if pool_ref:
            p_tenant, pool_ref = conv_utils.get_tenant_ref(pool_ref)
            # TODO: need to revisit after shared pool support implemented
            pool_ref, is_pool_group = conv_utils.clone_pool_if_shared(
                pool_ref, avi_config, vs_name, tenant, p_tenant,
                cloud_name=cloud_name, prefix=self.prefix)
            if ssl_pool:
                if is_pool_group:
                    conv_utils.add_ssl_to_pool_group(avi_config, pool_ref,
                                                     ssl_pool[0], tenant)
                    conv_utils.remove_http_mon_from_pool_group(
                        avi_config, pool_ref, tenant)
                else:
                    conv_utils.add_ssl_to_pool(avi_config['Pool'], pool_ref,
                                               ssl_pool[0], tenant)
                    conv_utils.remove_http_mon_from_pool(
                        avi_config, pool_ref, tenant)
            else:
                # TODO Remove this once controller support this scenario.
                if is_pool_group:
                    conv_utils.remove_https_mon_from_pool_group(
                        avi_config, pool_ref, tenant)
                else:
                    conv_utils.remove_https_mon_from_pool(
                        avi_config, pool_ref, tenant)

            persist_ref = self.get_persist_ref(f5_vs)
            if persist_ref:
                avi_persistence = avi_config.get(
                    'ApplicationPersistenceProfile', [])

                if is_pool_group:
                    pool_updated = conv_utils.update_pool_group_for_persist(
                        avi_config, pool_ref, persist_ref, hash_profiles,
                        avi_persistence, tenant)
                else:
                    pool_updated = conv_utils.update_pool_for_persist(
                        avi_config['Pool'], pool_ref, persist_ref,
                        hash_profiles, avi_persistence, tenant)

                if not pool_updated:
                    skipped.append("persist")
                    LOG.warning(
                        "persist profile %s not found for vs:%s" %
                        (persist_ref, vs_name))
            if f_host:
                conv_utils.update_pool_for_fallback(
                    f_host, avi_config['Pool'], pool_ref)
        ip_addr = ip_addr.strip()
        matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', ip_addr)
        if not matches or ip_addr == '0.0.0.0':
            LOG.warning('Avi does not support IPv6 : %s. '
                        'Generated random ipv4 for vs: %s' % (ip_addr, vs_name))
            vs_name += '-needs-ipv6-ip'
            ip_addr = ".".join(map(str, (
                random.randint(0, 255) for _ in range(4))))
        # VIP object for virtual service
        vip = {
            'ip_address': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'vip_id': 0
        }
        vs_obj = {
            'name': vs_name,
            'description': description,
            'type': 'VS_TYPE_NORMAL',
            'enabled': enabled,
            'cloud_ref': conv_utils.get_object_ref(
                cloud_name, 'cloud', tenant=tenant),
            'services': services_obj,
            'application_profile_ref': app_prof[0],
            'vs_datascripts': [],
            'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant')
        }
        if parse_version(controller_version) >= parse_version('17.1'):
            vs_obj['vip'] = [vip]
            vs_obj['vsvip_ref'] = vsvip_ref
        else:
            vs_obj['ip_address'] = vip['ip_address']
        vs_ds_rules = None
        if 'rules' in f5_vs:
            if isinstance(f5_vs['rules'], basestring):
                vs_ds_rules = [f5_vs['rules']]
            else:
                vs_ds_rules = f5_vs['rules'].keys()
            for index, rule in enumerate(vs_ds_rules):
                # converted _sys_https_redirect data script to rule in
                # http policy
                if rule == '_sys_https_redirect':
                    # Added prefix for objects
                    if self.prefix:
                        policy_name = self.prefix + '-' + rule + '-' + vs_name
                    else:
                        policy_name = rule + '-' + vs_name
                    policy = {
                        "name": policy_name,
                        "http_request_policy": {
                            "rules": [
                                {
                                    "index": 1,
                                    "redirect_action": {
                                        "keep_query": True,
                                        "status_code":
                                            "HTTP_REDIRECT_STATUS_CODE_302",
                                        "protocol": "HTTPS",
                                        "port": 443
                                    },
                                    "enable": True,
                                    "name": policy_name + "-Redirect",
                                    "match": {
                                        "protocol": {
                                            "protocols": "HTTP",
                                            "match_criteria": "IS_IN"
                                        }
                                    }
                                }
                            ]
                        },
                        'tenant_ref': conv_utils.get_object_ref(tenant,
                                                                'tenant'),
                        "is_internal_policy": False
                    }
                    http_policies = {
                        'index': 11,
                        'http_policy_set_ref':
                            conv_utils.get_object_ref(policy_name,
                                                      'httppolicyset',
                                                      tenant=tenant)
                    }
                    vs_obj['http_policies'] = []
                    vs_obj['http_policies'].append(http_policies)
                    avi_config['HTTPPolicySet'].append(policy)
        if is_pool_group:
            vs_obj['pool_group_ref'] = conv_utils.get_object_ref(
                pool_ref, 'poolgroup', tenant=tenant, cloud_name=cloud_name)
        elif pool_ref:
            vs_obj['pool_ref'] = conv_utils.get_object_ref(
                pool_ref, 'pool', tenant=tenant, cloud_name=cloud_name)

        self.convert_translate_port(avi_config, f5_vs, app_prof[0], pool_ref,
                                    skipped)
        conn_limit = int(f5_vs.get(self.connection_limit, '0'))
        if conn_limit > 0:
            vs_obj["performance_limits"] = {
                "max_concurrent_connections": conn_limit
            }
        rate_limit = int(f5_vs.get('rate-limit', '0'))
        if rate_limit > 0:
            vs_obj["connections_rate_limit"] = {
                "count": rate_limit
            }

        if realm:
            vs_obj['client_auth'] = realm

        if policy_set:
            vs_obj['http_policies'] = policy_set

        source = f5_vs.get('source', '0.0.0.0/0')
        if '%' in source:
            s_parts = source.split('%')
        elif '/' in source:
            s_parts = source.split('/')
        else:
            s_parts = [source]
        if not s_parts[0] == '0.0.0.0':
            parts = source.split('/')
            if '%' in parts[0]:
                parts[0] = parts[0].split('%')[0]
            mask = 24
            if len(parts) > 1:
                mask = parts[1]
            policy_name = ('vs-%s-ns' % vs_name)
            policy = conv_utils.create_network_security_rule(
                policy_name, parts[0], mask, tenant)
            avi_config['NetworkSecurityPolicy'].append(policy)
            vs_obj['network_security_policy_ref'] = conv_utils.get_object_ref(
                policy_name, 'networksecuritypolicy', tenant=tenant)

        # Checking snat conversion flag and snat info for creating snat ip object
        snat = f5_vs.get("source-address-translation", {})
        snat_pool_name = snat.get("pool", f5_vs.get("snatpool", None))
        snat_pool = snat_config.pop(snat_pool_name, None)
        if snat_pool:
            if self.con_snatpool:
                LOG.debug("Converting the snat as input flag and snat information is set")
                snat_list = conv_utils.get_snat_list_for_vs(snat_pool)
                if len(snat_list) > 32:
                    vs_obj["snat_ip"] = snat_list[0:32]
                    LOG.warning(
                        'Ignore the snat IPs, its count is beyond 32 for vs : %s' %
                        vs_name)
                else:
                    vs_obj["snat_ip"] = snat_list
                conv_status = {'status': final.STATUS_SUCCESSFUL}
                message = 'Mapped indirectly to VS -> SNAT IP Address'
                conv_utils.add_conv_status('snatpool', '', snat_pool_name,
                                           conv_status, message)
            else:
                LOG.debug("Skipped: snat conversion as input flag is not set for vs : %s" % vs_name)
                skipped.append("source-address-translation" if f5_vs.get(
                    "source-address-translation") else "snatpool" if f5_vs.get(
                    "snatpool") else None)

        if ntwk_prof:
            vs_obj['network_profile_ref'] = ntwk_prof[0]
        if enable_ssl:
            vs_obj['ssl_profile_ref'] = ssl_vs[0]["profile"]
            if ssl_vs[0]["cert"]:
                vs_obj['ssl_key_and_certificate_refs'] = [ssl_vs[0]["cert"]]
            if ssl_vs[0]["pki"] and app_prof[0] != "http":
                app_profiles = [obj for obj in
                                avi_config["ApplicationProfile"]
                                if obj['name'] ==
                                conv_utils.get_name_from_ref(app_prof[0])]
                if app_profiles[0]["type"] == \
                        'APPLICATION_PROFILE_TYPE_HTTP':
                    app_profiles[0]["http_profile"][
                        "ssl_client_certificate_mode"] = ssl_vs[0]["mode"]
                    app_profiles[0]["http_profile"]["pki_profile_ref"] = \
                        ssl_vs[0]["pki"]

        # Added code to skipped L4 VS if pool or pool group not present
        if vs_obj['application_profile_ref']:
            app_profile_name = \
                str(vs_obj['application_profile_ref']).split(
                    '&name=')[1]
            application_profile_obj = \
                [obj for obj in avi_config['ApplicationProfile']
                 if obj['name'] == app_profile_name]
            if application_profile_obj and application_profile_obj[0]['type'] \
                    == 'APPLICATION_PROFILE_TYPE_L4':
                if not 'pool_ref' and not 'pool_group_ref' in vs_obj:
                    LOG.debug("Failed to convert L4 VS dont have "
                              "pool or pool group ref: %s" % vs_name)
                    conv_utils.add_status_row('virtual', None,
                                              vs_name,
                                              final.STATUS_SKIPPED)
                    return
        for attr in self.ignore_for_value:
            ignore_val = self.ignore_for_value[attr]
            actual_val = f5_vs.get(attr, None)
            if not actual_val:
                continue
            if isinstance(ignore_val, str) and actual_val == ignore_val:
                skipped.remove(attr)
            elif isinstance(ignore_val, list) and actual_val in ignore_val:
                skipped.remove(attr)
        conv_status = dict()
        conv_status['user_ignore'] = [val for val in skipped
                                      if val in user_ignore]

        if vs_ds_rules:
            skipped_rules = [rule for rule in vs_ds_rules
                             if rule != '_sys_https_redirect']
            if skipped_rules:
                skipped.append('rules: %s' % skipped_rules)
        conv_status['na_list'] = [val for val in skipped if
                                  val in self.vs_na_attr]
        skipped = [attr for attr in skipped if attr not in self.vs_na_attr]
        skipped = [attr for attr in skipped if attr not in user_ignore]
        conv_status['skipped'] = skipped
        status = final.STATUS_SUCCESSFUL
        if skipped:
            status = final.STATUS_PARTIAL
        conv_status['status'] = status

        conv_utils.add_conv_status('virtual', None, vs_name,
                                   conv_status, vs_obj)

        return vs_obj


class VSConfigConvV11(VSConfigConv):
    def __init__(self, f5_virtualservice_attributes, prefix, con_snatpool):
        self.supported_attr = f5_virtualservice_attributes['VS_supported_attr']
        self.ignore_for_value = \
            f5_virtualservice_attributes['VS_ignore_for_value']
        self.unsupported_types = \
            f5_virtualservice_attributes['VS_unsupported_types']
        self.vs_na_attr = \
            f5_virtualservice_attributes['VS_na_attr']
        self.connection_limit = 'connection-limit'
        # Added prefix for objects
        self.prefix = prefix
        # Added flag for snat conversion
        self.con_snatpool = con_snatpool

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        if persist_ref:
            persist_ref = persist_ref.keys()[0]
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        port_translate = f5_vs.get('translate-port', None)
        if port_translate:
            if port_translate == 'disabled':
                conv_utils.update_pool_for_service_port(avi_config['Pool'],
                                                        pool_ref)
            elif port_translate == 'enabled':
                return


class VSConfigConvV10(VSConfigConv):
    def __init__(self, f5_virtualservice_attributes, prefix, con_snatpool):
        self.supported_attr = f5_virtualservice_attributes['VS_supported_attr']
        self.ignore_for_value = \
            f5_virtualservice_attributes['VS_ignore_for_value']
        self.vs_na_attr = \
            f5_virtualservice_attributes['VS_na_attr']
        self.unsupported_types = \
            f5_virtualservice_attributes['VS_unsupported_types']
        self.connection_limit = 'limit'
        # Added prefix for objects
        self.prefix = prefix
        # Added flag for snat conversion
        self.con_snatpool = con_snatpool

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        port_translate = f5_vs.get('translate service', None)
        if port_translate:
            if port_translate == 'disabled':
                conv_utils.update_pool_for_service_port(avi_config['Pool'],
                                                        pool_ref)
            elif port_translate == 'enabled':
                return
