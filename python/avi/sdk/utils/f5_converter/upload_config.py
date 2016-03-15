from avi.sdk.avi_api import ApiSession
import json
import logging

LOG = logging.getLogger("converter-log")


def upload_config_to_controller(config_dict, controller_ip,
                                username, password, tenant):
    session = ApiSession.get_session(controller_ip, username,
                                     password=password, tenant=tenant)

    for monitor in config_dict["HealthMonitor"]:
         resp = session.post("healthmonitor", data=json.dumps(monitor))
         if resp.status_code>299:
            LOG.error("Failed to create monitor :" + monitor["name"] + " " +
                      resp.text)
    for ssl_cert in config_dict.get("SSLKeyAndCertificate", []):
        resp = session.post("sslkeyandcertificate/importkeyandcertificate",
                            data=json.dumps(ssl_cert))
        if resp.status_code>299:
            LOG.error("Failed upload cert :" + ssl_cert["name"] + " " +
                      resp.text)

    pools = config_dict["Pool"]
    for pool in pools:
        create_pool(session, pool)

    for vs in config_dict["VirtualService"]:
        pool_obj = None
        if vs["pool_ref"]:
            pool_nmae = vs["pool_ref"]
            pool_obj = session.get_object_by_name("pool", pool_nmae)
            if pool_obj:
                vs["pool_ref"] = session.get_obj_ref(pool_obj)
            else:
                vs["pool_ref"] = None
        cert_names = vs.get("ssl_key_and_certificate_refs", None)
        if cert_names:
            cert_refs = []
            for cert_nmae in cert_names:
                if ":" in cert_nmae:
                    cert_nmae = cert_nmae.split(":")[1]
                cert_obj = session.get_object_by_name("sslkeyandcertificate",
                                           cert_nmae)
                if cert_obj:
                    cert_refs.append(session.get_obj_ref(cert_obj))
                elif not cert_refs:
                    cert_obj = session.get_object_by_name("sslkeyandcertificate",
                                           "System-Default-Cert")
                    cert_refs.append(session.get_obj_ref(cert_obj))
                    LOG.warning("Failed to get cert referance for : " +
                                cert_nmae+" adding System-Default-Cert insted")
            vs["ssl_key_and_certificate_refs"] = cert_refs


        resp = session.post('virtualservice', data=json.dumps(vs))
        if resp.status_code == 400 and "sharing the same pool" in resp.text:
            del pool_obj["uuid"]
            del pool_obj["url"]
            pool_obj["name"] = pool_obj["name"]+"-"+vs["name"]
            pool_obj = create_pool(session, pool_obj)
            if pool_obj:
                vs["pool_ref"] = session.get_obj_ref(pool_obj)
                resp = session.post('virtualservice', data=json.dumps(vs))
            else:
                continue
        elif resp.status_code>299:
            LOG.error("Failed to create vs :"+vs["name"]+" "+resp.text)


def create_pool(session, pool_obj):
    monitors = pool_obj.get("health_monitor_refs", [])
    monitor_refs = []
    for monitor in monitors:
        if ":" in monitor:
            monitor = monitor.split(":")[1]
        monitor_obj = session.get_object_by_name("healthmonitor",
                                                 monitor)
        if monitor_obj:
            monitor_refs.append(session.get_obj_ref(monitor_obj))
        else:
            continue
    if len(monitor_refs)>0:
        pool_obj["health_monitor_refs"] = monitor_refs

    ssl_profile = pool_obj.get("ssl_profile_ref", None)
    if ssl_profile:
        if ":" in ssl_profile:
            ssl_profile = ssl_profile.split(":")[1]
        ssl_profile_obj = session.get_object_by_name("sslprofile",
                                                     ssl_profile)
        if ssl_profile_obj:
            pool_obj["ssl_profile_ref"] = session.get_obj_ref(ssl_profile_obj)

    ssl_key = pool_obj.get("ssl_key_and_certificate_ref", None)
    if ssl_key and ":" in ssl_key:
        ssl_key = ssl_key.split(":")[1]
    if ssl_key:
        cert_obj = session.get_object_by_name("sslkeyandcertificate", ssl_key)
        if not cert_obj:
            cert_obj = session.get_object_by_name("sslkeyandcertificate",
                                           "System-Default-Cert")
            LOG.warning("Not found key cert files for Pool :%s "
                        "using System-Default-Cert insted"%pool_obj["name"])
        pool_obj["ssl_key_and_certificate_ref"] = session.get_obj_ref(cert_obj)

    pool = None
    resp = session.post("pool", data=json.dumps(pool_obj))
    if resp.status_code>299:
        LOG.error("Failed to create pool :"+pool_obj["name"]+" "+resp.text)
    else:
        pool = json.loads(resp.text)
    return pool
