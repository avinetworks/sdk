"""
This testsuite contains the initial test cases for testing the
f5 converter tool along with its options / parameters
"""

import logging
import os
import subprocess
import sys

import pytest
import yaml


from avi.migrationtools.f5_converter.f5_converter import F5Converter
from avi.migrationtools.test.common.excel_reader \
    import percentage_success, output_sanitization
from avi.migrationtools.test.common.test_clean_reboot \
    import verify_controller_is_up, clean_reboot
from avi.migrationtools.test.common.test_tenant_cloud \
    import create_tenant, create_cloud

config_file = pytest.config.getoption("--config")
input_file = pytest.config.getoption("--file")
input_file_version = pytest.config.getoption("--fileVersion")
output_file = pytest.config.getoption("--out")

if not output_file:
    output_file = os.path.abspath(os.path.join(os.path.dirname(__file__),
                                               'output'))

input_file_v10 = os.path.abspath(os.path.join(os.path.dirname(__file__),
                                              'bigip_v10.conf'))
input_file_v11 = os.path.abspath(os.path.join(os.path.dirname(__file__),
                                              'bigip_v11.conf'))
v10 = '10'
v11 = '11'

if input_file_version == '10' and input_file:
    v10 = '10'
    input_file_v10 = input_file
elif input_file_version == '11' and input_file:
    v11 = '11'
    input_file_v11 = input_file
elif any([input_file_version, input_file]):
    print("Both arguments 'input_file_version' and 'input_file' are mandatory")
    sys.exit(0)


with open(config_file) as f:
    file_attribute = yaml.load(f)

setup = dict(
    controller_version_v16=file_attribute['controller_version_v16'],
    controller_version_v17=file_attribute['controller_version_v17'],
    file_version_v10=v10,
    file_version_v11=v11,
    version=True,
    option=file_attribute['option'],
    controller_ip_17_1_1=file_attribute['controller_ip_17_1_1'],
    controller_user_17_1_1=file_attribute['controller_user_17_1_1'],
    controller_password_17_1_1=file_attribute['controller_password_17_1_1'],
    controller_ip_16_4_4=file_attribute['controller_ip_16_4_4'],
    controller_user_16_4_4=file_attribute['controller_user_16_4_4'],
    controller_password_16_4_4=file_attribute['controller_password_16_4_4'],
    f5_host_ip_v10=file_attribute['f5_host_ip_v10'],
    f5_host_ip_v11=file_attribute['f5_host_ip_v11'],
    f5_ssh_user=file_attribute['f5_ssh_user'],
    f5_ssh_user_10=file_attribute['f5_ssh_user_10'],
    f5_ssh_password=file_attribute['f5_ssh_password'],
    no_profile_merge=file_attribute['no_profile_merge'],
    prefix=file_attribute['prefix'],
    cloud_name=file_attribute['cloud_name'],
    tenant=file_attribute['tenant'],
    input_folder_location='',
    config_file_name_v10=input_file_v10,
    config_file_name_v11=input_file_v11,
    partition_config='new',  # this is new
    f5_key_file='cd_rt_key.pem',
    ignore_config=os.path.abspath(os.path.join(os.path.dirname(__file__),
                                               'ignore-config.yaml')),
    patch=os.path.abspath(os.path.join(os.path.dirname(__file__),
                                       'patch.yaml')),
    vs_filter='vs_ksl.com,vs_NStoAvi-SG',
    not_in_use=True,
    skip_file=False,
    ansible=True,
    baseline_profile=None,
    f5_passphrase_file=os.path.abspath(os.path.join(os.path.dirname(__file__),
                                                    'passphrase.yaml')),
    f5_ansible_object=os.path.abspath(os.path.join(
        os.path.dirname(__file__), 'output', 'avi_config_create_object.yml')),
    vs_level_status=True,
    test_vip=None,
    output_file_path=output_file,
    vrf = 'test_vrf',
    segroup = 'test_se'
)

mylogger = logging.getLogger()


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)


