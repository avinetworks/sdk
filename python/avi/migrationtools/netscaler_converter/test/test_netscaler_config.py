"""
This provides an initial test cases for entity count, vs references and code
coverage
"""
import os
import json
import re
import urlparse

from avi.migrationtools.netscaler_converter.netscaler_converter import NetscalerConverter


def netscaler_converter(config_file_name):
    args = Namespace(
        ns_config_file=config_file_name, tenant='admin', cloud_name='Default-Cloud',
        input_folder_location='certs', output_file_path=None,
        option='cli-upload', user='admin', password='avi123',
        controller_ip=None, vs_state='disable', controller_version='17.1',
        ns_host_ip=None, ns_ssh_user=None, ns_ssh_password=None, ns_key_file=None,
        ns_passphrase_file=None, version=None, no_profile_merge=True,
        patch=None, vs_filter=None, ignore_config=None, prefix='abc')
    netscaler_converter = NetscalerConverter(args)
    avi_config = netscaler_converter.convert()
    return avi_config

def get_output_config(report_name):
    output_file = open('output/%s-Output.json' % report_name, 'r')
    output_data = output_file.read()
    return json.loads(output_data)


def count_of_all_entity(avi_config, report_name):
    output_config = get_output_config(report_name)
    for entity in avi_config:
        assert len(avi_config[entity]) == len(output_config[entity])

def check_references(avi_config):
    http_policies_references_vs(avi_config)
    pool_groups_references_vs(avi_config)
    ssl_profile_reference_vs(avi_config)
    ssl_key_and_cert_reference_vs(avi_config)


def get_name(url):
    """
    This function defines that return name object from url
    :param url:
    :return: Name of object
    """
    parsed = urlparse.urlparse(url)
    return urlparse.parse_qs(parsed.query)['name'][0]


def http_policies_references_vs(avi_config):
    """
    This test case defines that verify all references from http policy sets
    of VS
    :return: None
    """

    # Get all VS from avi config
    avi_config_vs = avi_config.get('VirtualService', [])
    for vs in avi_config_vs:
        # check if vs has http policy ref
        if vs.get('http_policies', []):
            policies = vs.get('http_policies')
            for policy in policies:
                assert policy['http_policy_set_ref']
                http_policy_set_ref = policy['http_policy_set_ref']
                http_policy_set_name = get_name(http_policy_set_ref)

                # Get object of http policy set if VS has http policy ref
                http_policy_set = \
                    [http_policy_set for http_policy_set in
                     avi_config['HTTPPolicySet']
                     if http_policy_set['name'] == http_policy_set_name]
                assert len(http_policy_set) == 1
                if http_policy_set[0].get('http_request_policy', None):
                    rules = \
                        http_policy_set[0]['http_request_policy']. \
                            get('rules', [])
                    for rule in rules:
                        # Check for pool ref if rule has switching action
                        if rule.get('switching_action', None):
                            assert \
                                rule['switching_action']['pool_group_ref']
                            pool_group_ref = \
                                rule['switching_action']['pool_group_ref']
                            pool_group_name = get_name(pool_group_ref)

                            # Get the pool group if switching action has
                            # pool group ref
                            pool_group = [pool_group for pool_group in
                                          avi_config['PoolGroup'] if
                                          pool_group['name'] ==
                                          pool_group_name]
                            assert len(pool_group) == 1

                            # Check for members
                            members = pool_group[0]['members']
                            assert members
                            for member in members:
                                assert member['pool_ref']
                                pool_ref = member['pool_ref']
                                pool_name = get_name(pool_ref)

                                # Get the pool object if pool group has
                                # pool ref
                                pool = [pool for pool in avi_config['Pool']
                                        if pool['name'] == pool_name]
                                assert len(pool) == 1

                                # Get Health monitor object from health
                                # monitor ref
                                health_monitor_refs = \
                                    pool[0]['health_monitor_refs']
                                for health_monitor_ref in \
                                        health_monitor_refs:
                                    health_monitor_name = \
                                        get_name(health_monitor_ref)
                                    hm = [hm for hm in
                                          avi_config['HealthMonitor'] if
                                          hm['name'] == health_monitor_name]
                                    assert len(hm) == 1

                                # Get ssl profile object from ssl profile
                                # ref
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
                                    assert len(ssl_profile) == 1

                                # Get ssl key and cert object from ssl key
                                # and cert ref
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
                                    assert len(ssl_key_and_cert) == 1


