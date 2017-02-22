#!/usr/bin/env python
import argparse
import logging
import os
import json

import avi.netscaler_converter.netscaler_parser as ns_parser
import avi.netscaler_converter.netscaler_config_converter as ns_conf_converter
from avi.netscaler_converter import upload_config
import avi.netscaler_converter.scp_util as scp_util

LOG = logging.getLogger(__name__)


def init_logger_path(path):
    LOG.setLevel(logging.DEBUG)
    formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
    logging.basicConfig(filename=os.path.join(path, 'converter.log'),
                        level=logging.DEBUG, format=formatter)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--ns_config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder',
                        default='./test/input_files')
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in',
                        default='output')
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
                        help='Target Avi controller version', default='16.2')
    parser.add_argument('--ns_host_ip', help='host ip of Netscaler instance')
    parser.add_argument('--ns_ssh_user', help='Netscaler host ssh username')
    parser.add_argument('--ns_ssh_password',
                        help='Netscaler host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--ns_key_file',
                        help='Netscaler host key file location if key based ' +
                             'authentication')

    args = parser.parse_args()

    if not os.path.exists(args.output_file_path):
        os.mkdir(args.output_file_path)
    init_logger_path(args.output_file_path)
    input_dir = os.path.normpath(args.input_folder_location)
    output_dir = os.path.normpath(args.output_file_path)
    is_download_from_host = False
    if args.ns_host_ip:
        input_dir = output_dir + os.path.sep + args.ns_host_ip + \
                    os.path.sep + "input"
        if not os.path.exists(input_dir):
            os.makedirs(input_dir)
        output_dir = output_dir + os.path.sep + args.ns_host_ip + \
                     os.path.sep + "output"
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        is_download_from_host = True

    # LOG.info('Avi Build version : %s' % AVI_VERSION)
    # LOG.info('Avi pip version : %s' % AVI_PIP_VERSION)
    if is_download_from_host:
        LOG.debug("Copying files from host")
        scp_util.get_files_from_ns(input_dir, args.ns_host_ip,
                                   args.ns_ssh_user, args.ns_ssh_password)
        LOG.debug("Copied input files")
        source_file = input_dir + os.path.sep + "ns.conf"
    else:
        source_file = args.ns_config_file

    ns_config, skipped_cmds = ns_parser.get_ns_conf_dict(source_file)
    avi_config = ns_conf_converter.convert(ns_config, args.tenant,
                                           args.cloud_name,
                                           args.controller_version, output_dir,
                                           input_dir, skipped_cmds,
                                           args.vs_state)

    if args.option == "cli-upload":
        text_file = open(output_dir + os.path.sep + "Output.json", "w")
        json.dump(avi_config, text_file, indent=4)
        text_file.close()
        LOG.info('written avi config file ' +
                 output_dir + os.path.sep + "Output.json")
    else:
        upload_config.upload_config_to_controller(
            avi_config, args.controller_ip,
            args.user, args.password, args.tenant)