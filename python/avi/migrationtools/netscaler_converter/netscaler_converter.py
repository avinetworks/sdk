#!/usr/bin/env python
import argparse
import logging
import os
import sys
import json
import yaml
import avi.migrationtools
import avi.migrationtools.netscaler_converter.netscaler_parser as ns_parser
import avi.migrationtools.netscaler_converter.netscaler_config_converter \
    as ns_conf_converter
import avi.migrationtools.netscaler_converter.scp_util as scp_util

from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools.config_patch import ConfigPatch

LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)


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
        self.profile_merge_check = args.no_profile_merge
        # config_patch.py args taken into class variable
        self.patch = args.patch
        # vs_filter.py args taken into classs variable
        self.vs_filter = args.vs_filter
        self.ignore_config = args.ignore_config
        # Added prefix for objects
        self.prefix = args.prefix

    def init_logger_path(self):
        LOG.setLevel(logging.DEBUG)
        formatter = \
            '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
        if self.ns_config_file:
            report_name = '%s-converter.log' % os.path.splitext(
                os.path.basename(self.ns_config_file))[0]
        else:
            report_name = 'converter.log'

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
        if is_download_from_host:
            LOG.debug("Copying files from host")
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
        report_name = os.path.splitext(os.path.basename(source_file))[0]
        avi_config = ns_conf_converter.convert(
            ns_config, self.tenant, self.cloud_name, self.controller_version,
            output_dir, input_dir, skipped_cmds, self.vs_state,
            self.profile_merge_check, report_name, self.prefix,
            self.ns_passphrase_file, user_ignore)

        avi_config = self.process_for_utils(
            avi_config)
        self.write_output(
            avi_config, output_dir, '%s-Output.json' % report_name)
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

        '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    parser.add_argument('-f', '--ns_config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder',
                        default='netscaler_converter/test/certs')
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in')
    parser.add_argument('-O', '--option',
                        choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config '
                             'file auto upload will upload config to '
                             'controller', default='cli-upload')
    parser.add_argument('-u', '--user',
                        help='controller username for auto upload',
                        default='admin')
    parser.add_argument('-p', '--password',
                        help='controller password for auto upload',
                        default='avi123')
    parser.add_argument('-t', '--tenant',
                        help='tenant name for auto upload',
                        default='admin')
    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version',
                        default='17.1.1')
    parser.add_argument('--ns_host_ip',
                        help='host ip of Netscaler instance')
    parser.add_argument('--ns_ssh_user', help='Netscaler host ssh username')
    parser.add_argument('--ns_ssh_password',
                        help='Netscaler host ssh password if password based '
                             'authentication')
    parser.add_argument('--ns_key_file',
                        help='Netscaler host key file location if key based '
                             'authentication')
    parser.add_argument('--ns_passphrase_file',
                        help='Netscaler key passphrase yaml file')
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
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')
    # Added prefix for objects
    parser.add_argument('--prefix', help='Prefix for objects')

    args = parser.parse_args()
    # print avi netscaler converter version
    if args.version:
        print "SDK Version: %s\nController Version: %s" % \
              (sdk_version, args.controller_version)
        exit(0)
    netscaler_converter = NetscalerConverter(args)
    netscaler_converter.convert()
