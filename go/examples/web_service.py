from flask import Flask, render_template, request
import json
import requests

from flask import jsonify

app = Flask(__name__)

def healthmonitor_filter_response():
    responce = {
        "count": 10,
        "results": [
            {
                "receive_timeout": 4,
                "tenant_ref": "https://10.10.28.71/api/tenant/admin",
                "is_federated": False,
                "name": "System-HTTP",
                "failed_checks": 3,
                "send_interval": 10,
                "http_monitor": {
                    "exact_http_request": False,
                    "http_request": "HEAD / HTTP/1.0",
                    "http_response_code": [
                        "HTTP_2XX",
                        "HTTP_3XX"
                    ]
                },
                "successful_checks": 3,
                "type": "HEALTH_MONITOR_HTTP",
                "uuid": "healthmonitor-9bc3b954-f8b6-4e89-9e6a-db592dd6d78e"
            },
            {
                "https_monitor": {
                    "exact_http_request": False,
                    "http_request": "HEAD / HTTP/1.0",
                    "http_response_code": [
                        "HTTP_2XX",
                        "HTTP_3XX"
                    ]
                },
                "receive_timeout": 4,
                "tenant_ref": "https://10.10.28.71/api/tenant/admin",
                "is_federated": False,
                "name": "System-HTTPS",
                "failed_checks": 3,
                "send_interval": 10,
                "successful_checks": 3,
                "type": "HEALTH_MONITOR_HTTPS",
                "uuid": "healthmonitor-e00db079-a665-45b6-9b6d-ed8dcf081abf"
            },
            {
                "receive_timeout": 4,
                "tenant_ref": "https://10.10.28.71/api/tenant/admin",
                "is_federated": False,
                "name": "System-Ping",
                "failed_checks": 2,
                "send_interval": 10,
                "successful_checks": 2,
                "type": "HEALTH_MONITOR_PING",
                "uuid": "healthmonitor-3886593a-6bab-445c-834c-333cf04b4f56"
            }
        ],
        "next": "https://10.10.28.71/api/healthmonitor/?tenant=admin&page_size=3&page=2"
    }
    return responce

@app.route("/", methods=['POST','GET'])
def main():
    d = {"csrftoken": "DEpq2MIeXMDcn5V5sazJSTghNCtgzdRv	", "sessionid": "mfxw1q6qyftghyl92rq04a3fpqqq0iny"}
    return jsonify(d)

@app.route("/login", methods=['POST','GET'])
def login():
    res = {
        "user_initialized": True,
        "system_config": {
            "url": "/api/systemconfiguration",
            "uuid": "default",
            "_last_modified": "1523857332750138",
            "email_configuration": {
                "from_email": "admin@avicontroller.net",
                "mail_server_port": 25,
                "smtp_type": "SMTP_LOCAL_HOST",
                "mail_server_name": "localhost"
            },
            "global_tenant_config": {
                "se_in_provider_context": True,
                "tenant_access_to_provider_se": True,
                "tenant_vrf": False
            },
            "dns_configuration": {
                "search_domain": ""
            },
            "ssh_hmacs": ["hmac-sha2-512-etm@openssh.com", "hmac-sha2-256-etm@openssh.com", "umac-128-etm@openssh.com", "hmac-sha2-512"],
            "docker_mode": False,
            "snmp_configuration": {
                "version": "SNMP_VER2",
                "sys_contact": "support@avinetworks.com",
                "community": "<sensitive>"
            },
            "portal_configuration": {
                "use_uuid_from_input": False,
                "redirect_to_https": True,
                "sslprofile_ref": "/api/sslprofile/sslprofile-2ddfaff4-ce10-481c-b134-8849614f3159",
                "sslkeyandcertificate_refs": ["/api/sslkeyandcertificate/sslkeyandcertificate-865b7e54-3aaf-4f7d-ac27-55d53a605abc", "/api/sslkeyandcertificate/sslkeyandcertificate-4913d6d9-2c2c-4964-9d25-e0d7063da264"],
                "enable_clickjacking_protection": True,
                "enable_https": True,
                "disable_remote_cli_shell": False,
                "password_strength_check": False,
                "enable_http": True,
                "allow_basic_authentication": False
            },
            "ntp_configuration": {
                "ntp_servers": [{
                    "server": {
                        "type": "DNS",
                        "addr": "0.us.pool.ntp.org"
                    }
                }, {
                    "server": {
                        "type": "DNS",
                        "addr": "1.us.pool.ntp.org"
                    }
                }, {
                    "server": {
                        "type": "DNS",
                        "addr": "2.us.pool.ntp.org"
                    }
                }, {
                    "server": {
                        "type": "DNS",
                        "addr": "3.us.pool.ntp.org"
                    }
                }]
            },
            "ssh_ciphers": ["aes128-ctr", "aes256-ctr", "arcfour256", "arcfour128"],
            "default_license_tier": "ENTERPRISE_18"
        },
        "controller": {
            "api_idle_timeout": 15
        },
        "version": {
            "Product": "controller",
            "Version": "17.2.8",
            "build": 9022,
            "Tag": "17.2.8-9022-20180329.172906",
            "Date": "2018-03-29T17:29:06+00:00",
            "min_version": 15.2,
            "ProductName": "Avi Cloud Controller"
        },
        "user": {
            "username": "admin",
            "name": "admin",
            "is_superuser": True,
            "full_name": "System Administrator",
            "ui_property": "{\"defaultTimeframe\":\"6h\",\"valuesToDisplay\":\"avg\",\"sideRailOpen\":true,\"logs\":{\"savedSearch\":[],\"sidebarActiveTab\":\"1\"},\"appDashboard\":{\"viewType\":\"list\"},\"grid\":{\"pageSize\":30}}",
            "local": True,
            "email": "",
            "default_tenant_ref": "https://10.10.28.91/api/tenant/admin#admin"
        },
        "tenants": [{
            "url": "https://10.10.28.91/api/tenant/admin#admin",
            "uuid": "admin",
            "name": "admin",
            "local": True
        }, {
            "url": "https://10.10.28.91/api/tenant/tenant-ddf3c372-3b94-4235-9745-246e10fbafbc#avinetworks",
            "uuid": "tenant-ddf3c372-3b94-4235-9745-246e10fbafbc",
            "name": "avinetworks",
            "_last_modified": "1523857471333603",
            "config_settings": {
                "se_in_provider_context": True,
                "tenant_access_to_provider_se": True,
                "tenant_vrf": False
            },
            "local": True
        }, {
            "url": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
            "uuid": "tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f",
            "name": "webapp",
            "_last_modified": "1523857474301593",
            "config_settings": {
                "se_in_provider_context": True,
                "tenant_access_to_provider_se": True,
                "tenant_vrf": False
            },
            "local": True
        }]
    }
    return jsonify(res)


