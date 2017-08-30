import argparse
import json

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from requests.packages import urllib3
urllib3.disable_warnings()


HELP_STR = '''
Example of fetching vs metrics for a given se
    python se_vs_metrics.py -c 10.10.25.42 -p xxxx --limit 1 --se_uuid 'se-005056b01755'
'''

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
    parser.add_argument('--se_uuid', help='se uuid')
    parser.add_argument('--vs_metrics', help='VS Metrics to fetch for SE',
                        default='l4_client.avg_bandwidth')

    parser.add_argument('--per_vs_metrics',
                        help='Provide per vs or Aggregated metrics',
                        action='store_true')
    parser.add_argument('--step',
                        help='Granularity of metrics. Eg. 5, 300, 3600',
                        type=int, default=300)
    parser.add_argument('--limit',
                        help='number of values',
                        type=int, default=2)
    parser.add_argument('-c', '--controller',
                        help='controller ip', default='127.0.0.1')
    parser.add_argument('-u', '--username',
                        help='user name', default='admin')
    parser.add_argument('-p', '--password',
                        help='password', default='abc')

    args = parser.parse_args()
    print('parsed args', args)

    mq = {
        'metric_id': args.vs_metrics,
        'serviceengine_uuid': args.se_uuid,
        'tenant': (args.tenant if args.tenant else 'admin'),
        'step': args.step,
        'limit': args.limit,
        'aggregate_entity': not args.per_vs_metrics,
        'entity_uuid': '*',
        'pad_missing_data': False
    }

    api_ssn = ApiSession(args.controller, args.username, args.password,
                         args.tenant)
    api_utils = ApiUtils(api_ssn)

    rsp = api_utils.get_metrics_collection(tenant=args.tenant,
                                           metric_requests=[mq])
    print 'metrics query', mq
    print json.dumps(rsp, indent=2)