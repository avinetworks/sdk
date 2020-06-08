# Avi Go SDK and Utilities

Avi Go SDK is a Go Package that provides APIs to communicate with Avi Controller’s REST APIs. It uses Avisession class and provides utilities to simplify integration with Avi controller.

It handles session authentication and keeps a cache of sessions to avoid multiple connection setups and teardowns across different API Session invocation. It automatically updates session cookies, 
CSRF Tokens from controller and provides helper APIs and templates for Avi Objects. Other important features are X-AVI-TENANT (tenant) header handling and sample source code for common load balancing examples.

Here are list of important SDK directories

- **Go**: Source for the Go SDK. No need to download packages. Go will take care of a packages installations.
Here are list of important SDK directories
    - **examples**: Go sample are in directory go/examples.
        - **create_vs.go**: Gives example to create session and generic client to Avi Controller, Create pool with one 
        server, Create SSL VS and Fetch object by name.
   
    - **clients**: It contains AviClients which are needed to establish connection between the Go SDK and Avi Controller
     using the Avi session class. Each resource has its own client to establish connection.
   
    - **sessions**: It contains all generic code of REST calls for Avi session and helper routines from REST API calls. 
    It creates and maintains session for a given resurce.
   
    - **models**: It contains all models required to capture the API response. Basically its nothing but the structures 
    to grab and store data of corresponding REST API calls.
# Prerequisites
Go Lang ([Click here](https://golang.org/doc/install) for more information)

# Installation
They can be installed simply as:
### Avi Go SDK Install
```sh
$ mkdir -p src/github.com/avinetworks/
$ cd src/github.com/avinetworks/
$ git clone https://github.com/avinetworks/sdk.git
#GOPATH will be path till src dir.
$ export GOPATH=~/src
```

### Usage Examples
To create session, pool and a basic virtualservice named my-test-vs you need to execute create_vs.go file.
Before executing this script you need to specify AVI controller IP, username, 
password and tenant in create_vs.go file.

- Import AVI session, models and clients:

```go
package main

import (
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	)
``` 
- Create AVI API session:

```go
aviClient, err := clients.NewAviClient("10.10.25.25", "admin",
		session.SetPassword("something"),
		session.SetTenant("admin"),
		session.SetInsecure)
```

- Create pool 'my-test-pool' with one server:

```go
pobj := models.Pool{}
pname := "my-test-pool"
pobj.Name = &pname
serverobj := models.Server{}
enabled := true
serverobj.Enabled = &enabled
ipType := "V4"
addr := "10.90.20.12"
serverobj.IP = &models.IPAddr{Type: &ipType, Addr: &addr}
pobj.Servers = append(pobj.Servers, &serverobj)

npobj, err := aviClient.Pool.Create(&pobj)
if err != nil {
  fmt.Println("Pool creation failed: ", err)
  return
}
```

- Create vsvip 'test-vip' :

```go
vsVip := models.VsVip{}
vipAddr := "10.90.20.51"
vipip := models.IPAddr{Type: &ipType, Addr: &vipAddr}
vipId := "1"
vipObj := models.Vip{VipID: &vipId, IPAddress: &vipip}

vipName := "test-vip"
vsVip.Name = &vipName
vsVip.Vip = append(vsVip.Vip, &vipObj)

vsVipObj, err := aviClient.VsVip.Create(&vsVip)

if err != nil {
    fmt.Println("VIP creation failed: ", err)
}
```

- Create virtualservice 'my-test-vs' using pool 'my-test-pool':

```go
vsobj := models.VirtualService{}
vname := "my-test-vs"
vsobj.Name = &vname
vsobj.VsvipRef = vsVipObj.UUID
vsobj.PoolRef = npobj.UUID
port := int32(80)
vsobj.Services = append(vsobj.Services, &models.Service{Port: &port})

nvsobj, err := aviClient.VirtualService.Create(&vsobj)
if err != nil {
    fmt.Println("VS creation failed: ", err)
    return
}
fmt.Printf("VS obj: %+v", *nvsobj)
```

- Fetching object by name:

```go
var obj interface{}
err = aviClient.AviSession.GetObjectByName("virtualservice", "my-test-vs", &obj)
fmt.Printf("VS obj: %v\n", obj)

err = aviClient.AviSession.GetObject(
	"virtualservice", session.SetName("my-test-vs"), session.SetResult(&obj),
	session.SetCloudUUID("cloud-f39f950a-e6ca-442d-b546-fc31520991bb"))
fmt.Printf("VS with CLOUD_UUID obj: %v", obj)
```

- Delete virtualservice

```go
aviClient.VirtualService.Delete(nvsobj.UUID)
```
- Delete pool

```go
aviClient.Pool.Delete(npobj.UUID)
```

- Creating a session with Lazy Authentication:

```go
avisess, err := NewAviSession(AVI_CONTROLLER, "admin",
		SetPassword(AVI_PASSWORD), SetLazyAuthentication(true))
```

- create_vs.go Usage - Create a basic virtualservice named my-test-vs: 

```sh
$ go run create_vs.go
```

- Metric and Inventory API example:
```go
package main

import (
	//"flag"
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)

type MetricRequest struct {
	Step           int    `json:"step"`
	Limit          int    `json:"limit"`
	EntityUUID     string `json:"entity_uuid"`
	MetricID       string `json:"metric_id"`
	IncludeName    string `json:"include_name"`
	IncludeRefs    string `json:"include_refs"`
	PadMissingData string `json:"pad_missing_data"`
}

type Metrics struct {
	MetricRequests []MetricRequest `json:"metric_requests"`
}

func main() {
	// Create a session and a generic client to Avi Controller
	aviClient, err := clients.NewAviClient("10.10.25.42", "admin",
		session.SetPassword(""),
		session.SetTenant("admin"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	mr := MetricRequest{Step: 1, Limit: 1, EntityUUID: "*", MetricID: "l7_server.max_concurrent_sessions", IncludeName: "True", IncludeRefs: "True", PadMissingData: "False"}
	sr := []MetricRequest{}
	sr = append(sr, mr)
	req := Metrics{MetricRequests: sr}
	path := "/api/analytics/metrics/collection"
	var rsp interface{}
	aviClient.AviSession.Post(path, req, &rsp)
	fmt.Printf("response %v\n", rsp)
}
```
- To compile:

```sh
$ go build -o /usr/bin/create_vs create_vs.go
```
- To include Go SDK in third party code:

Following is an example entry of vendor.json file in Terraform provider
```go
"package": [{
                "path": "github.com/avinetworks/sdk/go/clients",
                "revision": "23def4e6c14b4da8ac2ed8007337bc5eb5007998",
                "revisionTime": "2016-01-25T20:49:56Z",
                "version": "18.1.3",
                "versionExact": "18.1.3"
            },
            {
                "path": "github.com/avinetworks/sdk/go/session",
                "revision": "23def4e6c14b4da8ac2ed8007337bc5eb5007998",
                "revisionTime": "2016-01-25T20:49:56Z",
                "version": "18.1.3",
                "versionExact": "18.1.3"
            }]
```

Following is an example to import Go SDK packages in third party Go code
```go
import (
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)
```
