package com.vmware.avi.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class AviSDKTest {
	static final Logger LOGGER = Logger.getLogger(AviSDKTest.class.getName());

	private static final String CONTROLLER = System.getenv("AVI_CONTROLLER");
	private static final String USERNAME = System.getenv("AVI_USERNAME");
	private static final String PASSWORD = System.getenv("AVI_PASSWORD");
	private static final String VERSION = System.getenv("AVI_VERSION");
	private static final String TENANT = System.getenv("AVI_TENANT");

	private static AviCredentials creds = null;

	static AviCredentials getCredsToken() {
		if (null == AviSDKTest.creds) {
			String token = AviSDKTest.getToken();
			AviSDKTest.creds = new AviCredentials(
					AviSDKTest.CONTROLLER, AviSDKTest.USERNAME);
			creds.setVersion(AviSDKTest.VERSION);
			creds.setTenant(AviSDKTest.TENANT);
			creds.setToken(token);
			return creds;
		} else {
			return AviSDKTest.creds;
		}
	}

	static AviCredentials getCredsPassword() {
		if (null == AviSDKTest.creds) {
			AviSDKTest.creds = new AviCredentials(
					AviSDKTest.CONTROLLER, AviSDKTest.USERNAME, AviSDKTest.PASSWORD);
			creds.setVersion(AviSDKTest.VERSION);
			creds.setTenant(AviSDKTest.TENANT);
			return creds;
		} else {
			return AviSDKTest.creds;
		}
	}

	private static String getToken() {
		AviCredentials aviCreds = new AviCredentials(CONTROLLER, USERNAME, PASSWORD);
		aviCreds.setVersion(AviSDKTest.VERSION);
		aviCreds.setTenant(AviSDKTest.TENANT);
		AviApi aviApi = new AviApi(aviCreds);
		JSONObject obj = new JSONObject();
		obj.put("hours", 1);
		try {
			JSONObject result = aviApi.post("user-token", obj);
			return result.getString("token");
		} catch (AviApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Test
	public void testExample() throws Exception {
		try {
			AviApi serv = new AviApi(AviSDKTest.getCredsToken());
			String content = readFile("InputFile.json", StandardCharsets.UTF_8);
			JSONObject obj = new JSONObject(content);
			JSONObject postInput = (JSONObject) obj.get("postInput");
			String poolStr = postInput.toString();

			JSONObject body = new JSONObject(poolStr);
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
            putResult.put("name", "test-pool");

			JSONObject updateRes = serv.put("pool", result);
            String updatedName  = (String)updateRes.get("name");

            assertNotSame(objectName, updatedName);

            // DELETE test case
            JSONObject deleteRes = serv.delete("pool", uuid);
            assertTrue(deleteRes.isEmpty());

		} catch (AviApiException  e) {
			e.printStackTrace(System.err);
		}
	}
	@Test
	public void testPostFileUpload() throws Exception {
		try {
			AviApi serv = new AviApi(AviSDKTest.getCredsPassword());
			serv.fileUpload("fileservice/hsmpackages?hsmtype=safenet", "/mnt/files/hsmpackages/safenet.tar",
					"controller://hsmpackages");
		} catch (AviApiException e) {
			e.printStackTrace(System.err);
		}
	}

	@Test
	public void downloadTextFile() throws Exception {
		try {
			AviApi serv = new AviApi(AviSDKTest.getCredsPassword());
			Map<String, String> param = new HashMap<String, String>();
			param.put("full_system", "true");
			param.put("passphrase", "abc1234");
			serv.fileDownload("/configuration/export", "/tmp/file.txt", param);
		} catch (AviApiException e) {
			e.printStackTrace(System.err);
		}
	}

	@Test
	public void downloadJsonFile() throws Exception {
		try {
			AviApi serv = new AviApi(AviSDKTest.getCredsPassword());
			Map<String, String> param = new HashMap<String, String>();
			param.put("passphrase", "abc1234");
			serv.fileDownload("/configuration/export", "/tmp/file.json", param);
		} catch (AviApiException e) {
			e.printStackTrace(System.err);
		}
	}
	@Test
	public void downloadTarFile() throws Exception {
		try {
			AviApi serv = new AviApi(AviSDKTest.getCredsPassword());
			Map<String, String> param = new HashMap<String, String>();
			param.put("uri", "controller://tech_support/portal.20200225-082451.tar.gz");
			serv.fileDownload("/fileservice", "/tmp/file.tar", param);
		} catch (AviApiException e) {
			e.printStackTrace(System.err);
		}
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path), encoding);
		return String.join(System.lineSeparator(), lines);
	}
}
