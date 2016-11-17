import logging
import os
import unittest
import json

from avi.netscaler_converter.lbvs_converter import LbvsConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


import logging
import os
import unittest
import json

from avi.netscaler_converter.csvs_converter import CsvsConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)
    cfg_file = open('test_policy_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    LOG.debug(' read cofig %s', gSAMPLE_CONFIG)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)


class Test(unittest.TestCase):
    policy_converter_obj = CsvsConverter()

    def test_http_req_url_path_and_query_contains_policy_conversion(self):
        avi_config = dict()
        avi_config['HTTPPolicySet'] = []
        new_rule_index, policy = self.policy_converter_obj.policy_converter(gSAMPLE_CONFIG['HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS'], 0)

        assert policy is not None
        avi_config['HTTPPolicySet'].append(policy)
        assert avi_config
        policies = avi_config.get('HTTPPolicySet', [])
        assert len(policies) > 0
        policy = policies[0]
        match_str = ["soacomposer", "integrationworklistapp"]
        assert policy['http_request_policy']['match']['query']['match_case'] == 'INSENSITIVE'
        assert policy['http_request_policy']['match']['query']['match_criteria'] == 'QUERY_MATCH_CONTAINS'
        assert policy['http_request_policy']['match']['query']['match_str'] == match_str
        pool_ref = gSAMPLE_CONFIG['HTTP.REQ.URL.PATH_AND_QUERY.CONTAINS']['targetLBVserver'] + "-pool"
        assert policy['http_request_policy']['switching_action']['pool_ref'] == pool_ref

    def test_req_ip_sourceip_policy_conversion(self):
        avi_config = dict()
        avi_config['HTTPPolicySet'] = []
        new_rule_index, policy = self.policy_converter_obj.policy_converter(
            gSAMPLE_CONFIG['REQ.IP.SOURCEIP'], 0)

        assert policy is not None
        avi_config['HTTPPolicySet'].append(policy)

        assert avi_config
        policies = avi_config.get('HTTPPolicySet', [])
        assert len(policies) > 0
        policy = policies[0]

        assert policy['http_request_policy']['match']['client_ip']['match_criteria'] == 'IS_IN'
        assert policy['http_request_policy']['match']['client_ip']['addrs'][0]["addr"] == "172.30.68.92"
        pool_ref = gSAMPLE_CONFIG['REQ.IP.SOURCEIP']['targetLBVserver'] + "-pool"
        assert policy['http_request_policy']['switching_action']['pool_ref'] == pool_ref

    def test_client_ip_src_eq_policy_conversion(self):
        avi_config = dict()
        avi_config['HTTPPolicySet'] = []
        new_rule_index, policy = self.policy_converter_obj.policy_converter(
            gSAMPLE_CONFIG['CLIENT.IP.SRC.EQ'], 0)

        assert policy is not None
        avi_config['HTTPPolicySet'].append(policy)

        assert avi_config
        policies = avi_config.get('HTTPPolicySet', [])
        assert len(policies) > 0
        policy = policies[0]
        assert policy['http_request_policy']['match']['client_ip']['match_criteria'] == 'IS_IN'
        assert policy['http_request_policy']['match']['client_ip']['addrs'][0]["addr"] == "172.30.68.211"
        pool_ref = gSAMPLE_CONFIG['CLIENT.IP.SRC.EQ']['targetLBVserver'] + "-pool"
        assert policy['http_request_policy']['switching_action']['pool_ref'] == pool_ref

    def test_http_req_url_path_startswith_policy_conversion(self):
        avi_config = dict()
        avi_config['HTTPPolicySet'] = []
        new_rule_index, policy = self.policy_converter_obj.policy_converter(
            gSAMPLE_CONFIG['HTTP.REQ.URL.PATH.STARTSWITH'], 0)

        assert policy is not None
        avi_config['HTTPPolicySet'].append(policy)

        assert avi_config
        policies = avi_config.get('HTTPPolicySet', [])
        assert len(policies) > 0
        policy = policies[0]
        assert policy['http_request_policy']['match']['query']['match_case'] == 'INSENSITIVE'
        assert policy['http_request_policy']['match']['query']['match_criteria'] == 'QUERY_MATCH_CONTAINS'
        assert policy['http_request_policy']['match']['query']['match_str'] == "mountwatch"
        pool_ref = gSAMPLE_CONFIG['HTTP.REQ.URL.PATH.STARTSWITH']['targetLBVserver'] + "-pool"
        assert policy['http_request_policy']['switching_action']['pool_ref'] == pool_ref

    def test_http_req_hostname_eq_policy_conversion(self):
        avi_config = dict()
        avi_config['HTTPPolicySet'] = []
        new_rule_index, policy = self.policy_converter_obj.policy_converter(
            gSAMPLE_CONFIG['HTTP.REQ.HOSTNAME.EQ'], 0)

        assert policy is not None
        avi_config['HTTPPolicySet'].append(policy)

        assert avi_config
        policies = avi_config.get('HTTPPolicySet', [])
        assert len(policies) > 0
        policy = policies[0]
        assert policy['http_request_policy']['match']['host_hdr']['match_case'] == 'INSENSITIVE'
        assert policy['http_request_policy']['match']['host_hdr']['match_criteria'] == 'HDR_EQUALS'
        assert policy['http_request_policy']['match']['host_hdr']['value'][0] == "ks-lb.qualcomm.com"
        pool_ref = gSAMPLE_CONFIG['HTTP.REQ.HOSTNAME.EQ']['targetLBVserver'] + "-pool"
        assert policy['http_request_policy']['switching_action']['pool_ref'] == pool_ref

