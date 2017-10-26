import unittest
import pytest
import sys
import logging
import traceback
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


def compareVsName(vs_name):
    """

    :param: It contains a virtual service name
    :return: return a virtual service name
    """
    vs_config = f5_config_dict.get("virtual", {})
    for each_parsed_vs in vs_config.keys():
        tenant, vsName = conversion_util.get_tenant_ref(each_parsed_vs)
        if vsName == vs_name:
            return vsName


def comAppProf(each_vs):
    """

    :param appType: It contains a application profile type
    :return: It returns default profile type and avi application profile type
    """

    application_profile_ref = each_vs['application_profile_ref']
    app_name = conversion_util.get_name(application_profile_ref)
    app_type = [i['type'] for i in avi_config_dict['ApplicationProfile']
                if i['name'] == app_name]
    if app_type:
        type = app_type[0]
        for profile_type in conv_const.PROFILES.keys():
            if conv_const.PROFILES[profile_type] == type:
                return True
    return False
def compareNetworkProfile(each_vs):
    """

    :param each_vs: It contains virtual service information
    :return networkProfile[0]: Type of default network profiles and avi network profiles
    :return network_type[0]: Type of avi network profiles
    """
    network_profile_ref = each_vs['network_profile_ref']
    network_name = conversion_util.get_name(network_profile_ref)
    network_type = [i['profile']['type'] for i in avi_config_dict['NetworkProfile']
                    if i['name'] == network_name]
    if network_type and network_type[0] in conv_const.NETWORK_PROFILES:
        return True
    else: False
""" Compare ssl profile type with
    default profile types
    """
def compareSslProfile(each_vs):
    """

    :param each_vs: It contains virtual service information
    :return: returns True if ssl profile type is matched with default profile types
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
    :return matchedMonitor: It contains health monitor list of avi health monitors
    :return monitors: It contains list of matched health monitors with F5 config
    """
    if pool['health_monitor_refs']:
        healthMonitorRef = pool['health_monitor_refs']
        if healthMonitorRef:
            healthMonitor = conversion_util.get_name(healthMonitorRef[0])
            monitors = [healthMonitors['type'] for healthMonitors in avi_config_dict['HealthMonitor']
                        if healthMonitors['name'] == healthMonitor]
            matchedmMnitor = compareHealthMonitor(monitors, healthMonitor)
            return matchedmMnitor
    else:
        return False

""" Compare health monitor type with
    F5 configurations health monitors
    """
def compareHealthMonitor(healthMonitors, monitorName):
    """

    :param healthMonitors: List of health monitors.
    :param monitorName: health monitor name.
    :return healthMonitor: health monitors list.
    """
    monitor_config = f5_config_dict.get("monitor", {})
    for key in monitor_config.keys():
        if f5_config_version == "11":
            monitorType, name = get_monitor_type(key)
            type, name = conversion_util.get_tenant_ref(name)
        elif f5_config_version == "10":
            name = key
        if monitorName == name:
            for key in conv_const.HEALTH_MONITORS:
                if conv_const.HEALTH_MONITORS[key] in healthMonitors:
                    return True
    LOG.error("Health Monitor not found for %s " % (monitorName))
    return False

# Return monitor type and name
def get_monitor_type(monitor):
    """

    :param monitor: It contains key of health monitor
    :return healthMonitor[0]: It contains type of health monitor
    :return healthMonitor[1]: It contains name of health monitor

    """
    healthMonitor = monitor.split(' ')
    return healthMonitor[0], healthMonitor[1]



# Check persistence profile
def checkPersistenceType(pool):
    """

    :param pool: It contains pool information.
    :return: returns True if profile type is matched with default profile type.
    """
    if pool['application_persistence_profile_ref']:
        profile = pool['application_persistence_profile_ref']
        applicationProfile = conversion_util.get_name(profile)
        if not applicationProfile.startswith("System"):
            # f5Profiles = []
            # f5_persistence = f5_config_dict.get('persistence', {})
            # for key in f5_persistence:
            #     if '/' in key:
            #         prof = key.split(' ')
            #         _, f5_profile = conversion_util.get_tenant_ref(prof[1])
            #         f5Profiles.append(f5_profile)
            #     else:
            #         _, f5_profile = get_monitor_type(key)
            #         f5Profiles.append(f5_profile)

            profiles = [appProfile for appProfile in avi_config_dict['ApplicationPersistenceProfile']
                        if appProfile['name'] == applicationProfile]

            if profiles:
                for key in conv_const.PERSISTENCE_PROFILE_TYPES:
                     if conv_const.PERSISTENCE_PROFILE_TYPES[key] == profiles[0]['persistence_type']:
                        return True
            else:
                LOG.error('Application persistence profile : %s not found in f5 configuration of application profiles' % (applicationProfile))
                return False
    else: return False

