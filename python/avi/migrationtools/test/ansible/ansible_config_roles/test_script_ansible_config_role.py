import shlex
import pytest
import logging
from cStringIO import StringIO
from string import Template
import subprocess
import os
logging.basicConfig(filename='ansible_config_role.log', level=logging.INFO)
LOG = logging.getLogger(__name__)


os.environ['AVI_USERNAME'] = "admin"
os.environ['AVI_PASSWORD'] = "admin"
os.environ['AVI_CONTROLLER'] = "10.10.28.98"
os.environ['API_VERSION'] = "17.2.7"

# Added api_version to pool_playbook_tmpl.
healthmonitor_playbook_tmpl = \
    Template('ansible-playbook ${playbook} '
             '--extra-vars "state=${state}"')

# Added api version
def test_ansible_create_role(playbook_dir, state='present', changed=1):
    """
    1. launch ansible healthmonitor playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """
    LOG.info(" ##### %s" %(playbook_dir))

    cmd = healthmonitor_playbook_tmpl.substitute(
        playbook="%s" %(playbook_dir),
        state=state)
    LOG.info('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    #LOG.debug('playbook out %s' % (out))
    sout = StringIO(out)
    lines = sout.readlines()
    for index, line in enumerate(lines):
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        assert int(ch) == int(changed)
        break



# Added api version
def test_ansible_update_role(playbook_dir, state='present', changed=1):
    """
    1. launch ansible healthmonitor playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """
    cmd = healthmonitor_playbook_tmpl.substitute(
        playbook="%s" %(playbook_dir), state=state)
    LOG.info('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    #LOG.debug('playbook out %s' % (out))
    sout = StringIO(out)
    lines = sout.readlines()
    for index, line in enumerate(lines):
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        assert int(ch) == int(changed)
        break