import copy
import logging
import os

import avi.f5_converter.conversion_util as conv_utils
import avi.f5_converter.converter_constants as final

LOG = logging.getLogger(__name__)


class ProfileConfigConv(object):
    @classmethod
    def get_instance(cls, version):
        if version == 10:
            return ProfileConfigConvV10()
        if version == 11:
            return ProfileConfigConvV11()

    supported_types = None
    ignore_for_defaults = None
    default_key = None

    def convert_profile(self, profile, key, f5_config, avi_config, input_dir):
        pass

    def convert(self, f5_config, avi_config, input_dir):
        profile_config = f5_config.get("profile", {})
        avi_config["SSLKeyAndCertificate"] = []
        avi_config["SSLProfile"] = []
        avi_config["PKIProfile"] = []
        avi_config["ApplicationProfile"] = []
        avi_config["NetworkProfile"] = []
        avi_config["StringGroup"] = []
        avi_config['realm_dict'] = {}
        avi_config['fallback_host_dict'] = {}
        for key in profile_config.keys():
            profile_type = None
            name = None
            try:
                profile_type, name = key.split(" ")
                if profile_type not in self.supported_types:
                    LOG.warning("Skipped not supported profile: %s of type: %s"
                                % (name, profile_type))
                    conv_utils.add_status_row('profile', profile_type, name,
                                              'skipped')
                    continue
                LOG.debug("Converting profile: %s" % name)
                profile = profile_config[key]
                profile = self.update_with_default_profile(
                    profile_type, profile, profile_config, name)
                self.convert_profile(profile, key, f5_config, avi_config,
                                     input_dir)

            except:
                LOG.error("Failed to convert profile: %s" % key, exc_info=True)
                if name:
                    conv_utils.add_status_row('profile', profile_type, name,
                                              'error')
                else:
                    conv_utils.add_status_row('profile', key, key, 'error')
            LOG.debug("Conversion successful for profile: %s" % name)

    def update_with_default_profile(self, profile_type, profile,
                                    profile_config, profile_name):
        """
        Profiles can have inheritance used by attribute defaults-from in F5
        configuration this method recursively gets all the attributes from the
        default objects and forms complete object
        :param profile_type: type of profile
        :param profile: currant profile object
        :param profile_config: F5 profile config dict
        :return: Complete profile with updated attributes from defaults
        """
        parent_name = profile.get(self.default_key, None)
        if parent_name and profile_name != parent_name:
            parent_profile = profile_config.get(profile_type + " " +
                                                parent_name, None)
            if parent_profile:
                parent_profile = self.update_with_default_profile(
                    profile_type, parent_profile, profile_config, parent_name)
                parent_profile = copy.deepcopy(parent_profile)
                parent_profile.update(profile)
                profile = parent_profile
        return profile

    def get_key_cert_obj(self, name, key_file_name, cert_file_name, input_dir):
        """
        Read key and cert files from given location and construct avi
        SSLKeyAndCertificate objects
        :param name: SSLKeyAndCertificate object name
        :param key_file_name: key file name
        :param cert_file_name: cert file name
        :param input_dir: location of key and cert files
        object structure
        :return:SSLKeyAndCertificate object
        """
        folder_path = input_dir+os.path.sep
        key = conv_utils.upload_file(folder_path + key_file_name)
        cert = conv_utils.upload_file(folder_path + cert_file_name)
        ssl_kc_obj = None
        if key and cert:
            cert = {"certificate": cert}
            ssl_kc_obj = {
                    'name': name,
                    'key': key,
                    'certificate': cert,
                    'key_passphrase': ''
                }
        return ssl_kc_obj


