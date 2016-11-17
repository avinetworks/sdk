
def get_sslkeyandcertificate_w_alt_names(api, name, obj=None, tenant='', tenant_uuid='', name_type='DNS'):
    """
    It augments the subject alt names into the sslkeyandcertificate object as due to AV-15174.
    :param name:
    :param obj:
    :param tenant:
    :param tenant_uuid:
    :return:
    """
    if not obj:
        obj = api.get_object_by_name('sslkeyandcertificate', name, tenant=tenant, tenant_uuid=tenant_uuid)
    if 'subject_alt_names' in obj['certificate']:
        # it is already present
        return obj
    # come here if the subject_alt_names is not set
    cert = obj['certificate']['text']
    cl = cert.splitlines()
    alt_entry = [cl[index + 1] for index, l in enumerate(cl)
                 if l.find('X509v3 Subject Alternative Name:') != -1]
    if not alt_entry:
        return obj
    alt_names = [str(name.split('%s:' % name_type)[1].strip()) for name in alt_entry[0].strip().split(',')
                 if name.strip().startswith(name_type)]
    obj['certificate']['subject_alt_names'] = alt_names
    return obj
