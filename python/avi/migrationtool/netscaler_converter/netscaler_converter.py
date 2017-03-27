#!/usr/bin/env python
import argparse
import logging
import os
import json
import avi.migrationtool
import avi.migrationtool.netscaler_converter.netscaler_parser as ns_parser
import avi.migrationtool.netscaler_converter.netscaler_config_converter \
    as ns_conf_converter
import avi.migrationtool.netscaler_converter.scp_util as scp_util

from avi.migrationtool import avi_rest_lib
from avi.migrationtool.avi_converter import AviConverter

LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtool, '__version__', None)


class NetscalerConverter(AviConverter):
    def __init__(self, args):
        self.ns_config_file = args.config_file
        self.input_folder_location = args.input_folder_location
        self.output_file_path = args.output_file_path if args.output_file_path \
            else 'netscaler_converter/output'
        self.option = args.option
        self.user = args.user
        self.password = args.password
        self.controller_ip = args.controller_ip
        self.tenant = args.tenant
        self.cloud_name = args.cloud_name
        self.vs_state = args.vs_state
        self.controller_version = args.controller_version
        self.ns_host_ip = args.host_ip
        self.ns_ssh_user = args.host_ssh_user
        self.ns_ssh_password = args.host_ssh_password
        self.ns_key_file = args.host_key_file
        self.ns_passphrase_file = args.ns_passphrase_file
        self.version = args.version

    def init_logger_path(self):
        LOG.setLevel(logging.DEBUG)
        formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
        logging.basicConfig(filename=os.path.join(self.output_file_path, 'converter.log'),
                            level=logging.DEBUG, format=formatter)

    def print_pip_and_controller_version(self):
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
        ns_config, skipped_cmds = ns_parser.get_ns_conf_dict(source_file)
        avi_config = ns_conf_converter.convert(ns_config, self.tenant,
                                               self.cloud_name,
                                               self.controller_version,
                                               output_dir,
                                               input_dir, skipped_cmds,
                                               self.vs_state,
                                               self.ns_passphrase_file)
        self.upload_config_to_controller(output_dir, avi_config)

    def upload_config_to_controller(self, output_dir, avi_config):
        if self.option == "cli-upload":
            text_file = open(output_dir + os.path.sep + "Output.json", "w")
            json.dump(avi_config, text_file, indent=4)
            text_file.close()
            LOG.info('written avi config file ' +
                     output_dir + os.path.sep + "Output.json")
        else:
            avi_rest_lib.upload_config_to_controller(
                avi_config, self.controller_ip, self.user, self.password,
                self.tenant)

