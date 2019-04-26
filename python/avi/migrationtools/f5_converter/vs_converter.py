import logging
import copy
import random
import re
import avi.migrationtools.f5_converter.converter_constants as final
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.f5_converter.policy_converter import used_pools
from avi.migrationtools.avi_migration_utils import update_count
from pkg_resources import parse_version

LOG = logging.getLogger(__name__)
# Creating f5 object for util library.
conv_utils = F5Util()
used_policy=[]

class VSConfigConv(object):
    @classmethod
    def get_instance(cls, version, f5_virtualservice_attributes, prefix,
                     con_snatpool, custom_mappings):
        """

        :param version:  version of f5 instance
        :param f5_virtualservice_attributes: yaml attribute file for object
        :param prefix: prefix for objects
        :param con_snatpool: flag for converting snat into  individual address
        :param custom_mappings: custom config to migrate irules
        :return:
        """
        if version == '10':
            return VSConfigConvV10(f5_virtualservice_attributes, prefix,
                                   con_snatpool, custom_mappings)
        if version in ['11', '12']:
            return VSConfigConvV11(f5_virtualservice_attributes, prefix,
                                   con_snatpool, custom_mappings)

    def get_persist_ref(self, f5_vs):
        pass

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               sys_dict):
        pass

    def create_partition_mapping(self, f5_vs, vs_name):
        dest = f5_vs['destination']
        tenant, vs_name = conv_utils.get_tenant_ref(vs_name)
        if not tenant:
            tenant = 'admin'
        if not tenant in dest:
            vip = dest
        else:
            vip = dest.split('/')[-1]
        p_mapping = {
            vip: {
                'vs_name': vs_name,
                'partition': tenant
            }
        }
        return p_mapping


    def convert(self, f5_config, avi_config, vs_state, user_ignore, tenant,
                cloud_name, controller_version, merge_object_mapping, sys_dict,
                vrf=None, segroup=None, partition_mapping=None):
        """

        :param f5_config: Parsed f5 config dict
        :param avi_config: dict for avi conversion
        :param vs_state: State of created Avi VS object
        :param user_ignore: Ignore config defined by user
        :param tenant: Tenant for which config need to be converted
        :param cloud_name: cloud for which config need to be converted
        :param controller_version: AVI controller version
        :param merge_object_mapping: flag for merge object
        :param sys_dict: baseline profile dict
        :param vrf: vrf user input to put vrf ref in VS object
        :param segroup: segroup user input to put se-group ref in VS object
        :return:
        """
        f5_snat_pools = f5_config.get("snatpool", {})
        vs_config = f5_config.get("virtual", {})
        avi_config['VirtualService'] = []
        avi_config['VSDataScriptSet'] = []
        avi_config['NetworkSecurityPolicy'] = []
        avi_config['VsVip'] = []
        print "Converting VirtualServices ..."
        # Added variable to get total object count.
        total_size = len(vs_config.keys())
        progressbar_count = 0
        for vs_name in vs_config.keys():
            progressbar_count += 1
            try:
                LOG.debug("Converting VS: %s" % vs_name)
                f5_vs = vs_config[vs_name]
                vs_type = [key for key in f5_vs.keys()
                           if key in self.unsupported_types]
                if vs_type:
                    msg = ("VS type: %s not supported by Avi skipped VS: %s" %
                           (vs_type, vs_name))
                    LOG.warn(msg)
                    conv_utils.add_status_row('virtual', None, vs_name,
                                              final.STATUS_SKIPPED, msg)
                    continue
                mapping = self.create_partition_mapping(f5_vs, vs_name)
                partition_mapping.update(mapping)

                vs_obj = self.convert_vs(
                    vs_name, f5_vs, vs_state, avi_config, f5_snat_pools,
                    user_ignore, tenant, cloud_name, controller_version,
                    merge_object_mapping, sys_dict, f5_config, vrf)
                if vs_obj:
                    if segroup:
                        segroup_ref = conv_utils.get_object_ref(
                            segroup, 'serviceenginegroup', tenant=tenant,
                            cloud_name=cloud_name)
                        vs_obj['se_group_ref'] = segroup_ref
                    avi_config['VirtualService'].append(vs_obj)
                    LOG.debug("Conversion successful for VS: %s" % vs_name)
            except:
                update_count('error')
                LOG.error("Failed to convert VS: %s" % vs_name, exc_info=True)
            # Added call to get the progress.
            msg = "virtualservice conversion started..."
            conv_utils.print_progress_bar(
                progressbar_count, total_size, msg, prefix='Progress',
                suffix='')
        LOG.debug("Converted %s VS" % len(avi_config['VirtualService']))
        f5_config.pop("virtual", {})

    def convert_vs(self, vs_name, f5_vs, vs_state, avi_config, snat_config,
                   user_ignore, tenant_ref, cloud_name, controller_version,
                   merge_object_mapping, sys_dict, f5_config, vrf=None):
        """

        :param vs_name: name of virtual service.
        :param f5_vs: parsed dict of f5 virtual service.
        :param vs_state: State of created Avi VS object
        :param avi_config: dict for avi conversion
        :param snat_config: parsed source address translation dict
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: Tenant for which config need to be converted
        :param cloud_name: cloud for which config need to be converted
        :param controller_version: AVI controller version
        :param merge_object_mapping: Flag to merge object
        :param sys_dict: Baseline dict
        :param vrf: vrf user input to put vrf ref in VS object
        :return:
        """
        needs_review = False
        tenant, vs_name = conv_utils.get_tenant_ref(vs_name)
        tenant_name = tenant
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        # Added prefix for objects
        if self.prefix:
            vs_name = '{}-{}'.format(self.prefix, vs_name)
        hash_profiles = avi_config.get('hash_algorithm', [])
        description = f5_vs.get("description", None)
        skipped = [key for key in f5_vs.keys()
                   if key not in self.supported_attr]
        enabled = (vs_state == 'enable')
        if enabled:
            enabled = False if "disabled" in f5_vs.keys() else True
        profiles = f5_vs.get("profiles", {})
        ssl_vs, ssl_pool = conv_utils.get_vs_ssl_profiles(
            profiles, avi_config, self.prefix, merge_object_mapping, sys_dict,
            f5_config)

        if (ssl_vs and len(ssl_vs) > 1) or (ssl_pool and len(ssl_pool)> 1):
            needs_review = True

        oc_prof = False
        for prof in profiles:
            prof_name = prof.split('/')[-1] if '/' in prof else prof
            if prof_name in avi_config.get('OneConnect', []):
                oc_prof = True
        enable_ssl = False
        if ssl_vs:
            enable_ssl = True
        app_prof_conf = conv_utils.get_vs_app_profiles(
            profiles, avi_config, tenant, self.prefix, oc_prof, enable_ssl,
            merge_object_mapping, sys_dict)
        app_prof = app_prof_conf.get('app_prof', None)
        f_host = app_prof_conf.get('f_host', None)
        realm = app_prof_conf.get('realm', None)
        app_pol_name = app_prof_conf.get('app_pol_name', None)

        if not app_prof:
            msg = ('Profile type not supported by Avi Skipping VS : %s'
                   % vs_name)
            LOG.warning(msg)
            conv_utils.add_status_row('virtual', None, vs_name,
                                      final.STATUS_SKIPPED, msg)
            return None

        ntwk_prof = conv_utils.get_vs_ntwk_profiles(
            profiles, avi_config, self.prefix, merge_object_mapping, sys_dict)

        # If one connect profile is not assigned to f5 VS and avi app profile
        # assigned to VS has connection_multiplexing_enabled value True then
        # clone profile and make connection_multiplexing_enabled as False
        pool_ref = f5_vs.get("pool", None)
        app_name = conv_utils.get_name(app_prof[0])
        app_prof_obj = [obj for obj in (sys_dict['ApplicationProfile'] +
                                        avi_config['ApplicationProfile']) if
                        obj['name'] == app_name]
        cme = True
        app_prof_type = None
        if app_prof_obj:
            app_prof_type = app_prof_obj[0].get('type')
        else:
            if app_name == 'System-L4-Application':
                app_prof_type = 'APPLICATION_PROFILE_TYPE_L4'
            elif app_name in ['System-HTTP', 'System-Secure-HTTP']:
                app_prof_type = 'APPLICATION_PROFILE_TYPE_HTTP'
            elif app_name == 'System-SSL-Application':
                app_prof_type = 'APPLICATION_PROFILE_TYPE_SSL'

        if app_prof_type == 'APPLICATION_PROFILE_TYPE_HTTP':
            cme = app_prof_obj[0]['http_profile'].get(
                'connection_multiplexing_enabled', False)
        if app_prof_obj and not (cme and oc_prof):
            # Check if already cloned profile present
            app_prof_cmd = [obj for obj in (
                    sys_dict['ApplicationProfile'] +
                    avi_config['ApplicationProfile']) if
                            obj['name'] == '%s-cmd' % app_name]
            if app_prof_cmd:
                app_name = app_prof_cmd[0]['name']
                app_prof[0] = conv_utils.get_object_ref(
                    app_name, 'applicationprofile',
                    tenant=conv_utils.get_name(app_prof_cmd[0]['tenant_ref']))
            else:
                app_prof_cmd = copy.deepcopy(app_prof_obj[0])
                app_prof_cmd['name'] = '%s-cmd' % app_prof_cmd['name']
                if 'http_profile' in app_prof_cmd:
                    app_prof_cmd['http_profile'][
                        'connection_multiplexing_enabled'] = False
                avi_config['ApplicationProfile'].append(app_prof_cmd)
                app_name = app_prof_cmd['name']
                app_prof[0] = conv_utils.get_object_ref(
                    app_name, 'applicationprofile',
                    tenant=conv_utils.get_name(app_prof_cmd['tenant_ref']))
        destination = f5_vs.get("destination", None)
        d_tenant, destination = conv_utils.get_tenant_ref(destination)
        # if destination is not present then skip vs.
        services_obj, ip_addr, vsvip_ref, vrf_ref = conv_utils.get_service_obj(
            destination, avi_config, enable_ssl, controller_version, tenant,
            cloud_name, self.prefix, vs_name, vrf)
        # Added check for same vip in same vrf
        if vsvip_ref == '':
            msg = "Skipped: Virtualservice %s has repeated vip not in " \
                  "different vrf" % vs_name
            LOG.debug(msg)
            conv_utils.add_status_row('virtual', None, vs_name,
                                      final.STATUS_SKIPPED, msg)
            return
        # Added Check for if port is no digit skip vs.
        if not services_obj and not ip_addr and not vsvip_ref:
            msg = "Skipped Virtualservice : %s" % vs_name
            LOG.debug(msg)
            conv_utils.add_status_row('virtual', None, vs_name,
                                      final.STATUS_SKIPPED, msg)
            return

        is_pool_group = False
        if pool_ref:
            p_tenant, pool_ref = conv_utils.get_tenant_ref(pool_ref)
            if not tenant_ref == 'admin':
                p_tenant = tenant_ref
            persist_ref = self.get_persist_ref(f5_vs)
            avi_persistence = avi_config['ApplicationPersistenceProfile']
            syspersist = sys_dict['ApplicationPersistenceProfile']
            persist_type = None
            if persist_ref:
                # Called tenant ref to get object name
                persist_ref = conv_utils.get_tenant_ref(persist_ref)[1]
                if self.prefix:
                    persist_ref = '{}-{}'.format(self.prefix, persist_ref)
                persist_profile_objs = (
                        [ob for ob in syspersist if ob['name'] ==
                         merge_object_mapping['app_per_profile'].get(
                             persist_ref)] or
                        [obj for obj in avi_persistence if
                         (obj["name"] == persist_ref or persist_ref in obj.get(
                             "dup_of", []))])
                persist_type = (persist_profile_objs[0]['persistence_type'] if
                                persist_profile_objs else None)
            # Pool cloned if controller version < 17.1.6 or VS has non http
            # cookie persistence or app profile type is different and poolgroup
            # cloned
            pool_ref, is_pool_group = conv_utils.clone_pool_if_shared(
                pool_ref, avi_config, vs_name, tenant, p_tenant, persist_type,
                controller_version, app_prof[0], sys_dict,
                cloud_name=cloud_name, prefix=self.prefix)
            if ssl_pool:
                if is_pool_group:
                    conv_utils.add_ssl_to_pool_group(avi_config, pool_ref,
                                                     ssl_pool[0], tenant)
                    conv_utils.remove_http_mon_from_pool_group(
                        avi_config, pool_ref, tenant, sys_dict)
                else:
                    conv_utils.add_ssl_to_pool(avi_config['Pool'], pool_ref,
                                               ssl_pool[0], tenant)
                    conv_utils.remove_http_mon_from_pool(
                        avi_config, pool_ref, tenant, sys_dict)
            else:
                # TODO Remove this once controller support this scenario.
                if is_pool_group:
                    conv_utils.remove_https_mon_from_pool_group(
                        avi_config, pool_ref, tenant, sys_dict)
                else:
                    conv_utils.remove_https_mon_from_pool(
                        avi_config, pool_ref, tenant, sys_dict)

            persist_type = None
            if persist_ref:
                if is_pool_group:
                    pool_updated, persist_type = \
                        conv_utils.update_pool_group_for_persist(
                            avi_config, pool_ref, persist_ref, hash_profiles,
                            avi_persistence, tenant, merge_object_mapping,
                            syspersist, app_prof_type)
                else:
                    pool_updated, persist_type = \
                        conv_utils.update_pool_for_persist(
                            avi_config['Pool'], pool_ref, persist_ref,
                            hash_profiles, avi_persistence, tenant,
                            merge_object_mapping, syspersist, app_prof_type)

                if not pool_updated:
                    skipped.append("persist")
                    LOG.warning(
                        "persist profile %s not found for vs:%s" %
                        (persist_ref, vs_name))
            if (oc_prof and not ssl_vs and
                    persist_type == 'PERSISTENCE_TYPE_TLS' or
                    persist_type == 'PERSISTENCE_TYPE_TLS'
                    and not enable_ssl):
                msg = ("Skipped VS : '%s' Secure persistence is applicable only"
                       " if SSL is enabled for Virtual Service" % vs_name)
                LOG.warning(msg)
                conv_utils.add_status_row('virtual', None, vs_name,
                                          final.STATUS_SKIPPED, msg)
                return
            # TODO: Followiong condition to be removed after controller adds
            # TODO: support for PERSISTENCE_TYPE_TLS for SSL VS
            elif (persist_type == 'PERSISTENCE_TYPE_TLS' and
                  app_prof_type == 'APPLICATION_PROFILE_TYPE_SSL'):
                msg = ("Skipped VS : '%s' Only client-ip persistence is "
                       "applicable for SSL VS" % vs_name)
                LOG.warning(msg)
                conv_utils.add_status_row('virtual', None, vs_name,
                                          final.STATUS_SKIPPED, msg)
                return
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
            'vip_id': '1'
        }
        vs_obj = {
            'name': vs_name,
            'description': description,
            'type': 'VS_TYPE_NORMAL',
            'enabled': True,
            'traffic_enabled': enabled,
            'cloud_ref': conv_utils.get_object_ref(
                cloud_name, 'cloud', tenant=tenant),
            'services': services_obj,
            'application_profile_ref': app_prof[0],
            'vs_datascripts': [],
            'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant')
        }
        if vrf:
            vrf_ref = conv_utils.get_object_ref(vrf, 'vrfcontext',
                                                tenant=tenant_name,
                                                cloud_name=cloud_name)
        if vrf_ref:
            vs_obj['vrf_context_ref'] = vrf_ref
            # Added code for assigning VS's vrf ref to poolgroup/pool having no
            # vrf ref
            if is_pool_group:
                conv_utils.set_pool_group_vrf(pool_ref, vrf_ref, avi_config)
            elif pool_ref:
                conv_utils.set_pool_vrf(pool_ref, vrf_ref, avi_config)
        else:
            # Added code for removing vrf ref from poolgroup/pool if VS is not
            # having vrf ref
            if is_pool_group:
                conv_utils.remove_pool_group_vrf(pool_ref, avi_config)
            elif pool_ref:
                conv_utils.remove_pool_vrf(pool_ref, avi_config)
        if parse_version(controller_version) >= parse_version('17.1'):
            vs_obj['vip'] = [vip]
            vs_obj['vsvip_ref'] = vsvip_ref
        else:
            vs_obj['ip_address'] = vip['ip_address']
        # Policy tracking starts from here
        vs_policies = [app_pol_name] if app_pol_name else []
        vs_ds_rules = None
        vs_ds = list()
        nw_policy = None
        converted_rules = list()
        if 'rules' in f5_vs:
            if isinstance(f5_vs['rules'], basestring):
                vs_ds_rules = [conv_utils.get_tenant_ref(f5_vs['rules'])[1]]
            else:
                vs_ds_rules = [conv_utils.get_tenant_ref(name)[1] for name in
                               f5_vs['rules'].keys()]

            vs_ds, req_policies, nw_policy, converted_rules = (
                conv_utils.convert_irules(
                    vs_ds_rules, self.rule_config, avi_config, self.prefix,
                    vs_name, tenant))
            vs_policies = vs_policies + req_policies
        if vs_ds:
            vs_datascripts = []
            index = 1
            for ds in vs_ds:
                vs_datascripts.append(
                    {
                        "index": index,
                        "vs_datascript_set_ref": conv_utils.get_object_ref(
                            ds, 'vsdatascriptset', tenant=tenant)
                    }
                )
                index += 1
            vs_obj['vs_datascripts'] = vs_datascripts

        if 'policies' in f5_vs:
            if isinstance(f5_vs['policies'], basestring):
                vs_policies.extend(['%s-%s' % (
                    self.prefix, conv_utils.get_tenant_ref(
                        f5_vs['policies'])[1]) if self.prefix else
                                    conv_utils.get_tenant_ref(
                                        f5_vs['policies'])[1]])
            else:
                vs_policies.extend(['%s-%s' % (
                    self.prefix, conv_utils.get_tenant_ref(name)[1]) if
                                    self.prefix else conv_utils.get_tenant_ref(
                    name)[1] for name in f5_vs['policies'].keys()])
        if app_prof_obj and 'HTTPPolicySet' in app_prof_obj[0]:
            vs_policies.append(app_prof_obj[0]['HTTPPolicySet'])
        if vs_policies:
            self.get_policy_vs(vs_policies, avi_config, vs_name, tenant,
                               cloud_name, vs_obj)
        p_ref = None
        if is_pool_group:
            p_ref = conv_utils.get_object_ref(
                pool_ref, 'poolgroup', tenant=p_tenant)
        elif pool_ref:
            p_ref = conv_utils.get_object_ref(
                pool_ref, 'pool', tenant=p_tenant)
        if p_ref and used_pools.get(p_ref):
            not_same = [pol_obj for pol_obj in used_pools[p_ref] if pol_obj
                        not in vs_policies]
            if not_same:
                if is_pool_group:
                    LOG.debug('Pool group %s attached to vs %s is shared '
                              'with policy %s of another vs, hence cloned',
                              pool_ref, vs_name, str(not_same))
                    pool_ref = conv_utils.clone_pool_group(
                        pool_ref, vs_name, avi_config, False, p_tenant,
                        cloud_name=cloud_name)
                else:
                    LOG.debug('Pool %s attached to vs %s is shared with '
                              'policy %s of another vs, hence cloned', pool_ref,
                              vs_name, str(not_same))
                    pool_ref = conv_utils.clone_pool(
                        pool_ref, vs_name, avi_config['Pool'], False, p_tenant)
        if is_pool_group:
            vs_obj['pool_group_ref'] = conv_utils.get_object_ref(
                pool_ref, 'poolgroup', tenant=tenant, cloud_name=cloud_name)
        elif pool_ref:
            vs_obj['pool_ref'] = conv_utils.get_object_ref(
                pool_ref, 'pool', tenant=tenant, cloud_name=cloud_name)
        # app prof ref is not used inside the below method call
        self.convert_translate_port(avi_config, f5_vs, app_prof[0], pool_ref,
                                    sys_dict)
        conn_limit = int(f5_vs.get(self.connection_limit, '0'))
        if conn_limit > 0:
            vs_obj["performance_limits"] = {
                "max_concurrent_connections": conn_limit
            }
        rate_limit = int(f5_vs.get('rate-limit', '0'))
        if rate_limit > 0:
            vs_obj["connections_rate_limit"] = {
                "count": rate_limit,
                'explicit_tracking': False,
                'period': 1,
                'action': {
                    'status_code': 'HTTP_LOCAL_RESPONSE_STATUS_CODE_429',
                    'type': "RL_ACTION_NONE"
                },
                'burst_sz': 0,
                'fine_grain': False
            }

        if realm:
            vs_obj['client_auth'] = realm

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
            if self.prefix:
                policy_name = '%s-%s' % (self.prefix, policy_name)
            policy = conv_utils.create_network_security_rule(
                policy_name, parts[0], mask, tenant)

            if nw_policy:
                old_policy = [obj for obj in avi_config['NetworkSecurityPolicy']
                              if obj['name'] == nw_policy][0]
                policy['rules'][0]['index'] = 2
                policy['rules'][0]['name'] = 'Rule 2'
                old_policy['rules'].append(policy['rules'][0])
            else:
                avi_config['NetworkSecurityPolicy'].append(policy)
                nw_policy = policy_name

        if nw_policy:
            vs_obj['network_security_policy_ref'] = conv_utils.get_object_ref(
                nw_policy, 'networksecuritypolicy', tenant=tenant)

        # Checking snat conversion flag and snat info for creating
        # snat ip object
        snat = f5_vs.get("source-address-translation", {})
        snat_pool_name = snat.get("pool", f5_vs.get("snatpool", None))
        snat_pool = snat_config.pop(snat_pool_name, None)
        if snat_pool:
            if self.con_snatpool:
                LOG.debug("Converting the snat as input flag and snat "
                          "information is set")
                snat_list = conv_utils.get_snat_list_for_vs(snat_pool)
                if len(snat_list) > 32:
                    vs_obj["snat_ip"] = snat_list[0:32]
                    LOG.warning('Ignore the snat IPs, its count is beyond 32 '
                                'for vs : %s' % vs_name)
                else:
                    vs_obj["snat_ip"] = snat_list
                conv_status = {'status': final.STATUS_SUCCESSFUL}
                message = 'Mapped indirectly to VS -> SNAT IP Address'
                conv_utils.add_conv_status('snatpool', '', snat_pool_name,
                                           conv_status, message)
            else:
                msg = ("Skipped: snat conversion as input flag is not set"
                       " for vs : %s" % vs_name)
                LOG.debug(msg)
                conv_status = {'status': final.STATUS_SKIPPED}
                skipped.append("source-address-translation" if f5_vs.get(
                    "source-address-translation") else "snatpool" if f5_vs.get(
                    "snatpool") else None)
                conv_utils.add_conv_status('snatpool', '', snat_pool_name,
                                           conv_status, msg)
        if ntwk_prof:
            vs_obj['network_profile_ref'] = ntwk_prof[0]
        if enable_ssl:
            vs_obj['ssl_profile_ref'] = ssl_vs[0]["profile"]
            if ssl_vs[0]["cert"]:
                vs_obj['ssl_key_and_certificate_refs'] = [ssl_vs[0]["cert"]]
            if ssl_vs[0]["pki"] and app_name != "http":
                app_profiles = [obj for obj in (
                        sys_dict['ApplicationProfile'] +
                        avi_config['ApplicationProfile'])
                                if obj['name'] == app_name]
                if app_profiles[0]["type"] == \
                        'APPLICATION_PROFILE_TYPE_HTTP':
                    app_profiles[0]["http_profile"][
                        "ssl_client_certificate_mode"] = ssl_vs[0]["mode"]
                    app_profiles[0]["http_profile"]["pki_profile_ref"] = \
                        ssl_vs[0]["pki"]

        # Added code to skipped L4 VS if pool or pool group not present
        if vs_obj['application_profile_ref']:
            application_profile_obj = \
                [obj for obj in (sys_dict['ApplicationProfile'] +
                                 avi_config['ApplicationProfile'])
                 if obj['name'] == app_name]
            if application_profile_obj and application_profile_obj[0]['type'] \
                    == 'APPLICATION_PROFILE_TYPE_L4':
                if not vs_obj.get('pool_ref', vs_obj.get('pool_group_ref')):
                    msg = ("Failed to convert L4 VS dont have pool or pool "
                           "group ref: %s" % vs_name)
                    LOG.debug(msg)
                    conv_utils.add_status_row('virtual', None,
                                              vs_name,
                                              final.STATUS_SKIPPED,
                                              msg)
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
            vs_ds.append('_sys_https_redirect')
            skipped_rules = [rule for rule in vs_ds_rules if rule not in
                             converted_rules]
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
        review_flag = 'Yes' if needs_review else None
        conv_utils.add_conv_status('virtual', None, vs_name,
                                   conv_status, vs_obj, review_flag)

        return vs_obj

    def get_policy_vs(self, vs_policies, avi_config, vs_name, tenant,
                      cloud_name, vs_obj):
        """
        This method gets all the policy attached to vs, also clone it if
        required
        :param vs_policies: dict of policies
        :param avi_config: dict for avi conversion
        :param vs_name: name of vs
        :param tenant: tenant for which output to converted
        :param cloud_name: cloud for which output to converted
        :param vs_obj: virtualservice object
        :return:
        """
        for pol_name in vs_policies:
            policy_obj = [ob for ob in avi_config['HTTPPolicySet'] if ob[
                'name'] == pol_name]
            if policy_obj:
                if pol_name in used_policy:
                    LOG.debug('Cloning the policy %s for vs %s',
                              pol_name, vs_name)
                    clone_policy = conv_utils.clone_http_policy_set(
                        policy_obj[0], vs_name, avi_config, tenant, cloud_name)
                    pol_name = clone_policy['name']
                    pol_tenant = conv_utils.get_name(clone_policy['tenant_ref'])
                    if pol_tenant == tenant:
                        avi_config['HTTPPolicySet'].append(clone_policy)
                        LOG.debug('Policy cloned %s for vs %s', pol_name,
                                  vs_name)
                    else:
                        LOG.debug('Policy with different tenant not '
                                   'supported  %s for vs %s', pol_name,
                                  vs_name)
                        continue
                used_policy.append(pol_name)
                pol = {
                    'index': 11,
                    'http_policy_set_ref':
                        conv_utils.get_object_ref(
                            pol_name, 'httppolicyset',
                            tenant=conv_utils.get_name(
                                policy_obj[0]['tenant_ref']))
                }
                if not vs_obj.get('http_policies'):
                    vs_obj['http_policies'] = []
                else:
                    ind = max([pol_index['index'] for pol_index in vs_obj[
                        'http_policies']])
                    pol['index'] = ind + 1
                vs_obj['http_policies'].append(pol)


