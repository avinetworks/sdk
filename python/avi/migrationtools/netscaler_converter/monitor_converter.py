import os
import re
import logging
import avi.migrationtools.netscaler_converter.ns_util as ns_util
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants

from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_EXTERNAL_MONITOR, STATUS_MISSING_FILE)


LOG = logging.getLogger(__name__)


class MonitorConverter(object):


    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 user_ignore, prefix):
        """
        Construct a new 'MonitorConverter' object.
        :param tenant_name: Name of tenant
        :param cloud_name: Name of cloud
        :param tenant_ref: Tenant reference
        :param cloud_ref: Cloud Reference
        :param user_ignore: Dict of user ignore attributes
        :param: prefix: Added prefix for objects
        """

        self.monitor_skip_attrs = \
            ns_constants.netscalar_command_status['monitor_skip_attrs']
        self.monitor_na_attrs = \
            ns_constants.netscalar_command_status['monitor_na_attrs']
        self.monitor_ignore_vals = \
            ns_constants.netscalar_command_status['monitor_ignore_vals']
        self.monitor_indirect_list = \
            ns_constants.netscalar_command_status['monitor_indirect_list']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
        # List of ignore val attributes for add lb monitor netscaler command.
        self.user_ignore = user_ignore.get('monitor', [])
        # Added prefix flag
        self.prefix = prefix

    def convert(self, ns_config, avi_config, input_dir):
        """
        This functions defines that convert health monitor
        :param ns_config: Dict of netscalar commands
        :param avi_config: Dict of AVI
        :param input_dir: Input dir for command_code
        :param tenant_ref: Tenant
        :param cloud_ref: Cloud ref
        :return: None
        """
        netscalar_command = 'add lb monitor'
        LOG.debug("Conversion started for Health Monitors")
        ns_monitors = ns_config.get('add lb monitor', {})
        supported_types = ['PING', 'TCP', 'HTTP', 'DNS', 'USER', 'HTTP-ECV']
        avi_config['HealthMonitor'] = []
        for name in ns_monitors.keys():
            ns_monitor = ns_monitors.get(name)
            ns_monitor_complete_command = \
                ns_util.get_netscalar_full_command(netscalar_command,
                                                   ns_monitor)
            ns_monitor_type = ns_monitor['attrs'][1]
            if ns_monitor_type not in supported_types:
                # Skipped health monitor if type is not supported
                ns_util.add_status_row(
                    ns_monitor['line_no'], netscalar_command,
                    name, ns_monitor_complete_command, STATUS_EXTERNAL_MONITOR)
                LOG.warning('Monitor type %s not supported skipped:%s' %
                         (ns_monitor_type, name))
                continue
            avi_monitor = self.convert_monitor(
                 ns_monitor, input_dir, netscalar_command,
                ns_monitor_complete_command)
            if not avi_monitor:
                continue
            # Add summery of this lb vs in CSV/report
            conv_status = ns_util.get_conv_status(
                ns_monitor, self.monitor_skip_attrs, self.monitor_na_attrs,
                self.monitor_indirect_list,
                ignore_for_val=self.monitor_ignore_vals,
                user_ignore_val=self.user_ignore)
            ns_util.add_conv_status(
                ns_monitor['line_no'], netscalar_command, name,
                ns_monitor_complete_command, conv_status, avi_monitor)
            avi_config['HealthMonitor'].append(avi_monitor)
            LOG.debug("Health monitor conversion completed : %s" % name)


    def convert_monitor(self, ns_monitor, input_dir, netscalar_command,
                        ns_monitor_complete_command):
        """
        This functions defines that convert netscalar health monitor to AVI
        health monitor object
        :param ns_monitor: Object of health monitor
        :param input_dir: Input dir for command_code
        :param tenant_ref: Tenant
        :param cloud_ref: Cloud ref
        :return: health monitor object
        """

        avi_monitor = dict()
        try:
            # Added prefix for objects
            if self.prefix:
                ns_monitor['attrs'][0] = self.prefix + '-' + \
                                         ns_monitor['attrs'][0]
            LOG.debug('Conversion started for monitor %s' %
                      ns_monitor['attrs'][0])
            avi_monitor["name"] = (ns_monitor['attrs'][0]).strip().\
                replace(" ", "_")
            avi_monitor["tenant_ref"] = self.tenant_ref
            avi_monitor["receive_timeout"] = ns_monitor.get('resptimeout', 2)
            avi_monitor["failed_checks"] = ns_monitor.get('failureRetries', 3)
            interval = ns_monitor.get('interval', '5')
            if 'MIN' in interval.upper():
                matchObj = re.findall('[0-9]+', ns_monitor.get('interval', '5'))
                interval = int(matchObj[0]) * 60
            avi_monitor["send_interval"] = str(interval)
            if ns_monitor.get('destPort'):
                avi_monitor['monitor_port'] = ns_monitor.get('destPort')
            avi_monitor["successful_checks"] = ns_monitor.get(
                'successRetries', 1)

            mon_type = ns_monitor['attrs'][1]

            if mon_type == 'PING':
                avi_monitor["type"] = "HEALTH_MONITOR_PING"
            elif mon_type == 'TCP':
                avi_monitor["type"] = "HEALTH_MONITOR_TCP"
            elif mon_type == 'HTTP':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTP"
                send = ns_monitor.get('httpRequest', None)
                if send:
                    send = send.replace('"', '')
                respCode = ns_monitor.get('respCode', None)
                if respCode:
                    respCode = ns_util.get_avi_resp_code(respCode)
                avi_monitor["http_monitor"] = {
                    "http_request": send,
                    "http_response_code": respCode
                }
            elif mon_type == 'HTTP-ECV':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTP"
                send = ns_monitor.get("send", None)
                if send:
                    send = send.replace('"', '')
                response = ns_monitor.get('recv', None)
                if response:
                    response = response.replace('"', '')
                avi_monitor["http_monitor"] = {
                    "http_request": send,
                    "http_response_code": ["HTTP_ANY"],
                    "http_response": response
                }
            elif mon_type == 'DNS':
                avi_monitor["type"] = "HEALTH_MONITOR_DNS"
            elif mon_type == 'USER':
                avi_monitor["type"] = "HEALTH_MONITOR_EXTERNAL"
                file_name = ns_monitor.get('scriptName')
                cmd_code = ns_util.upload_file(
                    input_dir + os.path.sep + file_name)
                if not cmd_code:
                    skipped_status = 'File not found %s : %s' % \
                                     (input_dir + os.path.sep + file_name,
                                      ns_monitor_complete_command)
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        ns_monitor['line_no'], netscalar_command,
                        avi_monitor["name"], ns_monitor_complete_command,
                        STATUS_MISSING_FILE, skipped_status)
                    return None
                ext_monitor = {
                    "command_code": cmd_code,
                    "command_parameters": ns_monitor.get("scriptArgs", None)
                }
                avi_monitor["external_monitor"] = ext_monitor

            LOG.debug('Successfully converted monitor %s' %
                      ns_monitor['attrs'][0])

        except:
            LOG.error('Error converting monitor %s', exc_info=True)
        return avi_monitor
