import json
import logging
import unittest
import time
from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from avi.sdk.samples.common import get_sample_ssl_params
from requests.packages import urllib3

gSAMPLE_CONFIG = None
api = None
log = logging.getLogger(__name__)




def setUpModule():
    cfg_file = open('test_api.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    log.debug(' read cofig %s', gSAMPLE_CONFIG)

    login_info = gSAMPLE_CONFIG["LoginInfo"]
    global api
    api = ApiSession.get_session(login_info["controller_ip"],
                                login_info.get("username", "admin"),
                                login_info.get("password", "avi123"),
                                tenant=login_info.get("tenant", "admin"),
                                tenant_uuid=login_info.get("tenant_uuid", None))


class Test(unittest.TestCase):
    def test_basic_vs(self):
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        resp = api.post('pool', data=json.dumps(basic_vs_cfg["pool_obj"]))
        vs_obj = basic_vs_cfg["vs_obj"]
        vs_obj["pool_ref"] = api.get_obj_ref(resp)
        resp = api.post('virtualservice', data=json.dumps(vs_obj))
        assert resp.status_code < 300

    def test_reuse_server_session(self):
        api2 = ApiSession(api.controller_ip, api.username, api.password,
                          tenant=api.tenant, tenant_uuid=api.tenant_uuid)
        assert api.headers["X-CSRFToken"] == api2.headers["X-CSRFToken"]

    def test_reuse_api_session(self):
        api2 = ApiSession.get_session(api.controller_ip, api.username,
                                      api.password, tenant=api.tenant,
                                      tenant_uuid=api.tenant_uuid)
        assert api == api2

    def test_delete_by_name(self):
        vs_name = gSAMPLE_CONFIG["BasicVS"]["vs_obj"]["name"]
        pool_name = gSAMPLE_CONFIG["BasicVS"]["pool_obj"]["name"]
        resp = api.delete_by_name("virtualservice", vs_name)
        resp2 = api.delete_by_name("pool", pool_name)
        assert resp.status_code < 300 and resp2.status_code < 300

    def test_ssl_vs(self):
        ssl_vs_cfg = gSAMPLE_CONFIG["SSL-VS"]
        resp = api.post('pool', data=json.dumps(ssl_vs_cfg["pool_obj"]))
        pool_ref = api.get_obj_ref(resp)
        cert, key, _, _ = get_sample_ssl_params(folder_path='../samples/')
        api_utils = ApiUtils(api)
        resp = api_utils.import_ssl_certificate("ssl-vs-kc", key, cert)
        ssl_key_and_cert_ref = [api.get_obj_ref(resp)]
        vs_obj = ssl_vs_cfg["vs_obj"]
        vs_obj["pool_ref"] = pool_ref
        vs_obj["ssl_key_and_certificate_refs"] = ssl_key_and_cert_ref
        resp = api.post('virtualservice', data=json.dumps(vs_obj))
        assert resp.status_code < 300

    def test_reset_connection(self):
        login_info = gSAMPLE_CONFIG["User2"]
        old_password = login_info["password"]
        api2 = ApiSession.get_session(api.controller_ip,
                                login_info["username"], old_password,
                                tenant=api.tenant, tenant_uuid=api.tenant_uuid)
        user_obj = api.get_object_by_name("user", login_info["name"])
        new_password = "avi1234"
        if login_info["password"] == new_password:
            new_password = "avi123"
        user_obj["password"] = new_password
        api.put("user/"+user_obj["uuid"], data=json.dumps(user_obj))
        user_obj["password"] = old_password
        api.put_by_name("user", user_obj["name"], data=json.dumps(user_obj))
        resp = api2.get("pool")
        assert resp.status_code < 300

    def test_delete_vs(self):
        vs_name = gSAMPLE_CONFIG["SSL-VS"]["vs_obj"]["name"]
        pool_name = gSAMPLE_CONFIG["SSL-VS"]["pool_obj"]["name"]
        vs_obj = api.get_object_by_name("virtualservice", vs_name)
        pool_obj = api.get_object_by_name("pool", pool_name)
        resp = api.delete("virtualservice/"+vs_obj["uuid"])
        resp2 = api.delete("pool/"+pool_obj["uuid"])
        assert resp.status_code < 300 and resp2.status_code < 300


if __name__ == "__main__":
    unittest.main()