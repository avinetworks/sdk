import paramiko
import logging
import os

LOG = logging.getLogger(__name__)


class SCPUtil(object):
    def __init__(self, hostname, username, password=None, pkey=None, port=22):
        """Initialize and setup connection"""
        self.sftp = None
        self.sftp_open = False
        # open SSH Transport stream
        self.transport = paramiko.Transport((hostname, port))
        self.transport.connect(username=username, password=password, pkey=pkey)
 
    def _openSFTPConnection(self):
        """
        Opens an SFTP connection if not already open
        """
        if not self.sftp_open:
            self.sftp = paramiko.SFTPClient.from_transport(self.transport)
            self.sftp_open = True
 
    def get(self, remote_path, local_path=None):
        """
        Copies a file from the remote host to the local host.
        """
        self._openSFTPConnection()        
        self.sftp.get(remote_path, local_path)        
 
    def get_all_file_names(self, remote_path):
        """
        Copies a file from the local host to the remote host
        """
        self._openSFTPConnection()
        return self.sftp.listdir(remote_path)

    def get_all_files(self, remote_path, local_path=None):
        files = self.get_all_file_names(remote_path)
        for file in files:
            try:
                self.get(remote_path+file, local_path+file)
            except IOError as e:
                LOG.error(e)
 
    def close(self):
        """
        Close SFTP connection and ssh connection
        """
        if self.sftp_open:
            self.sftp.close()
            self.sftp_open = False
        self.transport.close()


def get_files_from_f5(local_path, host, username, pw=None, key=None):
    local_path = local_path + os.path.sep
    scp = SCPUtil(host, username, pw, key)
    scp.get_all_files('/config/ssl/ssl.crl/', local_path)
    scp.get_all_files('/config/ssl/ssl.crt/', local_path)
    scp.get_all_files('/config/ssl/ssl.csr/', local_path)
    scp.get_all_files('/config/ssl/ssl.key/', local_path)
    scp.get_all_files('/config/monitors/', local_path)
    scp.get('/config/bigip.conf', local_path + 'bigip.conf')
    scp.get('/config/profile_base.conf', local_path + 'profile_base.conf')
    scp.get('/usr/share/monitors/base_monitors.conf', local_path +
            'base_monitors.conf')
    scp.close()

if __name__ == "__main__":
    input_folder_location = "D:/avi/test/"
    host = "10.90.117.121"
    username = "root"
    pw = "avi123"
    get_files_from_f5(input_folder_location, host, username, pw)
