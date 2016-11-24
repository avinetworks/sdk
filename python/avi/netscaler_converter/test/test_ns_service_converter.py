import logging
import os
import unittest
import json

from avi.netscaler_converter.ns_service_converter import ServiceConverter
import avi.netscaler_converter.ns_util as ns_util

gSAMPLE_CONFIG = None
LOG = logging.getLogger(__name__)


def setUpModule():
    LOG.setLevel(logging.DEBUG)
    formatter = '%(asctime)s - %(name)s - %(levelname)s - %(message)s'
    path = "test_output"
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)
    cfg_file = open('test_ns_service_converter.cfg', 'r')
    cfg = cfg_file.read()
    global gSAMPLE_CONFIG
    gSAMPLE_CONFIG = json.loads(cfg)
    LOG.debug(' read cofig %s', gSAMPLE_CONFIG)
    status_file = "./test_output" + os.path.sep + "ConversionStatus.csv"
    csv_file = open(status_file, 'w')
    ns_util.add_csv_headers(csv_file)



class Test(unittest.TestCase):

    def test_service_conversion(self):
        service_converter = ServiceConverter()
        avi_config = gSAMPLE_CONFIG["avi_config"]
        ns_config_dict = gSAMPLE_CONFIG["ns_config_dict"]
        service_converter.convert(ns_config_dict, avi_config)
        assert avi_config['Pool'][0]
        hm_count = self.get_health_monitor_count(ns_config_dict)
        server_count = self.get_server_count(ns_config_dict)
        assert len(avi_config['Pool'][0]['health_monitor_refs']) == hm_count
        assert len(avi_config['Pool'][0]['servers']) == server_count

    def get_health_monitor_count(self, ns_config):
        count = 0
        groups = ns_config.get('bind lb vserver', {})
        for key in groups.keys():
            group = groups.get(key)
            mon_ref = []
            ns_sg = ns_config.get('bind serviceGroup', {})
            ns_service_binding = ns_config.get('bind service', {})
            if isinstance(group, dict):
                group = [group]
            for member in group:
                for key in ns_sg.keys():
                    sg = ns_sg.get(key)
                    if isinstance(sg, dict):
                        sg = [sg]
                    self.get_monitor_names(sg, mon_ref, member)
                for key in ns_service_binding.keys():
                    service = ns_service_binding.get(key)
                    if isinstance(service, dict):
                        service = [service]
                    self.get_monitor_names(service, mon_ref, member)
            count += len(list(set(mon_ref)))
        return count

    def get_monitor_names(self, bindings, mon_ref, member):
        for binding in bindings:
            if binding.get('monitorName', None) and \
                            member['attrs'][1] == binding['attrs'][0]:
                    mon_ref.append(binding.get('monitorName'))

    def get_server_count(self, ns_config):
        count = 0
        groups = ns_config.get('bind lb vserver', {})
        for key in groups.keys():
            group = groups.get(key)
            ns_services = ns_config.get('add service', {})
            ns_service_group = ns_config.get('bind serviceGroup', {})
            ns_servers = ns_config.get('add server', {})
            ns_sg = None
            if isinstance(group, dict):
                group = [group]
            for member in group:
                ns_service = None
                if len(member.get('attrs', [])) > 1:
                    ns_service = ns_services.get(member['attrs'][1], None)
                if not ns_service:
                    ns_sg = ns_service_group.get(member['attrs'][1], None)
                if not ns_sg and not ns_service:
                    continue
                if ns_sg:
                    if isinstance(ns_sg, dict):
                        ns_sg = [ns_sg]
                    for sg in ns_sg:
                        if sg.get('monitorName', None):
                            continue
                        else:
                            count += 1
                else:
                    count += 1
            return count

    def remove_duplicate_health_monitors(self):
        converted_hm_config = gSAMPLE_CONFIG["converted_hm_config"]
        hm_config = gSAMPLE_CONFIG["hm_config"]
        health_monitors = ns_util.remove_duplicate_objects('Health Monitor', hm_config)
        if cmp(converted_hm_config, health_monitors) != 0:
            LOG.error("Error in remove duplicate health monitors")


