#!/usr/bin/env python3

import argparse
import json
import datetime
import logging
import gzip

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
# from metrics_list import metrics

from requests.packages import urllib3
urllib3.disable_warnings()


class ApiResponseWriter:

    def __init__(self, outfile: str):
        if outfile:
            self.out_fd = gzip.open(outfile, "wt")
            logging.info("Storing raw API responses in {}".format(outfile))
        else:
            self.out_fd = None

    def save_api_response(self, data: str):
        if self.out_fd:
            self.out_fd.write(data)

    def close(self):
        if self.out_fd:
            self.out_fd.close()


HELP_STR = '''

waf_sizer: Tool to estimate number of CPUs needed for the traffic
pattern according to the relevant metrics fetched from the provided
controller IP / host name.
    Examples:
        waf_sizer.py -c controller.foo.com -t XXXX

'''


def post_process_metric(filename: str, data: list, total_num_reqs: list) -> list:

    num_samples = len(total_num_reqs)
    if num_samples != len(data):
        logging.warn("Length mismatch for file {0}: {1} != {2}".
                     format(filename, num_samples, len(data)))
    logging.info("Opening new file: {0}".format(filename))
    (mi, ma, av, mi_i, ma_i) = (0, 0.0, 0.0, 0, 0)
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
            fh.write("{0}\n".format(sample))

    if num_valid_samples > 0:
        av /= num_valid_samples
        logging.info(" -- max was {0} (at sample {1}), min was {2} (at sample {3}), avg was {4}.\n".
                     format(ma, ma_i, mi, mi_i, av))
        if 'overall_pct_get' in filename:  # here minimum is 'worst case'
            return [mi, av, ma]
        else:
            return [ma, av, mi]
    else:
        return [-1, -1, -1]


def add_data_to_combined(name: str, combined: dict, data: dict):
    if name not in combined:
        combined[name] = {'data': data, 'num_vs': 1}
    else:
        old = combined[name]['data']
        L = len(data)
        if L != len(old):
            logging.warn("Length mis-match: new len = {0} -- old len = {1}".format(L, len(old)))
        L = min(L, len(old))
        for i in range(L):
            old[i] += data[i]
        combined[name]['num_vs'] += 1


def process_vsdata(vs_name: str, data: dict, combined: dict):
    """
    Adds the metrics data from one VS to the combined metrics.
    Argument 'data' is expected to contain {}
    """
    series = data.get('series', {})
    if not series:
        logging.warning("no data for {}".format(vs_name))
    for vs, metric_data in series.items():
        vs_uuid = '_'.join(vs.split('-')[1:])
        for stats in metric_data:
            metric_name = stats['header']['name']
            logging.info("Processing metric '{}' for vs '{}'".format(metric_name, vs_name))
            if 'data' not in stats:
                logging.error("No Data!")
                logging.error(json.dumps(stats))
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
            logging.debug("For {0} max was {1}, min was {2}, avg was {3}".
                          format(f, max(curr_series), min(curr_series), sum(curr_series)/len(curr_series)))


