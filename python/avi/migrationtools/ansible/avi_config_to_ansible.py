#!/usr/bin/env python
"""
Created on September 15, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
"""

import json
from copy import deepcopy

import argparse
import yaml

from avi.migrationtools.ansible.ansible_config_converter import \
    AviAnsibleConverterBase
from avi.migrationtools.ansible.ansible_constant import DEFAULT_SKIP_TYPES


class AviAnsibleConverter(AviAnsibleConverterBase):

    def __init__(self, avi_cfg, outdir, skip_types=None, filter_types=None,
                 controller_version=None):
        self.outdir = outdir
        self.avi_cfg = avi_cfg
        if 'META' in avi_cfg and avi_cfg['META']['version']['Version']:
            self.api_version = avi_cfg['META']['version']['Version']
        else:
            self.api_version = controller_version
        self.ansible_avi_config = {'avi_config': {}}
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
            if obj.get('name', '').startswith('System-') or obj.get('system_default', False):
                continue
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
            if rsrc.get('name', '').startswith('System-') or rsrc.get('system_default', False):
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
                if k == 'name' or k == 'tags' or k =='register':
                    continue
                if v.get('system_default'):
                    tasks.remove(task)
                    continue
                v['state'] = 'absent'
                v['api_version'] = self.avi_cfg['META']['version']['Version']
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
