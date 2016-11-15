import logging
import avi.netscaler_converter.ns_util as ns_util

LOG = logging.getLogger(__name__)


class ServiceConverter(object):

    bind_lb_skipped = ['priority', 'gotoPriorityExpression', 'type', 'invoke']
    service_skip = ['clearTextPort', 'cacheType', 'maxReq', 'useproxyport',
                    'sc', 'rtspSessionidRemap', 'CKA', 'maxBandwidth',
                    'monThreshold', 'netProfile', 'td', 'dnsProfileName']
    service_na = ['pathMonitor', 'pathMonitorIndv', 'accessDown', 'appflowLog',
                  'processLocal']

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
        for group_key in groups.keys():
            try:
                conv_status = []
                group = groups.get(group_key)
                # cmd = 'bind lb vserver %s' % group_key
                # status = ns_util.get_conv_status(group, self.bind_lb_skipped,
                #                                  [], [])
                # conv_status.append({'cmd': cmd, 'status': status})
                name = '%s-pool' % group_key
                servers = self.get_servers(ns_config, group, conv_status)
                lb_vs = lb_vs_conf.get(group_key)
                ns_algo = lb_vs.get('lbMethod', 'LEASTCONNECTION')
                algo = ns_util.get_avi_lb_algorithm(ns_algo)
                pool_obj = \
                    {
                        "name": name,
                        "servers": servers,
                        "lb_algorithm": algo
                    }
                monitor_names = self.get_monitors(ns_config, group)
                avi_monitors = avi_config["HealthMonitor"]
                monitor_refs = []
                for ref in monitor_names:
                    refs = [mon for mon in avi_monitors
                            if mon['name'] == ref]
                    if refs:
                        monitor_refs.append(ref)
                    else:
                        LOG.warn('Health monitor %s not found in avi config'
                                 % ref)

                pool_obj["health_monitor_refs"] = list(set(monitor_refs))
                avi_config['Pool'].append(pool_obj)

                for status in conv_status:
                    ns_util.add_conv_status(status['cmd'], status['status'],
                                            pool_obj)
            except:
                LOG.error('Error in bind lb vserver conversion bound to: %s' %
                          group_key, exc_info=True)

    def get_servers(self, ns_config, group, conv_status):
        servers = []
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
            if not ns_service and len(member['attrs']) > 1:
                ns_sg = ns_service_group.get(member['attrs'][1], None)
            if not ns_sg and not ns_service:
                continue
            if ns_sg:
                servers += self.convert_ns_service_group(
                    ns_sg, ns_servers, conv_status)
            else:
                servers += self.convert_ns_service(
                    ns_service, ns_servers, conv_status)
        return servers

    def get_monitors(self, ns_config, group):
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
        return list(set(mon_ref))

    def get_monitor_names(self, bindings, mon_ref, member):
        for binding in bindings:
            if len(member['attrs']) < 2:
                continue
            if binding.get('monitorName', None) and \
                            member['attrs'][1] == binding['attrs'][0]:
                    mon_ref.append(binding.get('monitorName'))

    def convert_ns_service(self, ns_service, ns_servers, conv_status):
        attrs = ns_service.get('attrs')
        cmd = 'add service %s' % attrs[0]
        status = ns_util.get_conv_status(ns_service, self.service_skip,
                                         self.service_na, [], self.skip_for_val)
        conv_status.append({'cmd': cmd, 'status': status})
        server = ns_servers.get(attrs[1])
        cmd = 'add server %s' % server['attrs'][0]
        status = ns_util.get_conv_status(server, self.server_skip,
                                         [], [])
        conv_status.append({'cmd': cmd, 'status': status})
        ip_addr = server['attrs'][1]
        enabled = True
        state = server.get('state', 'ENABLED')
        if not state == 'ENABLED':
            enabled = False
        port = attrs[3]
        if port == "*":
            port = "0"
        server_obj = {
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        }
        return [server_obj]

    def convert_ns_service_group(self, ns_service_group, ns_servers,
                                 conv_status):
        servers = []
        if isinstance(ns_service_group, dict):
            ns_service_group = [ns_service_group]

        for server_binding in ns_service_group:
            LOG.debug(server_binding)
            if server_binding.get('monitorName', None):
                continue
            attrs = server_binding.get('attrs')
            cmd = 'bind serviceGroup %s' % attrs[0]
            status = ns_util.get_conv_status(server_binding, self.bind_sg_skip,
                                             [], [])
            conv_status.append({'cmd': cmd, 'status': status})
            server = ns_servers.get(attrs[1])

            cmd = 'add server %s' % server['attrs'][0]
            status = ns_util.get_conv_status(server, self.server_skip,
                                             [], [])
            conv_status.append({'cmd': cmd, 'status': status})

            ip_addr = server['attrs'][1]
            enabled = True
            state = server.get('state', 'ENABLED')
            if not state == 'ENABLED':
                enabled = False
            port = attrs[2]
            server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'port': port,
                'enabled': enabled
            }
            servers.append(server_obj)
        return servers
