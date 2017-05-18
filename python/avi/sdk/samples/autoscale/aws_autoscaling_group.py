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
    #action_script for scalein
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.aws_samplescaleout import scalein

    aws_setting = {
        'ec2_region': 'us-west-2',
        'tenant': 'Demo',
        'aws_access_key_id': 'xxxxx',
        'aws_secret_access_key': 'xxxxx',
        'image_id': 'ami-xxxxx',
        'security_group_ids': ['sg-xxxxx'],
        'subnet_id': 'subnet-xxxxx',
        'tag': 'avidemo',
        'key_name': None
    }
    scalein(aws_setting, *sys.argv)

    #action_script for scaleout
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.aws_samplescaleout import scaleout

    aws_setting = {
        'ec2_region': 'us-west-2',
        'tenant': 'Demo',
        'aws_access_key_id': 'xxxxx',
        'aws_secret_access_key': 'xxxxx',
        'image_id': 'ami-xxxxx',
        'security_group_ids': ['sg-xxxxx'],
        'subnet_id': 'subnet-xxxxx',
        'tag': 'avidemo',
        'key_name': None
    }
    scaleout(aws_setting, *sys.argv)

Step 3: Monitor the output of the script as
    tail -F /home/<admin_user>/<AlertName>-<pool_name>-Log
    Eg. tail -F /home/admin/SERVER_AUTOSCALE_IN-p1-Log
