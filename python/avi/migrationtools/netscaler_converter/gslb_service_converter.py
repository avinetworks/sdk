import re
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants

from avi.migrationtools.netscaler_converter.ns_util import NsUtil
from avi.migrationtools.netscaler_converter.gslb_monitor_converter \
    import GslbHealthMonitorConverter

# Creating object for util library.
ns_util = NsUtil()

class GslbServiceConverter(object):
    def __init__(self):
        self.gslb_service_indirect = ns_constants.netscalar_command_status[
            'gslb_service_indirect']
        self.gslb_service_skip = ns_constants.netscalar_command_status[
            'gslb_service_skip']
        self.gslb_service_na = ns_constants.netscalar_command_status[
            'gslb_service_na']
        self.bind_gslb_skip = ns_constants.netscalar_command_status[
            'bind_gslb_skip']

    def convert_service(self, ns_service, vip_cluster_map, server_config,
                        ratio, avi_config, ns_monitor_config, gslb_monitor_converter):
        cmd = ns_util.get_netscalar_full_command('add gslb service',ns_service)
        matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+',
                             ns_service['attrs'][1])
        if matches:
            member_ip = ns_service['attrs'][1]
            port = ns_service['attrs'][3]
        else:
            server = server_config.get(ns_service['attrs'][1], {})
            member_ip = server['attrs'][1]
            if len(server['attrs']) >= 3:
                port = server['attrs'][3]
            else:
                port = 80
        state = (ns_service.get('state', 'ENABLED') == 'ENABLED')
        vs_details = None
        if vip_cluster_map:
            vs_details = vip_cluster_map.get(
                '%s:%s' % (member_ip,  port), None)
        if vs_details:
            member = {
                "cluster_uuid": vs_details['cluster_uuid'],
                "ip": {
                    "type": "V4",
                    "addr": member_ip
                },
                "vs_uuid": vs_details['vs_uuid'],
                "ratio": ratio,
                "enabled": state
            }
        else:
            member = {
                "ip": {
                    "type": "V4",
                    "addr": member_ip
                },
                "ratio": ratio,
                "enabled": state
            }
        gslb_monitor_ref = None
        if ns_service.get('healthmonitor', None):
            monitor_config = ns_monitor_config.get(
                ns_service.get('healthmonitor', {}))
            gslb_monitor = gslb_monitor_converter.convert(monitor_config)
            if gslb_monitor:
                avi_config['GslbHealthMonitor'].append(gslb_monitor)
                gslb_monitor_ref = gslb_monitor['name']
        conv_status = ns_util.get_conv_status(
            ns_service, self.gslb_service_skip, self.gslb_service_na,
            self.gslb_service_indirect)
        ns_util.add_conv_status(ns_service['line_no'], 'add gslb service',
                                ns_service['attrs'][0], cmd, conv_status,
                                member)
        return member, gslb_monitor_ref


    def convert(self, ns_config, gslb_vs_name, vip_cluster_map, gslb_algorithm,
                consistent_hash_mask, avi_config, gslb_monitor_converter):
        ns_groups = ns_config.get('bind gslb vserver', {})
        gslb_vs_conf = ns_config.get('add gslb vserver', {})
        service_config = ns_config.get('add gslb service', {})
        server_config = ns_config.get('add server')
        ns_monitor_config = ns_config.get('add lb monitor', {})
        vs_bindings = ns_groups.get(gslb_vs_name, {})
        domains=list()
        ttls = list()
        group_dict = dict()
        gslb_health_monitor_refs = []
        for binding in vs_bindings:
            if isinstance(binding, str):
                continue
            cmd = ns_util.get_netscalar_full_command(
                'bind gslb vserver', binding)
            if 'serviceName' in binding:
                member, health_monitor_ref = self.convert_service(
                    service_config[binding['serviceName']], vip_cluster_map,
                    server_config, binding.get('weight', 1), avi_config,
                    ns_monitor_config, gslb_monitor_converter)
                if health_monitor_ref:
                    gslb_health_monitor_refs.append(
                        '/api/gslbhealthmonitor/?tenant=admin&name=%s' %
                        health_monitor_ref)
                priority = binding.get('priority', 1)
                group = group_dict.get(priority, None)
                if not group:
                    group = {
                        'priority': priority,
                        'algorithm': gslb_algorithm,
                        'name': '%s-priority_%s' % (gslb_vs_name, priority),
                        'members': [member]
                    }
                    if consistent_hash_mask:
                        group['consistent_hash_mask'] = consistent_hash_mask
                    group_dict[priority] = group
                else:
                    group['members'].append(member)
                conv_status = ns_util.get_conv_status(
                    binding, self.bind_gslb_skip, [], [])
                ns_util.add_conv_status(binding['line_no'], 'add gslb service',
                                        binding['attrs'][0], cmd, conv_status,
                                        group)
            elif 'domainName' in binding:
                domains.append(binding['domainName'])
                ttl = binding.get('TTL', None)
                if ttl:
                    ttls.append(ttl)
                conv_status = ns_util.get_conv_status(
                    binding, self.bind_gslb_skip, [], [])
                ns_util.add_conv_status(binding['line_no'], 'add gslb service',
                                        binding['attrs'][0], cmd, conv_status,
                                        None)
        groups = list()
        for key in group_dict:
            groups.append(group_dict[key])
        ttl = 0
        if ttls:
            ttl = max(ttls, key=ttls.count)

        return groups, ttl, domains, gslb_health_monitor_refs
