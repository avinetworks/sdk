#!/bin/bash
set -x
assets=""
echo "Usage ./create_release.sh <branch> <release_name>"
REL=$2
BRANCH=$1
if [ $BRANCH = "eng" ]; then
    BRANCH="master"
fi

if [ -z $REL ]; then
    echo "Pl. give the release name eg. latest"
    exit 1
fi

git tag -d $REL
git tag $REL
git push -f origin $REL
set -e
git checkout -B $BRANCH
cd python
rm -rf dist/
./create_sdk_pip_packages.sh sdk
./create_sdk_pip_packages.sh f5_converter
./create_sdk_pkgs.sh

if [ -e dist/avisdk-$BRANCH.tar.gz ]; then
    mv dist/avisdk-$BRANCH.tar.gz ../avisdk-$BRANCH.tar.gz
else
    echo "Avi API SDK PIP package not found. Aborting."
    exit 1
fi

if [ -e dist/python-avisdk_0_all.deb ]; then
    mv dist/python-avisdk_0_all.deb ../avisdk-$BRANCH.deb
else
    echo "Avi API SDK Debian package not found. Aborting"
    exit 1
fi

if [ -e dist/avisdk-$BRANCH-1.noarch.rpm ]; then
    mv dist/avisdk-$BRANCH-1.noarch.rpm ../avisdk-$BRANCH.rpm
else
    echo "Avi API SDK RPM package not found. Aborting"
    exit 1
fi

if [ -e dist/avif5converter-$BRANCH.tar.gz ]; then
    mv dist/avif5converter-$BRANCH.tar.gz ../avif5converter-$BRANCH.tar.gz
else
    echo "Avi F5 converter package not found. Aborting"
    exit 1
fi

rm -rf dist
rm -rf avisdk.egg-info
assets="$assets -a avisdk-$BRANCH.tar.gz#pip-package-avisdk-$BRANCH -a avif5converter-$BRANCH.tar.gz#pip-package-avif5converter-$BRANCH -a avisdk-$BRANCH.deb#debian-package-avisdk-$BRANCH -a avisdk-$BRANCH.rpm#rpm--package-avisdk-$BRANCH"
cd ../
/usr/local/bin/hub release edit $assets -F ReleaseNote $REL
rm -rf avisdk-$BRANCH.tar.gz
rm -rf avif5converter-$BRANCH.tar.gz
rm -rf avisdk-$BRANCH.deb
rm -rf avisdk-$BRANCH.rpm