@app.route("/api/initial-data", methods=['POST','GET'])
def index():
    d = {
        "current_time": "2018-04-11T13:55:18.725859+00:00",
        "setup_failed": False,
        "email_configuration_is_set": True,
        "error_message": "",
        "user_initial_setup": False,
        "sso": False,
        "version": {
            "Product": "controller",
            "Version": "17.2.8",
            "build": 9022,
            "Tag": "17.2.8-9022-20180329.172906",
            "Date": "2018-03-29T17:29:06+00:00",
            "min_version": 15.2,
            "ProductName": "Avi Cloud Controller"
        },
        "sso_logged_in": False,
        "banner": ""
    }
    return jsonify(d)

@app.route("/api/cloud", methods=['POST'])
def create_cloud():
    res = {
        "url": "https://10.10.28.91/api/cloud/cloud-6f0e7fad-4f60-4b20-b11f-69c39a88022c#Default-Cloud",
        "uuid": "cloud-6f0e7fad-4f60-4b20-b11f-69c39a88022c", "name": "Default-Cloud",
        "tenant_ref": "https://10.10.28.91/api/tenant/admin#admin", "dhcp_enabled": False,
        "vtype": "CLOUD_NONE", "license_tier": "ENTERPRISE_18", "enable_vip_static_routes": False,
        "state_based_dns_registration": True, "prefer_static_routes": False, "license_type": "LIC_CORES", "apic_mode": False,
        "mtu": 1500
    }
    return json.dumps(res)


@app.route("/api/cloud", methods=['GET'])
def get_cloud():
    res = {
        "count": 1,
        "results": [
            {
                "vtype": "CLOUD_NONE",
                "license_tier": "ENTERPRISE_18",
                "_last_modified": "1523857464132583",
                "enable_vip_static_routes": False,
                "url": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb",
                "tenant_ref": "https://10.10.28.91/api/tenant/admin",
                "uuid": "cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb",
                "dhcp_enabled": False,
                "prefer_static_routes": False,
                "license_type": "LIC_CORES",
                "mtu": 1300,
                "apic_mode": False,
                "state_based_dns_registration": True,
                "name": "Test-vcenter-cloud"
            }
        ]
    }
    return json.dumps(res)

