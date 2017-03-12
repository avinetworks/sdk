import unittest
import json
import os
import re


def setUp():
    global avi_config
    output_file = open('output/Output.json', 'r')
    output_data = output_file.read()
    avi_config = json.loads(output_data)
    cfg_file = open('test/test_complete_vs_configuration.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)


class VSConfig(unittest.TestCase):
    def test_run_input_config_over_ns_tool(self):
        os.system('python netscaler_converter.py -f '
                  'test/input_vs_configuration.conf')

    def test_pool_groups(self):
        cfg_pool_groups = gSAMPLE_CONFIG.get('PoolGroup', [])
        avi_config_pool_groups = avi_config.get('PoolGroup', [])
        self.assertEqual(len(cfg_pool_groups), len(avi_config_pool_groups))
        for cfg_pool_group in cfg_pool_groups:
            pool_group_name = cfg_pool_group['name']
            if 'http_policy' in pool_group_name:
                pg_name = re.search(r"test_target.*\-poolgroup",
                                    pool_group_name).group(0)
                avi_config_pool_group = \
                    [pool_group for pool_group in avi_config_pool_groups
                     if pg_name in pool_group['name']]
            else:
                avi_config_pool_group = \
                    [pool_group for pool_group in avi_config_pool_groups
                     if pool_group['name'] == pool_group_name]
            self.assertTrue(len(avi_config_pool_group), 1)
            self.assertEqual(len(cfg_pool_group['members']),
                             len(avi_config_pool_group[0]['members']))

    def test_virtual_service(self):
        cfg_vs = gSAMPLE_CONFIG.get('VirtualService', [])
        avi_config_vs = avi_config.get('VirtualService', [])
        self.assertEqual(len(cfg_vs), len(avi_config_vs))
        self.assertListEqual(cfg_vs, avi_config_vs)

    def test_ssl_profile(self):
        cfg_ssl_profiles = gSAMPLE_CONFIG.get('SSLProfile', [])
        avi_config_ssl_profiles = avi_config.get('SSLProfile', [])
        self.assertEqual(len(cfg_ssl_profiles),
                         len(avi_config_ssl_profiles))
        self.assertListEqual(cfg_ssl_profiles, avi_config_ssl_profiles)

    def test_health_monitor(self):
        cfg_health_monitors = gSAMPLE_CONFIG.get('HealthMonitor', [])
        avi_config_health_monitors = avi_config.get('HealthMonitor', [])
        self.assertEqual(len(cfg_health_monitors),
                         len(avi_config_health_monitors))
        self.assertListEqual(cfg_health_monitors, avi_config_health_monitors)

    def test_http_policy(self):
        cfg_http_policies = gSAMPLE_CONFIG.get('HTTPPolicySet', [])
        avi_config_http_policies = avi_config.get('HTTPPolicySet', [])
        self.assertEqual(len(cfg_http_policies), len(cfg_http_policies))
        for cfg_http_policy in cfg_http_policies:
            policy_name = cfg_http_policy['name']
            avi_config_http_policy = \
                [policy for policy in avi_config_http_policies
                 if policy['name'] == policy_name]
            self.assertTrue(len(avi_config_http_policy), 1)
            self.assertEqual(
                cfg_http_policy['http_request_policy']['rules'][0]['match'],
                avi_config_http_policy[0]['http_request_policy']['rules'][0]
                ['match'])

    def test_ssl_key_and_certificate(self):
        cfg_ssl_key_and_certificates = \
            gSAMPLE_CONFIG.get('SSLKeyAndCertificate', [])
        avi_config_ssl_key_and_certificates = \
            avi_config.get('SSLKeyAndCertificate', [])
        self.assertEqual(len(cfg_ssl_key_and_certificates),
                         len(avi_config_ssl_key_and_certificates))
        for cfg_ssl_key_and_certificate in cfg_ssl_key_and_certificates:
            ssl_key_cert_name = cfg_ssl_key_and_certificate['name']
            avi_config_ssl_key_and_certificate = \
                [ssl_key_cert for ssl_key_cert in
                 avi_config_ssl_key_and_certificates
                 if ssl_key_cert['name'] == ssl_key_cert_name]
            self.assertTrue(len(avi_config_ssl_key_and_certificate), 1)


    def test_pools(self):
        cfg_pools = gSAMPLE_CONFIG.get('Pool', [])
        avi_config_pools = avi_config.get('Pool', [])
        self.assertEqual(len(cfg_pools), len(avi_config_pools))
        for cfg_pool in cfg_pools:
            pool_name = cfg_pool['name']
            if 'http_policy' in pool_name:
                name = re.search(r"test_target.*\-pool", pool_name).group(0)
                avi_config_pool = [pool for pool in avi_config_pools
                                   if name in pool['name']]
            else:
                avi_config_pool = [pool for pool in avi_config_pools
                                   if pool['name'] == pool_name]
            self.assertTrue(len(avi_config_pool), 1)
            self.assertListEqual(cfg_pool['servers'],
                                 avi_config_pool[0]['servers'])
            self.assertListEqual(cfg_pool['health_monitor_refs'],
                                 avi_config_pool[0]['health_monitor_refs'])


if __name__ == '__main__':
    unittest.main()
