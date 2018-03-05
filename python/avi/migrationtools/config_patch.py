#!/usr/bin/env python
'''
Created on Mar 25, 2015

@author: Gaurav Rastogi (grastogi@avinetworks.com)

This module provides a utility to rename objects and update attributes
in an exported Avi configuration Output.json


Eg.
Pool:
  - match_name: my-pool
    patch:
      name: grastogi
      cloud: AWS

'''
import argparse
import json
import logging
import sys
import traceback

import yaml
import re
from copy import deepcopy
from avi.migrationtools.avi_migration_utils import MigrationUtil

log = logging.getLogger(__name__)


class ConfigPatch(object):
    """
    This class implements patching of configuration object that are either
    exported from Avi Controller or created by the configuration migration
    """
    def __init__(self, avi_cfg, patches):
        """
        :param avi_cfg: Avi config dictionary
        :param patches: Patch dictionary
        """
        log.debug('input patch %s', patches)
        self.avi_cfg = avi_cfg
        self.patches = patches

    def param_value_in_ref(self, avi_ref, param_name):
        """

        :param avi_ref:
        :param param_name:
        :return:
        """
        qp = avi_ref.split('?')[1]
        params = qp.split('&')
        for param in params:
            k, v = param.split('=')
            if k == param_name:
                return v
        log.error('returning param %s %s', avi_ref, param_name)
        raise Exception('Could not find param %s in ref %s' %
                        (param_name, avi_ref))

    def update_obj_refs(self, old_obj_type, old_ref, new_ref, obj):
        """
        Traverses the full object maps and updates the references
        :param old_ref: old reference
        :param new_ref: new reference
        :param obj: Object dictionary or list. It could be nested part of the
        object as well.
        :return: None
        """
        if isinstance(obj, dict):
            for k, v in obj.iteritems():
                if k.endswith('ref') or k.endswith('_refs'):
                    if isinstance(v, list):
                        if old_ref in v:
                            # need to remove and add the item.
                            log.debug('refs changed %s to %s', old_ref, new_ref)
                            new_refs = set(v)
                            new_refs.pop(old_ref)
                            new_refs.add(new_ref)
                            obj[k] = list(new_refs)
                    elif v == old_ref:
                        log.debug('refs changed %s to %s', v, new_ref)
                        obj[k] = new_ref
                elif isinstance(v, dict):
                    self.update_obj_refs(
                        old_obj_type, old_ref, new_ref, v)
                elif isinstance(v, list):
                    for elem in v:
                        self.update_obj_refs(
                            old_obj_type, old_ref, new_ref, elem)
        elif isinstance(obj, list):
            for elem in obj:
                self.update_references(old_ref, new_ref, elem)
        else:
            # ignores the object.
            pass

    def update_references(self, obj_type, old_ref, new_ref, avi_cfg):
        """
        Iterates over every object type and updates the references to the
        old reference.
        :param obj_type: object type for the original object.
        :param old_ref: old reference of the object.
        :param new_ref: new reference of the object.
        :param avi_cfg: Full Avi configuration dictionary.
        :return: None
        """
        for _, obj_list in avi_cfg.iteritems():
            for obj in obj_list:
                self.update_obj_refs(
                    obj_type, old_ref, new_ref, obj)

    def apply_obj_patch(self, obj_type, obj, patch_data, avi_cfg):
        """
        :param obj_type: object type eg. VirtualService.
        :param obj: Patch an object.
        :param patch_data: Dictionary on a per object type basis.
        :param avi_cfg:
        :return:
        """
        old_obj_refs = []
        mg_util = MigrationUtil()

        # TODO(grastogi): The refs computation needs to change
        # as the currently the ref does not have tenant or
        # cloud information.
        tenant_ref = obj.get('tenant_ref', '/api/tenant/?name=admin')
        tenant = self.param_value_in_ref(tenant_ref, 'name')
        if 'name' in obj:
            obj_name = obj['name']
            old_obj_ref = '%s:%s' % (tenant, obj['name'])
            old_obj_refs.append(old_obj_ref)
            old_obj_ref = obj['name']
            old_obj_refs.append(old_obj_ref)
            # old_obj_ref = '/api/%s/?tenant=%s&name=%s' % (
            #     obj_type.lower(), tenant, obj['name'])
            cloud = (self.param_value_in_ref(obj.get('cloud_ref'), 'name')
                     if 'cloud_ref' in obj else None)
            old_obj_ref = mg_util.get_object_ref(
                obj['name'], obj_type.lower(), tenant, cloud_name=cloud)

            old_obj_refs.append(old_obj_ref)
        if patch_data.get('delete_old', False):
            new_obj_name = patch_data['patch']['name']
            avi_cfg[obj_type].remove(obj)
            log.debug('Deleted old %s named %s replacing references to %s',
                      obj_type, obj.get('name', ''), new_obj_name)
            if 'tenant_ref' in patch_data['patch']:
                tenant = mg_util.get_name(patch_data['patch']['tenant_ref'])

        else:
            log.debug('patching %s:%s with patch %s',
                      obj_type, obj.get('name', ''), patch_data)
            obj.update(patch_data['patch'])
            if 'name' in obj:
                new_obj_name = obj['name']
        if (('name' in patch_data['patch']) and old_obj_refs and
                (obj_name != new_obj_name)):
            # need to update all the references for this object
            # new_obj_ref = '/api/%s/?tenant=%s&name=%s' % (
            #     obj_type.lower(), tenant, obj['name'])
            cloud = (self.param_value_in_ref(obj.get('cloud_ref'), 'name')
                     if 'cloud_ref' in obj else '')
            new_obj_ref = mg_util.get_object_ref(
                new_obj_name, obj_type.lower(), tenant, cloud_name=cloud)
            # this is to handle old references could be in multiple formats
            for old_obj_ref in old_obj_refs:
                self.update_references(
                    obj_type, old_obj_ref, new_obj_ref, avi_cfg)

    def apply_patch(self, obj_type, patch_data, new_cfg):
        """
        For every patch in the patch data
            patch objects that match the patch data
                update the references if required
        :param obj_type: Avi object type
        :param patch_data: patch data dictionary
        :param new_cfg: Avi configuration dictionary that can be dumped
            as json
        :return:
        """
        cfg_objs = new_cfg.get(obj_type, [])
        if not cfg_objs:
            log.warn('Could not apply patch %s: %s as no matching obj found',
                     obj_type, patch_data)
            return new_cfg
        for obj in cfg_objs:
            obj_name = obj['name']
            rexp = None
            list_match = False
            regex_pattern = '.*'
            if 'match_name' in patch_data:
                regex_pattern = '^%s$' % patch_data['match_name']
                rexp = re.compile(regex_pattern)
            elif 'match_name_regex' in patch_data:
                regex_pattern = patch_data['match_name_regex']
                rexp = re.compile(regex_pattern)
            elif 'match_name_in_list' in patch_data:
                list_match = obj_name in patch_data['match_name_in_list']

            if (rexp and rexp.match(obj_name)) or list_match:
                try:
                    self.apply_obj_patch(obj_type, obj, patch_data, new_cfg)
                except:
                    log.error('failure in object %s patch %s', obj, patch_data)
                    log.error(traceback.format_exc())

                    raise
        return new_cfg

    def patch(self):
        """
        apply patches to the copy of configuration.
        :return:
        """
        # Creating util object for calling progressbar.
        mg_util = MigrationUtil()
        new_cfg = deepcopy(self.avi_cfg)
        total_size = len(self.patches)
        progressbar_count = 0
        print "Conversion For Patching of objects started..."
        for obj_type, obj_patches in self.patches.iteritems():
            progressbar_count += 1
            # for each object that is being patched need to iterate
            #   over all the configuration that matches either reference
            #   or name of object.
            for patch_data in obj_patches:
                self.apply_patch(obj_type, patch_data, new_cfg)
            msg = "Patching conversion started..."
            mg_util.print_progress_bar(progressbar_count, total_size, msg,
                               prefix='Progress', suffix='')
        return new_cfg


