#!/usr/bin/env python3

import argparse
import json
import datetime

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils

from requests.packages import urllib3

from metrics_list import metrics

urllib3.disable_warnings()


HELP_STR = '''

waf_sizer: Tool to estimate number of CPUs needed for the traffic
pattern according to the relevant metrics fetched from the provided
controller IP / host name.
    Examples:
        waf_sizer.py -c controller.foo.com -t XXXX
    
'''
verbose = False


def post_process_metric(filename,data,total_num_reqs):
    num_samples = len(total_num_reqs)
    if num_samples != len(data):
        print("Warning: Length mismatch for file {0}: {1} != {2}".\
              format(filename,num_samples,len(total_num_headers)))
    print("Opening new file: {0}".format(filename))
    (mi,ma,av,mi_i,ma_i) = (0,0.0,0.0,0,0)
    fh = open(filename, 'w')
    num_valid_samples = 0
    for i in range(num_samples):
        if total_num_reqs[i] > 0:
            num_valid_samples += 1
            sample = data[i] / total_num_reqs[i]
            if sample > ma:
                ma = sample
                ma_i = i

            if mi == 0 or sample < mi:
                mi = sample
                mi_i = i

            av += sample
            fh.write( "{0}\n".format(sample))

    if num_valid_samples > 0:
        av /= num_valid_samples
        print(" -- max was {0} (at sample {1}), min was {2} (at sample {3}), avg was {4}.\n".\
              format(ma,ma_i,mi,mi_i,av))
        return [ma, av, mi]
    else:
        return [-1,-1,-1]

def add_data_to_combined(name, combined,data):
    if name not in combined:
        combined[name] = {'data': data, 'num_vs': 1}
    else:
        old = combined[name]['data']
        L = len(data)
        if L != len(old):
            print("Warning: Length mis-match: new len = {0} -- old len = {1}".format(L,len(old)))
        L = min(L,len(old))
        for i in range(L):
            old[i] += data[i]
        combined[name]['num_vs'] += 1


def process_vsdata(data, combined):
    series = data['series']
    for vs, metric_data in series.items():
        vs_uuid = '_'.join(vs.split('-')[1:])
        for stats in metric_data:
            metric_name = stats['header']['name']
            print("Processing metric '{}'".format(metric_name))
            if 'data' not in stats:
                print("No Data!")
                print(json.dumps(stats))
                continue
            f = "{0}-{1}".format(vs_uuid, metric_name)
            f_out = open(f, 'w')
            data = stats['data']
            curr_series = []
            for sample in data:
                value = sample['value']
                f_out.write("{}\n".format(value))
                curr_series.append(value)
            f_out.close()
            add_data_to_combined(metric_name, combined, curr_series)
            if verbose:
                print("For {0} max was {1}, min was {2}, avg was {3}".\
                      format(f,max(curr_series),min(curr_series),sum(curr_series)/len(curr_series)))

def fetch_VSs(api_session, tenant, step, limit):
    #print(json.dumps(metrics))
    api_utils = ApiUtils(api_session)
    path = "/virtualservice/"
    result = api_session.get(path, tenant=tenant)
    j = result.json()
    vs_info = j['results']
    vs_uuids = [v['uuid'] for v in vs_info]
    mq = {
        'metric_id': metrics,
        'tenant': tenant,
        'step': step, # 5 minutes
        'limit': limit, # total of one week's worth of data
        'entity_uuid': '',
        'pad_missing_data': False,
        'include_name': True,
        'include_ref': True
    }
    combined = {} # { "metric_name": { "data": [1,0,3], "num_vs": 40}, {...},...}
    for vs in vs_info:
        if verbose:
            print("Fetching metrics for VS '{}' ({})".format(vs['name'], vs['uuid']))
        mq['entity_uuid'] = vs['uuid']
        rsp = api_utils.get_metrics_collection(tenant=tenant,
                                               metric_requests=[mq])
        #if verbose:
            #print(json.dumps(rsp, indent=2))
        process_vsdata(rsp, combined)