@app.route("/api/tenant", methods=['POST'])
def tenant1():
    data = request.get_json(force=True)
    if data['name'] == 'avinetworks':
        d = {
            "url": "https://10.10.28.91/api/tenant/tenant-528473ea-d6a6-40e9-b1dc-2ab4617d8101#avinetworks",
            "uuid": "tenant-528473ea-d6a6-40e9-b1dc-2ab4617d8101",
            "name": "avinetworks",
            "_last_modified": "1523616109131728",
            "config_settings": {
                "se_in_provider_context": True,
                "tenant_access_to_provider_se": True,
                "tenant_vrf": False
            },
            "local": True
        }
        return json.dumps(d)
    else:
        d = {
            "url": "https://10.10.28.91/api/tenant/tenant-f38b305a-b5a5-4dc1-943d-450c052713c4#webapp",
            "uuid": "tenant-f38b305a-b5a5-4dc1-943d-450c052713c4",
            "name": "admin",
            "_last_modified": "1523616112381490",
            "config_settings": {
                "se_in_provider_context": True,
                "tenant_access_to_provider_se": False,
                "tenant_vrf": False
            },
            "local": True
        }
        return json.dumps(d)

@app.route("/api/healthmonitor", methods=['POST'])
def create_healthmonitor():
    data = request.get_json(force=True)
    if data['name'] == "Test-Hm":
        res = {
            "url": "https://10.10.28.91/api/healthmonitor/healthmonitor-d1f13516-0f2f-4318-9286-c3ee978eac40#Test-Healthmonitor",
            "uuid": "healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a",
            "name": "Test-Hm",
            "is_federated": False,
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-f38b305a-b5a5-4dc1-943d-450c052713c4#webapp",
            "_last_modified": "1523616122171852",
            "receive_timeout": 2,
            "failed_checks": 2,
            "send_interval": 3,
            "http_monitor": {
                "exact_http_request": False,
                "http_request": "HEAD / HTTP/1.0",
                "http_response_code": ["HTTP_3XX"]
            },
            "successful_checks": 10,
            "type": "HEALTH_MONITOR_HTTP"
        }
        return jsonify(res)
    else:
        res = {
            "url": "https://10.10.28.91/api/healthmonitor/healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a#Test-Healthmonitor",
            "uuid": "healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a",
            "name": "Test-Hm",
            "is_federated": False,
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
            "_last_modified": "1523857484277433",
            "receive_timeout": 3,
            "failed_checks": 2,
            "send_interval": 4,
            "http_monitor": {
                "exact_http_request": False,
                "http_request": "HEAD / HTTP/1.0",
                "http_response_code": ["HTTP_3XX"]
            },
            "successful_checks": 10,
            "type": "HEALTH_MONITOR_HTTP"
        }
        return jsonify(res)

@app.route("/api/tenant", methods=['GET'])
def get_tenant():
    data = {
        "count": 1,
        "results": [
            {
                "_last_modified": "1524030682894729",
                "url": "https://10.10.28.91/api/tenant/tenant-0e125e6b-a6a5-4a36-9d95-5e350844de2e",
                "uuid": "tenant-0e125e6b-a6a5-4a36-9d95-5e350844de2e",
                "name": "avinetworks",
                "local": True,
                "config_settings": {
                    "se_in_provider_context": True,
                    "tenant_access_to_provider_se": True,
                    "tenant_vrf": False
                }
            }
        ]
    }
    return jsonify(data)

@app.route("/api/healthmonitor", methods=['GET'])
def get_healthmonitor():
    if 'page' and 'page_size' and 'page' in request.args and 'name' not in request.args:
        resp = healthmonitor_filter_response()
        return jsonify(resp)
        exit
    elif 'name' in request.args:
        res = {
            "count": 1,
            "results": [
                {
                    "uuid": "healthmonitor-2f9f1fed-2ef4-4b0d-a422-dee1b75e34d2",
                    "receive_timeout": 2,
                    "_last_modified": "1523889827791133",
                    "url": "https://10.10.28.91/api/healthmonitor/healthmonitor-2f9f1fed-2ef4-4b0d-a422-dee1b75e34d2",
                    "tenant_ref": "https://10.10.28.91/api/tenant/admin",
                    "is_federated": False,
                    "failed_checks": 2,
                    "send_interval": 3,
                    "http_monitor": {
                    "exact_http_request": False,
                    "http_request": "HEAD / HTTP/1.0",
                    "http_response_code": [
                    "HTTP_3XX"
                    ]
                    },
                    "successful_checks": 10,
                    "type": "HEALTH_MONITOR_HTTP",
                    "name": "Test-Hm"
                }
            ]
        }
        return json.dumps(res)

