'''
Created on Apr 22, 2016

@author: grastogi
'''

AVI_VERSION = '16.3'
AVI_PIP_VERSION = (AVI_VERSION if len(AVI_VERSION.split('.')) > 2
                   else (AVI_VERSION + '.0'))

if __name__ == '__main__':
    print AVI_PIP_VERSION
