import logging
import re
import avi.netscaler_converter.ns_util as ns_util
from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED, STATUS_SUCCESSFUL)

LOG = logging.getLogger(__name__)


class ServiceConverter(object):

    bind_lb_skipped = ['priority', 'gotoPriorityExpression', 'type', 'invoke']
    service_skip = ['clearTextPort', 'cacheType', 'maxReq', 'useproxyport',
                    'sc', 'rtspSessionidRemap', 'maxBandwidth',
                    'monThreshold', 'netProfile', 'td', 'dnsProfileName']
    service_na = ['pathMonitor', 'pathMonitorIndv', 'accessDown', 'appflowLog',
                  'processLocal', 'CKA']

    bind_sg_skip = ['passive', 'CustomServerID', 'state', 'hashId', 'weight']

    server_skip = ['comment', 'td']

    skip_for_val = {'useproxyport': 'YES', 'maxReq': '0'}

    def convert(self, ns_config, avi_config):
        """
        Converts service or service groups bound to VS to avi Pool entity
        :param ns_config: Netscaler parsed config
        :param avi_config: Avi converted config
        :return:
        """
        groups = ns_config.get('bind lb vserver', {})
        lb_vs_conf = ns_config.get('add lb vserver', {})
        avi_config['Pool'] = []
        b_cmd = 'bind lb vserver'
        for group_key in groups.keys():

            try:
                conv_status = []
                group = groups.get(group_key)
                if isinstance(group, list):
                    group = group[0]
                full_cmd = ns_util.get_netscalar_full_command(b_cmd, group)
                name = '%s-pool' % group_key
                updated_pool_name = re.sub('[:]', '-', name)
                if not group_key:
                    ns_util.add_status_row(b_cmd, group_key,full_cmd, STATUS_SKIPPED)
                    LOG.warning('Skipped: No bind lb vserver found. Skipped pool' % group_key)
                    continue
                server_list = self.get_servers(ns_config, group, conv_status)
                servers = [server for index, server in enumerate(server_list) if server not in server_list[index + 1:]]

                if not servers:
                    ns_util.add_status_row(b_cmd, group_key, full_cmd, STATUS_SKIPPED)
                    LOG.warning('Error: No Servers found. Skipped pool : %s' % group_key)
                    continue
                lb_vs = lb_vs_conf.get(group_key)

                if not lb_vs:
                    ns_util.add_status_row(b_cmd, group_key, full_cmd, STATUS_SKIPPED)
                    LOG.warning('Skipped: No bind lb vserver found. Skipped pool %s' % group_key)
                    continue
                ns_algo = lb_vs.get('lbMethod', 'LEASTCONNECTION')
                algo = ns_util.get_avi_lb_algorithm(ns_algo)
                pool_obj = \
                    {
                        "name": updated_pool_name,
                        "servers": servers,
                        "lb_algorithm": algo
                    }

                monitor_names = self.get_monitors(ns_config, group)
                avi_monitors = avi_config["HealthMonitor"]
                hm_monitors = []
                for ref in monitor_names:
                    refs = [mon for mon in avi_monitors
                            if mon['name'] == ref]
                    if refs:
                        hm_monitors.append(refs[0])

                monitors = ns_util.remove_duplicate_objects('Health Monitor', hm_monitors)

                monitor_refs = [mon["name"] for mon in monitors]
                monitor_refs = list(set(monitor_refs))

                if len(monitor_refs) > 6:
                    pool_obj["health_monitor_refs"] = monitor_refs[0:6]
                    LOG.warning('Ignore the Health monitor references, its count is beyond 6 for pool : %s' % name)
                else:
                    pool_obj["health_monitor_refs"] = monitor_refs

                avi_config['Pool'].append(pool_obj)

                conv_status = ns_util.get_conv_status(group, self.bind_lb_skipped, [], [])
                ns_util.add_conv_status(b_cmd, group_key, full_cmd, conv_status, pool_obj)

            except:
                LOG.error('Error in bind lb vserver conversion bound to: %s' %
                          group_key, exc_info=True)

    def get_servers(self, ns_config, group, conv_status):
        servers = []
        ns_services = ns_config.get('add service', {})
        ns_service_group = ns_config.get('bind serviceGroup', {})
        ns_servers = ns_config.get('add server', {})
        ns_dns = ns_config.get('add dns addRec', {})
        ns_sg = None
        if isinstance(group, dict):
            group = [group]
        for member in group:
            ns_service = None
            if len(member.get('attrs', [])) > 1:
                ns_service = ns_services.get(member['attrs'][1], None)
            if not ns_service and len(member['attrs']) > 1:
                ns_sg = ns_service_group.get(member['attrs'][1], None)
            if not ns_sg and not ns_service:
                continue
            if ns_sg:
                servers += self.convert_ns_service_group(
                    ns_sg, ns_servers, ns_dns, conv_status)
            else:
                servers += self.convert_ns_service(
                    ns_service, ns_servers, ns_dns, conv_status)
        return servers

    def get_monitors(self, ns_config, group):
        ns_sg = ns_config.get('bind serviceGroup', {})
        ns_service_binding = ns_config.get('bind service', {})

        if isinstance(group, dict):
            group = [group]
        monitor_ref = []
        for member in group:
            if len(member['attrs']) < 2:
                continue
            mon_ref = []
            cmd = "bind service %s %s" % (member['attrs'][1], member['attrs'][0])
            group_cmd = "bind service group %s %s" % (member['attrs'][1], member['attrs'][0])

            service_groups = ns_sg.get(member['attrs'][1], [])
            if service_groups and isinstance(service_groups, dict):
                service_groups = [service_groups]
            self.get_monitor_names(service_groups, mon_ref, group_cmd)

            services = ns_service_binding.get(member['attrs'][1], [])
            if services and isinstance(services, dict):
                services = [services]
            self.get_monitor_names(services, mon_ref, cmd)

            if mon_ref:
                monitor_ref += mon_ref

        return list(set(monitor_ref))

    def get_monitor_names(self, bindings, mon_ref, cmd):
        for binding in bindings:
            s_cmd = 'add service'
            full_cmd = ns_util.get_netscalar_full_command(cmd, binding)
            mon_name = binding.get('monitorName', None)
            if mon_name:
                mon_name = mon_name.replace('"', '').strip().replace(' ', '_')
                mon_ref.append(mon_name)
                LOG.info('Added service : %s' % cmd)
                ns_util.add_status_row(s_cmd, binding['attrs'][0], full_cmd, STATUS_SUCCESSFUL, binding)
            elif binding.get('CustomServerID', None) or \
                    binding.get('hashId', None) or \
                    binding.get('policyName', None):
                LOG.warning('Command not supported : %s' % cmd)
                ns_util.add_status_row(s_cmd, binding['attrs'][0], full_cmd, STATUS_SKIPPED)

    def convert_ns_service(self, ns_service, ns_servers, ns_dns, conv_status):
        attrs = ns_service.get('attrs')
        cmd = 'add service'
        status = ns_util.get_conv_status(ns_service, self.service_skip,
                                         self.service_na, [], self.skip_for_val)

        full_cmd = ns_util.get_netscalar_full_command(cmd, ns_service)
        ns_util.add_conv_status(cmd, attrs[0], full_cmd, status, ns_service)
        server = ns_servers.get(attrs[1])
        if not server:
            return []
        cmd = 'add server'
        status = ns_util.get_conv_status(server, self.server_skip,
                                         [], [])
        full_cmd = ns_util.get_netscalar_full_command(cmd, server)
        ip_addr = server['attrs'][1]
        enabled = True
        state = server.get('state', 'ENABLED')
        if not state == 'ENABLED':
            enabled = False
        port = attrs[3]
        if port in ("*", "0"):
            port = "1"

        if ip_addr in ns_dns:
            if isinstance(ns_dns[ip_addr], list):
                ip_addr = ns_dns[ip_addr][0]['attrs'][1]
            elif isinstance(ns_dns[ip_addr], dict):
                ip_addr = ns_dns[ip_addr]['attrs'][1]

        matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', ip_addr)
        server_obj = {
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        }
        if not matches:
            ns_util.add_status_row(cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
            LOG.warning('Not found IP of server : %s' % full_cmd)
            return []


        ns_util.add_conv_status(cmd, server['attrs'][0], full_cmd, status, server_obj)
        return [server_obj]

    def convert_ns_service_group(self, ns_service_group, ns_servers,
                                 ns_dns, conv_status):
        servers = []
        if isinstance(ns_service_group, dict):
            ns_service_group = [ns_service_group]

        for server_binding in ns_service_group:
            if server_binding.get('monitorName', None):
                continue
            attrs = server_binding.get('attrs')
            cmd = 'bind serviceGroup'
            status = ns_util.get_conv_status(server_binding, self.bind_sg_skip,
                                             [], [])
            full_cmd = ns_util.get_netscalar_full_command(cmd, server_binding)
            ns_util.add_conv_status(cmd, attrs[0], full_cmd, status, server_binding)
            server = ns_servers.get(attrs[1])
            if not server:
                ns_util.add_status_row(cmd, attrs[1], full_cmd, STATUS_SKIPPED)
                LOG.error('Skipped server : %s' % cmd)
                continue

            cmd = 'add server'
            full_cmd = ns_util.get_netscalar_full_command(cmd, server)
            status = ns_util.get_conv_status(server, self.server_skip,
                                             [], [])

            ip_addr = server['attrs'][1]
            if ip_addr in ns_dns:
                if isinstance(ns_dns[ip_addr], list):
                    ip_addr = ns_dns[ip_addr][0]['attrs'][1]
                elif isinstance(ns_dns[ip_addr], dict):
                    ip_addr = ns_dns[ip_addr]['attrs'][1]
            enabled = True
            state = server.get('state', 'ENABLED')
            if not state == 'ENABLED':
                enabled = False
            port = attrs[2]
            if port in ("*", "0"):
                port = "1"
            matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', ip_addr)
            server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'port': port,
                'enabled': enabled
            }
            if not matches:
                ns_util.add_status_row(cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
                LOG.warning('Not found IP of server : %s %s' % (cmd, attrs[1]))
                server_obj = None
            if server_obj:
                servers.append(server_obj)
            ns_util.add_conv_status(cmd, server['attrs'][0], full_cmd, status, server_obj)
        return servers