@app.route("/api/healthmonitor/healthmonitor-2f9f1fed-2ef4-4b0d-a422-dee1b75e34d2", methods=['PUT'])
def get_name():
    res = {
            "url": "https://10.10.28.91/api/healthmonitor/healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a#Test-Healthmonitor",
            "uuid": "healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a",
            "name": "Test-Healthmonitor",
            "is_federated": False,
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
            "_last_modified": "1523857484277433",
            "receive_timeout": 3,
            "failed_checks": 2,
            "send_interval": 4,
            "http_monitor": {
                "exact_http_request": False,
                "http_request": "HEAD / HTTP/1.0",
                "http_response_code": ["HTTP_3XX"]
            },
            "successful_checks": 10,
            "type": "HEALTH_MONITOR_HTTP"
        }

    return jsonify(res)

@app.route("/api/applicationpersistenceprofile", methods=['POST'])
def create_applicationPersistenceprofile():
    responce = {
        "url": "https://10.10.28.91/api/applicationpersistenceprofile/applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c#Test-Persistece-Profile",
        "uuid": "applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c",
        "name": "Test-Persistece-Profile",
        "is_federated": False,
        "tenant_ref": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
        "_last_modified": "1523857490818997",
        "persistence_type": "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS",
        "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
        "ip_persistence_profile": {
            "ip_persistent_timeout": 5
        }
    }
    return jsonify(responce)


@app.route("/api/applicationpersistenceprofile", methods=['GET'])
def get_applicationPersistenceprofile():
    responce = {
        "count": 1,
        "results": [
            {
                "_last_modified": "1523947144759552",
                "name": "Test-Persistece-Profile",
                "url": "https://10.10.28.91/api/applicationpersistenceprofile/applicationpersistenceprofile-15e02603-ada0-4ce3-9840-38bf35f673e7",
                "tenant_ref": "https://10.10.28.91/api/tenant/admin",
                "is_federated": False,
                "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
                "persistence_type": "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS",
                "ip_persistence_profile": {
                "ip_persistent_timeout": 5
                },
                "uuid": "applicationpersistenceprofile-15e02603-ada0-4ce3-9840-38bf35f673e7"
            }
        ]
    }
    return jsonify(responce)

@app.route("/api/sslprofile", methods=['POST'])
def create_sslprofile():
    responce = {
        "url": "https://10.10.28.91/api/sslprofile/sslprofile-f5af46be-ef2e-4e88-9ce3-8eeb4b056485#Test-Ssl-Profile",
        "uuid": "sslprofile-f5af46be-ef2e-4e88-9ce3-8eeb4b056485",
        "name": "Test-Ssl-Profile",
        "tenant_ref": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
        "_last_modified": "1523857492193849",
        "ssl_session_timeout": 86400,
        "accepted_ciphers": "ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-SHA:ECDHE-ECDSA-AES256-SHA:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES128-SHA256:ECDHE-ECDSA-AES256-SHA384:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:DES-CBC3-SHA",
        "prefer_client_cipher_ordering": True,
        "accepted_versions": [{
            "type": "SSL_VERSION_TLS1"
        }],
        "enable_ssl_session_reuse": True,
        "send_close_notify": True,
        "ssl_rating": {
            "performance_rating": "SSL_SCORE_AVERAGE",
            "security_score": "100.0",
            "compatibility_rating": "SSL_SCORE_AVERAGE"
        },
        "dhparam": "-----BEGIN DH PARAMETERS-----\nMIIBCAKCAQEAohUmEGbnPo1dxqvGg7zslnKTZAPPNnE7l1SdTbuPbsYF83J+VDkE\npUorADcUydwdPM9nTLEk4qKGnNsbt0S+WXf6EcP0oa+rjRFXsvb4B+tD4VHGmtDA\n/iivo51hKu93xaoS0xe9TjI9ZZBcirzyz3V55u/OICgNwRM6nL/Fxx3RXG3LGHP4\nJF73p/kR5cNB9ebYuKYaEzkTOg6pmCyguBEBdg40br+I59rQLgzn2WMRb1bZRUzy\nqSIIAMyok9/bsaxyCCsgVzkTPTtlYM9ooJzSGarlNaBhP3AerMdCV6rAQFYfP9vw\nKvbiJcx+IEdHViJLl2LAFl/gYxOnIBHAswIBAg==\n-----END DH PARAMETERS-----\n",
        "type": "SSL_PROFILE_TYPE_APPLICATION"
    }
    return jsonify(responce)

