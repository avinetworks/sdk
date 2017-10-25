#!/usr/bin/python
import copy, json, os, string, sys, urlparse
from avi.sdk.avi_api import ApiSession

RULE_NAME=string.Template("Rule--${name}--${tag}")
POOL_NAME=string.Template("Pool--${name}--${tag}")

def slug_from_uri(uri):
    if not uri or '/' not in uri:
        return uri

    o = urlparse.urlparse(uri)
    path = o.path
    #assume url
    uuid = os.path.basename(path)
    if '#' in uuid:
        uuid = uuid.split('#')[0]
    return uuid

def ParseCUDParams(argv):
    if len(argv) != 2:
        return
    cud_info = json.loads(argv[1])
    return cud_info

def get_avi_session():
    t = os.environ.get('API_TOKEN')
    u = os.environ.get('USER')
    return ApiSession.get_session("localhost", u, token=t, tenant='admin')

def extract_event_details(vs_cfg_dict):
    new_data = None
    old_data = None

    if 'events' not in vs_cfg_dict:
        print "No events found in input: %s"%vs_cfg_dict
        return new_data, old_data

    for event in vs_cfg_dict['events']:
        obj_uuid = event['obj_uuid']
        ev_id = event['event_id']
        ev_det = event.get('event_details', None)
        if ev_id not in ['CONFIG_CREATE', 'CONFIG_UPDATE', 'CONFIG_DELETE']:
            print "Unexpected event: %s"%ev_id
            continue

        if not obj_uuid or 'virtualservice-' not in obj_uuid or not ev_det:
            print "Unexpected data found: %s, %s"%(obj_uuid, ev_det)
            continue

        #print 'VS Event: ' + ev_id + ' for ' + event['obj_name']
        new_data = ev_det.get('config_create_details', dict()).get('resource_data', None)
        new_data = new_data or ev_det.get('config_update_details', dict()).get('new_resource_data', None)
        old_data = ev_det.get('config_update_details', dict()).get('old_resource_data', None)
        old_data = old_data or ev_det.get('config_delete_details', dict()).get('resource_data', None)
        if not new_data and not old_data:
            print "No new or old data found! %s, %s"%(new_data, old_data)
            continue

        new_data = json.loads(new_data) if new_data else dict()
        old_data = json.loads(old_data) if old_data else dict()

    return new_data, old_data

def extract_rule_info(vs_cfg_dict):
    n, o = extract_event_details(vs_cfg_dict)
    if not n and not o:
        return

    to_update = None
    to_remove = None
    if n and n.get('service_metadata', ''):
        # Policies to add/update
        n_hdr_host = json.loads(n['service_metadata']).get('host', '')
        n_hdr_path = json.loads(n['service_metadata']).get('path', '/')
        if n_hdr_host:
            to_update = {
                "host": n_hdr_host,
                "path": n_hdr_path
            }

    if o and o.get('service_metadata', ''):
        # Policies to remove
        o_hdr_host = json.loads(o['service_metadata']).get('host', '')
        o_hdr_path = json.loads(o['service_metadata']).get('path', '/')
        if o_hdr_host and not to_update:
            to_remove = {
                "host": o_hdr_host,
                "path": o_hdr_path
            }
    return n or o, to_update, to_remove

def aws_get_httppolicy_for_aws_vs(session):
    # We will just pick the first AWS VS in AWS Cloud
    avi_clouds = session.get('cloud')
    aws_cloud_uuid = ''
    if avi_clouds.status_code == 200:
        for cloud in avi_clouds.json()['results']:
            if cloud['vtype'] == 'CLOUD_AWS':
                #print "Found AWS Cloud: %s (%s)"%(cloud['uuid'], cloud['vtype'])
                aws_cloud_uuid = cloud['uuid']
                break

    if not aws_cloud_uuid:
        print "No AWS Cloud found, pls configure one for this control script"
        return '', ''

    vss = session.get('virtualservice?cloud_ref.uuid=%s'%aws_cloud_uuid)
    need_http_policy = False
    http_policy = {}
    http_policy_set_ref = ''
    vs_update_needed = True
    cloud_ref = ''
    vrf_ref = ''
    if vss.status_code == 200 and vss.json()['results']:
        vs = vss.json()['results'][0]
        cloud_ref = vs['cloud_ref']
        vrf_ref = vs['vrf_context_ref']
        vs_http = vs.get('http_policies', None)

        hps_name = vs['name'] + '-httppolicyset'
        http_policy_res = session.get('httppolicyset?name=%s'%hps_name)
        if http_policy_res.status_code == 200:
            http_policies = http_policy_res.json()['results']
            http_policy_set_ref = http_policies[0]['uuid'] if http_policies else ''

        if not vs_http and not http_policy_set_ref:
            need_http_policy = True
        elif vs_http:
            http_policy_uuid = slug_from_uri(vs_http[0]['http_policy_set_ref'])
            http_policy = session.get('httppolicyset/%s'%http_policy_uuid).json()
            #print "Found HTTPPolicySet %s"%http_policy_uuid
            vs_update_needed = False
    else:
        print "No valid AWS VS found, pls configure one for this control script."
        return '', ''

    #print "HTTP? %s, VS? %s, HTTP ref? %s"%(need_http_policy,
    #        vs_update_needed, http_policy_set_ref)

    if need_http_policy:
        http_policy = {
            'name': vs['name']+'-httppolicyset',
            'tenant_ref': '/api/tenant/admin',
            'created_by': 'ControlScript'}
        http_policy_res = session.post('httppolicyset', data=http_policy)
        if http_policy_res.status_code / 2 == 100:
            http_policy = http_policy_res.json()
            http_policy_set_ref = http_policy['url']
        else:
            print "Creation of HTTPPolicy failed with %d: %s"%(
                    http_policy.status_code, http_policy.text)
            http_policy = {}

    if vs_update_needed and http_policy_set_ref:
        vs.update({'http_policies': [{'index': 12, 'http_policy_set_ref': http_policy_set_ref}]})
        out = session.put('virtualservice/%s'%vs['uuid'], data=vs)
        if out.status_code/2 != 100:
            print "Association of HTTPPolicy failed with %d: %s"%(
                    out.status_code, out.text)
            http_policy = {}
    return http_policy, cloud_ref, vrf_ref

