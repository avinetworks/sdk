common_task_args = {'controller': "{{ controller }}",
                        'username': "{{ username }}",
                        'password': "{{ password }}"
                        }
ansible_dict = dict({
        'connection': 'local',
        'hosts': 'localhost',
        'vars': common_task_args,
        'tasks': []})

DEFAULT_SKIP_TYPES = [
    'SystemConfiguration', 'Network', 'debugcontroller', 'VIMgrVMRuntime',
    'VIMgrIPSubnetRuntime', 'Alert', 'VIMgrSEVMRuntime', 'VIMgrClusterRuntime',
    'VIMgrHostRuntime', 'DebugController', 'ServiceEngineGroup',
    'SeProperties', 'ControllerProperties', 'CloudProperties']


SKIP_FIELDS = ['uuid', 'url', 'ref_key', 'se_uuids', 'key_passphrase']
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

HTTP_TYPE = 'http'
SSL_TYPE = 'ssl'
DNS_TYPE = 'dns'
L4_TYPE = 'l4'
APPLICATION_PROFILE_REF = 'application_profile_ref'
ENABLE_F5 = 'enablef5'
DISABLE_F5 = 'disablef5'
ENABLE_AVI = 'enableavi'
DISABLE_AVI = 'disableavi'
CREATE_OBJECT = 'create_object'
VIRTUALSERVICE = 'virtualservice'
GEN_TRAFFIC = 'generate_traffic'
USERNAME = 'username'
PASSWORD = 'password'
NAME = 'name'
VIP = 'vip'
SERVICES = 'services'
CONTROLLER = 'controller'
API_VERSION = 'api_version'
POOL_REF = 'pool_ref'
TAGS = 'tags'
SERVER = 'server'
USER = 'user'
REQEST_TYPE = 'request_type'
IP_ADDRESS = 'ip_address'
VALIDATE_CERT = 'validate_certs'
TASKS = 'tasks'
CONTROLLER_INPUT = "{{controller}}"
USER_NAME = "{{username}}"
PASSWORD_NAME = "{{password}}"
AVI_VIRTUALSERVICE = 'avi_virtualservice'
STATE = 'state'
DISABLE = 'disabled'
BIGIP_VS_SERVER = 'bigip_virtual_server'
DELEGETE_TO = 'delegate_to'
LOCAL_HOST = 'localhost'
ENABLE = 'enabled'
F5_SERVER = "{{server}}"
F5_USERNAME = "{{f5_username}}"
F5_PASSWORD = "{{f5_password}}"
AVI_TRAFFIC = 'avi_traffic'
PORT = 'port'
ADDR = 'addr'
WHEN = 'when'
REGISTER = 'register'
VALUE = 'result'
RESULT = "result.success!=0"
VS_NAME = 'virtualservice_name'
TENANT = 'tenant'
ANSIBLE_STR = '# Auto-generated from Avi Configuration\n'
HELP_STR = '''
Converts Avi Config JSON to Ansible Playbooks.
Please ensure configuration is exported with options
include_name=true&uuid_refs=true as:
Example:
    api/configuration/export?include_name=true&uuid_refs=true

Example to export a single virtualservice:
    api/configuration/export/virtualservice/<vs-uuid>?include_name=true
    &uuid_refs=true

Example to export a single serviceengine:
    api/configuration/export/serviceengine/>se_uuid>?include_name=true
    &uuid_refs=true
'''