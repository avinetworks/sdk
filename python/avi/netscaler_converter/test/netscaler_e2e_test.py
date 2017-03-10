#!/usr/bin/env python
import argparse
import os
from ConfigParser import ConfigParser


def load_ini(ini_file, output_dir):
    """ Parse and collapse a ConfigParser-Style ini file into a nested,
    eval'ing the individual values, as they are assumed to be valid
    python statement formatted """

    ini_config = ConfigParser()
    ini_config.read(ini_file)
    try:
        ini_config.add_section('netscaler_test_config')
    except:
        pass
    ini_config.set('netscaler_test_config', 'output_dir', output_dir)

    with open(ini_file, 'w') as configfile:  # save
        ini_config.write(configfile)

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--ns_config_dir',
                        help='absolute path for Netscaler config directory')
    parser.add_argument('-l', '--input_folder_location',
                        help='location of extracted backup folder')
    parser.add_argument('-o', '--output_dir_path',
                        help='Folder path for output files to be created in')
    parser.add_argument('-t', '--tenant', help='tenant name for auto upload')
    parser.add_argument('--cloud_name', help='cloud name for auto upload')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created')

    args = parser.parse_args()

    # Raise exception if not provide input location
    if not args.ns_config_dir:
        raise Exception('Please provide input directiry')
    input_path = args.ns_config_dir
    # File path of test config ini file which used for to
    test_config_ini_path = 'test/csv_status_cfg.ini'
    input_files = [config_file for config_file in os.listdir(input_path)
                   if os.path.isfile(os.path.join(input_path, config_file))]
    for input in input_files:
        output_dir = args.output_dir_path if args.output_dir_path else input_path
        input_file = os.path.abspath(input_path + '/' + input)
        output_dir = os.path.abspath(output_dir + '/' + input + '-output')
        if not os.path.isdir(output_dir):
            os.mkdir(output_dir)
        output_dir += '/output'
        run_script = 'python netscaler_converter.py -f %s -o %s ' % (input_file,
                                                                    output_dir)
        if args.tenant:
            run_script += '-t %s ' % args.tenant
        if args.input_folder_location:
            run_script += '-l %s ' % args.input_folder_location
        if args.cloud_name:
            run_script += '--cloud_name %s ' % args.cloud_name
        if args.vs_state:
            run_script += '-s %s ' % args.vs_state
        # Start execution of netscaler_converter.py
        os.system(run_script)
        # End execution of netscaler_converter.py
        # Location path for html log report
        test_report_location = '%s/log.html' % output_dir
        load_ini(test_config_ini_path, output_dir)
        os.system("nosetests test/test_csv_status.py -s --tc-file=%s --with-html "
                  "--html-report=%s" % (test_config_ini_path, test_report_location))

