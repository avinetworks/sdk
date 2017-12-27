"""
Get the configuration from the config.yml file.
"""

def pytest_addoption(parser):
    parser.addoption("--config_file", action="store", help="configuration file")
    parser.addoption("--type", action="store", help="config type")
    parser.addoption("--controller_version", action="store", help=" Controller version", default="17.1.1" )
    parser.addoption("--file_version", action="store", default="11")
    parser.addoption("--vs_state", action="store", default='disable')
    parser.addoption("--output_path", action="store", help="Output file path")
    parser.addoption('--cloud_name', action="store", help='cloud name for auto upload',
                         default='Default-Cloud')
    parser.addoption('--input_folder_location',
                         help='location of extracted backup folder')
    parser.addoption('--key_file',
                         help='host key file location if key based ' +
                              'authentication')
    parser.addoption('--passphrase_file',
                         help='key passphrase yaml file path')
    parser.addoption('--no_object_merge',
                         help='Flag for object merge', action='store_false')
    parser.addoption('--patch', help='Run config_patch please provide '
                                         'location of patch.yaml')
    parser.addoption('--vs_filter', help='comma seperated names of '
                                             'virtualservices')
    parser.addoption('--ignore_config',
                         help='config json to skip the config in conversion')
    parser.addoption('--prefix', help='Prefix for objects')
    parser.addoption('--not_in_use',
                         help='Flag for skipping not in use object',
                         action="store_true")
    parser.addoption('--baseline_profile', help='asolute path for json '
                                                    'file containing baseline profiles')
    parser.addoption('--ansible',
                         help='Flag for create ansible file', action='store_true')