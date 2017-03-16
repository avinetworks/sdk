from avi.sdk.avi_api import ApiSession
import logging

LOG = logging.getLogger(__name__)


def upload_config_to_controller(avi_config_dict, controller_ip,
                                username, password, tenant):
    LOG.debug("Uploading config to controller")
    session = ApiSession.get_session(controller_ip, username,
                                     password=password, tenant=tenant)
    try:
        d = {'configuration': avi_config_dict}
        path = 'configuration/import'
        resp = session.post(path, data=d)
        if resp.status_code < 300:
            LOG.info("Config uploaded to controller successfully")
        else:
            LOG.error("Upload error response:" + resp.text)
            raise Exception("Upload error response:" + resp.text)
    except Exception as e:
        LOG.error("Failed config upload", exc_info=True)
        print "Error"
        raise Exception(e)


def get_object_from_controller(object_type, object_name, controller_ip, username, password, tenant):
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
        resp = session.get_object_by_name(object_type, object_name)
        return resp
    except:
        raise Exception("Failed get %s" % object_name, exc_info=True)
