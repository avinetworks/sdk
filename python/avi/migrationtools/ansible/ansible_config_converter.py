#!/usr/bin/env python
'''
Created on September 15, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
'''

import json
from copy import deepcopy

import logging
import yaml
import argparse
import re
import requests
#import avi.migrationtools.ansible.ansible_constant as ansible_constant
from avi.migrationtools.ansible.ansible_constant import \
    (USERNAME, PASSWORD ,HTTP_TYPE, SSL_TYPE,  DNS_TYPE, L4_TYPE,
     APPLICATION_PROFILE_REF, ENABLE_F5, DISABLE_F5, ENABLE_AVI, DISABLE_AVI,
     CREATE_OBJECT, VIRTUALSERVICE, GEN_TRAFFIC,common_task_args, ansible_dict,
     SKIP_FIELDS, DEFAULT_SKIP_TYPES, DEFAULT_META_ORDER, HELP_STR, NAME, VIP,
     SERVICES, CONTROLLER, API_VERSION, POOL_REF, TAGS, AVI_VIRTUALSERVICE,
     SERVER, VALIDATE_CERT, USER, REQEST_TYPE, IP_ADDRESS, TASKS,
     CONTROLLER_INPUT, USER_NAME, PASSWORD_NAME, STATE, DISABLE, BIGIP_VS_SERVER,
     DELEGETE_TO, LOCAL_HOST, ENABLE, F5_SERVER, F5_USERNAME, F5_PASSWORD,
     AVI_TRAFFIC, PORT, ADDR, VS_NAME, WHEN, RESULT, REGISTER, VALUE, TENANT,
     ANSIBLE_STR)

DEFAULT_SKIP_TYPES = DEFAULT_SKIP_TYPES
LOG = logging.getLogger(__name__)


