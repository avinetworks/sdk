import copy
import logging
import os
import avi.migrationtools.f5_converter.converter_constants as conv_const
from pkg_resources import parse_version
from avi.migrationtools.f5_converter.profile_converter import ssl_count
from avi.migrationtools.f5_converter.conversion_util import F5Util

LOG = logging.getLogger(__name__)
# Creating f5 object for util library.
conv_utils = F5Util()


class MonitorConfigConv(object):
    @classmethod
    def get_instance(cls, version, f5_monitor_atributes, prefix,
                     object_merge_check):
        """

        :param version: version of f5 instance
        :param f5_monitor_atributes: f5 monitor attributes from yaml file.
        :param prefix:  prefix for objects
        :param object_merge_check: Flag for object merge
        :return:
        """
        if version == '10':
            return MonitorConfigConvV10(f5_monitor_atributes, prefix,
                                        object_merge_check)
        if version in ['11', '12']:
            return MonitorConfigConvV11(f5_monitor_atributes, prefix,
                                        object_merge_check)

    def get_defaults(self, monitor_config, key):
        pass

    def get_name_type(self, f5_monitor, key):
        pass

    def get_default_monitor(self, monitor_type, monitor_config):
        pass

    def convert_http(self, monitor_dict, f5_monitor, skipped):
        pass

    def convert_https(self, monitor_dict, f5_monitor, skipped, avi_config,
                      tenant, input_dir, cloud_name, controller_version,
                      merge_object_mapping, sys_dict):
        pass

    def convert_dns(self, monitor_dict, f5_monitor, skipped):
        pass

    def convert_tcp(self, monitor_dict, f5_monitor, skipped, type):
        pass

    def convert_udp(self, monitor_dict, f5_monitor, skipped):
        pass

    def convert_icmp(self, monitor_dict, f5_monitor, skipped):
        pass

    def convert_external(self, monitor_dict, f5_monitor, skipped, input_dir,
                         name):
        pass

    def create_sslprofile(self, monitor_dict, f5_monitor, avi_config,
                           tenant, cloud_name, merge_object_mapping, sys_dict):
        """

        :param monitor_dict: parsed monitor dict of f5 config
        :param f5_monitor: parsed dict of f5 config
        :param avi_config: dict for conversion to avi config
        :param tenant: tenant for which config need to be converted
        :param input_dir: location of input certs and key
        :param cloud_name: cloud name for which config need to be converted
        :param controller_version: controller version of avi
        :return:
        """
        # Condition to create ssl profile.
        converted_objs = []
        cipher = f5_monitor.get('cipherlist', None)
        cipher = cipher.replace('\"', '') if cipher is not None else None
        ssl_profile = dict()
        ssl_profile["accepted_versions"] = [
            {"type": "SSL_VERSION_TLS1"},
            {"type": "SSL_VERSION_TLS1_1"},
            {"type": "SSL_VERSION_TLS1_2"}
        ]
        # Removed '-sslprofile' suffix from name
        ssl_profile['name'] = monitor_dict['name']
        ssl_profile['tenant_ref'] = conv_utils.get_object_ref(
            tenant, 'tenant')
        ssl_profile['accepted_ciphers'] = cipher
        if self.object_merge_check:
            conv_utils.update_skip_duplicates(
                ssl_profile, avi_config['SSLProfile'], 'ssl_profile',
                converted_objs, ssl_profile['name'], None, merge_object_mapping,
                None, self.prefix, sys_dict['SSLProfile'])
            ssl_count['count'] += 1
        else:
            avi_config['SSLProfile'].append(ssl_profile)
        sname = [ob for ob in sys_dict['SSLProfile'] if ob['name'] ==
                merge_object_mapping['ssl_profile'].get(ssl_profile['name'])] \
                or [sname for sname in avi_config['SSLProfile'] if (
                sname['name'] == ssl_profile['name'] or ssl_profile[
                'name'] in sname.get('dup_of', []))]
        ref = conv_utils.get_object_ref(
            sname[0]['name'], "sslprofile", tenant, cloud_name)
        monitor_dict["https_monitor"]['ssl_attributes'][
            'ssl_profile_ref'] = ref

    def create_sslkeyandcert(self, monitor_dict, f5_monitor, avi_config, tenant,
                             input_dir, cloud_name, merge_object_mapping,
                             sys_dict):
        """

        :param monitor_dict: parsed monitor dict of f5 config
        :param f5_monitor: parsed dict of f5 config
        :param avi_config: dict for conversion to avi config
        :param tenant: tenant for which config need to be converted
        :param input_dir: location of input certs and key
        :param cloud_name: cloud name for which config need to be converted
        :param merge_object_mapping: flag for merging objects
        :param sys_dict: baseline profile dict
        :return:
        """
        # Condition create  sslkeyandcert.
        converted_objs = []
        key_file_name = f5_monitor.get('key', None)
        cert_file_name = f5_monitor.get('cert', None)
        folder_path = input_dir + os.path.sep
        key = None
        if key_file_name:
            key = conv_utils.upload_file(folder_path + key_file_name)
        cert = None
        if cert_file_name:
            cert = conv_utils.upload_file(folder_path + cert_file_name)
        name = monitor_dict['name']
        if not key or not cert:
            key, cert = conv_utils.create_self_signed_cert()
            name = monitor_dict['name'] + '-dummy'
            LOG.warning(
                'Create self cerificate and key for : %s' % key_file_name)
        ssl_kc_obj = None
        if key and cert:
            cert = {"certificate": cert}
            ssl_kc_obj = {
                'name': name,
                'tenant_ref': conv_utils.get_object_ref(tenant,
                                                        'tenant'),
                'key': key,
                'certificate': cert,
                'key_passphrase': '',
                'type': 'SSL_CERTIFICATE_TYPE_VIRTUALSERVICE'
            }
        # Added condition for merging sslkeyandcert
        if ssl_kc_obj and 'dummy' not in ssl_kc_obj['name']:
            conv_utils.update_skip_duplicates(ssl_kc_obj,
                avi_config['SSLKeyAndCertificate'], 'ssl_cert_key',
                converted_objs, name, None, merge_object_mapping,
                None, self.prefix, sys_dict['SSLKeyAndCertificate'])
        else:
            avi_config['SSLKeyAndCertificate'].append(ssl_kc_obj)
        ssl_key_cert_list = avi_config.get("SSLKeyAndCertificate", [])
        key_cert = [ob for ob in sys_dict['SSLKeyAndCertificate'] if
                   ob['name'] == merge_object_mapping['ssl_cert_key'].get(
                   name)] or [obj for obj in ssl_key_cert_list if
                   (obj['name'] == name or obj['name'] == name + '-dummy'
                   or name in obj.get("dup_of", []))]
        if key_cert:
            name = key_cert[0]['name']
        ref = conv_utils.get_object_ref(
             name, "sslkeyandcertificate", tenant, cloud_name)
        monitor_dict["https_monitor"]['ssl_attributes'][
             'ssl_key_and_certificate_ref'] = ref
        LOG.info('Added new SSL key and certificate for %s' % name)

    def convert(self, f5_config, avi_config, input_dir, user_ignore, tenant,
                cloud_name, controller_version, merge_object_mapping, sys_dict):
        """

        :param f5_config:  parsed f5 config dict
        :param avi_config: dict for conversion to avi config
        :param input_dir: location of cert and key
        :param user_ignore: Ignore config defined by user
        :param tenant: tenant of which config to be converted
        :param cloud_name:  cloud name of which config to be converted
        :param controller_version: controller version.
        :param merge_object_mapping: flag for merge object
        :param sys_dict: baseline profile.
        :return:
        """
        LOG.debug("Converting health monitors")
        print "Converting Monitors..."
        converted_objs = []
        m_user_ignore = user_ignore.get('monitor', {})
        monitor_config = f5_config.pop("monitor", {})
        # Added varibles to  get total count of object.
        total_size = len(monitor_config.keys())
        progressbar_count = 0
        for key in monitor_config.keys():
            progressbar_count += 1
            # Added call to check progress.
            msg = "Monitor conversion started..."
            conv_utils.print_progress_bar(progressbar_count, total_size, msg,
                               prefix='Progress', suffix='')
            f5_monitor = monitor_config[key]
            if not f5_monitor:
                if " " in key:
                    m_type, name = key.split(" ")
                else:
                    m_type = None
                    name = key
                msg = "Empty config for monitor: %s " % name
                LOG.warn(msg)
                conv_utils.add_status_row('monitor', m_type, name,
                                          conv_const.STATUS_SKIPPED, msg)
                continue
            f5_monitor = self.get_defaults(monitor_config, key)
            monitor_type, name = self.get_name_type(f5_monitor, key)
            # Added prefix for objects
            if self.prefix:
                name = self.prefix + '-' + name
            try:
                LOG.debug("Converting monitor: %s" % name)
                if monitor_type not in self.supported_types:
                    avi_monitor = self.convert_monitor(
                        f5_monitor, key, monitor_config, input_dir,
                        m_user_ignore,
                        tenant, avi_config, cloud_name, controller_version,
                        merge_object_mapping, sys_dict)
                    if not avi_monitor:
                        continue
                    avi_monitor['name'] = '%s-%s' % (avi_monitor['name'],
                                                     'dummy')
                    avi_monitor["type"] = "HEALTH_MONITOR_EXTERNAL"
                    ext_monitor = {
                        "command_code": "",
                    }
                    avi_monitor["external_monitor"] = ext_monitor
                    avi_config['HealthMonitor'].append(avi_monitor)
                    msg = "Monitor type {} not supported, created dummy " \
                          "external monitor {}".format(monitor_type,
                                                       avi_monitor['name'])
                    LOG.warn(msg)
                    conv_utils.add_status_row(
                        'monitor', monitor_type, name,
                        conv_const.STATUS_EXTERNAL_MONITOR, msg)
                    continue
                avi_monitor = self.convert_monitor(
                    f5_monitor, key, monitor_config, input_dir, m_user_ignore,
                    tenant, avi_config, cloud_name, controller_version,
                    merge_object_mapping, sys_dict)
                if not avi_monitor:
                    continue
                # code to merge health monitor.
                if self.object_merge_check:
                    conv_utils.update_skip_duplicates(avi_monitor,
                        avi_config['HealthMonitor'], 'health_monitor',
                            converted_objs, name, None, merge_object_mapping,
                                            monitor_type, self.prefix,
                                                      sys_dict['HealthMonitor'])
                    self.mon_count += 1
                else:
                    avi_config["HealthMonitor"].append(avi_monitor)
                LOG.debug("Conversion successful for monitor: %s" % name)
            except:
                LOG.error("Failed to convert monitor: %s" % key, exc_info=True)
                if name:
                    conv_utils.add_status_row('monitor', monitor_type, name,
                                              conv_const.STATUS_ERROR)
                else:
                    conv_utils.add_status_row('monitor', key, key,
                                              conv_const.STATUS_ERROR)
        LOG.debug("Converted %s health monitors" %
                  len(avi_config["HealthMonitor"]))

    def convert_monitor(self, f5_monitor, key, monitor_config, input_dir,
                        user_ignore, tenant_ref, avi_config, cloud_name,
                        controller_version, merge_object_mapping, sys_dict):
        """

        :param f5_monitor: parsed f5 config dict
        :param monitor_config: parsed monitor config dict
        :param input_dir: location of cert and key
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: tenant of which output to be converted
        :param avi_config: converted avi config dict
        :param cloud_name: cloud name of which output to be converted
        :param controller_version: controller version
        :param merge_object_mapping: flag for merge objects
        :param sys_dict: baseline profile
        :return: monitor_dict
        """
        monitor_type, name = self.get_name_type(f5_monitor, key)
        skipped = [val for val in f5_monitor.keys()
                   if val not in self.supported_attributes]
        indirect = copy.deepcopy(self.indirect_mappings)
        timeout = int(f5_monitor.get("timeout", conv_const.DEFAULT_TIMEOUT))
        # Supporting value 'auto' and changing it to default value for interval
        interval = str(f5_monitor.get("interval", conv_const.DEFAULT_INTERVAL))
        interval = int(interval) if interval.isdigit() else \
                    conv_const.DEFAULT_INTERVAL
        time_until_up = int(f5_monitor.get(self.tup,
                                           conv_const.DEFAULT_TIME_UNTIL_UP))
        # Fixed Successful interval and failed checks, also averting
        # DivisionByZero error
        failed_checks = int(timeout/interval) if interval else 0
        successful_checks = conv_const.DEFAULT_FAILED_CHECKS
        if time_until_up > 0:
            successful_checks = int(time_until_up/interval) if interval else 0
            successful_checks = 1 \
                if successful_checks == 0 else successful_checks

        description = f5_monitor.get("description", None)
        monitor_dict = dict()
        tenant, name = conv_utils.get_tenant_ref(name)
        # Added prefix for objects
        if self.prefix:
            name = self.prefix + '-' + name
        if tenant_ref != 'admin':
            tenant = tenant_ref
        monitor_dict['tenant_ref'] = conv_utils.get_object_ref(tenant, 'tenant')
        monitor_dict["name"] = name
        monitor_dict["receive_timeout"] = interval-1 if interval else 0
        monitor_dict["failed_checks"] = failed_checks
        monitor_dict["send_interval"] = interval
        monitor_dict["successful_checks"] = successful_checks

        if description:
            monitor_dict["description"] = description
        # transparent : Only flag if destination or port are set, else ignore
        transparent = f5_monitor.get("transparent", 'disabled')
        transparent = False if transparent == 'disabled' else True
        destination = f5_monitor.get(self.dest_key, '*:*')
        if destination in ['*', '*:0']:
            destination = '*:*'
            f5_monitor[self.dest_key] = destination
        if not transparent or destination == '*:*':
            if 'transparent' in skipped:
                indirect.append('transparent')
        ignore_for_defaults = {}
        defaults = self.get_default_monitor(monitor_type, monitor_config)
        if defaults:
            ignore_for_defaults = copy.deepcopy(defaults)
        ignore_for_defaults.update(self.ignore)
        u_ignore = []
        na_list = []
        if monitor_type == "http":
            u_ignore = user_ignore.get("http", [])
            na_list = self.na_http
            skipped = self.convert_http(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "https":
            na_list = self.na_https
            u_ignore = user_ignore.get("https", [])
            skipped = self.convert_https(monitor_dict, f5_monitor, skipped,
                      avi_config, tenant_ref, input_dir, cloud_name,
                      controller_version, merge_object_mapping, sys_dict)
        elif monitor_type == "dns":
            na_list = self.na_dns
            u_ignore = user_ignore.get("dns", [])
            if f5_monitor.get('qname', None) and (not f5_monitor.get(
                    'qname') == 'none'):
                skipped = self.convert_dns(monitor_dict, f5_monitor, skipped)
                ignore_for_defaults.update({'qtype': 'a'})
            else:
                msg = ('No value for mandatory field query_name, skipped '
                       'DNS Monitor %s' % key)
                LOG.warning(msg)
                conv_utils.add_status_row('monitor', monitor_type, name,
                                          conv_const.STATUS_SKIPPED, msg)
                return None
        elif monitor_type in ["tcp", "tcp_half_open", "tcp-half-open"]:
            na_list = self.na_tcp
            u_ignore = user_ignore.get("tcp", [])
            skipped = self.convert_tcp(monitor_dict, f5_monitor, skipped,
                                       monitor_type)
        elif monitor_type == "udp":
            na_list = self.na_udp
            u_ignore = user_ignore.get("udp", [])
            skipped = self.convert_udp(monitor_dict, f5_monitor, skipped)
        elif monitor_type in ["icmp", "gateway-icmp", "gateway_icmp"]:
            na_list = self.na_icmp
            u_ignore = user_ignore.get("icmp", [])
            u_ignore += user_ignore.get("gateway-icmp", [])
            u_ignore += user_ignore.get("gateway_icmp", [])
            skipped = self.convert_icmp(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "external":
            na_list = self.na_external
            u_ignore = user_ignore.get("external", [])
            skipped = self.convert_external(monitor_dict, f5_monitor, skipped,
                                            input_dir, name)
        if monitor_dict.get('error', False):
            return []
        conv_status = conv_utils.get_conv_status(
            skipped, indirect, ignore_for_defaults, f5_monitor,
            u_ignore, na_list)

        conv_utils.add_conv_status('monitor', monitor_type, name, conv_status,
                                   [{'health_monitor': monitor_dict}])
        return monitor_dict


class MonitorConfigConvV11(MonitorConfigConv):
    def __init__(self, f5_monitor_attributes, prefix, object_merge_check):
        """

        :param f5_monitor_attributes: f5 monitor attributes from yaml file.
        :param prefix: prefix for objects
        :param object_merge_check: flag for merge objects
        """
        self.supported_types = f5_monitor_attributes['Monitor_Supported_Types']
        self.tup = "time-until-up"
        self.supported_attributes = \
            f5_monitor_attributes['Monitor_Supported_Attributes']
        self.indirect_mappings = \
            f5_monitor_attributes['Monitor_Indirect_Mappings']
        self.ignore = f5_monitor_attributes['Monitor_Ignore']
        self.dest_key = "destination"
        self.na_http = f5_monitor_attributes['Monitor_Na_Http']
        self.na_https = f5_monitor_attributes['Monitor_Na_Https']
        self.na_dns = f5_monitor_attributes['Monitor_Na_Dns']
        self.na_tcp = f5_monitor_attributes['Monitor_Na_Tcp']
        self.na_udp = f5_monitor_attributes['Monitor_Na_Udp']
        self.na_icmp = f5_monitor_attributes['Monitor_Na_Icmp']
        self.na_external = f5_monitor_attributes['Monitor_Na_External']
        self.http_attr = f5_monitor_attributes['Monitor_http_attr']
        self.https_attr = f5_monitor_attributes['Monitor_https_attr']
        self.dns_attr = f5_monitor_attributes['Monitor_dns_attr']
        self.tcp_attr = f5_monitor_attributes['Monitor_tcp_attr']
        self.udp_attr = f5_monitor_attributes['Monitor_udp_attr']
        self.ext_attr = f5_monitor_attributes['Monitor_ext_attr']
        # Added prefix for objects
        self.prefix = prefix
        self.object_merge_check = object_merge_check
        self.mon_count = 0

    def get_default_monitor(self, monitor_type, monitor_config):
        """

        :param monitor_type:  type of monitor
        :param monitor_config: parsed f5 monitor dict
        :return:
        """
        default_name = "%s %s" % (monitor_type, monitor_type)
        return monitor_config.get(default_name, {})

    def get_defaults(self, monitor_config, key):
        """

        :param monitor_config: parsed monitor config dict
        :param key: object name
        :return:
        """
        f5_monitor = monitor_config[key]
        monitor_type, monitor_name = key.split(" ")
        parent_name = f5_monitor.get("defaults-from", None)
        parent_name = None if parent_name == 'none' else \
                        conv_utils.get_tenant_ref(parent_name)[1] if \
                        parent_name is not None else parent_name
        if parent_name and monitor_name != parent_name:
            key = monitor_type+" "+parent_name
            parent_monitor = monitor_config.get(key, None)
            if parent_monitor:
                parent_monitor = self.get_defaults(monitor_config, key)
                copy_p_mon = copy.deepcopy(parent_monitor)
                copy_p_mon.update(f5_monitor)
                f5_monitor = copy_p_mon
        return f5_monitor

    def get_name_type(self, f5_monitor, key):
        return key.split(" ")

    def convert_http(self, monitor_dict, f5_monitor, skipped):
        """

        :param monitor_dict: dict for converted avi config
        :param f5_monitor: parsed f5 monitor dict
        :param skipped: skipped list
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.http_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        send = send.replace('\\\\', '\\')
        send = send.replace('"', '')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]}
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        # F5 version 11 have destination as port added code.
        # if * is there then ignore it else add to port.
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        # Added mapping for http_response.
        maintenance_resp, http_rsp = self.get_maintenance_response(f5_monitor)
        if maintenance_resp:
            monitor_dict["http_monitor"]["maintenance_response"] = \
                                                                maintenance_resp
        monitor_dict["http_monitor"]["http_response"] = http_rsp
        return skipped

    def convert_https(self, monitor_dict, f5_monitor, skipped, avi_config,
                      tenant_ref, input_dir, cloud_name, controller_version,
                      merge_object_mapping, sys_dict):
        """

        :param monitor_dict: converted dict of avi config
        :param f5_monitor:  parsed f5 monitor dict
        :param skipped: skipped list
        :param avi_config: dict for avi config conversion
        :param tenant_ref: tenant which used for converted output.
        :param input_dir: location of cert and key
        :param cloud_name: cloud which used for converted output
        :param controller_version: controller version of avi
        :param merge_object_mapping: flag for object merge
        :param sys_dict: baseline profile dict
        :return:
        """
        skipped = [key for key in skipped if key not in self.https_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        send = send.replace('\\\\', '\\')
        send = send.replace('"', '')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]}
        monitor_dict["https_monitor"]['ssl_attributes'] = dict()
        if parse_version(controller_version) >= parse_version('17.1'):
            # Added code to handle ssl attribute.
            # Removed ssl cert key ref from monitor's ssl attribute
            if f5_monitor.get('cipherlist', None):
                self.create_sslprofile(monitor_dict, f5_monitor, avi_config,
                               tenant_ref, cloud_name, merge_object_mapping,
                                       sys_dict)
            else:
                monitor_dict["https_monitor"]['ssl_attributes'][
                    'ssl_profile_ref'] = conv_utils.get_object_ref(
                                         'System-Standard',
                                         conv_const.OBJECT_TYPE_SSL_PROFILE,
                                                                    tenant_ref)
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        # F5 version 11 have destination as port added code.
        # if * is there then ignore it else add to port.
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        # Added mapping for http_response.
        maintenance_resp,http_rsp = self.get_maintenance_response(f5_monitor)
        if maintenance_resp:
            monitor_dict["https_monitor"]["maintenance_response"] = \
                                                                maintenance_resp
        monitor_dict["https_monitor"]["http_response"] = http_rsp
        return skipped

    def convert_dns(self, monitor_dict, f5_monitor, skipped):
        """

        :param monitor_dict: converted monitor dict
        :param f5_monitor:  parsed f5 dict
        :param skipped: skipped list for monitor
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.dns_attr]
        accept_rcode = f5_monitor.get("accept-rcode", None)
        dns_monitor = dict()
        if accept_rcode and accept_rcode == "no-error":
            rcode = "RCODE_NO_ERROR"
        else:
            rcode = "RCODE_ANYTHING"
        qtype = f5_monitor.get("answer-contains", None)
        if qtype:
            if qtype == 'query-type':
                qtype = 'DNS_QUERY_TYPE'
            elif qtype == 'any-type':
                qtype = 'DNS_ANY_TYPE'
            elif qtype == 'anything':
                qtype = 'DNS_ANY_THING'
            dns_monitor["qtype"] = qtype
        monitor_dict["type"] = "HEALTH_MONITOR_DNS"
        dns_monitor["rcode"] = rcode
        dns_monitor["query_name"] = f5_monitor.get("qname", None)
        monitor_dict["dns_monitor"] = dns_monitor
        # Added mapping for http_response.
        maintenance_resp, http_rsp = self.get_maintenance_response(f5_monitor)
        if maintenance_resp:
            monitor_dict["dns_monitor"]["maintenance_response"] = \
                                                                maintenance_resp
        monitor_dict["dns_monitor"]["http_response"] = http_rsp
        return skipped

    def convert_tcp(self, monitor_dict, f5_monitor, skipped, type):
        """

        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :param type:  type of monitor
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.tcp_attr]
        # F5 version 11 have destination as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_TCP"
        request = f5_monitor.get("send", None)
        if request:
            request = request.replace('\\\\', '\\')
            request = conv_utils.rreplace(request, '\\r\\n', '', 1)
        response = f5_monitor.get("recv", None)
        tcp_monitor = None
        if request or response:
            tcp_monitor = {"tcp_request": request, "tcp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
        # Added mapping for http_response.
        maintenance_resp, http_rsp = self.get_maintenance_response(f5_monitor)
        if tcp_monitor:
            if maintenance_resp:
                tcp_monitor["maintenance_response"] = maintenance_resp
            tcp_monitor["http_response"] = http_rsp
        else:
            tcp_monitor = {"http_response": http_rsp}
            if maintenance_resp:
                tcp_monitor["maintenance_response"] = maintenance_resp
            monitor_dict["tcp_monitor"] = tcp_monitor
        if type == 'tcp-half-open':
            if tcp_monitor:
                tcp_monitor["tcp_half_open"] = True
            else:
                tcp_monitor = {"tcp_half_open": True}
                monitor_dict["tcp_monitor"] = tcp_monitor

        return skipped

    def convert_udp(self, monitor_dict, f5_monitor, skipped):
        """

           :param monitor_dict: converted monitor dict
           :param f5_monitor: parsed f5 config monitor dict
           :param skipped: skipped list for monitor
           :param type:  type of monitor
           :return: skipped
        """
        skipped = [key for key in skipped if key not in self.udp_attr]
        # F5 version 11 have destination as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_UDP"
        request = f5_monitor.get("send", None)
        request = request.replace('\\\\', '\\')
        request = conv_utils.rreplace(request, '\\r\\n', '', 1)
        response = f5_monitor.get("recv", None)
        udp_monitor = None
        if request or response:
            udp_monitor = {"udp_request": request, "udp_response": response}
            monitor_dict["udp_monitor"] = udp_monitor
        # Added mapping for http_response.
        maintenance_resp, http_rsp = self.get_maintenance_response(f5_monitor)
        if udp_monitor:
            if maintenance_resp:
                udp_monitor["maintenance_response"] = maintenance_resp
            udp_monitor["http_response"] = http_rsp
        else:
            udp_monitor = {"http_response": http_rsp}
            if maintenance_resp:
                udp_monitor["maintenance_response"] = maintenance_resp
            monitor_dict["udp_monitor"] = udp_monitor
        return skipped

    def convert_icmp(self, monitor_dict, f5_monitor, skipped):
        """
        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :return: skipped
        """
        monitor_dict["type"] = "HEALTH_MONITOR_PING"
        return skipped

    def convert_external(self, monitor_dict, f5_monitor, skipped,
                         input_dir, name):
        """
        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :param input_dir: location of cert and key
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.ext_attr]
        monitor_dict["type"] = "HEALTH_MONITOR_EXTERNAL"
        cmd_code = f5_monitor.get("run", 'none')
        user_defined_vars = ""
        for m_key in f5_monitor.keys():
            if 'user-defined_' in m_key:
                var_value = f5_monitor[m_key]
                var_key = m_key.replace('user-defined_', '')
                skipped.remove(m_key)
                user_defined_vars += '%s=%s,' % (var_key, var_value)
        user_defined_vars = user_defined_vars[:-1]
        cmd_code = None if cmd_code == 'none' else cmd_code
        if cmd_code:
            cmd_code = conv_utils.upload_file(
                input_dir + os.path.sep + cmd_code)
        else:
            LOG.warn("Skipped monitor: %s for no value in run attribute" % name)
            conv_utils.add_status_row("monitor", "external", name,
                                      conv_const.STATUS_MISSING_FILE)
            monitor_dict['error'] = True
            return None
        if cmd_code:
            ext_monitor = {
                "command_code": cmd_code,
                "command_parameters": f5_monitor.get("args", None),
                "command_variables": user_defined_vars
            }
            monitor_dict["external_monitor"] = ext_monitor
        else:
            LOG.warn("MISSING File: %s" % name)
            conv_utils.add_status_row("monitor", "external", name,
                                      conv_const.STATUS_MISSING_FILE)
            monitor_dict['error'] = True
            return None
        return skipped

    def get_maintenance_response(self, f5_monitor):
        """
        Returns avi maintenance response value from F5 monitor object
        :param f5_monitor: F5 monitor object
        :return: Avi monitor maintenance response value
        """
        # Addded mapping for http_response.
        maintenance_response = ''
        http_response = ''
        if "reverse" in f5_monitor and f5_monitor["reverse"] != 'disabled':
            maintenance_response = f5_monitor.get("recv", '')
            http_response = f5_monitor.get('recv disable', f5_monitor.get(
                                'recv-disable', ''))
        else:
            http_response = f5_monitor.get("recv", '')
            maintenance_response = f5_monitor.get('recv disable',
                                            f5_monitor.get('recv-disable', ''))
        if maintenance_response:
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
        if http_response:
            http_response = \
                http_response.replace('\"', '').strip()
        if maintenance_response == 'none':
            maintenance_response = None
        if http_response == 'none':
            http_response = ''
        return maintenance_response, http_response


