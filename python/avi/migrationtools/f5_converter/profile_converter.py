import copy
import logging
import os
import yaml
import avi.migrationtools.f5_converter.converter_constants as final
from avi.migrationtools.f5_converter.conversion_util import F5Util
LOG = logging.getLogger(__name__)
ssl_count = {'count': 0}
# Creating f5 object for util library.
conv_utils = F5Util()


class ProfileConfigConv(object):
    @classmethod
    def get_instance(cls, version, f5_profile_attributes,
                     object_merge_check, prefix, keypassphrase):
        """

        :param version:  version of f5 instance
        :param f5_profile_attributes: yaml attribute file for object
        :param object_merge_check: Flag for object merge
        :param prefix: prefix for objects
        :param keypassphrase: path of keypassphrase
        :return: object of respective f5 version object.
        """
        f5_profile_attributes = f5_profile_attributes
        if version == '10':
            return ProfileConfigConvV10(
                f5_profile_attributes, object_merge_check, prefix,
                keypassphrase)
        if version in ['11', '12']:
            return ProfileConfigConvV11(
                f5_profile_attributes, object_merge_check, prefix,
                keypassphrase)

    default_key = None

    ciphers = 'ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-SHA:ECDHE-' \
              'ECDSA-AES256-SHA:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-ECDSA-' \
              'AES128-SHA256:ECDHE-ECDSA-AES256-SHA384:AES128-GCM-SHA256:' \
              'AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:' \
              'AES256-SHA:DES-CBC3-SHA'

    def convert_profile(self, profile, key, f5_config, profile_config,
                        avi_config, input_dir, user_ignore, tenant_ref,
                        key_and_cert_mapping_list, merge_object_mapping,
                        sys_dict):
        pass

    def convert(self, f5_config, avi_config, input_dir, user_ignore,
                tenant_ref, cloud_ref, merge_object_mapping, sys_dict):
        """

        :param f5_config:  parsed f5 config dict.
        :param avi_config: avi config dict for converted avi conversion.
        :param input_dir: Location of cert and external monitor script files
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: tenant ref for avi objects
        :param cloud_ref: cloud ref for avi objects
        :param merge_object_mapping: merged object dict for merging objects
        :param sys_dict: baseline objects
        :return:
        """
        profile_config = f5_config.get("profile", {})
        avi_config["StringGroup"] = []
        avi_config['HTTPPolicySet'] = []
        avi_config['OneConnect'] = []
        key_and_cert_mapping_list = []
        persistence = f5_config.get("persistence", None)
        if not persistence:
            f5_config['persistence'] = {}
        avi_config['UnsupportedProfiles'] = []
        print "\nConverting Profiles ..."
        # Added variable to get total object count.
        progressbar_count = 0
        total_size = len(profile_config.keys())
        for key in profile_config.keys():
            progressbar_count += 1
            profile_type = None
            name = None
            try:
                profile_type, name = key.split(" ")
                tenant, name = conv_utils.get_tenant_ref(name)
                if not tenant_ref == 'admin':
                    tenant = tenant_ref
                if profile_type not in self.supported_types:
                    msg = ("Skipped not supported profile: %s of type: %s"
                            % (name, profile_type))
                    LOG.warning(msg)
                    conv_utils.add_status_row('profile', profile_type, name,
                                              final.STATUS_SKIPPED, msg)
                    avi_config['UnsupportedProfiles'].append(name)
                    continue
                # Added prefix for objects
                if self.prefix:
                    name = self.prefix + '-' + name
                LOG.debug("Converting profile: %s" % name)
                profile = profile_config[key]
                profile = self.update_with_default_profile(
                    profile_type, profile, profile_config, name)
                u_ignore = user_ignore.get('profile', {})
                self.convert_profile(
                    profile, key, f5_config, profile_config, avi_config,
                    input_dir, u_ignore, tenant, key_and_cert_mapping_list,
                    merge_object_mapping, sys_dict)
                LOG.debug("Conversion successful for profile: %s" % name)
            except:
                LOG.error("Failed to convert profile: %s" % key, exc_info=True)
                if name:
                    conv_utils.add_status_row('profile', profile_type, name,
                                              final.STATUS_ERROR)
                else:
                    conv_utils.add_status_row('profile', key, key,
                                              final.STATUS_ERROR)
            # Added call to check progress.
            msg = "Profile conversion started..."
            conv_utils.print_progress_bar(progressbar_count, total_size, msg,
                             prefix='Progress', suffix='')
        count = len(avi_config["SSLProfile"])
        count += len(avi_config["PKIProfile"])
        count += len(avi_config["ApplicationProfile"])
        count += len(avi_config["NetworkProfile"])
        LOG.debug("Converted %s profiles" % count)
        f5_config.pop("profile")
        del key_and_cert_mapping_list


    def update_with_default_profile(self, profile_type, profile,
                                    profile_config, profile_name):
        """
        Profiles can have inheritance used by attribute defaults-from in F5
        configuration this method recursively gets all the attributes from the
        default objects and forms complete object
        :param profile_type: type of profile
        :param profile: currant profile object
        :param profile_config: F5 profile config dict
        :param profile_name: Name of profile
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

    def update_key_cert_obj(self, name, key_file_name, cert_file_name,
                            input_dir, tenant, avi_config, converted_objs,
                            default_profile_name, key_and_cert_mapping_list,
                            merge_object_mapping, sys_dict):
        """
        This method create the certs if certificate not present at location
        it create dummy certificate.
        :param name: name of certificate.
        :param key_file_name: name of keyfile of cert
        :param cert_file_name: name of cert file
        :param input_dir: location of cert and key
        :param tenant: tenant name
        :param avi_config: converted avi config dict
        :param converted_objs: list of converted object profile
        :param default_profile_name: name of default profile name.
        :param key_and_cert_mapping_list: list of key and cert
        :param merge_object_mapping: merged object dict for merging objects
        :param sys_dict: baseline objects
        :return:
        """

        cert_name = [cert['name'] for cert in key_and_cert_mapping_list if
                     cert['key_file_name'] == key_file_name and
                     cert['cert_file_name'] == cert_file_name]

        if cert_name:
            LOG.warning(
                'SSL key and Certificate is already exist for %s and %s is %s' %
                (key_file_name, cert_file_name, cert_name[0]))
            return
        folder_path = input_dir + os.path.sep
        key = None
        cert = None
        if key_file_name and cert_file_name:
            # Removed / from key_file_name to get name of file.
            if '/' in key_file_name:
                key_file_name = key_file_name.split('/')[-1]
            # Removed / from cert_file_name to get name of file.
            if '/' in cert_file_name:
                cert_file_name = cert_file_name.split('/')[-1]
            key = conv_utils.upload_file(folder_path + key_file_name)
            cert = conv_utils.upload_file(folder_path + cert_file_name)

        is_key_protected = False
        if key:
            # Check kay is passphrase protected or not
            is_key_protected = conv_utils.is_certificate_key_protected(
                input_dir + os.path.sep + key_file_name)

        if cert and key:
            # Flag to check expiry date of certificate. if expired then
            # create dummy certificate.
            if not conv_utils.check_certificate_expiry(input_dir,
                                                    cert_file_name):
                cert, key = None, None

        key_passphrase = None
        # Get the key passphrase for key_file
        if is_key_protected and self.f5_passphrase_keys:
            key_passphrase = self.f5_passphrase_keys.get(key_file_name, None)

        if is_key_protected and not key_passphrase:
            key = None

        if not key or not cert:
            key, cert = conv_utils.create_self_signed_cert()
            name += '-dummy'
            LOG.warning('Create self cerificate and key for : %s' % name)

        ssl_kc_obj = None
        if key and cert:
            cert = {"certificate": cert}
            ssl_kc_obj = {
                'name': name,
                'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant'),
                'key': key,
                'certificate': cert,
                'type': 'SSL_CERTIFICATE_TYPE_VIRTUALSERVICE'
            }
        if key_passphrase:
            ssl_kc_obj['key_passphrase'] = key_passphrase
        if ssl_kc_obj:
            cert_obj = {'key_file_name': key_file_name,
                        'cert_file_name': cert_file_name,
                        'name': name
                        }
            key_and_cert_mapping_list.append(cert_obj)
            LOG.info('Added new SSL key and certificate for %s' % name)

        if ssl_kc_obj:
            if self.object_merge_check:
                if 'dummy' not in ssl_kc_obj['name']:
                    conv_utils.update_skip_duplicates(ssl_kc_obj,
                        avi_config['SSLKeyAndCertificate'],'ssl_cert_key',
                        converted_objs, name, default_profile_name,
                        merge_object_mapping, None, self.prefix, sys_dict[
                        'SSLKeyAndCertificate'])
                else:
                    converted_objs.append({'ssl_cert_key': ssl_kc_obj})
                    avi_config['SSLKeyAndCertificate'].append(ssl_kc_obj)
                self.certkey_count += 1
            else:
                converted_objs.append({'ssl_cert_key': ssl_kc_obj})
                avi_config['SSLKeyAndCertificate'].append(ssl_kc_obj)


class ProfileConfigConvV11(ProfileConfigConv):
    def __init__(self, f5_profile_attributes, object_merge_check, prefix,
                 keypassphrase):
        """

        :param f5_profile_attributes: f5 profile attributes from yaml file.
        :param object_merge_check: flag for merging objects
        :param prefix: prefix for objects
        :param keypassphrase: keypassphrase yaml file location
        """
        self.supported_types = \
            f5_profile_attributes['Profile_supported_types']
        self.ignore_for_defaults = \
            f5_profile_attributes['Profile_ignore_for_defaults']
        self.default_key = "defaults-from"
        self.na_ssl = f5_profile_attributes['Profile_na_ssl']
        self.indirect_ssl = f5_profile_attributes['Profile_indirect_ssl']
        self.supported_ssl = f5_profile_attributes['Profile_supported_ssl']
        self.na_http = f5_profile_attributes['Profile_na_http']
        self.supported_http = f5_profile_attributes['Profile_supported_http']
        self.indirect_http = f5_profile_attributes['Profile_indirect_http']
        self.na_dns = f5_profile_attributes['Profile_na_dns']
        self.supported_dns = f5_profile_attributes['Profile_supported_dns']
        self.indirect_dns = f5_profile_attributes['Profile_indirect_dns']
        self.supported_hc = f5_profile_attributes['Profile_supported_hc']
        self.na_hc = f5_profile_attributes['Profile_na_hc']
        self.indirect_hc = f5_profile_attributes['Profile_indirect_hc']

        self.supported_wa = f5_profile_attributes['Profile_supported_wa']
        self.indirect_wa = f5_profile_attributes['Profile_indirect_wa']

        self.supported_l4 = f5_profile_attributes['Profile_supported_l4']
        self.na_l4 = f5_profile_attributes['profile_na_l4']
        self.indirect_l4 = f5_profile_attributes['Profile_indirect_l4']

        self.supported_fh = f5_profile_attributes['Profile_supported_fh']
        self.indirect_fh = f5_profile_attributes['Profile_indirect_fh']
        self.na_fh = f5_profile_attributes['Profile_na_fh']

        self.supported_tcp = f5_profile_attributes['Profile_supported_tcp']
        self.indirect_tcp = f5_profile_attributes['Profile_indirect_tcp']
        self.na_tcp = f5_profile_attributes['Profile_na_tcp']
        self.supported_udp = f5_profile_attributes['Profile_supported_udp']
        self.indirect_udp = f5_profile_attributes['Profile_indirect_udp']
        self.supported_oc = f5_profile_attributes['Profile_supported_oc']
        if keypassphrase:
            self.f5_passphrase_keys = yaml.safe_load(open(keypassphrase))
        else:
            self.f5_passphrase_keys = None
        self.object_merge_check = object_merge_check
        # added code to handel count of sslmerge, applicationmerge,
        # networkmerge count, certkey_count
        self.app_count = 0
        self.net_count = 0
        self.pki_count = 0
        self.certkey_count = 0
        # Added prefix for objects
        self.prefix = prefix

    def convert_profile(self, profile, key, f5_config, profile_config,
                        avi_config, input_dir, user_ignore, tenant_ref,
                        key_and_cert_mapping_list, merge_object_mapping,
                        sys_dict):
        """

        :param profile: parsed dict of profile
        :param key: key which contain combination of profile type and name
        :param f5_config: parsed f5 config dict
        :param profile_config:
        :param avi_config: dict for avi config conversion.
        :param input_dir:  Location of input key and cert
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: Tenant for which config need to be converted
        :param key_and_cert_mapping_list: list of key and cert mapping list
        :param merge_object_mapping: flag to merge the objects
        :param sys_dict: baseline objects
        :return:
        """
        skipped = profile.keys()
        indirect = []
        converted_objs = []
        na_list = []
        u_ignore = []
        parent_cls = super(ProfileConfigConvV11, self)
        profile_type, name = key.split(' ')
        tenant, name = conv_utils.get_tenant_ref(name)
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        default_profile_name = '%s %s' % (profile_type,
                                          profile_type.replace('-', ''))
        default_ignore = f5_config['profile'].get(default_profile_name, {})
        default_ignore.update(self.ignore_for_defaults)
        default_profile_name = profile_type.replace('-', '')
        # Added prefix for objects
        if self.prefix:
            name = '%s-%s' % (self.prefix, name)
            default_profile_name = '%s-%s' % (self.prefix, default_profile_name)
        if profile_type in ('client-ssl', 'server-ssl'):
            supported_attr = self.supported_ssl
            na_list = self.na_ssl
            indirect = self.indirect_ssl
            u_ignore = user_ignore.get('client-ssl', [])
            u_ignore += user_ignore.get('server-ssl', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            original_prof = profile_config.get(key, None)
            inherit_key = original_prof.get('inherit-certkeychain', 'true')
            if inherit_key == 'false':
                profile['cert-key-chain'] = original_prof.get(
                    "cert-key-chain", None)
                profile['key'] = original_prof.get("key", None)
                profile['cert'] = original_prof.get("cert", None)

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
            # Added for getting correct file names from cache path in sys file
            sys_file = f5_config.get('file', {})
            for file_key in sys_file:
                file_type, file_name = file_key.split(' ')
                if file_type in ('ssl-key', 'ssl-cert'):
                    if file_type == 'ssl-key' and file_name == key_file and \
                            sys_file[file_key].get('cache-path'):
                        key_file = sys_file[file_key]['cache-path'].rsplit(
                                                                    '/', 1)[-1]
                    elif file_type == 'ssl-cert' and file_name == cert_file \
                            and sys_file[file_key].get('cache-path'):
                        cert_file = sys_file[file_key]['cache-path'].rsplit(
                                                                    '/', 1)[-1]
            parent_cls.update_key_cert_obj(
                name, key_file, cert_file, input_dir, tenant_ref, avi_config,
                converted_objs, default_profile_name, key_and_cert_mapping_list,
                merge_object_mapping, sys_dict)

            # ciphers = profile.get('ciphers', 'DEFAULT')
            # ciphers = 'AES:3DES:RC4' if ciphers == 'DEFAULT' else ciphers
            # ciphers = ciphers.replace(":@SPEED", "")
            ssl_profile = dict()
            ssl_profile['name'] = name
            ssl_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            ssl_profile['accepted_ciphers'] = self.ciphers
            close_notify = profile.get('unclean-shutdown', None)
            if close_notify and close_notify == 'enabled':
                ssl_profile['send_close_notify'] = True
            else:
                ssl_profile['send_close_notify'] = False
            options = profile.get("options", {})
            options = {} if options == 'none' else options
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
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ssl_profile, avi_config['SSLProfile'], 'ssl_profile',
                    converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['SSLProfile'])
                ssl_count['count'] += 1
            else:
                converted_objs.append({'ssl_profile': ssl_profile})
                avi_config['SSLProfile'].append(ssl_profile)
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

            if ca_file_name:
                pki_profile = dict()
                file_path = input_dir+os.path.sep+ca_file_name
                pki_profile["name"] = name
                pki_profile['tenant_ref'] = conv_utils.get_object_ref(
                    tenant, 'tenant')
                pc_mode = profile.get('peer-cert-mode', 'ignore')
                if pc_mode == 'ignore':
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_NONE'
                elif pc_mode == 'request':
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_REQUEST'
                elif pc_mode == 'require':
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_REQUIRE'
                pki_profile['mode'] = pc_mode
                error = False
                ca = conv_utils.upload_file(file_path)
                if ca:
                    pki_profile["ca_certs"] = [{'certificate': ca}]
                else:
                    error = True
                if crl_file_name:
                    file_path = input_dir+os.path.sep+crl_file_name
                    crl = conv_utils.upload_file(file_path)
                    if crl:
                        pki_profile["crls"] = [{'body': crl}]
                    else:
                        error = True
                else:
                    pki_profile['crl_check'] = False
                if not error:
                    if self.object_merge_check:
                        conv_utils.update_skip_duplicates(pki_profile,
                                    avi_config['PKIProfile'], 'pki_profile',
                                    converted_objs, name, default_profile_name,
                                    merge_object_mapping, None, self.prefix,
                                                        sys_dict['PKIProfile'])
                        self.pki_count += 1
                    else:
                        converted_objs.append({'pki_profile': pki_profile})
                        avi_config['PKIProfile'].append(pki_profile)
        elif profile_type == 'http':
            supported_attr = self.supported_http
            na_list = self.na_http
            u_ignore = user_ignore.get('http', [])
            indirect = self.indirect_http
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
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

            header_erase = profile.get('header-erase', None)
            header_erase = None if header_erase == 'none' else header_erase
            if header_erase:
                header_erase = header_erase.replace('\"', '')
            header_insert = profile.get('header-insert', None)
            header_insert = None if header_insert == 'none' else header_insert
            if header_insert:
                header_insert = header_insert.replace('\"', '')

            if header_erase or header_insert:
                rules = []
                rule_index = 1
                # Added condition of header insert and header erase present then
                # create common rule with more action.
                if header_erase and header_insert:
                    header_erase = header_erase.split(':')[0]
                    header, val = header_insert.split(':')
                    header_erase_rule = conv_utils.create_hdr_erase_rule(
                        'rule-header-erase', header_erase, rule_index)
                    header_insert_rule = conv_utils.create_hdr_insert_rule(
                        'rule-header-insert', header, val, rule_index)
                    header_erase_rule['hdr_action'].append(header_insert_rule[
                        'hdr_action'][0])
                    rules.append(header_erase_rule)
                elif header_erase:
                    if ':' in header_erase:
                        header_erase = header_erase.split(':', 1)[0]
                    rules.append(conv_utils.create_hdr_erase_rule(
                        'rule-header-erase', header_erase, rule_index))
                elif header_insert:
                    header, val = header_insert.split(':', 1)
                    rules.append(conv_utils.create_hdr_insert_rule(
                        'rule-header-insert', header, val, rule_index))
                rule_index += 1
                policy_name = name + '-HTTP-Policy-Set'
                policy = {
                    "name": policy_name,
                    "http_request_policy": {
                        "rules": rules
                    },
                    "is_internal_policy": False
                }
                policy['tenant_ref'] = conv_utils.get_object_ref(
                    tenant, 'tenant')
                avi_config['HTTPPolicySet'].append(policy)
                app_profile["HTTPPolicySet"] = policy_name
                converted_objs.append({'policy_set': policy})

                realm = profile.get("basic-auth-realm", 'none')
                realm = None if realm == 'none' else realm
                if realm:
                    app_profile['realm'] = realm
                host = profile.get("fallback-host", 'none')
                host = None if host == 'none' else host
                if host:
                    app_profile['fallback_host'] = host
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count += 1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)

        elif profile_type == 'dns':
            supported_attr = self.supported_dns
            na_list = self.na_dns
            u_ignore = user_ignore.get('dns', [])
            indirect = self.indirect_dns
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_DNS'
            app_profile['description'] = profile.get('description', None)
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count += 1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
        elif profile_type == 'web-acceleration':
            supported_attr = self.supported_wa
            indirect = self.indirect_wa
            u_ignore = user_ignore.get('web-acceleration', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
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
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count += 1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)

        elif profile_type == 'http-compression':
            supported_attr = self.supported_hc
            u_ignore = user_ignore.get('http-compression', [])
            na_list = self.na_hc
            indirect = self.indirect_hc
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            app_profile = dict()
            app_profile['name'] = name
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
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
                sg_obj = conv_utils.get_content_string_group(
                    name, content_type, tenant_ref)
                avi_config['StringGroup'].append(sg_obj)
                converted_objs.append({'string_group': sg_obj})
                cc_ref = name + "-content_type"
                cc_ref = conv_utils.get_object_ref(
                    cc_ref, 'stringgroup', tenant=tenant)
                compression_profile["compressible_content_ref"] = cc_ref

            http_profile["compression_profile"] = compression_profile
            app_profile["http_profile"] = http_profile
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count +=1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
        elif profile_type == 'fastl4':
            supported_attr = self.supported_l4
            indirect = self.indirect_l4
            na_list = self.na_l4
            u_ignore = user_ignore.get('fastl4', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            hw_syn_protection = (profile.get("hardware-syn-cookie",
                                             None) == 'enabled')
            sw_syn_protection = (profile.get("software-syn-cookie",
                                             None) == 'enabled')
            syn_protection = (hw_syn_protection or sw_syn_protection)
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
                'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant'),
                "description": description
            }
            app_profile = dict()
            app_profile['name'] = name
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_L4'
            app_profile['description'] = description
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            explicit_tracking = profile.get("explicit-flow-migration", None)
            l4_profile = {"rl_profile": {
                "client_ip_connections_rate_limit": {
                    "explicit_tracking": (explicit_tracking == 'enabled')
                }}
            }
            app_profile['dos_rl_profile'] = l4_profile
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count +=1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile', converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count +=1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
        elif profile_type == 'fasthttp':
            supported_attr = self.supported_fh
            indirect = self.indirect_fh
            na_list = self.na_fh
            u_ignore = user_ignore.get('fasthttp', [])
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
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count +=1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
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
                        "idle_connection_timeout": timeout,
                        'automatic': False
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile', converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count +=1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)

        elif profile_type == 'one-connect':
            supported_attr = self.supported_oc
            indirect = []
            u_ignore = user_ignore.get('one-connect', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            mask = profile.get('source-mask', 'any')
            if not mask == 'any':
                skipped.append('source-mask')
            converted_objs = \
                'Maps Indirectly to : HTTP Profile -> Connection Multiplex'
            LOG.warn('one-connect profile %s will be mapped indirectly to HTTP '
                     'Profile -> Connection Multiplex of the same VS if '
                     'oneconnect-transformations is enabled' % name)
            avi_config['OneConnect'].append(name)

        elif profile_type == 'tcp':
            supported_attr = self.supported_tcp
            indirect = self.indirect_tcp
            na_list = self.na_tcp
            u_ignore = user_ignore.get('tcp', [])
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
            ip_dscp = profile.get("ip-tos-to-client", None)
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
                        "cc_algo": cc_algo,
                        'automatic': False
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            if ip_dscp:
                is_ip_dscp = True
                if ip_dscp == 'pass-through':
                    ip_dscp = 2147483647
                elif ip_dscp == 'mimic':
                    is_ip_dscp = False
                    skipped.append('ip-tos-to-client')
                if is_ip_dscp:
                    ntwk_profile["profile"]["tcp_proxy_profile"]["ip_dscp"] = \
                        ip_dscp

            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile', converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count +=1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
        elif profile_type == 'udp':
            supported_attr = self.supported_udp
            indirect = self.indirect_udp
            u_ignore = user_ignore.get('udp', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            per_pkt = profile.get("datagram-load-balancing", 'disabled')
            timeout = str(profile.get("idle-timeout", 0))
            if not timeout.isdigit():
                timeout = 0
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
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile', converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count +=1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
        conv_status = conv_utils.get_conv_status(
                skipped, indirect, default_ignore, profile, u_ignore, na_list)
        conv_utils.add_conv_status('profile', profile_type, name, conv_status,
                                   converted_objs)

class ProfileConfigConvV10(ProfileConfigConv):
    def __init__(self, f5_profile_attributes, object_merge_check, prefix,
                 keypassphrase):
        """

        :param f5_profile_attributes: f5 profile attributes from yaml file.
        :param object_merge_check: flag for merging objects
        :param prefix: prefix for objects
        :param keypassphrase: keypassphrase yaml file location
        """
        self.supported_types = f5_profile_attributes['Profile_supported_types']
        self.default_key = "defaults from"
        self.supported_ssl = f5_profile_attributes['Profile_supported_ssl']
        self.na_ssl = f5_profile_attributes['Profile_na_ssl']
        self.indirect_ssl = f5_profile_attributes['Profile_indirect_ssl']
        self.ignore_for_defaults = \
            f5_profile_attributes['Profile_ignore_for_defaults']
        self.na_http = f5_profile_attributes['Profile_na_http']
        self.supported_http = f5_profile_attributes['Profile_supported_http']
        self.indirect_http = f5_profile_attributes['Profile_indirect_http']
        self.na_dns = []
        self.supported_dns = f5_profile_attributes['Profile_supported_dns']
        self.indirect_dns = []
        self.supported_l4 = f5_profile_attributes['Profile_supported_l4']
        self.indirect_l4 = f5_profile_attributes['Profile_indirect_l4']
        self.supported_fh = f5_profile_attributes['Profile_supported_fh']
        self.indirect_fh = f5_profile_attributes['Profile_indirect_fh']
        self.supported_tcp = f5_profile_attributes['Profile_supported_tcp']
        self.indirect_tcp = f5_profile_attributes['Profile_indirect_tcp']
        self.supported_udp = f5_profile_attributes['Profile_supported_udp']
        self.indirect_udp = []
        self.supported_oc = f5_profile_attributes['Profile_supported_oc']
        if keypassphrase:
            self.f5_passphrase_keys = yaml.safe_load(open(keypassphrase))
        else:
            self.f5_passphrase_keys = None
        self.object_merge_check = object_merge_check
        # code to get count to merge objects
        self.app_count = 0
        self.net_count = 0
        self.pki_count = 0
        self.certkey_count = 0
        # Added prefix for objects
        self.prefix = prefix

    def convert_profile(self, profile, key, f5_config, profile_config,
                        avi_config, input_dir, user_ignore, tenant_ref,
                        key_and_cert_mapping_list, merge_object_mapping,
                        sys_dict):
        """

        :param profile: parsed dict of profile
        :param key: key which contain combination of profile type and name
        :param f5_config: parsed f5 config dict
        :param profile_config: dict of profile config
        :param avi_config: dict for avi config conversion.
        :param input_dir:  Location of input key and cert
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: Tenant for which config need to be converted
        :param key_and_cert_mapping_list: list of key and cert mapping list
        :param merge_object_mapping: flag to merge the objects
        :param sys_dict: baseline objects
        :return:
        """
        skipped = profile.keys()
        indirect = []
        converted_objs = []
        u_ignore = []
        na_list = []
        parent_cls = super(ProfileConfigConvV10, self)
        profile_type, name = key.split(" ")
        default_profile_name = '%s %s' % (profile_type, profile_type)
        default_ignore = f5_config['profile'].get(default_profile_name, {})
        default_ignore.update(self.ignore_for_defaults)
        tenant, name = conv_utils.get_tenant_ref(name)
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        old_name = name
        default_profile_name = profile_type
        # Added prefix for objects
        if self.prefix:
            name = '%s-%s' % (self.prefix, name)
            default_profile_name = '%s-%s' % (self.prefix, default_profile_name)
        if profile_type in ("clientssl", "serverssl"):
            supported_attr = self.supported_ssl
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            u_ignore = user_ignore.get('clientssl', [])
            u_ignore += user_ignore.get('serverssl', [])
            na_list = self.na_ssl
            indirect = self.indirect_ssl
            original_prof = profile_config.get('%s %s' % (profile_type,
                                                          old_name), None)
            inherit_key = original_prof.get('inherit-certkeychain', 'true')
            if inherit_key == 'false':
                profile['key'] = original_prof.get("key", None)
                profile['cert'] = original_prof.get("cert", None)
            cert_file = profile.get("cert", None)
            key_file = profile.get("key", None)
            key_file = None if key_file == 'none' else key_file
            cert_file = None if cert_file == 'none' else cert_file
            if key_file and cert_file:
                key_file = key_file.replace('\"', '')
                cert_file = cert_file.replace('\"', '')

            parent_cls.update_key_cert_obj(
                name, key_file, cert_file, input_dir, tenant_ref, avi_config,
                converted_objs, default_profile_name, key_and_cert_mapping_list,
                merge_object_mapping, sys_dict)
            ssl_profile = dict()
            ssl_profile['name'] = name
            ssl_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            ssl_profile['accepted_ciphers'] = self.ciphers
            close_notify = profile.get('unclean shutdown', None)
            if close_notify and close_notify == 'enabled':
                ssl_profile['send_close_notify'] = True
            else:
                ssl_profile['send_close_notify'] = False
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
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ssl_profile, avi_config['SSLProfile'], 'ssl_profile',
                    converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['SSLProfile'])
                ssl_count['count'] += 1
            else:
                converted_objs.append({'ssl_profile': ssl_profile})
                avi_config['SSLProfile'].append(ssl_profile)
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
            if ca_file_name:
                pki_profile = dict()
                file_path = input_dir+os.path.sep+ca_file_name
                pki_profile["name"] = name
                pc_mode = profile.get('peer-cert-mode', 'ignore')
                if pc_mode == 'ignore':
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_NONE'
                elif pc_mode == 'request':
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_REQUEST'
                else:
                    pc_mode = 'SSL_CLIENT_CERTIFICATE_REQUIRE'
                pki_profile['mode'] = pc_mode
                pki_profile['tenant_ref'] = conv_utils.get_object_ref(
                    tenant, 'tenant')
                error = False
                ca = conv_utils.upload_file(file_path)
                if ca:
                    pki_profile["ca_certs"] = [{'certificate': ca}]
                else:
                    error = True
                if crl_file_name:
                    file_path = input_dir+os.path.sep+crl_file_name
                    crl = conv_utils.upload_file(file_path)
                    if crl:
                        pki_profile["crls"] = [{'body': crl}]
                    else:
                        error = True
                else:
                    pki_profile['crl_check'] = False
                if not error:
                    if self.object_merge_check:
                        conv_utils.update_skip_duplicates(pki_profile,
                                    avi_config['PKIProfile'], 'pki_profile',
                                    converted_objs, name, default_profile_name,
                                    merge_object_mapping, None, self.prefix,
                                                         sys_dict['PKIProfile'])
                        self.pki_count += 1
                    else:
                        converted_objs.append({'pki_profile': pki_profile})
                        avi_config['PKIProfile'].append(pki_profile)
        elif profile_type == 'http':
            app_profile, skipped = self.convert_http_profile(
                profile, name, avi_config, converted_objs, tenant)
            u_ignore = user_ignore.get('http', [])
            na_list = self.na_http
            indirect = self.indirect_http
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count += 1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
        elif profile_type == 'dns':
            supported_attr = self.supported_dns
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            u_ignore = user_ignore.get('dns', [])
            app_profile = dict()
            app_profile['name'] = name
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            app_profile['type'] = 'APPLICATION_PROFILE_TYPE_DNS'
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count += 1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
        elif profile_type == 'fastL4':
            supported_attr = self.supported_l4
            indirect = self.indirect_l4
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            u_ignore = user_ignore.get('fastL4', [])
            hw_syn_protection = (profile.get("hardware syncookie",
                                             None) == 'enabled')
            sw_syn_protection = (profile.get("software syncookie",
                                             None) == 'enabled')

            syn_protection = (hw_syn_protection or sw_syn_protection)

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
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile',converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count +=1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    app_profile, avi_config['ApplicationProfile'],
                    'app_profile', converted_objs, name, default_profile_name,
                    merge_object_mapping, profile_type, self.prefix,
                    sys_dict['ApplicationProfile'])
                self.app_count +=1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)

        elif profile_type == 'fasthttp':
            supported_attr = self.supported_fh
            u_ignore = user_ignore.get('fasthttp', [])
            indirect = self.indirect_fh
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
            # code to merge application profile count.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates\
                    (app_profile, avi_config['ApplicationProfile'],
                     'app_profile',converted_objs, name, default_profile_name,
                     merge_object_mapping, profile_type, self.prefix,
                     sys_dict['ApplicationProfile'])
                self.app_count +=1
            else:
                converted_objs.append({'app_profile': app_profile})
                avi_config['ApplicationProfile'].append(app_profile)
            timeout = profile.get("idle-timeout", 0)
            ntwk_profile = {
                "profile": {
                    "tcp_proxy_profile": {
                        "idle_connection_timeout": timeout,
                        'automatic': False
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            app_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates\
                    (ntwk_profile, avi_config['NetworkProfile'],
                     'network_profile',converted_objs, name,
                     default_profile_name, merge_object_mapping,
                     profile_type, self.prefix, sys_dict['NetworkProfile'])
                self.net_count += 1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)

        elif profile_type == 'oneconnect':
            supported_attr = self.supported_oc
            indirect = []
            u_ignore = user_ignore.get('oneconnect', [])
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            mask = profile.get('source mask', '0.0.0.0')
            if not mask == '0.0.0.0':
                skipped.append('source-mask')
            converted_objs = \
                'Maps Indirectly to : HTTP Profile -> Connection Multiplex'
            LOG.warn('oneconnect profile %s will be mapped indirectly to HTTP '
                     'Profile -> Connection Multiplex of the same VS if '
                     'oneconnect-transformations is enabled' % name)
            avi_config['OneConnect'].append(name)
        elif profile_type == 'tcp':
            u_ignore = user_ignore.get('tcp', [])
            supported_attr = self.supported_tcp
            indirect = self.indirect_tcp
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
            ip_dscp = profile.get("ip tos", None)
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
                        "cc_algo": cc_algo,
                        'automatic': False
                    },
                    "type": "PROTOCOL_TYPE_TCP_PROXY"
                },
                "name": name
            }
            if ip_dscp:
                is_ip_dscp = True
                if ip_dscp == 'pass':
                    ip_dscp = 2147483647
                elif ip_dscp == 'mimic':
                    is_ip_dscp = False
                    skipped.append('ip tos')
                if is_ip_dscp:
                    ntwk_profile["profile"]["tcp_proxy_profile"]["ip_dscp"] = \
                        ip_dscp
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates\
                    (ntwk_profile, avi_config['NetworkProfile'],
                     'network_profile',converted_objs, name,
                     default_profile_name, merge_object_mapping,
                     profile_type, self.prefix, sys_dict['NetworkProfile'])

                self.net_count += 1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
        elif profile_type == 'udp':
            u_ignore = user_ignore.get('udp', [])
            supported_attr = self.supported_udp
            skipped = [attr for attr in profile.keys()
                       if attr not in supported_attr]
            per_pkt = profile.get("datagram lb", 'disable')
            timeout = profile.get("idle timeout", 0)
            if not timeout.isdigit():
                timeout = 0
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
            ntwk_profile['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            # code to get merge count of network profile.
            if self.object_merge_check:
                conv_utils.update_skip_duplicates(
                    ntwk_profile, avi_config['NetworkProfile'],
                    'network_profile', converted_objs, name,
                    default_profile_name, merge_object_mapping, profile_type,
                    self.prefix, sys_dict['NetworkProfile'])
                self.net_count += 1
            else:
                converted_objs.append({'network_profile': ntwk_profile})
                avi_config['NetworkProfile'].append(ntwk_profile)
        elif profile_type == 'persist':
            mode = profile.get("mode").replace(' ', '-')
            f5_config["persistence"]['%s %s' % (mode, name)] = profile
            return

        conv_status = conv_utils.get_conv_status(
                skipped, indirect, default_ignore, profile, u_ignore, na_list)
        conv_utils.add_conv_status('profile', profile_type, name, conv_status,
                                   converted_objs)

    def convert_http_profile(self, profile, name, avi_config, converted_objs,
                             tenant):
        """
        :param profile: parsed profile config dict.
        :param name: name of http profile.
        :param avi_config: dict to store converted avi config
        :param converted_objs: list of converted object
        :param tenant: Tenant for which config need to be converted
        :return: app_profile, skipped
        """
        supported_attr = self.supported_http
        skipped = [key for key in profile.keys() if key not in supported_attr]
        app_profile = dict()
        app_profile['name'] = name
        app_profile['tenant_ref'] = conv_utils.get_object_ref(tenant, 'tenant')
        app_profile['type'] = 'APPLICATION_PROFILE_TYPE_HTTP'
        http_profile = dict()
        encpt_cookie = profile.get('encrypt cookies', 'none')
        encpt_cookie = False if encpt_cookie == 'none' else True
        con_mltplxng = profile.get('oneconnect transformations', 'disabled')
        con_mltplxng = False if con_mltplxng == 'disabled' else True
        http_profile['x_forwarded_proto_enabled'] = profile.get(
            'insert xforwarded for', False)
        http_profile['xff_alternate_name'] = profile.get(
            'xff alternative names', None)
        header_size = profile.get('max header size', final.DEFAULT_MAX_HEADER)
        http_profile['client_max_header_size'] = int(
            header_size)/final.BYTES_IN_KB
        http_profile['connection_multiplexing_enabled'] = con_mltplxng
        http_profile['secure_cookie_enabled'] = encpt_cookie
        app_profile["http_profile"] = http_profile
        fallback_host = profile.get("fallback", 'none')
        fallback_host = None if fallback_host == 'none' else fallback_host
        if fallback_host:
                app_profile['fallback_host'] = fallback_host

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
            elif content_type and isinstance(content_type, dict):
                content_type = content_type.keys()+content_type.values()
                content_type = list(set(content_type))
                content_type.remove(None)
            elif content_type_exclude:
                content_type = final.DEFAULT_CONTENT_TYPE
            if content_type_exclude:
                content_type_exclude = content_type_exclude.keys() + \
                                       content_type_exclude.values()
                content_type = [ct for ct in content_type
                                if ct not in content_type_exclude]
            if content_type:
                sg_obj = conv_utils.get_content_string_group(
                    name, content_type, tenant)
                avi_config['StringGroup'].append(sg_obj)
                converted_objs.append({'string_group': sg_obj})
                cc_ref = name + "-content_type"
                cc_ref = conv_utils.get_object_ref(
                    cc_ref, 'stringgroup', tenant=tenant)
                compression_profile["compressible_content_ref"] = cc_ref
            http_profile["compression_profile"] = compression_profile
        app_profile["http_profile"] = http_profile
        header_erase = profile.get('header-erase', None)
        header_erase = None if header_erase == 'none' else header_erase

        if header_erase:
            header_erase = header_erase.replace('\"', '')
        header_insert = profile.get('header-insert', None)
        header_insert = None if header_insert == 'none' else header_insert
        if header_insert:
            header_insert = header_insert.replace('\"', '')

        if header_erase or header_insert:
            rules = []
            rule_index = 1
            # Added condition of header insert and header erase present then
            # create common rule with more action.
            if header_erase and header_insert:
                header_erase = header_erase.split(':')[0]
                header, val = header_insert.split(':')
                header_erase_rule = conv_utils.create_hdr_erase_rule(
                    'rule-header-erase', header_erase, rule_index)
                header_insert_rule = conv_utils.create_hdr_insert_rule(
                    'rule-header-insert', header, val, rule_index)
                header_erase_rule['hdr_action'].append(header_insert_rule[
                                                           'hdr_action'][0])
                rules.append(header_erase_rule)
            elif header_erase:
                if ':' in header_erase:
                    header_erase = header_erase.split(':')[0]
                rules.append(conv_utils.create_hdr_erase_rule(
                    'rule-header-erase', header_erase, rule_index))
            elif header_insert:
                header, val = header_insert.split(':')
                rules.append(conv_utils.create_hdr_insert_rule(
                    'rule-header-insert', header, val, rule_index))
            rule_index += 1
            policy_name = name + '-HTTP-Policy-Set'
            policy = {
                "name": policy_name,
                "http_request_policy": {
                    "rules": rules
                },
                "is_internal_policy": False
            }
            policy['tenant_ref'] = conv_utils.get_object_ref(
                tenant, 'tenant')
            avi_config['HTTPPolicySet'].append(policy)
            app_profile["HTTPPolicySet"] = policy_name
            converted_objs.append({'policy_set': policy})
        return app_profile, skipped