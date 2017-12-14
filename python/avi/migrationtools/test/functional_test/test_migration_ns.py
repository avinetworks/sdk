import logging
import os
import re
import unittest
import pytest
from F5_Conversion import F5Conversion
from avi.migrationtools.f5_converter.conversion_util import F5Util
import avi.migrationtools.test.functional_test.conversion_constant_util as conv_const
from  avi.migrationtools.netscaler_converter.policy_converter import PolicyConverter
from avi.migrationtools.netscaler_converter.ns_util import NsUtil

conversion_util = F5Util()
ns_util = NsUtil()
input_file = pytest.config.getoption("--bigip_config_file")
output_file = pytest.config.getoption("--output_path")
type = pytest.config.getoption("--type")
controller_version = pytest.config.getoption("--controller_version")
vs_state = pytest.config.getoption("--vs_state")
f5_config_version = pytest.config.getoption("--file_version")
cloudName = pytest.config.getoption("--cloud_name")

logging.basicConfig(filename=output_file + '/config_check.log', level=logging.INFO)
LOG = logging.getLogger()


def setUpModule():
    global ns_config_dict
    global avi_config_dict
    netscalerCnv = F5Conversion()

    ns_config_dict, avi_config_dict = netscalerCnv.convert(
         type, input_file, f5_config_version, output_file,
         vs_state, controller_version,cloudName)


# Compare virtual service name
def compareVirtualService(name):
    """

    :param name: virtual service name.
    :return: True 0r False
    """
    vs_config = ns_config_dict.get('add lb vserver', {})
    cs_config = ns_config_dict.get('add cs vserver', {})
    vs_config.update(cs_config)
    for vs_name in vs_config.keys():
        vsName = vs_name
        if ':' in vs_name:
            vsName = re.sub('[:]', '-', vs_name)
        if vsName == name:
            return True,vs_config[vs_name]
    return False, None


# Compare virtual service ip address.
def compareVsVip(vipRef, ns_vs_config):
    """

    :param vipRef: reference of virtual service.
    :param ns_vs_config: netscaler configuration of virtual service.
    :return:
    """
    vsvipName = conversion_util.get_name(vipRef)
    for vipKey in avi_config_dict['VsVip']:
        if vipKey['name'] == vsvipName:
            address = vipKey['vip'][0]['ip_address']['addr']
            nsAddress = ns_vs_config['attrs'][2]
            if address == nsAddress:
                return True
    return False

# Compare vip and port
def compareVipandService(each_vs, ns_config):
    ip_addr = each_vs['vip'][0]['ip_address']['addr']
    port = each_vs['services'][0]['port']
    ns_ip = ns_config['attrs'][2]
    ns_port = ns_config['attrs'][3]
    if ip_addr == ns_ip and port == ns_port:
        return True
    else: False



# Compare application profile.
def checkAppProfile(app_profile, vs_config):
    """

    :param app_profile: Reference of application profile.
    :return: True or False
    """
    httpProfiles = ns_config_dict.get('add ns httpProfile', {})
    name = conversion_util.get_name(app_profile)
    if name.startswith('System') or name.startswith('Merged'):
        return True
    for key in avi_config_dict['ApplicationProfile']:
        if key['name'] == name or 'httpProfileName' in vs_config and vs_config['httpProfileName'] == name:
            for profile in httpProfiles.keys():
                if profile == name:
                    return True
    return False


# Compare pool name.
def checkPoolName(pool,vs_name):
    """

    :param pool: pool object of virtual service.
    :param vs_name: virtual service name.
    :return: True or False
    """
    vs_name = getLbvsName(vs_name)
    name = pool['name']
    ns_config = ns_config_dict.get('bind lb vserver', {})
    poolName = name.split('-pool')[0]
    for key in ns_config.keys():
        nsVsKey = key
        if ':' in nsVsKey:
            nsVsKey = re.sub('[:]', '-', nsVsKey)
        if nsVsKey == vs_name:
            if isinstance(ns_config[key], list):
                for i in ns_config[key]:
                    nsProfile = i['attrs'][1]
                    nsProfile = re.sub('[:]', '-', nsProfile)
                    if nsProfile == poolName:
                        return True
            nsProfile = ns_config[key]['attrs'][1]
            nsProfile = re.sub('[:]', '-', nsProfile)
            if nsProfile == poolName:
                return True
    return False

