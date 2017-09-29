"""
This testsuite contains the initial test cases for testing the
Ace converter tool along with its options / parameters
"""

import logging
import os
import unittest
from avi.migrationtools.ace_converter.ace_converter import AceConvertor


class Namespace:
    def __init__(self, **kwargs):
        self.__dict__.update(kwargs)

def ace_conv(input_file=None, output_loc=None, version=None, sdkversion=None):
    args = Namespace(input_file=input_file,
                     output_loc=output_loc,
                     controller_version=version,
                     sdk_version=sdkversion)

    ace_converter = AceConvertor(args)
    avi_config = ace_converter.ace_converter()
    return avi_config

LOG = logging.getLogger(__name__)

path = os.path.dirname(os.path.abspath(__file__))
in_file = "%s%sdummy.conf" % (path, os.sep)
out_loc = "%s%soutput" % (path, os.sep)

class TestAceConverter(unittest.TestCase):

    def test_conversion(self):
        """
        Download Input File Flow, Test for Controller v17.1.1
        """
        ace_conv(input_file=in_file,
                 output_loc=out_loc,
                 version='17.1.1',
                 sdkversion='17.1.1')
