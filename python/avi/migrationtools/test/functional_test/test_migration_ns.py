import logging
import os
import re
import unittest
import pytest
from converter import F5Conversion
from avi.migrationtools.f5_converter.conversion_util import F5Util
import avi.migrationtools.test.functional_test.conversion_constant_util as conv_const
from  avi.migrationtools.netscaler_converter import ns_constants
from avi.migrationtools.netscaler_converter.ns_util import NsUtil

conversion_util = F5Util()
ns_util = NsUtil()

input_file = pytest.config.getoption("--config_file")
output_file = pytest.config.getoption("--output_path")
type = pytest.config.getoption("--type")
controller_version = pytest.config.getoption("--controller_version")
vs_state = pytest.config.getoption("--vs_state")
f5_config_version = pytest.config.getoption("--file_version")
cloudName = pytest.config.getoption("--cloud_name")

log_file = output_file + '/config_check.log'
logging.basicConfig(filename=log_file, level=logging.INFO)
LOG = logging.getLogger()

def setUpModule():

    global ns_config_dict
    global avi_config_dict
    global csvs_supported_types
    netscalerCnv = F5Conversion()
    ns_config_dict, avi_config_dict = netscalerCnv.convert(
         type, input_file, f5_config_version, output_file,
         vs_state, controller_version,cloudName)
    csvs_supported_types = ns_constants.netscalar_command_status['csvs_supported_types']
    # if log_file:
    #     open(log_file, 'w').close()


def compareVirtualService(lb_vs):
    attrs = lb_vs['attrs']
    vsName = attrs[0]
    type = attrs[1]
    ipaddress = attrs[2]
    port = attrs[3]
    if ':' in vsName:
        vsName = re.sub('[:]', '-', vsName)
    for each_avi_vs in avi_config_dict['VirtualService']:
        if each_avi_vs['name'] == vsName:
            return True
    return False

def comparePoolGroup(poolgroup_name):
    avi_poolGroup = avi_config_dict['PoolGroup']
    for each_group in avi_poolGroup:
        if each_group['name'] == poolgroup_name:
            return True
    return False


def check_virtual_service_name(attrs):
    vs_name = attrs[0]
    if ':' in vs_name:
        vs_name = re.sub('[:]','-', vs_name)
    avi_vs_config = avi_config_dict['VirtualService']
    for each_vs in avi_vs_config:
        if each_vs['name'] == vs_name:
            return True, each_vs
    return False, None

def check_vs_ip_and_port(attrs, avi_config):
    ip_address = attrs[2]
    port = attrs[3]
    avi_ip_addr = avi_config['vip'][0]['ip_address']['addr']
    avi_port = avi_config['services'][0]['port']
    if ip_address == avi_ip_addr and port == avi_port:
        return True
    else: return False




def check_poolGroup(poolGroupName):

    for each_group in avi_config_dict['PoolGroup']:
        pool_group_name = each_group['name']
        pool_group_name = re.sub('-poolgroup','',pool_group_name)
        if poolGroupName == pool_group_name:
            pool_refs = each_group['members']
            return True, pool_refs
    return False, None


def getPoolConfig(actual_pool_name):
    avi_pool_config = avi_config_dict['Pool']
    for each_pool in avi_pool_config:
        if actual_pool_name == each_pool['name']:
            return each_pool

def lbvscheckpool(poolName, pool_members,vsName):
    for each_pool in pool_members:
        actual_pool_name = conversion_util.get_name(each_pool['pool_ref'])
        if ':' in poolName:
            poolName = re.sub('[:]', '-', poolName)
        if vsName in actual_pool_name:
            poolName = poolName + '-pool-'+vsName
        else:
            poolName = poolName +'-pool'
        if poolName == actual_pool_name:
             poolConfig = getPoolConfig(actual_pool_name)
             return True, poolConfig
    return False, None
def checkPool(poolName, pool_members):
    #print "pool name => ",poolName , " ", pool_members
    for each_pool in pool_members:
        actual_pool_name = conversion_util.get_name(each_pool['pool_ref'])
        pool_name = re.sub('-pool','',actual_pool_name)
        if ':' in poolName:
            poolName = re.sub('[:]', '-', poolName)
        if poolName == pool_name:
            poolConfig = getPoolConfig(actual_pool_name)
            return True, poolConfig
    return False, None




