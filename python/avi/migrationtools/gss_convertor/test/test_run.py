import unittest
import os
import json

import avi.migrationtools.gss_convertor.gss_convertor as convertor
import avi.migrationtools.gss_convertor.gss_parser as parser
from avi.migrationtools.gss_convertor.gss_utils import get_loc

# Set basic locations
parent_loc = get_loc()
sep = os.sep
generated_loc = parent_loc + sep + "test" + sep + "generated_files" + sep
file_loc = parent_loc + sep + "test" + sep + "files" + sep
out_file_loc = parent_loc + sep + "test" + sep + "generated_files"


class Mock_config:
    """ Setting up mock config file """
    def __init__(self):
        self.input_file = file_loc + 'in1.txt'
        self.output_loc = out_file_loc
        self.tenant = 'admin'
        self.version = ''
        self.username = ''
        self.password = ''
        self.controller_ip = ''
        self.sdk_version = ''


def parse_pair(in_val):
    ''' It should return paired dict if len(list) % 2 == 0
        else return empty dict '''
    pair = parser.parse(in_val)
    if pair.get('hang', []):
        del pair['hang']
    return pair


class SimpleTest(unittest.TestCase):
    ''' The simple Test case Class '''
    def test_parse_pair(self):
        ''' First test case '''
        in_val = ['key1', 'val1', 'key2', 'val2']
        match = {'key1': 'val1', 'key2': 'val2'}
        self.assertEqual(parse_pair(in_val), match)

    def test_parse_pair_false(self):
        ''' should return empty dict '''
        in_val = ['key1', 'val1', 'key2', 'val2', 'key3']
        match = dict()
        self.assertEqual(parse_pair(in_val), match)

    def test_file(self):
        '''should test the whole input file'''
        with open(generated_loc + "out1.json", 'w') as writer:
            writer.write('')
        mock = Mock_config()
        gss_converter = convertor.GssConvertor(mock)
        gss_converter.init_logger_path()
        gss_converter.gss_converter()
        with open(out_file_loc + sep + 'config.json', 'r') as reader:
            output = json.load(reader)
        self.assertEqual(len(output.get('GslbService', [])), 2)


if __name__ == '__main__':
    # Start the unit test cases
    unittest.main()
