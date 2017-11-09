""" Application Persistance Conversion Goes here """
import logging
from avi.migrationtools.ace_converter.ace_utils import update_excel
from avi.migrationtools.ace_converter.ace_constants import APP_PERSISTANCE_TIMEOUT

# logging init
LOG = logging.getLogger(__name__)


class PersistanceConverter(object):
    """ Application Persistance Conversion """

    def __init__(self, parsed, tenant_ref, common_utils, tenant):
        self.parsed = parsed
        self.tenant_ref = tenant_ref
        self.common_utils = common_utils
        self.tenant = tenant

    def app_persistance_conversion(self):
        """ App persistance conversion """
        # persistance list
        persistance_list = list()
        persistance_type = 'PERSISTENCE_TYPE_CLIENT_IP_ADDRESS'
        for sticky in self.parsed.get('sticky', ''):
            if 'ip-netmask' in sticky:
                persistance_type = "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS"
            if 'http-cookie' in sticky:
                persistance_type = 'PERSISTENCE_TYPE_HTTP_COOKIE'

            name = sticky.get('name', [])
            if not name:
                LOG.warning('Skipping Sticky... %s' % name)
                continue
            # default time out
            timeout = APP_PERSISTANCE_TIMEOUT
            for time_out in sticky['desc']:
                if 'timeout' in time_out.keys():
                    if int(time_out['timeout']) < 720 and int(time_out['timeout']) > 1:
                        timeout = time_out['timeout']

            persistance = {
                "name": name,
                "persistence_type": persistance_type,
                "tenant_ref": self.tenant_ref,
                "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
                "ip_persistence_profile": {}
            }

            if type == "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS":
                persistance["ip_persistence_profile"] = {
                    "ip_persistent_timeout": timeout
                }
                # Updating Excel Sheet
            update_excel('sticky', name, avi_obj=persistance)

            persistance_list.append(persistance)

        return persistance_list
