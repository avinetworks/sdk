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
            # print vip
            # sys.exit()
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
            print vip

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
    # print "count", future
    # sys.exit()

    combined_dict = {}

    for rule in parsed_output['dns rule']:
        # parsed_output[rule['dns rule']['hang']] = 'n'
        combined_dict[rule['dns rule']] = {}

    total_iteration = len(combined_dict.keys())
    iteration = 1
    parsing_failed_count = 0

    for keys in combined_dict:
        # doing some visual
        msg = 'Converting Rule [ ' + str(parsed_output['dns rule'][0]['dns rule']) + ']'
        printProgressBar(iteration, total_iteration, msg,
                         prefix='Progress', suffix='')
        iteration += 1
        # LOG.info(msg)

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
                    # print "Exception ", e
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
        # set_total_stats('fail', total_failed)

    combined_dict_temp = copy.deepcopy(combined_dict)

    no_member_count = 0

    # kicking out memeber out when they don't have any clause or domains
    for key in combined_dict:
        flag = 0
        if len(combined_dict[key].get('clause', [])) < 1:
            LOG.warning('%s of key %s is not having members' %
                        (combined_dict[key], key))
            no_member_count += 1
            # print "val is ", combined_dict[key]
            excel_dict_create(combined_dict[key], 'dns rule', 'no member')
            del combined_dict_temp[key]
        elif len(combined_dict[key].get('domain', [])) < 1:
            LOG.warning('%s of key %s is not having domains' %
                        (combined_dict[key], key))
            no_member_count += 1
            # print "val is ", combined_dict[key]
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
    # count = 0
    for key in parsed_output:
        for val in parsed_output[key]:
            # count += 1
            if val['hang'] == 'y':
                if (val.get(key, [])):
                    excel_dict_create(val, key, 'hang')
                    LOG.warning('%s of type %s is hanging' % (val[key], key))
                else:
                    LOG.warning('%s of no type is hanging ' % (key))
                hang_count += 1
    set_total_stats('hang', hang_count)
    set_total_stats('no_member', no_member_count)

    LOG.info('Convertor completed')
    return combined_dict_temp


if __name__ == '__main__':
    pass
