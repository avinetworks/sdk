'''
Created on Aug 16, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
'''
import re


def ansible_return(module, rsp, changed):
    """
    :param module: AnsibleModule
    :param rsp: ApiResponse from avi_api
    :param changed: boolean

    helper function to return the right ansible based on the error code and
    changed
    Returns: specific ansible module exit function
    """
    if rsp.status_code > 299:
        return module.fail_json(msg='Error %d Msg %s' % (
            rsp.status_code, rsp.text))
    return module.exit_json(changed=changed, obj=rsp.json())


def purge_optional_fields(obj, module):
    """
    It purges the optional arguments to be sent to the controller.
    :param obj: dictionary of the ansible object passed as argument.
    :param module: AnsibleModule
    return modified obj
    """
    purge_fields = []
    for param, spec in module.argument_spec.iteritems():
        if not spec.get('required', False):
            if param not in obj:
                # these are ansible common items
                continue
            if obj[param] is None:
                purge_fields.append(param)
    for param in purge_fields:
        obj.pop(param, None)
    return obj


def cleanup_absent_fields(obj):
    """
    cleans up any field that is marked as state: absent. It needs to be removed
    from the object if it is present.
    """
    if type(obj) != dict:
        return obj
    cleanup_keys = []
    for k, v in obj.iteritems():
        if type(v) == dict:
            if 'state' in v and v['state'] == 'absent':
                cleanup_keys.append(k)
            else:
                cleanup_absent_fields(v)
        if type(v) == list:
            for x in v:
                cleanup_absent_fields(x)
    for k in cleanup_keys:
        del obj[k]
    return obj

RE_REF_MATCH = re.compile('^/api/[\w/]+\?name\=[\w]+[^#<>]*$')

# if HTTP ref match then strip out the #name
HTTP_REF_MATCH = re.compile('https://[\w.0-9:-]+/api/[\w/\?.#&-]*$')


def ref_n_str_cmp(x, y):
    """
    compares two references
    1. check for exact reference
    2. check for obj_type/uuid
    3. check for name

    if x is ref=name then extract uuid and name from y and use it.
    if x is http_ref then
        strip x and y
        compare them.

    if x and y are urls then match with split on #
    if x is a RE_REF_MATCH then extract name
    if y is a REF_MATCH then extract name
    :param x: first string
    :param y: second string from controller's object

    Returns
        True if they are equivalent else False
    """
    if (not isinstance(x, basestring)) or (not isinstance(y, basestring)):
        return False

    y_uuid = y_name = y
    if RE_REF_MATCH.match(x):
        x = x.split('name=')[1]
    elif HTTP_REF_MATCH.match(x):
        x = x.rsplit('#', 1)[0]
        y = y.rsplit('#', 1)[0]
    elif RE_REF_MATCH.match(y):
        y = y.split('name=')[1]

    if HTTP_REF_MATCH.match(y):
        path = y.split('api/', 1)[1]
        _, uuid_or_name = path.split('/')
        parts = uuid_or_name.rsplit('#', 1)
        y_uuid = parts[0]
        y_name = parts[1] if len(parts) > 1 else ''
        # is just string but y is a url so match either uuid or name
    return (x in (y, y_name, y_uuid))


def avi_obj_cmp(x, y):
    """
    compares whether x is fully contained in y. The comparision is different
    from a simple dictionary compare for following reasons
    1. Some fields could be references. The object in controller returns the
        full URL for those references. However, the ansible script would have
        it specified as /api/pool?name=blah. So, the reference fields need
        to match uuid, relative reference based on name and actual reference.

    2. Optional fields with defaults: In case there are optional fields with
        defaults then controller automatically fills it up. This would
        cause the comparison with Ansible object specification to always return
        changed.

    3. Optional fields without defaults: This is most tricky. The issue is
        how to specify deletion of such objects from ansible script. If the
        ansible playbook has object specified as Null then Avi controller will
        reject for non Message(dict) type fields. In addition, to deal with the
        defaults=null issue all the fields that are set with None are purged
        out before comparing with Avi controller's version

        So, the solution is to pass state: absent if any optional field needs
        to be deleted from the configuration. The script would return changed
        =true if it finds a key in the controller version and it is marked with
        state: absent in ansible playbook. Alternatively, it would return
        false if key is not present in the controller object. Before, doing
        put or post it would purge the fields that are marked state: absent.

    :param x: first string
    :param y: second string from controller's object

    Returns:
        True if x is subset of y else False
    """
    if isinstance(x, str):
        # Special handling for strings as they can be references.
        return ref_n_str_cmp(x, y)
    if type(x) not in [list, dict]:
        # if it is not list or dict or string then simply compare the values
        return x == y
    if type(x) == list:
        # should compare each item in the list and that should match
        if len(x) != len(y):
            return False
        for i in zip(x, y):
            if not avi_obj_cmp(i[0], i[1]):
                # no need to continue
                return False
    if type(x) == dict:
        d_xks = [k for k, v in x.iteritems() if not v and
                 (type(v) in (list, dict))]
        for k in d_xks:
            x.pop(k)

        # pop the keys that are marked deleted but not present in y
        # return false if item is marked absent and is present in y
        d_x_absent_ks = []
        for k, v in x.iteritems():
            if ((type(v) == dict) and ('state' in v) and
                    (v['state'] == 'absent')):
                if type(y) == dict and k not in y:
                    d_x_absent_ks.append(k)
                else:
                    return False
        for k in d_x_absent_ks:
            x.pop(k)
        x_keys = set(x.keys())
        y_keys = set(y.keys())
        if not x_keys.issubset(y_keys):
            return False
        for k, v in x.iteritems():
            if k not in y:
                return False
            if not avi_obj_cmp(v, y[k]):
                return False
    return True
