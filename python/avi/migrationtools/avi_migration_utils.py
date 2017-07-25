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
        global tenants
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


