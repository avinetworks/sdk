""" VsVip and VS Conversion Goes here """
import logging
from copy import deepcopy
from avi.migrationtools.ace_converter.ace_utils import update_excel

#logging init
LOG = logging.getLogger(__name__)
USED_POOLS = list()
PORT_END = 65535

class VSConverter(object):
    """ Vsvip and Vs Conversion """
    def __init__(self, parsed, tenant_ref, common_utils, enable_vs):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.enable_vs = enable_vs
    
    def check_persistance(self, pool_name, data):
        for pool in data['Pool']:
            if pool['name'] == pool_name:
                if pool.get('application_persistence_profile_ref', ''):
                    return True
        return False

    def clone_pool(self, vs_name, pool_name, data):
        for pool in data['Pool']:
            if pool['name'] == pool_name:
                cloned_pool = deepcopy(pool)
                cloned_pool['name'] = "%s_cloned_%s" % (pool_name, vs_name)
                # if cloned_pool['name'] not in USED_POOLS:
                return cloned_pool
        return False

    def virtual_service_conversion_policy(self, name, data, ssl_profile=None, ssl_cert=None):
        cloud_ref = self.common_utils.get_object_ref('Default-Cloud', 'cloud')
        global USED_POOLS
        port = None
        vs_ref = None
        port_end =None
        for policy_map in self.parsed['policy-map']:
            pool_obj = dict()
            temp_vs = dict()
            if policy_map.get('name') == name:
                name = policy_map['name']
                pool = None
                pool_ref = None
                vs_ref, port, ip = self.get_vsref_and_port_from_class(name)
                if not vs_ref or  port is None or not ip:
                    continue
                # Excel Sheet Update for class
                update_excel('class-map', name, avi_obj="Refer Policy-map {}".format(name))

                enable_ssl = (True if port == '443' else False)
                for class_dec in policy_map['desc']:
                    for vsobj in class_dec['class_desc']:
                        if 'sticky-serverfarm' in vsobj.keys():
                            LOG.warning('Skipping Sticky Serverfarm %s' % name)
                            return False, False
                        if 'serverfarm' in vsobj.keys():
                            pool = vsobj['serverfarm']

                            # if pool is already used do clone the pool and 
                            # having persistance profile
                            if self.check_persistance(pool, data):
                                if pool in USED_POOLS: # pool1
                                    if self.clone_pool(name, pool, data):
                                        pool_obj = self.clone_pool(name, pool, data)
                                        pool = pool_obj['name'] # pool_merged_pf
                                USED_POOLS.append(pool)
                                # else:
                                #     USED_POOLS.append(pool)

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
                            "port": port,
                        }],
                        "pool_ref": pool_ref,
                        "description": None,
                        "name": name,
                        "cloud_ref": cloud_ref,
                        "tenant_ref": self.tenant_ref,
                        "type": "VS_TYPE_NORMAL"
                    }
                # if port_end:
                #     temp_vs['services'][0]['port_range_end'] = 65535
                if ssl_profile:
                    temp_vs['ssl_profile_ref'] = ssl_profile
                if ssl_cert:
                    temp_vs['ssl_key_and_certificate_refs'] = [ ssl_cert ]
                return temp_vs, pool_obj
        return False, False


    def vsvip_conversion(self):
        """vs vip take from virutal-server in class map"""
        cloud_ref = "/api/cloud/?tenant=admin&name=Default-Cloud"
        vip_id = '0'
        vip_list = list()
        vip_obj_list = list()

        # get the number of vips available
        for class_map in self.parsed.get('class-map', ''):
            if 'match-all' not in class_map.values():
                LOG.warning('This type of class map not supported : %s' % class_map['class-map'])
                update_excel('class-map', class_map['class-map'], status='Skipped', avi_obj='This type of class map not supported')
                continue
            for address in class_map['desc']:
                if "source-address" in address or "destination-address" in address:
                    LOG.warning('source-address or destination-address in class map not supported :%s' % class_map['class-map'])
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
        return vip_obj_list

    def get_vsref_and_port_from_class(self, class_name):
        vs_ref = None
        port = None
        vs_ip = None
        port_end = None
        for class_map in self.parsed['class-map']:
            if 'match' in class_map['type'] and class_map['class-map'] == class_name:
                port = class_map['desc'][0].get('tcp', class_map['desc'][0].get('udp', ''))
                if port == 'www':
                    port = 80
                if port == 'https':
                    port = 443
                # if port == 'any':
                #     # port = 123
                #     port = 1
                #     port_end = 65535
                vs_ip = class_map['desc'][0].get('virtual-address', [])
                if vs_ip:
                    vs_ip_temp = '{}-vip'.format(vs_ip)
                    vs_ref = self.common_utils.get_object_ref(vs_ip_temp,
                                                              'vsvip')
        return vs_ref, port, vs_ip

    def virtual_service_conversion(self, data):
        vs_list = list()
        cloned_pool_list = list()

        for policy_map in self.parsed.get('policy-map', ''):
            if policy_map.get('match', '') == 'multi-match':
                update_excel('policy-map', policy_map['policy-map'], status='Indirect')
                for cls in policy_map['desc']:
                    if cls.get('class', []):
                        policy_name = None
                        ssl = []
                        ssl_cert = []
                        for obj in cls['class_desc']:
                            if obj.get('loadbalance', '') == 'policy':
                                policy_name = obj['type']
                            if obj.get('ssl-proxy', ''):
                                ssl = self.common_utils.get_object_ref(obj['type'],
                                                                       'sslprofile')
                                ssl_cert = self.common_utils.get_object_ref(obj['type'],
                                                                            'sslkeyandcertificate')
                        if policy_name:
                            vs, cloned_pool = self.virtual_service_conversion_policy(policy_name,
                                                                                     data,
                                                                                     ssl_profile=ssl,
                                                                                     ssl_cert=ssl_cert)
                            if vs:
                                vs['enabled'] = False
                                for class_dec in cls['class_desc']:
                                    if "loadbalance" in class_dec.keys():
                                        if class_dec.get('type', []) == 'inservice' and\
                                           self.enable_vs:
                                            vs['enabled'] = True 
                                               
                                # updating excel sheet
                                update_excel('policy-map', vs['name'], avi_obj=vs)

                                #updating object
                                vs_list.append(vs)
                                if cloned_pool:
                                    cloned_pool_list.append(cloned_pool)
                            else:
                                update_excel('policy-map', cls['class'], status='Skipped', avi_obj='Sticky-ServerFarm not allowed in Avi')
                        else:
                            update_excel('policy-map', cls['class'], status='Skipped', avi_obj='Policy is not in policy\'s class map')    
        self.port_fix(vs_list)
        return vs_list, cloned_pool_list

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
