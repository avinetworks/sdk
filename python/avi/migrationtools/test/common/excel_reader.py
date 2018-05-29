from xlrd import open_workbook
import json
import ast


def output_sanitization(path_to_excel, path_to_out_json=None, path_to_log=None):
    ''' Find the Success percentage of each output report '''
    path = path_to_excel

    out_obj = []
    excel_obj = []

    # Output Sanitization
    wb = open_workbook(path)
    cols = 0
    cols_id = None
    for s in wb.sheets():
        for col in range(s.ncols):
            if s.cell(0, col).value == "F5 ID":
                cols_id = col
            if s.cell(0, col).value == "Status":
                cols_status = col
            if s.cell(0, col).value == "F5 SubType":
                col_subtype = col
            if s.cell(0, col).value == "Avi Object":
                col_avi_obj = col
            if s.cell(0, col).value == "F5 type":
                col_type = col
        if cols_id and cols_status:
            for row in range(s.nrows):
                if row == 0:
                    continue
                if s.cell(row, cols_status).value == 'SUCCESSFUL' or \
                   s.cell(row, cols_status).value == 'PARTIAL':
                    if s.cell(row, cols_id).value == 'hash' or \
                       s.cell(row, cols_id).value == 'oneconnect' or\
                       s.cell(row, col_type).value == 'route' or\
                       s.cell(row, col_subtype).value == 'oneconnect' or\
                       s.cell(row, col_subtype).value == 'one-connect' or\
                       "Indirectly mapped" in s.cell(row, col_avi_obj).value:
                        value = None
                    else:
                        value = s.cell(row, cols_id).value
                    if s.cell(row, col_type).value == 'pool' or\
                       s.cell(row, col_type).value == 'policy' :
                        value = s.cell(row, cols_id).value.split('/')[-1]
                    if value:
                        excel_obj.append(value)
        break

    with open(path_to_out_json, 'r') as file_strem:
        file_strem = json.load(file_strem)
        for entity in file_strem:
            if entity <> 'META' and entity <> 'VsVip':
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
                print b
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

    print "Object Difference between Excel sheet and output is %s" % len(obj_list)
    if obj_list:
        print "Object not Common in Both Excel and Output %s", obj_list
        return False
    print "Excel sheet matches with Output.json"
    return True


def percentage_success(path_to_excel):
    # Percentage Success from Excel Reports
    # find the status column
    path = path_to_excel
    wb = open_workbook(path)
    for s in wb.sheets():
        for col in range(s.ncols):
            if s.cell(0, col).value == "Status":
                col_status_val = col
            if s.cell(0, col).value == "F5 type" or \
                            s.cell(0, col).value == "Netscaler Command":
                col_type_val = col
        break
    report_dict = dict()
    for s in wb.sheets():
        for row in range(s.nrows):
            if row == 0:
                continue
            # taking col_type_val column for type and col_status_val for status
            val, state = s.cell(row, col_type_val), s.cell(row, col_status_val)
            state = state.value
            val = val.value
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
        break
    for key in report_dict.keys():
        if report_dict[key]['success'] + report_dict[key]['fail'] != 0:
            percent = float(report_dict[key]['success'] * 100 /
                            (report_dict[key]['success'] + report_dict[key]['fail']))
            report_dict[key].update({'percent': percent})
        else:
            report_dict[key].update({'percent': 100.0})
    for key in report_dict.keys():
        print key, " -> ", report_dict[key]['percent'], "%"

def output_vs_level_status(path_to_excel):
    path = path_to_excel
    wb = open_workbook(path)
    col_list = []
    for s in wb.sheets():
        for col in range(s.ncols):
            if s.cell(0, col).value == "VS Reference":
                col_list.append(col)
            elif s.cell(0, col).value == "Overall skipped settings":
                col_list.append(col)
    if len(col_list) == 2:
        return True
    else: return False
