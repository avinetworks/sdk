import json
import urlparse

path_key_map = {'poolgroup': 'PoolGroup', 'healthmonitor': 'HealthMonitor',
                'sslprofile': 'SSLProfile', 'httppolicyset': 'HTTPPolicySet',
                'sslkeyandcertificate': 'SSLKeyAndCertificate', 'pool': 'Pool',
                'applicationpersistenceprofile':
                    'ApplicationPersistenceProfile'}


def get_name_and_entity(url):
    parsed = urlparse.urlparse(url)
    return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]


def filter_for_vs(avi_config, vs_name):
    count = 0
    new_config = dict()
    vs = [vs for vs in avi_config['VirtualService'] if vs['name'] == vs_name]
    vs = vs[0]
    new_config['META'] = avi_config['META']
    new_config['VirtualService'] = [vs]
    find_and_add_objects(vs, avi_config, new_config, count)
    print new_config


def find_and_add_objects(object, avi_config, new_config, count):
    count += 1
    for key in object:
        print count,key
        if (key.endswith('ref') and key !=
                'tenant_ref') or key == 'ssl_profile_name':
            entity, name = get_name_and_entity(object[key])
            # print entity, name
            found_obj_list = avi_config[path_key_map[entity]]
            found_obj = [obj for obj in found_obj_list if obj['name'] == name]
            if found_obj:
                found_obj = found_obj[0]
            else:
                raise 'Reference not found for %s with name %s' % (entity, name)
            if path_key_map[entity] in new_config:
                new_config[path_key_map[entity]].append(found_obj)
            else:
                new_config[path_key_map[entity]] = [found_obj]
            find_and_add_objects(found_obj, avi_config, new_config, count)
        elif key.endswith('refs'):
            for ref in object[key]:
                entity, name = get_name_and_entity(ref)
                print entity, name
                found_obj_list = avi_config[path_key_map[entity]]
                found_obj = [obj for obj in found_obj_list if
                             obj['name'] == name]
                if found_obj:
                    found_obj = found_obj[0]
                else:
                    raise 'Reference not found for %s with name %s' % (
                    entity, name)
                if path_key_map[entity] in new_config:
                    new_config[path_key_map[entity]].append(found_obj)
                else:
                    new_config[path_key_map[entity]] = [found_obj]
                find_and_add_objects(found_obj, avi_config, new_config, count)
        elif isinstance(object[key], dict):
            find_and_add_objects(object[key], avi_config, new_config, count)
        elif object[key] and isinstance(object[key], list) \
                and isinstance(object[key][0], dict):
            for member in object[key]:
                find_and_add_objects(member, avi_config, new_config, count)
    return


if __name__ == '__main__':
    filepath = 'D:\\CD\\Avi\\NetscalerConverter\\test\\Output.json'
    avi_config_file = open(filepath)
    avi_config = json.loads(avi_config_file.read())
    filter_for_vs(avi_config, 'epb_443_csvs')