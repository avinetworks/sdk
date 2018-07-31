import yaml
import os

DEFAULT_TIMEOUT = 16
DEFAULT_INTERVAL = 5
DEFAULT_TIME_UNTIL_UP = 1
PORT_START = 1
PORT_END = 65535
DEFAULT_PORT = 80
DEFAULT_FAILED_CHECKS = 1
DEFAULT_MAX_HEADER = 49152
BYTES_IN_KB = 1024
MIN_CACHE_OBJ_SIZE = 100
MAX_CACHE_OBJ_SIZE = 4194304
DEFAULT_CACHE_MAX_AGE = 600
DEFAULT_CACHE_MAX_ENTRIES = 0
DEFAULT_RECV_WIN = 64
MIN_RECV_WIN = 32
MAX_RECV_WIN = 65536
MIN_SYN_RETRANS = 3
MAX_SYN_RETRANS = 8
HTTPS_PORT = 443
HTTP_PORT = 80
POP3_PORT = 110
IMAP_PORT = 143
FTP_PORT = 21
SMTP_PORT = 25
SNMP_PORT = 161
TELNET_PORT = 23
SNMP_TRAP_PORT = 162
SSH_PORT = 22
XFER_PORT = 82
PCSYNC_HTTPS_PORT = 8443
MACROMEDIA_FCS_PORT = 1935
SEC_IN_MIN = 60
MIN_IN_HR = 60
HR_IN_DAY = 24
SOURCE_ADDR_TIMEOUT = 180
MIN_SESSION_TIMEOUT = 60
MAX_SESSION_TIMEOUT = 1800
DEFAULT_CONTENT_TYPE = ['text/html', 'text/xml', 'text/plain',
                        'application/pdf', 'text/javascript',
                        'application/javascript', 'application/x-javascript',
                        'application/xml', 'text/css']

# Status Constants which are used in CSV/report generation of the conversion
# run.
STATUS_SKIPPED = 'SKIPPED'
STATUS_SUCCESSFUL = 'SUCCESSFUL'
STATUS_ERROR = 'ERROR'
STATUS_NOT_APPLICABLE = 'NOT APPLICABLE'  # Its specific netscalar commands
# which are not applicable in AVI
STATUS_PARTIAL = 'PARTIAL'
STATUS_DATASCRIPT = 'DATASCRIPT'
STATUS_NOT_IN_USE = 'NOT IN USE'
# External status which are not supported Health monitors
STATUS_EXTERNAL_MONITOR = 'EXTERNAL MONITOR'
STATUS_MISSING_FILE = 'MISSING FILE'
# Object type constant which are used in object reference generation
OBJECT_TYPE_SSL_PROFILE = 'sslprofile'
OBJECT_TYPE_APPLICATION_PROFILE = 'applicationprofile'
OBJECT_TYPE_HTTP_POLICY_SET = 'httppolicyset'
OBJECT_TYPE_POOL_GROUP = 'poolgroup'
OBJECT_TYPE_POOL = 'pool'
OBJECT_TYPE_NETWORK_PROFILE = 'networkprofile'
OBJECT_TYPE_PKI_PROFILE = 'pkiprofile'
OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE = 'sslkeyandcertificate'
OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE = 'applicationpersistenceprofile'
OBJECT_TYPE_HEALTH_MONITOR = 'healthmonitor'
OBJECT_TYPE_VIRTUAL_SERVICE = 'virtualservice'
OBJECT_TYPE_STRING_GROUP = 'stringgroup'
# Complexity status constant
COMPLEXITY_ADVANCED = 'ADVANCED'
COMPLEXITY_BASIC = 'BASIC'
# Not supported constant.
STATUS_NOT_SUPPORTED = 'NOT SUPPORTED'
STATUS_LIST = [STATUS_SKIPPED, STATUS_SUCCESSFUL, STATUS_NOT_APPLICABLE,
               STATUS_ERROR, STATUS_PARTIAL, STATUS_DATASCRIPT]
HM_CUSTOM_KEY = 'healthmonitor_custom_config'
RULE_CUSTOM_KEY = 'irule_custom_config'

DUMMY_DS = {
    'datascript': [
        {
            'evt': 'VS_DATASCRIPT_EVT_HTTP_REQ',
            'script': 'if avi.http.get_query("intro", "true") == "hello%20world" then avi.http.add_header("intro", "true") end'
        }
    ]
}

DUMMY_REQ_POLICY = {
    'http_request_policy': {
        'rules': [
            {
                'index': 1,
                'hdr_action': [
                    {
                        'action': "HTTP_REPLACE_HDR",
                        'hdr': {
                            'name': "dummy",
                            'value': {
                                'val': "dummy"
                            }
                        }
                    }
                ],
                'all_headers': False,
                'match':
                {
                    'hdrs': [
                        {
                            'hdr': "dummy",
                            'match_criteria': "HDR_EXISTS"
                        }
                    ]
                },
                'name': "Rule 1"
            }
        ]
    },
    'is_internal_policy': False
}

DUMMY_NW_POLICY = {
    'rules': [
        {
            'index': 1,
            'enable': True,
            'name': "Rule 1",
            'action': "NETWORK_SECURITY_POLICY_ACTION_TYPE_ALLOW",
            'match': {
                'client_ip': {
                    'addrs': [
                        {
                            'type': "V4",
                            'addr': "1.1.1.1"
                        }
                    ],
                    'match_criteria': "IS_IN"
                }
            },
            'log': False
        }
    ]
}

HTTP_TO_HTTPS_REDIRECT_POL = {
    "http_request_policy": {
        "rules": [
            {
                "index": 1,
                "redirect_action": {
                    "keep_query": True,
                    "status_code":
                        "HTTP_REDIRECT_STATUS_CODE_302",
                    "protocol": "HTTPS",
                    "port": 443
                },
                "enable": True,
                "name": "HTTP-To-HTTPS-Redirect",
                "match": {
                    "protocol": {
                        "protocols": "HTTP",
                        "match_criteria": "IS_IN"
                    }
                }
            }
        ]
    },
"is_internal_policy": False
}

def init(version):
    """
    This function defines that to initialize constant from yaml file
    :return: None
    """
    global f5_command_status
    with open(os.path.dirname(__file__) + "/command_status.yaml") as stream:
        f5_command_status = yaml.safe_load(stream)
    if version == '10':
        return f5_command_status['VERSION_10']
    else:
        return f5_command_status['VERSION_11']
