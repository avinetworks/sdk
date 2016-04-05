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
        if resp.status_code > 299:
            LOG.error("Failed to create monitor :" + monitor["name"] + " " +
                      resp.text)

    for string_group in config_dict.get("StringGroup", []):
        resp = session.post("stringgroup", data=json.dumps(string_group))
        if resp.status_code > 299:
            LOG.error("Failed upload stringgroup :" + string_group["name"] +
                      " " + resp.text)

    for ssl_cert in config_dict.get("SSLKeyAndCertificate", []):
        resp = session.post("sslkeyandcertificate/importkeyandcertificate",
                            data=json.dumps(ssl_cert))
        if resp.status_code > 299:
            LOG.error("Failed upload cert :" + ssl_cert["name"] + " " +
                      resp.text)

    for ssl_profile in config_dict.get("SSLProfile", []):
        resp = session.post("sslprofile", data=json.dumps(ssl_profile))
        if resp.status_code > 299:
            LOG.error("Failed upload sslprofile :" + ssl_profile["name"] +
                      " " + resp.text)

    for pki_profile in config_dict.get("PKIProfile", []):
        resp = session.post("pkiprofile", data=json.dumps(pki_profile))
        if resp.status_code > 299:
            LOG.error("Failed upload pkiprofilet :" + pki_profile["name"] +
                      " " + resp.text)

    for app_profile in config_dict.get("ApplicationProfile", []):
        comp_prof = app_profile.get("http_profile", {}).get(
            "compression_profile", None)
        if comp_prof:
            content_ref = comp_prof.get("compressible_content_ref", None)
            if content_ref:
                str_grp = session.get_object_by_name("stringgroup", content_ref)
                str_grp_ref = session.get_obj_ref(str_grp)
                comp_prof["compressible_content_ref"] \
                    = str_grp_ref
        pki_profile = app_profile.get("http_profile", {}).get(
            "pki_profile_ref", None)
        if pki_profile:
            pki_profile_obj = session.get_object_by_name("pkiprofile",
                                                         pki_profile)
            if pki_profile_obj:
                app_profile["http_profile"]["pki_profile_ref"] = \
                    session.get_obj_ref(pki_profile_obj)
        resp = session.post("applicationprofile", data=json.dumps(app_profile))
        if resp.status_code > 299:
            LOG.error("Failed upload applicationprofile :" +
                      app_profile["name"] + " " + resp.text)

    for network_profile in config_dict.get("NetworkProfile", []):
        resp = session.post("networkprofile", data=json.dumps(network_profile))
        if resp.status_code > 299:
            LOG.error("Failed upload networkprofile :" +
                      network_profile["name"] + " " + resp.text)

    for persist_profile in config_dict.get("ApplicationPersistenceProfile", []):
        resp = session.post("applicationpersistenceprofile",
                            data=json.dumps(persist_profile))
        if resp.status_code > 299:
            LOG.error("Failed upload applicationpersistenceprofile :" +
                      persist_profile["name"] + " " + resp.text)

    pools = config_dict["Pool"]
    for pool in pools:
        create_pool(session, pool)

    for vs in config_dict["VirtualService"]:
        if vs["pool_ref"]:
            pool_nmae = vs["pool_ref"]
            pool_obj = session.get_object_by_name("pool", pool_nmae)
            if pool_obj:
                vs["pool_ref"] = session.get_obj_ref(pool_obj)
            else:
                vs["pool_ref"] = None

        network_profile = vs.get("network_profile_ref", None)
        if network_profile:
            network_profile_obj = session.get_object_by_name(
                "networkprofile", network_profile)
            if network_profile_obj:
                vs["network_profile_ref"] = session.get_obj_ref(
                    network_profile_obj)
        cert_names = vs.get("ssl_key_and_certificate_refs", None)
        if cert_names:
            cert_refs = []
            for cert_nmae in cert_names:
                cert_obj = session.get_object_by_name(
                    "sslkeyandcertificate", cert_nmae)
                if cert_obj:
                    cert_refs.append(session.get_obj_ref(cert_obj))
                elif not cert_refs:
                    cert_obj = session.get_object_by_name(
                        "sslkeyandcertificate", "System-Default-Cert")
                    cert_refs.append(session.get_obj_ref(cert_obj))
                    LOG.warning("Failed to get cert referance for : " +
                                cert_nmae+" adding System-Default-Cert insted")
            vs["ssl_key_and_certificate_refs"] = cert_refs

        app_profile = vs["application_profile_ref"]
        app_profile_obj = session.get_object_by_name(
            "applicationprofile", app_profile)
        app_profile_ref = session.get_obj_ref(app_profile_obj)
        vs["application_profile_ref"] = app_profile_ref

        resp = session.post('virtualservice', data=json.dumps(vs))
        if resp.status_code > 299:
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
    if len(monitor_refs) > 0:
        pool_obj["health_monitor_refs"] = monitor_refs

    pool_obj.get("health_monitor_refs", [])

    ssl_profile = pool_obj.get("ssl_profile_ref", None)
    if ssl_profile:
        ssl_profile_obj = session.get_object_by_name("sslprofile", ssl_profile)
        if ssl_profile_obj:
            pool_obj["ssl_profile_ref"] = session.get_obj_ref(ssl_profile_obj)

    pki_profile = pool_obj.get("pki_profile_ref", None)
    if pki_profile:
        pki_profile_obj = session.get_object_by_name("pkiprofile", pki_profile)
        if pki_profile_obj:
            pool_obj["pki_profile_ref"] = session.get_obj_ref(pki_profile_obj)

    persist_profile = pool_obj.get("application_persistence_profile_ref", None)
    if persist_profile:
        persist_profile_obj = session.get_object_by_name(
            "applicationpersistenceprofile", persist_profile)
        if persist_profile_obj:
            pool_obj["application_persistence_profile_ref"] \
                = session.get_obj_ref(persist_profile_obj)

    ssl_key = pool_obj.get("ssl_key_and_certificate_ref", None)
    if ssl_key:
        cert_obj = session.get_object_by_name("sslkeyandcertificate", ssl_key)
        if not cert_obj:
            cert_obj = session.get_object_by_name(
                "sslkeyandcertificate", "System-Default-Cert")
            LOG.warning("Not found key cert files for Pool :%s "
                        "using System-Default-Cert insted" % pool_obj["name"])
        pool_obj["ssl_key_and_certificate_ref"] = session.get_obj_ref(cert_obj)

    pool = None
    resp = session.post("pool", data=json.dumps(pool_obj))
    if resp.status_code > 299:
        LOG.error("Failed to create pool :"+pool_obj["name"]+" "+resp.text)
    else:
        pool = json.loads(resp.text)
    return pool
