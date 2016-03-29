import json
import copy
import numbers
import logging
import os

from openpyxl import Workbook

LOG = logging.getLogger("converter-log")
row_count = 1
ws = None


def get_port_by_protocol(protocol):
    port = 80
    if protocol == "https":
        port = 443
    elif protocol == "ftp":
        port = 21
    elif protocol == "smtp":
        port = 25
    elif protocol == "snmp":
        port = 161
    elif protocol == "telnet":
        port = 23
    elif protocol == "snmp-trap":
        port = 162
    elif protocol == "ssh":
        port = 22
    return port



def convert_servers_config(servers_config):
    """
    Converts the config of servers in the pool
    :param servers_config: F5 servers config for particular pool
    :param nodes: F5 node config to resolve IP of the server
    :return: List of Avi server configs
    """
    server_list = []
    skipped_list = []
    supported_attributes = ['session']
    for server_name in servers_config.keys():
        skipped = None
        server = servers_config[server_name]
        parts = server_name.split(':')
        ip_addr = parts[0]
        port = parts[1] if len(parts) == 2 else 80
        if not port.isdigit():
            port = get_port_by_protocol(port)
        enabled = True
        state = 'enabled'
        if server:
            state = server.get("session", 'enabled')
            skipped = [key for key in server.keys() if key not in
                  supported_attributes]
        if state == "user disabled":
            enabled = False
        server_list.append({
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        })

        if skipped:
            skipped_list.append({server_name: skipped})
    return server_list, skipped_list


def get_avi_pool_down_action(action):
    """
    Maps Pool down action from F5 config to Avi Config
    :param action: F5 action string
    :return: Avi action String
    """
    if action == "reset":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    if action == "reselect":
        return "POOL_DOWN_ACTION_CLOSE_CONN"
    else:
        return "POOL_DOWN_ACTION_CLOSE_CONN"


def convert_pool_config(pool_config, tenant, monitor_config_list):
    """
    Convert list of pools from F5 config to Avi config
    :param pool_config: F5 pool config
    :param tenant: name of tenant for default objects
    :param monitor_config_list: Avi monitor config list
    :return: List of pools converted to Avi configuration
    """
    pool_list = []
    supported_attr = ['members', 'monitor', 'action on svcdown']
    for pool_name in pool_config.keys():
        skipped = []
        f5_pool = pool_config[pool_name]
        if not f5_pool:
            LOG.debug("Empty pool skipped for conversion :"+pool_name)
            add_status_row('pool', None, pool_name, 'skipped', None, None)
            continue
        servers, member_skipped_config = convert_servers_config(
            f5_pool.get("members", {}))
        sd_action = f5_pool.get("action on svcdown", "")
        pd_action = get_avi_pool_down_action(sd_action)
        pool_obj = {
                "name": pool_name,
                "servers": servers,
                "pd_action_type": pd_action
            }
        monitor_names = f5_pool.get("monitor", None)
        default_monitors = {"http": "System-HTTP", "https": "System-HTTPS",
                            "tcp": "System-TCP", "icmp": "System-Ping",
                            "udp": "System-UDP", "gateway_icmp": "System-Ping"}
        is_ssl = False
        skipped_monitors = []
        if monitor_names:
            monitors = monitor_names.split(" ")
            monitor_refs = []
            for monitor in monitors:
                if monitor in ["and", "all", "min", "of"] or monitor.isdigit():
                    continue
                monitor_obj = [obj for obj in monitor_config_list
                               if obj["name"] == monitor]
                if monitor_obj:
                    monitor_refs.append(monitor_obj[0]["name"])
                    if monitor_obj[0]["type"] == "HEALTH_MONITOR_HTTPS":
                        is_ssl = True
                elif monitor in default_monitors.keys():
                    if monitor == "https":
                        is_ssl = True
                    monitor = tenant+":"+default_monitors[monitor]
                    monitor_refs.append(monitor)
                else:
                    LOG.warning("Skiping non supported monitor: %s for pool %s"
                                % (monitor, pool_name))
                    skipped_monitors.append(monitor)
            pool_obj["health_monitor_refs"] = monitor_refs
        if is_ssl:
            pool_obj["ssl_profile_ref"] = "admin:System-Standard"
        pool_list.append(pool_obj)
        skipped_attr = [key for key in f5_pool.keys() if
                        key not in supported_attr]
        if skipped_attr:
            skipped.append(skipped_attr)
        if member_skipped_config:
            skipped.append(member_skipped_config)
        if skipped_monitors:
            skipped.append({"monitors": skipped_monitors})
        if skipped:
            add_status_row('pool', None, pool_name, 'partial', skipped, pool_obj)
        else:
            add_status_row('pool', None, pool_name, 'successful', skipped, pool_obj)
    return pool_list

