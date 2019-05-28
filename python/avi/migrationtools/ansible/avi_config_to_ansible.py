#!/usr/bin/env python
"""
Created on September 15, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
"""

import argparse
import json
import re
import urlparse
from copy import deepcopy
from urllib import urlencode

import yaml
from avi.migrationtools.f5_converter.conversion_util import F5Util

DEFAULT_SKIP_TYPES = [
    'SystemConfiguration', 'Network', 'debugcontroller', 'VIMgrVMRuntime',
    'VIMgrIPSubnetRuntime', 'Alert', 'VIMgrSEVMRuntime', 'VIMgrClusterRuntime',
    'VIMgrHostRuntime', 'DebugController', 'ServiceEngineGroup',
    'SeProperties', 'ControllerProperties', 'CloudProperties']

DEFAULT_SKIP_PARAMS = {
    'sslprofile': ['dhparam']
    }


def should_use_block(value):
    for c in u"\u000a\u000d\u001c\u001d\u001e\u0085\u2028\u2029":
        if c in value:
            return True
    return False


def my_represent_scalar(self, tag, value, style=None):
    if style is None:
        if should_use_block(value):
             style='|'
        else:
            style = self.default_style

    node = yaml.representer.ScalarNode(tag, value, style=style)
    if self.alias_key is not None:
        self.represented_objects[self.alias_key] = node
    return node

yaml.representer.BaseRepresenter.represent_scalar = my_represent_scalar
utils = F5Util()
meta_file = utils.get_project_path()+'/../common/avi_resource_types.yaml'
with open(meta_file) as f:
    supported_obj = yaml.load(f)


