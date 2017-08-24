#!/usr/bin/env python
import logging
import argparse
import os
import sys
import time
import json
import xlsxwriter
from jinja2 import Environment, FileSystemLoader
import avi.migrationtools
from avi.migrationtools.gss_convertor.gss_config_convertor import \
                                                    config_converter
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.gss_convertor.gss_utils import get_excel_dict,\
                                            get_total_stats, set_total_stats
from pkg_resources import resource_filename


template_loc, template_name =\
                       os.path.split(resource_filename(
                        'avi.migrationtools.gss_convertor.parser_files',
                        'gslb_template.jinja'))


file_loc = os.path.split(os.path.abspath(__file__))[0]
sep = os.path.sep
LOG = logging.getLogger(file_loc + sep + 'out' + sep + 'conversion.log')

sdk_version = getattr(avi.migrationtools, '__version__', None)


class GssConvertor(AviConverter):
    """ GSS Converstion happens here """
    def __init__(self, args):
        self.in_file = args.input_file
        self.out_loc = args.output_loc
        self.tenant = args.tenant
        self.version = args.version
        self.sdk_version = sdk_version

    def init_logger_path(self):
        """ Enabling logging all over """
        LOG.setLevel(logging.DEBUG)
        formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] \
    %(message)s'
        logging.basicConfig(filename=self.out_loc + sep + 'conversion.log',
                            level=logging.DEBUG, format=formatter)

    def avi_json_bakery(self, config):
        """ Here we make json cakes for avi """
        LOG.info('Config Conversion mappings started')

        # getting meta tags from super class
        meta = self.meta(self.tenant, '17.1')
        meta = json.dumps(meta)[1: -1]

        # filling the jinja template to get avi conig json
        config_content = Environment(loader=FileSystemLoader(template_loc)
                         ).get_template(template_name
                         ).render(config=config, meta=meta, tenant=self.tenant)

        # wrting the ouput to json
        with open(self.out_loc + sep + "config.json", 'w') as file_handler:
            file_handler.write(config_content)
        LOG.info('File Generation Completed')

        # Reading from the output
        with open(self.out_loc + sep + "config.json", 'r') as reader:
            output = json.load(reader)
        
        converted_obj = dict()
        for gslb in output.get('GslbService', []):
            converted_obj.update({gslb['name']: gslb })


        # finally creating the excel sheet
        workbook = xlsxwriter.Workbook(self.out_loc + sep +
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

        worksheet.set_default_row(30)
        worksheet.set_column(2, 0, 60)

        # getting excel dict 
        excel_dict = get_excel_dict()

        row = 1
        col = 0
        partial_count = 0
        skip_count = 0
        success_count = 0
        failed_count = 0
        not_supported_count = 0
        hang_count = 0
        total_count = 0

        for key in excel_dict:
            total_count += 1
            if excel_dict[key].get('status', []) == 'success':
                success_count += 1
            elif excel_dict[key].get('status', []) == 'not_supported':
                not_supported_count += 1
            elif excel_dict[key].get('status', []) == 'skip':
                skip_count += 1
            elif excel_dict[key].get('status', []) == 'partial':
                partial_count += 1
            elif excel_dict[key].get('status', []) == 'hang':
                hang_count += 1
            worksheet.write(row, col, str(excel_dict[key]['type']).strip())
            worksheet.write(row, col+1, str(excel_dict[key]['name']).strip())

            if excel_dict[key]['status'] == 'success':
                worksheet.write(row, col+2, excel_dict[key]['status'].strip(),
                                success)
            elif excel_dict[key]['status'] == 'skip' or\
                    excel_dict[key]['status'] == 'failed':
                worksheet.write(row, col+2, excel_dict[key]['status'].strip(),
                                skip)
            elif excel_dict[key]['status'] == 'partial':
                worksheet.write(row, col+2, excel_dict[key]['status'].strip(),
                                partial)
            elif excel_dict[key]['status'] == 'not_supported':
                worksheet.write(row, col+2, excel_dict[key]['status'].strip(),
                                not_supported)
            elif excel_dict[key]['status'] == 'hang':
                worksheet.write(row, col+2, "Incomplete Configuration",
                                skip)

            worksheet.write(row, col+5, str(excel_dict[key]['na']))
            worksheet.write(row, col+3, str(excel_dict[key]['skipped']))

            if excel_dict[key]['rule'] == 'no_rule':
                worksheet.write(row, col+8,
                                "NA",
                                success
                                )
            else:
                worksheet.write(row, col+8,
                                "Refer Parent Rule: " + 
                                    str (excel_dict[key]['rule']),
                                success
                                )

            # Filling  Avi Objects Column
            if excel_dict[key].get('avi_status', []) == 'no member' or\
                    excel_dict[key].get('avi_status', []) == 'no domain':
                worksheet.write(row, col+8,
                                excel_dict[key]['avi_msg'].strip() +
                                " for " + excel_dict[key]['name'],
                                missing)
            elif excel_dict[key]['type'] == 'dns rule' and\
                    excel_dict[key]['name'] in converted_obj.keys():
                worksheet.write(row, col+8,
                                str(converted_obj[excel_dict[key]['name']]),
                                success
                                )

            row = row + 1

        set_total_stats('skip', skip_count)
        set_total_stats('fail', failed_count)
        set_total_stats('success', success_count)
        set_total_stats('partial', partial_count)
        set_total_stats('not_supported', not_supported_count)

        set_total_stats('total', total_count)

        # printing  stats
        stats = get_total_stats()
        print "==========================="
        print "==========Report =========="
        print "==========================="
        for key in stats:
            print "%s: %s" % (key, stats[key])

    def gss_converter(self):  # (self, in_file, out_loc, tenant):
        """ Call the main converter class """
        parsed_output = config_converter(self.in_file)
        self.avi_json_bakery(parsed_output)


if __name__ == '__main__':

    # Getting the runtime
    starttime = time.time()

    HELP_STR = '''
Converts cisco_gss config to avi config pops the config lists for conversion of
each type from cisco gss config and remaining marked as skipped in the
conversion status file

Usage:
    * gss_convertor.py -f <input_file> -o <output_location>

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

    parser.add_argument('-t', '--tenant', default='admin',
                        help='Out file name')

    parser.add_argument('--version', default='17.2',
                        help='Specify the particular version')

    pargs = parser.parse_args()
    if pargs.input_file is not None and pargs.output_loc is not None:
        LOG.info(' ----------------------------------------------------------')
        LOG.info(' Gss Convertor Started ')
        # print "Gss Convertor v" + str(sdk_version) # version needs to be added
        time.sleep(1.5)
        print "Gss Conversion Initializing ...."
        gss_converter = GssConvertor(pargs)

        # creating output directory if not present
        if not os.path.exists(pargs.output_loc):
            print "Folder not found " + pargs.output_loc
            print "Creating ..."
            os.makedirs(pargs.output_loc)

        # initiate logging
        gss_converter.init_logger_path()
        gss_converter.gss_converter()

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
