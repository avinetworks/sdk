'''
Created on Sep 4, 2015

@author: Gaurav Rastogi (grastogi@avinetworks.com)
This has examples of creating VS
'''
import argparse
from copy import deepcopy
import json
import math
import requests
from requests.auth import HTTPBasicAuth
from string import Template
import logging
from avi.sdk.avi_api import ApiSession

log = logging.getLogger(__name__)



ANALYTICS_POLICY = {
    'metrics_realtime_update': {
        'enabled': True,
        'duration': 0,
        },
    'full_client_logs': {
        'enabled': True,
        'duration': 0,        
        }
    }

VS_CFG = {
    "virtualservice": {'analytics_policy': ANALYTICS_POLICY,
                       'application_profile_ref': '/api/applicationprofile?name=System-HTTP'}
}

APP_CPU = 0.2

DEFAULT_APP = {
    "id": "bridged-webapp",
    "cmd": "service nginx start && /usr/sbin/sshd -D",
    #"cmd": "service nginx start",
    "cpus": APP_CPU,
    "mem": 32.0,
    "instances": 2,
    "labels": {"avi_proxy": json.dumps(VS_CFG)},
    "container": {
        "type": "DOCKER",
        "docker": {
            "image": "avinetworks/server",
            "forcePullImage": True,
            #"image": "nginx",
            "network": "BRIDGE",
            "portMappings": [
                {"containerPort": 80, "hostPort": 0, "servicePort": 0,
                 "protocol": "tcp"}
                ]
        }
    },
    "healthChecks": [
        {"protocol": "HTTP", "portIndex": 0, "path": "/",
         "gracePeriodSeconds": 10, "intervalSeconds": 20,
         "maxConsecutiveFailures": 3}
    ]
}

AVI_SERVER = {
    "id": "bridged-webapp",
    "cmd": "service nginx start && /usr/sbin/sshd -D",
    #"cmd": "service nginx start",
    "cpus": APP_CPU,
    "mem": 64.0,
    "instances": 2,
    "labels": {"avi_proxy": json.dumps(VS_CFG)},
    "container": {
        "type": "DOCKER",
        "docker": {
            "image": "avinetworks/server",
            "network": "BRIDGE",
            "portMappings": [
                {"containerPort": 80, "hostPort": 0, "servicePort": 0,
                 "protocol": "tcp"}
                ]
        }
    },
    "healthChecks": [
        {"protocol": "HTTP", "portIndex": 0, "path": "/",
         "gracePeriodSeconds": 10, "intervalSeconds": 20,
         "maxConsecutiveFailures": 3}
    ]
}


DEFAULT_CLIENT = {
    "id": "test-client",
    #"cmd": "service nginx start; service ssh start; sleep 30000000",
    "cmd": "service nginx start && /usr/sbin/sshd -D",
    "cpus": APP_CPU,
    "mem": 64.0,
    "instances": 1,
    "labels": {"avi_proxy": json.dumps(VS_CFG)},
    "container": {
        "type": "DOCKER",
        "docker": {
            "image": "avinetworks/server",
            "network": "BRIDGE",
            "portMappings": [
                {"containerPort": 80, "hostPort": 0, "servicePort": 19994,
                 "protocol": "tcp"}
                ]
        }
    },
    "healthChecks": [
        {"protocol": "HTTP", "portIndex": 0, "path": "/",
         "gracePeriodSeconds": 5, "intervalSeconds": 20,
         "maxConsecutiveFailures": 3}
    ]
}