class AviAnsibleConverter(object):
    common_task_args = {
        'controller': "{{ controller }}",
        'username': "{{ username }}",
        'password': "{{ password }}"
    }

    ansible_dict = dict({
        'connection': 'local',
        'hosts': 'localhost',
        'vars': common_task_args,
        'tasks': []})

    skip_fields = ['uuid', 'url', 'ref_key', 'se_uuids']
    skip_types = set(DEFAULT_SKIP_TYPES)
    default_meta_order = supported_obj['avi_resource_types']

    REF_MATCH = re.compile('^/api/[\w/.#&-]*#[\s|\w/.&-:]*$')

    def __init__(self, avi_cfg, outdir, skip_types=None, filter_types=None, controller_version=None):
        self.outdir = outdir
        self.avi_cfg = avi_cfg
        if 'META' in avi_cfg and avi_cfg['META']['version']['Version']:
            self.api_version = avi_cfg['META']['version']['Version']
        else:
            self.api_version = controller_version
        self.ansible_avi_config = {'avi_config': {}}
        self.conversion_util = F5Util()
        if skip_types is None:
            skip_types = DEFAULT_SKIP_TYPES
        if skip_types:
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
        elif x.startswith('/api/') and '?' in x:
            parsed = urlparse.urlparse(x)
            params = urlparse.parse_qs(parsed.query)
            if 'cloud' in params:
                obj['cloud_ref'] = '/api/cloud?name=%s' % params['cloud'][0]
        else:
            print "[WARNING] Ignoring invalid reference:  %s" % x
            return None

        u = urlparse.urlparse(x)
        query = {'name': urlparse.parse_qs(u.query)['name']}
        # query.pop('tenant', None)
        # query.pop('cloud', None)
        u = u._replace(query=urlencode(query, True))
        x = urlparse.urlunparse(u)
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
                    if ref:
                        obj[k] = ref
                    else:
                        del obj[k]
                elif type(v) == list:
                    new_list = []
                    for item in v:
                        if type(item) == dict:
                            self.transform_obj_refs(item)
                        elif (isinstance(item, basestring) or
                              isinstance(item, unicode)):
                            ref = self.transform_ref(item, obj)
                            if ref:
                                new_list.append(ref)
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

    def purge_fields(self, rsrc_type, rsrc):
        for skip_field in self.skip_fields:
            rsrc.pop(skip_field, None)
        for skip_param in DEFAULT_SKIP_PARAMS.get(rsrc_type, []):
            rsrc.pop(skip_param, None)
        for skip_field in self.skip_fields:
            rsrc.pop(skip_field, None)
        for key in rsrc:
            if isinstance(rsrc[key], str):
                rsrc[key] = rsrc[key].encode('string-escape')
            elif isinstance(rsrc[key], unicode) and key == 'key':
                rsrc[key] = rsrc[key].encode()
            elif isinstance(rsrc[key], unicode):
                rsrc[key] = rsrc[key].encode('unicode-escape')

        if rsrc_type == 'vsvip':
            # check for floating IP and normal IP
            for vip in rsrc.get('vip', []):
                if vip.get('avi_allocated_fip', False):
                    print ('purged floating ip from %s',
                           vip['floating_ip']['addr'])
                    vip.pop('floating_ip', None)
                if vip.get('avi_allocated_vip', False):
                    print ('purged avi vip %s', vip['ip_address']['addr'])
                    vip.pop('ip_address', None)

    def build_ansible_objects(self, obj_type, objs, ansible_dict):
        """
        adds per object type ansible task
        :param obj_type type of object
        :param objs list of objects
        :param ansible_dict: output dict
        Returns
            Ansible dict
        """
        for obj in objs:
            task = deepcopy(obj)
            self.purge_fields(obj_type, task)
            self.transform_obj_refs(task)
            task.update(self.common_task_args)
            task.update(
                {'api_version': self.api_version})
            task.update(
                {'api_context': "{{avi_api_context | default(omit)}}"})
            # update tenant if there is a tenant_ref in the object
            self.update_tenant(task)
            task_name = (
                "Create or Update %s: %s" % (obj_type, obj['name'])
                if 'name' in obj else obj_type)
            task_id = 'avi_%s' % obj_type.lower()
            tags = [obj['name'], obj_type.lower()]
            if obj_type.lower() == 'virtualservice':
                # add entry for traffic_enabled.
                traffic_enabled = obj.get('traffic_enabled', True)
                task['traffic_enabled'] = (
                        "{{ avi_traffic_enabled | default(%s)}}" %
                        traffic_enabled)
            # task.update({'tags': tags})
            ansible_dict['tasks'].append(
                {'name': task_name, 'tags': tags, task_id: task})
        return ansible_dict

    def build_yaml_objects(self, obj_type, objs, ansible_dict):
        """
        adds per object type ansible task
        :param obj_type type of object
        :param objs list of objects
        :param ansible_dict: output dict
        Returns
            Ansible dict
        """
        rsrc_type = obj_type.lower()
        if not objs:
            return ansible_dict
        if rsrc_type not in ansible_dict['avi_config']:
            ansible_dict['avi_config'][rsrc_type] = []
        for obj in objs:
            rsrc = deepcopy(obj)
            if rsrc.get('name', '').startswith('System-'):
                continue
            self.purge_fields(rsrc_type, rsrc)
            self.transform_obj_refs(rsrc)
            rsrc.update(
                {'api_version': self.api_version})
            self.update_tenant(rsrc)
            print 'processed', obj_type, rsrc.get('name', 'N/A')
            ansible_dict['avi_config'][rsrc_type].append(rsrc)
        return ansible_dict

    def write_ansible_playbook(self):
        ad = deepcopy(self.ansible_dict)
        for obj_type in self.default_meta_order:
            if self.filter_types and obj_type not in self.filter_types:
                continue
            if obj_type not in self.avi_cfg or obj_type in self.skip_types:
                continue
            self.build_ansible_objects(obj_type, self.avi_cfg[obj_type], ad)
        with open('%s/avi_config.yml' % self.outdir, "w") as outf:
            outf.write('# Auto-generated from Avi Configuration\n')
            outf.write('---\n')
            yaml.safe_dump([ad], outf, default_flow_style=False, indent=2)

        tasks = [task for task in reversed(ad['tasks'])]
        for task in tasks:
            for k, v in task.iteritems():
                if k == 'name' or 'tags':
                    continue
                v['state'] = 'absent'
                v['api_version'] = self.api_version
        ad['tasks'] = tasks
        with open('%s/avi_config_delete.yml' % self.outdir, "w") as outf:
            outf.write('# Auto-generated from Avi Configuration\n')
            outf.write('---\n')
            yaml.safe_dump([ad], outf, default_flow_style=False, indent=2)

    def write_yaml(self):
        ad = deepcopy(self.ansible_avi_config)
        for obj_type in self.default_meta_order:
            if self.filter_types and obj_type not in self.filter_types:
                continue
            if obj_type not in self.avi_cfg or obj_type in self.skip_types:
                continue
            self.build_yaml_objects(obj_type, self.avi_cfg[obj_type], ad)
        with open('%s/ansible_avi_config.yml' % self.outdir, "w") as outf:
            outf.write('# Auto-generated from Avi Configuration\n')
            outf.write('---\n')
            yaml.safe_dump(ad, outf, default_flow_style=False, indent=2)


HELP_STR = '''
Converts Avi Config JSON to Ansible Playbooks. 
Please ensure configuration is exported with options include_name=true&uuid_refs=true as:
Example:
    api/configuration/export?include_name=true&uuid_refs=true

Example to export a single virtualservice:
    api/configuration/export/virtualservice/<vs-uuid>?include_name=true&uuid_refs=true

Example to export a single serviceengine:
    api/configuration/export/serviceengine/>se_uuid>?include_name=true&uuid_refs=true
'''

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
        help='Comma separated list of Avi Object types to skip during conversion.\n  Eg. -s DebugController,ServiceEngineGroup will skip debugcontroller and serviceengine objects',
        default=DEFAULT_SKIP_TYPES)
    parser.add_argument(
        '-f', '--filter_types',
        help='Comma separated list of Avi Objects types to include during conversion.\n Eg. -f VirtualService,Pool will do ansible conversion only for Virtualservice and Pool objects',
        default=[])
    parser.add_argument(
        '-y', '--yaml',
        help='Export it as yaml output that can be used with Avi ansible role aviconfig',
        action='store_true')
    parser.add_argument(
        '--controller_version',
        help='Target Avi controller version',
        default='17.2.1')

    args = parser.parse_args()

    with open(args.config_file, "r+") as f:
        avi_cfg = json.loads(f.read())
        aac = AviAnsibleConverter(
            avi_cfg, args.output_dir, skip_types=args.skip_types,
            filter_types=args.filter_types, controller_version=args.controller_version)
        if not args.yaml:
            aac.write_ansible_playbook()
        else:
            aac.write_yaml()
