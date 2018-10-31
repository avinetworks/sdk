"""
This file is used to define constants which are used across code.
"""

import yaml
import re
import os
# Status Constants which are used in CSV/report generation of the conversion run.
STATUS_SKIPPED = 'SKIPPED'
STATUS_SUCCESSFUL = 'SUCCESSFUL'
STATUS_INDIRECT = 'INDIRECT'
STATUS_DUMMY = 'DUMMY'
STATUS_NOT_APPLICABLE = 'NOT APPLICABLE'  # Its specific netscalar commands
# which are not applicable in AVI
STATUS_PARTIAL = 'PARTIAL'
STATUS_DATASCRIPT = 'DATASCRIPT'
STATUS_EXTERNAL_MONITOR = 'EXTERNAL MONITOR'
STATUS_COMMAND_NOT_SUPPORTED = 'NOT SUPPORTED'  # Commands are not supported in
# AVI yet
STATUS_INCOMPLETE_CONFIGURATION = 'INCOMPLETE CONFIGURATION'
STATUS_MISSING_FILE = 'MISSING FILE'
STATUS_NOT_IN_USE = 'NOT IN USE'
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
STATUS_LIST = [STATUS_SKIPPED, STATUS_SUCCESSFUL, STATUS_INDIRECT,
               STATUS_NOT_APPLICABLE, STATUS_PARTIAL, STATUS_DATASCRIPT,
               STATUS_EXTERNAL_MONITOR, STATUS_COMMAND_NOT_SUPPORTED,
               STATUS_INCOMPLETE_CONFIGURATION, STATUS_MISSING_FILE]

# Regex for IPV6
IPV6_Address = re.compile('^(?:(?:[0-9A-Fa-f]{1,4}:){6}'
                                      '(?:[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}|'
                                      '(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}|'
                                      '2[0-4][0-9]|25[0-5])\\.){3}(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|'
                                      '25[0-5]))|::(?:[0-9A-Fa-f]{1,4}:){5}'
                                      '(?:[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}|'
                                      '(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}|'
                                      '2[0-4][0-9]|25[0-5])\\.){3}(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|'
                                      '25[0-5]))|(?:[0-9A-Fa-f]{1,4})?::(?:'
                                      '[0-9A-Fa-f]{1,4}:){4}(?:[0-9A-Fa-f]'
                                      '{1,4}:[0-9A-Fa-f]{1,4}|(?:(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|'
                                      '25[0-5])\\.){3}(?:[0-9]|[1-9][0-9]|'
                                      '1[0-9]{2}|2[0-4][0-9]|25[0-5]))|(?:[0'
                                      '-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4})?::(?'
                                      ':[0-9A-Fa-f]{1,4}:){3}(?:[0-9A-Fa-f]'
                                      '{1,4}:[0-9A-Fa-f]{1,4}|(?:(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|'
                                      '25[0-5])\\.){3}(?:[0-9]|[1-9][0-9]|'
                                      '1[0-9]{2}|2[0-4][0-9]|25[0-5]))|'
                                      '(?:(?:[0-9A-Fa-f]{1,4}:){,2}'
                                      '[0-9A-Fa-f]{1,4})?::(?:[0-9A-Fa-f]'
                                      '{1,4}:){2}(?:[0-9A-Fa-f]{1,4}:'
                                      '[0-9A-Fa-f]{1,4}|(?:(?:[0-9]|[1-9]'
                                      '[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.)'
                                      '{3}(?:[0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4]'
                                      '[0-9]|25[0-5]))|(?:(?:[0-9A-Fa-f]{1,4}:)'
                                      '{,3}[0-9A-Fa-f]{1,4})?::[0-9A-Fa-f]'
                                      '{1,4}:(?:[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]'
                                      '{1,4}|(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}'
                                      '|2[0-4][0-9]|25[0-5])\\.){3}(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))'
                                      '|(?:(?:[0-9A-Fa-f]{1,4}:){,4}[0-9A-Fa-f]'
                                      '{1,4})?::(?:[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]'
                                      '{1,4}|(?:(?:[0-9]|[1-9][0-9]|1[0-9]{2}'
                                      '|2[0-4][0-9]|25[0-5])\\.){3}(?:[0-9]|'
                                      '[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25'
                                      '[0-5]))|(?:(?:[0-9A-Fa-f]{1,4}:){,5}'
                                      '[0-9A-Fa-f]{1,4})?::[0-9A-Fa-f]{1,4}|'
                                      '(?:(?:[0-9A-Fa-f]{1,4}:){,6}'
                                      '[0-9A-Fa-f]{1,4})?::)$')

netscalar_command_status = None

def init():
    """
    This function defines that to initialize contant from yaml file
    :return: None
    """
    global netscalar_command_status
    with open(os.path.dirname(__file__)+ "/command_status.yaml") as stream:
        netscalar_command_status = yaml.safe_load(stream)


