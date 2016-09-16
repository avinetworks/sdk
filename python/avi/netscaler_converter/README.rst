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
                                  [-p PASSWORD] [-t TENANT] [-c CONTROLLER_IP]
                                  [-s {enable,disable}]
                                  [--controller_version CONTROLLER_VERSION]
                                  [--ns_host_ip NS_HOST_IP]
                                  [--ns_ssh_user NS_SSH_USER]
                                  [--ns_ssh_password NS_SSH_PASSWORD]
                                  [--ns_key_file NS_KEY_FILE]

    optional arguments:
      -h, --help            show this help message and exit
      -f NS_CONFIG_FILE, --ns_config_file NS_CONFIG_FILE
                            absolute path for Netscaler config file
      -l INPUT_FOLDER_LOCATION, --input_folder_location INPUT_FOLDER_LOCATION
                            location of extracted backup folder
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
      --controller_version CONTROLLER_VERSION
                            Target Avi controller version
      --ns_host_ip NS_HOST_IP
                            host ip of Netscaler instance
      --ns_ssh_user NS_SSH_USER
                            Netscaler host ssh username
      --ns_ssh_password NS_SSH_PASSWORD
                            Netscaler host ssh password if password based
                            authentication
      --ns_key_file NS_KEY_FILE
                            Netscaler host key file location if key based
                            authentication
