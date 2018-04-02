package main

import (
	"os"
	"os/exec"
	"strings"
	"testing"
)


func TestCreateCloud(t *testing.T) {
	os.Setenv("testenv", "true")
	os.Setenv("testname", "TestCreateCloud")

	command := "go run create_cloud.go"
	parts := strings.Fields(command)
	cmd := exec.Command(parts[0], parts[1:]...)
	cmd.Stderr = os.Stderr
	cmd.Stdout = os.Stdout
	err := cmd.Run()
	if err != nil {
		panic(err)
	}
}


func TestCreateTenant(t *testing.T) {
	os.Setenv("testenv", "true")
	os.Setenv("testname", "TestCreateTenant")

	command := "go run create_tenant.go"
	parts := strings.Fields(command)
	cmd := exec.Command(parts[0], parts[1:]...)
	cmd.Stderr = os.Stderr
	cmd.Stdout = os.Stdout
	err := cmd.Run()
	if err != nil {
		panic(err)
	}
}


func TestCreateHealthMonitor(t *testing.T) {
	os.Setenv("testenv", "true")
	os.Setenv("testname", "TestHealthmonitor")

	command := "go run create_healthmonitor.go"
	parts := strings.Fields(command)
	cmd := exec.Command(parts[0], parts[1:]...)
	cmd.Stderr = os.Stderr
	cmd.Stdout = os.Stdout
	err := cmd.Run()
	if err != nil {
		panic(err)
	}
}