# now write out combined data:
    for metric_name, info in combined.items():
        data = info['data']
        filename = "combined-{0}".format(metric_name)
        if 'pct' in metric_name:
            continue
        print("Creating file for combined data: {0}".format(filename))
        with open(filename, 'w') as fh:
            for item in data:
                fh.write("{0}\n".format(item))
        (mi,ma,av) = (min(data),max(data),sum(data)/len(data))
        print(" -- max was {0}, min was {1}, avg was {2}.\n".format(ma,mi,av))

## post process
    print("Post process\n")


    total_num_reqs = combined['l7_client.sum_total_responses']['data']

    to_normalize = [
        {"filename": 'combined-overall_hdrs_count_per_request',
         "metric":   'l7_client.sum_http_headers_count'},

        {"filename": 'combined-overall_args_count_per_request',
         "metric":   'l7_client.sum_http_params_count'},

        {"filename": 'combined-overall_pct_get',
         "metric":   'l7_client.sum_get_reqs'},

        {"filename": 'combined-overall_pct_post',
         "metric":   'l7_client.sum_post_reqs'},

        {"filename": 'combined-overall_pct_waf_disabled',
         "metric":   'l7_client.sum_waf_disabled'},
    ]

    for n in to_normalize:
        values = post_process_metric(n['filename'], combined[n['metric']]['data'], total_num_reqs)
        combined[n['filename']] = values
        
    return combined


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


def complexity_from_metric(combined_data, metric):
    name = metric['metric_name']
    thresh = metric['thresholds']
    res = metric['result']

    if not name in combined_data:
        print('Missing metric in combined data: {}'.format(name))
        return
    for type in range(3): #  0 -> max, 1 -> avg 2 -> min
        number = combined_data[name][type]
        ascending = thresh[1] > thresh[0]
        print("Checking metrics value for {}: {} against thresholds {}".format(name,number, thresh))
        for i,val in enumerate(thresh):
            if not ascending and number > val:
                break
            if ascending and number < val:
                break
        
        res[type] = i


def determine_complexity(combined_data):
    metrics_info = [
        {'metric_name': 'combined-overall_pct_get', 'thresholds': [.95, .90, .85], 'result': [0,0,0]},  # 'get_post_ratio':
        {'metric_name': 'combined-overall_hdrs_count_per_request', 'thresholds': [5, 7, 10], 'result': [0,0,0]},  # 'number_headers'
        {'metric_name': 'combined-overall_args_count_per_request', 'thresholds': [3,5,7], 'result': [0,0,0]},   # 'number_params'
        {'metric_name': 'combined-overall_pct_waf_disabled', 'thresholds': [.90, .70, .50], 'result': [0,0,0]},  # 'percent_bypass'
    ]
    complexity = [0, 0, 0] # default to 'LOW'
    for metric in metrics_info:
        complexity_from_metric(combined_data, metric)

    for metric in metrics_info:
        print("{} has complexity {}".format(metric['metric_name'], metric['result']))

    complexity = [sum(p) for p in zip(
        metrics_info[0]['result'], metrics_info[1]['result'], metrics_info[2]['result']
    )]
    print("Cumulative complexity: {}".format(complexity))
    for i in range(len(complexity)):
        complexity[i] = int(complexity[i]/ 3)
    return complexity


