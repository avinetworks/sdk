"""
This testsuite contains the initial test cases for testing the
converter tool along with its options / parameters
"""

import logging
import os
import pytest

from avi.migrationtools.netscaler_converter.netscaler_converter \
    import NetscalerConverter
from avi.migrationtools.test.common.excel_reader \
    import percentage_success, output_sanitization


setup = dict(
    controller_version='16.4.4',
    version=True,
    option='auto-upload',
    controller_ip_17_1_1='10.10.26.194',
    controller_user_17_1_1='admin',
    controller_password_17_1_1='avi123$%',
    controller_ip_16_4_4='10.10.26.253',
    controller_user_16_4_4='admin',
    controller_password_16_4_4='avi123',
    ns_host_ip='10.10.27.115',
    ns_ssh_user='nsroot',
    ns_ssh_password='nsroot',
    no_profile_merge=False,
    prefix='mig-tool-test',
    cloud_name='vmware',
    tenant='test',
    input_folder_location='',
    config_file_name='ns.conf',
    config_file_name_passphrase='ns_passphrase.conf',
    ns_passphrase_file='passphrase.yaml',
    ns_key_file='cd_rt_key.pem',
    ignore_config=os.path.abspath(os.path.dirname(__file__)) + os.sep + 'ignore-config.yaml',
    patch='patch.yml',
    vs_filter='vs_ksl.com,vs_NStoAvi-SG',
    not_in_use=True,
    baseline_profile=None
)


logging.basicConfig(filename="runlog.txt", level=logging.DEBUG)
mylogger = logging.getLogger()


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)


def netscaler_conv(
        config_file_name=None, tenant='admin', cloud_name='Default-Cloud',
        input_folder_location='certs', output_file_path='output',
        option='cli-upload', user=None, password=None, controller_ip=None,
        vs_state='disable', controller_version='17.1.1', ns_host_ip=None,
        ns_ssh_user=None, ns_ssh_password=None, ns_key_file=None,
        ns_passphrase_file=None, version=None, no_profile_merge=True,
        patch=None, vs_filter=None, ignore_config=None,
        prefix=None, not_in_use=False, baseline_profile=None):

    args = Namespace(
        ns_config_file=config_file_name, tenant=tenant, cloud_name=cloud_name,
        input_folder_location=input_folder_location,
        output_file_path=output_file_path, option=option, user=user,
        password=password, controller_ip=controller_ip, vs_state=vs_state,
        controller_version=controller_version, ns_host_ip=ns_host_ip,
        ns_ssh_user=ns_ssh_user, ns_ssh_password=ns_ssh_password,
        ns_key_file=ns_key_file, ns_passphrase_file=ns_passphrase_file,
        version=version, no_object_merge=no_profile_merge, patch=patch,
        vs_filter=vs_filter,  ignore_config=ignore_config, prefix=prefix,
        not_in_use=not_in_use, baseline_profile=baseline_profile)
    netscaler_converter = NetscalerConverter(args)
    avi_config = netscaler_converter.convert()
    return avi_config


class TestNetscalerConverter:

    @pytest.mark.travis
    def test_excel_report_16_4(self):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_17_1_1(self):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx',
                            './output/ns-Output.json')

    @pytest.mark.travis
    def test_excel_report_16_4(self):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_17_1_1(self):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                output_file_path='output')
        output_sanitization('./output/ns-ConversionStatus.xlsx',
                            './output/ns-Output.json')

    @pytest.mark.travis
    def test_without_options_17_1_1(self):
        """
        Input File on Local Filesystem, Controller v17.1.1
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'))

    @pytest.mark.travis
    def test_without_options_16_4_4(self):
        """
        Input File on Local Filesystem, Controller v16.4.4
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'))

    @pytest.mark.skip_travis
    def test_download_17_1_1(self):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        netscaler_conv(ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'))

    @pytest.mark.skip_travis
    def test_download_16_4_4(self):
        """
        Download Input File Flow, Test for Controller v16.4.4
        """
        netscaler_conv(ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'),
                       controller_version=setup.get('controller_version'))

    @pytest.mark.travis
    def test_no_profile_merge_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_no_profile_merge_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('no_profile_merge'),
                       controller_version=setup.get('controller_version'))

    @pytest.mark.travis
    def test_prefix_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_prefix_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_cloud_name_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_cloud_name_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_tenant_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_tenant_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_ignore_config_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_ignore_config_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_not_in_use_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_not_in_use_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       not_in_use=setup.get('not_in_use'),
                       controller_version=setup.get('controller_version'))


def teardown():
    pass
