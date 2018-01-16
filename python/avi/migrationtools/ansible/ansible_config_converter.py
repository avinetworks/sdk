#!/usr/bin/env python
'''
Created on September 15, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
'''

import json
import logging
import yaml
import argparse
import re
import requests
import os
from copy import deepcopy
from avi.migrationtools.avi_orphan_object import \
    filter_for_vs, get_vs_ref, get_name_and_entity
from avi.migrationtools.ansible.ansible_constant import \
    (USERNAME, PASSWORD, HTTP_TYPE, SSL_TYPE,  DNS_TYPE, L4_TYPE,
     APPLICATION_PROFILE_REF, ENABLE_F5, DISABLE_F5, ENABLE_AVI, DISABLE_AVI,
     CREATE_OBJECT, VIRTUALSERVICE, GEN_TRAFFIC, common_task_args, ansible_dict,
     SKIP_FIELDS, DEFAULT_SKIP_TYPES, HELP_STR, NAME, VIP,
     SERVICES, CONTROLLER, API_VERSION, POOL_REF, TAGS, AVI_VIRTUALSERVICE,
     SERVER, VALIDATE_CERT, USER, REQEST_TYPE, IP_ADDRESS, TASKS,
     CONTROLLER_INPUT, USER_NAME, PASSWORD_NAME, STATE, DISABLE, BIGIP_VS_SERVER,
     DELEGETE_TO, LOCAL_HOST, ENABLE, F5_SERVER, F5_USERNAME, F5_PASSWORD,
     AVI_TRAFFIC, PORT, ADDR, VS_NAME, WHEN, RESULT, REGISTER, VALUE, TENANT,
     ANSIBLE_STR)
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.ansible.ansible_traffic_generation import TrafficGen

DEFAULT_SKIP_TYPES = DEFAULT_SKIP_TYPES
LOG = logging.getLogger(__name__)
# Added util object
mg_util = MigrationUtil()


