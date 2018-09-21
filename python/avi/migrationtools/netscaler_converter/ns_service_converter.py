import logging
import re
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants
import socket
from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_SKIPPED, STATUS_SUCCESSFUL, STATUS_INDIRECT,
            STATUS_INCOMPLETE_CONFIGURATION, OBJECT_TYPE_POOL,
            OBJECT_TYPE_PKI_PROFILE, OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
            OBJECT_TYPE_SSL_PROFILE, OBJECT_TYPE_HEALTH_MONITOR,
            OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
            STATUS_EXTERNAL_MONITOR, STATUS_PARTIAL)
from avi.migrationtools.netscaler_converter.monitor_converter \
    import merge_object_mapping
from avi.migrationtools.netscaler_converter.ns_util import NsUtil
from avi.migrationtools.avi_migration_utils import update_count
app_per_merge_count = {'count': 0}

LOG = logging.getLogger(__name__)
# Creating f5 object for util library.
ns_util = NsUtil()


class ServiceConverter(object):


    def __init__(self, tenant_name, cloud_name, tenant_ref, cloud_ref,
                 object_merge_check, user_ignore, prefix):
        """
        Construct a new 'ServiceConverter' object.
        :param tenant_name: Name of tenant
        :param cloud_name: Name of cloud
        :param tenant_ref: Tenant reference
        :param cloud_ref: Cloud Reference
        :param object_merge_check: Bool value for object merge
        :param user_ignore: Dict of user ignore attributes
        :param prefix: prefix for objects
        """

        self.nsservice_bind_lb_skipped = \
            ns_constants.netscalar_command_status['nsservice_bind_lb_skipped']
        self.nsservice_service_skip = \
            ns_constants.netscalar_command_status['nsservice_service_skip']
        self.nsservice_service_na = \
            ns_constants.netscalar_command_status['nsservice_service_na']
        self.nsservice_bind_sg_skip = \
            ns_constants.netscalar_command_status['nsservice_bind_sg_skip']
        self.nsservice_server_skip = \
            ns_constants.netscalar_command_status['nsservice_server_skip']
        self.nsservice_skip_for_val = \
            ns_constants.netscalar_command_status['nsservice_skip_for_val']
        self.lbvs_supported_persist_types = \
            ns_constants.netscalar_command_status[
                'lbvs_supported_persist_types']
        self.nsservice_bind_lb_ignore_val = \
            ns_constants.netscalar_command_status[
                'nsservice_bind_lb_ignore_val']
        self.tenant_name = tenant_name
        self.cloud_name = cloud_name
        self.tenant_ref = tenant_ref
        self.cloud_ref = cloud_ref
        self.object_merge_check = object_merge_check
        # List of ignore val attributes for bind service netscaler command.
        self.nsservice_bind_lb_user_ignore = \
            user_ignore.get('nsservice_bind_lb', [])
        # List of ignore val attributes for add service netscaler command.
        self.nsservice_service_user_ignore = \
            user_ignore.get('nsservice_service', [])
        # List of ignore val attributes for bind servicegroup netscaler command.
        self.nsservice_bind_sg_user_ignore = \
            user_ignore.get('nsservice_bind_sg', [])
        # List of ignore val attributes for add servicegroup netscaler command.
        self.nsservice_server_user_ignore = \
            user_ignore.get('nsservice_server', [])
        # Added prefix for objects
        self.prefix = prefix
        # Progressbar count and total size.
        self.progressbar_count = 0
        self.total_size = 0

    def convert(self, ns_config, avi_config, sysdict, vrf):

        """
        Converts service or service groups bound to VS to avi Pool entity
        :param ns_config: Netscaler parsed config
        :param avi_config: Avi converted config
        :param tenant_ref: Tenant
        :param cloud_ref: Cloud ref
        :return: None
        """

        used_pool_ref = []
        groups = ns_config.get('bind lb vserver', {})
        # Added total size.
        self.total_size = self.total_size + len(groups)
        lb_vs_conf = ns_config.get('add lb vserver', {})
        avi_config['PoolGroup'] = []
        set_lb_groups = ns_config.get('set lb group', {})
        bind_lb_groups = ns_config.get('bind lb group', {})

        ns_bind_lb_vserver_command = 'bind lb vserver'

        # Conversion set ssl service netscalar commands to pool in AVI
        self.service_convert(ns_config, avi_config, sysdict, vrf)
        ns_dns = ns_config.get('add dns addRec', {})
        for dns_key in ns_dns:
            dns_obj = ns_dns.get(dns_key, [])
            if isinstance(dns_obj, dict):
                dns_obj = [dns_obj]
            ns_dns_command = 'add dns addRec'
            for element in dns_obj:
                ns_dns_complate_command = ns_util.get_netscalar_full_command(
                    ns_dns_command, element)
                # Add status indirect to all add dns addRec netscalar commands
                # which are indirectly converted to AVI
                ns_util.add_status_row(
                    element['line_no'], ns_dns_command, dns_key,
                    ns_dns_complate_command, STATUS_INDIRECT)
        for group_key in groups:
            # incremented progress bar
            self.progressbar_count += 1
            try:
                if not group_key:
                    skipped_status = 'Skipped: No bind lb vserver found. ' \
                                     'Skipped pool' % group_key
                    LOG.warning(skipped_status)
                        # Skipped service if could not found bind lb vs
                    ns_util.add_status_row(
                        None, ns_bind_lb_vserver_command, group_key, None,
                        STATUS_SKIPPED, skipped_status)
                    continue

                group = groups.get(group_key)
                if isinstance(group, dict):
                    group = [group]
                lb_vs = lb_vs_conf.get(group_key)
                ns_bind_lb_vserver_complete_command = \
                    ns_util.get_netscalar_full_command(
                        ns_bind_lb_vserver_command, group[0])
                if not lb_vs:
                    for element in group:
                        # Skipped service if could not found add lb vs
                        skipped_status = 'Skipped: No add lb vserver found. ' \
                                         'Skipped pool %s' % element['attrs'][0]
                        ns_bind_lb_vserver_complete_command = \
                            ns_util.get_netscalar_full_command(
                                ns_bind_lb_vserver_command, element)
                        ns_util.add_status_row(
                            element['line_no'], ns_bind_lb_vserver_command,
                            element['attrs'][0],
                            ns_bind_lb_vserver_complete_command,
                            STATUS_INCOMPLETE_CONFIGURATION)
                        LOG.warning(skipped_status)
                    continue
                ns_algo = lb_vs.get('lbMethod', 'LEASTCONNECTIONS')
                service_type = lb_vs['attrs'][1]
                algo = ns_util.get_avi_lb_algorithm(ns_algo)
                pg_members = []
                for element in group:
                    if len(element['attrs']) < 2:
                        # Skipped this service if it doen not have any server
                        continue
                    full_cmd = ns_util.get_netscalar_full_command(
                        ns_bind_lb_vserver_command, element)
                    service = element['attrs'][1]
                    pool_name = re.sub('[:]', '-', service + '-pool')
                    # Added prefix for objects
                    if self.prefix:
                        pool_name = self.prefix + '-' + pool_name
                    pool = [pool for pool in avi_config['Pool']
                            if pool['name'] == pool_name]
                    if pool:
                        if pool_name in used_pool_ref:
                            # Cloning the pool if it is attached to more than
                            # one VS
                            pool_name = ns_util.clone_pool(
                                pool_name, group_key, avi_config,
                                userprefix=self.prefix)
                        pool[0]['lb_algorithm'] = algo
                        if not pool[0].get('health_monitor_refs'):
                            if service_type == 'TCP':
                                pool[0]['health_monitor_refs'] = [
                                    ns_util.get_object_ref(
                                        'tcp-default',
                                        OBJECT_TYPE_HEALTH_MONITOR,
                                        self.tenant_name)]
                            else:
                                pool[0]['health_monitor_refs'] = [
                                    ns_util.get_object_ref(
                                        'ping-default',
                                        OBJECT_TYPE_HEALTH_MONITOR,
                                        self.tenant_name)]
                        updated_pool_ref = ns_util.get_object_ref(
                            pool_name, OBJECT_TYPE_POOL, self.tenant_name,
                            self.cloud_name)
                        pg_members.append({'pool_ref': updated_pool_ref,
                                           'ratio': 1,
                                           'priority_label': '10'
                                           })
                        used_pool_ref.append(pool_name)
                        LOG.info('Conversion successful : %s' % full_cmd)
                        # Add summery of add server in CSV/report
                        # Changed the status to INDIRECT for binding of pool to
                        # VS
                        ns_util.add_status_row(
                            element['line_no'], ns_bind_lb_vserver_command,
                            element['attrs'][0], full_cmd, STATUS_INDIRECT)
                    else:
                        # Skipped add server if pool not found in AVI
                        skipped_status = 'Skipped :Pool is not created %s' \
                                         % element['attrs'][0]
                        LOG.warning(skipped_status)
                        ns_util.add_status_row(
                            element['line_no'], ns_bind_lb_vserver_command,
                            element['attrs'][0], full_cmd, STATUS_SKIPPED,
                            skipped_status)

                pg_name = group_key + '-poolgroup'
                pg_name = re.sub('[:]', '-', pg_name)
                # Added prefix for objects
                if self.prefix:
                    pg_name = self.prefix + '-' + pg_name
                if pg_members:
                    pool_group = {
                        'name': pg_name,
                        'members': pg_members,
                        'tenant_ref': self.tenant_ref,
                        'cloud_ref': self.cloud_ref
                    }
                    avi_config['PoolGroup'].append(pool_group)

            except Exception as e:
                update_count('error')
                LOG.error('Error in bind lb vserver conversion bound to: %s' %
                          group_key, exc_info=True)
            msg = "PoolGroup Conversion started..."
            ns_util.print_progress_bar(self.progressbar_count, self.total_size,
                                     msg, prefix='Progress', suffix='')
        # Support for set lb group and bind lb group
        for set_lb_group_key in set_lb_groups:
            set_lb_group = set_lb_groups.get(set_lb_group_key)
            set_lb_group_mappings = bind_lb_groups.get(set_lb_group['attrs'][0],
                                                       [])
            persistenceType = set_lb_group.get('persistenceType', '')
            profile_name = '%s-persistance-profile' % set_lb_group['attrs'][0]
            ns_set_lb_group_command = 'set lb group'
            ns_set_lb_group_complate_command = \
                ns_util.get_netscalar_full_command(ns_set_lb_group_command,
                                                   set_lb_group)
            # Added prefix before object
            if self.prefix:
                profile_name = self.prefix + '-' + profile_name
            if persistenceType in self.lbvs_supported_persist_types:
                application_persistence_profile = \
                    ns_util.convert_persistance_prof(set_lb_group, profile_name,
                                                     self.tenant_ref)
                app_persist_profile_name = \
                    application_persistence_profile['name']
                if self.object_merge_check:
                    dup_of = ns_util.update_skip_duplicates(
                        application_persistence_profile, avi_config[
                            'ApplicationPersistenceProfile'],
                        'app_persist_profile', merge_object_mapping,
                        app_persist_profile_name, persistenceType, self.prefix,
                        sysdict['ApplicationPersistenceProfile'])
                    if dup_of:
                        app_per_merge_count['count'] += 1
                        app_persist_profile_name = merge_object_mapping[
                            'app_persist_profile'].get(
                            app_persist_profile_name, None)
                    else:
                        avi_config['ApplicationPersistenceProfile'].append(
                            application_persistence_profile)
                else:
                    avi_config['ApplicationPersistenceProfile'].append(
                        application_persistence_profile)
                application_persistence_profile_ref = \
                    ns_util.get_object_ref(app_persist_profile_name,
                        OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
                        self.tenant_name)

                # Added status successful in CSV/report if application
                # persistence profile create
                ns_util.add_status_row(
                    set_lb_group['line_no'], ns_set_lb_group_command,
                    set_lb_group['attrs'][0], ns_set_lb_group_complate_command,
                    STATUS_SUCCESSFUL, application_persistence_profile)
            else:
                skipped_status = 'Skipped:Persistance type %s not ' \
                                 'supported by Avi' % persistenceType
                LOG.warning(skipped_status)
                # Skipped set lb group if type perstistence profile not
                # supported by AVI
                ns_util.add_status_row(
                    set_lb_group['line_no'], ns_set_lb_group_command,
                    set_lb_group['attrs'][0], ns_set_lb_group_complate_command,
                    STATUS_SKIPPED, skipped_status)
                continue

            if isinstance(set_lb_group_mappings, dict):
                set_lb_group_mappings = [set_lb_group_mappings]
            for bind_lb_group in set_lb_group_mappings:
                ns_bind_lb_group_command = 'bind lb group'
                ns_bind_lb_group_complate_command = \
                    ns_util.get_netscalar_full_command(ns_bind_lb_group_command,
                                                       bind_lb_group)
                pool_group_name = bind_lb_group['attrs'][1] + '-poolgroup'
                # Added prefix for objects
                if self.prefix:
                    pool_group_name = self.prefix + '-' + pool_group_name
                pool_group = [pool_group for pool_group in
                              avi_config['PoolGroup'] if pool_group['name'] ==
                              pool_group_name]
                # Skipped if pool group not found in AVI
                if not pool_group:
                    skipped_status = "Skipped: Pool group %s not found" \
                                     % bind_lb_group['attrs'][1]
                    LOG.warning(skipped_status)
                    ns_util.add_status_row(
                        bind_lb_group['line_no'], ns_bind_lb_group_command,
                        bind_lb_group['attrs'][0],
                        ns_bind_lb_group_complate_command,
                        STATUS_SKIPPED, skipped_status)
                    continue
                for pool_member in pool_group[0]['members']:
                    pool_name = \
                        pool_member['pool_ref'].split('&')[1].split('=')[1]
                    pool = [pool for pool in avi_config['Pool']
                            if pool['name'] == pool_name]
                    if pool:
                        pool[0]['application_persistence_profile_ref'] = \
                            application_persistence_profile_ref
                        # add successful statusin CSV/report for bind lb group
                        # updated pool with application perstistence profile ref
                        ns_util.add_status_row(
                            bind_lb_group['line_no'], ns_bind_lb_group_command,
                            bind_lb_group['attrs'][0],
                            ns_bind_lb_group_complate_command,
                            STATUS_SUCCESSFUL, pool_group[0])

    def service_convert(self, ns_config, avi_config, sysdict, vrf):
        """
        This function is defines that convert service to pool
        :param ns_config: Dict of netscalar commands
        :param avi_config: Dict of AVI
        :return: None
        """

        used_pool_ref = []
        avi_config['Pool'] = []
        ns_services = ns_config.get('add service', {})
        bind_service_group = ns_config.get('bind serviceGroup', {})
        ns_servers = ns_config.get('add server', {})
        ns_dns = ns_config.get('add dns addRec', {})
        bind_ns_service = ns_config.get('bind service', {})
        ns_service_groups = ns_config.get('add serviceGroup', {})
        set_ssl_service_group = ns_config.get('set ssl serviceGroup', {})
        set_ssl_service = ns_config.get('set ssl service', {})
        bind_ssl_service = ns_config.get('bind ssl service', {})
        bind_ssl_service_group = ns_config.get('bind ssl serviceGroup', {})
        # Get the total size of object
        self.total_size = self.total_size + len(ns_services) + \
                          len(ns_service_groups)
        print "Converting Pools..."
        for key in ns_services:
            try:
                # Added count to increment progress.
                self.progressbar_count += 1
                service = ns_services.get(key, {})
                service_command = 'add service'
                service_name = key
                service_netscalar_full_command = \
                    ns_util.get_netscalar_full_command(service_command, service)
                server, use_service_port = self.convert_ns_service(
                    service, ns_servers, ns_dns)
                if not server:
                    LOG.warning('Skipped:No server found %s' %
                                service_netscalar_full_command)
                    # Skipped service if No sserver node
                    ns_util.add_status_row(
                        service['line_no'], service_command, service_name,
                        service_netscalar_full_command,
                        STATUS_INCOMPLETE_CONFIGURATION)
                    continue
                pool_name = re.sub('[:]', '-', service_name + '-pool')
                # Addded prefix for objects
                if self.prefix:
                    pool_name = self.prefix + '-' + pool_name
                pool_obj = {
                    'name': pool_name,
                    'servers': [server],
                    'health_monitor_refs': [],
                    'tenant_ref': self.tenant_ref,
                    'cloud_ref': self.cloud_ref
                }

                if vrf:
                    vrf_ref = ns_util.get_object_ref(vrf, 'vrfcontext',
                                                tenant=self.tenant_name,
                                                cloud_name=self.cloud_name)
                    pool_obj['vrf_ref'] = vrf_ref

                if use_service_port:
                    pool_obj['use_service_port'] = use_service_port
                # Add health monitor reference to pool
                monitor_refs = self.get_service_montor(service_name,
                                           bind_ns_service, avi_config, sysdict)
                if monitor_refs:
                    pool_obj['health_monitor_refs'] = list(set(monitor_refs))
                ssl_service = set_ssl_service.get(key, None)
                if ssl_service:
                    bind_ssl_service_conf = bind_ssl_service.get(key, [])
                    if isinstance(bind_ssl_service_conf, dict):
                        bind_ssl_service_conf = [bind_ssl_service_conf]
                    for service_conf in bind_ssl_service_conf:
                        if service_conf.get('CA', None):
                            # Added prefix for objects
                            pkiname = self.prefix + '-' + service_conf['CA'] \
                                        if self.prefix else service_conf['CA']
                            if self.object_merge_check:
                                pkiname = merge_object_mapping[
                                            'pki_profile'].get(pkiname, None)
                            if [pki for pki in (sysdict['PKIProfile'] +
                               avi_config['PKIProfile']) if pki['name'] ==
                               pkiname]:
                                updated_pki_ref = ns_util.get_object_ref(
                                              pkiname, OBJECT_TYPE_PKI_PROFILE,
                                              self.tenant_name)
                                pool_obj['pki_profile_ref'] = updated_pki_ref
                        if service_conf.get('certkeyName', None):
                            # Added prefix for objects
                            certname = self.prefix + '-' + service_conf[
                                        'certkeyName'] if self.prefix else \
                                        service_conf['certkeyName']
                            if [key_cert for key_cert in avi_config[
                                'SSLKeyAndCertificate'] if key_cert[
                                'name'] == certname]:
                                ssl_key_cert_ref = ns_util.get_object_ref(
                                            certname,
                                            OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                            self.tenant_name)
                                pool_obj['ssl_key_and_certificate_ref'] = \
                                    ssl_key_cert_ref
                            elif [key_cert for key_cert in avi_config[
                                'SSLKeyAndCertificate'] if key_cert[
                                'name'] == certname + '-dummy']:
                                ssl_key_cert_ref = ns_util.get_object_ref(
                                            certname + '-dummy',
                                            OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                            self.tenant_name)
                                pool_obj['ssl_key_and_certificate_ref'] = \
                                    ssl_key_cert_ref
                    ssl_profile_name = re.sub('[:]', '-', key)
                    # Added prefix for objects
                    if self.prefix:
                        ssl_profile_name = self.prefix + '-' + ssl_profile_name
                    if self.object_merge_check:
                        # Get the merge ssl profile name
                        ssl_profile_name = merge_object_mapping[
                                      'ssl_profile'].get(ssl_profile_name, None)
                    if [ssl_prof for ssl_prof in (sysdict['SSLProfile'] +
                       avi_config['SSLProfile']) if ssl_prof['name'] ==
                            ssl_profile_name]:
                        updated_ssl_profile_ref = ns_util.get_object_ref(
                            ssl_profile_name, OBJECT_TYPE_SSL_PROFILE,
                            self.tenant_name)
                        pool_obj['ssl_profile_ref'] = updated_ssl_profile_ref
                # added condition to attach default ssl profile if SSL is
                # present in the command
                elif service.get('attrs') and len(service['attrs']) >= 2 and \
                        'SSL' in service['attrs']:
                    pool_obj['ssl_profile_ref'] = ns_util.get_object_ref(
                            'System-Standard', OBJECT_TYPE_SSL_PROFILE, 'admin')
                # Remove health monitor reference of http type if pool
                # has ssl profile or pki profile or ssl cert key
                # ELSE remove health monitor of https type
                if pool_obj.get('pki_profile_ref', None) or \
                        pool_obj.get('ssl_key_and_certificate_ref', None) or \
                        pool_obj.get('ssl_profile_ref', None):
                    ns_util.remove_http_mon_from_pool(avi_config, pool_obj,
                                                      sysdict)
                else:
                    ns_util.remove_https_mon_from_pool(avi_config, pool_obj,
                                                       sysdict)
                if len(pool_obj['health_monitor_refs']) > 6:
                    pool_obj['health_monitor_refs'] = \
                        pool_obj['health_monitor_refs'][:6]
                # Updated the reference of HM in pool by deriving it from name
                if pool_obj['health_monitor_refs']:
                    updated_health_monitor_ref = []
                    for health_monitor_ref in pool_obj['health_monitor_refs']:
                        updated_health_monitor_ref.append(
                            ns_util.get_object_ref(
                                health_monitor_ref, OBJECT_TYPE_HEALTH_MONITOR,
                                self.tenant_name))
                    pool_obj['health_monitor_refs'] = updated_health_monitor_ref

                avi_config['Pool'].append(pool_obj)
                LOG.warning('Conversion successful: %s' %
                            service_netscalar_full_command)
                # Add summery of this service in CSV/report
                conv_status = ns_util.get_conv_status(
                    service, self.nsservice_bind_lb_skipped, [], [],
                    user_ignore_val=self.nsservice_bind_lb_user_ignore)
                ns_util.add_conv_status(
                    service['line_no'], service_command, service_name,
                    service_netscalar_full_command, conv_status, pool_obj)
            except:
                update_count('error')
                LOG.error('Error in pool conversion for: %s' % key,
                          exc_info=True)
            # Calling progressbar function.
            msg = "Pool Conversion started..."
            ns_util.print_progress_bar(self.progressbar_count, self.total_size,
                                     msg,prefix='Progress', suffix='')

        for group_key in ns_service_groups:
            try:
                # Added count to increment progress.
                self.progressbar_count += 1
                service_group_command = 'add serviceGroup'
                service_group = ns_service_groups.get(group_key, {})
                service_group_name = group_key
                service_group_netscalar_full_command = \
                    ns_util.get_netscalar_full_command(
                        service_group_command, service_group)
                bind_groups = bind_service_group.get(service_group['attrs'][0],
                                                     [])
                servers, monitor_ref, use_service_port = \
                    self.convert_ns_service_group(bind_groups, ns_servers,
                                                  ns_dns, avi_config, sysdict)
                if not servers:
                    LOG.warning('Skipped:No server found %s' %
                                service_group_netscalar_full_command)
                    # Skipped this service group if No server found
                    ns_util.add_status_row(service_group['line_no'],
                        service_group_command, service_group_name,
                        service_group_netscalar_full_command,
                        STATUS_INCOMPLETE_CONFIGURATION)
                    continue

                pool_name = re.sub('[:]', '-', service_group_name + '-pool')
                # Added prefix for objects
                if self.prefix:
                    pool_name = self.prefix + '-' + pool_name
                status_flag = False
                # Skipped the servers if length > 400
                if len(servers) > 400:
                    servers = servers[0:400]
                    status_flag = True
                pool_obj = {
                    'name': pool_name,
                    'servers': servers,
                    'health_monitor_refs': [],
                    'tenant_ref': self.tenant_ref,
                    'cloud_ref': self.cloud_ref
                }

                # Added code to disable translation port
                if use_service_port:
                    pool_obj['use_service_port'] = use_service_port
                # Add health monitor reference to pool
                if monitor_ref and [monitor for monitor in
                                    avi_config['HealthMonitor']
                                    if monitor['name'] == monitor_ref]:

                    pool_obj['health_monitor_refs'].append(monitor_ref)

                ssl_service_group = set_ssl_service_group.get(group_key, None)
                if ssl_service_group:
                    bind_ssl_service_group_conf = \
                        bind_ssl_service_group.get(group_key, [])
                    if isinstance(bind_ssl_service_group_conf, dict):
                        bind_ssl_service_group_conf = [
                                                    bind_ssl_service_group_conf]
                    for ssl_service_conf in bind_ssl_service_group_conf:
                        if ssl_service_conf.get('CA', None):
                            # Added prefix for objects
                            pkiname = '%s-%s' % (self.prefix,
                                      ssl_service_conf['CA']) if self.prefix \
                                      else ssl_service_conf['CA']
                            if self.object_merge_check:
                                pkiname = merge_object_mapping[
                                            'pki_profile'].get(pkiname, None)
                            if [pki for pki in (sysdict['PKIProfile'] +
                                avi_config['PKIProfile']) if pki['name'] ==
                                pkiname]:
                                updated_pki_ref = ns_util.get_object_ref(
                                              pkiname, OBJECT_TYPE_PKI_PROFILE,
                                              self.tenant_name)
                                pool_obj['pki_profile_ref'] = updated_pki_ref
                        if ssl_service_conf.get('certkeyName', None):
                            certname = self.prefix + '-' + \
                                       ssl_service_conf['certkeyName'] if \
                                self.prefix else ssl_service_conf['certkeyName']
                            if [key_cert for key_cert in avi_config[
                                'SSLKeyAndCertificate'] if key_cert['name'] ==
                                    certname]:
                                ssl_key_cert_ref = ns_util.get_object_ref(
                                            certname,
                                            OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                            self.tenant_name)
                                pool_obj['ssl_key_and_certificate_ref'] = \
                                    ssl_key_cert_ref
                            elif [key_cert for key_cert in avi_config[
                                'SSLKeyAndCertificate'] if key_cert[
                                      'name'] == certname + '-dummy']:
                                ssl_key_cert_ref = ns_util.get_object_ref(
                                    certname + '-dummy',
                                    OBJECT_TYPE_SSL_KEY_AND_CERTIFICATE,
                                    self.tenant_name)
                                pool_obj['ssl_key_and_certificate_ref'] = \
                                    ssl_key_cert_ref
                    ssl_profile_name = re.sub('[:]', '-', group_key)
                    # Added prefix for objects
                    if self.prefix:
                        ssl_profile_name = self.prefix + '-' + ssl_profile_name
                    if self.object_merge_check:
                        # Get the merge ssl profile name
                        ssl_profile_name = merge_object_mapping[
                                      'ssl_profile'].get(ssl_profile_name, None)
                    if [ssl_prof for ssl_prof in (sysdict['SSLProfile'] +
                       avi_config['SSLProfile']) if ssl_prof['name'] ==
                            ssl_profile_name]:
                        updated_ssl_profile_ref = ns_util.get_object_ref(
                            ssl_profile_name, OBJECT_TYPE_SSL_PROFILE,
                            self.tenant_name)
                        pool_obj['ssl_profile_ref'] = updated_ssl_profile_ref
                # added condition to attach default ssl profile if SSL is
                # present in the command
                elif (service_group.get('attrs') and len(service_group['attrs'])
                        >= 2 and 'SSL' in service_group['attrs']):
                    pool_obj['ssl_profile_ref'] = ns_util.get_object_ref(
                        'System-Standard', OBJECT_TYPE_SSL_PROFILE, 'admin')
                # Remove health monitor reference of http type if pool
                # has ssl profile or pki profile or ssl cert key
                # ELSE remove health monitor of https type
                if pool_obj.get('pki_profile_ref', None) or \
                        pool_obj.get('ssl_key_and_certificate_ref', None) or \
                        pool_obj.get('ssl_profile_ref', None):
                    ns_util.remove_http_mon_from_pool(avi_config, pool_obj,
                                                      sysdict)
                else:
                    ns_util.remove_https_mon_from_pool(avi_config, pool_obj,
                                                       sysdict)
                if len(pool_obj['health_monitor_refs']) > 6:
                    pool_obj['health_monitor_refs'] = \
                        pool_obj['health_monitor_refs'][:6]
                # Updated the reference of HM in pool by deriving it from name
                if pool_obj['health_monitor_refs']:
                    updated_health_monitor_ref = []
                    for health_monitor_ref in pool_obj['health_monitor_refs']:
                        updated_health_monitor_ref.append(
                                  ns_util.get_object_ref(health_monitor_ref,
                                  OBJECT_TYPE_HEALTH_MONITOR, self.tenant_name))
                    pool_obj['health_monitor_refs'] = updated_health_monitor_ref

                avi_config['Pool'].append(pool_obj)
                LOG.warning('Conversion successful: %s' %
                            service_group_netscalar_full_command)
                # Add summery of this service group in CSV/report
                conv_status = ns_util.get_conv_status(
                    service_group, self.nsservice_bind_lb_skipped, [], [],
                    user_ignore_val=self.nsservice_bind_lb_user_ignore)
                # If len of servers > 400 then considering only 400 servers
                # And status of the pool is partial
                if status_flag:
                    conv_status['status'] = STATUS_PARTIAL
                    conv_status['skipped'].append("Skipped:length of servers " \
                                             "greater than 400")
                ns_util.add_conv_status(
                    service_group['line_no'], service_group_command,
                    service_group_name, service_group_netscalar_full_command,
                    conv_status, pool_obj)
            except:
                update_count('error')
                LOG.error('Error in pool conversion for: %s' % group_key,
                          exc_info=True)
            # Calling progress bar function.
            msg = "Pool Conversion started..."
            ns_util.print_progress_bar(self.progressbar_count, self.total_size,
                                     msg, prefix='Progress', suffix='')

    def get_service_montor(self, service_name, bind_ns_service, avi_config,
                           sysdict):
        """
        This function defines that return the list of health monitor references
        which is bind to service
        :param service_name: Name of service
        :param bind_ns_service: List of bind services
        :param avi_config: Dict of avi config
        :return: Return the list of monitor ref
        """

        monitor_refs = []
        bind_service = bind_ns_service.get(service_name, None)
        bind_service_command = 'bind service'
        if bind_service:
            if isinstance(bind_service, dict):
                bind_service = [bind_service]
            for service in bind_service:
                full_bind_service_command = \
                    ns_util.get_netscalar_full_command(bind_service_command,
                                                       service)
                if service and service.get('monitorName', None):
                    monitor_name = service.get('monitorName')
                    # Added prefix for objects
                    if self.prefix:
                        monitor_name = self.prefix + '-' + monitor_name
                    if self.object_merge_check:
                        # Get the merge health monitor name
                        monitor_name = merge_object_mapping[
                            'health_monitor'].get(monitor_name, monitor_name)
                    monitor = [monitor for monitor in (sysdict['HealthMonitor']
                               + avi_config['HealthMonitor']) if monitor[
                               'name'] == monitor_name]
                    if not monitor:
                        monitor_name = '%s-%s' % (monitor_name, 'dummy')
                        monitor = [monitor for monitor in
                                   avi_config['HealthMonitor']
                                   if monitor['name'] == monitor_name]

                    if not monitor:
                        skipped_status = 'External Monitor : Not supported ' \
                                         'Health monitor %s' % \
                                         full_bind_service_command
                        LOG.warning(skipped_status)
                        ns_util.add_status_row(
                            service['line_no'], bind_service_command,
                            service_name, full_bind_service_command,
                            STATUS_EXTERNAL_MONITOR, skipped_status)
                        continue
                    monitor_refs.append(monitor_name)
                    LOG.info('Conversion successful : %s' %
                             full_bind_service_command)
                    # Successful if health monitor found in AVI
                    ns_util.add_status_row(
                        service['line_no'], bind_service_command, service_name,
                        full_bind_service_command, STATUS_SUCCESSFUL,
                        service.get('monitorName'))
                else:
                    skipped_status = 'Skipped : Not found Health monitor %s' \
                                     % full_bind_service_command
                    LOG.warning(skipped_status)
                    # Skipped if health monitor not found in AVI
                    ns_util.add_status_row(
                        service['line_no'], bind_service_command, service_name,
                        full_bind_service_command, STATUS_SKIPPED,
                        skipped_status)
        return monitor_refs


    def convert_ns_service(self, ns_service, ns_servers, ns_dns):
        """
        This function defines that convert netscalar backend servers of service
        :param ns_service: Object of service
        :param ns_servers: List of servers are to be bind to service
        :param ns_dns: List of dns add rec
        :return: Return the servers
        """

        attrs = ns_service.get('attrs')
        server = ns_servers.get(attrs[1])
        if not server:
            return [], False
        ns_add_server_command = 'add server'
        status = ns_util.get_conv_status(
            server, self.nsservice_server_skip, [], [],
            user_ignore_val=self.nsservice_server_user_ignore)
        ns_add_server_complete_command = \
            ns_util.get_netscalar_full_command(ns_add_server_command, server)
        ip_addr = server['attrs'][1]
        # Get the server name
        server_name = server['attrs'][0]
        enabled = True
        state = server.get('state', 'ENABLED')
        if not state == 'ENABLED':
            enabled = False
        port = attrs[3]
        use_service_port = False
        if port in ("*", "0"):
            port = "1"
            use_service_port = True
        ip_addr = str(ip_addr).lower()
        if ip_addr in ns_dns:
            if isinstance(ns_dns[ip_addr], list):
                ip_addr = ns_dns[ip_addr][0]['attrs'][1]
            elif isinstance(ns_dns[ip_addr], dict):
                ip_addr = ns_dns[ip_addr]['attrs'][1]
        # Added regex to match ip address
        matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', ip_addr)
        if not matches:
            try:
                # If dns then resolve it get the ip address from it.
                ip_addr = socket.gethostbyname(ip_addr)
            except:
                # Skipped this server if it does not have an Ip
                ns_util.add_status_row(
                    server['line_no'], ns_add_server_command, server['attrs'][0],
                    ns_add_server_complete_command, STATUS_INCOMPLETE_CONFIGURATION)
                LOG.warning('Not found IP of server : %s' %
                            ns_add_server_complete_command)
                return [], use_service_port
        server_obj = {
            'ip': {
                'addr': ip_addr,
                'type': 'V4'
            },
            'port': port,
            'enabled': enabled
        }
        if server_name:
            # Get the server name
            server_obj['hostname'] = server_name
        # Successful this server if it has an IP
        ns_util.add_conv_status(
            server['line_no'], ns_add_server_command, server['attrs'][0],
            ns_add_server_complete_command, status, server_obj)
        return server_obj, use_service_port


    def convert_ns_service_group(self, ns_service_group, ns_servers,
                                 ns_dns, avi_config, sysdict):
        """
        This function defines that returns the monitor ref and servers
        :param ns_service_group: Object of service group
        :param ns_servers: List of servers
        :param ns_dns: list of dns addrec
        :return: servers and monitor ref
        """

        servers = []
        monitor_name = None
        if isinstance(ns_service_group, dict):
            ns_service_group = [ns_service_group]
        use_service_port = False
        for server_binding in ns_service_group:
            attrs = server_binding.get('attrs')
            ns_bind_service_group_command = 'bind serviceGroup'
            group_status = \
                ns_util.get_conv_status(
                    server_binding, self.nsservice_bind_sg_skip, [], [],
                    user_ignore_val=self.nsservice_bind_sg_user_ignore)
            ns_bind_service_group_complete_command = \
                ns_util.get_netscalar_full_command(
                    ns_bind_service_group_command, server_binding)
            if server_binding.get('monitorName', None):
                monitor_name = server_binding.get('monitorName')
                # Added prefix for objects
                if self.prefix:
                    monitor_name = self.prefix + '-' + monitor_name
                if self.object_merge_check:
                    # Get the merge health monitor name
                    monitor_name = merge_object_mapping['health_monitor'].get(
                        monitor_name, None)
                monitor = [monitor for monitor in (sysdict['HealthMonitor'] +
                          avi_config['HealthMonitor']) if monitor['name'] ==
                           monitor_name]
                if not monitor:
                    monitor_name = '%s-%s' % (monitor_name, 'dummy')
                    monitor = [monitor for monitor in
                               avi_config['HealthMonitor']
                               if monitor['name'] == monitor_name]
                if monitor:
                    # Add summery of service group in CSV/report
                    ns_util.add_conv_status(
                        server_binding['line_no'], ns_bind_service_group_command,
                        attrs[0], ns_bind_service_group_complete_command,
                        group_status, monitor[0])
                else:
                    msg = ('External Health monitor: %s because bind service'
                           'is not in server' %
                           ns_bind_service_group_complete_command)
                    LOG.warning(msg)
                    # Skipped bind service group if doen not server
                    ns_util.add_status_row(
                        server_binding['line_no'], ns_bind_service_group_command,
                        attrs[0], ns_bind_service_group_complete_command,
                        STATUS_EXTERNAL_MONITOR, msg)

                continue

            server = ns_servers.get(attrs[1])
            if not server:
                # Skipped bind service group if doen not server
                ns_util.add_status_row(
                    server_binding['line_no'], ns_bind_service_group_command,
                    attrs[0], ns_bind_service_group_complete_command,
                    STATUS_INCOMPLETE_CONFIGURATION)
                LOG.error('Skipped server : %s' %
                          ns_bind_service_group_complete_command)
                continue

            ns_add_server_command = 'add server'
            ns_add_server_complete_command = \
                ns_util.get_netscalar_full_command(
                    ns_add_server_command, server)
            status = ns_util.get_conv_status(
                server, self.nsservice_server_skip, [], [],
                user_ignore_val=self.nsservice_server_user_ignore)
            ip_addr = server['attrs'][1]
            # Get the server name
            server_name = server['attrs'][0]
            if ip_addr in ns_dns:
                if isinstance(ns_dns[ip_addr], list):
                    ip_addr = ns_dns[ip_addr][0]['attrs'][1]
                elif isinstance(ns_dns[ip_addr], dict):
                    ip_addr = ns_dns[ip_addr]['attrs'][1]
            enabled = True
            state = server.get('state', 'ENABLED')
            if not state == 'ENABLED':
                enabled = False
            port = attrs[2]
            if port in ("*", "0"):
                port = "1"
                use_service_port = True
            # Added regex to match ip address
            matches = re.findall('^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$', ip_addr)
            server_obj = {
                'ip': {
                    'addr': ip_addr,
                    'type': 'V4'
                },
                'port': port,
                'enabled': enabled,
                'health_monitor': server_binding.get('monitorName')

            }
            if server_name:
                # Get the server name
                server_obj['hostname'] = server_name
            if not matches:
                try:
                    # If dns then resolve it get the ip address from it.
                    ip_addr = socket.gethostbyname(ip_addr)
                    server_obj['ip']['addr'] = ip_addr
                except:
                    update_count('warning')
                    # Skipped this server if it does not have an Ip
                    ns_util.add_status_row(
                        server['line_no'], ns_add_server_command, server['attrs'][0],
                        ns_add_server_complete_command,
                        STATUS_INCOMPLETE_CONFIGURATION)
                    LOG.warning('Not found IP of server : %s %s' %
                                (ns_add_server_command, attrs[1]))
                    ns_util.add_status_row(
                        server_binding['line_no'], ns_bind_service_group_command,
                        attrs[0], ns_bind_service_group_complete_command,
                        STATUS_INCOMPLETE_CONFIGURATION)
                    LOG.error('Skipped server : %s' %
                              ns_bind_service_group_complete_command)
                    server_obj = None
            if server_obj:
                servers.append(server_obj)
                # Add summery of add server in CSV/report
                ns_util.add_conv_status(
                    server['line_no'], ns_add_server_command, server['attrs'][0],
                    ns_add_server_complete_command, status, server_obj)
                # Add summery of service group in CSV/report
                ns_util.add_conv_status(
                    server_binding['line_no'], ns_bind_service_group_command,
                    attrs[0], ns_bind_service_group_complete_command,
                    group_status, server_obj)
        return servers, monitor_name, use_service_port
