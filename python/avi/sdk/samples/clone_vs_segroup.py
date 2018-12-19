#!/usr/bin/env python
from avi.sdk.avi_api import ApiSession
from avi.sdk.avi_api import APIError
import getpass
import argparse
import sys
import json
import pprint
import time
'''
Overview:

Accelerated networking has been introduced as an SE group level option in 17.2.14 release. By default all SE groups created 17.2.14 onwards will have this option enabled, but this option cannot be enabled on an existing SE group having SEs created with accelerated nw disabled. This is because 
Azure does not allow mixing VMs with accelerated nw enabled and disabled in the same availability set.


Migration to accelerated networking 

Create a new SE group with Accelerated networking enabled. All the existing VSes need to be migrated to this new SE group. Follow one or a combination o the following strategies to migrate the Virtual services to the new SE group.
1. Create a clone of existing Virtual services in the new SE group. Once the new VSes are up, switch the DNS record for each VS to point to the new Virtual services. This strategy makes sure this is no downtime for the clients. 
2. Modify the SE group for the Virtual services. This strategy needs the Virtual services to be disabled before changing the SE group, causing downtime for the clients, but allows all the analytical history of the Virtual services to be preserved.
A combination of both the strategies above can be followed to gain the benefits of both of them.

Please use the script provided to clone the virtual services to a new SE group.

Avi cloud connector does periodic reconcile of the existing virtual services to the cloud, this reconcile should be disabled while cloning the virtual services to a new se group. To disable cloud_reconcile, execute the following command on controller shell.

>configure controller properties
>no cloud_reconcile
>save

Setup a new SE group in the cloud where the Virtual services need to be cloned.

Execute the script provided as follows to create clones of virtual services.

usage: clone_vs_segroup.py [-h] [-c CONTROLLER] [-u USER] [-p PASSWORD]
                           [-x API_VERSION] [-C CLOUD] [-t TENANT] [-e]
                           [-f FROMSEGROUP] [-d TOSEGROUP] [-s SUFFIX] [-n]

optional arguments:
  -h, --help            show this help message and exit
  -c CONTROLLER, --controller CONTROLLER
                        FQDN or IP address of Avi Vantage controller
  -u USER, --user USER  Avi Vantage username
  -p PASSWORD, --password PASSWORD
                        Avi Vantage password
  -x API_VERSION, --api_version API_VERSION
                        Avi Vantage API version (default=17.2.14)
  -C CLOUD, --cloud CLOUD
                        Cloud name
  -t TENANT, --tenant TENANT
                        Tenant name
  -e, --enable          Enable the cloned Virtual Service
  -f FROMSEGROUP, --fromsegroup FROMSEGROUP
                        Source SE group
  -d TOSEGROUP, --tosegroup TOSEGROUP
                        Destination SE group
  -s SUFFIX, --suffix SUFFIX
                        suffix to be added to virtual service names
  -n, --dryrun          Dry run mode

The script will clone the existing virtual services to new SE group created. Once the VSes are up, the older VSes can be deleted or disabled.
'''

import urllib3
urllib3.disable_warnings()
print('\n\n\n\n')
pp = pprint.PrettyPrinter()


dry_run_mode = False
tenant = 'admin'
DEFAULT_API_VERSION = '17.2.14'


def get_ref_url_by_name(controller_ip, name, objtype, tenant='admin'):
    return 'https://%s/api/%s?name=%s&tenant=%s' % (controller_ip, objtype, name, tenant)


def switchto_cloud(api, cloud):
    api.headers['X-Avi-Cloud'] = cloud
    api.cloud = cloud


def get_all_vs(api):
    'To Get all vs with paginiation'
    all_vs = []
    api_path = "virtualservice?fields=name'"
    while True:
        vs_data = api.get(api_path).json()
        if 'results' in vs_data:
            all_vs.extend(vs_data['results'])
        if 'next' in vs_data:
            api_path = vs_data['next'].split('/')[-1]
            print("Next page : %s" % api_path)
            continue
        else:
            break
    return all_vs


