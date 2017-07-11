from avi.sdk.avi_api import ApiSession
import json
import pexpect
import logging

LOG = logging.getLogger(__name__)

def create_session(c_ip, username, password, tenant='admin', api_version="17.1.1"):
    """
    creates controller session
    :return: session object
    """
    api = ApiSession.get_session(c_ip, username, password, tenant=tenant, api_version=api_version)
    LOG.debug("session created")
    print "session created"
    return api


def scp_file(remote_ip, username, password, src, dest, remote_to_local=True):
    """
    scp the file from remote to local or local to remote
    :return: True if succeeds
    """
    if remote_to_local:
        cmd = "scp %s@%s:%s %s " % (username, remote_ip, src, dest)
    else:
        cmd = "scp %s %s@%s:%s" % (src, username, remote_ip, dest)
    scp_session = pexpect.spawn(cmd)
    try:
        response = scp_session.expect('Are you sure you want to continue connecting (yes/no)?', 5)
        if response == 0:
            scp_session.sendline("Yes")
    except Exception as e:
        LOG.debug("Exception: %s" % e)
        print "Exception: %s" % e
        pass
    password_response = scp_session.expect('password:')
    if password_response == 0:
        scp_session.sendline(password)
        scp_response = scp_session.expect('100%')
        if scp_response == 0:
            scp_session.close()
            return True
    scp_session.close()
    return False


def create_ssh_session(host_ip, username, password):
    """
    Creates ssh connection with host
    :return: ssh session handle which can use to execute further commands on remote host
    """
    cmd = "ssh %s@%s" % (username, host_ip)
    ssh_session = pexpect.spawn(cmd)
    try:
        response = ssh_session.expect('Are you sure you want to continue connecting (yes/no)?', 5)
        if response == 0:
            ssh_session.sendline("Yes")
    except:
        pass
    password_response = ssh_session.expect('password:')
    if password_response == 0:
        ssh_session.sendline(password)
        ssh_response = ssh_session.expect('Last login:')
        if ssh_response == 0:
            return ssh_session
    return


def hsm_client_delete(ssh_session, client_ip):
    """
    delete registered clients
    :param ssh_session:
    :param client_ip:
    """
    delete_cmd = "client delete -c %s" % (client_ip)
    try:
        ssh_session.sendline(delete_cmd)
        ssh_session.expect('Are you sure you wish to delete client named')
        LOG.debug("Are you sure you wish to delete client named")
        print "Are you sure you wish to delete client named"
        ssh_session.sendline("proceed")
        LOG.debug("proceed")
        print "proceed"
        ssh_session.expect("'client delete' successful")
        LOG.debug("client deleted successfully")
        print "client deleted successfully"
    except Exception as e:
        LOG.error("Error while deleting client %s" % e)
        print "Error while deleting client %s" % e

def verify_client_register(ssh_session):
    register_resp = ssh_session.expect("'client register' successful")
    if register_resp == 0:
        LOG.debug("client registerd successfully")
        print "client registerd successfully"
        return
    else:
        LOG.error("client registration failed")
        raise Exception("client registration failed")


def hsm_client_setup(hsmserver_ip, username, password, client_ip, partition_name):
    """
    scp the client certs from controller to HSM(<client_ip>.pem)
    """
    ssh_session = create_ssh_session(hsmserver_ip, username, password)
    hsm_client_register(ssh_session, client_ip)
    hsm_client_assign_partition(ssh_session, client_ip, partition_name)


