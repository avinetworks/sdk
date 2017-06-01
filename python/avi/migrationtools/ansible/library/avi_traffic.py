# prerequisite
# 1. pip install requests
#
#
# !/usr/bin/python
from ansible.module_utils.basic import *

try:
    import requests
    import shlex
    import socket
    import time
    from subprocess import call

    HAS_REQUEST = True
except ImportError:
    HAS_REQUEST = False


def main():
    """Module instantiation"""
    module = AnsibleModule(
        argument_spec=dict(
            ip_address=dict(required=True),
            request_type=dict(required=True),
            port=dict(required=True),
            vs_name=dict(required=True),
            controller=dict(required=True),
            username=dict(required=True),
            password=dict(required=True)
        )
    )

    if not HAS_REQUEST:
        module.fail_json(msg='Library not imported properly')

    # Accessing arguments
    uri = module.params.get("ip_address", None)
    request_type = module.params.get('request_type', None)
    port = module.params.get('port', None)
    virtualservice_name = module.params.get('vs_name', None)
    controller = module.params.get('controller', None)
    password = module.params.get('password', None)
    username = module.params.get('username', None)
    path = '/api/virtualservice?name='
    # Get the UUID OF virtualservice for runtime status.
    response = requests.get(request_type + '://' + controller + path +
                            virtualservice_name, verify=False,
                            auth=(username, password))
    if response.status_code >= 200 and response.status_code <= 299:
        response = response.json()
        uuid = response['results'][0]['uuid']
        vs_up = False
        if uuid:
            status_path = '/api/virtualservice/%s/runtime/detail/' % uuid
            for i in range(0, 10):
                # Check if virtualservice is up
                response = requests.get(request_type + '://' + controller +
                                        status_path, verify=False,
                                        auth=(username, password))
                response = response.json()
                if 'OPER_UP' == response[0]['oper_status']['state']:
                    vs_up = True
                    break
                else:
                    time.sleep(0.2)
        if vs_up:
            # Send http get requests to generate traffic
            if request_type == 'http' or request_type == 'https':
                for i in range(0, 10):
                    try:
                        response = requests.get(request_type + '://' + uri + ':'
                                                + port, verify=False)
                    except:
                        module.fail_json(msg='Virtualservice is down')
                    if response.status_code >= 200 \
                            and response.status_code <= 299:
                        continue
                    else:
                        module.fail_json(msg='Virtualservice is down')
                        break

                if response.status_code >= 200 and \
                                response.status_code <= 299:
                    module.exit_json(
                        stdout='Virtualservice Traffic sent successfully',
                        changed=False,
                        success=0
                    )
                else:
                    module.exit_json(
                        stderr='Virtualservice is not reachable',
                        changed=False,
                        success=1
                    )
            # Send tcp requests traffic if 0 then Success else False
            elif request_type == 'tcp':
                command = 'nc -w 2 %s %s' % (uri, port)
                cmd = shlex.split(command)
                out = call(cmd)
                if not out:
                    module.exit_json(
                        stderr='Tcp Traffic sent successfully',
                        changed=False,
                        success=0,
                    )
                else:
                    module.exit_json(
                        stderr='Tcp Traffic failed',
                        changed=False,
                        success=1
                    )
            # type dns then do the dns lookup
            elif request_type == 'dns':
                try:
                    ip = socket.gethostbyname('google.com')
                except:
                    module.fail_json(msg='Not valid dns')
                if ip:
                    module.exit_json(
                        stderr='Dns Lookup successful %s' % ip,
                        changed=False,
                        success=0
                    )
                else:
                    module.exit_json(
                        stderr='Dns Lookup unsuccessful',
                        changed=False,
                        success=1
                    )
        else:
            module.exit_json(
                stderr='Virtualservice is not enabled',
                changed=False,
                success=1
            )

    else:
        module.exit_json(
            stderr='Virtualservice api is not reachable',
            changed=False,
            success=1
        )


if __name__ == '__main__':
    main()