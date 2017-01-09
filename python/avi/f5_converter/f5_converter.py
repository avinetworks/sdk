#!/usr/bin/env python
import argparse
import json
import logging
import os
import sys

from requests.packages import urllib3
from avi.f5_converter import f5_config_converter, \
    f5_parser, upload_config, scp_util, conversion_util

urllib3.disable_warnings()
LOG = logging.getLogger(__name__)


def init_logger_path(path):
    if not os.path.exists(path):
        os.makedirs(path)
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    logging.basicConfig(filename=os.path.join(path, 'converter.log'),
                        level=logging.DEBUG, format=formatter)


def dict_merge(dct, merge_dct):
    for k, v in merge_dct.iteritems():
        if (k in dct and isinstance(dct[k], dict) and
                isinstance(merge_dct[k], dict)):
            dict_merge(dct[k], merge_dct[k])
        else:
            dct[k] = merge_dct[k]


def get_default_config(version, is_download, path, skip_default_file):
    f5_defaults_dict = {}
    if is_download:
        profile_base = open(path+os.path.sep+"profile_base.conf", "r")
        monitor_base = open(path+os.path.sep+"base_monitors.conf", "r")
        if skip_default_file:
            LOG.warning('Skipped default profile base file : %s\nSkipped default monitor base file : %s'
                        % (profile_base.name, monitor_base.name))
            return f5_defaults_dict

        profile_dict = f5_parser.parse_config(profile_base.read(), version)
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
        if version == '12':
            version = '11'
        if getattr(sys, 'frozen', False):
            # running in a exe bundle
            dir_path = os.path.abspath(os.path.dirname(__file__))
        else:
            # running from source
            dir_path = conversion_util.get_project_path()

        defaults_file = open(dir_path+os.path.sep+"f5_v%s_defaults.conf" %
                             version, "r")
        if skip_default_file:
            LOG.warning('Skipped default file : %s' % defaults_file.name)
            return f5_defaults_dict

        f5_defaults_dict = f5_parser.parse_config(defaults_file.read(), version)

    return f5_defaults_dict


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--bigip_config_file',
                        help='absolute path for F5 config file')
    parser.add_argument('--skip_default_file',
                        help='Falg for skip default file', default=False)
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
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
    parser.add_argument('--ignore_config',
                        help='config json to skip the config in conversion')
    parser.add_argument('--partition_config',
                        help='comma separated partition config files')

    args = parser.parse_args()
    tenant = args.tenant
    init_logger_path(args.output_file_path)
    if not os.path.exists(args.output_file_path):
        os.mkdir(args.output_file_path)
    output_dir = os.path.normpath(args.output_file_path)
    input_dir = os.path.normpath(args.input_folder_location)
    is_download_from_host = False
    if args.f5_host_ip:
        input_dir = output_dir + os.path.sep + args.f5_host_ip + \
                    os.path.sep + "input"
        if not os.path.exists(input_dir):
            os.makedirs(input_dir)
        output_dir = output_dir + os.path.sep + args.f5_host_ip + \
                     os.path.sep + "output"
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        is_download_from_host = True
    user_ignore = {}
    if args.ignore_config:
        ignore_conf_file = open(args.ignore_config, "r")
        ignore_conf_str = ignore_conf_file.read()
        user_ignore = json.loads(ignore_conf_str)

    partitions = []
    #LOG.info('Avi Build version : %s' % AVI_VERSION)
    #LOG.info('Avi pip version : %s' % AVI_PIP_VERSION)
    if args.partition_config:
        partitions = args.partition_config.split(',')

    if is_download_from_host:
        LOG.debug("Copying files from host")
        scp_util.get_files_from_f5(input_dir, args.f5_host_ip,
                                   args.f5_ssh_user, args.f5_ssh_password)
        LOG.debug("Copied input files")
        source_file = open(input_dir + os.path.sep + "bigip.conf", "r")
        files = os.listdir(input_dir)
        for f in files:
            if f.endswith('_bigip.conf'):
                partitions.append(input_dir + os.path.sep + f)
    else:
        source_file = open(args.bigip_config_file, "r")
    source_str = source_file.read()
    LOG.debug('Parsing config file:'+source_file.name)
    f5_config_dict = f5_parser.parse_config(source_str, args.f5_config_version)
    LOG.debug('Config file %s parsed successfully' % source_file.name)
    avi_config_dict = None
    LOG.debug('Parsing defaults files')
    f5_defaults_dict = get_default_config(args.f5_config_version,
                                          is_download_from_host,
                                          input_dir, bool(args.skip_default_file))
    if partitions:
        partition_conf = {}
        for partition in partitions:
            p_source_file = open(partition, "r")
            p_src_str = p_source_file.read()
            LOG.debug('Parsing partition config file:'+p_source_file.name)
            partition_dict = f5_parser.parse_config(
                p_src_str, args.f5_config_version)
            LOG.debug('Config file %s parsed successfully' % p_source_file.name)
            dict_merge(partition_conf, partition_dict)
        dict_merge(partition_conf, f5_config_dict)
        f5_config_dict = partition_conf

    LOG.debug('Defaults files parsed successfully')
    LOG.debug('Conversion started')
    dict_merge(f5_defaults_dict, f5_config_dict)
    f5_config_dict = f5_defaults_dict
    avi_config_dict = f5_config_converter.\
        convert(f5_config_dict, output_dir, args.vs_state,
                input_dir, args.f5_config_version, user_ignore, tenant)

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

    text_file = open(output_dir + os.path.sep + "Output.json", "w")
    json.dump(avi_config_dict, text_file, indent=4)
    text_file.close()
    LOG.info('written avi config file ' + output_dir + os.path.sep +
             "Output.json")

    if args.option == "auto-upload":
        upload_config.upload_config_to_controller(
            avi_config_dict, args.controller_ip,
            args.user, args.password, args.tenant)
