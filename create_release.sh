#!/bin/bash
set -x
assets=""
echo "Usage ./create_release.sh <branch> <release_name>"
REL=$2
BRANCH=$1
if [ $BRANCH = "eng" ]; then
    BRANCH="master"
fi
git tag -d $REL
git tag $REL
git push -f origin $REL
set -e
git checkout -B $BRANCH
cd python
rm -rf dist/
python setup.py sdist
mv dist/*tar.gz ../avisdk-$BRANCH.tar.gz
rm -rf dist
rm -rf avisdk.egg-info
assets="$assets -a avisdk-$BRANCH.tar.gz#pip-package-$BRANCH"
cd ../
/usr/local/bin/hub release edit $assets -F ReleaseNote $REL
rm avisdk-$BRANCH.tar.gz
