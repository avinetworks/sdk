import json
import os
import requests
import sys
import argparse
import time

from avi.sdk.avi_api import ApiSession

def backup_configuration(api, args):
    data = {'passphrase': args.passphrase} if args.passphrase else {}
    params = {'full_system': True}
    filename = "%s_%s.%s" % (args.filename, args.controller, time.strftime("%Y%m%d_%H%M%S"))
    rsp = api.post('configuration/export', params=params, data=json.dumps(data))
    with open(filename, 'w') as f:
        f.write(rsp.text)
    print('Configuration successfully saved in %s' % filename)

def main(args):
    api = ApiSession.get_session(args.controller, args.username, args.password)
    backup_configuration(api, args)

if __name__ == "__main__":
    requests.packages.urllib3.disable_warnings()
    parser = argparse.ArgumentParser(description="Script to get the full configuration from Avi controller")
    parser.add_argument("-u", "--username", required=True,
                        help="Login username")
    parser.add_argument("-p", "--password", required=True,
                        help="Login password")
    parser.add_argument("-c", "--controller", required=True,
                        help="Controller IP address")
    parser.add_argument("-P", "--passphrase", required=False,
                        help="Passphrase to encrypt sensitive information in backup")
    parser.add_argument("-f", "--filename", required=True,
                        help="Filename prefix - will be suffixed with a timestamp")
    args = parser.parse_args()
    main(args)
