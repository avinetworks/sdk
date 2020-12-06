#!/usr/bin/env python3

import argparse
import json
import datetime

from avi.sdk.avi_api import ApiSession
from requests.packages import urllib3

urllib3.disable_warnings()


HELP_STR = '''
Example of fetching vs application logs
    fetch_logs.py -c 10.10.25.42 -p xxxx
    fetch_logs.py -c 10.10.25.42 -p xxxx -s 3600 -e 60
'''


def fetch_logs(api_session, tenant, vs_name, start_date, end_date, outfile):
    outfile = open(outfile, "w")
    outfile.write("[\n")
    path = "/analytics/logs/"
    num_fetched = 0
    num_to_fetch = -1
    first_line = True
    while start_date < end_date:
        # make request for logs [start_date, up_to]:
        query_options = "virtualservice={}&start={}&end={}".format(
            vs_name,
            # The API claims to expect ISO 8601 format, but rejects the request if we use it:
            # start_date.isoformat(), end_date.isoformat()
            # instead it seems to be unable to handle time zones. The following works:
            f"{start_date:%Y-%m-%dT%H:%M:%S.%fZ}", f"{end_date:%Y-%m-%dT%H:%M:%S.%fZ}"
        )
        print("Query String: '{}'".format(query_options))
        query_options += "&type=1&page_size=10000&udf=true&nf=true&orderby=report_timestamp"
        result = api_session.get(path, tenant=tenant, params=query_options)
        j = result.json()
        if num_to_fetch == -1:
            # first fetch
            num_to_fetch = j['count']
        print("To fetch: {}, in this batch: {}".format(num_to_fetch, len(j['results'])))
        if num_to_fetch == 0:
            break
        if len(j['results']) == 0:
            print("Expected results, but none found!")
            exit(1)
        for applog in j['results']:
            if not first_line:
                outfile.write(",\n")
            first_line = False
            outfile.write(json.dumps(applog, indent=4))

        print(" First time stamp:{},\n last time stamp: {}".format(
            j['results'][0]['report_timestamp'],
            j['results'][-1]['report_timestamp']))

        num_fetched += len(j['results'])

        # if there's a 'next' hint in the response, use it
        #
        # note that due to a current limitation, for page_size = 10k, there
        # is never a 'next' link. this can change, so we handle it here anyway
        while 'next' in j:
            # fetch page after page, update num_fetched, save result
            next = j['next']
            qs = next.split('?')[1]
            print("New query string from 'next': {}".format(qs))
            result = api_session.get(path, tenant=tenant, params=qs)
            j = result.json()
            for applog in j['results']:
                outfile.write(",\n")
                outfile.write(json.dumps(applog, indent=4))
            num_fetched += len(j['results'])
            print("Newly fetched: {}, total: {}".format(len(j['results']), num_fetched))
        print("No 'next' link, to fetch: {}, fetched: {}".format(num_to_fetch, num_fetched))

        if num_fetched < num_to_fetch:
            # NB: percent_remaining is unreliable: it's 0 even when there are more logs!
            # To avoid fetching the same us twice, we increment by 1 us (and risk
            # missing logs if there is more than 1 per us)
            start_date = j['results'][-1]['report_timestamp']
            start_date = datetime.datetime.fromisoformat(start_date) + datetime.timedelta(microseconds=1)
            print("New start date: {}".format(start_date.isoformat()))  # f"{start_date:%Y-%m-%dT%H:%M:%S.%fZ}"))
        else:
            break

    print("Done")
    outfile.write("\n]\n")
    outfile.close()


def compute_date(value):
    my_tz = datetime.datetime.now(datetime.timezone(datetime.timedelta(0))).astimezone().tzinfo
    result = datetime.datetime.now(tz=my_tz)

    try:
        delta = float(value)
        seconds = int(delta)
        micros = int((delta-seconds)*100000)
        result -= datetime.timedelta(seconds=seconds, microseconds=micros)
    except Exception as e:
        result = datetime.datetime.fromisoformat(args.start)

    return result


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default=None)
    parser.add_argument('-v', '--vs_name', help='VS Name')
    parser.add_argument('-s', '--start',
                        help='Start date for fecthing logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative: 3600.0 (from 1h before now)', default='3600')
    parser.add_argument('-e', '--end',
                        help='End date for fecthing logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative: 60.0 (up to 1 minute before now)', default='0')
    parser.add_argument('-c', '--controller',
                        help='controller ip', default='127.0.0.1')
    parser.add_argument('-u', '--username',
                        help='user name', default='admin')
    parser.add_argument('-p', '--password',
                        help='password', default='admin')
    parser.add_argument('-o', '--outfile',
                        help='File to store resulting JSON array in', default='fetch_logs.json')

    args = parser.parse_args()

    start_date = compute_date(args.start)
    end_date = compute_date(args.end)

    if start_date >= end_date:
        print("Start date must be before end date: {} vs {}".format(start_date, end_date))
        exit(1)

    api_session = ApiSession(args.controller, args.username, args.password,
                             args.tenant)
    fetch_logs(api_session, args.tenant, args.vs_name, start_date, end_date, args.outfile)
