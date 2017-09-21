""" This file having all configuration conversion """

import os
import logging
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.ace_converter.ace_constants import *
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ace_converter.ace_utils import update_excel

file_loc = os.path.split(os.path.abspath(__file__))[0]
sep = os.path.sep
# logging.basicConfig(level=logging.WARNING)
LOG = logging.getLogger(file_loc + sep + 'out' + sep + 'conversion.log')


class ConfigConverter(object):
    """ Configuration conversion happens here """

    def __init__(self, parsed_output):
        self.parsed = parsed_output
        self.common_utils = MigrationUtil()

    def conversion(self):
        """ Create Some common Objects over here """
        self.tenant_ref = self.common_utils.get_object_ref('admin', 'tenant')

        """ All conversion controller over here """
        self.aviobj = AviConverter()
        data = dict()
        data['META'] = self.aviobj.meta(tenant='admin', controller_version='17.2.1')
        data['Pool'] = self.pool_conversion()
        data['HealthMonitor'] = self.healthmonitor_conversion()
        data['ApplicationPersistenceProfile'] = self.app_persistance_conversion()
        data['VsVip'] = self.vsvip_conversion()
        data['VirtualService'] = self.virtual_service_conversion()
        data['PoolGroup'] = []
        data['HTTPPolicySet'] = []
        data['SSLProfile'] = []
        data['SSLKeyAndCertificate'] = []
        data['NetworkProfile'] = []
        data['ApplicationProfile'] = []
        data['PKIProfile'] = []
        data['StringGroup'] = []
        return data

    def get_ips_of_server(self, server_name):
        for i in self.parsed['rserver']:
            if i['host'] == server_name:
                for j in i['desc']:
                    if "ip address" in j.keys():
                        return j['ip address']
        return False

    def get_ips_of_pool(self, farm_name):
        """ Get ips from server farms """
        ip_list = list()

        for index, val in enumerate(self.parsed['serverfarm']):
            if val['host'] == farm_name:
                for j in val['desc']:
                    if 'rserver' in j.keys():
                        if self.get_ips_of_server(j['rserver']):
                            ip_list.append(self.get_ips_of_server(j['rserver']))
        return ip_list

    def get_vsref_and_port_from_class(self, class_name):
        vs_ref = None
        port = None

        for i in self.parsed['class-map']:
            if 'match' in i['type'] and i['class-map'] == class_name:
                port = i['desc'][0].get('tcp', i['desc'][0].get('udp', ''))
                vs_ip = i['desc'][0].get('virtual-address', [])
                if vs_ip:
                    vs_ip_temp = '{}-vip'.format(vs_ip)
                    vs_ref = self.common_utils.get_object_ref(vs_ip_temp,
                                                              'vsvip')
        return vs_ref, port, vs_ip

    def virtual_service_conversion(self):
        vs_list = list()

        for i in self.parsed['policy-map']:
            if i.get('match', '') == 'multi-match':
                # print i
                update_excel('policy-map', i['policy-map'], status='Indirect')
                for j in i['desc']:
                    # print j
                    if j.get('class', []):
                        # print j['class']
                        vs = self.virtual_service_conversion_policy(j['class'])
                        # print vs
                        if vs:
                            for k in j['class_desc']:
                                if "loadbalance" in k.keys():
                                    if k.get('type', []) == 'inservice':
                                        vs['enabled'] = True
                            # updating excel sheet
                            update_excel('policy-map', vs['name'], avi_obj=vs)

                            #updating object
                            vs_list.append(vs)
                        else:
                            update_excel('policy-map', j['class'], status='Skipped', avi_obj='Sticky-ServerFarm not allowed in Avi')
            # elif i.get('match', '') == 'first-match':

        return vs_list

    def virtual_service_conversion_policy(self, name):

        cloud_ref = self.common_utils.get_object_ref('Default-Cloud', 'cloud')

        port = None
        vs_ref = None
        for i in self.parsed['policy-map']:
            temp_vs = dict()
            if i.get('name') == name:
                name = i['name']
                pool = None
                pool_ref = None
                # vs-ref and port
                vs_ref, port, ip = self.get_vsref_and_port_from_class(name)

                # Excel Sheet Update for class
                update_excel('class-map', name, avi_obj="Refer Policy-map {}".format(name))

                enable_ssl = (True if port == '443' else False)

                for j in i['desc']:
                    for k in j['class_desc']:
                        if 'sticky-serverfarm' in k.keys():
                            LOG.warning('Skipping Sticky Serverfarm {}'.format(name))
                            return False
                        if 'serverfarm' in k.keys():
                            pool = k['serverfarm']

                            # update excel sheet
                            update_excel('class-map',
                                         pool,
                                         avi_obj="Refer Class Map : {}".format(name))

                            # finding the ips for vip
                            ip_list = [ip]
                            vip = []
                            for ip in ip_list:
                                vip.append({
                                                "ip_address": {
                                                    "type": "V4",
                                                    "addr": ip
                                                },
                                                "vip_id": 0
                                           })

                            pool_ref = self.common_utils.get_object_ref(pool, 'pool')
                if not pool:
                    continue
                temp_vs = {
                        "vsvip_ref": vs_ref,
                        "enabled": False,
                        "vs_datascripts": [],
                        "vip": vip,
                        "services": [{
                            "enable_ssl": enable_ssl,
                            "port": port
                        }],
                        "pool_ref": pool_ref,
                        "description": None,
                        "name": name,
                        "cloud_ref": cloud_ref,
                        "tenant_ref": self.tenant_ref,
                        "type": "VS_TYPE_NORMAL"
                    }
                return temp_vs
        return False

    def vsvip_conversion(self):
        """vs vip take from virutal-server in class map"""
        cloud_ref = "/api/cloud/?tenant=admin&name=Default-Cloud"
        vip_id = '0'
        vip_list = list()
        vip_obj_list = list()

        # get the number of vips available
        for i in self.parsed['class-map']:
            if 'match-all' not in i.values():
                LOG.warning('This type of class map not supported :{}'.format(i['class-map']))
                update_excel('class-map', i['class-map'], status='Skipped', avi_obj='This type of class map not supported')
                continue
            for j in i['desc']:
                if "source-address" in j or "destination-address" in j:
                    LOG.warning('source-address or destination-address in class map not supported :{}'.format(i['class-map']))
                    update_excel('class-map', i['class-map'], status='Skipped', avi_obj='source-address or destination-address in class map not supported')
                    break
                if "virtual-address" in j:
                    vip = j['virtual-address']
                    if vip not in vip_list:
                        vip_list.append(vip)
        
        # create vsvip object 
        for v in vip_list:
            vip_name = "{}-vip".format(v)
            vip_obj_list.append(
                {
                    "cloud_ref": cloud_ref,
                    "vip": [{
                        "ip_address": {
                            "type": "V4",
                            "addr": v
                        },
                        "vip_id": "0"
                    }],
                    "tenant_ref": self.tenant_ref,
                    "name": vip_name
                }
            )

        # # Excel Sheet Creation
        # update_excel('sticky', name, avi_obj=persistance)

        return vip_obj_list

    def app_persistance_conversion(self):
        """ App persistance conversion """
        # persistance list
        persistance_list = list()
        persistance_type = 'PERSISTENCE_TYPE_CLIENT_IP_ADDRESS'

        for i in self.parsed['sticky']:

            if 'ip-netmask' in i:
                persistance_type = "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS"

            name = i.get('name', [])
            if not name:
                continue
            # default time out
            timeout = APP_PERSISTANCE_TIMEOUT
            for j in i['desc']:
                if 'timeout' in j.keys():
                    if int(j['timeout']) < 720 and int(j['timeout']) > 1:
                        timeout = j['timeout']
            
            persistance = {
                            "name": name,
                            "persistence_type": persistance_type,
                            "tenant_ref": self.tenant_ref,
                            "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
                            "ip_persistence_profile": {
                                "ip_persistent_timeout": timeout
                            }
                          }
            # Updating Excel Sheet
            update_excel('sticky', name, avi_obj=persistance)

            persistance_list.append(persistance)

        return persistance_list

    def find_app_persistance(self, pool_name):
        """ Find the app persistance tagged to the pool """
        app_persitance = False
        for i in self.parsed['sticky']:
            name = i['name']
            for j in i['desc']:
                if j.get('serverfarm', []) == pool_name:
                    app_persitance = name
                    break

        return app_persitance

    def healthmonitor_conversion(self):
        """ Health monitor conversion happens here """

        # monitor list
        monitor_list = list()

        for probe in self.parsed['probe']:
            receive_timeout = DEFAULT_TIMEOUT
            failed_checks = DEFAULT_FAILED_CHECKS
            send_interval = probe.get('interval', DEFAULT_INTERVAL)
            if int(receive_timeout) > int(send_interval):
                if int(send_interval) != 0:
                    receive_timeout = int(send_interval) - 1
                else:
                    receive_timeout = 0
            time_until_up = DEFAULT_TIME_UNTIL_UP
            successful_checks = DEFAULT_FAILED_CHECKS
            monitor = {
                "receive_timeout": receive_timeout,
                "name": probe['name'],
                "tenant_ref": self.tenant_ref,
                "failed_checks": failed_checks,
                "send_interval": send_interval,
                "type": None,
                "successful_checks": successful_checks
            }
            if probe['type'].strip() == 'icmp':
                monitor['type'] = 'HEALTH_MONITOR_PING'
            elif probe['type'].strip() == 'tcp':
                monitor['type'] = 'HEALTH_MONITOR_TCP'
                extra_details = {
                                    "monitor_port": probe.get('port', 80),
                                    "tcp_monitor": {
                                        "tcp_request": "",
                                        "tcp_response": "",
                                        "http_response": "",
                                        "maintenance_response": ""
                                    }
                                }
                monitor.update(extra_details)
            elif probe['type'].strip() == 'http':
                monitor['type'] = "HEALTH_MONITOR_HTTP"
            else:
                monitor['type'] == "HEALTH_MONITOR_PING"
                
                # for url
                if probe.get('method', []) and probe.get('url', []):
                    request_url = "{} {}".format(probe['method'], probe['url'])
                else:
                    request_url = probe.get('url', [])
                
                # for response code 
                response_code = ['HTTP_2XX', 'HTTP_3XX']
                if '20' in probe.get('status', []):
                    response_code = ['HTTP_2XX']
                extra_details = {
                                    "http_monitor": {
                                        "maintenance_response": "",
                                        "http_request": request_url,
                                        "http_response_code": response_code,
                                        "http_response": ""
                                    }
                                }
                monitor.update(extra_details)

            # Excel Sheet updating
            update_excel('probe', probe['name'], avi_obj=monitor)

            monitor_list.append(monitor)
        return monitor_list

    def pool_conversion(self):
        """ Pool conversion over here
            Pool Contains:
            - servers
        """
        pool_list = list()
        for farm in self.parsed['serverfarm']:
            temp_pool = dict()
            name = farm.get('host', '')
            # print name
            app_persistance = self.find_app_persistance(name)
            app_ref = self.common_utils.get_object_ref(app_persistance,
                                                'applicationpersistenceprofile')
            if app_persistance:
                temp_pool.update(
                    {
                        'application_persistence_profile_ref': app_ref
                    })
            cloud_ref = "/api/cloud/?tenant=admin&name=Default-Cloud"
            skipped_list = list()
            for i in farm['desc']:
                farm_set = set(i.keys())
                skipped_list_temp = list(farm_set.intersection(set(POOL_SKIP)))
                if skipped_list_temp:
                    skipped_list.extend(skipped_list_temp)
                if "rserver" in i.keys():
                    server = self.server_converter(i['rserver'])
                if "probe" in i.keys():
                    probe = i['probe']

            temp_pool.update({
                        "lb_algorithm": "LB_ALGORITHM_ROUND_ROBIN",
                        "name": name,
                        "cloud_ref": cloud_ref,
                        "tenant_ref": self.tenant_ref,
                        "servers": server,
                        "health_monitor_refs": [
                            self.common_utils.get_object_ref(probe, 'healthmonitor')
                        ],
                        "fail_action": {
                            "type": "FAIL_ACTION_CLOSE_CONN"
                        },
                        "description": None
                    })
            # update excel sheet
            update_excel('serverfarm', name, avi_obj=temp_pool, skip=skipped_list)

            pool_list.append(temp_pool)
        return pool_list

    def server_converter(self, name):
        """ Server Conversion \n
            :param @name: Server name
            * Get -  the server name
            * Reply - with server avi object
        """
        position = None

        for index, elem in enumerate(self.parsed['rserver']):
            if elem['host'] == name:
                position = index
                server_name = elem['host']

        if position is None:
            print "rserver {} not found ..".format(name)
            return False

        details = self.parsed['rserver'][position]
        server_list = list()
        server = ''
        probe = ''
        desc = ''
        default_port = 8080
        enabled = False

        # server conversion
        for i in details['desc']:
            # checking for ip address ,default port ?
            if 'ip address' in i.keys():
                server = i['ip address']
            # checking for desc
            if 'description' in i.keys():
                desc = i['description']
            # checking for server enabled or not ?
            if 'type' in i.keys():
                enabled = (True if i['type'] == 'inservice' else False)

        server_list.append({
            "ip": {
                    "addr": server,
                    "type": "V4",
                },
            "enabled": enabled,
            "description": desc,
            "port": default_port
            })

        # Update Excel Sheet
        update_excel('rserver', server_name, avi_obj=server_list)

        return server_list
