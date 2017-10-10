import logging
import os
import copy
import sys
from gss_parser import parser
from avi.migrationtools.gss_convertor.gss_utils import printProgressBar,\
    excel_dict_create, set_total_stats

file_loc = os.path.split(os.path.abspath(__file__))[0]
sep = os.path.sep
file_loc_sep = os.path.split(os.path.abspath(__file__))[0] + sep

LOG = logging.getLogger(__name__)


def find_location(list_val, find_val, type_val):
    for index, val in enumerate(list_val):
        if val[type_val] == find_val:
            return index
    return -1


def config_converter(file_name):
    """ The conversion from parsed output goes here """

    # trying to access the parser function on the fly and load the data
    # to a local variable
    parsed_output, excel_dict = parser(file_name)

    # top to button approach huh !!!
    # 1. Create a combined json with internal depencies
    # 2. Put the things to avi json
    # 3. Boom !!! Smoking ...

    total_failed = 0

    LOG.info('Internal Conversion Started')
    print "Converting the Parsed output ...."

    # Holding this feature for confirmation from Sumant or Gauvrav
    # failed_checks = 3
    # for vip in parsed_output['answer vip']:
    #     if 'keepalive' in vip:
    #         print vip['keepalive']

    # sys.exit()

    # jut to parse the stuffs
    for vip in parsed_output['answer vip']:
        try:
            loc = find_location(parsed_output['answer vip'],
                                vip['answer vip'],
                                'answer vip')
            parsed_output['answer vip'][loc]['hang'] = 'n'
            try:
                excel_dict_create(vip, 'vip', 'success')
            except:
                pass
        except:
            # excel_dict_create(vip, 'vip', 'failed')
            # print vip
            pass

    future = 0
    # passing source-address-list
    for source in parsed_output['source-address-list']:
        # print source
        future += 1
        try:
            # print source['source-address-list']
            loc = find_location(parsed_output['source-address-list'],
                                source['source-address-list'],
                                'source-address-list')
            parsed_output['source-address-list'][loc]['hang'] = 'n'
            # print parsed_output['source-address-list'][loc]['hang']
            excel_dict_create(source, 'source-address-list', 'success')
        except Exception as e:
            print "Failed for ", source
            print "Exception", str(e)

    combined_dict = {}

    for rule in parsed_output['dns rule']:
        combined_dict[rule['dns rule']] = {}

    total_iteration = len(combined_dict.keys())
    iteration = 1
    parsing_failed_count = 0

    for keys in combined_dict:
        # doing some visual
        msg = 'Converting Rule [ ' + \
            str(parsed_output['dns rule'][0]['dns rule']) + ']'
        printProgressBar(iteration, total_iteration, msg,
                         prefix='Progress', suffix='')
        iteration += 1

        for dns in parsed_output['dns rule']:
            dns_rule_name = dns['dns rule']
            loc = find_location(parsed_output['dns rule'], dns['dns rule'],
                                'dns rule')
            parsed_output['dns rule'][loc]['hang'] = 'n'

            if keys == dns['dns rule']:
                combined_dict[keys] = dns

                # for adding domain-list
                for domain in parsed_output['domain-list']:
                    if domain['domain-list'] == \
                            combined_dict[keys]['domain-list']:
                        loc = find_location(parsed_output['domain-list'],
                                            domain['domain-list'],
                                            'domain-list')
                        parsed_output['domain-list'][loc]['hang'] = 'n'
                        combined_dict[keys].update(domain)
                        # updating the excel sheet
                        excel_dict_create(domain, 'domain', 'success',
                                          dns_rule_name)

                # for adding answer-group
                # fix for clause erroring out in large files
                try:
                    for index, clause in enumerate(dns['clause']):
                        for group in parsed_output['answer-group']:
                            # print group
                            if group['answer-group'] == clause['vip-group']:
                                loc = find_location(
                                    parsed_output['answer-group'],
                                    group['answer-group'],
                                    'answer-group')
                                parsed_output['answer-group'][loc]['hang'] \
                                    = 'n'
                                combined_dict[keys]['clause'][index].\
                                    update(group)
                                # updating the excel dict
                                excel_dict_create(group, 'answer', 'success',
                                                  dns_rule_name)
                    excel_dict_create(dns, 'dns', 'success', dns_rule_name)
                except:
                    # updating the excel dict
                    parsing_failed_count += 1
                    excel_dict_create(dns, 'dns', 'skip', dns_rule_name)
                    LOG.debug("Parsing Failed for %s" % (dns))

                # for addign source address list
                for source in parsed_output['source-address-list']:
                    if source['source-address-list'] == \
                            combined_dict[keys]['source-address-list']:
                        loc = find_location(
                            parsed_output['source-address-list'],
                            source['source-address-list'],
                            'source-address-list')
                        parsed_output['source-address-list'][loc]['hang'] = 'n'
                        excel_dict_create(source, 'source-address-list',
                                          'success', dns_rule_name)
                        combined_dict[keys].update(source)

    combined_dict_temp = copy.deepcopy(combined_dict)

    no_member_count = 0

    # kicking out memeber out when they don't have any clause or domains
    for key in combined_dict:
        flag = 0
        if len(combined_dict[key].get('clause', [])) < 1:
            LOG.warning('%s of key %s is not having members' %
                        (combined_dict[key], key))
            no_member_count += 1
            excel_dict_create(combined_dict[key], 'dns rule', 'no member')
            del combined_dict_temp[key]
        elif len(combined_dict[key].get('domain', [])) < 1:
            LOG.warning('%s of key %s is not having domains' %
                        (combined_dict[key], key))
            no_member_count += 1
            excel_dict_create(combined_dict[key], 'dns rule', 'no domain')
            del combined_dict_temp[key]
        elif len(combined_dict[key].get('clause', [])) >= 1:
            for key1 in combined_dict[key]['clause']:
                if len(key1.get('answer-add', [])) < 1:
                    flag = 1
            if flag == 1:
                no_member_count += 1
                excel_dict_create(combined_dict[key], 'dns rule', 'no domain')
                del combined_dict_temp[key]

    # for updating hanged
    hang_count = 0
    for key in parsed_output:
        for val in parsed_output[key]:
            if val['hang'] == 'y':
                if (val.get(key, [])):
                    excel_dict_create(val, key, 'hang')
                    LOG.warning('%s of type %s is hanging' % (val[key], key))
                else:
                    LOG.warning('%s of no type is hanging ' % (key))
                hang_count += 1
    set_total_stats('hang', hang_count)
    set_total_stats('no_member', no_member_count)

    # fix for multiple az
    combined_dict_temp = remove_multiple_az(combined_dict_temp, combined_dict)

    # Temp fix for priority duplicate value
    # Assigning random priority to avoid conflict
    for key in combined_dict_temp:
        temp_priority = 0
        for row_num, row_val in enumerate(combined_dict_temp[key]['clause']):
            temp_priority += 1
            combined_dict_temp[key]['clause'][row_num]['clause'] = temp_priority

    # Fix for duplicate members on same answer-group
    # Deleting duplicate members
    key = None
    combined_dict = copy.deepcopy(combined_dict_temp)
    for key in combined_dict:
        temp_list = []
        kill = 0
        for val in combined_dict[key]['clause']:
            if val['vip-group'] in temp_list:
                kill = 1
                break
            else:
                temp_list.append(val['vip-group'])
        if kill == 1:
            del combined_dict_temp[key]

    LOG.info('Convertor completed')
    return combined_dict_temp


