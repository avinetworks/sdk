package com.vmware.avi.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class MockAviSDKTest {
	private static final String CONTROLLER = "";
	private static final String USERNAME = "";
	private static final Integer PORT = 443;
	
	AviApi aviapi;
	AviCredentials avicredentials;
	public String sessionKey;
	private static HashMap<String, AviApi> sessionPool = new HashMap<String, AviApi>();
	
	@Before
	public void setUp(){
		aviapi = mock(AviApi.class);
		avicredentials = mock(AviCredentials.class);
	}

	@Test	
	public void testgetSession() throws Exception {
		sessionKey = Mockito.when(avicredentials.getController()).thenReturn(CONTROLLER) + ":" 
						+ Mockito.when(avicredentials.getUsername()).thenReturn(USERNAME)+ ":"
					    + Mockito.when(avicredentials.getPort()).thenReturn(PORT);
		
		if (sessionPool.containsKey(sessionKey)) {
			Mockito.when(AviApi.getSession(avicredentials)).thenReturn(sessionPool.get(sessionKey));
		}else {
			AviApi session = new AviApi(avicredentials);
			sessionPool.put(sessionKey, session);
		}
	}
	
	@Test
	public void testPost() throws Exception{
		try {
		    // POST test case        
			Object obj = new JSONParser().parse(new FileReader("InputFile.json"));
			JSONObject jo = (JSONObject) obj; 
			JSONObject postInput = (JSONObject)jo.get("postInput"); 
			JSONObject postOutput = (JSONObject)jo.get("postOutput");
			Mockito.when(aviapi.post("pool", postInput)).thenReturn(postOutput);
			String objectName = (String)postOutput.get("name").toString();
			assertEquals("test-example", objectName);
			
		}catch (AviApiException | ParseException | NullPointerException e) {
		e.printStackTrace(System.err);
	}
}	
	@Test
	public void testGet() throws Exception{
		try {
			// GET test case
			Object obj = new JSONParser().parse(new FileReader("InputFile.json"));
			JSONObject jo = (JSONObject) obj; 
			JSONObject postOutput = (JSONObject)jo.get("postOutput");
			JSONObject getOutput = (JSONObject)jo.get("getOutput");
			String objectName = postOutput.get("name").toString();
			Map<String, String> val = new HashMap<String, String>();
			val.put("name", objectName);
			Mockito.when(aviapi.get("pool", val)).thenReturn(getOutput);
			JSONArray resp = (JSONArray)getOutput.get("results");
			JSONObject result = (JSONObject)resp.get(0);
			String name = (String)result.get("name");
			assertEquals(objectName, name);
		}
		catch (AviApiException | ParseException | NullPointerException e) {
		e.printStackTrace(System.err);
	}
}
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() throws Exception{
		try {
			// PUT test case
			
			Object obj = new JSONParser().parse(new FileReader("InputFile.json"));
			JSONObject jo = (JSONObject) obj; 
			JSONObject getOutput = (JSONObject)jo.get("getOutput");
			JSONObject putOutput = (JSONObject)jo.get("putOutput");
			JSONArray resp = (JSONArray)getOutput.get("results");
			JSONObject result = (JSONObject)resp.get(0);
			String objectName = result.get("name").toString();
			result.replace("name", "test-pool");
			Mockito.when(aviapi.put("pool", result)).thenReturn(putOutput);
			String updatedName  = (String)putOutput.get("name");
			assertNotEquals(objectName, updatedName);
            
        }
		catch (AviApiException | ParseException | NullPointerException e) {
		e.printStackTrace(System.err);
	}
}
	@Test
	public void testDelete() throws Exception{
		try {        
			// DELETE test case		
			Object obj = new JSONParser().parse(new FileReader("InputFile.json"));
			JSONObject jo = (JSONObject) obj; 
			JSONObject putOutput = (JSONObject)jo.get("putOutput");
			String name = putOutput.get("name").toString();
			String uuid = putOutput.get("uuid").toString();
			Mockito.when(aviapi.delete("pool", uuid)).thenReturn(null);
			String deleteRes = "{\"error\":\"Pool object not found!\"}";
			JSONParser parser = new JSONParser();
			JSONObject delRes = (JSONObject) parser.parse(deleteRes);
			Map<String, String> val = new HashMap<String, String>();
			val.put("name", name);
			Mockito.when(aviapi.get("pool", val)).thenReturn(delRes);
			String msg = delRes.get("error").toString();
			assertEquals("Pool object not found!", msg);
	            
			}
			catch (AviApiException | ParseException | NullPointerException e) {
			e.printStackTrace(System.err);
		}
	}
}
