""" Pool Conversion Goes here """
import logging
from avi.migrationtools.ace_converter.ace_constants import POOL_SKIP
from avi.migrationtools.ace_converter.ace_utils import update_excel
# logging init
LOG = logging.getLogger(__name__)


class PoolConverter(object):
    def __init__(self, parsed, tenant_ref, common_utils, cloud_ref, tenant, vrf_ref):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.cloud_ref = cloud_ref
        self.tenant = tenant
        self.vrf_ref = vrf_ref

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

        for val in self.parsed('serverfarm'):
            if val['host'] == farm_name:
                for server_name in val['desc']:
                    if 'rserver' in server_name.keys():
                        if self.get_ips_of_server(server_name['rserver']):
                            pool_ip_list.append(
                                self.get_ips_of_server(server_name['rserver']))
        return pool_ip_list

    def pool_conversion(self, data):
        """ Pool conversion over here
            Pool Contains:
            - servers
        """
        pool_list = list()
        for pool in self.parsed.get('serverfarm', ''):
            probe = None
            monitor_ref = None
            server = None
            temp_pool = dict()
            name = pool.get('host', '')
            app_persistance = self.find_app_persistance(name, data)
            app_ref = self.common_utils.get_object_ref(app_persistance,
                                                       'applicationpersistenceprofile',
                                                       tenant=self.tenant)
            if app_persistance:
                temp_pool.update(
                    {
                        'application_persistence_profile_ref': app_ref
                    })
            skipped_list = list()
            server = []
            for pools in pool['desc']:
                farm_set = set(pools.keys())
                skipped_list_temp = list(farm_set.intersection(set(POOL_SKIP)))
                if skipped_list_temp:
                    skipped_list.extend(skipped_list_temp)
                if "rserver" in pools.keys():
                    server.extend(self.server_converter(pools['rserver']))

                if data.get('HealthMonitor'):
                    for hm in data['HealthMonitor']:
                        if pools.get('probe') == hm['name']:
                            probe = pools['probe']

            if probe:
                monitor_ref = self.common_utils.get_object_ref(
                    probe, 'healthmonitor', tenant=self.tenant)
            if server:
                pool_dict = {
                    "lb_algorithm": "LB_ALGORITHM_ROUND_ROBIN",
                    "name": name,
                    "cloud_ref": self.cloud_ref,
                    "tenant_ref": self.tenant_ref,
                    "servers": server,
                    "health_monitor_refs": [
                    ],
                    "fail_action": {
                        "type": "FAIL_ACTION_CLOSE_CONN"
                    },
                    "description": None
                }

                if monitor_ref:
                    pool_dict['health_monitor_refs'].append(monitor_ref)
                if self.vrf_ref:
                    pool_dict['vrf_ref'] = self.vrf_ref
                temp_pool.update(pool_dict)
                # update excel sheet
                update_excel('serverfarm', name,
                             avi_obj=temp_pool, skip=skipped_list)

                pool_list.append(temp_pool)
        return pool_list

    def server_converter(self, name):
        """ Server Conversion \n
            :param @name: Server name
            * Get -  the server name
            * Reply - with server avi object
        """
        position = None
        if self.parsed.get('rserver', ''):
            for index, elem in enumerate(self.parsed['rserver']):
                if elem['host'] == name:
                    position = index
                    server_name = elem['host']

        if position is None:
            LOG.warning("rserver %s not found ..".format(name))
            return False

        details = self.parsed['rserver'][position]
        server_list = list()
        server = ''
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
        if server != '':
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

    def find_app_persistance(self, pool_name, data):
        """ Find the app persistance tagged to the pool """
        app_persitance = False
        for sticky in self.parsed.get('sticky', ''):
            name = sticky['name']
            for app in data['ApplicationPersistenceProfile']:
                if app['name'] == name:
                    app_persitance = name
                    break
        return app_persitance
