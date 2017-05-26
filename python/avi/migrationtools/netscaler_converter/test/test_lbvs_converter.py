import logging
import os
import unittest
import json

from avi.netscaler_converter.lbvs_converter import LbvsConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)
    cfg_file = open('test_lbvs_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)


class Test(unittest.TestCase):
    def test_lbvs_conversion(self):
        lbvs_converter = LbvsConverter()
        avi_config = gSAMPLE_CONFIG["avi_config"]
        ns_config_dict = gSAMPLE_CONFIG["ns_config_dict"]
        lbvs_converter.convert(ns_config_dict, avi_config)
        assert avi_config['VirtualService']
        assert len(avi_config['VirtualService']) == len(
            ns_config_dict['add lb vserver'])
        assert avi_config['ApplicationPersistenceProfile']
        pool_obj = [pool for pool in avi_config['Pool']
                    if pool["name"] == 'testpersist-pool']
        assert pool_obj[0]['application_persistence_profile_ref']