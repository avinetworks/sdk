from avi.migrationtools.f5_converter.conversion_util import F5Util
class CompareMigrations:

    def __init__(self):
        self.conversion_util = F5Util()

    def compareDict(self,f5_config_dict,avi_config_dict):
        for each_vs in avi_config_dict['VirtualService']:
            vs_name = each_vs['name']
            if 'application_profile_ref' in each_vs:
                application_profile_ref = each_vs['application_profile_ref']
                app_name = self.conversion_util.get_name(application_profile_ref)
                app_type = [i['type'] for i in avi_config_dict['ApplicationProfile'] if i['name']==app_name]
                print app_type

    def getPrifileName(self,name):
        profName =  name.split('=',2)
        return profName[2]