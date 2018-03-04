import shlex

import pytest
import logging
from cStringIO import StringIO
from string import Template
import subprocess



controller = pytest.config.getoption("--controller")
username = pytest.config.getoption("--username")
password = pytest.config.getoption("--password")

# Added api_version to pool_playbook_tmpl.
healthmonitor_playbook_tmpl = \
    Template('ansible-playbook ${playbook} '
             '--extra-vars "monitor_name=${monitor_name} '
             'controller=${controller} username=${username} state=${state} '
             'password=${password} api_version=${api_version}"')

# Added api version
def test_ansible_create_role(playbook_dir, monitor_name, state='present',
                                  changed=1, api_version='16.4'):
    """
    1. launch ansible healthmonitor playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """

    cmd = healthmonitor_playbook_tmpl.substitute(
        controller=controller, username=username, password=password,
        playbook="%s/test_healthmonitor_config.yml " %(playbook_dir),
        monitor_name=monitor_name,
        state=state,
        api_version=api_version)
    #LOG.debug('executing command %s' % cmd)

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
def test_ansible_update_role(playbook_dir, monitor_name, state='present',
                                  changed=1, api_version='16.4'):
    """
    1. launch ansible healthmonitor playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """

    cmd = healthmonitor_playbook_tmpl.substitute(
        controller=controller, username=username, password=password,
        playbook="%s/test_update_healthmonitor_config.yml " %(playbook_dir),
        monitor_name=monitor_name,
        state=state,
        api_version=api_version)
    #LOG.debug('executing command %s' % cmd)

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