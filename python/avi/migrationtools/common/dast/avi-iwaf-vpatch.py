#!/usr/bin/env python3

import sys
if sys.version_info < (3, 5):
    sys.stderr.write("python 3.5 or newer is required\n")
    sys.exit(1)

import argparse
import json
from urllib.parse import urlparse
from enum import Enum
import logging
import datetime
import os.path
import xmltodict
import requests
from avi.sdk.avi_api import ApiSession


requests.packages.urllib3.disable_warnings()
AVI_API_VERSION = "18.2.5"
__version__ = "1.0"

logging.basicConfig(level=logging.ERROR)
LOGGER = logging.getLogger(__name__)


def process_args():
    """ Read command line arguments """
    parser = argparse.ArgumentParser(description="""
        Import DAST scan into Avi Format.
        It creates a dedicated PSM group with rules for each vulnerability
        detected by the scanner.""")
    parser.add_argument(dest="filename", help="Name of the file to import")
    parser.add_argument("-c", "--controller", action="store",
                        default="localhost",
                        help="Name or IP of the controller, " +
                        "default is 'localhost'")
    parser.add_argument("-u", "--username", action="store",
                        default="admin",
                        help="Username to login, default is 'admin'")
    parser.add_argument("-p", "--password", action="store",
                        required=True,
                        help='Password for controller access')
    parser.add_argument("-t", "--tenant", action="store",
                        default="admin",
                        help="Tenant to act on, default is 'admin'")
    parser.add_argument("-v", "--verbose", action="store_true",
                        help="Verbose output")
    parser.add_argument("-f", "--force", action="store_true",
                        help="Apply changes to the controller. " +
                        "When this option is not set, the script only " +
                        "prints what it would do")
    args = parser.parse_args()
    return args


class AttackType(Enum):
    """ Attack types. """
    XSS = 1
    SQLI = 2
    OTHER = 3


class Protection:
    """ Actions to take for each attack type.
        Currently we only apply regular expressions to params.
    """

    # the same as in WAF PSM learning
    regexes = {
        "PARAM_XSS": "^[A-Za-z0-9 \t,._/:;|?!@#$%&=-]*$",
        "PARAM_SQLI": "^[A-Za-z0-9_:/?!@#&=+-]*$",
        "PARAM_SAFE_TEXT": "^[A-Za-z0-9 ._:,!?+*=@#\t-]*$",
    }

    # which regex to use for an attack type
    protection = {
        AttackType.XSS: "PARAM_XSS",
        AttackType.SQLI: "PARAM_SQLI",
        AttackType.OTHER: "PARAM_SAFE_TEXT"
    }

    @classmethod
    def get_regex_for(cls, attack_type):
        """ Given attack type enum value return a regex to be used
        in PSM rule. """
        return cls.regexes[cls.protection[attack_type]]