# Function to get LBVS name.
def getLbvsName(vs_name):
    """

    :param vs_name: Virtual service name.
    :return: lbvs service name or virtual service name.
    """
    csvsConfig = ns_config_dict.get('bind cs vserver', {})
    for csvsKey in csvsConfig.keys():
        if csvsKey == vs_name:
            if isinstance(csvsConfig[csvsKey], list):
                for i in csvsConfig[csvsKey]:
                    if 'lbvserver' in i:
                        return i['lbvserver']
            else:
                if 'lbvserver' in csvsConfig[csvsKey]:
                    lbvsName= csvsConfig[csvsKey]['lbvserver']
                    return lbvsName
    return vs_name


# def comparePool(pool, vs_name):
#     name = pool['name']
#     ns_config = ns_config_dict.get('bind lb vserver', {})
#     poolName = name.split('-pool')[0]
#     for key in ns_config.keys():
#         nsVsKey = key
#         if ':' in nsVsKey:
#             nsVsKey = re.sub('[:]', '-', nsVsKey)
#         if nsVsKey == vs_name:
#             if isinstance(ns_config[key], list):
#                 for i in ns_config[key]:
#                     nsProfile = i['attrs'][1]
#                     nsProfile = re.sub('[:]', '-', nsProfile)
#                     if nsProfile == poolName:
#                         return True
#             nsProfile = ns_config[key]['attrs'][1]
#             nsProfile = re.sub('[:]', '-', nsProfile)
#             if nsProfile == poolName:
#                 return True
#     return False


# Compare health monitor.
def checkHealthMonitor(pool):
    """

    :param pool: pool object.
    :return: True or False with health monitor name.
    """
    healthMonitorRef = pool['health_monitor_refs']
    if healthMonitorRef:
        for monitorKey in healthMonitorRef:
            healthMonitor = conversion_util.get_name(monitorKey)
            monitorList =[ healthMonitor for monitor in avi_config_dict['HealthMonitor'] if monitor['name'] == healthMonitor]

            ns_config = ns_config_dict.get('add lb monitor', {})
            for nsMonitors in ns_config.keys():
                if nsMonitors in monitorList or healthMonitor.startswith('Merged'):
                    return True, healthMonitor
            return False, healthMonitor
    return False, None


# Compare network profile.
def checkNetworkProfile(each_vs):
    """

    :param each_vs: virtual service object.
    :return: True of False
    """
    profile_name = each_vs['network_profile_ref']
    vsName = each_vs['name']
    actual_profile_name = conversion_util.get_name(profile_name)
    vs_config = ns_config_dict.get('add lb vserver', {})
    if actual_profile_name.startswith('System'):
        return True
    for profileLKey in avi_config_dict['NetworkProfile']:
        if profileLKey['name'] == actual_profile_name:
            for key in vs_config.keys():
                if key == vsName and 'tcpProfileName' in vs_config[key]:
                    if vs_config[key]['tcpProfileName'] == profileLKey['name']:
                        return True
    else: return False


# Compare persistece profile.
def checkPersistence(pool, vs_name):
    """

    :param pool: Pool object.
    :param vs_name: virtual service name.
    :return:
    """
    profile_ref = pool['application_persistence_profile_ref']
    profile_name = conversion_util.get_name(profile_ref)
    vs_config = ns_config_dict.get('add lb vserver', {})
    profile = profile_name.split('-persistance-profile')[0]

    if profile_name.startswith('Merged') or profile_name.startswith('System'):
        return True

    persistConf = ns_config_dict.get('bind lb group', {})
    for persistKey in persistConf.keys():
        if profile == persistKey:
            if isinstance(persistConf[persistKey], list):
                for persisteList in persistConf[persistKey]:
                    vs_Profile = persisteList['attrs']
                    if vs_name and profile in vs_Profile:
                        return True

    profile_name = getLbvsName(vs_name)
    for i in vs_config.keys():
        if i == profile_name:
            profile_name = profile_name + '-persistance-profile'
            vs_config = vs_config[i]

    for persistenseKey in vs_config.keys():
        if persistenseKey == profile:
            vs_config = vs_config[persistenseKey]

    for i in avi_config_dict['ApplicationPersistenceProfile']:
        if i['name'] == profile_name:
            if 'persistenceType'in vs_config and vs_config['persistenceType']:
                profileTypeKey = vs_config['persistenceType']
                if profileTypeKey in conv_const.NS_PERSISTENSE_TYPE \
                        and i['persistence_type'] == conv_const.NS_PERSISTENSE_TYPE[profileTypeKey]:
                    return True
    return False

