from avi.sdk.avi_api import *
import requests
import re
import urllib
import urlparse

logger = logging.getLogger(__name__)


def get_idp_class(idp):
    """
    Returns specific IDP class as
    per the idp input.
    :param idp: IDP type such as okta, onelogin, etc
    :param args:
    :param kwargs:
    :return: idp class
    """
    if not idp:
        logger.error("Please provide IDP name.")
        raise StandardError("Please provide IDP name")
    if str(idp).lower() == "okta":
        return OktaSAMLApiSession
    if str(idp).lower() == "onelogin":
        return OneloginSAMLApiSession


class SAMLApiSession(object):
    """
    This creates corresponding IDP class as per the idp input
    and implement SAML authentication and create controller session.
    """
    # At runtime creates a specific IDP class object
    # before initialization
    def __new__(cls, *args, **kwargs):
        idp = kwargs.get("idp", None)
        idp_class = get_idp_class(idp)
        return idp_class(*args, **kwargs)

    @staticmethod
    def get_session(controller_ip=None, username=None, password=None,
                    tenant=None, tenant_uuid=None,
                    verify=False, port=None, timeout=60,
                    api_version=None, retry_conxn_errors=True,
                    data_log=False, avi_credentials=None,
                    session_id=None, csrftoken=None,
                    lazy_authentication=False,
                    max_api_retries=None, idp_cookies=None,
                    idp=None):
        """
        returns the SAML session object for user.
        This overrides the get session method of ApiSession class.

        :param controller_ip: controller IP address
        :param username: SAML IDP username
        :param password: IDP password
        :param tenant: Name of the tenant on Avi Controller
        :param tenant_uuid: Don't specify tenant when using tenant_id
        :param verify: SSL verification for https requests
        :param port: Rest-API may use a different port other than 443
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param api_version: Controller API version
        :param retry_conxn_errors:
        :param data_log: datalog
        :param avi_credentials: Avi Credential objects
        :param session_id: Session ID
        :param csrftoken: CSRF Token
        :param lazy_authentication: Lazy_authentication
        :param max_api_retries: Maximum number of retries to REST API
        :param idp_cookies: IDP Cookies
        :param idp: Type of IDP. eg. okta, onelogin, pingfed, etc
        :return: Controller Session after successful SAML authentication with IDP.
        """
        idp_cls = get_idp_class(idp)
        saml_session = idp_cls.get_session(
            controller_ip=controller_ip,
            username=username,
            password=password,
            tenant=tenant,
            tenant_uuid=tenant_uuid,
            verify=verify,
            port=port,
            timeout=timeout,
            api_version=api_version,
            retry_conxn_errors=retry_conxn_errors,
            data_log=data_log,
            avi_credentials=avi_credentials,
            session_id=session_id,
            csrftoken=csrftoken,
            lazy_authentication=lazy_authentication,
            max_api_retries=max_api_retries,
            idp_cookies=idp_cookies,
            idp=idp)
        return saml_session


