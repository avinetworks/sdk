"""
Created on May 07, 2015

@author: mayurdhande, ypraveen
- (07/09) support for 15.2
"""

import argparse
import copy
import subprocess
import os
import json
import requests
import logging
import sys
import time
from requests.exceptions import (MissingSchema, InvalidSchema, InvalidURL)
import urllib3
import re


absolute_http_url_regexp = re.compile(r"^https?://", re.I)
log = logging.getLogger(__name__)
urllib3.disable_warnings()

sys.path.insert(0, '/opt/avi/python/lib')
from avi.util.login import login


def ordered(obj):
    """ Sort JSON blob by keys """
    if isinstance(obj, dict):
        return sorted((k, ordered(v)) for k, v in list(obj.items()))
    if isinstance(obj, list):
        return sorted(ordered(x) for x in obj)
    else:
        return obj


class HttpSession(requests.Session):

    def __init__(self, controller_ip, user, password, *args, **kwargs):
        requests.Session.__init__(self, *args, **kwargs)

        self.base_url = 'https://%s/' % controller_ip
        self.__cookies = None
        self.__headers = None
        self.__login(user=user, password=password)

    def __login(self, user, password, wait=True, **kwargs):
        """ Login to controller. waits if controller is not ready"""
        sleep_time = kwargs.get('sleep_time', 10)
        timeout = kwargs.get('timeout', 1200)
        iters = timeout / sleep_time
        for i in range(iters):
            try:
                self.__cookies, self.__headers, _ = login(
                    self.base_url, user=user, password=password)
                return
            except Exception as e:
                log.debug('%s', str(e))
                time.sleep(sleep_time)
        raise RuntimeError('Faied to get login handle after %s secs' % timeout)

    def _build_url(self, path):
        """ prepend url with hostname unless it's already an absolute URL """
        if absolute_http_url_regexp.match(path):
            return path
        else:
            return "%s%s" % (self.base_url, path)

    def request(self, method, url, **kwargs):
        """ Constructs and sends a :py:class:`requests.Request`."""

        url = self._build_url(url)
        try:
            return requests.Session.request(
                self, method, url, cookies=self.__cookies,
                headers=self.__headers, verify=False, **kwargs)
        except (MissingSchema, InvalidSchema, InvalidURL, Exception):
            raise


