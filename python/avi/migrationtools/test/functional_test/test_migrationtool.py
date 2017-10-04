import os
import sys
import copy
import argparse
import unittest
from avi.migrationtools.test.functional_test.f5_functional_test import *
from avi.migrationtools.f5_converter import (f5_config_converter,
                                            f5_parser, scp_util)
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.test.functional_test import f5_functional_test
class TestMigration(object):
    def __init__(self, args):
        self.filelocation = args.config_file
        self.outputlocation = args.output_file_path
        self.f5_config_version = args.version
        self.convert_type = args.conversion_type
        self.vs_state = args.vs_state
        self.controller_version = args.controller_version
        self.prefix = args.prefix
        self.key_file = args.key_file
        self.passphrase_file = args.passphrase_file
        self.no_object_merge = args.no_object_merge
        self.patch = args.patch
        self.vs_filter = args.vs_filter
        self.not_in_use = args.not_in_use
        self.baseline_profile = args.baseline_profile
        self.ignore_config = args.ignore_config
        self.ansible = args.ansible
        self.conversion_util = F5Util()

    # def get_default_config(self, path):
    #     f5_defaults_dict = {}
    #     if self.f5_config_version == '12':
    #         self.f5_config_version = '11'
    #     dir_path = self.conversion_util.get_project_path()
    #     with open(dir_path + os.path.sep + "f5_v%s_defaults.conf" %
    #             self.f5_config_version, "r") as defaults_file:
    #         f5_defaults_dict, not_supported_list = f5_parser.parse_config(
    #             defaults_file.read(), defaults_file.tell(),
    #             self.f5_config_version)
    #     return f5_defaults_dict

    def convert(self):
        if self.convert_type == 'f5':
            source_file = open (self.filelocation, "r")
            source_str = source_file.read()
            total_size = source_file.tell()
            f5_config_dict, not_supported_list = f5_parser.parse_config (
                source_str, total_size, self.f5_config_version)
            f5_defaults_dict = self.get_default_config()
            self.dict_merge(f5_defaults_dict, f5_config_dict)
            f5_config_dict = f5_defaults_dict
            actual_f5_config_dict = copy.deepcopy(f5_config_dict)
            avi_config_dict = f5_config_converter.convert(
            f5_config_dict, self.outputlocation, self.vs_state, self.filelocation, self.f5_config_version, True,
                self.controller_version,'test', None, False, {}, None, tenant='admin', cloud_name='Default-Cloud')

            test = f5_functional_test.Tester(actual_f5_config_dict,avi_config_dict)
            #test.compareDict(actual_f5_config_dict,avi_config_dict)
            print  "converted output########", avi_config_dict

    def get_default_config(self):
        """
        :param is_download:
        :param path:
        :return:
        """
        f5_defaults_dict = {}

        if self.f5_config_version == '12':
            self.f5_config_version = '11'

        # Added to get directory path.
        dir_path = self.conversion_util.get_project_path()
        with open(dir_path + os.path.sep + "f5_v%s_defaults.conf" %
            self.f5_config_version, "r") as defaults_file:
            f5_defaults_dict, not_supported_list = f5_parser.parse_config(
                defaults_file.read(), defaults_file.tell(),
                self.f5_config_version)
        return f5_defaults_dict

    def dict_merge(self, dct, merge_dct):
        for k, v in merge_dct.iteritems():
            if (k in dct and isinstance(dct[k], dict) and
                    isinstance(merge_dct[k], dict)):
                self.dict_merge(dct[k], merge_dct[k])
            else:
                dct[k] = merge_dct[k]

if __name__ == "__main__":
    HELP_STR = ''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    parser.add_argument ('-version',
                         help='version of f5 config file', default='11')
    parser.add_argument ('-type','--conversion_type',
                         help='conversion type f5 or ns')
    parser.add_argument ('-f', '--config_file',
                         help='absolute path of config file')
    parser.add_argument ('-o', '--output_file_path',
                         help='Folder path for output files to be created in', )
    parser.add_argument ('--cloud_name', help='cloud name for auto upload',
                         default='Default-Cloud')
    parser.add_argument ('-l', '--input_folder_location',
                         help='location of extracted backup folder')
    parser.add_argument ('-s', '--vs_state', choices=['enable', 'disable'],
                         help='state of VS created', default='disable')
    parser.add_argument ('--controller_version',
                         help='Target Avi controller version',
                         default='17.1.1')
    parser.add_argument ('--key_file',
                         help='host key file location if key based ' +
                              'authentication')
    parser.add_argument ('--passphrase_file',
                         help='key passphrase yaml file path')
    parser.add_argument ('--no_object_merge',
                         help='Flag for object merge', action='store_false')
    parser.add_argument ('--patch', help='Run config_patch please provide '
                                         'location of patch.yaml')
    parser.add_argument ('--vs_filter', help='comma seperated names of '
                                             'virtualservices')
    parser.add_argument ('--ignore_config',
                         help='config json to skip the config in conversion')
    parser.add_argument ('--prefix', help='Prefix for objects')
    parser.add_argument ('--not_in_use',
                         help='Flag for skipping not in use object',
                         action="store_true")
    parser.add_argument ('--baseline_profile', help='asolute path for json '
                                                    'file containing baseline profiles')
    parser.add_argument ('--ansible',
                         help='Flag for create ansible file', action='store_true')

    args = parser.parse_args()
    testmigration = TestMigration(args)
    testmigration.convert()
