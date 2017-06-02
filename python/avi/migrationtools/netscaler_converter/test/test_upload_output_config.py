import logging
import unittest
import json

from avi.migrationtools.netscaler_converter.ns_constants \
    import (OBJECT_TYPE_POOL_GROUP, OBJECT_TYPE_HTTP_POLICY_SET,
            OBJECT_TYPE_SSL_PROFILE, OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
            OBJECT_TYPE_NETWORK_PROFILE, OBJECT_TYPE_APPLICATION_PROFILE,
            OBJECT_TYPE_HEALTH_MONITOR, OBJECT_TYPE_VIRTUAL_SERVICE,
            OBJECT_TYPE_STRING_GROUP, OBJECT_TYPE_POOL, OBJECT_TYPE_PKI_PROFILE,
            OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE)
from testconfig import config
from avi.migrationtools.avi_rest_lib import (upload_config_to_controller,
                                            get_object_from_controller)


LOG = logging.getLogger(__name__)


def setUp():
    global csv_reader
    global avi_config
    global controller_ip
    global user_name
    global password
    global tenant
    global cloud_name

    LOG.setLevel(logging.DEBUG)
    output_dir = config['upload_config']['output_dir']
    config_file_name = config['upload_config']['config_file_name']
    output_file = open('%s/%s-Output.json' % (output_dir, config_file_name), 'r')
    controller_ip = config['upload_config']['controller_ip']
    user_name = config['upload_config']['user_name']
    password = config['upload_config']['password']
    tenant = config['netscaler_e2e_config']['tenant']
    cloud_name = config['netscaler_e2e_config']['cloud_name']
    output_data = output_file.read()
    avi_config = json.loads(output_data)


