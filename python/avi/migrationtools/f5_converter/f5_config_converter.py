import logging
import os

import avi.migrationtools.f5_converter.conversion_util as conv_utils
from avi.migrationtools.f5_converter.monitor_converter import MonitorConfigConv
from avi.migrationtools.f5_converter.persistence_converter import PersistenceConfigConv
from avi.migrationtools.f5_converter.pool_converter import PoolConfigConv
from avi.migrationtools.f5_converter.profile_converter import ProfileConfigConv
from avi.migrationtools.f5_converter import profile_converter
from avi.migrationtools.f5_converter.vs_converter import VSConfigConv
import avi.migrationtools.f5_converter.converter_constants as conv_const

LOG = logging.getLogger(__name__)
csv_writer = None


def convert(f5_config, output_dir, vs_state, input_dir, version,
            ssl_profile_merge_check, user_ignore={}, tenant='admin',
            cloud_name='Default-Cloud'):
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
    :param tenant: Tenant for which config need to be converted
    :param cloud_name: cloud for which config need to be converted
    :return: Converted avi objects
    """

    avi_config_dict = {}
    try:
        # load the yaml file attribute in f5_attributes.
        f5_attributes = conv_const.init(version)
        mon_conv = MonitorConfigConv.get_instance(version, f5_attributes)
        mon_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore,
                         tenant)

        pool_conv = PoolConfigConv.get_instance(version, f5_attributes)
        pool_conv.convert(f5_config, avi_config_dict, user_ignore, tenant,
                          cloud_name)

        profile_conv = ProfileConfigConv.get_instance(version, f5_attributes,
                                                      ssl_profile_merge_check)
        profile_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore,
                             tenant)

        persist_conv = PersistenceConfigConv.get_instance(version, f5_attributes)
        persist_conv.convert(f5_config, avi_config_dict, user_ignore, tenant)

        vs_conv = VSConfigConv.get_instance(version, f5_attributes)
        vs_conv.convert(f5_config, avi_config_dict, vs_state, user_ignore,
                        tenant, cloud_name)

        conv_utils.cleanup_config(avi_config_dict)

        for key in avi_config_dict:
            if key != 'META':
                # Added code to print merged count.
                if ssl_profile_merge_check and key == 'SSLProfile':
                    mergedfile = len(avi_config_dict[key]) -\
                                 profile_conv.sslmergecount
                    LOG.info('Total Objects of %s : %s (%s profile merged)' %
                             (key, len(avi_config_dict[key]),
                              abs(mergedfile)))
                    print 'Total Objects of %s : %s (%s profile merged)' % \
                          (key, len(avi_config_dict[key]),
                           abs(mergedfile))
                    continue
                elif ssl_profile_merge_check and key == 'ApplicationProfile':
                    mergedfile = len(avi_config_dict[key])- \
                                 profile_conv.applicationmergecount
                    LOG.info('Total Objects of %s : %s (%s profile merged)' %
                             (key, len(avi_config_dict[key]),
                              abs(mergedfile)))
                    print 'Total Objects of %s : %s (%s profile merged)' % \
                          (key, len(avi_config_dict[key]),
                           abs(mergedfile))
                    continue
                elif ssl_profile_merge_check and key == 'NetworkProfile':
                    mergedfile = len(avi_config_dict[key]) - \
                                 profile_conv.networkmergecount
                    LOG.info('Total Objects of %s : %s (%s profile merged)' %
                             (key, len(avi_config_dict[key]),
                              abs(mergedfile)))
                    print 'Total Objects of %s : %s (%s profile merged)' % \
                          (key, len(avi_config_dict[key]),
                           abs(mergedfile))
                    continue
                LOG.info('Total Objects of %s : %s' % (key, len(
                    avi_config_dict[key])))
                print 'Total Objects of %s : %s' % (key, len(
                    avi_config_dict[key]))

    except:
        LOG.error("Conversion error", exc_info=True)
    datascript_objs = ['data-group']
    # Added support node as not applicable
    na_list_objs = f5_attributes['na_list_objs']
    for f5_type in f5_config.keys():
        f5_obj = f5_config[f5_type]
        for key in f5_obj.keys():
            sub_type = None
            if ' ' in key:
                sub_type, key = key.rsplit(' ', 1)
            if f5_type in datascript_objs:
                conv_utils.add_status_row(f5_type, sub_type, key,
                                          conv_const.STATUS_DATASCRIPT)
            elif f5_type in na_list_objs:
                conv_utils.add_status_row(f5_type, sub_type, key,
                                          conv_const.STATUS_NOT_APPLICABLE)
            else:
                conv_utils.add_status_row(f5_type, sub_type, key,
                                          conv_const.STATUS_SKIPPED)

    # Add f5 converter status report in xslx report
    conv_utils.add_complete_conv_status(output_dir)
    return avi_config_dict
