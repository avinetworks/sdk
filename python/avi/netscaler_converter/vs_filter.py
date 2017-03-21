import argparse
import json
import os
import urlparse

path_key_map = {'poolgroup': 'PoolGroup', 'healthmonitor': 'HealthMonitor',
                'sslprofile': 'SSLProfile', 'httppolicyset': 'HTTPPolicySet',
                'sslkeyandcertificate': 'SSLKeyAndCertificate', 'pool': 'Pool',
                'networkprofile': 'NetworkProfile', 'pkiprofile': 'PKIProfile',
                'stringgroup': 'StringGroup', 'vrfcontext': 'VrfContext',
                'applicationprofile': 'ApplicationProfile', 'vsdatascriptset':
                    'VSDataScriptSet', 'networksecuritypolicy':
                    'NetworkSecurityPolicy', 'applicationpersistenceprofile':
                    'ApplicationPersistenceProfile'
                }


def get_name_and_entity(url):
    parsed = urlparse.urlparse(url)
    return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]


def filter_for_vs(avi_config, vs_name):
    new_config = dict()
    vs = [vs for vs in avi_config['VirtualService'] if vs['name'] == vs_name]
    if not vs:
        raise 'VS object not found with name %s' % vs_name
    vs = vs[0]
    new_config['META'] = avi_config['META']
    new_config['VirtualService'] = [vs]
    find_and_add_objects(vs, avi_config, new_config)
    return new_config


def search_obj(entity, name, new_config, avi_config):
    avi_conf_key = path_key_map[entity]
    found_obj_list = avi_config[avi_conf_key]
    found_obj = [obj for obj in found_obj_list if obj['name'] == name]
    if found_obj:
        found_obj = found_obj[0]
    else:
        raise 'Reference not found for %s with name %s' % (entity, name)
    if avi_conf_key in new_config:
        if not any(d['name'] == found_obj['name'] for d in
                   new_config[avi_conf_key]):
            new_config[avi_conf_key].append(found_obj)
    else:
        new_config[avi_conf_key] = [found_obj]
    find_and_add_objects(found_obj, avi_config, new_config)


def find_and_add_objects(object, avi_config, new_config):
    for key in object:
        if (key.endswith('ref') and key not in ['cloud_ref', 'tenant_ref']) \
                or key == 'ssl_profile_name':
            if not object[key]:
                continue
            entity, name = get_name_and_entity(object[key])
            search_obj(entity, name, new_config, avi_config)
        elif key.endswith('refs'):
            for ref in object[key]:
                entity, name = get_name_and_entity(ref)
                search_obj(entity, name, new_config, avi_config)
        elif isinstance(object[key], dict):
            find_and_add_objects(object[key], avi_config, new_config)
        elif object[key] and isinstance(object[key], list) \
                and isinstance(object[key][0], dict):
            for member in object[key]:
                find_and_add_objects(member, avi_config, new_config)
    return


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--avi_config_file', required=True,
                        help='absolute path for avi config file')
    parser.add_argument('-n', '--vs_name', required=True,
                        help='Name of VirtualService')
    parser.add_argument('-o', '--output_file_path', default='output',
                        help='folder location for output file')
    args = parser.parse_args()
    avi_config_file = open(args.avi_config_file)
    old_avi_config = json.loads(avi_config_file.read())
    new_avi_config = filter_for_vs(old_avi_config, args.vs_name)

    output_dir = os.path.normpath(args.output_file_path)
    text_file = open(output_dir + os.path.sep + "FilterOutput.json", "w")
    json.dump(new_avi_config, text_file, indent=4)
    text_file.close()
    print 'written avi config file ' + output_dir + \
          os.path.sep + "FilterOutput.json"