#!/usr/bin/python
#
# Example Control script to update vRA on SE creation or deletion on vCenter
#
# import sys
# import json
# from avi.sdk.samples.vra.update_vra import register_se, destroy_se
# 
# #print sys.argv
# event = json.loads(sys.argv[1])['events'][0]
# event_id = event['event_id']
# 
# vra_ip = '10.130.180.134'
# username = 'demouser'
# password = 'VMware1!'
# tenant = 'vsphere.local'
# catalog_name = 'Get Avi SE by name'
# 
# 
# if event_id == 'CREATED_SE':
#     se_name = event['event_details']['spawn_se_details']['se_name']
#     register_se(se_name, catalog_name, vra_ip, username, password, tenant)
# elif event_id == 'DELETED_SE':
#     se_name = event['event_details']['delete_se_details']['se_name']
#     destroy_se(se_name, vra_ip, username, password, tenant, force=False)


import sys
import json
import requests
from requests.packages import urllib3

# Suppress warnings (typically SSL certificate warnings) when calling the API
urllib3.disable_warnings()

class APIError(Exception):
    def __init__(self, arg, rsp=None):
        self.args = [arg, rsp]
        self.rsp = rsp

def get_token(vra_ip, username, password, tenant):
    url = 'https://%s/identity/api/tokens' % vra_ip
    data = {
        'username': username,
        'password': password,
        'tenant': tenant
    }

    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }

    r = requests.post(url, headers = headers, data = json.dumps(data), verify=False)
    if r.status_code == 200:
        resp = r.json()
        token = resp['id']
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

    return token

def get_catalog_id(vra_ip, token, catalog_name):
    url = 'https://%s/catalog-service/api/consumer/entitledCatalogItemViews' % vra_ip
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    r = requests.get(url, headers = headers, verify=False)
    if r.status_code == 200:
        resp = r.json()
        for cat_item in resp['content']:
            if cat_item['name'] == catalog_name:
                return cat_item['catalogItemId']
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

    return 'Catalog ID for %s not found' % catalog_name

def get_cat_template(vra_ip, token, catalog_id):
    url = 'https://%s/catalog-service/api/consumer/entitledCatalogItems/%s/requests/template' % (vra_ip,catalog_id)
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    r = requests.get(url, headers = headers, verify=False)
    if r.status_code == 200:
        resp = r.json()
        return resp
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

def request_cat_item(vra_ip, token, catalog_id, se_name, template):
    url = 'https://%s/catalog-service/api/consumer/entitledCatalogItems/%s/requests' % (vra_ip,catalog_id)
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    template['data']['criteria'] = se_name

    r = requests.post(url, headers = headers, data = json.dumps(template), verify=False)
    if r.status_code == 201:
        resp = r.json()
        return resp
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

def get_resource_id(vra_ip, token, se_name):
    url = 'https://%s/catalog-service/api/consumer/resources' % vra_ip
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    r = requests.get(url, headers = headers, verify=False)
    if r.status_code == 200:
        resp = r.json()
        for cat_item in resp['content']:
            if cat_item['name'] == se_name:
                return cat_item['parentResourceRef']['id']
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

    return 'SE %s not found' % se_name

def get_action_id(vra_ip, token, resource_id, action_name):
    url = 'https://%s/catalog-service/api/consumer/resources/%s/actions' % (vra_ip,resource_id)
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    r = requests.get(url, headers = headers, verify=False)
    if r.status_code == 200:
        resp = r.json()
        for cat_item in resp['content']:
            if cat_item['name'] == action_name:
                return cat_item['id']
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

    return 'Action %s not found' % action_name

def get_action_template(vra_ip, token, resource_id, action_id):
    url = 'https://%s/catalog-service/api/consumer/resources/%s/actions/%s/requests/template' % (vra_ip,resource_id,action_id)
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    r = requests.get(url, headers = headers, verify=False)
    if r.status_code == 200:
        resp = r.json()
        return resp
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

def request_day2_action(vra_ip, token, resource_id, action_id, template, force=False):
    url = 'https://%s/catalog-service/api/consumer/resources/%s/actions/%s/requests' % (vra_ip,resource_id,action_id)
    headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': 'Bearer %s' % token
    }
    template['data']['ForceDestroy'] = force

    r = requests.post(url, headers = headers, data = json.dumps(template), verify=False)
    if r.status_code == 201:
        return True
    else:
        raise APIError('Api Error: %s Resp Code: %s' % (r.text, r.status_code))

def register_se(se_name, catalog_name, vra_ip, username, password, tenant):
    token = get_token(vra_ip, username, password, tenant)
    catalog_id = get_catalog_id(vra_ip, token, catalog_name)
    template = get_cat_template(vra_ip, token, catalog_id)
    cat_item = request_cat_item(vra_ip, token, catalog_id, se_name, template)

def destroy_se(se_name, vra_ip, username, password, tenant, force=False):
    token = get_token(vra_ip, username, password, tenant)
    resource_id = get_resource_id(vra_ip, token, se_name)
    destroy_action_id = get_action_id(vra_ip, token, resource_id, 'Destroy')
    template = get_action_template(vra_ip, token, resource_id, destroy_action_id)
    request_day2_action(vra_ip, token, resource_id, destroy_action_id, template, force=force)


if __name__ == '__main__':
    register_se('Avi-se-jniwu', 'Get Avi SE by name', '10.10.10.10', 'demouser', 'VMware1!', 'vsphere.local')
    destroy_se('Avi-se-jniwu', '10.10.10.10', 'demouser', 'VMware1!', 'vsphere.local')

