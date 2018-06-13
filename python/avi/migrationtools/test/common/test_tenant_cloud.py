import json
from avi.sdk.avi_api import ApiSession


def create_tenant(controller_ip, username, password, name):
    """"
        Create non default tenant on the given Controller.
    """
    session = ApiSession.get_session (controller_ip, username, password)
    data = {'local': True, 'name': name}
    json_data = json.dumps (data)
    path = "/tenant?"
    rsp = session.post (path, data=json_data)
    print rsp
    return


def create_cloud(controller_ip, username, password, cloud_name):
    """"
    Create non default cloud name on the
    given Controller.
    """
    session = ApiSession.get_session (controller_ip, username, password)
    data = {"vtype": "CLOUD_NONE","name": cloud_name}
    json_data = json.dumps (data)
    path = "/cloud?include_name"
    rsp1 = session.post (path, data=json_data)
    print rsp1
    return json.loads (rsp1.content)


def create_segroup(controller_ip, username, password, segroup_name):
     session = ApiSession.get_session(controller_ip, username, password)
     data = {"name": segroup_name}
     json_data = json.dumps(data)
     path = "/serviceenginegroup"
     rsp1 = session.post(path, data=json_data)
     print rsp1
     return rsp1


def create_vrf_context(controller_ip, username, password, vrf_name):
    session = ApiSession.get_session(controller_ip, username, password)
    data = {"name": vrf_name}
    json_data = json.dumps(data)
    path = "/vrfcontext"
    rsp1 = session.post(path, data=json_data)
    print rsp1
    return rsp1


if __name__ == "__main__":
    create_cloud ('10.10.26.133', 'admin', 'avi123$%', 'qwe123')