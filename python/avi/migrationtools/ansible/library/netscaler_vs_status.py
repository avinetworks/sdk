# prerequisite
# 1. pip install requests
#
#
# !/usr/bin/python
from ansible.module_utils.basic import *
from avi.sdk.avi_api import ApiSession

try:
    import requests
    import json

    HAS_REQUEST = True
except ImportError:
    HAS_REQUEST = False


def main():
    """Module instantiation"""
    module = AnsibleModule(
        argument_spec=dict(
            username=dict(required=True),
            password=dict(required=True),
            state=dict(required=True),
            vs_name=dict(required=True),
            vs_type=dict(required=True),
            ns_host=dict(required=True)
        )
    )

    if not HAS_REQUEST:
        module.fail_json(msg='Library not imported properly')

    # Accessing arguments
    username = module.params.get("username")
    password = module.params.get('password')
    state = module.params.get('state')
    virtualservice_name = module.params.get('vs_name')
    vs_type = module.params.get('vs_type')
    ns_host = module.params.get('ns_host')
    # api = None
    # obj = None
    if vs_type == 'csvs':
        api = 'http://%s/nitro/v1/config/csvserver?action=%s' % (ns_host, state)
        obj = {'csvserver': {'name': virtualservice_name}}
    elif vs_type == 'lbvs':
        api = 'http://%s/nitro/v1/config/lbvserver?action=%s' % (ns_host, state)
        obj = {"lbvserver": {"name": virtualservice_name}}
    session = requests.Session()
    session.auth = (username, password)
    session.verify = False
    session.headers["Content-Type"] = "application/json"
    response = session.post(api, data=json.dumps(obj))
    if response.status_code >= 200 and \
                    response.status_code <= 299:
        module.exit_json(
            stdout='Virtualservice %s successfully' % state,
            changed=False,
            success=0
        )
    else:
        module.exit_json(
            stderr='Virtualservice is not %s' % state,
            changed=False,
            success=1
        )

if __name__ == '__main__':
    main()