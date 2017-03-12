import os
from ConfigParser import ConfigParser


def set_output_dir_in_test_config_ini(ini_file, output_dir):
    """
    Parse and collapse a ConfigParser-Style ini file into a nested,
    eval'ing the individual values, as they are assumed to be valid
    python statement formatted
    :param ini_file: Path of INI file
    :param output_dir: value of output_dir
    :return: None
    """

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
    # set INI file path
    test_config_ini_path = 'test/netscaler_e2e_test_cfg.ini'
    # Read INI file
    ini_config = ConfigParser()
    ini_config.read(test_config_ini_path)

    # Raise exception if not provide input location
    if not ini_config.get('netscaler_e2e_config', 'ns_config_dir'):
        raise Exception('Please provide input directiry')
    # Get the input folder location for config files
    input_path = ini_config.get('netscaler_e2e_config', 'ns_config_dir')
    # File path of test config ini file which used for to
    test_config_ini_path = 'test/netscaler_e2e_test_cfg.ini'
    output_dir_path = ini_config.get('netscaler_e2e_config',
                                     'output_dir_path') \
        if ini_config.get('netscaler_e2e_config', 'output_dir_path') \
        else input_path
    # Get the list of files from input folder
    input_files = [config_file for config_file in os.listdir(input_path)
                   if os.path.isfile(os.path.join(input_path, config_file))]

    for input in input_files:
        # Set the input file to convert
        input_file = os.path.abspath(input_path + '/' + input)
        # Set the output directory path to be create
        output_dir = os.path.abspath(output_dir_path + '/' + input + '-output')
        # If outout directory not exist then create output directory
        if not os.path.isdir(output_dir):
            os.mkdir(output_dir)
        output_dir += '/output'
        run_script = 'python netscaler_converter.py -f %s -o %s ' \
                     % (input_file, output_dir)
        if ini_config.get('netscaler_e2e_config', 'tenant'):
            run_script += '-t %s ' % ini_config.get('netscaler_e2e_config',
                                                    'tenant')
        if ini_config.get('netscaler_e2e_config', 'cloud_name'):
            run_script += '--cloud_name %s ' % \
                          ini_config.get('netscaler_e2e_config', 'cloud_name')
        if ini_config.get('netscaler_e2e_config', 'vs_state'):
            run_script += '-s %s ' % ini_config.get('netscaler_e2e_config',
                                                    'vs_state')
        # Start execution of netscaler_converter.py
        os.system(run_script)
        # Location path for html log report
        test_report_location = '%s/log_test_csv_status.html' % output_dir
        # Set the output directory location in INI file which will be read by
        # test config
        set_output_dir_in_test_config_ini(test_config_ini_path, output_dir)
        # Run test csv status test suite
        os.system("nosetests test/test_csv_status.py -s --tc-file=%s "
                  "--with-html --html-report=%s" % (test_config_ini_path,
                                                    test_report_location))
