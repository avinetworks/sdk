""" Utils Functions goes here """

import sys
import os

excel_dict = list()


def get_loc():
    """ Give the location of the script running """
    return os.path.dirname(os.path.abspath(__file__))

def get_excel_dict():
    """ Returning the excel dict"""
    global excel_dict
    return excel_dict


def set_excel_dict(excel):
    """ Initialize the excel dict"""
    global excel_dict
    excel_dict = excel


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


# Update Excel Sheet
def update_excel(obj_type, name, status='Success', avi_obj=[], skip=[]):
    """ Update Excel sheet """
    if skip:
        status = 'Partial'
    for index, row in enumerate(excel_dict):
        if row.get('name', '') == name and row.get('type', '') == obj_type:
            excel_dict[index]['Avi Object'] = avi_obj
            excel_dict[index]['status'] = status
            excel_dict[index]['skipped'] = skip
