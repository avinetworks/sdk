import logging
import avi.migrationtools.f5_converter.converter_constants as conv_const
import os
import json

from avi.migrationtools.f5_converter.monitor_converter \
    import MonitorConfigConv
from avi.migrationtools.f5_converter.persistence_converter \
    import PersistenceConfigConv
from avi.migrationtools.f5_converter.pool_converter import PoolConfigConv
from avi.migrationtools.f5_converter.profile_converter import \
    ProfileConfigConv, ssl_count
from avi.migrationtools.f5_converter.vs_converter import VSConfigConv
from avi.migrationtools.f5_converter import conversion_util
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.f5_converter.policy_converter import PolicyConfigConv
from avi.migrationtools.avi_migration_utils import update_count
from avi.migrationtools.f5_converter.datagroup_converter import DataGroupConfigConv
from avi.migrationtools.f5_converter.clone_cross_tenant_obj import CloneObjects

LOG = logging.getLogger(__name__)
csv_writer = None
# Define Dict of merge_object_mapping to update the merged monitor, profile
# name of ssl_profile, application_profile, network_profile etc
merge_object_mapping = {
    'ssl_profile': {'no': 0},
    'app_profile': {'no': 0},
    'network_profile': {'no': 0},
    'app_per_profile': {'no': 0},
    'pki_profile': {'no': 0},
    'health_monitor': {'no': 0},
    'ssl_cert_key': {'no': 0},
    'ip_group': {'no': 0}
}

# Creating f5 object for util library.
conv_utils = F5Util()