def hsm_client_register(ssh_session, client_ip):
    """
    register client on hsm server
    """

    hsm_login_resp = ssh_session.expect("lunash:>")
    if hsm_login_resp == 0:
        LOG.debug("Logged in to HSM ")
        print "Logged in to HSM "
    register_cmd = "client register -c %s -i %s" % (client_ip, client_ip)
    ssh_session.sendline(register_cmd)
    print register_cmd
    LOG.debug(register_cmd)
    try:
        verify_client_register(ssh_session)
        return
    except Exception as e:
        try:
            ssh_session.expect("client with the same IP address has already been registered", 5)
            LOG.debug("client with the same IP address has already been registered")
            print "client with the same IP address has already been registered"
            #if client is already registered then delete and re-register it
            hsm_client_delete(ssh_session, client_ip)
            hsm_login_resp = ssh_session.expect("lunash:>")
            if hsm_login_resp == 0:
                ssh_session.sendline(register_cmd)
                verify_client_register(ssh_session)
        except Exception as e:
            try:
                #if <client_ip>.pem cert not found on HSM server
                cli_cert_not_found = ssh_session.expect("There was a problem finding this client's certificate file")
                if cli_cert_not_found == 0:
                    raise Exception("There was a problem finding this client's certificate file")
            except:
                LOG.error("Exception: %s" % e)
                print "Exception: %s" % e


def hsm_client_assign_partition(sshsession, client_ip, partition_name):
    """
    Assigns partition to registered client
    :param sshsession: loggedin session for HSM server
    :param client_ip: client IP address to which the partition is to be aassigned
    :param partition_name: partition name
    :return:
    """
    cmd = "client assignPartition -c %s -p %s" % (client_ip, partition_name)
    sshsession.sendline(cmd)
    try:
        par_assign_resp = sshsession.expect("'client assignPartition' successful")
        if par_assign_resp == 0:
            LOG.debug("successfully assigned partition to the client")
            print "successfully assigned partition to the client"
            return
    except:
        try:
            sshsession.expect("client already has access")
            LOG.debug("The client already has access to the specified partition")
            print "The client already has access to the specified partition"
        except Exception as e:
            LOG.error("Exception e: " % e)
            print "Exception e: " % e


def read_file(filepath):
    """
    read the contents of file
    """
    try:
        with open(filepath, 'r') as infile:
            return infile.read()
    except Exception as e:
        LOG.error("Error: %s" % e)
        raise Exception("Error: %s" % e)


def get_hsm_server_cert(server_ip, username, password):
    """
    get HSM server cert from HSM server
    """
    server_pem_file = "/tmp/server%s.pem" % server_ip
    scp_file(server_ip, username, password, "server.pem",server_pem_file)
    server_cert = read_file(server_pem_file)
    return server_cert


def get_tenant_uuid(session, tenant_name):
    """
    returns the tenant_uuid for given tenant name
    """
    tenant_resp = session.get_object_by_name("tenant", tenant_name)
    tenant_uuid = session.get_obj_uuid(tenant_resp)
    return tenant_uuid


def create_hsm_safenet_group(hsmgrp_name, session, tenant='admin', hsm_server_details = [], client_ips=[]):
    """
    created the HSM safenet group
    :param hsmgrp_name: HSM group name
    :param session: api session of controller
    :param tenant: tenant name
    :param hsm_server_details: hsm server details eg. [{server_ip: <server_ip>, hsm_username: <hsm_username>
     hsm_password: <hsm_password>, partition_password: <partition_passwd>}]
    :param client_ips: client IP address for HSM server
    :return: contents of HSM group creation response
    """
    hsm_group_obj = {}
    hsm_group_obj['name'] = hsmgrp_name
    hsm_group_obj['tenant_uuid'] = get_tenant_uuid(session, tenant)
    hsm_group_obj['hsm'] = {'type': 'HSM_TYPE_SAFENET_LUNA', 'sluna': {}}
    #hsm_group_obj['hsm']['sluna']['server'] = hsm_server_details
    hsm_group_obj['hsm']['sluna']['server'] = []
    hsm_group_obj['hsm']['sluna']['node_info'] = []
    for hsm_server in hsm_server_details:
        server_cert = get_hsm_server_cert(hsm_server["server_ip"], hsm_server['hsm_username'], hsm_server['hsm_password'])
        hsm_server_detail = {"remote_ip": hsm_server["server_ip"], "partition_passwd": hsm_server['partition_password'],
                             "server_cert": server_cert}
        hsm_group_obj['hsm']['sluna']['server'].append(hsm_server_detail)

    for client_ip in client_ips:
        hsm_group_obj['hsm']['sluna']['node_info'].append({"client_ip": client_ip})

    data = json.dumps(hsm_group_obj)
    out = session.post("hardwaresecuritymodulegroup", data=data, tenant=hsm_group_obj['tenant_uuid'])
    return out.content


