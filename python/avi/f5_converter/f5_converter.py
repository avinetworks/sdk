#!/usr/bin/env python
import argparse
import json
import logging
import os

from requests.packages import urllib3

from avi.f5_converter import f5_config_converter_v11, \
    f5_config_converter_v10, f5_parser, upload_config, scp_util

urllib3.disable_warnings()


def dict_merge(dct, merge_dct):
    for k, v in merge_dct.iteritems():
        if (k in dct and isinstance(dct[k], dict) and
                isinstance(merge_dct[k], dict)):
            dict_merge(dct[k], merge_dct[k])
        else:
            dct[k] = merge_dct[k]


def get_default_config(version, is_download, path):
    if is_download:
        profile_base = open(path+os.path.sep+"profile_base.conf", "r")
        profile_dict = f5_parser.parse_config(profile_base.read(), version)
        monitor_base = open(path+os.path.sep+"base_monitors.conf", "r")
        monitor_dict = f5_parser.parse_config(monitor_base.read(), version)
        if int(version) == 10:
            default_mon = monitor_dict.get("monitor", {})
            root_mon = monitor_dict["monitorroot"]
            for key in root_mon.keys():
                default_mon[key.replace("type ", "")] = root_mon[key]
            monitor_dict["monitor"] = default_mon
            del monitor_dict["monitorroot"]
        profile_dict.update(monitor_dict)
        f5_defaults_dict = profile_dict
    else:
        dir_path = os.path.abspath(os.path.dirname(__file__))
        defaults_file = open(dir_path+os.path.sep+"f5_v%s_defaults.conf" %
                             version, "r")
        f5_defaults_dict = f5_parser.parse_config(defaults_file.read(), version)
    return f5_defaults_dict


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--bigip_config_file',
                        help='absolute path for F5 config file')
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default=11)
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
    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of input files like cert files ' +
                             'external monitor scripts', default='./test/certs')
    parser.add_argument('--f5_host_ip', help='host ip of f5 instance')
    parser.add_argument('--f5_ssh_user', help='f5 host ssh username')
    parser.add_argument('--f5_ssh_password',
                        help='f5 host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--f5_key_file',
                        help='f5 host key file location if key based ' +
                             'authentication')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version', default='16.2')

    args = parser.parse_args()
    if not os.path.exists(args.output_file_path):
        os.mkdir(args.output_file_path)
    output_file_path = os.path.normpath(args.output_file_path)
    input_folder_location = os.path.normpath(args.input_folder_location)
    is_download_from_host = False
    if args.f5_host_ip:
        input_folder_location = output_file_path+os.path.sep+args.f5_host_ip + \
                          os.path.sep+"input"
        if not os.path.exists(input_folder_location):
            os.makedirs(input_folder_location)
        output_file_path = output_file_path+os.path.sep+args.f5_host_ip + \
                           os.path.sep+"output"
        if not os.path.exists(output_file_path):
            os.makedirs(output_file_path)
        is_download_from_host = True

    LOG = logging.getLogger("converter-log")
    LOG.setLevel(logging.DEBUG)
    fh = logging.FileHandler(output_file_path + os.path.sep + "converter.log",
                             mode='a', encoding=None, delay=False)
    fh.setLevel(logging.DEBUG)
    formatter = logging.Formatter(
        '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)
    LOG.addHandler(fh)
    if is_download_from_host:
        LOG.debug("Copying files from host")
        scp_util.get_files_from_f5(input_folder_location, args.f5_host_ip,
                                   args.f5_ssh_user, args.f5_ssh_password)
        LOG.debug("Copied input files")
        source_file = open(input_folder_location+os.path.sep+"bigip.conf", "r")
    else:
        source_file = open(args.bigip_config_file, "r")
    source_str = source_file.read()
    LOG.debug('Parsing config file:'+source_file.name)
    f5_config_dict = f5_parser.parse_config(source_str, args.f5_config_version)
    LOG.debug('Config file parsed successfully')
    avi_config_dict = None
    LOG.debug('Parsing defaults files')
    f5_defaults_dict = get_default_config(args.f5_config_version,
                                          is_download_from_host,
                                          input_folder_location)
    LOG.debug('Defaults files parsed successfully')
    LOG.debug('Conversion started')
    dict_merge(f5_defaults_dict, f5_config_dict)
    f5_config_dict = f5_defaults_dict
    if int(args.f5_config_version) == 11:
        avi_config_dict = f5_config_converter_v11.\
            convert_to_avi_dict(f5_config_dict, output_file_path, args.vs_state,
                                input_folder_location, args.option)
    elif int(args.f5_config_version) == 10:
        avi_config_dict = f5_config_converter_v10.\
            convert_to_avi_dict(f5_config_dict, output_file_path, args.vs_state,
                                input_folder_location, args.option)


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
            "Version": args.controller_version,
            "min_version": 15.2,
            "ProductName": "Avi Cloud Controller"
        },
        "upgrade_mode": False,
        "use_tenant": args.tenant
    }
    text_file = open(output_file_path+os.path.sep+"Output.json", "w")
    json.dump(avi_config_dict, text_file, indent=4)
    text_file.close()
    if args.option == "cli-upload":
        LOG.info('written avi config file ' +
                 output_file_path+os.path.sep+"Output.json")
    else:
        upload_config.upload_config_to_controller(
            avi_config_dict, args.controller_ip,
            args.user, args.password, args.tenant)
        # LOG.info('Config uploaded to controller')
