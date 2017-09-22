""" This file having all configuration conversion """

import logging
from avi.migrationtools.avi_migration_utils import MigrationUtil
from avi.migrationtools.avi_converter import AviConverter
from avi.migrationtools.ace_converter.ace_utils import update_excel
from avi.migrationtools.ace_converter.pool_converter import PoolConverter
from avi.migrationtools.ace_converter.monitor_converter import MonitorConverter
from avi.migrationtools.ace_converter.vs_converter import VSConverter
from avi.migrationtools.ace_converter.persistance_conversion import\
                                                PersistanceConverter

# init logger
LOG = logging.getLogger(__name__)

class ConfigConverter(object):
    """ Configuration conversion happens here """

    def __init__(self, parsed_output):
        """ Create Some common Objects over here """
        self.aviobj = AviConverter()
        self.parsed = parsed_output
        self.common_utils = MigrationUtil()

        self.tenant_ref = self.common_utils.get_object_ref('admin', 'tenant')

        #creating objects for converters
        self.pool = PoolConverter(parsed=self.parsed,
                                  tenant_ref=self.tenant_ref,
                                  common_utils=self.common_utils,
                                  )
        self.monitor = MonitorConverter(parsed=self.parsed,
                                        tenant_ref=self.tenant_ref,
                                        common_utils=self.common_utils,
                                       )

        self.vs = VSConverter(parsed=self.parsed,
                              tenant_ref=self.tenant_ref,
                              common_utils=self.common_utils,
                              )

        self.persistance = PersistanceConverter(parsed=self.parsed,
                                                tenant_ref=self.tenant_ref,
                                                common_utils=self.common_utils,
                                                )

    def conversion(self):
        """ All conversion controller over here """
        data = dict()
        data['META'] = self.aviobj.meta(tenant='admin', controller_version='17.2.1')
        data['Pool'] = self.pool.pool_conversion()
        data['HealthMonitor'] = self.monitor.healthmonitor_conversion()
        data['ApplicationPersistenceProfile'] = self.persistance.app_persistance_conversion()
        data['VsVip'] = self.vs.vsvip_conversion()
        data['VirtualService'] = self.vs.virtual_service_conversion()
        data['SSLProfile'] = []
        data['SSLKeyAndCertificate'] = []

        return data
