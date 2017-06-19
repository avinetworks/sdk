#!/usr/bin/env python
import argparse
import json
import logging
import os
import sys
import avi.migrationtools
import yaml
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools.config_patch import ConfigPatch
from requests.packages import urllib3
from avi.migrationtools.f5_converter import (f5_config_converter,
                                            f5_parser, scp_util,
                                            conversion_util)
from avi.migrationtools import avi_rest_lib
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ansible.ansible_config_converter import AviAnsibleConverter
from pkg_resources import parse_version

# urllib3.disable_warnings()
LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)

DEFAULT_SKIP_TYPES = [
    'SystemConfiguration', 'Network', 'debugcontroller', 'VIMgrVMRuntime',
    'VIMgrIPSubnetRuntime', 'Alert', 'VIMgrSEVMRuntime', 'VIMgrClusterRuntime',
    'VIMgrHostRuntime', 'DebugController', 'ServiceEngineGroup',
    'SeProperties', 'ControllerProperties', 'CloudProperties']

class F5Converter(AviConverter):
    def __init__(self, args):
        self.bigip_config_file = args.bigip_config_file
        self.skip_default_file = args.skip_default_file
        self.f5_config_version = args.f5_config_version
        self.input_folder_location = args.input_folder_location
        self.output_file_path = args.output_file_path if args.output_file_path \
            else 'output'
        self.option = args.option
        self.user = args.user
        self.password = args.password
        self.controller_ip = args.controller_ip
        self.tenant = args.tenant
        self.cloud_name = args.cloud_name
        self.vs_state = args.vs_state
        self.controller_version = args.controller_version
        self.f5_host_ip = args.f5_host_ip
        self.f5_ssh_user = args.f5_ssh_user
        self.f5_ssh_password = args.f5_ssh_password
        self.f5_key_file = args.f5_key_file
        self.ignore_config = args.ignore_config
        self.partition_config = args.partition_config
        self.version = args.version
        self.ssl_profile_merge_check = args.no_profile_merge
        # config_patch.py args taken into class variable
        self.patch = args.patch
        # vs_filter.py args taken into classs variable
        self.vs_filter = args.vs_filter
        self.ansible_skip_types = args.ansible_skip_types
        self.ansible_filter_types = args.ansible_filter_types
        self.create_ansible = args.ansible
        # Prefix for objects
        self.prefix = args.prefix
        # Setting snat conversion flag using args
        self.con_snatpool = args.convertsnat

    def init_logger_path(self):
        LOG.setLevel(logging.DEBUG)
        if self.bigip_config_file:
            report_name = '%s-converter.log' % os.path.splitext(
                os.path.basename(self.bigip_config_file))[0]
        else:
            report_name = 'converter.log'
        formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] ' \
                    '%(message)s'
        logging.basicConfig(
            filename=os.path.join(self.output_file_path, report_name),
            level=logging.DEBUG, format=formatter)

    def print_pip_and_controller_version(self):
        # Added input parameters to log file
        LOG.info("Input parameters: %s" % ' '.join(sys.argv))
        # Add logger and print avi netscaler converter version
        LOG.info('AVI sdk version: %s Controller Version: %s'
                 % (sdk_version, self.controller_version))
        print 'AVI sdk version: %s Controller Version: %s' \
              % (sdk_version, self.controller_version)

    def upload_config_to_controller(self, avi_config):
        avi_rest_lib.upload_config_to_controller(
            avi_config, self.controller_ip, self.user, self.password,
            self.tenant)

    def convert(self):
        if not os.path.exists(self.output_file_path):
            os.mkdir(self.output_file_path)
        self.init_logger_path()
        output_dir = os.path.normpath(self.output_file_path)
        input_dir = os.path.normpath(self.input_folder_location)
        is_download_from_host = False
        if self.f5_host_ip:
            input_dir = output_dir + os.path.sep + self.f5_host_ip + \
                        os.path.sep + "input"
            if not os.path.exists(input_dir):
                os.makedirs(input_dir)
            output_dir = output_dir + os.path.sep + self.f5_host_ip + \
                         os.path.sep + "output"
            if not os.path.exists(output_dir):
                os.makedirs(output_dir)
            is_download_from_host = True
        user_ignore = {}
        # Read the attributes for user ignore val
        if self.ignore_config:
            with open(self.ignore_config) as stream:
                user_ignore = yaml.safe_load(stream)
        partitions = []
        # Add logger and print avi f5 converter version
        self.print_pip_and_controller_version()

        if self.partition_config:
            partitions = self.partition_config.split(',')

        if is_download_from_host:
            LOG.debug("Copying files from host")
            scp_util.get_files_from_f5(input_dir, self.f5_host_ip,
                                       self.f5_ssh_user, self.f5_ssh_password)
            LOG.debug("Copied input files")
            source_file = open(input_dir + os.path.sep + "bigip.conf", "r")
            files = os.listdir(input_dir)
            for f in files:
                if f.endswith('_bigip.conf'):
                    partitions.append(input_dir + os.path.sep + f)
        elif self.bigip_config_file:
            source_file = open(self.bigip_config_file, "r")
        if not source_file:
            print 'Not found ns configuration file'
            return
        source_str = source_file.read()
        LOG.debug('Parsing config file:' + source_file.name)
        f5_config_dict = f5_parser.parse_config(source_str,
                                                self.f5_config_version)
        LOG.debug('Config file %s parsed successfully' % source_file.name)
        avi_config_dict = None
        LOG.debug('Parsing defaults files')
        f5_defaults_dict = self.get_default_config(is_download_from_host,
                                                   input_dir)
        if partitions:
            partition_conf = {}
            for partition in partitions:
                with open(partition, "r") as p_source_file:
                    p_src_str = p_source_file.read()
                LOG.debug('Parsing partition config file:' + p_source_file.name)
                partition_dict = f5_parser.parse_config(
                    p_src_str, self.f5_config_version)
                LOG.debug(
                    'Config file %s parsed successfully' % p_source_file.name)
                self.dict_merge(partition_conf, partition_dict)
            self.dict_merge(partition_conf, f5_config_dict)
            f5_config_dict = partition_conf

        LOG.debug('Defaults files parsed successfully')
        LOG.debug('Conversion started')
        self.dict_merge(f5_defaults_dict, f5_config_dict)
        f5_config_dict = f5_defaults_dict
        report_name = os.path.splitext(os.path.basename(source_file.name))[0]
        avi_config_dict = f5_config_converter.convert(
            f5_config_dict, output_dir, self.vs_state, input_dir,
            self.f5_config_version, self.ssl_profile_merge_check,
            self.controller_version, report_name, self.prefix, self.con_snatpool, user_ignore,
            self.tenant, self.cloud_name)

        avi_config_dict["META"] = {
            "supported_migrations": {
                "versions": [
                    "14_2",
                    "15_1",
                    "15_1_1",
                    "15_2",
                    "15_2_3",
                    "15_3",
                    "16_1",
                    "16_1_1",
                    "16_1_2",
                    "16_1_3",
                    "16_2",
                    "16_2_1",
                    "16_2_2",
                    "16_2_3",
                    "16_3",
                    "16_3_1",
                    "16_3_2",
                    "16_3_4",
                    "16_4_1",
                    "16_4_2"
                ]
            },
            "version": {
                "Product": "controller",
                "Version": self.controller_version,
                "min_version": 15.2,
                "ProductName": "Avi Cloud Controller"
            },
            "upgrade_mode": False,
            "use_tenant": self.tenant
        }

        if parse_version(self.controller_version) >= parse_version('17.1'):
            avi_config_dict['META']['supported_migrations']['versions'].append(
                '17_1_1')
        avi_config_dict['META']['supported_migrations']['versions'].append(
            'current_version')

        avi_config = self.process_for_utils(avi_config_dict)
        self.write_output(avi_config, output_dir, '%s-Output.json' %
                          report_name)
        if self.create_ansible:
            avi_traffic = AviAnsibleConverter(
                avi_config, output_dir, self.prefix)
            avi_traffic.write_ansible_playbook(
                self.f5_host_ip, self.f5_ssh_user, self.f5_ssh_password)
        if self.option == 'auto-upload':
            self.upload_config_to_controller(avi_config)


    def get_default_config(self, is_download, path):
        f5_defaults_dict = {}
        if is_download:
            with open(path + os.path.sep + "profile_base.conf", "r") as \
                    profile:
                profile_base = profile.read()
            with open(path + os.path.sep + "base_monitors.conf", "r") as \
                    monitor:
                monitor_base = monitor.read()
            if bool(self.skip_default_file):
                LOG.warning('Skipped default profile base file : %s\nSkipped '
                            'default monitor base file : %s'
                            % (profile.name, monitor.name))
                return f5_defaults_dict
            profile_dict = f5_parser.parse_config(profile_base,
                                                  self.f5_config_version)
            monitor_dict = f5_parser.parse_config(monitor_base,
                                                  self.f5_config_version)
            if int(self.f5_config_version) == 10:
                default_mon = monitor_dict.get("monitor", {})
                root_mon = monitor_dict["monitorroot"]
                for key in root_mon.keys():
                    default_mon[key.replace("type ", "")] = root_mon[key]
                monitor_dict["monitor"] = default_mon
                del monitor_dict["monitorroot"]
            profile_dict.update(monitor_dict)
            f5_defaults_dict = profile_dict

        else:
            if self.f5_config_version == '12':
                self.f5_config_version = '11'
            if getattr(sys, 'frozen', False):
                # running in a exe bundle
                dir_path = os.path.abspath(os.path.dirname(__file__))
            else:
                # running from source
                dir_path = conversion_util.get_project_path()
            with open(dir_path + os.path.sep + "f5_v%s_defaults.conf" %
                    self.f5_config_version, "r") as defaults_file:
                if bool(self.skip_default_file):
                    LOG.warning(
                        'Skipped default file : %s' % defaults_file.name)
                    return f5_defaults_dict
                f5_defaults_dict = f5_parser.parse_config(
                    defaults_file.read(), self.f5_config_version)

        return f5_defaults_dict

    def dict_merge(self, dct, merge_dct):
        for k, v in merge_dct.iteritems():
            if (k in dct and isinstance(dct[k], dict) and
                    isinstance(merge_dct[k], dict)):
                self.dict_merge(dct[k], merge_dct[k])
            else:
                dct[k] = merge_dct[k]
