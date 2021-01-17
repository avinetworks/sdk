#!/usr/bin/env python3

from os import path, urandom
import subprocess
from hashlib import sha256
import sys
import gzip
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


HELP_STR = '''analyze_logs.py: Analyze logs read from file or from controller.
Statistics for User-Agent strings and WAF events are computed and
shown or written to file.  The top N User-Agents are shown, broken
down by IP, as well as the top WAF rules hit and the corresponding WAF
match elements and their values.

    Two modes of operation are supported:
    1) Logs are read from file on disk (JSON or CSV format):
      $ analyze_logs.py -i logs.csv
    2) Logs are fetched from a controller and then analyzed:
      $ analyze_logs.py -c 4.7.19.76 -u admin -a 9c81d5159d549806cf8868fc1645ec6027e816e1 -v virtualservice

Sample output:

Total number of entries     : 4, waf hits: 4 (100.0%), waf elements: 4, elements per hit: 1.0
Different User-Agents       : 3, browsers: 3
Different WAF rules hit     : 3
Different WAF match elements: 3

Top 2 User-Agents by times hit:

2 <==> Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko
  2 <==> 23.26.110.2
1 <==> python-requests/2.22.0
  1 <==> 100.64.25.63

Top 2 WAF rules by times hit:

2 <==> 930120
1 <==> 941100

Top 2 Match Elements by times hit

2 <==> ARGS:ip
1 <==> ARGS:foo

Element name ARGS:ip
  2 <==> ping 127.0.0.1 & cat /etc/passwd

Element name ARGS:foo
  1 <==> <script>'''

NONCE = urandom(16)


def scramble(s: str):
    """ return a shortened hash from the string which will stay
        stable during the runtime of the script, but will change with
        every new invocation of the script.
    """
    # make sure we do not run into any extension problems
    # so encode it in a unique way by prepending the length
    h = sha256()
    h.update(str(len(s)).encode())
    h.update(b":")
    h.update(s.encode())
    h.update(NONCE)
    return h.hexdigest()[:16]


def load_csv_file(csv_file: str, jsn_file: str, verbose: bool):
    """Load AVI Application Logs from CSV file 'csv_file'. The Result is
    stored as an array in JSON format in a new file 'jsn_file', which will be
    overwritten if it already exists.
    The array is returned.
    """
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


def show_top_matchelements(match_elements: dict, N: int, out_fd=sys.stdout):
    """Writes information about the top 'N' WAF match elements, i.e., the
    ones most often flagged by WAF, in 'match_elements' to 'out_fd'.
    For each match elements, the top 'N' match values are also shown.
    """
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


def show_top_uas(uas: dict, N: int, obfuscate_ips: bool, dns: bool, out_fd=sys.stdout):
    """Writes information about the top 'N' most frequently seen
    User-Agent values in 'uas'. For each user agent, the top 'N' IP
    addresses are shown from which the request originated. If 'dns' is
    True, a reverse and, if successful, corresponding forward DNS
    look-up is made and the resulting information is shown.
    """

    top_uas = N if len(uas) > N else len(uas)
    out_fd.write("Top {} User-Agents by times hit:\n\n".format(top_uas))

    uas_by_count = list(sorted(uas.items(), key=lambda item: item[1]['total'], reverse=True))
    for value, counts in uas_by_count[:top_uas]:
        out_fd.write("{} <==> {}\n".format(counts['total'], value))
        top_ips = N+1 if len(counts) > N+1 else len(counts)
        ips_by_count = list(sorted(counts.items(), key=lambda item: item[1], reverse=True))
        for ip, count in ips_by_count[1:top_ips]:
            if dns and not obfuscate_ips:
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
                out_fd.write("  {} <==> {}\n".format(count, scramble(ip) if obfuscate_ips else ip))


