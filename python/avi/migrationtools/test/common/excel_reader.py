import json
import openpyxl
import pandas


def output_sanitization(path_to_excel, path_to_out_json=None, path_to_log=None):
    ''' Find the Success percentage of each output report '''
    path = path_to_excel

    out_obj = []
    excel_obj = []

    # Output Sanitization
    s = pandas.read_excel(path, engine='openpyxl', sheet_name='Status Sheet')
    cols = 0
    cols_id = None
    cols_status = None
    for row in range(s.index.size):
        if 'F5 ID' in s and s['Status'][row] in ['SUCCESSFUL', 'PARTIAL']:
            if s['F5 ID'][row] in ['hash', 'oneconnect'] or\
               s['F5 type'][row] == 'route' or\
               s['F5 SubType'][row] in ['oneconnect', 'one-connect'] or\
               "Indirectly mapped" in s['Avi Object'][row]:
                value = None
            else:
                value = s.cell(row, cols_id).value
            if s['F5 type'][row] in ['pool' 'policy'] :
                value = s['F5 ID'][row].split('/')[-1]
            if value:
                excel_obj.append(value)

    with open(path_to_out_json, 'r') as file_strem:
        file_strem = json.load(file_strem)
        for entity in file_strem:
            if entity != 'META' and entity != 'VsVip' and entity != \
                    "OneConnect" and entity != "hash_algorithm":
                for obj in file_strem[entity]:
                    out_obj.append(obj.get('name'))
    excel_obj.sort()
    out_obj.sort()
    log_obj = {}
    if path_to_log:
        with open(path_to_log, 'r') as file_strem:
            a = file_strem.readlines()
            try:
                b = str(a).split('$$$$$$')[-2].replace('\'', '"')
                print(b)
                log_obj = eval(b)
            except:
                pass

    obj_list = list()

    # comparing excel objects with json out objects
    obj_list = list(set(excel_obj) - set(out_obj))

    # If object read from log is dict compare
    if isinstance(log_obj, dict):
        for key in log_obj.keys():
            obj_list = list(set(obj_list) - set(log_obj[key].keys()))

    print("Object Difference between Excel sheet and output is %s" % len(obj_list))
    if obj_list:
        print("Object not Common in Both Excel and Output %s", obj_list)
        return False
    print("Excel sheet matches with Output.json")
    return True


def percentage_success(path_to_excel):
    # Percentage Success from Excel Reports
    # find the status column
    path = path_to_excel
    s = pandas.read_excel(path, engine='openpyxl', sheet_name='Status Sheet')
    if "F5 type" in s:
        type_str = "F5 type"
    else:
        type_str = "Netscaler Command"
    report_dict = dict()
    for row in range(s.index.size):
        # taking col_type_val column for type and col_status_val for status
        val = s[type_str][row]
        state = s['Status'][row]
        fail = 1
        suc = 0
        if state == "PARTIAL" or state == "SUCCESSFUL":
            fail = 0
            suc = 1
        if val not in report_dict:
            report_dict.update({val: {'success': suc, 'fail': fail}})
        else:
            report_dict[val]['success'] += suc
            report_dict[val]['fail'] += fail
        # break
    for key in report_dict.keys():
        if report_dict[key]['success'] + report_dict[key]['fail'] != 0:
            percent = float(report_dict[key]['success'] * 100 /
                            (report_dict[key]['success'] + report_dict[key]['fail']))
            report_dict[key].update({'percent': percent})
        else:
            report_dict[key].update({'percent': 100.0})
    for key in report_dict.keys():
        print(key, " -> ", report_dict[key]['percent'], "%")


def output_vs_level_status(path_to_excel):
    path = path_to_excel
    s = pandas.read_excel(path, engine='openpyxl', sheet_name='Status Sheet')
    if "Overall skipped settings" in s and "VS Reference" in s:
        return True
    else:
        return False


def check_placeholder_cert_status(path_to_excel, certObj):
    # Percentage Success from Excel Reports
    # find the status column
    path = path_to_excel
    s = pandas.read_excel(path, engine='openpyxl', sheet_name='Status Sheet')
    report_dict = dict()
    if 'F5 type' in s:
        for row in range(s.columns.array.size):
            # if row == 0:
            #     continue
            # taking col_type_val column for type and col_status_val for status
            type = s['F5 type'][row]
            state = s['Status'][row]
            obj = s['Object Name'][row],
            if state == "DUMMY" and obj == certObj and \
                    type == 'add ssl certKey':
                return True
        return False
    else:
        return True
