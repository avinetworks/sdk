import paramiko
import logging
from stat import S_ISDIR

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

    def rexists(self, path):
        """os.path.exists for paramiko's SCP object
        """
        try:
            self.sftp.stat(path)
        except IOError, e:
            if 'No such file' in str(e):
                return False
            raise
        else:
            return True

    def get_all_partition_config(self, partition_path, local_path):
        if not self.rexists(partition_path):
            return
        files = self.get_all_file_names(partition_path)
        for file in files:
            remote_file = partition_path+file+'/bigip.conf'
            if self.isdir(partition_path+file) and self.rexists(remote_file):
                try:
                    self.get(remote_file, local_path+file+'_bigip.conf')
                except IOError as e:
                    LOG.error(
                        "conf file not found in partition dir : %s" % file)

    def isdir(self, path):
        self._openSFTPConnection()
        try:
            return S_ISDIR(self.sftp.stat(path).st_mode)
        except IOError:
            #Path does not exist, so by definition not a directory
            return False
 
    def close(self):
        """
        Close SFTP connection and ssh connection
        """
        if self.sftp_open:
            self.sftp.close()
            self.sftp_open = False
        self.transport.close()
