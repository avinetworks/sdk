Avi Ace Config Converter
==============================

`Avi Ace Config Converter  <https://github.com/avinetworks/sdk/releases/tag/latest>`_
is a Python Package that can convert Ace configurations into Avi Configurations.

Ace converter takes input as Ace configuration outputs Avi configuration in JSON
format which can be uploaded to Avi Vantage Controller for migrating
applications and settings.

Upon successful run the converter outputs the results in **ouput** directory
with following contents:

- **ConversionStatus.xlsx**: Status of the conversion. It is a Excel file with
  each row representing Ace configuration object and its migration status and
  corresponding Avi configuration.

- **Output.json**: This is ouput of the migrated configuration in Avi Vantage
  configuration JSON format. This configuration can be uploaded to the Avi
  Vantage controller.

- **converter.log**: This is troubleshooting log for Ace Converter useful for
  debugging and logging purpose.

Usage Examples
--------------
```
usage: ace_converter.py [-h] [-f INPUT_FILE] [-o OUTPUT_LOC]
                        [--controller_version CONTROLLER_VERSION]
                        [-s {enable,disable}] [-l INPUT_FOLDER_LOCATION]
                        [-O {cli-upload,auto-upload}] [-u USER] [-p PASSWORD]
                        [-c CONTROLLER_IP] [-t TENANT]
                        [--cloud_name CLOUD_NAME] [--ansible] [--patch PATCH]
                        [--vs_filter VS_FILTER] [--version]
                        [--vrf_name VRF_NAME]

Converts Ace config to avi config

Usage:
    `ace_convertor.py -f <input_file> -o <output_location>`


    Mandatory:
        :param input file: the input configuration file
        :param output_file : the output file that needs to be generated

    Optional:
        :param controller_version: To Target which controller converting into
        :param vs_state: To enable or disable after the vs is create
        :param input_folder_location: Location of input key and cert files, if not use
                                    current run location
        :param option: (auto-upload) Upload after conversion directly into controller
        :param user: Username of Controller to upload
        :param password: Password of Controller to upload
        :param controller_ip: The ip of the controller to upload

        :param tenant: Tenant for which config need to be converted
        :param cloudname: To change the cloud name
        :param ansible: To create ansible upload file
        :param vs_filter: To filter vs out of configuration
        :param patch: To patch the configuration file
        :param version: version of the controller
        :param vrf_name: Add vrf reference to pool and vs

    optional arguments:
    -h, --help            show this help message and exit
    -f INPUT_FILE, --input_file INPUT_FILE
                            Input configuration file that needs to be parsed
    -o OUTPUT_LOC, --output_loc OUTPUT_LOC
                            Out file location
    --controller_version CONTROLLER_VERSION
                            Specify the particular version
    -s {enable,disable}, --vs_state {enable,disable}
                            state of VS created
    -l INPUT_FOLDER_LOCATION, --input_folder_location INPUT_FOLDER_LOCATION
                            location of key and cert file
    -O {cli-upload,auto-upload}, --option {cli-upload,auto-upload}
                            Upload option cli-upload genarates Avi config file auto upload will upload config to controller
    -u USER, --user USER  controller username for auto upload
    -p PASSWORD, --password PASSWORD
                            controller password for auto upload
    -c CONTROLLER_IP, --controller_ip CONTROLLER_IP
                            controller ip for auto upload
    -t TENANT, --tenant TENANT  tenant name for auto upload
    --cloud_name CLOUD_NAME     cloud name for auto upload
    --ansible             Flag for create ansible file
    --patch PATCH         Run config_patch please provide location of patch.yaml
    --vs_filter VS_FILTER
                            comma seperated names of virtualservices
    --version             Print product version and exit
    --vrf_name VRF_NAME   Attach the vrf reference to pool and vs

