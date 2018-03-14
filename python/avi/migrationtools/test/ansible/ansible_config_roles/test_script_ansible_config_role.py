import shlex
import logging
from cStringIO import StringIO
from string import Template
import subprocess
logging.basicConfig(filename='ansible_config_role.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

configuration_playbook_tmpl = \
    Template('ansible-playbook ${playbook} '
             '--extra-vars "state=${state} config=${config_file}"')

def test_ansible_create_role(state='present', changed=49):
    """
    1. launch ansible avi_config playbook
    2. expect change in all configuration
    3. launch ansible avi_config playbook again
    4. expect change in specific configurations
    """
    cmd = configuration_playbook_tmpl.substitute(
        playbook="%s" %('config_test.yml'),
        config_file= "%s" %('avi_config.yml'),
        state=state)
    LOG.info('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    LOG.info('playbook out %s' % (out))
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

def test_ansible_update_role(state='present', changed=45):
    """
    1. launch ansible avi_config_update playbook
    2. expect change count
    3. launch ansible avi_config_update playbook again
    4. expect no change
    """
    cmd = configuration_playbook_tmpl.substitute(
        playbook="%s" %('config_test.yml'),
        config_file="%s" % ('avi_config_update.yml'),
        state=state)
    LOG.info('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    LOG.info('playbook out %s' % (out))
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