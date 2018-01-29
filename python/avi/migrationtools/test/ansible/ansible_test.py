import subprocess
from StringIO import StringIO
from shlex import shlex
from string import Template
import pytest
import json

playbook_file = pytest.config.getoption("--config")


ansible_temp =Template('ansible-playbook ${playbook}')


def test_configuration():
    cmd = ansible_temp.substitute(playbook = playbook_file)
    changed = 3
    res = subprocess.check_output(cmd, shell= True)
    sout = StringIO(res)
    lines = sout.readlines()
    for index, line in enumerate(lines):
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        assert int(ch) == int(changed)

