import unittest
import pytest
import logging
import re
from avi.migrationtools.test.functional_test.f5_functional_test import *
from avi.migrationtools.test.functional_test.F5_Conversion import F5Conversion
from avi.migrationtools.f5_converter.conversion_util import F5Util
import avi.migrationtools.test.functional_test.conversion_constant_util as conv_const

conversion_util = F5Util()
input_file = pytest.config.getoption("--bigip_config_file")
output_file = pytest.config.getoption("--output_path")
type = pytest.config.getoption("--type")
controller_version = pytest.config.getoption("--controller_version")
vs_state = pytest.config.getoption("--vs_state")
f5_config_version = pytest.config.getoption("--file_version")

logging.basicConfig(filename=output_file + '/config_check.log', level=logging.INFO)
LOG = logging.getLogger(__name__)


def setUpModule():
    global f5_config_dict
    global avi_config_dict
    f5Cnv = F5Conversion()
    f5_config_dict, avi_config_dict = f5Cnv.convert(
        type, input_file, f5_config_version, output_file,
        vs_state, controller_version)


# Compare virtual service name with virtual service in f5 configuration.
def compareVsName(vs_name):
    """

    :param: It contains a virtual service name
    :return: return a virtual service name
    :return: returns f5 parsed vs object.
    """
    vs_config = f5_config_dict.get("virtual", {})
    for each_parsed_vs in vs_config.keys():
        tenant, vsName = conversion_util.get_tenant_ref(each_parsed_vs)
        if vsName == vs_name:
            return vsName, vs_config[each_parsed_vs]


# Compare the virtual ip address.
def compareVip(each_vs, f5_vs):
    """

    :param each_vs: Contains information of virtual service object.
    :param f5_vs: Contains information of f5 parsed vs.
    :return:
    """
    if 'vip' in each_vs:
        ip_addr = each_vs['vip'][0]['ip_address']['addr']
    if 'services' in each_vs:
        vsPort = each_vs['services'][0]['port']

    destination = f5_vs.get("destination", None)
    d_tenant, vip_addr = conversion_util.get_tenant_ref(destination)
    parts = vip_addr.split(':')
    f5_ip_addrs = parts[0]
    port = parts[1] if len(parts) == 2 else conv_const.DEFAULT_PORT
    if not port.isdigit():
        port = conversion_util.get_port_by_protocol(port)

    matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', f5_ip_addrs)
    if not matches and ':' in vip_addr:
        port = vip_addr.split('.')[1]
    if not matches or f5_ip_addrs == '0.0.0.0' or ip_addr == f5_ip_addrs and port == vsPort:
        return True
    else: False


def getProfileFromF5(profileName):
    profile_config = f5_config_dict.get("profile", {})
    for key in profile_config.keys():
        if f5_config_version == "11":
            profileType, name = get_monitor_type(key)
            type, name = conversion_util.get_tenant_ref(name)
        elif f5_config_version == "10":
            name = key.split(' ')[1]
        if '-cmd' in profileName:
            profileName = re.sub('\-cmd$', '', profileName)
        if profileName == name or profileName.startswith('Merged'):
            return True
    return False


# Compares the application profile.
def compareAppProf(appName):
    """

    :param appName: It contains a application profile name
    :return: It returns default profile type and avi application profile type
    """
    isProfile = getProfileFromF5(appName)
    if isProfile:
        app_type = [i['type'] for i in avi_config_dict['ApplicationProfile']
                    if i['name'] == appName]
        if app_type:
            type = app_type[0]
            for profile_type in conv_const.PROFILES.keys():
                if conv_const.PROFILES[profile_type] == type:
                    return True
    return False


# Compare network profile.
def compareNetworkProfile(profileName):
    """

    :param profileName: It contains virtual service name.
    :return: True or False.
    """
    isProfile = getProfileFromF5(profileName)
    if isProfile:
        network_type = [i['profile']['type'] for i in avi_config_dict['NetworkProfile']
                        if i['name'] == profileName]
        if network_type and network_type[0] in conv_const.NETWORK_PROFILES:
            return True
    else: False


""" Compare ssl profile type with
    default profile types
    """
def compareSslProfile(each_vs):
    """

    :param each_vs: It contains virtual service information
    :return: True or False.
    """
    ssl_profile_ref = each_vs['ssl_profile_ref']
    ssl_profile_name = conversion_util.get_name(ssl_profile_ref)
    ssl_profile_type = [i['accepted_versions'] for i in avi_config_dict['SSLProfile']
                        if i['name'] == ssl_profile_name]
    profile_types = [profile['type'] for profile in ssl_profile_type[0]]
    return True if profile_types == conv_const.SSLPROFILE_VERSIONS else False


# Checks health monitor in avi configurations HealthMonitor.
def checkHealthMonitor(pool):
    """

    :param pool: It contains pool information.
    :return monitorStatus: It contains True or False.
    :return healthMonitor: It contains name of the health monitor.
    """
    healthMonitorRef = pool['health_monitor_refs']
    if healthMonitorRef:
        for monitorKey in healthMonitorRef:
            healthMonitor = conversion_util.get_name(monitorKey)
            monitors = [healthMonitors['type'] for healthMonitors in avi_config_dict['HealthMonitor']
                        if healthMonitors['name'] == healthMonitor]
            monitorStatus = compareHealthMonitor(monitors, healthMonitor)
            return monitorStatus, healthMonitor


