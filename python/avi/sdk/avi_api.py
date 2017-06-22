import os
import sys
import copy
import json
import logging
from datetime import datetime, timedelta
from requests import ConnectionError
from requests import Response
from requests.sessions import Session

logger = logging.getLogger(__name__)


def avi_timedelta(td):
    '''
    This is a wrapper class to workaround python 2.6 builtin datetime.timedelta
    does not have total_seconds method
    :param timedelta object
    '''
    if type(td) != timedelta:
        raise TypeError()
    if sys.version_info >= (2, 7):
        ts = td.total_seconds()
    else:
        ts = td.seconds + (24 * 3600 * td.days)
    return ts


def avi_sdk_syslog_logger(logger_name='avi.sdk'):
    # The following sets up syslog module to log underlying avi SDK messages
    # based on the environment variables:
    #   AVI_LOG_HANDLER: names the logging handler to use. Only syslog is
    #     supported.
    #   AVI_LOG_LEVEL: Logging level used for the avi SDK. Default is DEBUG
    #   AVI_SYSLOG_ADDRESS: Destination address for the syslog handler.
    #   Default is /dev/log
    from logging.handlers import SysLogHandler
    lf = '[%(asctime)s] %(levelname)s [' \
                        '%(module)s.%(funcName)s:%(lineno)d] %(message)s'
    log = logging.getLogger(logger_name)
    log_level = os.environ.get('AVI_LOG_LEVEL', 'DEBUG')
    if log_level:
        log.setLevel(getattr(logging, log_level))
    formatter = logging.Formatter(lf)
    sh = SysLogHandler(address=os.environ.get('AVI_SYSLOG_ADDRESS', '/dev/log'))
    sh.setFormatter(formatter)
    log.addHandler(sh)
    return log


class ObjectNotFound(Exception):
    pass


class APIError(Exception):
    def __init__(self, arg, rsp=None):
        self.args = [arg, rsp]
        self.rsp = rsp


class AviServerError(APIError):
    def __init__(self, arg, rsp=None):
        super(AviServerError, self).__init__(arg, rsp)


class APINotImplemented(Exception):
    pass


class ApiResponse(Response):
    """
    Returns copy of the requests.Response object provides additional helper
    routines
        1. obj: returns dictionary of Avi Object
    """
    def __init__(self, rsp):
        super(ApiResponse, self).__init__()
        for k, v in list(rsp.__dict__.items()):
            setattr(self, k, v)

    def json(self):
        """
        Extends the session default json interface to handle special errors
        and raise Exceptions
        returns the Avi object as a dictionary from rsp.text
        """
        if self.status_code in (200, 201):
            if not self.text:
                # In cases like status_code == 201 the response text could be
                # empty string.
                return None
            return super(ApiResponse, self).json()
        elif self.status_code == 204:
            # No response needed; e.g., delete operation
            return None
        elif self.status_code == 404:
            raise ObjectNotFound()
        elif self.status_code >= 500:
            raise AviServerError('HTTP Error: %d Error Msg %s' % (
                                    self.status_code, self.text), self)
        else:
            raise APIError('HTTP Error: %d Error Msg %s' % (
                    self.status_code, self.text), self)

    def count(self):
        """
        return the number of objects in the collection response. If it is not
        a collection response then it would simply return 1.
        """
        obj = self.json()
        if 'count' in obj:
            # this was a resposne to collection
            return obj['count']
        return 1

    @staticmethod
    def to_avi_response(resp):
        if type(resp) == Response:
            return ApiResponse(resp)
        return resp