def show_top_rules(waf_rules: dict, N: int, out_fd=sys.stdout):
    """Writes information about the top 'N' most frequently triggered
    WAF rules 'waf_rules'.
    """
    rules_by_count = list(sorted(waf_rules.items(), key=lambda item: item[1], reverse=True))
    top_n = N if len(waf_rules) > N else len(waf_rules)
    out_fd.write("\nTop {} WAF rules by times hit:\n\n".format(top_n))
    for value, count in rules_by_count[:top_n]:
        out_fd.write("{} <==> {}\n".format(count, value))


def get_filenames(filename: str):
    """From the given 'filename' tries to find a readable file by
    optionally appending '.csv' and/or '.json'
    """
    csv_file = ''
    if filename.endswith('.csv'):
        csv_file = filename
        jsn_file = '.'.join(filename.split('.')[:-1]) + '.json'
    elif filename.endswith('.json'):
        jsn_file = filename
    else:  # try appending csv or json
        candidate = filename + ".csv"
        if path.isfile(candidate):
            csv_file = candidate
            jsn_file = filename + ".json"
        else:
            candidate = filename + ".json"
            if path.isfile(candidate):
                jsn_file = candidate
    return csv_file, jsn_file


def get_log_data(filename: str, verbose: bool):
    """Reads data from CVS or JSON file, returns it as python array of dicts
    """
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
    """Default constructor for a dict of ints
    """
    return collections.defaultdict(int)


def process_applog_entry(applog: dict, uas: collections.defaultdict(DictOfInts),
                         browsers: collections.defaultdict(DictOfInts),
                         waf_rules: collections.defaultdict(DictOfInts), match_elements: dict):
    """Processes a single Appliction Log entry 'applog' and updates the
    User-Agent information in 'uas', the browser information in
    'browsers' as well as the WAF rules statistics in 'waf_rules' and
    'match_elements' returns a tuple of counters: waf_hits (0 or 1)
    and waf_elements, which contains the number of WAF elements that
    triggered WAF.
    """
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


def process_results(result: list, dns: bool):
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


def show_results(top_n: int, obfuscate_ips: bool, dns: bool,
                 num_entries: int, uas: collections.defaultdict(DictOfInts),
                 browsers: collections.defaultdict(DictOfInts),
                 waf_rules: collections.defaultdict(DictOfInts),
                 match_elements: dict,
                 waf_hits: int, waf_elements: int, out_fd=sys.stdout):

    elements_per_hit = 0
    if waf_hits > 0:
        elements_per_hit = round(waf_elements/waf_hits, 1)
    out_fd.write("Total number of entries     : {}, waf hits: {} ({}%), waf elements: {}, elements per hit: {}\n"
                 .format(num_entries, waf_hits, round(100.0*waf_hits/num_entries, 1), waf_elements, elements_per_hit))
    out_fd.write("Different User-Agents       : {}, browsers: {}\n".format(len(uas), len(browsers)))
    out_fd.write("Different WAF rules hit     : {}\n".format(len(waf_rules)))
    out_fd.write("Different WAF match elements: {}\n".format(len(match_elements)))
    out_fd.write("\n")
    show_top_uas(uas, top_n, obfuscate_ips, dns, out_fd)

    show_top_rules(waf_rules, top_n, out_fd)
    show_top_matchelements(match_elements, top_n, out_fd)


def parse_logs(filename: str, N: int, obfuscate_ips: bool, dns: bool, verbose: bool):

    result = get_log_data(filename, verbose)
    uas, browsers, waf_rules, match_elements, waf_hits, waf_elements = process_results(result, dns)
    show_results(N, obfuscate_ips, dns, len(result), uas, browsers, waf_rules, match_elements, waf_hits, waf_elements)


