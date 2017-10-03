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
from avi.migrationtools.ace_converter.ssl_converter import SSLConverter

# init logger
LOG = logging.getLogger(__name__)

class ConfigConverter(object):
    """ Configuration conversion happens here """

    def __init__(self, parsed_output, in_file, enable_vs=False, version='17.1.1'):
        """ Create Some common Objects over here """
        self.aviobj = AviConverter()
        self.parsed = parsed_output
        self.common_utils = MigrationUtil()
        self.in_path = in_file.rsplit('/', 1)[0]
        self.version = version
        self.enable_vs = enable_vs

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
                              enable_vs=self.enable_vs
                              )

        self.persistance = PersistanceConverter(parsed=self.parsed,
                                                tenant_ref=self.tenant_ref,
                                                common_utils=self.common_utils,
                                                )

        self.ssl = SSLConverter(parsed=self.parsed,
                                tenant_ref=self.tenant_ref,
                                common_utils=self.common_utils,
                                in_path=self.in_path
                                )

    def conversion(self):
        """ All conversion controller over here """
        data = dict()
        data['META'] = self.aviobj.meta(tenant='admin', controller_version=self.version)
        data['Pool'] = self.pool.pool_conversion()
        data['HealthMonitor'] = self.monitor.healthmonitor_conversion()
        data['ApplicationPersistenceProfile'] = self.persistance.app_persistance_conversion()
        data['VsVip'] = self.vs.vsvip_conversion()
        vs_list, cloned_pool_list = self.vs.virtual_service_conversion(data)
        data['VirtualService'] = vs_list
        data['Pool'].extend(cloned_pool_list)
        data['SSLProfile'] = self.ssl.ssl_profile()
        data['SSLKeyAndCertificate'] = self.ssl.ssl_key_and_cert()

        return data
