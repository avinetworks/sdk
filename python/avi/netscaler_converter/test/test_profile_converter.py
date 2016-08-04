import logging
import os
import unittest
import json

from avi.netscaler_converter.profile_converter import ProfileConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
log = logging.getLogger(__name__)


def setUpModule():
    cfg_file = open('test_profile_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    log.debug(' read cofig %s', gSAMPLE_CONFIG)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)


class Test(unittest.TestCase):

    LOG = logging.getLogger("converter-log")
    LOG.setLevel(logging.DEBUG)
    fh = logging.FileHandler("test_output" + os.path.sep + "test.log",
                              mode='a', encoding=None, delay=False)
    fh.setLevel(logging.DEBUG)
    formatter = logging.Formatter(
        '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)
    LOG.addHandler(fh)

    def test_ssl_conversion(self):
        profile_converter = ProfileConverter()
        avi_config = dict()
        ns_config_dict = gSAMPLE_CONFIG["ns_config_dict"]
        profile_converter.convert(ns_config_dict, avi_config, "./input_files")
        ssl_profile = avi_config.get('SSLProfile', None)
        ssl_certs = avi_config.get('SSLKeyAndCertificate', None)
        pki_profile = avi_config.get('PKIProfile', None)
        assert ssl_profile
        assert ssl_certs
        assert pki_profile