def f5_conv(
        bigip_config_file=None, skip_default_file=False, f5_config_version=None,
        input_folder_location='certs', output_file_path=output_file,
        option='cli-upload', user=None, password=None, controller_ip=None,
        tenant='admin', cloud_name='Default-Cloud', vs_state='disable',
        controller_version=None, f5_host_ip=None, f5_ssh_user=None,
        f5_ssh_password=None, f5_key_file=None, ignore_config=None,
        partition_config=None, version=None, no_profile_merge=None, patch=None,
        vs_filter=None, ansible_skip_types=None,
        ansible_filter_types=None, ansible=None, prefix=None,
        convertsnat=None, not_in_use=None, baseline_profile=None,
        f5_passphrase_file=None, vs_level_status=False, test_vip=None,
        vrf=None, segroup=None):

    args = Namespace(bigip_config_file=bigip_config_file,
                     skip_default_file=skip_default_file,
                     f5_config_version=f5_config_version,
                     input_folder_location=input_folder_location,
                     output_file_path=output_file_path, option=option,
                     user=user, password=password, controller_ip=controller_ip,
                     tenant=tenant, cloud_name=cloud_name, vs_state=vs_state,
                     controller_version=controller_version,
                     f5_host_ip=f5_host_ip, f5_ssh_user=f5_ssh_user,
                     f5_ssh_password=f5_ssh_password, f5_key_file=f5_key_file,
                     ignore_config=ignore_config,
                     partition_config=partition_config, version=version,
                     no_object_merge=no_profile_merge, patch=patch,
                     vs_filter=vs_filter, ansible_skip_types=ansible_skip_types,
                     ansible_filter_types=ansible_filter_types, ansible=ansible,
                     prefix=prefix, convertsnat=convertsnat,
                     not_in_use=not_in_use, baseline_profile=baseline_profile,
                     f5_passphrase_file=f5_passphrase_file,
                     vs_level_status=vs_level_status, test_vip=test_vip,
                     vrf=None, segroup=None)

    f5_converter = F5Converter(args)
    avi_config = f5_converter.convert()
    return avi_config


