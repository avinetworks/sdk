import os
import re
import logging
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants
import math
from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_EXTERNAL_MONITOR, STATUS_MISSING_FILE)
from avi.migrationtools.netscaler_converter.ns_util import NsUtil
from pkg_resources import parse_version



LOG = logging.getLogger(__name__)
# Creating f5 object for util library.
ns_util = NsUtil()
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
                 user_ignore, prefix, object_merge_check,
                 controller_version=None):
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
        self.controller_version = controller_version

    def convert(self, ns_config, avi_config, input_dir, sysdict):
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
        total_size = len(ns_monitors.keys())
        count = 0
        print "Converting Monitors..."
        for name in ns_monitors.keys():
            count = count + 1
            ns_monitor = ns_monitors.get(name)
            ns_monitor_complete_command = \
                ns_util.get_netscalar_full_command(netscalar_command,
                                                   ns_monitor)
            ns_monitor_type = ns_monitor['attrs'][1]
            if ns_monitor_type not in self.ns_monitor_types_supported:
                # Added external monitor if type is not supported
                avi_monitor = self.convert_monitor(
                     ns_monitor, input_dir, netscalar_command,
                    ns_monitor_complete_command)
                if not avi_monitor:
                    continue

                avi_monitor['name'] = '%s-%s' % (avi_monitor['name'], 'dummy')
                avi_monitor["type"] = "HEALTH_MONITOR_EXTERNAL"
                ext_monitor = {
                    "command_code": ""
                }
                avi_monitor["external_monitor"] = ext_monitor
                avi_config['HealthMonitor'].append(avi_monitor)
                msg = ('Monitor type %s not supported created dummy '
                            'external monitor:%s' %
                            (ns_monitor_type, name))
                LOG.warning(msg)
                ns_util.add_status_row(ns_monitor['line_no'], netscalar_command,
                    name, ns_monitor_complete_command, STATUS_EXTERNAL_MONITOR,
                    msg)
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
            # Checking for custom headers inorder to decide on conversion status
            if ns_monitor_type in ['HTTP', 'HTTP-ECV']:
                cus_header = ns_monitor.get('customHeaders')
                if cus_header:
                    repls = ('"', ''), ('\\r\\n', '')
                    cus_header = reduce(lambda a, kv: a.replace(*kv), repls,
                                        cus_header)
                    cus_header_list = [{i.split(':')[0]: i.split(':')[1]} for
                                       i in cus_header.split() if ':' in i]
                    if len(cus_header_list) == 1 and 'Host' in \
                            cus_header_list[0]:
                        LOG.debug("Monitor %s contains only 'Host' in 'custom "
                               "headers' attribute, " %name + "removing from "
                                                              "skipped")
                        conv_status['skipped'].remove('customHeaders')

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
                    self.prefix, sysdict['HealthMonitor'])
                if dup_of:
                    self.monitor_merge_count += 1
                else:
                    avi_config['HealthMonitor'].append(avi_monitor)
            else:
                avi_config['HealthMonitor'].append(avi_monitor)
            msg = "monitor conversion started..."
            ns_util.print_progress_bar(count, total_size, msg,
                                     prefix='Progress', suffix='')
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
        
        # Adding ssl-key and ssl-certificate for Secure
        ssl_attributes = None
        if ns_monitor.get('secure', []) == 'YES':
            # Force changing HTTP/HTTP-ECV to HTTPS in attributes 
            if ns_monitor.get('attrs', []):
                attr = ns_monitor['attrs']
                if 'HTTP' in attr:
                    attr.append('HTTPS')
                    attr.remove('HTTP')
                if 'HTTP-ECV' in attr:
                    attr.append('HTTPS')
                    attr.remove('HTTP-ECV')
                ns_monitor['attrs'] = attr
            # IF controller version is greater than 17.1 and type HTTP/S
            # add ssl-key and ssl-certificate
            # TODO: Remove this after all the clients are moved to 
            # 17 version and above
            if parse_version(self.controller_version) >= parse_version('17.1')\
                    and 'HTTPS' in ns_monitor.get('attrs', []):
                profile_ref = ns_util.get_object_ref('System-Standard',
                                                     'sslprofile',
                                                     'admin')
                ssl_attributes = {
                                  'ssl_profile_ref': profile_ref
                                 }
        try:
            mon_name = ns_monitor['attrs'][0]
            # Added prefix for objects
            if self.prefix:
                mon_name = self.prefix + '-' + mon_name
            LOG.debug('Conversion started for monitor %s' % mon_name)
            avi_monitor["name"] = str(mon_name).strip().replace(" ", "_")
            avi_monitor["tenant_ref"] = self.tenant_ref
            recv_timeout = ns_monitor.get('resptimeout', '2')
            if 'MSEC' in recv_timeout.upper() or 'MIN' in recv_timeout.upper():
                match_ob = re.findall('[0-9]+', recv_timeout)
                if 'MSEC' in recv_timeout.upper():
                    recv_timeout = int(math.ceil(float(match_ob[0])/1000))
                else:
                    recv_timeout = int(match_ob[0]) * 60
            avi_monitor["receive_timeout"] = recv_timeout
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
                    # Removed \\ from send.
                    if '\\' in send:
                        send = send.replace('\\', '"')
                response = ns_monitor.get('recv', None)
                if response:
                    response = response.replace('"', '')
                    # Removed \\ from response.
                    if '\\' in response:
                        response = response.replace('\\', '"')
                avi_monitor["tcp_monitor"] = {
                    "tcp_request": send,
                    "tcp_response": response,
                    "tcp_half_open": False
                }
            elif mon_type == 'HTTPS':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTPS"
                send = ns_monitor.get('httpRequest', None)
                if send:
                    send = send.replace('"', '')
                    # Removed \\ from send.
                    if '\\' in send:
                        send = send.replace('\\', '"')
                resp_code = ns_monitor.get('respCode', None)
                if resp_code:
                    resp_code = ns_util.get_avi_resp_code(resp_code)
                # TODO: Remove this after all the clients are moved to 
                # 17 version and above
                if parse_version(self.controller_version) >= parse_version(
                        '17.1'):
                    avi_monitor["https_monitor"] = {
                        "http_request": send,
                        "http_response_code": resp_code,
                        "ssl_attributes": ssl_attributes
                    }
                if parse_version(self.controller_version) >= parse_version(
                        '17.1.6'):
                    custom_header = ns_monitor.get('customHeaders')
                    if custom_header:
                        avi_monitor['https_monitor'].update({
                            'exact_http_request': True,
                            'http_request': (send + ' HTTP/1.0' + "\r\n" +
                                            custom_header + "\r\n").replace('"',
                                            '').replace('\\r\\n', '\r\n') if
                                            send else ('HTTP/1.0' + "\r\n" +
                                            custom_header + "\r\n").replace('"',
                                            '').replace('\\r\\n', '\r\n')
                        })
            elif mon_type == 'HTTP':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTP"
                send = ns_monitor.get('httpRequest', None)
                if send:
                    send = send.replace('"', '')
                    # Removed \\ from send.
                    if '\\' in send:
                        send = send.replace('\\', '"')
                resp_code = ns_monitor.get('respCode', None)
                if resp_code:
                    resp_code = ns_util.get_avi_resp_code(resp_code)
                avi_monitor["http_monitor"] = {
                    "http_request": send,
                    "http_response_code": resp_code
                }
                if parse_version(self.controller_version) >= parse_version(
                        '17.1.6'):
                    custom_header = ns_monitor.get('customHeaders')
                    if custom_header:
                        avi_monitor['http_monitor'].update({
                            'exact_http_request': True,
                            'http_request': (send + ' HTTP/1.0' + "\r\n" +
                                            custom_header + "\r\n").replace('"',
                                            '').replace('\\r\\n', '\r\n') if
                                            send else ('HTTP/1.0' + "\r\n" +
                                            custom_header + "\r\n").replace('"',
                                            '').replace('\\r\\n', '\r\n')
                        })
            elif mon_type == 'HTTP-ECV':
                avi_monitor["type"] = "HEALTH_MONITOR_HTTP"
                send = ns_monitor.get("send", None)
                if send:
                    send = send.replace('"', '')
                    # Removed \\ from send.
                    if '\\' in send:
                        send = send.replace('\\', '"')
                response = ns_monitor.get('recv', None)
                if response:
                    response = response.replace('"', '')
                    # Removed \\ from response.
                    if '\\' in response:
                        response = response.replace('\\', '"')
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