def checkPoolservers(poolServer, poolConfig):
    serverName = poolServer['attrs'][1]
    port = poolServer['attrs'][3]
    servers = ns_config_dict.get('add server', dict)
    serverattrs = servers.get(serverName)
    ip_address = serverattrs['attrs'][1]
    hostName = serverName
    poolServers = poolConfig['servers']
    for each_server in poolServers:
        avi_pool_server_ip = each_server['ip']['addr']
        avi_host_name = each_server['hostname']
        avi_server_port =  each_server['port']
        if ip_address == avi_pool_server_ip and hostName == avi_host_name and port == avi_server_port:
            #print ip_address ," ", avi_pool_server_ip , " ", hostName, " ", avi_host_name , " ", port , " ", avi_server_port
            return True
    return False

def getHealthMonitorObject(monitorName):
    avi_healthMonitor_object = avi_config_dict['HealthMonitor']
    for each_monitor in avi_healthMonitor_object:
        if each_monitor['name'] == monitorName:
            return each_monitor

def checkHealthMonitor(monitorName, poolConfig):
    bindMonitor = ns_config_dict.get('add lb monitor', dict)
    avi_monitor_name = None
    if 'health_monitor_refs' in poolConfig and poolConfig['health_monitor_refs']:
        healthMonitorref = poolConfig['health_monitor_refs']
        avi_monitor_name = conversion_util.get_name(healthMonitorref[0])
    if monitorName == avi_monitor_name:
        avi_monitor_config = getHealthMonitorObject(monitorName)
        monitorConfig = bindMonitor.get(monitorName)
        port = avi_monitor_port = 0
        # request = None
        # if 'destPort' in monitorConfig:
        #     port = monitorConfig['destPort']
        #     avi_monitor_port = avi_monitor_config['monitor_port']
        # if 'send' and 'recv' in monitorConfig:
        #     request = monitorConfig['send']
        #     response = monitorConfig['recv']
        # if 'httpRequest' in monitorConfig:
        #     request = monitorConfig['httpRequest']
        #     response = monitorConfig['respCode']
        # if 'http_monitor' in avi_monitor_config:
        #     avi_http_request = avi_monitor_config['http_monitor']['http_request']
        # if request:
        #     request = request.replace('"', '')
        # if request == avi_http_request:
        return True
    else: return False

def checkpolicy(policyName, avi_config):
    avi_policy_ref = avi_config['http_policies'][0]['http_policy_set_ref']
    avi_policy_name = conversion_util.get_name(avi_policy_ref)
    avi_policy_name = re.sub(avi_config['name'], '', avi_policy_name)
    if policyName in avi_policy_name:
        #print avi_policy_name , " ", policyName
        return True
    else:
        return False

def checkPersistenceProfile(vs_name, poolConfig):
    if 'application_persistence_profile_ref' in poolConfig and poolConfig['application_persistence_profile_ref']:
        persistence_ref = poolConfig['application_persistence_profile_ref']
        persistence_name = conversion_util.get_name(persistence_ref)
        persistence_name = re.sub('-persistance-profile','',persistence_name)
        if persistence_name.startswith('Merged'):
            return True
        if persistence_name == vs_name:
            return True
        else: return False

def checksslProfile(vs_name, avi_config):
    avi_ssl_config = avi_config_dict['SSLProfile']
    if 'ssl_profile_ref' in avi_config and  avi_config['ssl_profile_ref']:
        ssl_profile_ref = avi_config['ssl_profile_ref']
        ssl_profile = conversion_util.get_name(ssl_profile_ref)
        for each_ssl_profile in avi_ssl_config:
            if each_ssl_profile['name'] and ssl_profile == vs_name :
                return True
    return False

def checkSslCertAndKey(vs_name, sslvserverConfig, avi_config):
    ssl_key_and_certificate_refs = avi_config['ssl_key_and_certificate_refs'][0]
    ssl_key_and_certificate = conversion_util.get_name(ssl_key_and_certificate_refs)
    sslConfig = sslvserverConfig.get(vs_name, None)
    avi_ssl_cert_and_key = avi_config_dict['SSLKeyAndCertificate']
    for each_obj in sslConfig:
        if 'certkeyName' in each_obj:
            name = each_obj['certkeyName']

    for each_ssl in avi_ssl_cert_and_key:
        if each_ssl['name'] == ssl_key_and_certificate:
            ssl_profile = re.sub('-dummy','',each_ssl['name'])
            if ssl_profile and name:
                return True
    return False

