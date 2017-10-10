import mock
import json
import os
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


class TestModulesAce(unittest2.TestCase):

    def setUp(self):
        self.common_utils = MigrationUtil()
        tenant_ref = "/api/tenant/?name=admin"
        cloud_ref = "/api/cloud/?tenant=admin&name=Default-Cloud"
        tenant = "admin"
        self.pool_obj_app = PoolConverter(
            parsed=data, tenant_ref=tenant_ref, common_utils=self.common_utils, cloud_ref=cloud_ref, tenant=tenant)
        self.pool_obj_app_empty = PoolConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, cloud_ref=cloud_ref, tenant=tenant)
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
                              common_utils=self.common_utils, enable_vs=True, cloud_ref=cloud_ref, tenant=tenant)
        self.vs_empty = VSConverter(
            parsed={}, tenant_ref=tenant_ref, common_utils=self.common_utils, enable_vs=True,  cloud_ref=cloud_ref, tenant=tenant)

    """ POOL CONVERTERS"""

    def test_pool_persistance_true(self):
        """Checking correct input and correct pool name expects proper sticky"""
        self.assertEqual(self.pool_obj_app.find_app_persistance(
            pool_name), sticky_name)

    def test_pool_persistance_failure(self):
        self.assertFalse(self.pool_obj_app.find_app_persistance("invalid"))

    def test_pool_persistance_empty(self):
        self.assertFalse(
            self.pool_obj_app_empty.find_app_persistance(pool_name))

    def test_pool_conversion_true(self):
        self.assertEqual(self.pool_obj_app.pool_conversion()
                         [0]['name'], pool_name)

    def test_pool_conversion_invalid(self):
        self.assertNotEquals(self.pool_obj_app.pool_conversion()[
                             0]['name'], 'invalid')

    def test_pool_conversion_with_probe(self):
        self.assertEquals(len(self.pool_obj_app.pool_conversion()[
                          0]['health_monitor_refs']), 1)

    def test_server_converter_true(self):
        self.assertTrue(self.pool_obj_app.server_converter(server_name))

    def test_server_converter_invalid(self):
        self.assertFalse(self.pool_obj_app.server_converter("invalid"))

    def test_server_converter_empty(self):
        self.assertNotEquals(
            self.pool_obj_app_empty.server_converter(server_name), server_name)

    """ Monitor Converters """

    def test_monitor_convertor_true(self):
        """ Giving data and asserting with the expected output """
        self.assertTrue(self.MonitorConvertor_obj_app.healthmonitor_conversion()[
                        0]['name'], health_moniter_name)

    def test_monitor_convertor_empty(self):
        self.assertFalse(
            self.MonitorConvertor_empty.healthmonitor_conversion())

    """ Persistance Converter"""

    def test_persistance_convertor_true(self):
        self.assertTrue(self.PersistanceConvertor_obj_app.app_persistance_conversion()[
                        0]['name'], persistance_moniter_name)

    def test_persistance_convertor_empty(self):
        self.assertFalse(
            self.PersistanceConvertor_empty.app_persistance_conversion())

    """SSL Convertor"""

    def test_sslConvertor_true(self):
        self.assertTrue(self.sslConvertor_obj_app.ssl_key_and_cert())

    def test_sslConvertor_empty(self):
        self.assertFalse(self.sslConvertor_empty.ssl_key_and_cert())

    """SSL Profile Convertor"""

    def test_sslProfileConvertorTrue(self):
        self.assertTrue(self.sslConvertor_obj_app.ssl_profile())

    def test_sslProfileEmpty(self):
        self.assertFalse(self.sslConvertor_empty.ssl_profile())

    """VS Converter"""

    def test_vsipConverterTrue(self):
        self.assertTrue(self.vs.vsvip_conversion())

    def test_vsipConverter_Empty(self):
        self.assertFalse(self.vs_empty.vsvip_conversion())

    def test_vsConverter_true(self):
        self.assertTrue(self.vs.virtual_service_conversion(data))

    def test_vsConverter_False(self):
        self.assertEquals(
            self.vs_empty.virtual_service_conversion('{}'), ([], []))
