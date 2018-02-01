"""
Get the configuration from the yml file.
"""

def pytest_addoption(parser):
    parser.addoption("--config", action="store", help="playbook file")
    parser.addoption("--change", action="store", help="expected change")