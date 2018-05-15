Avi F5 Config Converter
=======================
`Avi F5 Config Converter  <https://github.com/avinetworks/sdk/releases/tag/latest>`_
is a Python Package that can convert F5 configurations into Avi Configurations.

F5 converter takes input as F5 configuration outputs Avi configuration in JSON
format which can be uploaded to Avi Vantage Controller for migrating
applications and settings.

There are two ways to input F5 configuration

#. **Command Line**: Input F5 configuration on the command line or,

#. **Download from F5 box**: Converter downloads the configuration and
   profile defaults from the F5 box.

Upon successful run the converter outputs the results in **ouput** directory
with following contents:

- **ConversionStatus.xlsx**: Status of the conversion. It is a Excel file with
  each row representing F5 configuration object and its migration status and
  corresponding Avi configuration.

- **Output.json**: This is ouput of the migrated configuration in Avi Vantage
  configuration JSON format. This configuration can be uploaded to the Avi
  Vantage controller.

- **converter.log**: This is troubleshooting log for F5 Converter useful for
  debugging and logging purpose.


F5 Object Migration status fields
---------------------------------

+---------+------------+-------+--------+----------+----------+------------+---------+----------+------------+-----------+----------+--------+
| F5 Type | F5 SubType | F5 Id | status | skipped  | Indirect | Not        | User    | Skipped  | Complexity | VS        | Overall  | Avi    |
|         |            |       |        | settings | mapping  | Applicable | Ignored | for      | Level      | Reference | skipped  | Object |
|         |            |       |        |          |          |            |         | Defaults |            |           | settings |        |
+---------+------------+-------+--------+----------+----------+------------+---------+----------+------------+-----------+----------+--------+
+---------+------------+-------+--------+----------+----------+------------+---------+----------+------------+-----------+----------+--------+


 - **Status**: Overall status of the migration. If it is "successful"
   implies it was completely migrated to AVI Vantage and admin can expect
   similar behavior in Avi Vantage as it was in F5 Box. A "partial" status
   implies that not all the settings within an F5 object could be fully
   converted to Avi configuration. Converter provides list of the skipped
   settings as part of the status of that object. The status can also be
   "skipped" which implies that the F5 configuration could not be migrated.

 - **Skipped**: List of field settings that were skipped as they are not
   supported in Avi.

 - **Indirect mapping**: These settings are indirectly mapped to Avi
   features. Please refer to Avi website for more details.

 - **Not Applicable**: These settings are not applicable to Avi. Eg.
   hardware settings etc.

 - **User Ignored**: These settings were ignored by the admins

 - **Skipped for defaults**: These settings came from F5 configuration
   defaults. These have been mapped to Avi's default settings.

 - **Complexity Level**: This column has value only in the rows of VS status to
   identify if VS is of BASIC or ADVANCED type. If VS has policy or Data-Script
   then it is considered as ADVANCED VS.

 - **VS Reference**: This column contains list of VS names where the object is
   referenced (This column appears only if --vs_level_status option is used)

 - **Overall skipped settings**: This column contains list of related objects of
   the VS and skipped values of those (This column appears only if
   --vs_level_status option is used)

 - **Avi Object**: Converter Avi JSON object


Usage Examples
--------------