def analyze_logs(api_session: ApiSession, tenant: str, vs_name: str, fields: str,
                 start_date: datetime.datetime, end_date: datetime.datetime, page_size: int,
                 delay: float, top_n: int, outfile_name: str,
                 log_all: bool, obfuscate_ips: bool, use_dns: bool, verbose: bool):

    uas = collections.defaultdict(DictOfInts)
    browsers = collections.defaultdict(int)

    waf_rules = collections.defaultdict(int)
    # { "ARGS:foo" => { "count": 137, "values" => { "val1:" 3, "val2": 66 } } }
    match_elements = {}

    waf_hits = 0
    waf_elements = 0

    logall_filecount = 0

    if outfile_name:
        outfile = gzip.open(outfile_name, "wt")
        outfile.write("[\n")
    path = "/analytics/logs/"
    num_fetched = 0
    first_line = True
    fixed_options = "virtualservice={}&type=1&page_size={}".format(vs_name, page_size)
    fixed_options += "&udf=true&nf=true&orderby=report_timestamp"
    if fields:
        fixed_options += "&cols={}".format(fields)
    minutes_tofetch = 8
    max_minutes = 64
    min_minutes = 1
    orig_start_date = start_date
    while start_date < end_date:
        upper_end = start_date + datetime.timedelta(minutes=minutes_tofetch)
        if upper_end > end_date:
            upper_end = end_date
        # make request for logs [start_date, up_to]:
        time_options = "&start={}&end={}".format(
            # The API claims to expect ISO 8601 format, but rejects the request if we use it:
            # start_date.isoformat(), end_date.isoformat()
            # It seems to be unable to handle time zones. The following works:
            f"{start_date:%Y-%m-%dT%H:%M:%S.%fZ}", f"{upper_end:%Y-%m-%dT%H:%M:%S.%fZ}"
        )
        query_options = fixed_options + time_options
        if verbose:
            print("Query String: '{}'".format(query_options))

        result = api_session.get(path, tenant=tenant, params=query_options)
        if log_all:
            logfile_name = "/tmp/analyze_logs_logall-{}.gz".format(logall_filecount)
            logall_filecount += 1
            logfile = gzip.open(logfile_name, "wt")
            logfile.write(result.text)
            logfile.close()

        j = result.json()
        num_to_fetch = j['count']
        if num_to_fetch == 0:
            start_date = upper_end
            if minutes_tofetch < max_minutes:
                minutes_tofetch *= 2
                if verbose:
                    print("Increased time window to {} minutes".format(minutes_tofetch))

            continue
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
                if obfuscate_ips and applog.get('client_ip', False):
                    applog['client_ip'] = scramble(applog['client_ip'])
                outfile.write(json.dumps(applog, indent=4))

        if verbose:
            print(" First time stamp:{},\n last time stamp: {}".format(
                j['results'][0]['report_timestamp'],
                j['results'][-1]['report_timestamp']))

        num_fetched += len(j['results'])
        remaining_time = end_date - upper_end
        r_minutes = round(remaining_time.days * 24 * 60 + remaining_time.seconds / 60)
        r_percent = round(100 * remaining_time / (end_date - orig_start_date))
        # Print one line of info to indicate progress, even if verbose is off:
        print("Fetched {} AppLog entries, minutes remaining: {} ({}%)".format(num_fetched, r_minutes, r_percent))

        if num_to_fetch > len(j['results']) and minutes_tofetch > min_minutes:
            minutes_tofetch /= 2
            if verbose:
                print("Decreased time window to {} minutes".format(minutes_tofetch))

        # if there's a 'next' hint in the response, use it
        # note that due to a current limitation, for page_size = 10k, there
        # is never a 'next' link.
        while 'next' in j:
            # fetch page after page, update num_fetched, save result
            next = j['next']
            qs = next.split('?')[1]
            if verbose:
                print("New query string from 'next': {}".format(qs))
            if delay > 0:
                sleep(delay)
            result = api_session.get(path, tenant=tenant, params=qs)
            if log_all:
                logfile_name = "/tmp/analyze_logs_logall-{}.gz".format(logall_filecount)
                logall_filecount += 1
                logfile = gzip.open(logfile_name, "wt")
                logfile.write(result.text)
                logfile.close()
            j = result.json()
            for applog in j['results']:
                hits, elements = process_applog_entry(applog, uas, browsers, waf_rules, match_elements)
                waf_hits += hits
                waf_elements += elements

                if outfile_name:
                    outfile.write(",\n")
                    if obfuscate_ips and applog.get('client_ip', False):
                        applog['client_ip'] = scramble(applog['client_ip'])
                    outfile.write(json.dumps(applog, indent=4))

            num_fetched += len(j['results'])
            if verbose:
                print("Newly fetched: {}, total: {}".format(len(j['results']), num_fetched))

        if verbose:
            print("No 'next' link, to fetch: {}, fetched: {}".format(num_to_fetch, num_fetched))

        # To avoid fetching the same us twice, we increment by 1 us (and risk
        # missing logs if there is more than 1 per us)
        start_date = j['results'][-1]['report_timestamp']
        start_date = datetime.datetime.fromisoformat(start_date) + datetime.timedelta(microseconds=1)
        if verbose:
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
        out_fd = gzip.open("analyze_logs.txt.gz", "wt")
        show_results(top_n, obfuscate_ips, use_dns, num_fetched, uas, browsers,
                     waf_rules, match_elements, waf_hits, waf_elements, out_fd)

    return num_fetched >= num_to_fetch


