import mock
import json
import os
import pytest
import unittest2
from avi.migrationtools.ace_converter.pool_converter import PoolConverter
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.ace_converter.monitor_converter import MonitorConverter
from avi.migrationtools.ace_converter.persistance_conversion import PersistanceConverter
from avi.migrationtools.ace_converter.vs_converter import VSConverter
from avi.migrationtools.ace_converter.ssl_converter import SSLConverter


path = os.path.dirname(os.path.abspath(__file__))
dummy_file = "%s%sdummy_input.json" % (path, os.sep)

with open(dummy_file, 'r') as reader:
    data = json.load(reader)

ssl_name = 'test_ssl_noname'
sticky_name = "test_sticky"
pool_name = "test_farm"
server_name = "test_server"
health_moniter_name = "test_monitor"
persistance_moniter_name = "test_persistance"
port = "test_port"

class TestModulesAce(unittest2.TestCase):

    def setUp(self):
        self.common_utils = MigrationUtil()
        tenant_ref = "/api/tenant/?name=admin"
        cloud_ref = "/api/cloud/?tenant=admin&name=Default-Cloud"
        tenant = "admin"
        vrf_ref = None
        self.empty_data = []
        self.data = {
            "ApplicationPersistenceProfile": [
                {
                    "name": "test_sticky"
                }
            ],
            "HealthMonitor": [
                {
                    "name": "test_probe"
                }
            ],
            "SSLProfile": [

            ]
        }
        self.vrf_ref_data = "/api/vrfcontext/?tenant=admin&name=testvrf1&cloud=Default-Cloud"
        self.pool_obj_app = PoolConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, cloud_ref=cloud_ref, tenant=tenant, vrf_ref=vrf_ref)
        self.pool_obj_app_vrf = PoolConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, cloud_ref=cloud_ref, tenant=tenant, vrf_ref=self.vrf_ref_data)
        self.pool_obj_app_empty = PoolConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, cloud_ref=cloud_ref, tenant=tenant, vrf_ref=vrf_ref)
        self.MonitorConvertor_obj_app = MonitorConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, tenant=tenant)
        self.MonitorConvertor_empty = MonitorConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, tenant=tenant)
        self.PersistanceConvertor_obj_app = PersistanceConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, tenant=tenant)
        self.PersistanceConvertor_empty = PersistanceConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, tenant=tenant)
        self.sslConvertor_obj_app = SSLConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, in_path=None, tenant=tenant)
        self.sslConvertor_empty = SSLConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, in_path=None, tenant=tenant)
        self.vs = VSConverter(parsed=data, tenant_ref=tenant_ref,
                              common_utils=self.common_utils, enable_vs=True, cloud_ref=cloud_ref, tenant=tenant, vrf_ref=vrf_ref)
        self.vs_vrf = VSConverter(parsed=data, tenant_ref=tenant_ref,
                                  common_utils=self.common_utils, enable_vs=True, cloud_ref=cloud_ref, tenant=tenant, vrf_ref=self.vrf_ref_data)
        self.vs_empty = VSConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, enable_vs=True,  cloud_ref=cloud_ref, tenant=tenant, vrf_ref=vrf_ref)

    """ POOL CONVERTERS"""


    @pytest.mark.TCID1_48_1551_13_0
    def test_pool_persistance_true(self):
        """Checking correct input and correct pool name expects proper sticky"""
        self.assertEqual(self.pool_obj_app.find_app_persistance(
            pool_name, self.data), sticky_name)


    @pytest.mark.TCID1_48_1551_12_0
    def test_pool_persistance_failure(self):
        self.assertNotEquals("invalid",
                             self.pool_obj_app.find_app_persistance("invalid", self.data))


    @pytest.mark.TCID1_48_1551_11_0
    def test_pool_persistance_empty(self):
        self.assertFalse(
            self.pool_obj_app_empty.find_app_persistance(pool_name, self.empty_data))


    @pytest.mark.TCID1_48_1551_8_0
    def test_pool_conversion_true(self):
        self.assertEqual(self.pool_obj_app.pool_conversion(self.data)
                         [0]['name'], pool_name)


    @pytest.mark.TCID1_48_1551_7_0
    def test_pool_conversion_invalid(self):
        self.assertNotEquals(self.pool_obj_app.pool_conversion(self.data)[
                             0]['name'], 'invalid')


    @pytest.mark.TCID1_48_1551_10_0
    def test_pool_conversion_with_probe(self):
        self.assertEquals(len(self.pool_obj_app.pool_conversion(self.data)[
                          0]['health_monitor_refs']), 1)


    @pytest.mark.TCID1_48_1551_9_0
    def test_pool_conversion_with_mutiple_servers(self):
        self.assertEquals(len(self.pool_obj_app.pool_conversion(self.data)[0]['servers']), 2)



    @pytest.mark.TCID1_48_1551_17_0
    def test_server_converter_true(self):
        self.assertTrue(self.pool_obj_app.server_converter(server_name, port))


    @pytest.mark.TCID1_48_1551_16_0
    def test_server_converter_invalid(self):
        self.assertFalse(self.pool_obj_app.server_converter("invalid","invalid"))


    @pytest.mark.TCID1_48_1551_15_0
    def test_server_converter_empty(self):
        self.assertNotEquals(
            self.pool_obj_app_empty.server_converter(server_name, port), server_name, port)


    @pytest.mark.TCID1_48_1551_14_0
    def test_pool_with_vrf_ref(self):
        self.assert_(self.pool_obj_app_vrf.pool_conversion(self.data)
                     [0]['vrf_ref'], self.vrf_ref_data)

    """ Monitor Converters """


    @pytest.mark.TCID1_48_1551_2_0
    def test_monitor_convertor_true(self):
        """ Giving data and asserting with the expected output """
        self.assertTrue(self.MonitorConvertor_obj_app.healthmonitor_conversion()[
                        0]['name'], health_moniter_name)


    @pytest.mark.TCID1_48_1551_1_0
    def test_monitor_convertor_empty(self):
        self.assertFalse(
            self.MonitorConvertor_empty.healthmonitor_conversion())
    

    @pytest.mark.TCID1_48_1551_3_0
    def test_monitor_https_support(self):
        self.assertEquals(self.MonitorConvertor_obj_app.healthmonitor_conversion()[0]['type'],
                          'HEALTH_MONITOR_HTTPS')


    @pytest.mark.TCID1_48_1551_4_0
    def test_monitor_port_support(self):
        self.assertTrue('monitor_port' in
                        self.MonitorConvertor_obj_app.healthmonitor_conversion()[1])

    """ Persistance Converter"""


    @pytest.mark.TCID1_48_1551_6_0
    def test_persistance_convertor_true(self):
        self.assertTrue(self.PersistanceConvertor_obj_app.app_persistance_conversion()[
                        0]['name'], persistance_moniter_name)


    @pytest.mark.TCID1_48_1551_5_0
    def test_persistance_convertor_empty(self):
        self.assertFalse(
            self.PersistanceConvertor_empty.app_persistance_conversion())

    """SSL Convertor"""


    @pytest.mark.TCID1_48_1551_19_0
    def test_sslConvertor_true(self):
        self.assertTrue(self.sslConvertor_obj_app.ssl_key_and_cert())


    @pytest.mark.TCID1_48_1551_18_0
    def test_sslConvertor_empty(self):
        self.assertFalse(self.sslConvertor_empty.ssl_key_and_cert())

    """SSL Profile Convertor"""


    @pytest.mark.TCID1_48_1551_20_0
    def test_sslProfileConvertorTrue(self):
        self.assertTrue(self.sslConvertor_obj_app.ssl_profile())


    @pytest.mark.TCID1_48_1551_21_0
    def test_sslProfileEmpty(self):
        self.assertFalse(self.sslConvertor_empty.ssl_profile())

    """VS Converter"""


    @pytest.mark.TCID1_48_1551_24_0
    def test_vsipConverterTrue(self):
        self.assertTrue(self.vs.vsvip_conversion())


    @pytest.mark.TCID1_48_1551_25_0
    def test_vsipConverter_Empty(self):
        self.assertFalse(self.vs_empty.vsvip_conversion())


    @pytest.mark.TCID1_48_1551_23_0
    def test_vsConverter_true(self):
        self.assertTrue(self.vs.virtual_service_conversion(self.data))


    @pytest.mark.TCID1_48_1551_22_0
    def test_vsConverter_False(self):
        self.assertEquals(
            self.vs_empty.virtual_service_conversion('{}'), ([], [], []))