class QualysWebXmlInputHandler:
    """ Class responsible for reading Qualys Webapp file format """

    input_type = "qualysweb"
    # map of qualys GROUP to AttackType enu,
    vtypes = {"XSS": AttackType.XSS,
              "SQL": AttackType.SQLI}

    @classmethod
    def vtype2avi(cls, group):
        """ Given GROUP return an AttackType enum value. """
        if group not in cls.vtypes:
            return AttackType.OTHER
        return cls.vtypes[group]

    def handle(self, xmldict):
        """ Read vulnerability data from xmldict.
            Returns a mapping of URL to list of vulnerabilities
            detected at this URL.
        """
        vulnerability_data = {}
        qualys_types = {}
        qualys_glossary_titles = {}

        # glossary is a dict qid -> string
        # e.g. 150003 -> SQL Injection
        # Some of the QIDs belong to a group, like XSS or SQL, others not.
        qids = xmldict.get("WAS_SCAN_REPORT", {}).get("GLOSSARY", {}).get(
            "QID_LIST", {}).get("QID")
        if not qids:
            LOGGER.error("Failed to find vulnerabilities glossary")
            return vulnerability_data
        for qid in qids:
            if "GROUP" in qid:
                qualys_types[qid["QID"]] = qid["GROUP"]
            else:
                qualys_types[qid["QID"]] = qid["TITLE"]
            qualys_glossary_titles[qid["QID"]] = qid["TITLE"]

        node = xmldict.get("WAS_SCAN_REPORT", {}).get("RESULTS", {}).get(
            "VULNERABILITY_LIST", {}).get("VULNERABILITY")
        if not node:
            LOGGER.error("Failed to find scan result data")
            return vulnerability_data
        for vuln in node:
            if not vuln.get("PARAM"):
                continue
            val = {}
            val["param"] = vuln["PARAM"]
            val["id"] = vuln.get("ID", "")
            qid = vuln.get("QID", "")
            val["qid"] = qid
            val["attack_type"] = self.vtype2avi(qualys_types[qid])
            val["description"] = qualys_glossary_titles[qid]
            try:
                url = urlparse(vuln["URL"]).path
                if not url:
                    raise ValueError("Path not found")
                vulnerability_data.setdefault(url, []).append(val)
            except ValueError as exc:
                vuln_id = "NONE" if "ID" not in vuln else vuln["ID"]
                LOGGER.warning("Failed to process vulnerability '%s': %s",
                               vuln_id, exc)
        return vulnerability_data


class ZapXmlInputHandler:
    """ Class responsible for reading ZAP file format """

    input_type = "zap"

    @staticmethod
    def vtype2avi(alert):
        """ Given 'alert' XML node return an AttackType enum value. """
        if "Cross Site Scripting" in alert:
            return AttackType.XSS
        elif "SQL Injection" in alert:
            return AttackType.SQLI
        else:
            return AttackType.OTHER

    def handle(self, xmldict):
        """ Read vulnerability data from xmldict.
            Returns a mapping of URL to list of vulnerabilities
            detected at this URL.
        """
        vulnerability_data = {}
        node = xmldict.get("OWASPZAPReport", {}).get("site", {}).get(
            "alerts", {}).get("alertitem")
        if not node:
            LOGGER.error("Failed to find scan result data")
            return vulnerability_data

        for vuln in node:
            if not vuln.get("param"):
                continue
            val = {}
            val["param"] = vuln["param"]
            val["attack_type"] = self.vtype2avi(vuln.get("alert", ""))
            val["description"] = vuln.get("alert", "")
            try:
                url = urlparse(vuln["uri"]).path
                if not url:
                    raise ValueError("Path not found")
                vulnerability_data.setdefault(url, []).append(val)
            except ValueError as exc:
                LOGGER.warning("Failed to process vulnerability for '%s': %s",
                               vuln["param"], exc)
        return vulnerability_data


def save_psmgroup(api, psmgroup):
    """ Save the psmgroup.
        Before trying to save, check if a group with the same name already
        exists. Return an error or delete it, depending on 'delete'
        command line argument.
    """
    psmgroup_obj = api.get_object_by_name("wafpolicypsmgroup",
                                          psmgroup["name"])
    if psmgroup_obj is None:
        res = api.post("wafpolicypsmgroup/", psmgroup)
        if res.status_code < 200 or res.status_code > 299:
            raise RuntimeError("Failed to save PSM group '{}': {}".
                               format(psmgroup["name"], str(res)))
        LOGGER.info("Created PSM group: %s", psmgroup["name"])
    else:
        LOGGER.info("WAF PSM group already exists")
        psmgroup_obj.update(psmgroup)
        LOGGER.debug("Existing PSM group:\n" +
                     json.dumps(psmgroup_obj, indent=4, sort_keys=True))
        res = api.put("wafpolicypsmgroup/" + psmgroup_obj["uuid"],
                      psmgroup_obj)
        if res.status_code < 200 or res.status_code > 299:
            raise RuntimeError("Failed to save PSM group '{}': {}".
                               format(psmgroup_obj["name"], str(res)))
        LOGGER.info("Updated PSM group: %s", psmgroup_obj["name"])