class Test(unittest.TestCase):
    def test_compareVs(self):
        for each_vs in avi_config_dict['VirtualService']:
            try:
                vs_name = each_vs['name']
                f5VsName = compareVsName(vs_name)
                assert f5VsName == vs_name
            except AssertionError:
                LOG.error(
                    'Virtual service not found in F5 configuration : %s ' % (vs_name))

            if f5VsName:
                try:
                    if 'application_profile_ref' in each_vs:
                        profileStatus = comAppProf(each_vs)
                        self.assertTrue(profileStatus)
                except AssertionError:
                    LOG.error("Application profile not found for : %s" %(vs_name))

                try:
                    if 'network_profile_ref' in each_vs:
                        networkProfile = compareNetworkProfile(each_vs)
                        self.assertTrue(networkProfile)
                except AssertionError:
                    LOG.error("Network profile is not found for %s" %(vs_name))

                try:
                    if 'ssl_profile_ref' in each_vs:
                        isCompare = compareSslProfile(each_vs)
                        self.assertTrue(isCompare)
                except AssertionError:
                    LOG.error(
                        'Failed to compare Ssl Profile profile : in service %s' % (vs_name))
                try:
                    if 'pool_group_ref' in each_vs:
                        poolRef = each_vs['pool_group_ref']
                        poolGroupName = conversion_util.get_name(poolRef)
                        poolGroups = [poolGroup for poolGroup in avi_config_dict['PoolGroup']
                                      if poolGroup['name'] == poolGroupName]
                        poolMembers = [conversion_util.get_name(i['pool_ref'])
                                       for i in poolGroups[0]['members']]
                        for pool in avi_config_dict['Pool']:
                            if pool['name'] in poolMembers:
                                try:
                                    if 'application_persistence_profile_ref' in pool:
                                        persistenceStatus = checkPersistenceType(pool)
                                        self.assertTrue(persistenceStatus)
                                except AssertionError:
                                    LOG.error(
                                        'Failed to compare Application persistence Profile : in service %s'
                                        % (vs_name))
                                try:
                                    if 'health_monitor_refs' in pool:
                                        f5healthMonitorStatus = checkHealthMonitor(pool)
                                        self.assertTrue(f5healthMonitorStatus)
                                except AssertionError:
                                    LOG.error("Health monitor not found for virtual service %s " % (vs_name))
                except:
                    _, _, tb = sys.exc_info()
                    traceback.print_tb(tb)
                    tb_info = traceback.extract_tb(tb)
                    filename, line, func, text = tb_info[-1]
                    print('An error occurred on line {} in statement {}'.format(line, text))

                try:
                    if 'pool_ref' in each_vs:
                        poolRef = each_vs['pool_ref']
                        poolName = conversion_util.get_name(poolRef)
                        for pool in avi_config_dict['Pool']:
                            if pool['name'] in poolName:
                                try:
                                    if 'application_persistence_profile_ref' in pool:
                                        persistenceStatus = checkPersistenceType(pool)
                                        self.assertTrue(persistenceStatus)
                                except AssertionError:
                                   LOG.error("Application profile not found in %s " % (vs_name))
                                try:
                                    if 'health_monitor_refs' in pool:
                                        f5healthMonitorStatus = checkHealthMonitor(pool)
                                        self.assertTrue(f5healthMonitorStatus)
                                except AssertionError:
                                    LOG.error("Health monitor not found for virtual service %s" % (vs_name))
                except:
                    _, _, tb = sys.exc_info()
                    traceback.print_tb(tb)
                    tb_info = traceback.extract_tb(tb)
                    filename, line, func, text = tb_info[-1]
                    print('An error occurred on line {} in statement {}'.format(line, text))

            else:
                pass


if __name__ == "__main__":
    unittest.main()
