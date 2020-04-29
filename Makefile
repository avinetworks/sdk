#Makefile to compile go source files and test the clients and models

export AVI_USERNAME ?= ""
export AVI_PASSWORD ?= ""
export AVI_CONTROLLER ?= localhost:8080//
export AVI_TENANT=admin
export AVI_VERSION ?= 18.2.9

compile:
	go build ./go/clients
	go vet ./go/clients ./go/models
	go build ./go/examples/create_vs.go
	go build ./go/examples/metrics_collection.go
	rm -rf create_vs metrics_collection

test: test_clients test_avisession

test_clients:
ifeq ($(AVI_CONTROLLER), localhost:8080//)
	nohup python ./go/examples/web_service.py &
endif
	go test ./go/examples/test/create_cloud_test.go ./go/examples/test/create_tenant_test.go ./go/examples/test/create_profiles_test.go ./go/examples/test/create_healthmonitor_test.go ./go/examples/test/create_virtualservice_test.go ./go/examples/test/api_filters_test.go ./go/examples/test/delete_configuration_test.go -v

test_avisession:
	go test ./go/session/. -v

fmt:
	go fmt ./go/clients ./go/models ./go/examples
