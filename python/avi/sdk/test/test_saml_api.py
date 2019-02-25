import json
import pytest
import unittest
from avi.sdk.avi_api import ApiSession

api_version = '18.2.2'

config_file = pytest.config.getoption("--config")
with open(config_file) as f:
    cfg = json.load(f)

def setUpModule():
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = cfg

    global oktalogin_info
    global onelogin_info
    global oktaapi
    global onelogin

    oktalogin_info = gSAMPLE_CONFIG["OktaLoginInfo"]
    oktaapi = ApiSession.get_session(
        oktalogin_info["controller_ip"], oktalogin_info.get("username", "admin"),
        oktalogin_info.get("password", "fr3sca$%^"),
        tenant=oktalogin_info.get("tenant", "admin"),
        tenant_uuid=oktalogin_info.get("tenant_uuid", None),
        api_version=oktalogin_info.get("api_version", api_version),
        verify=False,idp='okta')

    onelogin_info = gSAMPLE_CONFIG["OneloginLoginInfo"]
    onelogin = ApiSession.get_session(
        onelogin_info["controller_ip"], onelogin_info.get("username", "admin"),
        onelogin_info.get("password", "fr3sca$%^"),
        tenant=onelogin_info.get("tenant", "admin"),
        tenant_uuid=onelogin_info.get("tenant_uuid", None),
        api_version=onelogin_info.get("api_version", api_version),
        verify=False, idp='onelogin')


class TestSaml(unittest.TestCase):

    def test_basic_vs_using_okta(self):
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        vs_obj = basic_vs_cfg["vs_obj"]
        resp = oktaapi.post('pool', data=json.dumps(basic_vs_cfg["pool_obj"]),
                        api_version=api_version)
        assert resp.status_code in (200, 201)
        vs_obj["pool_ref"] = oktaapi.get_obj_ref(resp.json())
        resp = oktaapi.post('virtualservice', data=json.dumps(vs_obj),
                        api_version=api_version)
        assert resp.status_code in (200, 201)
        pool_name = gSAMPLE_CONFIG["BasicVS"]["pool_obj"]["name"]
        resp = oktaapi.get('virtualservice', tenant='admin',
                       api_version=api_version)
        assert resp.json()['count'] >= 1
        resp = oktaapi.delete_by_name('virtualservice', vs_obj['name'],
                                  api_version=api_version)
        assert resp.status_code in (200, 204)
        resp = oktaapi.delete_by_name("pool", pool_name,
                                  api_version=api_version)
        assert resp.status_code in (200, 204)

    def test_basic_vs_using_onelogin(self):
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        vs_obj = basic_vs_cfg["vs_obj"]
        resp = onelogin.post('pool', data=json.dumps(basic_vs_cfg["pool_obj"]),
                        api_version=api_version)
        assert resp.status_code in (200, 201)
        vs_obj["pool_ref"] = onelogin.get_obj_ref(resp.json())
        resp = onelogin.post('virtualservice', data=json.dumps(vs_obj),
                        api_version=api_version)
        assert resp.status_code in (200, 201)
        pool_name = gSAMPLE_CONFIG["BasicVS"]["pool_obj"]["name"]
        resp = onelogin.get('virtualservice', tenant='admin',
                       api_version=api_version)
        assert resp.json()['count'] >= 1
        resp = onelogin.delete_by_name('virtualservice', vs_obj['name'],
                                  api_version=api_version)
        assert resp.status_code in (200, 204)
        resp = onelogin.delete_by_name("pool", pool_name,
                                  api_version=api_version)
        assert resp.status_code in (200, 204)
