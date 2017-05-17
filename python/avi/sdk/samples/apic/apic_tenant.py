#!/usr/bin/python

import json
import sys

sys.path.insert(1,  '../')

from .apic_client import APICClient
from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils


tenant_config = None
admin_session = None
apic_session = None

def load_tenant_config():
    global tenant_config
    with open( 'apic_tenant_config.json', 'r' ) as f:
        try:
            tenant_config = json.load(f)
        except Exception as e:
            print(e)
            sys.exit(0)

def get_avi_controller_config():
    global tenant_config
    return tenant_config['AviController'][0]

def get_avi_apic_config():
    global tenant_config
    if 'Apic' in tenant_config['AviController'][0]:
        return tenant_config['AviController'][0]['Apic'][0]
    return None

def get_avi_pool():
    global tenant_config
    if 'Pool' in tenant_config['AviController'][0]:
        return tenant_config['AviController'][0]['Pool']
    return None

def get_avi_vs():
    global tenant_config
    if 'VirtualService' in tenant_config['AviController'][0]:
        return tenant_config['AviController'][0]['VirtualService']
    return None

def get_avi_ipaddrgroup():
    global tenant_config
    if 'IpAddrGroup' in tenant_config['AviController'][0]:
        return tenant_config['AviController'][0]['IpAddrGroup']
    return None

def get_apic_app_profile():
    global tenant_config
    if 'AppProfile' in tenant_config:
        return tenant_config['AppProfile']
    return None

def get_apic_bd():
    global tenant_config
    if 'BridgeDomain' in tenant_config:
        return tenant_config['BridgeDomain']
    return None

def get_apic_contract():
    global tenant_config
    if 'Contract' in tenant_config:
        return tenant_config['Contract']
    return None

def get_apic_private_network():
    global tenant_config
    if 'PrivateNetwork' in tenant_config:
        return tenant_config['PrivateNetwork']
    return None

def get_apic_graphs():
    global tenant_config
    if 'Graph' in tenant_config:
        return tenant_config['Graph']
    return None


def create_apic_topology():

    print('------------------------------------------------------')
    print('Creating objects in APIC for Tenant : %s' % tenant_config['Tenant'])
    print('------------------------------------------------------')
    # Setup the Bridge Domains
    apic_bds = get_apic_bd()
    for bd in apic_bds:
        for subnet in bd['subnets']:
            print('Creating BD : %s Subnet : %s ...' %
                bd['name'], subnet['gateway'])
            apic_session.createTenantBD(tenant_config['Tenant'],
                           bd['name'],
                           subnet['gateway'],
                           bd['network'])

    # Setup the Graphs
    apic_graphs = get_apic_graphs()
    apic_config = get_avi_apic_config()
    for graph in apic_graphs:
        print('Creating Graph : %s ...' %(graph['name']))
        apic_session.createGraph(tenant_config['Tenant'],
                apic_config['vendor'],
                apic_config['product'],
                graph['name'],
                graph['conn_out'],
                graph['conn_int'])

    # Setup the Contracts
    apic_contracts = get_apic_contract()
    for contract in apic_contracts:
        print(('Creating Contract : %s ...' %(contract['name'])))
        apic_session.createTenantContract(tenant_config['Tenant'],
                             contract['name'],
                             contract['subject']['graph'],
                             contract['subject']['filter'])

    # Setup the Application Profiles
    apic_apps = get_apic_app_profile()
    for app in apic_apps:
        for epg in app['EpgConfig']:
            print('Creating Application Profile : %s Epg : %s...' %
                  app['name'],epg['name'])
            apic_session.createAppEpg(tenant_config['Tenant'],
                 app['name'],
                 epg['name'],
                 epg['vmm_domain'],
                 epg['bridge_domain'])
            for contract in epg['EpgContract']:
                if contract['type'] == 'CONSUMER':
                    apic_session.addEpgContractCons(tenant_config['Tenant'],
                        app['name'],
                        epg['name'],
                        contract['name'])
                if contract['type'] == 'PROVIDER':
                    apic_session.addEpgContractProv(tenant_config['Tenant'],
                        app['name'],
                        epg['name'],
                        contract['name'])

