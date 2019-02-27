import argparse
import json
import re
import sys

def print_metrics_list(metric_name_list, step):
    for m in metric_name_list:
        factor = 1
        unit = ''
        if "avg_bandwidth" in m:
            factor = 1024 * 1024
            unit = ' Mb/s'
        print '\t' + m + ' for %s seconds' % args.step  
        total = 0
        for vs in metric_name_list[m]:
            print '\t\t' + vs + '    ' + str(metric_name_list[m][vs]/factor) + unit  
            total += metric_name_list[m][vs]/factor
        print '\t\tTotal ' + str(total) + unit
        if "avg_" not in m:
            print '\t\tTotal avg per sec (if applicable) ' + str(total/int(args.step)) + unit
        print '\n'

            
HELP_STR = 'python parse_se_metrics.py -c <avi_config> -m <se_metrics_file> -s <step>' 

if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=(HELP_STR))
    parser.add_argument('-c', '--config_file', help='avi config', required=True)
    parser.add_argument('-m', '--se_metrics_file', help='se metrics file', required=True)
    parser.add_argument('-s', '--step', help='Step used in se metrics', required=True)
    
    args = parser.parse_args()
        
    with open(args.config_file, 'r') as f:
        config = json.loads(f.read())

    with open(args.se_metrics_file, 'r') as f:
        metrics = json.loads(f.read())

    http_appprofile_list = []
    for i in config['ApplicationProfile']:
        if i["type"] == "APPLICATION_PROFILE_TYPE_HTTP":
            http_appprofile_list.append(i["name"])

    http_vs_list = []
    for i in config['VirtualService']:
        m = re.search('name=(.+)', i['application_profile_ref']).group(1)
        if m in http_appprofile_list:
            http_vs_list.append(i["uuid"])

    metric_name_list = {}
    non_http_metric_name_list = {}
    for vs in metrics['series']:
        vsm = metrics['series'][vs]
        for metric in vsm:
            name = metric['header']['name']
            if vs in http_vs_list:
                if not name in metric_name_list:
                    metric_name_list[name] = {}
                metric_name_list[name][vs] = metric["header"]["statistics"]["max"]
            else:
                if not name in non_http_metric_name_list:
                    non_http_metric_name_list[name] = {}
                non_http_metric_name_list[name][vs] = metric["header"]["statistics"]["max"]
                                          
    print '\nHTTP VS'
    print_metrics_list(metric_name_list, args.step)

    print '\nNon HTTP VS'
    print_metrics_list(non_http_metric_name_list, args.step)
 
