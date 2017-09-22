""" This file having all configuration conversion """

import os
import logging
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.ace_converter.ace_constants import *
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ace_converter.ace_utils import update_excel

# file_loc = os.path.split(os.path.abspath(__file__))[0]
# sep = os.path.sep
# # logging.basicConfig(level=logging.WARNING)
# LOG = logging.getLogger(file_loc + sep + 'out' + sep + 'conversion.log')
LOG = logging.getLogger(__name__)

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
        for server in self.parsed['rserver']:
            if server['host'] == server_name:
                for server_ip in server['desc']:
                    if "ip address" in server_ip.keys():
                        return server_ip['ip address']
        return False

    def get_ips_of_pool(self, farm_name):
        """ Get ips from server farms """
        pool_ip_list = list()

        for index, val in enumerate(self.parsed['serverfarm']):

            if val['host'] == farm_name:
                for server_name in val['desc']:
                    if 'rserver' in server_name.keys():
                        if self.get_ips_of_server(server_name['rserver']):
                            pool_ip_list.append(self.get_ips_of_server(server_name['rserver']))
        print pool_ip_list
        return pool_ip_list

    def get_vsref_and_port_from_class(self, class_name):
        vs_ref = None
        port = None
        for class_map in self.parsed['class-map']:
            if 'match' in class_map['type'] and class_map['class-map'] == class_name:
                port = class_map['desc'][0].get('tcp', class_map['desc'][0].get('udp', ''))
                vs_ip = class_map['desc'][0].get('virtual-address', [])
                if vs_ip:
                    vs_ip_temp = '{}-vip'.format(vs_ip)
                    vs_ref = self.common_utils.get_object_ref(vs_ip_temp,
                                                              'vsvip')
        return vs_ref, port, vs_ip

    def virtual_service_conversion(self):
        vs_list = list()

        for policy_map in self.parsed['policy-map']:
            if policy_map.get('match', '') == 'multi-match':
                update_excel('policy-map', policy_map['policy-map'], status='Indirect')
                for cls in policy_map['desc']:
                    # print j
                    if cls.get('class', []):
                        # print j['class']
                        vs = self.virtual_service_conversion_policy(cls['class'])
                        # print vs
                        if vs:
                            for class_dec in cls['class_desc']:
                                if "loadbalance" in class_dec.keys():
                                    if class_dec.get('type', []) == 'inservice':
                                        vs['enabled'] = True
                            # updating excel sheet
                            update_excel('policy-map', vs['name'], avi_obj=vs)

                            #updating object
                            vs_list.append(vs)
                        else:
                            update_excel('policy-map', cls['class'], status='Skipped', avi_obj='Sticky-ServerFarm not allowed in Avi')
        return vs_list

    def virtual_service_conversion_policy(self, name):

        cloud_ref = self.common_utils.get_object_ref('Default-Cloud', 'cloud')

        port = None
        vs_ref = None
        for policy_map in self.parsed['policy-map']:
            temp_vs = dict()
            if policy_map.get('name') == name:
                name = policy_map['name']
                pool = None
                pool_ref = None
                # vs-ref and port
                vs_ref, port, ip = self.get_vsref_and_port_from_class(name)

                # Excel Sheet Update for class
                update_excel('class-map', name, avi_obj="Refer Policy-map {}".format(name))

                enable_ssl = (True if port == '443' else False)

                for class_dec in policy_map['desc']:
                    for sticky in class_dec['class_desc']:
                        if 'sticky-serverfarm' in sticky.keys():
                            LOG.warning('Skipping Sticky Serverfarm {}'.format(name))
                            return False
                        if 'serverfarm' in sticky.keys():
                            pool = sticky['serverfarm']

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
        for class_map in self.parsed['class-map']:
            if 'match-all' not in class_map.values():
                LOG.warning('This type of class map not supported :{}'.format(class_map['class-map']))
                update_excel('class-map', class_map['class-map'], status='Skipped', avi_obj='This type of class map not supported')
                continue
            for address in class_map['desc']:
                if "source-address" in address or "destination-address" in address:
                    LOG.warning('source-address or destination-address in class map not supported :{}'.format(class_map['class-map']))
                    update_excel('class-map', class_map['class-map'], status='Skipped', avi_obj='source-address or destination-address in class map not supported')
                    break
                if "virtual-address" in address:
                    vip = address['virtual-address']
                    if vip not in vip_list:
                        vip_list.append(vip)
        
        # create vsvip object 
        for vs_ip in vip_list:
            vip_name = "{}-vip".format(vs_ip)
            vip_obj_list.append(
                {
                    "cloud_ref": cloud_ref,
                    "vip": [{
                        "ip_address": {
                            "type": "V4",
                            "addr": vs_ip
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

        for sticky in self.parsed['sticky']:

            if 'ip-netmask' in sticky:
                persistance_type = "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS"

            name = sticky.get('name', [])
            if not name:
                continue
                LOG.warning('Skipping ...', i)
            # default time out
            timeout = APP_PERSISTANCE_TIMEOUT
            for time_out in sticky['desc']:
                if 'timeout' in time_out.keys():
                    if int(time_out['timeout']) < 720 and int(time_out['timeout']) > 1:
                        timeout = time_out['timeout']
            
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
        for sticky in self.parsed['sticky']:
            name = sticky['name']
            for pool in sticky['desc']:
                if pool.get('serverfarm', []) == pool_name:
                    app_persitance = name
                    break

        return app_persitance

    def healthmonitor_conversion(self):
        """ Health monitor conversion happens here """

        # monitor list
        monitor_list = list()

        for health_monitor in self.parsed['probe']:
            receive_timeout = DEFAULT_TIMEOUT
            failed_checks = DEFAULT_FAILED_CHECKS
            send_interval = health_monitor.get('interval', DEFAULT_INTERVAL)
            if int(receive_timeout) > int(send_interval):
                if int(send_interval) != 0:
                    receive_timeout = int(send_interval) - 1
                else:
                    receive_timeout = 0
            time_until_up = DEFAULT_TIME_UNTIL_UP
            successful_checks = DEFAULT_FAILED_CHECKS
            monitor = {
                "receive_timeout": receive_timeout,
                "name": health_monitor['name'],
                "tenant_ref": self.tenant_ref,
                "failed_checks": failed_checks,
                "send_interval": send_interval,
                "type": None,
                "successful_checks": successful_checks
            }
            if health_monitor['type'].strip() == 'icmp':
                monitor['type'] = 'HEALTH_MONITOR_PING'
            elif health_monitor['type'].strip() == 'tcp':
                monitor['type'] = 'HEALTH_MONITOR_TCP'
                extra_details = {
                                    "monitor_port": health_monitor.get('port', 80),
                                    "tcp_monitor": {
                                        "tcp_request": "",
                                        "tcp_response": "",
                                        "http_response": "",
                                        "maintenance_response": ""
                                    }
                                }
                monitor.update(extra_details)
            elif health_monitor['type'].strip() == 'http':
                monitor['type'] = "HEALTH_MONITOR_HTTP"
            else:
                monitor['type'] == "HEALTH_MONITOR_PING"
                
                # for url
                if health_monitor.get('method', []) and health_monitor.get('url', []):
                    request_url = "{} {}".format(health_monitor['method'], health_monitor['url'])
                else:
                    request_url = health_monitor.get('url', [])
                
                # for response code 
                response_code = ['HTTP_2XX', 'HTTP_3XX']
                if '20' in health_monitor.get('status', []):
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
            update_excel('probe', health_monitor['name'], avi_obj=monitor)

            monitor_list.append(monitor)
        return monitor_list

    def pool_conversion(self):
        """ Pool conversion over here
            Pool Contains:
            - servers
        """
        pool_list = list()
        for pool in self.parsed['serverfarm']:
            temp_pool = dict()
            name = pool.get('host', '')
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
            for pools in pool['desc']:
                farm_set = set(pools.keys())
                skipped_list_temp = list(farm_set.intersection(set(POOL_SKIP)))
                if skipped_list_temp:
                    skipped_list.extend(skipped_list_temp)
                if "rserver" in pools.keys():
                    server = self.server_converter(pools['rserver'])
                if "probe" in pools.keys():
                    probe = pools['probe']

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
        for serv in details['desc']:
            # checking for ip address ,default port ?
            if 'ip address' in serv.keys():
                server = serv['ip address']
            # checking for desc
            if 'description' in serv.keys():
                desc = serv['description']
            # checking for server enabled or not ?
            if 'type' in serv.keys():
                enabled = (True if serv['type'] == 'inservice' else False)

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
