import os
from setuptools import setup, find_packages

AVI_PIP_VERSION = ''

# allow setup.py to be run from any path
os.chdir(os.path.normpath(os.path.join(os.path.abspath(__file__), os.pardir)))

setup(
    name='avimigrationtools',
    version=AVI_PIP_VERSION,
    packages=find_packages(exclude=['*sdk*']),
    description='Avi Converter.',
    url='http://avinetworks.com/',
    author='Avi Networks',
    author_email='support@avinetworks.com',
    scripts=['avi/migrationtools/f5_converter/f5_converter.py',
             'avi/migrationtools/netscaler_converter/netscaler_converter.py',
             'avi/migrationtools/vs_filter.py',
             'avi/migrationtools/config_patch.py'],
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
                      'pandas', 'openpyxl', 'appdirs',  'pexpect'],
    package_data={'avi': ['*.cfg', '*.conf', '*.crt', '*.crl', '*.json',
                          '*.key', '*.pem', '*.xml', '*.yaml', '*.yml']},
)
