#!/usr/bin/env python
import argparse
import avi.migrationtool

from avi.migrationtool.f5_converter.f5_converter import F5Converter
from avi.migrationtool.netscaler_converter.netscaler_converter \
    import NetscalerConverter


sdk_version = getattr(avi.migrationtool, '__version__', None)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('--skip_default_file',
                        help='Falg for skip default file', default=False)
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder',
                        default='./test/certs')
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in')
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
    parser.add_argument('-t', '--tenant', help='tenant name for auto upload',
                        default='admin')
    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version', default='16.3')
    parser.add_argument('--host_ip', help='host ip of instance')
    parser.add_argument('--host_ssh_user', help='Host ssh username')
    parser.add_argument('--host_ssh_password',
                        help='Host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--host_key_file',
                        help='Host key file location if key based ' +
                             'authentication')
    parser.add_argument('--ns_passphrase_file',
                        help='Netscaler key passphrase yaml file')
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')
    parser.add_argument('--partition_config',
                        help='comma separated partition config files')
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')
    parser.add_argument('--type', choices=['f5', 'netscaler'],
                        help='Config converter Type ', default='netscaler')

    args = parser.parse_args()
    if args.version:
        print "SDK Version: %s\nController Version: %s" % \
              (sdk_version, args.controller_version)
        exit(0)
    if args.type == 'f5':
        f5_converter = F5Converter(args)
        f5_converter.convert()
    elif args.type == 'netscaler':
        netscaler_converter = NetscalerConverter(args)
        netscaler_converter.convert()
