from avi.sdk.avi_api import ApiSession
import json
import pexpect
def create_session(c_ip, username, password, tenant='admin', api_version="17.1.1"):
    """
    creates controller session
    :return: session object
    """
    api = ApiSession.get_session(c_ip, username, password, tenant=tenant, api_version=api_version)
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


def delete_registered_client(ssh_session, client_ip):
    """
    delete registered clients
    :param ssh_session:
    :param client_ip:
    """
    delete_cmd = "client delete -c %s" % (client_ip)
    try:
        ssh_session.sendline(delete_cmd)
        ssh_session.expect('Are you sure you wish to delete client named')
        print "Are you sure you wish to delete client named"
        ssh_session.sendline("proceed")
        print "proceed"
        ssh_session.expect("'client delete' successful")
        print "client deleted successfully"
    except Exception as e:
        print "Error while deleting client %s" % e

def verify_client_register(ssh_session):
    register_resp = ssh_session.expect("'client register' successful")
    if register_resp == 0:
        print "client registerd successfully"
        return
    else:
        raise Exception("client registraion failed")


def register_client_on_hsmserver(hsmserver_ip, username, password, client_ip):
    """
    register client on hsm server
    """
    ssh_session = create_ssh_session(hsmserver_ip, username, password)
    hsm_login_resp = ssh_session.expect("lunash:>")
    if hsm_login_resp == 0:
        print "Logged in to HSM "
    register_cmd = "client register -c %s -i %s" % (client_ip, client_ip)
    ssh_session.sendline(register_cmd)
    print register_cmd
    try:
        verify_client_register(sshsession)
        return
    except Exception as e:
        try:
            ssh_session.expect("client with the same IP address has already been registered", 5)
            print "client with the same IP address has already been registered"
            #if client is already registered then delete and re-register it
            delete_registered_client(ssh_session, client_ip)
            hsm_login_resp = ssh_session.expect("lunash:>")
            if hsm_login_resp == 0:
                ssh_session.sendline(register_cmd)
                verify_client_register(sshsession)
        except Exception as e:
            try:
                #if <client_ip>.pem cert not found on HSM server
                cli_cert_not_found = ssh_session.expect("There was a problem finding this client's certificate file")
                if cli_cert_not_found == 0:
                    raise Exception("There was a problem finding this client's certificate file")
            except:
                print "Exception: %s" % e


def client_assign_partition(sshsession, client_ip, partition_name):
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
            print "successfully assigned partition to the client"
            return
    except:
        try:
            sshsession.expect("client already has access")
            print "The client already has access to the specified partition"
        except Exception as e:
            print "Exception e: " % e


def read_file(filepath):
    """
    read the contents of file
    """
    try:
        with open(filepath, 'r') as infile:
            return infile.read()
    except Exception as e:
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
    tenant_resp = session.get("tenant")["results"]
    for tenant in tenant_resp:
        if tenant['name'] == tenant_name:
            return tenant['uuid']


def create_hsm_safenet_group(hsmgrp_name, session, tenant='admin', hsm_server_details = [], client_ips=[], is_ha=False):
    """
    created the HSM safenet group
    :param hsmgrp_name: HSM group name
    :param session: api session of controller
    :param tenant: tenant name
    :param hsm_server_details: hsm server details eg. [{"remote_ip": "", "partition_passwd":"", "server_cert": server_cert}]
    :param client_ips: client IP address for HSM server
    :param is_ha: HA mode
    :return: contents of HSM group creation response
    """
    hsm_group_obj = {}
    hsm_group_obj['name'] = hsmgrp_name
    hsm_group_obj['tenant_uuid'] = get_tenant_uuid(session, tenant)
    hsm_group_obj['hsm'] = {'type': 'HSM_TYPE_SAFENET_LUNA', 'sluna': {}}
    hsm_group_obj['hsm']['sluna']['server'] = hsm_server_details
    hsm_group_obj['hsm']['sluna']['node_info'] = []

    for client_ip in client_ips:
        hsm_group_obj['hsm']['sluna']['node_info'].append({"client_ip": client_ip})
    hsm_group_obj['hsm']['sluna']['is_ha'] = is_ha
    data = json.dumps(hsm_group_obj)
    out = session.post("hardwaresecuritymodulegroup", data=data, tenant=hsm_group_obj['tenant_uuid'])
    return out.content