def main(args):

    if args:

        # If not specified on the command-line, prompt the user for the
        # controller IP address and/or password

        controller_ip = args.controller
        user = args.user
        password = args.password

        while not controller_ip:
            controller_ip = input('Controller:')

        while not password:
            password = getpass.getpass('Password for %s@%s:' %
                                       (user, controller_ip))
    api = ApiSession.get_session(
        controller_ip, user, password, tenant=args.tenant, api_version=args.api_version)
    cloud = args.cloud
    from_segrp = args.fromsegroup
    to_segrp = args.tosegroup
    switchto_cloud(api, cloud)
    dry_run_mode = args.dryrun
    suffix = args.suffix
    enabled = args.enable

    all_vs = get_all_vs(api)
    print(all_vs)
    old_se_grp_uuid = api.get('serviceenginegroup?name=%s' % from_segrp).json()[
        'results'][0]['uuid']
    print('se_grp_uuid : %s' % old_se_grp_uuid)
    new_se_grp = api.get('serviceenginegroup?name=%s' %
                         to_segrp).json()['results'][0]
    print('new_se_grp_uuid : %s' % new_se_grp['uuid'])
    c_vs_vips = {}
    all_vsvips = {}
    all_nw_policies = []
    all_vses = []
    all_http_pols = []
    for vs in all_vs:
        shared_vip = False
        vs_uuid = vs['uuid']
        vs_api = 'virtualservice/%s?join_subresources=runtime&page_size=1000' % vs_uuid
        vs = api.get(vs_api).json()
        vs_segid = vs['se_group_ref'].split('/')[-1]
        if vs_segid != old_se_grp_uuid:
            #print('Skipping VS as it does not belong to se group %s: %s' %
            #      (args.fromsegroup, vs['name']))
            continue
        print('Cloning VS %s to segrp %s' % (vs['name'], args.tosegroup))
        vs.pop('runtime')
        vs.pop('vip_runtime')

        #if not vs.has_key('vsvip_ref'):
        if not ('vsvip_ref' in vs):
            continue

        old_vsvip_ref = vs['vsvip_ref']
        #if c_vs_vips.has_key(old_vsvip_ref):
        if old_vsvip_ref in c_vs_vips:
            shared_vip = True
        else:
            c_vs_vips[old_vsvip_ref] = True
        vsvip = api.get('vsvip/%s' % old_vsvip_ref.split('/')[-1]).json()
        vsvip['vip'][0].pop('ip_address')
        if 'floating_ip' in vsvip['vip'][0]:
        #if vsvip['vip'][0].has_key('floating_ip'):
            vsvip['vip'][0].pop('floating_ip')
        vsvip['name'] = vsvip['name'] + suffix
        vsvip.pop('uuid')
        vsvip_post = None
        if not dry_run_mode:
            if shared_vip:
                vsvip_post = api.get_object_by_name('vsvip', vsvip['name'])
            else:
                try:
                    vsvip_post = api.post('vsvip', vsvip).json()
                except APIError as e:
                    if e.rsp.status_code == 409:
                        vsvip_post = api.get_object_by_name('vsvip', vsvip['name'])
                    else: 
                        raise e
                except Exception as e:
                    raise e
            vsvip_ref = api.get_obj_ref(vsvip_post)
            print(vsvip_post)
        else:
            vsvip_ref = get_ref_url_by_name(
                controller_ip, vsvip['name'], 'vsvip', tenant=tenant)
        all_vsvips[vsvip_ref] = vsvip

        #if vs.has_key('http_policies'):
        if 'http_policies' in vs:
            http_policies = vs['http_policies']
            if http_policies:
                for pol in http_policies:
                    pol_obj = api.get(
                        'httppolicyset/%s' % pol['http_policy_set_ref'].split('/')[-1]).json()
                    pol_obj['name'] = pol_obj['name'] + suffix
                    pol_obj.pop('uuid')
                    if not dry_run_mode:
                        try:
                            new_pol_obj = api.post('httppolicyset', pol_obj)
                        except APIError as e:
                                if e.rsp.status_code == 409:
                                    new_pol_obj = api.get_object_by_name('httppolicyset', pol_obj['name'])
                                    pass
                                else: 
                                    raise e
                        http_pol_ref = api.get_obj_ref(new_pol_obj)
                    else:
                        http_pol_ref = get_ref_url_by_name(
                            controller_ip, pol_obj['name'], 'httppolicyset')
                    all_http_pols.append(pol_obj)
                    pol['http_policy_set_ref'] = http_pol_ref
        #if vs.has_key('network_security_policy_ref'):
        if 'network_security_policy_ref' in vs:
            netw_sec_pol_ref = vs['network_security_policy_ref']
            netw_sec_pol = api.get('networksecuritypolicy/%s' %
                                   netw_sec_pol_ref.split('/')[-1]).json()
            netw_sec_pol.pop('uuid')
            netw_sec_pol['name'] = netw_sec_pol['name'] + suffix
            netw_sec_pol_post = None
            if not dry_run_mode:
                try:
                    netw_sec_pol_post = api.post(
                        'networksecuritypolicy', netw_sec_pol).json()
                except APIError as e:
                    if e.rsp.status_code == 409:
                        netw_sec_pol_post = api.get_object_by_name('networksecuritypolicy', netw_sec_pol['name'])
                        pass
                    else:
                        raise e
                nw_pol_ref = api.get_obj_ref(netw_sec_pol_post)
            else:
                nw_pol_ref = get_ref_url_by_name(
                    controller_ip, netw_sec_pol['name'], 'networksecuritypolicy')
            all_nw_policies.append(netw_sec_pol)
        else:
            nw_pol_ref = None

        vs['name'] = vs['name'] + suffix
        vs['vsvip_ref'] = vsvip_ref
        vs['enabled'] = enabled
        if not dry_run_mode:
            vs['vip'][0]['ip_address']['addr'] = vsvip_post['vip'][0]['ip_address']['addr']
        vs['network_security_policy_ref'] = nw_pol_ref
        vs['se_group_ref'] = api.get_obj_ref(new_se_grp)
        vs.pop('uuid')
        if not dry_run_mode:
            try:
                time.sleep(0.5)
                vs_post = api.post('virtualservice', vs).json()
            except APIError as e:
                if e.rsp.status_code == 409:
                    pass
                else: 
                    raise e
        all_vses.append(vs)
    for vs in all_vs:
        vs_uuid = vs['uuid']
        vs_api = 'virtualservice/%s?join_subresources=runtime&page_size=1000' % vs_uuid
        vs = api.get(vs_api).json()
        vs.pop('runtime')
        vs.pop('vip_runtime')

        #if vs.has_key('vsvip_ref'):
        if 'vsvip_ref' in vs:
            #print('Skipping VS %s as it has its own VIP' % vs['name'])
            continue
        if vs['type'] != 'VS_TYPE_VH_CHILD':
            #print('%s is not child vs' % vs['name'])
            continue
        parent_vs = api.get('virtualservice/%s' %
                            vs['vh_parent_vs_ref'].split('/')[-1]).json()
        vs_segid = parent_vs['se_group_ref'].split('/')[-1]
        if vs_segid != old_se_grp_uuid:
            #print('Skipping VS %s as it does not belong to se group %s' %
            #      (vs['name'], args.fromsegroup))
            continue
        print('checking vs %s' % vs['name'])
        new_parent = parent_vs['name'] + suffix
        vs['name'] = vs['name'] + suffix
        vs.pop('uuid')
        vs['enabled'] = enabled
        #if vs.has_key('http_policies'):
        if 'http_policies' in vs:
            http_policies = vs['http_policies']
            if http_policies:
                for pol in http_policies:
                    pol_obj = api.get(
                        'httppolicyset/%s' % pol['http_policy_set_ref'].split('/')[-1]).json()
                    pol_obj['name'] = pol_obj['name'] + suffix
                    pol_obj.pop('uuid')
                    if not dry_run_mode:
                        try:
                            new_pol_obj = api.post('httppolicyset', pol_obj)
                        except APIError as e:
                            if e.rsp.status_code == 409:
                                new_pol_obj = api.get_object_by_name('httppolicyset', pol_obj['name'])
                                pass
                            else: 
                                raise e
                        http_pol_ref = api.get_obj_ref(new_pol_obj)
                    else:
                        http_pol_ref = get_ref_url_by_name(
                            controller_ip, pol_obj['name'], 'httppolicyset')
                    all_http_pols.append(pol_obj)
                    pol['http_policy_set_ref'] = http_pol_ref
        #if vs.has_key('network_security_policy_ref'):
        if 'network_security_policy_ref' in vs:
            netw_sec_pol_ref = vs['network_security_policy_ref']
            netw_sec_pol = api.get('networksecuritypolicy/%s' %
                                   netw_sec_pol_ref.split('/')[-1]).json()
            netw_sec_pol.pop('uuid')
            netw_sec_pol['name'] = netw_sec_pol['name'] + suffix
            netw_sec_pol_post = None
            if not dry_run_mode:
                try:
                    netw_sec_pol_post = api.post(
                        'networksecuritypolicy', netw_sec_pol).json()
                except APIError as e:
                        if e.rsp.status_code == 409:
                            netw_sec_pol_post = api.get_object_by_name('networksecuritypolicy', netw_sec_pol['name'])
                            pass
                        else: 
                            raise e
                nw_pol_ref = api.get_obj_ref(netw_sec_pol_post)
            else:
                nw_pol_ref = get_ref_url_by_name(
                    controller_ip, netw_sec_pol['name'], 'networksecuritypolicy')
            vs['network_security_policy_ref'] = nw_pol_ref
            all_nw_policies.append(netw_sec_pol)
        else:
            nw_pol_ref = None

        if not dry_run_mode:
            new_parent_vs = api.get('virtualservice?name=%s' % new_parent).json()[
                'results'][0]
            parent_vs_ref = api.get_obj_ref(new_parent_vs)
            vs['vh_parent_vs_ref'] = parent_vs_ref
            try:
                vs_post = api.post('virtualservice', vs)
            except APIError as e:
                    if e.rsp.status_code == 409:
                        pass
                    else: 
                        raise e
            print('posted vs %s' % vs_post)
        else:
            parent_vs_ref = get_ref_url_by_name(
                controller_ip, new_parent, 'virtualservice')
            vs['vh_parent_vs_ref'] = parent_vs_ref
        all_vses.append(vs)

    with open('vsvip.json', mode='w') as outfile:
