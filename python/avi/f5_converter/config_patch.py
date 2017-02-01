#!/usr/bin/env python
'''
Created on Mar 25, 2015

@author: Gaurav Rastogi (grastogi@avinetworks.com)

This module provides a utility to rename objects and update attributes
in an exported Avi configuration Output.json


input:
  obj_type: [
     'obj_name':
        name: new_name
        cloud: aws_cloud
    ]

'''
import argparse
import json
import logging
import sys
import yaml
import re
from copy import deepcopy

log = logging.getLogger(__name__)


class ConfigPatch(object):
    def __init__(self, avi_cfg, patches):
        '''
        Args:
        @cfg: Avi config dictionary
        @patch_data: Patch dictionary
        Returns
            dictionary of the new Avi configuration
        '''
        log.debug('input patch %s', patches)
        self.avi_cfg = avi_cfg
        self.patches = patches

    def update_obj_refs(self, old_ref, new_ref, obj):
        if isinstance(obj, dict):
            for k, v in obj.iteritems():
                if k.endswith('ref') or k.endswith('_refs'):
                    if isinstance(v, list):
                        if old_ref in v:
                            # need to remove and add the item.
                            new_refs = set(v)
                            new_refs.pop(old_ref)
                            new_refs.add(new_ref)
                            obj[k] = list(new_refs)
                    elif v == old_ref:
                        obj[k] = new_ref
                elif isinstance(v, dict):
                    self.update_obj_refs(old_ref, new_ref, v)
                elif isinstance(v, list):
                    for elem in v:
                        self.update_obj_refs(old_ref, new_ref, elem)
        elif isinstance(obj, list):
            for elem in obj:
                self.update_references(old_ref, new_ref, elem)

    def update_references(self, old_ref, new_ref, new_cfg):
        for obj_type, obj_list in new_cfg.iteritems():
            for obj in obj_list:
                self.update_obj_refs(old_ref, new_ref, obj)

    def apply_obj_patch(self, obj, patch_data, new_cfg):
        # TODO(grastogi): The refs computation needs to change
        # as the currently the ref does not have tenant or
        # cloud information.
        old_obj_ref = '%s:%s' % (obj.get('tenant', 'admin'), obj['name'])
        old_obj_ref = obj['name']
        obj.update(patch_data['patch'])
        new_obj_ref = '%s:%s' % (obj.get('tenant', 'admin'), obj['name'])
        new_obj_ref = obj['name']
        if ('name' in patch_data['patch'] and
                    old_obj_ref != new_obj_ref):
            # need to update all the references for this object
            log.debug('refs changed %s to %s', old_obj_ref, new_obj_ref)
            self.update_references(old_obj_ref, new_obj_ref, new_cfg)

    def apply_patch(self, obj_type, patch_data, new_cfg):
        cfg_objs = new_cfg.get(obj_type, [])
        if not cfg_objs:
            log.warn('Could not apply patch %s: %s as no matching obj found',
                     obj_type, patch_data)
            return new_cfg
        for obj in cfg_objs:
            obj_name = obj['name']
            regex_pattern = '.*'
            if 'match_name' in patch_data:
                regex_pattern = '^%s$' % patch_data['match_name']
            elif 'match_name_regex' in patch_data:
                regex_pattern = patch_data['match_name_regex']
            rexp = re.compile(regex_pattern)
            if rexp.match(obj_name):
                self.apply_obj_patch(obj, patch_data, new_cfg)

    def patch(self):
        new_cfg = deepcopy(self.avi_cfg)
        for obj_type, obj_patches in self.patches.iteritems():
            # for each object that is being patched need to iterate
            #   over all the configuration that matches either reference
            #   or name of object.
            for patch_data in obj_patches:
                self.apply_patch(obj_type, patch_data, new_cfg)
        return new_cfg


if __name__ == '__main__':
    ch = logging.StreamHandler(sys.stdout)
    root_logger = logging.getLogger()
    root_logger.setLevel(logging.DEBUG)
    root_logger.addHandler(ch)

    parser = argparse.ArgumentParser(description='Patches an exported Avi Configuration with a configuration patch input as yaml file.')
    parser.add_argument('-c', '--aviconfig',
                        help='Avi configuration in JSON format')
    parser.add_argument('-p', '--patchconfig',
                        help='Avi configuration objects to be patched. It is list of patterns and object overrides')
    args = parser.parse_args()

    with open(args.aviconfig) as f:
        avi_cfg = json.load(f)

    with open(args.patchconfig) as f:
        patches = yaml.load(f)
    cp = ConfigPatch(avi_cfg, patches)
    patched_cfg = cp.patch()
    with open(args.aviconfig + '.patched', 'w') as f:
        f.write(json.dumps(patched_cfg, indent=4))
