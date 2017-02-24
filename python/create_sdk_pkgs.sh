#!/bin/bash

cp avi/sdk/setup.py .
cp avi/sdk/MANIFEST.in .
AVI_PIP_VERSION=`python version.py`
sed -i s/"AVI_PIP_VERSION =.*$"/"AVI_PIP_VERSION = \'$AVI_PIP_VERSION\'"/g setup.py
sed -i s/"__version__ =.*$"/"__version__ = \'$AVI_PIP_VERSION\'"/g avi/sdk/__init__.py
python debian/update_version.py
dpkg-buildpackage -b -us -uc
mv ../python-avisdk_*.deb dist/
rm -rf ../avisdk_*amd64.changes
python setup.py bdist_rpm
rm -rf avisdk.egg-info
rm -rf build/
rm -f setup.py
rm -f MANIFEST.in
sed -i s/"__version__ =.*$"/"__version__ = \'\'"/g avi/sdk/__init__.py
