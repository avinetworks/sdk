#!/usr/bin/env python
import argparse
import json
import logging
import sys
from avi.sdk.avi_api import ApiSession
from avi.sdk.saml_avi_api import OktaSAMLApiSession, OneloginSAMLApiSession
from avi.sdk.utils.api_utils import ApiUtils
from requests.packages import urllib3

logger = logging.getLogger(__name__)
ch = logging.StreamHandler(sys.stdout)
root_logger = logging.getLogger()
root_logger.setLevel(logging.DEBUG)
root_logger.addHandler(ch)

urllib3.disable_warnings()


class SAMLExample(object):
    """
    Provides example of following operations
    1. Create basic vs
    2. Create vs with SSL objects
    3. Create vs with custom parameters like application profile
    4. Inventory API calls for virtualservice
    5. Metrics API calls for virtualservice metrics
    """
    def __init__(self, api):
        self.api = api
        self.api_utils = ApiUtils(api)

    @staticmethod
    def get_idp_class(idp):
        """
        This return corresponding idp class.
        :param idp: idp type such as okta, onelogin, pingfed
        :return: IDP class or ApiSession class
        """

        if str(idp).lower() == "oktasamlapisession":
            print("Using OktaSAMLApiSession class")
            idp_class = OktaSAMLApiSession
        elif str(idp).lower() == 'oneloginsamlapisession':
            print("Using OktaSAMLApiSession class")
            idp_class = OneloginSAMLApiSession
        else:
            print("Please provide correct IDP class. Supported classes are "
                  "OktaSAMLApiSession, OneloginApiSession.")
            idp_class = None
        return idp_class

    def get_server_obj(self, servers):
        """
        :param servers Input pool servers.
        """
        servers_obj = []
        for server in servers:
            parts = server.split(':')
            ip_addr = parts[0]
            port = parts[1] if len(parts) == 2 else 80
            servers_obj.append({
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'port': port
            })
        return servers_obj

    def create_basic_vs(self, vs_name, vip, servers=None):
        # first create pool for virtual service
        servers_obj = self.get_server_obj(servers)
        pool_name = vs_name + '-pool'
        pool_obj = self.create_pool(pool_name, servers_obj)
        pool_ref = self.api.get_obj_ref(pool_obj)

        # create virtual service dict
        services_obj = [{'port': 80, 'enable_ssl': False}]
        vs_obj = {
            'name': vs_name,
            'type': 'VS_TYPE_NORMAL',
            'ip_address': {
                'addr': vip,
                'type': 'V4'
            },
            'enabled': True,
            'services': services_obj,
            'application_profile_name': 'System-HTTP',
            'pool_ref': pool_ref
        }

        # post VS data in json format to avi api
        resp = self.api.post('virtualservice', data=json.dumps(vs_obj))
        if resp.status_code in range(200, 299):
            logger.debug('Virtual service created successfully %s' % vs_name)
        else:
            logger.debug('Error creating virtual service : %s' % resp.text)
        return

    def create_pool(self, name, servers_obj, monitor_names=None,
                    lb_algorithm='LB_ALGORITHM_LEAST_CONNECTIONS'):
        health_monitors = None
        if monitor_names:
            health_monitors = []
            for monitor_name in monitor_names:
                health_monitor_tcp = self.api.get_object_by_name('healthmonitor',
                                                                 monitor_name)
                health_monitors.append(self.api.get_obj_ref(health_monitor_tcp))
        print(health_monitors)
        pool_name = name
        pool_obj = {
            "lb_algorithm": lb_algorithm,
            "default_server_port": 80,
            "name": pool_name,
            "servers": servers_obj,
            'health_monitor_refs': health_monitors
        }
        resp = self.api.post('pool', data=json.dumps(pool_obj))
        if resp.status_code in range(200, 299):
            return resp
        else:
            print('Error in creating pool :%s' % resp.text)
            exit(0)
        return


if __name__ == '__main__':

    parser = argparse.ArgumentParser()
    parser.add_argument('-idp', '--idp_class', help="IDP class such as OktaSAMLApiSession, "
                                                    "OneloginSAMLApiSession, etc",
                        default="OktaSAMLApiSession")
    parser.add_argument(
        '-s', '--server_ips',
        help='Pool Server IPs comma separated Eg. 1.1.1.1,2.2.2.2',
        default='1.1.1.1,1.1.1.2')
    parser.add_argument('-u', '--idp_user', help='IDP username',
                        default='foo@avinetworks.com')
    parser.add_argument('-p', '--idp_password', help='IDP user password',
                        default='foo123')
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
    parser.add_argument('--tenant-uuid', help='tenant uuid',
                        default=None)
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-i', '--vip', help='VIP address')

    args = parser.parse_args()
    print('parsed args', args)
    idp_cls = SAMLExample.get_idp_class(args.idp_class)

    # SAML authentication with given IDP and get the controller session
    api = ApiSession.get_session(args.controller_ip, args.idp_user, args.idp_password,
                                 tenant=args.tenant, tenant_uuid=args.tenant_uuid, idp_class=idp_cls)

    servers = [server.strip() for server in args.server_ips.split(',')]
    vse = SAMLExample(api)

    # Create basic VS
    vip = args.vip if args.vip else '10.10.42.2'
    vse.create_basic_vs('basic-vs', vip, servers)
