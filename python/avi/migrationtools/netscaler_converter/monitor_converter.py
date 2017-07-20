import os
import re
import logging
import avi.migrationtools.netscaler_converter.ns_util as ns_util
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants

from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_EXTERNAL_MONITOR, STATUS_MISSING_FILE)


LOG = logging.getLogger(__name__)

# Define Dict of merge_object_mapping to update the merged monitor, profile
# name of ssl_profile, application_profile, network_profile etc
merge_object_mapping = {
    'ssl_profile': {'no': 0},
    'app_profile': {'no': 0},
    'network_profile': {'no': 0},
    'app_persist_profile': {'no': 0},
    'pki_profile': {'no': 0},
    'health_monitor': {'no': 0}
}


class MonitorConverter(object):

    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 user_ignore, prefix, object_merge_check):
        """
        Construct a new 'MonitorConverter' object.
        :param tenant_name: Name of tenant
        :param cloud_name: Name of cloud
        :param tenant_ref: Tenant reference
        :param cloud_ref: Cloud Reference
        :param user_ignore: Dict of user ignore attributes
        :param: prefix: Added prefix for objects
        """

        self.monitor_skip_attrs = ns_constants.netscalar_command_status[
            'monitor_skip_attrs']
        self.monitor_na_attrs = ns_constants.netscalar_command_status[
            'monitor_na_attrs']
        self.monitor_ignore_vals = ns_constants.netscalar_command_status[
            'monitor_ignore_vals']
        self.monitor_indirect_list = ns_constants.netscalar_command_status[
            'monitor_indirect_list']
        self.ns_monitor_types_supported = ns_constants.netscalar_command_status[
            'monitor_types_supported']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
        # List of ignore val attributes for add lb monitor netscaler command.
        self.user_ignore = user_ignore.get('monitor', [])
        # Added prefix flag
        self.prefix = prefix
        self.object_merge_check = object_merge_check
        self.monitor_merge_count = 0

    def convert(self, ns_config, avi_config, input_dir):
        """
        This functions defines that convert health monitor
        :param ns_config: Dict of netscalar commands
        :param avi_config: Dict of AVI
        :param input_dir: Input dir for command_code
        :return: None
        """
        netscalar_command = 'add lb monitor'
        LOG.debug("Conversion started for Health Monitors")
        ns_monitors = ns_config.get('add lb monitor', {})
        for name in ns_monitors.keys():
            ns_monitor = ns_monitors.get(name)
            ns_monitor_complete_command = \
                ns_util.get_netscalar_full_command(netscalar_command,
                                                   ns_monitor)
            ns_monitor_type = ns_monitor['attrs'][1]
            if ns_monitor_type not in self.ns_monitor_types_supported:
                # Skipped health monitor if type is not supported
                avi_monitor = self.convert_monitor(
                     ns_monitor, input_dir, netscalar_command,
                    ns_monitor_complete_command)
                if not avi_monitor:
                    continue

                avi_monitor['name'] = '%s-%s' % (avi_monitor['name'], 'dummy')
                avi_monitor["type"] = "HEALTH_MONITOR_EXTERNAL"
                ext_monitor = {
                    "command_code": "",
                }
                avi_monitor["external_monitor"] = ext_monitor
                avi_config['HealthMonitor'].append(avi_monitor)
                ns_util.add_status_row(
                    ns_monitor['line_no'], netscalar_command,
                    name, ns_monitor_complete_command, STATUS_EXTERNAL_MONITOR)
                LOG.warning('Monitor type %s not supported created dummy '
                            'external monitor:%s' %
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
            if self.object_merge_check:
                # Check health monitor is duplicate of other
                # health monitor then skipped this health
                # monitor and increment of count of
                # monitor_merge_count
                dup_of = ns_util.update_skip_duplicates(
                    avi_monitor, avi_config['HealthMonitor'], 'health_monitor',
                    merge_object_mapping, avi_monitor['name'], ns_monitor_type,
                    self.prefix)
                if dup_of:
                    self.monitor_merge_count += 1
                else:
                    avi_config['HealthMonitor'].append(avi_monitor)
            else:
                avi_config['HealthMonitor'].append(avi_monitor)
            LOG.debug("Health monitor conversion completed : %s" % name)

    def convert_monitor(self, ns_monitor, input_dir, netscalar_command,
                        ns_monitor_complete_command):
        """
        This functions defines that convert netscalar health monitor to AVI
        health monitor object
        :param ns_monitor: Object of health monitor
        :param input_dir: Input dir for command_code
        :param netscalar_command: Netscalar command for XL sheet status
        :param ns_monitor_complete_command: Full command for XL sheet status
        :return: health monitor object
        """

        avi_monitor = dict()
        try:
            mon_name = ns_monitor['attrs'][0]
            # Added prefix for objects
            if self.prefix:
                mon_name = self.prefix + '-' + mon_name
            LOG.debug('Conversion started for monitor %s' % mon_name)
            avi_monitor["name"] = str(mon_name).strip().replace(" ", "_")
            avi_monitor["tenant_ref"] = self.tenant_ref
            avi_monitor["receive_timeout"] = ns_monitor.get('resptimeout', 2)
            avi_monitor["failed_checks"] = ns_monitor.get('failureRetries', 3)
            interval = ns_monitor.get('interval', '5')
            if 'MIN' in interval.upper():
                match_obj = re.findall('[0-9]+', ns_monitor.get(
                    'interval', '5'))
                interval = int(match_obj[0]) * 60
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
            elif mon_type == 'TCP-ECV':
                avi_monitor["type"] = "HEALTH_MONITOR_TCP"
                send = ns_monitor.get("send", None)
                if send:
                    send = send.replace('"', '')
                response = ns_monitor.get('recv', None)
                if response:
                    response = response.replace('"', '')
                avi_monitor["tcp_monitor"] = {
                    "tcp_request": send,
                    "tcp_response": response,
                    "tcp_half_open": False
                }
            elif mon_type == 'HTTP':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTP"
                send = ns_monitor.get('httpRequest', None)
                if send:
                    send = send.replace('"', '')
                resp_code = ns_monitor.get('respCode', None)
                if resp_code:
                    resp_code = ns_util.get_avi_resp_code(resp_code)
                avi_monitor["http_monitor"] = {
                    "http_request": send,
                    "http_response_code": resp_code
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

            LOG.debug('Successfully converted monitor %s' % mon_name)
        except:
            LOG.error('Error converting monitor %s', exc_info=True)
        return avi_monitor
