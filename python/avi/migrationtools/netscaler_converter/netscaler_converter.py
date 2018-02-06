#!/usr/bin/env python
import argparse
import logging
import os
import sys
import json
import yaml
import avi.migrationtools
import avi.migrationtools.netscaler_converter.netscaler_config_converter \
    as ns_conf_converter
import avi.migrationtools.netscaler_converter.netscaler_parser as ns_parser
import avi.migrationtools.netscaler_converter.scp_util as scp_util
from avi.migrationtools.ansible.ansible_config_converter import AviAnsibleConverter
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.avi_orphan_object import wipe_out_not_in_use
from avi.migrationtools.ansible.ansible_config_converter import\
    AviAnsibleConverter

LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)

DEFAULT_SKIP_TYPES = [
    'SystemConfiguration', 'Network', 'debugcontroller', 'VIMgrVMRuntime',
    'VIMgrIPSubnetRuntime', 'Alert', 'VIMgrSEVMRuntime', 'VIMgrClusterRuntime',
    'VIMgrHostRuntime', 'DebugController', 'ServiceEngineGroup',
    'SeProperties', 'ControllerProperties', 'CloudProperties']


class NetscalerConverter(AviConverter):
    def __init__(self, args):
        self.ns_config_file = args.ns_config_file
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
        self.ns_host_ip = args.ns_host_ip
        self.ns_ssh_user = args.ns_ssh_user
        self.ns_ssh_password = args.ns_ssh_password
        self.ns_key_file = args.ns_key_file
        self.ns_passphrase_file = args.ns_passphrase_file
        self.version = args.version
        self.object_merge_check = args.no_object_merge
        # config_patch.py args taken into class variable
        self.patch = args.patch
        # vs_filter.py args taken into classs variable
        self.vs_filter = args.vs_filter
        self.ignore_config = args.ignore_config
        # Added prefix for objects
        self.prefix = args.prefix
        # Added not in use flag
        self.not_in_use = args.not_in_use
        # Added args for baseline profile json file
        self.profile_path = args.baseline_profile
        # Added args for redirecting http vs to https vs
        self.redirect = args.redirect
        # for ansible
        self.create_ansible = args.ansible
        self.vs_level_status = args.vs_level_status
        # Added ansible flag
        self.ansible_skip_types = args.ansible_skip_types
        self.ansible_filter_types = args.ansible_filter_types
        # Test Vip
        self.test_vip = args.test_vip
        # vrf and segroup
        self.vrf = args.vrf
        self.segroup = args.segroup

    def convert(self):
        if not os.path.exists(self.output_file_path):
            os.mkdir(self.output_file_path)
        self.init_logger_path()
        input_dir = os.path.normpath(self.input_folder_location)
        output_dir = os.path.normpath(self.output_file_path)
        is_download_from_host = False
        if self.ns_host_ip:
            input_dir = output_dir + os.path.sep + self.ns_host_ip + \
                os.path.sep + "input"
            if not os.path.exists(input_dir):
                os.makedirs(input_dir)
            output_dir = output_dir + os.path.sep + self.ns_host_ip + \
                os.path.sep + "output"
            if not os.path.exists(output_dir):
                os.makedirs(output_dir)
            is_download_from_host = True

        self.print_pip_and_controller_version()
        # print the arguments in input
        LOG.info("Input parameters: %s" % ' '.join(sys.argv))

        if is_download_from_host:
            LOG.debug("Copying files from host")
            print "Copying Files from Host..."
            scp_util.get_files_from_ns(input_dir, self.ns_host_ip,
                                       self.ns_ssh_user, self.ns_ssh_password)
            LOG.debug("Copied input files")
            source_file = input_dir + os.path.sep + "ns.conf"
        else:
            source_file = self.ns_config_file
        if not source_file:
            print 'Not found ns configuration file'
            return
        ns_config, skipped_cmds = ns_parser.get_ns_conf_dict(source_file)
        user_ignore = {}
        # Read the attributes for user ignore val
        if self.ignore_config:
            with open(self.ignore_config) as stream:
                user_ignore = yaml.safe_load(stream)
        # getting meta tag from superclass
        meta = self.meta(self.tenant, self.controller_version)
        report_name = os.path.splitext(os.path.basename(source_file))[0]
        # Added dict for collecting vs for netscaler.
        vs_name_dict = dict()
        vs_name_dict['csvs'] = dict()
        vs_name_dict['lbvs'] = dict()
        avi_config = ns_conf_converter.convert(meta, ns_config, self.tenant,
                                               self.cloud_name, self.controller_version, output_dir,
                                               input_dir, skipped_cmds, self.vs_state,
                                               self.object_merge_check, report_name, self.prefix,
                                               vs_name_dict, self.profile_path, self.redirect,
                                               self.ns_passphrase_file, user_ignore, self.vs_level_status,
                                               self.vrf, self.segroup)
        avi_config = self.process_for_utils(
            avi_config)
        # Check if flag true then skip not in use object
        if self.not_in_use:
            avi_config = wipe_out_not_in_use(avi_config)
        self.write_output(
            avi_config, output_dir, '%s-Output.json' % report_name)
        if self.create_ansible:
            avi_traffic = AviAnsibleConverter(
                avi_config, output_dir, self.prefix, self.not_in_use,
                ns_vs_name_dict=vs_name_dict, test_vip=self.test_vip,
                skip_types=self.ansible_skip_types)
            avi_traffic.write_ansible_playbook(
                self.ns_host_ip, self.ns_ssh_user, self.ns_ssh_password,
                'netscaler'
            )
        if self.option == 'auto-upload':
            self.upload_config_to_controller(avi_config)
        return avi_config


