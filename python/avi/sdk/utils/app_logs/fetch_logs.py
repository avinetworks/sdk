#!/usr/bin/env python3

import collections
import argparse
import json
import datetime
from time import sleep

from avi.sdk.avi_api import ApiSession
from requests.packages import urllib3

urllib3.disable_warnings()

from parse_logs import process_applog_entry, DictOfInts, show_results

class LogResponseException(Exception):
    def __init__(self, num_to_fetch, num_fetched, page_size):
        super().__init__("Expected {} results, but none found!".format(
            min(min(10000, num_to_fetch), num_to_fetch-num_fetched))
        )


HELP_STR = '''
Example of fetching vs application logs
    fetch_logs.py -c 10.10.25.42 -p xxxx
    fetch_logs.py -c 10.10.25.42 -p xxxx -s 3600 -e 60
'''


def fetch_logs(api_session, tenant, vs_name, fields, start_date, end_date, page_size, delay, top_N, outfile_name, log_all):
    uas = collections.defaultdict(DictOfInts)
    browsers = collections.defaultdict(int)

    waf_rules = collections.defaultdict(int)
    # { "ARGS:foo" => { "count": 137, "values" => { "val1:" 3, "val2": 66 } } }
    match_elements = {}

    waf_hits = 0
    waf_elements = 0

    logall_filecount = 0

    if outfile_name:
        outfile = open(outfile_name, "w")
        outfile.write("[\n")
    path = "/analytics/logs/"
    num_fetched = 0
    num_to_fetch = 0
    first_line = True
    fixed_options = "virtualservice={}&type=1&page_size={}&udf=true&nf=true&orderby=report_timestamp".format(vs_name, page_size)
    if fields:
        fixed_options += "&cols={}".format(fields)
    while start_date < end_date:
        # make request for logs [start_date, up_to]:
        time_options = "&start={}&end={}".format(
            # The API claims to expect ISO 8601 format, but rejects the request if we use it:
            # start_date.isoformat(), end_date.isoformat()
            # instead it seems to be unable to handle time zones. The following works:
            f"{start_date:%Y-%m-%dT%H:%M:%S.%fZ}", f"{end_date:%Y-%m-%dT%H:%M:%S.%fZ}"
        )
        query_options = fixed_options + time_options
        print("Query String: '{}'".format(query_options))

        result = api_session.get(path, tenant=tenant, params=query_options)
        if log_all:
            logfile_name = "/tmp/fetch_logs_logall-{}".format(logall_filecount)
            logall_filecount += 1
            logfile = open(logfile_name, "w")
            logfile.write(result.text)
            logfile.close()

        j = result.json()
        num_to_fetch = j['count']
        print("To fetch: {}, in this batch: {}".format(num_to_fetch, len(j['results'])))
        if num_to_fetch == 0:
            break
        if len(j['results']) == 0:
            if outfile_name:
                outfile.write("\n]\n")
                outfile.close()
            raise LogResponseException(num_to_fetch, num_fetched, page_size)
        for applog in j['results']:
            hits, elements = process_applog_entry(applog, uas, browsers, waf_rules, match_elements)
            waf_hits += hits
            waf_elements += elements

            if outfile_name:
                if not first_line:
                    outfile.write(",\n")
                first_line = False
                outfile.write(json.dumps(applog, indent=4))

        print(" First time stamp:{},\n last time stamp: {}".format(
            j['results'][0]['report_timestamp'],
            j['results'][-1]['report_timestamp']))

        num_fetched += len(j['results'])

        # if there's a 'next' hint in the response, use it
        # note that due to a current limitation, for page_size = 10k, there
        # is never a 'next' link.
        while 'next' in j:
            # fetch page after page, update num_fetched, save result
            next = j['next']
            qs = next.split('?')[1]
            print("New query string from 'next': {}".format(qs))
            if delay > 0:
                sleep(delay)
            result = api_session.get(path, tenant=tenant, params=qs)
            if log_all:
                logfile_name = "/tmp/fetch_logs_logall-{}".format(logall_filecount)
                logall_filecount += 1
                logfile = open(logfile_name, "w")
                logfile.write(result.text)
                logfile.close()
            j = result.json()
            for applog in j['results']:
                hits, elements = process_applog_entry(applog, uas, browsers, waf_rules, match_elements)
                waf_hits += hits
                waf_elements += elements

                if outfile_name:
                    outfile.write(",\n")
                    outfile.write(json.dumps(applog, indent=4))
                
            num_fetched += len(j['results'])
            print("Newly fetched: {}, total: {}".format(len(j['results']), num_fetched))
        print("No 'next' link, to fetch: {}, fetched: {}".format(num_to_fetch, num_fetched))

        # To avoid fetching the same us twice, we increment by 1 us (and risk
        # missing logs if there is more than 1 per us)
        start_date = j['results'][-1]['report_timestamp']
        start_date = datetime.datetime.fromisoformat(start_date) + datetime.timedelta(microseconds=1)
        print("New start date: {}".format(start_date.isoformat()))  # f"{start_date:%Y-%m-%dT%H:%M:%S.%fZ}"))
        if delay > 0:
            sleep(delay)

    if num_fetched >= num_to_fetch:
        print("Done")
    else:
        print("Download incomplete: Expected {}, got {} log lines".format(num_to_fetch, num_fetched))
    if outfile_name:
        outfile.write("\n]\n")
        outfile.close()

    if num_fetched > 0:
        show_results(top_N, False, num_fetched, uas, browsers, waf_rules, match_elements, waf_hits, waf_elements)

    return num_fetched >= num_to_fetch


