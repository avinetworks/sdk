""" Health Monitor Conversion Goes here """
import logging
from avi.migrationtools.ace_converter.ace_constants import\
        DEFAULT_FAILED_CHECKS, DEFAULT_INTERVAL, DEFAULT_TIMEOUT
from avi.migrationtools.ace_converter.ace_utils import update_excel

# logging init
LOG = logging.getLogger(__name__)


class MonitorConverter(object):
    """ Monitor Converter Class """
    def __init__(self, parsed, tenant_ref, common_utils, tenant):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.tenant = tenant

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
                "send_interval": int(send_interval),
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
            elif health_monitor['type'].strip() == 'https':
                monitor['type'] = "HEALTH_MONITOR_HTTPS"
            else:
                monitor['type'] == "HEALTH_MONITOR_PING"

            if health_monitor['type'].strip() == 'http' or health_monitor['type'].strip() == 'https':
                # for url
                if health_monitor.get('method', []) and health_monitor.get('url', []):
                    request_url = "{} {}".format(health_monitor['method'], health_monitor['url'])
                elif health_monitor.get('header-value', []):
                    request_url = "HEAD Host:{}".format(str(health_monitor['header-value']).replace('"',''))
                else:
                    request_url = health_monitor.get('url', [])

                # for response code
                response_code = []
                if '20' in health_monitor.get('status', []):
                    response_code.append('HTTP_2XX')
                if '30' in health_monitor.get('status', []):
                    response_code.append('HTTP_3XX')
                if '40' in health_monitor.get('status', []):
                    response_code.append('HTTP_4XX')
                if '50' in health_monitor.get('status', []):
                    response_code.append('HTTP_5XX')
                if '*' in health_monitor.get('status', []):
                    response_code.append('HTTP_ANY')

                # add any if no response code is there
                if response_code == []:
                    response_code = ['HTTP_ANY']

                if health_monitor.get('regex', []):
                    response_code.append('HTTP_ANY')
                health_monitor_type = 'http_monitor'
                server_response_data = health_monitor.get('status1', [])
                if health_monitor['type'] == 'https':
                    health_monitor_type = 'https_monitor'

                extra_details = {
                                    health_monitor_type: {
                                        "maintenance_response": "",
                                        "client_request_data": request_url,
                                        "response_data": response_code,
                                        "server_response_data": server_response_data,
                                        "description": "",
                                    }
                                }


                monitor.update(extra_details)

            # Excel Sheet updating
            update_excel('probe', health_monitor['name'], avi_obj=monitor)

            monitor_list.append(monitor)
        return monitor_list
