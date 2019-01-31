import json
import os
import pytest
import subprocess

from avi.migrationtools.ansible.avi_config_to_ansible import AviAnsibleConverter

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
                                         '-s %s --extra-vars "controller=%s username=%s password=%s"'
                                         % (file, '10.10.29.206', 'admin', 'avi123$%'), shell=True)

    def test_avi_to_ansible_delete(self, cleanup):
        obj = AviAnsibleConverter(avi_cfg, outdir)
        obj.write_ansible_playbook()
        assert outdir + '/avi_config_delete.yml'
        file = outdir + '/avi_config_delete.yml'
        output = subprocess.check_output('/usr/local/bin/ansible-playbook '
                                         '-s %s --extra-vars "controller=%s username=%s password=%s"'
                                         % (file, '10.10.29.206', 'admin', 'avi123$%'), shell=True)

    def TearDown(self):
        pass