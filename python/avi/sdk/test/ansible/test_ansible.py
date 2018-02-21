import shlex
import subprocess
from cStringIO import StringIO
from string import Template
import os
import logging
import pytest
from avi.migrationtools.ansible.avi_config_to_ansible import AviAnsibleConverter
from avi.sdk.avi_api import ApiSession

logging.basicConfig(filename='ansible-test.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

controller = pytest.config.getoption("--controller")
username = pytest.config.getoption("--username")
password = pytest.config.getoption("--password")

dir_path = '/home/rohan/AVI/modules'
playbook_dir = '/tmp'
hosts_file = '/tmp/ansible_hosts'
default_servers = '10.42.10.10,10.42.10.11,10.42.10.12'

if not os.path.exists(hosts_file):
    LOG.info('creating the temp hosts file')
    with open(hosts_file, 'w') as f:
        f.write('localhost')



# Added api_version to pool_playbook_tmpl.
pool_playbook_tmpl = \
    Template('ansible-playbook -i ${hosts} -M ${avi_ansible_module} ${playbook} '
             '--extra-vars "pool_name=${pool_name} pool_servers=${servers} '
             'controller=${controller} username=${username} state=${state} '
             'password=${password} enabled=${enabled} api_version=${api_version}"')

playbook_tmpl = \
    Template('ansible-playbook -i ${hosts} -M ${avi_ansible_module} ${playbook} '
             '--extra-vars "controller=${controller} '
             'username=${username} password=${password}"')

ansible_reuse_session = \
    Template('ansible-playbook -i ${hosts} -M ${avi_ansible_module} ${playbook} '
             '--extra-vars "controller=${controller} username=${username} '
             'password=${password} api_version=${api_version}"')

# Template Added for check mode
ansible_checkmode_tmpl = \
    Template('ansible-playbook -i ${hosts} -M ${avi_ansible_module} ${playbook} '
             '--extra-vars "pool_name=${pool_name} pool_servers=${servers} '
             'controller=${controller} username=${username} state=${state} '
             'password=${password} enabled=${enabled} api_version=${api_version}'
             ' dontskip=${dontskip}"')


def test_ansible_reuse_session(playbook_dir, state='present',
                               api_version='16.4'):
    """

    Added ansible test case for reuse session
    :param playbook_dir: playbook dir
    :param state: state of object on controller
    :param api_version: api version for controller
    :return:
    """
    cmd = ansible_reuse_session.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        playbook="%s/ansible_reuse_session.yml" % playbook_dir,
        avi_ansible_module='%s' % dir_path, state=state,
        api_version=api_version)
    LOG.debug('executing command %s' % cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.debug('playbook out %s' % (out))
    sout = StringIO(out)
    lines = sout.readlines()
    resultlist = []
    for index, line in enumerate(lines):
        if not line.startswith('TASK [debug]'):
            continue
        results = lines[index + 2]
        terms = results.split()
        resultlist.append({'csrftoken' : terms[2], 'session_id' : terms[4]})
        LOG.info(resultlist)
    assert resultlist[0] == resultlist[1]

# Added api version
def test_ansible_pool_playbook_cd(playbook_dir, pool_name, state='present',
                                  changed=1, enabled='True', api_version='16.4'):
    """
    1. launch ansible pool playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """
    servers = default_servers
    cmd = pool_playbook_tmpl.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        pool_name=pool_name, servers=servers,
        playbook="%s/ansible_test_pool.yml" % playbook_dir,
        avi_ansible_module='%s' % dir_path, state=state,
        enabled=enabled, api_version=api_version)
    LOG.debug('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    # print out
    LOG.debug('playbook out %s' % (out))
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
def test_ansible_patch_pool_playbook_cd(playbook_dir, pool_name, state='present',
                                  changed=1, enabled='True', api_version='16.4'):
    """
    1. launch ansible pool playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """
    servers = default_servers
    cmd = pool_playbook_tmpl.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        pool_name=pool_name, servers=servers,
        playbook="%s/ansible_patch_test.yml" % playbook_dir,
        avi_ansible_module='%s' % dir_path, state=state,
        enabled=enabled, api_version=api_version)
    LOG.debug('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    # print out
    LOG.debug('playbook out %s' % (out))
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

def test_ansible_check_mode_playbook(playbook_dir, pool_name, state='present',
                                     enabled='True', api_version='16.4',
                                     dontskip=True):
    """

    Added test for check mode
    :param playbook_dir: Playbook directory
    :param pool_name: Pool name
    :param state: State of pool
    :param enabled: enabled state
    :param api_version: api version for avi
    :param dontskip: flag for dont skip
    :return: Ch: Change mode flag
    """
    servers = default_servers
    cmd = ansible_checkmode_tmpl.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        pool_name=pool_name, servers=servers,
        playbook="%s/ansible_check_mode_test.yml" % playbook_dir,
        avi_ansible_module='%s' % dir_path, state=state,
        enabled=enabled, api_version=api_version, dontskip=dontskip)
    LOG.debug('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    LOG.debug('playbook out %s' % (out))
    sout = StringIO(out)
    lines = sout.readlines()
    for index, line in enumerate(lines):
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        return ch


def test_ansible_config_playbook(state='present', changed=True):
    """
    1. launch ansible pool playbook
    2. expect no errors
    3. launch ansible pool playbook again
    4. expect no change
    """
    # generate the configuration for the virtualservice
    #
    playbook_name = ('avi_config.yml'
                     if state == 'present' else 'avi_config_delete.yml')
    cmd = playbook_tmpl.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        playbook="%s/%s" % (playbook_dir, playbook_name),
        avi_ansible_module='%s' % dir_path)
    LOG.debug('executing command %s' % cmd)
    out = subprocess.check_output(shlex.split(cmd))
    LOG.debug('playbook out %s' % (out))
    print out
    sout = StringIO(out)
    lines = sout.readlines()
    for index, line in enumerate(lines):
        if not line.startswith('PLAY RECAP'):
            continue
        results = lines[index + 1]
        ch = [term.split('=')[1] for term in results.split()
              if term.startswith('changed')][0]
        ch = (int(ch) != 0)
        LOG.debug('changed %s expected %s' %(ch, changed))
        assert changed == ch
        break