def remove_multiple_az(combined_dict_temp, combined_dict):
    """ check the domains , and if the same available
        merge the domains into single az
    """
    combined_dict_az = copy.deepcopy(combined_dict_temp)
    merge_list = list()
    for keys in combined_dict_az:
        if keys in merge_list:
            continue
        domains = list()
        if combined_dict_az[keys].get('domain', []) and combined_dict[keys].get('clause', []):
            for domain in combined_dict_az[keys]['domain']:
                domains.append(domain['domain'])
        for keys1 in combined_dict_az:
            domains1 = list()
            if keys1 in merge_list or keys == keys1:
                continue
            if combined_dict_az[keys1].get('domain', []) and combined_dict[keys1].get('clause', []):
                for domain in combined_dict_az[keys1]['domain']:
                    domains1.append(domain['domain'])
                if set(domains) & set(domains1):
                    # skipping duplicate members
                    child_members = combined_dict_temp[keys1]['clause']
                    parent_members = combined_dict_temp[keys]['clause']
                    combined_dict_temp = skip_duplicate(keys, child_members, parent_members,
                                                        combined_dict_temp)
                    combined_dict_temp.pop(keys1)
                    merge_list.append(keys)
                    merge_list.append(keys1)

    return combined_dict_temp


def skip_duplicate(keys, child_members, parent_members, combined_dict_temp):
    """ Skipping duplicate by deleting from configuration """
    for items_c in child_members:
        flag = 0
        for items_p in parent_members:
            if items_c['vip-group'] == items_p['vip-group']:
                flag = 0
                break
            else:
                flag = 1
        if flag == 1:
            combined_dict_temp[keys]['clause'].append(items_c)
    return combined_dict_temp


if __name__ == '__main__':
    pass
