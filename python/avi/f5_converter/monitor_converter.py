import copy
import logging
import numbers
import os

import avi.f5_converter.conversion_util as conv_utils
import avi.f5_converter.converter_constants as conv_const

LOG = logging.getLogger(__name__)


class MonitorConfigConv(object):
    @classmethod
    def get_instance(cls, version):
        if version == '10':
            return MonitorConfigConvV10()
        if version in ['11', '12']:
            return MonitorConfigConvV11()

    supported_attributes = None
    supported_types = None
    indirect_mappings = None
    ignore = None
    dest_key = None
    tup = None
    na_http = None
    na_https = None
    na_dns = None
    na_tcp = None
    na_udp = None
    na_icmp = None
    na_external = None

    def get_defaults(self, monitor_config, key):
        pass

    def get_name_type(self, f5_monitor, key):
        pass

    def get_default_monitor(self, monitor_type, monitor_config):
        pass

    def convert_http(self, monitor_dict, f5_monitor, skipped):
        pass

    def convert_https(self, monitor_dict, f5_monitor, skipped):
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

    def convert(self, f5_config, avi_config, input_dir, user_ignore, tenant):
        LOG.debug("Converting health monitors")
        avi_config["HealthMonitor"] = []
        m_user_ignore = user_ignore.get('monitor', {})
        monitor_config = f5_config.pop("monitor", {})
        for key in monitor_config.keys():
            f5_monitor = monitor_config[key]
            if not f5_monitor:
                if " " in key:
                    m_type, name = key.split(" ")
                else:
                    m_type = None
                    name = key
                conv_utils.add_status_row('monitor', m_type, name, 'skipped')
                LOG.warn("Empty config for monitor: %s " % name)
                continue
            f5_monitor = self.get_defaults(monitor_config, key)
            monitor_type, name = self.get_name_type(f5_monitor, key)
            try:
                LOG.debug("Converting monitor: %s" % name)
                if monitor_type not in self.supported_types:
                    LOG.warn("Monitor type not supported by Avi : "+name)
                    conv_utils.add_status_row('monitor', monitor_type, name,
                                              'skipped')
                    continue
                avi_monitor = self.convert_monitor(
                    f5_monitor, key, monitor_config, input_dir, m_user_ignore, tenant)
                if not avi_monitor:
                    continue
                avi_config["HealthMonitor"].append(avi_monitor)
                LOG.debug("Conversion successful for monitor: %s" % name)
            except:
                LOG.error("Failed to convert monitor: %s" % key, exc_info=True)
                if name:
                    conv_utils.add_status_row('monitor', monitor_type, name,
                                              'error')
                else:
                    conv_utils.add_status_row('monitor', key, key, 'error')
        LOG.debug("Converted %s health monitors" %
                  len(avi_config["HealthMonitor"]))

    def convert_monitor(self, f5_monitor, key, monitor_config, input_dir,
                        user_ignore, tenant_ref):
        monitor_type, name = self.get_name_type(f5_monitor, key)
        skipped = [val for val in f5_monitor.keys()
                   if val not in self.supported_attributes]
        indirect = copy.deepcopy(self.indirect_mappings)
        timeout = int(f5_monitor.get("timeout", conv_const.DEFAULT_TIMEOUT))
        interval = int(f5_monitor.get("interval", conv_const.DEFAULT_INTERVAL))
        time_until_up = int(f5_monitor.get(self.tup,
                                           conv_const.DEFAULT_TIME_UNTIL_UP))
        successful_checks = int(timeout/interval)
        failed_checks = conv_const.DEFAULT_FAILED_CHECKS
        if time_until_up > 0:
            failed_checks = int(time_until_up/interval)
            failed_checks = 1 if failed_checks == 0 else failed_checks

        description = f5_monitor.get("description", None)
        monitor_dict = dict()
        tenant, name = conv_utils.get_tenant_ref(name)

        monitor_dict['tenant_ref'] = tenant_ref
        monitor_dict["name"] = name
        monitor_dict["receive_timeout"] = interval-1
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
            skipped = self.convert_https(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "dns":
            na_list = self.na_dns
            u_ignore = user_ignore.get("dns", [])
            skipped = self.convert_dns(monitor_dict, f5_monitor, skipped)
            ignore_for_defaults.update({'qtype': 'a'})
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
                                   monitor_dict)
        return monitor_dict


