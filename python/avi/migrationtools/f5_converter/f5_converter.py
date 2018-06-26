#!/usr/bin/env python
import argparse
import json
import logging
import os
import sys
import avi.migrationtools
import yaml
import avi.migrationtools.f5_converter.converter_constants as conv_const
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools.avi_migration_utils import get_count
from requests.packages import urllib3

from avi.migrationtools.f5_converter import (f5_config_converter,
                                             f5_parser, scp_util)
from avi.migrationtools import avi_rest_lib
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ansible.ansible_config_converter import AviAnsibleConverter
from pkg_resources import parse_version
from avi.migrationtools.avi_orphan_object import wipe_out_not_in_use
from avi.migrationtools.f5_converter.conversion_util import F5Util
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
        self.f5_ssh_port = args.f5_ssh_port
        self.f5_key_file = args.f5_key_file
        self.ignore_config = args.ignore_config
        self.partition_config = args.partition_config
        self.version = args.version
        self.object_merge_check = args.no_object_merge
        # config_patch.py args taken into class variable
        self.patch = args.patch
        # vs_filter.py args taken into classs variable
        self.vs_filter = args.vs_filter
        # skip the object while creating ansible playbook
        self.ansible_skip_types = args.ansible_skip_types
        # Create ansible object playbook based on filter types.
        self.ansible_filter_types = args.ansible_filter_types
        # Tag to create ansible playbook.
        self.create_ansible = args.ansible
        # Prefix for objects
        self.prefix = args.prefix
        # rule config for irule conversion
        self.custom_config = args.custom_config
        # Setting snat conversion flag using args
        self.con_snatpool = args.convertsnat
        # Added not in use flag
        self.not_in_use = args.not_in_use
        # Added args for baseline profile json file to be changed
        self.profile_path = args.baseline_profile
        self.f5_passphrase_file = args.f5_passphrase_file
        self.vs_level_status = args.vs_level_status
        # Added args for creating test vips
        self.test_vip = args.test_vip
        # Support for vrf ref and segroup ref
        self.vrf = args.vrf
        self.segroup = args.segroup

        # Created f5 util object.
        self.conversion_util = F5Util()

    def print_pip_and_controller_version(self):
        """
        This method print the sdk version and controller version
        :return:
        """
        # Added input parameters to log file
        LOG.info("Input parameters: %s" % ' '.join(sys.argv))
        # Add logger and print avi netscaler converter version
        LOG.info('AVI sdk version: %s Controller Version: %s'
                 % (sdk_version, self.controller_version))
        print 'AVI sdk version: %s Controller Version: %s' \
              % (sdk_version, self.controller_version)

    def upload_config_to_controller(self, avi_config):
        """

        :param avi_config: conversion of f5 to avi compatible dict.
        :return:
        """
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
        custom_mappings = None
        if self.custom_config:
            with open(self.custom_config) as stream:
                custom_mappings = yaml.safe_load(stream)
        partitions = []
        # Add logger and print avi f5 converter version
        self.print_pip_and_controller_version()
        if self.partition_config:
            partitions = self.partition_config.split(',')
        source_file = None
        if is_download_from_host:
            LOG.debug("Copying files from host")
            print "Copying Files from Host..."
            scp_util.get_files_from_f5(input_dir, self.f5_host_ip,
                                       self.f5_ssh_user, self.f5_ssh_password,
                                       None, self.f5_ssh_port)
            LOG.debug("Copied input files")
            source_file = open(input_dir + os.path.sep + "bigip.conf", "r")
            files = os.listdir(input_dir)
            for f in files:
                if f.endswith('_bigip.conf'):
                    partitions.append(input_dir + os.path.sep + f)
        elif self.bigip_config_file:
            source_file = open(self.bigip_config_file, "r")
        if not source_file:
            print 'Not found F5 configuration file'
            return
        source_str = source_file.read()
        total_size = source_file.tell()
        LOG.debug('Parsing config file:' + source_file.name)
        print "Parsing Input Configuration..."
        f5_config_dict, not_supported_list = f5_parser.parse_config(
            source_str, total_size, self.f5_config_version)
        LOG.debug('Config file %s parsed successfully' % source_file.name)
        avi_config_dict = None
        LOG.debug('Parsing defaults files')
        f5_defaults_dict = self.get_default_config(is_download_from_host,
                                                   input_dir)
        # Added to get not supported parse config
        not_supported_list_partition = []
        if partitions:
            partition_conf = {}
            for partition in partitions:
                with open(partition, "r") as p_source_file:
                    p_src_str = p_source_file.read()
                    total_size = p_source_file.tell()
                LOG.debug('Parsing partition config file:' +
                          p_source_file.name)
                print "Parsing Partitions Configuration..."
                partition_dict, not_supported_list = f5_parser.parse_config(
                    p_src_str, total_size, self.f5_config_version)
                LOG.debug(
                    'Config file %s parsed successfully' % p_source_file.name)
                # TO get all not supported configuration.
                not_supported_list_partition = not_supported_list_partition \
                    + not_supported_list
                self.dict_merge(partition_conf, partition_dict)
            self.dict_merge(partition_conf, f5_config_dict)
            f5_config_dict = partition_conf
        # Added not supported parse config to file
        merged_not_supported_list = (not_supported_list +
                                     not_supported_list_partition)
        # Added status of all command that are not supported in parsing.
        for command in merged_not_supported_list:
            d = command.rsplit('/', 1)
            object_type = d[0].rsplit(' ', 1)
            object_name = '%s/%s' % (object_type[-1], d[-1])
            self.conversion_util.add_status_row(object_type[0], '', object_name,
                                                conv_const.STATUS_NOT_SUPPORTED)
        LOG.debug('Defaults files parsed successfully')
        LOG.debug('Conversion started')
        self.dict_merge(f5_defaults_dict, f5_config_dict)
        f5_config_dict = f5_defaults_dict
        report_name = os.path.splitext(os.path.basename(source_file.name))[0]
        avi_config_dict = f5_config_converter.convert(
            f5_config_dict, output_dir, self.vs_state, input_dir,
            self.f5_config_version, self.object_merge_check,
            self.controller_version, report_name, self.prefix,
            self.con_snatpool, user_ignore, self.profile_path,
            self.tenant, self.cloud_name, self.f5_passphrase_file,
            self.vs_level_status, self.vrf, self.segroup, custom_mappings)

        avi_config_dict["META"] = self.meta(self.tenant,
                                            self.controller_version)

        avi_config = self.process_for_utils(avi_config_dict)
        # Check if flag true then skip not in use object
        if self.not_in_use:
            avi_config = wipe_out_not_in_use(avi_config)
        self.write_output(avi_config, output_dir, '%s-Output.json' %
                          report_name)
        # Call to create ansible playbook if create ansible flag set.
        if self.create_ansible:
            avi_traffic = AviAnsibleConverter(
                avi_config, output_dir, self.prefix, self.not_in_use,
                test_vip=self.test_vip, skip_types=self.ansible_skip_types)
            avi_traffic.write_ansible_playbook(
                self.f5_host_ip, self.f5_ssh_user, self.f5_ssh_password, 'f5')
        if self.option == 'auto-upload':
            self.upload_config_to_controller(avi_config)
        print "Total Warning: ", get_count('warning')
        print "Total Errors: ", get_count('error')

    def get_default_config(self, is_download, path):
        """

        :param is_download:
        :param path:
        :return:
        """
        f5_defaults_dict = {}
        if is_download:
            print "Copying Files from Host..."
            with open(path + os.path.sep + "profile_base.conf", "r") as \
                    profile:
                profile_base = profile.read()
                total_size = profile.tell()
            with open(path + os.path.sep + "base_monitors.conf", "r") as \
                    monitor:
                monitor_base = monitor.read()
                total_size_mnt = monitor.tell()
            if self.skip_default_file:
                LOG.warning('Skipped default profile base file : %s\nSkipped '
                            'default monitor base file : %s'
                            % (profile.name, monitor.name))
                return f5_defaults_dict
            profile_dict, not_supported_list = f5_parser.parse_config(
                profile_base, total_size, self.f5_config_version)
            monitor_dict, not_supported_list = f5_parser.parse_config(
                monitor_base, total_size_mnt, self.f5_config_version)
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
                # Added to get directory path.
                dir_path = self.conversion_util.get_project_path()
            with open(dir_path + os.path.sep + "f5_v%s_defaults.conf" %
                      self.f5_config_version, "r") as defaults_file:
                if self.skip_default_file:
                    LOG.warning(
                        'Skipped default file : %s' % defaults_file.name)
                    return f5_defaults_dict
                f5_defaults_dict, not_supported_list = f5_parser.parse_config(
                    defaults_file.read(), defaults_file.tell(),
                    self.f5_config_version)
        return f5_defaults_dict

    def dict_merge(self, dct, merge_dct):
        """
        This method merge the two dicts into one.
        :param dct:
        :param merge_dct:
        :return:
        """
        for k, v in merge_dct.iteritems():
            if (k in dct and isinstance(dct[k], dict) and
                    isinstance(merge_dct[k], dict)):
                self.dict_merge(dct[k], merge_dct[k])
            else:
                dct[k] = merge_dct[k]


