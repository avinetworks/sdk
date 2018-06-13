#!/usr/bin/env python

import os
import sys
import argparse
import json
import yaml
import xlsxwriter
import time
from datetime import datetime
from collections import defaultdict

try:
    from bigsuds import BIGIP               # version 10
    from f5.bigip import ManagementRoot     # version 11
except ImportError:
    print "Please Install bigsuds and f5 sdk python packages using `pip install bigsuds f5-sdk` "
    sys.exit(1)

profile_mappings = {
    'l4': ['fastl4', 'tcp'],
    'l7': ['http', 'https', 'fasthttp', 'clientssl', 'oneconnect'],
    'dns': ['dns'],
    'udp': ['udp']
}

out_dict = {}


def get_name_and_entity(url):
    """
    Parses reference string to extract object type and
    :param url: reference url to be parsed
    :return: entity and object name
    """
    parsed = url.split('/')
    return parsed[1], parsed[2]


class F5InventoryConv(object):

    @classmethod
    def get_instance(cls, version, host, port, username, password, interval):
        """

        :param version:  version of f5 instance
        :param host: ip/url for f5 box
        :param port: port for f5 box
        :param username: username for f5 box
        :param password: password for f5 box
        :return: object of respective f5 version object.
        """
        if version == '10':
            return F5InventoryConvV10(host, port, username, password, interval)
        if version in ['11', '12']:
            return F5InventoryConvV11(host, port, username, password, interval)

    def get_inventory(self):
        pass

    def get_all_virtual_service(self):
        pass

    def print_human(self, path, version, ip, interval=1):

        # refactor the data for easy access
        traffic_global_dict = {}
        for data in self.avi_object:
            for k, v in data.iteritems():
                if data[k].get('traffic'):
                    entries = data[k]['traffic']
                    unpacked_entries = { str(k): v[u'value'] for k, v in entries.items() if v.get(u'value', '') is not '' }
                    if k in traffic_global_dict:
                        traffic_global_dict[k].append(unpacked_entries)
                    else:
                        traffic_global_dict[k] = [unpacked_entries]

                if data[k].get('traffic_list'):
                    # for types in data[k]['traffic_list']:
                    unpacked_entries = { types['type']: types['value']['high'] for types in data[k]['traffic_list']}
                    if k in traffic_global_dict:
                        traffic_global_dict[k].append(unpacked_entries)
                    else:
                        traffic_global_dict[k] = [unpacked_entries]
    
        new_traffic_global_dict = {}

        for k in traffic_global_dict.keys():
            intermediate = defaultdict(list)

            if version == '11':
                mean_key = ['clientside.curConns']
                keys =  ['totRequests', 'clientside.totConns',
                            'clientside.bitsIn', 'clientside.pktsOut']
            else:
                mean_key = ['STATISTIC_EPHEMERAL_CURRENT_CONNECTIONS']
                keys = ['STATISTIC_CLIENT_SIDE_PACKETS_OUT',
                        'STATISTIC_CLIENT_SIDE_TOTAL_CONNECTIONS',
                        'STATISTIC_CLIENT_SIDE_BYTES_OUT',
                        'STATISTIC_CLIENT_SIDE_PACKETS_OUT']

            for subdict in traffic_global_dict[k]:
                for key, val in subdict.items():
                    intermediate[key].append(val)

            for key in keys:
                value = intermediate[key]
                per_sec =  abs((value[0] - value[1]) / (2 * 60))
                if k in new_traffic_global_dict:
                    new_traffic_global_dict[k].update({ key: per_sec})
                else:
                    new_traffic_global_dict[k] = { key: per_sec}

            for key in mean_key:
                value = intermediate[key]
                mean_val =abs((value[0] + value[1]) /2)
                if k in new_traffic_global_dict:
                    new_traffic_global_dict[k].update({ key: mean_val})
                else:
                    new_traffic_global_dict[k] = { key: mean_val}


        # Print the Summary
        workbook = xlsxwriter.Workbook(path + os.sep + '{}_discovery_data.xlsx'.format(ip))

        bold = workbook.add_format({'bold': True})
        disabled = workbook.add_format({'font_color': 'red'})
        enabled = workbook.add_format({'font_color': 'green'})

        large_heading = workbook.add_format({'bold': True, 'font_size': '20'})
        large_heading.set_align('center')

        worksheet_summary = workbook.add_worksheet('Summary')
        worksheet_summary.merge_range(3, 4, 3, 7, 'Summary', large_heading)
        worksheet_summary.set_row(3, 40)
        worksheet_summary.set_column(5,6, width=24)

        worksheet_summary.write(5, 5, "F5 Version", bold)
        worksheet_summary.write(5, 6, str(version))

        worksheet_summary.write(6, 5, "Ip Address", bold)
        worksheet_summary.write(6, 6, str(ip))

        worksheet_summary.write(7, 5, "Created on", bold)
        worksheet_summary.write(7, 6, str(datetime.now()).split('.')[0])

        total_vs = total_pools = total_enabled_vs = total_enabled_pools = 0

        input = self.avi_object[0]
        total_input = self.avi_object

        pool_list = []
        vs_list = []
        traffic_list = []
        tenant_list = set()

        for vs in input.keys():
            total_vs = total_vs + 1

            temp_dict = {}
            details_dict = {}
            vsval = input[vs]

            # directory model
            profile = {
                'l4': 'N',
                'l7': 'N',
                'dns': 'N',
                'udp': 'N',
            }

            attr = {
                'ssl': 'N',
                'waf': 'N',
                'irules': 'N',
            }

            # filter with profile
            for k in profile_mappings.keys():
                if list(set(profile_mappings[k]).intersection(set(vsval.get('profiles')))) != []:
                    profile[k] = 'Y'

            if profile['l4'] == 'Y' and profile['l7']:
                profile['l4'] = 'N'

            # filter with attributes
            if 'clientssl' in vsval.get('profiles'):
                attr['ssl'] = 'Y'
            if 'policies' in vsval.keys():
                attr['waf'] = 'Y'
            if 'rules' in vsval.keys():
                attr['irules'] = 'Y'

            details_dict.update(profile)
            details_dict.update(attr)
            temp_dict.update({'details': details_dict})
            temp_dict['name'] = vsval['name']
            temp_dict['max_conn'] = vsval['max_conn']

            if vsval.get('enabled'):
                vs_state = True
            else:
                vs_state = False
            temp_dict['enabled'] = vs_state

            # pool conversion
            if vsval.get('pool'):
                total_pools = total_pools + 1
                if vsval['pool']['members'][0].get('name'):
                    pool_details = vsval['pool']['members'][0]
                    pool_list.append({'name': pool_details.get('name'), 'status': pool_details.get(
                        'state'), 'vs_enabled': vs_state, })
                    if pool_details.get('state') == 'up':
                        total_enabled_pools = total_enabled_pools + 1 
                else:
                    # using vs state for now
                    pool_list.append({'name': vsval['pool'].get(
                        'name'), 'status': vs_state, 'vs_enabled': vs_state, })

            vs_list.append(temp_dict)

            # tenants
            if vsval.get('partition'):
                tenant_list.add(vsval['partition'])

        worksheet = workbook.add_worksheet('VS')
        worksheet_pool = workbook.add_worksheet('Pools')
        worksheet_tenant = workbook.add_worksheet('Tenants')

        row, col = 0, 1

        # write vs details
        worksheet.write('A1', 'Name', bold)
        worksheet.write('B1', 'Enabled', bold)
        init = 0

        # sort the list
        vs_list = sorted(vs_list, key=lambda k: k['max_conn'], reverse=True)

        for vs in vs_list:
            if vs.get('name'):
                vs_name = vs.get('name')
            else:
                continue
            # write headers
            if init == 0:
                for keys in vs['details'].keys():
                    col = col + 1
                    worksheet.write(row, col, keys.strip(), bold)
                worksheet.write(row, col+1, "Max Connections", bold)    
                worksheet.write(row, col+2, "Number of Open connections", bold)    
                worksheet.write(row, col+3, "Requests / sec", bold)    
                worksheet.write(row, col+4, "Connections / sec", bold)    
                worksheet.write(row, col+5, "bytes / sec", bold)    
                worksheet.write(row, col+6, "pkts / sec", bold)  
                row = row + 2
            init = init + 1
            col = 2

            worksheet.write(row, 0, vs_name, bold)
            status = disabled
            v = ''
            if vs.get('enabled') == True:
                status = enabled
                v = 'Y'
                total_enabled_vs = total_enabled_vs + 1
            worksheet.write(row, 1, v, status)

            # write profile
            for k, v in vs['details'].items():
                state = enabled
                if v == 'N':
                    state = disabled
                    v = ''
                worksheet.write(row, col, v, state)
                col = col + 1
            if type(vs['max_conn']) is not int:
                worksheet.write(row, col, vs['max_conn'].get('value'), bold)
            else:
                worksheet.write(row, col, vs['max_conn'], bold)
            
            # write necessary details 
            if version == '11':
                open_conn = new_traffic_global_dict[vs_name]['clientside.curConns']
                req_psec = new_traffic_global_dict[vs_name]['totRequests']
                conn_psec = new_traffic_global_dict[vs_name]['clientside.totConns']
                bytes_psec = new_traffic_global_dict[vs_name]['clientside.bitsIn']
                pkts_psec = new_traffic_global_dict[vs_name]['clientside.pktsOut']
            else:
                open_conn = new_traffic_global_dict[vs_name]['STATISTIC_EPHEMERAL_CURRENT_CONNECTIONS']
                req_psec = new_traffic_global_dict[vs_name]['STATISTIC_CLIENT_SIDE_PACKETS_OUT']
                conn_psec = new_traffic_global_dict[vs_name]['STATISTIC_CLIENT_SIDE_TOTAL_CONNECTIONS']
                bytes_psec = new_traffic_global_dict[vs_name]['STATISTIC_CLIENT_SIDE_BYTES_OUT']
                pkts_psec = new_traffic_global_dict[vs_name]['STATISTIC_CLIENT_SIDE_PACKETS_OUT']
              
            worksheet.write(row, col+1, open_conn, bold)    
            worksheet.write(row, col+2, req_psec, bold)    
            worksheet.write(row, col+3, conn_psec, bold)    
            worksheet.write(row, col+4, bytes_psec, bold)    
            worksheet.write(row, col+5, pkts_psec, bold)

            row = row + 1
        
            # write total
            if init == len(vs_list):
                # doing offset
                end_row = row
                row = 1
                col = 0
                for r in range(len(vs['details'].keys()) + 1):
                    col = col + 1
                    from_row = chr(ord('A') + col) + "3"
                    to_row = chr(ord('A') + col) + str(end_row)
                    worksheet.write_formula(row, col, '=COUNTIF({}:{},"Y")'.format(from_row, to_row),bold)

        # write pools
        row = 0
        worksheet_pool.write('A1', 'Name', bold)
        worksheet_pool.write('B1', 'Enabled', bold)
        for pool in pool_list:
            row = row + 1
            pool_status = pool['status']
            if pool['status'] == 'up' and pool['vs_enabled']:
                state = enabled
            else:
                state = disabled
                pool_status = 'down'

            worksheet_pool.write(row, 0, pool['name'])
            worksheet_pool.write(row, 1, pool_status, state)

        # write tenant on different sheet
        row, col = 0, 0
        worksheet_tenant.write('A1', 'Tenant Name', bold)
        for tenant in tenant_list:
            row = row + 1
            worksheet_tenant.write(row, col, tenant, enabled)

        sheet = 0
        for all_vs in total_input:
            sheet = sheet + 1
            traffic_list = []
            worksheet_traffic = workbook.add_worksheet('Traffic-Sheet -{}'.format(sheet))
            for vs in all_vs.keys():
                vsval = all_vs[vs]
                # Traffic Details
                if vsval.get('traffic'):
                    traffic_list.append(
                        {'name': vs, 'details': vsval['traffic']})
    
                # write traffic details on different page
                row, col = 0, 0
                worksheet_traffic.write('A1', 'Vs Name', bold)
                init = 0
                if self.version == '11':
                    for vs in traffic_list:
                        # for Title Creation
                        if init == 0:
                            for keys, vals in vs['details'].items():
                                if 'value' in vals:
                                    col = col + 1
                                    worksheet_traffic.write(
                                        row, col, keys.strip(), bold)
                            row = row + 1
                            init = 1

                        # write details
                        col = 1
                        worksheet_traffic.write(row, 0, vs['name'])
                        for k, v in vs['details'].items():
                            if 'value' in v:
                                state = enabled
                                val = int(v[u'value'])
                                if val == 0:
                                    state = disabled
                                # trying to normalize
                                if '.bits' in k:
                                    val = str(val/(8*1024)) + "MB"
                                worksheet_traffic.write(
                                    row, col, val, state)
                                col = col + 1
                        row = row + 1

        # adding some more summary
        worksheet_summary.write(9, 5, "Total vs", bold)
        worksheet_summary.write(9, 6, str(total_vs))

        worksheet_summary.write(10, 5, "Total enabled vs", bold)
        worksheet_summary.write(10, 6, str(total_enabled_vs))
        
        worksheet_summary.write(11, 5, "Total pools", bold)
        worksheet_summary.write(11, 6, str(total_pools))
        
        print "===================="
        print " Summary"
        print "===================="
        print "Total vs: ", total_vs
        print "Total enabled vs: ", total_enabled_vs
        print "Total pools: ", total_pools

        if total_enabled_pools:
            worksheet_summary.write(12, 5, "Total enabled pools", bold)
            worksheet_summary.write(12, 6, str(total_enabled_pools))
            print "Total enabled pools: ", total_enabled_pools
        print "--------------------"

    def write_output(self, output_dir, avi_object):
        """
        :param output_dir: output path for file
        :param avi_object: dict to be dumped in file
        :return:
        """

        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        report_path = output_dir + os.path.sep + "Inventory.yaml"
        with open(report_path, "w") as text_file:
            yaml.safe_dump([avi_object], text_file,
                           default_flow_style=False,  allow_unicode=True)


