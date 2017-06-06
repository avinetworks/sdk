import logging
import copy
import re
import avi.migrationtools.f5_converter.conversion_util as conv_utils
import avi.migrationtools.f5_converter.converter_constants as conv_const

LOG = logging.getLogger(__name__)


class PoolConfigConv(object):
    @classmethod
    def get_instance(cls, version, f5_pool_attributes, prefix):
        if version == '10':
            return PoolConfigConvV10(f5_pool_attributes, prefix)
        if version in ['11', '12']:
            return PoolConfigConvV11(f5_pool_attributes, prefix)

    def convert_pool(self, pool_name, f5_config, avi_config, user_ignore,
                     tenant_ref, cloud_ref):
        pass

    def convert(self, f5_config, avi_config, user_ignore, tenant_ref,
                cloud_name):
        pool_list = []
        pool_config = f5_config.get('pool', {})
        user_ignore = user_ignore.get('pool', {})
        avi_config['VrfContext'] = []
        avi_config['PoolGroup'] = []
        avi_config['PriorityLabels'] = {}
        for pool_name in pool_config.keys():
            LOG.debug("Converting Pool: %s" % pool_name)
            f5_pool = pool_config[pool_name]
            if not f5_pool:
                LOG.debug("Empty pool skipped for conversion :%s" % pool_name)
                conv_utils.add_status_row('pool', None, pool_name,
                                          conv_const.STATUS_SKIPPED)
                continue
            if 'gateway-failsafe-device' in f5_pool:
                LOG.debug("Not supported gateway-failsafe-device, pool skipped "
                          "for conversion :%s" % pool_name)
                conv_utils.add_status_row('pool', None, pool_name,
                                          conv_const.STATUS_SKIPPED)
                continue
            try:
                converted_objs = self.convert_pool(
                    pool_name, f5_config, avi_config, user_ignore, tenant_ref,
                    cloud_name)
                pool_list += converted_objs['pools']
                if 'pg_obj' in converted_objs:
                    avi_config['PoolGroup'].append(converted_objs['pg_obj'])
                LOG.debug("Conversion successful for Pool: %s" % pool_name)
            except:
                LOG.error("Failed to convert pool: %s" % pool_name,
                          exc_info=True)
                conv_utils.add_status_row('pool', None, pool_name,
                                          conv_const.STATUS_ERROR)
            # labels_dict = avi_config.pop('PriorityLabels', None)
            # if labels_dict:
            #     for tenant in labels_dict:
            #         labels = labels_dict[tenant]
            #         if not tenant_ref == 'admin':
            #             tenant = tenant_ref
            #         labels = list(set(labels))
            #         labels = map(int, labels)
            #         labels.sort(reverse=True)
            #         labels = map(str, labels)
            #         priority_labels = {
            #             "name": "numeric_priority_labels",
            #             "equivalent_labels": [
            #                 {
            #                     "labels": labels
            #                 }
            #             ],
            #             'tenant_ref': conv_utils.get_object_ref(tenant, 'tenant')
            #         }
            #         avi_config['PriorityLabels'] = [priority_labels]

        avi_config['Pool'] = pool_list
        LOG.debug("Converted %s pools" % len(pool_list))
        f5_config.pop('pool', {})

    def get_monitor_refs(self, monitor_names, monitor_config_list, pool_name,
                         tenant_ref):
        skipped_monitors = []
        monitors = monitor_names.split(" ")
        monitor_refs = []
        garbage_val = ["and", "all", "min", "of", "{", "}", "none"]
        for monitor in monitors:
            monitor = monitor.strip()
            if not monitor or monitor in garbage_val or \
                    monitor.isdigit():
                continue
            if self.prefix:
                monitor = '%s-%s' % (self.prefix, monitor)

            tenant, monitor = conv_utils.get_tenant_ref(monitor)
            monitor_obj = [obj for obj in monitor_config_list
                           if obj["name"] == monitor]
            if monitor_obj:
                tenant = conv_utils.get_name_from_ref(
                    monitor_obj[0]['tenant_ref'])
                monitor_refs.append(conv_utils.get_object_ref(
                    monitor_obj[0]['name'], 'healthmonitor',
                    tenant=tenant))
            else:
                LOG.warning("Monitor not found: %s for pool %s" %
                            (monitor, pool_name))
                skipped_monitors.append(monitor)
        return skipped_monitors, monitor_refs

    def create_pool_object(self, name, desc, servers, pd_action, algo,
                           ramp_time, limits, tenant_ref, cloud_ref):
        tenant, name = conv_utils.get_tenant_ref(name)
        # Added prefix for objects
        if self.prefix:
            name = self.prefix + '-' + name
        pool_obj = {
            'name': name,
            'description': desc,
            'servers': servers,
            'fail_action': pd_action,
            'lb_algorithm': algo,
            'cloud_ref': conv_utils.get_object_ref(cloud_ref, 'cloud')
        }
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        pool_obj['tenant_ref'] = conv_utils.get_object_ref(tenant, 'tenant')
        if ramp_time:
            pool_obj['connection_ramp_duration'] = ramp_time
        if limits.get('connection_limit', 0) > 0:
            pool_obj['max_concurrent_connections_per_server'] = \
                limits['connection_limit']
        if limits.get('rate_limit', 0) > 0:
            pool_obj['max_conn_rate_per_server'] = {
                'count': limits['rate_limit']
            }
        return pool_obj

    def check_for_pool_group(self, servers):
        """
        Check if the priority group for the server exist
        :param servers: List of servers to check server priority
        :return: if priority exist returns true and priority wise
        dict of servers
        """
        is_pool_group = False
        for server in servers:
            if 'priority' in server:
                is_pool_group = True
                break
        if not is_pool_group:
            return is_pool_group, None
        pg_dict = dict()
        for server in servers:
            priority = server.get('priority', None)
            if not priority:
                is_pool_group = False
                break
            else:
                del server['priority']
            priority_list = pg_dict.get(priority, [])
            priority_list.append(server)
            pg_dict[priority] = priority_list
        return is_pool_group, pg_dict

    def add_status(self, name, skipped_attr, member_skipped,
                   skipped_monitors, converted_objs, user_ignore):
        skipped = []
        conv_status = dict()
        conv_status['user_ignore'] = []
        if skipped_attr:
            p_ignore = user_ignore.get('pool', [])
            conv_status['user_ignore'] = [val for val in skipped_attr
                                          if val in p_ignore]
            skipped_attr = [attr for attr in skipped_attr
                            if attr not in p_ignore]
            if skipped_attr:
                skipped.append(skipped_attr)
        if member_skipped:
            m_ignore = user_ignore.get('members', [])
            if m_ignore:
                ms_new = []
                um_list = []
                for obj in member_skipped:
                    um_skipped = dict()
                    um_skipped[obj.keys()[0]] = \
                        [val for val in obj[obj.keys()[0]] if val in m_ignore]
                    temp = [val for val in obj[obj.keys()[0]]
                            if val not in m_ignore]
                    if um_skipped[um_skipped.keys()[0]]:
                        um_list.append(um_skipped)
                    if temp:
                        ms_new.append({obj.keys()[0]: temp})
                conv_status['user_ignore'].append(um_list)
                if ms_new:
                    skipped.append(ms_new)
            else:
                skipped.append(member_skipped)

        if skipped_monitors and not user_ignore.get('monitor', None):
            skipped.append({"monitor": skipped_monitors})
        conv_status['skipped'] = skipped
        status = conv_const.STATUS_SUCCESSFUL
        if skipped:
            status = conv_const.STATUS_PARTIAL
        conv_status['status'] = status

        conv_utils.add_conv_status('pool', None, name, conv_status,
                                   converted_objs)

    def convert_for_pg(self, pg_dict, pool_obj, name, tenant, avi_config,
                       cloud_ref):
        """
        Creates a pool group object
        :param pg_dict: priority wise sorted dict of pools
        :param pool_obj: Converted f5 pool object
        :param name: name of the pool
        :param tenant: tenant name for tenant reference
        :param avi_config: Avi config to add temporary labels
        :return:
        """
        pg_members = []
        pools = []
        for priority in pg_dict:
            priority_pool = copy.deepcopy(pool_obj)
            priority_pool['servers'] = pg_dict[priority]
            priority_pool_ref = '%s-%s' % (name, priority)
            # Added prefix for objects
            if self.prefix:
                priority_pool_ref = self.prefix + '-' + priority_pool_ref
            priority_pool['name'] = priority_pool_ref
            pools.append(priority_pool)
            if priority_pool_ref:
                member = {
                    'pool_ref': conv_utils.get_object_ref(
                        priority_pool_ref, 'pool', tenant=tenant,
                        cloud_name=cloud_ref)
                }
                pg_members.append(member)
        # Added prefix for objects
        if self.prefix:
            name = self.prefix + "-" + name
        pg_obj = {
            'name': name,
            'members': pg_members,
            'cloud_ref': conv_utils.get_object_ref(cloud_ref, 'cloud')
        }

        pg_obj['tenant_ref'] = conv_utils.get_object_ref(tenant, 'tenant')
        converted_objs = {
            'pools': pools,
            'pg_obj': pg_obj
        }
        return converted_objs


