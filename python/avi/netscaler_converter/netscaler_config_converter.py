import logging
import os

LOG = logging.getLogger(__name__)

from avi.netscaler_converter.ns_service_converter import ServiceConverter
from avi.netscaler_converter.monitor_converter import MonitorConverter
from avi.netscaler_converter.lbvs_converter import LbvsConverter
from avi.netscaler_converter.csvs_converter import CsvsConverter
from avi.netscaler_converter import ns_util
from avi.netscaler_converter.profile_converter import ProfileConverter
from lbvs_converter import tmp_avi_config

def convert(ns_config_dict, tenant, version, output_dir, input_dir,
            skipped_cmds, vs_state):

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
        monitor_converter.convert(ns_config_dict, avi_config, input_dir)

        profile_converter = ProfileConverter()
        profile_converter.convert(ns_config_dict, avi_config, input_dir)

        service_converter = ServiceConverter()
        service_converter.convert(ns_config_dict, avi_config)

        lbvs_converter = LbvsConverter()
        lbvs_converter.convert(ns_config_dict, avi_config, vs_state)

        csvs_converter = CsvsConverter()
        csvs_converter.convert(ns_config_dict, avi_config, vs_state)

        ns_util.update_status_for_skipped(skipped_cmds)
        LOG.debug('Conversion completed successfully')

        ns_util.cleanup_config(tmp_avi_config)

    except:
        LOG.error('Error in config conversion', exc_info=True)

    csv_file.close()
    return avi_config