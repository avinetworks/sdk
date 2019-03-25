#!/usr/bin/python
import os
import sys
import json
from avi.sdk.avi_api import ApiSession
from requests.packages import urllib3

urllib3.disable_warnings()

def switch_priorities(session, pool_uuid, pool_name, retries=5):
    if retries <= 0:
        return 'Too many retry attempts - aborting!'
    query = 'refers_to=pool:%s' % pool_uuid
    pg_result = session.get('poolgroup', params=query)
    if pg_result.count == 0:
        return 'No pool group found referencing pool %s' % pool_name

    pg_obj = pg_result.json()['results'][0]

    highest_up_pool = None
    highest_down_pool = None

    for member in pg_obj['members']:
        priority_label = member['priority_label']
        member_ref = member['pool_ref']
        pool_runtime_url = ('%s/runtime/detail' %
                            member_ref.split('/api/')[1])
        pool_obj = session.get(pool_runtime_url).json()[0]
        if pool_obj['oper_status']['state'] == 'OPER_UP':
            if (not highest_up_pool or
                int(highest_up_pool[1]) < int(priority_label)):
                highest_up_pool = (member, priority_label,
                                   pool_obj['name'])
        elif (not highest_down_pool or
              int(highest_down_pool[1]) < int(priority_label)):
            highest_down_pool = (member, priority_label,
                                 pool_obj['name'])

    if not highest_up_pool:
        return ('No action required as all pools in the '
                'pool group are now down.')
    elif not highest_down_pool:
        return ('No action required as all pools in the '
                'pool group are now up.')

    if int(highest_down_pool[1]) <= int(highest_up_pool[1]):
        return ('No action required. The highest-priority available '
                'pool (%s) already has a higher priority than the '
                'highest-priority non-available pool (%s)' %
                (highest_up_pool[2], highest_down_pool[2]))

    highest_up_pool[0]['priority_label'] = highest_down_pool[1]
    highest_down_pool[0]['priority_label'] = highest_up_pool[1]

    p_result = session.put('poolgroup/%s' % pg_obj['uuid'], pg_obj)
    if p_result.status_code < 300:
        return ', '.join(['Pool %s priority changed to %s' % (p[0], p[1])
                          for p in ((highest_up_pool[2],
                                     highest_down_pool[1]),
                                    (highest_down_pool[2],
                                     highest_up_pool[1]))])
    if p_result.status_code == 412:
        return switch_priorities(session, pool_uuid,
                                 pool_name, retries - 1)

    return 'Error setting pool priority: %s' % p_result.text

def sticky_pool_group():
    token = os.environ.get('API_TOKEN')
    user = os.environ.get('USER')
    tenant = os.environ.get('TENANT')
    alert_dict = json.loads(sys.argv[1])
    events = alert_dict.get('events', [])
    if len(events) > 0:
        pool_uuid = events[0]['obj_uuid']
        pool_name = events[0]['obj_name']
        try:
            with ApiSession("localhost", user,
                            token=token,
                            tenant=tenant) as session:
                result = switch_priorities(session, pool_uuid, pool_name)
        except Exception as e:
            result = str(e)
    else:
        result = 'No event data for ControlScript'

    return result

# Use with a ControlScript to perform 'sticky' failover of pool groups.
#
# Create a ControlScript as follows:
#
# #!/usr/bin/python
#
# from avi.sdk.samples.sticky_pool_group import sticky_pool_group
#
# if __name__ == '__main__':
#   print sticky_pool_group()
#
