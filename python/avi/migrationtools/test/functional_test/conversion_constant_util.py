"""
This file contains default profile types and constants.
"""
PROFILES = {'fasthttp': 'APPLICATION_PROFILE_TYPE_HTTP',
            'fastL4': 'APPLICATION_PROFILE_TYPE_L4',
            'dns': 'APPLICATION_PROFILE_TYPE_DNS',
            'http-compression': 'APPLICATION_PROFILE_TYPE_HTTP',
            'http': 'APPLICATION_PROFILE_TYPE_HTTP',
            'web-acceleration': 'APPLICATION_PROFILE_TYPE_HTTP'}

NETWORK_PROFILES = ['PROTOCOL_TYPE_TCP_FAST_PATH',
                    'PROTOCOL_TYPE_TCP_PROXY',
                    'PROTOCOL_TYPE_UDP_FAST_PATH']

SSLPROFILE_VERSIONS = ['SSL_VERSION_TLS1','SSL_VERSION_TLS1_1','SSL_VERSION_TLS1_2']

HEALTH_MONITORS = {'https': 'HEALTH_MONITOR_HTTPS',
                   'tcp': 'HEALTH_MONITOR_TCP',
                   'udp': 'HEALTH_MONITOR_UDP',
                   'http': 'HEALTH_MONITOR_HTTP',
                   'icmp': 'HEALTH_MONITOR_PING',
                   'external': 'HEALTH_MONITOR_EXTERNAL'}


PERSISTENCE_PROFILE_TYPES = {'ssl': 'PERSISTENCE_TYPE_TLS',
                             'cookie': 'PERSISTENCE_TYPE_APP_COOKIE',
                             'source_addr': 'PERSISTENCE_TYPE_CLIENT_IP_ADDRESS'}

APP_PERS_PROF = "application_persistence_profile_ref"
APP_PROF = "application_profile_ref"
NETWORK_PROF = "network_profile_ref"


NS_PERSISTENSE_TYPE = {'COOKIEINSERT': 'PERSISTENCE_TYPE_HTTP_COOKIE',
                       'SOURCEIP': 'PERSISTENCE_TYPE_CLIENT_IP_ADDRESS',
                       'SSLSESSION': 'PERSISTENCE_TYPE_TLS'}