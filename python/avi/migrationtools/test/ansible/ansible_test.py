import subprocess
from StringIO import StringIO
from shlex import shlex
from string import Template
import pytest
import json
import logging
import unittest
playbook_file = pytest.config.getoption("--config")
expected_change = pytest.config.getoption("--change")
ansible_temp =Template('ansible-playbook ${playbook} -v')

logging.basicConfig(filename='ansible-test.log', level=logging.INFO)
LOG = logging.getLogger(__name__)


# def test_avi_tenant_module(change=3):
#     cmd = ansible_temp.substitute(playbook='test_avi_tenant.yml')
#     res = subprocess.check_output(cmd, shell=True)
#     sout = StringIO(res)
#     lines = sout.readlines()
#     for index, line in enumerate(lines):
#         if line.startswith('TASK'):
#             result = lines[index + 1]
#             LOG.info(result)
#         if not line.startswith('PLAY RECAP'):
#             continue
#         results = lines[index + 1]
#         ch = [term.split('=')[1] for term in results.split()
#               if term.startswith('changed')][0]
#         err = [term.split('=')[1] for term in results.split()
#               if term.startswith('failed')][0]
#         if int(err) > 1:
#             LOG.error("Ansible module is faild to create configuration from %s" %('test_avi_tenant.yml'))
#         assert int(ch) == int(change)
#         LOG.info("Playbook %s uploaded successfully.." %('test_avi_tenant.yml'))
#
# def test_avi_cloud_module(change=3):
#     cmd = ansible_temp.substitute(playbook='test_avi_cloud.yml')
#     res = subprocess.check_output(cmd, shell=True)
#     sout = StringIO(res)
#     lines = sout.readlines()
#     for index, line in enumerate(lines):
#         if line.startswith('TASK'):
#             result = lines[index + 1]
#             LOG.info(result)
#         if not line.startswith('PLAY RECAP'):
#             continue
#         results = lines[index + 1]
#         ch = [term.split('=')[1] for term in results.split()
#               if term.startswith('changed')][0]
#         err = [term.split('=')[1] for term in results.split()
#                if term.startswith('failed')][0]
#         if int(err) > 1:
#             LOG.error("Ansible module is faild to create configuration from %s" % (playbook_file))
#         assert int(ch) == int(change)
#         LOG.info("Playbook %s uploaded successfully.." % ('test_avi_cloud.yml'))


def test_ansible_configuration():

    cmd = ansible_temp.substitute(playbook = playbook_file)
    res = subprocess.check_output(cmd, shell= True)
    sout = StringIO(res)
    lines = sout.readlines()

    for index, line in enumerate(lines):
        if line.startswith('TASK'):
            result = lines[index + 1]
            LOG.info(result)
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        err = [term.split('=')[1] for term in results.split()
              if term.startswith('failed')][0]
        if int(err) > 1:
            LOG.error("Ansible module is faild to create configuration from %s" %(playbook_file))
        assert int(ch) == int(expected_change)
        LOG.info("Playbook %s uploaded successfully.." %(playbook_file))

# def test_avi_pool_module(change=3):
#     cmd = ansible_temp.substitute(playbook='test_pool_config.yml')
#     res = subprocess.check_output(cmd, shell=True)
#     sout = StringIO(res)
#     lines = sout.readlines()
#
#     for index, line in enumerate(lines):
#         if line.startswith('TASK'):
#             result = lines[index + 1]
#             LOG.info(result)
#         if not line.startswith('PLAY RECAP'):
#             continue
#         results = lines[index + 1]
#         ch = [term.split('=')[1] for term in results.split()
#               if term.startswith('changed')][0]
#         err = [term.split('=')[1] for term in results.split()
#                if term.startswith('failed')][0]
#         if int(err) > 1:
#             LOG.error("Ansible module is faild to create configuration from %s" % ('test_pool_config.yml'))
#         assert int(ch) == int(change)
#         LOG.info("Playbook %s uploaded successfully.." % ('test_pool_config.yml'))
#
# def test_avi_httppolicyset_module(change=7):
#     cmd = ansible_temp.substitute(playbook='test_avi_httppolicyset.yml')
#     res = subprocess.check_output(cmd, shell=True)
#     sout = StringIO(res)
#     lines = sout.readlines()
#
#     for index, line in enumerate(lines):
#         if line.startswith('TASK'):
#             result = lines[index + 1]
#             LOG.info(result)
#         if not line.startswith('PLAY RECAP'):
#             continue
#         results = lines[index + 1]
#         ch = [term.split('=')[1] for term in results.split()
#               if term.startswith('changed')][0]
#         err = [term.split('=')[1] for term in results.split()
#                if term.startswith('failed')][0]
#         if int(err) > 1:
#             LOG.error("Ansible module is faild to create configuration from %s" % ('test_avi_httppolicyset.yml'))
#         assert int(ch) == int(change)
#         LOG.info("Playbook %s uploaded successfully.." % ('test_avi_httppolicyset.yml'))
