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

- **ConversionStatus.csv**: Status of the conversion. It is a CSV file with
  each row representing F5 configuration object and its migration status and
  corresponding Avi configuration.

- **Output.json**: This is ouput of the migrated configuration in Avi Vantage
  configuration JSON format. This configuration can be uploaded to the Avi
  Vantage controller.

- **converter.log**: This is troubleshooting log for F5 Converter useful for
  debugging and logging purpose.


F5 Object Migration status fields
---------------------------------

+-----------+--------+----------+----------+------------+---------+---------+----------+--------+
| F5 Config | status | skipped  | Indirect | Not        | User    | Skipped | Avi      |        |
|           |        | settings | mapping  | Applicable | Ignored |         | Defaults | Object |
+-----------+--------+----------+----------+------------+---------+---------+----------+--------+
+-----------+--------+----------+----------+------------+---------+---------+----------+--------+

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

 - **Avi Object**: Converter Avi JSON object.


Usage Examples
--------------

- F5 Converter help::

   f5_converter.py -h

   usage: f5_converter.py [-h] [-f BIGIP_CONFIG_FILE] [-v F5_CONFIG_VERSION]
                           [-o OUTPUT_FILE_PATH] [-O {cli-upload,auto-upload}]
                           [-u USER] [-p PASSWORD] [-t TENANT] [-c CONTROLLER_IP]
                           [-s {enable,disable}] [-l INPUT_FOLDER_LOCATION]
                           [--f5_host_ip F5_HOST_IP] [--f5_ssh_user F5_SSH_USER]
                           [--f5_ssh_password F5_SSH_PASSWORD]
                           [--f5_key_file F5_KEY_FILE]
                           [--controller_version CONTROLLER_VERSION]
                           [--ignore_config IGNORE_CONFIG]
                           [--partition_config PARTITION_CONFIG]

    optional arguments:
      -h, --help            show this help message and exit
      -f BIGIP_CONFIG_FILE, --bigip_config_file BIGIP_CONFIG_FILE
                            absolute path for F5 config file
      -v F5_CONFIG_VERSION, --f5_config_version F5_CONFIG_VERSION
                            version of f5 config file
      -o OUTPUT_FILE_PATH, --output_file_path OUTPUT_FILE_PATH
                            Folder path for output files to be created in
      -O {cli-upload,auto-upload}, --option {cli-upload,auto-upload}
                            Upload option cli-upload genarates Avi config file
                            auto upload will upload config to controller
      -u USER, --user USER  controller username for auto upload
      -p PASSWORD, --password PASSWORD
                            controller password for auto upload
      -t TENANT, --tenant TENANT
                            tenant name for auto upload
      -c CONTROLLER_IP, --controller_ip CONTROLLER_IP
                            controller ip for auto upload
      -s {enable,disable}, --vs_state {enable,disable}
                            state of VS created
      -l INPUT_FOLDER_LOCATION, --input_folder_location INPUT_FOLDER_LOCATION
                            location of input files like cert files external
                            monitor scripts
      --f5_host_ip F5_HOST_IP
                            host ip of f5 instance
      --f5_ssh_user F5_SSH_USER
                            f5 host ssh username
      --f5_ssh_password F5_SSH_PASSWORD
                            f5 host ssh password if password based authentication
      --f5_key_file F5_KEY_FILE
                            f5 host key file location if key based authentication
      --controller_version CONTROLLER_VERSION
                            Target Avi controller version
      --ignore_config IGNORE_CONFIG
                            config json to skip the config in conversion
      --partition_config PARTITION_CONFIG
                            comma separated partition config files
      --version             Print product version and exit
      --no_object_merge     Flag for object merge
      --patch PATCH         Run config_patch please provide location of patch.yaml
      --vs_filter VS_FILTER
                        comma seperated names of virtualservices
      --ansible_skip_types ANSIBLE_SKIP_TYPES
                        Comma separated list of Avi Object types to skip during conversion.
                          Eg. -s DebugController,ServiceEngineGroup will skip debugcontroller and serviceengine objects
      --ansible_filter_types ANSIBLE_FILTER_TYPES
                        Comma separated list of Avi Objects types to include during conversion.
                         Eg. -f VirtualService, Pool will do ansible conversion only for Virtualservice and Pool objects
      --ansible             Flag for create ansible file
      --prefix PREFIX       Prefix for objects
      --convertsnat         Flag for converting snatpool into individual addresses
      --not_in_use          Flag for skipping not in use object
      --baseline_profile BASELINE_PROFILE
                        asolute path for json file containing baseline profiles
      --f5_passphrase_file F5_PASSPHRASE_FILE
                        F5 key passphrase yaml file path
