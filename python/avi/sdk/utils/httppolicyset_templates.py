'''
Created on Feb 4, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
'''

class HttpRequestSwitchingRuleTemplate(dict):
    '''
    This provides a simple template for creating http request switching rule
    for most common use case of matching list of tokens and rewriting 
    some optionally

    Example.
    rules = [
        HttpRequestSwitchingRuleTemplate(
            name='Mobile-IDBroker',
            index=11,
            match_strings=['/IDBroker'],
            switching_pool='admin:Mobile-IDBroker-pool:Philadelphia',
            rewrite_tokens=['IDBroker-1.0']),
        HttpRequestSwitchingRuleTemplate(
            name='Mobile-Alert-Staging',
            index=12,
            match_strings=['/alert/staging'],
            switching_pool='admin:Mobile-IDBroker-pool:Philadelphia',
            rewrite_tokens=['AlertManager-1.0']),

    ]
    policyset = {'name': 'HTTP-Policy-Set',
                 'http_request_policy': rules}
    '''
    def __init__(self, name, index, match_strings, switching_pool='',
                 rewrite_tokens=[], match_criteria='CONTAINS',
                 rewrite_start_index=2,
                 vslog=False, keep_query=True):
        self['index'] = index
        self['enable'] = True
        self['name'] = name
        if vslog:
            self['log'] = True

        if rewrite_tokens:
            action = 'rewrite_url_action'
            self[action] = {
                'path': {
                    'tokens': [],
                    'type': 'URI_PARAM_TYPE_TOKENIZED'
                },
            }
            self[action]['query'] = {"keep_query": keep_query}
            for token in rewrite_tokens:
                tokens = self[action]['path']['tokens']
                tokens.append(
                    {'str_value': token, 'type': 'URI_TOKEN_TYPE_STRING'})
            last_token = {"type": "URI_TOKEN_TYPE_PATH",
                          "start_index": rewrite_start_index,
                          "end_index": 65535}
            tokens.append(last_token)
        if switching_pool:
            self['switching_action'] = {
                "action": "HTTP_SWITCHING_SELECT_POOL",
                "status_code": "HTTP_LOCAL_RESPONSE_STATUS_CODE_200",
                "pool_ref": '/api/pool?name=%s' % switching_pool
                #"pool_ref": switching_pool
                }
        if match_strings:
            self['match'] = {
                "path": {
                    "match_case": "INSENSITIVE",
                    "match_str": [],
                    "match_criteria": match_criteria
                }
            }
            mstrings = self['match']['path']['match_str']
            for m in match_strings:
                mstrings.append({'str': m})


class HttpRequestRedirectRuleTemplate(dict):
    '''
    This provides a simple template for creating http request redirect rule
    with redirect
    Eg.
    rules = [
        HttpRequestRedirectRuleTemplate(
            name='Mobile-Alert-Staging',
            index=12,
            match_strings=['/alert/staging'],
            rewrite_tokens=['AlertManager-1.0']),
    ]
    policyset = {'name': 'HTTP-Policy-Set',
                 'http_request_policy': rules}
    '''
    def __init__(self, name, index, match_strings,
                 rewrite_tokens=[], match_criteria='CONTAINS',
                 vslog=False, keep_query=True):
        self['index'] = index
        self['enable'] = True
        self['name'] = name
        if vslog:
            self['log'] = True
        action = 'redirect_action' 
        self[action] = {
            'path': {
                'tokens': [],
                'type': 'URI_PARAM_TYPE_TOKENIZED'
            },
        }
        self[action]['keep_query'] = keep_query
        self[action]['protocol'] = 'HTTPS'
        self[action]['port'] =  {'port': 443} 
        self[action]['status_code'] = "HTTP_REDIRECT_STATUS_CODE_301"

        for token in rewrite_tokens:
            tokens = self[action]['path']['tokens']
            tokens.append(
                {'str_value': token, 'type': 'URI_TOKEN_TYPE_STRING'})
        if match_strings:
            self['match'] = {
                "path": {
                    "match_case": "INSENSITIVE",
                    "match_str": [],
                    "match_criteria": match_criteria
                }
            }
            mstrings = self['match']['path']['match_str']
            for m in match_strings:
                mstrings.append({'str': m})



if __name__ == '__main__':

    rules = [
        HttpRequestSwitchingRuleTemplate(
            name='Mobile-Switching',
            index=11,
            match_strings=['/mobile'],
            switching_pool='admin:Mobile-pool:SanFrancisco',
            rewrite_tokens=['Mobile-1.0']),
        HttpRequestRedirectRuleTemplate(
            name='Mobile-Redirect',
            index=12,
            match_strings=['/alert/staging'],
            rewrite_tokens=['AlertManager-1.0']),

    ]
    policyset = {'name': 'HTTP-Policy-Set',
                 'http_request_policy': rules}

    print(policyset)