def new_psmgroup(args, handler_type, vulnerability_data):
    """ Create new PSM group with locations and rules
        matching vulnerability_data.
    """
    psm_group_name = handler_type

    psmgroup = {}
    psmgroup["name"] = psm_group_name  # "DAST_qualysweb"
    psmgroup["hit_action"] = "WAF_ACTION_NO_OP"
    psmgroup["miss_action"] = "WAF_ACTION_BLOCK"
    psmgroup["description"] = "DAST results. " + \
        "File name: {}. Created on: {}. Created by: {}, version: {}".format(
            os.path.basename(args.filename),
            str(datetime.datetime.now()), sys.argv[0], __version__)
    psmgroup["locations"] = []

    rule_id = 0
    for location_index, (url, vulns) in enumerate(vulnerability_data.items()):
        location = {}
        location["index"] = location_index
        location["name"] = url
        location_index += 1
        location["match"] = {}
        location["match"]["path"] = {}
        location["match"]["path"]["match_case"] = "INSENSITIVE"
        location["match"]["path"]["match_criteria"] = "EQUALS"
        location["match"]["path"]["match_str"] = [url]
        psmgroup["locations"].append(location)
        location["rules"] = []

        params_added = set()  # tuples (param, attack_type)
        for rule_index, vuln in enumerate(vulns):
            if (vuln["param"], vuln["attack_type"]) in params_added:
                continue
            rule = {}
            rule["index"] = rule_index
            rule_index += 1
            rule["match_value_pattern"] = Protection.get_regex_for(
                vuln["attack_type"])
            rule["match_case"] = "SENSITIVE"
            rule_id += 1
            rule["rule_id"] = str(rule_id)
            rule["name"] = "{}-{}".format(vuln["param"], vuln["attack_type"])
            rule["description"] = "Type: {}. {}.".format(vuln["attack_type"],
                                                         vuln["description"])
            if vuln.get("qid"):
                rule["description"] = "{} QID:{}.".format(rule["description"],
                                                          vuln["qid"])
            match_element = {}
            match_element["index"] = 0
            match_element["name"] = "WAF_VARIABLE_ARGS"
            match_element["sub_element"] = vuln["param"]
            rule["match_elements"] = [match_element]
            params_added.add((vuln["param"], vuln["attack_type"]))
            location["rules"].append(rule)

    return psmgroup


def detect_input_type(xmldict):
    """ Detect input type and return appropriate input handler """
    if "WAS_SCAN_REPORT" in xmldict:
        return QualysWebXmlInputHandler()
    elif "OWASPZAPReport" in xmldict:
        return ZapXmlInputHandler()
    raise Exception("Failed to detect input type")


def main():
    """ script entry point """
    args = process_args()

    if args.verbose:
        LOGGER.setLevel(logging.DEBUG)
    else:
        LOGGER.setLevel(logging.INFO)

    # load file into memory
    try:
        with open(args.filename) as infile:
            xmldict = xmltodict.parse(infile.read())
    except Exception as exc:
        LOGGER.error("Failed to process input file: %s", exc)
        exit(1)
    handler = detect_input_type(xmldict)
    vulnerability_data = handler.handle(xmldict)
    if not vulnerability_data:
        LOGGER.warning("No data, skipping")
    else:
        psmgroup = new_psmgroup(args, handler.input_type, vulnerability_data)
        LOGGER.debug("New PSM group:\n" +
                     json.dumps(psmgroup, indent=4, sort_keys=True))
        if not args.force:
            msg = "Use --force to apply changes to Avi controller"
            if args.verbose is True:
                LOGGER.info(msg)
            else:
                LOGGER.info(msg + "or --verbose to display config changes")
            return
        with ApiSession.get_session(args.controller,
                                    args.username,
                                    args.password,
                                    tenant=args.tenant,
                                    api_version=AVI_API_VERSION) as api:
            save_psmgroup(api, psmgroup)


if __name__ == "__main__":
    main()
