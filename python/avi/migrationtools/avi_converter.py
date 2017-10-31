from pkg_resources import parse_version
from avi.migrationtools.config_patch import ConfigPatch
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools import avi_rest_lib
import yaml
import json
import logging
import os
import avi.migrationtools


LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)


class AviConverter(object):
    output_file_path = None
    patch = None
    vs_filter = None
    controller_ip = None
    user = None
    password = None
    tenant = None

    def print_pip_and_controller_version(self):
        pass

    def convert(self):
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
        print "Uploading Configuration to Controller..."
        avi_rest_lib.upload_config_to_controller(
            avi_config, self.controller_ip, self.user, self.password,
            self.tenant, self.controller_version)

    def download_gslb_config_form_controller(self):
        """ Downloading gslb configuration from controller
            and return the output json"""
        return avi_rest_lib.download_gslb_from_controller(
            self.controller_ip, self.user, self.password, self.password)

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
        print "Converted Output Location: %s" % \
              (report_path)
        with open(report_path, "w") as text_file:
            json.dump(avi_config, text_file, indent=4)
        LOG.info('written avi config file ' +
                 output_dir + os.path.sep + "Output.json")

    def init_logger_path(self):
        LOG.setLevel(logging.DEBUG)
        print "Log File Location: %s" % self.output_file_path
        formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
        logging.basicConfig(filename=os.path.join(self.output_file_path, 'converter.log'),
                            level=logging.DEBUG, format=formatter)

    def meta(self, tenant, controller_version):
        """ Return the meta data from superclass """
        avi_config_dict = {
            "supported_migrations": {
                "versions": [
                    "14_2",
                    "15_1",
                    "15_1_1",
                    "15_2",
                    "15_2_3",
                    "15_3",
                    "16_1",
                    "16_1_1",
                    "16_1_2",
                    "16_1_3",
                    "16_2",
                    "16_2_1",
                    "16_2_2",
                    "16_2_3",
                    "16_3",
                    "16_3_1",
                    "16_3_2",
                    "16_3_4",
                    "16_4_1",
                    "16_4_2",
                    "17_1_1",
                    "current_version"
                ]
            },
            "version": {
                "Product": "controller",
                "Version": controller_version,
                "min_version": 15.2,
                "ProductName": "Avi Cloud Controller"
            },
            "upgrade_mode": False,
            "use_tenant": tenant
        }
        try:
            for index, version in enumerate(avi_config_dict['supported_migrations']['versions']):
                # print parse_version(version), parse_version(controller_version)
                if parse_version(version.replace('_','.')) > parse_version(controller_version):
                    loc = index
                    break
            if loc:
                part_1 = avi_config_dict['supported_migrations']['versions'][:loc]
                part_2 = avi_config_dict['supported_migrations']['versions'][-1:]
                avi_config_dict['supported_migrations']['versions'] = part_1 + part_2
        except:
            pass
        return avi_config_dict
