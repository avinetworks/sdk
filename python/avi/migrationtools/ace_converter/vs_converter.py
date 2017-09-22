""" VsVip and VS Conversion Goes here """
import logging
from avi.migrationtools.ace_converter.ace_utils import update_excel

#logging init
LOG = logging.getLogger(__name__)

class VSConverter(object):
    """ Vsvip and Vs Conversion """
    def __init__(self, parsed, tenant_ref, common_utils):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils

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
                            LOG.warning('Skipping Sticky Serverfarm %s' % name)
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
