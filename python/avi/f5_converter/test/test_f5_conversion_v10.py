import copy
import logging
import os
import unittest

import avi.f5_converter.f5_config_converter_v10 as f5_config_converter
import avi.f5_converter.f5_parser as f5_parser
import avi.f5_converter.f5_converter as f5_converter

gSAMPLE_CONFIG = None
log = logging.getLogger(__name__)


def setUpModule():
    cfg_file = open('bigip_v10.conf', 'r')
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
        f5_config_dict = f5_parser.parse_config(gSAMPLE_CONFIG, 10)
        defaults_file = open("../f5_v10_defaults.conf", "r")
        f5_defaults_dict = f5_parser.parse_config(defaults_file.read(), 10)
        f5_converter.dict_merge(f5_defaults_dict, f5_config_dict)
        f5_config_dict = f5_defaults_dict

        assert f5_config_dict.get("virtual", None)
        assert f5_config_dict.get("monitor", None)
        assert f5_config_dict.get("pool", None)
        assert f5_config_dict.get("profile", None)
        assert f5_config_dict.get("node", None)
        f5_config_test = copy.deepcopy(f5_config_dict)
        avi_config_dict = f5_config_converter.convert_to_avi_dict(
            f5_config_dict, ".."+os.path.sep+"output", "disable",
            "certs", "api-upload")
        vs_count = 0
        unsupported_types = ["l2 forward", "ip forward", "stateless", "reject"]
        vs_config = f5_config_test["virtual"]
        for key in vs_config.keys():
            vs_type = [key for key in vs_config[key].keys() if key in
                       unsupported_types]
            if not vs_type:
                vs_count += 1
        assert vs_count == len(avi_config_dict["VirtualService"])

        assert len(f5_config_test["pool"].keys()) <= len(
            avi_config_dict["Pool"])
        supported_monitor_count = 0
        supported_types = ["http", "https", "dns", "external", "tcp",
                           "udp", "gateway_icmp", "icmp"]
        f5_monitor_config = f5_config_test["monitor"]
        for key in f5_monitor_config.keys():
            monitor = f5_config_converter.get_monitor_defaults(
                f5_monitor_config[key], f5_monitor_config, key)
            if monitor['type'] in supported_types:
                supported_monitor_count += 1
        assert supported_monitor_count == len(avi_config_dict["HealthMonitor"])

        f5_profile_config = f5_config_test["profile"]
        ssl_key_cert_count = 0
        ssl_profile_count = 0
        pki_profile_count = 0
        app_profile_count = 0
        network_profile_count = 0
        persist_profile_count = 0
        for key in f5_profile_config.keys():
            profile_type = key.split(" ")[0]
            if profile_type in ["clientssl", "serverssl"]:
                ssl_profile_count += 1
                profile = f5_profile_config[key]
                profile = f5_config_converter.update_with_default_profile(
                    profile_type, profile, f5_profile_config)
                crl_file_name = profile.get('crl file', None)
                ca_file_name = profile.get('ca file', None)
                if crl_file_name and crl_file_name != 'none':
                    crl_file_name = crl_file_name.replace('\"', '').strip()
                else:
                    crl_file_name = None
                if ca_file_name and ca_file_name != 'none':
                    ca_file_name = ca_file_name.replace('\"', '').strip()
                else:
                    ca_file_name = None
                if ca_file_name and crl_file_name:
                    pki_profile_count += 1
                cert_file = profile.get("cert", None)
                key_file = profile.get("key", None)
                key_file = None if key_file == 'none' else key_file
                cert_file = None if cert_file == 'none' else cert_file
                if key_file and cert_file:
                    ssl_key_cert_count += 1
            if profile_type in ["http", "dns", "fastL4"]:
                app_profile_count += 1
            if profile_type in ["udp", "tcp", "fasthttp", "fastL4"]:
                network_profile_count += 1
            if profile_type == "persist" and f5_profile_config[
                key]["mode"] in ["cookie", "ssl", "source addr"]:
                persist_profile_count += 1

        assert ssl_profile_count == len(avi_config_dict["SSLProfile"])
        assert app_profile_count == len(avi_config_dict["ApplicationProfile"])
        assert network_profile_count == len(avi_config_dict["NetworkProfile"])
        assert ssl_key_cert_count == len(
            avi_config_dict["SSLKeyAndCertificate"])
        assert persist_profile_count == len (
            avi_config_dict["ApplicationPersistenceProfile"])
        assert pki_profile_count == len(avi_config_dict["PKIProfile"])


if __name__ == "__main__":
    unittest.main()
