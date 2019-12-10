package com.vmware.avi.sdk.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.FixMethodOrder;

import com.vmware.avi.sdk.AviApi;
import com.vmware.avi.sdk.AviApiException;
import com.vmware.avi.sdk.AviCredentials;

import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AviSDKTest {
	static final Logger logger = Logger.getLogger(AviSDKTest.class.getName());
	
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
	public void testAviSdk() throws ParseException, AviApiException, IOException {
		try {
			// Test Post
			AviApi serv = AviApi.getSession(AviSDKTest.getCreds());
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
					"	\"name\": \"test-example\"\n" + 
					"}";

			JSONParser parser = new JSONParser();
			JSONObject body = (JSONObject) parser.parse(pool_str);
			JSONObject postResponse = serv.post("pool", body);
			String objectName = postResponse.get("name").toString();
			assertEquals("test-example", objectName);
			
			// Test get
			Map<String, String> val = new HashMap<String, String>();
			val.put("name", objectName);
			JSONObject pools = serv.get("pool",val);
			JSONArray getResponse = (JSONArray) pools.get("results");
            JSONObject result = (JSONObject)getResponse.get(0);
			String name = (String)result.get("name");
			assertEquals(objectName, name);
			
			// Test put
			result.replace("name", "test-pool");
			JSONObject putResponse = serv.put("pool", result);
            String nameUpdated  = (String)putResponse.get("name");
            assertNotSame(objectName, nameUpdated);
            
            // Test delete
            String uuid = (String)result.get("uuid");
			JSONObject response = serv.delete("pool", uuid);
			String msg = response.get("Message").toString();
			assertEquals("Object deleted successfully", "Object deleted successfully", msg);

		} catch (AviApiException | ParseException e) {
			e.printStackTrace(System.err);
		}
	}	
}
