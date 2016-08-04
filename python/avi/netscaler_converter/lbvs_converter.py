import logging

from avi.netscaler_converter import ns_util

LOG = logging.getLogger(__name__)

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

    def convert(self, ns_config, avi_config):
        lb_vs_conf = ns_config.get('add lb vserver', {})
        avi_config['VirtualService']=[]
        supported_types = ['HTTP', 'TCP', 'UDP', 'SSL', 'SSL_BRIDGE', 'SSL_TCP']
        for key in lb_vs_conf.keys():
            try:
                LOG.debug('LB VS conversion started for: %s' % key)
                lb_vs = lb_vs_conf[key]
                type = lb_vs['attrs'][1]
                cmd = 'add lb vserver %s' % key
                if type not in supported_types:
                    LOG.warn('Unsupported type %s of VS: %s' % (type, key))
                    ns_util.add_status_row(cmd, 'skipped')
                    continue
                enable_ssl = False
                if type in ['SSL', 'SSL_BRIDGE', 'SSL_TCP']:
                    enable_ssl = True
                vs_name = key
                ip_addr = lb_vs['attrs'][2]
                port = lb_vs['attrs'][3]

                state = lb_vs.get('state', 'ENABLED')
                enabled = True
                if state == 'DISABLED':
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
                    pool_obj[0]["fail_action"] = fail_action

                app_profile = 'System-HTTP'
                http_prof = lb_vs.get('httpProfileName', None)
                if http_prof:
                    app_profile = http_prof

                vs_obj = {
                    'name': vs_name,
                    'type': 'VS_TYPE_NORMAL',
                    'ip_address': {
                        'addr': ip_addr,
                        'type': 'V4'
                    },
                    'enabled': enabled,
                    'services': [{'port': port, 'enable_ssl': enable_ssl}],
                    'application_profile_ref': app_profile,
                    'pool_ref': pool_ref
                    }

                ntwk_prof = lb_vs.get('tcpProfileName', None)
                if ntwk_prof:
                    vs_obj['network_profile_ref'] = ntwk_prof
                avi_config['VirtualService'].append(vs_obj)
                conv_status = ns_util.get_conv_status(
                    lb_vs, self.skip_attrs, self.na_attrs, self.indirect_list)
                ns_util.add_conv_status(cmd, conv_status, vs_obj)

                if enable_ssl:
                    ssl_mappings = ns_config.get('bind ssl vserver', {})
                    for mapping in ssl_mappings.get(key, []):
                        if 'CA' in mapping.keys():
                            #TODO add ref of pki prof in app profile
                            pass
                        elif 'certkeyName' in mapping.keys():
                            avi_ssl_ref = 'ssl_key_and_certificate_refs'
                            vs_obj[avi_ssl_ref] = mapping['certkeyName']
                    ssl_vs_mapping = ns_config.get('set ssl vserver', {})
                    mapping = ssl_vs_mapping.get(key)
                    vs_obj['ssl_profile_name'] = mapping.get('sslProfile')



                LOG.debug('LB VS conversion completed for: %s' % key)
            except:
                LOG.error('Error in lb vs conversion for: %s' %
                          key, exc_info=True)