#!/bin/bash
export PYTHONPATH=`pwd`/python:$PYTHONPATH

AVI_VERSION=`python ./python/version.py`

cd python
rm -rf dist/

./create_sdk_pip_packages.sh sdk
./create_sdk_pip_packages.sh migrationtools

sudo pip install ./dist/avisdk*.tar.gz
sudo pip install ./dist/avimig*.tar.gz