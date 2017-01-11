from pyparsing import *
ParserElement.enablePackrat()
import logging
LOG = logging.getLogger(__name__)
import avi.netscaler_converter.ns_util as ns_util


def parse_config_file(filepath):
    EOL = LineEnd().suppress()
    comment = Suppress("#") + Suppress(restOfLine) + EOL
    SOL = LineStart().suppress()
    blank_line = SOL + EOL
    result = []

    hyphen = Literal("-")
    not_hyphen_sign = ''.join(c for c in printables if c != '-')
    text = Word(not_hyphen_sign, printables)
    key = Word('-', printables).setParseAction(
        lambda t: t[0].replace('-', '', 1))
    val = originalTextFor(Optional(ZeroOrMore(text), default=None))
    option = Group(key + val)
    command = Group(OneOrMore(text) + ZeroOrMore(option))
    command.ignore(comment | blank_line)
    with open(filepath) as infile:
        for line in infile:
            try:
               tmp = command.parseString(line)
               result += tmp.asList()
            except:
                LOG.error("Parsing error:"+line)
        return result


def get_command(line):
    commands = ['add server', 'add service', 'add lb vserver',
                'bind lb vserver', 'add lb monitor', 'bind service',
                'bind serviceGroup', 'add serviceGroup', 'add ns tcpProfile',
                'add ns httpProfile', 'bind ssl vserver', 'add ssl certKey',
                'set ssl vserver', 'add ssl profile', 'add cs vserver',
                'bind cs vserver', 'bind cs policylabel', 'add cs policy',
                'add_cs_policylabel', 'bind policy patset', 'add policy patset',
                'add dns addRec']
    for command in commands:
        cmd_arr = command.split(' ')
        if line[0: len(cmd_arr)] == cmd_arr:
            return command, len(cmd_arr)
    cmd = ns_util.get_command_from_line(line)
    LOG.debug("Command not supported : %s" % cmd)
    return cmd, None


def get_ns_conf_dict(filepath):
    LOG.debug('Started parsing netscaler config file')
    netscaler_conf = dict()
    skipped_cmds = []
    try:
        result = parse_config_file(filepath)
        for line in result:
            cmd, offset = get_command(line)
            if offset:
                cmd_dict = dict()
                attr_list = []
                key = line[offset]
                line = line[offset:]
                for token in line:
                    if isinstance(token, list):
                        if token[0] == "invoke" and 'policylabel' in token[1] and cmd == "bind cs policylabel":
                            policyLabel = token[1].split(' ')
                            cmd_dict.update({token[0]: policyLabel[1]})
                        elif token[0] == "invoke" and 'policylabel' in token[1] and cmd == "bind cs vserver":
                            policyLabel = token[1].split(' ')
                            cmd_dict.update({policyLabel[0]: policyLabel[1]})
                        else:
                            cmd_dict.update({token[0]: token[1]})
                    else:
                        attr_list.append(token)
                cmd_dict.update({'attrs':attr_list})
                cmd_list = netscaler_conf.get(cmd, {})
                obj = cmd_list.get(key, None)
                if obj:
                    if isinstance(obj, list):
                        obj.append(cmd_dict)
                    else:
                        obj_list = [obj, cmd_dict]
                        cmd_list.update({key: obj_list})
                else:
                    cmd_list.update({key: cmd_dict})
                netscaler_conf.update({cmd: cmd_list})
            else:
                skipped_cmds.append(cmd)
        LOG.debug('File parsed successfully')
    except:
        LOG.error('Error in parsing the file', exc_info=True)

    return netscaler_conf, skipped_cmds

# if __name__ == "__main__":
#     ns_conf, skipped_cmds = get_ns_conf_dict(
#         "D:\\avi\\NetscalerConverter\\test.conf")
#     print ns_conf