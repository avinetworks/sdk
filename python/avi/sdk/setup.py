import os
from setuptools import setup, find_packages
"""
This setup needs to be copied to the top level python directory and then
create the package.
"""
AVI_PIP_VERSION = ''

# allow setup.py to be run from any path
os.chdir(os.path.normpath(os.path.join(os.path.abspath(__file__), os.pardir)))

setup(
    name='avisdk',
    version=AVI_PIP_VERSION,
    packages=find_packages(exclude=['*migrationtools*',
                                    '*sdk.samples.autoscale*',
                                    '*sdk.test*'
                                   ]),
    description='Avi python API SDK for Avi Controller REST API with samples'
                ' and, utilities',
    url='https://github.com/avinetworks/sdk',
    author='Avi Networks',
    author_email='avisdk@avinetworks.com',
    scripts=['avi/sdk/samples/virtualservice_examples_api.py'],
    classifiers=[
        'Development Status :: 5 - Production/Stable',
        'Intended Audience :: Developers',
        'Operating System :: OS Independent',
        'Programming Language :: Python',
        'Programming Language :: Python :: 2.7',
        'Topic :: Internet :: WWW/HTTP',
        'Topic :: Internet :: WWW/HTTP :: Dynamic Content',
    ],
    keywords='AVI ADC Loadbalancer automation datacenter SDK',
    license='Avi Networks',
    include_package_data=True,
    install_requires=['requests'],
    package_data={'avi': ['*.cfg', '*.conf', '*.crt', '*.crl', '*.json',
                          '*.key', '*.pem', '*.xml', '*.yaml', '*.rst']},
)
