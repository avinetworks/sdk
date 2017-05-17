#!/usr/bin/python

import sys
import requests
import json
import copy
import os

alert_name = ""
virtualservice = ""
server_ip = ""
pool = ""
server = ""
controller = "localhost"
user = "admin"
password = "avi123"
tenant = "admin"

session = {}

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


def _LoginFailed(rsp):
    if rsp.status_code == 502:
        raise LoginUnknownError(rsp.text)
    elif rsp.status_code == 401:
        raise LoginCredentialsFailed(rsp.text)
    raise LoginUnknownError('Unknown error')


def Login(ws_addr='https://localhost', tenant='admin', user='admin',
          password='admin', token=None, timeout=30):
    '''
    At this time, we use username/password based authentication for most
    of the cases. Only when you log into the shell and we spawn the avi
    CLI, will we use the CHAP authentication at this time using a public
    key/private key pair.
    In both cases, we will use the login semantics to establish a session
    encoded in a cookie and will access resources using this
    '''
    # Get a CSRF token by touching the initial-data page
    rsp = requests.get(os.path.join(ws_addr, 'api/initial-data'), verify=False,
                       timeout=timeout)
    cookies = dict(rsp.cookies)
    headers = {
        'Content-Type' : 'application/json',
        'X-Avi-Tenant' : tenant,
        'Referer'      : ws_addr
    }

    if rsp.status_code != 200:
        _LoginFailed(rsp)
        return

    if 'csrftoken' in cookies:
        headers['X-CSRFToken'] = cookies['csrftoken']

    if not token:
        # Use a traditional login using username and password
        login_req = {'username' : user, 'password' : password}
        rsp = requests.post(os.path.join(ws_addr, 'login'), verify=False,
                            timeout=timeout, cookies=cookies,
                            headers=headers, data=json.dumps(login_req))
    else:
        login_req = {'username' : user, 'token' : token}
        rsp = requests.post(os.path.join(ws_addr, 'login'), verify=False,
                            timeout=timeout, cookies=cookies,
                            headers=headers, data=json.dumps(login_req))

    if rsp.status_code != 200:
        _LoginFailed(rsp)
        return

    # Cache the session id from the cookies
    cookies = dict(rsp.cookies)
    cookies['csrftoken'] = headers['X-CSRFToken']
    return (cookies, headers)

def _Api(ws_addr, method, uri, params={}, data={}, headers={}, timeout=10):
    '''
    Internal routine to perform the API given the controller IP address,
    HTTP method, query parameters and REST API URI
    Returns the response. 
    '''
    global session
    if not uri.startswith('http'):
        uri = ws_addr + uri

    _headers = copy.copy(session['headers'])
    if headers:
        _headers.update(headers)
    print('%s %s data=%s' % (method, uri, data))
    try:
        if method == 'GET':
            rsp = requests.get(uri, params=params,
                               headers=_headers,
                               cookies=session['cookies'],
                               timeout=timeout, verify=False)
        elif method == 'PUT':
            rsp = requests.put(uri, params=params,
                               data=json.dumps(data),
                               headers=_headers,
                               cookies=session['cookies'],
                               timeout=timeout, verify=False)
        elif method == 'POST':
            rsp = requests.post(uri, params=params,
                               data=json.dumps(data),
                               headers=_headers,
                               cookies=session['cookies'],
                               timeout=timeout, verify=False)
        elif method == 'DELETE':
            rsp = requests.delete(uri, params=params,
                               headers=_headers,
                               cookies=session['cookies'],
                               timeout=timeout, verify=False)
        else:
            raise Exception('Unknown http request %s' % method)
    except requests.exceptions.Timeout:
        print('Timeout in handling the request %s %s' % (method, uri))
        raise
    except requests.exceptions.ConnectionError as err:
        print('Error in contacting the controller %s' % err)
        raise

    return rsp

def _FindVsPoolByName(ws_addr, name=''):
    '''
    Find the Virtualservice by name.  
    '''
    params = {'name' : name }
    rsp = _Api(ws_addr, 'GET', '/api/virtualservice', params=params)
    if rsp.status_code != 200:
        raise Exception('Unable to find the virtualservice by name for %s' % name)
    rsp_dict = json.loads(rsp.text)
    if not rsp_dict.get('count', 0):
        return ('', '')
    vs = rsp_dict.get('results')[0]
    vs_uuid = vs.get('uuid', '')
    pool_uuid = os.path.basename(vs.get('pool_ref', ''))
    return (vs_uuid, pool_uuid)


def AddServersToVirtualservice(ws_addr, vs_name, new_server_list):
    '''
    Add backend servers to the pool. Backend servers are of the form
    ip_addr:port.
    This routine also allows you to add servers to a virtualservice
    '''
    uuid, pool_uuid = _FindVsPoolByName(ws_addr, name=vs_name)
    if not uuid or not pool_uuid:
        return
    pool_uri = '/api/pool/%s' % pool_uuid
    rsp = _Api(ws_addr, 'GET', pool_uri)
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

    _Api(ws_addr, method='PUT', uri=pool_uri, data=rsp_dict)

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

    ws_addr = ('https://'+controller
        if 'http' not in controller else controller)
    session['cookies'], session['headers'] = (
        Login(ws_addr, tenant, user, password))
    new_server_list = ['10.20.12.222:80']
    AddServersToVirtualservice(ws_addr, virtualservice, new_server_list)
    '''
