#!/usr/bin/env python

from __future__ import print_function
import sys
import os
import argparse
import getpass
import textwrap

from avi.sdk.avi_api import ApiSession
from requests.packages import urllib3

# Suppress warnings (typically SSL certificate warnings) when calling the API

urllib3.disable_warnings()

DEFAULT_API_VERSION = '16.4.2'
AVICLONE_VERSION = [0, 0, 7]

# Try to obtain the terminal width to allow spprint() to wrap output neatly.
# If unable to determine, assume terminal width is 70 characters

try:
    T_SIZE = os.get_terminal_size()[0]
except:
    T_SIZE = 70
    pass


def spprint(s, ind='', **kwargs):
    flush = kwargs.pop('flush', False)
    print('\r\n'.join(textwrap.wrap(s, width=T_SIZE, subsequent_indent=ind,
                                    break_on_hyphens=False)), **kwargs)
    if flush:
        f = kwargs.get('file', sys.stdout)
        f.flush() if f is not None else sys.stdout.flush()


class AviClone:
    def __init__(self, api):
        self.api = api
        self.flush_actions()

    def flush_actions(self):
        self.actions = []

    def get_all_objects_by_name(self, path, name, tenant='', tenant_uuid='',
                           timeout=None, params=None, api_version=None,
                           **kwargs):
        """
        Helper function which works like the SDK's get_object_by_name but
        returns a list of matches rather than just the first match
        """

        obj = None
        if not params:
            params = {}
        params['name'] = name
        resp = self.api.get(path, tenant, tenant_uuid, timeout=timeout,
                        params=params, api_version=api_version, **kwargs)
        if resp.status_code in (401, 419):
            ApiSession.reset_session(self.api)
            resp = self.api.get_object_by_name(
                    path, name, tenant, tenant_uuid, timeout=timeout,
                    params=params, **kwargs)
        if resp.status_code < 300:
            obj = resp.json()['results']

        self.api._update_session_last_used()
        
        return obj

    def clone_pool(self, old_pool_name, new_pool_name, tenant = None,
                   other_tenant = None, other_cloud = None,
                   force_unique_name = False):

        """
        Clones a pool object
        
        Optionally creating the cloned pool in a different tenant and/or a
        different cloud.

        Returns json representation of the cloned pool object

        :param old_pool_name: Name of existing pool
        :param new_pool_name: New name for cloned pool
        :param tenant: Tenant for existing pool (if not specfied, use user's
                        default tenant)
        :param other_tenant: Tenant for cloned pool (if not specified, clone to
                                same tenant as source)
        :param other_cloud: Cloud for cloned pool (if not specified, clone to
                            same cloud as source)
        :param force_unique_name: Resolve destination name conflicts by
                                    appending an index number
        :return: json representation of the cloned pool object
        :rtype: dict
        """

        # Lookup source and destination tenant and destination cloud if
        # specified

        if tenant is None:
            t_obj = None
        else:
            t_obj = self.api.get_object_by_name('tenant', tenant)
            if t_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                tenant)

        if other_tenant is None:
            ot_obj = None
        else:
            ot_obj = self.api.get_object_by_name('tenant', other_tenant)
            if ot_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                other_tenant)

        if other_cloud is None:
            oc_obj = None
        else:
            oc_obj = self.api.get_object_by_name('cloud', other_cloud)
            if oc_obj is None:
                raise Exception('A cloud with name %s could not be found' %
                                other_cloud)

        # Get existing pool object (either by name or by ref if old_pool_name
        # is in ref form)

        if old_pool_name.startswith('pool/'):
            p_obj = self.api.get(old_pool_name, tenant_uuid = t_obj['uuid'] if
                    t_obj else None).json()
            old_pool_name = p_obj['name']
        else:
            p_obj = self.api.get_object_by_name('pool', old_pool_name,
                                tenant_uuid = t_obj['uuid'] if t_obj else None)
        if not p_obj:
            raise Exception('Pool %s could not be found' % old_pool_name)

        p_obj_check = self.api.get_object_by_name('pool', new_pool_name,
                        tenant_uuid = ot_obj['uuid'] if ot_obj else
                        t_obj['uuid'] if t_obj else None)

        if p_obj_check is not None:
            if force_unique_name:
                count = 1
                new_pool_name_prefix = new_pool_name
                while p_obj_check is not None:
                    new_pool_name = new_pool_name_prefix + '-' + str(count)
                    count += 1
                    p_obj_check = self.api.get_object_by_name('pool',
                                    new_pool_name, tenant_uuid = ot_obj['uuid']
                                if ot_obj else t_obj['uuid'] if t_obj else None)
            else:
                raise Exception('A pool with name %s already exists' %
                                new_pool_name)

        # Remove unique attributes and rename pool

        p_obj.pop('uuid', None)
        p_obj.pop('url', None)
        p_obj['name'] = new_pool_name

        # (Try to!) move the new pool to a different cloud

        if oc_obj:
            p_obj['cloud_ref'] = oc_obj['url']

            # If moving to a different cloud, pool will be moved to the default
            # global VRF in the target cloud

            p_obj.pop('vrf_ref', None)

        # Try to create cloned pool (possibly in a different tenant to the
        # source pool)

        r = self.api.post('pool', p_obj, tenant_uuid = ot_obj['uuid'] if ot_obj
                            else t_obj['uuid'] if t_obj else None)
        if r.status_code < 300:
            new_pool = r.json()
            self.actions += ['Cloned pool %s%s to %s%s%s' % (old_pool_name,
                            (' in tenant "'+t_obj['name']+'"') if t_obj else '',
                            new_pool_name, (' in tenant "'+ot_obj['name']+'"')
                            if ot_obj else '', ' in cloud "'+oc_obj['name']+'"'
                            if oc_obj else '')]
            return new_pool
        else:
            raise Exception('Unable to clone pool %s as %s (%d:%s)' %
                            (old_pool_name, new_pool_name, r.status_code,
                             r.text))

    def clone_pool_group(self, old_pool_group_name, new_pool_group_name,
                         tenant, other_tenant, other_cloud,
                         force_unique_name = False):

        """
        Clones a pool group object
        
        Optionally creating the cloned pool group in a different tenant and/or
        a different cloud.

        Returns a tuple: json representation of the cloned pool object, list of
        additional objects created if any

        :param old_pool_group_name: Name of existing pool group
        :param new_pool_group_name: New name for cloned pool group
        :param tenant: Tenant for existing pool group (if not specfied, use
                        user's default tenant)
        :param other_tenant: Tenant for cloned pool group (if not specified,
                            clone to same tenant as source)
        :param other_cloud: Cloud for cloned pool group (if not specified,
                            clone to same cloud as source)
        :param force_unique_name: Resolve destination name conflicts by
                                    appending an index number
        :return: tuple - json representation of the cloned pool group object,
                    list of additional objects created if any
        :rtype: tuple
        """

        # Lookup source and destination tenant and destination cloud
        # if specified

        if tenant is None:
            t_obj = None
        else:
            t_obj = self.api.get_object_by_name('tenant', tenant)
            if t_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                tenant)

        if other_tenant is None:
            ot_obj = None
        else:
            ot_obj = self.api.get_object_by_name('tenant', other_tenant)
            if ot_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                other_tenant)

        if other_cloud is None:
            oc_obj = None
        else:
            oc_obj = self.api.get_object_by_name('cloud', other_cloud)
            if oc_obj is None:
                raise Exception('A cloud with name %s could not be found' %
                                other_cloud)

        # Get existing pool group object (either by name or by ref if
        # old_pool_group_name is in ref form)

        if old_pool_group_name.startswith('poolgroup/'):
            pg_obj = self.api.get(old_pool_group_name,
                        tenant_uuid = t_obj['uuid'] if t_obj else None).json()
            old_pool_group_name = pg_obj['name']
        else:
            pg_obj = self.api.get_object_by_name('poolgroup',
                        old_pool_group_name, tenant_uuid = t_obj['uuid'] if
                                                            t_obj else None)
        if not pg_obj:
            raise Exception('Pool group %s could not be found' %
                            old_pool_group_name)

        pg_obj_check = self.api.get_object_by_name('poolgroup',
                            new_pool_group_name, tenant_uuid = ot_obj['uuid']
                                if ot_obj else t_obj['uuid'] if t_obj else None)

        if pg_obj_check is not None:
            if force_unique_name:
                count = 1
                new_pool_group_name_prefix = new_pool_group_name
                while pg_obj_check is not None:
                    new_pool_group_name = new_pool_group_name_prefix + '-' + \
                                          str(count)
                    count += 1
                    pg_obj_check = self.api.get_object_by_name('poolgroup',
                                    new_pool_group_name,
                                    tenant_uuid = ot_obj['uuid'] if ot_obj else
                                    t_obj['uuid'] if t_obj else None)
            else:
                raise Exception('A pool group with name %s already exists' %
                                new_pool_group_name)

        # Currently also have to clone pools that are members of this pool group

        created_objs = []

        try:
            if 'members' in pg_obj:
                count = 1
                for member in pg_obj['members']:
                    if 'pool_ref' in member:
                        p_path = member['pool_ref'].split('/api/')[1]

                        p_obj = self.clone_pool(p_path, new_pool_group_name +
                                    '-pool-' + str(count), tenant, other_tenant,
                                                other_cloud, True)
                        count += 1

                        created_objs.append(p_obj)

                        # Update the pool with the cloned pool

                        member['pool_ref'] = p_obj['url']

            # Remove unique attributes and rename pool group

            pg_obj.pop('uuid', None)
            pg_obj.pop('url', None)
            pg_obj['name'] = new_pool_group_name

            # (Try to!) move the new pool group to a different cloud

            if oc_obj:
                pg_obj['cloud_ref'] = oc_obj['url']

            # Try to create cloned pool group (possibly in a different tenant to
            # the source pool group)

            r = self.api.post('poolgroup', pg_obj, tenant_uuid = ot_obj['uuid']
                                if ot_obj else t_obj['uuid'] if t_obj else None)
            if r.status_code < 300:
                new_pool_group = r.json()
                self.actions += ['Cloned pool group %s%s to %s%s%s' %
                                 (old_pool_group_name,
                                 (' in tenant "'+t_obj['name']+'"') if t_obj
                                 else '', new_pool_group_name,
                                 (' in tenant "'+ot_obj['name']+'"') if
                                 ot_obj else '', ' in cloud "'+oc_obj[
                                     'name']+'"' if oc_obj else '')]
            
                return new_pool_group, created_objs
            else:
                raise Exception('Unable to clone pool group %s as %s (%d:%s)' %
                                (old_pool_group_name, new_pool_group_name,
                                 r.status_code, r.text))
        except Exception as ec:
            # If an exception occurred, delete any intermediate objects we
            # have created

            for obj in created_objs:
                self.api.delete(obj['url'].split('/api/')[1],
                    tenant_uuid = ot_obj['uuid'] if ot_obj else t_obj['uuid']
                    if t_obj else None)

            raise Exception('%s\r\n=> Unable to clone pool group %s as %s' %
                            (ec, old_pool_group_name, new_pool_group_name))

    def clone_http_pol_set(self, old_http_pol_set_name, new_http_pol_set_name,
                           tenant, other_tenant, other_cloud,
                           force_unique_name = False):

        """
        Clones an HTTP policy set object
        
        Optionally creating the cloned policy set in a different tenant and/or
        a different cloud.

        Returns a tuple: json representation of the cloned policy set object,
        list of additional objects created if any

        :param old_http_pol_set_name: Name of existing policy set
        :param new_http_pol_set_name: New name for cloned policy set
        :param tenant: Tenant for existing policy set (if not specfied, use
                        user's default tenant)
        :param other_tenant: Tenant for cloned policy set (if not specified,
                            clone to same tenant as source)
        :param other_cloud: Cloud for cloned policy set (if not specified,
                            clone to same cloud as source)
        :param force_unique_name: Resolve destination name conflicts by
                                    appending an index number
        :return: tuple - json representation of the cloned policy set object,
                list of additional objects created if any
        :rtype: tuple
        """
        # Lookup source and destination tenant and destination cloud if
        # specified

        if tenant is None:
            t_obj = None
        else:
            t_obj = self.api.get_object_by_name('tenant', tenant)
            if t_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                tenant)

        if other_tenant is None:
            ot_obj = None
        else:
            ot_obj = self.api.get_object_by_name('tenant', other_tenant)
            if ot_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                other_tenant)

        if other_cloud is None:
            oc_obj = None
        else:
            oc_obj = self.api.get_object_by_name('cloud', other_cloud)
            if oc_obj is None:
                raise Exception('A cloud with name %s could not be found' %
                                other_cloud)

        # Get existing pool object (either by name or by ref if old_pool_name
        # is in ref form)

        if old_http_pol_set_name.startswith('httppolicyset/'):
            ps_obj = self.api.get(old_http_pol_set_name,
                        tenant_uuid = t_obj['uuid'] if t_obj else None).json()
            old_http_pol_set_name = ps_obj['name']
        else:
            ps_obj = self.api.get_object_by_name('httppolicyset',
                            old_http_pol_set_name, tenant_uuid = t_obj['uuid']
                            if t_obj else None)
        if not ps_obj:
            raise Exception('HTTP policy set %s could not be found' %
                            old_http_pol_set_name)

        ps_obj_check = self.api.get_object_by_name('httppolicyset',
                                                   new_http_pol_set_name)

        if ps_obj_check is not None:
            if force_unique_name:
                count = 1
                new_http_pol_set_name_prefix = new_http_pol_set_name
                while ps_obj_check is not None:
                    new_http_pol_set_name = new_http_pol_set_name_prefix + '-' \
                                            + str(count)
                    count += 1
                    ps_obj_check = self.api.get_object_by_name('httppolicyset',
                                                        new_http_pol_set_name)
            else:
                raise Exception('An HTTP policy set with name %s already exists'
                                % new_http_pol_set_name)

        # Remove unique attributes and rename HTTP policy set

        ps_obj.pop('uuid', None)
        ps_obj.pop('url', None)
        ps_obj['name'] = new_http_pol_set_name   

        # Check for any pools/pool groups referenced in content re-writing
        # rules and clone them

        created_objs = []

        try:
            if 'http_request_policy' in ps_obj:
                if 'rules' in ps_obj['http_request_policy']:
                    for rule in ps_obj['http_request_policy']['rules']:
                        if 'switching_action' in rule:
                            if 'pool_ref' in rule['switching_action']:
                                p_path = rule['switching_action'][
                                                'pool_ref'].split('/api/')[1]
                                p_obj = self.clone_pool(p_path,
                                            new_http_pol_set_name + '-pool',
                                        tenant, other_tenant, other_cloud, True)
                                rule['switching_action']['pool_ref'] = \
                                                                    p_obj['url']
                                created_objs.append(p_obj)
                            if 'pool_group_ref' in rule['switching_action']:
                                p_path = rule['switching_action'][
                                            'pool_group_ref'].split('/api/')[1]
                                p_obj, p_created_objs = self.clone_pool_group(
                                            p_path, new_http_pol_set_name +
                                            '-poolgroup', tenant, other_tenant,
                                                            other_cloud, True)
                                rule['switching_action']['pool_group_ref'] = \
                                                                    p_obj['url']
                                created_objs.append(p_obj)
                                created_objs.extend(p_created_objs)

            r = self.api.post('httppolicyset', ps_obj,
                    tenant_uuid = ot_obj['uuid'] if ot_obj else t_obj['uuid']
                    if t_obj else None)
            if r.status_code < 300:
                new_polset = r.json()
                self.actions += ['Cloned HTTP policy set %s%s to %s%s' %
                                 (old_http_pol_set_name,
                                 (' in tenant "'+t_obj['name']+'"') if t_obj
                                 else '', new_http_pol_set_name,
                                 (' in tenant "'+ot_obj['name']+'"') if
                                  ot_obj else '')]

                return new_polset, created_objs
            else:
                raise Exception('Unable to clone HTTP policy set %s as %s '
                                '(%d:%s)' % (old_http_pol_set_name,
                                new_http_pol_set_name, r.status_code, r.text))
        except Exception as ex:
            # If an exception occurred, delete any intermediate objects we
            # have created

            for obj in created_objs:
                self.api.delete(obj['url'].split('/api/')[1],
                                tenant_uuid = ot_obj['uuid'] if ot_obj else
                                t_obj['uuid'] if t_obj else None)

            raise Exception('%s\r\n=> Unable to clone HTTP policy set %s as %s'
                            % (ex, old_http_pol_set_name,
                               new_http_pol_set_name))

    def clone_vs(self, old_vs_name, new_vs_name, enable_vs = False,
                 new_vs_vips = ['*'], new_vs_fips = [None], new_fqdns = ['*'],
                 new_segroup = None, tenant = None, other_tenant = None,
                 other_cloud = None, force_unique_name = False):

        """
        Clones a virtual service object
        
        Optionally creating the cloned VS in a different tenant and/or a
        different cloud.

        Returns a tuple: json representation of the cloned virtual service,
        list of additional objects created if any

        :param old_vs_name: Name of existing virtual service
        :param new_vs_name: New name for cloned virtual service
        :param enable_vs: Whether the cloned VS should be enabled
        :param new_vs_vips: List of VIPs for cloned VS or ['*'] to use
                            auto-allocation for VIPs and FIPs (source VS must
                            also use auto-allocation)
        :param new_vs_fips: List of FIPs for cloned VS or [None] if FIPs are
                            not used (must have same number of elements as
                            new_vs_vips if specified)
        :param new_fqdns: List of FQDNs for cloned VS or ['*'] to derive FQDN
                            from new_vs_name and domain name in original VS
        :param new_segroup: SE Group to be used by cloned VS or None to use SE
                            group with same name as used by source VS
        :param tenant: Tenant for existing VS (if not specfied, use user's
                        default tenant)
        :param other_tenant: Tenant for cloned VS (if not specified, clone to
                                same tenant as source)
        :param other_cloud: Cloud for cloned VS (if not specified, clone to
                            same cloud as source)
        :param force_unique_name: Resolve destination name conflicts by
                                    appending an index number
        :return: tuple - json representation of the cloned VS object, list of
                    additional objects created if any
        :rtype: tuple
        """
        # Lookup source and destination tenant and destination cloud if
        # specified

        if tenant is None:
            t_obj = None
        else:
            t_obj = self.api.get_object_by_name('tenant', tenant)
            if t_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                tenant)

        if other_tenant is None:
            ot_obj = None
        else:
            ot_obj = self.api.get_object_by_name('tenant', other_tenant)
            if ot_obj is None:
                raise Exception('A tenant with name %s could not be found' %
                                other_tenant)

        if other_cloud is None:
            oc_obj = None
        else:
            oc_obj = self.api.get_object_by_name('cloud', other_cloud)
            if oc_obj is None:
                raise Exception('A cloud with name %s could not be found' %
                                other_cloud)
        
        # Get existing VS object (either by name or by ref if old_vs_name is in
        #  ref form)

        if new_vs_fips != [None] and len(new_vs_vips) != len(new_vs_fips):
            raise Exception('Cannot clone virtual service if number of VIPs and'
                            ' number of FIPs is not equal')

        if old_vs_name.startswith('virtualservice/'):
            v_obj = self.api.get(old_vs_name, tenant_uuid = t_obj['uuid'] if
                    t_obj else None).json()
            old_vs_name = v_obj['name']
        else:
            v_obj = self.api.get_object_by_name('virtualservice', old_vs_name,
                                tenant_uuid = t_obj['uuid'] if t_obj else None)
        if not v_obj:
            raise Exception('Virtual Service %s could not be found' %
                            old_vs_name)

        c_obj = self.api.get(v_obj['cloud_ref'].split('/api/')[1]).json()

        created_objs = []

        try:
            # Clone the pool/pool group used by the VS

            if 'pool_ref' in v_obj:
                p_path = v_obj['pool_ref'].split('/api/')[1]

                p_obj = self.clone_pool(p_path, new_vs_name + '-pool', tenant,
                                        other_tenant, other_cloud, True)

                created_objs.append(p_obj)

                # Update the pool with the cloned pool

                v_obj['pool_ref'] = p_obj['url']

            if 'pool_group_ref' in v_obj:
                p_path = v_obj['pool_group_ref'].split('/api/')[1]

                p_obj, p_created_objs = self.clone_pool_group(p_path,
                                            new_vs_name + '-poolgroup', tenant,
                                                other_tenant, other_cloud, True)
                created_objs.append(p_obj)
                created_objs.extend(list(p_created_objs))

                # Update the pool group with the cloned pool group

                v_obj['pool_group_ref'] = p_obj['url']
   
            # Remove unique atributes and rename

            v_obj.pop('uuid', None)
            v_obj.pop('url', None)
            v_obj.pop('network_security_policy_ref', None)
            v_obj.pop('vip_runtime', None)
            v_obj['name'] = new_vs_name

            # (Try to!) move the new virtual service to a different cloud

            if oc_obj:
                v_obj['cloud_ref'] = oc_obj['url']
                v_obj.pop('cloud_type')

                # If moving to a different cloud and a new SE group is not
                # specified, try to find an SE group
                # with the same name as the source virtual service's SE group

                if new_segroup is None:
                    seg_obj = self.api.get(
                                v_obj['se_group_ref'].split('/api/')[1],
                                tenant_uuid = t_obj['uuid'] if
                                t_obj else None).json()
                    new_segroup = seg_obj['name']
                
                # If moving to a different cloud, virtual service will be moved
                # to the default global VRF in the target cloud

                v_obj.pop('vrf_context_ref', None)

            if new_segroup is not None:
                # Locate SE group by name in the appropriate cloud

                cloud_url = c_obj['url'] if oc_obj is None else oc_obj['url']

                new_seg_objs = self.get_all_objects_by_name(
                                'serviceenginegroup', new_segroup,
                                tenant_uuid = ot_obj['uuid'] if ot_obj else
                                t_obj['uuid'] if t_obj else None)

                new_seg_obj = [new_seg_obj for new_seg_obj in new_seg_objs if
                               new_seg_obj['cloud_ref'] == cloud_url]

                # If can't find an SE group with matching name, raise an error

                try:
                    v_obj['se_group_ref'] = new_seg_obj[0]['url']
                except IndexError:
                    raise Exception('A service engine group with name %s could'
                                    ' not be found' % new_segroup)
                
            v_obj['enabled'] = enable_vs

            '''
            Clone any policy sets referenced in the VS
            '''

            if 'http_policies' in v_obj:
                for polset in v_obj['http_policies']:
                    ps_path = polset['http_policy_set_ref'].split('/api/')[1]
                    ps_obj, ps_created_objs = self.clone_http_pol_set(ps_path,
                        '-'.join([new_vs_name, c_obj['name'] if oc_obj is None
                        else oc_obj['name'], 'HTTP-Policy-Set']), tenant,
                                                other_tenant, other_cloud, True)
                    polset['http_policy_set_ref'] = ps_obj['url']
                    created_objs.append(ps_obj)
                    created_objs.extend(list(ps_created_objs))

            '''
            Allocate new VIPs. If auto-allocating then remove existing IP 
            addresses and allow auto_allocate_ip to do the work. Otherwise build
            a new array of VIPs.
            For versions prior to 17.1, only a single VIP is supported, and in 
            this case (detected by the absence of the 'vips' attribute), only 
            populate the first VIP.
            '''

            if new_vs_vips == ['*']:
                v_obj.pop('vsvip_ref', None)
                for vip in v_obj['vip'] if 'vip' in v_obj else [v_obj]:
                    vip.pop('port_uuid', None)
                    if vip['auto_allocate_ip'] is True:
                        vip.pop('ip_address', None)                        
                    else:
                        raise Exception('Existing VS does not have '
                                        'auto-allocate enabled')
                    if vip['auto_allocate_floating_ip'] is True:
                        vip.pop('floating_ip', None)
            else:
                if 'vip' in v_obj:
                    v_obj.pop('vip', None)
                    v_obj.pop('vsvip_ref', None)
                    if new_vs_fips == [None]:
                        v_obj['vip'] = [{'auto_allocate_ip': False,
                                'enabled': True, 'vip_id': str(c+1),
                                'ip_address': {'type': 'V4', 'addr':
                                new_vs_vip}} for c, new_vs_vip in
                                         enumerate(new_vs_vips)]
                    else:
                        v_obj['vip'] = [{'auto_allocate_ip': False,
                                'auto_allocate_fip': False, 'enabled': True,
                                'vip_id': str(c+1), 'ip_address': {'type': 'V4',
                                'addr': new_vs_vip}, 'floating_ip': {
                                'type': 'V4', 'addr': new_vs_fip}} for c,
                                (new_vs_vip, new_vs_fip) in enumerate(zip(
                                                    new_vs_vips, new_vs_fips))]
                else:
                    v_obj['auto_allocate_ip'] = False
                    v_obj['auto_allocate_fip'] = False
                    v_obj.pop('discovered_networks', None)
                    v_obj['ip_address'] = {'type': 'V4', 'addr': new_vs_vips[0]}
                    if new_vs_fips is None:
                        v_obj.pop('floating_ip', None)
                    else:
                        v_obj['floating_ip'] = {'type': 'V4',
                                                'addr': new_vs_fips[0]}
            
            # Allocate new FQDNs or create a single FQDN derived from the first
            # FQDN, replacing the hostname part with the new VS name

            if new_fqdns == ['*']:
                if 'dns_info' in v_obj:
                    new_fqdn = new_vs_name + '.' + v_obj['dns_info'][0][
                                'fqdn'].split('.', 1)[1]
                    v_obj['dns_info'] = [{'type': 'DNS_RECORD_A',
                                           'fqdn': new_fqdn}]
            else:
                if new_fqdns != [None]:
                    v_obj['dns_info'] = [{'type': 'DNS_RECORD_A',
                                    'fqdn': new_fqdn} for new_fqdn in new_fqdns]
                else:
                    v_obj.pop('dns_info', None)

            # Try to create the new VS (possibly in a different tenant to the
            # source)

            r = self.api.post('virtualservice', v_obj,
                              tenant_uuid = ot_obj['uuid'] if ot_obj else
                              t_obj['uuid'] if t_obj else None)

            if r.status_code < 300:
                newvs = r.json()
                self.actions += ['Cloned virtual service %s%s to %s%s%s' %
                                (old_vs_name, (' in tenant "'+t_obj['name']+'"')
                                if t_obj else '', new_vs_name,
                                (' in tenant "'+ot_obj['name']+'"') if ot_obj
                                else '', ' in cloud "'+oc_obj['name']+'"'
                                if oc_obj else '')]

                return newvs, created_objs
            else:
                raise Exception('Unable to create virtual service %s (%d:%s)' %
                                (new_vs_name, r.status_code, r.text))
        except Exception as exc:
            # If an exception occurred, delete any intermediate objects we have
            # created

            for obj in created_objs:
                self.api.delete(obj['url'].split('/api/')[1],
                    tenant_uuid = ot_obj['uuid'] if ot_obj else t_obj['uuid']
                    if t_obj else None)

            raise Exception('%s\r\n=> Unable to clone virtual service %s as %s'
                            % (exc, old_vs_name, new_vs_name))

