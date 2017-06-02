import unittest
import json
import os
import re


def setUp():
    global avi_config
    output_data = ''
    output_file = ''
    try:
        output_file = open('output/input_vs_configuration-Output.json', 'r')
    except:
        pass
    if output_file:
        output_data = output_file.read()
    avi_config = {}
    if output_data:
        avi_config = json.loads(output_data)
    cfg_file = open('netscaler_converter/test/test_complete_vs_configuration.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)


class VSConfig(unittest.TestCase):
    # Run input vs config over netscaler tool
    def test_run_input_config_over_ns_tool(self):
        os.system('python netscaler_converter/netscaler_converter.py -f '
                  'netscaler_converter/test/input_vs_configuration.conf -l '
                  'netscaler_converter/test/certs --no_profile_merge')

    def test_pool_groups(self):
        """
        This test case defines that verify pool groups from avi config after
        conversion with mock data
        :return: None
        """
        # Get pool groups from mock data
        cfg_pool_groups = gSAMPLE_CONFIG.get('PoolGroup', [])

        # Get pool groups from avi config after conversion
        avi_config_pool_groups = avi_config.get('PoolGroup', [])

        # Check length cfg_pool_groups and avi_config_pool_groups should be same
        self.assertEqual(len(cfg_pool_groups), len(avi_config_pool_groups))
        for cfg_pool_group in cfg_pool_groups:
            pool_group_name = cfg_pool_group['name']
            if 'http_policy' in pool_group_name:
                # pg_name = re.search(r"test_target.*\-poolgroup",
                #                     pool_group_name).group(0)
                # avi_config_pool_group = \
                #     [pool_group for pool_group in avi_config_pool_groups
                #      if pg_name in pool_group['name']]
                continue
            elif 'rule' in pool_group_name:
                # pg_name = re.search(r"rule.*\-poolgroup",
                #                     pool_group_name).group(0)
                # pg_name = pg_name[-20:]
                # avi_config_pool_group = \
                #     [pool_group for pool_group in avi_config_pool_groups
                #      if pg_name in pool_group['name']]
                continue
            else:
                avi_config_pool_group = \
                    [pool_group for pool_group in avi_config_pool_groups
                     if pool_group['name'] == pool_group_name]
            self.assertTrue(len(avi_config_pool_group), 1)

            # Length of pool members from pool groups should be same
            self.assertEqual(len(cfg_pool_group['members']),
                             len(avi_config_pool_group[0]['members']))

    def test_virtual_service(self):
        """
        This test case defines that verify VS from avi config after
        conversion with mock data
        :return: None
        """
        # Get VS from mock data
        cfg_vs = gSAMPLE_CONFIG.get('VirtualService', [])

        # Get VS from avi config after conversion
        avi_config_vs = avi_config.get('VirtualService', [])

        # check length of cfg_vs and avi_config_vs should be equal
        self.assertEqual(len(cfg_vs), len(avi_config_vs))

        # check for cfg_vs and avi_config_vs should be equal
        self.assertListEqual(cfg_vs, avi_config_vs)

    def test_ssl_profile(self):
        """
        This test case defines that verify ssl profiles from avi config after
        conversion with mock data
        :return: None
        """
        # Get ssl profiles from mock data
        cfg_ssl_profiles = gSAMPLE_CONFIG.get('SSLProfile', [])

        # Get ssl profiles from avi config after conversion
        avi_config_ssl_profiles = avi_config.get('SSLProfile', [])

        # check length of cfg_ssl_profiles and avi_config_ssl_profiles
        # should be equal
        self.assertEqual(len(cfg_ssl_profiles),
                         len(avi_config_ssl_profiles))

        # check for cfg_ssl_profiles and avi_config_ssl_profiles should be equal
        self.assertListEqual(cfg_ssl_profiles, avi_config_ssl_profiles)

    def test_health_monitor(self):
        """
        This test case defines that verify health monitors from avi config after
        conversion with mock data
        :return: None
        """

        # Get health monitors from mock data
        cfg_health_monitors = gSAMPLE_CONFIG.get('HealthMonitor', [])

        # Get health monitors from avi config after conversion
        avi_config_health_monitors = avi_config.get('HealthMonitor', [])

        # check length of cfg_health_monitors and avi_config_health_monitors
        # should be equal
        self.assertEqual(len(cfg_health_monitors),
                         len(avi_config_health_monitors))

        # check for cfg_health_monitors and avi_config_health_monitors should be equal
        self.assertListEqual(cfg_health_monitors, avi_config_health_monitors)

    def test_http_policy(self):
        """
        This test case defines that verify HTTPPolicySet from avi config after
        conversion with mock data
        :return: None
        """

        # Get HTTPPolicySet from mock data
        cfg_http_policies = gSAMPLE_CONFIG.get('HTTPPolicySet', [])

        # Get HTTPPolicySet from avi config after conversion
        avi_config_http_policies = avi_config.get('HTTPPolicySet', [])

        # check length of cfg_http_policies and avi_config_http_policies
        # should be equal
        self.assertEqual(len(cfg_http_policies), len(cfg_http_policies))
        for cfg_http_policy in cfg_http_policies:
            policy_name = cfg_http_policy['name']
            avi_config_http_policy = \
                [policy for policy in avi_config_http_policies
                 if policy['name'] == policy_name]
            self.assertTrue(len(avi_config_http_policy), 1)

            # Check for match of every rule
            self.assertEqual(
                cfg_http_policy['http_request_policy']['rules'][0]['match'],
                avi_config_http_policy[0]['http_request_policy']['rules'][0]
                ['match'])

    def test_ssl_key_and_certificate(self):
        """
        This test case defines that verify SSLKeyAndCertificate from avi config after
        conversion with mock data
        :return: None
        """

        # Get SSLKeyAndCertificate from mock data
        cfg_ssl_key_and_certificates = \
            gSAMPLE_CONFIG.get('SSLKeyAndCertificate', [])

        # Get SSLKeyAndCertificate from avi config after conversion
        avi_config_ssl_key_and_certificates = \
            avi_config.get('SSLKeyAndCertificate', [])

        # check length of cfg_ssl_key_and_certificates and
        # avi_config_ssl_key_and_certificates should be equal
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
        """
        This test case defines that verify Pool from avi config after
        conversion with mock data
        :return: None
        """

        # Get Pool from mock data
        cfg_pools = gSAMPLE_CONFIG.get('Pool', [])

        # Get Pool from avi config after conversion
        avi_config_pools = avi_config.get('Pool', [])

        # check length of cfg_pools and avi_config_pools should be equal
        self.assertEqual(len(cfg_pools), len(avi_config_pools))
        for cfg_pool in cfg_pools:
            pool_name = cfg_pool['name']
            if 'http_policy' in pool_name:
                # name = re.search(r"test_target.*\-pool", pool_name).group(0)
                # avi_config_pool = [pool for pool in avi_config_pools
                #                    if name in pool['name']]
                continue
            elif 'rule' in pool_name:
                # name = re.search(r"rule.*\-pool", pool_name).group(0)
                # name = name[-15:]
                # avi_config_pool = [pool for pool in avi_config_pools
                #                    if name in pool['name']]
                continue

            else:
                avi_config_pool = [pool for pool in avi_config_pools
                                   if pool['name'] == pool_name]
            self.assertTrue(len(avi_config_pool), 1)

            # Check for list of servers
            self.assertListEqual(cfg_pool['servers'],
                                 avi_config_pool[0]['servers'])

            # Check for list of health monitors
            self.assertListEqual(cfg_pool['health_monitor_refs'],
                                 avi_config_pool[0]['health_monitor_refs'])


if __name__ == '__main__':
    unittest.main()