def checkSslKeyAndCert(each_vs, vs_name):
    ssl_ref = each_vs['ssl_key_and_certificate_refs']
    for sslKey in ssl_ref:
        ssl_key_cert = conversion_util.get_name(sslKey)
        for key in avi_config_dict['SSLKeyAndCertificate']:
            if key['name'] == ssl_key_cert:
                sslFound = checkSslInNs(ssl_key_cert, vs_name)
                return sslFound, ssl_key_cert
        return False, ssl_key_cert

def checkSslInNs(certName, vs_name):
    sslcertName = re.sub('\-dummy$','',certName)
    lbvsName = vs_name
    # if vs_name.endswith('_csvs'):
    #     lbvsName = getLbvsName(vs_name)
    lbvsConfig = ns_config_dict.get('bind ssl vserver', {})
    for sslkey in lbvsConfig.keys():
        each_cert = sslkey
        if ':' in sslkey:
            each_cert = re.sub('[:]', '-', sslkey)
        if each_cert == lbvsName:
            if isinstance(lbvsConfig[sslkey], list):
                for sslKey in lbvsConfig[sslkey]:
                    if 'certkeyName' in sslKey and sslKey['certkeyName']:
                        if sslKey['certkeyName'] == sslcertName:
                            return True
            if 'certkeyName' in lbvsConfig[sslkey] and lbvsConfig[sslkey]['certkeyName']:
                if sslcertName == lbvsConfig[sslkey]['certkeyName']:
                    return True
    return False

# Compare ssl profile.
def checkSslProfile(vs_obj, vsConfig):
    """

    :param vs_obj: virtual service object.
    :param vsConfig: netscaler configuration of virtual service.
    :return: True or False.
    """
    profile_ref = vs_obj['ssl_profile_ref']
    profile_name = conversion_util.get_name(profile_ref)
    vs_attrs = vsConfig['attrs']
    if profile_name.startswith('Merged') or profile_name.startswith('System'):
        return True
    for pKey in avi_config_dict['SSLProfile']:
        if pKey['name'] == profile_name and 'SSL' in vs_attrs:
            return True
    return False


# Function to to get lbvs name.
def getLbvsConfig(vs_name):
    """

    :param vs_name: Virtual service name.
    :return: attached policy list.
    """
    csvsConfig = ns_config_dict.get('bind cs vserver', {})
    policyList = []
    for csvsKey in csvsConfig.keys():
        vs = re.sub('[:]','-',csvsKey)
        if vs == vs_name:
            if isinstance(csvsConfig[csvsKey], list):
                for i in csvsConfig[csvsKey]:
                    if 'policyName' in i:
                        policyList.append(i['policyName'])
            else:
                if 'policyName' in csvsConfig[csvsKey]:
                    policyName= csvsConfig[csvsKey]['policyName']
                    policyList.append(policyName)
    return policyList