class MesosTestUtils(object):
    '''
    Utilities for the marathon App. currently it implements
    1. Creation
    2. Deletion
    '''
    MARATHON_HDRS = {'Content-Type': 'application/json', "Accept": "application/json"}
    MARATHON_APP_TEMPLATES = {
        'default': DEFAULT_APP,
        'floating': DEFAULT_APP,
        'test-client': DEFAULT_CLIENT,
        'avi-server': AVI_SERVER}
    DOCKER_REGISTRY = '10.128.7.253'

    def __init__(self):
        pass

    def mesosCloudObj(self, marathon_ip, fleet_endpoint, sefolder, ew_subnet):
        mesos_confg_obj = {
            "mesos_url": "http://%s:5050" % marathon_ip,
            "se_volume": "/opt/avi",
            # "disable_se_repository_push": false,
            "use_bridge_ip_as_vip": True,
            # "use_marathon_se_deployment": false,
            # "disable_auto_frontend_service_sync": false,
            # "disable_auto_backend_service_sync": false,
            # "feproxy_bridge_name": "cbr1",
            'marathon_configurations': [
                {"marathon_url": "http://%s:8080" % marathon_ip}],
            # "container_port_match_http_service": true,
            "fleet_endpoint": "http://%s:4444" % fleet_endpoint,
            "docker_registry_se": {
                "registry": "%s:5000/%s" % (self.DOCKER_REGISTRY, sefolder)},
            "east_west_placement_subnet": {"ip_addr": {
                                            "type": "V4",
                                            "addr": ew_subnet},
                                           "mask": 24},
            "use_container_ip_port": True
            # "prefer_static_routes": false,
            # "mtu": 1500, "apic_mode": false,
            # "enable_vip_static_routes": false
        }
        return mesos_confg_obj

    def createApp(self, marathon_url, app_type, app_name, num_apps,
                  num_instances=None, northsouth=0, vips=None,
                  virtualservice=None, pool=None,
                  auth_type=None, auth_token=None, username=None, password=None,
                  ns_service_port=None, ew_service_port_start_index=None,
                  num_service_ports=1, constraints=None,
                  cpus=None, mem=None, tenant=None, no_healthcheck=False):
        if virtualservice is None:
            virtualservice = {}
        if pool is None:
            pool = {}

        marathon_uri = marathon_url + '/v2/apps'
        app_ids = []
        print('type', app_type, 'name', app_name, 'instances', num_instances)
        print('service_port count', num_service_ports, 'ns', northsouth, 'vip', vips)
        for index in range(num_apps):
            app_id = (app_name + '-' + str(index + 1)
                      if num_apps > 1 else app_name)
            app_obj = self.MARATHON_APP_TEMPLATES[app_type]
            app_obj = deepcopy(app_obj)

            if no_healthcheck:
                app_obj.pop('healthChecks')

            if num_instances:
                if num_instances < 0:
                    app_obj['instances'] = index % 3 + 1
                else:
                    app_obj['instances'] = num_instances
            elif num_instances == 0:
                app_obj['instances'] = 0
            # else None: not set so use the default

            if cpus:
                app_obj['cpus'] = cpus
            if mem:
                app_obj['mem'] = mem
            app_obj['id'] = app_id
            app_ids.append(app_id)
            avi_proxy_json = app_obj['labels']['avi_proxy']
            print(' proxy json-', avi_proxy_json)
            avi_proxy = json.loads(avi_proxy_json)
            if tenant:
                avi_proxy['tenant'] = tenant
            if virtualservice:
                if 'virtualservice' not in avi_proxy:
                    avi_proxy['virtualservice'] = virtualservice
                else:
                    for k, v in virtualservice.items():
                        avi_proxy['virtualservice'][k] = v
            if northsouth and vips and (index % math.ceil(float(num_apps)/northsouth) == 0):
                app_obj['labels']['FE-Proxy'] = 'Yes'
                if app_type == 'floating':
                    avi_proxy['virtualservice']['auto_allocate_floating_ip'] = True
                    avi_proxy['virtualservice']['auto_allocate_ip'] = True
                else:
                    ns_index = int(index / (num_apps/northsouth))
                    app_obj['labels']['FE-Proxy-VIP'] = vips[ns_index]
                # add services same as service port
                avi_proxy['virtualservice']['services'] = \
                    [{'port': int(ns_service_port)}]
            if pool:
                if 'pool' not in avi_proxy:
                    avi_proxy['pool'] = pool
                else:
                    for k, v in pool.items():
                        avi_proxy['pool'][k] = v
            app_obj['labels']['avi_proxy'] = json.dumps(avi_proxy)

            port_mapping_template = {'containerPort': 80, 'hostPort': 0, 'servicePort': 0, 'protocol': 'tcp'}
            for service_port_counter in range(num_service_ports):
                if service_port_counter > 0:
                    port_mapping = deepcopy(port_mapping_template)
                    app_obj['container']['docker']['portMappings'].append(port_mapping)
                #if service_port and not northsouth:
                if ew_service_port_start_index and not app_obj['labels'].get('FE-Proxy'):
                    app_obj['container']['docker']['portMappings'][service_port_counter]['servicePort'] = \
                        int(ew_service_port_start_index) + (index*num_service_ports) + service_port_counter

            if constraints:
                app_obj['constraints'] = []
                for constraint in constraints:
                    app_obj['constraints'].append(constraint)
                print('constraints:', app_obj['constraints'])

            headers = self.MARATHON_HDRS
            auth = None
            if auth_type == 'token':
                headers.update({'Authorization': 'token=%s'%str(auth_token)})
            elif auth_type == 'basic':
                auth=HTTPBasicAuth(username, password)
            rsp = requests.post(marathon_uri, data=json.dumps(app_obj),
                                auth = auth, headers=headers)
            if rsp.status_code == 409:
                print('got response %s, retrying with force=true' %rsp.text)
                marathon_uri = marathon_uri + '?force=true'
                rsp = requests.post(marathon_uri, data=json.dumps(app_obj),
                                    auth = auth, headers=headers)
            if rsp.status_code >= 300:
                raise RuntimeError('failed to create app %s; got response code %s: %s' %(app_id, str(rsp.status_code), rsp.text))
            print('created app', app_id, app_obj, ' response ', rsp.text)
        return app_ids

    def getInfo(self, marathon_uri, auth_type=None, auth_token=None, username=None, password=None):
        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        rsp = requests.get(marathon_uri, auth=auth, headers=headers)
        if rsp.status_code >= 300:
            raise RuntimeError('failed to get ' + marathon_uri + ', got response code' + str(rsp.status_code) + ': '+ rsp.text)
        print('response: ', rsp.text)
        info = json.loads(rsp.text) if rsp.text else {}
        log.debug('info %s', info)
        return info

    def getAppInfo(self, marathon_url, app_id,
                   auth_type=None, auth_token=None, username=None, password=None):
        marathon_uri = marathon_url + '/v2/apps'
        marathon_uri += '/' + app_id

        return self.getInfo(marathon_uri, auth_type=auth_type, auth_token=auth_token, username=username, password=password)

    def getAppInfos(self, marathon_url,
                    auth_type=None, auth_token=None, username=None, password=None):
        marathon_uri = marathon_url + '/v2/apps'

        return self.getInfo(marathon_uri, auth_type=auth_type, auth_token=auth_token, username=username, password=password)

    def updateAppConfig(self, marathon_url, app_id,
                        auth_type=None, auth_token=None, username=None, password=None,
                        **kwargs):
        app_obj = self.getAppInfo(marathon_url, app_id, auth_type, auth_token, username, password)
        app_obj = app_obj['app']
        # see https://github.com/mesosphere/marathon/issues/3054
        # could also do it on uri to be forwards compatible rather than backwards
        app_obj.pop('fetch', None)

        for k, v in kwargs.items():
            app_obj[k] = v
        del app_obj['version']

        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        marathon_uri = marathon_url + '/v2/apps/' + app_id + '?force=true'
        rsp = requests.put(marathon_uri, data=json.dumps(app_obj),
                           auth=auth, headers=headers)
        if rsp.status_code >= 300:
            raise RuntimeError('failed to update app config, got response code' + str(rsp.status_code) + ': '+ rsp.text)
        print('updated app', app_id, ' response ', rsp.text)
        return rsp

    def updateAviProxy(self, marathon_url, app_id, avi_proxy,
                       auth_type=None, auth_token=None, username=None, password=None):
        app_obj = self.getAppInfo(marathon_url, app_id, auth_type, auth_token, username, password)
        app_obj = app_obj['app']
        # see https://github.com/mesosphere/marathon/issues/3054
        # could also do it on uri to be forwards compatible rather than backwards
        app_obj.pop('fetch', None)

        app_obj['labels']['avi_proxy'] = json.dumps(avi_proxy)
        del app_obj['version']

        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        marathon_uri = marathon_url + '/v2/apps/' + app_id + '?force=true'
        rsp = requests.put(marathon_uri, data=json.dumps(app_obj),
                           auth=auth, headers=headers)
        if rsp.status_code >= 300:
            raise RuntimeError('failed to update app avi proxy, got response code' + str(rsp.status_code) + ': '+ rsp.text)
        print('updated app', app_id, ' response ', rsp.text)
        return rsp

    def updateApp(self, marathon_url, app_id, vs_obj=None,
                  auth_type=None, auth_token=None, username=None, password=None,
                  avi_version=None, **kwargs):
        app_obj = self.getAppInfo(marathon_url, app_id, auth_type, auth_token, username, password)
        app_obj = app_obj['app']
        # see https://github.com/mesosphere/marathon/issues/3054
        # could also do it on uri to be forwards compatible rather than backwards
        app_obj.pop('fetch', None)

        avi_proxy = json.loads(app_obj['labels']['avi_proxy'])
        if not vs_obj:
            vs_cfg = avi_proxy.get('virtualservice')
        else:
            vs_cfg = vs_obj
        for k, v in kwargs.items():
            vs_cfg[k] = v

        if not 'labels' in app_obj:
            app_obj['labels'] = {}

        if avi_version:
            avi_proxy['version'] = avi_version
        avi_proxy['virtualservice'] = vs_cfg
        app_obj['labels']['avi_proxy']= json.dumps(avi_proxy)
        del app_obj['version']

        marathon_uri = marathon_url + '/v2/apps/' + app_id + '?force=true'
        log.info('uri %s app %s', marathon_uri, app_obj)

        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        rsp = requests.put(marathon_uri, data=json.dumps(app_obj),
                           auth=auth, headers=headers)
        if rsp.status_code >= 300:
            raise RuntimeError('failed to update app, got response code' + str(rsp.status_code) + ': '+ rsp.text)
        print('updated app', app_id, ' response ', rsp.text)
        return app_obj

    def restartApp(self, marathon_url, app_id,
                   auth_type=None, auth_token=None, username=None, password=None):
        marathon_uri = marathon_url + '/v2/apps/' + app_id + '/restart'
        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        rsp = requests.post(marathon_uri, auth=auth, headers=headers)
        if rsp.status_code >= 300:
            raise RuntimeError('failed to restart app, got response code' + str(rsp.status_code) + ': '+ rsp.text)
        print('restarted app', app_id, ' rsp ', rsp.text)

    def deleteApp(self, marathon_url, app_name, num_apps,
                  auth_type=None, auth_token=None, username=None, password=None):
        app_ids = []
        base_marathon_uri = marathon_url + '/v2/apps'
        headers = self.MARATHON_HDRS
        auth = None
        if auth_type == 'token':
            headers.update({'Authorization': 'token=%s'%str(auth_token)})
        elif auth_type == 'basic':
            auth=HTTPBasicAuth(username, password)
        for index in range(num_apps):
            app_id = (app_name + '-' + str(index + 1)
                      if num_apps > 1 else app_name)
            marathon_uri = base_marathon_uri + '/' + app_id
            rsp = requests.delete(marathon_uri, auth=auth, headers=headers)
            if (rsp.status_code != 404) and (rsp.status_code >= 300):
                raise RuntimeError(
                    'failed to delete app, got response code %d:%s' %
                    (rsp.status_code, rsp.text))
            print(' deleted app', app_id, ' rsp ', rsp.text)
            app_ids.append(app_id)
        return app_ids

    def updateMesosCloud(self, api, marathon_ip, fleet_endpoint,
                         sefolder, ew_subnet):
        '''
        @param api
        '''
        cloud_data = api.get_object_by_name('cloud', 'Default-Cloud')
        print('current cloud', cloud_data)
        cloud_data['vtype'] = 'CLOUD_MESOS'
        cloud_data['mesos_configuration'] = \
            self.mesosCloudObj(marathon_ip, fleet_endpoint, sefolder,
                               ew_subnet)
        cloud_data = api.put('cloud/%s' % cloud_data['uuid'],
                                    data=json.dumps(cloud_data))
        print('updated cloud', cloud_data)

