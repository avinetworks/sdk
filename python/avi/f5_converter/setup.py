import os
from setuptools import setup, find_packages

# allow setup.py to be run from any path
os.chdir(os.path.normpath(os.path.join(os.path.abspath(__file__), os.pardir)))
AVI_PIP_VERSION = ''

setup(
    name='avif5converter',
    version=AVI_PIP_VERSION,
    # package_dir={'': 'avi/f5_converter'},
    packages=find_packages(exclude=['*sdk*', '*netscaler_converter*']),
    description='Avi F5 Converter.',
    url='http://avinetworks.com/',
    author='Avi Networks',
    author_email='support@avinetworks.com',
    scripts=['avi/f5_converter/f5_converter.py'],
    classifiers=[
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 2.7',
        'Topic :: Internet :: WWW/HTTP',
        'Topic :: Internet :: WWW/HTTP :: Dynamic Content',
    ],
    include_package_data=True,
    install_requires=['pyyaml', 'requests', 'pyparsing', 'paramiko', 'avisdk',
                      'pycrypto', 'ecdsa', 'pyOpenssl'],
    package_data={'avi': ['*.cfg', '*.conf', '*.crt', '*.crl', '*.json',
                          '*.key', '*.pem', '*.xml', '*.yaml']},
)
