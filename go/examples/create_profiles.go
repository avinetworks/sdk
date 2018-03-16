package main


import (
	//"flag"
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

func main() {

	aviClient, err := clients.NewAviClient("10.10.28.99", "admin",
		session.SetPassword("avi123$%"),
		session.SetTenant("webapp"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)


	// get virtual service
	var obj interface{}
	err = aviClient.AviSession.GetObjectByName("tenant", "webapp", &obj)
	if err == nil {
		fmt.Printf("### VS obj: %v\n %s", obj)
		uuid := obj.(map[string]interface{})["uuid"]
		fmt.Printf("### VS uuid: %v\n %s", uuid)
	}
	uuid := obj.(map[string]interface{})["uuid"]
	fmt.Printf("Tenant uuid %v\n", uuid)

	// Create health monitor in avinetworks tenant
	profileobj := models.ApplicationPersistenceProfile{}
	profileobj.IsFederated = false
	profileobj.PersistenceType = "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS"
	profileobj.Name = "Test-Persistece-Profile"
	profileobj.TenantRef = uuid.(string)
	ipobj := models.IPPersistenceProfile{IPPersistentTimeout: 5}
	profileobj.IPPersistenceProfile = &ipobj
	npobj, err := aviClient.ApplicationPersistenceProfile.Create(&profileobj)
	if err != nil {
		fmt.Println("Pool creation failed: ", err)
		return
	}
	fmt.Println("Application persistence profile ", npobj)
	fmt.Println("\n ###### ", profileobj)

	//sslobj := SSLProfile{}
	//sslobj.Name= "Test-Ssl-Profile"
	//sslobj.TenantRef= uuid.(string)
	//sslobj.EnableSslSessionReuse = true

}