import os
import test_ansible

class Test_Ansible(object):

    api_version='17.2.7'
    playbook_dir = os.getcwd()

    def ansible_check_mode(self):
        mode_output = test_ansible.test_ansible_check_mode_playbook(playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='absent', api_version=self.api_version, dontskip='true')
        assert int(mode_output) == 8

    # # Test Cases
    # def test_test_create_configs(self):
    #     # Tags:  create, config, TCID-1.12.202.1.0
    #     setup_all_avi_configs()
    #
    def test_ansible_pool_create(self):
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='present', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='present', api_version=self.api_version, changed='0')

    def test_ansible_patch_method(self):
        test_ansible.test_ansible_patch_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible1', state='present', api_version=self.api_version, changed='4')

    def test_ansible_pool_modify(self):
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='present', api_version=self.api_version, changed='1', enabled='False')
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='present', api_version=self.api_version, changed='0', enabled='False')

    def test_ansible_pool_delete(self):
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='absent', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible', state='absent', api_version=self.api_version, changed='0')

    def test_ansible_pool_add_persfield(self):
        test_ansible.test_ansible_pool_playbook_cd( playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='present', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_addremove_pers_profile( playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='present', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_addremove_pers_profile( playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='present', api_version=self.api_version, changed='0')

    def test_ansible_pool_delete_persfield(self):
        test_ansible.test_ansible_pool_addremove_pers_profile(playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='absent', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_addremove_pers_profile(playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='absent', api_version=self.api_version, changed='0')
        test_ansible.test_ansible_pool_playbook_cd(playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='absent', api_version=self.api_version, changed='1')
        test_ansible.test_ansible_pool_playbook_cd(playbook_dir=self.playbook_dir, pool_name='p_ansible2', state='absent', api_version=self.api_version, changed='0')

    def test_ansible_playbook_create(self):
        test_ansible.test_create_ansible_playbook()

    def test_ansible_playbook_check_mode(self):
        self.ansible_check_mode()

    def test_ansible_config_create(self):
        self.changed = eval('True')
        test_ansible.test_ansible_config_playbook(state='present', changed=self.changed)
        self.changed = eval('False')
        test_ansible.test_ansible_config_playbook(state='present', changed=self.changed)

    def test_ansible_config_delete(self):
        self.changed = eval('True')
        test_ansible.test_ansible_config_playbook(state='absent', changed=self.changed)
        self.changed = eval('False')
        test_ansible.test_ansible_config_playbook(state='absent', changed=self.changed)

    def test_ansible_session_reuse(self):
        test_ansible.test_ansible_reuse_session('/home/rohan/AVI/sdk/python/avi/sdk/test/ansible', state='present', api_version=self.api_version)

    # def test_ansible_in_aws(self):
    #     test_ansible.test_ansible_config_playbook('/home/rohan/AVI/sdk/python/avi/sdk/test/ansible', state='present', api_version=self.api_version)
    # def test_delete(self):
    #     """ Deletes all remaining configurations """
    #     delete_remaining_configs()


