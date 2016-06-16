from pyparsing import *


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
        parse_command).setDebug()
    grammar = OneOrMore(conf_line)
    grammar.ignore(comment | blank_line)
    parsed_str = grammar.parseString(file_str)
    return parsed_str


if __name__ == "__main__":
    result = parse_config_file("D:\\avi\\NetscalerConverter\\qualcom\\ns.conf")
    print result