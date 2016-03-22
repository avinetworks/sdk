import copy
import logging
import os
import unittest

import avi.sdk.utils.f5_converter.f5_config_converter as f5_config_converter
import avi.sdk.utils.f5_converter.f5_parser as f5_parser

gSAMPLE_CONFIG = None
log = logging.getLogger(__name__)


def setUpModule():
    cfg_file = open('bigip.conf', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = cfg
    log.debug(' read cofig %s', gSAMPLE_CONFIG)


class Test(unittest.TestCase):

    LOG = logging.getLogger("converter-log")
    LOG.setLevel(logging.DEBUG)
    fh = logging.FileHandler(".." + os.path.sep + "output" + os.path.sep +
                             "converter.log", mode='a', encoding=None,
                             delay=False)
    fh.setLevel(logging.DEBUG)
    formatter = logging.Formatter(
        '%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)
    LOG.addHandler(fh)

    def test_config_conversion(self):
        f5_config_dict = f5_parser.parse_config(gSAMPLE_CONFIG, ".." +
                                                os.path.sep + "output", 11)
        assert f5_config_dict.get("virtual", None)
        assert f5_config_dict.get("monitor", None)
        assert f5_config_dict.get("pool", None)
        assert f5_config_dict.get("profile", None)
        assert f5_config_dict.get("node", None)
        f5_config_test = copy.deepcopy(f5_config_dict)
        avi_config_dict = f5_config_converter.convert_to_avi_dict(
            f5_config_dict, ".."+os.path.sep+"output", "disable",
            "certs", "admin", "api-upload")

        assert len(f5_config_test["virtual"].keys()) == len(
            avi_config_dict["VirtualService"])
        assert len(f5_config_test["pool"].keys()) <= len(
            avi_config_dict["Pool"])
        supported_monitor_count = 0
        supported_types = ["http", "https", "dns", "external", "tcp",
                           "udp", "gateway-icmp", "icmp"]
        f5_monitor_config = f5_config_test["monitor"]
        for key in f5_monitor_config.keys():
            if key.split(" ")[0] in supported_types:
                supported_monitor_count += 1
        assert supported_monitor_count == len(avi_config_dict["HealthMonitor"])

        f5_profile_config = f5_config_test["profile"]
        ssl_key_cert_count = 0
        ssl_profile_count = 0
        pki_profile_count = 0
        app_profile_count = 0
        for key in f5_profile_config.keys():
            if key.split(" ")[0] in ["client-ssl", "server-ssl"]:
                ssl_profile_count += 1
                profile = f5_profile_config[key]
                ca_file = profile.get("ca-file", 'none')
                if not ca_file == 'none':
                    pki_profile_count += 1
                cert_obj = profile.get("cert-key-chain", None)
                key_file = None
                cert_file = None
                if cert_obj:
                    key_file = cert_obj["default"]["key"]
                    cert_file = cert_obj["default"]["cert"]
                elif profile.get("cert", None):
                    cert_file = profile["cert"]
                    key_file = profile["key"]
                    key_file = None if key_file == 'none' else key_file
                    cert_file = None if cert_file == 'none' else cert_file
                if key_file and cert_file:
                    ssl_key_cert_count += 1
            elif key.split(" ")[0] in ["http", "dns", "web-acceleration",
                                       "http-compression"]:
                app_profile_count += 1
        assert ssl_profile_count == len(avi_config_dict["SSLProfile"])
        assert app_profile_count == len(avi_config_dict["ApplicationProfile"])
        assert ssl_key_cert_count == len(
            avi_config_dict["SSLKeyAndCertificate"])
        assert pki_profile_count == len(avi_config_dict["PKIProfile"])


if __name__ == "__main__":
    unittest.main()
