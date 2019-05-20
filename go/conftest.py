import pytest
import os
import json
import sys
dashboard_metadata_imported = False
try:
    dashboard_metadata_file_location = "/mnt/files/rahulchugh/"
    sys.path.append(dashboard_metadata_file_location + '/dashboardv2/lib')
    from dashboard_metadata import DashboardMetadata
    dashboard_metadata_imported = True
except ImportError:
    pass #This is done for handling cases when /mnt/files is not mounted

input_args = {}

def pytest_addoption(parser):
    parser.addoption("--platform",help="Platform for running the test",default=None)
    parser.addoption("--access_mode",help="access_mode running the test",default=None)
    parser.addoption("--collect-only-with-markers",action="store_true",help="collect the testcases with marker information without executing them")
    parser.addoption("--testbed")
    parser.addoption("--api_version")

def pytest_configure(config):
    input_args['platform'] = config.getoption("--platform")
    input_args['access_mode'] = config.getoption("--access_mode")
    input_args['collect_only_with_markers'] = config.getoption('--collect-only-with-markers')

@pytest.fixture(scope="session",autouse=True)
def dashboardv2_delete_old_logs(request):
    print "session level"
    os.system("rm -rf %s"%(os.environ.get('WORKSPACE','.')+"/*dashboardv2_tc.log")) #removing all dashboardv2_tc.log before running the tests.

@pytest.mark.hookwrapper
def pytest_runtest_makereport(item, call):
    outcome = yield
    report = outcome.get_result()
    if os.environ.has_key('WORKSPACE'):
        workspace = os.environ['WORKSPACE']
        try:
            file_location = ''
            if input_args['platform'] != None:
                if input_args['access_mode']:
                    file_location = os.path.join(workspace, "--"+input_args['access_mode']+"--"+"_"+input_args['platform']+"_dashboardv2_tc.log")
                else:
                    file_location = os.path.join(workspace, "_"+input_args['platform']+"_dashboardv2_tc.log")
            else:
                file_location = os.path.join(workspace, "dashboardv2_tc.log")
            if dashboard_metadata_imported:
                dashboard_metadata = DashboardMetadata()
                dashboard_metadata.initialise_from_report_object(report)
                DashboardMetadata.serializer(file_location, dashboard_metadata)
        except:
            pass


def pytest_collection_modifyitems(session, config, items):
    if config.getoption('--collect-only-with-markers'):
        for item in items:
            data = {}
            # Collect some general information
            if item.cls:
                data['class'] = item.cls.__name__
            data['name'] = item.name
            if item.originalname:
                data['originalname'] = item.originalname
            data['file'] = item.location[0]

            # Get the marker information
            for key, value in item.keywords.items():
                if key == 'pytestmark' and len(value) > 0:
                    if 'marks' not in data:
                        data['marks'] = []
                    for markers in value:
                        data['marks'].append(markers.name)
            print(json.dumps(data))

        # Remove all items (we don't want to execute the tests)
        del items[:]
