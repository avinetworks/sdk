
This directory contains all the python files required to perfom the tasks related
to application onboarding in an APIC Tenant. 

It performs the following tasks 

APIC
-----
1. Creates the Application EPGs
2. Creates Contracts to be used across the Application EPGs
3. Creates Application Services Graph with Avi Template
3. Assigns Service Graph to a Contract

Avi Controller
--------------
1. Creates Static IP Address Pool for the relevant networks
2. Creates IP Address Groups (optional).
   - Apic Application EPG based or Static IP address
3. Creates Pool and points it to an EPG
4. Creates VirtualService and associated it to the Pools/IP Address Group

Python Packages required
------------------------
   json, requests, xml, sys

Files
------

- apic_tenant_config.json : 

      Description of the topology in json format

- apic_tenant.py : 

      Routines to create the objects described in apic_tenant_config.json 
      in APIC/Avi Controller

- apic_client.py

      Routines to establish a session with the APIC and program the APIC
      objects. The configs are pushed to APIC based on "$" value replacement
      in the xml files

- * xml files

      APIC XML schema used while creating the APIC objects
      
      CreateContract.xml
      CreateGraphWithParams.xml
      AddEPGContractCons.xml
      AddEPGContractProv.xml
      CreateEPG.xml
      AddBDSubnet.xml
      CreateBD.xml
      CreateTenant.xml

Execute
-------

    python apic_tenant.py

    It reads the configuration from apic_tenant_config.json

Config File Description
-----------------------

{
    "Tenant" : "<Apic Tenant Name>",
    "AppProfile" : [
        {
            "name" : "<Apic Application Profile Name>",
            "EpgConfig": [
                {
                    "name" : "<Apic EPG Name",
                    "vmm_domain" : "<Apic VMM Domain for EPG>",
                    "bridge_domain" : "<Bridge Domain for EPG>",
                    "EpgContract" : [
                        {
                            "name" : "<Contract applied to EPG>",
                            "type" : "CONSUMER or PROVIDER"
                        },
                        {
                            <Specify additional Contracts for EPG>...
                        }
                    ]
                },
                {
                    <Specify additional EPG's for Application Profile>...
                }
            ]
        }
    ],
    "BridgeDomain" : [
        {
            "name" : "<Apic Bridge Domain Name>",
            "network" : "<Apic Network for Bridge Domain">,
            "subnets" : [
                {
                    "gateway" : "<IP Subnet for Bridge Domain>"
                },
                {
                    <Specify additional IP Subnets for Bridge Domain>...
                }
            ]
        },
        {
            <Specify additional Bridge Domains for Tenant>.....
        }
    ],
    "PrivateNetwork" : [
        {
            "name" : "<Apic Private Network>"
        },
        {
            <Specify additional Private Networks for Tenant>.....
        }
    ],
    "Contract" : [
        {
            "name" : "<Apic Contract Name>",
            "subject" : {
                "name" : "<Apic Contract Subject Name>",
                "filter" : "<Apic Filter Name>",
                "graph" : "<Apic Graph for Subject>"
            }
        },
        {
            <Specify additional Contracts for Tenant>.....
        }
    ],
    "Graph" : [
        {
            "name" : "<Apic Graph Name>",
            "conn_out" : "<Connector type for Consumer EPG. 'L2' or 'L3'>",
            "conn_int" : "<Connector type for Provider EPG. 'L2' or 'L3'>",
        },
        {
            <Specify additional Graphs for Tenant>.....
        }
       
    ],
    "AviController" : [
        {
            "ip" : "<Ip address of Avi Controller>",
            "username" : "<Avi Controller username">,
            "password" : "<Avi Controller password>",
            "Apic" : [
                {
                    "ip" : "<Apic IP address configured in Avi Controller>",
                    "username" : "<APIC username>",
                    "password" : "<APIC password>",
                    "domain" : "<APIC VMM Domain>",
                    "vendor" : "Avi",
                    "product" : "CADP"
                }
            ],
            "VirtualService" : [
                {
                    "name" : "<Apic Contract>:<Apic Graph Name> in Avi Controller",
                    "vip"  : "<Virtual IP>",
                    "services" : [
                        { 
                            "port" : "<Service port. Eg 80, 8080>",
                            "enable_ssl" : <true or false>
                        },
                        { 
                            <Specify additional ports for Virtual Service>...
                        }
                    ],
                    "pool" : "<Pool Name associated for VirtualService">,
                    "network_security" : {
                        "allow" : <true (allow Ips in group) or false (deny Ips in group)>,
                        "groups" : [<List of IP Group Names in Avi Controller>]
                    }
                },
                {
                    <Specify additional Virtual Services>....
                }
            ],
            "Pool" : [
                {
                    "name" : "<Pool Name in Avi Controller>",
                    "pool_epg" : "<Apic epg name associated with the Pool>"
                },
                {
                    <Specify additional Pools >....
                }
            ],
            "IpAddrGroup" : [
                {
                    "name" : "<Name of the IP Address group>",
                    "epg" : "<Apic epg name associated with the group>"
                                       or
                    "addrs" : [<List of IP addresses>]
                  
                },
                {
                    <Specify additional IP Address Groups >....
                }
            ]
        }
    ]
}
