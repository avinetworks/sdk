import logging
import os
import unittest
import json

from avi.netscaler_converter.profile_converter import ProfileConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)
    cfg_file = open('test_profile_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)


class Test(unittest.TestCase):

    def test_ssl_conversion(self):
        profile_converter = ProfileConverter()
        avi_config = dict()
        ns_config_dict = gSAMPLE_CONFIG["ssl_profile_config"]
        profile_converter.convert(ns_config_dict, avi_config, "./input_files")
        ssl_profile = avi_config.get('SSLProfile', None)
        ssl_certs = avi_config.get('SSLKeyAndCertificate', None)
        pki_profile = avi_config.get('PKIProfile', None)
        assert ssl_profile
        assert ssl_certs
        assert pki_profile

    def test_http_conversion(self):
        profile_converter = ProfileConverter()
        avi_config = dict()
        ns_config_dict = gSAMPLE_CONFIG["http_profile_config"]
        profile_converter.convert(ns_config_dict, avi_config, "./input_files")
        http_profiles = avi_config.get('ApplicationProfile', None)
        assert http_profiles[0]
        assert http_profiles[0]['type'] == 'APPLICATION_PROFILE_TYPE_HTTP'

    def test_tcp_conversion(self):
        profile_converter = ProfileConverter()
        avi_config = dict()
        ns_config_dict = gSAMPLE_CONFIG["tcp_profile_config"]
        profile_converter.convert(ns_config_dict, avi_config, "./input_files")
        tcp_profiles = avi_config.get('NetworkProfile', None)
        assert tcp_profiles[0]
        assert tcp_profiles[0]['profile']['type'] == 'PROTOCOL_TYPE_TCP_PROXY'