def pytest_addoption(parser):
    parser.addoption("--config_file_name", action="append", default=[],
        help="list of config_file_name to pass to test functions")

def pytest_generate_tests(metafunc):
    if 'config_file_name' in metafunc.fixturenames:
        metafunc.parametrize("config_file_name",
                             metafunc.config.option.config_file_name)
