import json
import os
import yaml
import pytest
import subprocess

from avi.migrationtools.ansible.avi_config_to_ansible import AviAnsibleConverter

config_file = pytest.config.getoption("--config")

input_file = os.path.abspath(os.path.join(os.path.dirname(__file__),
                                          'avi_config.json'))
output_file = os.path.abspath(os.path.join(os.path.dirname(__file__),
                                           'ansible_output'))

if not os.path.exists(output_file):
    os.mkdir(output_file)

with open(input_file, "r+") as f:
    avi_cfg = json.loads(f.read())
    ansible_avi_config = {'avi_config': {}}
    outdir = output_file

with open(config_file) as f:
    file_attribute = yaml.load(f)

setup = dict(
    controller_ip=file_attribute['controller_ip_17_1_1'],
    controller_user=file_attribute['controller_user_17_1_1'],
    controller_password=file_attribute['controller_password_17_1_1'])

class TestAviToAnsible:

    @pytest.fixture
    def cleanup(self):
        if os.path.exists(output_file):
            for each_file in os.listdir(output_file):
                file_path = os.path.join(output_file, each_file)
                try:
                    if os.path.isfile(file_path):
                        os.unlink(file_path)
                except Exception as e:
                    print(e)

    @pytest.mark.travis
    def test_avi_to_ansible_conv(self, cleanup):
        obj = AviAnsibleConverter(avi_cfg, outdir)
        obj.write_yaml()
        assert outdir + '/ansible_avi_config.yml'

    def test_avi_to_ansible_playbook_conv(self, cleanup):
        obj = AviAnsibleConverter(avi_cfg, outdir)
        obj.write_ansible_playbook()
        assert outdir + '/avi_config.yml'
        assert outdir + '/avi_config_delete.yml'

    def test_avi_to_ansible_upload(self, cleanup):
        obj = AviAnsibleConverter(avi_cfg, outdir)
        obj.write_ansible_playbook()
        assert outdir + '/avi_config.yml'
        file = outdir + '/avi_config.yml'
        output = subprocess.check_output('/usr/local/bin/ansible-playbook '
                                         '%s --extra-vars "controller=%s username=%s password=%s"'
                                         % (file, setup.get('controller_ip'), setup.get('controller_user'),
                                            setup.get('controller_password')), shell=True)

    def test_avi_to_ansible_delete(self, cleanup):
        obj = AviAnsibleConverter(avi_cfg, outdir)
        obj.write_ansible_playbook()
        assert outdir + '/avi_config_delete.yml'
        file = outdir + '/avi_config_delete.yml'
        output = subprocess.check_output('/usr/local/bin/ansible-playbook '
                                         '%s --extra-vars "controller=%s username=%s password=%s"'
                                         % (file, setup.get('controller_ip'), setup.get('controller_user'),
                                            setup.get('controller_password')), shell=True)

    def TearDown(self):
        pass