def test_create_ansible_playbook():
    api = ApiSession(
        controller_ip= controller,
        username= username,
        password= password,
        api_version='17.2.7')

    path = ('configuration/export?passphrase=avi123&'
            'include_name=true&uuid_refs=true')
    avi_cfg = api.get(path)
    if avi_cfg.status_code > 299:
        raise RuntimeError('Error %d: %s' % (avi_cfg.status_code, avi_cfg))

    avi_config = avi_cfg.json()
    filter_types = ['VirtualService', 'Pool', 'VsVip', ]
    aac = AviAnsibleConverter\
        (avi_config, playbook_dir, filter_types=filter_types)
    aac.write_ansible_playbook()

# Added api version
def test_ansible_pool_addremove_pers_profile(playbook_dir, pool_name, state='present',
        changed=1, enabled='True', api_version='16.4'):
    """
    pass key value pairs to add or remove from the pool
    application_persistence_profile_ref: "System-Persistence-HTTP-Cookie"
    :param playbook_dir:
    :param pool_name:
    :param state:
    :param changed:
    :param enabled:
    :return:
    """
    servers = default_servers
    cmd = pool_playbook_tmpl.substitute(
        hosts=hosts_file,
        controller=controller, username=username, password=password,
        pool_name=pool_name, servers=servers,
        playbook="%s/ansible_test_pool_addremove_pers_profile.yml" % playbook_dir,
        avi_ansible_module='%s/../avi_ansible' % dir_path, state=state,
        enabled=enabled, api_version=api_version)
    LOG.debug('executing command %s' % cmd)

    out = subprocess.check_output(shlex.split(cmd))
    # print out
    LOG.debug('playbook out %s' % (out))

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