if __name__ == "__main__":

    HELP_STR = '''
    Converts F5 Config to Avi config.
    Example: to convert bigip conf file avi config json
        f5_converter.py -f  bigip.conf

    Example to export a single VS:
        f5_converter.py -f  bigip.conf --vs_filter cool_vs

    Example to restrict duplicate profiles to merge
        f5_converter.py -f  bigip.conf --no_profile_merge

    Example to download config from F5 host and convert to avi config:
        f5_converter.py --f5_host_ip "1.1.1.1" --f5_ssh_user
        "username" --f5_ssh_password "password"

    Example to auto upload to controller after conversion:
            f5_converter.py -f  bigip.conf -O auto-upload -c 2.2.2.2 -u
            username -p password -t tenant
    '''


    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    parser.add_argument('-f', '--bigip_config_file',
                        help='absolute path for F5 config file')
    parser.add_argument('--skip_default_file',
                        help='Flag for skip default file', default=False)
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in',
                        )
    parser.add_argument('-O', '--option', choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config ' +
                             'file auto upload will upload config to ' +
                             'controller', default='cli-upload')
    parser.add_argument('-u', '--user',
                        help='controller username for auto upload',
                        default='admin')
    parser.add_argument('-p', '--password',
                        help='controller password for auto upload',
                        default='avi123')
    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')
    parser.add_argument('-t', '--tenant', help='tenant name for auto upload',
                        default='admin')
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of input files like cert files ' +
                             'external monitor scripts', default='./')
    parser.add_argument('--f5_host_ip', help='host ip of f5 instance')
    parser.add_argument('--f5_ssh_user', help='f5 host ssh username')
    parser.add_argument('--f5_ssh_password',
                        help='f5 host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--f5_key_file',
                        help='f5 host key file location if key based ' +
                             'authentication')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version', default='17.1.1')
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')
    parser.add_argument('--partition_config',
                        help='comma separated partition config files')
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')
    parser.add_argument('--no_profile_merge',
                        help='Flag for ssl profile merge', action='store_false')
    # Added command line args to execute config_patch file with related avi
    # json file location and patch location
    parser.add_argument('--patch', help='Run config_patch please provide '
                                        'location of patch.yaml')
    # Added command line args to execute vs_filter.py with vs_name.
    parser.add_argument('--vs_filter', help='comma seperated names of '
                                            'virtualservices')
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_skip_types',
                        help='Comma separated list of Avi Object types to skip '
                             'during conversion.\n  Eg. -s DebugController,'
                             'ServiceEngineGroup will skip debugcontroller and '
                             'serviceengine objects',default=DEFAULT_SKIP_TYPES)
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_filter_types',
                        help='Comma separated list of Avi Objects types to '
                             'include during conversion.\n Eg. -f '
                             'VirtualService, Pool will do ansible conversion '
                             'only for Virtualservice and Pool objects',
                        default=[])
    # Create Ansible Script based on Flag
    parser.add_argument('--ansible',
                        help='Flag for create ansible file', action='store_true')
    # Added prefix for objects
    parser.add_argument('--prefix', help='Prefix for objects')

    # Added snatpool conversion option
    parser.add_argument('--convertsnat',
                        help='Flag for converting snatpool into individual addresses',
                        action = "store_true")


    args = parser.parse_args()
    # print avi f5 converter version
    if args.version:
        print "SDK Version: %s\nController Version: %s" % \
              (sdk_version, args.controller_version)
        exit(0)

    f5_converter = F5Converter(args)
    f5_converter.convert()
