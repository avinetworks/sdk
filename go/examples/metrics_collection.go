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
	// flag.Lookup("logtostderr").Value.Set("false")
	// Create a session and a generic client to Avi Controller
	aviClient, err := clients.NewAviClient("10.10.25.42", "admin",
		session.SetPassword(""),
		session.SetTenant("admin"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	//fmt.Printf("Avi Controller Version: %v\n", aviClient.AviSession.GetControllerVersion())

	mr := MetricRequest{Step: 1, Limit: 1, EntityUUID: "*", MetricID: "l7_server.max_concurrent_sessions", IncludeName: "True", IncludeRefs: "True", PadMissingData: "False"}
	sr := []MetricRequest{}
	sr = append(sr, mr)
	req := Metrics{MetricRequests: sr}
	path := "/api/analytics/metrics/collection"
	var rsp interface{}
	aviClient.AviSession.Post(path, req, &rsp)

	fmt.Printf("response %v\n", rsp)
}
