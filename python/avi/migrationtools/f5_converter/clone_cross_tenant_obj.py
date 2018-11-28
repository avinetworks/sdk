#!/usr/bin/env python
import json
import urlparse
import copy
import logging
from avi.migrationtools.f5_converter.conversion_util import F5Util

# LOG = logging.getLogger(__name__)

# Creating f5 object for util library.
conv_utils = F5Util()

api_avi_objects_map = {'virtualservice': 'VirtualService',
                       'httppolicyset': 'HTTPPolicySet',
                       'networkprofile': 'NetworkProfile',
                       'pool': 'Pool',
                       'poolgroup': 'PoolGroup',
                       'sslkeyandcertificate': 'SSLKeyAndCertificate',
                       'pkiprofile': 'PKIProfile',
                       'persistenceprofile': 'ApplicationPersistenceProfile',
                       'sslprofile': 'SSLProfile',
                       'applicationprofile': 'ApplicationProfile',
                       'vrfcontext': 'VrfContext',
                       'vsvip': 'VsVip', }

admin_obj_not_visible_to_all = ('sslkeyandcertificate',)

clone_objects = ['VirtualService', 'HealthMonitor', 'Pool']

class CloneObjects():
    """ Share methods for cross tenant cloning of AVI Objects"""

    def __init__(self, avi_configs):
        self.old_avi_config = avi_configs

    def get_obj_tenant_name(self, url):
        """Parse a url given as a string argument.

        Arguments:

        url: Object's tenant reference url

        Returns a name of tenant.
        """
        parsed = urlparse.urlparse(url)
        obj_tenant_name = urlparse.parse_qs(parsed.query)['tenant'][0]
        return obj_tenant_name

    def get_obj_name(self, url):
        """Parse a url given as a string argument.

        Arguments:

        url: Object's reference url.

        Returns a name of an object.
            """
        parsed = urlparse.urlparse(url)
        obj_name = urlparse.parse_qs(parsed.query)['name'][0]
        return obj_name

    def get_obj_type(self, url):
        """Parse a url given as a string argument.

        Arguments:

        url: Object's reference url.

        Returns a name of an object.
        """
        parsed = urlparse.urlparse(url)
        obj_type = filter(None, parsed.path.split('/'))[1]
        return obj_type

    def clone_objects(self, object, obj_type, cross_tenant):
        """ Function to clone avi_config object into cross tenant.

        :param object: Avi object configuration which has cross tenant reference.
        :param obj_type: Type of an AVI Object.
        :param cross_tenant: Name of the (cross tenant) tenant which is referred in current object.
        :return: a cloned object configuration and it's reference url.
        """

        cloned_obj = copy.deepcopy(object)
        cloned_obj['name'] += '-clone'
        cloned_obj['tenant_ref'] = conv_utils.get_object_ref(cross_tenant, 'tenant')
        cloned_obj_ref = conv_utils.get_object_ref(cloned_obj['name'], obj_type, tenant=cross_tenant)
        return cloned_obj, cloned_obj_ref

    # def clone_list_obj(self, p_tenant, dictionary, key, val):
    #     objtenant = self.get_obj_tenant_name(val)
    #     objname = self.get_obj_name(val)
    #     objtype = self.get_obj_type(val)
    #     return

    def rewrite_obj_ref(self, dictionary, clone_obj_ref, key=''):
        if key == '':
            dictionary = clone_obj_ref
        else:
            dictionary[key] = clone_obj_ref
        return

    def rewrite_obj(self, objtype, clone_objs):
        # print "********* obj_type: %s" %(objtype)
        return data[api_avi_objects_map[objtype]].append(clone_objs)

    def clone_obj(self, p_tenant, dictionary, dkey='', val='',):
        # add function to check cross tenant refs
        # print "\nk: %s\t_ref: %s" %(k,v)
        clone_objs = {}
        clone_obj_ref = ''
        objtenant = self.get_obj_tenant_name(val)
        objname = self.get_obj_name(val)
        objtype = self.get_obj_type(val)
        # if objtype == 'applicationprofile':
            # print "\napp"
        # tenant, name, type = self.get_obj_params(v)
        if (p_tenant != objtenant and objtenant != 'admin') or objtype in admin_obj_not_visible_to_all:
            # print "\nparent_tenant: %s tenant: %s\nname: %s\ntype: %s\ndict: %s\n" % (
            # p_tenant, objtenant, objname, objtype, dictionary)
            for child_obj in data[api_avi_objects_map[objtype]]:
                if child_obj['name'] == objname:
                    clone_objs, clone_obj_ref = self.clone_objects(child_obj, objtype, p_tenant)
                    # print 'name:%s \nobj_ref: %s' % (objname, clone_obj_ref)
                    # if isinstance(dictionary, (list)):
                    #     print "################ dic[%s]: %s" %(dkey, dictionary[dkey])
                    #     dictionary[dkey].append(clone_obj_ref)
                    # else:
                    #     dictionary[dkey] = clone_obj_ref
                    # data[api_avi_objects_map[objtype]].append(clone_objs)
                    # print "\nclone_objs: %s\nref: %s" %(str(clone_objs), clone_obj_ref)
                    # print "\nnew dictionary: %s" % (dictionary)
        return clone_objs, clone_obj_ref, objtype

    def find_refs_and_clone(self, key, dictionary, parent_tenant_ref):
        """ Function to find cross tenant referred objects, clone those objects and
        update particular object in AVI configuration.

        :param key: '_ref' to find all keys containing '_ref' as substring.
        :param dictionary: single AVI object e.g. single virtualservice
        :param parent_tenant_ref: parent tenant_ref of object in which cross
        referred object needs to be cloned
        :return:
        """
        # parent_tenant_ref = dictionary.get('tenant_ref', '')
        parent_tenant = self.get_obj_name(parent_tenant_ref)
        # print "parent tenant: %s" %(parent_tenant)
        # print "\nold_dict: %s" %(dictionary)
        if isinstance(dictionary, dict):
            for k, v in dictionary.iteritems():
                # print "k: %s\t v: %s" % (k, v)
                # print "v type: %s" %(type(v))
                # try:
                if isinstance(v, dict):
                    self.find_refs_and_clone(key, v, parent_tenant_ref)
                elif isinstance(v, list) and len(v) > 0 and isinstance(v[0], dict):
                    # print "##########################"
                    for d in v:
                        # print "d: %s" %d
                        self.find_refs_and_clone(key, d, parent_tenant_ref)
                elif isinstance(v, list) and len(v) > 0 and not isinstance(v[0], dict):
                    ref_list = []
                    for d in v:
                        # print "***************** k: %s v:%s, d: %s dictionary: %s" % (k, v, d, dictionary)
                        c_obj, c_ref, o_type = self.clone_obj(parent_tenant, dictionary, k, d)
                        ref_list.append(c_ref)
                        self.rewrite_obj(o_type, c_obj)
                    self.rewrite_obj_ref(dictionary, ref_list, k)
                else:
                    if key in k:
                        if v != parent_tenant_ref and not 'api/cloud' in v:
                            c_obj, c_ref, o_type = self.clone_obj(parent_tenant, dictionary, k, v)
                            if c_obj != {} and c_ref != '':
                                self.rewrite_obj_ref(dictionary, c_ref, k)
                                self.rewrite_obj(o_type, c_obj)
        else:
            # pass
            # print "######################################################"
            self.clone_obj(parent_tenant, dictionary, val=dictionary)
            c_obj, c_ref, o_type = self.clone_obj(parent_tenant, dictionary, val=dictionary)
            self.rewrite_obj_ref(dictionary, c_ref, c_obj, o_type)
            self.rewrite_obj(o_type, c_obj)
            # except:
            #     # LOG.warning("Error during cloning for %s, %s, %s" %(k, v, dictionary))
            #     print "Error for %s, %s, %s" %(k, v, dictionary)
        return

    def find_and_clone_all(self):
        """ Function to iterate over AVI configuration and clone cross tenant objects.

        :return: New AVI config object with cloned cross tenant references.
        """
        # print "data[%s]: %s" %(object_type, data[object_type])
        # obj = data[object_type][3]
        for object_type in clone_objects:
            for index, obj in enumerate(data[object_type]):
                # print '\nobj: %s' % obj
                self.find_refs_and_clone('_ref', obj, obj['tenant_ref'])
                # data[index] = obj
            if isinstance(obj, dict):
                data.update(obj)
        return


if __name__ == '__main__':
    # with open('/home/shrikantc/input/visa.bigip-Output.json') as f:
    with open('/home/shrikantc/Downloads/bigip-Output.json') as f:
        data = json.load(f)
    test_clone_obj = CloneObjects(data)
    # f = open('/tmp/test.log', 'a')
    # f.write("\nold_data: %s" % str(data))
    # f.close()
    # print "\n\nold: %s" % data['VirtualService']
    # test_clone_obj.find_refs_and_clone('_ref', data['VirtualService'][0], data['VirtualService'][0]['tenant_ref'])
    test_clone_obj.find_and_clone_all()
    # f = open('/tmp/test.log', 'a')
    # f.write("\n\nnew_data: %s" % str(data))
    # print "\n\nnew: %s" % data['VirtualService']
    # f = open('/tmp/test.log', 'a')
    # f.write(str(data['VirtualService'][0]))
    # f.close()
    # print "\n\nnew: %s" % new_avi_config