class PoolConfigConvV11(PoolConfigConv):
    def __init__(self, f5_pool_attributes, prefix):
        self.supported_attr = f5_pool_attributes['Pool_supported_attr']
        self.supported_attributes = f5_pool_attributes[
            'Pool_supported_attr_convert_servers_config']
        self.ignore_for_val = f5_pool_attributes['Pool_ignore_val']
        # Added prefix for objects
        self.prefix = prefix

    def convert_pool(self, pool_name, f5_config, avi_config, user_ignore,
                     tenant_ref, cloud_ref):
        converted_objs = {}
        nodes = f5_config.get("node", {})
        f5_pool = f5_config['pool'][pool_name]
        monitor_config = avi_config['HealthMonitor']
        servers, member_skipped_config, limits = self.convert_servers_config(
            f5_pool.get("members", {}), nodes, avi_config)
        sd_action = f5_pool.get("service-down-action", "")
        pd_action = conv_utils.get_avi_pool_down_action(sd_action)
        lb_method = f5_pool.get("load-balancing-mode", None)
        lb_algorithm = self.get_avi_lb_algorithm(lb_method)
        desc = f5_pool.get('description', None)
        ramp_time = f5_pool.get('slow-ramp-time', None)
        pool_obj = super(PoolConfigConvV11, self).create_pool_object(
            pool_name, desc, servers, pd_action, lb_algorithm, ramp_time,
            limits, tenant_ref, cloud_ref)
        tenant, name = conv_utils.get_tenant_ref(pool_name)
        if not tenant_ref == 'admin':
            tenant = tenant_ref
        num_retries = f5_pool.get('reselect-tries', None)
        if num_retries:
            server_reselect = {
                "retry_nonidempotent": False,
                "svr_resp_code": {
                    "resp_code_block": ["HTTP_RSP_4XX", "HTTP_RSP_5XX"]
                },
                "num_retries": num_retries,
                "enabled": True
            }
            pool_obj['server_reselect'] = server_reselect
        monitor_names = f5_pool.get("monitor", None)
        skipped_monitors = []
        if monitor_names:
            skipped_monitors, monitor_refs = super(
                PoolConfigConvV11, self).get_monitor_refs(
                monitor_names, monitor_config, pool_name, tenant)
            pool_obj["health_monitor_refs"] = monitor_refs
        skipped_attr = [key for key in f5_pool.keys() if
                        key not in self.supported_attr]
        for attr in self.ignore_for_val:
            ignore_val = self.ignore_for_val[attr]
            actual_val = f5_pool.get(attr, None)
            if not actual_val:
                continue
            if isinstance(ignore_val, str) and actual_val == ignore_val:
                skipped_attr.remove(attr)
            elif isinstance(ignore_val, list) and actual_val in ignore_val:
                skipped_attr.remove(attr)
        is_pg, pg_dict = self.check_for_pool_group(servers)
        if is_pg:
            converted_objs = self.convert_for_pg(
                pg_dict, pool_obj, name, tenant, avi_config, cloud_ref)
        else:
            converted_objs['pools'] = [pool_obj]

        super(PoolConfigConvV11, self).add_status(
            pool_name, skipped_attr, member_skipped_config, skipped_monitors,
            converted_objs, user_ignore)

        return converted_objs

    def get_avi_lb_algorithm(self, f5_algorithm):
        """
        Converts f5 LB algorithm to equivalent avi LB algorithm
        :param f5_algorithm: f5 algorithm name
        :return: Avi LB algorithm enum value
        """
        avi_algorithm = None
        if not f5_algorithm or f5_algorithm in ["ratio-node", "ratio-member"]:
            avi_algorithm = "LB_ALGORITHM_ROUND_ROBIN"
        elif f5_algorithm in ["least-connections-member",
                              "least-connections-node", "least-sessions",
                              "weighted-least-connections-member",
                              "ratio-least-connections-member",
                              "ratio-least-connections-node",
                              "weighted-least-connections-node"]:
            avi_algorithm = "LB_ALGORITHM_LEAST_CONNECTIONS"
        elif f5_algorithm in ["fastest-node", "fastest-app-response"]:
            avi_algorithm = "LB_ALGORITHM_FASTEST_RESPONSE"
        elif f5_algorithm in ["dynamic-ratio-node", "observed-member",
                              "predictive-node", "dynamic-ratio-member",
                              "predictive-member", "observed-node"]:
            avi_algorithm = "LB_ALGORITHM_LEAST_LOAD"
        return avi_algorithm

    def convert_servers_config(self, servers_config, nodes, avi_config):
        """
        Converts the config of servers in the pool
        :param servers_config: F5 servers config for particular pool
        :param nodes: F5 node config to resolve IP of the server
        :return: List of Avi server configs
        """
        server_list = []
        skipped_list = []
        rate_limit = []
        connection_limit = []
        for server_name in servers_config.keys():
            server = servers_config[server_name]
            parts = server_name.split(':')
            node = nodes.get(parts[0], None)
            if node:
                if '%' in node["address"]:
                    ip_addr, vrf = node["address"].split('%')
                    conv_utils.add_vrf(avi_config, vrf)
                else:
                    ip_addr = node["address"]
            else:
                if '%' in parts[0]:
                    ip_addr, vrf = parts[0].split('%')
                    conv_utils.add_vrf(avi_config, vrf)
                else:
                    ip_addr = parts[0]
            description = server.get('description', '')
            port = parts[1] if len(parts) == 2 else conv_const.DEFAULT_PORT
            if not port.isdigit():
                port = conv_utils.get_port_by_protocol(port)
            enabled = True
            state = server.get("state", 'enabled')
            session = server.get("session", 'enabled')
            if state == "user-down" or session == 'user-disabled':
                enabled = False
            priority = server.get('priority-group', None)

            ip_addr = ip_addr.strip()
            matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$',
                                 ip_addr)
            if not matches:
                LOG.warning('Avi does not support IPv6. Replace 1.1.1.1 '
                            'ipv4 for : %s' % ip_addr)
                ip_addr = '1.1.1.1'
            server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'enabled': enabled,
                'description': description,
            }
            # Check if port is present and added check for port is digit.
            if port and str(port).isdigit():
                server_obj['port'] = port
            if priority:
                server_obj['priority'] = priority
            ratio = server.get("ratio", None)
            if ratio:
                server_obj["ratio"] = ratio
            r_lim = int(server.get("rate-limit", '0'))
            if r_lim > 0:
                rate_limit.append(r_lim)
            c_lim = int(server.get("connection-limit", '0'))
            if c_lim > 0:
                connection_limit.append(c_lim)
            server_obj_list = [
                s for s in server_list if s['ip']['addr'] ==
                server_obj['ip']['addr'] and
                ('port' in s and 'port' in server_obj)and
                (s['port'] == server_obj['port'])]
            if server_obj_list:
                LOG.warning('Skipped duplicate server %s' % ip_addr)
                continue

            server_list.append(server_obj)
            skipped = [key for key in server.keys()
                       if key not in self.supported_attributes]
            if skipped:
                skipped_list.append({server_name: skipped})
        limits = dict()
        if rate_limit:
            limits['rate_limit'] = min(rate_limit)
        if connection_limit:
            limits['connection_limit'] = min(connection_limit)
        return server_list, skipped_list, limits


