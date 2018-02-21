"""
Get the configuration from the config.yml file.
"""

def pytest_addoption(parser):
    parser.addoption("--controller", action="store", help="controller ip")
    parser.addoption("--username", action="store", help="username")
    parser.addoption("--password", action="store", help="password")