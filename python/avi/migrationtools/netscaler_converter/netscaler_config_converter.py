import logging
import yaml
import os
import json
import time

from pkg_resources import parse_version
from avi.migrationtools.netscaler_converter.ns_service_converter \
    import ServiceConverter, app_per_merge_count
from avi.migrationtools.netscaler_converter.monitor_converter import \
    MonitorConverter, merge_object_mapping
from avi.migrationtools.netscaler_converter.lbvs_converter import \
    LbvsConverter, tmp_avi_config
from avi.migrationtools.netscaler_converter.csvs_converter import \
    CsvsConverter
from avi.migrationtools.netscaler_converter.profile_converter import \
    ProfileConverter, app_merge_count
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.netscaler_converter import ns_util as nsu
from avi.migrationtools.netscaler_converter.ns_util import NsUtil


LOG = logging.getLogger(__name__)
# Creating object for util library.
ns_util = NsUtil()

def convert(meta, ns_config_dict, tenant_name, cloud_name, version, output_dir,
            input_dir, skipped_cmds, vs_state, object_merge_check,report_name,
            prefix, vs_name_dict, profile_path, redirect, key_passphrase=None,
            user_ignore={}, vs_level_status=False, vrf=None, segroup=None):
    """
    This functions defines that it convert service/servicegroup to pool
    Convert pool group of netscalar bind lb vserver configuration
    :param ns_config_dict: Dict of netscalar commands
    :param tenant: Tenant
    :param cloud_ref: Cloud ref
    :param version: Version
    :param output_dir: Output dir for write AVI object after conversion
    :param input_dir: Input dir is to keep cert and keys
    :param skipped_cmds: List of skipped commands
    :param vs_state: VS state
    :param object_merge_check: Flag of object merge
    :param report_name: name of input file
    :param: prefix: prefix for objects
    :param key_passphrase: path of passphrase yaml file
    :param user_ignore: Dict of user ignore attributes
    :param vs_level_status: Add columns of vs reference overall skipped settings
    :return: None
    """

    ssl_ciphers_yaml = 'ssl_ciphers.yaml'
    # load ssl ciphers
    with open(os.path.dirname(__file__) + '/%s'% ssl_ciphers_yaml) as stream:
        ssl_ciphers = yaml.safe_load(stream)
    LOG.debug('Conversion Started')
    tenant_ref = ns_util.get_object_ref(tenant_name, 'tenant')
    cloud_ref = ns_util.get_object_ref(cloud_name, 'cloud')
    try:
        # call meta from super class
        avi_config = dict()
        sys_dict = dict()
        avi_config['META'] = meta  # avi_obj.meta(tenant_name, version)

        merge_object_type = ['ApplicationProfile', 'NetworkProfile',
                             'SSLProfile', 'PKIProfile',
                             'ApplicationPersistenceProfile', 'HealthMonitor']
        # Constructed avi config dict and baseline object dict for objects
        # which can be merged
        for key in merge_object_type:
            sys_dict[key] = []
            avi_config[key] = []
        # Read the baseline json file and filled the baseline object dict
        if profile_path and os.path.exists(profile_path):
            with open(profile_path) as data:
                prof_data = json.load(data)
                for key in merge_object_type:
                    sys_dict[key] = prof_data.get(key, [])
        monitor_converter = MonitorConverter(
            tenant_name, cloud_name, tenant_ref, cloud_ref, user_ignore,
            prefix, object_merge_check, version)
        monitor_converter.convert(ns_config_dict, avi_config, input_dir,
                                  sys_dict)

        profile_converter = ProfileConverter(
            tenant_name, cloud_name,tenant_ref, cloud_ref, ssl_ciphers,
            object_merge_check, user_ignore, prefix, key_passphrase)
        profile_converter.convert(ns_config_dict, avi_config, input_dir,
                                  sys_dict)

        service_converter = ServiceConverter(
            tenant_name, cloud_name,tenant_ref, cloud_ref, object_merge_check,
            user_ignore, prefix)
        service_converter.convert(ns_config_dict, avi_config, sys_dict, vrf)

        lbvs_converter = LbvsConverter(
            tenant_name, cloud_name, tenant_ref, cloud_ref, object_merge_check,
            version, user_ignore, prefix)
        lbvs_converter.convert(ns_config_dict, avi_config, vs_state, sys_dict,
                               vs_name_dict, vrf, segroup)
        csvs_converter = CsvsConverter(
            tenant_name, cloud_name, tenant_ref, cloud_ref, object_merge_check,
            version, user_ignore, prefix)
        csvs_converter.convert(ns_config_dict, avi_config, vs_state, sys_dict,
                               vs_name_dict, vrf, segroup)
        if object_merge_check:
            # Updating the reference for application persistence profile as we
            # are assigning reference at the time of profile creation
            ns_util.update_profile_ref('application_persistence_profile_ref',
                avi_config['Pool'], merge_object_mapping['app_persist_profile'])
            # Updating the reference for application profile as we
            # are assigning reference at the time of profile creation
            ns_util.update_profile_ref('application_profile_ref',
              avi_config['VirtualService'], merge_object_mapping['app_profile'])
        # Add status for skipped netscalar commands in CSV/report
        ns_util.update_status_for_skipped(skipped_cmds)
        if redirect:
            # Removing VS and changing the status in CSV which got redirected
            # Scenario for redirect - HTTP VS having no pool but redirect to
            # HTTPS VS
            ns_util.vs_redirect_http_to_https(avi_config, sys_dict)
        # Merging the pools in a pool group if pools are having same health
        # monitor
        ns_util.merge_pool(avi_config)
        # Add/update CSV/report
        ns_util.add_complete_conv_status(ns_config_dict, output_dir, avi_config,
                                         report_name, vs_level_status)
        LOG.debug('Conversion completed successfully')
        ns_util.cleanup_config(tmp_avi_config)
        ns_util.cleanup_dupof(avi_config)
        avi_config.pop('Lbvs', None)
        # Validating the aviconfig after generation
        ns_util.validation(avi_config)
        # added code to get fully converted virtual service.
        for key in avi_config:
            if key != 'META':
                if key == 'VirtualService':
                    if vs_level_status:
                        LOG.info('Total Objects of %s : %s (%s full conversions)'
                                 % (key,len(avi_config[key]),
                                    nsu.fully_migrated))
                        print 'Total Objects of %s : %s (%s full conversions)'\
                              % (key, len(avi_config[key]),
                                 nsu.fully_migrated)
                    else:
                        LOG.info(
                            'Total Objects of %s : %s'
                            % (key, len(avi_config[key])))
                        print 'Total Objects of %s : %s' \
                              % (key, len(avi_config[key]))

                    continue
                # Added code to print merged count.
                elif object_merge_check and key == 'SSLProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(profile_converter.ssl_merge_count),
                         abs(profile_converter.ssl_merge_count) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif object_merge_check and key == 'ApplicationProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(app_merge_count['count']),
                         abs(app_merge_count['count']) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif object_merge_check and key == 'NetworkProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(profile_converter.network_merge_count),
                         abs(profile_converter.network_merge_count) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif object_merge_check and key == \
                        'ApplicationPersistenceProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(app_per_merge_count['count']),
                         abs(app_per_merge_count['count']) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif object_merge_check and key == 'HealthMonitor':
                    monitor_merged_message = \
                        'Total Objects of %s : %s (%s/%s monitor merged)' % \
                        (key, len(avi_config[key]),
                         abs(monitor_converter.monitor_merge_count),
                         abs(monitor_converter.monitor_merge_count) +
                         len(avi_config[key]))
                    LOG.info(monitor_merged_message)
                    print monitor_merged_message
                    continue
                LOG.info('Total Objects of %s : %s' % (key,
                                                       len(avi_config[key])))
                print 'Total Objects of %s : %s' % (key, len(avi_config[key]))

    except:
        LOG.error('Error in config conversion', exc_info=True)

    return avi_config