class TestUploadConfig(unittest.TestCase):
    def test_upload_output_config(self):
        upload_config_to_controller(avi_config, controller_ip, user_name,
                                    password, tenant)

    def test_upload_poolgroup_on_controller(self):
        """
        This test case defines that verify all pool groups objects are uploaded
        on controller
        :return: None
        """

        # Get list of pool groups objects from avi config
        pool_groups = avi_config['PoolGroup']
        for pool_group in pool_groups:
            assert pool_group['name']
            # Get the pool group object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_POOL_GROUP,pool_group['name'] ,controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], pool_group['name'])

    def test_upload_http_policy_set_on_controller(self):
        """
        This test case defines that verify all HTTPPolicySet objects are
        uploaded on controller
        :return: None
        """

        # Get list of HTTPPolicySets objects from avi config
        http_policy_sets = avi_config['HTTPPolicySet']
        for http_policy_set in http_policy_sets:
            assert http_policy_set['name']
            # Get the HTTPPolicySet object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_HTTP_POLICY_SET,
                                           http_policy_set['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], http_policy_set['name'])

    def test_upload_ssl_profile_on_controller(self):
        """
        This test case defines that verify all SSL Profiles objects are uploaded
        on controller
        :return: None
        """

        # Get list of SSL Profiles objects from avi config
        ssl_profiles = avi_config['SSLProfile']
        for ssl_profile in ssl_profiles:
            assert ssl_profile['name']
            # Get the SSL Profile object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_SSL_PROFILE,
                                           ssl_profile['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], ssl_profile['name'])

    def test_upload_ssl_key_and_certificate_on_controller(self):
        """
        This test case defines that verify all SSL Key And Certificate objects
        are uploaded on controller
        :return: None
        """

        # Get list of SSL Key And Certificates objects from avi config
        ssl_key_and_certificates = avi_config['SSLKeyAndCertificate']
        for ssl_key_and_certificate in ssl_key_and_certificates:
            assert ssl_key_and_certificate['name']
            # Get the SSL Key And Certificate object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                           ssl_key_and_certificate['name'],
                                           controller_ip, user_name, password,
                                           tenant)
            self.assertEqual(jsondata['name'], ssl_key_and_certificate['name'])

    def test_upload_network_profile_on_controller(self):
        """
        This test case defines that verify all Network Profiles objects are
        uploaded on controller
        :return: None
        """

        # Get list of Network Profiles objects from avi config
        network_profiles = avi_config['NetworkProfile']
        for network_profile in network_profiles:
            assert network_profile['name']
            # Get the Network Profile object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_NETWORK_PROFILE,
                                           network_profile['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], network_profile['name'])

    def test_upload_application_profile_on_controller(self):
        """
        This test case defines that verify all Application Profiles objects are
        uploaded on controller
        :return: None
        """

        # Get list of Application Profiles objects from avi config
        application_profiles = avi_config['ApplicationProfile']
        for application_profile in application_profiles:
            assert application_profile['name']
            # Get the Application Profile object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_APPLICATION_PROFILE,
                                           application_profile['name'],
                                           controller_ip, user_name, password,
                                           tenant)
            self.assertEqual(jsondata['name'], application_profile['name'])

    def test_upload_health_monitor_on_controller(self):
        """
        This test case defines that verify all Health Monitors objects are
        uploaded on controller
        :return: None
        """

        # Get list of Health Monitors objects from avi config
        health_monitors = avi_config['HealthMonitor']
        for health_monitor in health_monitors:
            assert health_monitor['name']
            # Get the Health Monitor object from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_HEALTH_MONITOR,
                                           health_monitor['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], health_monitor['name'])

    def test_upload_virtual_service_on_controller(self):
        """
        This test case defines that verify all VirtualServices objects are
        uploaded on controller
        :return: None
        """

        # Get list of Virtual Services objects from avi config
        virtual_services = avi_config['VirtualService']
        for virtual_service in virtual_services:
            assert virtual_service['name']
            # Get the Virtual Service from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_VIRTUAL_SERVICE,
                                           virtual_service['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], virtual_service['name'])

    def test_upload_string_group_on_controller(self):
        """
        This test case defines that verify all String Groups objects are uploaded
        on controller
        :return: None
        """

        # Get list of String Groups objects from avi config
        string_groups = avi_config['StringGroup']
        for string_group in string_groups:
            assert string_group['name']
            # Get the String Group from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_STRING_GROUP,
                                           string_group['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], string_group['name'])

    def test_upload_application_persistence_profile_on_controller(self):
        """
        This test case defines that verify all Application Persistence Profiles
        objects are uploaded on controller
        :return: None
        """

        # Get list of Application Persistence Profiles objects from avi config
        application_persistence_profiles = \
            avi_config['ApplicationPersistenceProfile']
        for application_persistence_profile in application_persistence_profiles:
            assert application_persistence_profile['name']
            # Get the Application Persistence Profile from controller
            jsondata = \
                get_object_from_controller(
                    OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
                    application_persistence_profile['name'],
                    controller_ip, user_name, password,
                    tenant)
            self.assertEqual(jsondata['name'],
                             application_persistence_profile['name'])

    def test_upload_pool_on_controller(self):
        """
        This test case defines that verify all pools objects are uploaded on
        controller
        :return: None
        """

        # Get list of pools objects from avi config
        pools = avi_config['Pool']
        for pool in pools:
            assert pool['name']
            # Get the pool from controller
            jsondata = \
                get_object_from_controller(OBJECT_TYPE_POOL,
                                           pool['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], pool['name'])

    def test_upload_pki_profile_on_controller(self):
        """
        This test case defines that verify all PKI Profiles objects are uploaded
        on controller
        :return: None
        """

        # Get list of PKI Profiles objects from avi config
        pki_profiles = avi_config['PKIProfile']
        for pki_profile in pki_profiles:
            assert pki_profile['name']
            # Get the PKI Profile from controller
            status_code, jsondata = \
                get_object_from_controller(OBJECT_TYPE_PKI_PROFILE,
                                           pki_profile['name'],
                                           controller_ip,
                                           user_name, password, tenant)
            self.assertEqual(jsondata['name'], pki_profile['name'])


if __name__ == '__main__':
    unittest.main()
