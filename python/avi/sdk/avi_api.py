import copy
import json
import logging
from datetime import datetime
from requests import Response
from requests.sessions import Session

logger = logging.getLogger(__name__)


class ObjectNotFound(Exception):
    pass


class APIError(Exception):
    def __init__(self, arg):
      self.args = arg


class APINotImplemented(Exception):
    pass


class ApiSession(Session):
    '''
    Extends the Request library's session object to provide helper
    utilities to work with Avi Controller like authentication, api massaging
    etc.
    '''
    sessionDict = {}

    def __init__(self, controller_ip, username, password=None, token=None,
                 tenant=None, batch=False):
        '''
        initialize new session object with authenticated token from login api
        '''
        super(ApiSession, self).__init__()
        self.controller_ip = controller_ip
        self.username = username
        self.password = password
        self.keystone_token = token
        self.tenant = tenant if tenant else 'admin'
        self.batch = batch
        self.headers = {}
        self.prefix = (controller_ip if controller_ip.startswith('http')
                       else "https://%s" % controller_ip)

        try:
            user_session = ApiSession.sessionDict[username]["api"]
        except KeyError:
            logger.debug("Session dose not exist creating new session for %s",
                      username)
            ApiSession.authenticate_session(self)
            ApiSession.sessionDict[username] = {"api": self,
                                                "last_used": datetime.utcnow()}
            user_session = self
        self.headers = copy.deepcopy(user_session.headers)
        self.headers.update({"X-Avi-Tenant": "%s" % tenant})
        self.cookies = user_session.cookies
        return

    @staticmethod
    def get_session(controller_ip, username, password=None, token=None,
                    tenant=None, batch=False):
        """
        returns the session object for same user and tenant
        calls init if session dose not exist and adds it to session cache
        """
        try:
            user_session = ApiSession.sessionDict[username]["api"]
            if user_session.password != password:
                raise APIError("Authentication Failed")
            if user_session.tenant != tenant:
                raise APIError("Tenant wont match use ApiSessionAdapter")
        except KeyError:
            logger.debug("Session dose not exist creating new session for %s",
                         username)
            user_session = ApiSession(controller_ip, username, password,
                                      token=token, tenant=tenant, batch=batch)
            ApiSession.sessionDict[user_session.username] = \
                {"api": user_session, "last_used": datetime.utcnow()}
        ApiSession._clean_inactive_sessions()
        return user_session


    def reset_session(self):
        """
        @param api: ApiSession object
        """
        logger.info('resetting session for %s', self.username)
        sess = ApiSession.sessionDict.get(self.username)["api"]
        if sess.headers.get("X-CSRFToken") == self.headers.get("X-CSRFToken"):
            del ApiSession.sessionDict[self.username]
            print "Removed session for: " + self.username
        ApiSession._setup_session(self)
        ApiSession._clean_inactive_sessions()

    def authenticate_session(self):
        body = {"username": self.username}
        if not self.keystone_token:
            body["password"] = self.password
        else:
            body["token"] = self.keystone_token

        logger.debug('authenticating user %s ', self.username)
        rsp = super(ApiSession, self).post(self.prefix+"/login", body, timeout=5,
                                       verify=False)
        if rsp.status_code != 200:
            raise Exception("Authentication failed: %s", rsp.text)
        logger.debug("rsp cookies: %s", dict(rsp.cookies))
        self.headers.update({
            "X-CSRFToken": dict(rsp.cookies).get('csrftoken', ''),
            "Referer": self.prefix,
            "Content-Type": "application/json"
        })
        # switch to a different tenant if needed
        if self.tenant:
            self.headers.update({"X-Avi-Tenant": "%s" % self.tenant})
        logger.debug("authentication success sess headers: %s", self.headers)
        return

    def get(self, path, **kwargs):
        """get method takes relative path to service and kwargs as per Session
            class get method
        returns session's response object """
        path = self._get_api_path(path)
        resp = super(ApiSession, self).get(path, timeout=20, verify=False,
                                       **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.get(path, **kwargs)
        self._update_session_last_used()
        return resp

    def get_object_by_name(self, path, name, **kwargs):
        """get_by_name method takes relative path to service as well as name
            and adds name to query param
        returns session's response object"""
        pool_obj = None
        path = self._get_api_path(path)
        params = kwargs.get('params', {})
        params.update({'name': name})
        resp = super(ApiSession, self).get(path, params=params, timeout=20,
                                       verify=False, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.get_object_by_name(path, name, **kwargs)
        if resp.status_code > 299:
            return pool_obj
        try:
            pool_obj = json.loads(resp.text)['results'][0]
        except IndexError:
            pool_obj = None
        self._update_session_last_used()
        return pool_obj

    def post(self, path, data=None, json_data=None, **kwargs):
        """post accepts relative path to service and data,json and kwargs as
            per session class post method
        returns session's response object"""
        path = self._get_api_path(path)
        resp = super(ApiSession, self).post(path, data=data, json=json_data,
                                        **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.post(path, data, json_data, **kwargs)
        self._update_session_last_used()
        return resp

    def put(self, path, data=None, **kwargs):
        """put accepts relative path to service with uuid data and kwargs as
            per session class put method
        returns session's response object"""
        path = self._get_api_path(path)
        resp = super(ApiSession, self).put(path, data=data, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.put(path, data, **kwargs)
        self._update_session_last_used()
        return resp

    def put_by_name(self, path, name, data=None, **kwargs):
        """put_by_name accepts relative path to service only and adds uuid by
            getting it from name
        returns session's response object"""
        uuid = self._get_uuid_by_name(path, name)
        path = self._get_api_path(path, uuid)
        resp = super(ApiSession, self).put(path, data=data, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.put_by_name(path, name, data, **kwargs)
        self._update_session_last_used()
        return resp

    def delete(self, path, **kwargs):
        """delete accepts relative path to service with uuid data kwargs as per
            session class delete method
        returns session's response object"""
        path = self._get_api_path(path)
        resp = super(ApiSession, self).delete(path, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.delete(path, **kwargs)
        self._update_session_last_used()
        return resp

    def delete_by_name(self, path, name, **kwargs):
        """delete_by_name accepts relative path to service only and adds uuid
            by getting it from name
        returns session's response object"""
        uuid = self._get_uuid_by_name(path, name)
        path = self._get_api_path(path, uuid)
        resp = super(ApiSession, self).delete(path, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.delete_by_name(path, name, **kwargs)
        self._update_session_last_used()
        return resp

    def get_obj_ref(self, obj):
        """returns reference url from dict object"""
        if isinstance(obj, Response):
            obj = json.loads(obj.text)
        if obj.get(0, None):
            return obj[0]['url']
        elif obj.get('url', None):
            return obj['url']
        elif obj.get('results', None):
            return obj['results'][0]['url']
        else:
            return None

    def get_obj_uuid(self, obj):
        """returns uuid from dict object"""
        if isinstance(obj, Response):
            obj = json.loads(obj.text)
        if obj.get(0, None):
            return obj[0]['uuid']
        elif obj.get('uuid', None):
            return obj['uuid']
        elif obj.get('results', None):
            return obj['results'][0]['uuid']
        else:
            return None

    def _get_api_path(self, path, uuid=None):
        """returns the full url from relative path and uuid"""
        if uuid:
            return self.prefix+'/api/'+path+'/'+uuid
        else:
            return self.prefix+'/api/'+path

    def _get_uuid_by_name(self, path, name):
        """gets object by name and service path and returns uuid"""
        resp = self.get_object_by_name(path, name)
        return self.get_obj_uuid(resp)

    def _update_session_last_used(self):
        ApiSession.sessionDict[self.username]["last_used"] = datetime.utcnow()

    @staticmethod
    def _clean_inactive_sessions():
        """Removes sessions which are inactive more than 20 min"""
        print "cleaning inactive sessions"
        print ApiSession.sessionDict
        for sess_dict in ApiSession.sessionDict.values():
            if (datetime.utcnow() - sess_dict["last_used"]).\
                    total_seconds() > 20*60:
                del ApiSession.sessionDict[sess_dict["api"].username]
                print "Removed session for :" + sess_dict["api"].username


class ApiSessionAdapter:
    adapter_args = {}
    api = None

    def __init__(self, api, tenant=None, headers=None, cookies=None,
                 hooks=None):
        self.api = api
        if headers:
            new_headers = copy.deepcopy(api.headers)
            new_headers.update(headers)
            self.adapter_args["headers"] = new_headers
        if cookies:
            new_cookies = copy.deepcopy(api.cookies)
            new_cookies.update(cookies)
            self.adapter_args["cookies"] = new_cookies
        if hooks:
            self.adapter_args["hooks"] = hooks
        if tenant:
            self.adapter_args["headers"].update({"X-Avi-Tenant": "%s" % tenant})
        return

    def get(self, path, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.get(path, **self.adapter_args)
        return resp

    def get_by_name(self, path, name, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.get_object_by_name(path, name, **self.adapter_args)
        return resp

    def post(self, path, data=None, json_data=None, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.post(path, data=data, json_data=json_data,
                             **self.adapter_args)
        return resp

    def put(self, path, data=None, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.put(path, data=data, **self.adapter_args)
        return resp

    def put_by_name(self, path, name, data=None, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.put_by_name(path, name, data=data, **self.adapter_args)
        return resp

    def delete(self, path, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.delete(path, **self.adapter_args)
        return resp

    def delete_by_name(self, path, name, **kwargs):
        self.adapter_args.update(kwargs)
        resp = self.api.delete_by_name(path, name, **self.adapter_args)
        return resp
