#!/usr/bin/python

import sys
import requests
import json
import copy
import os
from avi.sdk.avi_api import ApiSession

alert_name = ""
virtualservice = ""
server_ip = ""
pool = ""
server = ""
controller_ip = "localhost"
username = "admin"
password = "avi123"
tenant = "admin"

session = None

def ParseAviParams(argv):
    global alert_name, virtualservice, server_ip, pool, server
    '''
    ParseAviParams : Parses the parameters
    passed from AVI Controller for the raised
    Alert. As of now action script is invoked
    only for the "Server-Down" Alert. 
   
    A Server is associated with a Pool which is
    part of a Virtual Service. The Server name
    and the affected IP Address is also supplied
    as a parameter
    '''
    if len(argv) != 2:
        return
    alert_dict = json.loads(argv[1])
    alert_name = alert_dict['alert_name']
    virtualservice = alert_dict['virtualservice']
    server_ip = alert_dict['server_ip']
    pool = alert_dict['pool']
    server = alert_dict['server']
    print('Alert Name : %s' % (alert_name))
    print('Virtual Service Name : %s' % (virtualservice))
    print('Pool Name : %s' % (pool))
    print('Server Name : %s' % (server))
    print('Server IP : %s' % (server_ip))

class LoginUnknownError(Exception):
    pass

class LoginCredentialsFailed(Exception):
    pass

class TokenCredentialsFailed (Exception):
    pass

def _FindVsPoolByName(name=''):
    '''
    Find the Virtualservice by name.  
    '''
    params = {'name' : name }
    rsp = session.get('virtualservice', params=params)
    if rsp.status_code != 200:
        raise Exception('Unable to find the virtualservice by name for %s' % name)
    rsp_dict = json.loads(rsp.text)
    if not rsp_dict.get('count', 0):
        return ('', '')
    vs = rsp_dict.get('results')[0]
    vs_uuid = vs.get('uuid', '')
    pool_uuid = os.path.basename(vs.get('pool_ref', ''))
    return (vs_uuid, pool_uuid)


def AddServersToVirtualservice(vs_name, new_server_list):
    '''
    Add backend servers to the pool. Backend servers are of the form
    ip_addr:port.
    This routine also allows you to add servers to a virtualservice
    '''
    uuid, pool_uuid = _FindVsPoolByName(name=vs_name)
    if not uuid or not pool_uuid:
        return
    pool_uri = 'pool/%s' % pool_uuid
    rsp = session.get(pool_uri)
    if rsp.status_code != 200:
        raise Exception('Pool is not configured')
    rsp_dict = json.loads(rsp.text)
    servers = rsp_dict.get('servers', [])
    # transform the list to ip:port format
    server_list = []
    for server in servers:
        if not server.get('port', 0):
            srvr = server['ip']['addr']
        else:
            srvr = '%s:%s' % (server['ip']['addr'], server['port'])
        server_list.append(srvr)
    for server in new_server_list:
        if server not in server_list:
            server_list.append(server)
    # Reconvert the server list back to what needs to be in the
    # pool
    rsp_dict['servers'] = []
    for each in server_list:
        if ':' in each:
            server = each.split(':')[0]
            port = each.split(':')[1]
        else:
            server = each
            port = 0
        server_data = {}
        server_data['ip'] = {}
        server_data['ip']['type'] = 'V4'
        server_data['ip']['addr'] = server
        server_data['port'] = port
        rsp_dict['servers'].append(server_data)

    session.put(pool_uri, data=rsp_dict)

if __name__ == "__main__":
    '''
    Invoked by the AVI Controller when a "Server-Down"
    Alert is raised 
    (alert action configured as action_script)
    ''' 
    ParseAviParams(sys.argv)

    '''
    Code to perform operations on this raised alert
    needs to be added here. As an example we are
    adding a dummy server to the pool

    session = ApiSession(controller_ip, username, password)
    new_server_list = ['10.20.12.222:80']
    AddServersToVirtualservice(virtualservice, new_server_list)
    '''
