'''
Created on Apr 22, 2016
@author: grastogi
'''
import argparse

AVI_VERSION = '20.1.7'
AVI_PIP_VERSION = '20.1.7b1'

if __name__ == '__main__':
    HELP_STR = '''
        Returns the pip or controller version
        pip version example:
            python version.py
        controller example:
            python version.py -c
    '''

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawTextHelpFormatter,
        description=HELP_STR)

    # To get controller version
    parser.add_argument('-c', '--controller',
                        help='Flag to get controller version',
                        action='store_true')

    args = parser.parse_args()

    if args.controller:
        print(AVI_VERSION)
    else:
        print(AVI_PIP_VERSION)
