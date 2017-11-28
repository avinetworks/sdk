"""
Get the configuration from the config.yml file.
"""

def pytest_addoption(parser):
    parser.addoption("--config", action="store", help="config file")
    parser.addoption("--file",  action="store", help="input file")
    parser.addoption("--out", action="store", help="Output folder path")