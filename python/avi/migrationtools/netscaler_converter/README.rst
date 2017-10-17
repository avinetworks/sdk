Avi Netscaler Config Converter
==============================
`Avi Netscaler Config Converter  <https://github.com/avinetworks/sdk/releases/tag/latest>`_
is a Python Package that can convert Netscaler configurations into Avi Configurations.

Netscaler converter takes input as Netscaler configuration outputs Avi configuration in JSON
format which can be uploaded to Avi Vantage Controller for migrating
applications and settings.

There are two ways to input Netscaler configuration

#. **Command Line**: Input Netscaler configuration on the command line or,

#. **Download from Netscaler box**: Converter downloads the configuration and
   profile defaults from the Netscaler box.

Upon successful run the converter outputs the results in **ouput** directory
with following contents:

- **ConversionStatus.csv**: Status of the conversion. It is a CSV file with
  each row representing Netscaler configuration object and its migration status and
  corresponding Avi configuration.

- **Output.json**: This is ouput of the migrated configuration in Avi Vantage
  configuration JSON format. This configuration can be uploaded to the Avi
  Vantage controller.

- **converter.log**: This is troubleshooting log for Netscaler Converter useful for
  debugging and logging purpose.


Netscaler Object Migration status fields
----------------------------------------

+------------------+--------+----------+----------+------------+---------+---------+----------+--------+
| Netscaler Config | status | skipped  | Indirect | Not        | User    | Skipped | Avi      |        |
|                  |        | settings | mapping  | Applicable | Ignored |         | Defaults | Object |
+------------------+--------+----------+----------+------------+---------+---------+----------+--------+
+------------------+--------+----------+----------+------------+---------+---------+----------+--------+

 - **Status**: Overall status of the migration. If it is "successful"
   implies it was completely migrated to AVI Vantage and admin can expect
   similar behavior in Avi Vantage as it was in Netscaler Box. A "partial" status
   implies that not all the settings within an Netscaler object could be fully
   converted to Avi configuration. Converter provides list of the skipped
   settings as part of the status of that object. The status can also be
   "skipped" which implies that the Netscaler configuration could not be migrated.

 - **Skipped**: List of field settings that were skipped as they are not
   supported in Avi.

 - **Indirect mapping**: These settings are indirectly mapped to Avi
   features. Please refer to Avi website for more details.

 - **Not Applicable**: These settings are not applicable to Avi. Eg.
   hardware settings etc.

 - **User Ignored**: These settings were ignored by the admins

 - **Skipped for defaults**: These settings came from Netscaler configuration
   defaults. These have been mapped to Avi's default settings.

 - **Avi Object**: Converter Avi JSON object.


Usage Examples
--------------

