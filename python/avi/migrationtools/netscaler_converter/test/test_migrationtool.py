"""
This testsuite contains the initial test cases for testing the
converter tool along with its options / parameters
"""

import logging
import os
import pytest
import yaml
import subprocess

from avi.migrationtools.netscaler_converter.netscaler_converter \
    import NetscalerConverter
from avi.migrationtools.test.common.excel_reader \
    import percentage_success, output_sanitization
from avi.migrationtools.test.common.test_clean_reboot \
    import verify_controller_is_up, clean_reboot
from avi.migrationtools.test.common.test_tenant_cloud \
    import create_tenant, create_cloud

config_file = pytest.config.getoption("--config")
input_file = pytest.config.getoption("--file")
output_file = pytest.config.getoption("--out")

if input_file is None:
    input_file = 'ns.conf'

with open(config_file) as f:
    file_attribute = yaml.load(f)

setup = dict(
    controller_version_v16=file_attribute['controller_version_v16'],
    controller_version_v17=file_attribute['controller_version_v17'],
    version=True,
    option=file_attribute['option'],
    controller_ip_17_1_1=file_attribute['controller_ip_17_1_1'],
    controller_user_17_1_1=file_attribute['controller_user_17_1_1'],
    controller_password_17_1_1=file_attribute['controller_password_17_1_1'],
    controller_ip_16_4_4=file_attribute['controller_ip_16_4_4'],
    controller_user_16_4_4=file_attribute['controller_user_16_4_4'],
    controller_password_16_4_4=file_attribute['controller_password_16_4_4'],
    ns_host_ip=file_attribute['ns_host_ip'],
    ns_ssh_user=file_attribute['ns_ssh_user'],
    ns_ssh_password=file_attribute['ns_ssh_password'],
    no_profile_merge=file_attribute['no_profile_merge'],
    prefix=file_attribute['prefix'],
    cloud_name=file_attribute['cloud_name'],
    tenant=file_attribute['tenant'],
    input_folder_location='',
    config_file_name=input_file,
    config_file_name_passphrase='ns_passphrase.conf',
    ns_passphrase_file='passphrase.yaml',
    ns_key_file='cd_rt_key.pem',
    ignore_config=os.path.abspath(os.path.join(
        os.path.dirname(__file__), 'ignore-config.yaml')),
    ns_ansible_object=os.path.abspath
    (os.path.join(os.path.dirname(__file__), 'output', 'avi_config_create_object.yml')),
    patch='patch.yaml',
    vs_filter='vs_ksl.com,vs_NStoAvi-SG',
    not_in_use=True,
    baseline_profile=None,
    redirect=False,
    ansible=True,
    vs_level_status=True,
    ansible_skip_types=None,
    test_vip=None,
    ansible_filter_types=None,
    output_file_path=output_file
)


#logging.basicConfig(filename="runlog.txt", level=logging.DEBUG)
mylogger = logging.getLogger()


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)


def netscaler_conv(
        config_file_name=None, tenant='admin', cloud_name='Default-Cloud',
        input_folder_location='certs', output_file_path='output',
        option='cli-upload', user=None, password=None, controller_ip=None,
        vs_state='disable', controller_version=None, ns_host_ip=None,
        ns_ssh_user=None, ns_ssh_password=None, ns_key_file=None,
        ns_passphrase_file=None, version=None, no_profile_merge=True,
        patch=None, vs_filter=None, ignore_config=None, ansible=None,
        prefix=None, not_in_use=False, baseline_profile=None, redirect=True,
        vs_level_status=False, ansible_skip_types=None, test_vip=None,
        ansible_filter_types=None):

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
        not_in_use=not_in_use, baseline_profile=baseline_profile,
        redirect=redirect, ansible=ansible, vs_level_status=vs_level_status,
        ansible_skip_types=ansible_skip_types, test_vip=None,
        ansible_filter_types=ansible_filter_types, vrf=None, segroup=None)
    netscaler_converter = NetscalerConverter(args)
    avi_config = netscaler_converter.convert()
    return avi_config


