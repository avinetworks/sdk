'''
Created on Feb 10, 2016

@author: grastogi
'''

def get_sample_ssl_params(folder_path=''):
    with open(folder_path + 'certs/server.crt') as f:
        server_crt = f.read()
    with open(folder_path + 'certs/server.key') as f:
        server_key = f.read()
    with open(folder_path + 'certs/cakey.pem') as f:
        ca_key = f.read()
    with open(folder_path + 'certs/cacert.pem') as f:
        ca_cert = f.read()
    return server_crt, server_key, ca_key, ca_cert