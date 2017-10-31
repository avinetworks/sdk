"""
Get the configuration from the config.yml file.
"""

def pytest_addoption(parser):
    parser.addoption("--config", action="store", help="Config file")
    parser.addoption ("--fileVersion", action="store", help="Input file version")
    parser.addoption("--file", action="store", help="Input file")
    parser.addoption ("--out", action="store", help="Output folder path")
