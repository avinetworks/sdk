from avi.migrationtools.f5_converter.conversion_util import F5Util
import avi.migrationtools.f5_converter.converter_constants as conv_const
import unittest



class Tester():

    def __init__(self):
        self.conversion_util = F5Util()

    def compareDict(self,f5_config_dict,avi_config_dict):
       for each_vs in avi_config_dict['VirtualService']:
            vs_name = each_vs['name']
            exist = self.test_compareVsName(vs_name, f5_config_dict)
            if exist:
                if 'application_profile_ref' in each_vs:
                    application_profile_ref = each_vs['application_profile_ref']
                    app_name = self.conversion_util.get_name(application_profile_ref)
                    app_type = [i['type'] for i in avi_config_dict['ApplicationProfile'] if i['name']==app_name]
                    self.test_getApplicationType(app_type[0],f5_config_dict)
            else:
                print "Virtual service is not available";

            # if 'network_profile_ref' in each_vs:
            #     network_profile_ref = each_vs['network_profile_ref']
            #     network_profile_name = self.conversion_util.get_name(network_profile_ref)
            #     network_type = [i['profile']['type'] for i in avi_config_dict['NetworkProfile'] if i['name'] == network_profile_name]
            #     print network_type


    def test_compareVsName(self,vs_name,f5_config_dict):
        for each_parsed_vs in f5_config_dict['virtual']:
            name =  each_parsed_vs.split('/')
            if vs_name == name[2]:
                print name[2]
                return True


    def test_getApplicationType(self,app_type,f5_config_dict):
        profile_config = f5_config_dict.get("profile", {})
        for key in profile_config.keys():
                profile_type = None
                name = None
                profile_type, name = key.split(" ")
                if profile_type in conv_const.PROFILES.keys():
                    if conv_const.PROFILES[profile_type] == app_type:
                        return True

