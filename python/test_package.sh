#!/bin/bash
rm -rf dist/*
sh create_sdk_pip_packages.sh sdk > test.log
sh create_sdk_pip_packages.sh f5_converter > test.log
virtualenv avi-sdk
cd avi-sdk
source bin/activate
bin/pip install ../dist/avisdk-*.tar.gz > ../test.log
bin/pip install ../dist/avif5converter-*.tar.gz > ../test.log
python local/lib/python2.7/site-packages/avi/sdk/test/test_avi_api.py
python local/lib/python2.7/site-packages/avi/f5_converter/test/test_f5_conversion_v11.py
python local/lib/python2.7/site-packages/avi/f5_converter/test/test_f5_conversion_v10.py
cd ..
rm -r avi-sdk