def convert(f5_config, output_dir, vs_state, input_dir, version,
            object_merge_check, controller_version, report_name, prefix,
            con_snatpool, user_ignore, profile_path, tenant='admin',
            cloud_name='Default-Cloud', keypassphrase=None,
            vs_level_status=False, vrf=None, segroup=None,
            custom_mappings=None):

    """
    Converts f5 config to avi config pops the config lists for conversion of
    each type from f5 config and remaining marked as skipped in the
    conversion status file
    :param f5_config: dict representation of f5 config from the file
    :param output_dir: Folder path to put output files
    :param vs_state: State of created Avi VS object
    :param input_dir: Location of cert and external monitor script files
    :param version: Version of F5 config
    :param object_merge_check: Flag for object merge
    :param controller_version: Version of controller
    :param report_name: output file name
    :param prefix : prefix for objects
    :param con_snatpool : flag for snat conversion
    :param user_ignore: Ignore config defined by user
    :param profile_path: path of default profile path
    :param tenant: Tenant for which config need to be converted
    :param cloud_name: cloud for which config need to be converted
    :param keypassphrase: path of keypassphrase file.
    :param vs_level_status: flag to add cloumn of vs reference.
    :param vrf: vrf name to write vrf_ref value
    :param segroup: segroup ref value for VS
    :param custom_mappings: custom mappings to overwrite monitor or map irules
    :return: Converted avi objects
    """

    avi_config_dict = {}
    sys_dict = {}
    partition_vs_mapping = {}

    try:
        # load the yaml file attribute in f5_attributes.
        f5_attributes = conv_const.init(version)
        merge_object_type = ['ApplicationProfile', 'NetworkProfile',
                             'SSLProfile', 'PKIProfile', 'SSLKeyAndCertificate',
                             'ApplicationPersistenceProfile', 'HealthMonitor',
                             'IpAddrGroup']
        for key in merge_object_type:
            sys_dict[key] = []
            avi_config_dict[key] = []

        if profile_path and os.path.exists(profile_path):
            with open(profile_path) as data:
                prof_data = json.load(data)
                for key in merge_object_type:
                    sys_dict[key] = prof_data.get(key, [])

        profile_conv = ProfileConfigConv.get_instance(
            version, f5_attributes, object_merge_check, prefix, keypassphrase)
        profile_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore,
                             tenant, cloud_name, merge_object_mapping, sys_dict)

        # Added ssl profile merge flag.
        mon_conv = MonitorConfigConv.get_instance(
            version, f5_attributes, prefix, object_merge_check)
        mon_conv.convert(f5_config, avi_config_dict, input_dir, user_ignore,
                         tenant, cloud_name, controller_version,
                         merge_object_mapping, sys_dict, custom_mappings)

        pool_conv = PoolConfigConv.get_instance(version, f5_attributes, prefix)
        pool_conv.convert(f5_config, avi_config_dict, user_ignore, tenant,
                          cloud_name, merge_object_mapping, sys_dict, vrf,
                          segroup)

        persist_conv = PersistenceConfigConv.get_instance(
            version, f5_attributes, prefix, object_merge_check)
        persist_conv.convert(f5_config, avi_config_dict, user_ignore, tenant,
                             merge_object_mapping, sys_dict)

        policy_conv = PolicyConfigConv.get_instance(version, prefix)
        policy_conv.convert(f5_config, avi_config_dict, tenant)

        vs_conv = VSConfigConv.get_instance(version, f5_attributes, prefix,
                                            con_snatpool, custom_mappings)
        vs_conv.convert(f5_config, avi_config_dict,
                                          vs_state, user_ignore,
                        tenant, cloud_name, controller_version,
                        merge_object_mapping, sys_dict, vrf, segroup,
                                            partition_vs_mapping)
        dg_conv = DataGroupConfigConv.get_instance(
            version, prefix, merge_object_mapping, f5_attributes)
        dg_conv.convert(f5_config, avi_config_dict, user_ignore,
                        tenant, merge_object_mapping, sys_dict)


        # Updating application profile from L4 to http if service has ssl enable
        conv_utils.update_app_profile(avi_config_dict, sys_dict)
        # Updated network profile to TCP PROXY if application profile is HTTP
        conv_utils.update_network_profile(avi_config_dict, sys_dict)

        # Disabled the net to static route conversion
        # conv_utils.net_to_static_route(f5_config, avi_config_dict)

        # Updating the ssl profile ref for monitors with merged name
        conv_utils.update_monitor_ssl_ref(avi_config_dict, merge_object_mapping,
                                          sys_dict)
        conv_utils.add_tenants(avi_config_dict)
        conv_utils.cleanup_config(avi_config_dict)
        # Validating the aviconfig after generation
        conv_utils.validation(avi_config_dict)
        # Clone cross tenant references
        test_clone_obj = CloneObjects(avi_config_dict)
        test_clone_obj.find_clone_all()

    except:
        update_count('warning')
        LOG.error("Conversion error", exc_info=True)
    datascript_objs = ['data-group']
    # Added support node as not applicable
    na_list_objs = f5_attributes['na_list_objs']
    # Marked route as skipped
    accept_list = ['snatpool', 'route']
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
                                          conv_const.STATUS_NOT_APPLICABLE,
                                          f5_type + " object not applicable")
            elif f5_type in accept_list:
                msg = (" skipped because of object "
                       "associated with this is skipped")
                conv_utils.add_status_row(f5_type, sub_type, key,
                                          conv_const.STATUS_SKIPPED,
                                          f5_type + msg)
            else:
                conv_utils.add_status_row(f5_type, sub_type, key,
                                          conv_const.STATUS_NOT_SUPPORTED)

    # Add f5 converter status report in xslx report
    conv_utils.add_complete_conv_status(
        output_dir, avi_config_dict, report_name, vs_level_status)
    for key in avi_config_dict:
        if key != 'META':
            if key == 'VirtualService':
                if vs_level_status:
                    LOG.info('Total Objects of %s : %s (%s full conversions)'
                             % (key, len(avi_config_dict[key]),
                                conversion_util.fully_migrated))
                    print 'Total Objects of %s : %s (%s full conversions)' \
                          % (key, len(avi_config_dict[key]),
                             conversion_util.fully_migrated)
                else:
                    LOG.info('Total Objects of %s : %s'
                             % (key, len(avi_config_dict[key])))
                    print 'Total Objects of %s : %s' \
                          % (key, len(avi_config_dict[key]))

                continue
            # Added code to print merged count.
            elif object_merge_check and key == 'SSLProfile':
                mergedfile = len(avi_config_dict[key]) - ssl_count['count']
                profile_merged_message = \
                    'Total Objects of %s : %s (%s/%s profile merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     ssl_count['count'])
                LOG.info(profile_merged_message)
                print profile_merged_message
                continue
            elif object_merge_check and key == 'ApplicationProfile':
                mergedfile = len(avi_config_dict[key]) - \
                             profile_conv.app_count
                profile_merged_message = \
                    'Total Objects of %s : %s (%s/%s profile merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     profile_conv.app_count)
                LOG.info(profile_merged_message)
                print profile_merged_message
                continue
            elif object_merge_check and key == 'NetworkProfile':
                mergedfile = len(avi_config_dict[key]) - \
                             profile_conv.net_count
                profile_merged_message = \
                    'Total Objects of %s : %s (%s/%s profile merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     profile_conv.net_count)
                LOG.info(profile_merged_message)
                print profile_merged_message
                continue
            elif object_merge_check and key == 'HealthMonitor':
                mergedmon = len(avi_config_dict[key]) - mon_conv.mon_count
                monitor_merged_message = \
                    'Total Objects of %s : %s (%s/%s monitor merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedmon),
                     mon_conv.mon_count)
                LOG.info(monitor_merged_message)
                print monitor_merged_message
                continue
            elif object_merge_check and key == 'PKIProfile':
                mergedfile = len(avi_config_dict[key]) - \
                             profile_conv.pki_count
                profile_merged_message = \
                    'Total Objects of %s : %s (%s/%s profile merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     profile_conv.pki_count)
                LOG.info(profile_merged_message)
                print profile_merged_message
                continue
            elif object_merge_check and key == 'ApplicationPersistenceProfile':
                mergedfile = len(avi_config_dict[key]) - \
                             persist_conv.app_per_count
                profile_merged_message = \
                    'Total Objects of %s : %s (%s/%s profile merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     persist_conv.app_per_count)
                LOG.info(profile_merged_message)
                print profile_merged_message
                continue
            elif object_merge_check and key == 'SSLKeyAndCertificate':
                mergedfile = len(avi_config_dict[key]) - \
                             profile_conv.certkey_count
                certkey_merged_message = \
                    'Total Objects of %s : %s (%s/%s cert key merged)' % \
                    (key, len(avi_config_dict[key]), abs(mergedfile),
                     profile_conv.certkey_count)
                LOG.info(certkey_merged_message)
                print certkey_merged_message
                continue
            LOG.info('Total Objects of %s : %s' % (key, len(
                avi_config_dict[key])))
            print 'Total Objects of %s : %s' % (key, len(
                avi_config_dict[key]))
    return avi_config_dict, partition_vs_mapping
