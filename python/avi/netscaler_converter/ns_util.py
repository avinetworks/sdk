import csv
import logging
import os
import copy

LOG = logging.getLogger(__name__)

csv_writer = None


def upload_file(file_path):
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


def add_conv_status(cmd, conv_status, avi_object=None):
    """
    Adds as status row in conversion status csv
    :param cmd: netscaler command
    :param conv_status: dict of conversion status
    :param avi_object: Converted objectconverted avi object
    """
    global csv_writer
    row = {
        'Netscaler Command': cmd,
        'Status': conv_status.get('status', ''),
        'Skipped settings': str(conv_status.get('skipped', '')),
        'Indirect mapping': str(conv_status.get('indirect', '')),
        'Not Applicable': str(conv_status.get('na_list', '')),
        'User Ignored': str(conv_status.get('user_ignore', '')),
        'Avi Object': str(avi_object)
    }
    csv_writer.writerow(row)


def add_status_row(cmd, status):
    """
    Adds as status row in conversion status csv
    :param cmd: netscaler command
    :param status: conversion status
    """
    global csv_writer
    row = {
        'Netscaler Command': cmd,
        'Status': status,
    }
    csv_writer.writerow(row)


def add_csv_headers(csv_file):
    """
    Adds header line in conversion status file
    :param csv_file: File to which header is to be added
    """
    global csv_writer
    fieldnames = ['Netscaler Command', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Not Applicable',
                  'User Ignored', 'Avi Object']
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames,
                                lineterminator='\n',)
    csv_writer.writeheader()


def get_avi_lb_algorithm(ns_algorithm):
    """
    Converts f5 LB algorithm to equivalent avi LB algorithm
    :param ns_algorithm: f5 algorithm name
    :return: Avi LB algorithm enum value
    """
    avi_algorithm = 'LB_ALGORITHM_ROUND_ROBIN'
    if not ns_algorithm or ns_algorithm == 'ROUNDROBIN':
        avi_algorithm = 'LB_ALGORITHM_ROUND_ROBIN'
    elif ns_algorithm in ['LEASTRESPONSETIME', 'LRTM']:
        avi_algorithm = 'LB_ALGORITHM_FASTEST_RESPONSE'
    elif ns_algorithm == 'SOURCEIPHASH':
        avi_algorithm = 'LB_ALGORITHM_CONSISTENT_HASH'
    elif ns_algorithm == 'URLHASH':
        avi_algorithm = 'LB_ALGORITHM_CONSISTENT_HASH_URI'
    return avi_algorithm


def get_avi_resp_code(respCode):
    avi_resp_codes = []
    codes = respCode.split(' ')
    for code in codes:
        if code < 200:
            avi_resp_codes.append({"code": "HTTP_1XX"})
        elif code < 300:
            avi_resp_codes.append({"code": "HTTP_2XX"})
        elif code < 400:
            avi_resp_codes.append({"code": "HTTP_3XX"})
        elif code < 500:
            avi_resp_codes.append({"code": "HTTP_4XX"})
        elif code < 600:
            avi_resp_codes.append({"code": "HTTP_5XX"})
    return list(set(avi_resp_codes))


def get_conv_status(ns_object, skipped_list, na_list, indirect_list,
                    ignore_for_val=None):
    skipped = [attr for attr in ns_object.keys() if attr in skipped_list]
    na = [attr for attr in ns_object.keys() if attr in na_list]
    indirect = [attr for attr in ns_object.keys() if attr in indirect_list]
    if skipped:
        status = 'partial'
    else:
        status = 'successful'
    if ignore_for_val:
        for key in ignore_for_val.keys():
            ns_val = ns_object.get(key)
            ignore_val = ignore_for_val.get(key)
            if key in skipped and ns_val == ignore_val:
                skipped.remove(key)


    conv_status = {
        'skipped': skipped,
        'indirect': indirect,
        'na_list': na,
        'status': status
    }
    return conv_status


def get_key_cert_obj(self, name, key_file_name, cert_file_name, input_dir):
        folder_path = input_dir+os.path.sep
        key = upload_file(folder_path + key_file_name)
        cert = upload_file(folder_path + cert_file_name)
        ssl_kc_obj = None
        if key and cert:
            cert = {"certificate": cert}
            ssl_kc_obj = {
                    'name': name,
                    'key': key,
                    'certificate': cert,
                    'key_passphrase': ''
                }
        return ssl_kc_obj


def get_command_from_line(line):
    cmd = ''
    for member in line:
        if isinstance(member, str):
            cmd += ' %s' % member
        else:
            cmd += ' -%s' % ' '.join(member)
    return cmd


def update_status_for_skipped(skipped_cmds):
    if not skipped_cmds:
        return
    for cmd in skipped_cmds:
        add_status_row(cmd, 'skipped')

def remove_duplicate_objects(obj_type, obj_list):
    """
    Remove duplicate objects from list
    :param obj_type: Object type
    :param obj_list: list of all objects
    :return: return list which has no duplicates objects
    """
    if len(obj_list) == 1:
        return obj_list
    for source_obj in obj_list:
        for index, tmp_obj in enumerate(obj_list):
            if tmp_obj["name"] == source_obj["name"]:
                continue
            src_cp = copy.deepcopy(source_obj)
            tmp_cp = copy.deepcopy(tmp_obj)
            del src_cp["name"]
            if "description" in src_cp:
                del src_cp["description"]

            del tmp_cp["name"]
            if "description" in tmp_cp:
                del tmp_cp["description"]
            if cmp(src_cp, tmp_cp) == 0:
                LOG.warn('Remove duplicate %s object : %s' % (obj_type, tmp_obj["name"]))
                del obj_list[index]
                remove_duplicate_objects(obj_type, obj_list)

    return obj_list

def cleanup_config(config):
    del config

def clone_pool(pool_name, prefix, avi_config):
    pools = [pool for pool in avi_config['Pool'] if pool['name'] == pool_name]
    if pools:
        pool_obj = copy.deepcopy(pools[0])
        pool_obj['name'] = prefix + pool_obj['name']
        avi_config['Pool'].append(pool_obj)
        LOG.info("Same pool reference to other object. Clone Pool %s for %s" % (pool_name, prefix))
        return pool_obj['name']
    return None

def get_vs_if_shared_vip(avi_config):
    vs_list = [v for v in avi_config['VirtualService'] if 'port_range_end' in v['services'][0]]
    for vs in vs_list:
        vs_port_list = [int(v['services'][0]['port']) for v in avi_config['VirtualService']
                        if v['ip_address']['addr'] == vs['ip_address']['addr'] and
                        'port_range_end' not in v['services'][0]]
        if vs_port_list:
            min_port = min(vs_port_list)
            max_port = max(vs_port_list)
            vs['services'][0]['port_range_end'] = str(min_port - 1)
            service = {
                'enable_ssl': False,
                'port': str(max_port + 1),
                'port_range_end': '65535'
            }
            vs['services'].append(service)
