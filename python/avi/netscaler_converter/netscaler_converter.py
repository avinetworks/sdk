import argparse
import logging
import os

import avi.netscaler_converter.netscaler_parser as ns_parser
import avi.netscaler_converter.netscaler_config_converter as ns_conf_converter


LOG = logging.getLogger(__name__)


def init_logger_path(path):
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    logging.basicConfig(filename=os.path.join(path, 'converter.log'),
                        level=logging.DEBUG, format=formatter)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--ns_config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder')
    parser.add_argument('-o', '--output_file_path',
                        help='Folder path for output files to be created in',
                        default='./output')
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
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version', default='16.2')

    args = parser.parse_args()
    if not os.path.exists(args.output_file_path):
        os.mkdir(args.output_file_path)
    init_logger_path(args.output_file_path)
    output_dir = os.path.normpath(args.output_file_path)
    ns_config = ns_parser.get_ns_conf_dict(args.ns_config_file)
    avi_config = ns_conf_converter.convert(ns_config, args.tenant,
                                           args.controller_version)