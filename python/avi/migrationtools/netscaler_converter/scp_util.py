import logging
import os
from avi.migrationtools.scp_util import SCPUtil

LOG = logging.getLogger(__name__)


def get_files_from_ns(local_path, host, username, pw=None, key=None):
    local_path = local_path + os.path.sep
    scp = SCPUtil(host, username, pw, key)
    scp.get_all_files('/flash/nsconfig/ssl/', local_path)
    scp.get_all_files('/flash/nsconfig/monitors/', local_path)
    scp.get('/flash/nsconfig/ns.conf', local_path + 'ns.conf')
    scp.close()

if __name__ == "__main__":
    input_folder_location = "D:\\avi\\test"
    host = "10.90.120.254"
    username = "nsroot"
    pw = "nsroot"
    get_files_from_ns(input_folder_location, host, username, pw)

