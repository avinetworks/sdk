package com.vmware.avi.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.vmware.avi.sdk.AviApi;
import com.vmware.avi.sdk.AviApiException;
import com.vmware.avi.sdk.AviCredentials;

import org.junit.Test;
import org.junit.Rule;

public class AviSDKTest {
	static final Logger LOGGER = Logger.getLogger(AviSDKTest.class.getName());
	
	private static final String CONTROLLER = System.getenv("AVI_CONTROLLER");
	private static final String USERNAME = System.getenv("AVI_USERNAME");
	private static final String PASSWORD = System.getenv("AVI_PASSWORD");
	private static final String VERSION = System.getenv("AVI_VERSION");
	private static final String TENANT = System.getenv("AVI_TENANT");
	
	private static AviCredentials creds = null;
		
	static AviCredentials getCreds() {
		if (null == AviSDKTest.creds) {
			AviSDKTest.creds = new AviCredentials(
					AviSDKTest.CONTROLLER, AviSDKTest.USERNAME, 
					AviSDKTest.PASSWORD);
			creds.setVersion(AviSDKTest.VERSION);
			creds.setTenant(AviSDKTest.TENANT);
			return creds;
		} else {
			return AviSDKTest.creds; 
		}
	}
	
	@Test
	public void testExample() throws ParseException, AviApiException{
		try {

			AviApi serv = new AviApi(AviSDKTest.getCreds());
			
			String poolStr = "{\n" + 
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
					"	\"name\": \"test-example\"\n" + 
					"}";

			JSONParser parser = new JSONParser();
			JSONObject body = (JSONObject) parser.parse(poolStr);
			JSONObject response = serv.post("pool", body);
			String objectName = response.get("name").toString();
			
			assertEquals("test-example", objectName);

			// GET rest call
			Map<String, String> val = new HashMap<String, String>();
			val.put("name", objectName);
			JSONObject pools = serv.get("pool",val);
			JSONArray resp = (JSONArray) pools.get("results");
            JSONObject result = (JSONObject)resp.get(0);
			String name = (String)result.get("name");
			String uuid = (String)result.get("uuid");
			
			assertEquals(objectName, name);

			// PUT test case
			Map<String, String> value = new HashMap<String, String>();
			val.put("name", objectName);
			JSONObject request = serv.get("pool",value);
			JSONArray res = (JSONArray) request.get("results");
            JSONObject putResult= (JSONObject)res.get(0);
            putResult.replace("name", "test-pool");
            
			JSONObject updateRes = serv.put("pool", result);
            String updatedName  = (String)updateRes.get("name");
            
            assertNotSame(objectName, updatedName);

            // DELETE test case
            JSONObject deleteRes = serv.delete("pool", uuid);
			String msg = deleteRes.get("Message").toString();
			assertEquals("Object deleted successfully", "Object deleted successfully", msg);

		} catch (AviApiException | ParseException e) {
			e.printStackTrace(System.err);
		}
	}		
}
