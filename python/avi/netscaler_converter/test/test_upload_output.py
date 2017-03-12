import logging
import unittest
import json

from testconfig import config
from avi.netscaler_converter import upload_config

LOG = logging.getLogger(__name__)


def setUp():
    global csv_reader
    global avi_config
    global controller_ip
    global user
    global password
    global tenant
    LOG.setLevel(logging.DEBUG)
    output_dir = config['upload_config']['output_dir']
    output_file = open('%s/Output.json' % output_dir, 'r')
    controller_ip = config['upload_config']['controller_ip']
    user = config['upload_config']['user_name']
    password = config['upload_config']['password']
    tenant = config['netscaler_test_config']['tenant']
    output_data = output_file.read()
    avi_config = json.loads(output_data)


class TestUploadConfig(unittest.TestCase):
    def test_upload_output_config(self):
        upload_config.upload_config_to_controller(avi_config, controller_ip,
                                                  user, password, tenant)

    def test_upload_poolgroup_on_controller(self):
        # TODO add functionality to get the list of poolgroups and output
        # config that shopuld be match

    def test_upload_http_policy_set_on_controller(self):
        # TODO add functionality to get the list of HTTPPolicySet and output
        # config that shopuld be match

    def test_upload_ssl_profile_on_controller(self):
        # TODO add functionality to get the list of SSLProfile and output
        # config that shopuld be match

    def test_upload_ssl_key_and_certificate_on_controller(self):
        # TODO add functionality to get the list of SSLKeyAndCertificate and output
        # config that shopuld be match

    def test_upload_network_profile_on_controller(self):
        # TODO add functionality to get the list of NetworkProfile and output
        # config that shopuld be match

    def test_upload_application_profile_on_controller(self):
        # TODO add functionality to get the list of ApplicationProfile and output
        # config that shopuld be match

    def test_upload_health_monitor_on_controller(self):
        # TODO add functionality to get the list of HealthMonitor and output
        # config that shopuld be match

    def test_upload_virtual_service_on_controller(self):
        # TODO add functionality to get the list of VirtualService and output
        # config that shopuld be match

    def test_upload_string_group_on_controller(self):
        # TODO add functionality to get the list of StringGroup and output
        # config that shopuld be match

    def test_upload_application_persistence_profile_on_controller(self):
        # TODO add functionality to get the list of ApplicationPersistenceProfile and output
        # config that shopuld be match

    def test_upload_pool_on_controller(self):
        # TODO add functionality to get the list of Pool and output
        # config that shopuld be match

    def test_upload_pki_profile_on_controller(self):
        # TODO add functionality to get the list of PKIProfile and output
        # config that shopuld be match


if __name__ == '__main__':
    unittest.main()