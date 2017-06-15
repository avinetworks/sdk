#!/usr/bin/env python
import urlparse
from avi.migrationtools.ansible.ansible_constant import PATH_KEY_MAP


def get_name_and_entity(url):
    """
    Parses reference string to extract object type and
    :param url: reference url to be parsed
    :return: entity and object name
    """
    parsed = urlparse.urlparse(url)
    return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]


def search_obj(entity, name, new_config, avi_config):
    """
    Method to search referenced object
    :param entity: object type
    :param name: object name
    :param new_config: filtered config
    :param avi_config: full config
    :param : Recursion  to determine level in the vs reference tree
    """
    avi_conf_key = PATH_KEY_MAP[entity]
    found_obj_list = avi_config[avi_conf_key]
    found_obj = [obj for obj in found_obj_list if obj['name'] == name]

    if found_obj:
        found_obj = found_obj[0]
        name_obj = '%s-%s' % (found_obj['name'], avi_conf_key)
    else:
        print 'ERROR: Reference not found for %s with name %s' % (entity, name)
        exit()
    if name_obj not in new_config:
        new_config.append(name_obj)
    find_and_add_objects(found_obj, avi_config, new_config, )


def find_and_add_objects(obj_dict, avi_config, new_config, ):
    """
    Method to iterate in one object find references and add those to output
    :param obj_dict: Object to be iterated over
    :param avi_config: Full config
    :param new_config: Filtered config
    :param : Recursion  to determine level in the vs reference tree
    """
    for key in obj_dict:
        if (key.endswith('ref') and key not in ['cloud_ref']):
            if not obj_dict[key]:
                continue
            entity, name = get_name_and_entity(obj_dict[key])
            search_obj(entity, name, new_config, avi_config, )
        elif key.endswith('refs'):
            for ref in obj_dict[key]:
                entity, name = get_name_and_entity(ref)
                search_obj(entity, name, new_config, avi_config, )
        elif isinstance(obj_dict[key], dict):
            find_and_add_objects(obj_dict[key], avi_config, new_config, )
        elif obj_dict[key] and isinstance(obj_dict[key], list) \
                and isinstance(obj_dict[key][0], dict):
            for member in obj_dict[key]:
                find_and_add_objects(member, avi_config, new_config, )
    return


def filter_for_vs(avi_config):
    """
    Filters vs and its references from full configuration
    :param avi_config: full configuration
    :param vs_names: comma separated vs names to filter
    :return: Filtered config dict
    """
    new_config = []
    for vs in avi_config['VirtualService']:
        name = '%s-%s' % (vs['name'], 'VirtualService')
        new_config.append(name)
        find_and_add_objects(vs, avi_config, new_config)
    return new_config


