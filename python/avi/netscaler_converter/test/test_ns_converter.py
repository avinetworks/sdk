import logging
import os
import unittest
import csv

import avi.netscaler_converter.netscaler_parser as ns_parser
import avi.netscaler_converter.netscaler_config_converter as ns_conf_converter

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)


class Test(unittest.TestCase):
    def test_ns_config_conversion(self):
        ns_config = ns_parser.get_ns_conf_dict('ns.conf')
        avi_config = ns_conf_converter.convert(ns_config, 'admin', '16.3',
                                               'test_output', 'input_files')
        assert avi_config.get('SSLProfile', None)
        assert avi_config.get('SSLKeyAndCertificate', None)
        assert avi_config.get('NetworkProfile', None)
        assert avi_config.get('ApplicationProfile', None)
        assert avi_config.get('META', None)
        assert avi_config.get('HealthMonitor', None)
        assert avi_config.get('VirtualService', None)
        assert avi_config.get('Pool', None)

        with open('%s%sConversionStatus.csv' %('test_output', os.path.sep)) \
                as csvfile:
            reader = csv.DictReader(csvfile)
            for row in reader:
                assert row['Status'] != 'error'
