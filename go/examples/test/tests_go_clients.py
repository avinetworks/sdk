import shlex
import pytest
import logging
from cStringIO import StringIO
from string import Template
import subprocess
logging.basicConfig(filename='go_tests.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

PLAYBOOK_TEMPLATE = \
    Template('go test ${test_file} -v')


@pytest.mark.TCID1_48_1606_1_0
def test_create_cloud():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_cloud_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)



@pytest.mark.TCID1_48_1606_2_0
def test_create_healthmonitor():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_healthmonitor_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)



@pytest.mark.TCID1_48_1606_3_0
def test_create_profiles():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_profiles_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)



@pytest.mark.TCID1_48_1606_4_0
def test_create_tenant():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_tenant_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)



@pytest.mark.TCID1_48_1606_5_0
def test_create_virtualservice():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_virtualservice_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


@pytest.mark.TCID1_48_1606_6_0
def test_custom_transport():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='custom_transport_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_reset_password():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='avi_client_change_password_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

@pytest.mark.TCID1_48_1606_7_0
def test_delete_configuration():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='delete_configuration_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


@pytest.mark.TCID1_48_1606_8_0
def test_avi_error():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='avi_error_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_avi_client_error():
    '''
    Test avi go sdk client with lazyauthentication and invalid controlleer IP
    '''
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='aviclient_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

@pytest.mark.TCID1_48_1606_9_0
def test_fileupload():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='fileupload_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

def test_avi_client_error():
    '''
    Test avi go sdk client with lazyauthentication and invalid controlleer IP
    '''
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='aviclient_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)
