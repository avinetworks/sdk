#!/usr/bin/python 

import sys, os, json, traceback, re, time
from avi.sdk.avi_api import ApiSession
from oauth2client.client import GoogleCredentials
from googleapiclient import discovery

'''
This ControlScript is executed on the Avi Controller every time there is a 
CC_IP_ATTACHED or a CC_IP_DETACHED event. 

CC_IP_ATTACHED: Event is triggered when a VIP is attached to a SE
CC_IP_DETACHED: Event is triggered when a VIP is detached from a SE, usually
when a SE goes down or a scale in occurs

The goal of this script is to add a route to GCP with the destination as the 
VIP and nextHopIp as the GCP instance IP on which the Avi SE is running after a 
CC_IP_ATTACHED event. After a CC_IP_DETACHED event, the goal of the script is 
to remove the corresponding route.

Script assumptions:

1) The Avi Controller GCP instance has scope=compute-rw to be able to modify 
routes in GCP
2) 'description' field in the Avi Service Engine Group is configured as a
JSON encoded string containing GCP project, zone and network

Event details contain the Avi SE UUID and the VIP.

1) GET Avi SE object from UUID and extract Avi SE IP address (which is
the same as the GCP instance IP address) and Avi Service Engine Group link

2) GET Avi Service Engine Group object. The 'description' field in the
Service Engine Group is a JSON encoded string containing GCP project and
network URL. Extract project and network from the 'description' field

3) Extract all routes matching destRange as VIP from GCP

4) If event is CC_IP_DETACHED, remove matching route with 
destRange as vip and nextHopIp as instance IP in the appr network
If event is CC_IP_ATTACHED and no matching route exists already, add a new
route with destRange as vip and nextHopIp as instance IP in appr network
'''

def parse_avi_params(argv):
    if len(argv) != 2:
        return {}
    script_parms = json.loads(argv[1])
    return script_parms

def create_avi_endpoint():
    token=os.environ.get('API_TOKEN')
    user=os.environ.get('USER')
    # tenant=os.environ.get('TENANT')
    return ApiSession.get_session("localhost", user, token=token, 
                                  tenant='admin')

def google_compute():
    credentials = GoogleCredentials.get_application_default()
    return discovery.build('compute', 'v1', credentials=credentials)

def gcp_program_route(gcp, event_id, project, network, inst_ip, vip):
    # List all routes for vip
    result = gcp.routes().list(project=project, 
                                   filter='destRange eq %s' % vip).execute()
    if (('items' not in result or len(result['items']) == 0) 
        and event_id == 'CC_IP_DETACHED'):
        print(('Project %s destRange %s route not found' % 
              (project, vip)))
        return

    if event_id == 'CC_IP_DETACHED':
        # Remove route for vip nextHop instance
        for r in result['items']:
            if (r['network'] == network and r['destRange'] == vip and 
                r['nextHopIp'] == inst_ip):
                result = gcp.routes().delete(project=project, 
                                             route=r['name']).execute()
                print(('Route %s delete result %s' % (r['name'], str(result))))
                # Wait until done or retries exhausted
                if 'name' in result:
                    start = int(time.time())
                    for i in range(0, 20):
                        op_result = gcp.globalOperations().get(project=project,
                                operation=result['name']).execute()
                        print(('op_result %s' % str(op_result)))
                        if op_result['status'] == 'DONE':
                            if 'error' in result:
                                print(('WARNING: Route delete had errors '
                                      'result %s' % str(op_result)))
                            else:
                                print(('Route delete done result %s' % 
                                      str(op_result)))
                            break
                        if int(time.time()) - start > 20:
                            print(('WARNING: Wait exhausted last op_result %s' %
                                  str(op_result)))
                            break
                        else:
                            time.sleep(1)
                else:
                    print('WARNING: Unable to obtain name of route delete '
                          'operation')
    elif event_id == 'CC_IP_ATTACHED':
        # Add routes to instance
        # Route names can just have - and alphanumeric chars
        rt_name = re.sub('[./]+', '-', 'route-%s-%s' % (inst_ip, vip))
        route = {'name': rt_name,
            'destRange': vip, 'network': network,
            'nextHopIp': inst_ip}
        result = gcp.routes().insert(project=project,
                                         body=route).execute()
        print(('Route VIP %s insert result %s' % 
                (vip, str(result))))
        
def handle_cc_alert(session, gcp, script_parms):
    se_name = script_parms['obj_name']
    print(('Event Se %s %s' % (se_name, str(script_parms))))
    if len(script_parms['events']) == 0:
        print ('WARNING: No events in alert')
        return

    # GET SE object from Avi for instance IP address and SE Group link
    rsp = session.get('serviceengine?uuid=%s' % 
                      script_parms['events'][0]['event_details']['cc_ip_details']['se_vm_uuid'])
    if rsp.status_code in range(200, 299):
        se = json.loads(rsp.text)
        if se['count'] == 0 or len(se['results']) == 0:
            print(('WARNING: SE %s no results' % 
                script_parms['events'][0]['event_details']['cc_ip_details']['se_vm_uuid']))
            return
        inst_ip = next((v['ip']['ip_addr']['addr'] for v in 
                se['results'][0]['mgmt_vnic']['vnic_networks'] 
                if v['ip']['mask'] == 32 and v['mode'] != 'VIP'), '')
        if not inst_ip:
            print(('WARNING: Unable to find IP with mask 32 SE %s' % str(se['results'][0])))
            return

        # GET SE Group object for GCP project, zones and network
        # https://localhost/api/serviceenginegroup/serviceenginegroup-99f78850-4d1f-4b7b-9027-311ad1f8c60e
        seg_ref_list = se['results'][0]['se_group_ref'].split('/api/')
        seg_rsp = session.get(seg_ref_list[1])
        if seg_rsp.status_code in range(200, 299):
            vip = '%s/32' % script_parms['events'][0]['event_details']['cc_ip_details']['ip']['addr']
            seg = json.loads(seg_rsp.text)
            descr = json.loads(seg.get('description', '{}'))
            project = descr.get('project', '')
            network = descr.get('network', '')
            if not project or not network:
                print(('WARNING: Project, Network is required descr %s' %
                      str(descr)))
                return
            gcp_program_route(gcp, script_parms['events'][0]['event_id'],
                              project, network, inst_ip, vip)
        else:
            print(('WARNING: Unable to retrieve SE Group %s status %d' % 
                  (se['results'][0]['se_group_ref'], seg_rsp.status_code)))
            return
    else:
        print(('WARNING: Unable to retrieve SE %s' % 
               script_parms['events'][0]['obj_uuid']))


# Script entry

if __name__ == "__main__":
    script_parms = parse_avi_params(sys.argv)
    try:
        admin_session = create_avi_endpoint()
        gcp = google_compute()
        handle_cc_alert(admin_session, gcp, script_parms)
    except Exception:
        print(('WARNING: Exception with Avi/Gcp route %s' % 
               traceback.format_exc()))
