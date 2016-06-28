from pyparsing import *
ParserElement.enablePackrat()
import logging
LOG = logging.getLogger(__name__)
def parse_config_file(filepath):
    EOL = LineEnd().suppress()
    comment = Suppress("#") + Suppress(restOfLine) + EOL
    SOL = LineStart().suppress()
    blank_line = SOL + EOL
    result = []

    hyphen = Literal("-")
    not_hyphen_sign = ''.join(c for c in printables if c != '-')
    text = Word(not_hyphen_sign, printables)
    kw_params = SkipTo(hyphen | lineEnd).setParseAction(
        lambda t: t[0].strip())
    option = hyphen.suppress() + Group(
        text + Optional(kw_params, default=None))
    command = Group(OneOrMore(text) + ZeroOrMore(option)).setDebug()
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
    commands = ['add server', 'add service', 'add lb vserver', 'bind lb vserver', 'add lb monitor']
    for command in commands:
        cmd_arr = command.split(' ')
        if line[0: len(cmd_arr)] == cmd_arr:
            return command, len(cmd_arr)
        else:
            LOG.debug("Command not supported : %s" % line)
    return None, None


def get_ns_conf_dict(filepath):
    netscaler_conf = dict()
    result = parse_config_file(filepath)
    for line in result:
        cmd, offset = get_command(line)
        if cmd:
            cmd_dict = dict()
            attr_list = []
            key = line[offset]
            line = line[offset:]
            for token in line:
                if isinstance(token, list):
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
    return netscaler_conf

if __name__ == "__main__":
    ns_conf = get_ns_conf_dict("D:\\avi\\NetscalerConverter\\test.conf")
    print ns_conf