#!/usr/bin/env python3

import os.path
import subprocess
import sys
import csv
import ast
import collections
import argparse
import json
import datetime
from time import sleep

from avi.sdk.avi_api import ApiSession
from requests.packages import urllib3

urllib3.disable_warnings()


class LogResponseException(Exception):
    def __init__(self, num_to_fetch):
        super().__init__("Expected {} results, but none found!".format(num_to_fetch))


HELP_STR = '''
Example of fetching vs application logs
    fetch_logs.py -c 10.10.25.42 -p xxxx
    fetch_logs.py -c 10.10.25.42 -p xxxx -s 3600 -e 60
'''


def load_csv_file(csv_file, jsn_file, verbose):

    result = []
    with open(csv_file) as fp:
        if verbose:
            print("CSV")
        logs = csv.DictReader(fp, delimiter=',', quotechar='"')
        fields_with_structure = [
            'waf_log', 'significant_log', 'client_cipher_list', 'paa_log', 'icap_log', 'saml_log', 'jwt_log',
            'DataScriptErrorTrace', 'connection_error_info']

        for line, row in enumerate(logs, 1):
            if verbose:
                print("Processing line {}".format(line))
            for f in fields_with_structure:
                if row.get(f, None):
                    try:
                        info = ast.literal_eval(row[f])
                    except Exception as e:
                        print("Failed to parse column {} in line {} as "
                              "python AST:\n{}\n Error: {}".format(f, line, row[f], e))
                        exit(1)
                    row[f] = info
            result.append(row)

        with open(jsn_file, "w") as jsnfile:
            jsnfile.write(json.dumps(result, sort_keys=True, indent=4))
    return result


def show_top_matchelements(match_elements, N, out_fd=sys.stdout):
    matches_by_count = list(sorted(match_elements.items(), key=lambda item: item[1]['count'], reverse=True))
    TOP_N = N if len(matches_by_count) > N else len(matches_by_count)
    out_fd.write("\nTop {} Match Elements by times hit\n\n".format(TOP_N))
    for value, count in matches_by_count[:TOP_N]:
        out_fd.write("{} <==> {}\n".format(count['count'], value))
    for top_hit in matches_by_count[:TOP_N]:
        element_name = top_hit[0]
        match_info = match_elements[element_name]
        values = match_info['values']
        values_by_count = list(sorted(
            values.items(), key=lambda item: item[1], reverse=True))
        out_fd.write("\nElement name {}\n".format(element_name))
        TOP_V = N if len(values_by_count) > N else len(values_by_count)
        for top_value in values_by_count[:TOP_V]:
            out_fd.write("  {} <==> {}\n".format(top_value[1], top_value[0]))
            value_info = values[top_value[0]]


def show_top_uas(uas, N, dns, out_fd=sys.stdout):
    top_uas = N if len(uas) > N else len(uas)
    uas_by_count = list(sorted(uas.items(), key=lambda item: item[1]['total'], reverse=True))
    for value, counts in uas_by_count[:top_uas]:
        out_fd.write("{} <==> {}\n".format(counts['total'], value))
        top_ips = N+1 if len(counts) > N+1 else len(counts)
        ips_by_count = list(sorted(counts.items(), key=lambda item: item[1], reverse=True))
        for ip, count in ips_by_count[1:top_ips]:
            if dns:
                dns_msg = "FAIL"
                ans = subprocess.run(["set -o pipefail; host " + ip + " | awk '{print $NF}'"], shell=True,
                                     stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                     universal_newlines=True)
                if ans.returncode == 0:
                    dns = ans.stdout[:len(ans.stdout)-1]
                    ans = subprocess.run(["set -o pipefail; host -t A " + dns + " | awk '{print $NF}'"], shell=True,
                                         stdout=subprocess.PIPE, stderr=subprocess.PIPE,
                                         universal_newlines=True)
                    if ans.returncode == 0:
                        r_dns = ans.stdout[:len(ans.stdout)-1]
                        if r_dns == ip:
                            dns_msg = "ok"
                        else:
                            dns_msg = "mismatch"
                    else:
                        r_dns = 'forward lookup failed'
                else:
                    dns = 'reverse lookup failed'
                    r_dns = 'n/a'
                out_fd.write("  {} <==> {} ({}: {} - {})\n".format(count, ip, dns_msg, dns, r_dns))
            else:
                out_fd.write("  {} <==> {}\n".format(count, ip))