""" Compare health monitor type with
    F5 configurations health monitors
    """
def compareHealthMonitor(healthMonitors, monitorName):
    """

    :param healthMonitors: List of health monitors.
    :param monitorName: health monitor name.
    :return: True or False.
    """
    monitor_config = f5_config_dict.get("monitor", {})
    for key in monitor_config.keys():
        if f5_config_version == "11":
            monitorType, name = get_monitor_type(key)
            type, name = conversion_util.get_tenant_ref(name)
        elif f5_config_version == "10":
            name = key
        if monitorName == name or monitorName.startswith("Merged"):
            for key in conv_const.HEALTH_MONITORS:
                if conv_const.HEALTH_MONITORS[key] in healthMonitors:
                    return True
    return False


# Return monitor type and name
def get_monitor_type(monitor):
    """

    :param monitor: It contains key of health monitor.
    :return healthMonitor[0]: It contains type of health monitor.
    :return healthMonitor[1]: It contains name of health monitor.

    """
    healthMonitor = monitor.split(' ')
    return healthMonitor[0], healthMonitor[1]



# Check persistence profile
def checkPersistenceType(applicationProfile):
    """

    :param pool: It contains pool information.
    :return: True and applicationProfile if profile type is matched with default profile type.
    :return: False and applicationProfile
    """
    profiles = [appProfile for appProfile in avi_config_dict['ApplicationPersistenceProfile']
                        if appProfile['name'] == applicationProfile]
    if profiles:
        for key in conv_const.PERSISTENCE_PROFILE_TYPES:
            if conv_const.PERSISTENCE_PROFILE_TYPES[key] == profiles[0]['persistence_type']:
                return True, applicationProfile

        return False, applicationProfile
    else: return False, applicationProfile


# Return profile application persistence profile name
def getProfileName(object, key):
    """

    :param object: it contains object information.
    :param key: it contains profiles key.
    :return persistenceProfile: returns persistence profile name.
    """
    profile = object[key]
    persistenceProfile = conversion_util.get_name(profile)
    if not persistenceProfile.startswith("System"):
        return persistenceProfile


def compareSslCert(each_vs):
    sslkey = each_vs['ssl_key_and_certificate_refs']
    for key in sslkey:
        sslname = conversion_util.get_name(key)
        for ssl in avi_config_dict['SSLKeyAndCertificate']:
            if ssl['name'] == sslname:
                sslkeystat = compareSslprofile(sslname)
                return sslkeystat
        return False

#Compare sslprofile in f5 Dict.
def compareSslprofile(sslname):
    sslName = re.sub('\-dummy$', '', sslname)
    vs_config = f5_config_dict.get("profile", {})
    for key in vs_config.keys():
        monitorType, name = get_monitor_type(key)
        if 'client-ssl' or 'server-ssl' in monitorType:
            type, name = conversion_util.get_tenant_ref(name)
            if name == sslName:
                return True
    return False
# Compare policy rules.
def comparePolicyRules(rule, f5_vs):
    """

    :param rule: Policy rule.
    :param f5_vs: It contains virtual service data.
    :return: Returns True or False and policy rule.
    """
    policyRule = rule.split('-')[0]
    if 'rules' in f5_vs:
        if isinstance(f5_vs['rules'], basestring):
            vs_ds_rules = [conversion_util.get_tenant_ref(f5_vs['rules'])[1]]
        else:
            vs_ds_rules = [conversion_util.get_tenant_ref(name)[1] for name in
                           f5_vs['rules'].keys()]
        for rule in (vs_ds_rules):
            if rule == policyRule:
                return True, policyRule
        return False, policyRule


# Compare http policies.
def compareHttpPolicies(httpPolicies):
    """

    :param httpPolicies:
    :param f5_vs:
    :return:
    """
    for ref in httpPolicies:
        if ref['http_policy_set_ref']:
            policyname = conversion_util.get_name(ref['http_policy_set_ref'])
            for policy in avi_config_dict['HTTPPolicySet']:
                if policy['name'] == policyname:
                    return True, policyname, policy
            return False, policyname, policy

