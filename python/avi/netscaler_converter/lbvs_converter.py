import logging
import re

from avi.netscaler_converter import ns_util
from avi.netscaler_converter.ns_constants import STATUS_SKIPPED

LOG = logging.getLogger(__name__)
Redirect_Pools = []
tmp_avi_config = {}

class LbvsConverter(object):

    skip_attrs = ['persistenceBackup', 'backupPersistenceTimeout', 'netmask',
                  'v6netmasklen', 'dataLength', 'dataOffset', 'rule',
                  'Listenpolicy', 'Listenpriority', 'resRule', 'persistMask',
                  'v6persistmasklen', 'pq', 'sc', 'rtspNat', 'sessionless',
                  'connfailover', 'cacheable', 'soMethod', 'soPersistence',
                  'soPersistenceTimeOut', 'healthThreshold', 'soThreshold',
                  'soBackupAction', 'redirectPortRewrite']
    na_attrs = ['l2Conn', 'oracleServerVersion', 'mssqlServerVersion', 'td',
                'mysqlProtocolVersion', 'mysqlServerVersion', 'processLocal',
                'mysqlCharacterSet', 'mysqlServerCapabilities', 'appflowLog',
                'icmpVsrResponse', 'persistAVPno', 'authnProfile', 'bypassAAAA',
                'macmodeRetainvlan', 'dbsLb', 'dns64', 'RecursionAvailable']
    indirect_list = ['hashLength']

    supported_persist_types = ['SOURCEIP', 'COOKIEINSERT', 'SSLSESSION']
    ignore_vals = {'Listenpolicy': 'None'}

    def convert(self, ns_config, avi_config, vs_state):
        lb_vs_conf = ns_config.get('add lb vserver', {})
        avi_config['VirtualService'] = []
        tmp_avi_config['VirtualService'] = []
        avi_config['ApplicationPersistenceProfile'] = []
        supported_types = ['HTTP', 'TCP', 'UDP', 'SSL', 'SSL_BRIDGE', 'SSL_TCP', 'DNS', 'DNS_TCP']
        for key in lb_vs_conf.keys():
            try:
                LOG.debug('LB VS conversion started for: %s' % key)
                lb_vs = lb_vs_conf[key]
                type = lb_vs['attrs'][1]
                cmd = 'add lb vserver'
                full_cmd = ns_util.get_netscalar_full_command(cmd, lb_vs)
                if type not in supported_types:
                    LOG.warning('Unsupported type %s of LB VS: %s' % (type, key))
                    ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
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

                pool_name = '%s-pool' % vs_name
                pool_ref = None
                pool_obj = [pool for pool in avi_config.get("Pool",[])
                            if pool['name'] == pool_name]
                if pool_obj:
                    pool_ref = pool_name
                else:
                    LOG.warn('Pool not found in avi config for LB VS %s' % key)

                redirect_url = lb_vs.get('redirectURL', None)
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
                    if pool_obj:
                        pool_obj[0]["fail_action"] = fail_action
                        Redirect_Pools.append(pool_name)

                http_prof = lb_vs.get('httpProfileName', None)
                app_profile = None
                if http_prof:
                    clttimeout = lb_vs.get('cltTimeout', None)
                    app_profile = http_prof
                    if clttimeout:
                        ns_util.add_clttimeout_for_http_profile(http_prof, avi_config, clttimeout)
                        clt_cmd = cmd + '%s cltTimeout %s' % (key, clttimeout)
                        LOG.info('Conversion successful : %s' % clt_cmd)

                updated_vs_name = re.sub('[:]', '-', vs_name)

                vs_obj = {
                    'name': updated_vs_name,
                    'type': 'VS_TYPE_NORMAL',
                    'ip_address': {
                        'addr': ip_addr,
                        'type': 'V4'
                    },
                    'enabled': enabled,
                    'services': [],
                    }

                if app_profile:
                    vs_obj['application_profile_ref'] = app_profile
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'DNS':
                    vs_obj['application_profile_ref'] = 'admin:System-DNS'
                    vs_obj['network_profile_ref'] = 'admin:System-UDP-Per-Pkt'
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'UDP':
                    vs_obj['application_profile_ref'] = 'admin:System-L4-Application'
                    vs_obj['network_profile_ref'] = 'admin:System-UDP-Fast-Path'
                elif not http_prof and (lb_vs['attrs'][1]).upper() == 'DNS_TCP':
                    vs_obj['application_profile_ref'] = 'admin:System-L4-Application'
                    vs_obj['network_profile_ref'] = 'admin:System-TCP-Proxy'

                if pool_ref:
                    vs_obj['pool_ref'] = pool_ref
                    updated_pool_ref = re.sub('[:]', '-', pool_ref)
                    vs_obj['pool_ref'] = updated_pool_ref
                updated_pool_ref = pool_ref

                if ip_addr == "0.0.0.0" and not redirect_url:
                    ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
                    LOG.error("%s %s Skipped VS, Service point to %s server." % (cmd, key, ip_addr))
                    continue

                service = {'port': port, 'enable_ssl': enable_ssl}
                if port in ("0", "*"):
                    service['port'] = "1"
                    service['port_range_end'] = "65535"
                vs_obj['services'].append(service)

                persistenceType = lb_vs.get('persistenceType','')
                if pool_ref and persistenceType in self.supported_persist_types:
                    timeout = lb_vs.get('timeout', 2)
                    profile_name = '%s-persistance-profile' % vs_name
                    persist_profile = self.convert_persistance_prof(
                        persistenceType, timeout, profile_name)
                    avi_config['ApplicationPersistenceProfile'].append(
                        persist_profile)
                    self.update_pool_for_persist(avi_config, updated_pool_ref,
                                                 profile_name)
                elif not persistenceType == 'NONE':
                    LOG.warn('Persistance type %s not supported by Avi' %
                             persistenceType)
                ntwk_prof = lb_vs.get('tcpProfileName', None)
                if ntwk_prof:
                    if ns_util.object_exist('NetworkProfile', ntwk_prof, avi_config):
                        LOG.info('Conversion successful: Added network profile %s for %s' % (ntwk_prof, vs_name))
                        vs_obj['network_profile_ref'] = ntwk_prof

                if redirect_url:
                    tmp_avi_config['VirtualService'].append(vs_obj)
                else:
                    is_shared = ns_util.is_shared_same_vip(vs_obj, avi_config)
                    if is_shared:
                        ns_util.add_status_row(cmd, key, full_cmd, STATUS_SKIPPED)
                        LOG.warning('Skipped: %s Same vip shares another virtual service' % vs_name)
                        continue
                    avi_config['VirtualService'].append(vs_obj)
                conv_status = ns_util.get_conv_status(
                    lb_vs, self.skip_attrs, self.na_attrs, self.indirect_list,
                    ignore_for_val=self.ignore_vals)
                ns_util.add_conv_status(cmd, key, full_cmd, conv_status, vs_obj)

                if enable_ssl:
                    ssl_mappings = ns_config.get('bind ssl vserver', {})
                    ssl_bindings = ssl_mappings.get(key, [])
                    if isinstance(ssl_bindings, dict):
                        ssl_bindings = [ssl_bindings]
                    for mapping in ssl_bindings:
                        if 'CA' in mapping:
                            #TODO add ref of pki prof in app profile
                            pass
                        elif 'certkeyName' in mapping:
                            avi_ssl_ref = 'ssl_key_and_certificate_refs'
                            if not [obj for obj in avi_config['SSLKeyAndCertificate'] if obj['name'] == mapping['attrs'][0]]:
                                LOG.warn('cannot find ssl key cert ref adding system default insted')
                                vs_obj[avi_ssl_ref] = ['admin:System-Default-Cert']
                                continue
                            vs_obj[avi_ssl_ref] = mapping['attrs'][0]
                    ssl_vs_mapping = ns_config.get('set ssl vserver', {})
                    mapping = ssl_vs_mapping.get(key, None)
                    if mapping and 'sslProfile' in mapping:
                        vs_obj['ssl_profile_name'] = mapping.get('sslProfile')

                LOG.debug('LB VS conversion completed for: %s' % key)
            except:
                LOG.error('Error in lb vs conversion for: %s' %
                          key, exc_info=True)

    def convert_persistance_prof(self, persistenceType, timeout, name):
        profile = None
        if persistenceType == 'COOKIEINSERT':
            profile = {
                "http_cookie_persistence_profile": {
                    "always_send_cookie": False,
                    "timeout": timeout
                },
                "persistence_type": "PERSISTENCE_TYPE_HTTP_COOKIE",
                "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
                "name": name
            }
        elif persistenceType == 'SOURCEIP':
            timeout = int(timeout)/60
            if timeout < 1:
                timeout = 1
            profile = {
              "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
              "persistence_type": "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS",
              "ip_persistence_profile": {
                "ip_persistent_timeout": timeout
              },
              "name": name
            }
        elif persistenceType == 'SSLSESSION':
            profile = {
                "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
                "persistence_type": "PERSISTENCE_TYPE_TLS",
                "name": name
            }
        return profile

    def update_pool_for_persist(self, avi_config, pool_ref, profile_name):
        pool_obj = [pool for pool in avi_config['Pool']
                    if pool["name"] == pool_ref]
        if not pool_obj:
            LOG.error("Pool %s not found to add profile %s" %
                      (pool_ref, profile_name))
        pool_obj = pool_obj[0]
        persist_ref_key = "application_persistence_profile_ref"
        pool_obj[persist_ref_key] = profile_name

