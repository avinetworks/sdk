"""
This file contains Conversion code of f5 configuration.
"""

import os
import sys
import copy
import argparse
import unittest
from avi.migrationtools.f5_converter import (f5_config_converter,
                                            f5_parser, scp_util)
from avi.migrationtools.f5_converter.conversion_util import F5Util

class F5Conversion():
    def __init__(self):
        self.conversion_util = F5Util()

    def convert(self,convert_type,filelocation,f5_config_version,outputlocation,vs_state,controller_version):
        if convert_type == 'f5':
            source_file = open(filelocation, "r")
            source_str = source_file.read()
            total_size = source_file.tell()
            f5_config_dict, not_supported_list = f5_parser.parse_config(
                source_str, total_size,f5_config_version)
            f5_defaults_dict = self.get_default_config(f5_config_version)
            self.dict_merge(f5_defaults_dict, f5_config_dict)
            f5_config_dict = f5_defaults_dict
            actual_f5_config_dict = copy.deepcopy(f5_config_dict)
            avi_config_dict = f5_config_converter.convert(
                f5_config_dict, outputlocation, vs_state, filelocation,f5_config_version, True,
                controller_version, 'test', None, False, {}, None, tenant='admin', cloud_name='Default-Cloud')
            #print  "converted output########", avi_config_dict
            return actual_f5_config_dict,avi_config_dict

    def get_default_config(self,f5_config_version):
        """
        :param is_download:
        :param path:
        :return:
        """
        f5_defaults_dict = {}

        if f5_config_version == '12':
            f5_config_version = '11'

        # Added to get directory path.
        dir_path = self.conversion_util.get_project_path()
        with open(dir_path + os.path.sep + "f5_v%s_defaults.conf" %
                f5_config_version, "r") as defaults_file:
            f5_defaults_dict, not_supported_list = f5_parser.parse_config(
                defaults_file.read(), defaults_file.tell(),
                f5_config_version)
        return f5_defaults_dict

    def dict_merge(self, dct, merge_dct):
        for k, v in merge_dct.iteritems():
            if (k in dct and isinstance(dct[k], dict) and
                    isinstance(merge_dct[k], dict)):
                self.dict_merge(dct[k], merge_dct[k])
            else:
                dct[k] = merge_dct[k]