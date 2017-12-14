#!/usr/bin/env python
import argparse
import json
import os
import urlparse
from f5.bigip import ManagementRoot


def get_name_and_entity(url):
    """
    Parses reference string to extract object type and
    :param url: reference url to be parsed
    :return: entity and object name
    """
    # parsed = urlparse.urlparse(url)
    # return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]
    parsed = url.split('/')
    return parsed[1], parsed[2]


class F5InventoryConv(object):

    @classmethod
    def get_instance(cls, version, host, username, password):
        """

        :param version:  version of f5 instance
        :param f5_profile_attributes: yaml attribute file for object
        :param object_merge_check: Flag for object merge
        :param prefix: prefix for objects
        :param keypassphrase: path of keypassphrase
        :return: object of respective f5 version object.
        """

        if version == '10':
            return F5InventoryConvV10(host, username, password)
        if version in ['11', '12']:
            return F5InventoryConvV11(host, username, password)

    def get_inventory(self):
        pass

    def get_all_virtual_service(self):
        virtual_services = self.f5_client.tm.ltm.virtuals.get_collection()
        return virtual_services

    def get_all_pools(self):
        pools = self.f5_client.tm.ltm.pools.get_collection()
        return pools

    def write_output(self, output_dir, avi_object):
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        report_path = output_dir + os.path.sep + "Inventory,json"
        with open(report_path, "w") as text_file:
            json.dump(avi_object, text_file, indent=4)


class F5InventoryConvV10(F5InventoryConv):

    def __init__(self, host, username, password):
        self.f5_client = ManagementRoot(host, username, password)
        self.avi_object = {}

    def get_inventory(self):
        virtual_services = self.get_all_virtual_service()
        pools = self.get_all_pools()


        for vs in virtual_services:
            vs_object = {
                'name': vs.name,
                'partition': vs.partition
            }
            pool = vs.pool
            pool_partition, pool_name = get_name_and_entity(pool)
            if pool_name:
                vs_object['pool'] = {
                    'name': pool_name
                }
                if pool_partition:
                    vs_object['pool']['partition'] = pool_partition

            avi_object[vs_object['name']] = vs_object

        print 'Hello: %s' % avi_object


class F5InventoryConvV11(F5InventoryConv):
    def __init__(self, host, username, password):
        self.f5_client = ManagementRoot(host, username, password)
        self.avi_object = {}

    def get_inventory(self):
        virtual_services = self.get_all_virtual_service()
        pools = self.get_all_pools()

        for vs in virtual_services:
            vs_object = {
                'name': vs.name,
                'partition': vs.partition
            }
            if hasattr(vs, 'enabled'):
                vs_object['enabled'] = True
            else:
                vs_object['enabled'] = False
            if hasattr(vs, 'destination'):
                destination_partition, destination_ip = get_name_and_entity(vs.destination)
                vs_object['destination'] = destination_ip

            pool = vs.pool
            pool_partition, pool_name = get_name_and_entity(pool)
            if pool_name:
                vs_object['pool'] = {
                    'name': pool_name
                }
                if pool_partition:
                    vs_object['pool']['partition'] = pool_partition
                pool = [pool for pool in pools if pool.name == pool_name]
                health_monitors = pool[0].monitor.split(',')
                if health_monitors:
                    vs_object['pool']['health_monitors'] = []
                    for monitor in health_monitors:
                        monitor = monitor.strip()
                        monitor_partition, monitor_name = get_name_and_entity(monitor)
                        vs_object['pool']['health_monitors'].append(monitor_name)

            source_address_translation =  vs.sourceAddressTranslation
            if source_address_translation.get('type') != 'none':
                vs_object['source_address_translation'] = source_address_translation


            self.avi_object[vs_object['name']] = vs_object

        print 'Inventory: %s' % self.avi_object


class F5Inventory():
    """

    """

    def __init__(self, args):
        """

        :param args:
        """

        self.f5_config_version = args.f5_config_version
        self.output_file_path = args.output_file_path if args.output_file_path \
            else 'output'
        self.f5_host_ip = args.f5_host_ip
        self.f5_ssh_user = args.f5_ssh_user
        self.f5_ssh_password = args.f5_ssh_password

    def get_inventory(self):
        """

        :return:
        """
        f5_inventory_conv = F5InventoryConv.get_instance(self.f5_config_version, self.f5_host_ip,
            self.f5_ssh_user, self.f5_ssh_password)
        f5_inventory_conv.get_inventory()
        f5_inventory_conv.write_output(self.output_file_path, f5_inventory_conv.avi_object)



if __name__ == '__main__':
    HELP_STR = '''
           F5 instance Inventory
           Example to get the inventory of f5 instance:
               f5_inventory.py -v 10 --f5_host_ip 10.90.117.121 --f5_ssh_user
               admin --f5_ssh_password avi123 -o  Output.json
           '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
    parser.add_argument('--f5_host_ip', help='host ip of f5 instance')
    parser.add_argument('--f5_ssh_user', help='f5 host ssh username')
    parser.add_argument('--f5_ssh_password',
                        help='f5 host ssh password if password based ' +
                             'authentication')
    parser.add_argument('-o', '--output_file_path', default='output',
                        help='folder location for output file')

    args = parser.parse_args()
    if not args.f5_host_ip:
        print 'Please provide f5 host'
        exit(0)
    if not args.f5_ssh_user:
        print 'Please provide ssh username of f5 host'
        exit(0)
    if not args.f5_host_ip:
        print 'Please provide ssh password of f5 host'
        exit(0)
    f5_inventory = F5Inventory(args)
    f5_inventory.get_inventory()
