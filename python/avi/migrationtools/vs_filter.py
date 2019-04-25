#!/usr/bin/env python
import argparse
import json
import os
import urlparse
import yaml

# Read avi object to API path map from yaml file.
yml_file = os.path.abspath(os.path.join(os.path.dirname(__file__), './common/avi_resource_types.yaml'))
yml_data = yaml.load(open(yml_file, 'r'))
# Converts avi object types to avi resource types
data_lower_case = map(lambda x: x.lower(), yml_data['avi_resource_types'])
# Generates AVI resource types to avi object type mapping in form of dictionary.
path_key_map = dict(zip(data_lower_case, yml_data['avi_resource_types']))

warning_list = []

def get_name_and_entity(url):
    """
    Parses reference string to extract object type and
    :param url: reference url to be parsed
    :return: entity and object name
    """
    parsed = urlparse.urlparse(url)
    return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]


def filter_for_vs(avi_config, vs_names):
    """
    Filters vs and its references from full configuration
    :param avi_config: full configuration
    :param vs_names: comma separated vs names to filter
    :return: Filtered config dict
    """
    new_config = dict()
    new_config['META'] = avi_config['META']
    new_config['VirtualService'] = []
    virtual_services = vs_names.split(',')

    for vs_name in virtual_services:
        vs = [vs for vs in avi_config['VirtualService']
              if vs['name'] == vs_name]
        if not vs:
            vs_log = 'WARNING: VS object not found with name %s' % vs_name
            warning_list.append(vs_log)
            continue
        vs = vs[0]
        new_config['VirtualService'].append(vs)
        print '%s(VirtualService)' % vs_name
        find_and_add_objects(vs, avi_config, new_config, depth=0)

    for warn in warning_list:
        print("\033[1;33;50m  %s   \033[0m" %(warn))

    return new_config


def search_obj(entity, name, new_config, avi_config, depth):
    """
    Method to search referenced object
    :param entity: object type
    :param name: object name
    :param new_config: filtered config
    :param avi_config: full config
    :param depth: Recursion depth to determine level in the vs reference tree
    """

    avi_conf_key = path_key_map[entity]
    found_obj_list = avi_config[avi_conf_key]
    found_obj = [obj for obj in found_obj_list if obj['name'] == name]
    if found_obj:
        found_obj = found_obj[0]
        print (' | '*depth), '|- %s(%s)' % (name, path_key_map[entity])
    elif entity in ['applicationprofile', 'networkprofile', 'healthmonitor',
                    'sslkeyandcertificate', 'sslprofile']:
        if str.startswith(str(name), 'System-'):
            return
    elif entity == 'vrfcontext':
        return
    else:
        print 'WARNING: Reference not found for %s with name %s' % (entity, name)
        return
    if avi_conf_key in new_config:
        if not any(d['name'] == found_obj['name'] for d in
                   new_config[avi_conf_key]):
            new_config[avi_conf_key].append(found_obj)
    else:
        new_config[avi_conf_key] = [found_obj]
    depth += 1
    find_and_add_objects(found_obj, avi_config, new_config, depth)


def find_and_add_objects(obj_dict, avi_config, new_config, depth):
    """
    Method to iterate in one object find references and add those to output
    :param obj_dict: Object to be iterated over
    :param avi_config: Full config
    :param new_config: Filtered config
    :param depth: Recursion depth to determine level in the vs reference tree
    """
    for key in obj_dict:
        if (key.endswith('ref') and key not in ['cloud_ref', 'tenant_ref', 'se_group_ref']) \
                or key == 'ssl_profile_name':
            if not obj_dict[key]:
                continue
            entity, name = get_name_and_entity(obj_dict[key])
            search_obj(entity, name, new_config, avi_config, depth)
        elif key.endswith('refs'):
            for ref in obj_dict[key]:
                entity, name = get_name_and_entity(ref)
                search_obj(entity, name, new_config, avi_config, depth)
        elif isinstance(obj_dict[key], dict):
            find_and_add_objects(obj_dict[key], avi_config, new_config, depth)
        elif obj_dict[key] and isinstance(obj_dict[key], list) \
                and isinstance(obj_dict[key][0], dict):
            for member in obj_dict[key]:
                find_and_add_objects(member, avi_config, new_config, depth)
    return


if __name__ == '__main__':
    HELP_STR = '''
           Filters selected VS config and referenced objects from full config
           Example to filter single vs:
               vs_filter.py -f  Output.json -n cool_vs

           Example to filter single multiple vs:
               vs_filter.py -f  Output.json -n cool_vs,awesome_vs

           Example to print tree of referenced objects without writing the file:
               vs_filter.py -f  Output.json -n cool_vs,awesome_vs -p
           '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)
    parser.add_argument('-f', '--avi_config_file', required=True,
                        help='absolute path for avi config file')
    parser.add_argument('-n', '--vs_names', required=True,
                        help='comma separated names of virtualservices')
    parser.add_argument('-o', '--output_file_path', default='output',
                        help='folder location for output file')
    parser.add_argument('-p', '--print_only', action='store_true',
                        help='Only prints tree of object references and wont '
                             'generate the filter output json')

    args = parser.parse_args()
    avi_config_file = open(args.avi_config_file)
    old_avi_config = json.loads(avi_config_file.read())
    new_avi_config = filter_for_vs(old_avi_config, args.vs_names)

    if not args.print_only:
        output_dir = os.path.normpath(args.output_file_path)
        if not os.path.exists(args.output_file_path):
            os.mkdir(args.output_file_path)
        text_file = open(output_dir + os.path.sep + "FilterOutput.json", "w")
        json.dump(new_avi_config, text_file, indent=4)
        text_file.close()

        print '\nWritten filtered avi config file to:', \
            '%s%sFilterOutput.json' % (output_dir, os.path.sep)
