from flask import Flask, render_template, request
import json

from flask import jsonify

app = Flask(__name__)

@app.route("/", methods=['POST','GET'])
def main():
    d = {"csrftoken": "DEpq2MIeXMDcn5V5sazJSTghNCtgzdRv	", "sessionid": "mfxw1q6qyftghyl92rq04a3fpqqq0iny"}
    return jsonify(d)

@app.route("/login", methods=['POST','GET'])
def login():
    d = {"name": "abc"}
    return jsonify(d)


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

@app.route("/api/cloud", methods=['POST','GET'])
def create_cloud():
    res = {"url": "https://10.10.28.91/api/cloud/cloud-6f0e7fad-4f60-4b20-b11f-69c39a88022c#Default-Cloud",
         "uuid": "cloud-6f0e7fad-4f60-4b20-b11f-69c39a88022c", "name": "Default-Cloud",
         "tenant_ref": "https://10.10.28.91/api/tenant/admin#admin", "dhcp_enabled": False,
         "vtype": "CLOUD_NONE", "license_tier": "ENTERPRISE_18", "enable_vip_static_routes": False,
         "state_based_dns_registration": True, "prefer_static_routes": False, "license_type": "LIC_CORES", "apic_mode": False,
         "mtu": 1500}
    return json.dumps(res)


if __name__ == "__main__":
    app.debug = True
    app.run(port=8080, ssl_context='adhoc')
