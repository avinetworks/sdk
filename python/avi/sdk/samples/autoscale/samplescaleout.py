#!/usr/bin/python
'''
Created on Apr 15, 2015

@author: Gaurav Rastogi
Avi Networks Inc.

It implements scaleout and scalein hooks that can be used for implementing scaleout and scalein workflow.

Usage:
Step 1: Create Alert with filter string to match on event SERVER_AUTOSCALE_IN or SERVER_AUTOSCALE_OUT as:
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_IN)"
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_OUT)"
Step 2: Register the scaleout and scalein hooks as alertactionscript
    action_script: "#!/usr/bin/python \nimport sys \nfrom avi.sdk.samples.autoscale.samplescaleout import scalein \nscalein(*sys.argv)"
    action_script: "#!/usr/bin/python \nimport sys \nfrom avi.sdk.samples.autoscale.samplescaleout import scaleout \nscaleout(*sys.argv)"

Step 3: Implement the ServerAutoScaleout and ServerAutoscaleIn hooks

Step 4: Monitor the output of the script as
    tail -F /home/<admin_user>/<AlertName>-<pool_name>-Log
    Eg. tail -F /home/admin/SERVER_AUTOSCALE_IN-p1-Log
'''
import sys
import json
import copy
from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from avi.sdk.samples.autoscale.heat_scaler import heat_stack_scale
from avi.protobuf.events_pb2 import SERVER_AUTOSCALE_IN, SERVER_AUTOSCALE_OUT,\
    EventId
from avi.protobuf.autoscale_mgr_rpc_pb2 import ServerAutoScaleStatus, \
    AutoScaleService_Stub
from google.protobuf.service import RpcController
from avi.protobuf.syserr_pb2 import SYSERR_SUCCESS
from avi.protobuf.common_pb2 import SCALEIN, SCALEOUT
from avi.protobuf.options_pb2 import V4
from avi.infrastructure.rpc_channel import RpcChannel
import time
import boto.ec2

def get_ssl_params_from_path(folder_path=''):
    print folder_path
    with open(folder_path + 'samples/certs/server.crt') as f:
        server_crt = f.read()
    with open(folder_path + 'samples/certs/server.key') as f:
        server_key = f.read()
    with open(folder_path + 'samples/certs/cakey.pem') as f:
        ca_key = f.read()
    with open(folder_path + 'samples/certs/cacert.pem') as f:
        ca_cert = f.read()
    return server_crt, server_key, ca_key, ca_cert

SDK_PATH = '/opt/avi/python/lib/avi/sdk/'
server_cert, server_key, ca_key, ca_cert = get_ssl_params_from_path(SDK_PATH)
API = None

HEAT_KWARGS = {'image': 'cirros', 'flavor': 'm1.tiny',
               'networks': 'avi-mgmt', 'passwd': 'blah', 'key': 'heat_key',
               'init': 1, 'sgrps': '844f5b1b-55c1-46ed-bab5-21e527da82e2',
               'metadata': {'name': 'siva','test':'heat trials'},
               'userdata': 'user=root;data=blah'}


def setup():
    global API
    API = ApiSession.get_session('127.0.0.1', 'admin', 'avi123', tenant='admin')
    ApiUtils(API).import_ssl_certificate('MyCert', server_key, server_cert)

setup()


def autoscale_dump(*args):
    print 'SCALEOUT: Num Args ', len(args), ' Args: ', args
    f = open('/tmp/scaleout.log', 'a')
    f.write('Num Args %d Args %s' % (len(args), str(args)))
    f.write('\n')
    alert_info = json.loads(args[1])
    print alert_info
    pool_uuid = ''
    for events in alert_info.get('events', []):
        event_details = events.get('event_details')
        if not event_details:
            continue
        scaleout_info = event_details.get('server_autoscaleout_info')
        if scaleout_info:
            pool_uuid = scaleout_info.get('pool_uuid')
            msg = 'Num Scaleout Servers %d for pool %s\n' % (
                scaleout_info.get('num_scaleout_servers'),
                pool_uuid)
            f.write(msg)
        scalein_info = event_details.get('server_autoscalein_info')
        if scalein_info:
            pool_uuid = scalein_info.get('pool_uuid')
            msg = 'Num Scaleout Servers %d for pool %s\n' % (
                scalein_info.get('num_scalein_servers'),
                pool_uuid)
            f.write(msg)
    f.close()


def scaleout_params(scaleout_type, alert_info):
    pool_name = alert_info.get('obj_name')
    print ' get pool obj for ', pool_name
    pool_obj = API.get_object_by_name('pool', pool_name)
    print 'returned pool obj', pool_obj
    pool_uuid = pool_obj['uuid']
    num_autoscale = 0
    for events in alert_info.get('events', []):
        event_details = events.get('event_details')
        if not event_details:
            continue
        autoscale_str = 'server_auto%s_info' % scaleout_type
        autoscale_info = event_details.get(autoscale_str)
        if not autoscale_info:
            continue
        num_autoscale_field = 'num_%s_servers' % scaleout_type
        num_autoscale = autoscale_info.get(num_autoscale_field)

    print (' Calling scaleout for ', pool_name, ':', pool_uuid,
           ' num scaleout', num_autoscale)
    return pool_name, pool_uuid, pool_obj, num_autoscale


def server_autoscale(api, pool_uuid, pool_obj, num_autoscale, action):
    for server in pool_obj['servers']:
        print ' checking server for autoscale', server
        if not num_autoscale:
            break
        print 'pool %s server %s' % (pool_obj['name'], server)
        if action == 'scaleout' and not server.get('enabled', True):
            server['enabled'] = True
        elif action == 'scalein' and server.get('enabled', True):
            server['enabled'] = False
        num_autoscale -= 1
    api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))


