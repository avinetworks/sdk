import logging
import copy
import random
import re

import avi.f5_converter.conversion_util as conv_utils


LOG = logging.getLogger(__name__)


class VSConfigConv(object):
    @classmethod
    def get_instance(cls, version):
        if version == '10':
            return VSConfigConvV10()
        if version in ['11', '12']:
            return VSConfigConvV11()

    def get_persist_ref(self, f5_vs):
        pass

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        pass

    supported_attr = None
    ignore_for_value = None
    connection_limit = None

    def convert(self, f5_config, avi_config, vs_state, user_ignore, tenant):
        f5_snat_pools = f5_config.get("snatpool", {})
        vs_config = f5_config.get("virtual", {})
        avi_config['VirtualService'] = []
        avi_config['VSDataScriptSet'] = []
        avi_config['NetworkSecurityPolicy'] = []
        unsupported_types = ["l2-forward", "ip-forward", "stateless",
                             "dhcp-relay", "internal", "reject"]

        for vs_name in vs_config.keys():
            try:
                LOG.debug("Converting VS: %s" % vs_name)
                f5_vs = vs_config[vs_name]
                vs_type = [key for key in f5_vs.keys()
                           if key in unsupported_types]
                if vs_type:
                    LOG.warn("VS type: %s not supported by Avi skipped VS: %s" %
                             (vs_type, vs_name))
                    conv_utils.add_status_row('virtual', None, vs_name,
                                              'skipped')
                    continue
                vs_obj = self.convert_vs(vs_name, f5_vs, vs_state, avi_config,
                                         f5_snat_pools, user_ignore, tenant)
                avi_config['VirtualService'].append(vs_obj)
                LOG.debug("Conversion successful for VS: %s" % vs_name)
            except:
                LOG.error("Failed to convert VS: %s" % vs_name, exc_info=True)

        LOG.debug("Converted %s VS" % len(avi_config['VirtualService']))
        f5_config.pop("virtual", {})

    def convert_vs(self, vs_name, f5_vs, vs_state, avi_config, snat_config,
                   user_ignore, tenant_ref):
        tenant, vs_name = conv_utils.get_tenant_ref(vs_name)
        hash_profiles = avi_config.get('hash_algorithm', [])
        description = f5_vs.get("description", None)
        skipped = [key for key in f5_vs.keys()
                   if key not in self.supported_attr]
        enabled = (vs_state == 'enable')
        if enabled:
            enabled = False if "disabled" in f5_vs.keys() else True
        profiles = f5_vs.get("profiles", {})
        ssl_vs, ssl_pool = conv_utils.get_vs_ssl_profiles(profiles, avi_config)
        app_prof, f_host, realm, policy_set = conv_utils.get_vs_app_profiles(
            profiles, avi_config, tenant_ref)
        ntwk_prof = conv_utils.get_vs_ntwk_profiles(profiles, avi_config)

        oc_prof = False
        for prof in profiles:
            if prof in avi_config.get('OneConnect', []):
                oc_prof = True

        # If one connect profile is not assigned to f5 VS and avi app profile
        # assigned to VS has connection_multiplexing_enabled value True then
        # clone profile and make connection_multiplexing_enabled as False

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
        services_obj, ip_addr = conv_utils.get_service_obj(
            destination, avi_config['VirtualService'], enable_ssl)

        if '%' in ip_addr:
            ip_addr, vrf = ip_addr.split('%')
            conv_utils.add_vrf(avi_config, vrf)
        p_tenant = None
        pool_ref = f5_vs.get("pool", None)
        is_pool_group = False
        if pool_ref:
            p_tenant, pool_ref = conv_utils.get_tenant_ref(pool_ref)
            # TODO: need to revisit after shared pool support implemented
            pool_ref, is_pool_group = conv_utils.clone_pool_if_shared(
                pool_ref, avi_config, vs_name, tenant_ref, p_tenant)

            if ssl_pool:
                if is_pool_group:
                    conv_utils.add_ssl_to_pool_group(avi_config, pool_ref,
                                               ssl_pool[0], tenant_ref)
                    conv_utils.remove_http_mon_from_pool_group(avi_config, pool_ref, tenant_ref)
                else:
                    conv_utils.add_ssl_to_pool(avi_config['Pool'], pool_ref,
                                               ssl_pool[0], tenant_ref)
                    conv_utils.remove_http_mon_from_pool(avi_config, pool_ref, tenant_ref)
            else:
                # TODO Remove this once controller support this scenario.
                if is_pool_group:
                    conv_utils.remove_https_mon_from_pool_group(avi_config, pool_ref, tenant_ref)
                else:
                    conv_utils.remove_https_mon_from_pool(avi_config, pool_ref, tenant_ref)

            persist_ref = self.get_persist_ref(f5_vs)
            if persist_ref:
                avi_persistence = avi_config.get(
                    'ApplicationPersistenceProfile', [])

                if is_pool_group:
                    pool_updated = conv_utils.update_pool_group_for_persist(
                        avi_config, pool_ref, persist_ref, hash_profiles,
                        avi_persistence, tenant_ref)
                else:
                    pool_updated = conv_utils.update_pool_for_persist(
                        avi_config['Pool'], pool_ref, persist_ref, hash_profiles,
                        avi_persistence, tenant_ref)

                if not pool_updated:
                    skipped.append("persist")
                    LOG.warning(
                        "persist profile %s not found for vs:%s" %
                        (persist_ref, vs_name))
            if f_host:
                conv_utils.update_pool_for_fallback(
                    f_host, avi_config['Pool'], pool_ref)

        if p_tenant:
            pool_ref = '%s:%s' % (p_tenant, pool_ref)

        ip_addr = ip_addr.strip()
        matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', ip_addr)
        if not matches:
            LOG.warning('Avi does not support IPv6 : %s. Generated random ipv4 for vs: %s' % (ip_addr, vs_name))
            vs_name += '-needs-ipv6-ip'
            ip_addr = ".".join(map(str, (random.randint(0, 255) for _ in range(4))))

        vs_obj = {
            'name': vs_name,
            'description': description,
            'type': 'VS_TYPE_NORMAL',
            'ip_address': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'enabled': enabled,
            'services': services_obj,
            'application_profile_ref': '%s:%s' % (tenant_ref, app_prof[0]),
            'vs_datascripts': [],
            'tenant_ref': tenant_ref
        }

        if 'rules' in f5_vs:
            if isinstance(f5_vs['rules'], basestring):
                rules = [f5_vs['rules']]
            else:
                rules = f5_vs['rules'].keys()
            print vs_name, len(rules)
            ds_ref = self.create_vs_datascript(rules[0], avi_config, tenant_ref)

            vs_datascript = {
                'index': 1,
                'vs_datascript_set_ref': '%s:%s' %(tenant_ref, ds_ref)
            }
            vs_obj['vs_datascripts'].append(vs_datascript)

        if is_pool_group:
            vs_obj['pool_group_ref'] = '%s:%s' % (tenant_ref, pool_ref)
        elif pool_ref:
            vs_obj['pool_ref'] = '%s:%s' % (tenant_ref, pool_ref)

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
        if not source == '0.0.0.0/0':
            parts = source.split('/')
            mask = 24
            if len(parts) > 1:
                mask = parts[1]
            policy_name = ('vs-%s-ns' % vs_name)
            policy = conv_utils.create_network_security_rule(
                policy_name, parts[0], mask)
            avi_config['NetworkSecurityPolicy'].append(policy)
            vs_obj['network_security_policy_ref'] = '%s:%s' % (tenant_ref, policy_name)

        snat = f5_vs.get("source-address-translation", {})
        snat_pool_name = snat.get("pool", None)
        if not snat_pool_name:
            snat_pool_name = f5_vs.get("snatpool", None)
        snat_pool = None
        if snat_pool_name:
            snat_pool = snat_config.pop(snat_pool_name, None)
        if snat_pool:
            snat_list = conv_utils.get_snat_list_for_vs(snat_pool)
            if len(snat_list) > 32:
                vs_obj["snat_ip"] = snat_list[0:32]
                LOG.warning(' Ignore the snat IPs, its count is beyond 32 for vs : %s' % vs_name)
            else:
                vs_obj["snat_ip"] = snat_list
            conv_status = {'status': 'successful'}
            message = 'Mapped indirectly to VS -> SNAT IP Address'
            conv_utils.add_conv_status('snatpool', '', snat_pool_name,
                                       conv_status, message)
        if ntwk_prof:
            vs_obj['network_profile_ref'] = '%s:%s' % (tenant_ref, ntwk_prof[0])
        if enable_ssl:
            vs_obj['ssl_profile_name'] = ssl_vs[0]["profile"]
            if ssl_vs[0]["cert"]:
                vs_obj['ssl_key_and_certificate_refs'] = \
                    ['%s:%s' % (tenant_ref, ssl_vs[0]["cert"])]
            if ssl_vs[0]["pki"] and app_prof[0] != "http":
                app_profiles = [obj for obj in
                                avi_config["ApplicationProfile"]
                                if obj['name'] == app_prof[0]]
                if app_profiles[0]["type"] == \
                        'APPLICATION_PROFILE_TYPE_HTTP':
                    app_profiles[0]["http_profile"][
                        "ssl_client_certificate_mode"] = ssl_vs[0]["mode"]
                    app_profiles[0]["http_profile"]["pki_profile_ref"] = \
                        '%s:%s' % (tenant_ref, ssl_vs[0]["pki"])

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
        skipped = [attr for attr in skipped if attr not in user_ignore]
        conv_status['skipped'] = skipped
        status = 'successful'
        if skipped:
            status = 'partial'
        conv_status['status'] = status
        conv_utils.add_conv_status('virtual', None, vs_name,
                                   conv_status, vs_obj)

        return vs_obj

    def create_vs_datascript(self, rule, avi_config, tenant):
        vs_ds_ref = rule + '-vs-datascript-dummy'
        if self.check_vs_datascript_ref_already_exist(vs_ds_ref, avi_config['VSDataScriptSet']):
            return vs_ds_ref
        vs_ds = {
            'name': vs_ds_ref,
            'datascript': [],
            'tenant_ref': tenant
        }

        datascript = {
            'evt': 'VS_DATASCRIPT_EVT_HTTP_REQ',
            'script': 'host = avi.http.host()'
        }
        if rule == '_sys_https_redirect':
            datascript['script'] = 'avi.http.redirect("https://" .. avi.http.hostname() .. avi.http.get_uri())'
        vs_ds['datascript'].append(datascript)
        avi_config['VSDataScriptSet'].append(vs_ds)
        LOG.info('Add new dummy data script : %s' % vs_ds_ref)
        conv_utils.add_status_row('datascript', None, vs_ds_ref, 'successful')

        return vs_ds_ref

    def check_vs_datascript_ref_already_exist(self, vs_ds_ref, datascript_config):
        ref  = [ds['name'] for ds in datascript_config if ds['name'] == vs_ds_ref]
        if ref:
            LOG.warning('Already data script present : %s' % vs_ds_ref)
            return True
        return False

