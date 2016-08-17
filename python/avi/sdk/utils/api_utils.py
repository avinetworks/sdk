'''
Created on Feb 10, 2016

@author: grastogi
'''
import json
import re


class ApiUtils(object):
    '''
    Common utilities for the Avi APIs
    '''
    def __init__(self, api_session):
        '''
        Constructor
        '''
        self.api_session = api_session

    def import_ssl_certificate(self, name, key, cert, key_passphrase='',
                               tenant='', tenant_uuid=''):
        """import_ssl_certificate takes cert name server key, cert, passphrase
        returns session's response object"""
        ssl_kc_obj = {
            'name': name,
            'key': key,
            'certificate': cert,
            'key_passphrase': key_passphrase
        }
        resp = self.api_session.post(
                path='sslkeyandcertificate/importkeyandcertificate',
                data=json.dumps(ssl_kc_obj),
                tenant=tenant, tenant_uuid=tenant_uuid)
        return resp

RE_REF_MATCH = re.compile('/api/[\w/]+\?name\=[\w#]+')


def ref_n_str_cmp(x, y):
    """
    compares two references
    1. check for exact reference
    2. check for obj_type/uuid
    3. check for name
    """
    if (not isinstance(x, basestring)) or (not isinstance(y, basestring)):
        return False
    y_uuid = y_name = y
    if RE_REF_MATCH.match(y):
        y_uuid = y_name = y.split('name=')[1]
    elif (y.find('api/') != -1):
        path = y.split('api/')[1]
        _, uuid_or_name = path.split('/')
        parts = uuid_or_name.split('#')
        y_uuid = parts[0]
        y_name = parts[1] if len(parts) > 1 else y_uuid
    if RE_REF_MATCH.match(x):
        x = x.split('name=')[1]
    return (x == y_uuid) or (x == y_name)


def avi_obj_cmp(x, y):
    """
    compares whether x is fully contained in y
    """
    if isinstance(x, str):
        return ref_n_str_cmp(x, y)
    if type(x) not in [list, dict]:
        return x == y
    if type(x) == list:
        # should compare each item in the list and that should match
        zipped = zip(x, y)
        if len(x) > len(zipped):
            return False
        for i in zip(x, y):
            if not avi_obj_cmp(i[0], i[1]):
                # not need to continue
                return False
    if type(x) == dict:
        x_keys = set(x.keys())
        y_keys = set(y.keys())
        if not x_keys.issubset(y_keys):
            return False
        for k, v in x.iteritems():
            if k not in y:
                return False
            if not avi_obj_cmp(v, y[k]):
                return False
    return True
