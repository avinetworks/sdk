import unittest
import json
import os
import re


def setUp():
    global avi_config
    output_file = open('output/Output.json', 'r')
    output_data = output_file.read()
    avi_config = json.loads(output_data)


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


    def test_ssl_profile_refernce_vs(self):
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

    def test_ssl_key_and_cert_refernce_vs(self):
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