def create_avi_ipaddrgroup(session):
    ipaddrgroup_config = get_avi_ipaddrgroup()
    for group in ipaddrgroup_config:
        print('Creating IP Address Group : %s...' %(group['name']))
        group_obj = None
        if 'epg' in group:
            group_obj = {
                'name' : group['name'],
                'apic_epg_name' : group['epg']
            }
        else:
            addrs_obj = []
            for ip in group['addrs']:
                addrs_obj.append({
                    'type' : 'V4',
                    'addr' : ip
                })
            group_obj = {
                'name' : group['name'],
                'addrs' : addrs_obj
            }
        session.create_or_update(obj='ipaddrgroup', 
                                 obj_name=group['name'],
                                 data=group_obj)

def create_avi_pool(session):
    pool_config = get_avi_pool()
    for pool in pool_config:
        print('Creating Pool : %s...' %(pool['name']))
        pool_obj = {
            'name' : pool['name'],
            'apic_epg_name' : pool['pool_epg']
        }
        session.create_or_update(obj='pool', obj_name=pool['name'],
                                 data=pool_obj)

def create_avi_networksecuritypolicy(session, vs):
    network_security = vs['network_security']
    group_refs = []
    for group in network_security['groups']:
        ref = session.get_object_uri(
                  'ipaddrgroup',
                  group)
        group_refs.append(ref)
    ns_policy_name = 'vs-' + vs['name'] + '-ns'
    ns_policy_obj = None
    if network_security['allow'] is True:
        ns_policy_obj = {
            'name' : ns_policy_name,
            'rules' : [
                {
                    'index' : 1,
                    'enable' : True,
                    'name' : 'Allowed IPs',
                    'action' : 'NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY',
                    'match' : {
                        'client_ip' : {
                            'group_refs' : group_refs,
                            'match_criteria' : 'IS_NOT_IN'
                        }
                    },
                    'log' : True
                }
            ]
        }
    else:
        ns_policy_obj = {
            'name' : ns_policy_name,
            'rules' : [
                {
                    'index' : 1,
                    'enable' : True,
                    'name' : 'Blocked IPs',
                    'action' : 'NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY',
                    'match' : {
                        'client_ip' : {
                            'group_refs' : group_refs,
                            'match_criteria' : 'IS_IN'
                        }
                    },
                    'log' : True
                }
            ]
        }
    
    session.create_or_update(obj='networksecuritypolicy',
                             obj_name=ns_policy_name,
                             data=ns_policy_obj)
    return session.get_object_uri(
               'networksecuritypolicy',
               ns_policy_name)

def create_avi_virtualservice(session, app_profile_name):
    vs_config = get_avi_vs()
    app_profile_ref = session.get_object_uri(
                        'applicationprofile', 
                        app_profile_name)
    for vs in vs_config: 
        print('Creating VirtualService : %s...' %(vs['name']))
        vs_obj = None
        pool_ref = session.get_object_uri('pool', vs['pool'])
        service_objs = []
        for service in vs['services']:
            service_objs.append({
                'port' : service['port'],
                'enable_ssl' : service['enable_ssl']
            })
        network_security_ref = None
        if 'network_security' in vs:
            network_security_ref = create_avi_networksecuritypolicy(
                                       session,
                                       vs)
            vs_obj = {
                'name' : vs['name'],
                'type' : 'VS_TYPE_NORMAL',
                'ip_address' : {
                    'addr' : vs['vip'],
                    'type' : 'V4'
                },
                'enabled' : True,
                'services' : service_objs,
                'pool_ref' : pool_ref,
                'application_profile_ref' : app_profile_ref,
                'network_security_policy_ref' : network_security_ref
            }
        else:
            vs_obj = {
                'name' : vs['name'],
                'type' : 'VS_TYPE_NORMAL',
                'ip_address' : {
                    'addr' : vs['vip'],
                    'type' : 'V4'
                },
                'enabled' : True,
                'services' : service_objs,
                'pool_ref' : pool_ref,
                'application_profile_ref' : app_profile_ref
            }
        session.create_or_update(obj='virtualservice', 
                                 obj_name=vs['name'],
                                 data=vs_obj)

