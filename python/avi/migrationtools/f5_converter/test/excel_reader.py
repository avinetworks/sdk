from xlrd import open_workbook
import json


def output_sanitization(path_to_excel, path_to_out_json=None):
    ''' Find the Success percentage of each output report '''
    path = path_to_excel

    out_obj = []
    excel_obj = []

    # Output Sanitization
    wb = open_workbook(path)
    cols = 0
    for s in wb.sheets():
        for col in range(s.ncols):
            if s.cell(0, col).value == "F5 ID":
                cols_id = col
            if s.cell(0, col).value == "Status":
                cols_status = col
        if cols_id and cols_status:
            for row in range(s.nrows):
                if row == 0:
                    continue
                if s.cell(row, cols_status).value == 'SUCCESSFUL' or\
                   s.cell(row, cols_status).value == 'PARTIAL':
                    if s.cell(row, cols_id ) == 'hash' or\
                       s.cell(row, cols_id) == 'oneconnect':
                        value = None
                    else:
                        value = s.cell(row, cols_id).value
                    if value:
                        excel_obj.append(value)
        break

    with open(path_to_out_json, 'r') as file_strem:
        file_strem = json.load(file_strem)
        for entity in file_strem:
            if entity <> 'META' and entity <> 'VsVip':
                # print file_strem
                for obj in file_strem[entity]:
                    out_obj.append(obj.get('name'))
    print len(out_obj)
    print len(excel_obj)
    excel_obj.sort()
    out_obj.sort()
    print "Object Common in Both Excel and Output "
    for obj in excel_obj:
        if obj not in out_obj:
            print obj
    

def percentage_success(path_to_excel):
    # Percetage Success from Excel Reportss
    # find the status colummn 
    path = path_to_excel
    wb = open_workbook(path)
    for s in wb.sheets():
        for col in range(s.ncols):
            if s.cell(0, col).value == "Status":
                col_status_val = col
            if s.cell(0, col).value == "F5 type" or\
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
            if state == "PARTIAL" or state ==  "SUCCESSFUL":
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