class VSConfigConvV11(VSConfigConv):
    def __init__(self, f5_virtualservice_attributes, prefix, con_snatpool,
                 custom_mappings):
        """

        :param f5_virtualservice_attributes: yaml attribute file for object
        :param prefix: prefix for object
        :param con_snatpool: flag for snat conversion
        :param custom_mappings: custom config to migrate irules
        """
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
        self.rule_config = custom_mappings.get(
            final.RULE_CUSTOM_KEY, dict()
        ) if custom_mappings else dict()

    def get_persist_ref(self, f5_vs):
        """

        :param f5_vs:  parsed f5 vs dict
        :return:
        """
        persist_ref = f5_vs.get("persist", None)
        if persist_ref:
            persist_ref = persist_ref.keys()[0]
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               sys_dict):
        """
        This method looks for translate-port property and sets the service
        port in pool and remove the monitor if monitor don't have port
        :param avi_config: dict for avi conversion
        :param f5_vs: parsed f5 vs dict
        :param app_prof: application profile
        :param pool_ref: pool reference name
        :param sys_dict: baseline dict
        :return:
        """
        port_translate = f5_vs.get('translate-port', None)
        if port_translate:
            if port_translate == 'disabled':
                conv_utils.update_pool_for_service_port(
                    avi_config['Pool'], pool_ref, avi_config['HealthMonitor'],
                    sys_dict['HealthMonitor'])
            elif port_translate == 'enabled':
                return

