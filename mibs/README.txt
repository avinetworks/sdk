If you update the mibs, you need to do the following:
- smilint AVI-NETWORKS-MIB.my -s -l 20
    - May involve doing an apt-get install smitools and also updating /etc/smi.conf with the path to the
      MIBS. This will be done by the developer who changes the MIBs and the result will be checked in.
- Go to the agent directory and do the following:
    - ./mib2c -c ./mib2c.conf aviNetworksMIB
    - May need the following environment variables
        export MIBDIRS=/usr/local/share/snmp/mibs:${workspace}/controller/snmp/mibs
        export MIBS=ALL
- All of this will be done by the developer before the changes are checked in. There is no automated build
  support for all this as we don't expect a whole lot of MIB changes at this time.
- 
