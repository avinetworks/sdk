import logging
import avi.netscaler_converter.ns_util as ns_util
import os
import re

LOG = logging.getLogger(__name__)


class MonitorConverter(object):

    skip_attrs = ['action', 'respCode', 'rtspRequest', 'customHeaders',
                  'dispatcherIP', 'dispatcherPort', 'LRTM', 'deviation',
                  'resptimeoutThresh', 'retries', 'alertRetries', 'downTime',
                  'state', 'reverse', 'transparent', 'ipTunnel',
                  'tos', 'tosId', 'secure', 'IPAddress', 'group', 'metricTable',
                  'netProfile', 'vendorSpecificVendorId',
                  'vendorSpecificAuthApplicationIds',
                  'vendorSpecificAcctApplicationIds',
                  'storefrontcheckbackendservices']
    na_attrs = ['userName', 'password', 'radKey', 'radNASid',
                'radNASip', 'radAccountType', 'radFramedIP', 'radAPN',
                'radMSISDN', 'radAccountSession', 'validateCred', 'fileName',
                'baseDN', 'bindDN', 'filter', 'attribute', 'database',
                'oracleSid ', 'sqlQuery', 'evalRule', 'mssqlProtocolVersion',
                'snmpOID', 'snmpCommunity', 'snmpThreshold', 'snmpVersion',
                'originHost', 'originRealm', 'vendorId', 'productName',
                'firmwareRevision', 'authApplicationId', 'acctApplicationId',
                'inbandSecurityId', 'supportedVendorIds', 'kcdAccount',
                'storedb', 'maxForwards', 'sipMethod', 'sipURI', 'sipregURI',
                'secondaryPassword', 'logonpointName', 'lasVersion', 'domain',
                'application', 'sitePath', 'storename', 'storefrontacctservice',
                'hostIPAddress']
    indirect_list = ['destIP']

    def convert(self, ns_config, avi_config, input_dir):
        LOG.debug("Conversion started for Health Monitors")
        ns_monitors = ns_config.get('add lb monitor', {})
        supported_types = ['PING', 'TCP', 'HTTP', 'DNS', 'USER', 'HTTP-ECV']
        avi_config['HealthMonitor'] = []
        for name in ns_monitors.keys():
            cmd = 'add lb monitor %s' % name
            ns_monitor = ns_monitors.get(name)
            mon_type = ns_monitor['attrs'][1]
            if not mon_type in supported_types:
                ns_util.add_status_row(cmd, 'skipped')
                LOG.warn('Monitor type %s not supported skipped:%s' %
                         (mon_type, name))
                continue
            avi_monitor = self.convert_monitor(ns_monitor, input_dir)
            if not avi_monitor:
                continue
            conv_status = ns_util.get_conv_status(
                ns_monitor, self.skip_attrs, self.na_attrs, self.indirect_list)
            ns_util.add_conv_status(cmd, conv_status, avi_monitor)
            avi_config['HealthMonitor'].append(avi_monitor)
            LOG.debug("Health monitor conversion completed")

    def convert_monitor(self, ns_monitor, input_dir):
        avi_monitor = dict()
        try:
            LOG.debug('Conversion started for monitor %s' %
                      ns_monitor['attrs'][0])
            avi_monitor["name"] = ns_monitor['attrs'][0]
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
                response = ns_monitor.get('recv', None)
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
