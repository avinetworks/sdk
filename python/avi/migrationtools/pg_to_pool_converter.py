#!/usr/bin/env python3
"""
Created on Mar 16, 2021

@author: Chaitanya Deshpande (deshpandech@vmware.com)

This module provides a utility to rename Pool Group objects having
single pool member and update its refs in an exported Avi
configuration Output.json

"""


import argparse
import json
import logging
import sys
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.netscaler_converter.ns_constants import OBJECT_TYPE_POOL_GROUP
from avi.migrationtools.config_patch import ConfigPatch

migration_util = MigrationUtil()


def update_obj_refs(old_obj_type, old_ref, new_ref, obj, avi_cfg):
    """
    Traverses the full object maps and updates the references
    :param old_obj_type: object type for the original object.
    :param old_ref: old reference
    :param new_ref: new reference
    :param obj: Object dictionary or list. It could be nested part of the
    object as well.
    :param avi_cfg: Full Avi configuration dictionary.
    :return: None
    """
    if isinstance(obj, dict):
        if 'pool_group_ref' in obj and obj['pool_group_ref'] == old_ref:
            obj['pool_ref'] = new_ref
            obj.pop('pool_group_ref')
            if obj.get('action', '') == 'HTTP_SWITCHING_SELECT_POOLGROUP':
                obj['action'] = 'HTTP_SWITCHING_SELECT_POOL'
        for k, v in obj.items():
            if isinstance(v, dict):
                update_obj_refs(
                    old_obj_type, old_ref, new_ref, v, avi_cfg)
            elif isinstance(v, list):
                for elem in v:
                    update_obj_refs(
                        old_obj_type, old_ref, new_ref, elem, avi_cfg)
    elif isinstance(obj, list):
        for elem in obj:
            update_references(old_ref, new_ref, elem, avi_cfg)
    else:
        # ignores the object.
        pass


def update_references(obj_type, old_ref, new_ref, avi_cfg):
    """
    Iterates over every object type and updates the references to the
    old reference.
    :param obj_type: object type for the original object.
    :param old_ref: old reference of the object.
    :param new_ref: new reference of the object.
    :param avi_cfg: Full Avi configuration dictionary.
    :return: None
    """
    for _, obj_list in avi_cfg.items():
        for obj in obj_list:
            update_obj_refs(
                obj_type, old_ref, new_ref, obj, avi_cfg)


def convert_pool_group(pg, avi_config):
    pool_ref = pg['members'][0].get('pool_ref')
    tenant_name = migration_util.get_name(pg['tenant_ref'])
    cloud_name = migration_util.get_name(pg['cloud_ref'])
    pg_ref = migration_util.get_object_ref(
        pg['name'], OBJECT_TYPE_POOL_GROUP, tenant_name, cloud_name)

    update_references('poolgroup', pg_ref, pool_ref, avi_config)


def convert_pg_to_pool(avi_config):
    pool_groups = avi_config.get('PoolGroup', None)
    updated_pgs = list()

    if not pool_groups:
        return avi_config

    for pg in pool_groups:
        if 'members' in pg and len(pg['members']) == 1:
            convert_pool_group(pg, avi_config)
            pg['mark_for_delete'] = True
    pool_groups_new = [obj for obj in pool_groups if not obj.get('mark_for_delete', False)]
    avi_config['PoolGroup'] = pool_groups_new
    return avi_config


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
        description='Updates an exported Avi Configuration with a '
                    'converting PGs with single pool to pool',
        usage="""python pg_to_pool_converter -c avi_config.json""")
    parser.add_argument('-c', '--aviconfig',
                        help='Avi configuration in JSON format')
    args = parser.parse_args()

    with open(args.aviconfig) as f:
        acfg = json.load(f)
    updated_cfg = convert_pg_to_pool(acfg)
    with open(args.aviconfig + '.updated', 'w') as f:
        f.write(json.dumps(updated_cfg, indent=4))