if __name__ == '__main__':
    ch = logging.StreamHandler(sys.stdout)
    root_logger = logging.getLogger()
    root_logger.setLevel(logging.DEBUG)
    formatter = logging.Formatter(
        '[%(asctime)s] %(levelname)s ['
        '%(module)s.%(funcName)s:%(lineno)d] %(message)s')
    ch.setFormatter(formatter)
    root_logger.addHandler(ch)

    parser = argparse.ArgumentParser(
        description='Patches an exported Avi Configuration with a configuration patch input as yaml file.',
        usage="""
    python config_patch -c avi_config.json -p test/patch.yml
    output: avi_config.json.patched
    Contents of the patch.yml
    Pool:
      - match_name: cool
        patch:
          name: awesome
    VirtualService:
      - match_name: cool
        patch:
          name: awesome
        """)
    parser.add_argument('-c', '--aviconfig',
                        help='Avi configuration in JSON format')
    parser.add_argument('-p', '--patchconfig',
                        help='Avi configuration objects to be patched. It is list of patterns and object overrides')
    args = parser.parse_args()

    with open(args.aviconfig) as f:
        acfg = json.load(f)

    with open(args.patchconfig) as f:
        patches = yaml.load(f)
    cp = ConfigPatch(acfg, patches)
    patched_cfg = cp.patch()
    with open(args.aviconfig + '.patched', 'w') as f:
        f.write(json.dumps(patched_cfg, indent=4))
