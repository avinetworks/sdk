import requests
import logging

from avi.sdk.avi_api import ApiSession


LOG = logging.getLogger(__name__)


def get_object_from_controller(uri, controller_ip, username, password, tenant):
    """
    This function defines that it get the object from controller or raise
    exception if object status code is less than 299
    :param uri: URI to get the object
    :param controller_ip: ip of controller
    :param username: usename of controller
    :param password: password of controller
    :param tenant: tenant of controller
    :return: response status_code and content
    """
    # Create new session
    session = ApiSession.get_session(controller_ip, username,
                                     password=password, tenant=tenant)
    try:
        resp = session.get(uri)
        jsondata = requests.to_json(resp.content)
        if resp.status_code < 300:
            return [resp.status_code, jsondata]
        else:
            return [resp.status_code, {}]
    except:
        raise Exception("Failed get %s" % uri, exc_info=True)
