import json

import argparse

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils


class PatchAPIexample(object):
    """
    Provides example for following operations
    1. Create a pool
    2. Add new servers to existing pool
    3. Replace a server in the pool
    4. Delete a server from the pool
    5. Delete a pool
    """
    def __init__(self, api_session):
        self.api_session = api_session
        self.api_util = ApiUtils(api_session)

    def get_server_obj(self, server):
        """
        The function creates json based avi side object from provided server information
        :param server: server ip address with port no (port no is optional)
        """
        parts = server.split(':')
        ip_addr = parts[0]
        port = parts[1] if len(parts) == 2 else 80
        server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'port': port
            }
        return server_obj

    def get_servers_obj(self, servers):
        """
        Get server objects from list of raw server string
        """
        servers_obj = []
        for server in servers:
            servers_obj.append(self.get_server_obj(server))
        return servers_obj

    def create_pool(self, name, servers_obj, monitor_names=None,
                    lb_algorithm='LB_ALGORITHM_LEAST_CONNECTIONS'):
        """
        Create a test pool from provided information
        :param name: Name of the pool
        :param servers_obj: list of servers to be added in the pool
        :param monitor_names: list of health monitors to be attached to pool
        :param lb_algorithm: Load balancer algorithm to be used for the pool
        """
        health_monitors = None
        if monitor_names:
            health_monitors = []
            for monitor_name in monitor_names:
                health_monitor_tcp = self.api_session.get_object_by_name('healthmonitor',
                                                                 monitor_name)
                health_monitors.append(self.api_session.get_obj_ref(health_monitor_tcp))
        print(health_monitors)
        pool_name = name
        server_objs = self.get_servers_obj(servers_obj)
        pool_obj = {
            "lb_algorithm": lb_algorithm,
            "default_server_port": 80,
            "name": pool_name,
            "servers": server_objs,
            'health_monitor_refs': health_monitors
        }
        resp = self.api_session.post('pool', data=json.dumps(pool_obj))
        if resp.status_code in range(200, 299):
            return resp
        else:
            print('Error in creating pool :%s' % resp.text)
            exit(0)

    def add_server_to_pool(self, server, pool_uuid):
        """
        Add a new server to existing pool
        :param server: list of servers to be added to the pool
        :param pool_uuid: uuid of the pool to which servers to be added
        """
        api_url = f"/pool/{pool_uuid}"
        server_obj = self.get_servers_obj(server)

        data = {
            "json_patch": [{
                "op": "add",
                "path": "/servers",
                "value": server_obj
            }]
        }

        resp = self.api_session.patch(path=api_url, data=json.dumps(data))
        if resp.status_code in range(200, 299):
            return resp
        else:
            print("Error in adding server to pool: %s" % resp.text)
            exit(0)

    def remove_server_from_pool(self, server_key, pool_uuid):
        """
        Remove a server from a pool
        :param server_key: key/index of the server the pool which is to be removed
        :param pool_uuid: uuid of the pool from which the server is to be removed
        """
        api_url = f"/pool/{pool_uuid}"

        data = {
            "json_patch": [
                {
                    "op": "remove",
                    "path": f"/servers/{server_key}"
                }
            ]
        }

        resp = self.api_session.patch(path=api_url, data=json.dumps(data))
        if resp.status_code in range(200, 299):
            return resp
        else:
            print("Error in removing server to pool: %s" % resp.text)
            exit(0)

    def update_server_in_pool(self, server_key, pool_uuid, server_ip):
        """
        Update a server information in a pool
        :param server_key: key/index of a server in a pool which is to be updated
        :param pool_uuid: uuid of the pool in which server is to be updated
        :param server_ip: new IP address of the server to which pool is to be updated
        """
        api_url = f"/pool/{pool_uuid}"
        server_obj = self.get_server_obj(server_ip)

        data = {
            "json_patch": [
                {
                    "op": "replace",
                    "path": f"/servers/{server_key}",
                    "value": server_obj,
                    f"{server_key}": "server-1"
                }
            ]
        }

        resp = self.api_session.patch(path=api_url, data=json.dumps(data))
        if resp.status_code in range(200, 299):
            return resp

        else:
            print("Error in updating server in pool: %s" % resp.text)
            exit(0)


if __name__ == "__main__":
    HELP_STR = """
    Patch API example for Avi SDK.
    1. Example to create a pool in a controller:
    python patch_api_example.py --controller_ip='10.10.10.10' --user="username"\
    --password="password" --tenant="admin" --option="create_pool"
    2. Example to add a server to an existing pool:
    python patch_api_example.py --controller_ip='10.10.10.10' --user="username" --password="password"\
    --tenant="admin" --option="add_server" --server_ips="10.10.10.10,1.1.1.1,2.2.2.2"\
    --pool_uuid="pool-uuid"
     3. Example to update a server to an existing pool:
    python patch_api_example.py --controller_ip='10.10.10.10' --user="username" --password="password"\
    --tenant="admin" --option="update_server" --server_ips="10.11.11.10"\
    --pool_uuid="pool-uuid" --server_key=1
    4. Example to remove a server from a pool:
    python patch_api_example.py --controller_ip='10.10.10.10' --user="username" --password="password"\
    --tenant="admin" --option="remove_server" --pool_uuid="pool-uuid" --server_key=0
    """
    parser = argparse.ArgumentParser(description=HELP_STR)
    parser.add_argument('-o', '--option',
                        choices=['create_pool', 'add_server', 'remove_server', 'update_server'],
                        default='create_pool')
    parser.add_argument('-n', '--pool_name', default='test_pool')
    parser.add_argument('-s', '--server_ips', default='1.1.1.1,2.2.2.2')
    parser.add_argument('-u', '--user', default='admin')
    parser.add_argument('-p', '--password', default='admin')
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
    parser.add_argument('--tenant-uuid', help='tenant uuid',
                        default=None)
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-k', '--server_key', help="server key to update or delete the server")
    parser.add_argument('-i', '--pool_uuid', help="pool_uuid for identifying which pool to be updated")

    args = parser.parse_args()
    print("Input args: ", args)

    api = ApiSession.get_session(args.controller_ip, args.user, args.password,
                                 tenant=args.tenant, tenant_uuid=args.tenant_uuid)
    servers = [server.strip() for server in args.server_ips.split(',')]

    ptch_exmpl = PatchAPIexample(api_session=api)

    if args.option == 'create_pool':
        ptch_exmpl.create_pool(args.pool_name, servers)

    elif args.option == 'add_server':
        ptch_exmpl.add_server_to_pool(servers, pool_uuid=args.pool_uuid)

    elif args.option == 'remove_server':
        ptch_exmpl.remove_server_from_pool(args.server_key, args.pool_uuid)

    elif args.option == 'update_server':
        ptch_exmpl.update_server_in_pool(args.server_key, args.pool_uuid, servers[0])