def show_top_rules(waf_rules, N, out_fd=sys.stdout):
    rules_by_count = list(sorted(waf_rules.items(), key=lambda item: item[1], reverse=True))
    TOP_N = N if len(waf_rules) > N else len(waf_rules)
    out_fd.write("\nTop {} WAF rules by times hit:\n\n".format(TOP_N))
    for value, count in rules_by_count[:TOP_N]:
        out_fd.write("{} <==> {}\n".format(count, value))


def get_filenames(filename):
    csv_file = ''
    if filename.endswith('.csv'):
        csv_file = filename
        jsn_file = '.'.join(filename.split('.')[:-1]) + '.json'
    elif filename.endswith('.json'):
        jsn_file = filename
    else:  # try appending csv or json
        candidate = filename + ".csv"
        if os.path.isfile(candidate):
            csv_file = candidate
            jsn_file = filename + ".json"
        else:
            candidate = filename + ".json"
            if os.path.isfile(candidate):
                jsn_file = candidate
    return csv_file, jsn_file


def get_log_data(filename, verbose):
    csv_file, jsn_file = get_filenames(filename)
    result = []
    try:
        with open(jsn_file) as fp:
            if verbose:
                print("JSON")
            result = json.load(fp)
    except Exception as e:
        result = load_csv_file(csv_file, jsn_file, verbose)

    return result


def DictOfInts():
    return collections.defaultdict(int)


def process_applog_entry(applog, uas, browsers, waf_rules, match_elements):
    (waf_hits, waf_elements) = (0, 0)
    ua = applog.get('user_agent', "<NONE>")
    uas[ua]['total'] += 1
    uas[ua][applog.get('client_ip', '<UNKNOWN>')] += 1

    browsers[applog.get('client_browser', '<NONE>')] += 1
    waf_log = applog.get('waf_log', "")
    if waf_log != "":
        status = waf_log.get('status', "")
        if status == "FLAGGED" or status == "REJECTED":
            waf_hits += 1
        rls = waf_log.get('rule_logs', [])
        for rl in rls:
            waf_rules[rl['rule_id']] += 1
            ms = rl.get('matches', [])
            waf_elements += len(ms)
            for m in ms:
                e = match_elements.get(m['match_element'], {'count': 0, "values": {}})
                e['count'] += 1
                v = e['values']
                v[m['match_value']] = v.get(m['match_value'], 0)+1
                match_elements[m['match_element']] = e

    return waf_hits, waf_elements


def process_results(result, dns):
    # { 'firefox': { 'total': 10032, '1.1.1.1' : 137, '2.2.2.2': 2043, ... }, ... }
    uas = collections.defaultdict(DictOfInts)
    browsers = collections.defaultdict(int)

    waf_rules = collections.defaultdict(int)
    # { "ARGS:foo" => { "count": 137, "values" => { "val1:" 3, "val2": 66 } } }
    match_elements = {}

    # TODO:
    methods = {}
    significant_logs = {}
    psm_logs = {}
    # ....

    waf_hits = 0
    waf_elements = 0

    for applog in result:
        hits, elements = process_applog_entry(applog, uas, browsers, waf_rules, match_elements)
        waf_hits += hits
        waf_elements += elements

    return uas, browsers, waf_rules, match_elements, waf_hits, waf_elements