@app.route("/api/sslprofile", methods=['GET'])
def get_sslprofile():
    responce = {
        "count": 1,
        "results": [
            {
                "ssl_session_timeout": 86400,
                "accepted_ciphers": "ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-SHA:ECDHE-ECDSA-AES256-SHA:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES128-SHA256:ECDHE-ECDSA-AES256-SHA384:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:DES-CBC3-SHA",
                "prefer_client_cipher_ordering": False,
                "_last_modified": "1523947146240811",
                "url": "https://10.10.28.91/api/sslprofile/sslprofile-820ef5cc-7a02-4c9c-8a9f-f795b3e457d9",
                "tenant_ref": "https://10.10.28.91/api/tenant/admin",
                "accepted_versions": [
                    {
                        "type": "SSL_VERSION_TLS1"
                    }
                ],
                "uuid": "sslprofile-820ef5cc-7a02-4c9c-8a9f-f795b3e457d9",
                "enable_ssl_session_reuse": True,
                "send_close_notify": True,
                "type": "SSL_PROFILE_TYPE_APPLICATION",
                "dhparam": "-----BEGIN DH PARAMETERS----- MIIBCAKCAQEAohUmEGbnPo1dxqvGg7zslnKTZAPPNnE7l1SdTbuPbsYF83J+VDkE pUorADcUydwdPM9nTLEk4qKGnNsbt0S+WXf6EcP0oa+rjRFXsvb4B+tD4VHGmtDA /iivo51hKu93xaoS0xe9TjI9ZZBcirzyz3V55u/OICgNwRM6nL/Fxx3RXG3LGHP4 JF73p/kR5cNB9ebYuKYaEzkTOg6pmCyguBEBdg40br+I59rQLgzn2WMRb1bZRUzy qSIIAMyok9/bsaxyCCsgVzkTPTtlYM9ooJzSGarlNaBhP3AerMdCV6rAQFYfP9vw KvbiJcx+IEdHViJLl2LAFl/gYxOnIBHAswIBAg== -----END DH PARAMETERS----- ",
                "ssl_rating": {
                    "compatibility_rating": "SSL_SCORE_AVERAGE",
                    "security_score": "100.0",
                    "performance_rating": "SSL_SCORE_AVERAGE"
                },
                "name": "Test-Ssl-Profile"
            }
        ]
    }
    return jsonify(responce)



@app.route("/api/pool", methods=['POST','GET'])
def create_pool():
    responce = {
        "url": "https://10.10.28.91/api/pool/pool-53d52b3c-d36d-4136-8ad4-9d217956e205#my-test-pool",
        "uuid": "pool-53d52b3c-d36d-4136-8ad4-9d217956e205",
        "name": "my-test-pool",
        "server_count": 1,
        "enabled": True,
        "tenant_ref": "https://10.10.28.91/api/tenant/tenant-ddf3c372-3b94-4235-9745-246e10fbafbc#avinetworks",
        "cloud_ref": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb#Test-vcenter-cloud",
        "_last_modified": "1523857507950253",
        "lb_algorithm": "LB_ALGORITHM_LEAST_CONNECTIONS",
        "use_service_port": False,
        "server_auto_scale": False,
        "host_check_enabled": False,
        "rewrite_host_header_to_sni": False,
        "capacity_estimation": False,
        "servers": [{
            "ratio": 1,
            "ip": {
                "type": "V4",
                "addr": "10.90.20.12"
            },
            "hostname": "10.90.20.12",
            "enabled": True,
            "verify_network": False,
            "static": False,
            "resolve_server_by_dns": False,
            "rewrite_host_header": False
        }],
        "fewest_tasks_feedback_delay": 10,
        "rewrite_host_header_to_server_name": True,
        "lookup_server_by_name": False,
        "lb_algorithm_core_nonaffinity": 2,
        "vrf_ref": "https://10.10.28.91/api/vrfcontext/vrfcontext-2687e8a8-7e2c-40cd-a5aa-48e1893481be#global",
        "application_persistence_profile_ref": "https://10.10.28.91/api/applicationpersistenceprofile/applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c#Test-Persistece-Profile",
        "inline_health_monitor": True,
        "default_server_port": 80,
        "request_queue_depth": 128,
        "graceful_disable_timeout": 1,
        "sni_enabled": True,
        "request_queue_enabled": False,
        "max_concurrent_connections_per_server": 0,
        "health_monitor_refs": ["https://10.10.28.91/api/healthmonitor/healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a#Test-Healthmonitor"],
        "connection_ramp_duration": 10,
        "application_persistence_profile_ref_data": {
            "uuid": "applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c",
            "persistence_type": "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS",
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-9d97ae61-950e-4c1b-ac8b-567d82b8311f#webapp",
            "is_federated": False,
            "server_hm_down_recovery": "HM_DOWN_PICK_NEW_SERVER",
            "url": "https://10.10.28.91/api/applicationpersistenceprofile/applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c#Test-Persistece-Profile",
            "ip_persistence_profile": {
                "ip_persistent_timeout": 5
            },
            "name": "Test-Persistece-Profile"
        }
    }
    return jsonify(responce)

