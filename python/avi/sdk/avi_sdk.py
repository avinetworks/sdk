
class AviSdk(object):

    def __init__(self, controller_ip, username, password=None, tenant=None):
        pass

    def resource(self, resource_name):
        '''
        return the AviResource
        '''
        pass


class AviResource(object):
    '''
    Note headers and authentication are done via sdk.
    returns AviObject class
    '''
    def __init__(self, sdk):
        pass

    def get(self, avi_obj_type, **kwargs):
        pass

    def get_by_name(self, avi_obj_type, obj_name, **kwargs):
        pass

    def get_inventory(self, avi_obj_type, **kwargs):
        pass

    def post(self, pb_object, **kwargs):
        pass

    def put(self, pb_object, **kwargs):
        pass

    def delete(self, avi_obj_type, uuid, **kwargs):
        pass

    def delete_by_name(self, avi_obj_type, name, **kwargs):
        pass


class VirtualserviceResource(AviResource):
    pass


class AviObject(object):
    def protobuf(self):
        pass

    def get(self, **kwargs):
        pass

    def get_inventory(self, **kwargs):
        raise Exception("Not supported")


class VirtualserviceObject(AviObject):

    def scaleout(self):
        pass

    def scalein(self):
        pass

    def migrate(self):
        pass

    def restart(self):
        pass

    def get_inventory(self):
        AviObject.get_inventory(self)


class PoolObject(AviObject):
    pass

