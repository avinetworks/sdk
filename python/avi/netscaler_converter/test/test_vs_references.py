import unittest
import json
import os
import re
import urlparse


def setUp():
    global avi_config
    output_file = open('output/Output.json', 'r')
    output_data = output_file.read()
    avi_config = json.loads(output_data)


def get_name(url):
    parsed = urlparse.urlparse(url)
    return urlparse.parse_qs(parsed.query)['name'][0]


class VSReferences(unittest.TestCase):
    def test_run_input_config_over_ns_tool(self):
        os.system('python netscaler_converter.py -f '
                  'test/input_vs_configuration.conf')

    def test_http_policies_references_vs(self):
        avi_config_vs = avi_config.get('VirtualService', [])
        for vs in avi_config_vs:
            if vs.get('http_policies', []):
                policies = vs.get('http_policies')
                for policy in policies:
                    assert policy['http_policy_set_ref']
                    http_policy_set_ref = policy['http_policy_set_ref']
                    http_policy_set_name = get_name(http_policy_set_ref)
                    http_policy_set = \
                        [http_policy_set for http_policy_set in
                         avi_config['HTTPPolicySet']
                         if http_policy_set['name'] == http_policy_set_name]
                    self.assertEqual(len(http_policy_set), 1)
                    if http_policy_set[0].get('http_request_policy', None):
                        rules = \
                            http_policy_set[0]['http_request_policy'].\
                                get('rules', [])
                        for rule in rules:
                            if rule.get('switching_action', None):
                                assert \
                                    rule['switching_action']['pool_group_ref']
                                pool_group_ref = \
                                    rule['switching_action']['pool_group_ref']
                                pool_group_name = get_name(pool_group_ref)
                                pool_group = [pool_group for pool_group in
                                              avi_config['PoolGroup'] if
                                              pool_group['name'] ==
                                              pool_group_name]
                                self.assertEqual(len(pool_group), 1)
                                members = pool_group[0]['members']
                                assert members
                                for member in members:
                                    assert member['pool_ref']
                                    pool_ref = member['pool_ref']
                                    pool_name = get_name(pool_ref)
                                    pool = [pool for pool in avi_config['Pool']
                                            if pool['name'] == pool_name]
                                    self.assertEqual(len(pool), 1)
                                    # Health monitor ref
                                    health_monitor_refs = \
                                        pool[0]['health_monitor_refs']
                                    for health_monitor_ref in \
                                            health_monitor_refs:
                                        health_monitor_name = \
                                            get_name(health_monitor_ref)
                                        hm = [hm for hm in
                                              avi_config['HealthMonitor'] if
                                              hm['name'] == health_monitor_name]
                                        self.assertEqual(len(hm), 1)
                                    # ssl profile ref
                                    ssl_profile_ref = \
                                        pool[0].get('ssl_profile_ref', None)
                                    if ssl_profile_ref:
                                        ssl_profile_name = \
                                            get_name(ssl_profile_ref)
                                        ssl_profile = [ssl_profile for
                                                       ssl_profile in
                                                       avi_config['SSLProfile']
                                                       if ssl_profile['name'] ==
                                                       ssl_profile_name]
                                        self.assertEqual(len(ssl_profile), 1)

                                        # ssl key and cert ref
                                    ssl_key_and_cert_ref = \
                                        pool[0].get(
                                            'ssl_key_and_certificate_ref', None)
                                    if ssl_key_and_cert_ref:
                                        ssl_key_and_cert_name = \
                                            get_name(ssl_key_and_cert_ref)
                                        ssl_key_and_cert = [ssl_key_and_cert for
                                                            ssl_key_and_cert in
                                                            avi_config[
                                                                'SSLKeyAndCertificate']
                                                            if ssl_key_and_cert[
                                                                'name'] == ssl_key_and_cert_name]
                                        self.assertEqual(len(ssl_key_and_cert),
                                                         1)

    def test_pool_groups_references_vs(self):
        avi_config_vs = avi_config.get('VirtualService', [])
        for vs in avi_config_vs:
            if vs.get('pool_group_ref', {}):
                pool_group_ref = vs.get('pool_group_ref')
                pool_group_name = get_name(pool_group_ref)
                pool_group = [pool_group for pool_group in
                              avi_config['PoolGroup']
                              if pool_group['name'] == pool_group_name]
                self.assertEqual(len(pool_group), 1)
                members = pool_group[0]['members']
                assert members
                for member in members:
                    assert member['pool_ref']
                    pool_ref = member['pool_ref']
                    pool_name = get_name(pool_ref)
                    pool = [pool for pool in avi_config['Pool']
                            if pool['name'] == pool_name]
                    self.assertEqual(len(pool), 1)
                    # Health monitor ref
                    health_monitor_refs = pool[0]['health_monitor_refs']
                    for health_monitor_ref in health_monitor_refs:
                        health_monitor_name = get_name(health_monitor_ref)
                        hm = [hm for hm in avi_config['HealthMonitor']
                              if hm['name'] == health_monitor_name]
                        self.assertEqual(len(hm), 1)
                    # ssl profile ref
                    ssl_profile_ref = pool[0].get('ssl_profile_ref', None)
                    if ssl_profile_ref:
                        ssl_profile_name = get_name(ssl_profile_ref)
                        ssl_profile = [ssl_profile for ssl_profile in
                                       avi_config['SSLProfile']
                                       if ssl_profile['name'] ==
                                       ssl_profile_name]
                        self.assertEqual(len(ssl_profile), 1)

                     # ssl key and cert ref
                    ssl_key_and_cert_ref = \
                        pool[0].get('ssl_key_and_certificate_ref', None)
                    if ssl_key_and_cert_ref:
                        ssl_key_and_cert_name = get_name(ssl_key_and_cert_ref)
                        ssl_key_and_cert = [ssl_key_and_cert for ssl_key_and_cert in
                                       avi_config['SSLKeyAndCertificate'] if
                                            ssl_key_and_cert['name'] ==
                                            ssl_key_and_cert_name]
                        self.assertEqual(len(ssl_key_and_cert), 1)


    def test_ssl_profile_reference_vs(self):
        avi_config_vs = avi_config.get('VirtualService', [])
        for vs in avi_config_vs:
            if vs.get('ssl_profile_name', None):
                ssl_profile_ref = \
                    ((re.search(r"name=.*",
                                vs.get('ssl_profile_name')).group(0)).
                     split('='))[1]
                ssl_profile = [profile for profile in avi_config['SSLProfile']
                               if profile['name'] == ssl_profile_ref]
                self.assertEqual(len(ssl_profile), 1)

    def test_ssl_key_and_cert_reference_vs(self):
        avi_config_vs = avi_config.get('VirtualService', [])
        for vs in avi_config_vs:
            if vs.get('ssl_key_and_certificate_refs', []):
                for ssl_key_and_certificate_ref in \
                        vs.get('ssl_key_and_certificate_refs'):
                    ssl_key_and_certificate_ref = \
                        ((re.search(r"name=.*",
                                    ssl_key_and_certificate_ref).group(0)).
                         split('='))[1]
                    ssl_cert_key = \
                        [key_cert for key_cert in
                         avi_config['SSLKeyAndCertificate']
                         if key_cert['name'] == ssl_key_and_certificate_ref]
                    self.assertEqual(len(ssl_cert_key), 1)


if __name__ == '__main__':
    unittest.main()