def create_avi_endpoint(tenant):
    controller_config = get_avi_controller_config()
    print('Connecting to Avi Controller %s...'%(controller_config['ip']))
    print('User : %s Tenant : %s' %(controller_config['username'], tenant))
    return ApiSession.get_session(controller_config['ip'],
                       controller_config['username'], 
                       controller_config['password'], tenant=tenant)


def create_application_profile(sess, name, pki_profile_obj_name):
    '''
    Create a L7 application profile with caching, compression and
    websockets enabled.
    '''
    pki_profile_ref = sess.get_object_uri('pkiprofile', pki_profile_obj_name)
    application_profile_obj = {
        'name' : name,
        'type' : 'APPLICATION_PROFILE_TYPE_HTTP',
        'http_profile' : {
            'connection_multiplexing_enabled' : True,
            'compression_profile' : {
                'compression' : True,
                'remove_accept_encoding_header' : False,
                'type' : 'AUTO_COMPRESSION'
            },
            'cache_config': {
                'enabled' : True,
            },
            'websockets_enabled' : True,
            'ssl_client_certificate_mode': 'SSL_CLIENT_CERTIFICATE_REQUEST',
            'ssl_client_certificate_action' : {
                'headers': [
                     {
                         'request_header' : 'X-Cert',
                         'request_header_value' : 'HTTP_POLICY_VAR_SSL_CLIENT_SUBJECT'
                     }
                ],
                'close_connection' : True
            },
            'pki_profile_ref' : pki_profile_ref
        }
    }
    rsp = sess.post('applicationprofile', 
                    data=json.dumps(application_profile_obj))
    return rsp


def create_pki_profile(sess, name, certs=[], crls=[]):
    cert_objs = []
    for cert in certs:
        cert_objs.append({
            'certificate' : cert
        })
    crl_objs = []
    for crl in crls:
        crl_objs.append({
            'body' : crl
        })
    pki_profile_obj = {
        'name' : name,
        'ca_certs' : cert_objs,
        'crls' : crl_objs
    }
    rsp = sess.post('pkiprofile', json.dumps(pki_profile_obj))
    return rsp

if __name__ == '__main__':

    with open('../certs/server.crt') as f:
        server_crt = f.read()
    with open('../certs/server.key') as f:
        server_key = f.read()
    with open('../certs/cakey.pem') as f:
        ca_key = f.read()
    with open('../certs/cacert.pem') as f:
        ca_cert = f.read()

    # Read the tenant config from apic/apic_tenant_config.json
    load_tenant_config()

    # Establish session with the Avi Controller in 'admin' tenant for
    # configuration
    try :
        admin_session = create_avi_endpoint(tenant='admin')
    except Exception: 
        print ('login failed to Avi Controller!')
        sys.exit(0) 

    ApiUtils(admin_session).import_ssl_certificate('MyCert', 
                                                   server_key, server_crt)
    create_pki_profile(admin_session, 'MyPKIProfile', certs=[ ca_cert ])
    create_application_profile(admin_session, 'MyAppProfile', 'MyPKIProfile')

    # Establish session with the APIC
    apic_config = get_avi_apic_config()
    apic_session = APICClient(
                     apic_config['ip'],
                     apic_config['username'],
                     apic_config['password'])
    create_apic_topology()

    print('------------------------------------------------------')
    print('Creating objects in Avi for Tenant %s' %(tenant_config['Tenant']))
    print('------------------------------------------------------')
    avi_tenant_session = create_avi_endpoint(tenant=tenant_config['Tenant'])
    # Create Ip Address Group if present
    create_avi_ipaddrgroup(avi_tenant_session)

    # Vs/Pool are created in the context of the Tenant
    create_avi_pool(avi_tenant_session)
    create_avi_virtualservice(avi_tenant_session, 'MyAppProfile')

    print('Finished creating Tenant %s' %(tenant_config['Tenant']))
