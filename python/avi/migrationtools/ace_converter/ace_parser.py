import os
import sys
import logging
from pyparsing import Keyword, Word, OneOrMore, printables, Group, nums,\
                      alphas,ZeroOrMore, Optional, Combine
from itertools import cycle
from avi.migrationtools.ace_converter.ace_utils import printProgressBar,\
                                                       set_excel_dict
LOG = logging.getLogger(__name__)
# file_loc = os.path.split(os.path.abspath(__file__))[0]
# sep = os.path.sep
# # logging.basicConfig(level=logging.WARNING)
# LOG = logging.getLogger(file_loc + sep + 'out' + sep + 'conversion.log')


class Parser():
    """ This class is for Parsing 
        - Parsing grammars are written in pyparsing
    """
    def __init__(self, file_name):
        self.file_name = file_name

    def parse_ace(self):

        with open(self.file_name, 'r') as input_config:
            input_data = input_config.read()
            input_config.seek(0, 2)
            file_size = input_config.tell()

        # Pyparsing grammer starts here :excitement :-O
        
        command = Group(Keyword('logging') | Keyword('access-list') | Keyword('probe'))

        # Grammer Global
        name = Word(printables)
        ipaddress = Combine(Word(nums) + ('.' + Word(nums)) * 3)
        num = Word(nums)

        # Grammer 1:
        # logging enable
        # logging timestamp
        # logging trap 9
        # logging buffered 9
        # logging host 127.0.0.1 udp/619         
        log = Keyword('logging')
        single_key = Keyword('enable') | Keyword('timestamp')
        double_key = (Keyword('trap') | Keyword('buffered')) + num
        triple_key = Keyword('host') + ipaddress + name
        grammer_1 = Group(log + (single_key | double_key | triple_key))

        # Grammer 2:
        # eg : access-list FROM_INSIDE line 11 extended permit ip <ip> 255.255.255.0 any
        access = Keyword('access-list')
        in_out = Keyword('FROM_INSIDE') | Keyword('FROM_OUTSIDE')
        line = Keyword('line')
        extend = Keyword('extended')
        permit = Keyword('permit')
        ip_key = Keyword('ip')
        any_key = Keyword('any')
        ip_any = ipaddress | any_key

        grammer_2 = Group(access + in_out + line + num + extend + permit + ip_key +
                          ip_any + ip_any + ip_any)

        # Grammer 3:
        # eg: probe http prb_HTTP-1234
        #        port 1234
        #        receive 5
        #        interval 10
        #        expect status 200 200
        #        request method get url /test/test:ping

        probe = Keyword('probe')
        type_key = Keyword('http') | Keyword('icmp') | Keyword('https') | Keyword('tcp')
        grammer_3_1 = Group (probe + type_key + name)

        grammer_3_2 = Group(Keyword('port') + Word(nums))
        grammer_3_3 = Group(Keyword('receive') + Word(nums))
        grammer_3_4 = Group(Keyword('interval') + Word(nums))
        grammer_3_5 = Group(Keyword('expect') + Keyword('status') + Word(nums) + Word(nums))

        request_key = Keyword('request')
        method_key = Keyword('method')
        get = Keyword('get')
        url_key = Keyword('url')
        url = Word(printables)
        grammer_3_6 = Group(request_key + method_key + get + url_key + url)

        grammer_3 = Group(grammer_3_1 + ZeroOrMore(grammer_3_2 |
                          grammer_3_3 | grammer_3_4 | grammer_3_5 |
                          grammer_3_6))

        # grammer 4:
        # rserver host rs_Test123
        #   description TEST_DESC
        #   ip address 127.0.0.1
        #   probe prb_HTTP-1234
        #   inservice

        rserver_key = Keyword('rserver')
        host = Keyword('host')
        rserver_name = Word(printables)

        grammer_4_1 = Group(rserver_key + host + rserver_name)
        grammer_4_2 = Group(Keyword('description') + Word(printables))
        grammer_4_3 = Group(Keyword('ip address') + ipaddress)
        grammer_4_4 = Group(Keyword('probe') + Word(printables))
        grammer_4_5 = Group(Keyword('inservice'))

        grammer_4 = Group(grammer_4_1 + ZeroOrMore(grammer_4_2 | grammer_4_3 |
                                                   grammer_4_4 | grammer_4_5))

        # grammer 5
        # parameter-map type <connection|http> ALLOW_TEST
        #   tcp-options selective-ack allow
        #   tcp-options timestamp allow
        #   tcp-options window-scale allow
        #   persistence-rebalance strict
        #   set timeout inactivity 9999

        param_key = Keyword('parameter-map')
        type_key = Word('type')
        connection = Word('connection') | Word('http')
        param_name = Word(printables)
        tcp_key = Word('tcp-options')
        tcp_type = Keyword('timestamp') | Keyword('window-scale') | Keyword('selective-ack')
        allow = Word('allow')

        grammer_5_1 = Group(param_key + type_key + connection + param_name)
        grammer_5_2 = Group(tcp_key + tcp_type + allow)
        grammer_5_3 = Group(Keyword('persistence-rebalance') + Keyword('strict'))
        grammer_5_4 = Group(Keyword('set') + Keyword('timeout') + Keyword('inactivity')+\
                            Word(nums))

        grammer_5 = Group(grammer_5_1 + ZeroOrMore(grammer_5_2 | grammer_5_3 | grammer_5_4))

        # Grammer 6:
        # sticky ip-netmask 255.255.255.255 address source test-adfdas-$5D
        #   serverfarm sf_TEST
        #   timeout 1000
        #   replicate sticky
        sticky = Keyword('sticky')
        ipnetmask = Keyword('ip-netmask')
        address = Keyword('address')
        source = Keyword('source')
        sticky_name = Word(printables)
        
        grammer_6_1 = Group(sticky + ipnetmask + ipaddress + address + source + sticky_name)
        grammer_6_2 = Group(Keyword('serverfarm') + Word(printables))
        grammer_6_3 = Group(Keyword('timeout') + Word(nums))
        grammer_6_4 = Group(Keyword('replicate') + sticky)

        grammer_6 = Group(grammer_6_1 + ZeroOrMore(grammer_6_2 | grammer_6_3 |
                                                   grammer_6_4))

        # grammer7:
        # class-map type management match-any TEST-PROTOCOLS
        # class-map match-any TEST_TEST_123
        # class-map match-any TEST_TEST_123
        # class-map match-all TEST_TEST_123
        #     2 match protocol icmp source-address 127.0.0.1 255.0.0.0
        #     3 match protocol snmp source-address 127.0.0.1 255.255.255.0
        #     2 match destination-address 127.0.0.1 255.255.255.0
        #     3 match source-address 127.0.0.1 255.255.255.0
        #     2 match virtual-address 127.0.0.1 tcp eq 1234
        #     2 match virtual-address 127.0.0.1 tcp any

        classmap = Keyword('class-map')
        classmap_type = Keyword('type') 
        mgmt = Keyword('management')
        type_key_att = classmap_type + mgmt
        match_key = Keyword('match-any') | Keyword('match-all')

        grammer7_1 = Group(classmap + match_key + name)

        match_key = Keyword('match')
        proto_key = Keyword('protocol')
        proto_type = Keyword('tcp') | Keyword('icmp') | Keyword('snmp') | Keyword('http') | Keyword('https') | Keyword('udp')
        proto = proto_key + proto_type
        source_dest = Keyword('source-address') | Keyword('destination-address')
        virtual_add = Keyword('virtual-address')
        eq_key = Keyword('eq')
        eq_val = Keyword('https') | Keyword('www') | Keyword('http') | num
        any_key = Keyword('any')
        add_att = Optional(proto) + source_dest + ipaddress + ipaddress
        virt_att = virtual_add + ipaddress + proto_type + ((eq_key + eq_val) | any_key)

        grammer7_2 = Group(num + match_key + (add_att | virt_att))

        grammer_7 = Group(grammer7_1 + ZeroOrMore(grammer7_2))

        # grammer8:
        # policy-map type loadbalance first-match LB_TEST_MAP_1235
        #     class class-default
        #         serverfarm TEST_FARM_2
        #         sticky-serverfarm TEST_FARM_2
        #         connection advanced-options TEST_CONN123
        #        loadbalance vip inservice
        #        loadbalance vip icmp-reply
        #        loadbalance policy LB_TEST_123
        #        inspect ftp
        #        ssl-proxy server ssl_name

        policy_key = Keyword('policy-map')
        lb_key = Keyword('loadbalance')
        match = Keyword('first-match') | Keyword('multi-match')

        grammer_8_1 = Group(policy_key + Optional(type_key + lb_key) + match + name)

        grammer_8_2_1 = Group(Keyword('class') + name)

        grammer_8_2_2 = Group((Keyword('serverfarm') | Keyword('sticky-serverfarm')) + name)
        grammer_8_2_3 = Group(Keyword('connection') + Keyword('advanced-option') + name)

        lb_vip = Keyword('vip') + (Keyword('inservice') | Keyword('icmp-reply'))
        lb_policy = Keyword('policy') + name
        grammer_8_2_4 = Group(Keyword('loadbalance') + (lb_vip | lb_policy))
        grammer_8_2_5 = Group(Keyword('inspect') + Keyword('ftp'))
        grammer_8_2_6 = Group(Keyword('ssl-proxy') + Keyword('server') + name)

        grammer_8_2 = Group(grammer_8_2_1 + ZeroOrMore(grammer_8_2_2 |
                                                       grammer_8_2_3 |
                                                       grammer_8_2_4 |
                                                       grammer_8_2_5 |
                                                       grammer_8_2_6))
        
        grammer_8 = Group(grammer_8_1 + ZeroOrMore(grammer_8_2))

        # grammer9:
        # interface vlan 1011
        #     ip address 127.0.0.1 255.255.255.0
        #     alias 127.0.0.1 255.255.255.0
        #     peer ip address 127.0.0.1 255.255.255.0
        #     access-group input FROM_TEST
        #     service-policy input TEST_ACCESS
        #     service-policy input vs_TEST
        #     service-policy input TEST_POLICY_8080
        #     no shutdown
        #     nat-pool 1 127.0.0.1 127.0.0.1 netmask 255.255.255.255 pat

        grammer_9_1 = Group(Keyword('interface') + Keyword('vlan') + num)
        grammer_9_2 = Group(ip_key + address + ipaddress + ipaddress)
        grammer_9_3 = Group(Keyword('alias') + ipaddress + ipaddress)
        grammer_9_4 = Group(Keyword('peer') + ip_key + address + ipaddress + ipaddress )
        grammer_9_5 = Group(Keyword('access-group') + Keyword('input') + name)
        grammer_9_6 = Group(Keyword('service-policy') + Keyword('input') + name)
        grammer_9_7 = Group(Keyword('no') + Keyword('shutdown'))
        grammer_9_8 = Group(Keyword('nat-pool') + num + ipaddress + ipaddress +
                            Keyword('netmask') + ipaddress + Keyword('pat'))
    
        grammer_9 = Group(grammer_9_1 + ZeroOrMore(grammer_9_2 | grammer_9_3 |
                                                   grammer_9_4 | grammer_9_5 |
                                                   grammer_9_6 | grammer_9_7 |
                                                   grammer_9_8))

        # grammer 10:
        # ip route 0.0.0.0 0.0.0.0 127.0.0.1
        grammer_10 = Group(ip_key + Keyword('route') + ipaddress + ipaddress)

        # grammer 11:
        # snmp-server host 127.0.0.1 traps version 2c ********
        # snmp-server enable traps slb k7server
        snmp = Keyword('snmp-server')
        host = Keyword('host')
        traps = Keyword('traps')
        slb = Keyword('slb')
        version = Keyword('version')
        enable = Keyword('enable')
        host_att = host + ipaddress + traps + version + name + name
        ord_att = enable + traps + slb + name 

        grammer_11 = Group(snmp + (host_att | ord_att))

        # grammer 12
        # serverfarm host TEST_TEST_79
        #     probe probe_TEST_123
        #     inband-health check count
        #     rserver RS_TEST123
        #         inservice
        serverfarm = Keyword('serverfarm')
        host = Keyword('host')
        grammer_12_1 = Group(serverfarm + host + name)
        grammer_12_2 = Group(Keyword('probe') + name)
        grammer_12_3 = Group(Keyword('inband-health') + Keyword('check') + name)
        grammer_12_4_1 = Keyword('rserver') + name
        grammer_12_4_2 = Keyword('inservice')
        grammer_12_4 = Group(grammer_12_4_1 + ZeroOrMore(grammer_12_4_2))
        
        grammer_12 = Group(grammer_12_1 + ZeroOrMore(grammer_12_2 | grammer_12_2 |
                                                     grammer_12_3 | grammer_12_4))

        grammer = Group(grammer_1 | grammer_2 | grammer_3 | grammer_4 |
                        grammer_5 | grammer_6 | grammer_7 | grammer_8 |
                        grammer_9 | grammer_10 | grammer_11 | grammer_12)

        print "Grammer created .."
        LOG.info("Grammer created ..")

        out_dict = []
        total_parse_count = 0
        final_excel = []

        LOG.info("Parsing Starts ..")
        final_dict = dict()
        for match, start, end in grammer.scanString(input_data):
            key = ''
            extra_dict = {}

            # printing progress bar
            msg = ''
            printProgressBar(end, file_size, msg, prefix='Progress', suffix='')

            if match:                
                matched = match.asList()
                command = input_data[start: end]
                out_dict.append(matched)
                if type(matched[0][0][0]) is list:
                    key = matched[0][0][0][0]
                    name_to_log = matched[0][0][0][1]
                else:
                    key = matched[0][0][0]
                    name_to_log = matched[0][0][1]

            LOG.info('Parsing happening for :{} ->  {}'.format(key, name_to_log))
            # LOG.debug('Parsing value {}'.format(matched))


            excel_dict = {  
                            'name': '',
                            'type': '',
                            'command': '',
                            'converted': 'n',
                            'status': 'Not Supported',
                            'skipped': [],
                            'indirect': [],
                            'NA': [],
                            'Avi Object': ''
                        }

            name_to_log = None
            type_to_log = ['logging', 'access-list', 'rserver', 'serverfarm',
                           'parameter-map', 'class-map', 'policy-map', 'sticky',
                           'probe']

            if key == 'logging':
                matched = matched[0][0]
                name_to_log = matched[1]
                total_index = len(matched)
                if total_index == 2:
                    extra_dict = {
                        'log_type': matched[1]
                    }

                elif total_index == 3:
                    extra_dict = {
                        'log_type': matched[1],
                        'value': matched[2]
                    }

                elif total_index == 4:
                    extra_dict = {
                        'log_type': matched[1],
                        'value': matched[2],
                        'packet': matched[3]
                    }
                LOG.info('parsing: Logging for value : {}'.format(name_to_log))
                # LOG.debug('Logging value {}'.format(extra_dict))

            if key == 'access-list':
                matched = matched[0][0]
                name_to_log = "{} line {}".format(matched[0][1], matched[0][4])
                extra_dict = {
                    'type': matched[1],
                    matched[2]: matched[3],
                    'extend': matched[4],
                    'permit': matched[5],
                    'ip1': matched[7],
                    'ip2': matched[8],
                    'ip3': matched[9]
                }
                LOG.info('parsing: Access-list {}'.format(name_to_log))
                # LOG.debug('Access-list value {}'.format(extra_dict))

            if key == 'rserver':
                matched = matched[0][0]
                name_to_log = matched[0][2]
                extra_dict = {
                    matched[0][1]: matched[0][2],
                    'desc': []
                }
                for match in matched[1:]:
                    temp_dict = dict()
                    if len(match) == 1:
                        temp_dict = {
                            'type': match[0]
                        }
                    else:
                        temp_dict = {
                            match[0]: match[1]
                        }
                    extra_dict['desc'].append(temp_dict)

                LOG.info('parsing: rserver for value : {}'.format(name_to_log))
                # LOG.debug('rserver value {}'.format(extra_dict))

            if key == 'serverfarm':
                matched = matched[0][0]
                name_to_log = matched[0][2]
                extra_dict = {
                    matched[0][1]: matched[0][2],
                    'desc': []
                }
                for match in matched[1:]:
                    temp_dict = dict()
                    if len(match) < 3:
                        temp_dict = {
                            match[0]: match[1]
                        }
                    else:
                        temp_dict = {
                            match[0]: match[1],
                            'type': match[2]
                        }
                    extra_dict['desc'].append(temp_dict)

                LOG.info('parsing: server farm for value : {}'.format(name_to_log))
                # LOG.debug('serverfarm value {}'.format(extra_dict))

            if key == 'parameter-map':
                matched = matched[0][0]
                name_to_log = matched[0][3]
                extra_dict = {
                    matched[0][1]: matched[0][2],
                    'conn_name': matched[0][3],
                    'desc': []
                }
                for match in matched[1:]:
                    temp_dict = dict()
                    if len(match) == 2:
                        temp_dict = {
                            match[0]: match[1]
                        }
                    else:
                        temp_dict = {
                            match[0]: match[1],
                            'allow': match[2]
                        }
                    extra_dict['desc'].append(temp_dict)

                LOG.info('parsing: parameter-map for value : {}'.format(name_to_log))
                # LOG.debug('parameter-map value {}'.format(extra_dict))

            if key == 'class-map':
                matched = matched[0][0]
                name_to_log = matched[0][2]
                extra_dict = {
                    matched[0][0]: matched[0][2],
                    'type': matched[0][1],
                    'desc': []
                }
                for match in matched[1:]:
                    # print match
                    temp_dict = dict()
                    if len(match) == 7:
                        temp_dict = {
                            match[1]: match[0],
                            match[2]: match[3],
                            match[4]: match[6]
                        }
                    elif len(match) == 5:
                        temp_dict = {
                            match[1]: match[0],
                            match[2]: match[3],
                            "mask": match[4]
                        }
                    elif len(match) == 6:
                        temp_dict = {
                            match[1]: match[0],
                            match[2]: match[3],
                            match[4]: match[5]
                        }
                    extra_dict['desc'].append(temp_dict)
                LOG.info('parsing: class-map for value : {}'.format(name_to_log))
                # LOG.debug('class-map value {}'.format(extra_dict))

            if key == 'policy-map':
                matched = matched[0][0]
                if len(matched[0]) == 5:
                    extra_dict = {
                        matched[0][1]: matched[0][2],
                        'match': matched[0][3],
                        'name': matched[0][4],
                        'desc': []
                    }
                    name_to_log = matched[0][4]
                else:
                    extra_dict = {
                        matched[0][0]: matched[0][2],
                        'match': matched[0][1],
                        'desc': []
                    }
                    name_to_log = matched[0][2]

                # if name_to_log == 'vs_SVCH1048_http-9118':
                #     print matched
                #     sys.exit(1)

                for match in matched[1:]:
                    temp_dict = dict()
                    temp_dict = {
                        match[0][0]: match[0][1],
                        'class_desc': []
                    }
                    for match1 in match[1:]:
                        temp_dict_1 = dict()
                        if len(match1) == 2:
                            temp_dict_1 = {
                                match1[0]: match1[1]
                            }
                        elif len(match1) == 3:
                            temp_dict_1 = {
                                match1[0]: match1[1],
                                'type': match1[2]
                            }
                        temp_dict['class_desc'].append(temp_dict_1)
                    extra_dict['desc'].append(temp_dict)
                LOG.info('parsing: policy-map for value : {}'.format(name_to_log))
                # LOG.debug('policy-map value {}'.format(extra_dict))

            if key == 'sticky':
                matched = matched[0][0]
                name_to_log = matched[0][5]
                extra_dict = {
                    matched[0][1]: matched[0][2],
                    'name': matched[0][5],
                    'desc': []
                }
                for match in matched[1:]:
                    temp_dict = dict()
                    if len(match) == 2:
                        temp_dict = {
                            match[0]: match[1]
                        }
                    extra_dict['desc'].append(temp_dict)
                LOG.info('parsing: sticky for value : {}'.format(name_to_log))
                # LOG.debug('sticky value {}'.format(extra_dict))

            if key == 'probe':
                matched = matched[0][0]
                name_to_log = matched[0][2]
                extra_dict = {
                    'type': matched[0][1],
                    'name': matched[0][2],
                }
                for match in matched[1:]:
                    temp_dict = dict()
                    if len(match) == 2:
                        temp_dict = {
                            match[0]: match[1]
                        }
                    if len(match) == 4:
                        temp_dict = {
                            'status': match[2],
                            'status1': match[3]
                        }
                    if len(match) == 5:
                        temp_dict = {
                            match[1]: match[2],
                            match[3]: match[4]
                        }
                    extra_dict.update(temp_dict)
                LOG.info('parsing: probe for value : {}'.format(name_to_log))
                # LOG.debug('probe value {}'.format(extra_dict))

            # updating excel sheet
            if key in type_to_log and name_to_log:
                excel_dict['name'] = name_to_log
                excel_dict['type'] = key
                # print key , name_to_log
            
                # print excel_dict
                # sys.exit()
                final_excel.append(excel_dict)

            if key not in final_dict.keys():
                final_dict.update({key: [extra_dict]})
            else:
                final_dict[key].append(extra_dict)

        set_excel_dict(final_excel)
        return final_dict
