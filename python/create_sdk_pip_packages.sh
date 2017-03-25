#!/bin/bash

if [ ! "$1" ]; then
    echo "package name {sdk|config_converter} not provided"
    exit
fi

cp avi/migrationtool/setup.py .
cp avi/migrationtool/MANIFEST.in .
AVI_PIP_VERSION=`python version.py`
sed -i s/"AVI_PIP_VERSION =.*$"/"AVI_PIP_VERSION = \'$AVI_PIP_VERSION\'"/g setup.py
sed -i s/"__version__ =.*$"/"__version__ = \'$AVI_PIP_VERSION\'"/g avi/migrationtool/__init__.py
echo "copied setup and manifest to top level python directory"
echo "creating package"
python setup.py sdist
echo "cleanup"
if [ $1 == "sdk" ]; then
    rm -rf avisdk.egg-info
elif [ $1 == "config_converter" ]; then
    rm -rf aviconverter.egg-info
fi
rm -f setup.py
rm -f MANIFEST.in
sed -i s/"__version__ =.*$"/"__version__ = \'\'"/g avi/migrationtool/__init__.py
