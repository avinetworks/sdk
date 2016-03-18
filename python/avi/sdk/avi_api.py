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
    """
    Extends the Request library's session object to provide helper
    utilities to work with Avi Controller like authentication, api massaging
    etc.
    """
    sessionDict = {}

    def __init__(self, controller_ip, username, password=None, token=None,
                 tenant=None, tenant_uuid=None):
        """
        initialize new session object with authenticated token from login api.
        It also keeps a cache of user sessions that are cleaned up if inactive
        for more than 20 mins.
        """
        super(ApiSession, self).__init__()
        self.controller_ip = controller_ip
        self.username = username
        self.password = password
        self.keystone_token = token
        self.tenant_uuid = tenant_uuid
        self.tenant = None
        if tenant:
            self.tenant = tenant
        elif not tenant_uuid:
            self.tenant = "admin"
        self.headers = {}
        self.prefix = (controller_ip if controller_ip.startswith('http')
                       else "https://%s" % controller_ip)

        try:
            user_session = ApiSession.sessionDict[username]["api"]
        except KeyError:
            logger.debug("Session does not exist creating new session for %s",
                         username)
            self.authenticate_session()
            ApiSession.sessionDict[username] = {"api": self,
                                                "last_used": datetime.utcnow()}
            user_session = self
        self.headers = copy.deepcopy(user_session.headers)
        if self.tenant:
            self.headers.update({"X-Avi-Tenant": "%s" % self.tenant})
        if self.tenant_uuid:
            self.headers.update({"X-Avi-Tenant-UUID": "%s" % self.tenant_uuid})
        self.cookies = user_session.cookies
        return

    @staticmethod
    def get_session(controller_ip, username, password=None, token=None,
                    tenant=None, tenant_uuid=None):
        """
        returns the session object for same user and tenant
        calls init if session dose not exist and adds it to session cache
        """
        try:
            user_session = ApiSession.sessionDict[username]["api"]
            if user_session.password != password:
                raise APIError("Authentication Failed")
            if user_session.tenant != tenant:
                raise APIError("Tenant doesn't match; use ApiSessionAdapter")
        except KeyError:
            logger.debug("Session does not exist creating new session for %s",
                         username)
            user_session = ApiSession(controller_ip, username, password,
                                      token=token, tenant=tenant,
                                      tenant_uuid=tenant_uuid)
            ApiSession.sessionDict[user_session.username] = \
                {"api": user_session, "last_used": datetime.utcnow()}
        ApiSession._clean_inactive_sessions()
        return user_session

    def reset_session(self):
        """
        resets and re-authenticates the current session.
        @param api: ApiSession object
        """
        logger.info('resetting session for %s', self.username)
        self.headers = {}
        self.authenticate_session()
        ApiSession._clean_inactive_sessions()

    def authenticate_session(self):
        """
        Performs session authentication with Avi controller and stores 
        session cookies and sets header options like tenant. 
        """
        body = {"username": self.username}
        if not self.keystone_token:
            body["password"] = self.password
        else:
            body["token"] = self.keystone_token

        logger.debug('authenticating user %s ', self.username)
        rsp = super(ApiSession, self).post(self.prefix+"/login", body,
                                           timeout=5, verify=False)
        if rsp.status_code != 200:
            raise Exception("Authentication failed: code %d: msg: %s", 
                            rsp.status_code, rsp.text)
        logger.debug("rsp cookies: %s", dict(rsp.cookies))
        self.headers.update({
            "X-CSRFToken": dict(rsp.cookies).get('csrftoken', ''),
            "Referer": self.prefix,
            "Content-Type": "application/json"
        })
        # switch to a different tenant if needed
        if self.tenant:
            self.headers.update({"X-Avi-Tenant": "%s" % self.tenant})
        elif self.tenant_uuid:
            self.headers.update({"X-Avi-Tenant-UUID": "%s" % self.tenant_uuid})
        logger.debug("authentication success for user %s with headers: %s", 
                     self.username, self.headers)
        return

    def get(self, path, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        @param path: takes relative path to the AVI api. 
        get method takes relative path to service and kwargs as per Session
            class get method
        returns session's response object 
        """
        fullpath = self._get_api_path(path)
        resp = super(ApiSession, self).get(fullpath, timeout=20, verify=False,
                                           **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.get(path, **kwargs)
        self._update_session_last_used()
        return resp

    def get_object_by_name(self, path, name, **kwargs):
        """
        Helper function to access Avi REST Objects using object 
        type and name. It behaves like python dictionary interface where it 
        returns None when the object is not present in the AviController.
        
        Internally, it transforms the request to api/path?name=<name>...
        
        @param path: relative path to service 
        @param name: name of the object
        
        returns dictionary object if successful else None
        """
        obj = None
        fullpath = self._get_api_path(path)
        params = kwargs.get('params', {})
        params.update({'name': name})
        resp = super(ApiSession, self).get(fullpath, params=params, timeout=20,
                                           verify=False, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.get_object_by_name(path, name, **kwargs)
        if resp.status_code > 299:
            return obj
        try:
            obj = json.loads(resp.text)['results'][0]
        except IndexError:
            obj = None
        self._update_session_last_used()
        return obj

    def post(self, path, data=None, json_data=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        @param path: takes relative path to the AVI api.It is modified by 
        the library to conform to AVI Controller's REST API interface
        returns session's response object
        """
        fullpath = self._get_api_path(path)
        resp = super(ApiSession, self).post(fullpath, data=data,
                                            json=json_data, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.post(path, data, json_data, **kwargs)
        self._update_session_last_used()
        return resp

    def put(self, path, data=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        @param path: takes relative path to the AVI api.It is modified by 
        the library to conform to AVI Controller's REST API interface
        returns session's response object
        """
        fullpath = self._get_api_path(path)
        resp = super(ApiSession, self).put(fullpath, data=data, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.put(path, data, **kwargs)
        self._update_session_last_used()
        return resp

    def put_by_name(self, path, name, data=None, **kwargs):
        """
        Helper function to perform HTTP PUT on Avi REST Objects using object 
        type and name. 
        
        Internally, it transforms the request to api/path?name=<name>...
        
        @param path: relative path to service 
        @param name: name of the object
        
        returns session's response object
        """
        uuid = self._get_uuid_by_name(path, name)
        fullpath = self._get_api_path(path, uuid)
        resp = super(ApiSession, self).put(fullpath, data=data, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.put_by_name(path, name, data, **kwargs)
        self._update_session_last_used()
        return resp

    def delete(self, path, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        @param path: takes relative path to the AVI api.It is modified by 
        the library to conform to AVI Controller's REST API interface
        returns session's response object
        """
        fullpath = self._get_api_path(path)
        resp = super(ApiSession, self).delete(fullpath, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.delete(path, **kwargs)
        self._update_session_last_used()
        return resp

    def delete_by_name(self, path, name, **kwargs):
        """
        Helper function to perform HTTP DELETE on Avi REST Objects using object 
        type and name.Internally, it transforms the request to 
        api/path?name=<name>...
        
        @param path: relative path to service 
        @param name: name of the object
        
        returns session's response object
        """

        uuid = self._get_uuid_by_name(path, name)
        fullpath = self._get_api_path(path, uuid)
        resp = super(ApiSession, self).delete(fullpath, **kwargs)
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
        if not resp:
            raise ObjectNotFound("%s/%s" % (path, name))
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
    """
    This is helper class that allows re-using an Avi ApiSession object with 
    different header options like tenant etc. ApiSessionAdapter is recommended 
    for use in situations like OpenStack LBASS Plugin or load balancer 
    Orchestration software that is automating load balancer function using 
    a common API user across different tenants and keeps AVI Controller session 
    active all the time. It also provides a convenience of not passing
    tenant or other headers with every API call.
    
    Usage Example:
    avi_ssn = ApiSession.get_session(controller_ip,username="admin",
                password="admin", tenant="admin")
    tenant_ssn =  ApiSessionAdapter(avi_ssn, tenant="tenant_A")
    # returns all vs from tenant A
    all_tenant_vs = tenant_ssn.get("virtualservice")

    Here is summary of usage behaviors when multiple adapters share an API 
    session 
    1. A common Session Library object is created and used.
    2. Single network connection to AVI Controller is used across the adapters
    sharing Avi ApiSession object.
    3. Any session timeout or re-authentication is done once across all the 
    Adapter instances.
    """
    adapter_args = {}
    api = None

    def __init__(self, api, tenant=None, tenant_uuid=None, headers=None,
                 cookies=None, hooks=None):
        """
        @param api: Avi ApiSession object
        Rest of the arguments are used for modifying API calls as per 
        Adapter settings.
        """
        self.api = api
        new_headers = copy.deepcopy(api.headers)
        if headers:
            new_headers.update(headers)
        self.adapter_args["headers"] = new_headers
        new_cookies = copy.deepcopy(api.cookies)
        if cookies:
            new_cookies.update(cookies)
        self.adapter_args["cookies"] = new_cookies
        if hooks:
            self.adapter_args["hooks"] = hooks
        if tenant:
            self.adapter_args["headers"].update({
                "X-Avi-Tenant": "%s" % tenant})
        elif tenant_uuid:
            self.adapter_args["headers"].update({
                "X-Avi-Tenant-UUID": "%s" % tenant_uuid})
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
