import keystoneclient.v2_0.client as ksclient
import heatclient.client as hclient
from heatclient.common import utils
from heatclient.common import template_utils
import json
import logging
import time

# imp to tweak this param
cooldown = 5

# http://developer.openstack.org/api-ref-orchestration-v1.html

def heat_init(node='10.10.184.2', uname='admin', passwd='admin', tenant='admin', 
    sch='http', region='RegionOne', tmo=120):
    authurl = '%s://%s:5000/v2.0' % (sch, node)
    ksc     = ksclient.Client(username=uname, password=passwd, tenant_name=tenant, 
                auth_url=authurl, timeout=tmo, insecure=True, region_name=region)
    heatep  = '%s://%s:8004/v1/%s' % (sch, node, ksc.tenant_id)
    hc      = hclient.Client('1', endpoint=heatep, token=ksc.auth_token, timeout=tmo,
                insecure=True, region_name=region, username=uname, password=passwd,
                include_pass=True)
    return hc

# read params from ENV/rc file
def _heat_get_env():
    env = {'username': 'admin', 'password': 'admin', 'tenant': 'admin', 
           'host': '10.10.184.2', 'scheme': 'http', 'region': 'RegionOne',
           'env-file': ['/opt/avi/python/lib/avi/sdk/samples/heat/lb-env.yaml'], 'template-file': '/opt/avi/python/lib/avi/sdk/samples/heat/lb-asg.yaml'}
    return env

def heat_stack_exists(hc, name):
    for stk in hc.stacks.list(name=name):
        if stk.stack_name == name:
            return stk
    return None

def heat_stack_create(hc, env, name, params):
    tf, t = template_utils.get_template_contents(env['template-file'])
    ef, e = template_utils.process_multiple_environments_and_files(env_paths=env['env-file'])
    px    = utils.format_all_parameters(params, None, template_file=env['template-file'])
    data  = {'stack_name' : name, 
             'parameters' : px, 
             'template'   : t, 
             'files'      : dict(list(tf.items()) + list(ef.items())), 
             'environment': e}
    stk   = hc.stacks.create(**data)
    return stk

def heat_stack_delete(hc, name):
    for stk in hc.stacks.list(name=name):
        if stk.stack_name == name:
            hc.stacks.delete(stk.id)    

def heat_stack_scale(name, image, flavor, networks, passwd, key, lbpool,
    sgrps=None, metadata=None, userdata=None, init=1, count=1, up=True):
    env = _heat_get_env()
    hc  = heat_init()
    stk = heat_stack_exists(hc, name)
    if not stk and up:
        # ignore init in params - allows create to be fast
        params = ['cooldown='+str(cooldown), 'admin_pass='+passwd, 'key_name='+key, 
                  'flavor='+flavor, 'image='+image, 'pool_id='+lbpool, 
                  'init=0', 'network='+str(networks), 
                  'metadata='+json.dumps(metadata), 
                  'security_group='+str(sgrps), 'user_data='+userdata]
        stk = heat_stack_create(hc, env, name, params)['stack']
        stk = hc.stacks.get(stk['id'])
        # sleep atleast cooldown - else scaleup is ignored
        time.sleep(cooldown)
    if stk:
        sup = sdn = None
        for i in hc.resources.list(stk.id):
            if i.resource_type != 'OS::Heat::ScalingPolicy':
                continue
            if i.logical_resource_id == 'scale_up_policy':
                sup = i
            elif i.logical_resource_id == 'scale_down_policy':
                sdn = i
        if up and sup:
            print('triggering scale_up')
            hc.resources.signal(stk.id, sup.logical_resource_id)
        elif not up and sdn:
            print('triggering scale_down')        
            hc.resources.signal(stk.id, sdn.logical_resource_id)
        else:
            print('scaling policy not found for stack %s' % name)
    return

if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)
    hc   = heat_init()
    name = 'avi-heat-asg'
    args = {'name'    : name, 'image': 'cirros', 'flavor': 'm1.tiny', 
            'networks': 'avi-mgmt', 'passwd': 'blah', 'key': 'heat_key', 'init':1, 
            'sgrps'   : '844f5b1b-55c1-46ed-bab5-21e527da82e2', 
            'lbpool'  : 'b2c15882-a253-4208-b530-e9b5150ccd61',
            'metadata': {'name':'siva','test':'heat trials'},
            'userdata': 'user=root;data=blah'}
    print('create and scale up stack')
    heat_stack_scale(up=True, **args)
    for i in hc.stacks.list():
      print(i)
    print('sleep and scale down stack')
    time.sleep(120)    
    heat_stack_scale(up=False, **args)
    print('sleep and tear down stack')
    time.sleep(120)    
    heat_stack_delete(hc, name)
    for i in hc.stacks.list():
      print(i)