class VSConfigConvV10(VSConfigConv):
    def __init__(self, f5_virtualservice_attributes, prefix, con_snatpool,
                 custom_mappings):
        """

        :param f5_virtualservice_attributes: yaml attribute file for object
        :param prefix: prefix for object
        :param con_snatpool: flag for snat conversion
        :param custom_mappings: custom config to migrate irules
        """
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
        self.rule_config = custom_mappings.get(
            final.RULE_CUSTOM_KEY, dict()
        ) if custom_mappings else dict()

    def get_persist_ref(self, f5_vs):
        persist_ref = f5_vs.get("persist", None)
        return persist_ref

    def convert_translate_port(self, avi_config, f5_vs, app_prof, pool_ref,
                               sys_dict):
        """
        This method looks for translate-port property and sets the service
        port in pool and remove the monitor if monitor don't have port
        :param avi_config: dict for avi conversion
        :param f5_vs: parsed f5 vs dict
        :param app_prof: application profile
        :param pool_ref: pool reference name
        :param sys_dict: baseline dict
        :return:
        """
        port_translate = f5_vs.get('translate service', None)
        if port_translate:
            if port_translate == 'disabled':
                conv_utils.update_pool_for_service_port(
                    avi_config['Pool'], pool_ref, avi_config['HealthMonitor'],
                    sys_dict['HealthMonitor'])
            elif port_translate == 'enabled':
                return
