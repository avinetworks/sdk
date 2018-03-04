import os
import unittest
import test_script_ansible_config_role as role

class Test(unittest.TestCase):
    api_version = '17.2.1'
    playbook_dir = os.getcwd()

    def test_create_role(self):
        role.test_ansible_create_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='present',
                                      api_version=self.api_version, changed=1)
        role.test_ansible_create_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='present',
                                      api_version=self.api_version, changed=0)

    def test_update_role(self):
        role.test_ansible_update_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='present',
                                      api_version=self.api_version, changed=1)
        role.test_ansible_update_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='present',
                                      api_version=self.api_version, changed=0)

    def test_delete_role(self):
        role.test_ansible_create_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='absent',
                                      api_version=self.api_version, changed=1)
        role.test_ansible_create_role(playbook_dir=self.playbook_dir, monitor_name='test-monitor', state='absent',
                                      api_version=self.api_version, changed=0)