if __name__ == '__main__':
    print('%s version %s' % (sys.argv[0], '.'.join(str(v) for v in
                                                   AVICLONE_VERSION)))
    print()

    # Build the command-line parameter parser

    parser = argparse.ArgumentParser(description = '')
    parser.add_argument('-c', '--controller',
                        help = 'FQDN or IP address of Avi Vantage controller')
    parser.add_argument('-u', '--user', help = 'Avi Vantage username',
                        default='admin')
    parser.add_argument('-p', '--password', help = 'Avi Vantage password')
    parser.add_argument('-x', '--api_version',
          help = 'Avi Vantage API version (default=%s)' % DEFAULT_API_VERSION,
                                                    default=DEFAULT_API_VERSION)
    type_parser = parser.add_subparsers(help = 'Type of object to clone',
                                metavar = 'object_type', dest = 'obj_type')
    vs_parser = type_parser.add_parser('vs', help = 'Clone a Virtual Service')
    vs_parser.add_argument('vs_name',
                           help = 'Name of an existing Virtual Service')
    vs_parser.add_argument('new_vs_names',
               help = 'Name(s) to be assigned to the cloned Virtual Service(s)')
    vs_parser.add_argument('-v', '--vips',
          help = 'The new VIP or list of VIPs (optionally specify list of FIPs '
          'after ;) or * for auto-allocation', metavar = 'VIPs', default = '*')
    vs_parser.add_argument('-d', '--fqdns',
        help = 'The new FQDN or list of FQDNs or * to derive from the VS name',
                           metavar = 'FQDNs', default = '')
    vs_parser.add_argument('-e', '--enable',
        help = 'Enable the cloned Virtual Service', action = 'store_true')
    vs_parser.add_argument('-t', '--tenant',
                    help = 'Scope to a particular tenant', metavar = 'tenant')
    vs_parser.add_argument('-2t', '--totenant',
                           help = 'Clone the service to a different tenant',
                           metavar = 'other_tenant')
    vs_parser.add_argument('-2c', '--tocloud',
                           help = 'Clone the service to a different cloud',
                           metavar = 'other_cloud')
    vs_parser.add_argument('-g', '--segroup',
            help = 'The optional new SE group for the cloned Virtual Service',
                           metavar = 'se_group')
    pool_parser = type_parser.add_parser('pool', help = 'Clone a Pool')
    pool_parser.add_argument('pool_name', help = 'Name of an existing Pool')
    pool_parser.add_argument('new_pool_names',
                        help = 'Name(s) to be assigned to the cloned Pool(s)')
    pool_parser.add_argument('-t', '--tenant',
                             help = 'Scope to a particular tenant',
                             metavar = 'tenant')
    pool_parser.add_argument('-2t', '--totenant',
                             help = 'Clone the pool to a different tenant',
                             metavar = 'other_tenant')
    pool_parser.add_argument('-2c', '--tocloud',
                             help = 'Clone the pool to a different cloud',
                             metavar = 'other_cloud')
    pool_group_parser = type_parser.add_parser('poolgroup',
                                               help = 'Clone a Pool Group')
    pool_group_parser.add_argument('pool_group_name',
                                   help = 'Name of an existing Pool Group')
    pool_group_parser.add_argument('new_pool_group_names',
                    help = 'Name(s) to be assigned to the cloned Pool Group(s)')
    pool_group_parser.add_argument('-t', '--tenant',
                      help = 'Scope to a particular tenant', metavar = 'tenant')
    pool_group_parser.add_argument('-2t', '--totenant',
                            help = 'Clone the pool group to a different tenant',
                                   metavar = 'other_tenant')
    pool_group_parser.add_argument('-2c', '--tocloud',
                            help = 'Clone the pool group to a different cloud',
                                   metavar = 'other_cloud')
    
    args = parser.parse_args()

    if args and args.obj_type:

        # If not specified on the command-line, prompt the user for the
        # controller IP address and/or password

        controller = args.controller
        user = args.user
        password = args.password

        while not controller:
            controller = input('Controller:')

        while not password:
            password = getpass.getpass('Password for %s@%s:' %
                                       (user, controller))

        try:
            # Create the API session

            print('Creating API session...', end = '')
            api = ApiSession.get_session(controller, user, password,
                                         api_version=args.api_version)
            print('OK!')
            print()

            # Create an instance of our cloning class

            cl = AviClone(api)

            if args.obj_type == 'vs':
                # Loop through the clone names and clone the source VS for
                # each destination

                new_vs_names = args.new_vs_names.split(',')
                num_new_vs = len(new_vs_names)

                vipsfips = args.vips.split(';')
                vips = ['*'] * num_new_vs if args.vips == '*' else \
                                                        vipsfips[0].split(',')
                fips = [None] * num_new_vs if (args.vips == '*' or
                                len(vipsfips) == 1) else vipsfips[1].split(',')
                fqdns = ['*'] * num_new_vs if args.fqdns == '*' else \
                    args.fqdns.split(',') if args.fqdns else [None] * num_new_vs

                if num_new_vs == 1:
                    # If we only have a single destination VS name, assume the
                    # provided VIPs/FIPs/FQDNs are multi-values for a single
                    # VS rather than values per new VS

                    vips = [vips]
                    fips = [fips]
                    fqdns = [fqdns]
                else:
                    # Otherwise, make sure we have the same number of VIPs,
                    # FIPs, FQDNs as the number of provided VS names

                    if len(vips) == len(fips) == len(fqdns) == num_new_vs:
                        vips = [[vip] for vip in vips]
                        fips = [[fip] for fip in fips]
                        fqdns = [[fqdn] for fqdn in fqdns]
                    else:
                        raise Exception("Number of VIPs, FIPs and FQDNs "
                                        "specified should match the number of "
                                        "new virtual services")

                for new_vs_name, new_vips, new_fips, new_fqdns in \
                        zip(new_vs_names, vips, fips, fqdns):
                    spprint('Trying to clone VS %s%s to %s%s%s...' %
                            (args.vs_name, ' ['+args.tenant+']' if args.tenant
                            else '',new_vs_name, ' ['+args.totenant+']' if
                            args.totenant else '', ' in cloud '+args.tocloud if
                            args.tocloud else ''), end = '', flush = True)
                    new_vs, created_objs = cl.clone_vs(args.vs_name,
                                            new_vs_name, args.enable, new_vips,
                                            new_fips, new_fqdns, args.segroup,
                                            args.tenant, args.totenant,
                                                       args.tocloud, False)
                    print('OK!')
                    print()

                    print('New Virtual Service created as follows:')
                    print('%10s: %s' % ('Name', new_vs['name']))
                    print('%10s: %s' % ('VIP(s)', ','.join([ipa['ip_address'][
                                        'addr'] for ipa in new_vs['vip']]) if
                            'vip' in new_vs else new_vs['ip_address']['addr']))
                    print('%10s: %s' % ('FIP(s)', ','.join([(ipa['floating_ip'][
                                        'addr'] if 'floating_ip' in ipa else
                                        'N/A') for ipa in new_vs['vip']]) if
                                        'vip' in new_vs else (new_vs[
                                        'floating_ip']['addr'] if
                                        'floating_ip' in new_vs else 'N/A')))
                    if 'dns_info' in new_vs:
                        print('%10s: %s' % ('FQDN(s)',
                         ','.join([dns['fqdn'] for dns in new_vs['dns_info']])))
                    print('%10s: %s' % ('State', 'Enabled' if new_vs['enabled']
                                                               else 'Disabled'))
                    if args.totenant:
                        print('%10s: %s' % ('Tenant', args.totenant))
                    if args.tocloud:
                        print('%10s: %s' % ('Cloud', args.tocloud))
                    print()
            elif args.obj_type == 'pool':
                # Loop through the clone names and clone the source pool for
                # each destination

                for new_pool_name in args.new_pool_names.split(','):
                    spprint('Trying to clone pool %s%s to %s%s%s...' %
                            (args.pool_name, ' ['+args.tenant+']' if args.tenant
                            else '',new_pool_name, ' ['+args.totenant+']' if
                            args.totenant else '', ' in cloud '+args.tocloud if
                            args.tocloud else ''), end = '', flush = True)
                    new_pool = cl.clone_pool(args.pool_name, new_pool_name,
                                args.tenant, args.totenant, args.tocloud, False)
                    print('OK!')
                    print()

                    print('New Pool created as follows:')
                    print('%10s: %s' % ('Name', new_pool['name']))
                    if args.totenant:
                        print('%10s: %s' % ('Tenant', args.totenant))
                    if args.tocloud:
                        print('%10s: %s' % ('Cloud', args.tocloud))
                    print()

            elif args.obj_type == 'poolgroup':
                # Loop through the clone names and clone the source pool group
                # for each destination

                for new_pool_group_name in args.new_pool_group_names.split(','):
                    spprint('Trying to clone pool group %s%s to %s%s%s...' %
                            (args.pool_group_name, ' ['+args.tenant+']' if
                            args.tenant else '',new_pool_group_name,
                            ' ['+args.totenant+']' if args.totenant else '',
                            ' in cloud '+args.tocloud if args.tocloud else ''))
                    new_pool_group, created_objs = cl.clone_pool_group(
                        args.pool_group_name, new_pool_group_name, args.tenant,
                        args.totenant, args.tocloud, False)
                    print('OK!')
                    print()

                    print('New Pool Group created as follows:')
                    print('%10s: %s' % ('Name', new_pool_group['name']))
                    if args.totenant:
                        print('%10s: %s' % ('Tenant', args.totenant))
                    if args.tocloud:
                        print('%10s: %s' % ('Cloud', args.tocloud))
                    print()

            # Display the actions taken by the cloning class

            print('-' * 32)
            print('Actions taken were:')
            for i, a in enumerate(cl.actions):
                spprint('%2d. %s' % (i+1, a), '    ')

        except Exception as e:
            print()
            print(e)
    else:
        parser.print_help()

'''
Notes:
The script allows the cloning of virtual services, pools and pool groups. 
The script clones any additional objects that are required, so for example 
when cloning a virtual service, the pools and/or pool groups used by that VS,
including any specified in context-switching rules, will also be cloned.

The script also allows the cloning of objects into a different tenant and/or 
cloud than the source. This may not always be successful because the source 
and destination tenant/cloud may have different properties. If the clone attempt
fails, the script will automatically delete any objects that it created along 
the way.

If the object to be cloned uses features specific to a particular minimum Avi
Vantage s/w release, it may be necessary to specify the API version using the
-x parameter.

Some known limitations:
* Cloning a VS which references tenant-specific application profiles etc. to a
 different tenant is likely to fail
* Cloning a VS with automatic address allocation to a different cloud is likely
 to fail (unless static VIPs/FIPs are specified)
* Cloning a VS to a cloud of a different type to the source cloud is more likely
 to fail as it may reference shared objects which do not make sense in the 
 destination cloud
* Cloning a VS to a different tenant/cloud will try to find an SE group with the
 same name as referenced in the source VS but if no match is found, will place
  into the Default SE group instead
* The script has been primarily written for and tested with Linux/VMWare/AWS
 clouds - it may not work as-is for other clouds
'''
