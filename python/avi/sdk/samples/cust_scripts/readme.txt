
This directory contains the control scripts samples for Avi

1. server_down_script.py  : This file contains the script which can be invoked
   via the alert action when a SERVER_DOWN Alert is generated.

2. control_script_se_route_update.py : This ControlScript is executed on the 
   Avi Controller every time there is a CC_IP_ATTACHED or a CC_IP_DETACHED event.

3. dos-script.py : This control script will be executed in the Avi Controller when an
   alert due to a DOS_ATTACK event is generated.
