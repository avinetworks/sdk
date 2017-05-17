import json, requests
import time, traceback
import xml.dom.minidom

WAIT_AFTER_REQ=1

tenant_config_xml = {'CreateTenant.xml':['$TENANT','$APPPROFILE', '$PRIVATENETWORK']}

bd_config_xml = {'CreateBD.xml':['$TENANT','$BD','$SUBNET', '$PRIVATENETWORK']}

bd_subnet_config_xml = { 'AddBDSubnet.xml':['$TENANT','$BD','$SUBNET']}

epg_config_xml = {'CreateEPG.xml':['$TENANT','$APPPROFILE','$EPG','$BD','$DOMAIN']}

contract_config_xml = {'CreateContract.xml':['$TENANT','$WEBCTRCT','$WEBGRAPH', '$FILTER']}

epg_contract_prov_xml = {'AddEPGContractProv.xml':['$TENANT','$APPPROFILE','$EPG','$WEBCTRCT']}

epg_contract_cons_xml = {'AddEPGContractCons.xml':['$TENANT','$APPPROFILE','$EPG','$WEBCTRCT']}

graph_config_xml = {'CreateGraphWithParams.xml':['$TENANT', '$VENDOR','$PRODUCT', '$WEBGRAPH', '$CONOUT', '$CONINT']}
                     
class APICClient(object):
    def __init__(self, apic_ip, username, password):
        self.apic_ip = apic_ip
        self.apic_user = username
        self.apic_password = password
        self.cookies = None
        self.connectToAPIC()
        return

    def connectToAPIC(self):
        auth = {
            'aaaUser': {
                'attributes': {
                    'name': self.apic_user,
                    'pwd': self.apic_password
                }
            }
        }
        status = 0
        while( status != 200 ):
            url = 'https://%s/api/aaaLogin.json' % self.apic_ip
            while(1):
                try:
                    r = requests.post( url, data=json.dumps(auth), timeout=5,
                                       verify=False)
                    break;
                except Exception:
                    print(traceback.format_exc())
            status = r.status_code
            #print r.text
            self.cookies = r.cookies
            time.sleep(1)
        return

    def sendAPICPostRequest(self, data):
        #print '++++++++ REQUEST ++++++++'
        #print data
        #print '-------- REQUEST --------'
        url = 'https://%s/api/node/mo/.xml' % self.apic_ip
        #print url
        r = requests.post( url,
                           cookies=self.cookies,
                           data=data,
                           verify=False)
        xml.dom.minidom.parseString( r.text )
        status = r.status_code
        #print '++++++++ RESPONSE (%s) ++++++++' % file
        #print '-------- RESPONSE (%s) --------' % file
        if( status==200):
            time.sleep(WAIT_AFTER_REQ) 

    def retrieveXmlFilePath(self, xml_file):
        xml_path =  xml_file
        return xml_path

    def createTenantConfig(self, Tenant, AppProfile, PrivateNetwork=''):
        if not PrivateNetwork:
            PrivateNetwork = Tenant + 'ctx1'
        for xml_file, dvalue_list in tenant_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$APPPROFILE']:
                        new_str = AppProfile
                    if dvalue in ['$PRIVATENETWORK']:
                        new_str = PrivateNetwork
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def createTenantBD(self, Tenant, Bd, Subnet, PrivateNetwork=''):
        if not PrivateNetwork:
            PrivateNetwork = Tenant + 'ctx1'
        for xml_file, dvalue_list in bd_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$BD']:
                        new_str = Bd
                    if dvalue in ['$SUBNET']:
                        new_str = Subnet
                    if dvalue in ['$PRIVATENETWORK']:
                        new_str = PrivateNetwork
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def addTenantBDSubnet(self, Tenant, Bd, Subnet):
        for xml_file, dvalue_list in bd_subnet_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$BD']:
                        new_str = Bd
                    if dvalue in ['$SUBNET']:
                        new_str = Subnet
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def createTenantContract(self, Tenant, Contract, Graph, Filter):
        for xml_file, dvalue_list in contract_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$WEBCTRCT']:
                        new_str = Contract
                    if dvalue in ['$WEBGRAPH']:
                        new_str = Graph
                    if dvalue in ['$FILTER']:
                        new_str = Filter
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def createAppEpg(self, Tenant, AppProfile, Epg, Domain, Bd, Subnet=''):
        for xml_file, dvalue_list in epg_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$APPPROFILE']:
                        new_str = AppProfile
                    if dvalue in ['$EPG']:
                        new_str = Epg
                    if dvalue in ['$DOMAIN']:
                        new_str = Domain
                    if dvalue in ['$BD']:
                        new_str = Bd
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def addEpgContractProv(self, Tenant, AppProfile, Epg, Contract):
        for xml_file, dvalue_list in epg_contract_prov_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$APPPROFILE']:
                        new_str = AppProfile
                    if dvalue in ['$EPG']:
                        new_str = Epg
                    if dvalue in ['$WEBCTRCT']:
                        new_str = Contract
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)

    def addEpgContractCons(self, Tenant, AppProfile, Epg, Contract):
        for xml_file, dvalue_list in epg_contract_cons_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$APPPROFILE']:
                        new_str = AppProfile
                    if dvalue in ['$EPG']:
                        new_str = Epg
                    if dvalue in ['$WEBCTRCT']:
                        new_str = Contract
                    data = data.replace(dvalue, new_str)
        self.sendAPICPostRequest(data)

    def createGraph(self, Tenant, Vendor, Product, Graph, conn_out, conn_ins):
        for xml_file, dvalue_list in graph_config_xml.items():
            #print '--------------------'
            #print xml_file
            #print '--------------------'
            data = None
            path = self.retrieveXmlFilePath(xml_file)
            with open( path, 'r' ) as payload:
                data = payload.read()
                payload.close()
                for dvalue in dvalue_list:
                    new_str = ''
                    if dvalue in ['$TENANT']:
                        new_str = Tenant
                    if dvalue in ['$WEBGRAPH']:
                        new_str = Graph
                    if dvalue in ['$PRODUCT']:
                        new_str = Product
                    if dvalue in ['$VENDOR']:
                        new_str = Vendor
                    if dvalue in ['$CONOUT']:
                        new_str = conn_out
                    if dvalue in ['$CONINT']:
                        new_str = conn_ins
                    data = data.replace(dvalue, new_str)
            self.sendAPICPostRequest(data)
