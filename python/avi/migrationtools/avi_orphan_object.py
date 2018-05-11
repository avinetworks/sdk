#!/usr/bin/env python
import urlparse

# global vs reference object
global vs_ref_dict_g

PATH_KEY_MAP = {'poolgroup': 'PoolGroup', 'healthmonitor': 'HealthMonitor',
                'sslprofile': 'SSLProfile', 'httppolicyset': 'HTTPPolicySet',
                'sslkeyandcertificate': 'SSLKeyAndCertificate', 'pool': 'Pool',
                'networkprofile': 'NetworkProfile', 'pkiprofile': 'PKIProfile',
                'stringgroup': 'StringGroup', 'vrfcontext': 'VrfContext',
                'applicationprofile': 'ApplicationProfile', 'vsdatascriptset':
                    'VSDataScriptSet', 'networksecuritypolicy':
                    'NetworkSecurityPolicy', 'applicationpersistenceprofile':
                    'ApplicationPersistenceProfile', 'prioritylabels':
                    'PriorityLabels', 'vsvip': 'VsVip', 'tenant': "Tenant",
                'serviceenginegroup': 'ServiceEngineGroup',
                'virtualservice': 'VirtualService'}

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


def search_obj(entity, name, new_config, avi_config, vs_ref_dict):
    """
    Method to search referenced object
    :param entity: object type
    :param name: object name
    :param new_config: filtered config
    :param avi_config: full config
    :param : Recursion  to determine level in the vs reference tree
    """
    avi_conf_key = PATH_KEY_MAP.get(entity, '')
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
        find_and_add_objects(found_obj, avi_config, new_config, vs_ref_dict)


def find_and_add_objects(obj_dict, avi_config, new_config, vs_ref_dict,
                         vs_flag=False):
    """
    Method to iterate in one object find references and add those to output
    :param obj_dict: Object to be iterated over
    :param avi_config: Full config
    :param new_config: Filtered config
    :param : Recursion  to determine level in the vs reference tree
    """
    global vs_name
    for key in obj_dict:
        if (key.endswith('ref') and key not in ['cloud_ref']):
            if not obj_dict[key]:
                continue
            entity, name = get_name_and_entity(obj_dict[key])
            tenant_name = None
            # creating vs reference dict with unique keys
            if 'tenant_ref' in obj_dict:
                ee, tenant_name = get_name_and_entity(obj_dict['tenant_ref'])
            key = '%s$$%s$$%s' %(name, entity, tenant_name)
            if vs_flag:
                vs_name = obj_dict['name']
            if key in vs_ref_dict and vs_name not in vs_ref_dict[key]:
                vs_ref_dict[key].append(vs_name)
            else:
                vs_ref_dict[key] = [vs_name]
            search_obj(entity, name, new_config, avi_config, vs_ref_dict)
        elif key.endswith('refs'):
            for ref in obj_dict[key]:
                tenant_name = None
                entity, name = get_name_and_entity(ref)
                # creating vs reference dict with unique keys
                if 'tenant_ref' in obj_dict:
                    ee, tenant_name = get_name_and_entity(
                        obj_dict['tenant_ref'])
                key = '%s$$%s$$%s' % (name, entity, tenant_name)
                if vs_flag:
                    vs_name = obj_dict['name']
                if key in vs_ref_dict and vs_name not in vs_ref_dict[key]:
                    vs_ref_dict[key].append(vs_name)
                else:
                    vs_ref_dict[key] = [vs_name]
                search_obj(entity, name, new_config, avi_config, vs_ref_dict)
        elif isinstance(obj_dict[key], dict):
            find_and_add_objects(obj_dict[key], avi_config, new_config,
                                 vs_ref_dict)
        elif obj_dict[key] and isinstance(obj_dict[key], list) \
                and isinstance(obj_dict[key][0], dict):
            for member in obj_dict[key]:
                find_and_add_objects(member, avi_config, new_config,
                                     vs_ref_dict)
    return


def filter_for_vs(avi_config):
    """
    Filters vs and its references from full configuration
    :param avi_config: full configuration
    :param vs_names: comma separated vs names to filter
    :return: Filtered config dict
    """
    global vs_ref_dict_g
    new_config = []
    vs_ref_dict = dict()
    for vs in avi_config['VirtualService']:
        vs_flag = True
        if 'tenant_ref' in vs:
            link, tenant = get_name_and_entity(vs['tenant_ref'])
        name = '%s-%s-%s' % (vs['name'], 'VirtualService', tenant)
        new_config.append(name)
        find_and_add_objects(vs, avi_config, new_config, vs_ref_dict,
                             vs_flag=vs_flag)
    vs_ref_dict_g = vs_ref_dict
    return new_config


def get_vs_ref():
    """ Function to return the global vs reference object """
    return vs_ref_dict_g


def get_full_name(ele, key):
    tenant = None
    if 'tenant_ref' in ele:
        link, tenant = get_name_and_entity(ele['tenant_ref'])
    name = '%s-%s-%s' % (ele['name'], key, tenant)
    return name


def wipe_out_not_in_use(avi_config):
    """

    :param avi_config:
    :return:
    """
    use_obj = filter_for_vs(avi_config)
    for key in DEFAULT_META_ORDER:
        if key not in avi_config:
            continue
        obj_list = avi_config[key]
        new_list = [obj for obj in obj_list if
                    get_full_name(obj, key) in use_obj]
        avi_config[key] = new_list
    return avi_config
