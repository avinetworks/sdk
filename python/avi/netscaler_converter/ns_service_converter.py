import logging
import re
import avi.netscaler_converter.ns_util as ns_util
from avi.netscaler_converter.ns_constants import (STATUS_SKIPPED,
                                                  STATUS_SUCCESSFUL,
                                                  STATUS_INDIRECT)

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
        used_pool_ref = []
        groups = ns_config.get('bind lb vserver', {})
        lb_vs_conf = ns_config.get('add lb vserver', {})
        avi_config['PoolGroup'] = []
        netscalar_cmd = 'bind lb vserver'

        # service converter
        self.service_convert(ns_config, avi_config)
        ns_dns = ns_config.get('add dns addRec', {})
        for dns_key in ns_dns:

            dns_obj = ns_dns.get(dns_key, [])
            if isinstance(dns_obj, dict):
                dns_obj = [dns_obj]
            dns_cmd = 'add dns addRec'
            for element in dns_obj:
                full_dns_cmd = ns_util.get_netscalar_full_command(dns_cmd, element)
                ns_util.add_status_row(element['line_no'], dns_cmd, dns_key, full_dns_cmd, STATUS_INDIRECT)

        for group_key in groups:
            try:
                if not group_key:
                    ns_util.add_status_row(None, netscalar_cmd, group_key, full_cmd, STATUS_SKIPPED)
                    LOG.warning('Skipped: No bind lb vserver found. Skipped pool' % group_key)
                    continue

                group = groups.get(group_key)
                if isinstance(group, dict):
                    group = [group]
                lb_vs = lb_vs_conf.get(group_key)
                if not lb_vs:
                    ns_util.add_status_row(None, netscalar_cmd, group_key, full_cmd, STATUS_SKIPPED)
                    LOG.warning('Skipped: No add lb vserver found. Skipped pool %s' % group_key)
                    continue
                ns_algo = lb_vs.get('lbMethod', 'LEASTCONNECTION')
                algo = ns_util.get_avi_lb_algorithm(ns_algo)
                pg_members = []
                for element in group:
                    if len(element['attrs']) < 2:
                        continue
                    full_cmd = ns_util.get_netscalar_full_command(netscalar_cmd, element)
                    service = element['attrs'][1]
                    pool_name = service + '-pool'
                    pool = [pool for pool in avi_config['Pool'] if pool['name'] == pool_name]
                    if pool:
                        if pool_name in used_pool_ref:
                            pool_name = ns_util.clone_pool(pool_name, group_key, avi_config)
                        pool[0]['lb_algorithm'] = algo
                        pg_members.append({'pool_ref': pool_name})
                        used_pool_ref.append(pool_name)
                        LOG.info('Conversion successful : %s' % element['attrs'][0])
                        conv_status = ns_util.get_conv_status(element, self.bind_lb_skipped, [], [])
                        ns_util.add_conv_status(element['line_no'], netscalar_cmd, element['attrs'][0], full_cmd, conv_status, pool[0])
                    else:
                        LOG.warning('Skipped :Pool is not created %s' % element['attrs'][0])
                        ns_util.add_status_row(element['line_no'], netscalar_cmd, element['attrs'][0], full_cmd, STATUS_SKIPPED)

                pg_name = group_key + '-poolgroup'
                if pg_members:
                    pool_group = {
                        'name': pg_name,
                        'members': pg_members
                    }
                    avi_config['PoolGroup'].append(pool_group)

            except Exception as e:
                LOG.error('Error in bind lb vserver conversion bound to: %s' %
                          group_key, exc_info=True)


    def service_convert(self, ns_config, avi_config):
        """

        :param ns_config:
        :param avi_config:
        :return:
        """
        used_pool_ref = []
        avi_config['Pool'] = []
        ns_services = ns_config.get('add service', {})
        bind_service_group = ns_config.get('bind serviceGroup', {})
        ns_servers = ns_config.get('add server', {})
        ns_dns = ns_config.get('add dns addRec', {})
        bind_ns_service = ns_config.get('bind service', {})
        ns_service_groups = ns_config.get('add serviceGroup', {})

        for key in ns_services:
            service = ns_services.get(key, {})
            service_command = 'add service'
            service_name = key
            service_netscalar_full_command = ns_util.get_netscalar_full_command(service_command, service)
            server = self.convert_ns_service(service, ns_servers, ns_dns)
            if not server:
                LOG.warning('Skipped:No server found %s' % service_netscalar_full_command)
                ns_util.add_status_row(service['line_no'], service_command, service_name, service_netscalar_full_command, STATUS_SKIPPED)
                continue

            pool_obj = {
                'name': service_name + '-pool',
                'servers': [server],
                'health_monitor_refs': []
            }
            monitor_refs = self.get_service_montor(service_name, bind_ns_service)
            if monitor_refs:
                pool_obj['health_monitor_refs'] = list(set(monitor_refs))
            avi_config['Pool'].append(pool_obj)
            LOG.warning('Conversion successful: %s' % service_netscalar_full_command)
            conv_status = ns_util.get_conv_status(service, self.bind_lb_skipped, [], [])
            ns_util.add_conv_status(service['line_no'], service_command, service_name, service_netscalar_full_command, conv_status, pool_obj)

        for group_key in ns_service_groups:
            service_group_command = 'add serviceGroup'
            service_group = ns_service_groups.get(group_key, {})
            service_group_name = group_key
            service_group_netscalar_full_command = ns_util.get_netscalar_full_command(service_group_command, service_group)
            bind_groups = bind_service_group.get(service_group['attrs'][0], [])
            servers, monitor_ref = self.convert_ns_service_group(bind_groups, ns_servers, ns_dns)
            if not servers:
                LOG.warning('Skipped:No server found %s' % service_netscalar_full_command)
                ns_util.add_status_row(service_group['line_no'], service_group_command, service_group_name, service_group_netscalar_full_command, STATUS_SKIPPED)
                continue

            pool_obj = {
                'name': service_group_name + '-pool',
                'servers': servers,
                'health_monitor_refs': []
            }
            if monitor_ref:
                pool_obj['health_monitor_refs'].append(monitor_ref)
            avi_config['Pool'].append(pool_obj)
            LOG.warning('Conversion successful: %s' % service_group_netscalar_full_command)
            conv_status = ns_util.get_conv_status(service_group, self.bind_lb_skipped, [], [])
            ns_util.add_conv_status(service_group['line_no'], service_group_command, service_group_name, service_group_netscalar_full_command, conv_status,
                                    pool_obj)

    def get_service_montor(self, service_name, bind_ns_service):
        monitor_refs = []
        bind_service = bind_ns_service.get(service_name, None)
        bind_service_command = 'bind service'
        if bind_service:
            if isinstance(bind_service, dict):
                bind_service = [bind_service]
            for service in bind_service:
                full_bind_service_command = ns_util.get_netscalar_full_command(bind_service_command, service)
                if service and service.get('monitorName', None):
                    monitor_refs.append(service.get('monitorName'))
                    LOG.info('Conversion suv=ccessful : %s' % full_bind_service_command)
                    ns_util.add_status_row(service['line_no'], bind_service_command, service_name, full_bind_service_command, STATUS_SUCCESSFUL, service.get('monitorName'))
                else:
                    LOG.warning('Skipped : Not found Health monitor %s' % full_bind_service_command)
                    ns_util.add_status_row(service['line_no'], bind_service_command, service_name, full_bind_service_command,
                                           STATUS_SKIPPED)
        return monitor_refs


    def convert_ns_service(self, ns_service, ns_servers, ns_dns):
        attrs = ns_service.get('attrs')
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
        if not matches:
            ns_util.add_status_row(server['line_no'], cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
            LOG.warning('Not found IP of server : %s' % full_cmd)
            return []
        server_obj = {
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        }
        ns_util.add_conv_status(server['line_no'], cmd, server['attrs'][0], full_cmd, status, server_obj)
        return server_obj


    def convert_ns_service_group(self, ns_service_group, ns_servers,
                                 ns_dns):
        servers = []
        monitor_name = None
        if isinstance(ns_service_group, dict):
            ns_service_group = [ns_service_group]

        for server_binding in ns_service_group:
            if server_binding.get('monitorName', None):
                monitor_name = server_binding.get('monitorName')
                continue
            attrs = server_binding.get('attrs')
            cmd = 'bind serviceGroup'
            status = ns_util.get_conv_status(server_binding, self.bind_sg_skip,
                                             [], [])
            full_cmd = ns_util.get_netscalar_full_command(cmd, server_binding)
            ns_util.add_conv_status(server_binding['line_no'], cmd, attrs[0], full_cmd, status, server_binding)
            server = ns_servers.get(attrs[1])
            if not server:
                ns_util.add_status_row(server_binding['line_no'], cmd, attrs[1], full_cmd, STATUS_SKIPPED)
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
                'enabled': enabled,
                'health_monitor': server_binding.get('monitorName')

            }
            if not matches:
                ns_util.add_status_row(server['line_no'], cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
                LOG.warning('Not found IP of server : %s %s' % (cmd, attrs[1]))
                server_obj = None
            if server_obj:
                servers.append(server_obj)
            ns_util.add_conv_status(server['line_no'], cmd, server['attrs'][0], full_cmd, status, server_obj)
        return servers, monitor_name


    #
    # def get_servers_and_thier_health_monitor(self, ns_config, group, conv_status):
    #     servers = []
    #     ns_services = ns_config.get('add service', {})
    #     ns_service_group = ns_config.get('bind serviceGroup', {})
    #     ns_servers = ns_config.get('add server', {})
    #     ns_dns = ns_config.get('add dns addRec', {})
    #     ns_service = None
    #     ns_sg = None
    #     if len(group.get('attrs', [])) > 1:
    #         ns_service = ns_services.get(group['attrs'][1], None)
    #     if not ns_service and len(group['attrs']) > 1:
    #         ns_sg = ns_service_group.get(group['attrs'][1], None)
    #     if not ns_sg and not ns_service:
    #         return None
    #     if ns_sg:
    #         servers += self.convert_ns_service_group(
    #             ns_sg, ns_servers, ns_dns, conv_status)
    #     else:
    #         servers += self.convert_ns_service(
    #             ns_service, ns_servers, ns_dns, conv_status)
    #
    #
    #     return servers
    #
    #
    # def get_servers(self, ns_config, group, conv_status):
    #     servers = []
    #     ns_services = ns_config.get('add service', {})
    #     ns_service_group = ns_config.get('bind serviceGroup', {})
    #     ns_servers = ns_config.get('add server', {})
    #     ns_dns = ns_config.get('add dns addRec', {})
    #     ns_service_binding = ns_config.get('bind service', {})
    #     ns_sg = None
    #     if isinstance(group, dict):
    #         group = [group]
    #     for member in group:
    #         ns_service = None
    #         if len(member.get('attrs', [])) > 1:
    #             ns_service = ns_services.get(member['attrs'][1], None)
    #         if not ns_service and len(member['attrs']) > 1:
    #             ns_sg = ns_service_group.get(member['attrs'][1], None)
    #         if not ns_sg and not ns_service:
    #             continue
    #         if ns_sg:
    #             servers += self.convert_ns_service_group(
    #                 ns_sg, ns_servers, ns_dns, conv_status)
    #         else:
    #             servers += self.convert_ns_service(
    #                 ns_service, ns_servers, ns_dns, conv_status)
    #     return servers
    #
    # def get_monitors(self, ns_config, group):
    #     ns_sg = ns_config.get('bind serviceGroup', {})
    #     ns_service_binding = ns_config.get('bind service', {})
    #
    #     if isinstance(group, dict):
    #         group = [group]
    #     monitor_ref = []
    #     for member in group:
    #         if len(member['attrs']) < 2:
    #             continue
    #         mon_ref = []
    #         cmd = "bind service %s %s" % (member['attrs'][1], member['attrs'][0])
    #         group_cmd = "bind service group %s %s" % (member['attrs'][1], member['attrs'][0])
    #
    #         service_groups = ns_sg.get(member['attrs'][1], [])
    #         if service_groups and isinstance(service_groups, dict):
    #             service_groups = [service_groups]
    #         self.get_monitor_names(service_groups, mon_ref, group_cmd)
    #
    #         services = ns_service_binding.get(member['attrs'][1], [])
    #         if services and isinstance(services, dict):
    #             services = [services]
    #         self.get_monitor_names(services, mon_ref, cmd)
    #
    #         if mon_ref:
    #             monitor_ref += mon_ref
    #
    #     return list(set(monitor_ref))
    #
    # def get_monitor_names(self, bindings, mon_ref, cmd):
    #     for binding in bindings:
    #         s_cmd = 'add service'
    #         full_cmd = ns_util.get_netscalar_full_command(cmd, binding)
    #         mon_name = binding.get('monitorName', None)
    #         if mon_name:
    #             mon_name = mon_name.replace('"', '').strip().replace(' ', '_')
    #             mon_ref.append(mon_name)
    #             LOG.info('Added service : %s' % cmd)
    #             ns_util.add_status_row(s_cmd, binding['attrs'][0], full_cmd, STATUS_SUCCESSFUL, binding)
    #         elif binding.get('CustomServerID', None) or \
    #                 binding.get('hashId', None) or \
    #                 binding.get('policyName', None):
    #             LOG.warning('Command not supported : %s' % cmd)
    #             ns_util.add_status_row(s_cmd, binding['attrs'][0], full_cmd, STATUS_SKIPPED)
    #
    # def convert_ns_service(self, ns_service, ns_servers, ns_dns, conv_status):
    #     attrs = ns_service.get('attrs')
    #     cmd = 'add service'
    #     status = ns_util.get_conv_status(ns_service, self.service_skip,
    #                                      self.service_na, [], self.skip_for_val)
    #
    #     full_cmd = ns_util.get_netscalar_full_command(cmd, ns_service)
    #     ns_util.add_conv_status(cmd, attrs[0], full_cmd, status, ns_service)
    #     server = ns_servers.get(attrs[1])
    #     if not server:
    #         return []
    #     cmd = 'add server'
    #     status = ns_util.get_conv_status(server, self.server_skip,
    #                                      [], [])
    #     full_cmd = ns_util.get_netscalar_full_command(cmd, server)
    #     ip_addr = server['attrs'][1]
    #     enabled = True
    #     state = server.get('state', 'ENABLED')
    #     if not state == 'ENABLED':
    #         enabled = False
    #     port = attrs[3]
    #     if port in ("*", "0"):
    #         port = "1"
    #
    #     if ip_addr in ns_dns:
    #         if isinstance(ns_dns[ip_addr], list):
    #             ip_addr = ns_dns[ip_addr][0]['attrs'][1]
    #         elif isinstance(ns_dns[ip_addr], dict):
    #             ip_addr = ns_dns[ip_addr]['attrs'][1]
    #
    #     matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', ip_addr)
    #
    #     server_obj = {
    #         'server': {
    #             'ip': {
    #                 'addr': ip_addr,
    #                 'type': 'V4'
    #             },
    #             'port': port,
    #             'enabled': enabled
    #         },
    #         'name': attrs[0]
    #     }
    #
    #     if not matches:
    #         ns_util.add_status_row(cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
    #         LOG.warning('Not found IP of server : %s' % full_cmd)
    #         return []
    #
    #     ns_util.add_conv_status(cmd, server['attrs'][0], full_cmd, status, server_obj)
    #     return [server_obj]
    #
    # def convert_ns_service_group(self, ns_service_group, ns_servers,
    #                              ns_dns, conv_status):
    #     servers = []
    #     if isinstance(ns_service_group, dict):
    #         ns_service_group = [ns_service_group]
    #
    #     for server_binding in ns_service_group:
    #         if server_binding.get('monitorName', None):
    #             continue
    #         attrs = server_binding.get('attrs')
    #         cmd = 'bind serviceGroup'
    #         status = ns_util.get_conv_status(server_binding, self.bind_sg_skip,
    #                                          [], [])
    #         full_cmd = ns_util.get_netscalar_full_command(cmd, server_binding)
    #         ns_util.add_conv_status(cmd, attrs[0], full_cmd, status, server_binding)
    #         server = ns_servers.get(attrs[1])
    #         if not server:
    #             ns_util.add_status_row(cmd, attrs[1], full_cmd, STATUS_SKIPPED)
    #             LOG.error('Skipped server : %s' % cmd)
    #             continue
    #
    #         cmd = 'add server'
    #         full_cmd = ns_util.get_netscalar_full_command(cmd, server)
    #         status = ns_util.get_conv_status(server, self.server_skip,
    #                                          [], [])
    #         ip_addr = server['attrs'][1]
    #         if ip_addr in ns_dns:
    #             if isinstance(ns_dns[ip_addr], list):
    #                 ip_addr = ns_dns[ip_addr][0]['attrs'][1]
    #             elif isinstance(ns_dns[ip_addr], dict):
    #                 ip_addr = ns_dns[ip_addr]['attrs'][1]
    #         enabled = True
    #         state = server.get('state', 'ENABLED')
    #         if not state == 'ENABLED':
    #             enabled = False
    #         port = attrs[2]
    #         if port in ("*", "0"):
    #             port = "1"
    #         matches = re.findall('[0-9]+.[[0-9]+.[0-9]+.[0-9]+', ip_addr)
    #         server_obj = {
    #             'ip': {
    #                 'addr': ip_addr,
    #                 'type': 'V4'
    #             },
    #             'port': port,
    #             'enabled': enabled,
    #             'health_monitor': server_binding.get('monitorName')
    #
    #         }
    #         server_obj = {
    #             'server': {
    #                 'ip': {
    #                     'addr': ip_addr,
    #                     'type': 'V4'
    #                 },
    #                 'port': port,
    #                 'enabled': enabled
    #             },
    #             'name': server['attrs'][0],
    #             'health_monitor': server_binding.get('monitorName')
    #         }
    #         if not matches:
    #             ns_util.add_status_row(cmd, server['attrs'][0], full_cmd, STATUS_SKIPPED)
    #             LOG.warning('Not found IP of server : %s %s' % (cmd, attrs[1]))
    #             server_obj = None
    #         if server_obj:
    #             servers.append(server_obj)
    #         ns_util.add_conv_status(cmd, server['attrs'][0], full_cmd, status, server_obj)
    #     return servers