def show_results(TOP_N, dns, num_entries, uas, browsers, waf_rules, match_elements,
                 waf_hits, waf_elements, out_fd=sys.stdout):
    elements_per_hit = 0
    if waf_hits > 0:
        elements_per_hit = round(waf_elements/waf_hits, 1)
    out_fd.write("Total number of entries     : {}, waf hits: {} ({}%), waf elements: {}, elements per hit: {}\n"
                 .format(num_entries, waf_hits, round(100.0*waf_hits/num_entries, 1), waf_elements, elements_per_hit))
    out_fd.write("Different User-Agents       : {}, browsers: {}\n".format(len(uas), len(browsers)))
    out_fd.write("Different WAF rules hit     : {}\n".format(len(waf_rules)))
    out_fd.write("Different WAF match elements: {}\n".format(len(match_elements)))

    out_fd.write("\nUser-Agents by times hit:\n\n")
    show_top_uas(uas, TOP_N, dns, out_fd)

    show_top_rules(waf_rules, TOP_N, out_fd)
    show_top_matchelements(match_elements, TOP_N, out_fd)


def parse_logs(filename, N, dns, verbose):

    result = get_log_data(filename, verbose)
    uas, browsers, waf_rules, match_elements, waf_hits, waf_elements = process_results(result, dns)
    show_results(N, dns, len(result), uas, browsers, waf_rules, match_elements, waf_hits, waf_elements)


def fetch_logs(api_session, tenant, vs_name, fields, start_date, end_date, page_size,
               delay, top_N, outfile_name, log_all, use_dns):
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
    first_line = True
    fixed_options = "virtualservice={}&type=1&page_size={}".format(vs_name, page_size)
    fixed_options += "&udf=true&nf=true&orderby=report_timestamp"
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
            raise LogResponseException(num_fetched)
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
        out_fd = open("fetch_logs.txt", "w")
        show_results(top_N, use_dns, num_fetched, uas, browsers, waf_rules,
                     match_elements, waf_hits, waf_elements, out_fd)

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
    parser.add_argument("--dns", action="store_true", help='make reverse DNS lookup for IPs')
    parser.add_argument('-e', '--end',
                        help='End date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 60.0 (up to 60 seconds = 1 minute before now) or 1.5d',
                        default='0')
    parser.add_argument('-i', '--inputfile',
                        help='File containing log entries - CSV or JSON. If provided, no fetch from controller')
    parser.add_argument('-f', '--fields',
                        help='Log fields to fetch, e.g. user_agent,client_ip; default: none for all fields',
                        default=None)
    parser.add_argument('-l', '--logall', help='Log all JSON data received from controller into files',
                        action="store_true")
    parser.add_argument('-n', '--top_n', help='Top N occurrences to show', default=10, type=int)
    parser.add_argument('-o', '--outfile',
                        help='File to store resulting JSON array in. If not supplied, only summary is saved',
                        default=None)
    parser.add_argument('-p', '--password', help='password')
    parser.add_argument('-s', '--start',
                        help='Start date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 3600.0 (3600 seconds = 1h before now) or 1d (in the last day)',
                        default='3600')
    parser.add_argument('-t', '--tenant', help='tenant name', default=None)
    parser.add_argument('-u', '--username', help='user name', default='admin')
    parser.add_argument('-v', '--vs_name', help='VS Name')
    parser.add_argument("--verbose", action="store_true", help='print verbose messages during processing')
    parser.add_argument('-y', '--summary', help='only show summary, not individual log entries', type=bool,
                        default=False)

    args = parser.parse_args()

    # first of all, check whether we have an input file:
    if args.inputfile:
        parse_logs(args.inputfile, args.top_n, args.dns, args.verbose)
        exit(0)

    # otherwise, fetch logs from controller:
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

    if not args.vs_name:
        print("VS name is required if no log file is provided")
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
                             batch_size, delay, args.top_n, args.outfile, args.logall, args.dns)
        exit(0 if success else 1)
    except Exception as e:
        print(str(e))
        exit(1)


if __name__ == '__main__':
    main()