class F5InventoryConvV10(F5InventoryConv):

    def __init__(self, host, port, username, password, interval):
        self.f5_client = BIGIP(host, port, username, password)
        self.avi_object = []
        self.version = '10'
        self.avi_traffic_object = []
        self.interval = interval
        self.port = port

    def get_all_virtual_service(self):
        """
        :return:list of virtual server objects
        """
        virtual_services = self.f5_client.LocalLB.VirtualServer.get_list()
        return virtual_services

    def get_inventory(self):

        i = 0

        while i < 2:
            self.avi_object_temp = {}
            i += 1
            if i == 1:
                print "Running Sample for 1st time"
            else:
                time.sleep(60 * int(self.interval))
                print "Running Sample for 2nd time"

            virtual_services = self.get_all_virtual_service()
            for vs in virtual_services:
                self.avi_object_temp = {}
                vs_object = {
                    'name': vs
                }
                state = self.f5_client.LocalLB.VirtualServer.get_enabled_state([
                                                                            vs])
                state = state[0].split('STATE_')[1]
                if state == 'ENABLED':
                    vs_object['enabled'] = True
                else:
                    vs_object['enabled'] = False
                destination = self.f5_client.LocalLB.VirtualServer.get_destination([
                    vs])
                if destination:
                    vs_object['destination'] = destination
                persist = self.f5_client.LocalLB.VirtualServer\
                    .get_persistence_profile([vs])[0]
                if persist:
                    persist = [persist_profile['profile_name'] for
                            persist_profile in persist]
                    vs_object['persist'] = persist
                source_address_translation = self.f5_client.LocalLB.VirtualServer\
                    .get_snat_type([vs])
                source_address_translation = source_address_translation[0].split(
                    'SNAT_TYPE_')[1]
                if source_address_translation != 'NONE':
                    vs_object['source_address_translation'] = \
                        source_address_translation
                pool = self.f5_client.LocalLB.VirtualServer.get_default_pool_name([
                    vs])[0]
                exit
                if pool:
                    vs_object['pool'] = {
                        'name': pool
                    }
                    members = self.f5_client.LocalLB.Pool.get_member([pool])[0]
                    if members:
                        vs_object['pool']['members'] = members
                    health_monitors = \
                        self.f5_client.LocalLB.Pool.get_monitor_instance([pool])[0]
                    if health_monitors:
                        monitors = set([monitor['instance']['template_name'] for
                                        monitor in health_monitors])
                        vs_object['pool']['health_monitors'] = list(monitors)
                profiles = self.f5_client.LocalLB.VirtualServer.get_profile([vs])[
                    0]
                if profiles:
                    profiles = [profile['profile_name'] for profile in profiles]
                    vs_object['profiles'] = profiles

                traffic = self.f5_client.LocalLB.VirtualServer.get_statistics([vs])

                max_conn = 0

                for t in traffic['statistics'][0]['statistics']:
                    if t.get('type') == 'STATISTIC_CLIENT_SIDE_MAXIMUM_CONNECTIONS':
                        max_conn =  int(t['value']['high'])
                
                vs_object['max_conn'] = max_conn

                if traffic and len(traffic['statistics']):
                    vs_object['traffic_list'] = traffic['statistics'][0]['statistics']
                self.avi_object_temp[vs_object['name']] = vs_object
            self.avi_object.append(self.avi_object_temp)


