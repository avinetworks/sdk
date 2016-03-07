from pyparsing import *
import logging

LOG = logging.getLogger("converter-log")


def generate_grammar_v11():
    # define data types that might be in the values
    unquoted_string = Word(alphanums+"!#$%&'()*+,-./:;<=>?@[\]^_`|~")
    quoted_string = quotedString.setParseAction(removeQuotes)
    ltm = Keyword("ltm")
    apm = Keyword("apm")
    auth = Keyword("auth")
    net = Keyword("net")
    sys = Keyword("sys")
    and_kw = Keyword("and")
    empty_object = Keyword("{ }")

    common = Suppress("/Common/")
    comment = Suppress("#") + Suppress(restOfLine)
    BS, LBRACE, RBRACE = map(Suppress, " {}")
    LBRACE_KW = Keyword("{")
    RBRACE_KW = Keyword("}")
    EOL = LineEnd().suppress()
    SOL = LineStart().suppress()
    reserved_words = (ltm | apm | auth | net | sys).suppress()

    ignore = (common | comment)

    entity_type = SOL.suppress()+Optional(reserved_words).suppress()+\
                  unquoted_string
    data = (unquoted_string | quoted_string)

    # define structures
    value = Forward()
    object = Forward()

    property_name = Word(alphanums+"_-.:/")
    property = dictOf(property_name, Optional(value, default=None))
    properties = Dict(property)
    entity_details = (originalTextFor(ZeroOrMore(unquoted_string)))
    entity = Group(entity_type+Group(entity_details+LBRACE +
                                    (property | BS)+RBRACE))
    entities = OneOrMore(entity)

    object << ((LBRACE + properties + RBRACE) | empty_object)
    value << (object | originalTextFor(data +OneOrMore(and_kw+data)) | data)

    dataset = entities.ignore(ignore)
    return dataset

def parse_config(source_str, output_file_path, version = 11):
    grammar = get_grammar_by_version(version)
    result = []
    last_end = 0
    skiped = ""
    source_str = source_str.replace("\t", "    ")
    for tokens, start, end in grammar.scanString(source_str):
        result = result+tokens.asList()
        if last_end != 0:
            skiped = skiped+source_str[last_end:start]
        last_end = end
    LOG.debug("Parsing complete...")
    LOG.info("Parse Unmatched String: "+skiped.replace("\n\n", ""))
    dict = convert_to_dict(result)
    return dict

def get_grammar_by_version(version):
    grammer = None
    if version == 10:
        grammer = generate_grammar_v11()
    elif version == 11:
        grammer = generate_grammar_v11()
    return grammer


def convert_to_dict(result):
    dict = {}
    for item in result:
        # determine the key and value to be inserted into the dict
        dictval = None
        key = None
        if isinstance(item, list):
            try:
                key = item[0].replace("/Common/", "")
                if isinstance(item[1], list):
                    dictval = convert_to_dict(item)
                    if dict.has_key(key):
                        dict[key].update(dictval)
                    else:
                        dict[key] = dictval
                else:
                    if isinstance(item[1], str):
                        dict[key] = item[1].replace("/Common/", "")
                    else:
                        dict[key] = item[1]
            except IndexError:
                dictval = None
                # determine whether to insert the value into the key or to
                # merge the value with existing values at this key
                if key:
                    if key in dict:
                        if isinstance(dict[key], list):
                            dict[key].append(dictval)
                        else:
                            old = dict[key]
                            new = [old]
                            new.append(dictval.replace("/Common/", ""))
                            dict[key] = new
                    else:
                        dict[key] = dictval
    return dict