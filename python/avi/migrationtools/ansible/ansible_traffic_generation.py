import json
from copy import deepcopy

import requests
from avi.migrationtools.ansible.ansible_constant import \
    (ENABLE_F5, DISABLE_F5, ENABLE_AVI, DISABLE_AVI, VIRTUALSERVICE, NAME, TAGS,
     AVI_VIRTUALSERVICE, TASKS, STATE, DISABLE, BIGIP_VS_SERVER, DELEGETE_TO,
     LOCAL_HOST, ENABLE, WHEN, RESULT, DISABLE_NETSCALER, NS_USERNAME,
     NS_PASSWORD, NS_HOST, NETSCALER_VS_STATUS, ARP_STATE,
     BIGIP_VIRTUAL_ADDRESS, TRAFFIC_ENABLE)


class TrafficGen(object):
    @classmethod
    def get_instance(cls, object_name, prefix, ns_vs_name_dict=None):
        """

        :param object_name: name of ADC
        :param prefix:
        :return:
        """
        if object_name == 'f5':
            return F5TrafficGen(prefix)
        elif object_name == 'netscaler':
            return NetscalerTrafficGen(prefix, ns_vs_name_dict=ns_vs_name_dict)

    def remove_prefix(self, vs_name):
        """
        This function used to remove prefix from name
        :param vs_name: name of virtualservice
        :return: virtualservice name
        """
        prefix = self.prefix + '-'
        if vs_name.startswith(prefix):
            return vs_name[len(prefix):]
        return vs_name

    def create_ansible_disable(self, vs_dict, ansible_dict):
        pass

    def create_avi_ansible_enable(self, vs_dict, ansible_dict, test_vip=None):
        """
        This function is used to enable the avi virtual service.
        :param vs_dict: avi virtualservice related parameters.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        avi_enable = deepcopy(vs_dict)
        avi_enable[TRAFFIC_ENABLE] = True
        avi_enable[ENABLE] = True
        vip = avi_enable.pop('vip')
        vip_ref = '/api/vsvip/?name=%s-vsvip' % vip[0]['ip_address']['addr']
        avi_enable['vsvip_ref'] = vip_ref
        name = "Enable Avi virtualservice: %s" % avi_enable[NAME]
        if test_vip:
            test_vip = test_vip.split('.')[:3]
            avi_enable['vip'][0]['ip_address']['addr'] =\
                '.'.join(test_vip + avi_enable['vip'][0]
                         ['ip_address']['addr'].split('.')[3:])
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_VIRTUALSERVICE: avi_enable,
                TAGS: [ENABLE_AVI, avi_enable[NAME], VIRTUALSERVICE]
            })

    def update_avi_ansible_vip(self, vs_dict, ansible_dict):
        """
        This function is used to disable the avi virtual service for test vips.
        :param vs_dict: avi virtualservice attributes.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        avi_enable = deepcopy(vs_dict)
        avi_enable[TRAFFIC_ENABLE] = False
        vip = avi_enable.pop('vip')
        vip_ref = '/api/vsvip/?name=%s-vsvip' % vip[0]['ip_address']['addr']
        avi_enable['vsvip_ref'] = vip_ref
        name = "Update Avi virtualservice vip: %s" % avi_enable[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_VIRTUALSERVICE: avi_enable,
                TAGS: [DISABLE_AVI, avi_enable[NAME], VIRTUALSERVICE]
            })

    def create_avi_ansible_disable(self, vs_dict, ansible_dict):
        """
        This function is used to disable the avi virtual service.
        :param vs_dict: avi virtualservice attributes.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        avi_enable = deepcopy(vs_dict)
        avi_enable[TRAFFIC_ENABLE] = False
        vip = avi_enable.pop('vip')
        vip_ref = '/api/vsvip/?name=%s-vsvip' % vip[0]['ip_address']['addr']
        avi_enable['vsvip_ref'] = vip_ref
        name = "Disable Avi virtualservice: %s" % avi_enable[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_VIRTUALSERVICE: avi_enable,
                TAGS: [DISABLE_AVI, avi_enable[NAME], VIRTUALSERVICE],
                WHEN: RESULT
            })

    def create_ansible_enable(self, vs_dict, ansible_dict):
        pass

    def get_status_vs(self, vs_name, vip, f5server, username, password,
                      ns_vs_name_dict=None, verify=False, partitions=[]):
        pass


class F5TrafficGen(TrafficGen):

    def __init__(self, prefix):
        """
        :param prefix:
        """
        self.prefix = prefix

    def create_ansible_disable(self, f5_dict, ansible_dict):
        """
        This function used to disabled f5 virtualservice.
        :param f5_dict: contains f5 related attributes.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        f5_disable = deepcopy(f5_dict)
        f5_disable[STATE] = DISABLE
        # Remove prefix from vs name of big ip.
        if self.prefix:
            f5_disable[NAME] = self.remove_prefix(f5_dict[NAME])
        name = "Disable F5 virtualservice: %s" % f5_disable[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                BIGIP_VS_SERVER: f5_disable,
                DELEGETE_TO: LOCAL_HOST,
                TAGS: [DISABLE_F5, f5_dict[NAME], VIRTUALSERVICE]
            })

    def create_virtual_address_disable(self, f5_dict, ansible_dict):
        f5_values = deepcopy(f5_dict)
        f5_values[STATE] = DISABLE
        f5_values[ARP_STATE] = DISABLE
        name = "Disable F5 virtualaddress: %s" % f5_values[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                BIGIP_VIRTUAL_ADDRESS: f5_values,
                DELEGETE_TO: LOCAL_HOST,
                TAGS: [DISABLE_F5, f5_dict[NAME], VIRTUALSERVICE]
            })

    def create_virtual_address_enable(self, f5_dict, ansible_dict):
        f5_values = deepcopy(f5_dict)
        f5_values[STATE] = ENABLE
        f5_values[ARP_STATE] = ENABLE
        name = "Enable F5 virtualaddress: %s" % f5_values[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                BIGIP_VIRTUAL_ADDRESS: f5_values,
                DELEGETE_TO: LOCAL_HOST,
                TAGS: [DISABLE_F5, f5_dict[NAME], VIRTUALSERVICE],
                WHEN: RESULT
            })

    def create_ansible_enable(self, f5_dict, ansible_dict):
        """
        This function is used to enable the f5 virtualservice.
        :param f5_dict: f5 attributes
        :param ansible_dict: used for playbook generation.
        :return: None
        """

        f5_values = deepcopy(f5_dict)
        f5_values[STATE] = ENABLE
        # Remove prefix from vs name of big ip.
        if self.prefix:
            f5_values[NAME] = self.remove_prefix(f5_dict[NAME])
        name = "Enable F5 virtualservice: %s" % f5_values[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                BIGIP_VS_SERVER: f5_values,
                DELEGETE_TO: LOCAL_HOST,
                TAGS: [ENABLE_F5, f5_dict[NAME], VIRTUALSERVICE],
                WHEN: RESULT
            })

    def get_status_vs(self, vs_name, vip, f5server, username, password,
                      tenant= None, ns_vs_name_dict=None, verify=False,
                      partitions=[]):
        """
        This function is used for getting status for F5 virtualservice.
        :param vs_name: virtualservice name
        :param f5server: f5 server
        :param username: f5 username
        :param password: f5 password
        :return: if enabled tag present.
        """

        global url
        if self.prefix:
            vs_name = self.remove_prefix(vs_name)
        if vip in partitions.keys():
            data = partitions.get(vip)
            url = 'https://%s/mgmt/tm/ltm/virtual/~%s~%s/' % (
            f5server, data['partition'],
            data['vs_name'])
        else:
            if tenant == 'admin':
                url = 'https://%s/mgmt/tm/ltm/virtual/%s/' % (f5server, vs_name)
            else:
                url = 'https://%s/mgmt/tm/ltm/virtual/~%s~%s/' % (
                    f5server, tenant, vs_name)
        status = requests.get(url, verify=verify, auth=(username, password))
        status = json.loads(status.content)
        if status.pop(ENABLE, None):
            return True


