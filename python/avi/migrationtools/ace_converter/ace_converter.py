#!/usr/bin/env python
import logging
import argparse
import os
import sys
import time
import json
import avi.migrationtools
import xlsxwriter
from avi.migrationtools.ace_converter.ace_parser import Parser
from avi.migrationtools.ace_converter.ace_config_converter import\
                                                            ConfigConverter
from avi.migrationtools.ace_converter.ace_utils import get_excel_dict
from pkg_resources import resource_filename
from avi.migrationtools.avi_converter import AviConverter

template_loc, template_name =\
                       os.path.split(resource_filename(
                        'avi.migrationtools.gss_convertor.parser_files',
                        'gslb_template.jinja'))


sep = os.path.sep
LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)


class AceConvertor(AviConverter):
    """ GSS Converstion happens here """
    def __init__(self, args):
        self.in_file = args.input_file
        self.output_file_path = args.output_loc
        self.version = args.version
        self.sdk_version = sdk_version

    # def init_logger_path(self):
    #     """ Enabling logging all over """
    #     LOG.setLevel(logging.DEBUG)
    #     formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] \
    # %(message)s'
    #     logging.basicConfig(filename=self.output_file_path + sep + 'conversion.log',
    #                         level=logging.DEBUG, format=formatter)

    def avi_json_bakery(self, config):
        """ Here we make json cakes for avi """
        LOG.info('Config Conversion mappings started')

    def ace_converter(self):  # (self, in_file, output_file_path, tenant):
        """ Call the main converter class
            3 steps
                - Parsing
                - Configuration Conversion
                - Writing output JSON & Reporting
        """
        # Parsing
        parser = Parser(self.in_file)
        parsed_output = parser.parse_ace()

        # Configuration Conversion
        print "configuration conversion started ..."
        cfgConvert = ConfigConverter(parsed_output)
        converted_output = cfgConvert.conversion()

        # Writing Output JSON
        with open(self.output_file_path + '/config.json', 'w') as writer:
            json.dump(converted_output, writer, sort_keys=True, indent=4)

        # create excel sheet
        self.excel_sheet_writing()

    def excel_sheet_writing(self):
        """ Excel Sheet Creation. """
        workbook = xlsxwriter.Workbook(self.output_file_path + sep +
                                       'Conversion_status.xlsx')
        worksheet = workbook.add_worksheet()

        # Write some data headers.
        bold = workbook.add_format({'bold': True})
        skip = workbook.add_format({'font_color': 'red'})
        not_supported = workbook.add_format({'font_color': 'red'})
        success = workbook.add_format({'font_color': 'green'})
        partial = workbook.add_format({'font_color': 'blue'})
        missing = workbook.add_format({'font_color': 'orange'})

        worksheet.write('A1', 'Type', bold)
        worksheet.write('B1', 'Name', bold)
        worksheet.write('C1', 'Status', bold)
        worksheet.write('D1', 'Skipped Settings', bold)
        worksheet.write('E1', 'Indirect Mappings', bold)
        worksheet.write('F1', 'Not Applicable', bold)
        worksheet.write('G1', 'User Ignore', bold)
        worksheet.write('H1', 'Overall Skip', bold)
        worksheet.write('I1', 'Avi Status', bold)

        excel_dict = get_excel_dict()

        row = 1
        col = 0

        for data in excel_dict:
            # writing values to excel
            worksheet.write(row, col, str(data['type']))
            worksheet.write(row, col+1, str(data['name']))
            worksheet.write(row, col+2, str(data['status']))
            worksheet.write(row, col+3, str(data['skipped']))
            worksheet.write(row, col+4, str(data['indirect']))
            worksheet.write(row, col+5, str(data['NA']))
            worksheet.write(row, col+5, str(data['Avi Object']))

            # increment the row value
            row += 1

if __name__ == '__main__':

    # Getting the total running time
    starttime = time.time()

    HELP_STR = '''
Converts Ace config to avi config

Usage:
    * ace_convertor.py -f <input_file> -o <output_location>

Mandatory
:param input file: the input configuration file
:param output_file : the output file that needs to be generated

Optional:
:param tenant: Tenant for which config need to be converted
:param version: version of the controller (optional)
            '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)

    parser.add_argument('-f', '--input_file',
                        help='Input configuration file that needs to be parsed')

    parser.add_argument('-o', '--output_loc',
                        help='Out file location')

    parser.add_argument('--version', default='17.2',
                        help='Specify the particular version')

    pargs = parser.parse_args()
    if pargs.input_file is not None and pargs.output_loc is not None:
        LOG.info(' ----------------------------------------------------------')
        LOG.info(' Ace Convertor Started ')
        # print "Gss Convertor v" + str(sdk_version) # version needs to be added
        time.sleep(1.5)
        print "Ace Conversion Initializing ...."
        ace_converter = AceConvertor(pargs)

        # creating output directory if not present
        if not os.path.exists(pargs.output_loc):
            print "Folder not found " + pargs.output_loc
            print "Creating ..."
            os.makedirs(pargs.output_loc)

        # initiate logging
        ace_converter.init_logger_path()
        ace_converter.ace_converter()

        # print the totalrun time
        elapsed = time.time() - starttime
        if elapsed < 60:
            elapsed_time = str(elapsed)[:3] + " Seconds"
        else:
            elapsed_time = str(elapsed/60)[:4] + " Minutes"
        print "\n(Elapsed Time: " + elapsed_time + ")"

    elif pargs.input_file is None:
        print "Fatal: Enter a input file"
        sys.exit()
    elif pargs.output_loc is None:
        print "Fatal: Enter a output location"
        sys.exit()
