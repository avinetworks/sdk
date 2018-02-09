'''

@author: grastogi
It implements scaleout and scalein hooks that can be used for implementing
scaleout and scalein by enabling and disabling existing servers.

Usage:
Step 1: Create Alert with filter string to match on event SERVER_AUTOSCALE_IN
    or SERVER_AUTOSCALE_OUT as:
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_IN)"
    filter_string: "filter=eq(event_id,SERVER_AUTOSCALE_OUT)"
Step 2: Register the scaleout and scalein hooks as alertactionscript
    #action_script for scalein
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.autoscale_enable_disable import scalein

    scalein(*sys.argv)

    #action_script for scaleout
    #!/usr/bin/python
    import sys
    from avi.sdk.samples.autoscale.autoscale_enable_disable import scaleout

    scaleout(*sys.argv)

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
import traceback
import uuid
import os
from requests.packages import urllib3

urllib3.disable_warnings()

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

def scaleout(*args):
    """
    1. Creates an instance in vmware
    2. Registers that instance as a Pool Member
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
    print(pool_name, 'num_scaleout', num_scaleout)
    # Find existing server that is disabled
    for s in pool_obj['servers']:
        if not num_scaleout:
            print ('no more servers needed to be scaledout')
            break
        if not s['enabled']:
            s['enabled'] = True
            num_scaleout = num_scaleout - 1
            print (pool_name, 'updated server ', s['hostname'], s['enabled'])
    if num_scaleout:
        print(pool_name, 'could not scaleout', num_scaleout, 'servers')
    # call controller API to update the pool
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print('updated pool', pool_obj['name'], resp.status_code)


def scalein(*args):
    """
    Deletes an instance from vmware and removes it from the Pool
    :param args: The args passed down as part of the alert.
    """
    api = getAviApiSession()
    autoscale_dump(*args)
    alert_info = json.loads(args[1])
    # Perform actual scaleout
    pool_name, pool_uuid, pool_obj, num_scalein = \
        scaleout_params('scalein', alert_info, api=api)
    print(pool_name, 'num_scalein', num_scalein)
    # Find existing server that is disabled
    num_servers = len(pool_obj['servers'])
    for index in xrange(num_servers):
        s = pool_obj['servers'][num_servers - index - 1]
        if not num_scalein:
            print ('no more servers needed to be scaledout')
            break
        if s['enabled']:
            s['enabled'] = False
            num_scalein = num_scalein - 1
            print (pool_name, 'updated server ', s['hostname'], s['enabled'])
    if num_scalein:
        print(pool_name, 'could not scalein', num_scalein, 'servers')
    # call controller API to update the pool
    resp = api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
    print('updated pool', pool_name, resp.status_code)

if __name__ == '__main__':
    scaleout(*sys.argv)
