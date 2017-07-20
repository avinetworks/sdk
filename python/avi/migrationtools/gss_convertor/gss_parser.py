import os
import sys
import logging
from pyparsing import alphanums, alphas, nums, Group, ZeroOrMore, printables,\
    quotedString, Keyword, Word, Optional, Combine, Empty, replaceWith,\
    Literal
from avi.migrationtools.gss_convertor.gss_utils import printProgressBar,\
                                                set_total_stats, set_excel_dict

file_loc = os.path.split(os.path.abspath(__file__))[0]
sep = os.path.sep
file_loc_sep = os.path.split(os.path.abspath(__file__))[0] + sep

LOG = logging.getLogger('%slog%sconversion.log' % (file_loc_sep, sep))


def parse(val):
    ''' This function pairs the value 1st value to "key"
        and 2nd value to "value" in a dictionary '''
    config_dict = dict()
    if len(val) % 2 == 0:
        for index in xrange(0, len(val), 2):
            config_dict[str(val[index])] = str(val[index+1])
        config_dict.update({'hang': 'y'})
        return config_dict
    else:
        config_dict.update({'hang': 'y'})
        return config_dict


def parser(file_name):
    """ Parsing goes here """
    LOG.info('Parser Started')

    with open(file_name, 'r') as input_config:
        input_data = input_config.read()
        input_config.seek(0, 2)
        file_size = input_config.tell()

    # grammer def:1 source-address-list Anywhere owner System
    key = Keyword("source-address-list")
    name = Word(printables)
    system = Keyword("owner")
    system_name = Word(alphanums)
    comment_key = Keyword("comments")
    comment = quotedString | Word(printables)
    grammer1 = Group(key + name + system + system_name +
                     Optional(comment_key + comment))

    # grammer def:2 ip address  10.10.10.10 255.255.255.255
    key1 = "ip address"
    ipaddress = Combine(Word(nums) + ('.' + Word(nums)) * 3)
    ipaddress1 = Empty().addParseAction(replaceWith('Mask')) + Combine(
        Word(nums) + ('.' + Word(nums)) * 3)
    grammer2 = Group(key1 + Optional(ipaddress) + Optional(ipaddress1) +
                     Optional('::/0'))

    # grammer def:3 domain-list <name> owner System
    key = Keyword("domain-list")
    name = Word(printables)
    own = Keyword("owner")
    owner_name = Word(alphanums)
    comments = Keyword('comment')
    comment = quotedString | Word(printables)
    grammer3 = Group(key + name + own + owner_name +
                     Optional(comments + comment))

    # grammer def:4
    domain_key = Keyword("domain")
    domain_name = Word(printables)
    grammer4 = Group(domain_key + ~Literal('-') + domain_name)

    # grammer def:4 answer vip 10.10.10.10 name <name> location
    # "<location>" manual-reactivation disable activate
    answer_key = Keyword("answer vip")
    ipaddress = Combine(Word(nums) + ('.' + Word(nums)) * 3)
    name_key = Keyword("name")
    name = Word(alphanums)
    location_key = Keyword("location")
    location = quotedString
    manual_reactivation_key = Keyword("manual-reactivation")
    manual_reactivation = Keyword("disable") | Keyword("enable")
    activate_key = Empty().addParseAction(
        replaceWith('Mode')) + Keyword("activate")

    grammer5 = Group(answer_key + ipaddress + name_key + name + location_key +
                     location + Optional(manual_reactivation_key) +
                     Optional(manual_reactivation) + Optional(activate_key))

    # grammer6 : keepalive type tcp port <port> ip-address <ip> <<retries>>
    #                        <<successful-probes>> <<termination>>
    #            keepalive type http-head port 80 <<path>> <<retries>>
    #                          <<successful-probes>> <<shared>> <<termination>>
    #            keepalive type icmp ip-address <ip>  <<retries>>
    #                       <<successful-probes>>
    key = Keyword('keepalive')
    tcp_key = Keyword("type tcp")
    http_key = Keyword("type http-head")
    icmp_key = Keyword("type icmp")
    port_key = Keyword("port")
    num = Word(nums)
    ip_add_key = Keyword("ip-address")
    ip_add = Combine(Word(nums) + ('.' + Word(nums)) * 3)
    retry = Optional(Keyword('retries') + num)
    probe = Optional(Keyword('successful-probes') + num)
    shared = Optional(Keyword('shared') + ip_add)
    path = Optional(Keyword('path') + ip_add)
    termination = Optional(Keyword('termination') + (Word('graceful') |
                                                     Word('reset')))

    grammer6_1 = Group(key + tcp_key + port_key + num + ip_add_key + ip_add +
                       Optional(retry) + Optional(probe) + Optional(termination))
    grammer6_2 = Group(key + http_key + path + port_key + num + retry + probe +
                       shared + termination)
    grammer6_3 = Group(key + icmp_key + Optional(ip_add_key + ip_add) + retry +
                       probe)

    grammer6 = grammer6_1 | grammer6_2 | grammer6_3

    # grammer 7: answer-group <name> owner System type vip comment "comment"
    key = Keyword("answer-group")
    key_name = Word(printables)
    owner_key = Keyword("owner")
    owner_name = Word(alphanums)
    type_key = Keyword("type")
    type_name = Word(alphas)
    comment_key = Keyword("comments")
    comments = quotedString() | Word(printables)

    grammer7 = Group(key + key_name + owner_key + owner_name +
                     type_key + type_name + Optional(comment_key + comments))

    # grammer 8: answer-add 10.10.10.10 name MDC-PROD-SMTP-ACE \
    # weight 1 order 1 load-threshold 254 suspend
    key = Keyword('answer-add')
    key_ip = Combine(Word(nums) + ('.' + Word(nums)) * 3)
    name_key = Keyword('name')
    name_val = Word(printables)
    weight_key = Keyword('weight')
    weight_val = Word(nums)
    order_key = Keyword('order')
    order_val = Word(nums)
    thres_key = Keyword('load-threshold')
    thres_val = Word(nums)
    suspend_key = Empty().addParseAction(replaceWith('Mode')) + Word(alphas)

    grammer8 = Group(key + key_ip + name_key + name_val + weight_key +
                     weight_val + order_key + order_val + thres_key +
                     thres_val + suspend_key)

    # grammer9:dns rule <rule name> owner System source-address-list
    # Anywhere domain-list <dl_name> activate
    # query a
    # <sticky | sticky method> <domain | domain-list> timeout 15
    key = Keyword("dns rule")
    key_val = Word(printables)
    owner_key = Keyword("owner")
    owner_name = Word(alphas)
    saddlist_key = Keyword("source-address-list")
    saddlist_val = Word(alphanums)
    domain_key = Keyword("domain-list")
    domain_val = Word(printables)
    activate_key = Empty().addParseAction(
        replaceWith('Mode')) + Keyword("activate")
    query_key = Keyword("query")
    query_val = Word("a") | Word(printables)
    s_key = Keyword('sticky method') | Keyword('sticky')
    d_key = Keyword('domain') | Keyword('domain-list')
    t_key = Keyword('timeout')
    t_val = Word(nums)

    grammer9 = Group(key + key_val + owner_key + owner_name +
                     saddlist_key + saddlist_val + domain_key + domain_val +
                     activate_key + Optional(query_key + query_val) +
                     Optional(s_key + d_key + t_key + t_val))

    # grammer10 :
    # clause 1 vip-group <name> method ordered ttl 20 \
    # count 1 <sticky|region-sticky> enabled manual-reactivation disable activate
    key = Keyword("clause")
    key_val = Word(nums)
    vip_key = Keyword("vip-group")
    vip_val = Word(printables)
    method_key = Keyword("method")
    method_val = Word(printables)
    ttl_key = Keyword("ttl")
    ttl_val = Word(nums)
    count_key = Keyword("count")
    count_val = Word(nums)
    sticky_key = Keyword("sticky") | Keyword("region-sticky")
    sticky_val = Word("enable")
    mr_key = Keyword("manual-reactivation")
    mr_val = Word("disable")
    state_key = Empty().addParseAction(replaceWith('Mode')) + Word("activate")

    grammer10 = Group(key + key_val + vip_key + vip_val + method_key +
                      method_val + ttl_key + ttl_val + count_key +
                      count_val + Optional(sticky_key + sticky_val) +
                      mr_key + mr_val + state_key)

    testing = Group(
                grammer1 + ZeroOrMore(grammer2)) | Group(
                grammer3 + ZeroOrMore(grammer4)) | Group(
                grammer5 + ZeroOrMore(grammer6)) | Group(
                grammer7 + ZeroOrMore(grammer8)) | Group(
                grammer9 + ZeroOrMore(grammer10))

    LOG.info('Grammar Generated')

    child_ref = {
        'source-address-list': 'ip address',
        'domain-list': 'domain',
        'answer vip': 'keepalive',
        'answer-group': 'answer-add',
        'dns rule': 'clause'
    }

    excel_dict = dict()

    out_dict = {'source-address-list': [], 'domain-list': [], 'answer vip': [],
                'answer-group': [], 'dns rule': []}

    ref = ''

    print "Parsing the File ..."

    total_parse_count = 0
    c = 0

    for match, start, end in testing.scanString(input_data):

        # incrementing total object count for reporting
        total_parse_count += 1

        matched = match.asList()
        type = matched[0][0][0]
        name = matched[0][0][1]
        excel_dict[type + '-' + name] = {'type': type, 'name': name, 'status': '',
                            'na': '', 'skipped': ''}
        msg = 'Parsing Entity [ ' + matched[0][0][0] + '->' +\
              matched[0][0][1] + ']'
        printProgressBar(end, file_size, msg,
                         prefix='Progress', suffix='')

        # dictonary creation
        start = True
        for line in matched[0]:
            out = 'Parsing [ ' + line[0] + '->' + line[1] + ']'
            LOG.debug(out)
            # print matched[0]
            if start:
                ref = line[0]
                parent = parse(line)
                start = False
            else:
                child = parse(line)
                if child_ref[ref] not in parent:
                    parent[str(child_ref[ref])] = [child]
                else:
                    parent[str(child_ref[ref])].append(child)
        out_dict[ref].append(parent)

    LOG.info('Config File Parsed')
    set_excel_dict(excel_dict)

    return out_dict, excel_dict