class TestNetscalerConverter:

    @pytest.fixture
    def cleanup(self):
        import avi.migrationtools.f5_converter.conversion_util as conv
        conv.csv_writer_dict_list = list()

    @pytest.mark.skip_travis
    def test_download(self, cleanup):
        """
        Download Input File Flow.
        """
        netscaler_conv(ns_host_ip=setup.get('ns_host_ip'),
                       ns_ssh_user=setup.get('ns_ssh_user'),
                       ns_ssh_password=setup.get('ns_ssh_password'),
                       controller_version=setup.get('controller_version_v17'))

    @pytest.mark.travis
    def test_excel_report_16_4(self, cleanup):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_17_1_1(self, cleanup):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_excel_report_16_4(self, cleanup):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       output_file_path='output')
        percentage_success('./output/ns-ConversionStatus.xlsx')

    @pytest.mark.travis
    def test_output_sanitization_17_1_1(self, cleanup):
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       output_file_path='output')
        output_sanitization('./output/ns-ConversionStatus.xlsx',
                            './output/ns-Output.json')

    @pytest.mark.travis
    def test_without_options_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Controller v17.1.1
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'))

    @pytest.mark.travis
    def test_without_options_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Controller v16.4.4
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'))

    @pytest.mark.travis
    def test_no_profile_merge_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       no_profile_merge=setup.get('no_profile_merge'))

    @pytest.mark.travis
    def test_no_profile_merge_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('no_profile_merge'),
                       controller_version=setup.get('controller_version_v16'))

    @pytest.mark.travis
    def test_prefix_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_prefix_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Prefix Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       prefix=setup.get('prefix'))

    @pytest.mark.travis
    def test_cloud_name_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_cloud_name_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Cloud-Name Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       cloud_name=setup.get('cloud_name'))

    @pytest.mark.travis
    def test_tenant_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_tenant_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Tenant Added
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       tenant=setup.get('tenant'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_input_folder_path_not_provided_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        Input Folder path not provided
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       input_folder_location=setup.get('input_folder_location'))

    @pytest.mark.travis
    def test_ignore_config_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_ignore_config_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        ignore_config option usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'),
                       ignore_config=setup.get('ignore_config'))

    @pytest.mark.travis
    def test_not_in_use_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       not_in_use=setup.get('not_in_use'))

    @pytest.mark.travis
    def test_not_in_use_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        No_profile_merge Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       not_in_use=setup.get('not_in_use'),
                       controller_version=setup.get('controller_version_v16'))

    @pytest.mark.travis
    def test_no_redirect_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        redirect Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       redirect=setup.get('redirect'))

    @pytest.mark.travis
    def test_no_redirect_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        redirect Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       no_profile_merge=setup.get('redirect'),
                       controller_version=setup.get('controller_version_v16'))

    @pytest.mark.travis
    def test_redirect_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        redirect Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),)

    @pytest.mark.travis
    def test_redirect_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        redirect Flag Reset
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v16'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v11_17_1_1(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_17_1_1'],
                                        file_attribute['controller_user_17_1_1'],
                                        file_attribute['controller_password_17_1_1'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_17_1_1'], file_attribute['controller_user_17_1_1'],
                         file_attribute['controller_password_17_1_1'], file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_17_1_1(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1,
        AutoUpload Flow
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       option=setup.get('option'),
                       ansible=setup.get('ansible'),
                       output_file_path=setup.get('output_file_path'),
                       controller_version=setup.get('controller_version_v17'),
                       controller_ip=setup.get('controller_ip_17_1_1'),
                       user=setup.get('controller_user_17_1_1'),
                       password=setup.get('controller_password_17_1_1'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v11_16_4_4(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_16_4_4'],
                                        file_attribute['controller_user_16_4_4'],
                                        file_attribute['controller_password_16_4_4'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_16_4_4'], file_attribute['controller_user_16_4_4'],
                         file_attribute['controller_password_16_4_4'], file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_auto_upload_16_4_4(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4,
        AutoUpload Flow
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       output_file_path=setup.get('output_file_path'),
                       controller_version=setup.get('controller_version_v16'),
                       option=setup.get('option'),
                       ansible=setup.get('ansible'),
                       controller_ip=setup.get('controller_ip_16_4_4'),
                       user=setup.get('controller_user_16_4_4'),
                       password=setup.get('controller_password_16_4_4'))

    @pytest.mark.travis
    def test_create_ansible_object(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v17.1.1
        Create Ansible Script based on Flag
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       output_file_path=setup.get('output_file_path'),
                       controller_version=setup.get('controller_version_v17'),
                       ansible=setup.get('ansible'))

    @pytest.mark.skip_travis
    def test_reboot_clean_v11_16_4_4(self, cleanup):
        """""
        Verify Controller v17.1.1 is running and clean reboot avi api.
        After controller setup completed, upload the AviInternal certificate file.
        """
        is_up = verify_controller_is_up(file_attribute['controller_ip_16_4_4'],
                                        file_attribute['controller_user_16_4_4'],
                                        file_attribute['controller_password_16_4_4'])
        if is_up:
            clean_reboot(file_attribute['controller_ip_16_4_4'], file_attribute['controller_user_16_4_4'],
                         file_attribute['controller_password_16_4_4'], file_attribute['license_file_path'])
            print "Controller is running properly."
        else:
            print "Controller is not running properly."

    @pytest.mark.skip_travis
    def test_ansible_object_auto_upload_v10(self, cleanup):
        """
        Input File on Local Filesystem, Test for Controller v16.4.4
        AutoUpload Flow
        """
        print(subprocess.check_output('pip install avisdk --upgrade', shell=True))
        print(subprocess.check_output(
            '/usr/local/bin/ansible-galaxy install avinetworks.avisdk', shell=True))
        try:
            output = subprocess.check_output('/usr/local/bin/ansible-playbook -s %s --extra-vars '
                                             '"controller=%s username=%s password=%s"' %
                                             (setup.get('ns_ansible_object'), setup.get('controller_ip_16_4_4'),
                                              setup.get(
                                                  'controller_user_16_4_4'),
                                              setup.get('controller_password_16_4_4')), shell=True)
        except subprocess.CalledProcessError as e:
            output = e.output

    @pytest.mark.travis
    def test_vs_level_status_true(self, cleanup):
        """
        Input File on Local Filesystem, VS level option true usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'),
                       vs_level_status=setup.get('vs_level_status'))

    @pytest.mark.travis
    def test_vs_level_status_false(self, cleanup):
        """
        Input File on Local Filesystem, VS level option false usage
        """
        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       controller_version=setup.get('controller_version_v17'))

    @pytest.mark.skip_travis
    def test_create_tenant_cloud_and_upload_controller_17_1_1(self, cleanup):
        """
        Create Tenant and Cloud name on the Controller v17.1.1,
        Auto Upload configuration file on controller.
        """
        create_tenant(file_attribute['controller_ip_17_1_1'], file_attribute['controller_user_17_1_1'],
                      file_attribute['controller_password_17_1_1'], file_attribute['tenant'])

        create_cloud(file_attribute['controller_ip_17_1_1'], file_attribute['controller_user_17_1_1'],
                     file_attribute['controller_password_17_1_1'], file_attribute['cloud_name'])

        netscaler_conv(config_file_name=setup.get('config_file_name'),
                       option=setup.get('option'),
                       tenant=file_attribute['tenant'],
                       cloud_name=file_attribute['cloud_name'],
                       ansible=setup.get('ansible'),
                       output_file_path=setup.get('output_file_path'),
                       controller_version=setup.get('controller_version_v17'),
                       controller_ip=setup.get('controller_ip_17_1_1'),
                       user=setup.get('controller_user_17_1_1'),
                       password=setup.get('controller_password_17_1_1'))


def teardown():
    pass