class VSConfigConvV11(VSConfigConv):
    supported_attr = ['profiles', 'destination', 'pool', 'persist',
                      'source-address-translation', 'description', 'disabled',
                      'translate-port', 'source', 'rate-limit',
                      'connection-limit']
    ignore_for_value = {'ip-protocol': 'tcp', 'translate-address': 'enabled',
                        'mask': ['255.255.255.255', 'any']
                        }
    unsupported_types = ["l2-forward", "ip-forward", "stateless", "dhcp-relay",
                         "internal", "reject"]
    connection_limit = 'connection-limit'

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        if persist_ref:
            persist_ref = persist_ref.keys()[0]
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        port_translate = f5_vs.get('translate-port', None)
        if port_translate:
            vs_type = conv_utils.get_app_profile_type(app_prof, avi_config)
            l4_type = 'APPLICATION_PROFILE_TYPE_L4'
            if port_translate == 'disabled' and vs_type == l4_type:
                conv_utils.update_pool_for_service_port(avi_config['Pool'],
                                                        pool_ref)
            elif port_translate == 'enabled':
                return
            else:
                skipped.append('translate-port')


class VSConfigConvV10(VSConfigConv):
    supported_attr = ['profiles', 'destination', 'pool', 'persist', 'disabled',
                      'description', 'snatpool', 'translate service', 'source',
                      'limit']
    ignore_for_value = {'ip protocol': 'tcp', 'translate address': 'enabled',
                        'mask': ['255.255.255.255', 'any']}
    unsupported_types = ["l2 forward", "ip forward", "stateless", "reject"]
    connection_limit = 'limit'
    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               skipped):
        port_translate = f5_vs.get('translate service', None)
        if port_translate:
            vs_type = conv_utils.get_app_profile_type(app_prof, avi_config)
            l4_type = 'APPLICATION_PROFILE_TYPE_L4'
            if port_translate == 'disabled' and vs_type == l4_type:
                conv_utils.update_pool_for_service_port(avi_config['Pool'],
                                                        pool_ref)
            elif port_translate == 'enabled':
                return
            else:
                skipped.append('translate service')