# compare http policies.
def checkHttpPolicy(name, vs_name):
    """

    :param name: policy name.
    :param vs_name: virtual service name.
    :return:
    """
    responder_policy = ns_config_dict.get('add responder policy', {})
    rewrite_policy = ns_config_dict.get('add rewrite policy', {})
    rewrite_action = ns_config_dict.get('add rewrite action', {})
    responder_action = ns_config_dict.get('add responder action', {})
    policyList = getLbvsConfig(vs_name)
    rewrite_policy.update(responder_policy)
    for pKey in avi_config_dict['HTTPPolicySet']:
        if pKey['name'] == name:
            aviPolObj =pKey['http_request_policy']['rules']

    for each_rule in aviPolObj:
        pName = each_rule['name'].split('-rule')[0]
        for key in rewrite_policy.keys():
                if pName == key and pName in policyList:
                    actions = rewrite_policy[key]['attrs']
                    action_name = actions[2]
                    for l in responder_action.keys():
                        if l == action_name:
                            rules = responder_action[l]['attrs']
                            if rules[1] == 'redirect':
                                path_matches = \
                                    re.findall('\\\\(.+?)\\\\',
                                               rules[2].strip('"').strip())
                                redirect_url = str(path_matches[0]).replace('"', '')
                                redirect_url = ns_util.parse_url(redirect_url)
                                hostname = str(redirect_url.hostname)
                                pathstring = str(redirect_url.path)
                                querystring = str(redirect_url.query)
                                full_path = '%s?%s' % (pathstring, querystring) if pathstring and \
                                                                               querystring else pathstring
                                if 'redirect_action' in each_rule:
                                    checkAction(each_rule, hostname, full_path)
                                if 'match' in each_rule:
                                    checkMatch(each_rule, actions)

                            elif rules[1] == 'respondwith':
                                attrs = rules[2].split(' ')
                                if attrs[0].startswith('q{'):
                                    return
                                if attrs[1] == '301':
                                    redirect_url = str(attrs[4]).replace('"', '')
                                    redirect_url = ns_util.parse_url(redirect_url)
                                    protocol = str(redirect_url.scheme).upper()
                                    hostname = str(redirect_url.hostname)
                                    pathstring = str(redirect_url.path)
                                    querystring = str(redirect_url.query)
                                    full_path = '%s?%s' % (pathstring, querystring) if pathstring \
                                                                                       and querystring else pathstring
                                    if 'redirect_action' in each_rule:
                                        checkAction(each_rule, hostname, full_path)
                                    if 'match' in each_rule:

                                        checkMatch(each_rule, actions)

                    for l in rewrite_action.keys():
                        if l == action_name:
                            rules = rewrite_action[l]['attrs']
                            if rules[1] == 'insert_http_header':
                                try:
                                    if 'hdr_action' in each_rule:
                                        for p in each_rule['hdr_action']:
                                            if p['hdr']['name'] == rules[1]:
                                                if len(rules[3]):
                                                    matches = [rules[3].replace('\\"',
                                                                          '').replace('"', '')]
                                                if matches:
                                                        val = p['hdr']['value']['val']
                                                        assert val == matches[0]
                                except AssertionError:
                                    LOG.error("Action not matched of %s in %s Sefvice " % (name, vs_name))

                                if 'match' in each_rule:
                                    checkMatch(each_rule, actions)

                            elif rules[1] == 'replace':
                                path_matches = \
                                    re.findall('\\\\(.+?)\\\\',
                                               rules[3].strip('"').strip())
                                if 'rewrite_url_action' in each_rule:
                                    if 'host_hdr' in each_rule['rewrite_url_action']:
                                        if 'tokens' in each_rule['rewrite_url_action']['host_hdr']:
                                            try :
                                                tokens = each_rule['rewrite_url_action']['host_hdr']['tokens']
                                                assert tokens[0]['str_value'] == rules[2]
                                            except AssertionError:
                                                LOG.error("Redirect action not found for %s " % (each_rule['name']))
                                        if 'path' in each_rule['rewrite_url_action']:
                                            if each_rule['rewrite_url_action']['path']['tokens']:
                                                try:
                                                    tokens = each_rule['rewrite_url_action']['path']['tokens']
                                                    assert tokens[0]['str_value'] == path_matches[0]
                                                except AssertionError:
                                                    LOG.error("Path not matched in %s " % (each_rule['name']) )
                                        if 'match' in each_rule:
                                            checkMatch(each_rule, actions)

                            elif rules[1] == 'insert_before':
                                path_matches = re.findall('\\\\(.+?)\\\\',
                                                          rules[3])
                                if 'rewrite_url_action' in each_rule:
                                    if 'host_hdr' in each_rule['rewrite_url_action']:
                                        try:
                                            if 'tokens' in each_rule['rewrite_url_action']['host_hdr']:
                                                tokens = each_rule['rewrite_url_action']['host_hdr']['tokens']
                                                assert tokens[0]['str_value'] == rules[2]
                                        except AssertionError:
                                            LOG.error("Rewrite action not found for %s" % (each_rule['name']))
                                        if 'match' in each_rule:
                                            checkMatch(each_rule, actions)


# Compare action and path of policy rule.
def checkAction(each_rule, hostname, full_path):
    """

    :param each_rule: rules of attached policy
    :param hostname: policy
    :param full_path: path
    """
    hostObj = each_rule['redirect_action']['host']['tokens']
    str_val = hostObj[0]['str_value']
    pathObj = each_rule['redirect_action']['path']['tokens']
    path_str_val = pathObj[0]['str_value']
    if hostname:
        try:
            assert str_val == hostname
        except AssertionError:
            LOG.error("Action not matched in %s" % (each_rule['name']))
    if full_path:
        try:
            assert path_str_val == full_path
        except AssertionError:
            LOG.error("Path not matched in %s" % (each_rule['name']))


