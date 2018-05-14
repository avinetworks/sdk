Avi GSS Config Converter
==============================

`Avi GSS Config Converter  <https://github.com/avinetworks/sdk/releases/tag/latest>`_
is a Python Package that can convert GSS configurations into Avi GSLB
Configurations.

GSS converter takes input as GSS configuration outputs Avi configuration in JSON
format which can be uploaded to Avi Vantage Controller for migrating
applications and settings.

Upon successful run the converter outputs the results in **ouput** directory
with following contents:

- **ConversionStatus.xlsx**: Status of the conversion. It is a Excel file with
  each row representing GSS configuration object and its migration status and
  corresponding Avi configuration.

- **Output.json**: This is ouput of the migrated configuration in Avi Vantage
  configuration JSON format. This configuration can be uploaded to the Avi
  Vantage controller.

- **converter.log**: This is troubleshooting log for GSS Converter useful for
  debugging and logging purpose.

Usage Examples
--------------

Usage:
    * gss_convertor.py -f <input_file> -o <output_location>

Mandatory
:param input file: the input configuration file
:param output_file : the output file that needs to be generated

Optional:
:param tenant: Tenant for which config need to be converted
:param version: version of the controller (optional)


optional arguments:
  -h, --help            show this help message and exit
  -f INPUT_FILE, --input_file INPUT_FILE
                        Input configuration file that needs to be parsed
  -o OUTPUT_LOC, --output_loc OUTPUT_LOC
                        Out file location
  -t TENANT, --tenant TENANT
                        Out file name
  --version VERSION     Specify the particular version



