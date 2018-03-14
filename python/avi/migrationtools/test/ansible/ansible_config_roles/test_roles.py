import unittest
import test_script_ansible_config_role as role
import pytest
import vcr

my_vcr = vcr.VCR(
    cassette_library_dir='python/avi/migrationtools/test/ansible/ansible_config_roles/fixtures/cassettes/',
    record_mode='all',
    serializer='json',
    match_on= ['method','url']
)

class Test(unittest.TestCase):

    @my_vcr.use_cassette()
    @pytest.mark.order1
    def test_config_create_role(self):
        role.test_ansible_create_role(state='present', changed=51)
        role.test_ansible_create_role(state='present', changed=14)

    @my_vcr.use_cassette()
    @pytest.mark.order2
    def test_config_update_role(self):
        role.test_ansible_update_role(state='present', changed=46)
        role.test_ansible_update_role(state='present', changed=14)

    @my_vcr.use_cassette()
    @pytest.mark.order3
    def test_delete_role(self):
        role.test_ansible_create_role(state='absent', changed=50)
        role.test_ansible_create_role(state='absent', changed=1)