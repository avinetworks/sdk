#!/usr/bin/env python
import copy
import logging
from avi.migrationtools.f5_converter.conversion_util import F5Util
from avi.migrationtools.vs_filter import path_key_map
import yaml
import os

LOG = logging.getLogger(__name__)

# Creating f5 object for util library.
conv_utils = F5Util()

obj_not_supported = ('vrfcontext', 'cloud', 'tenant',)

# These objects are present in admin tenant and visible across the other tenants.
admin_obj_visible_to_all = ('poolgroup', 'httppolicyset', 'pool',
                            'pkiprofile', 'stringgroup',
                            'vrfcontext', 'applicationprofile',
                            'vsdatascriptset', 'networksecuritypolicy',
                            'applicationpersistenceprofile', 'prioritylabels',
                            'vsvip', 'ipaddrgroup', 'virtualservice',)

# Iterate over these objects and clone cross tenant objects.
# Read supported avi objects from yaml file.
yml_file = os.path.abspath(os.path.join(os.path.dirname(__file__), '../common/avi_resource_types.yaml'))
supported_obj = yaml.load(open(yml_file, 'r'))
# Reverse order of avi_objects is required during clone operation.
avi_object_types = tuple(supported_obj['avi_resource_types'][::-1])


class CloneObjects:
    """ Share methods for cross tenant cloning of AVI Objects"""
    def __init__(self, avi_configs):
        self.old_avi_config = avi_configs

    # List of already cloned objects. Avoid duplication of objects.
    cloned = []

    def clone_object(self, object, obj_type, cross_tenant):
        """
        Function to clone avi_config object into cross tenant.

        :param object: Avi object configuration which has cross tenant reference
        :param obj_type: Type of an AVI Object.
        :param cross_tenant: Name of the (cross tenant) tenant which is
        referred in current object.
        :return: a cloned object configuration and it's reference url.
        """

        cloned_obj = copy.deepcopy(object)
        LOG.info("Copying object...!")
        cloned_obj['name'] += '-clone'
        cloned_obj['tenant_ref'] = conv_utils.get_object_ref(
            cross_tenant, 'tenant')
        cloned_obj_ref = conv_utils.get_object_ref(
            cloned_obj['name'], obj_type, tenant=cross_tenant)
        if cloned_obj_ref in self.cloned:
            LOG.info("Object already cloned. Return clone object ref %s", cloned_obj_ref)
            return None, cloned_obj_ref
        otenant = conv_utils.get_name(object['tenant_ref'])
        LOG.info("Cloned object %s with name %s from tenant %s to tenant %s.",
                 obj_type, cloned_obj['name'], otenant,
                 cross_tenant)
        return cloned_obj, cloned_obj_ref

    def rewrite_avi_obj_ref(self, dictionary, clone_obj_ref, key=''):
        """
        Updated reference of cloned object in parent object.

        :param dictionary: AVI object or AVI parameter.
        :param clone_obj_ref: Reference to cloned object.
        :param key: avi parameter
        :return:
        """
        if key == '':
            dictionary = clone_obj_ref
        else:
            dictionary[key] = clone_obj_ref
        return dictionary

    def add_cloned_obj(self, objtype, clone_objs):
        """
        Add cloned object in corresponding AVI object.

        :param objtype: Type of object.
        :param clone_objs: Updated AVI configuration.
        :return:
        """
        return self.old_avi_config[path_key_map[objtype]].append(clone_objs)

    def get_clone_ref_obj(self, p_tenant, ref_str='', ):
        """
        Clone objects by verifying cross tenant reference.

        :param p_tenant: Parent object tenant in which object needs to be cloned
        :param ref_str:
        :return: Cloned object and cloned object reference.
        """
        clone_objs = None
        clone_obj_ref = None
        objname = conv_utils.get_name(ref_str)
        objtype = conv_utils.get_obj_type_from_ref(ref_str)

        if objtype not in obj_not_supported:
            for child_obj in self.old_avi_config[path_key_map[objtype]]:
                if child_obj.get('name') and child_obj['name'] == objname:
                    clone_objs, clone_obj_ref = self.clone_object(
                        child_obj, objtype, p_tenant)
                    if clone_objs and clone_obj_ref:
                        self.cloned.append(clone_obj_ref)
                        break
        return clone_objs, clone_obj_ref

    def find_refs_and_clone(self, obj_dict, parent_tenant=None):
        """
        Find cross tenant referred objects, clone those objects and
        update corresponding object in AVI configuration.

        :param obj_dict: single AVI object e.g. single virtualservice
        :return:
        """
        if not parent_tenant:
            parent_tenant = conv_utils.get_name(obj_dict['tenant_ref'])
        for k, v in obj_dict.iteritems():
            if k == 'tenant_ref':
                continue
            if isinstance(v, dict):
                self.find_refs_and_clone(v, parent_tenant)
            elif isinstance(v, list) and len(v) > 0 and isinstance(v[0], dict):
                for child_obj in v:
                    self.find_refs_and_clone(child_obj, parent_tenant)
            elif k.endswith('_refs'):
                ref_list = list(set(copy.deepcopy(v)))
                for ref in v:
                    obj_tenant = conv_utils.get_tenant_from_ref(ref)
                    if obj_tenant == parent_tenant:
                        continue
                    o_type = conv_utils.get_obj_type_from_ref(ref)
                    if (obj_tenant == 'admin' and o_type in
                            admin_obj_visible_to_all):
                        continue
                    c_obj, c_ref = self.get_clone_ref_obj(parent_tenant, ref)
                    if c_ref:
                        ref_list.remove(ref)
                        ref_list.append(c_ref)
                        if c_obj:
                            self.add_cloned_obj(o_type, c_obj)
                if len(ref_list) > 0:
                    obj_dict[k] = ref_list
            elif k.endswith('_ref'):
                if v:
                    o_tenant = conv_utils.get_tenant_from_ref(v)
                    o_type = conv_utils.get_obj_type_from_ref(v)
                    if o_tenant == parent_tenant:
                        continue
                    if (o_tenant == 'admin' and o_type in
                            admin_obj_visible_to_all):
                        continue
                    c_obj, c_ref = self.get_clone_ref_obj(parent_tenant, v)
                    if c_ref:
                        obj_dict = self.rewrite_avi_obj_ref(obj_dict, c_ref, k)
                        if c_obj:
                            self.add_cloned_obj(o_type, c_obj)
        return

    def find_clone_all(self):
        """
        Iterate over AVI configuration of given objects in a list
        above and clone cross tenant objects.
        :return: New AVI config object with cloned cross tenant references.
        """

        total_size = len(avi_object_types)
        progress_count = 0
        LOG.info("Started Cloning of cross tenant objects")
        print "Cloning cross tenant objects..."
        msg = "Cloning started..."
        for object_type in avi_object_types:
            progress_count += 1
            conv_utils.print_progress_bar(progress_count, total_size,
                                          msg, prefix='Progress',
                                          suffix='')
            if object_type in ['Tenant', 'META']:
                continue
            for obj in self.old_avi_config.get(object_type, []):
                if obj:
                    self.find_refs_and_clone(obj)
        LOG.info("Finished cloning of cross tenant objects.")
        return
