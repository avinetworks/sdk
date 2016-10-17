import logging
import os
import unittest
import json

from avi.netscaler_converter.monitor_converter import MonitorConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)
    cfg_file = open('test_monitor_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    LOG.debug(' read cofig %s', gSAMPLE_CONFIG)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)


class Test(unittest.TestCase):
    monitor_converter = MonitorConverter()

    def test_ping_monitor_conversion(self):
        avi_config = dict()
        self.monitor_converter.convert(gSAMPLE_CONFIG['ping_mon_config'],
                                       avi_config, '')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_PING'

    def test_tcp_monitor_conversion(self):
        avi_config = dict()
        self.monitor_converter.convert(gSAMPLE_CONFIG['tcp_mon_config'],
                                       avi_config, '')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_TCP'

    def test_http_monitor_conversion(self):
        avi_config = dict()
        self.monitor_converter.convert(gSAMPLE_CONFIG['http_mon_config'],
                                       avi_config, '')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_HTTP'
        assert monitor['http_monitor']

    def test_dns_monitor_conversion(self):
        avi_config = dict()
        self.monitor_converter.convert(gSAMPLE_CONFIG['dns_mon_config'],
                                       avi_config, '')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_DNS'

    def test_external_monitor_conversion(self):
        avi_config = dict()
        self.monitor_converter.convert(gSAMPLE_CONFIG['external_mon_config'],
                                       avi_config, 'input_files')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_EXTERNAL'
        assert monitor['external_monitor'].get('command_code')

    def test_http_ecv_monitor_conversion(self):
        avi_config = dict()
        input = gSAMPLE_CONFIG['http-ecv_mon_config']
        self.monitor_converter.convert(input, avi_config, '')
        assert avi_config
        monitors = avi_config.get('HealthMonitor', [])
        assert len(monitors) > 0
        monitor = monitors[0]
        assert monitor['type'] == 'HEALTH_MONITOR_HTTP'
        assert monitor['http_monitor']
        input = input['add lb monitor']
        ns_monitor = input[input.keys()[0]]
        assert ns_monitor['recv'] == monitor['http_monitor']['http_response']
        assert ns_monitor['send'] == monitor['http_monitor']['http_request']