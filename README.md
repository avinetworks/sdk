# Avi SDK and Utilities

[![Build Status](https://travis-ci.org/avinetworks/sdk.svg?branch=17.1.4_pytest)](https://travis-ci.org/avinetworks/sdk)

This repository includes API documentation, SDK and sample source to integrate
into the Avi Solution. Below is brief description of the contents.

- **doc**: Avi API documentation includes documentation for the load balancer
objects, Analytics Metrics, and Log Analytics APIs.
- **python**: Source for the Python SDK. The pip package can be downloaded from
[Releases](https://github.com/avinetworks/sdk/releases "Avi SDK Releases").
Here are list of important SDK directories:
    - **samples**: Python samples are in the python/avi/sdk/samples directory.
        - **autoscale**: Gives ControlScript examples for
        server autoscaling.
        - **heat**: Provides a heat example for pool servers that can be used
        with the server autoscale feature and ControlScripts.
        - **virtualservice_examples_api**: Provides examples of programmatically
        creating most common virtual services, such as basic VS, SSL VS, analytics
        APIs, tenant-based APIs, etc.
    - **utils**: Useful utilities for devops automation.
        - **f5_converter**: Is a utility for converting an F5 configuration into
        an Avi Vantage configuration.
        - **httppolicyset_templates**: Provides easy-to-use templates for
        creating HTTP request and redirect policies for most common use cases.
        - **Mesos**: Provides CRUD APIs to create a Marathon app with Avi labels.

# AVI SDK includes following tools and utilities:

**[Avi API SDK and Utilities](./python/avi/sdk/README.md)**

**[Avi Migration Tools](./python/avi/sdk/README.md)**

**[Avi Go SDK and Utilities](./go/README.md)**

**[SNMP MIBs](./mibs/README.txt)**

**[Swagger UI Dist](./swagger/README.md)**