class PoolConfigConvV10(PoolConfigConv):
    def __init__(self, f5_pool_attributes, prefix):
        self.supported_attr = f5_pool_attributes['Pool_supported_attr_1']
        self.supported_attributes = f5_pool_attributes['Pool_supported_attr_2']
        self.ignore_for_val = f5_pool_attributes['Pool_ignore_val']
        # Added prefix for objects
        self.prefix = prefix

    def convert_pool(self, pool_name, f5_config, avi_config, user_ignore,
                     tenant_ref, cloud_ref):
        nodes = f5_config.pop("node", {})
        f5_pool = f5_config['pool'][pool_name]
        monitor_config = avi_config['HealthMonitor']
        servers, member_skipped_config, limits = self.convert_servers_config(
            f5_pool.get("members", {}), nodes, avi_config)
        sd_action = f5_pool.get("action on svcdown", "")
        pd_action = conv_utils.get_avi_pool_down_action(sd_action)
        lb_method = f5_pool.get("lb method", None)
        lb_algorithm = self.get_avi_lb_algorithm(lb_method)
        desc = f5_pool.get('description', None)
        ramp_time = f5_pool.get('slow ramp time', None)
        pool_obj = super(PoolConfigConvV10, self).create_pool_object(
            pool_name, desc, servers, pd_action, lb_algorithm, ramp_time,
            limits, tenant_ref, cloud_ref)
        monitor_names = f5_pool.get("monitor", None)
        skipped_monitors = []
        if monitor_names:
            skipped_monitors, monitor_refs = super(
                PoolConfigConvV10, self).get_monitor_refs(
                monitor_names, monitor_config, pool_name, tenant_ref)
            pool_obj["health_monitor_refs"] = monitor_refs

        num_retries = f5_pool.get('reselect tries', None)
        if num_retries:
            server_reselect = {
                "retry_nonidempotent": False,
                "svr_resp_code": {
                    "resp_code_block": ["HTTP_RSP_4XX", "HTTP_RSP_5XX"]
                },
                "num_retries": num_retries,
                "enabled": True
            }
            pool_obj['server_reselect'] = server_reselect

        skipped_attr = [key for key in f5_pool.keys() if
                        key not in self.supported_attr]
        for attr in self.ignore_for_val:
            ignore_val = self.ignore_for_val[attr]
            actual_val = f5_pool.get(attr, None)
            if not actual_val:
                continue
            if isinstance(ignore_val, str) and actual_val == ignore_val:
                skipped_attr.remove(attr)
            elif isinstance(ignore_val, list) and actual_val in ignore_val:
                skipped_attr.remove(attr)
        is_pg, pg_dict = self.check_for_pool_group(servers)
        converted_objs = dict()
        tenant, name = conv_utils.get_tenant_ref(pool_name)
        if is_pg:
            converted_objs = self.convert_for_pg(pg_dict,
                                                 pool_obj, name,
                                                 tenant, avi_config, cloud_ref)
        else:
            converted_objs['pools'] = [pool_obj]

        super(PoolConfigConvV10, self).add_status(
            pool_name, skipped_attr, member_skipped_config, skipped_monitors,
            converted_objs, user_ignore)
        return converted_objs

    def get_avi_lb_algorithm(self, f5_algorithm):
        """
        Converts f5 LB algorithm to equivalent avi LB algorithm
        :param f5_algorithm: f5 algorithm name
        :return: Avi LB algorithm enum value
        """
        avi_algorithm = None
        if not f5_algorithm or f5_algorithm in ["ratio", "member ratio"]:
            avi_algorithm = "LB_ALGORITHM_ROUND_ROBIN"
        elif f5_algorithm in ["member least conn", "least conn", "l3 addr",
                              "weighted least conn member", "least sessions",
                              "weighted least conn node addr"]:
            avi_algorithm = "LB_ALGORITHM_LEAST_CONNECTIONS"
        elif f5_algorithm in ["fastest", "fastest app resp"]:
            avi_algorithm = "LB_ALGORITHM_FASTEST_RESPONSE"
        elif f5_algorithm in ["dynamic ratio", "member observed", "predictive",
                              "member predictive", "observed",
                              "member dynamic ratio"]:
            avi_algorithm = "LB_ALGORITHM_LEAST_LOAD"
        return avi_algorithm

    def convert_servers_config(self, servers_config, nodes, avi_config):
        """
        Converts the config of servers in the pool
        :param servers_config: F5 servers config for particular pool
        :return: List of Avi server configs
        """
        server_list = []
        skipped_list = []
        connection_limit = []
        if isinstance(servers_config, str):
            servers_config = {servers_config.split(' ')[0]: None}
        for server_name in servers_config.keys():
            skipped = None
            server = servers_config[server_name]
            parts = server_name.split(':')
            node = nodes.get(parts[0], None)
            if node and '%' in node.get("address", ''):
                ip_addr, vrf = node["address"].split('%')
                conv_utils.add_vrf(avi_config, vrf)
            else:
                if '%' in parts[0]:
                    ip_addr, vrf = parts[0].split('%')
                    conv_utils.add_vrf(avi_config, vrf)
                else:
                    ip_addr = parts[0]
            port = parts[1] if len(parts) == 2 else conv_const.DEFAULT_PORT
            if not port.isdigit():
                port = conv_utils.get_port_by_protocol(port)
            enabled = True
            state = 'enabled'
            ratio = None
            description = None
            priority = None
            if server:
                state = server.get("session", 'enabled')
                skipped = [key for key in server.keys()
                           if key not in self.supported_attributes]
                ratio = server.get("ratio", None)
                description = server.get('description', None)
                if state == "user disabled" or 'down' in server.keys():
                    enabled = False
                c_lim = int(server.get("limit", '0'))
                if c_lim > 0:
                    connection_limit.append(c_lim)
                priority = server.get('priority', None)
            server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'enabled': enabled,
                'description': description,
            }
            # Check if port is present and added check for port is digit.
            if port and str(port).isdigit():
                server_obj['port'] = port
            else:
                LOG.debug("Pool server port is not digit %s" % str(parts[1]))
            if priority:
                server_obj['priority'] = priority
            if ratio:
                server_obj["ratio"] = ratio
            server_list.append(server_obj)
            if skipped:
                skipped_list.append({server_name: skipped})
        limits = dict()
        if connection_limit:
            limits['connection_limit'] = min(connection_limit)
        return server_list, skipped_list, limits