- Netscaler Converter help::

   netscaler_converter.py -h

    usage: netscaler_converter.py [-h] [-f NS_CONFIG_FILE]
                              [-l INPUT_FOLDER_LOCATION] [-o OUTPUT_FILE_PATH]
                              [-O {cli-upload,auto-upload}] [-u USER]
                              [-p PASSWORD] [-t TENANT]
                              [--cloud_name CLOUD_NAME] [-c CONTROLLER_IP]
                              [-s {enable,disable}]
                              [--controller_version CONTROLLER_VERSION]
                              [--ns_host_ip NS_HOST_IP]
                              [--ns_ssh_user NS_SSH_USER]
                              [--ns_ssh_password NS_SSH_PASSWORD]
                              [--ns_key_file NS_KEY_FILE]
                              [--ns_passphrase_file NS_PASSPHRASE_FILE]
                              [--version] [--no_object_merge] [--patch PATCH]
                              [--vs_filter VS_FILTER]
                              [--ignore_config IGNORE_CONFIG]
                              [--prefix PREFIX] [--not_in_use]
                              [--baseline_profile BASELINE_PROFILE]
                              [--redirect] [--ansible] [--vs_level_status]

        Converts Netscaler Config to Avi config.
        Example to convert Netscaler config file to avi config json:
            netscaler_converter.py -f ns.conf

        Example to export a single VS:
            netscaler_converter.py -f ns.conf --vs_filter cool_vs

        Example to download config from Netscalet host and convert to avi config:
            netscaler_converter.py --ns_host_ip "1.1.1.1" --ns_ssh_user
            username --ns_ssh_password password

        Example to auto upload to controller after conversion:
            netscaler_converter.py -f ns.conf -O auto-upload -c 2.2.2.2 -u
            username -p password -t tenant

        Example to provide passpharse of encrypted certs and certkey file
        location
            netscaler_converter.py -f ns.conf -l /home/certs/
            --ns_passphrase_file passphrase.yaml
            passphrase.yaml file contains
            <file_name>:<passphrase>
            <file_name2>:<passphrase2>
            Example:
            mcqcim.key: ZcZawJ7ps0AJ+5TMDi7UA==
            avi_key.pem : foobar
            
        Example to provide baseline json file absolute location:
            netscaler_converter.py -f ns.conf --baseline_profile 
            /home/<'sys_conf.json' or 'ns-Output.json'>
        Usecase: Need to merge objects if there is migration of two netscaler
                 instances/box to single controller.
        
        Example to patch the config after conversion:
          netscaler_converter.py -f ns.conf --patch test/patch.yaml
          where patch.yaml file contains
          <avi_object example Pool>:
           - match_name: <existing name example p1>
             patch:
               name: <changed name example coolpool>
         
        Example to add the prefix to avi object name:
          netscaler_converter.py -f ns.conf --prefix abc
        Usecase: When two configuration is to be uploaded to same controller 
                 then in order to differentiate between the objects that will
                 be uploaded in second time.
        
        Example to use no object merge option:
          netscaler_converter.py -f ns.conf --no_object_merge
        Usecase: When we don't need to merge two same object (based on their
                 attribute values except name)
         
        Example to use redirect option:
          netscaler_converter.py -f ns.conf --redirect
        Usecase: If a http VS has no pool assigned to it but has redirect to 
                 https VS
          
        Example to use ansible option:
          netscaler_converter.py -f ns.conf --ansible
        Usecase: To generate the ansible playbook for the avi configuration
                 which can be used for upload to controller
          
        Example to use vs level status option:
          netscaler_converter.py -f ns.conf --vs_level_status
        Usecase: To get the vs level status for the avi objects in excel sheet
         
        Example to use ignore config option:
          netscaler_converter.py -f ns.conf --ignore_config
        Usecase: The attributes mentioned in ignore_config.yaml will appear in 
                 ignore column in excel sheet instead of skip.
                 It will need an ignore_config.yaml file like below
                 in the input directory defined by user
                 <object example monitor>:
                     <property example https>:
                     - <attribute example 'destination'>
        Example to use not_in_use option:
          netscaler_converter.py -f ns.conf --not_in_use
        Usecase: Dangling object which are not referenced by any avi object
                 will be removed.
                 
        Example to use -s or --vs_state option:
          netsacaler_converter.py -f ns.conf -s <enable or disable>
        Usecase: To enable a VS after conversion to AVI.
           
        Example to use --controller_version option:
          netscaler_converter.py -f ns.conf --controller_version <17.2.3>
        Usecase: To provide the version of controller.

optional arguments:
  -h, --help            show this help message and exit
  -f NS_CONFIG_FILE, --ns_config_file NS_CONFIG_FILE
                        absolute path for Netscaler config file
  -l INPUT_FOLDER_LOCATION, --input_folder_location INPUT_FOLDER_LOCATION
                        location of extracted backup folder
  -o OUTPUT_FILE_PATH, --output_file_path OUTPUT_FILE_PATH
                        Folder path for output files to be created in
  -O {cli-upload,auto-upload}, --option {cli-upload,auto-upload}
                        Upload option cli-upload genarates Avi config file auto upload will upload config to controller
  -u USER, --user USER  controller username for auto upload
  -p PASSWORD, --password PASSWORD
                        controller password for auto upload
  -t TENANT, --tenant TENANT
                        tenant name for auto upload
  --cloud_name CLOUD_NAME
                        cloud name for auto upload
  -c CONTROLLER_IP, --controller_ip CONTROLLER_IP
                        controller ip for auto upload
  -s {enable,disable}, --vs_state {enable,disable}
                        state of VS created
  --controller_version CONTROLLER_VERSION
                        Target Avi controller version
  --ns_host_ip NS_HOST_IP
                        host ip of Netscaler instance
  --ns_ssh_user NS_SSH_USER
                        Netscaler host ssh username
  --ns_ssh_password NS_SSH_PASSWORD
                        Netscaler host ssh password if password based authentication
  --ns_key_file NS_KEY_FILE
                        Netscaler host key file location if key based authentication
  --ns_passphrase_file NS_PASSPHRASE_FILE
                        Netscaler key passphrase yaml file
  --version             Print product version and exit
  --no_object_merge     Flag for object merge
  --patch PATCH         Run config_patch please provide location of patch.yaml
  --vs_filter VS_FILTER
                        comma seperated names of virtualservices
  --ignore_config IGNORE_CONFIG
                        config json to skip the config in conversion
  --prefix PREFIX       Prefix for objects
  --not_in_use          Flag for skipping not in use object
  --baseline_profile BASELINE_PROFILE
                        asolute path for json file containing baseline profiles
  --redirect            redirect http vs to https vs if there is no pool assigned
  --ansible             Flag for create ansible file
  --vs_level_status     Add columns of vs reference and overall skipped settings in status excel sheet