class AviAnsibleConverter(object):
    skip_fields = SKIP_FIELDS
    skip_types = set(DEFAULT_SKIP_TYPES)
    REF_MATCH = re.compile('^/api/[\w/.#&-]*#[\s|\w/.&-:]*$')
    # Modified REGEX
    REL_REF_MATCH = re.compile('/api/[A-z]+/\?[A-z]+\=[A-z]+\&[A-z]+\=.*')

    def __init__(self, avi_cfg, outdir, prefix, not_in_use, skip_types=None,
                 filter_types=None, ns_vs_name_dict=None, test_vip=None):
        self.outdir = outdir
        self.avi_cfg = avi_cfg
        self.api_version = avi_cfg['META']['version']['Version']
        # Added prefix flag for object
        self.prefix = prefix
        self.not_in_use = not_in_use
        # Added ns vs dict
        self.ns_vs_name_dict = ns_vs_name_dict
        # for test vip
        self.test_vip = test_vip
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

        # Read file to get meta order.
        self.ansible_rest_file_path = os.path.join(os.path.dirname(__file__),
                                                   'ansible_order_constant.yaml')

        with open(self.ansible_rest_file_path, 'r') as f:
            self.default_meta_order = yaml.load(f)

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

    def update_tenant(self, obj):
        """
        updates the tenant field in the task. This is then picked up by
        ansible task or aviconfig role to create objects in the right tenant
        :param obj:
        :return:
        """
        if 'tenant' not in obj and 'tenant_ref' in obj:
            tenant = obj['tenant_ref'].split('name=')[1].strip()
            obj.update({'tenant': tenant})

    def build_ansible_objects(self, obj_type, objs, ansible_dict, inuse_list):
        """
        adds per object type ansible task
        :param obj_type type of object
        :param ansible_dict: output dict
        :param objs:
        Returns
            Ansible dict
        """

        # get the reference dict
        vs_ref_dict = get_vs_ref()

        for obj in objs:
            task = deepcopy(obj)
            # Added tag for checking object ref.
            used_tag = 'in_use'
            if isinstance(task, str):
                continue
            for skip_field in self.skip_fields:
                task.pop(skip_field, None)
            self.transform_obj_refs(task)
            task.update(common_task_args)
            self.update_tenant(task)
            task_name = ("Create or Update %s: %s" % (obj_type, obj['name'])
                         if 'name' in obj else obj_type)
            task_id = 'avi_%s' % obj_type.lower()

            # replacing test vips for both versions 17.1 and 16.4
            if self.test_vip:
                test_vip = self.test_vip.split('.')[:3]
                if self.api_version == '16.4':
                    if task.get('ip_address', []):
                        task['ip_address']['addr']\
                            = '.'.join(test_vip +
                                       task['ip_address']['addr'].split('.')[3:])
                else:
                    if task.get('vip', []):
                        for id, ip in enumerate(task['vip']):
                            task['vip'][id]['ip_address']['addr']\
                                = '.'.join(test_vip +
                                           task['vip'][id]['ip_address']['addr'].split('.')[3:])
                        if task.get('vsvip_ref', []):
                            task.get('vsvip_ref', [])
            task.update({'api_context': "{{api_context | default(omit)}}"})
            task.update({API_VERSION: self.api_version})
            # Check object present in list for tag.
            name = '%s-%s' % (obj['name'], obj_type)
            if inuse_list and name not in inuse_list:
                used_tag = 'not_in_use'

            tname = None
            if 'tenant_ref' in obj:
                entity, tname = get_name_and_entity(obj['tenant_ref'])

            # creating the equivalent key
            vs_ref_type = '%s$$%s$$%s' % (obj['name'], obj_type.lower(), tname)
            vs_ref_tags = None

            if vs_ref_type in vs_ref_dict:
                vs_ref_tags = vs_ref_dict[vs_ref_type]

            tags = [obj[NAME], CREATE_OBJECT, obj_type.lower(), used_tag]

            # eliminate nonetype in vs_ref_tags
            if vs_ref_tags:
                tags.extend(vs_ref_tags)
            ansible_dict[TASKS].append(
                {
                    task_id: task,
                    NAME: task_name,
                    TAGS: tags
                })
        return ansible_dict

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


    def get_f5_virtual_address_attrs(self, vs_dict):
        """
        This function used for generating f5 playbook configuration.
        It pop out the parameters like ip address, services, controller,
        and user name.
        It adds related parameters for f5 yaml generation.
        :param vs_dict: contains all virtualservice list.
        :return: None
        """
        f5_dict = deepcopy(vs_dict)
        v_address_dict = {
            NAME: f5_dict[VIP][0]['ip_address']['addr'],
            SERVER: F5_SERVER,
            VALIDATE_CERT: False,
            USER: F5_USERNAME,
            PASSWORD: F5_PASSWORD
        }
        return v_address_dict

    def generate_avi_vs_traffic(self, vs_dict, ansible_dict,
                                application_profile, tenant='admin',
                                test_vip=None):
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
        if application_profile == 'http':
            avi_traffic_dict[REQEST_TYPE] = 'http'
        else:
            avi_traffic_dict[REQEST_TYPE] = \
                self.get_request_type(application_profile.split('name=')[1])
        if avi_traffic_dict[REQEST_TYPE] != 'dns':
            avi_traffic_dict[PORT] = vs_dict[SERVICES][0][PORT]
            ip = vs_dict[VIP][0][IP_ADDRESS][ADDR]
            if test_vip:
                test_vip = self.test_vip.split('.')[:3]
                ip = '.'.join(test_vip + ip.split('.')[3:])
            avi_traffic_dict[IP_ADDRESS] = ip
            avi_traffic_dict[VS_NAME] = vs_dict[NAME]
            avi_traffic_dict[CONTROLLER] = CONTROLLER_INPUT
            avi_traffic_dict[USERNAME] = USER_NAME
            avi_traffic_dict[PASSWORD] = PASSWORD_NAME
            avi_traffic_dict[TENANT] = tenant
        name = "Generate Avi virtualservice traffic: %s" % vs_dict[NAME]
        ansible_dict[TASKS].append(
            {
                NAME: name,
                AVI_TRAFFIC: avi_traffic_dict,
                TAGS: [vs_dict[NAME], GEN_TRAFFIC],
                REGISTER: VALUE
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

    def generate_traffic(self, ansible_dict, f5server, f5username, f5password,
                         instace_type):
        """
        Generate the ansible playbook for Traffic generation.
        :param ansible_dict: ansible dict for generating yaml.
        :param f5server: Instance ip of f5
        :param: f5usename: username of f5server
        :param: f5password: password of f5server
        :return: None
        """
        # Added variable to check progress.
        total_size = len(self.avi_cfg['VirtualService'])
        progressbar_count = 0
        print "Conversion Started For Ansible Generate Traffic..."
        trafic_obj = TrafficGen.get_instance(instace_type, self.prefix,
                                             ns_vs_name_dict=self.ns_vs_name_dict)
        for vs in self.avi_cfg['VirtualService']:
            if trafic_obj.get_status_vs(vs[NAME], f5server, f5username, f5password):
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
                    vs_dict[POOL_REF] = removed_ref[0] + '?' + sep_ele[1]
                f5_dict = self.get_f5_attributes(vs_dict)
                f5_virtual_address_dict = \
                    self.get_f5_virtual_address_attrs(vs_dict)
                # Call to distinguish between f5 and netscaler
                trafic_obj.create_ansible_disable(f5_dict, ansible_dict)
                trafic_obj.create_virtual_address_disable(f5_virtual_address_dict, ansible_dict)
                trafic_obj.create_avi_ansible_enable(
                    vs_dict, ansible_dict, test_vip=self.test_vip)
                # Getting the request type
                if APPLICATION_PROFILE_REF in vs:
                    self.generate_avi_vs_traffic(
                        vs_dict, ansible_dict,
                        vs[APPLICATION_PROFILE_REF],
                        test_vip=self.test_vip
                    )
                else:
                    self.generate_avi_vs_traffic(
                        vs_dict, ansible_dict,
                        'http',
                        tenant=tenant
                    )
                if self.test_vip:
                    trafic_obj.update_avi_ansible_vip(
                        vs_dict, ansible_dict)
                trafic_obj.create_avi_ansible_disable(vs_dict, ansible_dict)
                trafic_obj.create_ansible_enable(f5_dict, ansible_dict)
                trafic_obj.create_virtual_address_enable(f5_virtual_address_dict, ansible_dict)
            # Added call to check progress.
            progressbar_count += 1
            msg = "Ansible Generate Traffic..."
            mg_util.print_progress_bar(progressbar_count, total_size, msg,
                                       prefix='Progress', suffix='')

    def write_ansible_playbook(self, f5server=None, f5user=None,
                               f5password=None, instance_type=None):
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
        ansible_delete_object_path = '%s/avi_config_delete_object.yml'\
                                     % self.outdir
        # Get the reference object list for not_in_use tag.
        inuse_list = []
        if not self.not_in_use:
            inuse_list = filter_for_vs(self.avi_cfg)
        ad = deepcopy(ansible_dict)
        generate_traffic_dict = deepcopy(ansible_dict)
        total_size = len(self.default_meta_order['avi_resource_types'])
        progressbar_count = 0
        print "Conversion Started For Ansible Create Object..."
        for obj_type in self.default_meta_order['avi_resource_types']:
            progressbar_count += 1
            # Added call to check progress.
            msg = "Ansible Create Object..."
            mg_util.print_progress_bar(progressbar_count, total_size, msg,
                                       prefix='Progress', suffix='')
            if self.filter_types and obj_type not in self.filter_types:
                continue
            # have a temp dict for accessing lowercase keys
            avi_cfg_temp = {k.lower(): v for k, v in self.avi_cfg.items()}

            if obj_type not in avi_cfg_temp or obj_type in self.skip_types:
                continue
            self.build_ansible_objects(obj_type, avi_cfg_temp[obj_type], ad,
                                       inuse_list)
        # if f5 username, password and server present then only generate
        #  playbook for traffic.
        if f5server and f5user and f5password and instance_type:
            self.generate_traffic(generate_traffic_dict, f5server, f5user,
                                  f5password, instance_type)
            # Generate traffic file separately
            with open(ansible_traffic_path, "w+") as outf:
                outf.write(ANSIBLE_STR)
                outf.write('---\n')
                yaml.safe_dump(
                    [generate_traffic_dict], outf,
                    default_flow_style=False, indent=2
                )
        with open(ansible_create_object_path, "w") as outf:
            outf.write(ANSIBLE_STR)
            outf.write('---\n')
            yaml.safe_dump([ad], outf, default_flow_style=False, indent=2)

        # Added support to generate ansible delete object playbook
        if len(ad['tasks']):
            for k, v in ad['tasks'][0].iteritems():
                    if isinstance(v, dict):
                        v['api_context'] = "{{results.api_context}}"
        tasks = [task for task in reversed(ad['tasks'])]
        for task in tasks:
            for k, v in task.iteritems():
                if k == 'name' or k == 'tags' or k =='register':
                    continue
                if v.get('system_default'):
                    tasks.remove(task)
                    continue
                v['state'] = 'absent'
        ad['tasks'] = tasks
        with open(ansible_delete_object_path, "w") as outf:
            outf.write('# Auto-generated from Avi Configuration\n')
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
# avi_cfg, outdir, prefix, not_in_use, skip_types=None, filter_types=None