if __name__ == "__main__":

    HELP_STR = '''
        Converts Netscaler Config to Avi config.
        Example to convert Netscaler config file to avi config json:
            netscaler_converter.py -f ns.conf

        Example to export a single VS:
            netscaler_converter.py -f ns.conf --vs_filter cool_vs

        Example to download config from Netscalet host and convert to avi config:
            netscaler_converter.py --ns_host_ip "1.1.1.1" --ns_ssh_user
            username --ns_ssh_password password

        Example to auto upload to controller after conversion:
            netscaler_converter.py -f ns.conf -O auto-upload -c 2.2.2.2 -u
            username -p password -t tenant

        Example to provide passpharse of encrypted certs and certkey file
        location
            netscaler_converter.py -f ns.conf -l /home/certs/
            --ns_passphrase_file passphrase.yaml
            passphrase.yaml file contains
            <file_name>:<passphrase>
            <file_name2>:<passphrase2>
            Example:
            mcqcim.key: ZcZawJ7ps0AJ+5TMDi7UA==
            avi_key.pem : foobar
            
        Example to provide baseline json file absolute location:
            netscaler_converter.py -f ns.conf --baseline_profile 
            /home/<'sys_conf.json' or 'ns-Output.json'>
        Usecase: Need to merge objects if there is migration of two netscaler
                 instances/box to single controller.
        
        Example to patch the config after conversion:
          netscaler_converter.py -f ns.conf --patch test/patch.yaml

        Example to use segroup flag 
            netscalar_converter.py -f ns.conf --segroup segroup_name
        UseCase: To add / Change segroup reference of vs

        Example to use vrf flag
            netscalar_converter.py -f ns.conf --vrf vrf_name
        UseCase: Change all the vrf reference in the configuration while conversion
        '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    # Ansible tags
    parser.add_argument('--ansible', help='Flag for create ansible file',
                        action="store_true")
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_skip_types',
                        help='Comma separated list of Avi Object types to skip '
                             'during conversion.\n  Eg. -s DebugController,'
                             'ServiceEngineGroup will skip debugcontroller and '
                             'serviceengine objects',
                        default=DEFAULT_SKIP_TYPES)
    # Added command line args to take skip type for ansible playbook
    parser.add_argument('--ansible_filter_types',
                        help='Comma separated list of Avi Objects types to '
                             'include during conversion.\n Eg. -f '
                             'VirtualService, Pool will do ansible conversion '
                             'only for Virtualservice and Pool objects',
                        default=[])
    # Added args for baseline profile json file
    parser.add_argument('--baseline_profile', help='absolute path for json '
                        'file containing baseline profiles')
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version',
                        default='17.1.1')
    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')
    parser.add_argument('-f', '--ns_config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder',
                        default='netscaler_converter/test/certs')
    # Changed the option name and description to generic as along with profile
    # health monitor can also be merged
    parser.add_argument('--no_object_merge',
                        help='Flag for object merge', action='store_false')
    # Added not in use flag
    parser.add_argument('--not_in_use',
                        help='Flag for skipping not in use object',
                        action="store_true")
    parser.add_argument('--ns_key_file',
                        help='Netscaler host key file location if key based '
                             'authentication')
    parser.add_argument('--ns_passphrase_file',
                        help='Netscaler key passphrase yaml file')
    parser.add_argument('--ns_host_ip',
                        help='host ip of Netscaler instance')                        
    parser.add_argument('--ns_ssh_user', help='Netscaler host ssh username')
    parser.add_argument('--ns_ssh_password',
                        help='Netscaler host ssh password if password based '
                             'authentication')                             
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in')
    parser.add_argument('-O', '--option',
                        choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config '
                             'file auto upload will upload config to '
                             'controller', default='cli-upload')
    parser.add_argument('-p', '--password',
                        help='controller password for auto upload',
                        default='avi123')
    # Added command line args to execute config_patch file with related avi
    # json file location and patch location
    parser.add_argument('--patch', help='Run config_patch please provide '
                                        'location of patch.yaml')
    # Added prefix for objects
    parser.add_argument('--prefix', help='Prefix for objects')
    # Added args for redirecting http vs to https vs
    parser.add_argument('--redirect', help='redirect http vs to https vs if '
                        'there is no pool assigned', action="store_true")
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('--segroup',
                        help='Update the available segroup ref with the'
                             'custom ref')
    parser.add_argument('-t', '--tenant',
                        help='tenant name for auto upload',
                        default='admin')
    # Adding support for test vip
    parser.add_argument('--test_vip',
                        help='Enable test vip for ansible generated file '
                        'It will replace the original vip '
                        'Note: The actual ip will vary from input to output'
                        'use it with caution ')
    parser.add_argument('-u', '--user',
                        help='controller username for auto upload',
                        default='admin')
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')
    # Support for vrf and segroups
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
    netscaler_converter = NetscalerConverter(args)
    # print avi netscaler converter version
    if args.version:
        netscaler_converter.print_pip_and_controller_version()
        exit(0)
    netscaler_converter.convert()