class NetscalerTrafficGen(TrafficGen):

    def __init__(self, prefix, ns_vs_name_dict=None):
        """
        :param prefix:
        """
        self.prefix = prefix
        self.ns_vs_name_dict = ns_vs_name_dict

    def get_ns_name(self, vs_name):
        if vs_name in self.ns_vs_name_dict['lbvs']:
            vs_name = self.ns_vs_name_dict['lbvs'][vs_name]
        elif vs_name in self.ns_vs_name_dict['csvs']:
            vs_name = self.ns_vs_name_dict['csvs'][vs_name]
        return vs_name

    def create_ansible_disable(self, vs_dict, ansible_dict):
        """

        :param f5_dict:
        :param ansible_dict:
        :return:
        """
        vs_name = self.get_ns_name(vs_dict[NAME])
        vs_dict = {
            'ns_username': NS_USERNAME,
            'ns_password': NS_PASSWORD,
            'vs_state': 'disable',
            'vs_name': vs_name,
            'vs_type': 'lbvs',
            'ns_host': NS_HOST
        }
        ansible_dict[TASKS].append(
            {

                NETSCALER_VS_STATUS: vs_dict,
                TAGS: [DISABLE_NETSCALER, vs_dict['vs_name'], VIRTUALSERVICE]
            }
        )

    def create_ansible_enable(self, vs_dict, ansible_dict):
        """

        :param f5_dict:
        :param ansible_dict:
        :return:
        """
        vs_name = self.get_ns_name(vs_dict[NAME])
        vs_dict = {
            'ns_username': NS_USERNAME,
            'ns_password': NS_PASSWORD,
            'vs_state': 'enable',
            'vs_name': vs_name,
            'vs_type': 'lbvs',
            'ns_host': NS_HOST
        }
        ansible_dict[TASKS].append(
            {
                NETSCALER_VS_STATUS: vs_dict,
                TAGS: [DISABLE_NETSCALER, vs_dict['vs_name'], VIRTUALSERVICE]
            }
        )

    def get_status_vs(self, vs_name, vip, f5server, username, password,
                      ns_vs_name_dict=None, verify=False, partitions=[]):
        """
                This function is used for getting status for F5 virtualservice.
                :param vs_name: virtualservice name
                :param f5server: f5 server
                :param username: f5 username
                :param password: f5 password
                :return: if enabled tag present.
                """
        if self.prefix:
            vs_name = self.remove_prefix(vs_name)

        if vs_name in self.ns_vs_name_dict['lbvs']:
            vs_name = self.ns_vs_name_dict['lbvs'][vs_name]
            api = 'http://%s/nitro/v1/config/lbvserver/%s' % (
                f5server, vs_name)
        elif vs_name in self.ns_vs_name_dict['csvs']:
            vs_name = self.ns_vs_name_dict['csvs'][vs_name]
            api = 'http://%s/nitro/v1/config/csvserver/%s' % (
                f5server, vs_name)
        status = requests.get(api, verify=verify, auth=(username, password))
        status = json.loads(status.content)
        if 'lbvserver' in status and status['lbvserver'][0]['curstate'] == 'UP':
            return True
        elif 'csvserver' in status and \
                status['csvserver'][0]['curstate'] == 'UP':
            return True