class TestF5Converter:

    @pytest.fixture
    def cleanup(self):
        import avi.migrationtools.f5_converter.conversion_util as conv
        import shutil
        conv.csv_writer_dict_list = list()
        if os.path.exists(output_file):
            for each_file in os.listdir(output_file):
                file_path = os.path.join(output_file, each_file)
                try:
                    if os.path.isfile(file_path):
                        if file_path.endswith('.log'):
                            open('converter.log', 'w').close()
                        else:
                            os.unlink(file_path)
                    elif os.path.isdir(file_path):
                        shutil.rmtree(file_path)
                except Exception as e:
                    print(e)

    @pytest.mark.skip_travis
    def test_download_v11(self, cleanup):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        f5_conv(f5_host_ip=setup.get('f5_host_ip_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_ssh_user=setup.get('f5_ssh_user'),
                f5_ssh_password=setup.get('f5_ssh_password'),
                f5_config_version=setup.get('file_version_v11'))

    @pytest.mark.skip_travis
    def test_download_v10(self, cleanup):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        f5_conv(f5_host_ip=setup.get('f5_host_ip_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_ssh_user=setup.get('f5_ssh_user_10'),
                f5_ssh_password=setup.get('f5_ssh_password'),
                f5_config_version=setup.get('file_version_v10'))

    @pytest.mark.skip_travis
    def test_output_sanitization_v10(self, cleanup):
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=output_file)
        self.excel_path = os.path.abspath(os.path.join(output_file,
                                          'bigip_v10-ConversionStatus.xlsx'))
        self.json_path = os.path.abspath(os.path.join(output_file,
                                                'bigip_v10-Output.json'))
        self.log_path = os.path.abspath(os.path.join(output_file,
                                                     'converter.log'))
        assert output_sanitization(self.excel_path,
                                   self.json_path,
                                   self.log_path)

    @pytest.mark.skip_travis
    def test_output_sanitization_v11(self, cleanup):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=output_file)
        self.excel_path = os.path.abspath(os.path.join(output_file,
                                            'bigip_v11-ConversionStatus.xlsx'))
        self.json_path = os.path.abspath(os.path.join(output_file,
                                                      'bigip_v11-Output.json'))
        self.log_path = os.path.abspath(os.path.join(output_file,
                                                     'converter.log'))
        assert output_sanitization(self.excel_path,
                                   self.json_path,
                                   self.log_path)

    @pytest.mark.travis
    def test_excel_report_v11(self, cleanup):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=output_file)
        percentage_success(os.path.join(output_file,
                                        'bigip_v11-ConversionStatus.xlsx'))

    @pytest.mark.travis
    def test_without_options_v10(self, cleanup):
        """
        Check the Configuration file for V10
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'))

    @pytest.mark.travis
    def test_without_options_v11(self, cleanup):
        """
        Check the configuration file for v11
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'))

    @pytest.mark.travis
    def test_no_profile_merge_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_no_profile_merge_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_prefix_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_prefix_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_cloud_name_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_cloud_name_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_tenant_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_tenant_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_ignore_config_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_ignore_config_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_patch_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Patch option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                patch=setup.get('patch'))

    @pytest.mark.travis
    def test_patch_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Patch option usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                patch=setup.get('patch'))

    @pytest.mark.travis
    def test_not_in_use_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_not_in_use_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_passphrase_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                f5_passphrase_file=setup.get('f5_passphrase_file'))

    @pytest.mark.travis
    def test_passphrase_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                f5_passphrase_file=setup.get('f5_passphrase_file'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v10_17_1_1(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_17_1_1'],
                                        file_attribute[
                                            'controller_user_17_1_1'],
                                        file_attribute[
                                            'controller_password_17_1_1'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_17_1_1'],
                         file_attribute['controller_user_17_1_1'],
                         file_attribute['controller_password_17_1_1'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_v10_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_17_1_1'),
                user=setup.get('controller_user_17_1_1'),
                password=setup.get('controller_password_17_1_1'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v10_16_4_4(self, cleanup):
        """""
        Verify Controller v16.4.4 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        print file_attribute['license_file_path']
        is_up = verify_controller_is_up(file_attribute['controller_ip_16_4_4'],
                                        file_attribute[
                                            'controller_user_16_4_4'],
                                        file_attribute[
                                            'controller_password_16_4_4'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_16_4_4'],
                         file_attribute['controller_user_16_4_4'],
                         file_attribute['controller_password_16_4_4'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_v10_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                output_file_path=setup.get('output_file_path'),
                controller_version=setup.get('controller_version_v16'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v11_17_1_1(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_17_1_1'],
                                        file_attribute[
                                            'controller_user_17_1_1'],
                                        file_attribute[
                                            'controller_password_17_1_1'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_17_1_1'],
                         file_attribute['controller_user_17_1_1'],
                         file_attribute['controller_password_17_1_1'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_v11_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                output_file_path=setup.get('output_file_path'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_17_1_1'),
                user=setup.get('controller_user_17_1_1'),
                password=setup.get('controller_password_17_1_1'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v11_16_4_4(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api. After
        controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_16_4_4'],
                                        file_attribute[
                                            'controller_user_16_4_4'],
                                        file_attribute[
                                            'controller_password_16_4_4'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_16_4_4'],
                         file_attribute['controller_user_16_4_4'],
                         file_attribute['controller_password_16_4_4'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_v11_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                output_file_path=setup.get('output_file_path'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v16'),
                option=setup.get('option'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.travis
    def test_create_ansible_object_creation_v11(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1
        Create Ansible Script based on Flag
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                output_file_path=setup.get('output_file_path'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v11'),
                ansible=setup.get('ansible'))

    @pytest.mark.skip_travis
    def test_reboot_clean_ansible_v11_17_1_1(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_17_1_1'],
                                        file_attribute[
                                            'controller_user_17_1_1'],
                                        file_attribute[
                                            'controller_password_17_1_1'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_17_1_1'],
                         file_attribute['controller_user_17_1_1'],
                         file_attribute['controller_password_17_1_1'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_ansible_object_auto_upload_v11_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1
        AutoUpload Flow
        """
        print(subprocess.check_output('pip install avisdk --upgrade',
                                      shell=True))
        print(subprocess.check_output(
            '/usr/local/bin/ansible-galaxy install avinetworks.avisdk',
            shell=True))
        try:
            output = subprocess.check_output('/usr/local/bin/ansible-playbook '
                    '-s %s --extra-vars "controller=%s username=%s password=%s"'
                    % (setup.get('f5_ansible_object'), setup.get(
                    'controller_ip_17_1_1'), setup.get(
                    'controller_user_17_1_1'), setup.get(
                    'controller_password_17_1_1')), shell=True)
        except subprocess.CalledProcessError as e:
            output = e.output

    @pytest.mark.travis
    def test_create_ansible_object_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1
        Create Ansible Script based on Flag
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                output_file_path=setup.get('output_file_path'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'),
                ansible=setup.get('ansible'))

    @pytest.mark.skip_travis
    def test_reboot_clean_ansible_v10_16_4_4(self, cleanup):
        """""
        Verify Controller v16.4.4 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_16_4_4'],
                                        file_attribute[
                                            'controller_user_16_4_4'],
                                        file_attribute[
                                            'controller_password_16_4_4'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_16_4_4'],
                         file_attribute['controller_user_16_4_4'],
                         file_attribute['controller_password_16_4_4'],
                         file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_ansible_object_auto_upload_v10_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4
        AutoUpload Flow
        """
        print(subprocess.check_output('pip install avisdk --upgrade',
                                      shell=True))
        print(subprocess.check_output(
            '/usr/local/bin/ansible-galaxy install avinetworks.avisdk',
            shell=True))
        try:
            output = subprocess.check_output('/usr/local/bin/ansible-playbook '
                    '-s %s --extra-vars "controller=%s username=%s password=%s"'
                    % (setup.get('f5_ansible_object'), setup.get(
                    'controller_ip_16_4_4'), setup.get(
                    'controller_user_16_4_4'), setup.get(
                    'controller_password_16_4_4')), shell=True)
        except subprocess.CalledProcessError as e:
            output = e.output

    @pytest.mark.travis
    def test_vs_level_status_true_v10(self, cleanup):
        """
        Input File on Local Filesystem, VS level option true usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                vs_level_status=setup.get('vs_level_status'))

    @pytest.mark.travis
    def test_vs_level_status_false_v10(self, cleanup):
        """
        Input File on Local Filesystem, VS level option false usage
        """
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                controller_version=setup.get('controller_version_v17'),
                f5_config_version=setup.get('file_version_v10'))

    @pytest.mark.skip_travis
    def test_create_tenant_cloud_and_upload_controller_v11_16_4_4(self,
                                                                  cleanup):
        """
        Create Tenant and Cloud name on the Controller v16.4.4,
        Auto Upload configuration file on controller.
        """
        create_tenant(file_attribute['controller_ip_16_4_4'],
                      file_attribute['controller_user_16_4_4'],
                      file_attribute['controller_password_16_4_4'],
                      file_attribute['tenant'])

        create_cloud(file_attribute['controller_ip_16_4_4'],
                     file_attribute['controller_user_16_4_4'],
                     file_attribute['controller_password_16_4_4'],
                     file_attribute['cloud_name'])

        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                output_file_path=setup.get('output_file_path'),
                controller_version=setup.get('controller_version_v16'),
                option=setup.get('option'),
                tenant=file_attribute['tenant'],
                cloud_name=file_attribute['cloud_name'],
                ansible=setup.get('ansible'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.skip_travis
    def test_create_tenant_cloud_and_upload_controller_v10_16_4_4(self,
                                                                  cleanup):
        """
        Create Tenant and Cloud name on the Controller v16.4.4,
        Auto Upload configuration file on controller.
        """
        create_tenant(file_attribute['controller_ip_16_4_4'],
                      file_attribute['controller_user_16_4_4'],
                      file_attribute['controller_password_16_4_4'],
                      file_attribute['tenant'])

        create_cloud(file_attribute['controller_ip_16_4_4'],
                     file_attribute['controller_user_16_4_4'],
                     file_attribute['controller_password_16_4_4'],
                     file_attribute['cloud_name'])

        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                output_file_path=setup.get('output_file_path'),
                controller_version=setup.get('controller_version_v16'),
                option=setup.get('option'),
                tenant=file_attribute['tenant'],
                cloud_name=file_attribute['cloud_name'],
                ansible=setup.get('ansible'),
                controller_ip=setup.get('controller_ip_16_4_4'),
                user=setup.get('controller_user_16_4_4'),
                password=setup.get('controller_password_16_4_4'))

    @pytest.mark.travis
    def test_http_cookie_type_on_file_v10(self):

        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'))
        fileName = output_file + '/bigip_v10-Output.json'
        with open(fileName) as f:
            file_object = yaml.load(f)
        persistenceProfiles = file_object['ApplicationPersistenceProfile']
        for type in persistenceProfiles:
            if "COOKIE" in type['persistence_type']:
                assert type['persistence_type'] == 'PERSISTENCE_TYPE_HTTP_COOKIE'

    @pytest.mark.travis
    def test_http_cookie_type_on_file_v11(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'))
        fileName = output_file +'/bigip_v11-Output.json'
        with open(fileName) as f:
            file_object = yaml.load(f)
        persistenceProfiles = file_object['ApplicationPersistenceProfile']
        for type in persistenceProfiles:
            if "COOKIE" in type['persistence_type']:
                assert type['persistence_type'] == 'PERSISTENCE_TYPE_HTTP_COOKIE'

    @pytest.mark.travis
    def test_vrf_flag_on_file_v10(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'),
                vrf = setup.get('vrf'),
                )

    @pytest.mark.travis
    def test_vrf_flag_on_file_v10(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v10'),
                f5_config_version=setup.get('file_version_v10'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'),
                segroup = setup.get('segroup')
                )

    @pytest.mark.travis
    def test_vrf_flag_on_file_v11(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'),
                vrf = setup.get('vrf'),
                )

    @pytest.mark.travis
    def test_vrf_flag_on_file_v11(self):
        f5_conv(bigip_config_file=setup.get('config_file_name_v11'),
                f5_config_version=setup.get('file_version_v11'),
                controller_version=setup.get('controller_version_v17'),
                output_file_path=setup.get('output_file_path'),
                segroup = setup.get('segroup')
                )

def teardown():
    pass
