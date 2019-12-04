package com.vmware.avi.sdk.examples;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.vmware.avi.sdk.AviApi;
import com.vmware.avi.sdk.AviApiException;
import com.vmware.avi.sdk.AviCredentials;

public class AviSDKExamples {

	private static final String CONTROLLER = "10.10.28.15";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "avi123$%";
	private static final String VERSION = "18.2.6";
	private static final String TENANT = "admin";
	private static AviCredentials creds = null;

	static AviCredentials getCreds() {
		if (null == AviSDKExamples.creds) {
			AviSDKExamples.creds = new AviCredentials(
					AviSDKExamples.CONTROLLER, AviSDKExamples.USERNAME, 
					AviSDKExamples.PASSWORD);
			creds.setVersion(AviSDKExamples.VERSION);
			creds.setTenant(AviSDKExamples.TENANT);
			return creds;
		} else {
			return AviSDKExamples.creds; 
		}
	}

	public static JSONObject postExample() {
		try {

			AviApi serv = new AviApi(AviSDKExamples.getCreds());
			String pool_str = "{\n" + 
					"	\"lb_algorithm\": \"LB_ALGORITHM_LEAST_CONNECTIONS\",\n" + 
					"	\"default_server_port\": 80,\n" + 
					"	\"enabled\": true,\n" + 
					"	\"servers\": [{\n" + 
					"		\"enabled\": false,\n" + 
					"		\"ip\": {\n" + 
					"			\"addr\": \"1.2.3.4\",\n" + 
					"			\"type\": \"V4\"\n" + 
					"		}\n" + 
					"	}],\n" + 
					"	\"name\": \"test-example1\"\n" + 
					"}";

			JSONParser parser = new JSONParser();
			JSONObject body = (JSONObject) parser.parse(pool_str);
			JSONObject response = serv.post("pool", body);
			System.out.println(response);
			return response;

		} catch (AviApiException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JSONObject putExample(JSONObject body) {
		try {
			AviApi serv = AviApi.getSession(AviSDKExamples.getCreds());
			JSONObject response = serv.put("pool", body);
			System.out.println(response);
			return response;

		} catch (AviApiException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void getExample() {
		try {
			AviApi serv = AviApi.getSession(AviSDKExamples.creds);
			JSONObject pools = serv.get("pool", null);
			System.out.println(pools);
		} catch (AviApiException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteExample(String poolUuid) {
		try {
			AviApi serv = AviApi.getSession(AviSDKExamples.creds);
			JSONObject pools = serv.delete("pool", poolUuid);
			System.out.println(pools);
		} catch (AviApiException | IOException e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject pool = AviSDKExamples.postExample();
		String poolUuid = (String) pool.get("uuid");
		JSONObject servers = (JSONObject) ((JSONArray) pool.get("servers")).get(0);
		servers.put("enabled", false);
		pool = AviSDKExamples.putExample(pool);
		AviSDKExamples.getExample();
		AviSDKExamples.deleteExample(poolUuid);
	}

}