def pool_groups_references_vs(avi_config):
    """
    This test case defines that verify all references from pool group of VS
    :return: None
    """

    # Get VS from avi config
    avi_config_vs = avi_config.get('VirtualService', [])
    for vs in avi_config_vs:
        # Check for pool group ref in VS
        if vs.get('pool_group_ref', {}):
            pool_group_ref = vs.get('pool_group_ref')
            pool_group_name = get_name(pool_group_ref)

            # Get pool group object if pool group ref in VS
            pool_group = [pool_group for pool_group in
                          avi_config['PoolGroup']
                          if pool_group['name'] == pool_group_name]
            assert len(pool_group) == 1

            # Get members from pool group object
            members = pool_group[0]['members']
            assert members
            for member in members:
                assert member['pool_ref']
                pool_ref = member['pool_ref']
                pool_name = get_name(pool_ref)

                # Get pool object from pool ref
                pool = [pool for pool in avi_config['Pool']
                        if pool['name'] == pool_name]
                assert len(pool) == 1

                # Get Health monitor object from health monitor ref
                health_monitor_refs = pool[0]['health_monitor_refs']
                for health_monitor_ref in health_monitor_refs:
                    health_monitor_name = get_name(health_monitor_ref)
                    hm = [hm for hm in avi_config['HealthMonitor']
                          if hm['name'] == health_monitor_name]
                    assert len(hm) == 1

                # Get ssl profile object from ssl profile ref
                ssl_profile_ref = pool[0].get('ssl_profile_ref', None)
                if ssl_profile_ref:
                    ssl_profile_name = get_name(ssl_profile_ref)
                    ssl_profile = [ssl_profile for ssl_profile in
                                   avi_config['SSLProfile']
                                   if ssl_profile['name'] ==
                                   ssl_profile_name]
                    assert len(ssl_profile) == 1

                # Get ssl_key_and_certificate object from
                # ssl_key_and_certificate_ref
                ssl_key_and_cert_ref = \
                    pool[0].get('ssl_key_and_certificate_ref', None)
                if ssl_key_and_cert_ref:
                    ssl_key_and_cert_name = get_name(ssl_key_and_cert_ref)
                    ssl_key_and_cert = [ssl_key_and_cert for ssl_key_and_cert in
                                        avi_config['SSLKeyAndCertificate'] if
                                        ssl_key_and_cert['name'] ==
                                        ssl_key_and_cert_name]
                    assert len(ssl_key_and_cert) == 1


def ssl_profile_reference_vs(avi_config):
    """
    This test case defines that verify all references of ssl profile of VS
    :return: None
    """

    # Get VS from avi config
    avi_config_vs = avi_config.get('VirtualService', [])
    for vs in avi_config_vs:
        # Changed ssl profile name to ssl profile ref.
        if vs.get('ssl_profile_ref', None):
            ssl_profile_ref = \
                ((re.search(r"name=.*",
                            vs.get('ssl_profile_ref')).group(0)).
                 split('='))[1]

            # Get ssl profile object if VS has ssl profile name
            ssl_profile = [profile for profile in avi_config['SSLProfile']
                           if profile['name'] == ssl_profile_ref]
            assert len(ssl_profile) == 1


def ssl_key_and_cert_reference_vs(avi_config):
    """
    This test case defines that verify all references of ssl key and
    certificate of VS
    :return:
    """

    # Get VS from avi config
    avi_config_vs = avi_config.get('VirtualService', [])
    for vs in avi_config_vs:
        if vs.get('ssl_key_and_certificate_refs', []):
            for ssl_key_and_certificate_ref in \
                    vs.get('ssl_key_and_certificate_refs'):
                ssl_key_and_certificate_ref = \
                    ((re.search(r"name=.*",
                                ssl_key_and_certificate_ref).group(0)).
                     split('='))[1]

                # Get ssl_key_and_certificate object if VS has
                # ssl_key_and_certificate_refs
                ssl_cert_key = \
                    [key_cert for key_cert in
                     avi_config['SSLKeyAndCertificate']
                     if key_cert['name'] == ssl_key_and_certificate_ref]
                assert len(ssl_cert_key) == 1


def check_prefix(avi_config, prefix):
    """

    :param avi_config: Output of avi config dict
    :param prefix: prefix for objects
    :return: None
    """
    for key in avi_config:
        if key == "META":
            continue
        object_list = avi_config[key]
        for obj in object_list:
            assert prefix in obj['name']


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)

class TestNetscalerConverter():
    def test_netscaler_converter(self, config_file_name):
        avi_config = netscaler_converter(config_file_name)
        report_name = os.path.splitext(os.path.basename(config_file_name))[0]
        count_of_all_entity(avi_config, report_name)
        check_references(avi_config)
        check_prefix(avi_config, 'abc')
