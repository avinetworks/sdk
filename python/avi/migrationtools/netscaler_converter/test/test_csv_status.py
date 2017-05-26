import logging
import os
import unittest
import json
import csv
from testconfig import config
from avi.migrationtools.netscaler_converter.ns_constants import (STATUS_SKIPPED,
                                                  STATUS_SUCCESSFUL,
                                                  STATUS_PARTIAL)

LOG = logging.getLogger(__name__)


def init_logger_path(path):
    LOG.setLevel(logging.DEBUG)
    formatter = '[%(asctime)s] %(levelname)s [%(funcName)s:%(lineno)d] %(message)s'
    logging.basicConfig(filename=os.path.join(path, 'test.log'),
                        level=logging.DEBUG, format=formatter)


def Excel2CSV(ExcelFile, SheetName, CSVFile):
    import xlrd
    import csv
    workbook = xlrd.open_workbook(ExcelFile)
    worksheet = workbook.sheet_by_name(SheetName)
    csvfile = open(CSVFile, 'wb')
    wr = csv.writer(csvfile, quoting=csv.QUOTE_ALL)
    for rownum in xrange(worksheet.nrows):
        wr.writerow(
            list(x.encode('utf-8') if type(x) == type(u'') else x
                 for x in worksheet.row_values(rownum)))
    csvfile.close()

def setUp():
    global csv_reader
    global aviconfig
    LOG.setLevel(logging.DEBUG)
    output_dir = config['netscaler_test_config']['output_dir']
    config_file_name = config['netscaler_test_config']['config_file_name']
    xlsx_file = '%s/%s-ConversionStatus.xlsx' % (output_dir, config_file_name)
    output_file = open('%s/%s-Output.json' % (output_dir, config_file_name), 'r')
    csv_path = '%s/ConversionStatus.csv' % output_dir
    Excel2CSV(xlsx_file, "Status Sheet", csv_path)
    csv_file = open(csv_path, 'r')
    csv_reader = csv.DictReader(csv_file, )
    output_data = output_file.read()
    aviconfig = json.loads(output_data)

