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
    exit
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
mv dist/avisdk-$BRANCH.tar.gz ../avisdk-$BRANCH.tar.gz
mv dist/avif5converter-$BRANCH.tar.gz ../avif5converter-$BRANCH.tar.gz
rm -rf dist
rm -rf avisdk.egg-info
assets="$assets -a avisdk-$BRANCH.tar.gz#pip-package-avisdk-$BRANCH -a avif5converter-$BRANCH.tar.gz#pip-package-avif5converter-$BRANCH"
cd ../
/usr/local/bin/hub release edit $assets -F ReleaseNote $REL
rm avisdk-$BRANCH.tar.gz
rm avif5converter-$BRANCH.tar.gz
