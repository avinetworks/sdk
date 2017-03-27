#!/usr/bin/env python
import argparse
import json
import logging
import os
import sys

from requests.packages import urllib3
from avi.migrationtool.f5_converter import (f5_config_converter,
                                            f5_parser, scp_util,
                                            conversion_util)
from avi.migrationtool.utils import avi_rest_lib
from avi.migrationtool import __version__

# urllib3.disable_warnings()
LOG = logging.getLogger(__name__)


class F5Converter():
    def __init__(self, args):
        self.bigip_config_file = args.config_file
        self.skip_default_file = args.skip_default_file
        self.f5_config_version = args.f5_config_version
        self.input_folder_location = args.input_folder_location
        self.output_file_path = args.output_file_path if args.output_file_path \
            else 'f5_converter/output'
        self.option = args.option
        self.user = args.user
        self.password = args.password
        self.controller_ip = args.controller_ip
        self.tenant = args.tenant
        self.cloud_name = args.cloud_name
        self.vs_state = args.vs_state
        self.controller_version = args.controller_version
        self.f5_host_ip = args.host_ip
        self.f5_ssh_user = args.host_ssh_user
        self.f5_ssh_password = args.host_ssh_password
        self.f5_key_file = args.host_key_file
        self.f5_passphrase_file = args.ns_passphrase_file
        self.ignore_config = args.ignore_config
        self.partition_config = args.partition_config
        self.version = args.version

    def init_logger_path(self):
        LOG.setLevel(logging.DEBUG)
        formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
        logging.basicConfig(filename=os.path.join(self.output_file_path, 'converter.log'),
                            level=logging.DEBUG, format=formatter)

    def print_pip_and_controller_version(self):
        # Add logger and print avi netscaler converter version
        LOG.info('AVI sdk version: %s Controller Version: %s'
                 % (__version__, self.controller_version))
        print 'AVI sdk version: %s Controller Version: %s' \
              % (__version__, self.controller_version)

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
        if self.ignore_config:
            ignore_conf_file = open(self.ignore_config, "r")
            ignore_conf_str = ignore_conf_file.read()
            user_ignore = json.loads(ignore_conf_str)

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
        else:
            source_file = open(self.bigip_config_file, "r")
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
                p_source_file = open(partition, "r")
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
        avi_config_dict = f5_config_converter. \
            convert(f5_config_dict, output_dir, self.vs_state, input_dir,
                    self.f5_config_version, user_ignore, self.tenant,
                    self.cloud_name)

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
                "Version": self.controller_version,
                "min_version": 15.2,
                "ProductName": "Avi Cloud Controller"
            },
            "upgrade_mode": False,
            "use_tenant": self.tenant
        }

        text_file = open(output_dir + os.path.sep + "Output.json", "w")
        json.dump(avi_config_dict, text_file, indent=4)
        text_file.close()
        LOG.info('written avi config file ' + output_dir + os.path.sep +
                 "Output.json")
        if self.option == "auto-upload":
            self.upload_config_to_controller(avi_config_dict)

    def get_default_config(self, is_download, path):
        f5_defaults_dict = {}
        if is_download:
            profile_base = open(path + os.path.sep + "profile_base.conf", "r")
            monitor_base = open(path + os.path.sep + "base_monitors.conf", "r")
            if bool(self.skip_default_file):
                LOG.warning('Skipped default profile base file : %s\nSkipped '
                            'default monitor base file : %s'
                            % (profile_base.name, monitor_base.name))
                return f5_defaults_dict

            profile_dict = f5_parser.parse_config(profile_base.read(),
                                                  self.f5_config_version)
            monitor_dict = f5_parser.parse_config(monitor_base.read(),
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

            defaults_file = open(
                dir_path + os.path.sep + "f5_v%s_defaults.conf" %
                self.f5_config_version, "r")
            if bool(self.skip_default_file):
                LOG.warning('Skipped default file : %s' % defaults_file.name)
                return f5_defaults_dict

            f5_defaults_dict = f5_parser.parse_config(defaults_file.read(),
                                                      self.f5_config_version)

        return f5_defaults_dict

    def dict_merge(self, dct, merge_dct):
        for k, v in merge_dct.iteritems():
            if (k in dct and isinstance(dct[k], dict) and
                    isinstance(merge_dct[k], dict)):
                self.dict_merge(dct[k], merge_dct[k])
            else:
                dct[k] = merge_dct[k]