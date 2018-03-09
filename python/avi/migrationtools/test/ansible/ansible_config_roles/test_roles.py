import os
import unittest
import test_script_ansible_config_role as role
import pytest
#create_playbook = pytest.config.getoption("--create_playbook")
#update_playbook = pytest.config.getoption("--update_playbook")

class Test(unittest.TestCase):
    api_version = '17.2.1'

    @pytest.mark.order1
    def test_create_role(self):
        role.test_ansible_create_role(state='present', changed=3)
        role.test_ansible_create_role(state='present', changed=0)

    @pytest.mark.order2
    def test_update_role(self):
        role.test_ansible_update_role(state='present', changed=2)
        role.test_ansible_update_role(state='present', changed=0)

    # @pytest.mark.order3
    # def test_delete_role(self):
    #     role.test_ansible_create_role(playbook_dir=create_playbook, state='absent', changed=1)
    #     role.test_ansible_create_role(playbook_dir=create_playbook,  state='absent', changed=0)