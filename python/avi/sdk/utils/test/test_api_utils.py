'''
Created on Aug 16, 2016

@author: grastogi
'''
import unittest
from avi.sdk.utils.api_utils import avi_obj_cmp


class Test(unittest.TestCase):

    def test_avi_obj_cmp(self):
        obj = {'name': 'testpool'}
        existing_obj = {
            'lb_algorithm': 'LB_ALGORITHM_LEAST_CONNECTIONS',
            'use_service_port': False,
            'server_auto_scale': False,
            'host_check_enabled': False,
            'enabled': True,
            'capacity_estimation': False,
            'fewest_tasks_feedback_delay': 10,
            '_last_modified': u'1471377748747040',
            'cloud_ref': u'https://10.130.2.252/api/cloud/cloud-afe8bf2c-9821-4272-9bc6-67634c84bec9',
            'vrf_ref': u'https://10.130.2.252/api/vrfcontext/vrfcontext-0e8ce760-fed2-4650-9397-5b3e4966376e',
            'inline_health_monitor': True,
            'default_server_port': 80,
            'request_queue_depth': 128,
            'graceful_disable_timeout': 1,
            'server_count': 0,
            'sni_enabled': True,
            'request_queue_enabled': False,
            'name': u'testpool',
            'max_concurrent_connections_per_server': 0,
            'url': 'https://10.130.2.252/api/pool/pool-20084ee1-872e-4103-98e1-899103e2242a',
            'tenant_ref': u'https://10.130.2.252/api/tenant/admin',
            'uuid': u'pool-20084ee1-872e-4103-98e1-899103e2242a',
            'connection_ramp_duration': 10}

        diff = avi_obj_cmp(obj, existing_obj)
        assert diff
        x = not diff
        assert not x

    def test_avi_obj_cmp_w_refs(self):
        obj = {'name': 'testpool',
               'health_monitor_refs': ['/api/healthmonitor?name=System-HTTP'],
               'enabled': True}
        existing_obj = {
            'lb_algorithm': 'LB_ALGORITHM_LEAST_CONNECTIONS',
            'use_service_port': False,
            'server_auto_scale': False,
            'host_check_enabled': False,
            'enabled': True,
            'capacity_estimation': False,
            'fewest_tasks_feedback_delay': 10,
            '_last_modified': u'1471377748747040',
            'cloud_ref': u'https://10.130.2.252/api/cloud/cloud-afe8bf2c-9821-4272-9bc6-67634c84bec9',
            'vrf_ref': u'https://10.130.2.252/api/vrfcontext/vrfcontext-0e8ce760-fed2-4650-9397-5b3e4966376e',
            'inline_health_monitor': True,
            'default_server_port': 80,
            'request_queue_depth': 128,
            'graceful_disable_timeout': 1,
            'server_count': 0,
            'sni_enabled': True,
            'request_queue_enabled': False,
            'name': u'testpool',
            'max_concurrent_connections_per_server': 0,
            'url': 'https://10.130.2.252/api/pool/pool-20084ee1-872e-4103-98e1-899103e2242a',
            'tenant_ref': u'https://10.130.2.252/api/tenant/admin',
            'uuid': u'pool-20084ee1-872e-4103-98e1-899103e2242a',
            'connection_ramp_duration': 10,
            'health_monitor_refs': [
                "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9#System-HTTP"
                ],
            }

        diff = avi_obj_cmp(obj, existing_obj)
        assert diff
        obj = {'name': 'testpool',
               'health_monitor_refs': ['/api/healthmonitor?name=System-HTTP'],
               'server_count': 1}
        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff

        obj = {'name': 'testpool',
               'health_monitor_refs': ['api/healthmonitor?name=System-HTTP'],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff
        obj = {'name': 'testpool',
               'health_monitor_refs': ['healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9'],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff
        obj = {'name': 'testpool#asdfasf',
               'health_monitor_refs': ['api/healthmonitor?name=System-HTTP'],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff
        obj = {'name': 'testpool',
               'health_monitor_refs': ['/api/healthmonitor?name=System-HTTP#'],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff

    def test_avi_obj_cmp_empty_list(self):
        obj = {'name': 'testpool',
               'health_monitor_refs': [],
               'enabled': True}
        existing_obj = {
            'lb_algorithm': 'LB_ALGORITHM_LEAST_CONNECTIONS',
            'use_service_port': False,
            'server_auto_scale': False,
            'host_check_enabled': False,
            'enabled': True,
            'capacity_estimation': False,
            'fewest_tasks_feedback_delay': 10,
            '_last_modified': u'1471377748747040',
            'cloud_ref': u'https://10.130.2.252/api/cloud/cloud-afe8bf2c-9821-4272-9bc6-67634c84bec9',
            'vrf_ref': u'https://10.130.2.252/api/vrfcontext/vrfcontext-0e8ce760-fed2-4650-9397-5b3e4966376e',
            'inline_health_monitor': True,
            'default_server_port': 80,
            'request_queue_depth': 128,
            'graceful_disable_timeout': 1,
            'server_count': 0,
            'sni_enabled': True,
            'request_queue_enabled': False,
            'name': u'testpool',
            'max_concurrent_connections_per_server': 0,
            'url': 'https://10.130.2.252/api/pool/pool-20084ee1-872e-4103-98e1-899103e2242a',
            'tenant_ref': u'https://10.130.2.252/api/tenant/admin',
            'uuid': u'pool-20084ee1-872e-4103-98e1-899103e2242a',
            'connection_ramp_duration': 10
            }
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()