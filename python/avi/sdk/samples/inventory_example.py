
############################################################################
 #
 # AVI CONFIDENTIAL
 # __________________
 #
 # [2013] - [2017] Avi Networks Incorporated
 # All Rights Reserved.
 #
 # NOTICE: All information contained herein is, and remains the property
 # of Avi Networks Incorporated and its suppliers, if any. The intellectual
 # and technical concepts contained herein are proprietary to Avi Networks
 # Incorporated, and its suppliers and are covered by U.S. and Foreign
 # Patents, patents in process, and are protected by trade secret or
 # copyright law, and other laws. Dissemination of this information or
 # reproduction of this material is strictly forbidden unless prior written
 # permission is obtained from Avi Networks Incorporated.
 ###

"""
Created on Aug 16, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)

Prints the vital vs information using inventory. It also pull metrics useful
for use cases like dashboard building.
Usage: python inventory_example.py -c 10.10.25.42 -u admin -p <paswd>

"""
import argparse
from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from requests.packages import urllib3
from collections import namedtuple

urllib3.disable_warnings()

VSData = namedtuple('VSData',
                    ['name', 'uuid', 'domain_name',
                     'pool_names', 'pool_refs', 'vh_parent_vs_name',
                     'metrics'])


def fetch_data(api_ssn, cloud, tenant, metric_ids):
    """
    :param api_ssn:
    :param cloud:
    :param tenant:
    :param metric_ids:
    :return:
    """

    api_utils = ApiUtils(api_ssn)
    api_params = {'cloud_ref.name': cloud, 'include_name': '',
                  'metric_id': metric_ids}
    vs_results = api_ssn.get(
        'virtualservice-inventory', params=api_params, tenant=tenant).json()

    results = []
    for vs in vs_results['results']:
        config = vs['config']
        pool_names = [pool.split('#')[1] for pool in vs.get('pools', [])]
        pool_refs = vs.get('pools', [])
        domain_name = config.get('vh_domain_name')
        vh_parent_vs_ref = config.get('vh_parent_vs_ref', '')
        vh_parent_vs_name = (
            vh_parent_vs_ref.split('#')[1] if vh_parent_vs_ref else '')
        metrics = vs['metrics']
        vs_data = VSData(
            name=config['name'], uuid=config['uuid'], domain_name=domain_name,
            pool_names=pool_names, pool_refs=pool_refs,
            vh_parent_vs_name=vh_parent_vs_name, metrics=metrics)
        results.append(vs_data)
    return results


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
    parser.add_argument('--cloud', help='cloud name',
                        default='Default-Cloud')
    parser.add_argument('--metric_ids', help='Comma separated list of metrics',
                        default='l7_client.sum_total_responses')
    parser.add_argument('--step',
                        help='Granularity of metrics. Eg. 5, 300, 3600',
                        type=int, default=300)
    parser.add_argument('--limit',
                        help='number of values',
                        type=int, default=2)
    parser.add_argument('-c', '--controller',
                        help='controller ip', default='127.0.0.1')
    parser.add_argument('--api_version',
                        help='API version to use for Avi APIs',
                        default='17.2.4')
    parser.add_argument('-u', '--username',
                        help='user name', default='admin')
    parser.add_argument('-p', '--password',
                        help='password', default='abc')

    args = parser.parse_args()
    print('parsed args', args)

    api_ssn = ApiSession(args.controller, args.username, args.password,
                         tenant=args.tenant, api_version=args.api_version)
    ret = fetch_data(api_ssn, args.cloud, args.tenant, args.metric_ids)

    for vs_data in ret:
        print 'Data for Virtualservice ', vs_data.name
        print '  ', vs_data