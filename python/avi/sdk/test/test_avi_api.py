import json
import logging
import unittest
from avi.sdk.avi_api import ApiSession, ObjectNotFound, APIError, ApiResponse
from avi.sdk.utils.api_utils import ApiUtils
from avi.sdk.samples.common import get_sample_ssl_params
from requests.packages import urllib3
from requests import Response
import traceback
import copy

gSAMPLE_CONFIG = None
api = None
log = logging.getLogger(__name__)
login_info = None

urllib3.disable_warnings()


def setUpModule():
    cfg_file = open('test_api.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    log.debug(' read cofig %s', gSAMPLE_CONFIG)

    global login_info
    login_info = gSAMPLE_CONFIG["LoginInfo"]

    global api
    api = ApiSession.get_session(
            login_info["controller_ip"], login_info.get("username", "admin"),
            login_info.get("password", "avi123"),
            tenant=login_info.get("tenant", "admin"),
            tenant_uuid=login_info.get("tenant_uuid", None),
            verify=False)


class Test(unittest.TestCase):
    def test_basic_vs(self):
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        vs_obj = basic_vs_cfg["vs_obj"]
        resp = api.post('pool', data=json.dumps(basic_vs_cfg["pool_obj"]))
        assert resp.status_code in (200, 201)
        vs_obj["pool_ref"] = api.get_obj_ref(resp)
        resp = api.post('virtualservice', data=json.dumps(vs_obj))
        assert resp.status_code in (200, 201)
        pool_name = gSAMPLE_CONFIG["BasicVS"]["pool_obj"]["name"]
        resp = api.get('virtualservice', tenant='admin')
        assert resp.json()['count'] >= 1
        resp = api.delete_by_name('virtualservice', vs_obj['name'])
        assert resp.status_code in (200, 204)
        resp = api.delete_by_name("pool", pool_name)
        assert resp.status_code in (200, 204)

    def test_reuse_server_session(self):
        api2 = ApiSession(api.controller_ip, api.username, api.password,
                          tenant=api.tenant, tenant_uuid=api.tenant_uuid)
        assert api.headers["X-CSRFToken"] == api2.headers["X-CSRFToken"]

    def test_reuse_api_session(self):
        api2 = ApiSession.get_session(api.controller_ip, api.username,
                                      api.password, tenant=api.tenant,
                                      tenant_uuid=api.tenant_uuid,
                                      verify=False)
        assert api == api2

    def test_ssl_vs(self):
        # papi = ApiSession(api.controller_ip, api.username, api.password,
        #                  verify=False)
        papi = api
        ssl_vs_cfg = gSAMPLE_CONFIG["SSL-VS"]
        vs_obj = ssl_vs_cfg["vs_obj"]
        pool_name = gSAMPLE_CONFIG["SSL-VS"]["pool_obj"]["name"]
        resp = papi.post('pool', data=json.dumps(ssl_vs_cfg["pool_obj"]))
        pool_ref = papi.get_obj_ref(resp)
        cert, key, _, _ = get_sample_ssl_params(folder_path='../samples/')
        api_utils = ApiUtils(papi)
        resp = api_utils.import_ssl_certificate("ssl-vs-kc", key, cert)
        ssl_key_and_cert_ref = [papi.get_obj_ref(resp)]
        vs_obj["pool_ref"] = pool_ref
        vs_obj["ssl_key_and_certificate_refs"] = ssl_key_and_cert_ref
        resp = papi.post('virtualservice', data=json.dumps(vs_obj))
        assert resp.status_code < 300
        resp = papi.delete_by_name('virtualservice', vs_obj['name'])
        assert resp.status_code in (200, 204)
        resp = papi.delete_by_name("pool", pool_name)
        assert resp.status_code in (200, 204)

    def test_reset_connection(self):
        login_info = gSAMPLE_CONFIG["User2"]
        old_password = login_info["password"]
        api2 = ApiSession.get_session(
                api.controller_ip, login_info["username"], old_password,
                tenant=api.tenant, tenant_uuid=api.tenant_uuid, verify=False)
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

    def test_avi_json(self):
        rsp = Response()
        rsp.status_code = 404
        rsp._content = 'Not found'
        try:
            avi_rsp = ApiResponse(rsp)
            avi_rsp.json()
            assert False
        except ObjectNotFound:
            pass
        except Exception:
            assert False

        rsp.status_code = 501
        try:
            avi_rsp = ApiResponse(rsp)
            avi_rsp.json()
            assert False
        except APIError:
            pass
        except Exception:
            assert False

        rsp.status_code = 200
        rsp._content = json.dumps({'count': 3, 'results': ['a', 'b', 'c']})
        try:
            avi_rsp = ApiResponse(rsp)
            obj = avi_rsp.json()
            assert obj['count']
            assert avi_rsp.count() == 3
            assert len(obj['results']) == 3
        except Exception as e:
            log.debug('exception %s', str(e))
            log.debug('%s', traceback.format_exc())
            assert False

    def test_multiple_tenants(self):
        """
        Tests api with multiple tenants to make sure object is only returned
        for the right tenant.
        """
        tobj = {'name': 'test-tenant'}
        resp = api.post('tenant', data=tobj)
        assert resp.status_code in (200, 201)
        tapi = ApiSession(api.controller_ip, api.username, api.password,
                          tenant=tobj['name'], verify=False)
        t_obj = tapi.get_object_by_name('tenant', tobj['name'])
        # created pool.
        log.info('tenant %s', t_obj)
        basic_vs_cfg = gSAMPLE_CONFIG["BasicVS"]
        pool_cfg = copy.deepcopy(basic_vs_cfg["pool_obj"])
        pool_cfg['name'] = pool_cfg['name'] + '-test-tenant'
        resp = tapi.post('pool', data=pool_cfg)
        assert resp.status_code in (200, 201)
        # check pool was not created in tenant admin
        pname = pool_cfg['name']
        resp = api.get_object_by_name('pool', pname)
        assert resp is None
        resp = tapi.get_object_by_name('pool', pname)
        assert resp
        resp = api.get_object_by_name('pool', pname, tenant_uuid=t_obj['uuid'])
        assert resp
        resp = api.get_object_by_name('pool', pname, tenant='test-tenant')
        assert resp
        resp = tapi.delete_by_name("pool", pname)
        assert resp.status_code in (200, 201, 204)
        resp = api.get_object_by_name('pool', pname, tenant='test-tenant')
        assert resp is None
        resp = tapi.delete_by_name('tenant', 'test-tenant', tenant='admin')
        assert resp.status_code in (200, 201, 204)

    def test_timeout(self):
        resp = api.get_object_by_name('tenant', 'admin', timeout=2)
        assert resp

    def Ntest_delete_tenant(self):
        resp = api.delete_by_name('tenant', 'test-tenant')
        assert resp.status_code in (200, 201, 204)


if __name__ == "__main__":
    unittest.main()
