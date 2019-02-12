import copy
import logging
import os
import random
import string
import urlparse
from datetime import datetime
from socket import gethostname

import avi.migrationtools.f5_converter.converter_constants as conv_const
import networkx as nx
import pexpect
import yaml
from OpenSSL import crypto
from avi.migrationtools.vs_filter import path_key_map, get_name_and_entity

LOG = logging.getLogger(__name__)
csv_writer_dict_list = []
tenants = []
ran_str = ''.join(random.choice(string.ascii_uppercase + string.ascii_lowercase
                                + string.digits) for _ in range(3))
warning_count = 0
error_count = 0

def set_update_count():
    global warning_count, error_count
    warning_count = 0
    error_count = 0


def update_count(type='warning'):
    global warning_count, error_count
    if type == 'warning':
        warning_count += 1
    elif type == 'error':
        error_count += 1

def get_count(type='None'):
    if type == 'warning':
        return warning_count
    elif type == 'error':
        return error_count
    return { 'warning': warning_count, 'error': error_count }

class MigrationUtil(object):


    def create_self_signed_cert(self):
        # create a key pair
        key = crypto.PKey()
        key.generate_key(crypto.TYPE_RSA, 2048)

        # create a self-signed cert
        cert = crypto.X509()
        cert.get_subject().C = "US"
        cert.get_subject().O = "Avi Networks"
        cert.get_subject().CN = gethostname()
        cert.set_serial_number(1000)
        cert.gmtime_adj_notBefore(0)
        cert.gmtime_adj_notAfter(10 * 365 * 24 * 60 * 60)
        cert.set_issuer(cert.get_subject())
        cert.set_pubkey(key)
        cert.sign(key, 'sha256')
        cert = crypto.dump_certificate(crypto.FILETYPE_PEM, cert)
        key = crypto.dump_privatekey(crypto.FILETYPE_PEM, key)
        return key, cert

    def is_certificate_key_protected(self, key_file):
        """
        This functions defines that whether key is passphrase protected or not
        :param key_file: Path of key file
        :return: Return True if key is passphrase protected else return False
        """
        try:
            child = pexpect.spawn(
                'openssl rsa -in %s -check -noout' % key_file)
            # Expect for enter pass phrase if key is protected else it will raise
            # an exception
            child.expect('Enter pass phrase for')
            update_count('warning')
            return True
        except Exception as e:
            return False

    def update_vs_complexity_level(self, vs_csv_row, virtual_service):
        """
        This function defines that update complexity level of VS objects.
        if it has reference of VS Datascript or Http policies -> Advanced
        else
        level -> Basic
        :param vs_csv_row: csv row of VS
        :param virtual_service: dict of Virtual service
        :return: None
        """

        if ('http_policies' in virtual_service and
                virtual_service['http_policies']) or \
                ('vs_datascripts' in virtual_service and
                     virtual_service['vs_datascripts']):
            vs_csv_row['Complexity Level'] = conv_const.COMPLEXITY_ADVANCED
        else:
            vs_csv_row['Complexity Level'] = conv_const.COMPLEXITY_BASIC

    def remove_dup_key(self, obj_list):
        for obj in obj_list:
            obj.pop('dup_of', None)

    def check_for_duplicates(self, src_obj, obj_list, obj_type,
                             merge_object_mapping, ent_type, prefix, syslist):
        """
        Checks for duplicate objects except name and description values
        :param src_obj: Object to be checked for duplicate
        :param obj_list: List of oll objects to search in
        :return: Name of object for which given object is duplicate of
        """
        if not syslist:
            syslist = []
        src_cp = copy.deepcopy(src_obj)
        src_cp.pop("name")
        src_cp.pop("description", [])
        for obj in syslist:
            ob_cp = copy.deepcopy(obj)
            ob_cp.pop("name")
            ob_cp.pop("description", [])
            ob_cp.pop('url', [])
            ob_cp.pop('uuid', [])
            if cmp(src_cp, ob_cp) == 0:
                return obj["name"], src_obj['name']
        for tmp_obj in obj_list:
            tmp_cp = copy.deepcopy(tmp_obj)
            tmp_cp.pop("name")
            tmp_cp.pop("description", [])
            dup_lst = tmp_cp.pop("dup_of", [tmp_obj["name"]])
            if cmp(src_cp, tmp_cp) == 0:
                dup_lst.append(src_obj["name"])
                tmp_obj["dup_of"] = dup_lst
                old_name = tmp_obj['name']
                if tmp_obj["name"] in merge_object_mapping[obj_type].keys():
                    merge_object_mapping[obj_type]['no'] += 1
                    no = merge_object_mapping[obj_type]['no']
                    mid_name = ent_type and ('Merged-%s-%s-%s-%s' % (ent_type,
                               obj_type, ran_str, str(no))) or (
                               'Merged-%s-%s-%s' % (obj_type, ran_str, str(no)))
                    new_name = '%s-%s' %(prefix, mid_name) if prefix else \
                                mid_name
                    tmp_obj["name"] = new_name
                return tmp_obj["name"], old_name
        return None, None

    def upload_file(self, file_path):
        """
        Reads the given file and returns the UTF-8 string
        :param file_path: Path of file to read
        :return: UTF-8 string read from file
        """

        file_str = None
        # remove double quotes if available
        file_path = file_path.replace('"', '')

        if '/Common/' in file_path:
            file_path = file_path.replace('/Common/', '')
        if ':Common:' in file_path:
            file_path = file_path.replace(':Common:', '')
        try:
            with open(file_path, "r") as file_obj:
                file_str = file_obj.read()
                file_str = file_str.decode("utf-8")
        except UnicodeDecodeError:
            try:
                file_str = file_str.decode('latin-1')
            except:
                update_count('error')
                LOG.error("[UnicodeDecode] Error to read file %s" % file_path,
                          exc_info=True)
        except IOError:
            update_count('warning')
            LOG.warn("Cannot read file %s" % file_path)
        except:
            update_count('error')
            LOG.error("Error accessing file %s" % file_path, exc_info=True)
        return file_str

    def get_name(self, url):
        """
        This function defines that return name object from url
        :param url:
        :return: Name of object
        """
        parsed = urlparse.urlparse(url)
        return urlparse.parse_qs(parsed.query)['name'][0]

    def get_tenant_from_ref(self, url):
        """
        This function defines that return tenant from url
        :param url:
        :return: Name of tenant
        """
        parsed = urlparse.urlparse(url)
        return urlparse.parse_qs(parsed.query).get('tenant', ['admin'])[0]

    def get_obj_type_from_ref(self, url):
        return url.split('/api/')[1].split('/')[0].split('?')[0]

    def get_object_ref(self, object_name, object_type, tenant='admin',
                       cloud_name='Default-Cloud', prefix=None):
        """
        This function defines that to genarte object ref in the format of
        /api/object_type/?tenant=tenant_name&name=object_name&cloud=cloud_name
        :param object_name: Name of object
        :param object_type: Type of object
        :param tenant: Name of tenant
        :param cloud_name: Name of cloud
        :param prefix : Prefix for objects
        :return: Return generated object ref
        """
        # Added prefix for objects
        if prefix:
            object_name = prefix + '-' + object_name

        cloud_supported_types = ['pool', 'poolgroup', 'vsvip', 'vrfcontext',
                                 'serviceenginegroup']
        if not cloud_name:
            cloud_name = "Default-Cloud"

        if object_type == 'tenant':
            ref = '/api/tenant/?name=%s' % object_name
            if object_name not in tenants:
                tenants.append(object_name)
        elif object_type == 'cloud':
            ref = '/api/%s/?tenant=admin&name=%s' % (object_type, object_name)
        elif object_type == 'vrfcontext':
            ref = '/api/%s/?tenant=admin&name=%s&cloud=%s' % (
                object_type, object_name, cloud_name)
        elif object_type in cloud_supported_types:
            ref = '/api/%s/?tenant=%s&name=%s&cloud=%s' % (
                object_type, tenant, object_name, cloud_name)
        else:
            ref = '/api/%s/?tenant=%s&name=%s' % (
            object_type, tenant, object_name)
        # if cloud_name:
        #     ref += '&cloud=%s' % cloud_name
        return ref

    # Print iterations progress
    def print_progress_bar(self, iteration, total, msg, prefix='', suffix='',
                           decimals=1, length=50, fill='#'):
        """
        Call in a loop to create terminal progress bar
        @params:
            iteration   - Required  : current iteration (Int)
            total       - Required  : total iterations (Int)
            prefix      - Optional  : prefix string (Str)
            suffix      - Optional  : suffix string (Str)
            decimals    - Optional  : positive number of decimals in percent
            complete (Int)
            length      - Optional  : character length of bar (Int)
            fill        - Optional  : bar fill character (Str)
        """
        percent = ("{0:." + str(decimals) + "f}"). \
            format(100 * (iteration / float(total)))
        filledLength = int(length * iteration // total)
        bar = fill * filledLength + '-' * (length - filledLength)
        if (iteration < total):
            print '\r%s |%s| %s%% %s' % (prefix, bar, percent, suffix),
        else:
            print '\r%s |%s| %s%% %s' % (prefix, bar, percent, suffix)

    def validate_value(self, entity_names, prop_name, value, limit_data, obj,
                       valname):

        """
        :param entity_names: list of name of the avi entity/object
        :param prop_name: property name
        :param value: property value
        :param limit_data: data from generated yaml
        :param obj: obj name
        :return: validity and new value
        """
        valid = None
        new_value = value
        msgvar = valname and entity_names and '%s-->%s-->%s' % (valname,
                 '-->'.join(entity_names), prop_name) or valname and '%s-->%s' \
                 % (valname, prop_name) or entity_names and '%s-->%s' % (
                 '-->'.join(entity_names), prop_name) or '%s' % prop_name
        for key, val in limit_data.iteritems():
            pr = val.get(obj, {})
            if not pr:
                continue
            LOG.debug("Validating property '%s'", msgvar)
            p_key = self.get_to_prop(val, pr, entity_names, prop_name,
                                     limit_data)
            typ = p_key.get('py_type') if p_key else None
            if typ:
                break
        else:
            LOG.debug("Property '%s' is not present in generated yaml, reason "
                   "being the property doesn't have any attribute from the "
                   "list %s", msgvar, str(['default_value', 'range',
                   'special_values', 'ref_type']))
            return None, None
        if new_value is not None:
            if type(new_value) == unicode:
                new_value = new_value.encode()
            if type(new_value) == eval(typ) or (eval(typ) == int and
                                                str(new_value).isdigit()):
                special_value = p_key.get('special_values')
                if typ == 'int':
                    new_value = int(new_value)
                    if special_value and str(new_value) in special_value:
                        valid = True
                        LOG.debug("Special value %s is fine", str(new_value))
                    else:
                        lval = p_key.get('range')
                        if lval:
                            low, high = lval.split('-')
                            if new_value < int(low):
                                valid = False
                                new_value = int(low)
                            elif new_value > int(high):
                                valid = False
                                new_value = int(high)
                            else:
                                valid = True
                                LOG.debug("Value '%s' is fine", str(new_value))
                if typ == 'str':
                    if special_value and new_value in special_value:
                        valid = True
                        LOG.debug("Special value %s is fine", str(new_value))
                    else:
                        options = p_key.get('option_values')
                        if options and new_value not in options:
                            valid = False
                            new_value = p_key.get('default_value')
                        else:
                            valid = True
                            LOG.debug("Value '%s' is fine", str(new_value))
                if typ == 'bool':
                    if new_value not in (False, True, 'False', 'True'):
                        valid = False
                        new_value = p_key.get('default_value')
                        new_value = False if new_value == 'False' else True
                    else:
                        valid = True
                        LOG.debug("Value '%s' is fine", str(new_value))
            else:
                LOG.debug("Type of value '%s' doesn't match with type '%s' "
                       "defined", str(type(new_value)), typ)
                valid, new_value = None, None
        else:
            if p_key.get('required') == 'True':
                valid = False
                new_value = p_key.get('default_value')
                if typ == 'bool':
                    new_value = False if new_value == 'False' else True
                LOG.debug("Value is required hence, defaulting to value '%s'",
                          str(new_value))
            else:
                valid = True
                LOG.debug("Property '%s' not mandatory", msgvar)

        return valid, new_value

    def get_to_prop(self, val, pr, entity_names, prop_name, limit_data):

        for name in entity_names:
            if pr.get('properties', {}).get(name, {}):
                if pr['properties'][name].get('ref_type'):
                    ref = pr['properties'][name].get('ref_type')
                    vr = val.get(ref, {})
                    if not vr:
                        for k, v in limit_data.iteritems():
                            if v.get(ref):
                                tr = v[ref]
                                return self.get_to_prop(v, tr, entity_names,
                                                prop_name, limit_data)
                        else:
                            return
                    else:
                        return self.get_to_prop(val, vr, entity_names,
                                                prop_name, limit_data)
        p_key = pr.get('properties', {}).get(prop_name, {})
        if p_key:
            return p_key

    def validation(self, avi_config):

        """
        Validator function for all avi objects
        :param avi_config:
        :return:
        """

        LOG.debug("Starting Validation checks ... ")
        limit_data = None
        dir_path = os.path.abspath(os.path.dirname(__file__))
        if os.path.exists(dir_path + os.path.sep + 'pb_attributes.yaml'):
            with open(dir_path + os.path.sep + 'pb_attributes.yaml') as data:
                limit_data = yaml.safe_load(data)
        if limit_data:
            for obj, vals in avi_config.iteritems():
                if obj != 'META' and vals:
                    for val in vals:
                        heir = []
                        LOG.debug("Validating %s of Object %s", val['name'],
                                  obj)
                        self.validate_prop(val, heir, limit_data, obj,
                                           val['name'])

    def validate_prop(self, dictval, heir, limit_data, obj, valname=None):

        for k, v in dictval.iteritems():
            if k in ['tenant_ref', 'name', 'cloud_ref', 'health_monitor_refs',
                     'ssl_profile_ref', 'application_persistence_profile_ref',
                     'application_profile_ref', 'network_profile_ref',
                     'pki_profile_ref', 'pool_ref', 'pool_group_ref',
                     'http_policy_set_ref', 'ssl_key_and_certificate_refs',
                     'vsvip_ref', 'description']:
                msvar = valname and heir and '%s-->%s-->%s' % (valname,
                        '-->'.join(heir), k) or valname and '%s-->%s' % (
                        valname, k) or heir and '%s-->%s' % ('-->'.join(heir),
                        k) or '%s' % k
                LOG.debug("Skipping validation checks for '%s'", msvar)
                continue
            else:
                if isinstance(v, list):
                    for listval in v:
                        if isinstance(listval, dict):
                            k not in heir and heir.append(k) or None
                            self.validate_prop(listval, heir, limit_data, obj,
                                               valname)
                            heir and heir.pop() or None
                        else:
                            mgvar = valname and heir and '%s-->%s-->%s' % (
                                    valname, '-->'.join(heir), k) or valname \
                                    and '%s-->%s' % (valname, k) or heir and \
                                    '%s-->%s' % ('-->'.join(heir), k) or \
                                    '%s' % k
                            LOG.debug("Property '%s' has value as a list %s, "
                                  "not supported currently", mgvar, str(v))
                            #valid, val = self.validate_value(heir, k, listval,
                                                    #limit_data)
                            #if valid is False:
                                #LOG.debug("Correcting the value for %s" % k)
                                #dictval[k] = val
                elif isinstance(v, dict):
                    k not in heir and heir.append(k) or None
                    self.validate_prop(v, heir, limit_data, obj, valname)
                    heir and heir.pop() or None
                else:
                    valid, val = self.validate_value(heir, k, v, limit_data,
                                                     obj, valname)
                    if valid is False:
                        mvar = valname and heir and '%s-->%s-->%s' % (valname,
                               '-->'.join(heir), k) or valname and '%s-->%s' % (
                               valname, k) or heir and '%s-->%s' % (
                               '-->'.join(heir), k) or '%s' % k
                        LOG.debug("Correcting the value for '%s' from '%s' to "
                                  "'%s'", mvar, str(v), str(val))
                        dictval[k] = val

    def check_certificate_expiry(self, input_dir, cert_file_name):
        cert_file_name = cert_file_name.replace(':Common:', '')
        cert_text = self.upload_file(input_dir + os.path.sep + cert_file_name)
        if cert_text:
            cert_date = crypto.load_certificate(crypto.FILETYPE_PEM, cert_text)
            expiry_date = datetime.strptime(cert_date.get_notAfter(),
                                            "%Y%m%d%H%M%SZ")
            present_date = datetime.now()
            if expiry_date < present_date:
                LOG.warning("Certificate %s is expired creating self "
                            "signed cert." % cert_file_name)
                return False
            else:
                return True
        else:
            LOG.warn('Cannot load cert %s to check expiry skipping the check' %
                     cert_file_name)
            update_count('warning')
            return True

    def make_graph(self, avi_config):
        """
        Filters vs and its references from full configuration
        :param avi_config: full configuration
        :return: graph
        """
        avi_graph = nx.DiGraph()
        avi_graph.add_node('AVI', type='Tree')
        for vs in avi_config['VirtualService']:
            name = vs['name']
            avi_graph.add_node(name, type='VS')
            avi_graph.add_edge('AVI', name)
            self.find_and_add_ne(vs, avi_config, avi_graph, name, depth=0)
        return avi_graph

    def find_and_add_ne(self, obj_dict, avi_config, avi_graph, vsname, depth):
        """
        Method to iterate in one object find references and add those to output
        :param obj_dict: Object to be iterated over
        :param avi_config: Full config
        :param avi_graph: avi graph
        :param vsname: name of object
        :param depth: Recursion depth to determine level in the vs reference
                      tree
        """
        for key in obj_dict:
            if (key.endswith('ref') and key not in ['cloud_ref', 'tenant_ref'])\
                    or key == 'ssl_profile_name':
                if not obj_dict[key]:
                    continue
                entity, name = get_name_and_entity(obj_dict[key])
                self.search_ne(entity, name, avi_graph, avi_config, depth,
                               vsname)
            elif key.endswith('refs'):
                for ref in obj_dict[key]:
                    entity, name = get_name_and_entity(ref)
                    self.search_ne(entity, name, avi_graph, avi_config, depth,
                                   vsname)
            elif isinstance(obj_dict[key], dict):
                self.find_and_add_ne(obj_dict[key], avi_config, avi_graph,
                                     vsname, depth)
            elif obj_dict[key] and isinstance(obj_dict[key], list) \
                    and isinstance(obj_dict[key][0], dict):
                for member in obj_dict[key]:
                    self.find_and_add_ne(member, avi_config, avi_graph, vsname,
                                         depth)
            elif key == 'hostname':
                sername = obj_dict[key]
                if avi_graph.has_node(sername):
                    node_type = [n[1]['type'] for n in list(
                                 avi_graph.nodes().data()) if n[0] == sername]
                    node_type = '{}-{}'.format(node_type[0], 'Server')
                    avi_graph.add_node(sername, type=node_type)
                    avi_graph.add_edge(vsname, sername)
                else:
                    avi_graph.add_node(sername, type='Server')
                    avi_graph.add_edge(vsname, sername)
            elif key == 'name' and depth == 1 and '-rule-' in obj_dict[key]:
                rule_name = obj_dict[key]
                if avi_graph.has_node(rule_name):
                    node_type = [n[1]['type'] for n in list(
                                 avi_graph.nodes().data()) if n[0] == rule_name]
                    node_type = '{}-{}'.format(node_type[0], 'Rule')
                    avi_graph.add_node(rule_name, type=node_type)
                    avi_graph.add_edge(vsname, rule_name)
                else:
                    avi_graph.add_node(rule_name, type='Rule')
                    avi_graph.add_edge(vsname, rule_name)
        return

    def search_ne(self, entity, name, avi_graph, avi_config, depth, vsname):
        """
        Method to search referenced object
        :param entity: object type
        :param name: object name
        :param avi_graph: avi graph
        :param avi_config: full config
        :param depth: Recursion depth to determine level in the vs reference
                      tree
        :param vsname: name of VS
        """

        avi_conf_key = path_key_map[entity]
        found_obj_list = avi_config.get(avi_conf_key)
        found_obj = [obj for obj in found_obj_list if obj['name'] == name] if \
            found_obj_list else []
        if found_obj:
            found_obj = found_obj[0]
            if avi_graph.has_node(name):
                nod_type = [node[1]['type'] for node in list(
                            avi_graph.nodes().data()) if node[0] == name]
                nod_type = '{}-{}'.format(nod_type[0], path_key_map[entity])
                avi_graph.add_node(name, type=nod_type)
                avi_graph.add_edge(vsname, name)
            else:
                avi_graph.add_node(name, type=path_key_map[entity])
                avi_graph.add_edge(vsname, name)
        elif entity in ['applicationprofile', 'networkprofile', 'healthmonitor',
                        'sslkeyandcertificate', 'sslprofile',
                        'applicationpersistenceprofile']:
            if str.startswith(str(name), 'System-'):
                return
        else:
            print 'ERROR: Reference not found for %s with name %s' % (
                entity, name)
            exit()
        depth += 1
        new_name = found_obj.get('name')
        if new_name:
            self.find_and_add_ne(found_obj, avi_config, avi_graph, new_name,
                                 depth)
