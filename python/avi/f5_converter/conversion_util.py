import copy
import csv
import logging

import converter_constants as final

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
    except UnicodeDecodeError as ude:
        try:
            file_str = file_str.decode('latin-1')
        except:
            LOG.error("Error to read file %s" % file_path, exc_info=True)
    except:
        LOG.error("Error to read file %s" % file_path, exc_info=True)
    return file_str


def update_skipped_attributes(skipped, indirect_list, ignore_dict, object):
    indirect_mappings = [attr for attr in indirect_list if attr in skipped]
    skipped = [attr for attr in skipped if attr not in indirect_list]
    for key in ignore_dict.keys():
        if key in object and key in skipped and object[key] == ignore_dict[key]:
            skipped.remove(key)
    return skipped, indirect_mappings


def remove_dup_key(obj_list):
    for obj in obj_list:
        obj.pop('dup_of', None)


def check_for_duplicates(src_obj, obj_list):
    for tmp_obj in obj_list:
        src_cp = copy.deepcopy(src_obj)
        tmp_cp = copy.deepcopy(tmp_obj)
        del src_cp["name"]
        if "description" in src_cp:
            del src_cp["description"]
        del tmp_cp["name"]
        if "description" in tmp_cp:
          del tmp_cp["description"]
        dup_lst = tmp_cp.pop("dup_of", [])
        if cmp(src_cp, tmp_cp) == 0:
            dup_lst.append(src_obj["name"])
            tmp_obj["dup_of"] = dup_lst
            return tmp_obj["name"]
    return None


def get_avi_pool_down_action(action):
    """
    Maps Pool down action from F5 config to Avi Config
    :param action: F5 action string
    :return: Avi action String
    """
    action_close_con = {
        "type": "FAIL_ACTION_CLOSE_CONN"
    }
    if action == "reset":
        return action_close_con
    if action == "reselect":
        return action_close_con
    else:
        return action_close_con


def get_cc_algo_val(cc_algo):
    avi_algo_val = "CC_ALGO_NEW_RENO"
    if cc_algo == "high-speed":
        avi_algo_val = "CC_ALGO_HTCP"
    elif cc_algo == "cubic":
        avi_algo_val = "CC_ALGO_CUBIC"
    return avi_algo_val


def add_status_row(f5_type, f5_sub_type, f5_id, status, skipped_params=None,
                   avi_object=None, indirect_params=None):
    """
    Adds as status row in conversion status csv
    :param f5_type: Object type
    :param f5_sub_type: Object sub type
    :param f5_id: Name of object
    :param status: conversion status
    :param skipped_params: skipped params if partial conversion
    :param indirect_params: List of attributes have indirect mappings
    :param avi_object: converted avi object
    """
    global csv_writer
    row = {
        'F5 type': f5_type,
        'F5 SubType': f5_sub_type,
        'F5 ID': f5_id,
        'Status': status,
        'Indirect mapping': indirect_params,
        'Skipped settings': str(skipped_params),
        'Avi Object': str(avi_object)
    }
    csv_writer.writerow(row)


def get_port_by_protocol(protocol):
    """
    Instead of default ports for protocols F5 config has protocol in
    destination value for Avi object need to conver it to port number
    :param protocol: protocol name
    :return: integer value for protocol
    """
    port = final.DEFAULT_PORT
    if protocol == "https":
        port = final.HTTPS_PORT
    elif protocol == "ftp":
        port = final.FTP_PORT
    elif protocol == "smtp":
        port = final.SMTP_PORT
    elif protocol == "snmp":
        port = final.SNMP_PORT
    elif protocol == "telnet":
        port = final.TELNET_PORT
    elif protocol == "snmp-trap":
        port = final.SNMP_TRAP_PORT
    elif protocol == "ssh":
        port = final.SSH_PORT
    return port


def add_csv_headers(csv_file):
    global csv_writer
    fieldnames = ['F5 type', 'F5 SubType', 'F5 ID', 'Status',
                  'Skipped settings', 'Indirect mapping', 'Avi Object']
    csv_writer = csv.DictWriter(csv_file, fieldnames=fieldnames,
                                lineterminator='\n',)
    csv_writer.writeheader()


def update_skip_duplicates(obj, obj_list, obj_type, converted_objs):
    dup_of = check_for_duplicates(obj, obj_list)
    if dup_of:
        converted_objs.append({obj_type: "Duplicate of %s" % dup_of})
        LOG.info("Duplicate profiles: %s merged in %s" % (obj['name'], dup_of))
    else:
        obj_list.append(obj)
        converted_objs.append({obj_type: obj})


def get_containt_string_group(name, content_types):
    sg_obj = {"name": name+"-content_type", "type": "SG_TYPE_STRING"}
    kv = []
    for content_type in content_types:
        uri = {"key": content_type}
        kv.append(uri)
    sg_obj["kv"] = kv
    return sg_obj