@app.route("/api/virtualservice", methods=['POST','GET'])
def create_virtualservice():
    responce = {
        "url": "https://10.10.28.91/api/virtualservice/virtualservice-e5d922ed-1392-4c2d-80d7-0cea5bc378a3#Test-vs",
        "uuid": "virtualservice-e5d922ed-1392-4c2d-80d7-0cea5bc378a3",
        "name": "Test-vs",
        "enabled": True,
        "application_profile_ref": "https://10.10.28.91/api/applicationprofile/applicationprofile-053aaf82-24d2-4e59-95e4-760e8954d963#System-HTTP",
        "se_group_ref": "https://10.10.28.91/api/serviceenginegroup/serviceenginegroup-f32c5b36-5984-40e8-a86c-096e8c4d32af#Default-Group",
        "vrf_context_ref": "https://10.10.28.91/api/vrfcontext/vrfcontext-2687e8a8-7e2c-40cd-a5aa-48e1893481be#global",
        "analytics_profile_ref": "https://10.10.28.91/api/analyticsprofile/analyticsprofile-badbc9ce-8585-43aa-821d-45716e72d01c#System-Analytics-Profile",
        "tenant_ref": "https://10.10.28.91/api/tenant/tenant-ddf3c372-3b94-4235-9745-246e10fbafbc#avinetworks",
        "cloud_ref": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb#Test-vcenter-cloud",
        "vsvip_ref": "https://10.10.28.91/api/vsvip/vsvip-b1ccce54-974c-4573-b363-a5dd23a9d451#vsvip-aherrE",
        "_last_modified": "1523857513193459",
        "network_profile_ref": "https://10.10.28.91/api/networkprofile/networkprofile-0d027197-0131-4496-89cd-b506877f255c#System-TCP-Proxy",
        "weight": 1,
        "flow_dist": "LOAD_AWARE",
        "delay_fairness": False,
        "vip": [{
            "vip_id": "myvip",
            "avi_allocated_fip": False,
            "auto_allocate_ip": False,
            "enabled": True,
            "auto_allocate_floating_ip": False,
            "avi_allocated_vip": False,
            "ip_address": {
                "type": "V4",
                "addr": "10.90.20.52"
            }
        }],
        "cloud_type": "CLOUD_NONE",
        "scaleout_ecmp": False,
        "max_cps_per_client": 0,
        "traffic_enabled": True,
        "type": "VS_TYPE_NORMAL",
        "bulk_sync_kvcache": False,
        "use_bridge_ip_as_vip": False,
        "active_standby_se_tag": "ACTIVE_STANDBY_SE_1",
        "use_vip_as_snat": False,
        "services": [{
            "enable_ssl": False,
            "port_range_end": 80,
            "port": 80
        }, {
            "enable_ssl": False,
            "port_range_end": 443,
            "port": 443
        }],
        "pool_ref": "https://10.10.28.91/api/pool/pool-53d52b3c-d36d-4136-8ad4-9d217956e205#my-test-pool",
        "ign_pool_net_reach": False,
        "east_west_placement": False,
        "limit_doser": False,
        "ssl_sess_cache_avg_size": 1024,
        "enable_autogw": True,
        "remove_listening_port_on_vs_down": False,
        "close_client_conn_on_config_update": False,
        "flow_label_type": "NO_LABEL",
        "vip_runtime": [{
            "num_additional_se": 0,
            "vip_id": "myvip",
            "requested_resource": {
                "num_se": 1,
                "num_standby_se": 0
            }
        }],
        "tls_ticket_key": [{
            "hmac_key": "yeRXvVlB2SzDaZF+du4Wyg==",
            "name": "d3ea53c7-9b22-4bfd-807f-66e27037e117",
            "aes_key": "2uEFgkzrauN//GWZhpAirg=="
        }, {
            "hmac_key": "Rr5zuHyC/dK7gy5O7PVBkA==",
            "name": "a851ff6b-7926-48f3-8770-4707d80d2e68",
            "aes_key": "fXFVcfDWZACLYNjW1EgEKA=="
        }, {
            "hmac_key": "PfY4Cn7TiHEr4vU0a/FTTQ==",
            "name": "a3ae9f3b-46b4-4732-b4f9-64fe2c56cebf",
            "aes_key": "A6S7elkfgHYNJrGSYbY2iw=="
        }],
        "redis_ip": "127.0.0.1",
        "redis_db": 8,
        "version": 9,
        "redis_port": 5023,
        "network_profile_ref_data": {
            "profile": {
                "tcp_proxy_profile": {
                    "receive_window": 64,
                    "time_wait_delay": 2000,
                    "cc_algo": "CC_ALGO_NEW_RENO",
                    "nagles_algorithm": False,
                    "max_syn_retransmissions": 8,
                    "ignore_time_wait": False,
                    "use_interface_mtu": True,
                    "idle_connection_type": "KEEP_ALIVE",
                    "aggressive_congestion_avoidance": False,
                    "idle_connection_timeout": 600,
                    "max_retransmissions": 8,
                    "automatic": True,
                    "ip_dscp": 0
                },
                "type": "PROTOCOL_TYPE_TCP_PROXY"
            },
            "url": "https://10.10.28.91/api/networkprofile/networkprofile-0d027197-0131-4496-89cd-b506877f255c#System-TCP-Proxy",
            "tenant_ref": "https://10.10.28.91/api/tenant/admin#admin",
            "uuid": "networkprofile-0d027197-0131-4496-89cd-b506877f255c",
            "name": "System-TCP-Proxy"
        },
        "application_profile_ref_data": {
            "uuid": "applicationprofile-053aaf82-24d2-4e59-95e4-760e8954d963",
            "url": "https://10.10.28.91/api/applicationprofile/applicationprofile-053aaf82-24d2-4e59-95e4-760e8954d963#System-HTTP",
            "type": "APPLICATION_PROFILE_TYPE_HTTP",
            "tenant_ref": "https://10.10.28.91/api/tenant/admin#admin",
            "http_profile": {
                "max_rps_uri": 0,
                "keepalive_header": False,
                "max_rps_cip_uri": 0,
                "x_forwarded_proto_enabled": False,
                "connection_multiplexing_enabled": False,
                "websockets_enabled": True,
                "enable_request_body_buffering": True,
                "hsts_enabled": False,
                "compression_profile": {
                    "compressible_content_ref": "https://10.10.28.91/api/stringgroup/stringgroup-2a9f6a6f-137d-49e1-8eaa-f36f751efce3#System-Compressible-Content-Types",
                    "type": "AUTO_COMPRESSION",
                    "compression": False,
                    "remove_accept_encoding_header": True
                },
                "xff_enabled": True,
                "disable_keepalive_posts_msie6": True,
                "keepalive_timeout": 30000,
                "ssl_client_certificate_mode": "SSL_CLIENT_CERTIFICATE_NONE",
                "http_to_https": False,
                "spdy_enabled": False,
                "respond_with_100_continue": True,
                "client_body_timeout": 30000,
                "httponly_enabled": False,
                "hsts_max_age": 365,
                "max_bad_rps_cip": 0,
                "server_side_redirect_to_https": False,
                "client_max_header_size": 12,
                "client_max_request_size": 48,
                "cache_config": {
                    "min_object_size": 100,
                    "query_cacheable": False,
                    "xcache_header": True,
                    "age_header": True,
                    "enabled": False,
                    "default_expire": 600,
                    "max_cache_size": 0,
                    "heuristic_expire": False,
                    "date_header": True,
                    "aggressive": False,
                    "max_object_size": 4194304,
                    "mime_types_group_refs": ["https://10.10.28.91/api/stringgroup/stringgroup-0c596eae-3b10-4727-bd32-d2c48ffabcb0#System-Cacheable-Resource-Types"]
                },
                "max_rps_unknown_uri": 0,
                "ssl_everywhere_enabled": False,
                "spdy_fwd_proxy_mode": False,
                "allow_dots_in_header_name": False,
                "client_header_timeout": 10000,
                "post_accept_timeout": 30000,
                "secure_cookie_enabled": False,
                "max_response_headers_size": 48,
                "xff_alternate_name": "X-Forwarded-For",
                "max_rps_cip": 0,
                "client_max_body_size": 0,
                "enable_fire_and_forget": False,
                "max_rps_unknown_cip": 0,
                "max_bad_rps_cip_uri": 0,
                "max_bad_rps_uri": 0,
                "use_app_keepalive_timeout": False
            },
            "preserve_client_port": False,
            "preserve_client_ip": False,
            "name": "System-HTTP"
        },
        "pool_ref_data": {
            "lb_algorithm": "LB_ALGORITHM_LEAST_CONNECTIONS",
            "use_service_port": False,
            "server_auto_scale": False,
            "host_check_enabled": False,
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-ddf3c372-3b94-4235-9745-246e10fbafbc#avinetworks",
            "rewrite_host_header_to_sni": False,
            "capacity_estimation": False,
            "servers": [{
                "ratio": 1,
                "ip": {
                    "type": "V4",
                    "addr": "10.90.20.12"
                },
                "hostname": "10.90.20.12",
                "enabled": True,
                "verify_network": True,
                "static": False,
                "resolve_server_by_dns": False,
                "rewrite_host_header": False
            }],
            "fewest_tasks_feedback_delay": 10,
            "rewrite_host_header_to_server_name": False,
            "lookup_server_by_name": False,
            "uuid": "pool-53d52b3c-d36d-4136-8ad4-9d217956e205",
            "cloud_ref": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb#Test-vcenter-cloud",
            "lb_algorithm_core_nonaffinity": 2,
            "vrf_ref": "https://10.10.28.91/api/vrfcontext/vrfcontext-2687e8a8-7e2c-40cd-a5aa-48e1893481be#global",
            "application_persistence_profile_ref": "https://10.10.28.91/api/applicationpersistenceprofile/applicationpersistenceprofile-d6a3f83b-b4d1-48ee-a751-9cc3679c816c#Test-Persistece-Profile",
            "inline_health_monitor": True,
            "default_server_port": 80,
            "request_queue_depth": 128,
            "graceful_disable_timeout": 1,
            "server_count": 1,
            "sni_enabled": True,
            "request_queue_enabled": False,
            "name": "my-test-pool",
            "max_concurrent_connections_per_server": 0,
            "url": "https://10.10.28.91/api/pool/pool-53d52b3c-d36d-4136-8ad4-9d217956e205#my-test-pool",
            "enabled": True,
            "health_monitor_refs": ["https://10.10.28.91/api/healthmonitor/healthmonitor-1b17c992-2004-4670-9f05-f267c99fc19a#Test-Healthmonitor"],
            "connection_ramp_duration": 10
        },
        "cloud_ref_data": {
            "vtype": "CLOUD_NONE",
            "license_tier": "ENTERPRISE_18",
            "uuid": "cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb",
            "enable_vip_static_routes": False,
            "url": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb#Test-vcenter-cloud",
            "tenant_ref": "https://10.10.28.91/api/tenant/admin#admin",
            "mtu": 1300,
            "state_based_dns_registration": True,
            "prefer_static_routes": False,
            "license_type": "LIC_CORES",
            "apic_mode": False,
            "dhcp_enabled": False,
            "name": "Test-vcenter-cloud"
        },
        "vsvip_ref_data": {
            "east_west_placement": False,
            "uuid": "vsvip-b1ccce54-974c-4573-b363-a5dd23a9d451",
            "url": "https://10.10.28.91/api/vsvip/vsvip-b1ccce54-974c-4573-b363-a5dd23a9d451#vsvip-aherrE",
            "tenant_ref": "https://10.10.28.91/api/tenant/tenant-ddf3c372-3b94-4235-9745-246e10fbafbc#avinetworks",
            "cloud_ref": "https://10.10.28.91/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb#Test-vcenter-cloud",
            "vip": [{
                "vip_id": "myvip",
                "avi_allocated_fip": False,
                "auto_allocate_ip": False,
                "enabled": True,
                "auto_allocate_floating_ip": True,
                "avi_allocated_vip": True,
                "ip_address": {
                    "type": "V4",
                    "addr": "10.90.20.52"
                }
            }],
            "vrf_context_ref": "https://10.10.28.91/api/vrfcontext/vrfcontext-2687e8a8-7e2c-40cd-a5aa-48e1893481be#global",
            "name": "vsvip-aherrE"
        },
        "shared_vs_refs": []
    }
    return jsonify(responce)

@app.route("/api/cloud/cloud-a1c23bff-deae-4e4b-b530-5fbeb9914adb", methods=['DELETE'])
def delete_cloud():
    data = {}
    return jsonify(data)

@app.route("/api/healthmonitor/healthmonitor-2f9f1fed-2ef4-4b0d-a422-dee1b75e34d2", methods=['DELETE'])
def delete_healthmonitor():
    data = {}
    return jsonify(data)

@app.route("/api/sslprofile/sslprofile-820ef5cc-7a02-4c9c-8a9f-f795b3e457d9", methods=['DELETE'])
def delete_sslprofile():
    data = {}
    return jsonify(data)

@app.route("/api/applicationpersistenceprofile/applicationpersistenceprofile-15e02603-ada0-4ce3-9840-38bf35f673e7", methods=['DELETE'])
def delete_persistenceprofile():
    data = {}
    return jsonify(data)


@app.route("/api/tenant/tenant-0e125e6b-a6a5-4a36-9d95-5e350844de2e", methods=['DELETE'])
def delete_tenant():
    data = {}
    return jsonify(data)

if __name__ == "__main__":
    app.debug = True
    app.run(port=8080, ssl_context='adhoc')

