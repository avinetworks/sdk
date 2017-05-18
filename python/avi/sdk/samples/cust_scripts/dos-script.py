#!/usr/bin/python 
import sys, os, json
from avi.sdk.avi_api import ApiSession


'''
This control script will be executed in the Avi Controller when an
alert due to a DOS_ATTACK event is generated. 

An example params passed to the control script dos-attack.py is as follows

params = [u'/home/admin/Dos_Attack-l4vs', 
           '{"name": "Dos_Attack-virtualservice-d1093604-e1f0-476a-ad91-01c5224c5641-1461261720.83-1461261716-77911185", 
             "throttle_count": 0, 
             "level": "ALERT_HIGH", 
             "reason": "threshold_exceeded", 
             "obj_name": "l4vs", 
             "threshold": 1, 
             "events": 
             [
                 { 
                      "event_id": "DOS_ATTACK", 
                      "event_details": 
                      {
                          "dos_attack_event_details": 
                          {
                              "attack_count": 2150.0, 
                              "attack": "SYN_FLOOD", 
                              "ipgroup_uuids": [
                                  "ipaddrgroup-f6883289-39fa-418f-94c2-3b8f8093cd7a"
                               ], 
                               "src_ips": ["10.10.90.67"]
                          }
                      }, 
                      "obj_uuid": "virtualservice-d1093604-e1f0-476a-ad91-01c5224c5641", 
                      "obj_name": "l4vs", 
                      "report_timestamp": 1461261716
                 }
             ]
            }'
         ]

The DOS_ATTACK event was generated due to a SYN_FLOOD from client 10.10.90.67. It was
traffic to the Virtual Service : "l4vs". 

The offending client ip is added as NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY in the
Network Security Policy for the VS

'''

def ParseAviParams(argv):
    if len(argv) != 2:
        return
    alert_dict = json.loads(argv[1])
    return alert_dict

def create_avi_endpoint():
    token=os.environ.get('API_TOKEN')
    user=os.environ.get('USER')
    # tenant=os.environ.get('TENANT')
    return ApiSession.get_session("localhost", user, token=token, 
                                  tenant='admin')

def add_ns_rules_dos(session, dos_params):
    vs_name = dos_params['obj_name']
    vs_uuid = ''
    client_ips = []
    vs_name = dos_params['obj_name']
    for event in dos_params['events']:
        vs_uuid = event['obj_uuid']
        dos_attack_event_details = event['event_details']['dos_attack_event_details']
        if dos_attack_event_details['attack'] != 'SYN_FLOOD':
            continue
        for ip in dos_attack_event_details['src_ips']:
            client_ips.append(ip)
    if len(client_ips) == 0:
        print ('DOS ATTACK is not SYN_FLOOD. Ignoring')
        return

    print('VS name : ' + vs_name + ' VS UUID : ' + vs_uuid + ' Client IPs : ' + str(client_ips))
    ip_list = []
    for ip in client_ips:
        ip_addr_obj = {
            'addr' : ip,
            'type' : 'V4'
        }
        ip_list.append(ip_addr_obj)

    match_obj = {
        'match_criteria' : 'IS_IN',
        'addrs' : ip_list
    }
    ns_match_target_obj = {
        'client_ip' : match_obj
    }
    ns_rule_dos_obj = {
        'enable' : True,
        'log'    : True,
        'match'  : ns_match_target_obj,
        'action' : 'NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY'
    }
    ns_policy_dos_obj = {
        'vs_name' : vs_name,
        'vs_uuid' : vs_uuid,
        'rules'   : [
            ns_rule_dos_obj,
        ]
    }
    print('ns_policy_dos_obj : ' + str(ns_policy_dos_obj))
    try :
        session.post(path='networksecuritypolicydos?action=block',
                 data=ns_policy_dos_obj)
    except Exception as e:
        print(str(e))
    print(('Added Client IPs ' + str(client_ips) + \
           ' in the blocked list for VS : ' + vs_name))

if __name__ == "__main__":
    alert_dict = ParseAviParams(sys.argv)
    try :
        admin_session = create_avi_endpoint()
    except Exception as e:
        print('login failed to Avi Controller!' + str(e))
        sys.exit(0)
    add_ns_rules_dos(admin_session, alert_dict)
