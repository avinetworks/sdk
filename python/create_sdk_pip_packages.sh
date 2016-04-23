#!/bin/bash

if [ ! "$1" ]; then
    echo "package name {sdk|f5_converter} not provided"
    exit
fi

cp avi/$1/setup.py .
cp avi/$1/MANIFEST.in .
echo "copied setup and manifest to top level python directory"
echo "creating package"
python setup.py sdist
echo "cleanup"
if [ $1 == "sdk" ]; then
    rm -rf avisdk.egg-info
else
    rm -rf avif5converter.egg-info
fi
rm -f setup.py
rm -f MANIFEST.in
