from copy import deepcopy

common_task_args = {'controller': "{{ controller }}",
                    'username': "{{ username }}",
                    'password': "{{ password }}",
                    'state': "{{ state | default(omit)}}"}


ansible_dict = dict({
    'connection': 'local',
    'hosts': 'localhost',
    'roles': ['avinetworks.avisdk'],
    'vars': deepcopy(common_task_args),
    'tasks': []})

ansible_dict['vars']['state'] = 'present'

DEFAULT_SKIP_TYPES = [
    'SystemConfiguration', 'Network', 'debugcontroller', 'VIMgrVMRuntime',
    'VIMgrIPSubnetRuntime', 'Alert', 'VIMgrSEVMRuntime', 'VIMgrClusterRuntime',
    'VIMgrHostRuntime', 'DebugController', 'ServiceEngineGroup',
    'SeProperties', 'ControllerProperties', 'CloudProperties']


SKIP_FIELDS = ['uuid', 'url', 'ref_key', 'se_uuids', 'key_passphrase']
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
ARP_STATE = 'arp_state'
DISABLE = 'disabled'
BIGIP_VS_SERVER = 'bigip_virtual_server'
BIGIP_VIRTUAL_ADDRESS = 'bigip_virtual_address'
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
RESULT_SUCCESS = 'result.success==0'
VS_NAME = 'vs_name'
TENANT = 'tenant'
ANSIBLE_STR = '# Auto-generated from Avi Configuration\n'
DISABLE_NETSCALER = 'disablenetscaler'
ENABLE_NETSCALER = 'enablenetscaler'
NS_USERNAME = "{{ns_username}}"
NS_PASSWORD = "{{ns_password}}"
NS_HOST = "{{ns_host}}"
NETSCALER_VS_STATUS = 'netscaler_vs_status'
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
