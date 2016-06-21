from pyparsing import *
import ast


def parse_config_file(filepath):
    conf_file = open(filepath, "r")
    file_str = conf_file.read()
    EOL = LineEnd().suppress()
    comment = Suppress("#") + Suppress(restOfLine) + EOL
    SOL = LineStart().suppress()
    blank_line = SOL + EOL

    def parse_command(s, loc, tokens):
        not_hyphen_sign = ''.join(c for c in printables if c != '-')
        text = Word(not_hyphen_sign, printables)
        qarg = quotedString.setParseAction(removeQuotes)
        option = Literal("-").suppress() + Group(
            text + Optional((text | qarg), default=None))
        g = Group(OneOrMore(text) + ZeroOrMore(option))
        g.ignore(comment)
        # g = Combine(ZeroOrMore(text),adjacent=False, joinString=" ")
        return g.parseString(tokens[0])

    # line starts, anything follows until EOL, fails on blank lines,
    conf_line = (LineStart() + SkipTo(LineEnd()) + EOL).setParseAction(
        parse_command)
    grammar = OneOrMore(conf_line)
    grammar.ignore(comment | blank_line)
    parsed_str = grammar.parseString(file_str)
    return parsed_str


def get_command(line):
    commands = ['add server', 'add service', 'add lb vserver', 'bind lb vserver']
    for command in commands:
        cmd_arr = command.split(' ')
        if line[0: len(cmd_arr)] == cmd_arr:
            return command, len(cmd_arr)
    return None, None


if __name__ == "__main__":
    netscaler_conf = dict()

    # result = parse_config_file("D:\\avi\\NetscalerConverter\\qualcom\\ns.conf")
    result = parse_config_file("D:\\avi\\NetscalerConverter\\test.conf")
    for line in result:
        cmd, offset = get_command(line)
        if cmd:
            cmd_dict = dict()
            attr_list = []
            key = line[offset]
            line = line[offset:]
            print line
            for token in line:
                if isinstance(token, ParseResults):
                    cmd_dict.update({token[0]: token[1]})
                else:
                    attr_list.append(token)
            cmd_dict.update({'attrs':attr_list})
            cmd_list = netscaler_conf.get(cmd, {})
            cmd_list.update({key:cmd_dict})
            netscaler_conf.update({cmd: cmd_list})
    print netscaler_conf