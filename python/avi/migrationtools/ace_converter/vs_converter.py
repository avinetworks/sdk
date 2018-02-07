""" VsVip and VS Conversion Goes here """
import logging
from copy import deepcopy
from avi.migrationtools.ace_converter.ace_utils import update_excel

# logging init
LOG = logging.getLogger(__name__)
USED_POOLS = list()
PORT_END = 65535


class VSConverter(object):
    """ Vsvip and Vs Conversion """

    def __init__(self, parsed, tenant_ref, common_utils, enable_vs, cloud_ref, tenant, vrf_ref):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.enable_vs = enable_vs
        self.cloud_ref = cloud_ref
        self.tenant = tenant
        self.vrf_ref = vrf_ref
        self.http_policy_set = []
        self.data = ''

    def create_redirect_http_policy(self, name, data):
        real_name = name
        name = "%s-httppolicyset" % name

        if data.get('code') not in ['301', '302', '307']:
            code = 'HTTP_REDIRECT_STATUS_CODE_301'
        else:
            code = 'HTTP_REDIRECT_STATUS_CODE_%s' % data.get('code')

        if data.get('location'):
            url = data.get('location')
            protocol = url.split('/')[0].replace(':', '')
            host = url.split('/')[2]
            path = '/'.join(url.split('/')[3:])
            protocol = 'HTTP'
            port = 80
            if protocol == 'https':
                protocol = 'HTTPS'
                port = 443
        httppolicyset = {
            "http_security_policy": [],
            "http_request_policy": {
                "rules": [
                    {
                        "redirect_action": {
                            "protocol": protocol,
                            "status_code": "HTTP_REDIRECT_STATUS_CODE_301",
                            "host": {
                                "tokens": [
                                    {
                                        "str_value": host,
                                        "type": "URI_TOKEN_TYPE_STRING"
                                    }
                                ],
                                "type": "URI_PARAM_TYPE_TOKENIZED"
                            },
                            "path": {
                                "tokens": [
                                    {
                                        "str_value": path,
                                        "type": "URI_TOKEN_TYPE_STRING"
                                    }
                                ],
                                "type": "URI_PARAM_TYPE_TOKENIZED"
                            },
                            "port": port
                        },
                        "enable": True,
                        "name": 'rule1'
                    }
                ]
            },
            "name": name,
        }
        update_excel('action-list', real_name, avi_obj=httppolicyset)
        return httppolicyset

    def create_http_policy(self, action, name):
        type = None
        httppolicyset = {}
        real_name = name
        name = "%s-httppolicyset" % name
        for action_list in self.parsed['action-list']:
            if action == action_list['action-list']:
                for desc in action_list['desc']:
                    if 'ssl' in desc.keys():
                        type = 'ssl'
                    if 'header' in desc.keys():
                        type = 'header'
        if type == 'ssl':
            httppolicyset = {
                "http_security_policy": [],
                "http_request_policy": {
                    "rules": [
                        {
                            "redirect_action": {
                                "keep_query": True,
                                "status_code": "HTTP_REDIRECT_STATUS_CODE_302",
                                "protocol": "HTTPS",
                                "port": 443
                            },
                            "is_internal_policy": False,
                            "name": "rule1"
                        }
                    ]
                },
                "name": name
            }
        update_excel('action-list', real_name, avi_obj=httppolicyset)
        return httppolicyset

    def check_persistance(self, pool_name, data, l4_type=None):
        for index, pool in enumerate(data['Pool']):
            if pool['name'] == pool_name and (pool.get('application_persistence_profile_ref', '') or l4_type):
                if l4_type:
                    ref_name = pool.get(
                        'application_persistence_profile_ref', '').split(
                        '=')[-1]
                    for app_name in data['ApplicationPersistenceProfile']:
                        if app_name.get('name') == ref_name:
                            if app_name.get('persistence_type') != 'PERSISTENCE_TYPE_CLIENT_IP_ADDRESS':
                                data['Pool'][index]['application_persistence_profile_ref'] = ''
                                LOG.warning("Removing persistance in Pool because of l4 type"
                                            "cannot other than client based ip address persistance")
                return True
        return False

    def clone_pool(self, vs_name, pool_name, data):
        for pool in data['Pool']:
            if pool['name'] == pool_name:
                cloned_pool = deepcopy(pool)
                cloned_pool['name'] = "%s_cloned_%s" % (pool_name, vs_name)
                if cloned_pool.get('application_persistence_profile_ref'):
                    del cloned_pool['application_persistence_profile_ref']
                return cloned_pool
        return False

    def virtual_service_conversion_policy(self, name, data, ssl_profile=None, ssl_cert=None):
        global USED_POOLS
        port = None
        vs_ref = None
        port_end = None
        l4_type = None
        http_policy_ref = None
        http_policy_set = None
        msg = ''
        for policy_map in self.parsed['policy-map']:
            pool_obj = dict()
            temp_vs = dict()
            if policy_map.get('name') == name:
                name = policy_map['name']
                pool = None
                original_pool_name = None
                pool_ref = None
                action = None
                vs_ref, port, ip, l4_type = self.get_vsref_and_port_from_class(
                    name)
                if not vs_ref or port is None or not ip:
                    msg = 'No vsvip, ip-port for policy-map {}'.format(name)
                    continue
                # Excel Sheet Update for class
                update_excel('class-map', name,
                             avi_obj="Refer Policy-map {}".format(name))

                enable_ssl = (True if port == '443' else False)
                for class_dec in policy_map['desc']:
                    for vsobj in class_dec['class_desc']:
                        if 'action' in vsobj.keys():
                            action = vsobj['action']
                        if 'sticky-serverfarm' in vsobj.keys() or\
                                'serverfarm' in vsobj.keys():
                            if 'sticky-serverfarm' in vsobj.keys():
                                stick_farm = vsobj['sticky-serverfarm']
                                for farm in self.parsed['sticky']:
                                    for farm_desc in farm['desc']:
                                        if farm_desc.get('serverfarm'):
                                            pool = farm_desc['serverfarm']
                                            break
                            if 'serverfarm' in vsobj.keys():
                                pool = vsobj['serverfarm']
                                original_pool_name = pool
                            flag = 0
                            for pool_set in self.data['Pool']:
                                if pool_set['name'] == original_pool_name:
                                    flag = 1
                            if flag == 0:
                                pool = ''
                            # if pool is already used do clone the pool and
                            # having persistance profile
                            if self.check_persistance(pool, data, l4_type):
                                if pool in USED_POOLS:
                                    if self.clone_pool(name, pool, data):
                                        pool_obj = self.clone_pool(
                                            name, pool, data)
                                        pool = pool_obj['name']
                                USED_POOLS.append(pool)

                            update_excel('class-map',
                                         pool,
                                         avi_obj="Refer "
                                                 "Class Map : {}".format(name))

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
                            if pool != '':
                                pool_ref = self.common_utils.get_object_ref(
                                    pool, 'pool', tenant=self.tenant)
                if not pool:
                    msg = 'No Pool configured for VS {}'.format(name)
                    # continue
                if action:
                    http_policy_set = self.create_http_policy(action, name)
                    http_policy_ref = self.common_utils.get_object_ref(object_name=http_policy_set['name'],
                                                                       object_type='httppolicyset', tenant=self.tenant)
                else:
                    for sfarm in self.parsed.get('serverfarm'):
                        if sfarm['host'] == original_pool_name:
                            for pools in sfarm['desc']:
                                temp_pool_name = pools.get('rserver', [])
                                for servers in self.parsed.get('rserver', []):
                                    if servers.get('host', []) == temp_pool_name:
                                        if len(servers) > 0 and len(servers['desc']) > 0 and \
                                                "code" in servers.get('desc', [])[0].keys():
                                            http_policy_set = self.create_redirect_http_policy(
                                                original_pool_name, servers['desc'][0])
                                            http_policy_ref = self.common_utils.get_object_ref(object_name=http_policy_set['name'],
                                                                                               object_type='httppolicyset', tenant=self.tenant)

                temp_vs = {
                    "vsvip_ref": vs_ref,
                    "enabled": False,
                    "vs_datascripts": [],
                    "vip": vip,
                    "services": [{
                        "enable_ssl": enable_ssl,
                        "port": port,
                    }],
                    "description": None,
                    "name": name,
                    "cloud_ref": self.cloud_ref,
                    "tenant_ref": self.tenant_ref,
                    "type": "VS_TYPE_NORMAL"
                }
                if pool_ref:
                    temp_vs['pool_ref'] = pool_ref
                if l4_type:
                    app_ref = self.common_utils.get_object_ref(
                        'System-L4-Application', 'applicationprofile', tenant='admin')
                    nw_ref = None
                    if l4_type == 'tcp':
                        nw_ref = self.common_utils.get_object_ref(
                            'System-TCP-Proxy', 'networkprofile', tenant='admin')
                    elif l4_type == 'udp':
                        nw_ref = self.common_utils.get_object_ref(
                            'System-UDP-Fast-Path', 'networkprofile', tenant='admin')
                    temp_vs['application_profile_ref'] = app_ref
                    temp_vs['network_profile_ref'] = nw_ref
                if ssl_profile:
                    temp_vs['ssl_profile_ref'] = ssl_profile
                if ssl_cert:
                    temp_vs['ssl_key_and_certificate_refs'] = [ssl_cert]
                if self.vrf_ref:
                    temp_vs['vrf_context_ref'] = self.vrf_ref
                if http_policy_ref:
                    temp_vs['http_policy_set_ref'] = http_policy_ref
                return temp_vs, pool_obj, http_policy_set, msg
        return False, False, False, msg

    def vsvip_conversion(self):
        """vs vip take from virutal-server in class map"""
        vip_id = '0'
        vip_list = list()
        vip_obj_list = list()

        # get the number of vips available
        for class_map in self.parsed.get('class-map', ''):
            if 'match-all' not in class_map.values():
                LOG.warning('This type of class map not supported : %s' %
                            class_map['class-map'])
                update_excel(
                    'class-map', class_map['class-map'], status='Skipped', avi_obj='This type of class map not supported')
                continue
            for address in class_map['desc']:
                if "source-address" in address or "destination-address" in address:
                    LOG.warning(
                        'source-address or destination-address in class map not supported :%s' % class_map['class-map'])
                    update_excel('class-map', class_map['class-map'], status='Skipped',
                                 avi_obj='source-address or destination-address in class map not supported')
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
                    "cloud_ref": self.cloud_ref,
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
        return vip_obj_list

    def get_vsref_and_port_from_class(self, class_name):
        vs_ref = None
        port = None
        vs_ip = None
        port_end = None
        l4_type = None
        lb_policy = None

        for policy in self.parsed['policy-map']:
            if policy.get('match') == 'multi-match':
                for multi in policy['desc']:
                    for classdesc in multi['class_desc']:
                        if classdesc.get('loadbalance') == 'policy' and \
                                classdesc.get('type') == class_name:
                            lb_policy = multi['class']

        if lb_policy:
            for class_map in self.parsed['class-map']:
                if 'match' in class_map['type'] and class_map[
                        'class-map'] == lb_policy and class_map['desc']:
                    port = class_map['desc'][0].get(
                        'tcp', class_map['desc'][0].get('udp', ''))
                    if 'tcp' in class_map['desc'][0].keys():
                        l4_type = 'tcp'
                    if 'udp' in class_map['desc'][0].keys():
                        l4_type = 'udp'
                    if port == 'www':
                        port = 80
                    if port == 'https':
                        port = 443
                    vs_ip = class_map['desc'][0].get('virtual-address', [])
                    if vs_ip:
                        vs_ip_temp = '{}-vip'.format(vs_ip)
                        vs_ref = self.common_utils.get_object_ref(vs_ip_temp,
                                                                  'vsvip',
                                                                  tenant=self.tenant)
        return vs_ref, port, vs_ip, l4_type

    def virtual_service_conversion(self, data):
        self.data = data
        vs_list = list()
        cloned_pool_list = list()
        http_list = list()

        for policy_map in self.parsed.get('policy-map', ''):
            if policy_map.get('match', '') == 'multi-match':
                update_excel(
                    'policy-map', policy_map['policy-map'], status='Indirect')
                for cls in policy_map['desc']:
                    if cls.get('class', []):
                        policy_name = None
                        ssl = []
                        ssl_cert = []
                        for obj in cls['class_desc']:
                            if obj.get('loadbalance', '') == 'policy':
                                policy_name = obj['type']
                            ssl_ref = [obj['type'] for ssl1 in data['SSLProfile'] if ssl1.get(
                                'name') == obj.get('type') and "ssl-proxy" in obj.keys()]
                            if ssl_ref:
                                ssl = self.common_utils.get_object_ref(ssl_ref[0],
                                                                       'sslprofile',
                                                                       tenant=self.tenant)
                                ssl_cert = self.common_utils.get_object_ref(ssl_ref[0],
                                                                            'sslkeyandcertificate',
                                                                            tenant=self.tenant)
                        if policy_name:
                            vs, cloned_pool, http_policy_set, msg = \
                                self.virtual_service_conversion_policy(
                                    policy_name, data, ssl_profile=ssl,
                                    ssl_cert=ssl_cert)
                            if vs:
                                vs['enabled'] = False
                                for class_dec in cls['class_desc']:
                                    if "loadbalance" in class_dec.keys():
                                        if class_dec.get('type', []) == 'inservice' and\
                                           self.enable_vs:
                                            vs['enabled'] = True

                                # updating excel sheet
                                update_excel(
                                    'policy-map', vs['name'], avi_obj=vs)

                                # updating object
                                vs_list.append(vs)
                                self.port_fix(vs_list)
                                if cloned_pool:
                                    cloned_pool_list.append(cloned_pool)
                                if http_policy_set:
                                    http_list.append(http_policy_set)
                            else:
                                update_excel('policy-map', cls['class'],
                                             status='Skipped', avi_obj=msg)
                        else:
                            update_excel(
                                'policy-map', cls['class'], status='Skipped', avi_obj='Policy is not in policy\'s class map')
        return vs_list, cloned_pool_list, http_list

    def port_fix(self, vs_list):
        vs_list = vs_list
        min_port = 1
        max_port = 65535
        for index, vs in enumerate(vs_list):
            if vs['services'][0]['port'] == 'any':
                name = vs['name']
                addr = vs['vip'][0]['ip_address']['addr']
                port_list = list()
                for vs1 in vs_list:
                    if name <> vs1['name']:
                        port_list.append(int(vs1['services'][0]['port']))

                port_list = list(set(port_list))
                port_list.sort()
                start = min_port
                # end = max_port
                services_obj = list()
                if max_port not in port_list:
                    port_list.append(max_port + 1)
                for i in range(len(port_list)):
                    if start == port_list[i]:
                        start += 1
                        continue
                    end = int(port_list[i]) - 1
                    services_obj.append({'port': start,
                                         'port_range_end': end,
                                         'enable_ssl': False})
                    start = int(port_list[i]) + 1
                vs_list[index]['services'] = services_obj
        return vs_list
