import mock
import json
import os
import unittest
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

print data

ssl_name = 'test_ssl_noname'
sticky_name = "test_sticky"
pool_name = "test_farm"
server_name = "test_server"
health_moniter_name = "test_monitor"
persistance_moniter_name = "test_persistance"

class TestModulesAce(unittest.TestCase):

    def setUp(self):
        self.common_utils = MigrationUtil()
        self.pool_obj_app = PoolConverter(parsed=data, tenant_ref='test', common_utils=self.common_utils)
        self.pool_obj_app_empty = PoolConverter(parsed={}, tenant_ref='test', common_utils=self.common_utils)
        self.MonitorConvertor_obj_app = MonitorConverter(parsed=data, tenant_ref='test', common_utils=self.common_utils)
        self.MonitorConvertor_empty = MonitorConverter(parsed={}, tenant_ref='test', common_utils=self.common_utils)
        self.PersistanceConvertor_obj_app = PersistanceConverter(parsed=data, tenant_ref='test', common_utils=self.common_utils)
        self.PersistanceConvertor_empty = PersistanceConverter(parsed={}, tenant_ref='test',common_utils=self.common_utils)
        self.sslConvertor_obj_app = SSLConverter(parsed=data, tenant_ref='test', common_utils=self.common_utils, in_path=None)
        self.sslConvertor_empty = SSLConverter(parsed={}, tenant_ref='test', common_utils=self.common_utils, in_path=None)
        self.vs = VSConverter(parsed=data, tenant_ref='test', common_utils=self.common_utils)
        self.vs_empty = VSConverter(parsed={}, tenant_ref='test', common_utils=self.common_utils)


    """ POOL CONVERTERS"""

    def test_pool_persistance_true(self):
        """Checking correct input and correct pool name expects proper sticky"""
        self.assertEqual(self.pool_obj_app.find_app_persistance(pool_name), sticky_name)

    def test_pool_persistance_failure(self):
        self.assertFalse(self.pool_obj_app.find_app_persistance("invalid"))

    def test_pool_persistance_empty(self):
        self.assertFalse(self.pool_obj_app_empty.find_app_persistance(pool_name))

    def test_pool_conversion_true(self):
        self.assertEqual(self.pool_obj_app.pool_conversion()[0]['name'], pool_name)

    def test_pool_conversion_invalid(self):
        self.assertNotEquals(self.pool_obj_app.pool_conversion()[0]['name'], 'invalid')


    def test_pool_conversion_with_probe(self):
        self.assertEquals (len(self.pool_obj_app.pool_conversion()[0]['health_monitor_refs']), 1)

    # ToDO : without probe needs to be tested
    # def test_pool_conversion_without_probe(self):
    #     self.assertNotEquals(self.pool_obj_app.pool_conversion()[0]['name'], 'invalid')

    def test_server_converter_true(self):
         self.assertTrue(self.pool_obj_app.server_converter(server_name))

    def test_server_converter_invalid(self):
        self.assertFalse(self.pool_obj_app.server_converter("invalid"))

    def test_server_converter_empty(self):
        self.assertNotEquals(self.pool_obj_app_empty.server_converter(server_name), server_name)


    """ Monitor Converters """

    def test_monitor_convertor_true(self):
        """ Giving data and asserting with the expected output """
        print self.MonitorConvertor_obj_app.healthmonitor_conversion()[0]['name']
        self.assertTrue(self.MonitorConvertor_obj_app.healthmonitor_conversion()[0]['name'], health_moniter_name)

    def test_monitor_convertor_empty(self):
       self.assertFalse(self.MonitorConvertor_empty.healthmonitor_conversion())

    """ Persistance Converter"""


    def test_persistance_convertor_true(self):
        self.assertTrue(self.PersistanceConvertor_obj_app.app_persistance_conversion()[0]['name'],persistance_moniter_name)

    def test_persistance_convertor_empty(self):
        self.assertFalse(self.PersistanceConvertor_empty.app_persistance_conversion())



    # """Vs Convertor"""
    # def test_vs_check_persistance_true(self):
    #      print "data", self.assertTrue(self.vs.check_persistance(pool_name, data), pool_name)
    #      assert 0



    """SSL Convertor"""

    def test_sslConvertor_true(self):
       self.assertTrue(self.sslConvertor_obj_app.ssl_key_and_cert())

    def test_sslConvertor_empty(self):
         self.assertFalse(self.sslConvertor_empty.ssl_key_and_cert())

    """SSL Profile Convertor"""

    def test_sslProfileConvertor(self):
        self.assertTrue(self.sslConvertor_obj_app.ssl_profile())

    def test_sslProfileEmpty(self):
        self.assertFalse(self.sslConvertor_empty.ssl_profile())
