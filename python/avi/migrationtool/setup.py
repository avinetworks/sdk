import os
from setuptools import setup, find_packages

AVI_PIP_VERSION = ''

# allow setup.py to be run from any path
os.chdir(os.path.normpath(os.path.join(os.path.abspath(__file__), os.pardir)))

setup(
    name='aviconverter',
    version=AVI_PIP_VERSION,
    packages=find_packages(exclude=['*sdk*']),
    description='Avi Converter.',
    url='http://avinetworks.com/',
    author='Avi Networks',
    author_email='support@avinetworks.com',
    scripts=['avi/migrationtool/f5_converter/f5_converter.py',
             'avi/migrationtool/netscaler_converter/netscaler_converter.py',
             'avi/migrationtool/vs_filter.py',
             'avi/migrationtool/config_patch.py',
             'avi/migrationtool/netscaler_converter/test/netscaler_e2e_test.py'],
    classifiers=[
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 2.7',
        'Topic :: Internet :: WWW/HTTP',
        'Topic :: Internet :: WWW/HTTP :: Dynamic Content',
    ],
    include_package_data=True,
    install_requires=['pyyaml', 'requests', 'pyparsing', 'paramiko', 'avisdk',
                      'pycrypto', 'ecdsa', 'pyOpenssl', 'nose-html-reporting',
                      'nose-testconfig', 'ConfigParser', 'xlsxwriter',
                      'pandas', 'openpyxl'],
    package_data={'avi': ['*.cfg', '*.conf', '*.crt', '*.crl', '*.json',
                          '*.key', '*.pem', '*.xml', '*.yaml']},
)
