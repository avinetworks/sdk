"""
This testsuite contains the initial test cases for testing the
converter tool along with its options / parameters
"""

import logging

from avi.migrationtools.netscaler_converter.netscaler_converter \
    import NetscalerConverter


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
    ignore_config='ignore-config.yaml',
    patch='patch.yml',
    vs_filter='vs_ksl.com,vs_NStoAvi-SG'
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
        prefix=None):

    args = Namespace(
        ns_config_file=config_file_name, tenant=tenant, cloud_name=cloud_name,
        input_folder_location=input_folder_location,
        output_file_path=output_file_path, option=option, user=user,
        password=password, controller_ip=controller_ip, vs_state=vs_state,
        controller_version=controller_version, ns_host_ip=ns_host_ip,
        ns_ssh_user=ns_ssh_user, ns_ssh_password=ns_ssh_password,
        ns_key_file=ns_key_file, ns_passphrase_file=ns_passphrase_file,
        version=version, no_profile_merge=no_profile_merge, patch=patch,
        vs_filter=vs_filter,  ignore_config=ignore_config, prefix=prefix)
    netscaler_converter = NetscalerConverter(args)
    avi_config = netscaler_converter.convert()
    return avi_config


class TestNetscalerConverter:

    def test_without_options_17_1_1(self):
        """
        Input File on Local Filesystem, Controller v17.1.1
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'))

    def test_without_options_16_4_4(self):
        """
        Input File on Local Filesystem, Controller v16.4.4
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'))

    def test_auto_upload_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       option=setup.get('option'),
                       controller_ip=setup.get('controller_ip_17_1_1'),
                       user=setup.get('controller_user_17_1_1'),
                       password=setup.get('controller_password_17_1_1'))

    def test_auto_upload_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       option=setup.get('option'),
                       controller_ip=setup.get('controller_ip_16_4_4'),
                       user=setup.get('controller_user_16_4_4'),
                       password=setup.get('controller_password_16_4_4'))

    def test_download_17_1_1(self):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        netscaler_conv(ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'))

    def test_download_16_4_4(self):
        """
        Download Input File Flow, Test for Controller v16.4.4
        """
        netscaler_conv(ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'),
                       controller_version=setup.get('controller_version'))

    def test_download_auto_upload_17_1_1(self):
        """
        Test for Controller v17.1.1, Download Input File + Auto-Upload Flow
        """
        netscaler_conv(controller_ip=setup.get('controller_ip_17_1_1'),
                       user=setup.get('controller_user_17_1_1'),
                       password=setup.get('controller_password_17_1_1'),
                       option=setup.get('option'),
                       ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'))

    def test_download_auto_upload_16_4_4(self):
        """
        Test for Controller v16.4.4, Download Input File + Auto-Upload Flow
        """
        netscaler_conv(controller_ip=setup.get('controller_ip_16_4_4'),
                       user=setup.get('controller_user_16_4_4'),
                       password=setup.get('controller_password_16_4_4'),
                       option=setup.get('option'),
                       ns_host_ip=setup.get('ns_host_ip'),
                       controller_version=setup.get('controller_version'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'))

    def test_no_profile_merge_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('no_profile_merge'))

    def test_no_profile_merge_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('no_profile_merge'),
                       controller_version=setup.get('controller_version'))

    def test_vs_filter_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        vs_filter attributes set
        """
        avconf = netscaler_conv(config_file_name=setup.get('config_file_name'),
                                vs_filter=setup.get('vs_filter'))
        assert isinstance(avconf, dict)
        assert 'VirtualService' in avconf
        assert len(avconf['VirtualService']) == 2
        actual_vsnames = [obj['name'] for obj in avconf['VirtualService']]
        actual_vsnames.sort()
        expected_vsnames = ['vs_ksl.com,vs_NStoAvi-SG']
        expected_vsnames.sort()
        assert actual_vsnames == expected_vsnames

    def test_vs_filter_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        vs_filter attributes set
        """
        avconf = netscaler_conv(config_file_name=setup.get('config_file_name'),
                                vs_filter=setup.get('vs_filter'),
                                controller_version=setup.get('controller_version'))
        assert isinstance(avconf, dict)
        assert 'VirtualService' in avconf
        assert len(avconf['VirtualService']) == 2
        actual_vsnames = [obj['name'] for obj in avconf['VirtualService']]
        actual_vsnames.sort()
        expected_vsnames = ['vs_ksl.com,vs_NStoAvi-SG]
        expected_vsnames.sort()
        assert actual_vsnames == expected_vsnames

    def test_passphrase_auto_upload_17_1_1(self):
        """
        Input File on Local Filesystem,Test for Controller v17.1.1,
        Passphrase Usage + Auto-Upload
        """
        netscaler_conv(controller_ip=setup.get('controller_ip_17_1_1'),
                       user=setup.get('controller_user_17_1_1'),
                       password=setup.get('controller_password_17_1_1'),
                       option=setup.get('option'),
                       config_file_name=setup.get('config_file_name_passphrase'),
                       ns_passphrase_file=setup.get('ns_passphrase_file'))

    def test_passphrase_auto_upload_16_4_4(self):
        """
        Input File on Local Filesystem,Test for Controller v16.4.4,
        Passphrase Usage + Auto-Upload
        """
        netscaler_conv(controller_ip=setup.get('controller_ip_16_4_4'),
                       user=setup.get('controller_user_16_4_4'),
                       password=setup.get('controller_password_16_4_4'),
                       option=setup.get('option'),
                       config_file_name=setup.get('config_file_name_passphrase'),
                       controller_version=setup.get('controller_version'),
                       ns_passphrase_file=setup.get('ns_passphrase_file'))

    def test_prefix_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       prefix=setup.get('prefix'))

    def test_prefix_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       prefix=setup.get('prefix'))

    def test_cloud_name_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       cloud_name=setup.get('cloud_name'))

    def test_cloud_name_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       cloud_name=setup.get('cloud_name'))

    def test_tenant_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       tenant=setup.get('tenant'))

    def test_tenant_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       tenant=setup.get('tenant'))

    def test_input_folder_path_not_provided_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       input_folder_location=setup.get('input_folder_location'))

    def test_input_folder_path_not_provided_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       input_folder_location=setup.get('input_folder_location'))

    def test_ignore_config_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       ignore_config=setup.get('ignore_config'))

    def test_ignore_config_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       ignore_config=setup.get('ignore_config'))

    def test_patch_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Patch option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       patch=setup.get('patch'))

    def test_patch_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Patch option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version'),
                       patch=setup.get('patch'))


def teardown():
    pass
