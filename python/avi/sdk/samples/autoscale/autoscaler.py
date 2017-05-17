'''
Created on Apr 21, 2015

@author: Gaurav Rastogi (grastogi@avinetworks.com)

This is a simple server that monitors the virtual servers and micro
service engines. If any of the service engine's resources spike then  it
triggers autoscale.

'''
import argparse
import logging
import json
from twisted.internet import reactor, task
from avi.infrastructure.avi_logging import get_root_logger, get_logger
from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils
from avi.sdk.samples.common import get_sample_ssl_params
import traceback
from datetime import datetime

log = get_root_logger(__name__, logfile_path='/opt/avi/log/sdkautoscale.log',
                      level=logging.DEBUG,
                      propagate=True)


class AnalyticsAutoScaler(object):
    '''
    Performs periodic autoscaling check based on the analytics.
    '''
    vs_name = ''
    api = None
    reactor = None
    AUTOSCALE_TIMEOUT = 5
    SE_CPU_METRIC = 'se_stats.avg_cpu_usage'
    LATENCY_METRIC = 'l7_client.avg_client_txn_latency'
    POOL_APDEX_METRIC = 'l4_server.apdexr'
    max_scaleout = 2
    min_scalein = 1
    # time
    last_autoscale_action = ''
    last_autoscale = None
    autoscale_cooldown = 15
    scalein_cooldown = 40
    scaleout_cooldown = 15

    def __init__(self, reactor, controller_ip, user, password, tenant,
                 vs_name):
        self.reactor = reactor
        self.vs_name = vs_name
        self.controller_ip = controller_ip
        self.user = user
        self.password = password
        self.tenant = tenant
        self.api = self.setupApiSession()

        if not self.vs_name:
            self.vs_name = self.fetchDefaultVs()
        log.info('setting up autoscaling for vs %s', self.vs_name)
        self.as_timer = task.LoopingCall(self.asTimerCallback)
        d = self.as_timer.start(self.AUTOSCALE_TIMEOUT)
        d.addErrback(self.asTimerErrback)
        self.scaleout = False

    def fetchDefaultVs(self):
        rsp = self.api.get('virtualservice')
        rsp_data = json.loads(rsp.text)
        log.debug('received following vs %s', rsp_data)
        if not rsp_data.get('count', 0):
            return ''
        return rsp_data['results'][0]['name']

    def getMetricSeries(self, metrics_query_resp, metric_name):
        for mseries in metrics_query_resp.get('series', []):
            metric = mseries['header']['name']
            if metric == metric_name:
                return mseries
        return None

    def checkIfAutoScaleCooldown(self, vs_obj, now):
        if not self.last_autoscale:
            return False
        if ((now - self.last_autoscale).total_seconds() <
                self.autoscale_cooldown):
            log.info('num_se %d cooldown as %s occured at %s',
                     len(vs_obj.get('se_list', [])),
                     self.last_autoscale_action.upper(),
                     self.last_autoscale)
            return True
        return False

    def getSeMetrics(self, se_uuid, metric_id, now, metric_agg='max'):
        resp = self.api.get('serviceengine/%s' % se_uuid)
        se_obj = json.loads(resp.text)
        path = 'analytics/metrics/serviceengine/%s/?metric_id=%s&step=5&limit=1&stop=%s' % (
                                                se_uuid, metric_id,now.isoformat())
        resp = self.api.get(path)
        se_metrics = json.loads(resp.text)
        mseries = self.getMetricSeries(se_metrics, metric_id)
        if not mseries:
            return None
        log.debug('se %s metrics %s', se_obj['name'], mseries)
        return mseries['header']['statistics'][metric_agg]

    def getVsMetrics(self, uuid, metric_id, now, metric_agg='max'):

        path = 'analytics/metrics/virtualservice/%s/?metric_id=%s&step=5&limit=1&stop=%s' % (
                                                uuid, metric_id,now.isoformat())
        resp = self.api.get(path)
        vs_metrics = json.loads(resp.text)
        mseries = self.getMetricSeries(vs_metrics, metric_id)
        log.debug('vs %s metrics %s', uuid, mseries)
        return mseries['header']['statistics'][metric_agg]

    def checkSEAutoScale(self, vs_obj, now):
        se_list = vs_obj.get('se_list', [])
        if not se_list:
            return ''
        max_se_cpu = 0
        action = ''
        for se_info in se_list:
            self.checkIfAutoScaleCooldown(vs_obj, now)
            se_uuid = se_info.get('se_ref').split('serviceengine/')[1]
            se_cpu = self.getSeMetrics(se_uuid, self.SE_CPU_METRIC, now)
            if se_cpu is None:
                continue
            max_se_cpu = max(se_cpu, max_se_cpu)

        # Autoscale logic
        if max_se_cpu < 10 and len(se_list) > self.min_scalein:
            # no need for autoscale
            action = 'scalein'
            self.autoscale_cooldown = self.scalein_cooldown
        elif max_se_cpu > 40 and len(se_list) < self.max_scaleout:
            action = 'scaleout'
            self.autoscale_cooldown = self.scaleout_cooldown
        else:
            log.info('num se: %d no autoscale metric %s %.1f%%',
                     len(se_list), self.SE_CPU_METRIC, max_se_cpu)
            return action
        log.info('num_se: %d %s for due to metric %s %.1f%%',
                 len(se_list), action.upper(), self.SE_CPU_METRIC,
                 max_se_cpu)
        return action

    def checkVSAutoScale(self, vs_obj, now):
        self.checkIfAutoScaleCooldown(vs_obj, now)
        se_list = vs_obj.get('se_list', [])
        action = ''
        vs_latency = \
            self.getVsMetrics(vs_obj['uuid'], self.LATENCY_METRIC, now)
        # Autoscale logic
        if vs_latency < 100 and len(se_list) > self.min_scalein:
            # no need for autoscale
            action = 'scalein'
            self.autoscale_cooldown = self.scalein_cooldown
        elif vs_latency > 400 and len(se_list) < self.max_scaleout:
            action = 'scaleout'
            self.autoscale_cooldown = self.scaleout_cooldown
        else:
            log.info('num se: %d no autoscale metric %s %.1fms ',
                     len(se_list), self.LATENCY_METRIC, vs_latency)
            return action
        log.info('%s for vs %s due to metric %s %.1fms num_se %d',
                 action.upper(), self.vs_name, self.LATENCY_METRIC, vs_latency,
                 len(vs_obj.get('se_list', [])))
        return action

    def autoscalePoolServer(self, vs_obj, action, num_autoscale=1):
        pool_uuid = vs_obj['pool_ref'].split('pool/')[1]
        resp = self.api.get('pool/%s' % pool_uuid)
        pool_obj = json.loads(resp.text)
        for server in pool_obj['servers']:
            if not num_autoscale:
                break
            log.info('pool %s server %s', pool_obj['name'], server)
            if action == 'scaleout' and not server.get('enabled', True):
                server['enabled'] = True
            elif action == 'scalein' and server.get('enabled', True):
                server['enabled'] = False
            num_autoscale -= 1
        self.api.put('pool/%s' % pool_uuid, data=json.dumps(pool_obj))
        return

    def asTimerCallback(self):
        try:
            if not self.api:
                self.setupApiSession()
            now = datetime.utcnow()
            vs_obj = self.api.get_object_by_name('virtualservice', self.vs_name)
            if self.checkIfAutoScaleCooldown(vs_obj, now):
                return
            action = self.checkSEAutoScale(vs_obj, now)
            #action = action if action else self.checkVSAutoScale(vs_obj, now)
            if not action:
                return
            self.api.post('virtualservice/%s/%s' % (vs_obj.get('uuid'), action))
            #self.autoscalePoolServer(vs_obj, action)
            self.last_autoscale = now
            self.last_autoscale_action = action
            # log.info('triggered %s for VS %s', action, self.vs_name)
        except:
            log.error('%s', traceback.format_exc())
            self.setupApiSession()

    def asTimerErrback(self, failure):
        log.error('error %s', failure)

    def setupApiSession(self):
        self.api = None
        api = ApiSession.get_session(self.controller_ip, self.user, self.password,
                               tenant=self.tenant)
        server_cert, server_key, _, _ = get_sample_ssl_params()
        ApiUtils(api).import_ssl_certificate('MyCert', server_key, server_cert)
        self.api = api
        return api

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-v', '--virtualservice',
                        help='name of virtualservice')
    parser.add_argument('-d', '--debug', default=logging.DEBUG, type=int,
                        help='debug level')
    parser.add_argument('-c', '--controller_ip', default='127.0.0.1',
                        help='controller VIP or IP')
    parser.add_argument('-u', '--user', default='admin',
                        help='Admin user name')
    parser.add_argument('-p', '--password', default='avi123',
                        help='password for admin user')
    parser.add_argument('-t', '--tenant', default='admin')
    parser.add_argument('-s', '--sdkpath',
                        default='/opt/avi/python/lib/avi/sdk/',
                        help='path to the SDK')
    parser.add_argument('-m', '--max-scaleout', help='max number of scaleout')
    args = parser.parse_args()

    root_logger = get_logger()
    root_logger.setLevel(args.debug)

    aascaler = AnalyticsAutoScaler(reactor, args.controller_ip, args.user,
                                   args.password, args.tenant,
                                   args.virtualservice)
    print('started autoscaler')
    reactor.run()