class F5InventoryConvV11(F5InventoryConv):

    def __init__(self, host, port, username, password, interval):
        self.f5_client = ManagementRoot(host, username, password, port=port)
        self.avi_object = []
        self.version = '11'
        self.avi_traffic_object = []
        self.interval = interval

    def get_all_virtual_service(self):
        """
        :return:list of virtual server objects
        """
        virtual_services = self.f5_client.tm.ltm.virtuals.get_collection()
        return virtual_services

    def get_inventory(self):

        i = 0

        while i < 2:
            self.avi_object_temp = {}
            i += 1
            if i == 1:
                print "Running Sample for 1st time"
            else:
                time.sleep(60 * int(self.interval))
                print "Running Sample for 2nd time"

            virtual_services = self.get_all_virtual_service()
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
                    destination_partition, destination_ip = get_name_and_entity(
                        vs.destination)
                    vs_object['destination'] = destination_ip
                if hasattr(vs, 'persist'):
                    vs_object['persist'] = vs.attrs['persist'][0]
                source_address_translation = vs.sourceAddressTranslation
                if source_address_translation.get('type') != 'none':
                    vs_object['source_address_translation'] = \
                        source_address_translation
                if hasattr(vs, 'pool'):
                    pool = vs.pool
                    pool_partition, pool_name = get_name_and_entity(pool)
                    if pool_name:
                        vs_object['pool'] = {
                            'name': pool_name
                        }
                        if pool_partition:
                            vs_object['pool']['partition'] = pool_partition
                        poolobj = self.f5_client.tm.ltm.pools.pool.load(
                            partition=pool_partition, name=pool_name)
                        health_monitors = [get_name_and_entity(monitors.strip())[1]
                                        for monitors in poolobj.monitor.split(
                                        ' and ') if monitors]
                        if health_monitors:
                            vs_object['pool']['health_monitors'] = health_monitors
                        members = [{'name': pool_member.name,
                                    'address': pool_member.address,
                                    'state': pool_member.state} for
                                pool_member in
                                poolobj.members_s.get_collection()]
                        if members:
                            vs_object['pool']['members'] = members
                virtual_obj = self.f5_client.tm.ltm.virtuals.virtual.load(
                    partition=vs.partition, name=vs.name)


                profiles = [profile.name for profile in
                            virtual_obj.profiles_s.get_collection()]

                if profiles:
                    vs_object['profiles'] = profiles
                policies = [policy.name for policy in
                            virtual_obj.policies_s.get_collection()]
                if policies:
                    vs_object['policies'] = policies

                if hasattr(vs, 'rules'):
                    vs_object['rules'] = vs.rules

                vs_object['traffic'] = virtual_obj.stats.load().entries
                max_conn = virtual_obj.stats.load().entries.get(u'clientside.maxConns', 0)
                vs_object['max_conn'] = max_conn

                # if str(vs.name) == 'miska-http':
                #     print "========  ========"
                #     print virtual_obj.stats.load().entries
                #     print "================"
                    
                self.avi_object_temp[vs_object['name']] = vs_object
            self.avi_object.append(self.avi_object_temp)
        # print 'Inventory: %s' % self.avi_object