def fetch_VSs(api_session: ApiSession, tenant: str, vs_name: str, step: int, limit: int, apilogfile: str) -> dict:

    metrics = (
        "l7_client.sum_total_responses,"
        "l7_client.sum_waf_disabled,"
        "l7_client.avg_waf_disabled,"
        "l7_client.pct_waf_disabled,"
        "l7_client.sum_http_headers_count,"
        "l7_client.avg_http_headers_count,"
        "l7_client.sum_http_headers_bytes,"
        "l7_client.avg_http_headers_bytes,"
        "l7_client.pct_get_reqs,"
        "l7_client.pct_post_reqs,"
        "l7_client.sum_http_params_count,"
        "l7_client.avg_http_params_count,"
        "l7_client.sum_uri_length,"
        "l7_client.avg_uri_length,"
        "l7_client.sum_post_bytes,"
        "l7_client.avg_post_bytes,"
        "l4_client.avg_bandwidth,"
        "l4_client.avg_complete_conns,"
        "l7_client.avg_complete_responses,"
        "l7_client.sum_get_reqs,"
        "l7_client.sum_post_reqs"
    )

    file_writer = ApiResponseWriter(apilogfile)

    api_utils = ApiUtils(api_session)
    path = "/virtualservice/"
    result = api_session.get(path, tenant=tenant)
    j = result.json()
    file_writer.save_api_response(json.dumps(j, indent=2))
    vs_info = j.get('results', [])
    vs_uuids = [v['uuid'] for v in vs_info if vs_name is None or v['name'] == vs_name]
    mq = {
        'metric_id': metrics,
        'step': step,
        'limit': limit,  # how many samples to fetch
        'entity_uuid': '',
        'pad_missing_data': False,
        'include_name': True,
        'include_ref': True
    }
    combined = {}  # { "metric_name": { "data": [1,0,3], "num_vs": 40}, "name2" : {...},...}

    for vs in vs_info:
        if vs_name is not None and not vs['name'] == vs_name:
            continue
        logging.debug("Fetching metrics for VS '{}' ({})".format(vs['name'], vs['uuid']))
        mq['entity_uuid'] = vs['uuid']
        rsp = api_utils.get_metrics_collection(tenant=tenant,
                                               metric_requests=[mq])
        file_writer.save_api_response(json.dumps(rsp, indent=2))

        process_vsdata(vs['name'], rsp, combined)

    file_writer.close()
    # now write out combined data:
    for metric_name, info in combined.items():
        data = info['data']
        filename = "combined-{0}".format(metric_name)
        if 'pct' in metric_name:
            continue
        logging.info("Creating file for combined data: {0}".format(filename))
        with open(filename, 'w') as fh:
            for item in data:
                fh.write("{0}\n".format(item))
        (mi, ma, av) = (min(data), max(data), sum(data)/len(data))
        logging.info(" -- max was {0}, min was {1}, avg was {2}.\n".format(ma, mi, av))

    # post process
    logging.info("Post process\n")

    total_num_reqs = combined.get('l7_client.sum_total_responses', {}).get('data', [])

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
        values = post_process_metric(n['filename'], combined.get(n['metric'], {}).get('data', []), total_num_reqs)
        combined[n['filename']] = values

    return combined


def complexity_from_metric(combined_data: str, metric: dict):
    name = metric['metric_name']
    thresh = metric['thresholds']
    result = metric['result']

    if name not in combined_data:
        logging.warn('Missing metric in combined data: {}'.format(name))
        return
    for type in range(3):  # 0 -> max, 1 -> avg 2 -> min
        number = combined_data[name][type]
        ascending = thresh[1] > thresh[0]
        logging.info("Checking metrics value for {}: {} against thresholds {}".format(name, number, thresh))
        for i, val in enumerate(thresh):
            if not ascending and number > val:
                break
            if ascending and number < val:
                break

        result[type] = i


def determine_complexity(combined_data: dict) -> list:
    metrics_info = [
        # 'get_post_ratio'
        {'metric_name': 'combined-overall_pct_get', 'thresholds': [.95, .90, .85], 'result': [0, 0, 0]},
        # 'number_headers'
        {'metric_name': 'combined-overall_hdrs_count_per_request', 'thresholds': [5, 7, 10], 'result': [0, 0, 0]},
        # 'number_params'
        {'metric_name': 'combined-overall_args_count_per_request', 'thresholds': [3, 5, 7], 'result': [0, 0, 0]},
        # 'percent_bypass'
        {'metric_name': 'combined-overall_pct_waf_disabled', 'thresholds': [.90, .70, .50], 'result': [0, 0, 0]},
    ]
    complexity = [0, 0, 0]  # default to 'LOW'
    for metric in metrics_info:
        complexity_from_metric(combined_data, metric)

    for metric in metrics_info:
        logging.info("{} has complexity {}".format(metric['metric_name'], metric['result']))

    complexity = [sum(p) for p in zip(
        metrics_info[0]['result'], metrics_info[1]['result'], metrics_info[2]['result']
    )]
    logging.info("Cumulative complexity: {}".format(complexity))
    for i in range(len(complexity)):
        complexity[i] = int(complexity[i] / 3)
    return complexity