class MonitorConfigConvV10(MonitorConfigConv):

    def __init__(self, f5_monitor_attributes, prefix, object_merge_check):
        """

       :param f5_monitor_attributes: f5 monitor attributes from yaml file.
       :param prefix: prefix for objects
       :param object_merge_check: flag for merge objects
        """
        self.supported_types = f5_monitor_attributes['Monitor_Supported_Types']
        self.tup = "time until up"
        self.supported_attributes =\
            f5_monitor_attributes['Monitor_Supported_Attributes']
        self.indirect_mappings = \
            f5_monitor_attributes['Monitor_Indirect_Mappings']
        self.ignore = f5_monitor_attributes['Monitor_Ignore']
        self.dest_key = "dest"
        self.na_http = f5_monitor_attributes['Monitor_Na_Http']
        self.na_https = f5_monitor_attributes['Monitor_Na_Https']
        self.na_dns =  f5_monitor_attributes['Monitor_Na_Dns']
        self.na_tcp = f5_monitor_attributes['Monitor_Na_Tcp']
        self.na_udp = f5_monitor_attributes['Monitor_Na_Udp']
        self.na_icmp = f5_monitor_attributes['Monitor_Na_Icmp']
        self.na_external = f5_monitor_attributes['Monitor_Na_External']
        self.http_attr = f5_monitor_attributes['Monitor_http_attr']
        self.https_attr = f5_monitor_attributes['Monitor_https_attr']
        self.tcp_attr = f5_monitor_attributes['Monitor_tcp_attr']
        self. udp_attr = f5_monitor_attributes['Monitor_udp_attr']
        self.ext_attr = f5_monitor_attributes['Monitor_ext_attr']
        # Added prefix for objects
        self.prefix = prefix
        self.object_merge_check = object_merge_check
        self.mon_count = 0

    def get_name_type(self, f5_monitor, key):
        return f5_monitor.get("type"), key

    def get_default_monitor(self, monitor_type, monitor_config):
        return monitor_config.get(monitor_type, {})

    def get_defaults(self, monitor_config, key):
        """

        :param monitor_config: parsed monitor config dict
        :param key: object name
        :return:
        """
        f5_monitor = monitor_config[key]
        parent_name = f5_monitor.get("defaults from", None)
        parent_name = None if parent_name == 'none' else \
                        conv_utils.get_tenant_ref(parent_name)[1] if \
                        parent_name is not None else parent_name
        if parent_name and key != parent_name:
            parent_monitor = monitor_config.get(parent_name, None)
            if parent_monitor:
                parent_monitor = self.get_defaults(monitor_config, parent_name)
                parent_monitor = copy.deepcopy(parent_monitor)
                parent_monitor.update(f5_monitor)
                f5_monitor = parent_monitor
        else:
            f5_monitor["type"] = key
        return f5_monitor

    def convert_http(self, monitor_dict, f5_monitor, skipped):
        """

        :param monitor_dict: converted dict of avi config
        :param f5_monitor:  parsed f5 monitor dict
        :param skipped: skipped list
        :param avi_config: dict for avi config conversion
        :param tenant_ref: tenant which used for converted output.
        :param input_dir: location of cert and key
        :param cloud_name: cloud which used for converted output
        :param controller_version: controller version of avi
        :param merge_object_mapping: flag for object merge
        :param sys_dict: baseline profile dict
        :return:
        """
        ignore_list = ['adaptive']
        http_attr = self.http_attr + ignore_list
        skipped = [key for key in skipped if key not in http_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        send = send.replace('\\\\', '\\')
        send = send.replace('"', '')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]
        }
        # F5 version 10 have dest as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . is appear with port ex: *.80
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        # Added mapping for http_response.
        maintenance_resp, http_resp = self.get_maintenance_response(f5_monitor)
        if maintenance_resp:
            monitor_dict["http_monitor"]["maintenance_response"] = \
                                                                maintenance_resp
        monitor_dict["http_monitor"]["http_response"] = http_resp
        return skipped

    def convert_https(self, monitor_dict, f5_monitor, skipped,
                      avi_config, tenant, input_dir, cloud_name,
                      controller_version, merge_object_mapping, sys_dict):
        """

        :param monitor_dict: converted dict of avi config
        :param f5_monitor:  parsed f5 monitor dict
        :param skipped: skipped list
        :param avi_config: dict for avi config conversion
        :param tenant_ref: tenant which used for converted output.
        :param input_dir: location of cert and key
        :param cloud_name: cloud which used for converted output
        :param controller_version: controller version of avi
        :param merge_object_mapping: flag for object merge
        :param sys_dict: baseline profile dict
        :return:
        """
        ignore_list = ['compatibility']
        https_attr = ignore_list + self.https_attr
        skipped = [key for key in skipped if key not in https_attr]
        send = f5_monitor.get('send', None)
        send = send.replace('\\\\', '\\')
        send = send.replace('"', '')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]
        }
        # Added code to handel ssl attribute and certificate.
        monitor_dict["https_monitor"]['ssl_attributes'] = dict()
        if parse_version(controller_version) >= parse_version('17.1'):
            # Added code to handle ssl attribute
            # Removed ssl cert and key ref to monitor' ssl attribute
            if f5_monitor.get('cipherlist', None):
                self.create_sslprofile(monitor_dict, f5_monitor, avi_config,
                            tenant, cloud_name, merge_object_mapping, sys_dict)
            else:
                monitor_dict["https_monitor"]['ssl_attributes'][
                    'ssl_profile_ref'] = conv_utils.get_object_ref(
                                            'System-Standard',
                                            conv_const.OBJECT_TYPE_SSL_PROFILE,
                                            tenant)
        # F5 version 10 have dest as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        # Added mapping for http_response.
        maintenance_resp, http_resp = self.get_maintenance_response(f5_monitor)
        if maintenance_resp:
            monitor_dict["https_monitor"]["maintenance_response"] = \
                                                                maintenance_resp
        monitor_dict["https_monitor"]["http_response"] = http_resp
        return skipped

    def convert_tcp(self, monitor_dict, f5_monitor, skipped, type):
        """

        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :param type:  type of monitor
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.tcp_attr]
        # F5 version 10 have dest as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_TCP"
        request = f5_monitor.get("send", None)
        if request:
            request = request.replace('\\\\', '\\')
            request = conv_utils.rreplace(request, '\\r\\n', '', 1)
        response = f5_monitor.get("recv", None)
        tcp_monitor = None
        if request or response:
            request = request.replace('\"', '') if request else None
            response = response.replace('\"', '') if response else None
            tcp_monitor = {"tcp_request": request, "tcp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
        # Added mapping for http_response.
        maintenance_resp, http_rsp = self.get_maintenance_response(f5_monitor)
        if tcp_monitor:
            if maintenance_resp:
                tcp_monitor["maintenance_response"] = maintenance_resp
            tcp_monitor["http_response"] = http_rsp
        else:
            tcp_monitor = {"http_response": http_rsp}
            if maintenance_resp:
                tcp_monitor["maintenance_response"] = maintenance_resp
            monitor_dict["tcp_monitor"] = tcp_monitor
        if type == 'tcp_half_open':
            if tcp_monitor:
                tcp_monitor["tcp_half_open"] = True
            else:
                tcp_monitor = {"tcp_half_open": True}
                monitor_dict["tcp_monitor"] = tcp_monitor
        return skipped

    def convert_udp(self, monitor_dict, f5_monitor, skipped):
        """

        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :param type:  type of monitor
        :return: skipped
        """
        skipped = [key for key in skipped if key not in self.udp_attr]
        # F5 version 10 have dest as port added code.
        # if * is there then ignore it else add to port.
        destination = f5_monitor.get(self.dest_key, "*:*")
        dest_str = destination.split(":")
        # some config . appear with port. ex '*.80'
        if '.' in destination:
            dest_str = destination.split('.')
        if dest_str[0] != '*':
            skipped.append(self.dest_key)
        if dest_str[1].isdigit():
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_UDP"
        request = f5_monitor.get("send", None)
        request = request.replace('\\\\', '\\')
        request = conv_utils.rreplace(request, '\\r\\n', '', 1)
        response = f5_monitor.get("recv", None)
        udp_monitor = None
        if request or response:
            request = request.replace('\"', '') if request else None
            response = response.replace('\"', '') if response else None
            udp_monitor = {"udp_request": request, "udp_response": response}
            monitor_dict["udp_monitor"] = udp_monitor
        # Added mapping for http_response.
        maintenance_resp, http_resp = self.get_maintenance_response(f5_monitor)
        if udp_monitor:
            if maintenance_resp:
                udp_monitor["maintenance_response"] = maintenance_resp
            udp_monitor["http_response"] = http_resp
        else:
            udp_monitor = {"http_response": http_resp}
            if maintenance_resp:
                udp_monitor["maintenance_response"] = maintenance_resp
            monitor_dict["udp_monitor"] = udp_monitor
        return skipped

    def convert_icmp(self, monitor_dict, f5_monitor, skipped):
        """

        :param monitor_dict: converted monitor dict
        :param f5_monitor: parsed f5 config monitor dict
        :param skipped: skipped list for monitor
        :param type:  type of monitor
        :return: skipped
        """
        monitor_dict["type"] = "HEALTH_MONITOR_PING"
        return skipped

    def convert_external(self, monitor_dict, f5_monitor, skipped,
                         input_dir, name):
        """
           :param monitor_dict: converted monitor dict
           :param f5_monitor: parsed f5 config monitor dict
           :param skipped: skipped list for monitor
           :param input_dir: location of cert and key
           :return: skipped
        """
        script_vars = ""
        for key in f5_monitor.keys():
            if key not in ('args', 'run') and '\"' in f5_monitor[key]:
                self.ext_attr.append(key)
                param_value = f5_monitor[key].replace('\"', '')
                script_vars += "%s=%s," % (key, param_value)
        if script_vars:
            script_vars = script_vars[:-1]
        skipped = [key for key in skipped if key not in self.ext_attr]
        cmd_code = f5_monitor.get("run", None)
        cmd_params = f5_monitor.get("args", None)
        cmd_code = cmd_code.replace('\"', '') if cmd_code else None
        cmd_params = cmd_params.replace('\"', '') if cmd_params else None
        if cmd_code:
            cmd_code = conv_utils.upload_file(
                input_dir + os.path.sep + cmd_code)
        else:
            LOG.warn("Skipped monitor: %s for no value in run attribute" % name)
            conv_utils.add_status_row("monitor", "external", name,
                                      conv_const.STATUS_MISSING_FILE)
            monitor_dict['error'] = True
            return None
        monitor_dict["type"] = "HEALTH_MONITOR_EXTERNAL"
        if cmd_code:
            ext_monitor = {
                "command_code": cmd_code,
                "command_parameters": cmd_params,
                "command_variables": script_vars
            }
            monitor_dict["external_monitor"] = ext_monitor
        else:
            LOG.warn("MISSING File: %s" % name)
            conv_utils.add_status_row("monitor", "external", name,
                                      conv_const.STATUS_MISSING_FILE)
            monitor_dict['error'] = True
            return None

        return skipped

    def get_maintenance_response(self, f5_monitor):
        """
        Returns avi maintenance response value from F5 monitor object
        :param f5_monitor: F5 monitor object
        :return: Avi monitor maintenance response value
        """
        # Addded mapping for http_response.
        maintenance_response = ''
        http_response = ''
        if "reverse" in f5_monitor:
            maintenance_response = f5_monitor.get("recv", '')
            http_response = f5_monitor.get('recv disable', '')
        else:
            http_response = f5_monitor.get("recv", '')
            maintenance_response = f5_monitor.get('recv disable', '')
        if maintenance_response:
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
        if http_response:
            http_response = \
                http_response.replace('\"', '').strip()
        if maintenance_response == 'none':
            maintenance_response = None
        if http_response == 'none':
            http_response = ''
        return maintenance_response, http_response


