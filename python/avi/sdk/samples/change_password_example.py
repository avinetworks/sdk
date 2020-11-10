import json

import argparse

from avi.sdk.avi_api import ApiSession
from avi.sdk.utils.api_utils import ApiUtils

from avi.sdk.avi_api import APIError


class ChangePasswordExample(object):
    """
    The class will provide example for the following operations
    1. Update/change controller password using Python SDK
    2. Clear the cached session after updating the password
    """

    def __init__(self, api_session):
        self.api_session = api_session
        self.api_utils = ApiUtils(api_session)

    def change_password(self, new_password):
        """
        This method will change/update the password of the controller
        :param new_password: New password to be set to the controller
        """
        old_password = self.api_session.password
        user_info = {
            "password": new_password,
            "old_password": old_password
        }
        try:
            res = self.api_session.put('useraccount', data=json.dumps(user_info))
            if res.status_code == 200:
                print("Password Updated successfully")
                print("Clearing cached session...")
                self.api_session.clear_cached_sessions()
            else:
                print("Failed to update the password. Error message: " + res.text)
        except APIError as err:
            print("Failed to update the password. Error message: " + str(err))
            exit(1)

    def get_pool(self):
        """
        Get the pool using same API session to check if changed password is working or not
        """
        try:
            res = self.api_session.get('pool')
            if res.status_code == 200:
                print("The pool fetched successfully using the session")
            else:
                print("Failed to fetch the pool")
        except APIError as err:
            print("Failed to fetch the pool")
            exit(1)


if __name__ == '__main__':
    HELP_STR = """
    Example: 
    python change_password_example.py --controller_ip="10.10.10.10" --user="admin" --current_password="password" --new_password="password@123"
    """
    parser = argparse.ArgumentParser(description=HELP_STR)
    parser.add_argument('-c', '--controller_ip', help='controller ip')
    parser.add_argument('-u', '--user', default='admin')
    parser.add_argument('-p', '--current_password', default='admin')
    parser.add_argument('-n', '--new_password', default='admin@123')

    args = parser.parse_args()
    print("Input args: ", args)
    api = None

    try:
        api = ApiSession(controller_ip=args.controller_ip, username=args.user,
                         password=args.current_password, tenant="admin")
    except APIError as error:
        print("Failed to update the password. Error message: " + str(error))
        exit(1)
    change_pwd_example = ChangePasswordExample(api_session=api)
    print("Get pool before changing password")
    change_pwd_example.get_pool()
    change_pwd_example.change_password(args.new_password)
    api_after_updation = ApiSession(controller_ip=args.controller_ip, username=args.user,
                                    password=args.new_password, tenant="admin")
    updated_password_example = ChangePasswordExample(api_session=api_after_updation)
    print("Get pool after changing password")
    updated_password_example.get_pool()