class AviAnsibleConverter(object):
    skip_fields = SKIP_FIELDS
    skip_types = set(DEFAULT_SKIP_TYPES)
    default_meta_order = DEFAULT_META_ORDER
    REF_MATCH = re.compile('^/api/[\w/.#&-]*#[\s|\w/.&-:]*$')
    # Modified REGEX
    REL_REF_MATCH = re.compile('/api/[A-z]+/\?[A-z]+\=[A-z]+\&[A-z]+\=.*')

    def __init__(self, avi_cfg, outdir, prefix, skip_types=None,
                 filter_types=None):
        self.outdir = outdir
        self.avi_cfg = avi_cfg
        self.api_version = avi_cfg['META']['version']['Version']
        # Added prefix flag for object
        self.prefix = prefix
        if skip_types is None:
            skip_types = DEFAULT_SKIP_TYPES
        self.skip_types = (skip_types if type(skip_types) == list
                               else skip_types.split(','))
        if filter_types:
            self.filter_types = \
                (set(filter_types) if type(filter_types) == list
                 else set(filter_types.split(',')))
        else:
            self.filter_types = None

    def transform_ref(self, x, obj):
        """
        :param obj:
        :param x:
        :return:
        """
        # converts ref into the relative reference
        if not (isinstance(x, basestring) or isinstance(x, unicode)):
            return x
        if x == '/api/tenant/admin':
            x = '/api/tenant/admin#admin'
        # Added REGEX
        if self.REF_MATCH.match(x):
            name = x.rsplit('#', 1)[1]
            obj_type = x.split('/api/')[1].split('/')[0]
            # print name, obj_type
            x = '/api/%s?name=%s' % (obj_type, name)
        elif self.REL_REF_MATCH.match(x):
            ref_parts = x.split('?')
            for p in ref_parts[1].split('&'):
                k, v = p.split('=')
                # if url is /api/cloud/?tenant=admin&name='Default-Cloud'
                if k.strip() == 'cloud' or 'cloud' in ref_parts[0]:
                    obj['cloud_ref'] = '/api/cloud?name=%s' % v.strip()
                elif k.strip() == 'tenant' or 'tenant' in ref_parts[0]:
                    obj['tenant_ref'] = '/api/tenant?name=%s' % v.strip()
                # Added value of keyname
                if k.strip() == 'name':
                    x = '%s?name=%s' % (ref_parts[0], v)
        else:
            LOG.info('%s did not match ref' % x)
        return x

    def transform_obj_refs(self, obj):
        if type(obj) != dict:
            return
        for k, v in obj.items():
            if type(v) == dict:
                self.transform_obj_refs(v)
                continue
            if k.endswith('_ref') or k.endswith('_refs'):
                # check for whether v is string or list of strings
                if isinstance(v, basestring) or isinstance(v, unicode):
                    ref = self.transform_ref(v, obj)
                    obj[k] = ref
                elif type(v) == list:
                    new_list = []
                    for item in v:
                        if type(item) == dict:
                            self.transform_obj_refs(item)
                        elif (isinstance(item, basestring) or
                              isinstance(item, unicode)):
                            new_list.append(self.transform_ref(item, obj))
                    if new_list:
                        obj[k] = new_list
            elif type(v) == list:
                for item in v:
                    self.transform_obj_refs(item)
        return obj

    def build_ansible_objects(self, obj_type, objs, ansible_dict):
        """
        adds per object type ansible task
        :param obj_type type of object
        :param ansible_dict: output dict
        :param objs:
        Returns
            Ansible dict
        """
        for obj in objs:
            task = deepcopy(obj)
            if isinstance(task, str):
                continue
            for skip_field in self.skip_fields:
                task.pop(skip_field, None)
            self.transform_obj_refs(task)
            task.update(common_task_args)
            task_name = ("Create or Update %s: %s" % (obj_type, obj['name'])
                         if 'name' in obj else obj_type)
            task_id = 'avi_%s' % obj_type.lower()
            task.update({API_VERSION: self.api_version})
            ansible_dict[TASKS].append(
                {
                    task_id: task,
                    NAME: task_name,
                    TAGS: [obj[NAME], CREATE_OBJECT, obj_type.lower()]
                })
        return ansible_dict

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

    def get_status_vs(self, vs_name, f5server, username, password):
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
        url = 'https://%s/mgmt/tm/ltm/virtual/%s/' % (f5server, vs_name)
        status = requests.get(url, verify=False, auth=(username, password))
        status = json.loads(status.content)
        if status.pop(ENABLE, None):
            return True

    def get_f5_attributes(self, vs_dict):
        """
        This function used for generating f5 playbook configuration.
        It pop out the parameters like ip address, services, controller,
        and user name.
        It adds related parameters for f5 yaml generation.
        :param vs_dict: contains all virtualservice list.
        :return: None
        """
        f5_dict = deepcopy(vs_dict)
        f5_dict.pop(VIP)
        f5_dict.pop(SERVICES)
        f5_dict.pop(CONTROLLER)
        f5_dict.pop(USERNAME)
        f5_dict.pop(API_VERSION)
        f5_dict.pop(POOL_REF, None)
        f5_dict[SERVER] = F5_SERVER
        f5_dict[VALIDATE_CERT] = False
        f5_dict[USER] = F5_USERNAME
        f5_dict[PASSWORD] = F5_PASSWORD
        return f5_dict

    def create_f5_ansible_disable(self, f5_dict, ansible_dict):
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

    def create_avi_ansible_enable(self, vs_dict, ansible_dict):
        """
        This function is used to enable the avi virtual service.
        :param vs_dict: avi virtualservice related parameters.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        avi_enable = deepcopy(vs_dict)
        avi_enable[ENABLE] = True
        name = "Enable Avi virtualservice: %s" % avi_enable[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_VIRTUALSERVICE: avi_enable,
                TAGS: [ENABLE_AVI, avi_enable[NAME], VIRTUALSERVICE]
            })

    def generate_avi_vs_traffic(self, vs_dict, ansible_dict,
                                application_profile, tenant='admin'):
        """
        This function is used for generating tags for avi traffic.
        :param vs_dict: avi virtualservice attributes.
        :param ansible_dict: used for playbook generation.
        :param application_profile: dict used to for request type
        eg: request type : dns, http, https.
        :param tenant: name of tenant
        :return: None
        """
        avi_traffic_dict = dict()
        avi_traffic_dict[REQEST_TYPE] = \
            self.get_request_type(application_profile.split('name=')[1])
        if avi_traffic_dict[REQEST_TYPE] != 'dns':
            avi_traffic_dict[PORT] = vs_dict[SERVICES][0][PORT]
            ip = vs_dict[VIP][0][IP_ADDRESS][ADDR]
            avi_traffic_dict[IP_ADDRESS] = ip
            avi_traffic_dict[VS_NAME] = vs_dict[NAME]
            avi_traffic_dict[CONTROLLER] = CONTROLLER_INPUT
            avi_traffic_dict[USERNAME] = USER_NAME
            avi_traffic_dict[PASSWORD] = PASSWORD_NAME
            avi_traffic_dict[REGISTER] = VALUE
            avi_traffic_dict[TENANT] = tenant
        name = "Generate Avi virtualservice traffic: %s" % vs_dict[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_TRAFFIC: avi_traffic_dict,
                TAGS: [vs_dict[NAME], GEN_TRAFFIC]
            })

    def create_avi_ansible_disable(self, vs_dict, ansible_dict):
        """
        This function is used to disable the avi virtual service.
        :param vs_dict: avi virtualservice attributes.
        :param ansible_dict: used for playbook generation.
        :return: None
        """
        avi_enable = deepcopy(vs_dict)
        avi_enable[ENABLE] = False
        avi_enable[WHEN] = RESULT
        name = "Disable Avi virtualservice: %s" % avi_enable[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_VIRTUALSERVICE: avi_enable,
                TAGS: [DISABLE_AVI, avi_enable[NAME], VIRTUALSERVICE]
            })

    def create_f5_ansible_enable(self, f5_dict, ansible_dict):
        """
        This function is used to enable the f5 virtualservice.
        :param f5_dict: f5 attributes
        :param ansible_dict: used for playbook generation.
        :return: None
        """

        f5_values = deepcopy(f5_dict)
        f5_values[STATE] = ENABLE
        f5_values[WHEN] = RESULT
        # Remove prefix from vs name of big ip.
        if self.prefix:
            f5_values[NAME] = self.remove_prefix(f5_dict[NAME])
        name = "Enable F5 virtualservice: %s" % f5_values[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                BIGIP_VS_SERVER: f5_values,
                DELEGETE_TO: LOCAL_HOST,
                TAGS: [ENABLE_F5, f5_dict[NAME], VIRTUALSERVICE]
            })

    def get_request_type(self, name):
        """
        This function is used to get the type of virtualservice.
        :param name: application profile name.
        :return: request type
        """
        request_type = [app_profile['type'] for app_profile in
                        self.avi_cfg['ApplicationProfile'] if
                        app_profile['name'] == name]
        if HTTP_TYPE in str(request_type).lower():
            return 'http'
        elif SSL_TYPE in str(request_type).lower():
            return 'https'
        elif DNS_TYPE in str(request_type).lower():
            return 'dns'
        elif L4_TYPE in str(request_type).lower():
            return 'tcp'

    def generate_traffic(self, ansible_dict, f5server, f5username, f5password):
        """
        Generate the ansible playbook for Traffic generation.
        :param ansible_dict: ansible dict for generating yaml.
        :param f5server: Instance ip of f5
        :param: f5usename: username of f5server
        :param: f5password: password of f5server
        :return: None
        """
        for vs in self.avi_cfg['VirtualService']:
            if self.get_status_vs(vs[NAME], f5server, f5username, f5password):
                tenant = 'admin'
                vs_dict = dict()
                vs_dict[NAME] = vs[NAME]
                vs_dict[VIP] = vs[VIP]
                vs_dict[SERVICES] = vs[SERVICES]
                vs_dict[CONTROLLER] = CONTROLLER_INPUT
                vs_dict[USERNAME] = USER_NAME
                vs_dict[PASSWORD] = PASSWORD_NAME
                vs_dict[API_VERSION] = self.api_version
                # Added tenant in playbook for avi api calls.
                if 'tenant_ref' in vs:
                    tenant = str(vs['tenant_ref']).split('=')[-1]
                if POOL_REF in vs:
                    sep_ele = vs[POOL_REF].split('&')
                    removed_ref = sep_ele[0].split('?')
                    vs_dict[POOL_REF] = removed_ref[0]+'?'+sep_ele[1]
                f5_dict = self.get_f5_attributes(vs_dict)
                self.create_f5_ansible_disable(f5_dict, ansible_dict)
                self.create_avi_ansible_enable(vs_dict, ansible_dict)
                # Getting the request type
                if APPLICATION_PROFILE_REF in vs:
                    self.generate_avi_vs_traffic(
                                                 vs_dict, ansible_dict,
                                                 vs[APPLICATION_PROFILE_REF],
                                                 tenant=tenant
                                                )
                self.create_avi_ansible_disable(vs_dict, ansible_dict)
                self.create_f5_ansible_enable(f5_dict, ansible_dict)

    def write_ansible_playbook(self, f5server=None, f5user=None,
                               f5password=None):
        """
        Create the ansible playbook based on output json
        :param f5server:  Ip of f5 server
        :param f5user: username for f5
        :param f5password: password for f5
        :return: None
        """
        ansible_traffic_path = '%s/avi_migrate_and_verfiy_traffic.yml' \
                               % self.outdir
        ansible_create_object_path = '%s/avi_config_create_object.yml'\
                                     % self.outdir
        ad = deepcopy(ansible_dict)
        generate_traffic_dict = deepcopy(ansible_dict)
        meta = self.avi_cfg['META']
        if 'order' not in meta:
            meta['order'] = self.default_meta_order
        for obj_type in meta['order']:
            if self.filter_types and obj_type not in self.filter_types:
                continue
            if obj_type not in self.avi_cfg or obj_type in self.skip_types:
                continue
            self.build_ansible_objects(obj_type, self.avi_cfg[obj_type], ad)
        # if f5 username, password and server present then only generate
        #  playbook for traffic.
        if f5server and f5user and f5password:
            self.generate_traffic(generate_traffic_dict, f5server, f5user,
                                  f5password)
            # Generate traffic file separately
            with open(ansible_traffic_path, "w+") as outf:
                outf.write(ANSIBLE_STR)
                outf.write('---\n')
                yaml.safe_dump(
                               [generate_traffic_dict], outf,
                               default_flow_style=False, indent=2
                               )
        with open(ansible_create_object_path, "w+") as outf:
            outf.write(ANSIBLE_STR)
            outf.write('---\n')
            yaml.safe_dump([ad], outf, default_flow_style=False, indent=2)


HELP_STR = HELP_STR

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)
    parser.add_argument(
        '-c', '--config_file', help='location of configuration file',
        default='avi_config.json')
    parser.add_argument('-o', '--output_dir', help='Ansible dir',
                        default='.')
    parser.add_argument(
        '-s', '--skip_types',
        help='Comma separated list of Avi Object types to '
             'skip during conversion.\n  Eg. -s DebugController,'
             'ServiceEngineGroup will skip debugcontroller and '
             'serviceengine objects',
        default=DEFAULT_SKIP_TYPES)
    parser.add_argument(
        '-f', '--filter_types',
        help='Comma separated list of Avi Objects types to '
             'include during conversion.\n Eg. -f VirtualService,'
             'Pool will do ansible conversion only for '
             'Virtualservice and Pool objects',
        default=[])
    args = parser.parse_args()

    with open(args.config_file, "r+") as f:
        avi_cfg = json.loads(f.read())
        aac = AviAnsibleConverter(
            avi_cfg, args.output_dir, skip_types=args.skip_types,
            filter_types=args.filter_types)
        aac.write_ansible_playbook()
