#!/bin/bash
mkdir -p dist
cd avi/sdk/
dpkg-buildpackage -b -us -uc
mv ../python-avisdk_*.deb ../../dist/
rm -rf ../avisdk_*amd64.changes
python setup.py bdist_rpm
mv dist/avisdk*.noarch.rpm ../../dist/
rm -rf avisdk.egg-info
rm -rf build/
rm -rf dist/
