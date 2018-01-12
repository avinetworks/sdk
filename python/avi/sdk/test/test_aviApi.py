import json
import os
import copy
from multiprocessing import Process, Pool
from random import randint
from urllib import urlopen

import time

import sys
from betamax import Betamax

from avi.sdk.samples.common import get_sample_ssl_params
from avi.sdk.utils.api_utils import ApiUtils
import logging
import pytest
import unittest
from csrf import TestResueApi
import requests
import urllib3
import vcr
from avi.sdk.avi_api import (ApiSession, ObjectNotFound, APIError, ApiResponse,
                             avi_timedelta, sessionDict)
from multiprocessing.pool import ThreadPool
from threading import Thread
gSAMPLE_CONFIG = None
api = None
log = logging.getLogger(__name__)
login_info = None

urllib3.disable_warnings()
gapi_version = '17.1.6'

obj = TestResueApi()
config_file = pytest.config.getoption("--config")
with open(config_file) as f:
    cfg = json.load(f)


my_vcr = vcr.VCR(
    cassette_library_dir='fixtures/cassettes/',
    record_mode='none',
    serializer='json',
    match_on= ['method','url','headers']
)

# with Betamax.configure() as config:
#     config.cassette_library_dir = 'cassettes/'
#     config.default_cassette_options['record_mode'] ='all'
#     config.default_cassette_options['serializer'] = 'json'
#     # config.default_cassette_options['before_record'] = 'before_record_cb'
#     # config.default_cassette_options['allow_playback_repeats'] = True
#     # config.default_cassette_options['match_requests_on'] = [
#     #     'method',
#     #     'uri',
#     #     'headers',
#     # ]
#     config.preserve_exact_body_bytes = True



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


def shared_session_check(index):
    vcr.use_cassette('test_chechProcess')
    rsp = api.get('tenant')
    return rsp.status_code

PROCESSES = 5
WORKER_CALLS = 7


class Test(unittest.TestCase):

    @my_vcr.use_cassette()
    def test_multiThreading(self):
        api.get_object_by_name('tenant', name='admin')
        for i in range(5):
            pool = ThreadPool(processes=3)
            res = pool.apply_async(shared_session_check, args=(1,))
            print "Return val ",res.get()

    # @my_vcr.use_cassette()
    # def test_chechProcess(self):
    #     api.get_object_by_name('tenant', name='admin')
    #     p = Process(target=shared_session_check, args=(1,))
    #     p.start()
    #     p.join()
    #     p = Pool(5)
    #     shared_sessions = []
    #     for index in range(5):
    #         shared_sessions.append(index)
    #     results = p.map(shared_session_check, shared_sessions)
    #     print "results :", results
    #     for result in results:
    #         assert result == 200
if __name__ == "__main__":
    unittest.main()