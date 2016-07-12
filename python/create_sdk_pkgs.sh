#!/bin/bash

cp avi/sdk/setup.py .
cp avi/sdk/MANIFEST.in .
python debian/update_version.py
dpkg-buildpackage -b -us -uc
mv ../python-avisdk_*.deb dist/
rm -rf ../avisdk_*amd64.changes
python setup.py bdist_rpm
rm -rf avisdk.egg-info
rm -rf build/
rm -f setup.py
rm -f MANIFEST.in
