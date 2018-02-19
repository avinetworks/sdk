import json
import requests
import pytest
import unittest

import urllib3

from avi.sdk.avi_api import (ApiSession, ObjectNotFound, APIError, ApiResponse,
                             avi_timedelta, sessionDict)


gSAMPLE_CONFIG = None
api = None
gapi_version = "17.1.6"
urllib3.disable_warnings()
config_file = pytest.config.getoption("--config")
with open(config_file) as f:
    cfg = json.load(f)

def setUpModule():
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = cfg
    #log.debug(' read config %s', gSAMPLE_CONFIG)

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

    def test_patch_methods(self):
        # create pool using post
        pool_config = gSAMPLE_CONFIG['BasicVS']
        pool_obj = pool_config['pool_obj']
        res = api.post('pool', json.dumps(pool_obj))
        assert res.status_code in [200, 201]

        # update pool using put
        uuid = res.json()['uuid']
        path = 'pool/' + uuid
        pool_obj['name'] = 'Updated_pool'
        put_res = api.put(path, json.dumps(pool_obj))
        assert put_res.status_code in [200, 201]

        # update pool using patch
        patch_obj = pool_config['patch_pool_obj']
        result = api.patch(path, json.dumps(patch_obj['data']))
        assert result.status_code in [200, 201]

        # remove servers using patch
        patch_obj = pool_config['pool_server']
        result = api.patch(path, json.dumps(patch_obj['data']))
        assert res.status_code in [200, 201]

        # replace server using patch
        patch_obj = pool_config['replace_pool_server']
        result = api.patch(path, json.dumps(patch_obj['data']))
        print result.json()
        assert res.status_code in [200, 201]

        # delete pool object
        pool_name = 'Updated_pool'
        result = api.delete_by_name('pool', name=pool_name)
        assert result.status_code == 204


    def test_add_persistence_profile(self):
        api1 = ApiSession(api.avi_credentials.controller,
                          api.avi_credentials.username,
                          api.avi_credentials.password,
                          api_version=api.avi_credentials.api_version,
                          verify=False, data_log=True)
        profile_config = gSAMPLE_CONFIG['ApplicationPersistenceProfile']
        res = api1.post('applicationpersistenceprofile', json.dumps(profile_config['profile1']))
        print api1.get_context()
        api2 = ApiSession(api.avi_credentials.controller,
                          api.avi_credentials.username,
                          api.avi_credentials.password,
                          api_version=api.avi_credentials.api_version,
                          verify=False, data_log=True)


        # profile_config = gSAMPLE_CONFIG['ApplicationPersistenceProfile']
        # res = api2.post('applicationpersistenceprofile', json.dumps(profile_config['profile2']))
        # print res.cookies
        print api2.get_context()