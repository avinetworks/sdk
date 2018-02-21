import os
from subprocess import Popen, PIPE, STDOUT
from string import Template
import sys
import logging
import env_vars

logging.basicConfig(filename='ansible-test.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

ansible_temp =Template('pytest ansible_test.py --config ${config} --change ${change}')
file = 'test-playbook.dat'
num_lines = 0

test = os.listdir("Output/")
for item in test:
    if item.endswith(".txt"):
        os.remove(os.path.join('Output', item))

if not os.path.exists('Output'):
    os.makedirs('Output')

fail = open("Output/test_failure.txt", "w+")
passed = open("Output/passed.txt", "w+")
passed_header = " Successfully passed ansible playbooks "
test_failed_error= " Errors occured in ansible playbooks "
header1  = passed_header.center(100, '=')
header2 = test_failed_error.center(100, '=')
passed.write(header1 + "\n")
fail.write(header2 + "\n")

with open(file, 'r') as f:
    for line in f:
        list = line.split(' ')
        fileName = list[0]
        change = list[1].split('=')[1]
        print fileName
        cmd = 'pytest ansible_test.py -vvvv --config %s --change %s' %(fileName, change)
        p = Popen(cmd, shell=True, stdin=PIPE, stdout=PIPE, stderr=STDOUT, close_fds=True)
        output = p.stdout.read()
        print output

        if 'FAILURES' in output:
            fail.write(fileName + "\n")
            fail.write(output+"\n")
        else:
            passed.write(fileName+"\n")

count = len(open('/home/rohan/AVI/sdk/python/avi/migrationtools/test/ansible/Output/passed.txt').readlines(  ))
print count
if count == 1:
    print count
    os.remove('Output/test_failure.txt')