#        json.dump(all_vsvips.values(), outfile, indent=4, sort_keys=True)
        json.dump(all_vsvips, outfile, indent=4, sort_keys=True)
    with open('nwpolicies.json', mode='w') as outfile:
        json.dump(all_nw_policies, outfile, indent=4, sort_keys=True)
    with open('httppolicies.json', mode='w') as outfile:
        json.dump(all_http_pols, outfile, indent=4, sort_keys=True)
    with open('vs.json', mode='w') as outfile:
        json.dump(all_vses, outfile, indent=4, sort_keys=True)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='')
    parser.add_argument('-c', '--controller',
                        help='FQDN or IP address of Avi Vantage controller')
    parser.add_argument('-u', '--user', help='Avi Vantage username',
                        default='admin')
    parser.add_argument('-p', '--password', help='Avi Vantage password')
    parser.add_argument('-x', '--api_version',
                        help='Avi Vantage API version (default=%s)' % DEFAULT_API_VERSION,
                        default=DEFAULT_API_VERSION)
    parser.add_argument('-C', '--cloud',
                        help='Cloud name', default='Default-Cloud')
    parser.add_argument('-t', '--tenant',
                        help='Tenant name', default='admin')
    parser.add_argument('-e', '--enable',
                        help='Enable the cloned Virtual Service', action='store_true')
    parser.add_argument('-f', '--fromsegroup', help='Source SE group')
    parser.add_argument('-d', '--tosegroup', help='Destination SE group')
    parser.add_argument(
        '-s', '--suffix', help='suffix to be added to virtual service names')
    parser.add_argument(
        '-n', '--dryrun', help='Dry run mode', action='store_true')
    args = parser.parse_args()
    if not args.fromsegroup or not args.tosegroup:
        parser.print_help(sys.stderr)
        sys.exit(1)

    main(args)
