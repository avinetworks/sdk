"""
This file contains Conversion code of f5 configuration.
"""

import os
import copy
from avi.migrationtools.f5_converter import (f5_config_converter,f5_parser)
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.netscaler_converter import netscaler_parser as ns_parser
import avi.migrationtools.netscaler_converter.netscaler_config_converter \
    as ns_conf_converter
from avi.migrationtools.avi_converter import AviConverter

class F5Conversion(AviConverter):
    def __init__(self):
        self.conversion_util = F5Util()

    def convert(self,convert_type,filelocation,f5_config_version,outputlocation,vs_state,controller_version,cloudName):
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
            print actual_f5_config_dict
            avi_config_dict = f5_config_converter.convert(
                f5_config_dict, outputlocation, vs_state, filelocation,f5_config_version, True,
                controller_version, 'test', None, False, {}, None, tenant='admin', cloud_name='Default-Cloud')
            return actual_f5_config_dict,avi_config_dict
        if convert_type == 'ns':
            source_file = filelocation
            output_file = outputlocation
            ns_config, skipped_cmds = ns_parser.get_ns_conf_dict(source_file)
            meta = self.meta(self.tenant, controller_version)
            report_name = os.path.splitext(os.path.basename(source_file))[0]
            actual_ns_config_dict = copy.deepcopy(ns_config)
            avi_config = ns_conf_converter.convert(meta, ns_config, 'admin',
                                                   cloudName, controller_version, output_file,
                                                   source_file, skipped_cmds, vs_state,
                                                   True, report_name, None,
                                                   None, None, key_passphrase = False,
                                                   user_ignore ={}, vs_level_status = False)

            return actual_ns_config_dict,avi_config


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