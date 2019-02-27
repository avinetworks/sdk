import argparse
import json

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from requests.packages import urllib3
urllib3.disable_warnings()


HELP_STR =  '''
Example of fetching vs metrics
    python vs_metrics.py -c 10.10.25.42 -p xxxx --limit 1 
    python vs_metrics.py -c 10.10.25.42 -p xxxx --limit 1 -m 'l7_client.avg_complete_responses,l4_client.avg_bandwidth'
'''

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
    parser.add_argument('-m', '--metrics', help='VS Metrics to fetch',
                        default=None)
    parser.add_argument('-v', '--vs_name', help='VS Name',
                        default='*')
    parser.add_argument('-s', '--step',
                        help='Granularity of metrics. Eg. 5, 300, 3600',
                        type=int, default=3600)
    parser.add_argument('-l', '--limit',
                        help='number of values',
                        type=int, default=168)
    parser.add_argument('-c', '--controller',
                        help='controller ip', default='127.0.0.1')
    parser.add_argument('-u', '--username',
                        help='user name', default='admin')
    parser.add_argument('-p', '--password',
                        help='password', default='admin')


    args = parser.parse_args()
    #print('parsed args', args)

    api_ssn = ApiSession(args.controller, args.username, args.password,
                         args.tenant)
    api_utils = ApiUtils(api_ssn)

    entity_uuid = '*'
    if args.vs_name != '*':
        vs_obj = api_ssn.get_object_by_name('virtualservice', args.vs_name)
        entity_uuid = vs_obj['uuid']

    mq = {
        'metric_id': (args.metrics if args.metrics else 'l4_client.avg_bandwidth,l4_client.avg_complete_conns,l7_client.avg_complete_responses,l7_client.sum_get_reqs, l7_client.sum_post_reqs'),
        'tenant': (args.tenant if args.tenant else 'admin'),
        'step': args.step,
        'limit': args.limit,
        'entity_uuid': entity_uuid,
        'pad_missing_data': False
    }

    rsp = api_utils.get_metrics_collection(tenant=args.tenant,
                                           metric_requests=[mq])
    #print 'metrics query', mq
    print json.dumps(rsp, indent=2)

