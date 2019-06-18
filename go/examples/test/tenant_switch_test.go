package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/models"
	"os"
	"testing"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)

func TestCreateObjectInDiffTenant(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)
	cv1, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("\n Avi Controller Version: %v:%v\n", cv1, err)

	tenant := "Test-Admin"
	// Use a tenant client to create tenant
	tobj := models.Tenant{}
	tname := tenant
	tobj.Name = &tname

	tres, err := aviClient.Tenant.Create(&tobj)
	if err != nil {
		fmt.Println("\n[ERROR] : ", err)
		t.Fail()
	} else {
		fmt.Println("\nTenant", *tres.Name ,"Created successfully.")
	}
	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pname := "Test-pool"
	pobj.Name = &pname
       serverobj := models.Server{}
	serverobj1 := models.Server{}
	enabled := true
	enabled1 := false
	serverobj.Enabled = &enabled
	serverobj1.Enabled = &enabled1
	Type := "V4"
	addr := "10.90.20.12"
	Type1 := "V4"
	addr1 := "10.90.20.13"
	serverobj.IP = &models.IPAddr{Type: &Type, Addr: &addr}
	serverobj1.IP = &models.IPAddr{Type: &Type1, Addr: &addr1}
	pobj.Servers = append(pobj.Servers, &serverobj)
	pobj.Servers = append(pobj.Servers, &serverobj1)
	tr := "/api/tenant?name=avinetworks"
	pobj.TenantRef = &tr

	npobj, err := aviClient.Pool.Create(&pobj, session.SetOptTenant(tenant))
	if err == nil {
		fmt.Println("\nPOOL", *npobj.Name, "Created successfully in tenant", tenant)
	} else {
		fmt.Printf("\n[ERROR]: %s", err)
		t.Fail()
	}

	// Get pool Object from other tenant.
	plObj1, err := aviClient.Pool.GetObject(session.SetName("Test-pool"), session.SetOptTenant(tenant))
	if err != nil {
		fmt.Printf("\n[ERROR]: %+v", err)
		t.Fail()
	} else {
		fmt.Printf("\nGet Pool Object of name: %+v from tenant %s", *plObj1.Name, tenant)
	}

	nobj, err := aviClient.Pool.Update(plObj1, session.SetOptTenant(tenant))
	if err != nil {
		fmt.Printf("\n[ERROR] : %s", err)
		t.Fail()
	} else {
		fmt.Println("\nUpdated Pool ", *nobj.Name ," in tenant ", tenant ," successfully.")
	}

	obj, err := aviClient.Pool.Get(*nobj.UUID, session.SetOptTenant(tenant))
	if err != nil {
		fmt.Println("\n[ERROR] :", err)
		t.Fail()
	} else {
		fmt.Println("Get Pool Object of name", *obj.Name ,"from tenant", tenant)
	}

	//vservice := models.Pool{}
	pool, err := aviClient.Pool.GetByName("Test-pool", session.SetOptTenant(tenant))
	if err != nil {
		fmt.Println("\n[ERROR] is : ", err)
		t.Fail()
	} else {
		fmt.Println("Get Pool", *pool.Name ,"from tenant", tenant ,"by GetObjectByName.")
	}

	// Delete Pool object of other tenant.
	//err = aviClient.Pool.DeleteByName("Test-pool", session.SetOptTenant("Test-Admin"))
	//if err != nil {
	//	fmt.Println("Error while deleting the object is :", err)
	//} else {
	//	fmt.Println("Object deleted successfully")
	//}

	//nobj1, err := aviClient.Pool.GetAll(session.SetOptTenant("Test-Admin"))
	//if err == nil {
	//	fmt.Println("\n All Pools are : ", *nobj1[0])
	//
	//} else {
	//	fmt.Printf("\n [ERROR] : %s", err)
	//	t.Fail()
	//}


	// Delete Pool Object by UUID from other tenant
	err = aviClient.Pool.Delete(*plObj1.UUID, session.SetOptTenant(tenant))
	if err != nil {
		fmt.Println("Error", err)
		t.Fail()
	} else {
		fmt.Println("Pool Deleted successfully")
	}

	//Delete Pool Object by UUID from admin tenant
	aviClient.Tenant.Delete(*tres.UUID)
}
