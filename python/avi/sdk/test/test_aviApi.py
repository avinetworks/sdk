import json
import os
import copy
from urllib import urlopen
from avi.sdk.samples.common import get_sample_ssl_params
from avi.sdk.utils.api_utils import ApiUtils
import logging
import pytest
import unittest

import requests
import urllib3
import vcr
from avi.sdk.avi_api import (ApiSession, ObjectNotFound, APIError, ApiResponse,
                             avi_timedelta, sessionDict)

gSAMPLE_CONFIG = None
api = None
log = logging.getLogger(__name__)
login_info = None

urllib3.disable_warnings()
gapi_version = '17.1.6'

config_file = pytest.config.getoption("--config")
with open(config_file) as f:
    cfg = json.load(f)

my_vcr = vcr.VCR(
    cassette_library_dir='fixtures/cassettes',
    record_mode='once',
    match_on=['uri', 'method'],
)


def setUpModule():
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = cfg
    #log .debug(' read config %s', gSAMPLE_CONFIG)

    global login_info
    login_info = gSAMPLE_CONFIG["LoginInfo"]

    global api
    api = ApiSession.get_session(
        login_info["controller_ip"], login_info.get("username", "admin"),
        login_info.get("password", "avi123"),
        tenant=login_info.get("tenant", "admin"),
        tenant_uuid=login_info.get("tenant_uuid", None),
        api_version=login_info.get("api_version", gapi_version),
        verify=False)

class Test(unittest.TestCase):

    @my_vcr.use_cassette()
    def test_basic_vs(self):
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        vs_obj = basic_vs_cfg["vs_obj"]
        resp = api.post('pool', data=json.dumps(basic_vs_cfg["pool_obj"]),
                        api_version='17.1.1')
        assert resp.status_code in (200, 201)
        vs_obj["pool_ref"] = api.get_obj_ref(resp.json())
        resp = api.post('virtualservice', data=json.dumps(vs_obj),
                        api_version='17.1.1')
        assert resp.status_code in (200, 201)
        pool_name = gSAMPLE_CONFIG["BasicVS"]["pool_obj"]["name"]
        resp = api.get('virtualservice', tenant='admin',
                       api_version='17.1.1')
        assert resp.json()['count'] >= 1
        resp = api.delete_by_name('virtualservice', vs_obj['name'],
                                  api_version='17.1.1')
        assert resp.status_code in (200, 204)
        resp = api.delete_by_name("pool", pool_name,
                                  api_version='17.1.1')
        assert resp.status_code in (200, 204)

    @my_vcr.use_cassette()
    def test_ssl_vs(self):
        papi = ApiSession(api.avi_credentials.controller,
                          api.avi_credentials.username,
                          api.avi_credentials.password,
                          api_version=api.avi_credentials.api_version,
                          verify=False, data_log=True)

        ssl_vs_cfg = gSAMPLE_CONFIG["SSL-VS"]
        vs_obj = ssl_vs_cfg["vs_obj"]
        pool_name = gSAMPLE_CONFIG["SSL-VS"]["pool_obj"]["name"]
        resp = papi.post('pool', data=gSAMPLE_CONFIG["SSL-VS"]["pool_obj"])
        assert resp.status_code == 201
        pool_ref = papi.get_obj_ref(resp.json())
        cert, key, _, _ = get_sample_ssl_params \
            (folder_path=os.path.abspath(
                os.path.join(os.path.dirname(__file__), '..',
                             'samples')) + os.sep)
        api_utils = ApiUtils(papi)
        try:
            resp = api_utils.import_ssl_certificate("ssl-vs-kc", key, cert)
            ssl_kc = resp.json()
        except:
            ssl_kc = api.get_object_by_name('sslkeyandcertificate',
                                            'ssl-vs-kc')
        ssl_key_and_cert_ref = [papi.get_obj_ref(ssl_kc)]
        vs_obj["pool_ref"] = pool_ref
        vs_obj["ssl_key_and_certificate_refs"] = ssl_key_and_cert_ref
        resp = papi.post('virtualservice', data=json.dumps(vs_obj))
        assert resp.status_code < 300
        resp = papi.delete_by_name('virtualservice', vs_obj['name'])
        assert resp.status_code in (200, 204)
        resp = papi.delete_by_name("pool", pool_name)
        assert resp.status_code in (200, 204)
        resp = papi.delete_by_name('sslkeyandcertificate', 'ssl-vs-kc')
        assert resp.status_code in (200, 204)

    def test_reuse_api_session(self):
            api1 = ApiSession(avi_credentials=api.avi_credentials,
                               verify=False)
            api2 = ApiSession.get_session(avi_credentials=api.avi_credentials,
                                          verify=False)
            assert api1 == api2

if __name__ == "__main__":
    unittest.main()