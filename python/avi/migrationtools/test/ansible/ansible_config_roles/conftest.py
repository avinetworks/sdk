"""
    Get information from user
"""

def pytest_addoption(parser):

    parser.addoption("--controller", action="store", help="Controller ip")
    parser.addoption("--username", action="store", help="Controller username")
    parser.addoption("--password", action="store", help="Controller password")