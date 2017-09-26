""" Health Monitor Conversion Goes here """
import logging
from avi.migrationtools.ace_converter.ace_constants import\
        DEFAULT_FAILED_CHECKS, DEFAULT_INTERVAL, DEFAULT_TIMEOUT
from avi.migrationtools.ace_converter.ace_utils import update_excel

#logging init
LOG = logging.getLogger(__name__)

class MonitorConverter(object):
    """ Monitor Converter Class """
    def __init__(self, parsed, tenant_ref, common_utils):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils

    def healthmonitor_conversion(self):
        """ Health monitor conversion happens here """

        # monitor list
        monitor_list = list()

        for health_monitor in self.parsed.get('probe', ''):
            receive_timeout = DEFAULT_TIMEOUT
            failed_checks = DEFAULT_FAILED_CHECKS
            send_interval = health_monitor.get('interval', DEFAULT_INTERVAL)
            if int(receive_timeout) > int(send_interval):
                if int(send_interval) != 0:
                    receive_timeout = int(send_interval) - 1
                else:
                    receive_timeout = 0
            # time_until_up = DEFAULT_TIME_UNTIL_UP
            successful_checks = DEFAULT_FAILED_CHECKS
            monitor = {
                "receive_timeout": receive_timeout,
                "name": health_monitor['name'],
                "tenant_ref": self.tenant_ref,
                "failed_checks": failed_checks,
                "send_interval": send_interval,
                "type": None,
                "successful_checks": successful_checks
            }
            if health_monitor['type'].strip() == 'icmp':
                monitor['type'] = 'HEALTH_MONITOR_PING'
            elif health_monitor['type'].strip() == 'tcp':
                monitor['type'] = 'HEALTH_MONITOR_TCP'
                extra_details = {
                                    "monitor_port": health_monitor.get('port', 80),
                                    "tcp_monitor": {
                                        "tcp_request": "",
                                        "tcp_response": "",
                                        "http_response": "",
                                        "maintenance_response": ""
                                    }
                                }
                monitor.update(extra_details)
            elif health_monitor['type'].strip() == 'http':
                monitor['type'] = "HEALTH_MONITOR_HTTP"
            else:
                monitor['type'] == "HEALTH_MONITOR_PING"

                # for url
                if health_monitor.get('method', []) and health_monitor.get('url', []):
                    request_url = "{} {}".format(health_monitor['method'], health_monitor['url'])
                else:
                    request_url = health_monitor.get('url', [])

                # for response code
                response_code = ['HTTP_2XX', 'HTTP_3XX']
                if '20' in health_monitor.get('status', []):
                    response_code = ['HTTP_2XX']
                extra_details = {
                                    "http_monitor": {
                                        "maintenance_response": "",
                                        "http_request": request_url,
                                        "http_response_code": response_code,
                                        "http_response": ""
                                    }
                                }
                monitor.update(extra_details)

            # Excel Sheet updating
            update_excel('probe', health_monitor['name'], avi_obj=monitor)

            monitor_list.append(monitor)
        return monitor_list
