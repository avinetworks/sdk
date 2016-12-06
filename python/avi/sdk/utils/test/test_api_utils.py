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

    def testAWSVs(self):
        existing_obj = {u'network_profile_ref': u'https://12.97.16.202/api/networkprofile/networkprofile-9a0a9896-6876-44c8-a3ee-512a968905f2#System-TCP-Proxy', u'port_uuid': u'eni-4144e73c', u'weight': 1, u'availability_zone': u'us-west-2a', u'enabled': True, u'flow_dist': u'LOAD_AWARE', u'subnet_uuid': u'subnet-91f0b6f4', u'delay_fairness': False, u'avi_allocated_vip': True,
                        u'vrf_context_ref': u'https://12.97.16.202/api/vrfcontext/vrfcontext-722b280d-b555-4d82-9b35-af9442c0cb86#global',
                        u'subnet': {u'ip_addr': {u'type': u'V4', u'addr': u'10.144.0.0'}, u'mask': 24},
                        u'cloud_type': u'CLOUD_AWS', u'uuid': u'virtualservice-a5f49b99-22c8-42e6-aa65-3ca5f1e36b9e',
                        u'network_ref': u'https://12.97.16.202/api/network/subnet-91f0b6f4',
                        u'cloud_ref': u'https://12.97.16.202/api/cloud/cloud-49829414-c704-43ca-9dff-05b9e8474dcb#AWS Cloud', u'avi_allocated_fip': False, u'se_group_ref': u'https://12.97.16.202/api/serviceenginegroup/serviceenginegroup-3bef6320-5a2d-4801-85c4-ef4f9841f235#Default-Group', u'scaleout_ecmp': False, u'max_cps_per_client': 0, u'type': u'VS_TYPE_NORMAL', u'analytics_profile_ref': u'https://12.97.16.202/api/analyticsprofile/analyticsprofile-70f8b06f-7b6a-4500-b829-c869bbca2009#System-Analytics-Profile', u'use_bridge_ip_as_vip': False, u'application_profile_ref': u'https://12.97.16.202/api/applicationprofile/applicationprofile-103cbc31-cac5-46ab-8e66-bbbb2c8f551f#System-HTTP', u'auto_allocate_floating_ip': False, u'services': [{u'enable_ssl': False, u'port_range_end': 80, u'port': 80}], u'active_standby_se_tag': u'ACTIVE_STANDBY_SE_1', u'ip_address': {u'type': u'V4', u'addr': u'10.144.0.33'}, u'ign_pool_net_reach': False, u'east_west_placement': False, u'limit_doser': False, u'name': u'wwwawssit.ebiz.verizon.com', u'url': u'https://12.97.16.202/api/virtualservice/virtualservice-a5f49b99-22c8-42e6-aa65-3ca5f1e36b9e#wwwawssit.ebiz.verizon.com', u'ssl_sess_cache_avg_size': 1024, u'enable_autogw': True, u'auto_allocate_ip': True, u'tenant_ref': u'https://12.97.16.202/api/tenant/tenant-f52f7a3e-6876-4bb9-b8f7-3cab636dadf2#Sales', u'remove_listening_port_on_vs_down': False
                        }
        obj = {'auto_allocate_ip': True, 'subnet_uuid': 'subnet-91f0b6f4', 'cloud_ref': '/api/cloud?name=AWS Cloud', 'services': [{'port': 80}],
               'name': 'wwwawssit.ebiz.verizon.com'}

        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

    def testhttppolicy(self):
        existing_obj = {
            "http_request_policy": {
                "rules": [
                    {"enable": True,
                     "index": 0,
                     "match": {
                         "path": {
                             "match_case": "INSENSITIVE",
                             "match_criteria": "CONTAINS",
                             "match_str": [
                                 "xvz",
                                 "rst"
                                 ]
                            }
                     },
                     "name": "blah",
                     "switching_action": {
                        "action": "HTTP_SWITCHING_SELECT_POOL",
                        "pool_ref": "https://12.97.16.202/api/pool/pool-d7f6f5e7-bd26-49ad-aeed-965719eb140b#abc",
                        "status_code": "HTTP_LOCAL_RESPONSE_STATUS_CODE_200"
                     }
                     }
                ]
            },
            "is_internal_policy": False,
            "name": "blah",
            "tenant_ref": "https://12.97.16.202/api/tenant/tenant-f52f7a3e-6876-4bb9-b8f7-3cab636dadf2#Sales",
            "url": "https://12.97.16.202/api/httppolicyset/httppolicyset-ffd8354b-671b-48d5-92cc-69a9057aad0c#blah",
            "uuid": "httppolicyset-ffd8354b-671b-48d5-92cc-69a9057aad0c"
        }

        obj = {
            "http_request_policy": {
                "rules": [
                    {"enable": True,
                     "index": "0",
                     "match": {
                         "path": {
                             "match_case": "INSENSITIVE",
                             "match_criteria": "CONTAINS",
                             "match_str": [
                                 "xvz", "rst"
                                 ]
                                }},
                     "name": "blah",
                     "switching_action": {
                         "action": "HTTP_SWITCHING_SELECT_POOL",
                         "pool_ref": "/api/pool?name=abc",
                         "status_code": "HTTP_LOCAL_RESPONSE_STATUS_CODE_200"
                         }
                     }
                ]
            },
            "is_internal_policy": False,
            "tenant": "Sales"
        }
        diff = avi_obj_cmp(obj, existing_obj)
        assert diff

    def testCleanupFields(self):
        obj = {'name': 'testpool',
               'scalar_field': {'state': 'absent'},
               'list_fields': [{'x': '1'}, {'y': {'state': 'absent'}}]}

        cleanup_absent_fields(obj)
        assert 'scalar_field' not in obj
        for elem in obj['list_fields']:
            assert 'y' not in elem

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()
