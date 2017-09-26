""" SSL Conversion Goes here """
import os
import logging
from avi.migrationtools.ace_converter.ace_constants import\
        DEFAULT_FAILED_CHECKS, DEFAULT_INTERVAL, DEFAULT_TIMEOUT
from avi.migrationtools.ace_converter.ace_utils import update_excel

#logging init
LOG = logging.getLogger(__name__)

class SSLConverter(object):
    """ SSL Converter Class """
    def __init__(self, parsed, tenant_ref, common_utils, in_path):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.in_path = in_path

    def ssl_key_and_cert(self):
        key_list = list()
        for ssl in self.parsed.get('ssl-proxy', '') :
            key = None
            cert = None
            name = ssl['name']
            # for val in ssl['desc']:
            #     key_and_cert = None
            #     if val.get('key', ''):
            #         key_loc = '%s/%s' % (self.in_path, val['key'])
            #         # print key_loc
            #         if os.path.isfile(key_loc):
            #             with open(key_loc, 'r') as reader:
            #                 key = reader.read().replace('\n', '')
            #         else:
            #             pass
            #     if val.get('cert', ''):
            #         cert_loc = '%s/%s' % (self.in_path, val['cert'])
            #         if os.path.isfile(cert_loc):
            #             with open(cert_loc, 'r') as reader:
            #                 cert = reader.read().replace('\n', '')
            #         else:
            #             pass
            if not key or not cert:
                key, cert = self.common_utils.create_self_signed_cert()
            if key and cert and name:
                key_and_cert = {
                    "type": "SSL_CERTIFICATE_TYPE_VIRTUALSERVICE",
                    "certificate": {
                        "certificate": cert
                    },
                    "tenant_ref": self.tenant_ref,
                    "name": name,
                    "key": key
                }
            if key_and_cert:
                key_list.append(key_and_cert)    
        return key_list
    def ssl_profile(self): 
        ssl_profile_list = list()
        for ssl in self.parsed.get('ssl-proxy', ''):
            temp_ssl_profile  = dict()
            temp_ssl_profile = {
                "accepted_ciphers": "DEFAULT:+SHA:+3DES:+kEDH", 
                "name": ssl['name'], 
                "accepted_versions": [
                    {
                        "type": "SSL_VERSION_TLS1"
                    }, 
                    {
                        "type": "SSL_VERSION_TLS1_1"
                    }, 
                    {
                        "type": "SSL_VERSION_TLS1_2"
                    }
                ], 
                "tenant_ref": self.tenant_ref, 
                "send_close_notify": False
            }
            ssl_profile_list.append(temp_ssl_profile)
        return ssl_profile_list
