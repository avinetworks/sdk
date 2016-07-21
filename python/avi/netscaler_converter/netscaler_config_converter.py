import logging
import os

LOG = logging.getLogger(__name__)

from avi.netscaler_converter.ns_service_converter import ServiceConverter
from avi.netscaler_converter.monitor_converter import MonitorConverter
from avi.netscaler_converter.lbvs_converter import LbvsConverter
from avi.netscaler_converter import ns_util


def convert(ns_config_dict, tenant, version, output_dir):

    status_file = output_dir + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)
    LOG.debug('Conversion Started')
    try:
        avi_config = {
            "META": {
                "supported_migrations": {
                    "versions": [
                        "14_2",
                        "15_1",
                        "15_1_1",
                        "15_2",
                        "15_2_3",
                        "15_3",
                        "current_version"
                    ]
                },
                "version": {
                    "Product": "controller",
                    "Version": version,
                    "min_version": 15.2,
                    "ProductName": "Avi Cloud Controller"
                },
                "upgrade_mode": False,
                "use_tenant": tenant
            }
        }

        monitor_converter = MonitorConverter()
        monitor_converter.convert(ns_config_dict, avi_config)

        service_converter = ServiceConverter()
        service_converter.convert(ns_config_dict, avi_config)

        lbvs_converter = LbvsConverter()
        lbvs_converter.convert(ns_config_dict, avi_config)
        LOG.debug('Conversion completed successfully')

    except:
        LOG.error('Error in config conversion', exec_info=True)

    csv_file.close()
    return avi_config