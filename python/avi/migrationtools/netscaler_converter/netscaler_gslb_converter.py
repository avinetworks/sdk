import argparse
import logging
import avi.migrationtools
import os
import avi.migrationtools.netscaler_converter.scp_util as scp_util
import avi.migrationtools.netscaler_converter.netscaler_parser as ns_parser
from avi.migrationtools.avi_converter import AviConverter
import avi.migrationtools.netscaler_converter.gslb_config_converter as gslb_config_converter

LOG = logging.getLogger(__name__)
sdk_version = getattr(avi.migrationtools, '__version__', None)


class NetscalerGSLBConverter(AviConverter):
    def __init__(self, args):
        self.ns_config_file = args.ns_config_file
        self.output_file_path = args.output_file_path
        self.option = args.option
        self.user = args.user
        self.password = args.password
        self.controller_ip = args.controller_ip
        self.tenant = args.tenant
        self.vs_state = args.vs_state
        self.controller_version = args.controller_version
        self.ns_host_ip = args.ns_host_ip
        self.ns_ssh_user = args.ns_ssh_user
        self.ns_ssh_password = args.ns_ssh_password
        self.ns_key_file = args.ns_key_file
        self.version = args.version
        self.vs_level_status = args.vs_level_status

    def convert(self):
        if not os.path.exists(self.output_file_path):
            os.mkdir(self.output_file_path)
        self.init_logger_path()
        output_dir = os.path.normpath(self.output_file_path)
        is_download_from_host = False
        if self.ns_host_ip:
            input_dir = output_dir + os.path.sep + self.ns_host_ip + \
                        os.path.sep + "input"
            if not os.path.exists(input_dir):
                os.makedirs(input_dir)
            output_dir = output_dir + os.path.sep + self.ns_host_ip + \
                         os.path.sep + "output"
            if not os.path.exists(output_dir):
                os.makedirs(output_dir)
            is_download_from_host = True

        self.print_pip_and_controller_version()
        if is_download_from_host:
            LOG.debug("Copying files from host")
            scp_util.get_files_from_ns(output_dir, self.ns_host_ip,
                                       self.ns_ssh_user, self.ns_ssh_password)
            LOG.debug("Copied input files")
            source_file = output_dir + os.path.sep + "ns.conf"
        else:
            source_file = self.ns_config_file
        report_name = os.path.splitext(os.path.basename(source_file))[0]
        gslb_ns_config = dict()
        ns_config, skipped_cmds = ns_parser.get_ns_conf_dict(source_file)
        gslb_ns_config['add gslb service'] = ns_config.get('add gslb service')
        gslb_ns_config['add gslb vserver'] = ns_config.get('add gslb vserver')
        gslb_ns_config['bind gslb vserver'] = ns_config.get('bind gslb vserver')
        gslb_ns_config['add server'] = ns_config.get('add server')
        print gslb_ns_config
        # getting meta tag from superclass
        meta = self.meta(self.tenant, self.controller_version)
        avi_gslb_config = gslb_config_converter.convert(
            meta, gslb_ns_config, self.controller_ip, self.user, self.password,
            self.tenant, self.vs_state, self.output_file_path, self.version,
            report_name, self.vs_level_status)
        self.write_output(
            avi_gslb_config, output_dir, '%s-Output.json' % report_name)


if __name__ == "__main__":

    # TODO: Update help strings with examples
    HELP_STR = '''


            '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))

    parser.add_argument('-f', '--ns_config_file',
                        help='absolute path for Netscaler config file')
    parser.add_argument('-o', '--output_file_path', default='output',
                        help='Folder path for output files to be created in')
    parser.add_argument('-O', '--option',
                        choices=['cli-upload', 'auto-upload'],
                        help='Upload option cli-upload genarates Avi config ' +
                             'file auto upload will upload config to ' +
                             'controller', default='cli-upload')
    parser.add_argument('-u', '--user',help='controller username of gslb leader',
                        default='admin')
    parser.add_argument('-p', '--password',help='controller password of gslb leader',
                        default='avi123')
    parser.add_argument('-t', '--tenant',
                        help='tenant name for auto upload',
                        default='admin')
    parser.add_argument('-c', '--controller_ip',help='controller ip gslb leader')
    parser.add_argument('-s', '--vs_state', choices=['enable', 'disable'],
                        help='state of VS created', default='disable')
    parser.add_argument('--controller_version',
                        help='Target Avi controller version',
                        default='17.1.7')
    parser.add_argument('--ns_host_ip',
                        help='host ip of Netscaler instance')
    parser.add_argument('--ns_ssh_user', help='Netscaler host ssh username')
    parser.add_argument('--ns_ssh_password',
                        help='Netscaler host ssh password if password based ' +
                             'authentication')
    parser.add_argument('--ns_key_file',
                        help='Netscaler host key file location if key based ' +
                             'authentication')
    parser.add_argument('--version',
                        help='Print product version and exit',
                        action='store_true')

    parser.add_argument('--vs_level_status', action='store_true',
                        help='Add columns of vs reference and overall skipped '
                             'settings in status excel sheet')

    args = parser.parse_args()

    gslb_converter = NetscalerGSLBConverter(args)
    # print avi netscaler converter version
    if args.version:
        gslb_converter.print_pip_and_controller_version()
        exit(0)
    gslb_converter.convert()