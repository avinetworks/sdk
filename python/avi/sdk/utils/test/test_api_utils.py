'''
Created on Aug 16, 2016

@author: grastogi
'''
import unittest
from avi.sdk.utils.ansible_utils import cleanup_absent_fields, avi_obj_cmp


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

    def test_avi_obj_cmp_w_refs_n_name(self):
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
                "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9#System-HTTP",
                "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc8",
                ],
            }

        obj = {'name': 'testpool',
               'health_monitor_refs': ['https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9',
                                       "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc8"],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

        obj = {'name': 'testpool',
               'health_monitor_refs': [
                   'https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9#System-HTTP',
                   "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc8"],
               'server_count': 0}
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

        obj = {'name': 'testpool',
               'health_monitor_refs': [
                   'https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc9#System-HTTP',
                   "https://10.130.2.252/api/healthmonitor/healthmonitor-6d07b57f-126b-476c-baba-a8c8c8b06dc8#System-HTTP2"],
               'server_count': 0,
               'cloud_ref': u'https://10.130.2.252/api/cloud/cloud-afe8bf2c-9821-4272-9bc6-67634c84bec9#Default-Cloud',
               }
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

    def test_avi_list_update(self):
        existing_obj = {
            'services': [
                {
                    "enable_ssl": False,
                    "port_range_end": 80,
                    "port": 80
                },
                {
                    "enable_ssl": False,
                    "port_range_end": 443,
                    "port": 443
                }
            ],
            "name": "vs-health-test",
            "url": "https://10.10.25.42/api/virtualservice/virtualservice-526c55c2-df89-40b9-9de6-e45a472290aa",
        }

        obj = {
            'services': [
                {
                    "enable_ssl": False,
                    "port_range_end": 80,
                    "port": 80
                }
            ]
        }

        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff

        obj = {
            'services': [
                {
                    "enable_ssl": False,
                    "port_range_end": 80,
                    "port": 80
                },
                {
                    "enable_ssl": False,
                    "port_range_end": 443,
                    "port": None
                }
            ],
            "name": "vs-health-test",
            "url": "https://10.10.25.42/api/virtualservice/virtualservice-526c55c2-df89-40b9-9de6-e45a472290aa",
        }

        diff = avi_obj_cmp(obj, existing_obj)
        assert not diff

    def test_cleanup_abset(self):
        obj = {'x': 10, 'y': {'state': 'absent'},
               'z': {'a': {'state': 'absent'}}}
        cleanup_absent_fields(obj)

        assert 'y' not in obj
        assert 'a' not in obj['z']

    def test_complex_obj(self):

        obj = {
            u'lb_algorithm': u'LB_ALGORITHM_ROUND_ROBIN',
            u'use_service_port': False, u'server_auto_scale': False,
            u'host_check_enabled': False,
            u'tenant_ref': u'https://10.10.25.42/api/tenant/admin#admin',
            u'capacity_estimation': False,
            u'servers': [
                {u'hostname': u'grastogi-server6', u'ratio': 1,
                 u'ip': {u'type': u'V4', u'addr': u'10.90.64.62'},
                 u'discovered_networks': [
                     {u'subnet': [
                         {u'ip_addr': {
                             u'type': u'V4', u'addr': u'10.90.64.0'},
                          u'mask': 24}],
                      u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10#PG-964'}],
                 u'enabled': True, u'nw_ref': u'https://10.10.25.42/api/vimgrnwruntime/dvportgroup-53975-10.10.2.10#PG-964', u'verify_network': False, u'static': False, u'resolve_server_by_dns': False, u'external_uuid': u'vm-4230615e-bc0b-3d33-3929-1c7328575993', u'vm_ref': u'https://10.10.25.42/api/vimgrvmruntime/vm-4230615e-bc0b-3d33-3929-1c7328575993#grastogi-server6'}, {u'hostname': u'grastogi-server6', u'ratio': 1, u'ip': {u'type': u'V4', u'addr': u'10.90.64.61'}, u'discovered_networks': [{u'subnet': [{u'ip_addr': {u'type': u'V4', u'addr': u'10.90.64.0'}, u'mask': 24}], u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10#PG-964'}], u'enabled': True, u'nw_ref': u'https://10.10.25.42/api/vimgrnwruntime/dvportgroup-53975-10.10.2.10#PG-964', u'verify_network': False, u'static': False, u'resolve_server_by_dns': False, u'external_uuid': u'vm-4230615e-bc0b-3d33-3929-1c7328575993', u'vm_ref': u'https://10.10.25.42/api/vimgrvmruntime/vm-4230615e-bc0b-3d33-3929-1c7328575993#grastogi-server6'}, {u'hostname': u'grastogi-server6', u'ratio': 1, u'ip': {u'type': u'V4', u'addr': u'10.90.64.65'}, u'discovered_networks': [{u'subnet': [{u'ip_addr': {u'type': u'V4', u'addr': u'10.90.64.0'}, u'mask': 24}], u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10#PG-964'}], u'enabled': True, u'verify_network': False, u'static': False, u'resolve_server_by_dns': False}], u'fewest_tasks_feedback_delay': 10, u'_last_modified': u'1473292763246107', u'cloud_ref': u'https://10.10.25.42/api/cloud/cloud-e0696a58-8b72-4026-923c-9a87c38a2489#Default-Cloud', u'vrf_ref': u'https://10.10.25.42/api/vrfcontext/vrfcontext-33dfbcd7-867c-4e3e-acf7-96bf679d5a0d#global', u'inline_health_monitor': True, u'default_server_port': 8000, u'request_queue_depth': 128, u'graceful_disable_timeout': 1, u'sni_enabled': True, u'server_count': 3, u'uuid': u'pool-09201181-747e-41ea-872d-e9a7df71b726', u'request_queue_enabled': False, u'name': u'p1', u'max_concurrent_connections_per_server': 0, u'url': u'https://10.10.25.42/api/pool/pool-09201181-747e-41ea-872d-e9a7df71b726#p1',
            u'enabled': True,
            u'connection_ramp_duration': 10}

        existing_obj = {
            u'lb_algorithm': u'LB_ALGORITHM_ROUND_ROBIN',
            u'use_service_port': False,
            u'server_auto_scale': False,
            u'host_check_enabled': False,
            u'tenant_ref': u'https://10.10.25.42/api/tenant/admin',
            u'capacity_estimation': False,
            u'servers': [
                {u'hostname': u'grastogi-server6', u'ratio': 1,
                 u'ip': {u'type': u'V4', u'addr': u'10.90.64.62'},
                 u'discovered_networks': [
                     {u'subnet': [
                         {u'mask': 24,
                          u'ip_addr': {
                              u'type': u'V4', u'addr': u'10.90.64.0'}}], u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10'}], u'enabled': True, u'nw_ref': u'https://10.10.25.42/api/vimgrnwruntime/dvportgroup-53975-10.10.2.10', u'verify_network': False, u'static': False, u'resolve_server_by_dns': False, u'external_uuid': u'vm-4230615e-bc0b-3d33-3929-1c7328575993', u'vm_ref': u'https://10.10.25.42/api/vimgrvmruntime/vm-4230615e-bc0b-3d33-3929-1c7328575993'}, {u'hostname': u'grastogi-server6', u'ratio': 1, u'ip': {u'type': u'V4', u'addr': u'10.90.64.61'}, u'discovered_networks': [{u'subnet': [{u'mask': 24, u'ip_addr': {u'type': u'V4', u'addr': u'10.90.64.0'}}], u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10'}], u'enabled': True, u'nw_ref': u'https://10.10.25.42/api/vimgrnwruntime/dvportgroup-53975-10.10.2.10', u'verify_network': False, u'static': False, u'resolve_server_by_dns': False, u'external_uuid': u'vm-4230615e-bc0b-3d33-3929-1c7328575993', u'vm_ref': u'https://10.10.25.42/api/vimgrvmruntime/vm-4230615e-bc0b-3d33-3929-1c7328575993'}, {u'hostname': u'grastogi-server6', u'ratio': 1, u'ip': {u'type': u'V4', u'addr': u'10.90.64.65'}, u'discovered_networks': [{u'subnet': [{u'mask': 24, u'ip_addr': {u'type': u'V4', u'addr': u'10.90.64.0'}}], u'network_ref': u'https://10.10.25.42/api/network/dvportgroup-53975-10.10.2.10'}], u'enabled': True, u'nw_ref': u'https://10.10.25.42/api/vimgrnwruntime/dvportgroup-53975-10.10.2.10', u'verify_network': False, u'static': False, u'resolve_server_by_dns': False, u'external_uuid': u'vm-4230615e-bc0b-3d33-3929-1c7328575993', u'vm_ref': u'https://10.10.25.42/api/vimgrvmruntime/vm-4230615e-bc0b-3d33-3929-1c7328575993'}], u'fewest_tasks_feedback_delay': 10, u'cloud_ref': u'https://10.10.25.42/api/cloud/cloud-e0696a58-8b72-4026-923c-9a87c38a2489', u'vrf_ref': u'https://10.10.25.42/api/vrfcontext/vrfcontext-33dfbcd7-867c-4e3e-acf7-96bf679d5a0d', u'inline_health_monitor': True, u'default_server_port': 8000, u'request_queue_depth': 128, u'graceful_disable_timeout': 1, u'sni_enabled': True, u'server_count': 3, u'uuid': u'pool-09201181-747e-41ea-872d-e9a7df71b726', u'request_queue_enabled': False, u'name': u'p1', u'max_concurrent_connections_per_server': 0,
                        u'url': u'https://10.10.25.42/api/pool/pool-09201181-747e-41ea-872d-e9a7df71b726',
                        u'enabled': True,
                        u'connection_ramp_duration': 10}

        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()