import os
import sys
import json
import argparse
import requests.packages.urllib3

from avi.sdk import avi_api

requests.packages.urllib3.disable_warnings()


def create_ccuser(controller, username, password, tenant, ccuser_name, key_file, update):
    if not os.path.exists(key_file):
        raise Exception("Service account key file %s not found" % key_file)

    key_file_data = {}
    with open(key_file, 'r') as f:
        key_file_data = json.load(f)

    key_file_data = json.dumps(key_file_data)
    try:
        session = avi_api.ApiSession.get_session(controller, username, password, tenant=tenant, api_version='18.2.3')
    except:
        print "Failed to establish connection with AVI Controller"
        raise

    ccuser = session.get_object_by_name('cloudconnectoruser', ccuser_name)
    if ccuser:
        if update:
            ccuser["gcp_credentials"]["service_account_keyfile_data"] = key_file_data
            print "Updating cloudconnectoruser %s" % ccuser_name
            resp = session.put("cloudconnectoruser/%s" % ccuser['uuid'], data=ccuser)
            if resp.status_code != 200:
                raise Exception("Failed to update Cloudconnectoruser %s : %s" % (ccuser_name, resp.text))
            print "Cloudconnectoruser %s successfully updated" % (ccuser_name)
    else:
        ccuser_config = {
                         "name": ccuser_name,
                         "gcp_credentials": {
                            "service_account_keyfile_data": key_file_data,
                         }
                    }

        print "Creating cloudconnectoruser %s" % ccuser_name
        resp = session.post('cloudconnectoruser', data=ccuser_config)
        if resp.status_code != 201:
            raise Exception("Failed to create Cloudconnectoruser %s : %s" % (ccuser_name, resp.text))
        print "Cloudconnectoruser %s successfully created" % ccuser_name


def main():
    parser = argparse.ArgumentParser(description=
        "This script creates the cloudconnector user for the GCP Cloud. \
        It takes the service account key file in JSON and creates the \
        cloudconnectoruser.")
    parser.add_argument('--controller', help="Hostname/IP-Address of the AVI Controller", required=True)
    parser.add_argument('--username', help="AVI username", default="admin")
    parser.add_argument('--password', help="AVI user password", required=True)
    parser.add_argument('--tenant', help='AVI tenant name', default='admin')
    parser.add_argument('--name', help="CloudConnector user name", required=True)
    parser.add_argument('--key-file', help="GCP service account JSON key file path", required=True)
    parser.add_argument('--update', help="Update cloudconnector user with key if user already exists", action='store_true')
    args = parser.parse_args()
    try:
        create_ccuser(args.controller, args.username, args.password, args.tenant, args.name, args.key_file, args.update)
    except Exception as e:
        print e.message if e.message else str(e)
        sys.exit(1)


if __name__ == '__main__':
    main()
