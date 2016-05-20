import logging
import conversion_util as conv_utils
import copy
import converter_constants as final
import numbers
import os
LOG = logging.getLogger("converter-log")


class MonitorConfigConv(object):
    @classmethod
    def factory(cls, version):
        if version == 10:
            return MonitorConfigConvV10()
        if version == 11:
            return MonitorConfigConvV11()

    def convert(self, f5_config, avi_config, input_dir):
        monitor_list = []
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
                avi_monitor, skipped, indirect_list = \
                    self.convert_monitor(key, monitor_config, input_dir)
                if not avi_monitor:
                    continue
                if skipped:
                    conv_utils.add_status_row(
                        'monitor', monitor_type, name, 'partial', skipped,
                        avi_monitor, indirect_list)
                else:
                    conv_utils.add_status_row(
                        'monitor', monitor_type, name, 'successful', None,
                        avi_monitor, indirect_list)
                monitor_list.append(avi_monitor)
            except:
                LOG.error("Failed to convert monitor: %s" % key, exc_info=True)
                if name:
                    conv_utils.add_status_row('monitor', monitor_type, name,
                                              'error')
                else:
                    conv_utils.add_status_row('monitor', key, key, 'error')
            LOG.debug("Conversion successful for monitor: %s" % name)
            avi_config["HealthMonitor"] = monitor_list
        return monitor_list


    def convert_monitor(self, key, monitor_config, input_dir):
        """
        Conversion of single F5 monitor object to Avi health monitor object
        :param monitor_type: Health monitor type
        :param name: name of health monitor
        :param f5_monitor: F5 monitor config object
        :param file_location: External monitor script file location
        :return: Avi monitor config object
        """
        f5_monitor = monitor_config[key]
        monitor_type, name = self.get_name_type(f5_monitor, key)
        skipped = [key for key in f5_monitor.keys()
                   if key not in self.supported_attributes]
        indirect_mappings = self.indirect_mappings
        timeout = int(f5_monitor.get("timeout", final.DEFAULT_TIMEOUT))
        interval = int(f5_monitor.get("interval", final.DEFAULT_INTERVAL))
        time_until_up = int(f5_monitor.get(self.tup,
                                           final.DEFAULT_TIME_UNTIL_UP))
        successful_checks = int(timeout/interval)
        failed_checks = final.DEFAULT_FAILED_CHECKS
        if time_until_up > 0:
            failed_checks = int(time_until_up/interval)
            failed_checks = 1 if failed_checks == 0 else failed_checks

        description = f5_monitor.get("description", None)
        monitor_dict = dict()
        monitor_dict["name"] = name
        monitor_dict["receive_timeout"] = interval-1
        monitor_dict["failed_checks"] = failed_checks
        monitor_dict["send_interval"] = interval
        monitor_dict["successful_checks"] = successful_checks

        if description:
            monitor_dict["description"] = description
        # transparent : Only flag if 'destination' or 'port' are set, else ignore
        transparent = f5_monitor.get("transparent", 'disabled')
        transparent = False if transparent == 'disabled' else True
        destination = f5_monitor.get("destination", '*.*')
        if (not transparent or destination == '*.*') and 'transparent' in skipped:
            skipped.remove('transparent')

        ignore_for_defaults = self.get_default_monitor(type, monitor_config)
        if monitor_type == "http":
            skipped = self.convert_http(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "https":
            skipped = self.convert_https(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "dns":
            skipped = self.convert_dns(monitor_dict, f5_monitor, skipped)
            ignore_for_defaults['qtype'] = 'a'
        elif monitor_type == "tcp":
            skipped = self.convert_tcp(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "udp":
            skipped = self.convert_udp(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "icmp":
            skipped = self.convert_icmp(monitor_dict, f5_monitor, skipped)
        elif monitor_type == "external":
            skipped = self.convert_external(monitor_dict, f5_monitor, skipped,
                                            input_dir, name)
        if monitor_dict.get('error', False):
            return None, None, None
        skipped, indirect_mappings = conv_utils.update_skipped_attributes(
            skipped, indirect_mappings, ignore_for_defaults, monitor_dict)
        return monitor_dict, skipped, indirect_mappings


class MonitorConfigConvV11(MonitorConfigConv):
    supported_types = ["http", "https", "dns", "external", "tcp", "udp",
                       "gateway-icmp", "icmp"]
    supported_attributes = ["timeout", "interval", "time-until-up",
                            "description", "defaults-from"]
    indirect_mappings = ["up-interval", "debug", "ip-dscp"]
    ignore_for_defaults = {"destination": "*:*", "manual-resume": 'disabled'}
    tup = "time-until-up"

    def get_default_monitor(self, monitor_type, monitor_config):
        return monitor_config.get("%s %s" % (monitor_type, monitor_type), {})

    def get_defaults(self, monitor_config, key):
        """
        Monitor can have inheritance used by attribute defaults-from in F5
        configuration this method recursively gets all the attributes from the
        default objects and forms complete object
        :param monitor_type: Monitor type
        :param f5_monitor: F5 monitor object
        :param monitor_config: List of F5 monitor configs
        :return:
        """
        f5_monitor = monitor_config[key]
        monitor_type = key.split(" ")[0]
        parent_name = f5_monitor.get("defaults-from", None)
        if parent_name:
            key = monitor_type+" "+parent_name
            parent_monitor = monitor_config.get(key, None)
            if parent_monitor:
                parent_monitor = self.get_defaults(monitor_config, key)
                parent_monitor.update(f5_monitor)
                f5_monitor = parent_monitor
        return f5_monitor

    def get_name_type(self, f5_monitor, key):
        return key.split(" ")

    def convert_http(self, monitor_dict, f5_monitor, skipped):
        http_attr = ["recv", "recv-disable", "reverse", "send"]
        ignore_list = ['adaptive']
        http_attr = http_attr + ignore_list
        skipped = [key for key in skipped if key not in http_attr]
        send = f5_monitor.get('send', 'HEAD / HTTP/1.0')
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": send,
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
        maintenance_response = None
        if "reverse" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv", None)
        elif "recv-disable" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv-disable", None)
        if maintenance_response and maintenance_response.replace('\"', ''):
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
            monitor_dict["http_monitor"]["maintenance_response"] = \
                maintenance_response
        return skipped

    def convert_https(self, monitor_dict, f5_monitor, skipped):
        https_attr = ["recv", "recv-disable", "reverse", "send"]
        ignore_list = ['compatibility']
        https_attr = ignore_list + https_attr
        skipped = [key for key in skipped if key not in https_attr]
        send = f5_monitor.get('send', None)
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": send,
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
        maintenance_response = None
        if "reverse" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv", None)
        elif "recv-disable" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv-disable", None)
        if maintenance_response and maintenance_response.replace('\"', ''):
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
            monitor_dict["https_monitor"]["maintenance_response"] = \
                maintenance_response
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
        maintenance_response = None
        if "reverse" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv", None)
        elif "recv-disable" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv-disable", None)
        if maintenance_response and maintenance_response.replace('\"', ''):
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
            monitor_dict["dns_monitor"]["maintenance_response"] = \
                maintenance_response
        return skipped

    def convert_tcp(self, monitor_dict, f5_monitor, skipped):
        tcp_attr = ["recv-disable", "reverse", "destination", "send", "recv"]
        skipped = [key for key in skipped if key not in tcp_attr]
        destination = f5_monitor.get("destination", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_TCP"
        request = f5_monitor.get("send", None)
        response = f5_monitor.get("recv", None)
        tcp_monitor = None
        if request or response:
            tcp_monitor = {"tcp_request": request, "tcp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
        maintenance_response = None
        if "reverse" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv", None)
        elif "recv-disable" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv-disable", None)
        if maintenance_response and maintenance_response.replace('\"', ''):
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
            if tcp_monitor:
                tcp_monitor["maintenance_response"] = maintenance_response
            else:
                tcp_monitor = {"maintenance_response": maintenance_response}
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
        response = f5_monitor.get("recv", None)
        udp_monitor = None
        if request or response:
            udp_monitor = {"udp_request": request, "udp_response": response}
            monitor_dict["udp_monitor"] = udp_monitor
        maintenance_response = None
        if "reverse" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv", None)
        elif "recv-disable" in f5_monitor.keys():
            maintenance_response = f5_monitor.get("recv-disable", None)
        if maintenance_response and maintenance_response.replace('\"', ''):
            maintenance_response = \
                maintenance_response.replace('\"', '').strip()
            if udp_monitor:
                udp_monitor["maintenance_response"] = maintenance_response
            else:
                udp_monitor = {"maintenance_response": maintenance_response}
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
        cmd_code = None if cmd_code == 'none' else cmd_code
        if cmd_code:
            cmd_code = conv_utils.upload_file(
                input_dir + os.path.sep + cmd_code)
        else:
            LOG.warn("Skipped monitor: %s for no value in run attribute" % name)
            conv_utils.add_status_row("monitor", "external", name, "error")
            monitor_dict['error'] = True
            return None
        ext_monitor = {
            "command_code": cmd_code,
            "command_parameters": f5_monitor.get("args", None),
            "command_variables": f5_monitor.get("user-defined", None)
        }
        monitor_dict["external_monitor"] = ext_monitor
        return skipped


class MonitorConfigConvV10(MonitorConfigConv):
    tup = "time until up"

    def get_name_type(self, f5_monitor, key):
        return f5_monitor.pop("type"), key

    def get_default_monitor(self, monitor_type, monitor_config):
        return monitor_config.get(monitor_type, {})

    def get_defaults(self, monitor_config, key):
        """
        Monitor can have inheritance used by attribute defaults-from in F5
        configuration this method recursively gets all the attributes from the
        default objects and forms complete object
        :param f5_monitor: F5 monitor object
        :param monitor_config: List of F5 monitor configs
        :param monitor_name: There is no attribute in config to determine type of
        monitor it can be mapped from root monitors name
        :return:
        """
        f5_monitor = monitor_config[key]
        parent_name = f5_monitor.get("defaults from", None)
        if parent_name:
            parent_monitor = monitor_config.get(parent_name, None)
            if parent_monitor:
                parent_monitor = self.get_defaults( monitor_config, parent_name)
                parent_monitor = copy.deepcopy(parent_monitor)
                parent_monitor.update(f5_monitor)
                f5_monitor = parent_monitor
        else:
            f5_monitor["type"] = key
        return f5_monitor