class TestCSV(unittest.TestCase):

    def test_csv_skipped_status_report(self):
        """
        This test case defines that verify skipped netscaler commands have
        the reasons
        :return: None
        """
        skipped_rows = [row for row in csv_reader
                        if row['Status'] == STATUS_SKIPPED and
                        row['AVI Object'] == '']
        self.assertTrue(len(skipped_rows) == 0)

    def test_csv_successful_status_add_lb_monitor(self):
        """
        This test case defines that verify all add lb monitor netscaler commands
        which are successful those Health monitor should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'add lb monitor']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_monitor_object = json.loads(avi_object)
            avi_monitor = [monitor for monitor in aviconfig['HealthMonitor']
                           if monitor['name'] == avi_monitor_object['name']]
            self.assertTrue(len(avi_monitor) == 1)

    def test_csv_successful_status_add_cs_vserver(self):
        """
        This test case defines that verify all add cs vserver netscaler commands
        which are successful those VS should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'add cs vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_vs_object = json.loads(avi_object)
            avi_vs = [cs_vs for cs_vs in aviconfig['VirtualService']
                           if cs_vs['name'] == avi_vs_object['name']]
            self.assertTrue(len(avi_vs) == 1)

    def test_csv_successful_status_add_service(self):
        """
        This test case defines that verify all add service netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'add service']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [cs_vs for cs_vs in aviconfig['Pool']
                           if cs_vs['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)

    def test_csv_successful_status_add_service_group(self):
        """
        This test case defines that verify all add serviceGroup netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'add serviceGroup']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [cs_vs for cs_vs in aviconfig['Pool']
                           if cs_vs['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)

    def test_csv_successful_status_set_lb_group(self):
        """
        This test case defines that verify all set lb group netscaler commands
        which are successful those ssl profile should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'set lb group']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_profile_object = json.loads(avi_object)
            avi_profile = [profile for profile in aviconfig['ApplicationPersistenceProfile']
                           if profile['name'] == avi_profile_object['name']]
            self.assertTrue(len(avi_profile) == 1)

    def test_csv_successful_status_bind_lb_vserver(self):
        """
        This test case defines that verify all bind lb vserver netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'bind lb vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [pool for pool in aviconfig['Pool']
                           if pool['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)

    def test_csv_successful_status_set_ssl_service_group(self):
        """
        This test case defines that verify all set ssl service group netscaler commands
        which are successful those ssl profile should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'set ssl serviceGroup']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in aviconfig['SSLProfile']
                        if ssl_profile['name'] == avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)

    def test_csv_successful_status_set_ssl_service(self):
        """
       This test case defines that verify all set ssl service netscaler commands
       which are successful those ssl profile should be created from avi
       object
       :return: None
       """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'set ssl service']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in
                               aviconfig['SSLProfile']
                               if ssl_profile['name'] ==
                               avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)

    def test_csv_successful_status_set_ssl_vserver(self):
        """
       This test case defines that verify all set ssl vserver netscaler commands
       which are successful those ssl profile should be created from avi
       object
       :return: None
       """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_SUCCESSFUL and
                           row['Netscaler Command'] == 'set ssl vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in
                               aviconfig['SSLProfile']
                               if ssl_profile['name'] ==
                               avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)

    def test_csv_partial_status_add_lb_monitor(self):
        """
        This test case defines that verify all add lb monitor netscaler commands
        which are successful those Health monitor should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'add lb monitor']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_monitor_object = json.loads(avi_object)
            avi_monitor = [monitor for monitor in aviconfig['HealthMonitor']
                           if monitor['name'] == avi_monitor_object['name']]
            self.assertTrue(len(avi_monitor) == 1)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_add_cs_vserver(self):
        """
        This test case defines that verify all add cs vserver netscaler commands
        which are successful those VS should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'add cs vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_vs_object = json.loads(avi_object)
            avi_vs = [cs_vs for cs_vs in aviconfig['VirtualService']
                      if cs_vs['name'] == avi_vs_object['name']]
            self.assertTrue(len(avi_vs) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_add_service(self):
        """
        This test case defines that verify all add service netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'add service']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [cs_vs for cs_vs in aviconfig['Pool']
                        if cs_vs['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_add_service_group(self):
        """
        This test case defines that verify all add serviceGroup netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'add serviceGroup']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [cs_vs for cs_vs in aviconfig['Pool']
                        if cs_vs['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_set_lb_group(self):
        """
        This test case defines that verify all set lb group netscaler commands
        which are successful those ssl profile should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'set lb group']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_profile_object = json.loads(avi_object)
            avi_profile = [profile for profile in
                           aviconfig['ApplicationPersistenceProfile']
                           if profile['name'] == avi_profile_object['name']]
            self.assertTrue(len(avi_profile) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_bind_lb_vserver(self):
        """
        This test case defines that verify all bind lb vserver netscaler commands
        which are successful those pool should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'bind lb vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_pool_object = json.loads(avi_object)
            avi_pool = [pool for pool in aviconfig['Pool']
                        if pool['name'] == avi_pool_object['name']]
            self.assertTrue(len(avi_pool) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_set_ssl_service_group(self):
        """
        This test case defines that verify all set ssl service group netscaler commands
        which are successful those ssl profile should be created from avi
        object
        :return: None
        """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'set ssl serviceGroup']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in
                               aviconfig['SSLProfile']
                               if ssl_profile['name'] ==
                               avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_set_ssl_service(self):
        """
       This test case defines that verify all set ssl service netscaler commands
       which are successful those ssl profile should be created from avi
       object
       :return: None
       """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'set ssl service']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in
                               aviconfig['SSLProfile']
                               if ssl_profile['name'] ==
                               avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def test_csv_partial_status_set_ssl_vserver(self):
        """
       This test case defines that verify all set ssl vserver netscaler commands
       which are successful those ssl profile should be created from avi
       object
       :return: None
       """

        successful_rows = [row for row in csv_reader
                           if row['Status'] == STATUS_PARTIAL and
                           row['Netscaler Command'] == 'set ssl vserver']
        for row in successful_rows:
            avi_object = self.format_string_to_json(row['AVI Object'])
            skipped_settings = \
                self.format_string_to_list(row['Skipped settings'])
            avi_ssl_profile_object = json.loads(avi_object)
            avi_ssl_profile = [ssl_profile for ssl_profile in
                               aviconfig['SSLProfile']
                               if ssl_profile['name'] ==
                               avi_ssl_profile_object['name']]
            self.assertTrue(len(avi_ssl_profile) == 1)
            self.assertFalse(len(skipped_settings) == 0)
            for skipped_attribute in skipped_settings:
                self.assertIn(skipped_attribute, row['Full Command'])

    def format_string_to_json(self, avi_string):
        """
        This function defines that it convert string into json format to
        convert into dict
        :param avi_string: string to be converted
        :return: Return converted string
        """

        repls = ('True', 'true'), ('False', 'false'), ("\"", ""), ("'", "\""), \
                ("None", "null")
        avi_string = reduce(lambda a, kv: a.replace(*kv), repls, avi_string)
        return avi_string

    def format_string_to_list(self, avi_string):
        """
        This function defines that it convert string into list format to
        convert into dict
        :param avi_string: string to be converted
        :return: Return converted string
        """

        repls = ('[', ''), (']', ''), ("'", "")
        avi_string = reduce(lambda a, kv: a.replace(*kv), repls, avi_string)
        return avi_string.split(',')


if __name__ == '__main__':
    unittest.main()