class MonitorConfigConvV11(MonitorConfigConv):
    supported_types = ["http", "https", "dns", "external", "tcp", "udp",
                       "gateway-icmp", "icmp", "tcp-half-open"]
    supported_attributes = ["timeout", "interval", "time-until-up",
                            "description", "defaults-from"]
    indirect_mappings = ["up-interval", "debug", "ip-dscp"]
    ignore = {"destination": "*:*", "manual-resume": 'disabled'}
    tup = "time-until-up"
    dest_key = "destination"
    na_http = ['adaptive']
    na_https = ['adaptive', 'compatibility']
    na_dns = ['adaptive']
    na_tcp = ['adaptive']
    na_udp = ['adaptive']
    na_icmp = ['adaptive']
    na_external = ['adaptive']

    def get_default_monitor(self, monitor_type, monitor_config):
        default_name = "%s %s" % (monitor_type, monitor_type)
        return monitor_config.get(default_name, {})

    def get_defaults(self, monitor_config, key):
        f5_monitor = monitor_config[key]
        monitor_type, monitor_name = key.split(" ")
        parent_name = f5_monitor.get("defaults-from", None)
        parent_name = None if parent_name == 'none' else parent_name
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
        http_attr = ["recv", "recv-disable", "reverse", "send"]
        skipped = [key for key in skipped if key not in http_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        send = send.replace('\\\\', '\\')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": send,
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}

        maintenance_resp = self.get_maintenance_response(f5_monitor)
        monitor_dict["http_monitor"]["maintenance_response"] = maintenance_resp

        return skipped

    def convert_https(self, monitor_dict, f5_monitor, skipped):
        https_attr = ["recv", "recv-disable", "reverse", "send"]
        skipped = [key for key in skipped if key not in https_attr]
        send = f5_monitor.get('send', None)
        send = send.replace('\\\\', '\\')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": send,
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        monitor_dict["https_monitor"]["maintenance_response"] = maintenance_resp
        return skipped

    def convert_dns(self, monitor_dict, f5_monitor, skipped):
        dns_attr = ["recv", "recv-disable", "reverse", "accept-rcode", "qname",
                    "answer-contains"]
        skipped = [key for key in skipped if key not in dns_attr]
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
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        monitor_dict["dns_monitor"]["maintenance_response"] = maintenance_resp
        return skipped

    def convert_tcp(self, monitor_dict, f5_monitor, skipped, type):
        tcp_attr = ["recv-disable", "reverse", "destination", "send", "recv"]
        skipped = [key for key in skipped if key not in tcp_attr]
        destination = f5_monitor.get("destination", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
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

        maintenance_resp = self.get_maintenance_response(f5_monitor)
        if tcp_monitor:
            tcp_monitor["maintenance_response"] = maintenance_resp
        else:
            tcp_monitor = {"maintenance_response": maintenance_resp}
            monitor_dict["tcp_monitor"] = tcp_monitor
        if type == 'tcp-half-open':
            if tcp_monitor:
                tcp_monitor["tcp_half_open"] = True
            else:
                tcp_monitor = {"tcp_half_open": True}
                monitor_dict["tcp_monitor"] = tcp_monitor

        return skipped

    def convert_udp(self, monitor_dict, f5_monitor, skipped):
        udp_attr = ["recv", "recv-disable", "reverse", "destination", "send"]
        skipped = [key for key in skipped if key not in udp_attr]
        destination = f5_monitor.get("destination", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
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
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        if udp_monitor:
            udp_monitor["maintenance_response"] = maintenance_resp
        else:
            udp_monitor = {"maintenance_response": maintenance_resp}
            monitor_dict["udp_monitor"] = udp_monitor
        return skipped

    def convert_icmp(self, monitor_dict, f5_monitor, skipped):
        monitor_dict["type"] = "HEALTH_MONITOR_PING"
        return skipped

    def convert_external(self, monitor_dict, f5_monitor, skipped,
                         input_dir, name):
        ext_attr = ["run", "args", "user-defined"]
        skipped = [key for key in skipped if key not in ext_attr]
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
            conv_utils.add_status_row("monitor", "external", name, "skipped")
            monitor_dict['error'] = True
            return None
        ext_monitor = {
            "command_code": cmd_code,
            "command_parameters": f5_monitor.get("args", None),
            "command_variables": user_defined_vars
        }
        monitor_dict["external_monitor"] = ext_monitor
        return skipped

    def get_maintenance_response(self, f5_monitor):
        """
        Returns avi maintenance response value from F5 monitor object
        :param f5_monitor: F5 monitor object
        :return: Avi monitor maintenance response value
        """
        maintenance_response = ''
        if "reverse" in f5_monitor:
            maintenance_response = f5_monitor.get("recv", '')
        elif "recv-disable" in f5_monitor:
            maintenance_response = f5_monitor["recv-disable"]
        if maintenance_response:
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
        if maintenance_response == 'none':
            maintenance_response = ''
        return maintenance_response


class MonitorConfigConvV10(MonitorConfigConv):
    tup = "time until up"
    supported_types = ["http", "https", "dns", "external", "tcp", "udp",
                       "gateway_icmp", "icmp", "tcp_half_open"]
    supported_attributes = ["timeout", "interval", "time until up",
                            "description", "type", "defaults from"]
    indirect_mappings = ['up interval', 'debug', 'ip dscp', 'timeoutpackets',
                         'sendpackets']
    ignore = {"dest": "*:*", "manual-resume": 'disabled'}
    dest_key = "dest"
    na_http = ['adaptive']
    na_https = ['adaptive', 'compatibility']
    na_dns = ['adaptive']
    na_tcp = ['adaptive']
    na_udp = ['adaptive']
    na_icmp = ['adaptive']
    na_external = ['adaptive']

    def get_name_type(self, f5_monitor, key):
        return f5_monitor.get("type"), key

    def get_default_monitor(self, monitor_type, monitor_config):
        return monitor_config.get(monitor_type, {})

    def get_defaults(self, monitor_config, key):
        f5_monitor = monitor_config[key]
        parent_name = f5_monitor.get("defaults from", None)
        parent_name = None if parent_name == 'none' else parent_name
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
        http_attr = ["recv", "recv disable", "reverse", "send"]
        ignore_list = ['adaptive']
        http_attr = http_attr + ignore_list
        skipped = [key for key in skipped if key not in http_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        send = send.replace('\\\\', '\\')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]
        }

        maintenance_resp = self.get_maintenance_response(f5_monitor)
        monitor_dict["http_monitor"]["maintenance_response"] = maintenance_resp
        return skipped

    def convert_https(self, monitor_dict, f5_monitor, skipped):
        https_attr = ["recv", "recv disable", "reverse", "send"]
        ignore_list = ['compatibility']
        https_attr = ignore_list + https_attr
        skipped = [key for key in skipped if key not in https_attr]
        send = f5_monitor.get('send', None)
        send = send.replace('\\\\', '\\')
        send = conv_utils.rreplace(send, '\\r\\n', '', 1)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": send,
            "http_response_code": ["HTTP_2XX", "HTTP_3XX"]
        }
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        monitor_dict["https_monitor"]["maintenance_response"] = maintenance_resp
        return skipped

    def convert_tcp(self, monitor_dict, f5_monitor, skipped, type):
        tcp_attr = ["dest", "send", "recv", "recv disable", "reverse"]
        skipped = [key for key in skipped if key not in tcp_attr]
        destination = f5_monitor.get("dest", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
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
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        if tcp_monitor:
            tcp_monitor["maintenance_response"] = maintenance_resp
        else:
            tcp_monitor = {"maintenance_response": maintenance_resp}
            monitor_dict["tcp_monitor"] = tcp_monitor
        if type == 'tcp_half_open':
            if tcp_monitor:
                tcp_monitor["tcp_half_open"] = True
            else:
                tcp_monitor = {"tcp_half_open": True}
                monitor_dict["tcp_monitor"] = tcp_monitor
        return skipped

    def convert_udp(self, monitor_dict, f5_monitor, skipped):
        udp_attr = ["dest", "send", "recv", "recv disable", "reverse"]
        skipped = [key for key in skipped if key not in udp_attr]
        destination = f5_monitor.get("dest", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
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
        maintenance_resp = self.get_maintenance_response(f5_monitor)
        if udp_monitor:
            udp_monitor["maintenance_response"] = maintenance_resp
        else:
            udp_monitor = {"maintenance_response": maintenance_resp}
            monitor_dict["udp_monitor"] = udp_monitor
        return skipped

    def convert_icmp(self, monitor_dict, f5_monitor, skipped):
        monitor_dict["type"] = "HEALTH_MONITOR_PING"
        return skipped

    def convert_external(self, monitor_dict, f5_monitor, skipped,
                         input_dir, name):
        script_vars = ""
        ext_attr = ["run", "args", "user-defined"]
        for key in f5_monitor.keys():
            if key not in ('args', 'run') and '\"' in f5_monitor[key]:
                ext_attr.append(key)
                param_value = f5_monitor[key].replace('\"', '')
                script_vars += "%s=%s," % (key, param_value)
        if script_vars:
            script_vars = script_vars[:-1]
        skipped = [key for key in skipped if key not in ext_attr]
        cmd_code = f5_monitor.get("run", None)
        cmd_params = f5_monitor.get("args", None)
        cmd_code = cmd_code.replace('\"', '') if cmd_code else None
        cmd_params = cmd_params.replace('\"', '') if cmd_params else None
        if cmd_code:
            cmd_code = conv_utils.upload_file(
                input_dir + os.path.sep + cmd_code)
        else:
            LOG.warn("Skipped monitor: %s for no value in run attribute" % name)
            conv_utils.add_status_row("monitor", "external", name, "skipped")
            monitor_dict['error'] = True
            return None
        monitor_dict["type"] = "HEALTH_MONITOR_EXTERNAL"
        ext_monitor = {
            "command_code": cmd_code,
            "command_parameters": cmd_params,
            "command_variables": script_vars
        }
        monitor_dict["external_monitor"] = ext_monitor
        return skipped

    def get_maintenance_response(self, f5_monitor):
        """
        Returns avi maintenance response value from F5 monitor object
        :param f5_monitor: F5 monitor object
        :return: Avi monitor maintenance response value
        """
        maintenance_response = ''
        if "reverse" in f5_monitor:
            maintenance_response = f5_monitor.get("recv", '')
        elif "recv disable" in f5_monitor:
            maintenance_response = f5_monitor["recv disable"]
        if maintenance_response:
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
        if maintenance_response == 'none':
            maintenance_response = ''
        return maintenance_response