- F5 Converter help::

   f5_converter.py -h

   usage: f5_converter.py [-h] [--ansible]
                       [--ansible_skip_types ANSIBLE_SKIP_TYPES]
                       [--ansible_filter_types ANSIBLE_FILTER_TYPES]
                       [--baseline_profile BASELINE_PROFILE]
                       [-c CONTROLLER_IP] [--cloud_name CLOUD_NAME]
                       [--controller_version CONTROLLER_VERSION]
                       [--convertsnat] [-f BIGIP_CONFIG_FILE]
                       [--f5_host_ip F5_HOST_IP] [--f5_key_file F5_KEY_FILE]
                       [--f5_passphrase_file F5_PASSPHRASE_FILE]
                       [--f5_ssh_user F5_SSH_USER]
                       [--f5_ssh_password F5_SSH_PASSWORD]
                       [--ignore_config IGNORE_CONFIG]
                       [-l INPUT_FOLDER_LOCATION] [--no_object_merge]
                       [--not_in_use] [-o OUTPUT_FILE_PATH]
                       [-O {cli-upload,auto-upload}] [-p PASSWORD]
                       [--partition_config PARTITION_CONFIG] [--patch PATCH]
                       [--prefix PREFIX] [-r RULE_CONFIG]
                       [--skip_default_file] [-s {enable,disable}]
                       [--segroup SEGROUP] [-t TENANT] [--test_vip TEST_VIP]
                       [-u USER] [-v F5_CONFIG_VERSION] [--version]
                       [--vrf VRF] [--vs_filter VS_FILTER] [--vs_level_status]

    Converts F5 Config to avi config.
    Example to convert F5 config file to avi config json:
         f5_converter.py -f bigip.conf

    Example to skip default file in f5:
          f5_converter.py -f bigip.conf --skip_default_file
    Usecase: To skip default profile and monitor configuration

    Example to f5_config_version
       f5_converter.py -f bigip.conf -v 10

    Example to download config from f5 host and convert to avi config:
         f5_converter.py --f5_host_ip "1.1.1.1" --f5_ssh_user
         username --f5_ssh_password password

    Example to auto upload to controller after conversion:
        f5_converter.py -f bigip.conf -O auto-upload -c 2.2.2.2 -u
        username -p password -t tenant

    Example to use -s or --vs_state option:
        f5_converter.py -f bigip.conf -s <enable or disable>
    Usecase: To enable a VS after conversion to AVI.

    Example to use input file for certs and key
        f5_converter.py -f bigip.conf -l /home/username

    Example to use --controller_version option:
     f5_converter.py -f bigip.conf --controller_version <17.2.3>
    Usecase: To provide the version of controller for getting output in
    respective controller format.

    Example to use ignore config option:
         f5_converter.py -f bigip.conf --ignore_config
    Usecase: The attributes mentioned in ignore_config.yaml will appear in
    ignore column in excel sheet instead of skip. It will need an ignore_config.yaml
    file in the input directory defined by user
    <object example monitor>:
        <property example https>:
        - <attribute example 'destination'>

    Example to use --partition_config option:
       f5_converter.py -f bigip.conf --partition_config /home/username/abc.txt
    Usecase: When auto-download option enable. It download the files from
    different f5 partitions with comma separated path provided with partition
    config option.

    Example to use no object merge option:
        f5_converter.py -f bigip.conf --no_object_merge
    Usecase: When we don't need to merge two same object (based on their
     attribute values except name)

    Example to patch the config after conversion:
       f5_converter.py -f bigip.conf --patch test/patch.yaml
       where patch.yaml file contains
       <avi_object example Pool>:
        - match_name: <existing name example p1>
       patch:
        name: <changed name example coolpool>

    Example to export a single VS:
         f5_converter.py -f bigip.conf --vs_filter cool_vs

    Example to skip avi object during playbook creation
         f5_converter.py -f bigip.conf  --ansible --ansible_skip_types DebugController
    Usecase:
         Comma separated list of Avi Object types to skip during conversion.
         Eg. DebugController, ServiceEngineGroup will skip debugcontroller and
         serviceengine objects

    Example to filter ansible object
         f5_converter.py -f bigip.conf  --ansible --ansible_filter_types
         virtualservice, pool
    Usecase:
        Comma separated list of Avi Objects types to include during conversion.
        Eg. VirtualService , Pool will do ansible conversion only for
        Virtualservice and Pool objects

    Example to use ansible option:
        f5_converter.py -f bigip.conf --ansible
    Usecase: To generate the ansible playbook for the avi configuration
    which can be used for upload to controller

    Example to add the prefix to avi object name:
        f5_converter.py -f bigip.conf --prefix abc
    Usecase: When two configuration is to be uploaded to same controller then
     in order to differentiate between the objects that will be uploaded in
     second time.

    Example to convert snatpool into individual address
     f5_converter.py -f bigip.conf --convertsnat
    Usecase:
        Flag to enable Source Network Address Translation in avi.

    Example to use not_in_use option:
        f5_converter.py -f bigip.conf --not_in_use
    Usecase: Dangling object which are not referenced by any avi object will be removed

    Example to provide baseline json file absolute location:
        f5_converter.py -f bigip.conf --baseline_profile
        /home/<'sys_conf.json' or 'bigip-Output.json'>
     Usecase: Need to merge objects if there is migration of two
     f5 instances/box to single controller.

    Example to provide passpharse of encrypted certs and certkey file location
         f5_converter.py -f bigip.conf -l /home/certs/
         --f5_passphrase_file passphrase.yaml
         passphrase.yaml file contains
          <file_name>:<passphrase>
          <file_name2>:<passphrase2>
          Example:
            mcqcim.key: ZcZawJ7ps0AJ+5TMDi7UA==
            avi_key.pem : foobar

    Example to use vs level status option:
        f5_converter.py -f bigip.conf --vs_level_status
    Usecase: To get the vs level status for the avi objects in excel sheet

    Example to use segroup flag
        f5_converter.py -f ns.conf --segroup segroup_name
    UseCase: To add / Change segroup reference of vs

    Example to use vrf flag
        f5_converter.py -f ns.conf --vrf vrf_name
    UseCase: Change all the vrf reference in the configuration while conversion


