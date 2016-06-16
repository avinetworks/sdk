#!/bin/bash
sh create_sdk_pip_packages.sh sdk
sh create_sdk_pip_packages.sh f5_converter
virtualenv avi
cd avi
source bin/activate
pip install ../dist/avisdk-master.tar.gz
pip install ../dist/avif5converter-master.tar.gz
f5_converter.py -h
deactivate