def update_http_policy_rule(session, vs_cfg_dict):
    vs_info, update, delete = extract_rule_info(vs_cfg_dict)
    if not update and not delete:
        # Nothing to do
        return

    aws_httppolicy, cloud_ref, vrf_ref = aws_get_httppolicy_for_aws_vs(session)
    if not aws_httppolicy:
        print "No valid HTTPPolicy found in AWS Cloud to update"
        return

    pool_name_servers = dict()
    rule_names = dict()
    rule_name_indices = dict()
    pool_name_jsons = dict()
    pool_name_svc_port = dict()
    for svc in vs_info['services']:
        #TODO: Handle same port different protocols
        rule_name = RULE_NAME.substitute(
                name=vs_info['name'], tag='%s'%svc['port'])
        pool_name = POOL_NAME.substitute(
                name=vs_info['name'], tag='%s'%svc['port'])
        rule_names[rule_name] = pool_name
        pool_name_servers[pool_name] = list()
        for v in vs_info['vip']:
            pool_name_servers[pool_name].append({
                    'ip': {
                        'addr': v['ip_address']['addr'],
                        'type': 'V4'
                    },
                    'port': svc['port']
                })
        pool_name_svc_port[pool_name] = svc['port']
        pool_jsons = session.get('pool?name=%s'%pool_name).json()['results']
        if pool_jsons:
            pool_name_jsons[pool_name] = pool_jsons[0]

    # Walk through HTTPPolicy and update rules
    http_policy_new = copy.deepcopy(aws_httppolicy)
    if 'http_request_policy' in http_policy_new:
        http_policy_new['http_request_policy'].pop('rules', None)
    else:
        http_policy_new['http_request_policy'] = dict()
    http_policy_new['http_request_policy']['rules'] = []

    old_index = None
    indices_used = set()
    possible_indices = set(xrange(0, 1000))
    for orule in aws_httppolicy.get('http_request_policy', dict()).get('rules', []):
        if any(r in orule['name'] for r in rule_names.keys()):
            rule_name_indices[orule['name']] = orule['index']
        else:
            http_policy_new['http_request_policy']['rules'].append(orule)
            indices_used.add(orule['index'])
    free_indices = possible_indices - indices_used

    servers = dict()
    if update:
        # Always update pools with current set of servers (no add/delete/patch) 
        for pname, pservers in pool_name_servers.iteritems():
            if pname in pool_name_jsons:
                pool_name_jsons[pname].pop('servers', None)
                pool_name_jsons[pname]['servers'] = pservers
                pool_cfg = pool_name_jsons[pname]
            else:
                pool_cfg = {
                    'name': pname,
                    'servers': pservers,
                    'health_monitor_refs': ['/api/healthmonitor?name=System-Ping'],
                    'tenant_ref': vs_info['tenant_ref'],
                    'cloud_ref': cloud_ref,
                    'vrf_ref': vrf_ref
                }
            pool_uuid = pool_cfg.get('uuid', '')
            pool_new = session.put('pool/%s'%pool_uuid, data=pool_cfg) \
                    if pool_uuid else session.post('pool', data=pool_cfg)
            pool_ref = pool_new.json()['url']

            # Walk through HTTPPolicy and update rules
            for rn, pn in rule_names.iteritems():
                if pn == pname:
                    break

            index_to_use = rule_name_indices[rn] \
                    if rn in rule_name_indices else free_indices.pop()

            rule = {
                'name': rn,
                'index': index_to_use,
                'enable': True,
                'switching_action': {'action': 1, 'pool_ref': pool_ref},
                'match': {
                    'host_hdr': {'match_criteria': 9, 'value': [update['host']]},
                    'path': {'match_criteria': 1, 'match_str': [update['path']]},
                    'vs_port': {'match_criteria': 0, 'ports': [pool_name_svc_port[pname]]}
                }
            }
            http_policy_new['http_request_policy']['rules'].append(rule)

    # Update HTTPPolicySet object now
    out = session.put('httppolicyset/%s'%http_policy_new['uuid'], data=http_policy_new)
    if out.status_code != 200:
        print "HTTPPolicy PUT failed with %d, %s"%(out.status_code, out.text)

    # Rules/VS got deleted
    if delete:
        # Delete associated pools as well
        for pname, pcfg in pool_name_jsons.iteritems():
            puuid = pcfg['uuid']
            out = session.delete('pool/%s'%puuid)
            if out.status_code not in [204, 404]:
                print "Pool %s delete status: %s"%(puuid, out.status_code)

if __name__ == "__main__":
    vs_cfg_dict = ParseCUDParams(sys.argv)
    try :
        api_session = get_avi_session()
    except Exception as e:
        print('login failed to Avi Controller!' + str(e))
        sys.exit(0)
    update_http_policy_rule(api_session, vs_cfg_dict)
