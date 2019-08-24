'''
Created on May 2, 2016

@author: grastogi
It implements scaleout and scalein hooks that can be used for implementing
scaleout and scalein workflow in VMware environment

Usage:
Step 1: Create Alert with filter string to match on event SERVER_AUTOSCALE_IN
    or SERVER_AUTOSCALE_OUT as:
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_IN)"
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_OUT)"
Step 2: Register the scaleout and scalein hooks as alertactionscript
    #action_script for scalein
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.vmware_samplescaleout import scalein

    vmware_settings = {
        'host': '10.10.2.10',
        'user': 'root',
        'password': 'something',
        'port_group': 'PG-964',
        'folder': None
        'resourcepool': None,
        'datastore': None
        }

    scalein(vmware_settings, *sys.argv)

    #action_script for scaleout
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.vmware_samplescaleout import scaleout

    vmware_settings = {
        'host': '10.10.2.10',
        'user': 'root',
        'password': 'something',
        'port_group': 'PG-964',
        'vm_template': 'pool-server'}
    scaleout(vmware_settings, *sys.argv)

Step 3: Monitor the output of the script as
    tail -F /home/<admin_user>/<AlertName>-<pool_name>-Log
    Eg. tail -F /home/admin/SERVER_AUTOSCALE_IN-p1-Log
'''

import sys
import json
from avi.sdk.avi_api import ApiSession
import time
from avi.sdk.samples.autoscale.samplescaleout import scaleout_params, \
    autoscale_dump
from pysphere import VIServer
import traceback
import uuid
import os
import ssl


default_context = ssl._create_default_https_context
ssl._create_default_https_context = ssl._create_unverified_context


def getAviApiSession(tenant='admin'):
    """
    create session to avi controller
    """
    token = os.environ.get('API_TOKEN')
    user = os.environ.get('USER')
    # tenant=os.environ.get('TENANT')
    api = ApiSession.get_session("localhost", user, token=token,
                                 tenant=tenant)
    return api


def create_vmware_connection(vmware_settings):
    try:
        server = VIServer()
        server.connect(vmware_settings['host'],
                       vmware_settings['user'],
                       vmware_settings['password'])
    except:
        print(traceback.format_exc())
        raise
    return server


def create_vmware_instance(vmware_settings, pool_name):
    """
    Create vmware instance with public IP address.
    :param vmware_settings: dictionary of vmware settings keys [name,
        user, password, port_group]
    :param pool_name: used for creating vms with pool name
    """
    conn = create_vmware_connection(vmware_settings)
    vm_name = vmware_settings['vm_template']
    new_vm_name = pool_name + '-' + str(uuid.uuid4())
    vm = conn.get_vm_by_name(vm_name)
    new_vm = vm.clone(new_vm_name,
                      folder=vmware_settings.get('folder', None),
                      resourcepool=vmware_settings.get('resourcepool', None),
                      datastore=vmware_settings.get('datastore', None))
    ip_address = ''
    for _ in range(20):
        # try for 5mins
        if new_vm.is_powered_on() and new_vm.get_property('net', False):
            net_intfs = new_vm.get_property('net', False)
            ip_addresses = \
                [net_intf['ip_addresses'][0]
                 for net_intf in net_intfs if (net_intf['network'] ==
                                               vmware_settings['port_group'])]
            ip_address = ip_addresses[0] if ip_addresses else ''
            if ip_address:
                break
        print('sleeping for vm to come up', new_vm_name, 'powered', new_vm.is_powered_on())
        time.sleep(15)

    if not ip_address:
        print('instance', new_vm.get_property('name'), ' is still not running')
        new_vm.power_off()
        new_vm.destroy()
        return '', ''
    return new_vm_name, ip_address


def delete_vmware_instance(vmware_settings, instance_ids):
    """
    deletes an istance from the vmware
    :param vmware_settings: dictionary of vmware settings keys [name,
        user, password, port_group]
    :param instance_ids: list of instance ids to delete. These are typically
    stored as hostname
    """
    print('deleting instances ', instance_ids)
    conn = create_vmware_connection(vmware_settings)
    for host in instance_ids:
        try:
            vm = conn.get_vm_by_name(host)
            vm.power_off()
            vm = conn.get_vm_by_name(host)
            vm.destroy()
            print('terminated instance', host)
        except Exception as e:
            print(traceback.format_exc())
            print(e)


def scaleout(vmware_settings, *args):
    """
    1. Creates an instance in vmware
    2. Registers that instance as a Pool Member
    :param vmware_settings: dictionary of vmware settings keys
        [vmware_access_key_id, vmware_secret_access_key, ec2_region,
        security_group_ids, instance_type, image_id]
    :param args: The args passed down as part of the alert.
    """
    # print all the args passed down
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    api = getAviApiSession()
    pool_name, pool_uuid, pool_obj, num_scaleout = \
        scaleout_params('scaleout', alert_info, api=api)
    # create vmware instance using these two ids.
    print(pool_name, 'scaleout', num_scaleout)
    hostname, ip_addr = create_vmware_instance(vmware_settings, pool_name)
    if not (hostname or ip_addr):
        print('not performing scaleout as could not create vm')
    new_server = {
        'ip': {'addr': ip_addr, 'type': 'V4'},
        'port': 0,
        'hostname': hostname,
    }
    # refresh the pool object
    pool_obj = api.get('pool/%s' % pool_uuid).json()
    # add new server to the pool
    pool_obj['servers'].append(new_server)
    # call controller API to update the pool
    print('new pool obj', pool_obj)
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print('updated pool %s num servers %s rcode %s' % (
          pool_obj['name'], len(pool_obj.get('servers', [])), resp.status_code))


def scalein(vmware_settings, *args):
    """
    Deletes an instance from vmware and removes it from the Pool
    :param vmware_settings: dictionary of vmware settings keys [vmware_access_key_id,
    vmware_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param args: The args passed down as part of the alert.
    """
    api = getAviApiSession()
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_autoscale = \
        scaleout_params('scalein', alert_info, api=api)
    print((pool_name, ':', pool_uuid, ' num_scaleout', num_autoscale))
    scalein_server = pool_obj['servers'][-1]
    instance_ids = [scalein_server['hostname']]
    pool_obj['servers'] = pool_obj['servers'][:-1]
    # call controller API to update the pool
    print('new pool obj', pool_obj)
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print('updated pool', pool_obj['name'], resp.status_code)
    if resp.status_code in (200, 201, 204):
        print('deleting the instance from the vmware - ', instance_ids)
        delete_vmware_instance(vmware_settings, instance_ids)

if __name__ == '__main__':
    scaleout(*sys.argv)