if __name__ == '__main__':
    mapp_utils = MesosTestUtils()
    parser = argparse.ArgumentParser()
    parser.add_argument('-c', '--command',
                        choices=['create-app', 'delete-app', 'update-cloud',
                                 'show-app', 'show-apps'],
                        help='lastest timestamp',
                        default='create-app')
    parser.add_argument('-a', '--app_name', help='Application Name',
                        default='bridged-webapp')
    parser.add_argument('-n', '--num_apps',
                        help='Number of Applications',
                        default=1, type=int)
    parser.add_argument('-m', '--marathon_url',
                        help='address of the marathon service')
    parser.add_argument('-f', '--fleet_endpoint_ip',
                        help='IP address of the fleet')
    parser.add_argument('-s', '--se_folder',
                        help='SE folder for registry')
    parser.add_argument('-e', '--east_west_subnet',
                        help='east west subnet. It assumes mask 24')
    parser.add_argument('-t', '--app_type',
                        help='type of app: ' + str(list(mapp_utils.MARATHON_APP_TEMPLATES.keys())),
                        default='default')
    parser.add_argument('-r', '--controller_ip', help='controller_ip',
                        default='127.0.0.1')
    parser.add_argument('-i', '--instances',
                        help='number of instances of server',
                        default=2, type=int)
    parser.add_argument('--northsouth', help='north south app',
                        default=False, type=bool)
    parser.add_argument('--vip', help='north south app',
                        default='')
    parser.add_argument('--autoscalepolicy', help='enable autoscale policy to app',
                        default='')
    parser.add_argument('--service_port', help='service port for app',
                        default=0, type=int)
    args = parser.parse_args()

    print('parsed args', args)

    if args.command == 'create-app':
        if not args.marathon_url:
            raise Exception('marathon IP is required')
        pool = None
        if args.autoscalepolicy:
            pool = {}
            pool['lb_algorithm']='LB_ALGORITHM_FEWEST_SERVERS'
            pool['autoscale_policy_ref']=\
                '/api/serverautoscalepolicy?name=%s'%args.autoscalepolicy
            pool['autoscale_launch_config_ref']=\
                '/api/autoscalelaunchconfig?name=default-autoscalelaunchconfig'
            pool['capacity_estimation'] = True
            pool['capacity_estimation_ttfb_thresh'] = 10

        mapp_utils.createApp(args.marathon_url, args.app_type,
                             args.app_name, args.num_apps, args.instances,
                             northsouth=args.northsouth,
                             vips=args.vip.split(','), pool=pool)
    elif args.command == 'delete-app':
        if not args.marathon_url:
            raise Exception('marathon URL is required')
        mapp_utils.deleteApp(args.marathon_url, args.app_name, args.num_apps)
    elif args.command == 'update-cloud':
        api = ApiSession.get_session(args.controller_ip, 'admin', 'avi123', tenant='admin')
        mapp_utils.updateMesosCloud(api, args.marathon_url,
                                    args.fleet_endpoint_ip,
                                    args.se_folder, args.east_west_subnet)
    elif args.command == 'show-app':
        if not args.marathon_url:
            raise Exception('marathon URL is required')
        app_info = mapp_utils.getAppInfo(args.marathon_url, args.app_name)
        print(app_info)
    elif args.command == 'show-apps':
        if not args.marathon_url:
            raise Exception('marathon URL is required')
        app_infos = mapp_utils.getAppInfos(args.marathon_url)
        print(app_infos)

