'''
Created on Jan 25, 2016

@author: grastogi
'''
import argparse
import json
import logging
import sys
from avi.sdk.avi_api import ApiSession

logger = logging.getLogger(__name__)
ch = logging.StreamHandler(sys.stdout)
root_logger = logging.getLogger()
root_logger.setLevel(logging.DEBUG)
root_logger.addHandler(ch)


def test_multi_tenant(args, tenants):
    '''
    1. get list of tenants
    2. create API for each tenant
    3. call virtual service get on each tenant
    '''
    t_apis = []
    for tenant in tenants:
        api = ApiSession.get_session(args.controller_ip, args.user, args.password,
                     tenant=tenant)
        t_apis.append(api)
        print(' created api for teant %s api %s' % (tenant, api))

    for _ in range(5):
        for api in t_apis:
            r = api.get('virtualservice')
            results = json.loads(r.text)['results']
            logger.debug(' tenant %s num vs %d', api.tenant, len(results))

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-u', '--user', default='admin', help='controller ip')
    parser.add_argument('-p', '--password', default='avi123',
                        help='controller ip')

    tenants = []
    args = parser.parse_args()
    logger.debug('parsed args %s', args)

    api = ApiSession.get_session(args.controller_ip, username=args.user,
                 password=args.password, tenant='admin')
    resp = api.get('tenant')
    logger.debug('resp code %d txt %s', resp.status_code, resp.text)

    tenants = (json.loads(resp.text))['results']

    tnames = [tenant['name'] for tenant in tenants]
    test_multi_tenant(args, tnames)
