import logging
import os
import conversion_util as conv_utils
from monitor_converter import MonitorConfigConv

LOG = logging.getLogger("converter-log")
csv_writer = None

def convert(f5_config_dict, output_dir, input_dir, vs_state, version):
    """
    Converts f5 config to avi config pops the config lists for conversion of
    each type from f5 config and remaining marked as skipped in the
    conversion status file
    :param f5_config_dict: dict representation of f5 config from the file
    :param output_file_path: Folder path to put output files
    :param vs_state: State of created Avi VS object
    :param input_files_location: Location of cert and external monitor
    script files
    :param option: Upload option cli-upload or api-upload
    :return: Converted avi objects
    """
    status_file = output_dir+os.path.sep+"ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    conv_utils.add_csv_headers(csv_file)
    avi_config = {}
    try:
        mon_conv =  MonitorConfigConv.factory(version)
        mon_conv.convert(f5_config_dict, avi_config, input_dir)

    except:
        LOG.error("Conversion error", exc_info=True)