# compare match of policy.
def checkMatch(each_rule, actions):
    """

    :param each_rule: policy rule.
    :param actions: list of actions.
    """
    try:
        if 'path' in each_rule['match']:
            match_str = each_rule['match']['path']["match_str"]
            match = matchStr(actions[1])
            assert match["path"]["match_str"][0] == match_str[0]
    except AssertionError:
        LOG.error("Match Not found for %s " % (each_rule['name']))


# Function creates a matchrule.
def matchStr(rule):
    """

    :param rule: ns configuration policy rule
    :return: match
    """
    bind_patset = ns_config_dict.get('bind policy patset', {})
    patset_config = ns_config_dict.get('add policy patset', {})

    query = rule.strip('"')
    query = query.strip()
    match = None

    path_query = {
        "match_str": [],
        "match_criteria": ''
    }

    if 'true' == query.lower():
        match = {"path": path_query}
        match["path"]["match_str"].append('/')
        match["path"]["match_criteria"] = "CONTAINS"

    elif 'URL ==' in query.upper() or 'REQ.HTTP.URL ==' in query.upper():
        a, b = query.split("==")
        b = b.strip()
        match_str = b.strip("\\'")
        if not match_str:
            return None
        match = {"path": path_query}
        match["path"]["match_str"].append(match_str)
        match["path"]["match_criteria"] = "EQUALS"

    elif 'HTTP.REQ.URL.PATH.GET' in query.upper() \
            and 'EQ(' in query.upper():
        match = {"path": path_query}
        match["path"]["match_str"] = []
        exact_match = re.search(r'\((\d+?)\)', query).group(1)
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        for element in matches:
            regex = '.*/'
            element = re.sub('[\\\/]', '', element)
            if int(exact_match) == 1:
                regex = '^%s://.*' % element
            elif int(exact_match) > 1:
                if int(exact_match) == 1:
                    regex = '^%s://.*' % element
                elif int(exact_match) > 1:
                    for index in range(int(exact_match), 2, -1):
                        regex += '/\w+'
                    regex += '/%s' % element + '.*'
            else:
                continue
            match["path"]["match_str"].append(regex)

    elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'EQUALS_ANY(' in \
            query.upper():
        match = {"path": path_query}
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        patsets = []
        for element in matches:
            element = re.sub('[\\\/]', '', element)
            patset = PolicyConverter.get_patset_collection(element, bind_patset,
                                                patset_config)
            if patset:
                patsets += patset
        match["path"]["match_str"] = list(set(patsets))

    elif 'HTTP.REQ.URL.PATH.GET' in query.upper() and 'CONTAINS(' in \
            query.upper():
        match = {"path": path_query}
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        for element in matches:
            element = re.sub('[\\\/]', '', element)
            match["path"]["match_str"].append(element)

    elif 'HTTP.REQ.URL.PATH.CONTAINS' in query.upper():
        match = {"path": path_query}
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        matches = list(set(matches))
        for element in matches:
            element = re.sub('[\\\/]', '', element)
            match["path"]["match_str"].append(element)

    elif 'HTTP.REQ.URL.PATH.EQ' in query.upper():
        match = {"path": path_query}
        match["path"]["match_criteria"] = "EQUALS"
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        matches = list(set(matches))
        for element in matches:
            element = re.sub('[\\\/]', '', element)
            match["path"]["match_str"].append(element)

    elif 'HTTP.REQ.URL.PATH' in query.upper():
        match = {"path": path_query}
        matches = re.findall('\\\\(.+?)\\\\', query)
        if len(matches) == 0:
            return None
        matches = list(set(matches))
        for element in matches:
            element = re.sub('[\\\/]', '', element)
            match["path"]["match_str"].append(element)

    if match:
        if match.get('path', None) and \
                        match['path']['match_str'][0] == '/*':
            match['path']['match_str'][0] = '/'
        elif match.get('path', None) and \
                match['path']['match_str'][0].endswith('*'):
            match['path']['match_str'][0] = \
                match['path']['match_str'][0][:-1]
        return match


def comparePoolServers(pool, ns_vs_config):
    name = pool['name'].rstrip('-pool')

    ns_services = ns_config_dict.get('add service')
    ns_servers = ns_config_dict.get('add server')
    print name
    for each_server in pool['servers']:
        ip = each_server['ip']['addr']
        hostName = each_server['hostname']
        port = each_server['port']
        print ip ," ",hostName, " ",port
    # for key in ns_services.keys():
    #     if name == key:
    #         service = ns_services[key]
    #         print service['attrs'][1]
    #         for serverKey in ns_servers.keys():
    #             if serverKey == service['attrs'][1]:
    #                 print ns_servers[serverKey]['attrs'][1]
