import logging
import os

from avi.migrationtools.scp_util import SCPUtil


LOG = logging.getLogger(__name__)


def get_files_from_f5(local_path, host, username, pw=None, key=None):
    local_path = local_path + os.path.sep
    scp = SCPUtil(host, username, pw, key)
    scp.get_all_files('/config/ssl/ssl.crl/', local_path)
    scp.get_all_files('/config/ssl/ssl.crt/', local_path)
    scp.get_all_files('/config/ssl/ssl.csr/', local_path)
    scp.get_all_files('/config/ssl/ssl.key/', local_path)
    scp.get_all_files('/config/monitors/', local_path)
    scp.get('/config/bigip.conf', local_path + 'bigip.conf')
    try:
        scp.get('/config/profile_base.conf', local_path + 'profile_base.conf')
    except:
        pass
    try:
        scp.get('/usr/share/monitors/base_monitors.conf', local_path +
                'base_monitors.conf')
    except:
        pass
    try:
        scp.get('/config/bigip_gtm.conf', local_path + 'bigip_gtm.conf')
    except:
        pass
    try:
        scp.get_all_partition_config('/config/partitions/', local_path)
    except:
        pass
    scp.close()
