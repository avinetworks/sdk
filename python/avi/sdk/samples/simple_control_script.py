"""This is a simple example of a control script. This control script is triggered by a 'Created SE' alert. 
When the Alert triggers, it prints the alert json to a file. Then it makes an api call to retrieve the SE object info 
and appends this info to the file"""



#!/usr/bin/python
import json
import sys
import os
from time import sleep
from avi.sdk.avi_api import ApiSession

def getAviApiSession(tenant='admin'):
    '''
    create session to avi controller
    '''
    token = os.environ.get('API_TOKEN')
    user = os.environ.get('USER')
    # tenant=os.environ.get('TENANT')
    api = ApiSession.get_session("localhost", user, token=token,
                                 tenant=tenant)
    return api

def write_to_file(data):
    file = open('/tmp/alert.json', 'a+')
    file.write(data)
    file.close()

def get_se_info(se_name):
    api = getAviApiSession()
    se_obj = api.get_object_by_name('serviceengine', se_name)
    return se_obj

if __name__ == '__main__':
    alert_info = sys.argv[1]
    write_to_file(alert_info)
    alert_json = json.loads(alert_info)
    se_name = alert_json['events'][0]['event_details']['spawn_se_details']['se_name']
    #host_name = alert_json['events'][0]['event_details']['spawn_se_details']['host_name'] 
    '''
    give enough time for SE IP address allocation/controller detection
    '''
    sleep(90)
    se_json = get_se_info(se_name)
    se_ip = se_json['mgmt_vnic']['vnic_networks'][0]['ip']['ip_addr']['addr']
    write_to_file('\n\n\nSE Name: ' + se_name)
    write_to_file('\nSE IP: ' + se_ip)