class ApiSession(Session):
    """
    Extends the Request library's session object to provide helper
    utilities to work with Avi Controller like authentication, api massaging
    etc.
    """
    sessionDict = {}
    # This keeps track of the process which created the cache.
    # At anytime the pid of the process changes then it would create
    # a new cache for that process.
    AVI_SLUG = 'Slug'
    SESSION_CACHE_EXPIRY = 20*60
    SHARED_USER_HDRS = ['X-CSRFToken', 'Session-Id', 'Referer']
    MAX_API_RETRIES = 3

    def __init__(self, controller_ip, username, password=None, token=None,
                 tenant=None, tenant_uuid=None, verify=False, port=None,
                 timeout=60, api_version=None,
                 retry_conxn_errors=False):
        """
        initialize new session object with authenticated token from login api.
        It also keeps a cache of user sessions that are cleaned up if inactive
        for more than 20 mins.

        Notes:
        01. If mode is https and port is none or 443, we don't embed the
            port in the prefix. The prefix would be 'https://ip'. If port
            is a non-default value then we concatenate https://ip:port
            in the prefix.
        02. If mode is http and the port is none or 80, we don't embed the
            port in the prefix. The prefix would be 'http://ip'. If port is
            a non-default value, then we concatenate http://ip:port in
            the prefix.
        """
        super(ApiSession, self).__init__()
        self.controller_ip = controller_ip
        self.username = username
        self.password = password
        self.keystone_token = token
        self.tenant_uuid = tenant_uuid
        self.tenant = tenant if tenant else "admin"
        self.headers = {}
        self.verify = verify
        self.port = port
        self.key = controller_ip + ":" + username
        self.api_version = api_version
        self.retry_conxn_errors = retry_conxn_errors
        self.remote_api_version = {}

        # Refer Notes 01 and 02
        if controller_ip.startswith('http'):
            if port is None or port == 80:
                self.prefix = controller_ip
            else:
                self.prefix = '{x}:{y}'.format(x=controller_ip, y=port)
        else:
            if port is None or port == 443:
                self.prefix = 'https://{x}'.format(x=controller_ip)
            else:
                self.prefix = 'https://{x}:{y}'.format(x=controller_ip, y=port)
        self.timeout = timeout
        try:
            user_session = ApiSession.sessionDict[self.key]["api"]
        except KeyError:
            logger.debug("Session does not exist; Creating new session for %s",
                         self.key)
            self.authenticate_session()
            ApiSession.sessionDict[self.key] = \
                {"api": self, "last_used": datetime.utcnow()}
            user_session = self
        # don't save the tenant headers as it would interfere with the
        # individual method tenant overrides
        for hdr in self.SHARED_USER_HDRS:
            if hdr in user_session.headers:
                self.headers[hdr] = user_session.headers[hdr]
        self.cookies = user_session.cookies
        self.num_session_retries = 0
        self.pid = os.getpid()
        ApiSession._clean_inactive_sessions()
        return

    @staticmethod
    def get_session(controller_ip, username, password=None, token=None,
                    tenant=None, tenant_uuid=None, verify=False, port=None,
                    timeout=60, retry_conxn_errors=False, api_version=None):
        """
        returns the session object for same user and tenant
        calls init if session dose not exist and adds it to session cache
        :param controller_ip: controller IP address
        :param username:
        :param password:
        :param token: Token to use; example, a valid keystone token
        :param tenant: Name of the tenant on Avi Controller
        :param tenant_uuid: Don't specify tenant when using tenant_id
        :param port: Rest-API may use a different port other than 443
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param retry_conxn_errors: retry on connection errors
        :param api_version: Controller API version
        """
        key = controller_ip + ":" + username
        try:
            user_session = ApiSession.sessionDict[key]["api"]
            tenant = tenant if tenant else 'admin'
            if (user_session.password != password or
                    user_session.keystone_token != token or
                    user_session.tenant != tenant or
                    user_session.tenant_uuid != tenant_uuid or
                    user_session.api_version != api_version):
                logger.debug('Api Session auth credential mismatch %s', key)
                del ApiSession.sessionDict[key]
                user_session = None
        except KeyError:
            logger.debug("Session does not exist; Creating new session for %s",
                         key)
            user_session = None

        if not user_session:
            user_session = ApiSession(
                controller_ip, username, password, token=token, tenant=tenant,
                tenant_uuid=tenant_uuid, verify=verify, port=port,
                timeout=timeout, retry_conxn_errors=retry_conxn_errors,
                api_version=api_version)
            ApiSession.sessionDict[key] = \
                {"api": user_session, "last_used": datetime.utcnow()}
        ApiSession._clean_inactive_sessions()
        return user_session

    def reset_session(self):
        """
        resets and re-authenticates the current session.
        """
        logger.info('resetting session for %s', self.key)
        self.headers = {}
        self.authenticate_session()

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
                                           timeout=self.timeout)
        if rsp.status_code != 200:
            self.remote_api_version = {}
            raise Exception(
                "Authentication failed with code %d reason msg: %s" %
                (rsp.status_code, rsp.text))
        self.remote_api_version = rsp.json().get('version', {})
        logger.debug("rsp cookies: %s", dict(rsp.cookies))
        self.headers.update({
            "Referer": self.prefix,
            "Content-Type": "application/json"
        })
        if rsp.cookies and 'csrftoken' in rsp.cookies:
            csrftoken = rsp.cookies['csrftoken']
            self.headers.update({"X-CSRFToken": csrftoken})
            if self.key in ApiSession.sessionDict:
                cached_api = \
                    ApiSession.sessionDict[self.key]['api']
                cached_api.headers.update({"X-CSRFToken": csrftoken})
        logger.debug("authentication success for user %s with headers: %s",
                     self.username, self.headers)
        return

    def _get_api_headers(self, tenant, tenant_uuid, timeout, headers,
                         api_version):
        """
        returns the headers that are passed to the requests.Session api calls.
        """
        api_hdrs = copy.deepcopy(self.headers)
        api_hdrs['timeout'] = str(timeout)
        if api_version:
            api_hdrs['X-Avi-Version'] = api_version
        elif self.api_version:
            api_hdrs['X-Avi-Version'] = self.api_version
        if tenant:
            tenant_uuid = None
        elif tenant_uuid:
            tenant = None
        else:
            tenant = self.tenant
            tenant_uuid = self.tenant_uuid
        if tenant_uuid:
            api_hdrs.update({"X-Avi-Tenant-UUID": "%s" % tenant_uuid})
            api_hdrs.pop("X-Avi-Tenant", None)
        elif tenant:
            api_hdrs.update({"X-Avi-Tenant": "%s" % tenant})
            api_hdrs.pop("X-Avi-Tenant-UUID", None)
        if headers:
            # overwrite the headers passed via the API calls.
            api_hdrs.update(headers)
        return api_hdrs

    def _api(self, api_name, path, tenant, tenant_uuid, data=None,
             headers=None, timeout=None, api_version=None, **kwargs):
        """
        It calls the requests.Session APIs and handles session expiry
        and other situations where session needs to be reset.
        returns ApiResponse object
        :param path: takes relative path to the AVI api.
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param headers: dictionary of headers that override the session
            headers.
        """
        if self.pid != os.getpid():
            logger.info('pid %d change detected new %d. Closing session',
                        self.pid, os.getpid())
            self.close()
            self.pid = os.getpid()
        if timeout is None:
            timeout = self.timeout
        fullpath = self._get_api_path(path)
        fn = getattr(super(ApiSession, self), api_name)
        api_hdrs = \
            self._get_api_headers(tenant, tenant_uuid, timeout, headers,
                                  api_version)
        connection_error = False
        try:
            if (data is not None) and (type(data) == dict):
                resp = fn(fullpath, data=json.dumps(data), headers=api_hdrs,
                          timeout=timeout, **kwargs)
            else:
                resp = fn(fullpath, data=data, headers=api_hdrs,
                          timeout=timeout, **kwargs)
        except ConnectionError as e:
            logger.warning('Connection error retrying %s', e)
            if not self.retry_conxn_errors:
                raise
            connection_error = True
        except Exception as e:
            logger.error('Error in Requests library %s', e)
            raise
        if not connection_error:
            logger.debug(
                'path: %s http_method: %s hdrs: %s params: %s data: %s rsp: %s',
                fullpath, api_name.upper(), api_hdrs, kwargs, data, resp.text)
        if connection_error or resp.status_code in (401, 419):
            if connection_error:
                logger.warning('Connection failed, retrying.')
            else:
                logger.info('received error %d %s so resetting connection',
                            resp.status_code, resp.text)
            ApiSession.reset_session(self)
            self.num_session_retries += 1
            if self.num_session_retries > self.MAX_API_RETRIES:
                # Added this such that any code which re-tries can succeed
                # eventually.
                self.num_session_retries = 0
                raise APIError(
                    "giving up after %d retries connection failure %s" %
                    (self.MAX_API_RETRIES, connection_error))
            # should restore the updated_hdrs to one passed down
            resp = self._api(api_name, path, tenant, tenant_uuid, data,
                             headers=headers, api_version=api_version,
                             timeout=timeout, **kwargs)
            self.num_session_retries = 0

        if resp.cookies and 'csrftoken' in resp.cookies:
            csrftoken = resp.cookies['csrftoken']
            self.headers.update({"X-CSRFToken": csrftoken})
        self._update_session_last_used()
        return ApiResponse.to_avi_response(resp)

    def get(self, path, tenant='', tenant_uuid='', timeout=None, params=None,
            api_version=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        :param path: takes relative path to the AVI api.
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        get method takes relative path to service and kwargs as per Session
            class get method
        returns session's response object
        """
        return self._api('get', path, tenant, tenant_uuid, timeout=timeout,
                         params=params, api_version=api_version, **kwargs)

    def get_object_by_name(self, path, name, tenant='', tenant_uuid='',
                           timeout=None, params=None, api_version=None,
                           **kwargs):
        """
        Helper function to access Avi REST Objects using object
        type and name. It behaves like python dictionary interface where it
        returns None when the object is not present in the AviController.
        Internally, it transforms the request to api/path?name=<name>...
        :param path: relative path to service
        :param name: name of the object
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns dictionary object if successful else None
        """
        obj = None
        if not params:
            params = {}
        params['name'] = name
        resp = self.get(path, tenant, tenant_uuid, timeout=timeout,
                        params=params, api_version=api_version, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self)
            resp = self.get_object_by_name(
                    path, name, tenant, tenant_uuid, timeout=timeout,
                    params=params, **kwargs)
        if resp.status_code > 299:
            return obj
        try:
            obj = resp.json()['results'][0]
        except IndexError:
            obj = None
        self._update_session_last_used()
        return obj

    def post(self, path, data=None, tenant='', tenant_uuid='', timeout=None,
             force_uuid=None, params=None, api_version=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        :param path: takes relative path to the AVI api.It is modified by
        the library to conform to AVI Controller's REST API interface
        :param data: dictionary of the data. Support for json string
            is deprecated
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        if force_uuid is not None:
            headers = kwargs.get('headers', {})
            headers[self.AVI_SLUG] = force_uuid
            kwargs['headers'] = headers
        return self._api('post', path, tenant, tenant_uuid, data=data,
                         timeout=timeout, params=params,
                         api_version=api_version, **kwargs)

    def put(self, path, data=None, tenant='', tenant_uuid='',
            timeout=None, params=None, api_version=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        :param path: takes relative path to the AVI api.It is modified by
            the library to conform to AVI Controller's REST API interface
        :param data: dictionary of the data. Support for json string
            is deprecated
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        return self._api('put', path, tenant, tenant_uuid, data=data,
                         timeout=timeout, params=params,
                         api_version=api_version, **kwargs)

    def patch(self, path, data=None, tenant='', tenant_uuid='',
              timeout=None, params=None, api_version=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        :param path: takes relative path to the AVI api.It is modified by
            the library to conform to AVI Controller's REST API interface
        :param data: dictionary of the data. Support for json string
            is deprecated
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        return self._api('patch', path, tenant, tenant_uuid, data=data,
                         timeout=timeout, params=params,
                         api_version=api_version, **kwargs)

    def put_by_name(self, path, name, data=None, tenant='',
                    tenant_uuid='', timeout=None, params=None,
                    api_version=None, **kwargs):
        """
        Helper function to perform HTTP PUT on Avi REST Objects using object
        type and name.
        Internally, it transforms the request to api/path?name=<name>...
        :param path: relative path to service
        :param name: name of the object
        :param data: dictionary of the data. Support for json string
            is deprecated
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        uuid = self._get_uuid_by_name(path, name, tenant, tenant_uuid)
        path = '%s/%s' % (path, uuid)
        return self.put(path, data, tenant, tenant_uuid, timeout=timeout,
                        params=params, api_version=api_version, **kwargs)

    def delete(self, path, tenant='', tenant_uuid='', timeout=None, params=None,
               data=None, api_version=None, **kwargs):
        """
        It extends the Session Library interface to add AVI API prefixes,
        handle session exceptions related to authentication and update
        the global user session cache.
        :param path: takes relative path to the AVI api.It is modified by
        the library to conform to AVI Controller's REST API interface
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param data: dictionary of the data. Support for json string
            is deprecated
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        return self._api('delete', path, tenant, tenant_uuid, data=data,
                         timeout=timeout, params=params,
                         api_version=api_version, **kwargs)

    def delete_by_name(self, path, name, tenant='', tenant_uuid='',
                       timeout=None, params=None, api_version=None, **kwargs):
        """
        Helper function to perform HTTP DELETE on Avi REST Objects using object
        type and name.Internally, it transforms the request to
        api/path?name=<name>...
        :param path: relative path to service
        :param name: name of the object
        :param tenant: overrides the tenant used during session creation
        :param tenant_uuid: overrides the tenant or tenant_uuid during session
            creation
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param params: dictionary of key value pairs to be sent as query
            parameters
        :param api_version: overrides x-avi-header in request header during
            session creation
        returns session's response object
        """
        uuid = self._get_uuid_by_name(path, name, tenant, tenant_uuid)
        if not uuid:
            raise ObjectNotFound("%s/?name=%s" % (path, name))
        path = '%s/%s' % (path, uuid)
        return self.delete(path, tenant, tenant_uuid, timeout=timeout,
                           params=params, api_version=api_version, **kwargs)

    def get_obj_ref(self, obj):
        """returns reference url from dict object"""
        if not obj:
            return None
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
        if not obj:
            raise ObjectNotFound()
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
        """
        This function returns the full url from relative path and uuid.
        """
        if uuid:
            return self.prefix+'/api/'+path+'/'+uuid
        else:
            return self.prefix+'/api/'+path

    def _get_uuid_by_name(self, path, name, tenant='admin', tenant_uuid=''):
        """gets object by name and service path and returns uuid"""
        resp = self.get_object_by_name(path, name, tenant, tenant_uuid)
        if not resp:
            raise ObjectNotFound("%s/%s" % (path, name))
        return self.get_obj_uuid(resp)

    def _update_session_last_used(self):
        if self.key in ApiSession.sessionDict:
            ApiSession.sessionDict[self.key]["last_used"] = \
                datetime.utcnow()
        else:
            ApiSession.sessionDict[self.key] = \
                {'api': self, 'last_used': datetime.utcnow()}

    @staticmethod
    def _clean_inactive_sessions():
        """Removes sessions which are inactive more than 20 min"""
        session_cache = ApiSession.sessionDict
        logger.debug("cleaning inactive sessions in pid %d num elem %d",
                     os.getpid(), len(session_cache))
        keys_to_delete = []
        for key, session in list(session_cache.items()):
            tdiff = avi_timedelta(session["last_used"] - datetime.utcnow())
            if tdiff < ApiSession.SESSION_CACHE_EXPIRY:
                continue
            keys_to_delete.append(key)
        for key in keys_to_delete:
            del session_cache[key]
            logger.debug("Removed session for : %s", key)

    def delete_session(self):
        """ Removes the session for cleanup"""
        logger.debug("Removed session for : %s", self.key)
        ApiSession.sessionDict.pop(self.key, None)
        return
# End of file
