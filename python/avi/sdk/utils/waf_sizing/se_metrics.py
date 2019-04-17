from __future__ import print_function

import argparse
import json

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from requests.packages import urllib3
from metrics_list import metrics

urllib3.disable_warnings()

HELP_STR = '''
Example of fetching vs metrics for a given se
    python se_metrics.py -c 10.10.25.42 -p xxxx --limit 1 --se_uuid 'se-005056b01755'
'''

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
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
    parser.add_argument('--se_uuid',
                        help='SE UUID', required=True)


    args = parser.parse_args()
    #print('parsed args', args)

    api_ssn = ApiSession(args.controller, args.username, args.password,
                         args.tenant)
    api_utils = ApiUtils(api_ssn)

    entity_uuid = '*'
    mq = [
        {
            'metric_id': "se_stats.avg_cpu_usage",
            'tenant': (args.tenant if args.tenant else 'admin'),
            'step': args.step,
            'limit': args.limit,
            'serviceengine_uuid':  args.se_uuid,
            'pad_missing_data': False,
        },
        {
            'metric_id': metrics,
            'tenant': (args.tenant if args.tenant else 'admin'),
            'step': args.step,
            'limit': args.limit,
            'serviceengine_uuid':  args.se_uuid,
            'entity_uuid': entity_uuid,
            'pad_missing_data': False,
            #"dimension_aggregation": "METRICS_DIMENSION_AGG_SUM",
            #"aggregate_entity":True
        }
        ]
    rsp = api_utils.get_metrics_collection(tenant=args.tenant,
                                           metric_requests=mq)

    #print("metrics query {0}".format(mq))
    print(json.dumps(rsp, indent=2))
