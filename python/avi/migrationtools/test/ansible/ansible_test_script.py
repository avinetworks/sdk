import os
from subprocess import Popen, PIPE, STDOUT
import logging

logging.basicConfig(filename='ansible_test.log', level=logging.INFO)
LOG = logging.getLogger(__name__)

FILE = 'test-playbook.dat'

if not os.path.exists('Output'):
    os.makedirs('Output')

TEXT = os.listdir("Output/")
for item in TEXT:
    if item.endswith(".txt"):
        os.remove(os.path.join('Output', item))

FAIL = open("Output/test_failure.txt", "w+")
PASSED = open("Output/passed.txt", "w+")
PASSED_HEADER = " Successfully passed ansible playbooks "
TEST_FAILED_ERROR = " Errors occured in ansible playbooks "
HEADER1 = PASSED_HEADER.center(100, '=')
HEADER2 = TEST_FAILED_ERROR.center(100, '=')
PASSED.write(HEADER1 + "\n")
FAIL.write(HEADER2 + "\n")

with open(FILE, 'r') as f:
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
            FAIL.write(fileName + "\n")
            FAIL.write(output+"\n")
        else:
            PASSED.write(fileName+"\n")

COUNT = len(open(os.getcwd()+'/Output/passed.txt').readlines())
if COUNT == 1:
    os.remove('Output/test_failure.txt')