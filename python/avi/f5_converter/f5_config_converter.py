import logging
import os

import conversion_util as conv_utils
from monitor_converter import MonitorConfigConv
from persistence_converter import PersistenceConfigConv
from pool_converter import PoolConfigConv
from profile_converter import ProfileConfigConv
from vs_converter import VSConfigConv

LOG = logging.getLogger(__name__)
csv_writer = None


def convert(f5_config, output_dir, vs_state, input_dir, version,
            user_ignore={}, tenant='admin'):
    """
    Converts f5 config to avi config pops the config lists for conversion of
    each type from f5 config and remaining marked as skipped in the
    conversion status file
    :param f5_config: dict representation of f5 config from the file
    :param output_dir: Folder path to put output files
    :param vs_state: State of created Avi VS object
    :param input_dir: Location of cert and external monitor script files
    :param version: Version of F5 config
    :param user_ignore: Ignore config defined by user
    :return: Converted avi objects
    """

    status_file = output_dir + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    conv_utils.add_csv_headers(csv_file)
    avi_config_dict = {}
    try:
        mon_conv = MonitorConfigConv.get_instance(version)
        mon_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore, tenant)

        pool_conv = PoolConfigConv.get_instance(version)
        pool_conv.convert(f5_config, avi_config_dict, user_ignore, tenant)

        profile_conv = ProfileConfigConv.get_instance(version)
        profile_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore, tenant)

        persist_conv = PersistenceConfigConv.get_instance(version)
        persist_conv.convert(f5_config, avi_config_dict, user_ignore, tenant)

        vs_conv = VSConfigConv.get_instance(version)
        vs_conv.convert(f5_config, avi_config_dict, vs_state, user_ignore, tenant)

        conv_utils.cleanup_config(avi_config_dict)

        for key in avi_config_dict:
            if key != 'META':
                LOG.info('Total Objects of %s : %s' % (key, len(avi_config_dict[key])))
                print 'Total Objects of %s : %s' % (key, len(avi_config_dict[key]))

    except:
        LOG.error("Conversion error", exc_info=True)
    for f5_type in f5_config.keys():
        f5_obj = f5_config[f5_type]
        for key in f5_obj.keys():
            sub_type = None
            if ' ' in key:
                sub_type, key = key.rsplit(' ', 1)
            conv_utils.add_status_row(f5_type, sub_type, key, 'skipped')
    csv_file.close()
    return avi_config_dict
