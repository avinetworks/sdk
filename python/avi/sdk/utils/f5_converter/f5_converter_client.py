import argparse
import json
import logging
import os

import f5_config_converter
import f5_parser
import upload_config
from requests.packages import urllib3

urllib3.disable_warnings()

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--bigip_config_file',
                        help='F5 config file location')
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config', default=11)
    parser.add_argument('-o', '--output_file_path',
                        help='output file path', default='output')
    parser.add_argument('-O', '--option', choices=['cli-upload', 'api-upload'],
                        help='Output option', default='cli-upload')
    parser.add_argument('-u', '--user', help='controller user', default='admin')
    parser.add_argument('-p', '--password', help='controller user password',
                        default='avi123')
    parser.add_argument('-t', '--tenant', help='tenant name', default='admin')
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of created VS', default='disable')
    parser.add_argument('-l', '--certs_location',
                        help='location of cert files', default='.')

    args = parser.parse_args()

    output_file_path = os.path.normpath(args.output_file_path)
    certs_location = os.path.normpath(args.certs_location)

    LOG = logging.getLogger("converter-log")
    LOG.setLevel(logging.DEBUG)
    fh = logging.FileHandler(args.output_file_path +
                             os.path.sep + "converter.log",
                             mode='a', encoding=None, delay=False)
    fh.setLevel(logging.DEBUG)
    formatter = logging.Formatter(
        '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)
    LOG.addHandler(fh)

    source_file = open(args.bigip_config_file, "r")
    source_str = source_file.read()
    LOG.debug('Reading source file:'+source_file.name)
    f5_config_dict = f5_parser.parse_config(source_str,
                                            output_file_path, 11)
    LOG.debug('File Parsed successfully')
    avi_config_dict = f5_config_converter.\
        convert_to_avi_dict(f5_config_dict, output_file_path, args.vs_state,
                            certs_location, args.tenant, args.option)
    LOG.debug('Conversion started')
    if args.option == "cli-upload":
        avi_config_dict["META"] = {
        "supported_migrations": {
            "versions": [
                "14_2",
                "15_1",
                "15_1_1",
                "15_2",
                "15_2_3",
                "15_3",
                "current_version"
            ]
        },
        "version": {
            "Product": "controller",
            "Version": "16.1",
            "min_version": 15.2,
            "ProductName": "Avi Cloud Controller"
        },
        "upgrade_mode": False,
        "use_tenant": args.tenant
        }
        text_file = open(output_file_path+os.path.sep+"Output.json", "w")
        json.dump(avi_config_dict, text_file, indent=4)
        text_file.close()
        LOG.info('writtent avi config file '+
                 output_file_path+os.path.sep+"Output.json")
    else:
        text_file = open(output_file_path+"Output.json", "w")
        json.dump(avi_config_dict, text_file, indent=4)
        text_file.close()
        upload_config.upload_config_to_controller\
            (avi_config_dict, args.controller_ip, args.user,
             args.password, args.tenant)
        LOG.info('Config uploaded to controller')












