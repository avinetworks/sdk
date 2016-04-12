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
        'aws_access_key_id': 'AKIkkkkkkkkkkkkkkk',
        'aws_secret_access_key': 'XUsxkkkkkkkkkkkkkkkkkkkk',
        'image_id': 'ami-kkkkkkk',
        'security_group_ids': ['sg-ca68xxx']
    }
    scalein(aws_setting, *sys.argv)

    #action_script for scaleout
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.aws_samplescaleout import scaleout

    aws_setting = {
        'aws_access_key_id': 'AKIkkkkkkkkkkkkkkk',
        'aws_secret_access_key': 'XUsxkkkkkkkkkkkkkkkkkkkk',
        'image_id': 'ami-kkkkkkk',
        'security_group_ids': ['sg-ca68xxx']
    }
    scaleout(aws_setting, *sys.argv)

Step 3: Monitor the output of the script as
    tail -F /home/<admin_user>/<AlertName>-<pool_name>-Log
    Eg. tail -F /home/admin/SERVER_AUTOSCALE_IN-p1-Log
'''
import sys
import json
from avi.sdk.avi_api import ApiSession
import time
import boto.ec2
from avi.sdk.samples.autoscale.samplescaleout import scaleout_params, \
    autoscale_dump

API = None


def getAviApiSession():
    """
    create session to avi controller
    """
    global API
    if not API:
        API = ApiSession.get_session(
                '127.0.0.1', 'admin', 'avi123', tenant='admin')
    return API


def create_aws_connection(aws_settings):
    """
    creates aws connection
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    """
    aws_access_key_id = aws_settings['aws_access_key_id']
    aws_secret_access_key = aws_settings['aws_secret_access_key']
    ec2_region = aws_settings.get('ec2_region', 'us-west-2')
    print 'using: ', aws_access_key_id, aws_secret_access_key, ec2_region
    conn = boto.ec2.connect_to_region(
        ec2_region, aws_access_key_id=aws_access_key_id,
        aws_secret_access_key=aws_secret_access_key)
    print 'connection obj', conn
    return conn


def create_aws_instance(aws_settings):
    """
    Create AWS instance with public IP address.
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    """
    ami_id = aws_settings['image_id']
    security_groups = aws_settings['security_group_ids']
    instance_type = aws_settings.get('instance_type', 't2.micro')
    conn = create_aws_connection(aws_settings)

    interface = boto.ec2.networkinterface.NetworkInterfaceSpecification(
        groups=security_groups, associate_public_ip_address=True)
    interfaces = \
        boto.ec2.networkinterface.NetworkInterfaceCollection(interface)
    print ami_id, interfaces
    reservations = conn.run_instances(
        ami_id, instance_type=instance_type, network_interfaces=interfaces)
    if not reservations.instances:
        return '', '', ''
    instance = reservations.instances[0]
    # Wait for the instance to enter the running state
    # check for instance is running
    for _ in xrange(25):
        # try for 2mins
        rc = instance.update()
        if rc == 'running':
            break
        time.sleep(5)
    if rc != 'running':
        print 'instance', instance.id, ' is still not running', rc
    print 'created', instance.id, instance.ip_address, instance.public_dns_name
    return instance.id, instance.ip_address, instance.public_dns_name


def delete_aws_instance(aws_settings, instance_ids):
    """
    deletes an istance from the aws
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param instance_ids: list of instance ids to delete. These are typically
    stored in the external uuid of the server.
    """
    print 'deleting instances ', instance_ids
    conn = create_aws_connection(aws_settings)
    rc = conn.stop_instances(instance_ids=instance_ids)
    print 'stopping instances ', instance_ids, rc
    rc = conn.terminate_instances(instance_ids=instance_ids)
    print 'terminating instances ', instance_ids, rc


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
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_scaleout = \
        scaleout_params('scaleout', alert_info)
    # create AWS instance using these two ids.
    print pool_name, 'scaleout', num_scaleout
    insid, ip_addr, hostname = create_aws_instance(aws_settings)
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
    api = getAviApiSession()
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print 'updated pool', pool_obj['name'], resp.status_code


def scalein(aws_settings, *args):
    """
    Deletes an instance from AWS and removes it from the Pool
    :param aws_settings: dictionary of aws settings keys [aws_access_key_id,
    aws_secret_access_key, ec2_region, security_group_ids, instance_type,
    image_id]
    :param args: The args passed down as part of the alert.
    """
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_autoscale = \
        scaleout_params('scalein', alert_info)
    print (pool_name, ':', pool_uuid, ' num_scaleout', num_autoscale)
    scalein_server = pool_obj['servers'][-1]
    instance_ids = [scalein_server['external_uuid']]
    pool_obj['servers'] = pool_obj['servers'][:-1]
    # call controller API to update the pool
    print 'new pool obj', pool_obj
    api = getAviApiSession()
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print 'updated pool', pool_obj['name'], resp.status_code
    if resp.status_code in (200, 201, 204):
        print 'deleting the instance from the aws - ', instance_ids
        delete_aws_instance(aws_settings, instance_ids)

if __name__ == '__main__':
    scaleout(*sys.argv)
