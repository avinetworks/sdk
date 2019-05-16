import shlex
import logging
from cStringIO import StringIO
from string import Template
import subprocess
logging.basicConfig(filename='go_tests.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

PLAYBOOK_TEMPLATE = \
    Template('go test ${test_file} -v')

def test_create_cloud():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_cloud_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_create_healthmonitor():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_healthmonitor_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_create_profiles():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_profiles_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_create_tenant():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_tenant_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)


def test_create_virtualservice():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='create_virtualservice_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

def test_custom_transport():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='custom_transport_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

def test_delete_configuration():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='delete_configuration_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)

def test_avi_error():
    cmd = PLAYBOOK_TEMPLATE.substitute(test_file='avi_error_test.go')
    LOG.info("executing command %s ", cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.info("playbook out %s ", out)
