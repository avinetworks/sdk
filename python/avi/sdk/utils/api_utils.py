'''
Created on Feb 10, 2016

@author: grastogi
'''
import json


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
