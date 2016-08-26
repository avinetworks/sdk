'''
Created on Aug 16, 2016

@author: Gaurav Rastogi (grastogi@avinetworks.com)
'''


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