class Test(unittest.TestCase):

    def test_compareVirtualService(self):
        for each_vs in avi_config_dict['VirtualService']:
            try:
                vs_name = each_vs['name']
                vsStatus, ns_vs_config = compareVirtualService(vs_name)
                self.assertTrue(vsStatus)
            except AssertionError:
                LOG.error("Virtual service not found in ns configuration %s" %(vs_name))

            try:
                if 'vsvip_ref' in each_vs:
                    vipRef = each_vs['vsvip_ref']
                    vsVipStatus = compareVsVip(vipRef, ns_vs_config)
                    self.assertTrue(vsVipStatus)
            except AssertionError:
                LOG.error("Virtual ip not matched for service %s" %(vs_name))

            try:
                vipStatus = compareVipandService(each_vs, ns_vs_config)
                self.assertTrue(vipStatus)
            except AssertionError:
                LOG.error("Vip Not matched with config in %s" % (vs_name))

            try:
                if 'application_profile_ref' in each_vs and avi_config_dict['ApplicationProfile']:
                    app_profile = each_vs['application_profile_ref']
                    profileStatus = checkAppProfile(app_profile, ns_vs_config)
                    self.assertTrue(profileStatus)
            except AssertionError:
                LOG.error("Application profile not found for %s" %(vs_name))
            try:
                if 'network_profile_ref' in each_vs and avi_config_dict['NetworkProfile']:
                    profileStatus = checkNetworkProfile(each_vs)
                    self.assertTrue(profileStatus)
            except AssertionError:
                LOG.error("Network profile not found for %s" % (vs_name))

            try:
                if 'ssl_key_and_certificate_refs' in each_vs and each_vs['ssl_key_and_certificate_refs']:
                    sslKeyCertStatus, sslProfName = checkSslKeyAndCert(each_vs, vs_name)
                    self.assertTrue(sslKeyCertStatus)
            except AssertionError:
                LOG.error("Ssl key cert : %s not found for %s " % (sslProfName, vs_name))

            try:
                if 'ssl_profile_ref' in each_vs:
                    sslProfileStatus = checkSslProfile(each_vs, ns_vs_config)
                    self.assertTrue(sslProfileStatus)
            except AssertionError:
                LOG.error("Ssl profile not found for : %s " % (vs_name))

            if 'http_policies' in each_vs and each_vs['http_policies']:
                    policies = each_vs['http_policies']
                    policy_list = [conversion_util.get_name(i['http_policy_set_ref']) for i in policies]
                    for name in policy_list:
                        checkHttpPolicy(name, vs_name)

            if 'pool_group_ref' in each_vs:
                    pool_group_ref = each_vs['pool_group_ref']
                    name = conversion_util.get_name(pool_group_ref)
                    poolGroups = [poolGroup for poolGroup in avi_config_dict['PoolGroup']
                                  if poolGroup['name'] == name]
                    poolMembers = [conversion_util.get_name(i['pool_ref'])
                                   for i in poolGroups[0]['members']]
                    for pool in avi_config_dict['Pool']:
                        if pool['name'] in poolMembers:
                            try:
                                poolNameStatus = checkPoolName(pool,vs_name)
                                self.assertTrue(poolNameStatus)
                            except AssertionError:
                                LOG.error("Pool group not found in %s" % (vs_name))
                            try:
                                comparePoolServers(pool, ns_vs_config)
                            except AssertionError:
                                LOG.error("Servers not match in %s " %(pool['name']))
                            try:
                                if 'health_monitor_refs' in pool and pool['health_monitor_refs']:
                                    monitorStatus, monitorName = checkHealthMonitor(pool)
                                    self.assertTrue(monitorStatus)
                            except AssertionError:
                                LOG.error("Health monitor %s not found in %s" % (monitorName, vs_name))
                            try:
                                if 'application_persistence_profile_ref' in pool:
                                    persistenseStatus = checkPersistence(pool,vs_name)
                                    self.assertTrue(persistenseStatus)
                            except AssertionError:
                                LOG.error("Application persistence profile not found for %s" % (vs_name))
                            try:
                                if 'ssl_profile_ref' in pool:
                                    sslProfileStatus = checkSslProfile(pool, ns_vs_config)
                                    self.assertTrue(sslProfileStatus)
                            except AssertionError:
                                LOG.error("Ssl profile not found for : %s " % (pool['name']))

if __name__ == "__main__":
    unittest.main()
