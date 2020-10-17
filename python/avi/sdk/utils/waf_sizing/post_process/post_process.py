#!/usr/bin/env python3

# prints out WAF-performance-related metrics gathered from
# se_metrics.py and computes aggregate and correctly normalized
# relative metrics from those of individual VSs

import sys
import re
import os.path
import json
import pathlib
import argparse

verbose = False

##
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

def process_file(file, combined):
    fh = open(file, 'r') # excepts on failure - which is what we want
    file_data = json.load(fh)
    series = file_data['series']
    for vs, metric_data in series.items():
        vs_uuid = '_'.join(vs.split('-')[1:])
        for stats in metric_data:
            metric_name = stats['header']['name']
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

def post_process_metric(filename,data,total_num_reqs):
    num_samples = len(total_num_reqs)
    if num_samples != len(data):
        print("Warning: Length mismatch for file {0}: {1} != {2}".\
              format(filename,num_samples,len(total_num_headers)))
    print("Opening new file: {0}".format(filename))
    (mi,ma,av,mi_i,ma_i) = (0,0.0,0.0,0,0)
    fh = open(filename, 'w')
    for i in range(num_samples):
        sample = data[i] / total_num_reqs[i]
        if sample > ma:
            ma = sample
            ma_i = i

        if mi == 0 or sample < mi:
            mi = sample
            mi_i = i

        av += sample
        fh.write( "{0}\n".format(sample))

    av /= num_samples
    print(" -- max was {0} (at sample {1}), min was {2} (at sample{3}), avg was {4}.\n".\
          format(ma,ma_i,mi,mi_i,av))


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("file", nargs='+')
    parser.add_argument("-v", action="store_true")
    args = parser.parse_args()
    verbose = args.v


    combined = {} # { "metric_name": { "data": [1,0,3], "num_vs": 40}, {...},...}



    for file in args.file:
        if verbose:
            print(file)
        if os.path.getsize(file) == 0:
            print("File {0} is empty - skipping".format(file))
            continue
        process_file(file, combined)


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

        {"filename": 'combined-overall_pct_get',
         "metric":   'l7_client.sum_get_reqs'},

        {"filename": 'combined-overall_pct_post',
         "metric":   'l7_client.sum_post_reqs'},

        {"filename": 'combined-overall_pct_waf_disabled',
         "metric":   'l7_client.sum_waf_disabled'},
    ]

    for n in to_normalize:
        post_process_metric(n['filename'], combined[n['metric']]['data'],total_num_reqs)



if __name__ == '__main__':
    main()
