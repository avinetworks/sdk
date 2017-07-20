"""
    want to do somthing helpful
    write down those here
"""

import sys
import os

excel_dict = dict()
total_stats = {
    "Skipped Attributes": 0,
    "Total Objects Parsed": 0,
    "Partially Converted": 0,
    "Not supported": 0,
    "Successfull Conversions": 0,
    "Incomplete Configuration": 0
}

# print total_stats


def get_loc():
    """ Give the location of the script running """
    return os.path.dirname(os.path.abspath(__file__))


def get_total_stats():
    """ Keep all the stats here """
    global total_stats
    return total_stats


def set_total_stats(key, val=1):
    global total_stats
    """ Return the total stats gathered """
    if key == 'total':
        total_stats['Total Objects Parsed'] = total_stats['Total Objects Parsed'] + val
    elif key == 'success':
        total_stats['Successfull Conversions'] = total_stats['Successfull Conversions'] + val
    elif key == 'skip':
        total_stats['Skipped Attributes'] = total_stats['Skipped Attributes'] + val
    elif key == 'partial':
        total_stats['Partially Converted'] = total_stats['Partially Converted'] + val
    elif key == 'not_supported':
        total_stats['Not supported'] = total_stats['Not supported'] + val
    elif key == 'hang':
        total_stats['Incomplete Configuration'] = total_stats['Incomplete Configuration'] + val


def get_excel_dict():
    """ Returning the excel dict"""
    global excel_dict
    return excel_dict


def set_excel_dict(excel):
    """ Initialize the excel dict"""
    global excel_dict
    excel_dict = excel


def excel_dict_create(obj, type, status, rule='no_rule'):
    """ Excel Dictonary Creation happens here """
    global excel_dict
    na_val = []
    skipped_val = []
    # print "Excel dict create"
    # for source-address-list
    if status == 'hang':
        name = obj[type]
        excel_dict[type + '-' + name].update({'status': status, 'na': na_val,
                                              'skipped': skipped_val,
                                              'rule': rule})
    if status == 'no member' or status == 'no domain':
        msg = "No GSLB Service Created because of " + str(status)
        name = obj[type]
        # print msg
        excel_dict[type + '-' + name].update({'avi_status': status,
                                              'avi_msg': msg,
                                              'status': 'skip'})
    elif type == 'source-address-list' and status == 'success':
        name = obj['source-address-list']
        excel_dict[type + '-' + name].update({"status": "not_supported", 
                                              "na": na_val,
                                              "skipped": skipped_val,
                                              "rule": rule})

    # for domain list
    elif type == 'domain' and status == 'success':
        name = obj['domain-list']
        type = 'domain-list'
        excel_dict[type + '-' + name].update({"status": "success",
                                              "na": na_val,
                                              "skipped": skipped_val,
                                              "rule": rule})

    # for answer group
    elif type == 'answer' and status == 'success':
        name = obj['answer-group']
        type = 'answer-group'
        state = 'success'
        # print obj
        for answer in obj.get('answer-add', []):
            if 'load-threshold' in answer.keys():
                na_val.append('load-threshold')
        excel_dict[type + '-' + name].update({"status": state, "na": na_val,
                                              "skipped": skipped_val,
                                              "rule": rule})

    # for answer vip
    elif type == 'vip':
        type = 'answer vip'
        if status == 'success':
            name = obj['answer vip']
            state = 'success'
            skip = ["manual-reactivation", "activate", "location"]
            for val in skip:
                if val in obj.keys() and val not in na_val:
                    na_val.append(val)
            excel_dict[type + '-' + name].update({"status": state,
                                                  "na": na_val,
                                                  "skipped": skipped_val,
                                                  "rule": rule})
        else:
            excel_dict[type + '-' + name].update({"status": 'skip',
                                                  "na": na_val,
                                                  "skipped": skipped_val,
                                                  "rule": rule})
    # for dns rule
    elif type == 'dns':
        type = 'dns rule'
        if status == 'success':
            name = obj['dns rule']
            ttl = 0
            sticky = 0
            r_sticky = 0
            state = 'success'
            stick_parital = 0
            # print obj.keys()
            if "sticky method" in obj.keys():
                stick_parital = 1
                # print "failed"
            for answer in obj.get('clause', []):
                # print answer.keys()
                if 'ttl' in answer.keys():
                    ttl += 1
                if 'sticky' in answer.keys():
                    sticky += 1
                if 'region-sticky' in answer.keys():
                    r_sticky += 1

            if ttl > 1:
                skipped_val.append('ttl')
                state = 'partial'
            if sticky > 0:
                skipped_val.append('sticky in clause')
                state = 'partial'
            if r_sticky > 0:
                skipped_val.append('reigon-sticky in clause')
                state = 'partial'
            if stick_parital > 0:
                skipped_val.append('sticky')
                state = 'partial'

        else:
            name = obj['dns rule']
            state = 'skip'

        excel_dict[type + '-' + name].update({"status": state, "na": na_val,
                                              "skipped": skipped_val,
                                              "rule": rule})


# Print iterations progress
def printProgressBar(iteration, total, msg, prefix='', suffix='', decimals=1,
                     length=100, fill='#'):
    """
    Call in a loop to create terminal progress bar
    @params:
        iteration   - Required  : current iteration (Int)
        total       - Required  : total iterations (Int)
        prefix      - Optional  : prefix string (Str)
        suffix      - Optional  : suffix string (Str)
        decimals    - Optional  : positive number of decimals in percent complete (Int)
        length      - Optional  : character length of bar (Int)
        fill        - Optional  : bar fill character (Str)
    """
    percent = ("{0:." + str(decimals) + "f}").\
                             format(100 * (iteration / float(total)))
    filledLength = int(length * iteration // total)
    bar = fill * filledLength + '-' * (length - filledLength)
    if (iteration < total):
        print '\r%s |%s| %s%% %s' % (prefix, bar, percent, suffix),
    else:
        print '\r%s |%s| %s%% %s' % (prefix, bar, percent, suffix)
        print 'completed'
        print '\n'
