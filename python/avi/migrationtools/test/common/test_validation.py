import os
import unittest
import json
import copy
from avi.migrationtools.avi_migration_utils import MigrationUtil


class Test(unittest.TestCase):

    def setUp(self):
        dir_path = os.path.abspath(os.path.dirname(__file__))
        json_file = open(os.path.join(dir_path, 'test_validation_avi.json'),
                         'r')
        self.old_file = json.load(json_file)
        self.new_file = copy.deepcopy(self.old_file)

    def test_validation(self):
        util = MigrationUtil()
        util.validation(self.new_file)
        assert len(self.new_file) == len(self.old_file)
        assert cmp(self.new_file, self.old_file) != 0
        assert self.new_file['NetworkProfile'][0]['profile'][
            'tcp_proxy_profile']['max_segment_size'] == 512
        obj = [app_obj for app_obj in self.new_file[
            'ApplicationPersistenceProfile'] if app_obj['name'] ==
               'Merged-COOKIEINSERT-app_persist_profile-2']
        assert obj[0]['http_cookie_persistence_profile']['timeout'] == 1
