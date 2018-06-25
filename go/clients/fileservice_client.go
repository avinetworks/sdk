package clients

import (
	"github.com/avinetworks/sdk/go/session"
)

// FileServiceClient is a client for avi FileService resource
type FileServiceClient struct {
	aviSession *session.AviSession
}

// NewFileServiceClient creates a new client for FileService resource
// func NewFileServiceClient(aviSession *session.AviSession) *FileServiceClient {
// return &FileServiceClient{aviSession: aviSession}
//}
func NewFileServiceClient(aviSession *session.AviSession) *FileServiceClient {
	return &FileServiceClient{aviSession: aviSession}
}
func (client *FileServiceClient) getAPIPath(uuid string) string {
	path := "api/fileservice/"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// Get an existing FileService api status
func (client *FileServiceClient) Get(uuid string) (error) {
	//var obj *models.FileService
	var obj interface{}
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return err
}