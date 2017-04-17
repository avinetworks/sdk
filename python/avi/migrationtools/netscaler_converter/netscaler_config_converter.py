import logging
import yaml
import os

from avi.migrationtools.netscaler_converter.ns_service_converter \
    import ServiceConverter
from avi.migrationtools.netscaler_converter.monitor_converter import \
    MonitorConverter
from avi.migrationtools.netscaler_converter.lbvs_converter import \
    LbvsConverter
from avi.migrationtools.netscaler_converter.csvs_converter import \
    CsvsConverter
from avi.migrationtools.netscaler_converter import ns_util
from avi.migrationtools.netscaler_converter.profile_converter import \
    ProfileConverter
from avi.migrationtools.netscaler_converter.lbvs_converter import \
    tmp_avi_config

LOG = logging.getLogger(__name__)


def convert(ns_config_dict, tenant_name, cloud_name, version, output_dir,
            input_dir, skipped_cmds, vs_state, profile_merge_check,
            key_passphrase=None):
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
        avi_config = {
            "META": {
                "supported_migrations": {
                    "versions": [
                        "14_2",
                        "15_1",
                        "15_1_1",
                        "15_2",
                        "15_2_3",
                        "15_3",
                        "16_1",
                        "16_1_1",
                        "16_1_2",
                        "16_1_3",
                        "16_2",
                        "16_2_1",
                        "16_2_2",
                        "16_2_3",
                        "16_3",
                        "16_3_1",
                        "16_3_2",
                        "16_3_4",
                        "16_4_1",
                        "16_4_2",
                        "current_version"
                    ]
                },
                "version": {
                    "Product": "controller",
                    "Version": version,
                    "min_version": 15.2,
                    "ProductName": "Avi Cloud Controller"
                },
                "use_tenant": tenant_name,
                "upgrade_mode": False

            }
        }

        monitor_converter = MonitorConverter(tenant_name, cloud_name,
                                             tenant_ref, cloud_ref)
        monitor_converter.convert(ns_config_dict, avi_config, input_dir)

        profile_converter = \
            ProfileConverter(tenant_name, cloud_name,tenant_ref, cloud_ref,
                             ssl_ciphers, profile_merge_check, key_passphrase)
        profile_converter.convert(ns_config_dict, avi_config, input_dir)

        service_converter = ServiceConverter(tenant_name, cloud_name,tenant_ref,
                                             cloud_ref, profile_merge_check)
        service_converter.convert(ns_config_dict, avi_config)

        lbvs_converter = LbvsConverter(tenant_name, cloud_name, tenant_ref,
                                       cloud_ref, profile_merge_check)
        lbvs_converter.convert(ns_config_dict, avi_config, vs_state)

        csvs_converter = CsvsConverter(tenant_name, cloud_name, tenant_ref,
                                       cloud_ref, profile_merge_check)
        csvs_converter.convert(ns_config_dict, avi_config, vs_state)

        # Add status for skipped netscalar commands in CSV/report
        ns_util.update_status_for_skipped(skipped_cmds)
        # Add/update CSV/report
        ns_util.add_complete_conv_status(ns_config_dict, output_dir, avi_config)

        LOG.debug('Conversion completed successfully')
        ns_util.cleanup_config(tmp_avi_config)
        # added code to get fully converted virtual service.
        for key in avi_config:
            if key != 'META':
                if key == 'VirtualService':
                    LOG.info('Total Objects of %s : %s (%s full conversions)'
                             % (key,len(avi_config[key]), ns_util.count))
                    print 'Total Objects of %s : %s (%s full conversions)'\
                          % (key, len(avi_config[key]), ns_util.count)
                    continue
                    # Added code to print merged count.
                elif profile_merge_check and key == 'SSLProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(profile_converter.ssl_merge_count),
                         abs(profile_converter.ssl_merge_count) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif profile_merge_check and key == 'ApplicationProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(profile_converter.application_merge_count),
                         abs(profile_converter.application_merge_count) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                elif profile_merge_check and key == 'NetworkProfile':
                    profile_merged_message = \
                        'Total Objects of %s : %s (%s/%s profile merged)' % \
                        (key, len(avi_config[key]),
                         abs(profile_converter.network_merge_count),
                         abs(profile_converter.network_merge_count) +
                         len(avi_config[key]))
                    LOG.info(profile_merged_message)
                    print profile_merged_message
                    continue
                LOG.info('Total Objects of %s : %s' % (key,
                                                       len(avi_config[key])))
                print 'Total Objects of %s : %s' % (key, len(avi_config[key]))

    except:
        LOG.error('Error in config conversion', exc_info=True)

    return avi_config
