"""
This testsuite contains the initial test cases for testing the
f5 converter tool along with its options / parameters
"""

import logging
import pytest
import os

from avi.migrationtools.f5_converter.f5_converter import F5Converter
# from avi.migrationtools.test.common.excel_reader \
from avi.migrationtools.test.common.excel_reader \
    import percentage_success, output_sanitization


setup = dict(
    controller_version='16.4.4',
    file_version_v10='10',
    file_version_v11='11',
    version=True,
    option='auto-upload',
    controller_ip_17_1_1='10.10.24.179',
    controller_user_17_1_1='admin',
    controller_password_17_1_1='Avi123$%',
    controller_ip_16_4_4='10.10.24.16',
    controller_user_16_4_4='admin',
    controller_password_16_4_4='Avi123$%',
    f5_host_ip='10.90.117.120',
    f5_ssh_user='admin',
    f5_ssh_password='avi123',
    no_profile_merge=False,
    prefix='mig-tool-test',
    cloud_name='vmware',
    tenant='test',
    input_folder_location='',
    config_file_name_v10=os.path.abspath(
        os.path.dirname(__file__)) + os.sep + 'bigip_v10.conf',
    config_file_name_v11=os.path.abspath(
        os.path.dirname(__file__)) + os.sep + 'bigip_v11.conf',
    partition_config = 'new',  # this is new
    f5_key_file='cd_rt_key.pem',
    ignore_config=os.path.abspath(
        os.path.dirname(__file__)) + os.sep + 'ignore-config.yaml',
    patch=os.path.abspath(os.path.dirname(__file__)) + os.sep + 'patch.yml',
    vs_filter='vs_ksl.com,vs_NStoAvi-SG',
    not_in_use=True,
    skip_file=False,
    ansible=True,
    baseline_profile=None,
    f5_passphrase_file=os.path.abspath(
        os.path.dirname(__file__)) + os.sep + 'passphrase.yaml',
    f5_ansible_object=os.path.abspath
    (os.path.join(os.path.dirname(__file__), 'output', 'avi_config_create_object.yml'))
)

logging.basicConfig(filename="runlog.txt", level=logging.DEBUG)
mylogger = logging.getLogger()


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)


def f5_conv(
        bigip_config_file=None, skip_default_file=False, f5_config_version=None,
        input_folder_location='certs', output_file_path='output', option='cli-upload',
        user=None, password=None, controller_ip=None, tenant='admin',
        cloud_name='Default-Cloud', vs_state='disable', controller_version='17.1.1',
        f5_host_ip=None, f5_ssh_user=None, f5_ssh_password=None, f5_key_file=None,
        ignore_config=None, partition_config=None, version=None,
        no_profile_merge=None, patch=None, vs_filter=None, ansible_skip_types=None,
        ansible_filter_types=None, ansible=None, prefix=None,
        convertsnat=None, not_in_use=None, baseline_profile=None, f5_passphrase_file=None):

    args = Namespace(
        bigip_config_file=bigip_config_file, skip_default_file=skip_default_file, 
        f5_config_version=f5_config_version, input_folder_location=input_folder_location, 
        output_file_path=output_file_path, option=option, user=user, password=password, 
        controller_ip=controller_ip, tenant=tenant, cloud_name=cloud_name, 
        vs_state=vs_state, controller_version=controller_version, 
        f5_host_ip=f5_host_ip, f5_ssh_user=f5_ssh_user, f5_ssh_password=f5_ssh_password, 
        f5_key_file=f5_key_file, ignore_config=ignore_config, partition_config=partition_config, 
        version=version, no_object_merge=no_profile_merge, patch=patch,
        vs_filter=vs_filter, ansible_skip_types=ansible_skip_types,
        ansible_filter_types=ansible_filter_types, ansible=ansible, 
        prefix=prefix,convertsnat=convertsnat, not_in_use=not_in_use,
        baseline_profile=baseline_profile, f5_passphrase_file=f5_passphrase_file)

    f5_converter = F5Converter(args)
    avi_config = f5_converter.convert()
    return avi_config

class TestF5Converter:
    @pytest.mark.travis
    def test_excel_report_v10(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                output_file_path='output')
        percentage_success('./output/bigip_v10-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_v10(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                output_file_path='output')
        output_sanitization('./output/bigip_v10-ConversionStatus.xlsx',
                            './output/bigip_v10-Output.json')

    @pytest.mark.travis
    def test_excel_report_v11(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                output_file_path='output')
        percentage_success('./output/bigip_v11-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_v11(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                output_file_path='output')
        output_sanitization('./output/bigip_v11-ConversionStatus.xlsx',
                            './output/bigip_v11-Output.json')

    @pytest.mark.travis
    def test_without_options_v10(self):
        """
        Check the Configuration file for V10
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                )

    @pytest.mark.travis
    def test_without_options_v11(self):
        """
        Check the configuration file for v11
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'))

    @pytest.mark.skip_travis
    def test_download(self):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        f5_conv(f5_host_ip=setup.get('f5_host_ip'),
                f5_ssh_user=setup.get('f5_ssh_user'),
                f5_ssh_password=setup.get('f5_ssh_password'),
                f5_config_version=setup.get('file_version_v11'))

    @pytest.mark.travis
    def test_no_profile_merge_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_no_profile_merge_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_prefix_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_prefix_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_cloud_name_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_cloud_name_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_tenant_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_tenant_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_ignore_config_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_ignore_config_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_patch_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Patch option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                patch=setup.get('patch'))

    @pytest.mark.travis
    def test_patch_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Patch option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                patch=setup.get('patch'))

    @pytest.mark.travis
    def test_not_in_use_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_not_in_use_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_passphrase_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                f5_passphrase_file=setup.get('f5_passphrase_file'))

    @pytest.mark.travis
    def test_passphrase_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                f5_passphrase_file=setup.get('f5_passphrase_file'))

    @pytest.mark.skip_travis
    def test_auto_upload_v10_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_17_1_1'),
                user=setup.get('controller_user_17_1_1'),
                password=setup.get('controller_password_17_1_1'))

    @pytest.mark.skip_travis
    def test_auto_upload_v10_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.skip_travis
    def test_auto_upload_v11_17_1_1(self):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_17_1_1'),
                user=setup.get('controller_user_17_1_1'),
                password=setup.get('controller_password_17_1_1'))

    @pytest.mark.skip_travis
    def test_auto_upload_v11_16_4_4(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.travis
    def test_create_ansible_object_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4
        Create Ansible Script based on Flag
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version = setup.get('file_version_v10'),
                ansible=setup.get('ansible'))

    @pytest.mark.travis
    def test_create_ansible_object_creation_v11(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4
        Create Ansible Script based on Flag
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                ansible=setup.get('ansible'))

    @pytest.mark.skip_travis
    def test_ansible_object_auto_upload_v10(self):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4
        AutoUpload Flow
        """

        os.system('sudo pip install avisdk --upgrade')
        os.system('sudo ansible-galaxy install avinetworks.avisdk')
        os.system('sudo ansible-playbook  -s output/avi_config_create_object.yml '
                  '--extra-vars "controller=10.10.26.133 username=admin password=avi123$%"')


def teardown():
    pass