'''
import sys
import json
import time
import boto.ec2
from avi.sdk.samples.autoscale.samplescaleout import scaleout_params, \
    autoscale_dump, getAviApiSession
import boto.ec2.autoscale
from avi.sdk.samples.autoscale.aws_samplescaleout import (
    AviInstanceInfo, create_aws_connection)
from requests.packages import urllib3

urllib3.disable_warnings()


def create_autoscale_connection(aws_settings):
    """
    creates aws connection
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    """
    aws_access_key_id = aws_settings['aws_access_key_id']
    aws_secret_access_key = aws_settings['aws_secret_access_key']
    ec2_region = aws_settings.get('ec2_region', 'us-west-2')
    conn = boto.ec2.autoscale.connect_to_region(
        ec2_region, aws_access_key_id=aws_access_key_id,
        aws_secret_access_key=aws_secret_access_key)
    print('using: ', aws_access_key_id, aws_secret_access_key, ec2_region)
    return conn


def get_autoscaling_group(api, pool_obj):
    """
    fetchs the aws autoscaling group name from pool
    :param api:
    :param pool_obj:
    :return:
    """
    return 'grastogi-demo-asg'
    launch_cfg_ref = pool_obj['autoscale_launch_config_ref']
    launch_cfg_uuid = launch_cfg_ref.split('autoScalelaunchconfig')[1]
    launch_cfg = api.get('autoScalelaunchconfig/%s' % launch_cfg_uuid).json()
    autoscaling_group = launch_cfg['image_id']
    return autoscaling_group


def aws_autoscaling_scaleout(aws_settings, pool_obj, autoscaling_group,
                             desired_capacity, nscaleout):
    """

    :param aws_settings:
    :param pool_obj:
    :param autoscaling_group:
    :param desired_capacity:
    :return:
        array of tuples [insid, hostname, ip_addr]
    """
    new_instances = []
    print('For ', autoscaling_group, 'setting desired capacity',
        desired_capacity)
    aws_asconn = create_autoscale_connection(aws_settings)

    ec2_conn = create_aws_connection(aws_settings)

    aws_asconn.set_desired_capacity(
        autoscaling_group, desired_capacity=desired_capacity)
    # need to wait and add new servers to the list.
    asg_group = aws_asconn.get_all_groups([autoscaling_group])[0]
    pool_server_ids = set()
    for server in pool_obj['servers']:
        try:
            instance_id = server['external_uuid']
        except KeyError:
            vm_ref = server['vm_ref']
            instance_id = vm_ref.split('/api/vimgrvmruntime/')[1].split('#')[0]
        pool_server_ids.add(instance_id)

    new_instances = []
    for _ in range(25):
        # try for 2mins
        time.sleep(10)
        asg_group = aws_asconn.get_all_groups([autoscaling_group])[0]
        new_instances = [instance for instance in asg_group.instances
                         if instance.instance_id not in pool_server_ids]
        new_instances = \
            [instance for instance in new_instances
                if (instance.health_status == 'Healthy' and
                    instance.lifecycle_state == 'InService')]
        if len(new_instances) == nscaleout:
            print(('Autoscaling group %s has %s new instances %s'
                   % (autoscaling_group, len(new_instances), new_instances)))
            break
        time.sleep(10)

    new_instance_ids = [instance.instance_id for instance in new_instances]
    ec2_reservations = ec2_conn.get_all_instances(
        instance_ids=new_instance_ids)
    new_instances_db = {}
    for r in ec2_reservations:
        for instance in r.instances:
            new_instances_db[instance.id] = instance
    new_avi_servers = []
    for instance in new_instances:
        ins = new_instances_db.get(instance.instance_id, None)
        tag = '-'.join([aws_settings.get('tag', 'avidemo'),
                        ins.id])
        ins.add_tag('Name', tag)
        ins.update()
        ip_address = (ins.ip_address
                      if ins.ip_address else ins.private_ip_address)
        avi_inst_info = AviInstanceInfo(
            instance_id=ins.id, ip_address=ip_address, hostname=tag)
        new_avi_servers.append(avi_inst_info)
        print('Adding new instance ', avi_inst_info)
    return new_avi_servers


def scaleout(aws_settings, *args):
    """
    1. Creates an instance in AWS
    2. Registers that instance as a Pool Member
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param args: The args passed down as part of the alert.
    """
    # print all the args passed down
    tenant = aws_settings.get('tenant', 'admin')
    api = getAviApiSession(tenant)
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_scaleout = \
        scaleout_params('scaleout', alert_info, api=api, tenant=tenant)
    # create AWS instance using these two ids.
    print(pool_name, 'scaleout', num_scaleout)
    autoscaling_group = get_autoscaling_group(api, pool_obj)
    desired_capacity = len(pool_obj['servers']) + num_scaleout
    new_instances = aws_autoscaling_scaleout(
        aws_settings, pool_obj, autoscaling_group, desired_capacity,
        num_scaleout)
    for instance in new_instances:
        insid, ip_addr, hostname = instance
        new_server = {
            'ip': {'addr': ip_addr, 'type': 'V4'},
            'port': 0,
            'hostname': hostname,
            'external_uuid': insid,
            'vm_uuid': insid,
        }
        # add new server to the pool
        pool_obj['servers'].append(new_server)
    # call controller API to update the pool
    print('new pool obj', pool_obj)
    api = getAviApiSession()
    resp = api.put('pool/%s' % pool_uuid, tenant=tenant,
                   data=json.dumps(pool_obj))
    print('updated pool', pool_obj['name'], resp.status_code)


def delete_aws_autoscaling_instance(
        aws_settings, autoscaling_group, instance_ids):
    """
    deletes an istance from the aws
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param instance_ids: list of instance ids to delete. These are typically
    stored in the external uuid of the server.
    """
    print('deleting instances ', instance_ids)
    aws_asconn = create_autoscale_connection(aws_settings)
    for instance in instance_ids:
        rc = aws_asconn.terminate_instance(instance)
        print('terminating instance', instance, 'status', rc)
    # conn = create_aws_connection(aws_settings)
    # rc = conn.stop_instances(instance_ids=instance_ids)
    # print 'stopping instances ', instance_ids, rc
    # rc = conn.terminate_instances(instance_ids=instance_ids)


def scalein(aws_settings, *args):
    """
    Deletes an instance from AWS and removes it from the Pool
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param args: The args passed down as part of the alert.
    """
    tenant = aws_settings.get('tenant', 'admin')
    api = getAviApiSession(tenant)
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_autoscale = \
        scaleout_params('scalein', alert_info, api=api, tenant=tenant)
    print((pool_name, ':', pool_uuid, ' num_scaleout', num_autoscale))
    scalein_server = pool_obj['servers'][-1]
    autoscaling_group = get_autoscaling_group(api, pool_obj)
    try:
        instance_ids = [scalein_server['external_uuid']]
    except KeyError:
        vm_ref = scalein_server['vm_ref']
        # https://10.130.129.34/api/vimgrvmruntime/i-08ddf0d2
        vm_uuid = vm_ref.split('/api/vimgrvmruntime/')[1].split('#')[0]
        instance_ids = [vm_uuid]
    pool_obj['servers'] = pool_obj['servers'][:-1]
    # call controller API to update the pool
    print('pool %s scalein server %s' % (pool_name, scalein_server))
    api = getAviApiSession()
    resp = api.put('pool/%s' % pool_uuid, tenant=tenant, data=pool_obj)
    print('updated pool', pool_obj['name'], resp.status_code)
    if resp.status_code in (200, 201, 204):
        print('deleting the instance from the aws - ', instance_ids)
        delete_aws_autoscaling_instance(
            aws_settings, autoscaling_group, instance_ids)

if __name__ == '__main__':
    scaleout(*sys.argv)
