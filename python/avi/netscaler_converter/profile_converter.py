import logging
import avi.netscaler_converter.ns_util as ns_util
import os
import re
import avi.netscaler_converter.ns_constants as ns_constants

from avi.netscaler_converter.ns_constants import STATUS_SKIPPED, STATUS_SUCCESSFUL

LOG = logging.getLogger(__name__)


class ProfileConverter(object):


    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref):
        self.profile_http_skip = \
            ns_constants.netscalar_command_status['profile_http_skip']
        self.profile_http_indirect = \
            ns_constants.netscalar_command_status['profile_http_indirect']
        self.profile_tcp_skip = \
            ns_constants.netscalar_command_status['profile_tcp_skip']
        self.profile_tcp_indirect =\
            ns_constants.netscalar_command_status['profile_tcp_indirect']
        self.profile_ssl_prof_indirect = \
            ns_constants.netscalar_command_status['profile_ssl_prof_indirect']
        self.profile_ssl_prof_na = \
            ns_constants.netscalar_command_status['profile_ssl_prof_na']
        self.profile_ssl_prof_skip = \
            ns_constants.netscalar_command_status['profile_ssl_prof_skip']
        self.profile_add_key_cert_skip = \
            ns_constants.netscalar_command_status['profile_add_key_cert_skip']
        self.profile_bind_sslvs_skip = \
            ns_constants.netscalar_command_status['profile_bind_sslvs_skip']
        self.profile_set_ssl_vserver_skip = \
            ns_constants.netscalar_command_status['profile_set_ssl_vserver_skip']
        self.profile_set_ssl_vserver_indirect = \
            ns_constants.netscalar_command_status['profile_set_ssl_vserver_indirect']
        self.profile_set_ssl_vserver_na = \
            ns_constants.netscalar_command_status['profile_set_ssl_vserver_na']
        self.profile_set_ssl_service_skip = \
            ns_constants.netscalar_command_status['profile_set_ssl_service_skip']
        self.profile_set_ssl_service_indirect = \
            ns_constants.netscalar_command_status['profile_set_ssl_service_indirect']
        self.profile_set_ssl_service_ignore = \
            ns_constants.netscalar_command_status['profile_set_ssl_service_ignore']
        self.profile_bind_ssl_service_skip = \
            ns_constants.netscalar_command_status['profile_bind_ssl_service_skip']
        self.profile_bind_ssl_service_indirect = \
            ns_constants.netscalar_command_status['profile_bind_ssl_service_indirect']
        self.profile_bind_ssl_service_ignore = \
            ns_constants.netscalar_command_status['profile_bind_ssl_service_ignore']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref

    def convert(self, ns_config, avi_config, input_dir):
        """
        This function defines that convert netscalar profiles to avi profiles
        :param ns_config: It is dict of all netscalar commands which are
        supported by AVI
        :param avi_config: dict of AVI
        :param input_dir: input dir path for key and cert
        :param tenant_ref: Tenant
        :param cloud_ref: Cloud ref
        :return: None
        """

        http_profiles = ns_config.get('add ns httpProfile', {})
        tcp_profiles = ns_config.get('add ns tcpProfile', {})
        ssl_mappings = ns_config.get('bind ssl vserver', {})
        ssl_profiles = ns_config.get('add ssl profile', {})
        ssl_vs_mapping = ns_config.get('set ssl vserver', {})
        ssl_key_and_cert = ns_config.get('add ssl certKey', {})
        set_ssl_service = ns_config.get('set ssl service', {})
        bind_ssl_service = ns_config.get('bind ssl service', {})
        set_ssl_service_group = ns_config.get('set ssl serviceGroup', {})
        bind_ssl_service_group = ns_config.get('bind ssl serviceGroup', {})

        avi_config['ApplicationProfile'] = []
        avi_config['NetworkProfile'] = []
        avi_config["SSLKeyAndCertificate"] = []
        avi_config["SSLProfile"] = []
        avi_config["PKIProfile"] = []
        LOG.debug("Conversion started for HTTP profiles")
        for key in http_profiles.keys():
            ns_http_profile_command = 'add ns httpProfile'
            profile = http_profiles[key]
            ns_http_profile_complete_command = ns_util.\
                get_netscalar_full_command(ns_http_profile_command, profile)
            app_profile = self.convert_http_profile(profile)
            if app_profile:
                conv_status = \
                    ns_util.get_conv_status(profile, self.profile_http_skip, [],
                                            self.profile_http_indirect)
                # Add summery in CSV/report for http profile
                ns_util.add_conv_status(profile['line_no'],
                                        ns_http_profile_command, key,
                                        ns_http_profile_complete_command,
                                        conv_status, app_profile)
                avi_config['ApplicationProfile'].append(app_profile)

        LOG.debug("HTTP profiles conversion completed")

        LOG.debug("Conversion started for TCP profiles")
        for key in tcp_profiles.keys():
            ns_tcp_profile_command = 'add ns tcpProfile'
            profile = tcp_profiles[key]
            ns_tcp_profile_complete_command = \
                ns_util.get_netscalar_full_command(ns_tcp_profile_command,
                                                   profile)
            net_profile = self.convert_tcp_profile(profile)
            if net_profile:
                # Add summery in CSV/report for tcp profile
                conv_status = ns_util.get_conv_status(profile, self.profile_tcp_skip,
                                                      [], self.profile_tcp_indirect)
                ns_util.add_conv_status(profile['line_no'],
                                        ns_tcp_profile_command, key,
                                        ns_tcp_profile_complete_command,
                                        conv_status, net_profile)
                avi_config['NetworkProfile'].append(net_profile)
        LOG.debug("TCP profiles conversion completed")

        LOG.debug("Conversion started for SSL profiles")
        for key in ssl_vs_mapping.keys():
            ns_set_ssl_vserver_command = 'set ssl vserver'
            mapping = ssl_vs_mapping[key]
            ns_set_ssl_vserver_complete_command = \
                ns_util.get_netscalar_full_command(ns_set_ssl_vserver_command,
                                                   mapping)
            ssl_profile_name = mapping.get('sslProfile')
            ssl_profile = ssl_profiles.get(ssl_profile_name, None)

            ssl_mapping_data = ssl_mappings.get(key, [])
            if isinstance(ssl_mapping_data, dict):
                ssl_mapping_data = [ssl_mapping_data]

            obj = self.get_key_cert(ssl_mapping_data, ssl_key_and_cert,
                                    input_dir, None, ns_config,
                                    'bind ssl vserver')
            if obj.get('accepted_ciphers', None):
                if ssl_profile:
                    avi_ssl_prof = self.convert_ssl_profile(ssl_profile)
                else:
                    ssl_profile_name = re.sub('[:]', '-', key)
                    avi_ssl_prof = {
                        'name': ssl_profile_name,
                        'accepted_versions': [],
                        'tenant_ref': self.tenant_ref
                    }
                    if not avi_ssl_prof['accepted_versions']:
                        avi_ssl_prof['accepted_versions'].append(
                            {'type': 'SSL_VERSION_TLS1_1'})

                # Todo supported only valid ciphers
                # avi_ssl_prof['accepted_ciphers'] = obj.get('accepted_ciphers')
                avi_ssl_prof['accepted_ciphers'] = 'AES:3DES:RC4'
                avi_config["SSLProfile"].append(avi_ssl_prof)
                LOG.info('Conversion successful: ssl profile %s' % key)
                conv_status = \
                    ns_util.get_conv_status(avi_ssl_prof,
                                            self.profile_set_ssl_vserver_skip,
                                            self.profile_set_ssl_vserver_indirect,
                                            self.profile_set_ssl_vserver_na)
                # Add summery in CSV/report for ssl profile
                ns_util.add_conv_status(mapping['line_no'],
                                        ns_set_ssl_vserver_command, key,
                                        ns_set_ssl_vserver_complete_command,
                                        conv_status, avi_ssl_prof)
            if obj.get('cert', None):
                avi_config["SSLKeyAndCertificate"].append(obj.get('cert'))
            if obj.get('pki', None):
                avi_config["PKIProfile"].append(obj.get('pki'))

        # Set ssl service conversion
        self.convert_ssl_service_profile(set_ssl_service, bind_ssl_service,
                                         ssl_key_and_cert, input_dir, ns_config,
                                         avi_config, 'set ssl service',
                                         'bind ssl service')

        # Set ssl servicegroup conversion
        self.convert_ssl_service_profile(set_ssl_service_group,
                                         bind_ssl_service_group,
                                         ssl_key_and_cert, input_dir, ns_config,
                                         avi_config, 'set ssl serviceGroup',
                                         'bind ssl serviceGroup')

        LOG.debug("SSL profiles conversion completed")


    def convert_ssl_service_profile(self, set_ssl_service, bind_ssl_service,
                                    ssl_key_and_cert, input_dir, ns_config,
                                    avi_config, set_ssl_service_command,
                                    bind_ssl_service_command):
        """
        This function defines that convert ssl profiles
        :param set_ssl_service: dict of set_ssl_service netscalar command
        :param bind_ssl_service: dict of bind_ssl_service netscalar command
        :param ssl_key_and_cert: dict of set_ssl_service netscalar command
        :param input_dir: path of input dir which keeps cert and key
        :param ns_config: It is dict of all netscalar commands which are
        supported by AVI
        :param avi_config: dict of AVI
        :param set_ssl_service_command: netscalar command set ssl
        :param bind_ssl_service_command: netscalar command bind ssl
        :return: None
        """

        for key in set_ssl_service:
            ssl_service = set_ssl_service[key]
            full_set_ssl_service_command = \
                ns_util.get_netscalar_full_command(set_ssl_service_command,
                                                   ssl_service)
            ssl_profile_name = ssl_service['attrs'][0]
            ssl_profile_name = re.sub('[:]', '-', ssl_profile_name)
            ssl_profile = {
                'name': ssl_profile_name,
                'tenant_ref': self.tenant_ref,
                'accepted_versions': []
            }
            # set ssl service
            sess_reuse = ssl_service.get('sessReuse', None)
            if sess_reuse == 'DISABLED':
                ssl_profile['enable_ssl_session_reuse'] = False
            if ssl_service.get('sessTimeout', None):
                ssl_profile['ssl_session_timeout'] = \
                    int(ssl_service.get('sessTimeout'))
            accepted_versions = []
            if ssl_service.get('tls1', None):
                accepted_versions.append({'type': 'SSL_VERSION_TLS1'})
            if ssl_service.get('tls11', None):
                accepted_versions.append({'type': 'SSL_VERSION_TLS1_1'})
            if ssl_service.get('tls12', None):
                accepted_versions.append({'type': 'SSL_VERSION_TLS1_2'})
            if accepted_versions:
                ssl_profile['accepted_versions'] = accepted_versions
            else:
                ssl_profile['accepted_versions'].append(
                    {'type': 'SSL_VERSION_TLS1_1'})

            send_close_notify = ssl_service.get('sendCloseNotify', None)
            if send_close_notify == 'NO':
                ssl_profile['send_close_notify'] = False

            # bind ssl service
            binding_mapping = bind_ssl_service.get(ssl_profile_name, [])
            if isinstance(binding_mapping, dict):
                binding_mapping = [binding_mapping]
            obj = self.get_key_cert(binding_mapping, ssl_key_and_cert,
                                    input_dir, None, ns_config,
                                    bind_ssl_service_command)
            if obj.get('accepted_ciphers', None):
                # Todo supported only valid ciphers
                ssl_profile['accepted_ciphers'] = 'AES:3DES:RC4'
                # ssl_profile['accepted_ciphers'] = obj.get('accepted_ciphers')
            if obj.get('cert', None):
                avi_config["SSLKeyAndCertificate"].append(obj.get('cert'))
            if obj.get('pki', None):
                avi_config["PKIProfile"].append(obj.get('pki'))

            avi_config["SSLProfile"].append(ssl_profile)
            LOG.info('Conversion successful: %s' % full_set_ssl_service_command)
            conv_status = \
                ns_util.get_conv_status(ssl_profile,
                                        self.profile_set_ssl_service_skip,
                                        self.profile_set_ssl_service_indirect,
                                        [])
            # Add summery in CSV/report for ssl service
            ns_util.add_conv_status(ssl_service['line_no'],
                                    set_ssl_service_command, key,
                                    full_set_ssl_service_command,
                                    conv_status, ssl_profile)

        LOG.debug("SSL profiles conversion completed")


    def convert_http_profile(self, profile):
        """
        This function defines that convert http profile
        :param profile: Object of http profile
        :return: http profile
        """

        app_profile = dict()
        try:
            LOG.debug("Converting httpProfile: %s" % profile['attrs'][0])
            app_profile['name'] = profile['attrs'][0]
            app_profile['tenant_ref'] = self.tenant_ref
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            http_profile = dict()
            conn_mux = profile.get('conMultiplex', 'DISABLED')
            conn_mux = False if conn_mux == 'DISABLED' else True
            http_profile['connection_multiplexing_enabled'] = conn_mux
            xff_header = profile.get('clientIpHdrExpr', None)
            xff_enabled = True if xff_header else False
            http_profile['xff_enabled'] = xff_enabled
            # TODO: clientIpHdrExpr conversion to xff_alternate_name
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
        """
        This function defines that convert tcp profile
        :param profile: Object of tcp profile
        :return: tcp profile
        """

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
                        "receive_window": int(int(window) / 1024)
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": profile['attrs'][0],
                "tenant_ref": self.tenant_ref
            }
        except:
            LOG.error("Error in convertion of tcpProfile", exc_info=True)
        return ntwk_profile

    def convert_ssl_profile(self, profile):
        """
        This function defines that convert ssl profile
        :param profile: Object of ssl profile
        :return: ssl profile
        """

        avi_ssl_prof = dict()
        netscalar_cmd = 'add ssl profile'
        profile_name = re.sub('[:]', '-', profile['attrs'][0])
        avi_ssl_prof['name'] = profile_name
        avi_ssl_prof['tenant_ref'] = self.tenant_ref
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
            profile, self.profile_ssl_prof_skip, self.profile_ssl_prof_indirect,
            self.profile_ssl_prof_na)
        ns_full_cmd = ns_util.get_netscalar_full_command(netscalar_cmd, profile)
        # Add summery in CSV/report for ssl profile
        ns_util.add_conv_status(profile['line_no'], netscalar_cmd,
                                profile['attrs'][0], ns_full_cmd, conv_status,
                                avi_ssl_prof)

        return avi_ssl_prof

    def get_key_cert(self, ssl_mappings, ssl_key_and_cert, input_dir,
                     avi_ssl_prof, ns_config, bind_ssl_cmd):
        """
        This function defines that convert PKI, SSL, and sslkeyandcert profiles
        :param ssl_mappings: List of bind ssl
        :param ssl_key_and_cert: Object of ssl key and cert
        :param input_dir: path of input dir which keeps key and cert
        :param avi_ssl_prof: Object of ssl profile
        :param ns_config: dict of netscalar commands
        :param bind_ssl_cmd: list of binding ssl
        :return: key and cert/ ssl profile/PKI profile
        """

        obj = dict()
        ciphers = []
        for mapping in ssl_mappings:
            output = None
            bind_ssl_full_cmd = ns_util.get_netscalar_full_command(bind_ssl_cmd,
                                                                   mapping)
            bind_ssl_success = False

            if 'CA' in mapping.keys():
                key_cert = ssl_key_and_cert.get(mapping.get('certkeyName'))
                if not key_cert:
                    continue
                key_file_name = key_cert.get('key')
                cert_file_name = key_cert.get('cert')
                ca_str = None
                crl_str = None
                netscalar_cmd = 'add ssl certKey'
                full_cmd = ns_util.get_netscalar_full_command(netscalar_cmd,
                                                              key_cert)
                if key_file_name:
                    ca_str = ns_util.upload_file(
                        input_dir + os.path.sep + key_file_name)
                if cert_file_name:
                    crl_str = ns_util.upload_file(
                        input_dir + os.path.sep + cert_file_name)
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
                    pki_profile["tenant_ref"] = self.tenant_ref
                    obj['pki'] = pki_profile
                    output = pki_profile
                    bind_ssl_success = True
                    LOG.info('Conversion successful: %s' % full_cmd)
                    conv_status = ns_util.get_conv_status(
                        key_cert, self.profile_add_key_cert_skip, [], [])
                    # Add summery in CSV/report for PKI
                    ns_util.add_conv_status(key_cert['line_no'], netscalar_cmd,
                                            key_cert['attrs'][0], full_cmd,
                                            conv_status, obj['pki'])
                else:
                    LOG.info('Skipped: %s' % full_cmd)
                    # Add skipped status in CSV/report for ssl cert key
                    ns_util.add_status_row(key_cert['line_no'], netscalar_cmd,
                                           key_cert['attrs'][0], full_cmd,
                                           STATUS_SKIPPED)

            elif 'certkeyName' in mapping.keys():
                key_cert = ssl_key_and_cert.get(mapping.get('certkeyName'))
                if not key_cert:
                    continue
                netscalar_cmd = 'add ssl certKey'
                full_cmd = ns_util.get_netscalar_full_command(netscalar_cmd,
                                                              key_cert)
                key_file_name = key_cert.get('key')
                cert_file_name = key_cert.get('cert')
                if key_file_name:
                    key_str = ns_util.upload_file(
                        input_dir + os.path.sep + key_file_name)
                if cert_file_name:
                    cert_str = ns_util.upload_file(
                        input_dir + os.path.sep + cert_file_name)
                if key_str and cert_str:
                    cert = {"certificate": cert_str}
                    ssl_kc_obj = {
                        'name': key_cert['attrs'][0],
                        'tenant_ref': self.tenant_ref,
                        'key': key_str,
                        'certificate': cert,
                        'key_passphrase': key_cert.get('password', ''),
                        'type': 'SSL_CERTIFICATE_TYPE_VIRTUALSERVICE'
                    }
                    obj['cert'] = ssl_kc_obj
                    output = ssl_kc_obj
                    conv_status = ns_util.get_conv_status(
                        key_cert, self.profile_add_key_cert_skip, [], [])
                    # Add ssummery in CSV/report for ssl service
                    ns_util.add_conv_status(key_cert['line_no'], netscalar_cmd,
                                            key_cert['attrs'][0], full_cmd,
                                            conv_status, output)
                    bind_ssl_success = True
                else:
                    LOG.warning('Skipped : %s' % full_cmd)
                    # Add skipped status in CSV/report for ssl cert key
                    ns_util.add_status_row(key_cert['line_no'], netscalar_cmd,
                                           key_cert['attrs'][0], full_cmd,
                                           STATUS_SKIPPED)

            elif 'cipherName' in mapping.keys():
                ciphers_keys = self.get_ciphers(mapping['cipherName'],
                                                ns_config)
                ciphers += ciphers_keys
                ciphers = list(set(ciphers))
                obj['accepted_ciphers'] = ':'.join(ciphers)
                bind_ssl_success = True
                output = obj

            conv_status = ns_util.get_conv_status(
                mapping, self.profile_bind_sslvs_skip, [], [])
            if not bind_ssl_success:
                LOG.warning('Skipped : %s' % bind_ssl_full_cmd)
                # Add skipped status in CSV/report for bind ssl service
                ns_util.add_status_row(mapping['line_no'], bind_ssl_cmd,
                                       mapping['attrs'][0], bind_ssl_full_cmd,
                                       STATUS_SKIPPED)
                continue

            LOG.info('Conversion successful: %s' % bind_ssl_full_cmd)
            # Add successful status in CSV/report for ssl service
            ns_util.add_conv_status(mapping['line_no'], bind_ssl_cmd,
                                    mapping['attrs'][0], bind_ssl_full_cmd,
                                    conv_status, output)

        return obj


    def get_ciphers(self, cipher, ns_config):
        """
        This function is define to get the ssl ciphers
        :param cipher: cipher name
        :param ns_config: netscalar configuration
        :return: list of ciphers
        """

        cipher_config = ns_config.get('add ssl cipher', {})
        cipher_mapping = ns_config.get('bind ssl cipher', {})
        lb_cipher = cipher_config.get(cipher, None)
        bind_ciphers = cipher_mapping.get(cipher, None)
        add_ssl_cipher_command = 'add ssl cipher'
        bind_ssl_cipher_command = 'bind ssl cipher'

        if not (lb_cipher and bind_ciphers):
            return [cipher]
        ciphers = []
        full_add_ssl_cipher_command = \
            ns_util.get_netscalar_full_command(add_ssl_cipher_command, lb_cipher)
        LOG.info('Conversion successful: %s' % full_add_ssl_cipher_command)
        # Add Successful status in CSV/report for add ssl cipher
        ns_util.add_status_row(lb_cipher['line_no'], add_ssl_cipher_command,
                               cipher, full_add_ssl_cipher_command,
                               STATUS_SUCCESSFUL, None)
        if isinstance(bind_ciphers, dict):
            bind_ciphers = [bind_ciphers]
        for bind_cipher in bind_ciphers:
            full_bind_ssl_cipher_command = ns_util.\
                get_netscalar_full_command(bind_ssl_cipher_command, bind_cipher)
            if bind_cipher.get('cipherName', None):
                avi_cipher = {'accepted_ciphers': bind_cipher['cipherName']}
                ciphers.append(bind_cipher['cipherName'])
                LOG.info('Conversion successful: %s' %
                         full_bind_ssl_cipher_command)
                # Add Successful status in CSV/report for add ssl cipher
                ns_util.add_status_row(bind_cipher['line_no'],
                                       bind_ssl_cipher_command, cipher,
                                       full_bind_ssl_cipher_command,
                                       STATUS_SUCCESSFUL, avi_cipher)
            else:
                LOG.info('Skipped: %s' % full_bind_ssl_cipher_command)
                # Add skipped status in CSV/report for add ssl cipher
                ns_util.add_status_row(bind_cipher['line_no'],
                                       bind_ssl_cipher_command, cipher,
                                       full_bind_ssl_cipher_command,
                                       STATUS_SKIPPED)

        if not ciphers:
            return [cipher]

        return ciphers

