package com.vmware.avi.sdk;

import java.util.List;

import com.vmware.avi.sdk.model.Pool;

public class TestTemp {
	
	private static final String CONTROLLER = "10.79.109.242";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String VERSION = "18.2.8";
	private static final String TENANT = "admin";
	
	public static void main(String[] args) throws Exception {
		AviCredentials creds = new AviCredentials(CONTROLLER, USERNAME, PASSWORD);
		creds.setVersion(VERSION);
		creds.setTenant(TENANT);
		
		AviApi api = new AviApi(creds);
		
		List<Pool> pools = (List<Pool>) api.get(Pool.class, null);
		Pool pool = pools.get(0);
		pool.setDescription("Pool Updated");
		Pool p = api.put(pool);
		System.out.println(p);
	}

}
