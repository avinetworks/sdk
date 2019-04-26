#!/usr/bin/env python
from avi.sdk.avi_api import ApiSession
from avi.sdk.avi_api import APIError
import getpass
import argparse
import sys
import json
'''
usage: alb_rules.py [-h] [-c CONTROLLER] [-u USER] [-p PASSWORD]
                           [-x API_VERSION] [-C CLOUD] [-t TENANT]

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
'''

import urllib3
urllib3.disable_warnings()


tenant = 'admin'
DEFAULT_API_VERSION = '17.2.14'


def switchto_cloud(api, cloud):
    api.headers['X-Avi-Cloud'] = cloud
    api.cloud = cloud


def get_all_vs(api):
    'To Get all vs with paginiation'
    all_vs = []
    api_path = "virtualservice"
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

    api = ApiSession.get_session(
        controller_ip, user, password, tenant=args.tenant, api_version=args.api_version)
    cloud = args.cloud
    switchto_cloud(api, cloud)

    all_vs = get_all_vs(api)

    alb_rule_count = {}
    for vs in all_vs:

        az = vs.get('azure_availability_set')
        if az:
            for service in vs['services']:
                alb_rule_count[az] = alb_rule_count.get(az, 0) + service['port_range_end'] - service['port'] + 1
    print alb_rule_count


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
    args = parser.parse_args()

    main(args)
