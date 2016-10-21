'''
Created on Feb 10, 2016

@author: grastogi
'''
import json
import logging

log = logging.getLogger(__name__)


class ApiUtils(object):
    '''
    Common utilities for the Avi APIs
    '''
    def __init__(self, api_session):
        '''
        Constructor
        :param api_session: ApiSession
        '''
        self.api = api_session

    def import_ssl_certificate(self, name, key, cert, cert_type='', key_passphrase='',
                               tenant='', tenant_uuid=''):
        """import_ssl_certificate takes cert name server key, cert, cert_type, passphrase
        returns session's response object

        Starting from 16.3, cert_type is required.
        API defaults to SSL_CERTIFICATE_TYPE_VIRTUALSERVICE if not provided"""
        if not cert_type:
            cert_type = 'SSL_CERTIFICATE_TYPE_VIRTUALSERVICE'
        ssl_kc_obj = {
            'name': name,
            'key': key,
            'type': cert_type,
            'certificate': {
                'certificate': cert
                },
            'key_passphrase': key_passphrase
        }
        resp = self.api.post(
                path='sslkeyandcertificate',
                data=json.dumps(ssl_kc_obj),
                tenant=tenant, tenant_uuid=tenant_uuid)
        return resp

    def get_metrics(
            self, entity_type, entity_name, entity_uuid='', metric_id='',
            step=300, limit=1, start='', stop='', tenant='admin',
            tenant_uuid='', **query_options):
        """
        This is utility method to fetch metrics from the controller.
        Eg.
        1. api_utils.get_metrics('virtualservice', 'vs1',
            metric_id='l4_client.avg_bandwidth')
            This gets 1 vs1's network bandwidth metrics.
        2.
        :param entity_type: 'virtualservice, serviceengine, pool, tenant'
        :param entity_name: string corresponding to the object
        :param entity_uuid: uuid of the entity. If entity_uuid and entity_name
            are blank then it is treated as collection API where metrics
            for all the objects in the tenant would be fetched
        :param metric_id: comma separated string of metrics or list of
            metric_ids
        :param step: granularity of the metrics
        :param limit: number of data points for the metrics
        :param start: ISO8901 compatible start time for the metrics. Controller
            will adjust the start time based on the Stop time if not provided
        :param stop: ISO8901 compatible start time for the metrics. Controller
            sets stop as utc.now if not provided in the API
        :tenant: name of the tenant
        :tenant_uuid: uuid of the tenant
        :query_options: All the query_options are sent as the query parameters
            for the API call as per the Avi API Guide.
        """
        if entity_name and not entity_uuid:
            resp = self.api.get_object_by_name(entity_type, entity_name)
            entity_uuid = self.api.get_obj_uuid(resp)
        path = 'analytics/metrics/%s/%s' % (entity_type, entity_uuid)
        if type(metric_id) == list:
            metric_id = ','.join(metric_id)
        if metric_id:
            query_options['metric_id'] = metric_id
        query_options['step'] = step
        query_options['limit'] = limit
        if start:
            query_options['start'] = start
        if stop:
            query_options['stop'] = stop
        rsp = self.api.get(path, tenant=tenant, tenant_uuid=tenant_uuid,
                           params=query_options)
        return rsp.json()

    def get_healthscore(
            self, entity_type, entity_name, entity_uuid='',
            step=300, limit=1, start='', stop='', tenant='admin',
            tenant_uuid='', **query_options):
        """
        This is utility method to fetch healthscore from the controller.
        Eg.
        1. api_utils.get_metrics('virtualservice', 'vs1',
            metric_id='l4_client.avg_bandwidth')
            This gets 1 vs1's network bandwidth metrics.
        :param entity_type: 'virtualservice, serviceengine, pool, tenant'
        :param entity_name: string corresponding to the object
        :param entity_uuid: uuid of the entity. If entity_uuid and entity_name
            are blank then it is treated as collection API where metrics
            for all the objects in the tenant would be fetched
        :param step: granularity of the metrics
        :param limit: number of data points for the metrics
        :param start: ISO8901 compatible start time for the metrics. Controller
            will adjust the start time based on the Stop time if not provided
        :param stop: ISO8901 compatible start time for the metrics. Controller
            sets stop as utc.now if not provided in the API
        :tenant: name of the tenant
        :tenant_uuid: uuid of the tenant
        :query_options: All the query_options are sent as the query parameters
            for the API call as per the Avi API Guide.
        """
        if entity_name and not entity_uuid:
            resp = self.api.get_object_by_name(entity_type, entity_name)
            entity_uuid = self.api.get_obj_uuid(resp)
        path = 'analytics/metrics/%s/%s' % (entity_type, entity_uuid)
        query_options['step'] = step
        query_options['limit'] = limit
        if start:
            query_options['start'] = start
        if stop:
            query_options['stop'] = stop
        rsp = self.api.get(path, tenant=tenant, tenant_uuid=tenant_uuid,
                           params=query_options)
        return rsp.json()

    def get_metrics_collection(
            self, tenant='admin', tenant_uuid='', metric_requests=None,
            **query_options):
        """
        This is utility method to fetch metrics from the controller.
        Eg.
            {"metric_requests":[
                {"step":300,"limit":72,"id":"end_to_end",
                "entity_uuid":"virtualservice-76146076-be4f-4ccd-8253-68f2fb83f498",
                "metric_id":"l4_client.avg_total_rtt,l4_server.avg_total_rtt},
                {"step":300,"limit":72,"id":"l4_client.avg_bandwidth",
                "entity_uuid":"virtualservice-76146076-be4f-4ccd-8253-68f2fb83f498",
                "metric_id":"l4_client.avg_bandwidth"}
                ]
            }
        :param metric_requests: Array of metric_requests
        :tenant: name of the tenant
        :tenant_uuid: uuid of the tenant
        :query_options: All the query_options are sent as the query parameters
            for the API call as per the Avi API Guide.
        """
        if not metric_requests or type(metric_requests) != list:
            raise Exception(
                'No queries passed or invalid reqs %s' % metric_requests)
        data = {'metric_requests': metric_requests}
        path = 'analytics/metrics/collection'
        rsp = self.api.post(path, data=data, tenant=tenant,
                            tenant_uuid=tenant_uuid, params=query_options)
        return rsp.json()
