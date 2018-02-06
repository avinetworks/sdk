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
from avi.migrationtools.vs_filter import filter_for_vs
from avi.migrationtools.ace_converter.ace_config_converter import\
    ConfigConverter
from avi.migrationtools.ace_converter.ace_utils import get_excel_dict
from pkg_resources import resource_filename
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ansible.ansible_config_converter import AviAnsibleConverter

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
        self.controller_version = args.controller_version
        self.sdk_version = sdk_version
        self.enable_vs = (True if str(args.vs_state) == "enable" else False)
        print "enable_vs", self.enable_vs, args.vs_state
        self.input_folder_location = args.input_folder_location
        self.tenant = args.tenant
        self.cloud = args.cloud_name
        # uploading params
        self.option = args.option
        self.user = args.user
        self.password = args.password
        self.controller_ip = args.controller_ip
        # ansible param
        self.create_ansible = args.ansible
        # patch and vs_filter
        self.patch = args.patch
        self.vs_filter = args.vs_filter
        # vrf name
        self.vrf_name = args.vrf_name

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
        # printing pip version
        self.print_pip_and_controller_version()

        # Parsing
        parser = Parser(self.in_file)
        parsed_output = parser.parse_ace()

        # Configuration Conversion
        print "configuration conversion started ..."
        cfgConvert = ConfigConverter(parsed_output,
                                     version=self.controller_version, enable_vs=self.enable_vs,
                                     input_folder_loc=self.input_folder_location,
                                     tenant=self.tenant, cloud=self.cloud, vrf=self.vrf_name)
        converted_output = cfgConvert.conversion()

        out_file = "/%s-config.json" % os.path.splitext(
            os.path.basename(self.in_file))[0]
        self.out_excel = "/%s-Conversion_status.xlsx" % os.path.splitext(
            os.path.basename(self.in_file))[0]

        # Avi Config
        avi_config = self.process_for_utils(converted_output)

        # writing config.json
        with open(self.output_file_path + out_file, 'w') as writer:
            json.dump(avi_config, writer, sort_keys=True, indent=4)

        # writing ansible if needed
        if self.create_ansible:
            avi_traffic = AviAnsibleConverter(
                avi_config, self.output_file_path, prefix=None, not_in_use=None)
            avi_traffic.write_ansible_playbook()

        # create excel sheet
        self.excel_sheet_writing()

        # if auto-upload enabled to auto upload
        if self.option == 'auto-upload':
            if self.controller_ip:
                self.upload_config_to_controller(converted_output)
            else:
                print "Fatal: enter controller ip"

    def excel_sheet_writing(self):
        """ Excel Sheet Creation. """
        workbook = xlsxwriter.Workbook(self.output_file_path + sep +
                                       self.out_excel)
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
            worksheet.write(row, col + 1, str(data['name']))
            worksheet.write(row, col + 2, str(data['status']))
            worksheet.write(row, col + 3, str(data['skipped']))
            worksheet.write(row, col + 4, str(data['indirect']))
            worksheet.write(row, col + 5, str(data['NA']))
            worksheet.write(row, col + 8, str(data['Avi Object']))

            # increment the row value
            row += 1

    def print_pip_and_controller_version(self):
        # Added input parameters to log file
        LOG.info("Input parameters: %s" % ' '.join(sys.argv))
        # Add logger and print avi netscaler converter version
        LOG.info('AVI sdk version: %s Controller Version: %s'
                 % (sdk_version, self.controller_version))
        print 'AVI sdk version: %s Controller Version: %s' \
              % (sdk_version, self.controller_version)


if __name__ == '__main__':

    # Getting the total running time
    starttime = time.time()

    HELP_STR = '''
Converts Ace config to avi config

Usage:
======
    * ace_convertor.py -f <input_file> -o <output_location>

Mandatory:
==========
:param input file: the input configuration file
:param output_file : the output file that needs to be generated

Optional:
=========
:param ansible: To create ansible upload file
:param controller_version: To Target which controller converting into
:param cloudname: To change the cloud name
:param input_file: Path of the file that needs to be parsed
:param input_folder_location: Location of input key and cert files, if not use current run location
:param output_loc: Path where the parsed data needs to be stored
:param patch: To patch the configuration file
:param tenant: Tenant for which config need to be converted
:param version: version of the controller
:param vrf_name: Add vrf reference to pool and vs
:param vs_filter: To filter vs out of configuration
:param vs_state: To enable or disable after the vs is create

:param option: (auto-upload) Upload after conversion, directly into controller
    :param user: Username of Controller to upload 
    :param password: Password of Controller to upload
    :param controller_ip: The ip of the controller to upload
'''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)

    parser.add_argument('--ansible',
                        help='Flag for create ansible file',
                        action='store_true')

    parser.add_argument('-c', '--controller_ip',
                        help='controller ip for auto upload')

    parser.add_argument('--cloud_name', help='cloud name for auto upload',
                        default='Default-Cloud')

    parser.add_argument('--controller_version', default='17.1.1',
                        help='Specify the particular version')

    parser.add_argument('-f', '--input_file',
                        help='Input configuration file that needs to be parsed')

    # key and cert input location
    parser.add_argument('-l', '--input_folder_location',
                        help='location of key and cert file')

    parser.add_argument('-o', '--output_loc',
                        help='Out file location')

    # Auto Upload Options
    parser.add_argument('-O', '--option',
                        choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config '
                             'file auto upload will upload config to '
                             'controller', default='cli-upload')

    parser.add_argument('-p', '--password',
                        help='controller password for auto upload',
                        default='avi123')

    # Added command line args to execute config_patch file with related avi
    # json file location and patch location
    parser.add_argument('--patch', help='Run config_patch please provide '
                                        'location of patch.yaml')

    # enable vs
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')

    parser.add_argument('-t', '--tenant',
                        help='tenant name for auto upload',
                        default='admin')

    parser.add_argument('-u', '--user',
                        help='controller username for auto upload',
                        default='admin')

    # Version Parameter
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')

    # vrf name Parameter
    parser.add_argument('--vrf_name',
                        help='Attach the vrf reference to pool and vs')

    # Added command line args to execute vs_filter.py with vs_name.
    parser.add_argument('--vs_filter', help='comma seperated names of'
                                            'virtualservices')

    pargs = parser.parse_args()

    if pargs.version:
        print "SDK Version: %s\nController Version: %s" % \
              (sdk_version, pargs.controller_version)
        exit(0)

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
            elapsed_time = str(elapsed / 60)[:4] + " Minutes"
        print "\n(Elapsed Time: " + elapsed_time + ")"

    elif pargs.input_file is None:
        print "Fatal: Enter a input file"
        sys.exit()
    elif pargs.output_loc is None:
        print "Fatal: Enter a output location"
        sys.exit()