if __name__ == '__main__':
    HELP_STR = '''
           F5 instance Discovery
           Example to get the inventory of f5 instance:
               f5_discovery.py -v 10 --f5_ip xxx.xxx.xxx.xxx --f5_user
               admin --f5_password xxxxx -o  output/
           '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)
    parser.add_argument('-v', '--f5_config_version',
                        help='version of f5 config file', default='11')
    parser.add_argument('--f5_ip', help='host ip of f5 instance')
    parser.add_argument('--f5_user', help='f5 host username')
    parser.add_argument('--f5_password', help='f5 host password')
    parser.add_argument('-o', '--output_file_path', default='output',
                        help='folder location for output file')

    parser.add_argument('-c', '--cli-out', action='store_true',
                        help='Print the human readable output')
    
    parser.add_argument('-i', '--interval', default=2,
                        help='Take the sample data with interval [default 2 mins]')

    parser.add_argument('--f5_port',
                        help='f5 host port id non default port is used ',
                        default=443)

    args = parser.parse_args()
    if not args.f5_ip:
        print 'Please provide f5 host'
        exit(0)
    if not args.f5_user:
        print 'Please provide ssh username of f5 host'
        exit(0)
    if not args.f5_password:
        print 'Please provide ssh password of f5 host'
        exit(0)

    if not os.path.isdir(args.output_file_path):
        print "Creating output directory ..."
        os.makedirs(args.output_file_path)

    f5_inventory_conv = F5InventoryConv.get_instance(args.f5_config_version,
                                                     args.f5_ip,
                                                     args.f5_port,
                                                     args.f5_user,
                                                     args.f5_password,
                                                     args.interval)
    f5_inventory_conv.get_inventory()

    f5_inventory_conv.print_human(
        args.output_file_path, args.f5_config_version, args.f5_ip, args.interval)
    print "\n Inventory Complete ..."
