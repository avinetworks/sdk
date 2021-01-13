#!/usr/bin/env python3

import os.path
import subprocess
import sys
import csv
import json
import collections
import ast
import argparse


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
                              "python AST:\n{}\n Error: ".format(f, line, row[f], e))
                        exit(1)
                    row[f] = info
            result.append(row)

        with open(jsn_file, "w") as jsnfile:
            jsnfile.write(json.dumps(result, sort_keys=True, indent=4))
    return result


def show_top_matchelements(match_elements, N):
    matches_by_count = list(sorted(match_elements.items(), key=lambda item: item[1]['count'], reverse=True))
    TOP_N = N if len(matches_by_count) > N else len(matches_by_count)
    print("\nTop {} Match Elements by times hit\n".format(TOP_N))
    for value, count in matches_by_count[:TOP_N]:
        print("{} <==> {}".format(count['count'], value))
    for top_hit in matches_by_count[:TOP_N]:
        element_name = top_hit[0]
        match_info = match_elements[element_name]
        values = match_info['values']
        values_by_count = list(sorted(
            values.items(), key=lambda item: item[1], reverse=True))
        print("\nElement name {}".format(element_name))
        TOP_V = N if len(values_by_count) > N else len(values_by_count)
        for top_value in values_by_count[:TOP_V]:
            print("  {} <==> {}".format(top_value[1], top_value[0]))
            value_info = values[top_value[0]]


def show_top_uas(uas, N, dns):
    top_uas = N if len(uas) > N else len(uas)
    uas_by_count = list(sorted(uas.items(), key=lambda item: item[1]['total'], reverse=True))
    for value, counts in uas_by_count[:top_uas]:
        print("{} <==> {}".format(counts['total'], value))
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
                print("  {} <==> {} ({}: {} - {})".format(count, ip, dns_msg, dns, r_dns))
            else:
                print("  {} <==> {}".format(count, ip))


def show_top_rules(waf_rules, N):
    rules_by_count = list(sorted(waf_rules.items(), key=lambda item: item[1], reverse=True))
    TOP_N = N if len(waf_rules) > N else len(waf_rules)
    print("\nTop {} WAF rules by times hit:\n".format(TOP_N))
    for value, count in rules_by_count[:TOP_N]:
        print("{} <==> {}".format(count, value))


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


def get_log_data(filename):
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
    (waf_hits, waf_elements) = (0,0)
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


def show_results(TOP_N, dns, num_entries, uas, browsers, waf_rules, match_elements, waf_hits, waf_elements):
    elements_per_hit = 0
    if waf_hits > 0:
        elements_per_hit = round(waf_elements/waf_hits, 1)
    print("Total number of entries               : {}, waf hits: {} ({}%), waf elements: {}, elements per hit: {}"
          .format(num_entries, waf_hits, round(100.0*waf_hits/num_entries, 1), waf_elements, elements_per_hit))
    print("Number of different User-Agents       : {}, browsers: {}".format(len(uas), len(browsers)))
    print("Number of different WAF rules hit     : {}".format(len(waf_rules)))
    print("Number of different WAF match elements: {}".format(len(match_elements)))

    print("\nUser-Agents by times hit:\n")
    show_top_uas(uas, TOP_N, dns)

    show_top_rules(waf_rules, TOP_N)
    show_top_matchelements(match_elements, TOP_N)


def parse_logs(filename, N, dns):

    result = get_log_data(filename)
    uas, browsers, waf_rules, match_elements, waf_hits, waf_elements = process_results(result, dns)
    show_results(N, dns, len(result), uas, browsers, waf_rules, match_elements, waf_hits, waf_elements)


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("file", help='file with avi logs')
    parser.add_argument("-v", action="store_true", help='print verbose messages during processing')
    parser.add_argument("--dns", action="store_true", help='make reverse DNS lookup for IPs')
    parser.add_argument("-n", '--top_n', type=int, default=5, help='How many "top N" items to show')
    args = parser.parse_args()
    verbose = args.v

    parse_logs(args.file, args.top_n, args.dns)
