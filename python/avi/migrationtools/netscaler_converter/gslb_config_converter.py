import logging
import json
from avi.migrationtools.netscaler_converter.ns_util import NsUtil
from avi.sdk.avi_api import ApiSession
from avi.migrationtools.netscaler_converter.gslb_vs_converter \
    import GslbVsConverter

LOG = logging.getLogger(__name__)

# Creating object for util library.
ns_util = NsUtil()

def get_vip_cluster_map(sites):
    vip_map=dict()
    for site in sites:
        session = ApiSession.get_session(
            site['ip_addresses'][0]['addr'], site['username'], site['password'])
        resp = session.get('virtualservice', api_version='17.1.1')
        vs_list = json.loads(resp.text)['results']
        for vs in vs_list:
            vip_map.update(create_map_for_vs(vs, vip_map, site))
    return vip_map


def create_map_for_vs(vs, vip_map, site):
    vips = vs['vip']
    services = vs['services']
    for vip in vips:
        for service in services:
            port_range = xrange(int(service['port']),
                                int(service['port_range_end'])+1)
            for port in port_range:
                vip_map['%s:%s' % (vip['ip_address']['addr'], port)] = {
                    'cluster_uuid': site['cluster_uuid'], 'vs_uuid': vs['uuid']}
    return vip_map


def convert(meta, gslb_config_dict, controller_ip, user_name,
            password, tenant_name, vs_state, output_dir, version,
            report_name, vs_level_status):
    vip_cluster_map = None
    # If controller ip present then only get configuration from controller.
    if controller_ip:
        session = ApiSession.get_session(controller_ip, user_name, password)
        resp = session.get('configuration/export?full_system=true')
        avi_config = json.loads(resp.text)
        sites = avi_config['Gslb'][0]['sites']
        vip_cluster_map = get_vip_cluster_map(sites)
    avi_gslb_config = None
    try:
        avi_gslb_config = dict()
        avi_gslb_config['META'] = meta
        gslb_vs_converter = GslbVsConverter()
        avi_config = gslb_vs_converter.convert(
            gslb_config_dict, avi_gslb_config, vs_state, vip_cluster_map)

        ns_util.add_complete_conv_status(
            gslb_config_dict, output_dir, avi_config, report_name, vs_level_status)

    except:
        LOG.error('Error in config conversion', exc_info=True)

    return avi_gslb_config
