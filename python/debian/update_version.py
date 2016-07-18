from avi.version import AVI_VERSION
import re
import os
if __name__ == '__main__':
    #version = '0' if AVI_VERSION[0].isalpha() else AVI_VERSION
    version = '0'
    regex = '\(.*?\)'
    dir_path = os.path.abspath(os.path.dirname(__file__))
    with open(dir_path+os.path.sep+'changelog', 'r+') as f:
        content = f.read()
        f.seek(0)
        f.truncate()
        f.write(re.sub(regex,'(%s)' % version, content))
