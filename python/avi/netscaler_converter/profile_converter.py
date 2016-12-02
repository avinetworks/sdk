import logging
import avi.netscaler_converter.ns_util as ns_util
import os

LOG = logging.getLogger(__name__)


class ProfileConverter(object):

    http_skip = ['dropInvalReqs', 'markHttp09Inval', 'markConnReqInval', 'spdy',
                 'cmpOnPush', 'maxReusePool', 'dropExtraCRLF', 'incompHdrDelay',
                 'rtspTunnel', 'reqTimeout', 'adptTimeout', 'reqTimeoutAction',
                 'dropExtraData', 'persistentETag', 'http2HeaderTableSize'
                 'reusePoolTimeout', 'maxHeaderLen', 'minReUsePool',
                 'http2MaxHeaderListSize', 'http2MaxFrameSize', 'http2',
                 'http2MaxConcurrentStreams', 'http2InitialWindowSize']
    http_indirect = ['maxReq']

    tcp_skip = ['WS', 'SACK', 'WSVal', 'ackOnPush', 'maxBurst', 'initialCwnd',
                'delayedAck', 'oooQSize', 'pktPerRetx', 'minRTO',
                'slowStartIncr']
    tcp_indirect = ['tcpSegOffload']

    ssl_prof_indirect = ['dhCount', 'dh', 'dhFile']
    ssl_prof_na = ['sslProfileType']
    ssl_prof_skip = ['eRSA', 'eRSACount', 'sessReuse', 'sessTimeout',
                     'cipherRedirect', 'cipherURL', 'clientAuth', 'clientCert',
                     'dhKeyExpSizeLimit', 'sslRedirect', 'redirectPortRewrite',
                     'nonFipsCiphers', 'ssl3', 'SNIEnable', 'serverAuth',
                     'commonName', 'pushEncTrigger', 'clearTextPort',
                     'insertionEncoding', 'denySSLReneg', 'quantumSize',
                     'strictCAChecks', 'encryptTriggerPktCount', 'pushFlag',
                     'dropReqWithNoHostHeader', 'pushEncTriggerTimeout',
                     'sslTriggerTimeout', 'clientAuthUseBoundCAChain']

    add_key_cert_skip = ['fipsKey', 'hsmKey', 'inform', 'expiryMonitor',
                         'notificationPeriod', 'bundle']

    bind_sslvs_skip = ['priority', 'gotoPriorityExpression', 'invoke',
                       'certkeyName', 'ocspCheck', 'skipCAName', 'SNICert',
                       'eccCurveName']

    set_ssl_vserver_skip = ssl_prof_skip + ['dtlsProfileName']
    set_ssl_vserver_indirect = ['dhCount', 'dh', 'dhFile']
    set_ssl_vserver_na = ['sslProfileType']

    def convert(self, ns_config, avi_config, input_dir):
        http_profiles = ns_config.get('add ns httpProfile', {})
        tcp_profiles = ns_config.get('add ns tcpProfile', {})
        ssl_mappings = ns_config.get('bind ssl vserver', {})
        ssl_profiles = ns_config.get('add ssl profile', {})
        ssl_vs_mapping = ns_config.get('set ssl vserver', {})
        ssl_key_and_cert = ns_config.get('add ssl certKey', {})

        avi_config['ApplicationProfile'] = []
        avi_config['NetworkProfile'] = []
        avi_config["SSLKeyAndCertificate"] = []
        avi_config["SSLProfile"] = []
        avi_config["PKIProfile"] = []
        LOG.debug("Conversion started for HTTP profiles")
        for key in http_profiles.keys():
            profile = http_profiles[key]
            app_profile = self.convert_http_profile(profile)
            if app_profile:
                cmd = 'add ns httpProfile %s' % app_profile.get('name')
                conv_status = ns_util.get_conv_status(profile, self.http_skip,
                                                      [], self.http_indirect)
                ns_util.add_conv_status(cmd, conv_status, app_profile)
                avi_config['ApplicationProfile'].append(app_profile)

        LOG.debug("HTTP profiles conversion completed")

        LOG.debug("Conversion started for TCP profiles")
        for key in tcp_profiles.keys():
            profile = tcp_profiles[key]
            net_profile = self.convert_tcp_profile(profile)
            if net_profile:
                cmd = 'add ns tcpProfile %s' % net_profile.get('name')
                conv_status = ns_util.get_conv_status(profile, self.tcp_skip,
                                                      [], self.tcp_indirect)
                ns_util.add_conv_status(cmd, conv_status, net_profile)
                avi_config['NetworkProfile'].append(net_profile)
        LOG.debug("TCP profiles conversion completed")

        LOG.debug("Conversion started for SSL profiles")
        for key in ssl_vs_mapping.keys():
            ssl_cmd = 'set ssl vserver %s' % key
            mapping = ssl_vs_mapping[key]
            if not 'sslProfile' in mapping:
                continue
            ssl_profile_name = mapping.get('sslProfile')
            ssl_profile = ssl_profiles.get(ssl_profile_name, None)
            if ssl_profile:
                avi_ssl_prof = self.convert_ssl_profile(ssl_profile)
            obj = self.get_key_cert(ssl_mappings.get(key,[]), ssl_key_and_cert,
                                    input_dir, avi_ssl_prof)
            avi_config["SSLProfile"].append(avi_ssl_prof)
            conv_status = ns_util.get_conv_status(avi_ssl_prof, self.set_ssl_vserver_skip,
                                                  self.set_ssl_vserver_indirect,
                                                  self.set_ssl_vserver_na)
            ns_util.add_conv_status(ssl_cmd, conv_status, avi_ssl_prof)
            if obj.get('cert', None):
                avi_config["SSLKeyAndCertificate"].append(obj.get('cert'))
            if obj.get('pki', None):
                avi_config["PKIProfile"].append(obj.get('pki'))
        LOG.debug("SSL profiles conversion completed")

    def convert_http_profile(self, profile):
        app_profile = dict()
        try:
            LOG.debug("Converting httpProfile: %s" % profile['attrs'][0])
            app_profile['name'] = profile['attrs'][0]
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            http_profile = dict()
            conn_mux = profile.get('conMultiplex', 'DISABLED')
            conn_mux = False if conn_mux == 'DISABLED' else True
            http_profile['connection_multiplexing_enabled'] = conn_mux
            xff_header = profile.get('clientIpHdrExpr', None)
            xff_enabled = True if xff_header else False
            http_profile['xff_enabled'] = xff_enabled
            #TODO: clientIpHdrExpr conversion to xff_alternate_name
            websockets = profile.get('websockets_enabled', 'DISABLED')
            websockets = False if websockets == 'DISABLED' else True
            http_profile['websockets_enabled'] = websockets
            app_profile["http_profile"] = http_profile
            LOG.debug("Conversion completed successfully for httpProfile: %s" %
                      profile['attrs'][0])
        except:
            LOG.error("Error in convertion of httpProfile", exc_info=True)

        return app_profile

    def convert_tcp_profile(self, profile):
        ntwk_profile = None
        try:
            nagle = profile.get("nagle", 'DISABLED')
            nagle = False if nagle == 'DISABLED' else True
            mss = profile.get("mss", 0)
            mtu = True if int(mss) > 0 else False
            window = profile.get("bufferSize", 8190)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "nagles_algorithm": nagle,
                        "max_segment_size": int(mss),
                        "use_interface_mtu": mtu,
                        "receive_window": int(int(window)/1024)
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": profile['attrs'][0]
            }
        except:
             LOG.error("Error in convertion of tcpProfile", exc_info=True)
        return ntwk_profile

    def convert_ssl_profile(self, profile):
        avi_ssl_prof = dict()
        cmd = 'add ssl profile %s' % profile['attrs'][0]
        avi_ssl_prof['name'] = profile['attrs'][0]
        scn = profile.get('sendCloseNotify', 'NO')
        scn = True if scn == 'YES' else False
        avi_ssl_prof['send_close_notify'] = scn
        accepted_versions = []
        if profile.get('tls1', 'ENABLED') == 'ENABLED':
            accepted_versions.append({"type": "SSL_VERSION_TLS1"})
        if profile.get('tls11', 'ENABLED') == 'ENABLED':
            accepted_versions.append({"type": "SSL_VERSION_TLS1_1"})
        if profile.get('tls12', 'ENABLED') == 'ENABLED':
            accepted_versions.append({"type": "SSL_VERSION_TLS1_2"})
        avi_ssl_prof["accepted_versions"] = accepted_versions

        conv_status = ns_util.get_conv_status(
            profile, self.ssl_prof_skip, self.ssl_prof_indirect,
            self.ssl_prof_na)
        ns_util.add_conv_status(cmd, conv_status, avi_ssl_prof)

        return avi_ssl_prof

    def get_key_cert(self, ssl_mappings, ssl_key_and_cert, input_dir,
                     avi_ssl_prof):
        obj = dict()
        ciphers = []
        for mapping in ssl_mappings:
            output = None
            cmd = 'bind ssl vserver %s' % (mapping['attrs'][0])
            if 'CA' in mapping.keys():
                cmd += '-certkeyName %s -CA' % mapping.get('certkeyName')
                key_cert = ssl_key_and_cert.get(mapping.get('certkeyName'))
                key_file_name = key_cert.get('key')
                cert_file_name = key_cert.get('cert')
                ca_str = None
                crl_str = None
                if key_file_name:
                    ca_str = ns_util.upload_file(
                        input_dir+os.path.sep+key_file_name)
                if cert_file_name:
                    crl_str = ns_util.upload_file(
                        input_dir+os.path.sep+cert_file_name)
                if ca_str:
                    pki_profile = dict()
                    pki_profile["ca_certs"] = [{'certificate': ca_str}]
                    crl_check = mapping.get('crlCheck', 'Optional')
                    if crl_check == 'Mandatory':
                        pki_profile['crl_check'] = True
                    else:
                        pki_profile['crl_check'] = False
                    if crl_str:
                        pki_profile["crls"] = [{'body': crl_str}]
                    pki_profile["name"] = key_cert['attrs'][0]
                    obj['pki'] = pki_profile
                    output = pki_profile
                conv_status = ns_util.get_conv_status(
                    key_cert, self.add_key_cert_skip, [], [])
                kc_cmd = 'add ssl certKey %s' % key_cert['attrs'][0]
                ns_util.add_conv_status(kc_cmd, conv_status, avi_ssl_prof)

            elif 'certkeyName' in  mapping.keys():
                cmd += '-certkeyName %s' % mapping.get('certkeyName')
                key_cert = ssl_key_and_cert.get(mapping.get('certkeyName'))
                key_file_name = key_cert.get('key')
                cert_file_name = key_cert.get('cert')
                if key_file_name:
                    key_str = ns_util.upload_file(
                        input_dir+os.path.sep+key_file_name)
                if cert_file_name:
                    cert_str = ns_util.upload_file(
                        input_dir+os.path.sep+cert_file_name)
                if key_str and cert_str:
                    cert = {"certificate": cert_str}
                    ssl_kc_obj = {
                            'name': key_cert['attrs'][0],
                            'key': key_str,
                            'certificate': cert,
                            'key_passphrase': key_cert.get('password', '')
                        }
                    obj['cert'] = ssl_kc_obj
                    output = ssl_kc_obj
                conv_status = ns_util.get_conv_status(
                    key_cert, self.add_key_cert_skip, [], [])
                kc_cmd = 'add ssl certKey %s' % key_cert['attrs'][0]
                ns_util.add_conv_status(kc_cmd, conv_status, avi_ssl_prof)
            elif 'cipherName' in mapping.keys():
                cmd += '-cipherName %s' % mapping.get('cipherName')
                ciphers.append(mapping['cipherName'])
                output = avi_ssl_prof
            else:
                ns_util.add_status_row(cmd, 'skipped')
                continue
            conv_status = ns_util.get_conv_status(
                mapping, self.bind_sslvs_skip, [], [])
            ns_util.add_conv_status(cmd, conv_status, output)

        avi_ssl_prof['accepted_ciphers'] = ':'.join(ciphers)
        return obj