def set_hsm_ha(hsmgrp_name, session, tenant='admin', is_ha=True):
    """
    updates HA mode for HSM
    """
    hsm_grp_resp = session.get_object_by_name("hardwaresecuritymodulegroup", hsmgrp_name, tenant=tenant)
    hsm_grp_resp['hsm']['sluna']['is_ha'] = is_ha
    hsm_update_resp = session.put_by_name("hardwaresecuritymodulegroup", hsmgrp_name, data=hsm_grp_resp, tenant=tenant)
    if hsm_update_resp.status_code >= 300:
        raise Exception("Failed to set HSM HA. Error: %s" % hsm_update_resp.content)


def get_hsm_grp_uuid(session, hsm_grp_name, tenant="admin"):
    """
    returns the hsm group uuid for name
    """
    hsm_resp = session.get_object_by_name("hardwaresecuritymodulegroup", hsm_grp_name, tenant=tenant)
    hsm_grp_uuid = session.get_obj_uuid(hsm_resp)
    return hsm_grp_uuid


def scp_client_cert_on_hsm(session, hsm_grp_name, client_ip, hsm_ip, hsm_username, hsm_password, tenant="admin"):
    """
    scp the client certs from controller to HSM
    """
    hsm_grp_uuid = get_hsm_grp_uuid(session, hsm_grp_name, tenant)
    client_cert_name = "/etc/luna/cert/client/%s.pem-%s" % (client_ip, hsm_grp_uuid)
    dest_path = "/tmp/%s.pem" % client_ip
    scp_file(session.controller_ip, session.username, session.password, client_cert_name, dest_path)
    scp_file(hsm_ip, hsm_username, hsm_password, dest_path, "%s.pem" % client_ip, remote_to_local=False)


def verify_hsm_group(session, hsm_grp_name, controller_ip):
    """
    verify hsm group is configured successfully or not
    """
    ssh_session = create_ssh_session(session.controller_ip, session.username, session.password)

    hsm_verify_cmd = 'sudo /opt/avi/scripts/safenet.py -p %s -i %s -c "/usr/safenet/lunaclient/bin/vtl verify"'\
                     % (hsm_grp_name, controller_ip)
    ssh_session.sendline(hsm_verify_cmd)
    try:
        sudo_passswd_resp = ssh_session.expect("password for")
        if sudo_passswd_resp == 0:
            ssh_session.sendline(session.password)
    except:
        pass

    try:
        hsm_verify_resp = ssh_session.expect("Serial #")
        if hsm_verify_resp == 0:
            LOG.debug("HSM group verified successfully")
            print "HSM group verified successfully"
    except Exception as e:
        hsm_verify_resp = ssh_session.expect("Error: Unable to find any Luna SA slots/partitions among registered")
        if hsm_verify_resp == 0:
            LOG.error("Error: Unable to find any Luna SA slots/partitions among registered server")
            print "Error: Unable to find any Luna SA slots/partitions among registered server"
        else:
            LOG.error("Error: %s" % e)
            print "Error: %s" % e

    hsm_listslots_cmd = 'sudo /opt/avi/scripts/safenet.py -p %s -i %s -c ' \
                        '"/usr/safenet/lunaclient/bin/vtl listslots"' % (hsm_grp_name, controller_ip)

    ssh_session.sendline(hsm_listslots_cmd)
    try:
        hsm_listslots_resp = ssh_session.expect("Present")
        if hsm_listslots_resp == 0:
            LOG.debug("HSM group listslots verified successfully")
            print "HSM group listslots verified successfully"
    except Exception as e:
        LOG.error("HSM group listslots verification failed")