def create_aws_instance(ami_id, security_gid):
    conn = boto.ec2.connect_to_region(
        "us-west-2",
        aws_access_key_id='***REMOVED***',
        aws_secret_access_key='***REMOVED***')

    interface = boto.ec2.networkinterface.NetworkInterfaceSpecification(
        groups=[security_gid], associate_public_ip_address=True)
    interfaces = \
        boto.ec2.networkinterface.NetworkInterfaceCollection(interface)
    reservations = conn.run_instances(
        ami_id, instance_type='t2.micro',
        network_interfaces=interfaces)

    if not reservations.instances:
        return '', '', ''
    instance = reservations.instances[0]
    # Wait for the instance to enter the running state
    # check for instance is running
    while instance.update() != 'running':
        time.sleep(10)
    print instance.ip_address
    print instance.public_dns_name
    return instance.id, instance.ip_address, instance.public_dns_name


def delete_aws_instance(instance_ids):
    print 'deleting instances ', instance_ids
    conn = boto.ec2.connect_to_region(
        "us-west-2",
        aws_access_key_id='***REMOVED***',
        aws_secret_access_key='***REMOVED***')
    rc = conn.stop_instances(instance_ids=instance_ids)
    print 'stopping instances ', instance_ids, rc
    rc = conn.terminate_instances(instance_ids=instance_ids)
    print 'terminating instances ', instance_ids, rc


def scaleout(*args):
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_autoscale = \
        scaleout_params('scaleout', alert_info)
    if pool_name.find('heat') != -1:
        hkwargs = copy.deepcopy(HEAT_KWARGS)
        hkwargs['lbpool'] = pool_uuid.split('pool-')[1]
        hkwargs['name'] = pool_name + pool_uuid
        print 'calling heat'
        heat_stack_scale(up=True, **hkwargs)
    elif pool_name.find('autoscale-alertscript') != -1:
        print pool_name, 'enabling disabled pool members'
        server_autoscale(API, pool_uuid, pool_obj, num_autoscale,
                         'scaleout')
    elif pool_name.find('launch') != -1:
        # Send the launch complete notification
        time.sleep(5)
        astatus = ServerAutoScaleStatus()
        astatus.pool_uuid = pool_uuid
        astatus.status = SYSERR_SUCCESS
        astatus.ip.addr = '10.90.64.16'
        astatus.ip.type = V4
        astatus.action = SCALEOUT
        astatus.nscaleout = 1
        print '##########################################'
        print pool_uuid, 'calling scaleout launch done '
        AutoScaleService_Stub(RpcChannel()).NotifyAutoScaleStatus(
            RpcController(), astatus)
    elif pool_name.lower().find('aws') != -1:
        ami_id = 'ami-ac6491cc'
        security_gid = 'sg-ca682bad'
        # create AWS instance using these two ids.
        insid, ip_addr, hostname = create_aws_instance(ami_id, security_gid)
        new_server = {
            'ip': {'addr': ip_addr, 'type': 'V4'},
            'port': 0,
            'hostname': hostname,
            'external_uuid': insid
        }
        # add new server to the pool
        pool_obj['servers'].append(new_server)
        # call controller API to update the pool
        print 'new pool obj', pool_obj
        API.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))


def scalein(*args):
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_autoscale = \
        scaleout_params('scalein', alert_info)

    print (pool_name, ':', pool_uuid, ' num_scaleout', num_autoscale)
    if pool_name.find('heat') != -1:
        hkwargs = copy.deepcopy(HEAT_KWARGS)
        hkwargs['lbpool'] = pool_uuid.split('pool-')[1]
        hkwargs['name'] = pool_name + pool_uuid
        print pool_uuid, 'calling heat'
        heat_stack_scale(up=False, **hkwargs)
    elif pool_name.find('autoscale-alertscript') != -1:
        print pool_name, 'disabling enabled pool members'
        server_autoscale(API, pool_uuid, pool_obj, num_autoscale,
                         'scalein')
    elif pool_name.find('launch') != -1:
        # Send the launch complete notification
        time.sleep(5)
        astatus = ServerAutoScaleStatus()
        astatus.pool_uuid = pool_uuid
        astatus.status = SYSERR_SUCCESS
        astatus.ip.addr = '10.90.64.16'
        astatus.ip.type = V4
        astatus.action = SCALEIN
        astatus.nscalein = 1
        print '##########################################'
        print pool_uuid, 'calling scalein termination done '
        AutoScaleService_Stub(RpcChannel()).NotifyAutoScaleStatus(
            RpcController(), astatus)
        time.sleep(1)
    elif pool_name.lower().find('hsbc') != -1:
        # remove the last server from the pool
        scalein_server = pool_obj['servers'][-1]
        instance_ids = [scalein_server['external_uuid']]
        delete_aws_instance(instance_ids)
        pool_obj['servers'] = pool_obj['servers'][:-1]
        # call controller API to update the pool
        print 'new pool obj', pool_obj
        API.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))


def autoscale(*args):
    alert_info = json.loads(args[1])
    for events in alert_info.get('events', []):
        event_name = events['event_id']
        event_id = EventId.DESCRIPTOR.values_by_name[event_name].number
        if event_id == SERVER_AUTOSCALE_IN:
            scalein(*args)
        elif event_id == SERVER_AUTOSCALE_OUT:
            scaleout(*args)
        continue

if __name__ == '__main__':
    scaleout(*sys.argv)
