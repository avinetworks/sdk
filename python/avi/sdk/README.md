# Avi API SDK and Utilities

Avi API SDKis a Python Package that provides APIs to communicate with Avi
Controller’s REST APIs. It extends Python’s Request Library’s Session Class and
provides utilities to simplify integration with Avi Controller.

It handles session authentication and keeps a cache of sessions to avoid
multiple connection setups and teardowns across different API Session
invocation. It automatically updates session cookies, CSRF Tokens from
controller and provides helper APIs and templates for Avi Objects. Other
important features are X-AVI-TENANT (tenant) header handling and sample
source code for common load balancing examples.

It is multi-process and multi-thread safe.

Here are list of important SDK directories

- **samples**: Python samples are in directory python/avi/sdk/samples.

  - **autoscale**: Gives examples of creating control scripts for
    server autoscale

  - **heat**: Provides a heat example for pool servers that can be used
    with server autoscale feature and control scripts

  - **virtualservice_examples_api**: provides examples of programmatically
    creating most common VirtuaServices like basic VS, SSL VS, analytics
    APIs, tenant based APIs etc.

- **utils**: Useful utilities for devops automation.

  - **httppolicyset_templates**: Provides easy to use templates for
    creating HTTP request and redirect policies for most common use cases

  - **Mesos**: Provides CRUD apis to create Marathon App with AVI labels

--------------
Installation
--------------
Pip packages hosted at pypi. They can be installed simply as:

```sh
$ pip install avisdk
```

--------------
Usage Examples
--------------

- **Import Avi API Session:**

   from avi.sdk.avi_api import ApiSession

- **Create Avi API Session:**

   api = ApiSession.get_session("10.10.10.42", "admin", "something", tenant="admin")

- **Create VirtualService Using Pool sample_pool:**

   pool_obj = api.get_object_by_name('pool', 'sample_pool')
   pool_ref = api.get_obj_ref(pool_obj)
   services_obj = [{'port': 80, 'enable_ssl': False}]
   vs_obj = {'name': 'sample_vs', 'ip_address': {'addr': '11.11.11.42', 'type': 'V4'},
            'services': services_obj, 'pool_ref': pool_ref}
   resp = api.post('virtualservice', data=vs_obj)
   print resp.json()

- **Create VirtualService Using Pool sample_pool on 17.x Controllers:**

   pool_obj = api.post('pool', data={'name': 'sample_pool'}, api_version='17.2.4')
   pool_ref = api.get_obj_ref(pool_obj)
   services_obj = [{'port': 80, 'enable_ssl': False}]
   vs_obj = {'name': 'sample_vs', 'vip': [{'ip_address': {'addr': '11.11.11.42', 'type': 'V4'}}],
            'services': services_obj, 'pool_ref': pool_ref}
   resp = api.post('virtualservice', data=vs_obj, api_version='17.2.4')
   print resp.json()

- **Print List of All VirtualServices:**

   resp = api.get('virtualservice')
   for vs in resp.json()['results']:
      print vs['name']

- **Delete VirtualService:**

   resp = api.delete('virtualservice', 'sample_vs')

# SAML Authentication Usage
### Prerequisite:
1. SAML configured/enabled Controller.

To set up SAML SSO controller, [click here](https://avinetworks.com/docs/17.2/single-sign-on-with-saml/)

Currently, the SDK supports two IDPs for SAML-based authentication:
1) Okta
2) Onelogin

## SAML-based Session Usage for the Okta IDP

```python
from avi.sdk.saml_avi_api import OktaSAMLApiSession
# create Avi API Session
api = OktaSAMLApiSession("10.10.10.42", "okta_username", "okta_password")

# create virtualservice using pool sample_pool
pool_obj = api.get_object_by_name('pool', 'sample_pool')
pool_ref = api.get_obj_ref(pool_obj)
services_obj = [{'port': 80, 'enable_ssl': False}]
vs_obj = {'name': 'sample_vs', 'ip_address': {'addr': '11.11.11.42', 'type': 'V4'},
         'services': services_obj, 'pool_ref': pool_ref}
resp = api.post('virtualservice', data=vs_obj)

# print list of all virtualservices
resp = api.get('virtualservice')
for vs in resp.json()['results']:
    print vs['name']

# delete virtualservice
resp = api.delete_by_name('virtualservice', 'sample_vs')
```

## SAML-based Session Usage for the OneLogin IDP

```python
from avi.sdk.saml_avi_api import OneloginSAMLApiSession
# create Avi API Session
api = OneloginSAMLApiSession("10.10.10.42", "onelogin_username", "onelogin_password")

# create virtualservice using pool sample_pool
pool_obj = api.get_object_by_name('pool', 'sample_pool')
pool_ref = api.get_obj_ref(pool_obj)
services_obj = [{'port': 80, 'enable_ssl': False}]
vs_obj = {'name': 'sample_vs', 'ip_address': {'addr': '11.11.11.42', 'type': 'V4'},
         'services': services_obj, 'pool_ref': pool_ref}
resp = api.post('virtualservice', data=vs_obj)

# print list of all virtualservices
resp = api.get('virtualservice')
for vs in resp.json()['results']:
    print vs['name']

# delete virtualservice
resp = api.delete_by_name('virtualservice', 'sample_vs')
```

SAML session can also be invoked by following:
```
api = ApiSession.get_session("10.10.10.42", "onelogin_username", "onelogin_password", idp_class=OneloginSAMLApiSession)
```
```
api = ApiSession.get_session("10.10.10.42", "onelogin_username", "onelogin_password", idp_class=OktaSAMLApiSession)
```



# Control Script Usage
 If ApiSession is invoked in the context of a control
  script, then token can be used for authentication. Along with that,
  information regarding username and tenant information can also be retrieved
  as follows::

      token=os.environ.get('API_TOKEN')
      user=os.environ.get('USER')
      tenant=os.environ.get('TENANT')
      api = ApiSession.get_session("localhost", user, token=token, tenant=tenant)


# virtualservice_examples_api Usage
 Create a basic virtualservice named
  basic-vs:

   virtualservice_examples_api.py -h
   virtualservice_examples_api.py -c 10.10.25.42 -i 10.90.64.141 -o create-basic-vs -s 10.90.64.12

