"""
This file is used to define constants which are used across code.
"""

import yaml

# Status Constants which are used in CSV/report generation of the conversion run.
STATUS_SKIPPED = 'SKIPPED'
STATUS_SUCCESSFUL = 'SUCCESSFUL'
STATUS_INDIRECT = 'INDIRECT'
STATUS_NOT_APPLICABLE = 'NOT APPLICABLE'  # Its specific netscalar commands which are not applicable in AVI
STATUS_PARTIAL = 'PARTIAL'
STATUS_DATASCRIPT = 'DATASCRIPT'
STATUS_EXTERNAL_MONITOR = 'EXTERNAL MONITOR'
STATUS_COMMAND_NOT_SUPPORTED = 'NOT SUPPORTED'  # Commands are not supported in AVI yet
STATUS_INCOMPLETE_CONFIGURATION = 'INCOMPLETE CONFIGURATION'


def init():
    """
    This function defines that to initialize contant from yaml file
    :return: None
    """
    global netscalar_command_status
    netscalar_command_status = yaml.safe_load(open("command_status.yaml"))