if __name__ == "__main__":

    HELP_STR = '''
    Converts F5 Config to avi config.
    Example to convert F5 config file to avi config json:
         f5_converter.py -f bigip.conf

    Example to skip default file in f5:
          f5_converter.py -f bigip.conf --skip_default_file
    Usecase: To skip default profile and monitor configuration

    Example to f5_config_version
       f5_converter.py -f bigip.conf -v 10

    Example to download config from f5 host and convert to avi config:
         f5_converter.py --f5_host_ip "1.1.1.1" --f5_ssh_user
         username --f5_ssh_password password

    Example to auto upload to controller after conversion:
        f5_converter.py -f bigip.conf -O auto-upload -c 2.2.2.2 -u
        username -p password -t tenant

    Example to use -s or --vs_state option:
        f5_converter.py -f bigip.conf -s enable
    Usecase: To enable a VS after conversion to AVI (default value is disable).

    Example to use input file for certs and key
        f5_converter.py -f bigip.conf -l /home/username

    Example to use --controller_version option:
     f5_converter.py -f bigip.conf --controller_version <17.2.3>
    Usecase: To provide the version of controller for getting output in
    respective controller format.

    Example to use ignore config option:
         f5_converter.py -f bigip.conf --ignore_config
    Usecase: The attributes mentioned in ignore_config.yaml will appear in
    ignore column in excel sheet instead of skip. It will need an ignore_config.yaml
    file in the input directory defined by user
    <object example monitor>:
        <property example https>:
        - <attribute example 'destination'>

    Example to use --partition_config option:
       f5_converter.py -f bigip.conf --partition_config /home/username/abc.txt
    Usecase: When auto-download option enable. It download the files from
    different f5 partitions with comma separated path provided with partition
    config option.

    Example to use no object merge option:
        f5_converter.py -f bigip.conf --no_object_merge
    Usecase: When we don't need to merge two same object (based on their
     attribute values except name)

    Example to patch the config after conversion:
       f5_converter.py -f bigip.conf --patch test/patch.yaml
       where patch.yaml file contains
       <avi_object example Pool>:
        - match_name: <existing name example p1>
       patch:
        name: <changed name example coolpool>

    Example to export a single VS:
         f5_converter.py -f bigip.conf --vs_filter cool_vs

    Example to skip avi object during playbook creation
         f5_converter.py -f bigip.conf  --ansible --ansible_skip_types DebugController
    Usecase:
         Comma separated list of Avi Object types to skip during conversion.
         Eg. DebugController, ServiceEngineGroup will skip debugcontroller and
         serviceengine objects

    Example to filter ansible object
         f5_converter.py -f bigip.conf  --ansible --ansible_filter_types
         virtualservice, pool
    Usecase:
        Comma separated list of Avi Objects types to include during conversion.
        Eg. VirtualService , Pool will do ansible conversion only for
        Virtualservice and Pool objects

    Example to use ansible option:
        f5_converter.py -f bigip.conf --ansible
    Usecase: To generate the ansible playbook for the avi configuration
    which can be used for upload to controller

    Example to add the prefix to avi object name:
        f5_converter.py -f bigip.conf --prefix abc
    Usecase: When two configuration is to be uploaded to same controller then
     in order to differentiate between the objects that will be uploaded in
     second time.

    Example to convert snatpool into individual address
     f5_converter.py -f bigip.conf --convertsnat
    Usecase:
        Flag to enable Source Network Address Translation in avi.

    Example to use not_in_use option:
        f5_converter.py -f bigip.conf --not_in_use
    Usecase: Dangling object which are not referenced by any avi object will be removed

    Example to provide baseline json file absolute location:
        f5_converter.py -f bigip.conf --baseline_profile
        /home/<'sys_conf.json' or 'bigip-Output.json'>
     Usecase: Need to merge objects if there is migration of two
     f5 instances/box to single controller.

    Example to provide passpharse of encrypted certs and certkey file location
         f5_converter.py -f bigip.conf -l /home/certs/
         --f5_passphrase_file passphrase.yaml
         passphrase.yaml file contains
          <file_name>:<passphrase>
          <file_name2>:<passphrase2>
          Example:
            mcqcim.key: ZcZawJ7ps0AJ+5TMDi7UA==
            avi_key.pem : foobar

    Example to use vs level status option:
        f5_converter.py -f bigip.conf --vs_level_status
    Usecase: To get the vs level status for the avi objects in excel sheet
    
    Example to use segroup flag
        f5_converter.py -f ns.conf --segroup segroup_name
    UseCase: To add / Change segroup reference of vs

    Example to use vrf flag
        f5_converter.py -f ns.conf --vrf vrf_name
    UseCase: Change all the vrf reference in the configuration while conversion
    '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    # Create Ansible Script based on Flag
    parser.add_argument('--ansible',
                        help='Flag for create ansible file',
                        action='store_true')
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_skip_types',
                        help='Comma separated list of Avi Object types to skip '
                             'during conversion.\n  Eg. -s DebugController,'
                             'ServiceEngineGroup will skip debugcontroller and '
                             'serviceengine objects', default=DEFAULT_SKIP_TYPES)
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_filter_types',
                        help='Comma separated list of Avi Objects types to '
                             'include during conversion.\n Eg. -f '
                             'VirtualService, Pool will do ansible conversion '
                             'only for Virtualservice and Pool objects',
                        default=[])
    # Added args for baseline profile json file
    parser.add_argument('--baseline_profile', help='asolute path for json '
                        'file containing baseline profiles')
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version', default='17.2.1')
    # Added snatpool conversion option
    parser.add_argument('--convertsnat',
                        help='Flag for converting snatpool into '
                             'individual addresses',
                        action="store_true")
    parser.add_argument('--custom_config',
                        help='iRule/monitor custom mapping yml file path')
    parser.add_argument('-f', '--bigip_config_file',
                        help='absolute path for F5 config file')
    parser.add_argument('--f5_host_ip', help='host ip of f5 instance')
    parser.add_argument('--f5_key_file',
                        help='f5 host key file location if key based ' +
                             'authentication')
    parser.add_argument('--f5_passphrase_file',
                        help='F5 key passphrase yaml file path')
    parser.add_argument('--f5_ssh_user', help='f5 host ssh username')
    parser.add_argument('--f5_ssh_password',
                        help='f5 host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--f5_ssh_port',
                        help='f5 host ssh port id non default port is used ',
                        default=22)
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')

    parser.add_argument('-l', '--input_folder_location',
                        help='location of input files like cert files ' +
                             'external monitor scripts', default='./')
    # Changed the command line option to more generic term object
    parser.add_argument('--no_object_merge',
                        help='Flag for object merge', action='store_false')
    # Added not in use flag
    parser.add_argument('--not_in_use',
                        help='Flag for skipping not in use object',
                        action="store_true")
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in',
                        )
    parser.add_argument('-O', '--option', choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config ' +
                             'file auto upload will upload config to ' +
                             'controller', default='cli-upload')
    parser.add_argument('-p', '--password',
                        help='controller password for auto upload',
                        default='avi123')
    parser.add_argument('--partition_config',
                        help='comma separated partition config files')
    # Added command line args to execute config_patch file with related avi
    # json file location and patch location
    parser.add_argument('--patch', help='Run config_patch please provide '
                                        'location of patch.yaml')
    # Added prefix for objects
    parser.add_argument('--prefix', help='Prefix for objects')
    parser.add_argument('--skip_default_file',
                        help='Flag for skip default file', action='store_true')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    # Adding support for test vip
    parser.add_argument('--segroup',
                    help='Update the available segroup ref with the'
                            'custom ref')
    parser.add_argument('-t', '--tenant', help='tenant name for auto upload',
                        default='admin')
    parser.add_argument('--test_vip',
                        help='Enable test vip for ansible generated file '
                        'It will replace the original vip '
                        'Note: The actual ip will vary from input to output'
                        'use it with caution ')
    parser.add_argument('-u', '--user',
                        help='controller username for auto upload',
                        default='admin')
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')
    parser.add_argument('--vrf',
                        help='Update the available vrf ref with the custom vrf'
                             'reference')
    # Added command line args to execute vs_filter.py with vs_name.
    parser.add_argument('--vs_filter', help='comma seperated names of '
                                            'virtualservices')
    parser.add_argument('--vs_level_status', action='store_true',
                        help='Add columns of vs reference and overall skipped '
                             'settings in status excel sheet')

    

    args = parser.parse_args()
    # print avi f5 converter version
    if args.version:
        print "SDK Version: %s\nController Version: %s" % \
              (sdk_version, args.controller_version)
        exit(0)
    f5_converter = F5Converter(args)
    f5_converter.convert()
