#!/usr/bin/python
import os
import json
from avi.sdk.avi_api import ApiSession

def DisableVirtualService(vs_name):
    """
    Creates a session using token and other user information passed to the control script.
    :param vs_name: Name of the Virtual Service which need to be disabled. 
    """
    # Get session on the basis of authentication token
    token=os.environ.get('API_TOKEN')
    user=os.environ.get('USER')
    tenant=os.environ.get('TENANT')
    with ApiSession("localhost", user, token=token, tenant=tenant) as session:
        # Get the virtualservice objct of name myVirtualService
        vs_obj = session.get_object_by_name('virtualservice', vs_name)

        if vs_obj:
            # Update the object
            vs_obj['enabled'] = False

            # Save the object
            resp = session.put('virtualservice/%s' %vs_obj['uuid'], data=vs_obj)
            print(resp.status_code, resp.json())

if __name__ == "__main__":
    DisableVirtualService('myVirtualService')
