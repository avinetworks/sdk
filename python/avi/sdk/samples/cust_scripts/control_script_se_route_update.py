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
VIP and nextHop as the GCP instance on which the Avi SE is running after a 
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
Service Engine Group is a JSON encoded string containing GCP project, zone and
network. Extract project, zone and network from the 'description' field

3) GET all GCP instances and filter out the instance matching the 
instance IP and network; extract its selfLink

4) Extract all routes matching destRange as VIP from GCP

5) If event is CC_IP_DETACHED, remove matching route with 
destRange as vip and nextHopInstance as instance in the appr network
If event is CC_IP_ATTACHED and no matching route exists already, add a new
route with destRange as vip and nextHopInstance as instance in appr network
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

def gcp_program_route(gcp, event_id, project, zones, network, inst_ip, vip):
    # net url e.g. https://www.googleapis.com/compute/v1/projects/astral-chassis-136417/global/networks/net1
    net_sfx = 'projects/%s/global/networks/%s' % (project, network)
    # First extract selfLink of GCP instance where SE is running
    inst = ''
    for zone in zones:
        result = gcp.instances().list(project=project, zone=zone).execute()
        if 'items' in result and len(result['items']) > 0:
            # selfLink e.g. https://www.googleapis.com/compute/v1/projects/astral-chassis-136417/zones/us-central1-b/instances/instance-2
            inst = next((s['selfLink'] for s in result['items']
                for n in s['networkInterfaces'] if n['networkIP'] == inst_ip 
                and net_sfx in n['network']), '')
            if inst:
                break

    if not inst:
        print('WARNING: Instance not found for project %s zones %s IP %s' % 
                  (project, str(zones), inst_ip))
    inst_pfx_list = inst.split('/projects/')
    net_url = '%s/%s' % (inst_pfx_list[0], net_sfx)

    # List all routes for vip
    result = gcp.routes().list(project=project, 
                                   filter='destRange eq %s' % vip).execute()
    if (('items' not in result or len(result['items']) == 0) 
        and event_id == 'CC_IP_DETACHED'):
        print('Project %s destRange %s route not found' % 
              (project, vip))
        return

    if event_id == 'CC_IP_DETACHED':
        # Remove route for vip nextHop instance
        for r in result['items']:
            if (r['network'] == net_url and r['destRange'] == vip and 
                r['nextHopInstance'] == inst):
                result = gcp.routes().delete(project=project, 
                                             route=r['name']).execute()
                print('Route %s delete result %s' % (r['name'], str(result)))
                # Wait until done or retries exhausted
                if 'name' in result:
                    start = int(time.time())
                    for i in xrange(0, 20):
                        op_result = gcp.globalOperations().get(project=project,
                                operation=result['name']).execute()
                        print('op_result %s' % str(op_result))
                        if op_result['status'] == 'DONE':
                            if 'error' in result:
                                print('WARNING: Route delete had errors '
                                      'result %s' % str(op_result))
                            else:
                                print('Route delete done result %s' % 
                                      str(op_result))
                            break
                        if int(time.time()) - start > 20:
                            print('WARNING: Wait exhausted last op_result %s' %
                                  str(op_result))
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
            'destRange': vip, 'network': net_url,
            'nextHopInstance': inst}
        result = gcp.routes().insert(project=project,
                                         body=route).execute()
        print('Route VIP %s inst %s insert result %s' % 
                (vip, inst, str(result)))
        
def handle_cc_alert(session, gcp, script_parms):
    se_name = script_parms['obj_name']
    print ('Event Se %s %s' % (se_name, str(script_parms)))
    if len(script_parms['events']) == 0:
        print ('WARNING: No events in alert')
        return

    # GET SE object from Avi for instance IP address and SE Group link
    rsp = session.get('serviceengine?uuid=%s' % 
                      script_parms['events'][0]['event_details']['cc_ip_details']['se_vm_uuid'])
    if rsp.status_code in xrange(200, 299):
        se = json.loads(rsp.text)
        if se['count'] == 0 or len(se['results']) == 0:
            print ('WARNING: SE %s no results' % 
                script_parms['events'][0]['event_details']['cc_ip_details']['se_vm_uuid'])
            return
        inst_ip = next((v['ip']['ip_addr']['addr'] for v in 
                se['results'][0]['mgmt_vnic']['vnic_networks'] 
                if v['ip']['mask'] == 32), '')
        if not inst_ip:
            print('WARNING: Unable to find IP with mask 32 SE %s' % str(se['results'][0]))
            return

        # GET SE Group object for GCP project, zones and network
        # https://localhost/api/serviceenginegroup/serviceenginegroup-99f78850-4d1f-4b7b-9027-311ad1f8c60e
        seg_ref_list = se['results'][0]['se_group_ref'].split('/api/')
        seg_rsp = session.get(seg_ref_list[1])
        if seg_rsp.status_code in xrange(200, 299):
            vip = '%s/32' % script_parms['events'][0]['event_details']['cc_ip_details']['ip']['addr']
            seg = json.loads(seg_rsp.text)
            descr = json.loads(seg.get('description', '{}'))
            project = descr.get('project', '')
            zones = descr.get('zones', [])
            network = descr.get('network', '')
            if not project or not zones or not network:
                print('WARNING: Project, Zone, Network is required descr %s' %
                      str(descr))
                return
            gcp_program_route(gcp, script_parms['events'][0]['event_id'],
                              project, zones, network, inst_ip, vip)
        else:
            print('WARNING: Unable to retrieve SE Group %s status %d' % 
                  (se['results'][0]['se_group_ref'], seg_rsp.status_code))
            return
    else:
        print ('WARNING: Unable to retrieve SE %s' % 
               script_parms['events'][0]['obj_uuid'])


# Script entry

if __name__ == "__main__":
    script_parms = parse_avi_params(sys.argv)
    try:
        admin_session = create_avi_endpoint()
        gcp = google_compute()
        handle_cc_alert(admin_session, gcp, script_parms)
    except Exception:
        print ('WARNING: Exception with Avi/Gcp route %s' % 
               traceback.format_exc())