def main():
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-s', '--step', help='Granularity of metrics, i.e. time between samples in seconds, '
                        'default 300',
                        type=int, default=300)
    parser.add_argument('-d', '--days', help='Number of days (before now) to analyze, default = 7',
                        type=int, default=7)
    parser.add_argument('-t', '--tenant', help='Tenant name', default=None)
    parser.add_argument('-v', '--vs_name', help='VS Name to restrict to one VS, default is all')
    parser.add_argument('-c', '--controller', help='Controller ip', default='127.0.0.1')
    parser.add_argument('-u', '--username', help='User name', default='admin')
    parser.add_argument('-p', '--password', help='Password - deprecated, use authentication token instead')
    parser.add_argument('-a', '--authtoken', help='Authentication token')
    parser.add_argument('-l', '--logapiresponses', type=str, default=None,
                        help='Log all raw JSON data received from controller into the specified file.'
                        ' An existing file will be overwritten. By default these responses are not saved to disk.')

    parser.add_argument('-r', '--run_tests', help='Run internal test suite', action="store_true")
    parser.add_argument("--verbose", action="store_true", help='Print verbose messages during processing')

    args = parser.parse_args()
    logging.basicConfig(level=logging.DEBUG if args.verbose else logging.INFO)

    if args.run_tests:
        exit(1 if run_tests() == -1 else 0)

    try:
        if args.authtoken:
            logging.debug("Using auth token")
            api_session = ApiSession(controller_ip=args.controller, username=args.username,
                                     password=None, token=args.authtoken, tenant=args.tenant)
        elif args.password:
            logging.debug("Using password")
            api_session = ApiSession(controller_ip=args.controller, username=args.username,
                                     password=args.password, tenant=args.tenant)
        else:
            logging.error("Password or authentication token must be supplied")
            exit(1)
    except Exception as e:
        logging.error(str(e))
        exit(1)

    step = args.step
    seconds_per_day = 86400
    limit = args.days * seconds_per_day / step
    logging.info("Fetching {} samples".format(limit))

    combined = fetch_VSs(api_session, args.tenant, args.vs_name, step, limit, args.logapiresponses)

    # 'complexity' is a vector of 3 elements. Each element encodes the
    # complexity according to one of the metrics - pct_get,
    # num_headers, num_args. A value of 0 means 'low', 1 'medium' and
    # 2 'high'
    complexity = determine_complexity(combined)
    logging.info("Normalised complexity: {}".format(complexity))

    description = ['LOW', 'MEDIUM', 'HIGH']
    logging.info("Based on the metrics collected, this deployment has worst case complexity '{}', average "
                 "complexity '{}' and best case complexity '{}'".format(
                     description[complexity[0]], description[complexity[1]], description[complexity[2]]))

    cases = ['Max metrics', 'Avg metrics', 'Min metrics']
    rps_per_core_00_disabled = [765, 532, 401]
    rps_per_core_80_disabled = [1611, 1095, 716]
    pct_disabled_observed = combined['combined-overall_pct_waf_disabled']  # [type]

    rps = combined.get('l7_client.avg_complete_responses', {}).get('data', [])
    need = [max(rps), sum(rps)/len(rps)] if rps else [0, 0]
    logging.info("Max RPS: {}, Avg RPS: {}".format(need[0], need[1]))

    # fake_percent_disabled = [0, 50, 90]
    for i in range(len(complexity)):
        can_do = rps_per_core_80_disabled[complexity[i]]
        can_do_00 = rps_per_core_00_disabled[complexity[i]]
        observed_disabled = pct_disabled_observed[complexity[i]]  # fake_percent_disabled[i] ###
        logging.info("Can do for 80 percent bypass: {}, 0 percent: {}, observed disabled: {}".
                     format(can_do, can_do_00, observed_disabled))
        if observed_disabled < 80:
            diff = can_do - can_do_00
            factor = observed_disabled / 80
            can_do = can_do_00 + factor*diff
        logging.info("Using {} rps per core".format(can_do))
        n_cores = [int(need[0]/can_do)+1, int(need[1]/can_do)+1]
        n_ses = [int(n_cores[0]/16)+1, int(n_cores[1]/16)+1]
        print("For complexity {} found in {} case, Need {} cores"
              # " ({} SEs of 16 cores)"
              " for Max RPS, {} cores"
              # " ({} SEs of 16 cores)"
              " for Avg RPS".format(description[complexity[i]],
                                    cases[i],
                                    n_cores[0],
                                    # ,n_ses[0]
                                    n_cores[1]
                                    # ,n_ses[1]
                                    ))


if __name__ == '__main__':
    main()


def run_tests():
    # 1. test

    return 0
