import argparse

from avi.protobuf.common_pb2 import AviObjectType
from avi.protobuf.metrics_query_pb2 import MetricsQuery
from avi.protobuf.options_pb2 import IpAddr
from avi.protobuf.options_pb2 import IpAddrType
from avi.protobuf.options_pb2 import MetricsEntityType
from avi.protobuf.pool_pb2 import LbAlgorithm
from avi.protobuf.pool_pb2 import Pool
from avi.protobuf.vs_pb2 import VirtualService
from avi.sdk.avi_sdk import AviSdk


class VirtualserviceSDKExample(object):
    def create_basic_vs(self, vs_name, vip, servers=None):
        # create pool protobuf object
        pool_pb = Pool()
        pool_pb.name = vs_name + 'pool_pb'
        pool_pb.lb_algorithm = LbAlgorithm.Value('LB_ALGORITHM_LEAST_CONNECTIONS')

        server_protos = []
        for server in servers:
            parts = server.split(':')
            ip_addr = parts[0]
            print(parts[1])
            port = parts[1] if len(parts) == 2 else 80
            server_proto = pool_pb.servers.add()
            ip = IpAddr()
            ip.addr = ip_addr
            ip.type = IpAddrType.Value('V4')
            server_proto.ip.CopyFrom(ip)
            print(port)
            server_proto.port = int(port)

        # post the pool protobuf with pool resource
        pool_resource = sdk.resource(AviObjectType.POOL)
        pool_obj = pool_resource.post(pool_pb)

        # create vs protobuf
        vs_pb = VirtualService()
        vs_pb.name = vs_name
        service = vs_pb.services.add()
        service.port = 80
        ip = IpAddr()
        ip.addr = vip
        ip.type = IpAddrType.Value('V4')
        vs_pb.ip_address.CopyFrom(ip)
        vs_pb.pool_uuid = pool_obj.protobuf().uuid

        # post vs protobuf using vs resource
        vs_obj = vs_resource.post(vs_pb)

        print('Virtual service created successfully')


    def scaleout_vs(self, vs_name):
        # get the vs avi object by name
        vs_obj = vs_resource.get_by_name(vs_name)
        # avi object will have the actions for the entities hence scaleout can be called on vs_obj
        new_vs_obj = vs_obj.scaleout()
        print('Virtual service scaled out successfully')

    def delete_vs(self, name):
        vs_resource.delete(name=name)
        print('Virtual service deleted successfully')

    def get_metrics(self, metric_entity, metric_entity_uuid, metric_ids):
        # To get the metric data need to create metric query object
        mq_req = MetricsQuery()  # protobuf
        mq_req.metric_entity = metric_entity
        mq_req.entity_uuid = metric_entity_uuid
        mq_req.metric_id = metric_ids
        mq_req.step = 300
        mq_req.limit = 12

        # metric data can be fetched from analytics resource
        analytics_resource = sdk.resource(AviObjectType.ANALYTICS)
        metric_obj = analytics_resource.get(mq_req)
        print(metric_obj)

    def get_vs_inventory(self, name):
        vs_obj = vs_resource.get_by_name()
        # inventory for every entity is available in the avi object of that entity
        return vs_obj.inventory()
        print(inventory)



if __name__ == '__main__':

    parser = argparse.ArgumentParser()
    parser.add_argument('-o', '--option',
                        choices=['create-basic-vs', 'show-vs-inventory',  'delete-vs',
                                 'show-vs-metric', 'scaleout-vs'],
                        help='lastest timestamp',
                        default='create-basic-vs')
    parser.add_argument('-n', '--vs_name_suffix',
                        help='VirtualService Name Suffix',
                        default='vs')
    parser.add_argument(
        '-s', '--server_ips',
        help='Pool Server IPs comma separated Eg. 1.1.1.1,2.2.2.2',
        default='1.1.1.1,1.1.1.2')
    parser.add_argument('-u', '--user', help='controller user',
                        default='admin')
    parser.add_argument('-p', '--password', help='controller user password',
                        default='avi123')
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default='admin')
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-i', '--vip', help='VIP address')

    parser.add_argument('-r', '--resource_name',
                        help='Resource Name to be deleted',
                        default='basic-vs')
    parser.add_argument('-m', '--metric_id',
                        help='Comma separated metric ids',
                        default='l4_client.avg_bandwidth')


    args = parser.parse_args()
    sdk = AviSdk('10.10.24.152', 'admin', 'avi123')
    vs_resource = sdk.resource(AviObjectType.VIRTUALSERVICE)
    vse = VirtualserviceSDKExample()
    servers = [server.strip() for server in args.server_ips.split(',')]
    if args.option == 'create-basic-vs':
        vip = args.vip if args.vip else '10.10.42.2'
        vs_name = 'basic-' + args.vs_name_suffix
        vse.create_basic_vs(vs_name, vip, servers)
    elif args.option == 'show-vs-metric':
        vs_obj = vs_resource.get_by_name(args.resource_name)
        vse.get_metric(MetricsEntityType.VSERVER_METRICS_ENTITY, vs_obj.protobuf().uuid , args.metric_id)
    elif args.option == 'delete-vs':
        vse.delete(args.resource_name)
    elif args.option == 'show-vs-inventory':
        inventory = vse.get_vs_inventory(args.resource_name)


