import requests
import argparse
import time

from avi.sdk.avi_api import ApiSession


def get_config_logs_for_vs(api, vs, only_config=True):
    url = ('analytics/logs?type=2&filter=co(all,%s)&'
           'page_size=10000' % vs)
    if only_config:
        url += ('&filter=eq(event_id,[config_create,config_update,'
                'config_delete,config_action])')
    start = time.time()
    resp = {"count": -1}
    total_retries = 50
    retry = 0
    while url:
        try:
            resp = api.get(url).json()
            if "more" in resp and resp["more"]:
                print "Need to get more: Curr Count %s Remaining: %s%%" % (
                    resp["count"], resp["percent_remaining"])
                url = resp["more"].split("api/")[1]
            else:
                break
        except Exception as e:
            if "Search system is down" in str(e):
                print "Search system is down; wait 2 seconds and retry"
                time.sleep(5.0)
            else:
                print("Failed in getting: %s;"
                      " will continue to retry")
                time.sleep(1.0)
            print("url: %s" % url)
            if retry == total_retries:
                break
            else:
                retry += 1
    time_taken = time.time() - start
    print "Time taken to fetch config logs for VS %s: %ss" % (vs, time_taken)
    with open("config_logs_%s" % vs, 'w') as f:
        f.write("%s" % resp)
    return


def get_config_logs_for_all_vses(api):
    all_vses = api.get("virtualservice?page_size=1000").json()["results"]
    vs_ids = [vs["uuid"] for vs in all_vses]
    for vs in vs_ids:
        print "Working on VS %s" % vs
        get_config_logs_for_vs(api, vs)


def main(args):
    api = ApiSession.get_session(args.controller, args.username, args.password,
                                 tenant="*")
    if args.vs:
        get_config_logs_for_vs(api, args.vs)
    else:
        get_config_logs_for_all_vses(api)


if __name__ == "__main__":
    requests.packages.urllib3.disable_warnings()
    parser = argparse.ArgumentParser(
        description="Script to get the config logs from Avi controller")
    parser.add_argument("-u", "--username", required=True,
                        help="Login username")
    parser.add_argument("-p", "--password", required=True,
                        help="Login password")
    parser.add_argument("-c", "--controller", required=True,
                        help="Controller IP address")
    parser.add_argument("-v", "--vs", required=False,
                        help="VirtualService uuid for which config logs are"
                             " needed. If not specified, config logs for all "
                             "VSes are fetched.")
    args = parser.parse_args()
    main(args)
