from avi.sdk.avi_api import ApiSession
import argparse


def get_sslkeyandcertificate_w_alt_names(api, name, obj=None, tenant='', tenant_uuid='',
                                         name_type='DNS'):
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
    alt_names = [str(name.split('%s:' % name_type)[1]) for name in alt_entry[0].strip().split(',')
                 if name.strip().startswith(name_type)]
    obj['certificate']['subject_alt_names'] = alt_names
    return obj


def get_all_sslkeyandcertificate_w_alt_names(api):
    r = api.get('sslkeyandcertificate?page_size=1000').json()
    ssl_certs = r['results']
    for ssl_cert_obj in ssl_certs:
        get_sslkeyandcertificate_w_alt_names(api, ssl_cert_obj['name'], obj=ssl_cert_obj)
    return ssl_certs

if __name__ == '__main__':

    parser = argparse.ArgumentParser()
    parser.add_argument('-u', '--user', help='controller user',
                        default='admin')
    parser.add_argument('-p', '--password', help='controller user password',
                        default='avi123')
    parser.add_argument('-t', '--tenant', help='tenant name',
                        default='admin')
    parser.add_argument('-c', '--controller_ip', help='controller ip')

    args = parser.parse_args()
    api = ApiSession.get_session(args.controller_ip, args.user, args.password,
                                 tenant=args.tenant)

    ssl_certs = get_all_sslkeyandcertificate_w_alt_names(api)
    for ssl_cert in ssl_certs:
        print(ssl_cert['name'])
        print('   Alternate Subject Names:', ssl_cert['certificate'].get('subject_alt_names', []))
