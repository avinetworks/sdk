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
            LOG.error("Upload error response:"+resp.text)
    except:
        LOG.error("Failed config upload", exc_info=True)
        print "Error"
