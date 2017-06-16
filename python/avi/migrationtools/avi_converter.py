from avi.migrationtools.config_patch import ConfigPatch
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools import avi_rest_lib
import yaml
import json
import logging
import os

LOG = logging.getLogger(__name__)

class AviConverter(object):
    def init_logger_path(self):
        pass

    def print_pip_and_controller_version(self):
        pass

    def convert(self):
        pass

    def upload_config_to_controller(self):
        pass

    def process_for_utils(self, avi_config):
        """
        Check if patch args present then execute the config_patch.py with args
        :param avi_config: converted avi object dict
        :return: avi_config
        """

        if self.patch:
            with open(self.patch) as f:
                patches = yaml.load(f)
            cp = ConfigPatch(avi_config, patches)
            avi_config = cp.patch()
        # Check if vs_filter args present then execute vs_filter.py with args
        if self.vs_filter:
            avi_config = filter_for_vs(avi_config, self.vs_filter)
        return avi_config


    def upload_config_to_controller(self, avi_config):
        """
        Upload configuration to controller
        :param avi_config: converted avi object dict
        :return:
        """

        avi_rest_lib.upload_config_to_controller(
            avi_config, self.controller_ip, self.user, self.password,
            self.tenant, self.controller_version)

    def write_output(self, avi_config, output_dir, report_name):
        """
        write output file for conversion
        :param avi_config: dict of converted avi object
        :param output_dir: location for output file
        :param report_name: name of file
        :param prefix: prefix for object
        :return: None
        """

        report_path = output_dir + os.path.sep + report_name
        with open(report_path, "w") as text_file:
            json.dump(avi_config, text_file, indent=4)
        LOG.info('written avi config file %s' % report_path)