class OneloginSAMLApiSession(ApiSession):
    """"
        Extends the ApiSession class to override authentication
        method and provide helper utilities to work with Avi
        Controller and IDPs like onelogin, okta, etc.
    """

    SAML_URL_SUFFIX = "/sso/login"

    def __init__(self, controller=None, username=None, password=None,
                 tenant=None, tenant_uuid=None, verify=False,
                 port=None, timeout=60, api_version=None,
                 retry_conxn_errors=True, data_log=False,
                 avi_credentials=None, session_id=None, csrftoken=None,
                 lazy_authentication=False, max_api_retries=None,
                 idp_cookies=None, idp=None):
        self.idp_cookies = idp_cookies
        self.idp = idp
        ApiSession.__init__(self, controller, username, password, None,
                            tenant, tenant_uuid, verify,
                            port, timeout, api_version,
                            retry_conxn_errors, data_log,
                            avi_credentials, session_id, csrftoken,
                            lazy_authentication, max_api_retries)

        return

    @staticmethod
    def get_session(
            controller_ip=None, username=None, password=None,
            tenant=None, tenant_uuid=None, verify=False, port=None,
            timeout=60, api_version=None, retry_conxn_errors=True,
            data_log=False, avi_credentials=None, session_id=None,
            csrftoken=None, lazy_authentication=False,
            max_api_retries=None, idp_cookies=None, idp=None):
        """
        returns the session object for same user and tenant
        calls init if session dose not exist and adds it to session cache
        :param controller_ip: Controller Ip
        :param username: IDP username
        :param password: IDP password
        :param verify: Verify SSL boolean flag
        :param tenant: Name of the tenant on Avi Controller
        :param tenant_uuid: Don't specify tenant when using tenant_id
        :param port: Rest-API may use a different port other than 443
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param retry_conxn_errors: retry on connection errors
        :param api_version: Controller API version
        :param idp_cookies: Identity Provider cookies.
        :param idp: IDP name such as  onelogin, okta, etc
        """
        if not avi_credentials:
            tenant = tenant if tenant else "admin"
            avi_credentials = AviCredentials(controller=controller_ip,
                                             username=username,
                                             password=password,
                                             api_version=api_version,
                                             tenant=tenant,
                                             tenant_uuid=tenant_uuid,
                                             port=port,
                                             timeout=timeout,
                                             session_id=session_id,
                                             csrftoken=csrftoken)
        k_port = avi_credentials.port if avi_credentials.port else 443
        if avi_credentials.controller.startswith('http'):
            k_port = 80 if not avi_credentials.port else k_port
        key = '%s:%s:%s' % (avi_credentials.controller,
                            avi_credentials.username, k_port)
        cached_session = sessionDict.get(key)
        if cached_session:
            user_session = cached_session['api']
            if not (user_session.avi_credentials.csrftoken or
                    lazy_authentication):
                user_session.authenticate_session()
        else:
            user_session = OneloginSAMLApiSession(
                controller=controller_ip, username=username,
                password=password,
                tenant=tenant, tenant_uuid=tenant_uuid,
                verify=verify, port=port, timeout=timeout,
                retry_conxn_errors=retry_conxn_errors,
                api_version=api_version, data_log=data_log,
                avi_credentials=avi_credentials,
                lazy_authentication=lazy_authentication,
                max_api_retries=max_api_retries,
                idp_cookies=idp_cookies,
            )
        return user_session

    def saml_assertion(self, username, password):
        """
        Perform SAML request from controller to IDPs.
        Establish session with controller and IDP.
        Assert SAML request url into the response header.
        :return: controller session and IDP response
        """

        err = None
        resp = None
        saml_request_regex = r'<input type=\"hidden\" ' \
                             r'name=\"SAMLRequest\" value=\"(.*?)\"'
        relay_state_regex = r'<input type=\"hidden\" ' \
                            r'name=\"RelayState\" value=\"(.*?)\"'
        assertion_url_regex = r'<form method=\"post\" action=\"(.*?)\">'

        # Getting controller session
        controller_session = requests.Session()
        controller_session.verify = False
        try:
            saml_controller_url = self.prefix + self.SAML_URL_SUFFIX
            resp = controller_session.get(saml_controller_url,
                                          allow_redirects=True)
        except Exception as e:
            logger.error("Error for controller SSO login URL. %s",
                         str(e.message))
            err = APIError('Status Code %s msg %s' % (
                resp.status_code, resp.text), resp)
            raise StandardError(err)
        # Getting IDP session
        idp_session = requests.Session()
        saml_request_match = re.search(saml_request_regex, resp.text,
                                       re.M | re.S)
        if not saml_request_match:
            err = "SAML request not generated by controller."
            logger.error("SAML request not generated by controller.")
            raise StandardError(err)
        saml_request = saml_request_match.group(1)
        relay_state = re.search(relay_state_regex, resp.text,
                                re.M | re.S).group(1)
        assertion_url = re.search(assertion_url_regex, resp.text,
                                  re.M | re.S).group(1)
        headers = {'Content-Type': 'application/x-www-form-urlencoded'}
        saml_data = urllib.urlencode({
            'SAMLRequest': saml_request,
            'RelayState': relay_state})
        if self.idp_cookies:
            logger.info("Controller generated SAML request is being "
                        "sent to IDP with existing IDP cookies.")
            try:
                resp = idp_session.post(assertion_url, headers=headers,
                                        data=saml_data, allow_redirects=False,
                                        cookies=self.idp_cookies)
            except Exception as e:
                logger.error("Error No SAML response from IDP %s",
                             str(e.message))
                err = APIError("Error No SAML response from IDP. "
                               "Status Code %s msg %s" % (resp.status_code,
                                                          resp.text), resp)
                raise StandardError(err)
        else:
            try:
                idp_resp = idp_session.post(assertion_url, headers=headers,
                                            data=saml_data,
                                            allow_redirects=False)
            except Exception as e:
                logger.error("Error No SAML response from IDP %s",
                             str(e.message))
                err = APIError("Error No SAML response from IDP. "
                               "Status Code %s msg %s" % (resp.status_code,
                                                          resp.text), resp)
                raise StandardError(err)
        if "SAMLResponse" not in idp_resp.text:
            try:
                redirect_url = idp_resp.headers['Location']
                try:
                    idp_resp = idp_session.get(redirect_url,
                                               allow_redirects=False)
                except Exception as e:
                    logger.error("Error for response from url %s %s",
                                 (redirect_url, str(e.message)))
                    err = APIError("Error for response from url %s "
                                   "Status Code %s msg %s"
                                   % (redirect_url,
                                      idp_resp.status_code,
                                      idp_resp.text), idp_resp)
                    raise StandardError(err)
                query_string = idp_resp.headers['Location'].split('=')[1]
                data = {"return": query_string}
                json_data = json.dumps(data)
                headers = {'content-type': 'application/json'}
                parsed_uri = urlparse.urlparse(assertion_url)
                # This needs to be modified for other IDPs.
                auth_url = "{}://{}/access/auth".format(parsed_uri.scheme,
                                                        parsed_uri.netloc)
                try:
                    resp = idp_session.post(auth_url, headers=headers,
                                            data=json_data)
                except Exception as e:
                    logger.error("Error for response from url %s %s",
                                 (auth_url, str(e.message)))
                    err = APIError("Error for response from url %s "
                                   "Status Code %s msg %s"
                                   % (auth_url,
                                      resp.status_code,
                                      resp.text), resp)
                    raise StandardError(err)
                # credentials payload for given IDP
                credentials_tuple = [('username', 'login',
                                      username),
                                     ('password', 'password',
                                      password)]
                for state in credentials_tuple:
                    bearer = "Bearer " + resp.text.split('jwt":"')[1][:-3]
                    headers = {'content-type': 'application/json',
                               'authorization': bearer}
                    user_data = {'state': state[0],
                                 'payload': {state[1]: state[2]}}
                    json_data = json.dumps(user_data)
                    try:
                        resp = idp_session.put(auth_url, headers=headers,
                                               data=json_data)
                    except Exception as e:
                        logger.error("Error for response from url %s %s",
                                     (auth_url, str(e.message)))
                        err = APIError("Error for response from url %s "
                                       "Status Code %s msg %s"
                                       % (auth_url,
                                          resp.status_code,
                                          resp.text), resp)
                        raise StandardError(err)

                data = json.loads(resp.text)
                try:
                    token = data["request"]["params"]
                    ["saml_request_params_token"]
                except KeyError:
                    raise StandardError("Couldn't complete "
                                        "authentication with IDP")
                url = data["request"]["uri"]
                params = {'saml_request_params_token': token}
                try:
                    resp = idp_session.get(url, params=params)
                except Exception as e:
                    logger.error("Error for response from url %s %s",
                                 (url, str(e.message)))
                    err = APIError("Error for response from url %s "
                                   "Status Code %s msg %s"
                                   % (url, resp.status_code,
                                      resp.text), resp)
                    raise StandardError(err)
            except Exception as e:
                logger.error("SAML authentication failed with msg: ",
                             (str(e.message)))
                msg = "saml authentication failed with msg: " \
                      + str(e.message)
                raise StandardError(msg)
        return controller_session, resp

    def authenticate_session(self):
        """
        Performs session SAML authentication with Avi controller
        and IDPs. Stores session cookies and sets header.
        """

        saml_response_regex = r'<input type=\"hidden\" ' \
                              r'name=\"SAMLResponse\" value=\"(.*?)\"'
        relay_state_regex = r'<input type=\"hidden\" ' \
                            r'name=\"RelayState\" value=\"(.*?)\"'
        assertion_url_regex = r'<form method=\"post\" ' \
                              r'action=\"(.*?)\">'
        username = self.avi_credentials.username
        if self.avi_credentials.password:
            password = self.avi_credentials.password
        else:
            raise APIError("No user password provided")
        logger.debug('authenticating user %s prefix %s',
                     self.avi_credentials.username, self.prefix)
        self.cookies.clear()
        try:
            # Assert SAML response
            controller_session, resp = self.saml_assertion(username, password)
            try:
                content = resp.text
                saml_response_match = re.search(saml_response_regex, content,
                                                re.M | re.S)
                saml_response = saml_response_match.group(1)
                relay_state = re.search(relay_state_regex, content, re.M |
                                        re.S).group(1)
                assertion_url = re.search(assertion_url_regex, content, re.M |
                                          re.S).group(1)
                saml_data = urllib.urlencode([
                    ('SAMLResponse', saml_response),
                    ('RelayState', relay_state)])
                headers = {'Content-Type': 'application/x-www-form-urlencoded'}
                try:
                    rsp = controller_session.post(assertion_url,
                                                  headers=headers,
                                                  data=saml_data,
                                                  )
                except Exception as e:
                    logger.error("SAML authentication on controller url "
                                 "%S failed with msg: %s",
                                 (assertion_url, str(e.message)))
                    msg = "SAML authentication on controller failed " \
                          "with msg: " + str(e.message)
                    raise StandardError(msg)
            except Exception as e:
                msg = "SAML authentication failed with msg: " + str(e.message)
                raise StandardError(msg)
            if rsp.status_code == 200:
                self.num_session_retries = 0
                self.remote_api_version = \
                    rsp.headers.get('AVI_API_VERSION', {})
                self.headers.update(self.user_hdrs)
                if rsp.cookies and 'csrftoken' in rsp.cookies:
                    sessionDict[self.key] = {
                        'csrftoken': rsp.cookies['csrftoken'],
                        'session_id': rsp.cookies['sessionid'],
                        'last_used': datetime.utcnow(),
                        'api': self,
                        'connected': True
                    }
                logger.debug("authentication success for user %s",
                             self.avi_credentials.username)
                return
            # Check for bad request and invalid credentials response code
            elif rsp.status_code in [401, 403]:
                logger.error('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text))
                err = APIError('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text), rsp)
                raise err
            else:
                logger.error("Error status code %s msg %s", rsp.status_code,
                             rsp.text)
                err = APIError('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text), rsp)
        except (ConnectionError, SSLError, ChunkedEncodingError) as e:
            if not self.retry_conxn_errors:
                raise
            logger.warning('Connection error retrying %s', e)
            err = e
        # comes here only if there was either exception or login was not
        # successful
        if self.retry_wait_time:
            time.sleep(self.retry_wait_time)
        self.num_session_retries += 1
        if self.num_session_retries > self.max_session_retries:
            self.num_session_retries = 0
            logger.error("Giving up after %d retries connection failure %s" % (
                self.max_session_retries, True))
            raise err
        self.authenticate_session()
        return


class OktaSAMLApiSession(ApiSession):
    """"
        Extends the Request library's session object to provide helper
        utilities to work with Avi Controller like SAML authentication,
        api massaging
        etc.
    """

    SAML_URL_SUFFIX = "/sso/login"

    def __init__(self, controller=None, username=None, password=None,
                 tenant=None, tenant_uuid=None, verify=False,
                 port=None, timeout=60, api_version=None,
                 retry_conxn_errors=True, data_log=False,
                 avi_credentials=None, session_id=None, csrftoken=None,
                 lazy_authentication=False, max_api_retries=None,
                 idp_cookies=None, idp=None):
        self.idp_cookies = idp_cookies
        self.idp = idp
        ApiSession.__init__(self, controller, username, password, None,
                            tenant, tenant_uuid, verify,
                            port, timeout, api_version,
                            retry_conxn_errors, data_log,
                            avi_credentials, session_id, csrftoken,
                            lazy_authentication, max_api_retries)
        return

    @staticmethod
    def get_session(
            controller_ip=None, username=None, password=None,
            tenant=None, tenant_uuid=None, verify=False, port=None,
            timeout=60, api_version=None, retry_conxn_errors=True,
            data_log=False, avi_credentials=None, session_id=None,
            csrftoken=None, lazy_authentication=False,
            max_api_retries=None, idp_cookies=None, idp=None):
        """
        returns the session object for same user and tenant
        calls init if session dose not exist and adds it to session cache
        :param controller_ip: Controller Ip
        :param username: IDP username
        :param password: IDP password
        :param verify: Verify SSL boolean flag
        :param tenant: Name of the tenant on Avi Controller
        :param tenant_uuid: Don't specify tenant when using tenant_id
        :param port: Rest-API may use a different port other than 443
        :param timeout: timeout for API calls; Default value is 60 seconds
        :param retry_conxn_errors: retry on connection errors
        :param api_version: Controller API version
        :param idp_cookies: Identity Provider cookies.
        :param idp: IDP name such as onelogin, okta, etc
        """
        if not avi_credentials:
            tenant = tenant if tenant else "admin"
            avi_credentials = AviCredentials(controller=controller_ip,
                                             username=username,
                                             password=password,
                                             api_version=api_version,
                                             tenant=tenant,
                                             tenant_uuid=tenant_uuid,
                                             port=port,
                                             timeout=timeout,
                                             session_id=session_id,
                                             csrftoken=csrftoken)
        k_port = avi_credentials.port if avi_credentials.port else 443
        if avi_credentials.controller.startswith('http'):
            k_port = 80 if not avi_credentials.port else k_port
        key = '%s:%s:%s' % (avi_credentials.controller,
                            avi_credentials.username, k_port)
        cached_session = sessionDict.get(key)
        if cached_session:
            user_session = cached_session['api']
            if not (user_session.avi_credentials.csrftoken or
                    lazy_authentication):
                user_session.authenticate_session()
        else:
            user_session = OktaSAMLApiSession(
                controller=controller_ip, username=username, password=password,
                tenant=tenant, tenant_uuid=tenant_uuid,
                verify=verify, port=port, timeout=timeout,
                retry_conxn_errors=retry_conxn_errors,
                api_version=api_version, data_log=data_log,
                avi_credentials=avi_credentials,
                lazy_authentication=lazy_authentication,
                max_api_retries=max_api_retries,
                idp_cookies=idp_cookies,
            )
        return user_session

    def saml_assertion(self, username, password):
        """
        Perform SAML request from controller to IDPs.
        Establish session with controller and IDP.
        Assert SAML request url into the response header.
        :return:
        """
        err = None
        resp = None
        saml_request_regex = r'<input type=\"hidden\" ' \
                             r'name=\"SAMLRequest\" value=\"(.*?)\"'
        relay_state_regex = r'<input type=\"hidden\" ' \
                            r'name=\"RelayState\" value=\"(.*?)\"'
        assertion_url_regex = r'<form method=\"post\" action=\"(.*?)\">'
        # Getting controller session
        controller_session = requests.Session()
        controller_session.verify = False
        try:
            saml_controller_url = self.prefix + self.SAML_URL_SUFFIX
            resp = controller_session.get(saml_controller_url,
                                          allow_redirects=True)
        except Exception as e:
            logger.error("Error for controller SSO login URL. %s",
                         str(e.message))
            err = APIError('Status Code %s msg %s' % (
                resp.status_code, resp.text), resp)
            raise StandardError(err)
        saml_request_match = re.search(saml_request_regex, resp.text,
                                       re.M | re.S)
        if not saml_request_match:
            err = "SAML request not generated by controller."
            logger.error("SAML request not generated by controller.")
            raise StandardError(err)
        saml_request = saml_request_match.group(1)
        relay_state = re.search(relay_state_regex, resp.text,
                                re.M | re.S).group(1)
        assertion_url = re.search(assertion_url_regex, resp.text,
                                  re.M | re.S).group(1)

        idp_session = requests.Session()
        idp_session.verify = False
        saml_data = urllib.urlencode({
            'SAMLRequest': saml_request,
            'RelayState': relay_state})
        parsed_uri = urlparse.urlparse(assertion_url)
        base_url = "{}://{}".format(parsed_uri.scheme, parsed_uri.netloc)
        if self.idp_cookies:
            logger.info("Controller generated SAML request is being "
                        "sent to IDP with existing IDP cookies.")
            try:
                resp = idp_session.get(assertion_url, allow_redirects=False,
                                       cookies=self.idp_cookies)
            except Exception as e:
                logger.error("Error No SAML response from IDP %s",
                             str(e.message))
                err = APIError("Error No SAML response from IDP. "
                               "Status Code %s msg %s" % (resp.status_code,
                                                          resp.text), resp)
                raise StandardError(err)
        else:
            try:
                resp = idp_session.get(assertion_url, allow_redirects=False)
            except Exception as e:
                logger.error("Error No SAML response from IDP %s",
                             str(e.message))
                err = APIError("Error No SAML response from IDP. "
                               "Status Code %s msg %s" % (resp.status_code,
                                                          resp.text), resp)
                raise StandardError(err)
        if "SAMLResponse" not in resp.text:
            try:
                user_data = {"username": username,
                             "options": {"warnBeforePasswordExpired": True,
                                         "multiOptionalFactorEnroll": True},
                             "password": password}
                json_data = json.dumps(user_data)
                headers = {'content-type': 'application/json'}
                resp = idp_session.post(base_url + "/api/v1/authn",
                                        headers=headers,
                                        data=json_data)
                data = json.loads(resp.text)
                try:
                    token = data["sessionToken"]
                except KeyError:
                    raise StandardError("Couldn't complete authentication "
                                        "with IDP")
                new_url = base_url + "/login/sessionCookieRedirect"
                redirect_url = "{}?{}".format(assertion_url, saml_data)
                params = {'checkAccountSetupComplete': 'true',
                          'token': token,
                          'redirectUrl': redirect_url}
                resp = idp_session.get(new_url, params=params,
                                       allow_redirects=True)
            except Exception as e:
                msg = "SAML authentication failed with msg: " + \
                      str(e.message)
                raise StandardError(msg)
        return controller_session, resp

    def authenticate_session(self):
        """
        Performs session SAML authentication with Avi controller
        and IDPs. Stores session cookies and sets header.
        """

        saml_response_regex = r'<input name=\"SAMLResponse\" ' \
                              r'type=\"hidden\" value=\"(.*?)\"'
        relay_state_regex = r'<input name=\"RelayState\" ' \
                            r'type=\"hidden\" value=\"(.*?)\"'
        assertion_url_regex = r'<form id=\"appForm\" ' \
                              r'action=\"(.*?)\" method=\"post\">'
        username = self.avi_credentials.username
        if self.avi_credentials.password:
            password = self.avi_credentials.password
        else:
            raise APIError("No user password provided")
        logger.debug('authenticating user %s prefix %s',
                     self.avi_credentials.username, self.prefix)
        self.cookies.clear()
        try:
            # Assert SAML response
            controller_session, resp = self.saml_assertion(username, password)
            try:
                content = resp.text
                saml_response_match = re.search(saml_response_regex,
                                                content, re.M | re.S)
                saml_response = saml_response_match.group(1)
                assertion_url = re.search(assertion_url_regex, content,
                                          re.M | re.S |
                                          re.IGNORECASE).group(1)
                relay_state = re.search(relay_state_regex, content,
                                        re.M | re.S).group(1)
                from HTMLParser import HTMLParser
                parser = HTMLParser()
                assertion_url = parser.unescape(assertion_url)
                saml_response = parser.unescape(saml_response)
                saml_data = urllib.urlencode([
                    ('SAMLResponse', saml_response),
                    ('RelayState', relay_state)])
                headers = {'Content-Type': 'application/x-www-form-urlencoded'}
                rsp = controller_session.post(assertion_url,
                                              headers=headers,
                                              data=saml_data,
                                              allow_redirects=True)
            except Exception as e:
                msg = "SAML authentication failed with msg: " + str(e.message)
                raise StandardError(msg)
            if rsp.status_code == 200:
                self.num_session_retries = 0
                self.remote_api_version = \
                    rsp.headers.get('AVI_API_VERSION', {})
                self.headers.update(self.user_hdrs)
                if rsp.cookies and 'csrftoken' in rsp.cookies:
                    sessionDict[self.key] = {
                        'csrftoken': rsp.cookies['csrftoken'],
                        'session_id': rsp.cookies['sessionid'],
                        'last_used': datetime.utcnow(),
                        'api': self,
                        'connected': True
                    }
                logger.debug("authentication success for user %s",
                             self.avi_credentials.username)
                return
            # Check for bad request and invalid credentials response code
            elif rsp.status_code in [401, 403]:
                logger.error('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text))
                err = APIError('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text), rsp)
                raise err
            else:
                logger.error("Error status code %s msg %s", rsp.status_code,
                             rsp.text)
                err = APIError('Status Code %s msg %s' % (
                    rsp.status_code, rsp.text), rsp)
        except (ConnectionError, SSLError, ChunkedEncodingError) as e:
            if not self.retry_conxn_errors:
                raise
            logger.warning('Connection error retrying %s', e)
            err = e
        # comes here only if there was either exception or login was not
        # successful
        if self.retry_wait_time:
            time.sleep(self.retry_wait_time)
        self.num_session_retries += 1
        if self.num_session_retries > self.max_session_retries:
            self.num_session_retries = 0
            logger.error("Giving up after %d retries connection failure %s" % (
                self.max_session_retries, True))
            raise err
        self.authenticate_session()
        return
