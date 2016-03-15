# Avi SDK and Utilities 

This repository includes API documentation, SDK and sample source to integrate 
into Avi Solution. Here is brief description of the contents

- **doc**: Avi API documentation. It includes documentation for the load balancer 
objects, Analytics Metrics, and Log Analytics APIs.
- **python**: Source for the python SDK. The pip package can be downloaded from
[Releases](https://github.com/avinetworks/sdk/releases "Avi SDK Releases"). 
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
        - **f5_converter**: It is utility for converting F5 configuration into 
        AVI configuration
        - **httppolicyset_templates**: Provides easy to use templates for 
        creating HTTP request and redirect policies for most common use cases
        - **Mesos**: Provides CRUD apis to create Marathon App with AVI labels


