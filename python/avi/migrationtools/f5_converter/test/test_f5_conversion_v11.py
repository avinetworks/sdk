import copy
import logging
import os
import unittest
import csv

import avi.migrationtools.f5_converter.f5_config_converter as f5_config_converter
import avi.migrationtools.f5_converter.f5_parser as f5_parser
import avi.migrationtools.f5_converter.f5_converter as f5_converter

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    dir_path = os.path.abspath(os.path.dirname(__file__))
    dir_path = dir_path.rsplit(os.path.sep, 1)[0]
    dir_path = dir_path + os.path.sep + "output"
    logging.basicConfig(filename=os.path.join(dir_path, 'converter.log'),
                        level=logging.DEBUG, format=formatter)
    dir_path = os.path.abspath(os.path.dirname(__file__))
    cfg_file = open(dir_path+os.path.sep+'bigip_v11.conf', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = cfg


class Test(unittest.TestCase):

    def test_config_conversion(self):
        dir_path = os.path.abspath(os.path.dirname(__file__))
        dir_path = dir_path.rsplit(os.path.sep, 1)[0]
        f5_config_dict = f5_parser.parse_config(gSAMPLE_CONFIG, 11)

        defaults_file = open(dir_path+os.path.sep+"f5_v11_defaults.conf", "r")
        f5_defaults_dict = f5_parser.parse_config(defaults_file.read(), 11)
        f5_converter.dict_merge(f5_defaults_dict, f5_config_dict)
        f5_config_dict = f5_defaults_dict

        assert f5_config_dict.get("virtual", None)
        assert f5_config_dict.get("monitor", None)
        assert f5_config_dict.get("pool", None)
        assert f5_config_dict.get("profile", None)
        assert f5_config_dict.get("node", None)
        avi_config_dict = f5_config_converter.convert(
            f5_config_dict, dir_path+os.path.sep+"output", "disable",
            "certs", '11')
        assert avi_config_dict
        with open('%s%soutput%sConversionStatus.csv' %
                          (dir_path, os.path.sep, os.path.sep)) as csvfile:
            reader = csv.DictReader(csvfile)
            for row in reader:
                assert row['Status'] != 'error'


if __name__ == "__main__":
    unittest.main()
