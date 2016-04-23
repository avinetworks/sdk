import os
from setuptools import setup, find_packages
from avi.version import AVI_VERSION
"""
This setup needs to be copied to the top level python directory and then
create the package.
"""

# allow setup.py to be run from any path
os.chdir(os.path.normpath(os.path.join(os.path.abspath(__file__), os.pardir)))

setup(
    name='avisdk',
    version=AVI_VERSION,
    packages=find_packages(exclude=['*f5_converter*']),
    description='Avi python sdk.',
    url='http://avinetworks.com/',
    author='Avi Networks',
    author_email='support@avinetworks.com',
    scripts=['avi/sdk/samples/virtualservice_examples_api.py'],
    classifiers=[
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 2.7',
        'Topic :: Internet :: WWW/HTTP',
        'Topic :: Internet :: WWW/HTTP :: Dynamic Content',
    ],
    include_package_data=True,
    install_requires=['pyyaml', 'requests', 'pyparsing'],
    package_data={'avi': ['*.cfg', '*.conf', '*.crt', '*.crl', '*.json',
                          '*.key', '*.pem', '*.xml', '*.yaml']},
)