def compute_date(value: str):
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
    parser.add_argument('-c', '--controller', help='controller ip or host name', default='127.0.0.1')
    parser.add_argument('-i', '--inputfile',
                        help='File containing log entries - CSV or JSON. If provided controller is not queried')

    parser.add_argument('-u', '--username', help='User name', default='admin')
    parser.add_argument('-a', '--authtoken', help='Authentication token')
    parser.add_argument('-p', '--password', help='Password. '
                        'Deprecated, please use authentication token instead if possible.')
    parser.add_argument('-t', '--tenant', help='tenant name', default=None)

    parser.add_argument('-s', '--start',
                        help='Start date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 3600.0 (3600 seconds = 1h before now) or 1d (in the last day)',
                        default='3600')
    parser.add_argument('-e', '--end',
                        help='End date for fetching logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
                             'relative before now: 60.0 (up to 60 seconds = 1 minute before now) or 1.5d',
                        default='0')
    parser.add_argument('-f', '--fields',
                        help='Log fields to fetch, e.g. user_agent,client_ip; default: none for all fields',
                        default=None)

    parser.add_argument('-v', '--vs_name', help='Virtual Service for which AppLogs are fetched')

    parser.add_argument('-b', '--batchsize', help='Batch size for fetching logs', default=10000, type=int)
    parser.add_argument('-d', '--delay', help='Delay in seconds between requests, eg 0.1', default=1, type=float)
    parser.add_argument("--dns", action="store_true", help='Make reverse DNS lookup for IPs')

    parser.add_argument('-l', '--logall', help='Log all JSON data received from controller into files under /tmp',
                        action="store_true")
    parser.add_argument('--no_ip_obfuscation', help='Do not obfuscate client IPs in all output - not recommended.',
                        action='store_true')
    parser.add_argument('-n', '--top_n', help='Top N occurrences to show', default=10, type=int)

    parser.add_argument('-o', '--outfile',
                        help='File to store resulting JSON array in. If not supplied, only summary is saved',
                        default=None)
    # parser.add_argument('-z', '--compress', help='Compress all output', action="store_true")

    parser.add_argument("--verbose", action="store_true", help='Print verbose messages during processing')

    args = parser.parse_args()

    # first of all, check whether we have an input file:
    if args.inputfile:
        parse_logs(args.inputfile, args.top_n, not args.no_ip_obfuscation, args.dns, args.verbose)
        exit(0)

    # otherwise, fetch logs from controller:
    if not args.vs_name:
        print("VS name is required if no log file is provided")
        exit(1)

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
        success = analyze_logs(api_session, args.tenant, args.vs_name, args.fields,
                               start_date, end_date,
                               batch_size, delay, args.top_n, args.outfile,
                               args.logall, not args.no_ip_obfuscation, args.dns, args.verbose)
        exit(0 if success else 1)
    except Exception as e:
        print(str(e))
        exit(1)


if __name__ == '__main__':
    main()
