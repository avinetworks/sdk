import logging
import avi.migrationtools.f5_converter.converter_constants as final
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.avi_migration_utils import update_count
LOG = logging.getLogger(__name__)
# Creating f5 object for util library.
conv_utils = F5Util()


class DataGroupConfigConv(object):
    @classmethod
    def get_instance(cls, version, prefix, object_merge_check,
                     dg_command_status):
        """

        :param version: version of f5 instance
        :param prefix: prefix for objects
        :param object_merge_check: Flag for object merge
        :return:
        """
        if version == '10':
            return DataGroupConfigConvV10(prefix, object_merge_check,
                                          dg_command_status)
        if version in ['11', '12']:
            return DataGroupConfigConvV11(prefix, object_merge_check,
                                          dg_command_status)

    def convert_ip_group(self, name, d_group, skipped, tenant):
        pass

    def update_conv_status_for_skip(self, dg_type, name, msg):
        conv_utils.add_status_row("data-group", dg_type, name,
                                  final.STATUS_NOT_SUPPORTED, msg)

    def update_conversion_status(self, conv_status, dg_type, name,
                                 data_group):
        """

        :param conv_status:  state of conversion
        :param dg_type: type of data group
        :param name: name of data group
        :param data_group: dict of data group
        :return:
        """
        conv_utils.add_conv_status('data-group', dg_type, name, conv_status,
                                   [{'data-group': data_group}])
        LOG.debug("Conversion successful for data group: %s" %
                  name)

    def update_conv_status_for_error(self, name, dg_type, key):
        """

        :param name:  name of data group
        :param dg_type: type of data group.
        :param key: key for data group
        :return:
        """
        if name:
            conv_utils.add_status_row("data-group", dg_type, name,
                                      final.STATUS_ERROR)
        else:
            conv_utils.add_status_row("data-group", dg_type, key,
                                      final.STATUS_ERROR)

    def convert(self, f5_config, avi_config, user_ignore, tenant_ref,
                merge_object_mapping, sys_dict):
        """

        :param f5_config: parsed f5 config
        :param avi_config: dict of avi config
        :param user_ignore: Ignore config defined by user
        :param tenant_ref: tenant of which output to converted
        :param merge_object_mapping: flag for object merge
        :param sys_dict: baseline profile
        :return:
        """
        avi_config['IpAddrGroup'] = []
        converted_objs = []
        f5_datagroup_dict = f5_config.get('data-group')
        user_ignore = user_ignore.get('data-group', {})
        # Added variable to get total object count.
        progressbar_count = 0
        total_size = len(f5_datagroup_dict.keys())
        print "Converting Data groups..."
        for key in f5_datagroup_dict.keys():
            progressbar_count += 1
            data_group_type = None
            name = None
            skipped = []
            # Added call to check the progress.
            msg = "data-group conversion started..."
            conv_utils.print_progress_bar(progressbar_count, total_size, msg,
                             prefix='Progress', suffix='')
            dg_type = None
            try:
                tenant, name = conv_utils.get_tenant_ref(key)
                # dg_scope, name = key.split(" ")
                # name = name.split('/')[-1]
                LOG.debug("Converting datagroup: %s" % name)
                dg_config = f5_datagroup_dict[key]
                if tenant_ref != 'admin':
                    tenant = tenant_ref
                if self.prefix:
                    name = '{}-{}'.format(self.prefix, name)

                dg_type = dg_config['type']
                if dg_type == 'ip':
                    ip_group = self.convert_ip_group(name, dg_config, skipped,
                                                     tenant)
                else:
                    msg = 'data-group type not supported skipping ' \
                          'conversion: %s' % name
                    LOG.warning(msg)
                    self.update_conv_status_for_skip(dg_type, name, msg)
                    continue
                if not ip_group:
                    continue
                # code to merge Data groups.
                if self.object_merge_check:
                    conv_utils.update_skip_duplicates(
                        ip_group, avi_config['IpAddrGroup'], 'ip_group',
                        converted_objs, name, None, merge_object_mapping,
                        dg_type, self.prefix, sys_dict['IpAddrGroup'])
                    self.dg_count += 1
                else:
                    avi_config["IpAddrGroup"].append(ip_group)

                conv_status = conv_utils.get_conv_status(
                    skipped, dict(), dict(), ip_group, user_ignore)
                self.update_conversion_status(conv_status, dg_type, name,
                                              ip_group)
            except:
                update_count('error')
                LOG.error("Failed to convert data-group : %s" % key,
                          exc_info=True)
                self.update_conv_status_for_error(name, dg_type, key)
        count = len(avi_config["IpAddrGroup"])
        LOG.debug("Converted %s ip group" % count)
        f5_config.pop('data-group')



class DataGroupConfigConvV11(DataGroupConfigConv):
    def __init__(self, prefix, object_merge_check, dg_command_status):
        """

        :param prefix: prefix for object
        :param object_merge_check: flag to merge object
        """
        self.supported_attr = dg_command_status['Datagroup_supported_attr']
        # Added prefix for objects
        self.prefix = prefix
        self.object_merge_check = object_merge_check
        self.dg_count = 0


    def convert_ip_group(self, name, d_group, skipped, tenant):

        skipped += [attr for attr in d_group.keys()
                    if attr not in self.supported_attr]
        prefixes = []
        for record in d_group.get('records', []):
            prefix = {
                'mask': record.split('/')[1],
                'ip_addr': {
                    'type': "V4",
                    'addr': record.split('/')[0]
                }
            }
            prefixes.append(prefix)

        ip_group = {
            'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant'),
            'name': name,
            'prefixes': prefixes
        }
        return ip_group


class DataGroupConfigConvV10(DataGroupConfigConv):
    def __init__(self, prefix, object_merge_check, dg_command_status):
        """

        :param prefix: prefix for object
        :param object_merge_check: flag to merge object
        """
        self.supported_attr = dg_command_status['Datagroup_supported_attr']
        # Added prefix for objects
        self.prefix = prefix
        self.object_merge_check = object_merge_check
        self.dg_count = 0

    def convert_ip_group(self, name, d_group, skipped, tenant):

        skipped += [attr for attr in d_group.keys()
                    if attr not in self.supported_attr]
        prefixes = []
        for record in d_group.get('records', []):
            for ip in record:
                prefix = {
                    'mask': ip.split('/')[1],
                    'ip_addr': {
                        'type': "V4",
                        'addr': ip.split('/')[0]
                    }
                }
                prefixes.append(prefix)

        ip_group = {
            'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant'),
            'name': name,
            'prefixes': prefixes
        }
        return ip_group