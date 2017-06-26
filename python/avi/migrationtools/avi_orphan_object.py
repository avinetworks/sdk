#!/usr/bin/env python
import urlparse

PATH_KEY_MAP = {'poolgroup': 'PoolGroup', 'healthmonitor': 'HealthMonitor',
                'sslprofile': 'SSLProfile', 'httppolicyset': 'HTTPPolicySet',
                'sslkeyandcertificate': 'SSLKeyAndCertificate', 'pool': 'Pool',
                'networkprofile': 'NetworkProfile', 'pkiprofile': 'PKIProfile',
                'stringgroup': 'StringGroup', 'vrfcontext': 'VrfContext',
                'applicationprofile': 'ApplicationProfile', 'vsdatascriptset':
                    'VSDataScriptSet', 'networksecuritypolicy':
                    'NetworkSecurityPolicy', 'applicationpersistenceprofile':
                    'ApplicationPersistenceProfile', 'prioritylabels':
                    'PriorityLabels', 'vsvip': 'VsVip', 'tenant': "Tenant"
                }

DEFAULT_META_ORDER = [
        "ControllerLicense",
        "SeProperties",
        "SecureChannelToken",
        "SecureChannelMapping",
        "VIMgrIPSubnetRuntime",
        "Tenant",
        "ControllerProperties",
        "CloudProperties",
        "SecureChannelAvailableLocalIPs",
        "JobEntry",
        "Role",
        "DebugController",
        "AutoScaleLaunchConfig",
        "MicroService",
        "AuthProfile",
        "AnalyticsProfile",
        "APICLifsRuntime",
        "LogControllerMapping",
        "SnmpTrapProfile",
        "AlertSyslogConfig",
        "NetworkRuntime",
        "AlertObjectList",
        "VIPGNameInfo",
        "CertificateManagementProfile",
        "CloudRuntime",
        "CloudConnectorUser",
        "DebugServiceEngine",
        "HardwareSecurityModuleGroup",
        "HealthMonitor",
        "VIDCInfo",
        "VIMgrControllerRuntime",
        "GlobalHealthMonitor",
        "IpamDnsProviderProfile",
        "StringGroup",
        "Backup",
        "DebugVirtualService",
        "AlertScriptConfig",
        "NetworkProfile",
        "GlobalLB",
        "IpAddrGroup",
        "Cluster",
        "SSLProfile",
        "PKIProfile",
        "ApplicationPersistenceProfile",
        "MicroServiceGroup",
        "SSLKeyAndCertificate",
        "GlobalService",
        "ApplicationProfile",
        "NetworkSecurityPolicy",
        "SystemConfiguration",
        "Cloud",
        "AlertEmailConfig",
        "PriorityLabels",
        "PoolGroupDeploymentPolicy",
        "VIMgrVMRuntime",
        "VrfContext",
        "ActionGroupConfig",
        "VIMgrHostRuntime",
        "AlertConfig",
        "VIMgrNWRuntime",
        "VIMgrClusterRuntime",
        "VIMgrSEVMRuntime",
        "ServerAutoScalePolicy",
        "Network",
        "VIMgrDCRuntime",
        "ServiceEngineGroup",
        "Pool",
        "VIMgrVcenterRuntime",
        "ServiceEngine",
        "PoolGroup",
        "HTTPPolicySet",
        "VSDataScriptSet",
        "VirtualService",
        "Alert",
        "Application"
    ]


def get_name_and_entity(url):
    """
    Parses reference string to extract object type and
    :param url: reference url to be parsed
    :return: entity and object name
    """
    parsed = urlparse.urlparse(url)
    return parsed.path.split('/')[2], urlparse.parse_qs(parsed.query)['name'][0]


def search_obj(entity, name, new_config, avi_config):
    """
    Method to search referenced object
    :param entity: object type
    :param name: object name
    :param new_config: filtered config
    :param avi_config: full config
    :param : Recursion  to determine level in the vs reference tree
    """
    avi_conf_key = PATH_KEY_MAP[entity]
    found_obj = None
    name_obj = None
    if avi_conf_key in avi_config:
        found_obj_list = avi_config[avi_conf_key]
        found_obj = [obj for obj in found_obj_list if obj['name'] == name]
    if found_obj:
        found_obj = found_obj[0]
        tenant =  None
        if 'tenant_ref' in found_obj:
            link, tenant = get_name_and_entity(found_obj['tenant_ref'])
        name_obj = '%s-%s-%s' % (found_obj['name'], avi_conf_key, tenant)
        if new_config and name_obj not in new_config:
            new_config.append(name_obj)
        find_and_add_objects(found_obj, avi_config, new_config)


def find_and_add_objects(obj_dict, avi_config, new_config):
    """
    Method to iterate in one object find references and add those to output
    :param obj_dict: Object to be iterated over
    :param avi_config: Full config
    :param new_config: Filtered config
    :param : Recursion  to determine level in the vs reference tree
    """
    for key in obj_dict:
        if (key.endswith('ref') and key not in ['cloud_ref']):
            if not obj_dict[key]:
                continue
            entity, name = get_name_and_entity(obj_dict[key])
            search_obj(entity, name, new_config, avi_config, )
        elif key.endswith('refs'):
            for ref in obj_dict[key]:
                entity, name = get_name_and_entity(ref)
                search_obj(entity, name, new_config, avi_config, )
        elif isinstance(obj_dict[key], dict):
            find_and_add_objects(obj_dict[key], avi_config, new_config)
        elif obj_dict[key] and isinstance(obj_dict[key], list) \
                and isinstance(obj_dict[key][0], dict):
            for member in obj_dict[key]:
                find_and_add_objects(member, avi_config, new_config)
    return


def filter_for_vs(avi_config):
    """
    Filters vs and its references from full configuration
    :param avi_config: full configuration
    :param vs_names: comma separated vs names to filter
    :return: Filtered config dict
    """
    new_config = []
    for vs in avi_config['VirtualService']:
        if 'tenant_ref' in vs:
            link, tenant = get_name_and_entity(vs['tenant_ref'])
        name = '%s-%s-%s' % (vs['name'], 'VirtualService', tenant)
        new_config.append(name)
        find_and_add_objects(vs, avi_config, new_config)
    return new_config


def wipe_out_not_in_use(avi_config):
    """

    :param avi_config:
    :return:
    """
    use_obj = filter_for_vs(avi_config)
    for obj in DEFAULT_META_ORDER:
        if obj not in avi_config:
            continue
        for ele in avi_config[obj]:
            tenant = None
            if 'tenant_ref' in ele:
                link, tenant = get_name_and_entity(ele['tenant_ref'])
            name = '%s-%s-%s' % (ele['name'], obj, tenant)
            if name not in use_obj:
                avi_config[obj].remove(ele)

    return avi_config