class AviController:
    def __init__(self):
        self.configs = None
        self.cmd_args = self.__parse_args()
        self.__set_log()
        self.__read_configs()
        self.client = HttpSession(
            self.cmd_args.controller_ip, self.cmd_args.user, self.cmd_args.password)

    def __set_log(self):
        """ Set logging level """
        lvl = logging.DEBUG if self.cmd_args.verbose else logging.INFO
        log.setLevel(lvl)
        ch = logging.StreamHandler()
        ch.setLevel(lvl)
        formatter = logging.Formatter(
            '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
        ch.setFormatter(formatter)
        log.addHandler(ch)

    def __read_configs(self):
        """ Read configs into memory """
        if self.cmd_args.config and not os.path.isfile(self.cmd_args.config):
            raise RuntimeError(
                'Config file: %s is not present. Please check the path and try again')

        if not self.cmd_args.config:
            return
        with open(self.cmd_args.config, 'r') as fd:
            configs = fd.read()
        try:
            self.configs = json.loads(configs)
        except Exception:
            log.error('Failed to read JSON config file.')
            raise

    def __get_config_keys(self):
        """ Return configs keys in lower case """
        if not self.configs:
            return list()
        return [key.lower() for key in list(self.configs.keys())]

    def __get_config(self, config):
        """ Return configs keys in lower case """
        if not self.configs:
            return dict()
        for key, values in list(self.configs.items()):
            if key.lower() == config:
                for val in values:
                    return val

    def __parse_args(self):
        parser = argparse.ArgumentParser(description='Config import script')

        parser.add_argument(
            '-c', '--config',
            help='Config file for System and cluster configurations',
            action='store')
        parser.add_argument(
            '-i', '--controller-ip',
            help='Controller IP',
            action='store', default='localhost')

        parser.add_argument(
            '-u', '--user',
            help='Controller admin username',
            action='store', default='admin')

        parser.add_argument(
            '-p', '--password',
            help='Controller admin user password',
            action='store', default='admin')
        parser.add_argument(
            '-r', '--recovery',
            help='Recovery mode for controller',
            action='store_true')

        parser.add_argument(
            '-n', '--new-node',
            help='In case of recovery mode, specify new node IP')

        parser.add_argument(
            '-s', '--state',
            help='Wait till cluster goes to this state. Need to specify along with --wait')

        parser.add_argument(
            '--wait',
            help='wait until cluster ready after import',
            action='count', default=0)

        parser.add_argument(
            '-v', '--verbose',
            help='verbose output', action='count', default=0)

        args = parser.parse_args()
        return args

    def __get_my_ip(self):
        """ Return list of Ips associated with VM"""
        ips = subprocess.getoutput('hostname -I')
        return ips.split(' ')

    def __get_ref(self, uri):
        """ Returns a ref for given URI"""

        response = self.client.get(uri)
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get system configuration. Is controller running?')
        source = json.loads(response.content)
        if not source['results']:
            raise RuntimeError('Failed to get %s' % uri)
        return source['results'][0]['url']

    def __get_uuid_from_name(self, uri, name):
        log.debug('__get_uuid_from_name : uri %s name %s' %\
                  (uri,name))
        response = self.client.get(uri)
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to retrieve %s objects. Is controller running?' \
                               %(uri))
        content = json.loads(response.content)
        info_list = content['results']
        for info in info_list:
            log.debug('Name : %s' % (info['name']))
            if info['name'] == name:
                return info['uuid']

    def configure_cloud(self):
        """Configure cloud"""
        # https://10.10.36.126/api/cloud-inventory?include_name=true

        """ Configure system config on controller if it's not set already"""
        if self.configs is None:
            raise RuntimeError('Please load configs first')

        response = self.client.get('/api/cloud-inventory?include_name=true')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get cloud inventory. Is controller running?')

        if 'cloud' not in self.__get_config_keys():
            log.info('No cloud object present in JSON file. return')
            return

        json_config = self.__get_config('cloud')
        log.debug(str(json_config))
        source = json.loads(response.content)
        # print "source: %s" % source
        source = source['results'][0]['config']
        # print "new source: %s" % source
        if ordered(json_config) == ordered(source):
            return

        cloud_id = source['uuid']
        for key in list(json_config.keys()):
            source[key] = json_config[key]

        # check for vcenter configuration. If so then we need to perform
        # vcenter discovery pattern
        if source.get('vcenter_configuration'):
            '''
            Remove apic_configuration if present
            '''
            apic_conf = source.pop('apic_configuration', None)
            dc_name = source.get('vcenter_configuration').pop('datacenter_ref', None)
            mgmt_nw_name = source.get('vcenter_configuration').pop('management_network', None)

            log.info('source : %s' % (str(source)))
            response = self.client.put(
                '/api/cloud/%s' % cloud_id, data=json.dumps(source))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to configure cloud')
            self.wait_until_vcenter_state('VCENTER_DISCOVERY_WAITING_DC')

            '''
            Datacenters have been retrieved in Controller.
            Get the UUID corressponding to the Data center
            name
            '''
            dc_uuid = self.__get_uuid_from_name('/api/vimgrdcruntime?page_size=1000', dc_name)
            source.get('vcenter_configuration')['datacenter_ref'] = dc_uuid
            #log.info('Datacenter : %s' % (str(source)))
            log.debug('Setting Datacenter %s' % (dc_name))
            response = self.client.put(
                '/api/cloud/%s' % cloud_id, data=json.dumps(source))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to configure cloud')
            self.wait_until_vcenter_state('VCENTER_DISCOVERY_COMPLETE_NO_MGMT_NW')

            '''
            Networks(portgroups) have been retrieved in Controller.
            Get the UUID corressponding to the Management Network
            name
            '''
            mgmt_nw_uuid = self.__get_uuid_from_name('/api/vimgrnwruntime?page_size=1000', mgmt_nw_name)
            source.get('vcenter_configuration')['management_network'] = mgmt_nw_uuid
            log.debug('Setting vCenter Management Network : %s' % (mgmt_nw_name))
            #log.info('Management Network : %s' % (str(source)))
            response = self.client.put(
                '/api/cloud/%s' % cloud_id, data=json.dumps(source))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to configure cloud')
            time.sleep(60)

            '''
            Add the APIC configuration 
            '''
            log.debug('Setting APIC Configuration....')
            source['apic_configuration'] = apic_conf
            response = self.client.put(
                '/api/cloud/%s' % cloud_id, data=json.dumps(source))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to configure cloud')

        else:
            response = self.client.put(
                '/api/cloud/%s' % cloud_id, data=json.dumps(source))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to configure cloud')
        log.info('Cloud configuration successful!')
        pass

    def configure_system_config(self):
        """ Configure system config on controller if it's not set already"""
        if self.configs is None:
            raise RuntimeError('Please load configs first')

        response = self.client.get('/api/systemconfiguration')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get system configuration. Is controller running?')

        if 'systemconfiguration' not in self.__get_config_keys():
            log.info('No system config object present in JSON file. return')
            return

        json_config = self.__get_config('systemconfiguration')
        source = json.loads(response.content)
        if ordered(json_config) == ordered(source):
            return

        for key in list(json_config.keys()):
            source[key] = json_config[key]

        # source = {"url": "https://10.10.24.3/api/systemconfiguration", "uuid": "default", "email_configuration": {"mail_server_name": "localhost", "smtp_type": "SMTP_NONE", "mail_server_port": 25}, "global_tenant_config": {"per_tenant_vrf": False, "per_tenant_default_profiles": False}, "dns_configuration": {"search_domain": "", "server_list": [{"type": "V4", "addr": "8.8.8.8"}]}, "tech_support_uploader_configuration": {"auto_upload": False}, "openstack_configuration": {"username": "admin", "import_keystone_tenants": True, "region_name": "RegionOne", "admin_tenant": "admin", "hypervisor": "KVM", "mgmt_network_name": "avi-mgmt", "nuage_port": 8443, "tenant_se": True, "contrail_plugin": False, "keystone_host": "10.10.184.2", "anti_affinity": True, "privilege": "WRITE_ACCESS", "use_keystone_auth": False}, "dhcp_enabled": True, "prefer_static_routes": False, "portal_configuration": {"use_uuid_from_input": False, "redirect_to_https": True, "sslprofile_ref": "https://10.10.24.3/api/sslprofile/sslprofile-f2e675fd-017d-4ec0-b178-8260f0d1b374", "enable_https": True, "sslkeyandcertificate_ref": "https://10.10.24.3/api/sslkeyandcertificate/sslkeyandcertificate-2f13fe71-94c8-4f00-aae1-e07f52479914", "enable_http": False}, "ntp_configuration": {"ntp_server_list": [{"type": "DNS", "addr": "0.us.pool.ntp.org"}]}, "docker_mode": False, "enable_vip_static_routes": False, "apic_mode": False}
        response = self.client.put(
            '/api/systemconfiguration', data=json.dumps(source))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to configure systemconfiguration')
        log.info('System configuration successful!')

    def configure_cluster(self):
        """ Configure cluster on controller"""
        if self.configs is None:
            raise RuntimeError('Please load configs first')

        response = self.client.get('/api/cluster')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get cluster config. Is controller running?')

        if 'cluster' not in self.__get_config_keys():
            log.info('No cluster object present in JSON file. return')
            return

        json_config = self.__get_config('cluster')
        source = json.loads(response.content)
        if 'nodes' in list(json_config.keys()) and 'nodes' in list(source.keys()) and \
                ordered(json_config['nodes']) == ordered(source['nodes']):
            log.debug('Node config not changed')
            return

        for key in list(json_config.keys()):
            source[key] = json_config[key]

        response = self.client.put(
            '/api/cluster', data=json.dumps(source))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to configure cluster')
        log.info('Cluster configuration successful!')

    def configure_default_segroup(self):
        """ Configure default SE group """
        if self.configs is None:
            raise RuntimeError('Please load configs first')

        response = self.client.get('/api/serviceenginegroup?name=Default-Group')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('No serviceengine group with name Default-Group present')

        json_config = self.__get_config('serviceenginegroup')
        source = json.loads(response.content)
        se_group = source['results'][0]

        for key in list(json_config.keys()):
            se_group[key] = json_config[key]

        uri = '/api/serviceenginegroup/%s' % se_group['uuid']
        response = self.client.put(uri, data=json.dumps(se_group))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to configure SE group')
        log.info('SE Group configuration successful!')

    def configure_segroup_os_config(self):
        """ Configures SE group ref as part of openstack tenant configuration """
        response = self.client.get('/api/cloud')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get default cloud. Is controller running?')

        source = json.loads(response.content)['results'][0]
        if source.get('openstack_configuration', None) is None:
            log.info('No Openstack configuration. Ignoring')
            return

        source['openstack_configuration']['se_group_ref'] = self.__get_ref('/api/serviceenginegroup?name=Default-Group')

        log.debug('%s' % str(source))
        response = self.client.put(
            '/api/cloud/%s' % source['uuid'], data=json.dumps(source))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to add segroup to cloud')
        log.info('Adding SE group to cloud configuration: successful!')

    def configure_seproperties(self):
        """ Sets SE properties """
        response = self.client.get('/api/seproperties')
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get system configuration. Is controller running?')

        json_config = self.__get_config('serviceengineproperties')
        source = json.loads(response.content)
        for key, value in list(json_config.items()):
            if isinstance(value, dict):
                for _key in list(value.keys()):
                    source[key][_key] = json_config[key][_key]
            else:
                source[key] = json_config[key]

        response = self.client.put(
            '/api/seproperties', data=json.dumps(source))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to configure service engine properties')
        log.info('SE Properties configuration successful!')

    def configure_roles(self):
        """
        Configures Roles
        In configuration, specify the new role to create as key and
        the default role name that you want to copy the privileges from.
        :return:
        """
        json_config = self.__get_config('rolemapping')
        if not json_config:
            log.info('No roles to configure')
            return
        response = self.client.get("/api/role")
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get roles. Is controller running?')
        results = json.loads(response.content)['results']
        roles = {}
        for res in results:
            roles[res['name']] = res

        for key, value in list(json_config.items()):
            if value not in roles:
                raise RuntimeError("mapped-to role %s does not exist on "
                                   "Avi" % value)
            nrole = {"privileges": roles[value]["privileges"],
                     "name": key}
            if key not in roles:
                response = self.client.post('/api/role',
                                            data=json.dumps(nrole))
                if response.status_code / 100 != 2:
                    log.debug('%s, %s', response.status_code, response.content)
                    raise RuntimeError('Failed to add new role %s' % key)
                else:
                    log.debug("Added new role %s", key)
            elif roles[key]["privileges"] != nrole["privileges"]:
                response = self.client.put('/api/role/%s' % roles[key]["uuid"],
                                            data=json.dumps(nrole))
                if response.status_code / 100 != 2:
                    log.debug('%s, %s', response.status_code, response.content)
                    raise RuntimeError('Failed to update role %s' % key)
                else:
                    log.debug("Updated role %s", key)
            else:
                log.debug("Role %s already exists with right privileges", key)
        log.info('Role configuration successfull!')

    def configure_app_profiles(self):
        """
        Sets websockets_enabled to true in System-HTTP
        and System-Secure-HTTP profiles
        :return:
        """
        response = self.client.get("/api/applicationprofile")
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get app profiles.'
                               ' Is controller running?')
        results = json.loads(response.content)['results']
        for aprofile in results:
            if(aprofile["name"] in ["System-HTTP", "System-Secure-HTTP"] and
               "http_profile" in aprofile and
               not aprofile["http_profile"]["websockets_enabled"]):
                aprofile["http_profile"]["websockets_enabled"] = True
                response = self.client.put('/api/applicationprofile/%s' %
                                           aprofile["uuid"],
                                           data=json.dumps(aprofile))
                if response.status_code / 100 != 2:
                    log.debug('%s, %s', response.status_code,
                              response.content)
                    raise RuntimeError('Failed to update application'
                                       ' profile %s' % aprofile["name"])
                else:
                    log.debug("Updated application profile %s",
                              aprofile["name"])
        log.info('App profiles configuration successful!')

    def configure_admin_password(self):
        """
        Configures admin password
        :return:
        """
        json_config = self.__get_config('adminpassword')
        if not json_config:
            return
        if json_config["password"] == self.cmd_args.password:
            return

        response = self.client.get("/api/user/user-1")
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to get user information.'
                               ' Is controller running?')

        source = json.loads(response.content)
        source["password"] = json_config["password"]

        response = self.client.put(
            '/api/user/user-1', data=json.dumps(source))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to set admin password')
        log.info('Password configuration successful!')
        self.client = HttpSession(
            self.cmd_args.controller_ip, self.cmd_args.user, json_config["password"])
        return

    def wait_until_cluster_ready(self, expected_states):
        """ Wait until cluster ready """

        uri = '/api/cluster/runtime'
        timeout = 1200
        sleep_time = 10
        iters = timeout / sleep_time
        for i in range(iters):
            try:
                response = self.client.get(uri)
                if response.status_code == 500:
                    raise Exception(response.content)
                data = json.loads(response.content)
                if data:
                    cluster_state = data.get('cluster_state', {})
                    log.debug('Cluster state: %s', cluster_state.get('state'))
                    if cluster_state.get('state') in expected_states:
                        return True
            except Exception as e:
                log.debug('%s', str(e))
            time.sleep(sleep_time)

        raise RuntimeError(
            'Timeout: waited approximately %s sec. and the cluster is still not active.' % (timeout))

    def wait_until_vcenter_state(self, expected_state):
        """ Wait until vcenter state"""

        uri = '/api/vimgrvcenterruntime'
        timeout = 1200
        sleep_time = 10
        iters = timeout / sleep_time
        for i in range(iters):
            try:
                response = self.client.get(uri)
                if response.status_code == 500:
                    raise Exception(response.content)
                data = json.loads(response.content)
                #log.debug('data : %s' % (str(data)))
                if data:
                    vcenter_runtime = data.get('results')[0]
                    inventory_state = vcenter_runtime.get('inventory_state', '')
                    log.debug('Vcenter state: %s Expected State : %s' %(inventory_state, expected_state))
                    if inventory_state == expected_state:
                        return True
            except Exception as e:
                log.debug('%s', str(e))
            time.sleep(sleep_time)

        raise RuntimeError(
            'Timeout: waited approximately %s sec. and the vCenter is still not ready.' % (timeout))

    def fix_same_ip_node(self, leader, all_nodes):
        """ In this case, new node cluster IP is same as old IP
            We need to convert this to one node cluster and then form
            a 3 node cluster again with new IPs
        """

        resp = self.client.get('/api/cluster')
        if resp.status_code / 100 != 2:
            log.debug('%s, %s', resp.status_code, resp.content)
            raise RuntimeError(
                'Failed to get cluster config. Is controller running?')

        # Form a one node cluster first
        cluster = json.loads(resp.content)
        new_nodes = [node for node in cluster['nodes']
                     if node['name'] == leader]
        cluster['nodes'] = new_nodes

        response = self.client.put(
            '/api/cluster', data=json.dumps(cluster))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to remove node from cluster')

        self.wait_until_cluster_ready(['CLUSTER_UP_NO_HA'])
        # Hack to wait until other node comes up
        time.sleep(60)

        for node in all_nodes:
            if node == leader:
                continue
            new_node_config = copy.deepcopy(cluster['nodes'][0])
            new_node_config['ip']['addr'] = node
            new_node_config['name'] = node
            cluster['nodes'].append(new_node_config)

        response = self.client.put(
            '/api/cluster', data=json.dumps(cluster))
        if response.status_code / 100 != 2:
            log.debug('%s, %s', response.status_code, response.content)
            raise RuntimeError('Failed to add node to cluster')

        self.wait_until_cluster_ready(['CLUSTER_UP_HA_ACTIVE'])
        return

    def maybe_fix_bad_node_cluster(self, new_node):
        """ Scenarios:
            - New node has different IP than old node
                In this case, we can just update the cluster with new nodes IP
            - New node has same IP as old node
                This is bit tricky, as we need to remove node with same Ip and
                create 1 node cluster.
                Wait for all nodes to go in cluster_up_no_ha state
                Configure 3 node cluster again
        """

        def get_active_nodes(nodes):
            return [node['name'] for node in nodes
                    if node['state'] != 'CLUSTER_INACTIVE']

        def get_all_nodes(nodes):
            return [node['name'] for node in nodes]

        def get_cluster_leader(nodes):
            for node in nodes:
                if node['role'] == 'CLUSTER_LEADER':
                    return node['name']

        resp = self.client.get('/api/cluster/runtime')
        if resp.status_code / 100 != 2:
            log.debug(
                'Cluster Runtime status code: %s, content: %s' % (
                    resp.status_code, resp.content))
            raise RuntimeError('Failed to get cluster node status')
        response = json.loads(resp.content)
        active_nodes = get_active_nodes(response['node_states'])
        all_nodes = get_all_nodes(response['node_states'])

        if get_cluster_leader(response['node_states']) not in self.__get_my_ip():
            log.debug('Cluster leaader: %s, This node IP: %s' % (
                get_cluster_leader(response['node_states']), self.__get_my_ip()))
            raise RuntimeError(
                'Please run this from cluster leader: %s' %
                get_cluster_leader(response['node_states']))

        if len(active_nodes) == 3:
            log.debug('All cluster nodes are active. returning')
            return

        if new_node not in all_nodes:
            # Different IP
            resp = self.client.get('/api/cluster')
            if resp.status_code / 100 != 2:
                log.debug('%s, %s', resp.status_code, resp.content)
                raise RuntimeError(
                    'Failed to get cluster config. Is controller running?')

            cluster = json.loads(resp.content)
            new_nodes = [node for node in cluster['nodes']
                         if node['name'] in active_nodes]
            cluster['nodes'] = new_nodes

            new_node_config = copy.deepcopy(cluster['nodes'][0])
            new_node_config['ip']['addr'] = new_node
            new_node_config['name'] = new_node
            cluster['nodes'].append(new_node_config)

            log.debug('%s' % str(cluster['nodes']))
            response = self.client.put(
                '/api/cluster', data=json.dumps(cluster))
            if response.status_code / 100 != 2:
                log.debug('%s, %s', response.status_code, response.content)
                raise RuntimeError('Failed to remove node from cluster')
        else:
            self.fix_same_ip_node(
                get_cluster_leader(response['node_states']),
                active_nodes)
        log.info('Cluster configuration successful!')

    def recover_cluster(self, new_node):
        """ Used to recover cluster. This is the case when one of the cluster
            node goes down and recovery script will be used to create that node.
            We will need then to detect this bad node and update it with newly
            created node information.
            Assumptions:
                - Cluster is in CLUSTER_UP_HA_COMPROMISED state
        """
        self.wait_until_cluster_ready(['CLUSTER_UP_HA_COMPROMISED',
                                       'CLUSTER_UP_HA_ACTIVE'])
        self.maybe_fix_bad_node_cluster(new_node)
        self.wait_until_cluster_ready(['CLUSTER_UP_HA_ACTIVE'])
        return

    def run(self):
        """ Start the config import utility"""

        if self.cmd_args.recovery and not self.cmd_args.new_node:
            raise RuntimeError(
                'Recovery mode in use but no new node config specified')

        if self.cmd_args.state and not self.cmd_args.wait:
            raise RuntimeError('state is passed without --wait flag')

        if self.cmd_args.recovery and self.cmd_args.new_node:
            # If recovery and new node is specified, only do recovery and
            # return
            self.recover_cluster(self.cmd_args.new_node)
            return

        if self.cmd_args.wait and self.cmd_args.state:
            # in case if wait is specified with no config, wait till cluster
            # comes up in given state
            self.wait_until_cluster_ready([self.cmd_args.state])
            return

        if self.cmd_args.wait and not self.cmd_args.config:
            # in case if wait is specified with no config, wait till cluster
            # comes up in No HA mode
            self.wait_until_cluster_ready(['CLUSTER_UP_NO_HA'])
            return

        self.configure_admin_password()
        self.configure_system_config()
        self.configure_cloud()
        self.configure_default_segroup()
        self.configure_segroup_os_config()
        self.configure_seproperties()
        self.configure_roles()
        self.configure_app_profiles()
        self.configure_cluster()

        if self.cmd_args.wait:
            time.sleep(30)
            self.wait_until_cluster_ready(['CLUSTER_UP_HA_ACTIVE'])


def main():
    controller = AviController()
    controller.run()

if __name__ == '__main__':
    main()