class ProfileConfigConvV11(ProfileConfigConv):
    supported_types = ["client-ssl", "server-ssl", "http", "dns", "fasthttp",
                       "web-acceleration", "http-compression", "fastl4", "tcp",
                       "udp"]
    ignore_for_defaults = {'app-service': 'none', 'uri-exclude': 'none'}

    default_key = "defaults-from"

    def convert_profile(self, profile, key, f5_config, avi_config, input_dir):
        skipped = profile.keys()
        indirect = []
        converted_objs = []
        default_ignore = {}
        parent_cls = super(ProfileConfigConvV11, self)
        profile_type, name = key.split(" ")
        if profile_type in ("client-ssl", "server-ssl"):
            supported_attr = ["cert-key-chain", "cert", "key", "ciphers",
                              "unclean-shutdown", "crl-file", "ca-file",
                              "options", "defaults-from"]
            ignore_list = ['chain', 'secure-renegotiation', 'cache-size',
                           'renegotiate-size', 'cache-timeout',
                           'strict-resume', 'renegotiate-max-record-delay',
                           'renegotiate-period']
            supported_attr = supported_attr + ignore_list
            default_profile_name = '%s %s' % (profile_type,
                                              profile_type.replace("-", ""))
            default_ignore = f5_config['profile'].get(default_profile_name, {})
            default_ignore.update(self.ignore_for_defaults)
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            cert_obj = profile.get("cert-key-chain", None)
            if cert_obj and cert_obj.keys():
                cert_obj_key = cert_obj.keys()[0]
                key_file = cert_obj.get(cert_obj_key, {}).get("key", None)
                cert_file = cert_obj.get(cert_obj_key, {}).get("cert", None)
            else:
                cert_file = profile.get("cert", None)
                key_file = profile.get("key", None)
                cert_file = None if cert_file == 'none' else cert_file
                key_file = None if key_file == 'none' else key_file
            if key_file and cert_file:
                key_cert_obj = parent_cls.get_key_cert_obj(
                    name, key_file, cert_file, input_dir)

                conv_utils.update_skip_duplicates(
                    key_cert_obj, avi_config['SSLKeyAndCertificate'],
                    'key_cert', converted_objs)
            ciphers = profile.get('ciphers', 'DEFAULT')
            ciphers = 'AES:3DES:RC4' if ciphers == 'DEFAULT' else ciphers
            ciphers = ciphers.replace(":@SPEED", "")
            ssl_profile = dict()
            ssl_profile['name'] = name
            ssl_profile['accepted_ciphers'] = ciphers
            close_notify = profile.get('unclean-shutdown', None)
            if close_notify and close_notify == 'enabled':
                ssl_profile['send_close_notify'] = True
            else:
                ssl_profile['send_close_notify'] = False
            options = profile.get("options", "")
            options = options.keys()+options.values()
            if None in options:
                options.remove(None)
            accepted_versions = []
            if "no-tlsv1" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1"})
            if "no-tlsv1.1" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1_1"})
            if "no-tlsv1.2" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1_2"})
            if accepted_versions:
                ssl_profile["accepted_versions"] = accepted_versions

            conv_utils.update_skip_duplicates(
                ssl_profile, avi_config['SSLProfile'], 'ssl_profile',
                converted_objs)

            crl_file_name = profile.get('crl-file', None)
            ca_file_name = profile.get('ca-file', None)
            if crl_file_name and crl_file_name != 'none':
                crl_file_name = crl_file_name.replace('\"', '').strip()
            else:
                crl_file_name = None
            if ca_file_name and ca_file_name != 'none':
                ca_file_name = ca_file_name.replace('\"', '').strip()
            else:
                ca_file_name = None

            if ca_file_name and crl_file_name:
                pki_profile = dict()
                file_path = input_dir+os.path.sep+ca_file_name
                pki_profile["name"] = name
                error = False
                ca = conv_utils.upload_file(file_path)
                if ca:
                    pki_profile["ca_certs"] = [{'certificate': ca}]
                else:
                    error = True
                file_path = input_dir+os.path.sep+crl_file_name
                crl = conv_utils.upload_file(file_path)
                if crl:
                    pki_profile["crls"] = [{'body': crl}]
                else:
                    error = True
                if not error:
                    conv_utils.update_skip_duplicates(
                        pki_profile, avi_config['PKIProfile'], 'pki_profile',
                        converted_objs)
            elif ca_file_name:
                LOG.warn("crl-file missing hence skipped ca-file")
                skipped.append("ca-file")
        elif profile_type == 'http':
            supported_attr = [
                "description", "insert-xforwarded-for", "enforcement",
                "xff-alternative-names", "encrypt-cookies", "defaults-from",
                "accept-xff", "oneconnect-transformations",
                "basic-auth-realm", "fallback-host"]
            ignore_list = ['lws-width', 'lws-separator ']
            default_ignore = f5_config['profile'].get('http http', {})
            default_ignore.update(self.ignore_for_defaults)
            # ignore_for_defaults["proxy-type"] = "reverse"
            supported_attr = ignore_list + supported_attr
            indirect = ["request-chunking", "response-chunking", "sflow",
                        'response-headers-permitted', 'via-response',
                        'via-request', 'server-agent-name']
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            encpt_cookie = profile.get('encrypt-cookies', 'none')
            encpt_cookie = False if encpt_cookie == 'none' else True
            xff_enabled = profile.get('accept-xff', 'disabled')
            xff_enabled = False if xff_enabled == 'disabled' else True
            con_mltplxng = profile.get('oneconnect-transformations',
                                       'disabled')
            con_mltplxng = False if con_mltplxng == 'disabled' else True
            http_profile = dict()
            insert_xff = profile.get('insert-xforwarded-for', 'disabled')
            insert_xff = True if insert_xff == 'enabled' else False
            http_profile['x_forwarded_proto_enabled'] = insert_xff
            http_profile['xff_alternate_name'] = \
                profile.get('xff-alternative-names', None)
            http_profile['secure_cookie_enabled'] = encpt_cookie
            http_profile['xff_enabled'] = xff_enabled
            http_profile['connection_multiplexing_enabled'] = con_mltplxng

            enforcement = profile.get('enforcement', None)
            if enforcement:
                header_size = enforcement.get('max-header-size',
                                              final.DEFAULT_MAX_HEADER)
                http_profile['client_max_header_size'] = \
                    int(header_size)/final.BYTES_IN_KB
                enf_skipped = [enf for enf in enforcement.keys()
                               if enf not in ["max-header-size"]]
                skipped.append({"enforcement": enf_skipped})
            app_profile["http_profile"] = http_profile

            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
            realm = profile.get("basic-auth-realm", 'none')
            realm = None if realm == 'none' else realm
            if realm:
                avi_config['realm_dict'][name] = realm
            host = profile.get("fallback-host", 'none')
            host = None if host == 'none' else host
            if host:
                avi_config['fallback_host_dict'][name] = host
        elif profile_type == 'dns':
            supported_attr = ["description", "defaults-from"]
            ignore_list = ['enable-gtm']
            indirect = ['avr-dnsstat-sample-rate', 'unhandled-query-action',
                        'use-local-bind', 'log-profile', 'dns64', 'cache',
                        'enable-cache', 'process-rd', 'enable-dns-express',
                        'enable-dnssec', 'dns-security', 'process-xfr',
                        'enable-dns-firewall', 'enable-rapid-response',
                        'enable-logging', 'rapid-response-last-action']
            supported_attr += ignore_list
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_DNS'
            app_profile['description'] = profile.get('description', None)
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'web-acceleration':
            supported_attr = ["description", "cache-object-min-size",
                              "cache-max-age", "cache-object-max-size",
                              "cache-insert-age-header", "defaults-from",
                              "cache-uri-exclude", "cache-uri-include",
                              "cache-max-entries"]
            indirect = ["cache-size", "cache-aging-rate"]
            default_profile_name = 'web-acceleration web-acceleration'
            default_ignore = f5_config['profile'].get(default_profile_name, {})
            # ignore_for_defaults.update({
            #     'cache-client-cache-control-mode': 'none'})
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            cache_config = dict()
            cache_config['min_object_size'] = profile.get(
                'cache-object-min-size', final.MIN_CACHE_OBJ_SIZE)
            cache_config['query_cacheable'] = True
            cache_config['max_object_size'] = profile.get(
                'cache-object-max-size', final.MAX_CACHE_OBJ_SIZE)
            age_header = profile.get('cache-insert-age-header', 'disabled')
            if age_header == 'enabled':
                cache_config['age_header'] = True
            else:
                cache_config['age_header'] = False
            cache_config['enabled'] = True
            cache_config['default_expire'] = \
                profile.get('cache-max-age', final.DEFAULT_CACHE_MAX_AGE)
            max_entities = profile.get('cache-max-entries', 0)
            cache_config['max_cache_size'] = \
                (int(max_entities) * int(cache_config['max_object_size']))
            exclude_uri = profile.get("cache-uri-exclude", None)
            include_uri = profile.get("cache-uri-include", None)
            if exclude_uri and isinstance(exclude_uri, dict):
                exclude_uri = exclude_uri.keys() + exclude_uri.values()
                if None in exclude_uri:
                    exclude_uri.remove(None)
                cache_config['mime_types_black_list'] = exclude_uri
            if include_uri and isinstance(include_uri, dict):
                include_uri = include_uri.keys() + include_uri.values()
                if None in include_uri:
                    include_uri.remove(None)
                cache_config['mime_types_list'] = include_uri
            http_profile = dict()
            http_profile["cache_config"] = cache_config
            app_profile["http_profile"] = http_profile
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'http-compression':
            supported_attr = ["description", "content-type-include",
                              "keep-accept-encoding", "defaults-from",
                              "content-type-exclude"]
            ignore_list = ['cpu-saver-high', 'buffer-size', 'cpu-saver-low']
            supported_attr = supported_attr + ignore_list
            indirect = ['browser-workarounds', 'uri-include', 'gzip-level',
                        'gzip-window-size', 'gzip-memory-level']
            # ignore_for_defaults.update({'method-prefer': 'gzip'})
            default_profile_name = 'http-compression http-compression'
            default_ignore = f5_config['profile'].get(default_profile_name, {})
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            compression_profile = dict()
            compression_profile["type"] = "AUTO_COMPRESSION"
            compression_profile["compression"] = True
            encoding = profile.get("keep-accept-encoding", "disable")
            if encoding == "disable":
                encoding = True
            else:
                encoding = False
            compression_profile["remove_accept_encoding_header"] = encoding
            content_type = profile.get("content-type-include", "")
            ct_exclude = profile.get("content-type-exclude", "")
            ct_exclude = None if ct_exclude == 'none' else ct_exclude
            http_profile = dict()
            if content_type:
                content_type = content_type.keys()+content_type.values()
            elif ct_exclude:
                content_type = final.DEFAULT_CONTENT_TYPE
            if ct_exclude:
                ct_exclude = ct_exclude.keys() + ct_exclude.values()
                content_type = [ct for ct in content_type
                                if ct not in ct_exclude]
            if content_type:
                sg_obj = conv_utils.get_containt_string_group(name,
                                                              content_type)
                avi_config['StringGroup'].append(sg_obj)
                converted_objs.append({'string_group': sg_obj})
                compression_profile["compressible_content_ref"] = \
                    name + "-content_type"
                http_profile["compression_profile"] = compression_profile
            app_profile["http_profile"] = http_profile
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'fastl4':
            supported_attr = ["description", "explicit-flow-migration",
                              "idle-timeout", "software-syn-cookie",
                              "pva-acceleration", "defaults-from"]
            indirect = ['reset-on-timeout', 'ip-tos-to-server',
                        'pva-offload-dynamic', 'tcp-handshake-timeout',
                        'timeout-recovery', 'pva-dynamic-server-packets',
                        'pva-acceleration', 'pva-dynamic-client-packets',
                        'tcp-timestamp-mode', 'link-qos-to-server',
                        'client-timeout', 'tcp-wscale-mode', 'server-sack',
                        'late-binding', 'syn-cookie-whitelist',
                        'rtt-from-client', 'rtt-from-server',
                        'link-qos-to-client', 'tcp-generate-isn',
                        'ip-tos-to-client', 'server-timestamp',
                        'receive-window-size']
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            syn_protection = (profile.get("software-syn-cookie",
                                          None) == 'enabled')
            timeout = profile.get("idle-timeout", final.MIN_SESSION_TIMEOUT)
            if timeout < 60:
                timeout = final.MIN_SESSION_TIMEOUT
                LOG.warn("idle-timeout for profile: %s is less" % name +
                         " than minimum, changed to Avis minimum value")
            elif timeout > final.MAX_SESSION_TIMEOUT:
                timeout = final.MAX_SESSION_TIMEOUT
                LOG.warn("idle-timeout for profile: %s  is grater" % name +
                         " than maximum, changed to Avis maximum value")
            description = profile.get('description', None)
            ntwk_profile = {
                "profile": {
                    "tcp_fast_path_profile": {
                      "session_idle_timeout": timeout,
                      "enable_syn_protection": syn_protection
                    },
                    "type": "PROTOCOL_TYPE_TCP_FAST_PATH"
                },
                "name": name,
                "description": description
            }
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_L4'
            app_profile['description'] = description
            explicit_tracking = profile.get("explicit-flow-migration", None)
            l4_profile = {"rl_profile": {
                "client_ip_connections_rate_limit": {
                    "explicit_tracking": (explicit_tracking == 'enabled')
                }}
            }
            app_profile['dos_rl_profile'] = l4_profile
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)

            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'fasthttp':
            supported_attr = ["description", "receive-window-size",
                              "idle-timeout", "defaults-from",
                              'max-header-size', 'insert-xforwarded-for']
            default_ignore = f5_config['profile'].get('fasthttp fasthttp', {})
            # ignore_for_defaults.update(
            #     {'client-close-timeout': '5', 'connpool-max-reuse': '0',
            #      'connpool-idle-timeout-override': '0',
            #      'connpool-max-size': '2048', 'connpool-min-size': '0',
            #      'connpool-step': '4', 'header-insert': 'none',
            #      'server-close-timeout': '5', 'max-requests': '0',
            #      'mss-override': '0', 'layer-7': 'enabled'})
            indirect = ['reset-on-timeout',  'unclean-shutdown',
                        'http-11-close-workarounds', 'server-sack',
                        'force-http-10-response', 'hardware-syn-cookie',
                        'connpool-replenish', 'server-timestamp']
            skipped = [attr for attr in f5_config['profile'][key].keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            http_profile = dict()
            insert_xff = profile.get('insert-xforwarded-for', 'disabled')
            insert_xff = True if insert_xff == 'enabled' else False
            http_profile['x_forwarded_proto_enabled'] = insert_xff
            header_size = profile.get('max-header-size',
                                      final.DEFAULT_MAX_HEADER)
            http_profile['client_max_header_size'] = \
                int(header_size)/final.BYTES_IN_KB
            app_profile["http_profile"] = http_profile
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
            receive_window = profile.get("receive-window-size",
                                         final.DEFAULT_RECV_WIN)
            if not (final.MIN_RECV_WIN <= int(receive_window) <=
                    final.MAX_RECV_WIN):
                receive_window = final.DEFAULT_RECV_WIN
            timeout = profile.get("idle-timeout", 0)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "receive_window": receive_window,
                        "idle_connection_timeout": timeout
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'tcp':
            supported_attr = ["description", "idle-timeout", "max-retrans",
                              "syn-max-retrans", "time-wait-recycle",
                              "time-wait-timeout", "nagle", "defaults-from",
                              "congestion-control", "receive-window-size"]
            indirect = ['reset-on-timeout', 'slow-start', 'minimum-rto',
                        'syn-cookie-whitelist', 'max-segment-size', 'mptcp',
                        'mptcp-csum', 'mptcp-csum-verify', 'mptcp-rxmitmin',
                        'mptcp-fallback', 'mptcp-fastjoin', 'mptcp-debug',
                        'mptcp-join-max', 'mptcp-makeafterbreak',
                        'mptcp-nojoindssack', 'mptcp-rtomax',
                        'mptcp-subflowmax', 'mptcp-timeout']
            # ignore_for_defaults.update(
            #     {'ack-on-push': 'enabled',
            #      'deferred-accept': 'disabled', 'ecn': 'disabled',
            #      'proxy-mss': 'disabled', 'selective-acks': 'enabled',
            #      'timestamps': 'enabled', 'proxy-buffer-high': '49152',
            #      'proxy-buffer-low': '32768', 'proxy-options': 'disabled',
            #      'limited-transmit': 'enabled', 'fin-wait-timeout': '5',
            #      'close-wait-timeout': '5', 'keep-alive-interval': '1800',
            #      'delayed-acks': 'enabled', 'send-buffer-size': '65535'})
            default_ignore = f5_config['profile'].get('tcp tcp', {})
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            timeout = profile.get("idle-timeout", 0)
            nagle = profile.get("nagle", 'disabled')
            nagle = False if nagle == 'disabled' else True
            retrans = profile.get("max-retrans", final.MIN_SYN_RETRANS)
            retrans = final.MIN_SYN_RETRANS if \
                int(retrans) < final.MIN_SYN_RETRANS else retrans
            retrans = final.MAX_SYN_RETRANS if \
                int(retrans) > final.MAX_SYN_RETRANS else retrans
            syn_retrans = profile.get("syn-max-retrans",
                                      final.MIN_SYN_RETRANS)
            syn_retrans = final.MIN_SYN_RETRANS if \
                int(syn_retrans) < final.MIN_SYN_RETRANS else syn_retrans
            syn_retrans = final.MAX_SYN_RETRANS if \
                int(syn_retrans) > final.MAX_SYN_RETRANS else syn_retrans
            conn_type = profile.get("time-wait-recycle", "disabled")
            conn_type = "CLOSE_IDLE" if \
                conn_type == "disabled" else "KEEP_ALIVE"
            delay = profile.get("time-wait-timeout", 0)
            window = profile.get("receive-window-size",
                                 (final.MIN_RECV_WIN * final.BYTES_IN_KB))
            window = int(int(window)/final.BYTES_IN_KB)
            cc_algo = profile.get("congestion-control", "")
            cc_algo = conv_utils.get_cc_algo_val(cc_algo)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "idle_connection_timeout": timeout,
                        "nagles_algorithm": nagle,
                        "max_syn_retransmissions": syn_retrans,
                        "max_retransmissions": retrans,
                        "idle_connection_type": conn_type,
                        "time_wait_delay": delay,
                        "receive_window": window,
                        "cc_algo": cc_algo
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'udp':
            supported_attr = ["description", "idle-timeout",
                              "datagram-load-balancing", "defaults-from"]
            indirect = ['link-qos-to-client', 'proxy-mss',
                        'ip-tos-to-client', 'allow-no-payload']
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            per_pkt = profile.get("datagram-load-balancing", 'disabled')
            timeout = profile.get("idle-timeout", 0)
            ntwk_profile = {
                "profile": {
                    "type": "PROTOCOL_TYPE_UDP_FAST_PATH",
                    "udp_fast_path_profile": {
                        "per_pkt_loadbalance": (per_pkt == 'enabled'),
                        "session_idle_timeout": timeout
                    }
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)

        skipped, indirect = conv_utils.update_skipped_attributes(
                skipped, indirect, default_ignore, profile)
        if skipped:
            conv_utils.add_status_row(
                'profile', profile_type, name, 'partial', skipped,
                converted_objs, indirect)
        else:
            conv_utils.add_status_row(
                'profile', profile_type, name, 'successful', skipped,
                converted_objs, indirect)

class ProfileConfigConvV10(ProfileConfigConv):
    def convert_profile(self, profile, key, f5_config, avi_config, input_dir):
        skipped = profile.keys()
        indirect = []
        converted_objs = []
        f5_config["persistence"] = {}
        default_ignore = {}
        parent_cls = super(ProfileConfigConvV10, self)
        profile_type, name = key.split(" ")
        if profile_type in ("clientssl", "serverssl"):
            supported_attr = ["cert", "key", "ciphers", "unclean shutdown",
                              "crl file", "ca file", "defaults from",
                              "options"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            key_cert_obj = None
            cert_file = profile.get("cert", None)
            key_file = profile.get("key", None)
            key_file = None if key_file == 'none' else key_file
            cert_file = None if cert_file == 'none' else cert_file
            if key_file and cert_file:
                key_cert_obj = parent_cls.get_key_cert_obj(
                    name, key_file, cert_file, input_dir)
            if key_cert_obj:
                conv_utils.update_skip_duplicates(
                    key_cert_obj, avi_config['SSLKeyAndCertificate'],
                    'key_cert', converted_objs)
            ciphers = profile.get('ciphers', 'DEFAULT')
            ciphers = ciphers.replace('\"', '')
            ciphers = 'AES:3DES:RC4' if ciphers in ['DEFAULT',
                                                    'NATIVE'] else ciphers
            ciphers = ciphers.replace(":@SPEED", "")
            ssl_profile = dict()
            ssl_profile['name'] = name
            ssl_profile['accepted_ciphers'] = ciphers
            close_notify = profile.get('unclean shutdown', None)
            if close_notify and close_notify == 'enabled':
                ssl_profile['send_close_notify'] = True
            else:
                ssl_profile['send_close_notify'] = False
            conv_utils.update_skip_duplicates(
                ssl_profile, avi_config['SSLProfile'], 'ssl_profile',
                converted_objs)
            options = profile.get("options", "")
            if isinstance(options, dict):
                opt = []
                for opt_key in options.keys():
                    opt.append(opt_key+' '+options[opt_key])
                options = opt
            accepted_versions = []
            if "no tlsv1" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1"})
            if "no tlsv1.1" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1_1"})
            if "no tlsv1.2" not in options:
                accepted_versions.append({"type": "SSL_VERSION_TLS1_2"})
            if accepted_versions:
                ssl_profile["accepted_versions"] = accepted_versions

            crl_file_name = profile.get('crl file', None)
            ca_file_name = profile.get('ca file', None)
            if crl_file_name and crl_file_name != 'none':
                crl_file_name = crl_file_name.replace('\"', '').strip()
            else:
                crl_file_name = None
            if ca_file_name and ca_file_name != 'none':
                ca_file_name = ca_file_name.replace('\"', '').strip()
            else:
                ca_file_name = None
            if ca_file_name and crl_file_name:
                pki_profile = dict()
                file_path = input_dir+os.path.sep+ca_file_name
                pki_profile["name"] = name
                error = False
                ca = conv_utils.upload_file(file_path)
                if ca:
                    pki_profile["ca_certs"] = [{'certificate': ca}]
                else:
                    error = True
                file_path = input_dir+os.path.sep+crl_file_name
                crl = conv_utils.upload_file(file_path)
                if crl:
                    pki_profile["crls"] = [{'body': crl}]
                else:
                    error = True
                if not error:
                    conv_utils.update_skip_duplicates(
                        pki_profile, avi_config['PKIProfile'], 'pki_profile',
                        converted_objs)
            elif ca_file_name:
                LOG.warn("crl-file missing hence skipped ca-file")
                skipped.append("ca-file")
        elif profile_type == 'http':
            app_profile, sg_obj, skipped, fallback_host = \
                self.convert_http_profile(profile, name)
            if fallback_host:
                avi_config['fallback_host_dict'][name] = fallback_host
            indirect = ["lws separator", "max requests",
                        "compress browser workarounds", "cache size",
                        "compress uri include", "ramcache aging rate",
                        "compress gzip window size", "compress gzip level",
                        'compress cpu saver', 'compress cpu saver high',
                        'compress cpu saver low', 'compress min size',
                        'compress gzip memory level',
                        'compress vary header']

            ignore_for_defaults = {'compress uri exclude': 'none'}
            if sg_obj:
                avi_config['StringGroup'].append(sg_obj)
                converted_objs.append({'string_group': sg_obj})
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'dns':
            supported_attr = ["description", "defaults from"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_DNS'
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'fastL4':
            supported_attr = ["idle timeout", "software syncookie",
                              "defaults from"]
            indirect = ["reset on timeout", "pva acceleration"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            syn_protection = (profile.get("software syncookie", None) ==
                              'enabled')
            description = profile.get('description', None)
            timeout = profile.get("idle timeout", final.MIN_SESSION_TIMEOUT)
            if timeout < 60:
                timeout = final.MIN_SESSION_TIMEOUT
                LOG.warn("idle-timeout for profile: %s is less" % name +
                         " than minimum, changed to Avis minimum value")
            elif timeout > final.MAX_SESSION_TIMEOUT:
                timeout = final.MAX_SESSION_TIMEOUT
                LOG.warn("idle-timeout for profile: %s  is grater" % name +
                         " than maximum, changed to Avis maximum value")
            ntwk_profile = {
                "profile": {
                    "tcp_fast_path_profile": {
                      "session_idle_timeout": timeout,
                      "enable_syn_protection": syn_protection
                    },
                    "type": "PROTOCOL_TYPE_TCP_FAST_PATH"
                },
                "name": name,
                "description": description
            }
            app_profile = {
                "type": "APPLICATION_PROFILE_TYPE_L4",
                "name": name,
                "description": description
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
        elif profile_type == 'fasthttp':
            supported_attr = ["description", "idle timeout",
                              "defaults from", "max header size",
                              "insert xforwarded for"]
            ignore_for_defaults = {
                'server close timeout': '5', 'client close timeout': '5',
                'conn pool idle timeout override': '0',
                'conn pool max reuse': '0', 'conn pool max size': '2048',
                'conn pool min size': '0', 'conn pool step': '4',
                'header insert': '""', 'max requests': '0',
                'max segment override': '0', 'layer7': 'enable'
            }
            indirect = ["reset on timeout"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
            app_profile['description'] = profile.get('description', None)
            http_profile = dict()
            insert_xff = profile.get('insert xforwarded for', 'disabled')
            insert_xff = True if insert_xff == 'enabled' else False
            http_profile['x_forwarded_proto_enabled'] = insert_xff
            header_size = profile.get('max header size',
                                      final.DEFAULT_MAX_HEADER)
            http_profile['client_max_header_size'] = \
                int(header_size)/final.BYTES_IN_KB
            app_profile["http_profile"] = http_profile
            conv_utils.update_skip_duplicates(
                app_profile, avi_config['ApplicationProfile'], 'app_profile',
                converted_objs)
            timeout = profile.get("idle-timeout", 0)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "idle_connection_timeout": timeout
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'tcp':
            supported_attr = ["description", "idle timeout", "nagle",
                              "max retrans syn", "time wait recycle",
                              "time wait", "congestion control",
                              "recv window", "max retrans", "defaults from"]
            ignore_for_defaults = {
                'delayed acks': 'enable', 'deferred accept': 'disable',
                'proxy max segment': 'disable', 'selective acks': 'enable',
                'ecn': 'disable', 'limited transmit': 'enable',
                'rfc1323': 'enable', 'fin wait': '5', 'close wait': '5',
                'send buffer': '32768', 'keep alive interval': '1800',
                'zero window timeout': '20000'
            }
            indirect = ["reset on timeout", "slow start"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            timeout = profile.get("idle timeout", 0)
            nagle = profile.get("nagle", 'disabled')
            nagle = False if nagle == 'disabled' else True
            retrans = profile.get("max retrans", final.MIN_SYN_RETRANS)
            retrans = final.MIN_SYN_RETRANS if \
                int(retrans) < final.MIN_SYN_RETRANS else retrans
            retrans = final.MAX_SYN_RETRANS if \
                int(retrans) > final.MAX_SYN_RETRANS else retrans
            syn_retrans = profile.get("max retrans syn",
                                      final.MIN_SYN_RETRANS)
            syn_retrans = final.MIN_SYN_RETRANS \
                if int(syn_retrans) < final.MIN_SYN_RETRANS else syn_retrans
            syn_retrans = final.MAX_SYN_RETRANS \
                if int(syn_retrans) > final.MAX_SYN_RETRANS else syn_retrans
            conn_type = profile.get("time wait recycle", "disabled")
            conn_type = "CLOSE_IDLE" if \
                conn_type == "disabled" else "KEEP_ALIVE"
            delay = profile.get("time wait", 0)
            window = profile.get("recv window",
                                 (final.MIN_RECV_WIN * final.BYTES_IN_KB))
            window = int(int(window)/final.BYTES_IN_KB)
            cc_algo = profile.get("congestion-control", "")
            cc_algo = conv_utils.get_cc_algo_val(cc_algo)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "idle_connection_timeout": timeout,
                        "nagles_algorithm": nagle,
                        "max_syn_retransmissions": syn_retrans,
                        "max_retransmissions": retrans,
                        "idle_connection_type": conn_type,
                        "time_wait_delay": delay,
                        "receive_window": window,
                        "cc_algo": cc_algo
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'udp':
            supported_attr = ["idle timeout", "datagram lb",
                              "defaults from"]
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            per_pkt = profile.get("datagram lb", 'disable')
            timeout = profile.get("idle timeout", 0)
            ntwk_profile = {
                "profile": {
                    "type": "PROTOCOL_TYPE_UDP_FAST_PATH",
                    "udp_fast_path_profile": {
                        "per_pkt_loadbalance": (per_pkt == 'enable'),
                        "session_idle_timeout": timeout
                    }
                },
                "name": name
            }
            conv_utils.update_skip_duplicates(
                ntwk_profile, avi_config['NetworkProfile'], 'network_profile',
                converted_objs)
        elif profile_type == 'persist':
            f5_config["persistence"]['%s %s' %
                                     (profile.get("mode"), name)] = profile
        if skipped:
            conv_utils.add_status_row(
                'profile', profile_type, name, 'partial', skipped,
                converted_objs, indirect)
        else:
            conv_utils.add_status_row(
                'profile', profile_type, name, 'successful', skipped,
                converted_objs, indirect)

    def convert_http_profile(self, profile, name):
        """
        Converts HTTP f5 profile config to Avi HTTP profile config with
        caching and compression config
        :param profile: F5 http profile config
        :param name: http profile name
        :return: Avi http profile config
        """
        supported_attr = ["insert xforwarded for", "xff alternative names",
                          "max header size", "ramcache min object size",
                          "ramcache max age", "ramcache max object size",
                          "ramcache insert age header", "oneconnect transformations"
                          "compress keep accept encoding", "ramcache uri exclude",
                          "compress content type include", "ramcache uri include",
                          "ramcache size", "encrypt cookies", "fallback"]
        ignore_list = ['lws width']
        supported_attr = ignore_list + supported_attr
        skipped = [key for key in profile.keys() if key not in supported_attr]
        app_profile = dict()
        sg_obj = None
        app_profile['name'] = name
        app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
        http_profile = dict()
        encpt_cookie = profile.get('encrypt cookies', 'none')
        encpt_cookie = False if encpt_cookie == 'none' else True
        con_mltplxng = profile.get('oneconnect transformations', 'disabled')
        con_mltplxng = False if con_mltplxng == 'disabled' else True
        http_profile['x_forwarded_proto_enabled'] = profile.get(
            'insert xforwarded for', False)
        http_profile['xff_alternate_name'] = profile.get('xff alternative names',
                                                         None)
        header_size = profile.get('max header size', final.DEFAULT_MAX_HEADER)
        http_profile['client_max_header_size'] = int(header_size)/final.BYTES_IN_KB
        http_profile['connection_multiplexing_enabled'] = con_mltplxng
        http_profile['secure_cookie_enabled'] = encpt_cookie
        app_profile["http_profile"] = http_profile
        fallback_host = profile.get("fallback", 'none')
        fallback_host = None if fallback_host == 'none' else fallback_host

        cache = profile.get('ramcache', 'disable')
        if not cache == 'disable':
            cache_config = dict()
            cache_config['min_object_size'] = profile.get(
                'ramcache min object size', final.MIN_CACHE_OBJ_SIZE)
            cache_config['query_cacheable'] = True
            cache_config['max_object_size'] = profile.get(
                'ramcache max object size', final.MAX_CACHE_OBJ_SIZE)
            age_header = profile.get('ramcache insert age header', 'disable')
            if age_header == 'enable':
                cache_config['age_header'] = True
            else:
                cache_config['age_header'] = False
            cache_config['enabled'] = True
            cache_config['default_expire'] = profile.get(
                'ramcache max age', final.DEFAULT_CACHE_MAX_AGE)
            exclude_uri = profile.get("ramcache uri exclude", None)
            include_uri = profile.get("ramcache uri include", None)
            if exclude_uri and isinstance(exclude_uri, dict):
                exclude_uri = exclude_uri.keys() + exclude_uri.values()
                if None in exclude_uri:
                    exclude_uri.remove(None)
                cache_config['mime_types_black_list'] = exclude_uri
            if include_uri and isinstance(include_uri, dict):
                include_uri = include_uri.keys() + include_uri.values()
                if None in include_uri:
                    include_uri.remove(None)
                cache_config['mime_types_list'] = include_uri
            http_profile["cache_config"] = cache_config
        compression = profile.get('compress', 'disable')
        if not compression == 'disable':
            compression_profile = dict()
            compression_profile["type"] = "AUTO_COMPRESSION"
            compression_profile["compression"] = True
            encoding = profile.get("compress keep accept encoding", "disable")
            if encoding == "disable":
                encoding = True
            else:
                encoding = False
            compression_profile["remove_accept_encoding_header"] = encoding
            content_type = profile.get("compress content type include", "")
            content_type = None if content_type == 'none' else content_type
            ct_exclude = profile.get("compress content type exclude", "")
            content_type_exclude = None if ct_exclude == 'none' else ct_exclude
            if content_type and isinstance(content_type, str):
                content_type = content_type.split(" ")
            elif  content_type and isinstance(content_type, dict):
                content_type = content_type.keys()+content_type.values()
            elif content_type_exclude:
                content_type = final.DEFAULT_CONTENT_TYPE
            if content_type_exclude:
                content_type_exclude = content_type_exclude.keys() + \
                                       content_type_exclude.values()
                content_type = [ct for ct in content_type
                                if ct not in content_type_exclude]
            if content_type:
                sg_obj = conv_utils.get_containt_string_group(name, content_type)
                compression_profile["compressible_content_ref"] = \
                    name + "-content_type"
                http_profile = dict()
                http_profile["compression_profile"] = compression_profile

            compression_profile["compressible_content_ref"]= name + "-content_type"
            http_profile["compression_profile"] = compression_profile
        app_profile["http_profile"] = http_profile
        return app_profile, sg_obj, skipped, fallback_host