import logging
import unittest
import json

from avi.netscaler_converter.ns_constants import (OBJECT_TYPE_POOL_GROUP,
                                                  OBJECT_TYPE_HTTP_POLICY_SET,
                                                  OBJECT_TYPE_SSL_PROFILE,
                                                  OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                                  OBJECT_TYPE_NETWORK_PROFILE,
                                                  OBJECT_TYPE_APPLICATION_PROFILE,
                                                  OBJECT_TYPE_HEALTH_MONITOR,
                                                  OBJECT_TYPE_VIRTUAL_SERVICE,
                                                  OBJECT_TYPE_STRING_GROUP,
                                                  OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
                                                  OBJECT_TYPE_POOL,
                                                  OBJECT_TYPE_PKI_PROFILE)
from avi.netscaler_converter import ns_util
from avi.netscaler_converter.avi_rest_lib import get_object_from_controller
from testconfig import config
from avi.netscaler_converter import upload_config



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
    output_file = open('%s/Output.json' % output_dir, 'r')
    controller_ip = config['upload_config']['controller_ip']
    user_name = config['upload_config']['user_name']
    password = config['upload_config']['password']
    tenant = config['netscaler_test_config']['tenant']
    cloud_name = config['netscaler_test_config']['cloud_name']
    output_data = output_file.read()
    avi_config = json.loads(output_data)


class TestUploadConfig(unittest.TestCase):
    def test_upload_output_config(self):
        upload_config.upload_config_to_controller(avi_config, controller_ip,
                                                  user_name, password, tenant)

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

            # Get the url of pool group
            pool_group_ref = \
                ns_util.get_object_ref(pool_group['name'],
                                       OBJECT_TYPE_POOL_GROUP, tenant,
                                       cloud_name)

            # Get the pool group object from controller
            status_code, jsondata = \
                get_object_from_controller(pool_group_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == pool_group['name'])

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

            # Get the url of HTTPPolicySet
            http_policy_ref = \
                ns_util.get_object_ref(http_policy_set['name'],
                                       OBJECT_TYPE_HTTP_POLICY_SET, tenant,
                                       cloud_name)

            # Get the HTTPPolicySet object from controller
            status_code, jsondata = \
                get_object_from_controller(http_policy_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == http_policy_set['name'])

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

            # Get the url of SSL Profile
            ssl_profiles_ref = \
                ns_util.get_object_ref(ssl_profile['name'],
                                       OBJECT_TYPE_SSL_PROFILE, tenant,
                                       cloud_name)

            # Get the SSL Profile object from controller
            status_code, jsondata = \
                get_object_from_controller(ssl_profiles_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == ssl_profile['name'])

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

            # Get the url of SSL Key And Certificate
            ssl_key_and_certificate_ref = \
                ns_util.get_object_ref(ssl_key_and_certificate['name'],
                                       OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                       tenant, cloud_name)

            # Get the SSL Key And Certificate object from controller
            status_code, jsondata = \
                get_object_from_controller(ssl_key_and_certificate_ref,
                                           controller_ip, user_name, password,
                                           tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(
                jsondata['name'] == ssl_key_and_certificate['name'])

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

            # Get the url of Network Profile
            network_profile_ref = \
                ns_util.get_object_ref(network_profile['name'],
                                       OBJECT_TYPE_NETWORK_PROFILE, tenant,
                                       cloud_name)

            # Get the Network Profile object from controller
            status_code, jsondata = \
                get_object_from_controller(network_profile_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == network_profile['name'])

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

            # Get the url of Application Profile
            application_profile_ref = \
                ns_util.get_object_ref(application_profile['name'],
                                       OBJECT_TYPE_APPLICATION_PROFILE, tenant,
                                       cloud_name)

            # Get the Application Profile object from controller
            status_code, jsondata = \
                get_object_from_controller(application_profile_ref,
                                           controller_ip, user_name, password,
                                           tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == application_profile['name'])

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

            # Get the url of Health Monitor
            health_monitor_ref = \
                ns_util.get_object_ref(health_monitor['name'],
                                       OBJECT_TYPE_HEALTH_MONITOR, tenant,
                                       cloud_name)

            # Get the Health Monitor object from controller
            status_code, jsondata = \
                get_object_from_controller(health_monitor_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == health_monitor['name'])

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

            # Get the url of Virtual Service
            virtual_service_ref = \
                ns_util.get_object_ref(virtual_service['name'],
                                       OBJECT_TYPE_VIRTUAL_SERVICE, tenant,
                                       cloud_name)

            # Get the Virtual Service from controller
            status_code, jsondata = \
                get_object_from_controller(virtual_service_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == virtual_service['name'])

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

            # Get the url of String Group
            string_group_ref = \
                ns_util.get_object_ref(string_group['name'],
                                       OBJECT_TYPE_STRING_GROUP, tenant,
                                       cloud_name)

            # Get the String Group from controller
            status_code, jsondata = \
                get_object_from_controller(string_group_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == string_group['name'])

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

            # Get the url of Application Persistence Profile
            application_persistence_profile_ref = \
                ns_util.get_object_ref(
                    application_persistence_profile['name'],
                    OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE, tenant,
                    cloud_name)

            # Get the Application Persistence Profile from controller
            status_code, jsondata = \
                get_object_from_controller(application_persistence_profile_ref,
                                           controller_ip, user_name, password,
                                           tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(
                jsondata['name'] == application_persistence_profile['name'])

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

            # Get the url of pool
            pool_ref = \
                ns_util.get_object_ref(pool['name'],
                                       OBJECT_TYPE_POOL, tenant, cloud_name)

            # Get the pool from controller
            status_code, jsondata = \
                get_object_from_controller(pool_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == pool['name'])

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

            # Get the url of PKI Profile
            pki_profile_ref = \
                ns_util.get_object_ref(pki_profile['name'],
                                       OBJECT_TYPE_PKI_PROFILE, tenant,
                                       cloud_name)

            # Get the PKI Profile from controller
            status_code, jsondata = \
                get_object_from_controller(pki_profile_ref, controller_ip,
                                           user_name, password, tenant)
            self.assertTrue(int(status_code) < 299)
            self.assertEqual(jsondata['name'] == pki_profile['name'])


if __name__ == '__main__':
    unittest.main()