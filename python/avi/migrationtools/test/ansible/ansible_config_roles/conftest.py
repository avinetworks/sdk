"""
    Get information from user
"""

def pytest_addoption(parser):

    parser.addoption("--create_playbook", action="store", help="Playbook for create config")
    parser.addoption("--update_playbook", action="store", help="Playbook for delete config")