if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-s', '--step', help='Granularity of metrics, i.e. time between samples in seconds',
                        type=int, default=300)
    parser.add_argument('-d', '--days', help='Number of days (before now) to analyze',
                        type=int, default=7)
    parser.add_argument('-t', '--tenant', help='tenant name', default=None)
    parser.add_argument('-v', '--vs_name', help='VS Name to restrict to one VS, default is all')
    # parser.add_argument('-s', '--start',
    #                     help='Start date for fecthing logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
    #                          'relative before now: 3600.0 (3600 seconds = 1h before now) or 1d (in the last day)',
    #                     default='3600')
    # parser.add_argument('-e', '--end',
    #                     help='End date for fecthing logs. Absolute dates: 2020-12-06, 2020-12-06T09:00:01.137Z or '
    #                          'relative before now: 60.0 (up to 60 seconds = 1 minute before now) or 1.5d',
    #                     default='0')
    parser.add_argument('-c', '--controller', help='controller ip', default='127.0.0.1')
    parser.add_argument('-u', '--username', help='user name', default='admin')
    parser.add_argument('-p', '--password', help='password')
    parser.add_argument('-a', '--authtoken', help='Authentication token')
    parser.add_argument('-o', '--outfile', help='File to store resulting JSON array in', default='fetch_logs.json')
    parser.add_argument('-r', '--run_tests', help='Run internal test suite', action="store_true")
    parser.add_argument("--verbose", action="store_true")
        
    args = parser.parse_args()

    verbose = args.verbose

    if args.run_tests:
        exit(1 if run_tests() -1 else 0)
    
    #start_date = compute_date(args.start)
    #end_date = compute_date(args.end)

    #if start_date >= end_date:
    #    print("Start date must be before end date: {} vs {}".format(start_date, end_date))
    #    exit(1)

    if args.authtoken:
        print("Using auth token")
        api_session = ApiSession(controller_ip=args.controller, username=args.username,
                                 password=None, token=args.authtoken, tenant=args.tenant)
    elif args.password:
        print("Using password")
        api_session = ApiSession(controller_ip=args.controller, username=args.username,
                                 password=args.password, tenant=args.tenant)
    else:
        print("Password or authentication token must be supplied")
        exit(1)
    step = args.step
    seconds_per_day = 86400
    limit = args.days * seconds_per_day / step
    combined = fetch_VSs(api_session, args.tenant, step, limit)
    complexity = determine_complexity(combined)
    print("Normalised complexity: {}".format(complexity))
    description = ['LOW', 'MEDIUM', 'HIGH']
    print("Based on the metrics, this deployment has worst case complexity '{}', average complexity '{}' and best case "
          "complexity '{}'".format(description[complexity[0]], description[complexity[1]], description[complexity[2]]))
    cases = ['Max metrics', 'Avg metrics', 'Min metrics']
    rps_per_core_00_disabled = [765, 532, 401]
    rps_per_core_80_disabled = [1611, 1095, 716]
    pct_disabled_observed = combined['combined-overall_pct_waf_disabled']####  [type]

    rps = combined['l7_client.avg_complete_responses']['data']
    need = [max(rps), sum(rps)/len(rps)]
    print("Max RPS: {}, Avg RPS: {}".format(need[0], need[1]))
    # fake_percent_disabled = [0, 50, 90]
    for i in range(len(complexity)):
        can_do = rps_per_core_80_disabled[complexity[i]]
        can_do_00 = rps_per_core_00_disabled[complexity[i]]
        observed_disabled = pct_disabled_observed[complexity[i]]  ### fake_percent_disabled[i] ###
        print("Can do for 80 percent bypass: {}, 0 percent: {}, observed disabled: {}".format(can_do, can_do_00, observed_disabled))
        if observed_disabled < 80:
            diff = can_do -  can_do_00
            factor = observed_disabled /  80
            can_do = can_do_00 + factor*diff
        print("Using {} rps per core".format(can_do))
        n_cores = [int(need[0]/can_do)+1,int(need[1]/can_do)+1]
        n_ses = [int(n_cores[0]/16)+1, int(n_cores[1]/16)+1]
        print("For complexity {} found in {} case, Need {} cores"
              #" ({} SEs of 16 cores)"
              " for Max RPS, {} cores"
              #" ({} SEs of 16 cores)"
              " for Avg RPS".format(description[complexity[i]],cases[i],n_cores[0]
                                    #,n_ses[0]
                                    ,n_cores[1]
                                    #,n_ses[1]
              ))
            
    
def run_tests():
    # 1. test 
