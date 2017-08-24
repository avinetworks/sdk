import logging
import copy
import ast
import urlparse
import os
import pandas
import json
import re
import random
import csv
import pexpect
import yaml
import avi.migrationtools.f5_converter.converter_constants as conv_const
import avi.migrationtools.netscaler_converter.ns_constants as ns_constants
from pkg_resources import parse_version
from socket import gethostname
from OpenSSL import crypto
from xlsxwriter import Workbook
from openpyxl import load_workbook
from avi.migrationtools.netscaler_converter.ns_constants \
    import (STATUS_SKIPPED, STATUS_SUCCESSFUL, STATUS_INDIRECT,
            STATUS_NOT_APPLICABLE, STATUS_PARTIAL, STATUS_DATASCRIPT,
            STATUS_INCOMPLETE_CONFIGURATION, STATUS_COMMAND_NOT_SUPPORTED,
            OBJECT_TYPE_POOL_GROUP, OBJECT_TYPE_POOL, STATUS_NOT_IN_USE,
            OBJECT_TYPE_HTTP_POLICY_SET, STATUS_LIST, COMPLEXITY_ADVANCED,
            COMPLEXITY_BASIC, OBJECT_TYPE_APPLICATION_PERSISTENCE_PROFILE,
            OBJECT_TYPE_APPLICATION_PROFILE)
LOG = logging.getLogger(__name__)
csv_writer_dict_list = []
tenants = []


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
            return True
        except Exception as e:
            print e
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

    def check_for_duplicates(self, src_obj, obj_list, obj_type, merge_object_mapping,
                             ent_type, prefix, syslist):
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
                    mid_name = ent_type and (
                    'Merged-' + ent_type + '-' + obj_type
                    + '-' + str(no)) or ('Merged-' +
                                         obj_type + '-' + str(no))
                    new_name = prefix + '-' + mid_name if prefix else mid_name
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
        if '/Common/' in file_path:
            file_path = file_path.replace('/Common/', '')
        try:
            with open(file_path, "r") as file_obj:
                file_str = file_obj.read()
                file_str = file_str.decode("utf-8")
        except UnicodeDecodeError:
            try:
                file_str = file_str.decode('latin-1')
            except:
                LOG.error("Error to read file %s" % file_path, exc_info=True)
        except:
            LOG.error("Error to read file %s" % file_path, exc_info=True)
        return file_str

    def get_name(self, url):
        """
        This function defines that return name object from url
        :param url:
        :return: Name of object
        """
        parsed = urlparse.urlparse(url)
        return urlparse.parse_qs(parsed.query)['name'][0]

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

        cloud_supported_types = ['pool', 'poolgroup', 'vsvip', 'vrfcontext']
        if not cloud_name:
            cloud_name = "Default-Cloud"

        if object_type == 'tenant':
            ref = '/api/tenant/?name=%s' % object_name
            if object_name not in tenants:
                tenants.append(object_name)
        elif object_type == 'cloud':
            ref = '/api/%s/?tenant=admin&name=%s' % (object_type, object_name)
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

    def validate_value(self, entity_names, prop_name, value, limit_data, obj):

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
        for key, val in limit_data.iteritems():
            pr = val.get(obj, {})
            if not pr:
                continue
            LOG.debug("Validating property '%s'", ('-->'.join(entity_names) +
                            '-->' + prop_name if entity_names else prop_name))
            p_key = self.get_to_prop(val, pr, entity_names, prop_name,
                                     limit_data)
            typ = p_key.get('py_type') if p_key else None
            if typ:
                break
        else:
            LOG.debug("Property '%s' is not present in generated yaml, reason "
                   "being the property doesn't have any attribute from the "
                   "list %s", prop_name, str(['default_value', 'range',
                                                'special_values', 'ref_type']))
            return None, None
        if new_value is not None:
            if type(new_value) == unicode:
                new_value = new_value.encode()
            if type(new_value) == eval(typ) or (new_value.isdigit() and eval(
                    typ) == int):
                if typ == 'int':
                    new_value = int(new_value)
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
                LOG.debug("Property '%s' not mandatory", prop_name)

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
                        self.validate_prop(val, heir, limit_data, obj)

    def validate_prop(self, dictval, heir, limit_data, obj):

        for k, v in dictval.iteritems():
            if k in ['tenant_ref', 'name', 'cloud_ref', 'health_monitor_refs',
                     'ssl_profile_ref', 'application_persistence_profile_ref',
                     'application_profile_ref', 'network_profile_ref',
                     'pki_profile_ref', 'pool_ref', 'pool_group_ref',
                     'http_policy_set_ref', 'ssl_key_and_certificate_refs',
                     'vsvip_ref', 'description']:
                LOG.debug("Skipping validation checks for '%s'", k)
                continue
            else:
                if isinstance(v, list):
                    for listval in v:
                        if isinstance(listval, dict):
                            k not in heir and heir.append(k) or None
                            self.validate_prop(listval, heir, limit_data, obj)
                            heir and heir.pop() or None
                        else:
                            LOG.debug("Property '%s' has value as a list %s, "
                                  "not supported currently", k, str(v))
                            #valid, val = self.validate_value(heir, k, listval,
                                                    #limit_data)
                            #if valid is False:
                                #LOG.debug("Correcting the value for %s" % k)
                                #dictval[k] = val
                elif isinstance(v, dict):
                    k not in heir and heir.append(k) or None
                    self.validate_prop(v, heir, limit_data, obj)
                    heir and heir.pop() or None
                else:
                    valid, val = self.validate_value(heir, k, v, limit_data,
                                                     obj)
                    if valid is False:
                        LOG.debug("Correcting the value for '%s' from '%s' to "
                                  "'%s'", k, str(v), str(val))
                        dictval[k] = val

    


