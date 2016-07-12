import logging

import avi.f5_converter.conversion_util as conv_utils

LOG = logging.getLogger(__name__)


class VSConfigConv(object):
    @classmethod
    def get_instance(cls, version):
        if version == '10':
            return VSConfigConvV10()
        if version == '11':
            return VSConfigConvV11()

    def get_persist_ref(self, f5_vs):
        pass

    supported_attr = None

    def convert(self, f5_config, avi_config, vs_state, user_ignore):
        f5_snat_pools = f5_config.get("snatpool", {})
        vs_config = f5_config.get("virtual", {})
        avi_config['VirtualService'] = []
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
                                         f5_snat_pools, user_ignore)
                avi_config['VirtualService'].append(vs_obj)
                LOG.debug("Conversion successful for VS: %s" % vs_name)
            except:
                LOG.error("Failed to convert VS: %s" % vs_name, exc_info=True)

        LOG.debug("Converted %s VS" % len(avi_config['VirtualService']))
        f5_config.pop("virtual", {})

    def convert_vs(self, vs_name, f5_vs, vs_state, avi_config, snat_config,
                   user_ignore):
        tenant, vs_name = conv_utils.get_tenant_ref(vs_name)
        hash_profiles = avi_config.get('hash_algorithm', [])
        description = f5_vs.get("description", None)
        skipped = [key for key in f5_vs.keys()
                   if key not in self.supported_attr]
        enabled = (vs_state == 'enable')
        if enabled:
            enabled = False if "disabled" in f5_vs.keys() else True
        profiles = f5_vs.get("profiles", None)
        ssl_vs, ssl_pool = conv_utils.get_vs_ssl_profiles(profiles, avi_config)
        app_prof, f_host, realm, policy_set = conv_utils.get_vs_app_profiles(
            profiles, avi_config)
        ntwk_prof = conv_utils.get_vs_ntwk_profiles(profiles, avi_config)
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
        if pool_ref:
            p_tenant, pool_ref = conv_utils.get_tenant_ref(pool_ref)
            if p_tenant:
                shared_vs = [obj for obj in avi_config['VirtualService']
                             if obj.get("pool_ref", "") == '%s:%s' % (
                                 p_tenant, pool_ref)]
            else:
                shared_vs = [obj for obj in avi_config['VirtualService']
                             if obj.get("pool_ref", "") == pool_ref]
                if tenant:
                    pool_ref = conv_utils.clone_pool(
                        pool_ref, vs_name, avi_config['Pool'], tenant)
            if shared_vs:
                pool_ref = conv_utils.clone_pool(pool_ref, vs_name,
                                                 avi_config['Pool'])
            if ssl_pool:
                conv_utils.add_ssl_to_pool(avi_config['Pool'], pool_ref,
                                           ssl_pool[0])
            persist_ref = self.get_persist_ref(f5_vs)
            if persist_ref:
                avi_persistence = avi_config.get(
                    'ApplicationPersistenceProfile', [])
                pool_updated = conv_utils.update_pool_for_persist(
                    avi_config['Pool'], pool_ref, persist_ref, hash_profiles,
                    avi_persistence)
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
            'application_profile_ref': app_prof[0],
            'pool_ref': pool_ref
        }

        if tenant:
            vs_obj['tenant_ref'] = tenant

        if realm:
            vs_obj['client_auth'] = realm

        if policy_set:
            vs_obj['http_policies'] = policy_set

        snat = f5_vs.get("source-address-translation", {})
        snat_pool_name = snat.get("pool", None)
        if not snat_pool_name:
            snat_pool_name = f5_vs.get("snatpool", None)
        snat_pool = None
        if snat_pool_name:
            snat_pool = snat_config.pop(snat_pool_name, None)
        if snat_pool:
            snat_list = conv_utils.get_snat_list_for_vs(snat_pool)
            vs_obj["snat_ip"] = snat_list
        if ntwk_prof:
            vs_obj['network_profile_ref'] = ntwk_prof[0]
        if enable_ssl:
            vs_obj['ssl_profile_name'] = ssl_vs[0]["profile"]
            if ssl_vs[0]["cert"]:
                vs_obj['ssl_key_and_certificate_refs'] = [ssl_vs[0]["cert"]]
            if ssl_vs[0]["pki"] and app_prof[0] != "http":
                app_profiles = [obj for obj in
                                avi_config["ApplicationProfile"]
                                if obj['name'] == app_prof[0]]
                if app_profiles[0]["type"] == \
                        'APPLICATION_PROFILE_TYPE_HTTP':
                    app_profiles[0]["http_profile"][
                        "ssl_client_certificate_mode"] = \
                        "SSL_CLIENT_CERTIFICATE_REQUEST"
                    app_profiles[0]["http_profile"]["pki_profile_ref"] = \
                        ssl_vs[0]["pki"][0]["name"]

        conv_status = dict()
        conv_status['user_ignore'] = [val for val in skipped
                                      if val in user_ignore]
        skipped = [attr for attr in skipped if attr not in user_ignore]
        conv_status['skipped'] = skipped
        ststus = 'successful'
        if skipped:
            ststus = 'partial'
        conv_status['ststus'] = ststus
        conv_utils.add_conv_status('virtual', None, vs_name,
                                   conv_status, vs_obj)

        return vs_obj


class VSConfigConvV11(VSConfigConv):
    supported_attr = ['profiles', 'destination', 'pool', 'persist', 'snatpool',
                      'source-address-translation', 'description', 'disabled']
    unsupported_types = ["l2-forward", "ip-forward", "stateless", "dhcp-relay",
                         "internal", "reject"]

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        if persist_ref:
            persist_ref = persist_ref.keys()[0]
        return persist_ref


class VSConfigConvV10(VSConfigConv):
    supported_attr = ['profiles', 'destination', 'pool', 'persist', 'disabled',
                      'description']
    unsupported_types = ["l2 forward", "ip forward", "stateless", "reject"]

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        return persist_ref