optional arguments:
  -h, --help            show this help message and exit
  --ansible             Flag for create ansible file
  --ansible_skip_types ANSIBLE_SKIP_TYPES
                        Comma separated list of Avi Object types to skip during conversion.
                          Eg. -s DebugController,ServiceEngineGroup will skip debugcontroller and serviceengine objects
  --ansible_filter_types ANSIBLE_FILTER_TYPES
                        Comma separated list of Avi Objects types to include during conversion.
                         Eg. -f VirtualService, Pool will do ansible conversion only for Virtualservice and Pool objects
  --baseline_profile BASELINE_PROFILE
                        asolute path for json file containing baseline profiles
  -c CONTROLLER_IP, --controller_ip CONTROLLER_IP
                        controller ip for auto upload
  --cloud_name CLOUD_NAME
                        cloud name for auto upload
  --controller_version CONTROLLER_VERSION
                        Target Avi controller version
  --convertsnat         Flag for converting snatpool into individual addresses
  -f BIGIP_CONFIG_FILE, --bigip_config_file BIGIP_CONFIG_FILE
                        absolute path for F5 config file
  --f5_host_ip F5_HOST_IP
                        host ip of f5 instance
  --f5_key_file F5_KEY_FILE
                        f5 host key file location if key based authentication
  --f5_passphrase_file F5_PASSPHRASE_FILE
                        F5 key passphrase yaml file path
  --f5_ssh_user F5_SSH_USER
                        f5 host ssh username
  --f5_ssh_password F5_SSH_PASSWORD
                        f5 host ssh password if password based authentication
  --ignore_config IGNORE_CONFIG
                        config json to skip the config in conversion
  -l INPUT_FOLDER_LOCATION, --input_folder_location INPUT_FOLDER_LOCATION
                        location of input files like cert files external monitor scripts
  --no_object_merge     Flag for object merge
  --not_in_use          Flag for skipping not in use object
  -o OUTPUT_FILE_PATH, --output_file_path OUTPUT_FILE_PATH
                        Folder path for output files to be created in
  -O {cli-upload,auto-upload}, --option {cli-upload,auto-upload}
                        Upload option cli-upload genarates Avi config file auto upload will upload config to controller
  -p PASSWORD, --password PASSWORD
                        controller password for auto upload
  --partition_config PARTITION_CONFIG
                        comma separated partition config files
  --patch PATCH         Run config_patch please provide location of patch.yaml
  --prefix PREFIX       Prefix for objects
  -r RULE_CONFIG, --rule_config RULE_CONFIG
                        iRule mapping yml file path
  --skip_default_file   Flag for skip default file
  -s {enable,disable}, --vs_state {enable,disable}
                        state of VS created
  --segroup SEGROUP     Update the available segroup ref with thecustom ref
  -t TENANT, --tenant TENANT
                        tenant name for auto upload
  --test_vip TEST_VIP   Enable test vip for ansible generated file It will replace the original vip Note: The actual ip will vary from input to outputuse it with caution
  -u USER, --user USER  controller username for auto upload
  -v F5_CONFIG_VERSION, --f5_config_version F5_CONFIG_VERSION
                        version of f5 config file
  --version             Print product version and exit
  --vrf VRF             Update the available vrf ref with the custom vrfreference
  --vs_filter VS_FILTER
                        comma seperated names of virtualservices
  --vs_level_status     Add columns of vs reference and overall skipped settings in status excel sheet
