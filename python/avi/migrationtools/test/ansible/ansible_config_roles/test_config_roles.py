from subprocess import Popen, PIPE, STDOUT

FILE = 'ansible_config_roles.dat'

with open(FILE, 'r') as file:
    for line in file:
        playbook_list = line.split(' ')
        create_playbook = playbook_list[0]
        update_playbook = playbook_list[1]
        print create_playbook , update_playbook
        cmd = 'pytest test_roles.py -vvvv --create_playbook %s --update_playbook %s' %(create_playbook, update_playbook)
        p = Popen(cmd, shell=True, stdin=PIPE, stdout=PIPE, stderr=STDOUT, close_fds=True)
        output = p.stdout.read()
        print output