class Test(unittest.TestCase):
    def test_compareVirtualService(self):
        lbvs_config = ns_config_dict.get('add lb vserver', {})
        csvs_config = ns_config_dict.get('add cs vserver', {})
        bind_cs_vserver = ns_config_dict.get('bind cs vserver', {})
        bind_lb_vserver = ns_config_dict.get('bind lb vserver', {})
        servers = ns_config_dict.get('add service', {})
        bindservices = ns_config_dict.get('bind service', dict)
        bind_ssl_vserver = ns_config_dict.get('bind ssl vserver')

        # get each service from add cs vserver
        for lbvsKey in lbvs_config.keys():
            lbvsConfig = lbvs_config[lbvsKey]
            attrs = lbvsConfig['attrs']
            vs_name = attrs[0]
            type = attrs[1]
            ip_address = attrs[2]
            port = attrs[3]
            if type not in conv_const.supported_types:
                skipped_status = 'Skipped:Unsupported type %s of LB VS: ' \
                                 '%s' % (type, lbvsKey)
                LOG.warning(skipped_status)
                continue
            # Skipped VS if type is not SSL but persistence is of SSL type
            if type != 'SSL' and lbvsConfig.get('persistenceType') == \
                    'SSLSESSION':
                skipped_status = "Skipped:Secure persistence is applicable" \
                                     " only if SSL is enabled for Virtual " \
                                     "Service %s" % lbvsKey
                LOG.warning(skipped_status)
                continue
            try:
                vsStatus, avi_config = check_virtual_service_name(attrs)
                self.assertTrue(vsStatus)
            except AssertionError:
                LOG.error("lbvs Virtual service not found : %s" % (vs_name))
            # check poolgroup
            try:
                pgstatus, references = check_poolGroup(vs_name)
                self.assertTrue(pgstatus)
            except AssertionError:
                LOG.error("lbvs PoolGroup not found %s" % (vs_name))
            pg = bind_lb_vserver.get(vs_name, None)
            print pg
            if pg:
                if isinstance(pg, dict):
                    pg = [pg]
                poolName = pg[0]['attrs'][1]
                #updated_pool_name = poolName + "-pool-" + vs_name
                #print updated_pool_name
                try:
                    poolStatus, poolConfig = lbvscheckpool(poolName, references, vs_name)
                    self.assertTrue(poolStatus)
                except AssertionError:
                    LOG.error("Lbvs Pool not found for %s " % (poolName))
                if poolConfig:
                    # Check pool servers
                    for each_attr in pg:
                        if len(each_attr['attrs']) == 2:
                            pool = each_attr['attrs'][1]
                            poolServer = servers.get(pool)
                            try:
                                lbvsserverStatus = checkPoolservers(poolServer, poolConfig)
                                self.assertTrue(lbvsserverStatus)
                            except AssertionError:
                                LOG.error('Lbvs Pool server not found')
                    if poolName in bindservices:
                        monitor = bindservices.get(poolName)
                        monitorName = monitor['monitorName']
                        try:
                            monitorStatus = checkHealthMonitor(monitorName, poolConfig)
                            #print monitorStatus , " ", monitorName , " ", vs_name
                            self.assertTrue(monitorStatus)
                        except AssertionError:
                            LOG.error("Lbvs Health monitor %s not found for %s " % (monitorName, vs_name))
                    if 'persistenceType' in lbvsConfig and not lbvsConfig['persistenceType'] == 'NONE':
                        try:
                            persistence_status = checkPersistenceProfile(vs_name, poolConfig)
                            self.assertTrue(persistence_status)
                        except AssertionError:
                            LOG.error("Persistence profile not found for lbvs %s" %(poolName))
                #check ssl profile
                if type == 'SSL':
                    try:
                        sslStatus = checksslProfile(vs_name, avi_config)
                        self.assertTrue(sslStatus)
                    except AssertionError:
                        LOG.error("SSL profile not found for %s " %(vs_name))
                    try:
                        sslKeyCertStatus = checkSslCertAndKey(vs_name, bind_ssl_vserver, avi_config)
                        self.assertTrue(sslKeyCertStatus)
                    except AssertionError:
                        LOG.error("Ssl cert and key not matched %s" %(vs_name))
        for key in csvs_config.keys():
            cs_vs = csvs_config[key]
            attrs = cs_vs['attrs']
            vs_name = key
            ip_address = attrs[2]
            port = attrs[3]
            type = attrs[1]
            if not attrs[1] in csvs_supported_types:
                skipped_status = 'Skipped:Unsupported type %s of Context ' \
                                 'switch VS: %s' % (cs_vs['attrs'][1], key)
                LOG.warning(skipped_status)
                continue
            tt = cs_vs.get('targetType', None)
            if tt and tt == 'GSLB':
                skipped_status = 'Skipped:Unsupported target type %s of ' \
                                 'Context switch VS: %s' % (tt, key)
                LOG.warning(skipped_status)
                continue
            if len(cs_vs['attrs']) < 3:
                skipped_status = 'Skipped:No IP, port found for Context ' \
                                 'switch VS: %s' % key
                LOG.warning(skipped_status)
                continue
            # check key present in bind cs vserver
            bind_conf_list = bind_cs_vserver.get(key, None)
            if not bind_conf_list:
                continue
            if isinstance(bind_conf_list, dict):
                bind_conf_list = [bind_conf_list]
            for each_group_obj in bind_conf_list:
                            if 'targetLBVserver' in each_group_obj:
                                lbvserver = each_group_obj['targetLBVserver']

                            try:
                                vsStatus, avi_config = check_virtual_service_name(attrs)
                                self.assertTrue(vsStatus)
                            except AssertionError:
                                 LOG.error("Virtual service not found : %s" %(vs_name))
                            try:
                                vipStatus = check_vs_ip_and_port(attrs, avi_config)
                                self.assertTrue(vipStatus)
                            except AssertionError:
                                LOG.error("Ip address %s and port %s number not matched with avi configuration " %(ip_address, port))

                            # check http policy
                            try:
                                if 'policyName' in each_group_obj:
                                    policyName = each_group_obj['policyName']
                                if 'lbvserver' in each_group_obj:
                                    pg = bind_lb_vserver.get(lbvserver, None)
                                    policyName = [each_gr['policyName'] for each_gr in pg if 'policyName' in each_gr][0]

                                policyStatus = checkpolicy(policyName, avi_config)
                                self.assertTrue(policyStatus)
                            except AssertionError:
                                LOG.error("Policy not matched %s" %(policyName))
                            # check poolgroup
                            try:
                                pgstatus, references = check_poolGroup(lbvserver)
                                self.assertTrue(pgstatus)
                            except AssertionError:
                                LOG.error("PoolGroup not found %s" % (lbvserver))
                            pg = bind_lb_vserver.get(lbvserver, None)
                            poolName = pg[0]['attrs'][1]
                            try:
                                poolStatus, poolConfig = checkPool(poolName, references)
                                self.assertTrue(poolStatus)
                            except AssertionError:
                                LOG.error("Pool not found for %s " %(poolName))
                            if poolConfig:
                                # Check pool servers
                                for each_attr in pg:
                                    if len(each_attr['attrs']) == 2:
                                        pool = each_attr['attrs'][1]
                                        poolServer = servers.get(pool)
                                        if poolConfig:
                                            try:
                                                csvsserverStatus = checkPoolservers(poolServer, poolConfig)
                                                self.assertTrue(csvsserverStatus)
                                            except AssertionError:
                                                LOG.error('Pool server not found')

                                if poolName in bindservices:
                                    monitor = bindservices.get(poolName)
                                    monitorName = monitor['monitorName']
                                    try:
                                        monitorStatus = checkHealthMonitor(monitorName, poolConfig)
                                        #print monitorStatus , " ", monitorName , " ", vs_name
                                        self.assertTrue(monitorStatus)
                                    except AssertionError:
                                        LOG.error("Health monitor %s not found " %(monitorName))



if __name__ == "__main__":
        unittest.main()