def get_defaults(f5_monitor, monitor_config):
    """
    Monitor can have inheritance used by attribute defaults-from in F5
    configuration this method recursively gets all the attributes from the
    default objects and forms complete object
    :param f5_monitor: F5 monitor object
    :param monitor_config: List of F5 monitor configs
    :return:
    """
    parent_name = f5_monitor.get("defaults from", None)
    if parent_name:
        parent_monitor = monitor_config.get(parent_name, None)
        if parent_monitor:
            parent_monitor = get_defaults(parent_monitor, monitor_config)
            parent_monitor = copy.deepcopy(parent_monitor)
            parent_monitor.update(f5_monitor)
            f5_monitor = parent_monitor
        else:
            f5_monitor["type"] = parent_name
    return f5_monitor


def convert_monitor_entity(name, f5_monitor):
    """
    Conversion of single F5 monitor object to Avi health monitor object
    :param name: name of health monitor
    :param f5_monitor: F5 monitor config object
    :return: Avi monitor config object
    """
    supported_attributes = ["timeout", "interval", "time until up",
                            "description", "type", "defaults from"]
    skipped = [key for key in f5_monitor.keys() if
              key not in supported_attributes]
    timeout = int(f5_monitor.get("timeout", 16))
    interval = int(f5_monitor.get("interval", 5))
    time_until_up = int(f5_monitor.get("time until up", 1))
    successful_checks = int(timeout/interval)
    if time_until_up > 0:
        failed_checks = int(time_until_up/interval)
    else:
        failed_checks = 1
    description = f5_monitor.get("description", None)
    monitor_dict = dict()
    monitor_dict["name"] = name
    monitor_dict["receive_timeout"] = interval-1
    monitor_dict["failed_checks"] = failed_checks
    monitor_dict["send_interval"] = interval
    monitor_dict["successful_checks"] = successful_checks
    if description:
        monitor_dict["description"] = description

    if f5_monitor["type"] == "http":
        monitor_dict["type"] = "HEALTH_MONITOR_HTTP"
        monitor_dict["http_monitor"] = {
            "http_request": "HEAD / HTTP/1.0",
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
    elif f5_monitor["type"] == "https":
        monitor_dict["type"] = "HEALTH_MONITOR_HTTPS"
        monitor_dict["https_monitor"] = {
            "http_request": "HEAD / HTTP/1.0",
            "http_response_code": [
                {"code": "HTTP_2XX"}, {"code": "HTTP_3XX"}
            ]}
    elif f5_monitor["type"] == "tcp":
        tcp_attr = ["dest", "send", "recv"]
        skipped = [key for key in skipped if key not in tcp_attr]
        destination = f5_monitor.get("dest", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_TCP"
        request = f5_monitor.get("send", None)
        response = f5_monitor.get("recv", None)
        if request or response:
            tcp_monitor = {"tcp_request": request, "tcp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
    elif f5_monitor["type"] == "udp":
        udp_attr = ["dest", "send", "recv"]
        skipped = [key for key in skipped if key not in udp_attr]
        destination = f5_monitor.get("dest", "*:*")
        dest_str = destination.split(":")
        if len(dest_str) > 1 and isinstance(dest_str[1], numbers.Integral):
            monitor_dict["monitor_port"] = dest_str[1]
        monitor_dict["type"] = "HEALTH_MONITOR_UDP"
        request = f5_monitor.get("send", None)
        response = f5_monitor.get("recv", None)
        if request or response:
            tcp_monitor = {"udp_request": request, "udp_response": response}
            monitor_dict["tcp_monitor"] = tcp_monitor
    elif f5_monitor["type"] in ["gateway-icmp", "icmp"]:
        monitor_dict["type"] = "HEALTH_MONITOR_PING"
    elif f5_monitor["type"] == "external":
        ext_attr = ["run", "args", "user-defined"]
        skipped = [key for key in skipped if key not in ext_attr]
        monitor_dict["type"] = "HEALTH_MONITOR_EXTERNAL"
        ext_monitor = {
            "command_code": f5_monitor.get("run", None),
            "command_parameters": f5_monitor.get("args", None),
            "command_variables": f5_monitor.get("user-defined", None)
        }
        monitor_dict["external_monitor"] = ext_monitor
    return monitor_dict, skipped


def convert_monitor_config(monitor_config):
    """
    Convert F5 monitor config dict to Avi health monitor config list
    :param monitor_config: F5 monitor config dict
    :return: List of Avi health monitor objects
    """
    monitor_list = []
    supported_types = ["http", "https", "dns", "external", "tcp", "udp",
                       "gateway_icmp", "icmp"]
    for key in monitor_config.keys():
        f5_monitor = monitor_config[key]
        if not f5_monitor:
            add_status_row('monitor', '', key, 'skipped', None, None)
            continue
        f5_monitor = get_defaults(f5_monitor, monitor_config)
        if f5_monitor["type"] not in supported_types:
            LOG.debug("Monitor type not supported by Avi : "+key)
            add_status_row('monitor', f5_monitor["type"], key, 'skipped',
                           None, None)
            continue
        avi_monitor, skipped = convert_monitor_entity(key, f5_monitor)
        if skipped:
            add_status_row('monitor', f5_monitor["type"], key, 'partial',
                           skipped, avi_monitor)
        else:
            add_status_row('monitor', f5_monitor["type"], key, 'successful',
                           None, avi_monitor)
        monitor_list.append(avi_monitor)

    return monitor_list


def add_status_row(f5_type, f5_sub_type, f5_id, status, skipped_params,
                   avi_object):
    global row_count
    global ws
    ws['A'+str(row_count)] = f5_type
    ws['B'+str(row_count)] = f5_sub_type
    ws['C'+str(row_count)] = f5_id
    ws['D'+str(row_count)] = status
    ws['E'+str(row_count)] = str(skipped_params)
    ws['F'+str(row_count)] = str(avi_object)
    row_count += 1


def convert_to_avi_dict(f5_config_dict, output_file_path,
                        vs_state, certs_location, tenant, option):
    global row_count
    global ws
    wb = Workbook()
    ws = wb.active
    ws['A'+str(row_count)] = 'F5 type'
    ws['B'+str(row_count)] = 'F5 SubType'
    ws['C'+str(row_count)] = 'F5 ID'
    ws['D'+str(row_count)] = 'Status'
    ws['E'+str(row_count)] = 'Skipped settings'
    ws['F'+str(row_count)] = 'Avi Object'
    row_count += 1
    avi_config_dict = {}
    monitor_config_list = convert_monitor_config(f5_config_dict.get(
        "monitor", {}))
    del f5_config_dict["monitor"]
    avi_config_dict["HealthMonitor"] = monitor_config_list
    LOG.debug("Converted health monitors")
    avi_pool_list = convert_pool_config(f5_config_dict.get("pool", {}), tenant,
                                        monitor_config_list)
    del f5_config_dict["pool"]
    avi_config_dict["Pool"] = avi_pool_list
    LOG.debug("Converted pools")
    # f5_profile_dict = f5_config_dict.get("profile", {})
    # avi_profiles, string_group = convert_profile_config(
    #     f5_profile_dict, certs_location, option)
    # del f5_config_dict["profile"]
    # avi_config_dict["SSLKeyAndCertificate"] = avi_profiles["ssl_key_cert_list"]
    # avi_config_dict["SSLProfile"] = avi_profiles["ssl_profile_list"]
    # avi_config_dict["PKIProfile"] = avi_profiles["pki_profile_list"]
    # avi_config_dict["ApplicationProfile"] = avi_profiles["app_profile_list"]
    # avi_config_dict["NetworkProfile"] = avi_profiles["network_profile_list"]
    # avi_config_dict["StringGroup"] = string_group
    # LOG.debug("Converted ssl profiles")
    # avi_vs_list = convert_vs_config(f5_config_dict.get("virtual", {}), vs_state,
    #                                 tenant, avi_pool_list, avi_profiles)
    # avi_config_dict["VirtualService"] = avi_vs_list
    # del f5_config_dict["virtual"]
    # LOG.debug("Converted VS")
    for f5_type in f5_config_dict.keys():
        f5_obj = f5_config_dict[f5_type]
        for key in f5_obj.keys():
            sub_type = None
            if ' ' in key:
                sub_type, key = key.rsplit(' ', 1)
            add_status_row(f5_type, sub_type, key, 'skipped', None, None)
    wb.save(filename = output_file_path+os.path.sep+"ConversionStatus.xls")
    return avi_config_dict