class Test(unittest.TestCase):
    def test_compareVirtualService(self):
        for each_vs in avi_config_dict['VirtualService']:
            try:
                vs_name = each_vs['name']
                f5VsName, f5_vs = compareVsName(vs_name)
                assert f5VsName == vs_name
            except AssertionError:
                LOG.error(
                    'Virtual service not found in F5 configuration : %s ' % (vs_name))
            try:
                vipStatus = compareVip(each_vs,f5_vs)
                self.assertTrue(vipStatus)
            except AssertionError:
                LOG.error("Virtual ip address not found for %s " %(vs_name))
            if f5VsName:
                try:
                    if 'application_profile_ref' in each_vs:
                        appProfile = getProfileName(each_vs,conv_const.APP_PROF)
                        if appProfile:
                            profileStatus = compareAppProf(appProfile)
                            self.assertTrue(profileStatus)
                except AssertionError:
                    LOG.error("Application profile not found for : %s" %(vs_name))

                try:
                    if 'network_profile_ref' in each_vs:
                        profileName = getProfileName(each_vs, conv_const.NETWORK_PROF)
                        if profileName:
                            networkProfile = compareNetworkProfile(profileName)
                            self.assertTrue(networkProfile)
                except AssertionError:
                    LOG.error("Network profile is not found for %s" %(vs_name))

                try:
                    if 'ssl_profile_ref' in each_vs:
                        isCompare = compareSslProfile(each_vs)
                        self.assertTrue(isCompare)
                except AssertionError:
                    LOG.error(
                        "SSL Profile not found in %s" % (vs_name))

                if 'pool_group_ref' in each_vs:
                    poolGroupRef = each_vs['pool_group_ref']
                    poolGroupName = conversion_util.get_name(poolGroupRef)
                    poolGroups = [poolGroup for poolGroup in avi_config_dict['PoolGroup']
                                  if poolGroup['name'] == poolGroupName]
                    poolMembers = [conversion_util.get_name(i['pool_ref'])
                                   for i in poolGroups[0]['members']]
                    for pool in avi_config_dict['Pool']:
                        if pool['name'] in poolMembers:
                            try:
                                if 'application_persistence_profile_ref' in pool \
                                        and pool['application_persistence_profile_ref']:
                                    applicationProfile = getProfileName(pool, conv_const.APP_PERS_PROF)
                                    if applicationProfile:
                                        persistenceStatus, profileName = checkPersistenceType(applicationProfile)
                                        self.assertTrue(persistenceStatus)
                            except AssertionError:
                                LOG.error("Application persistence profile %s not found in %s "
                                          % (profileName, vs_name))
                            try:
                                if 'health_monitor_refs' in pool and pool['health_monitor_refs']:
                                    f5healthMonitorStatus, monitorName = checkHealthMonitor(pool)
                                    self.assertTrue(f5healthMonitorStatus)
                            except AssertionError:
                                LOG.error("Health monitor %s not found for virtual service %s" % (monitorName, vs_name))
                            try:
                                if 'ssl_profile_ref' in pool and pool['ssl_profile_ref']:
                                    isCompare = compareSslProfile(pool)
                                    self.assertTrue(isCompare)
                            except AssertionError:
                                LOG.error(
                                    "SSL Profile not found in %s" % (vs_name))

                if 'pool_ref' in each_vs:
                    poolRef = each_vs['pool_ref']
                    poolName = conversion_util.get_name(poolRef)
                    for pool in avi_config_dict['Pool']:
                        if pool['name'] in poolName:
                            try:
                                if 'application_persistence_profile_ref' in pool \
                                        and pool['application_persistence_profile_ref']:
                                    applicationProfile = getProfileName(pool, conv_const.APP_PERS_PROF)
                                    if applicationProfile:
                                        persistenceStatus, profileName = checkPersistenceType(applicationProfile)
                                        self.assertTrue(persistenceStatus)
                            except AssertionError:
                                LOG.error("Application persistence profile %s not found in %s "
                                          % (profileName, vs_name))
                            try:
                                if 'health_monitor_refs' in pool and pool['health_monitor_refs']:
                                    f5healthMonitorStatus, monitorName = checkHealthMonitor(pool)
                                    self.assertTrue(f5healthMonitorStatus)
                            except AssertionError:
                                LOG.error("Health monitor %s not found for virtual service %s" % (monitorName, vs_name))

                            try:
                                if 'ssl_profile_ref' in pool and pool['ssl_profile_ref']:
                                    isCompare = compareSslProfile(pool)
                                    self.assertTrue(isCompare)
                            except AssertionError:
                                LOG.error(
                                    "SSL Profile not found in %s" % (vs_name))
                try:
                    if 'ssl_key_and_certificate_refs' in each_vs:
                        sslStatus = compareSslCert(each_vs)
                        self.assertTrue(sslStatus)
                except AssertionError:
                    LOG.error(
                        "SSL key & cert not found for %s" % (vs_name))

                if 'http_policies' in each_vs:
                    try:
                        httpPolicies = each_vs['http_policies']
                        policyStatus, policyName, policy = compareHttpPolicies(httpPolicies)
                        self.assertTrue(policyStatus)
                    except:
                        LOG.error("Http policy %s not found in %s" % (policyName, vs_name))
                    try :
                        if policy['http_request_policy']['rules']:
                            rules = policy['http_request_policy']['rules']
                            for index in rules:
                                rule = index['name']
                                if rule.startswith('_sys_https_redirect'):
                                    ruleStatus, policyName =comparePolicyRules(rule, f5_vs)
                                    self.assertTrue(ruleStatus)
                    except AssertionError:
                        LOG.error("Http policy rule %s not found for service %s " % (policyName, vs_name))

            else:
                pass


if __name__ == "__main__":
    unittest.main()