def compute_date(value):
    my_tz = datetime.datetime.now(datetime.timezone(datetime.timedelta(0))).astimezone().tzinfo
    result = datetime.datetime.now(tz=my_tz)

    try:
        if value.endswith('d'):
            value = float(value[:-1]) * 24 * 3600  # days -> seconds
        delta = float(value)
        seconds = int(delta)
        micros = int((delta-seconds)*100000)
        result -= datetime.timedelta(seconds=seconds, microseconds=micros)
    except Exception as e:
        result = datetime.datetime.fromisoformat(value)

    return result

def main():
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-a', '--authtoken', help='Authentication token')
    parser.add_argument('-b', '--batchsize', help='Batch size for fetching logs', default=100, type=int)
    parser.add_argument('-c', '--controller', help='controller ip', default='127.0.0.1')
    parser.add_argument('-d', '--delay', help='delay in seconds between requests, eg 0.1', default=1, type=float)
    parser.add_argument('-e', '--end',
                        help='End date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 60.0 (up to 60 seconds = 1 minute before now) or 1.5d',
                        default='0')
    parser.add_argument('-f', '--fields', help='Log fields to fetch, e.g. user_agent,client_ip; default: none for all fields',
                        default=None)
    parser.add_argument('-l', '--logall', help='Log all JSON data received from controller into files', action="store_true")
    parser.add_argument('-n', '--top_n', help='Top N occurrences to show', default=10, type=int)
    parser.add_argument('-o', '--outfile', help='File to store resulting JSON array in. If not supplied, only summary is saved',
                        default=None)
    parser.add_argument('-p', '--password', help='password')
    parser.add_argument('-s', '--start',
                        help='Start date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 3600.0 (3600 seconds = 1h before now) or 1d (in the last day)',
                        default='3600')
    parser.add_argument('-t', '--tenant', help='tenant name', default=None)
    parser.add_argument('-u', '--username', help='user name', default='admin')
    parser.add_argument('-v', '--vs_name', help='VS Name', required=True)
    parser.add_argument('-y', '--summary', help='only show summary, not individual log entries', type=bool,
                        default=False)

    args = parser.parse_args()

    start_date = compute_date(args.start)
    end_date = compute_date(args.end)

    if start_date >= end_date:
        print("Start date must be before end date: {} vs {}".format(start_date, end_date))
        exit(1)

    batch_size = args.batchsize
    if batch_size <= 0:
        print("Batch size must be greater than zero")
        exit(1)

    delay = args.delay
    if delay < 0:
        print("Delay must not be negative")
        exit(1)

    if args.authtoken:
        api_session = ApiSession(args.controller, args.username, args.tenant, token=args.authtoken)
    elif args.password:
        api_session = ApiSession(args.controller, args.username, args.password, args.tenant)
    else:
        print("Password or authentication token must be supplied")
        exit(1)

    try:
        success = fetch_logs(api_session, args.tenant, args.vs_name, args.fields, start_date, end_date,
                             batch_size, delay, args.top_n, args.outfile, args.logall)
        exit(0 if success else 1)
    except Exception as e:
        print(str(e))
        exit(1)

if __name__ == '__main__':
    main()
