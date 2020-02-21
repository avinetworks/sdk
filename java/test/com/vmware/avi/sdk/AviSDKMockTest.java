package com.vmware.avi.sdk;

import static com.github.tomakehurst.wiremock.client.WireMock.aMultipart;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.binaryEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.matching;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class AviSDKMockTest {

	AviCredentials avicredentials;
	static final Logger LOGGER = Logger.getLogger(AviSDKMockTest.class.getName());

	@Before
	public void setUp() {
		avicredentials = mock(AviCredentials.class);
	}

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8090);

	private HttpResponse httpGetCall() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet("http://localhost:8090/api/pool/pool-0a70a98c-0b7b-4f32-9c93-13a74fcf8201");
		request.addHeader("Accept", "text/html");
		return httpClient.execute(request);
	}

	private HttpResponse httpPostCall() throws IOException {
		String content = readFile("InputFile.json", StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(content);
		JSONObject postInput = (JSONObject) obj.get("postInput");
		String poolStr = postInput.toString();
		StringEntity entity = new StringEntity(poolStr);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost("http://localhost:8090/api/pool");
		request.addHeader("Content-Type", "application/json");
		request.setEntity(entity);
		return httpClient.execute(request);
	}

	@Test
	public void testAuthenticateSession() throws ClientProtocolException, IOException {
		JSONObject body = new JSONObject();
		body.put("username", avicredentials.getUsername());
		if (avicredentials.getPassword() != "" || avicredentials.getPassword() != null) {
			body.put("password", avicredentials.getPassword());
		} else if (avicredentials.getToken() != "" || avicredentials.getToken() != null) {
			body.put("token", avicredentials.getToken());
		}

		stubFor(post(urlEqualTo("/api/login")).willReturn(aResponse().withStatus(200)));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost request = new HttpPost("http://localhost:8090/api/login");
		StringEntity input = new StringEntity(body.toString());
		input.setContentType("application/json");
		request.addHeader("X-Avi-Version", avicredentials.getVersion());
		request.addHeader("X-Avi-Tenant", avicredentials.getTenant());
		request.setEntity(input);
		HttpResponse response = httpClient.execute(request);
		verify(postRequestedFor(urlPathEqualTo("/api/login")));
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode > 299) {
			LOGGER.severe("Login faild with status code " + statusCode);
			throw new IOException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
	}

	@Test
	public void testPostCall200()
			throws ClientProtocolException, IOException, NoSuchMethodException, SecurityException, AviApiException {
		String content = readFile("InputFile.json", StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(content);
		JSONObject postInput = (JSONObject) obj.get("postInput");
		String poolstr = postInput.toString();
		stubFor(post(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json"))
				.withRequestBody(containing(poolstr))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")));

		HttpResponse httpResponse = httpPostCall();
		verify(postRequestedFor(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json")));
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		if (responseCode > 299) {
			StringBuffer errMessage = new StringBuffer();
			errMessage.append("Failed : HTTP error code : ");
			errMessage.append(responseCode);
			if (null != httpResponse.getEntity()) {
				errMessage.append(" Error Message :");
				errMessage.append(EntityUtils.toString(httpResponse.getEntity()));
			}
			throw new AviApiException(errMessage.toString());
		}

	}

	@Test
	public void testPostCall503()
			throws ClientProtocolException, IOException, NoSuchMethodException, SecurityException, AviApiException {
		String content = readFile("InputFile.json", StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(content);
		JSONObject postInput = (JSONObject) obj.get("postInput");
		String poolstr = postInput.toString();

		stubFor(post(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json"))
				.withRequestBody(containing(poolstr)).willReturn(aResponse().withStatus(503)
						.withHeader("Content-Type", "application/json").withBody("Service Unavailable")));
		HttpResponse httpResponse = httpPostCall();
		String stringResponse = convertHttpResponseToString(httpResponse);
		verify(postRequestedFor(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json")));
		assertEquals(503, httpResponse.getStatusLine().getStatusCode());
		assertEquals("Service Unavailable", stringResponse);

	}

	@Test
	public void testGetCall200() throws ClientProtocolException, IOException, AviApiException {
		stubFor(get(urlPathMatching("/api/pool/([a-z0-9-]*)"))
				.willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json")));

		HttpResponse httpResponse = httpGetCall();
		verify(getRequestedFor(urlPathMatching("/api/pool/pool-0a70a98c-0b7b-4f32-9c93-13a74fcf8201")));
		assertEquals("application/json", httpResponse.getFirstHeader("Content-Type").getValue());
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		if (responseCode > 299) {
			StringBuffer errMessage = new StringBuffer();
			errMessage.append("Failed : HTTP error code : ");
			errMessage.append(responseCode);
			if (null != httpResponse.getEntity()) {
				errMessage.append(" Error Message :");
				errMessage.append(EntityUtils.toString(httpResponse.getEntity()));
			}
			throw new AviApiException(errMessage.toString());
		}

	}

	@Test
	public void testGetCall503() throws ClientProtocolException, IOException {
		stubFor(get(urlPathMatching("/api/pool/([a-z0-9-]*)")).withHeader("Accept", matching("text/.*")).willReturn(
				aResponse().withStatus(503).withHeader("Content-Type", "text/html").withBody("Service Unavailable")));

		HttpResponse httpResponse = httpGetCall();
		String stringResponse = convertHttpResponseToString(httpResponse);
		verify(getRequestedFor(urlPathMatching("/api/pool/pool-0a70a98c-0b7b-4f32-9c93-13a74fcf8201")));
		assertEquals(503, httpResponse.getStatusLine().getStatusCode());
		assertEquals("text/html", httpResponse.getFirstHeader("Content-Type").getValue());
		assertEquals("Service Unavailable", stringResponse);

	}

	@Test
	public void testPutCall()
			throws ClientProtocolException, IOException, NoSuchMethodException, SecurityException, AviApiException {
		String content = readFile("InputFile.json", StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(content);
		JSONObject postInput = (JSONObject) obj.get("postInput");
		postInput.put("name", "test-pool");
		String poolstr = postInput.toString();

		stubFor(put(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json"))
				.withRequestBody(containing(poolstr)).willReturn(aResponse().withStatus(200)));

		StringEntity entity = new StringEntity(poolstr);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut request = new HttpPut("http://localhost:8090/api/pool");
		request.addHeader("Content-Type", "application/json");
		request.setEntity(entity);
		HttpResponse httpResponse = httpClient.execute(request);
		verify(putRequestedFor(urlEqualTo("/api/pool")).withHeader("Content-Type", equalTo("application/json")));
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		if (responseCode > 299) {
			StringBuffer errMessage = new StringBuffer();
			errMessage.append("Failed : HTTP error code : ");
			errMessage.append(responseCode);
			if (null != httpResponse.getEntity()) {
				errMessage.append(" Error Message :");
				errMessage.append(EntityUtils.toString(httpResponse.getEntity()));
			}
			throw new AviApiException(errMessage.toString());
		}

	}

	@Test
	public void testDeleteCall()
			throws ClientProtocolException, IOException, NoSuchMethodException, SecurityException, AviApiException {
		stubFor(delete(urlPathMatching("/api/pool/([a-z0-9-]*)")).willReturn(ok().withStatus(204)));

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpDelete request = new HttpDelete("http://localhost:8090/api/pool/pool-0a70a98c-0b7b-4f32-9c93-13a74fcf8201");
		request.addHeader("Content-Type", "application/json");
		HttpResponse httpResponse = httpClient.execute(request);
		verify(deleteRequestedFor(urlPathMatching("/api/pool/pool-0a70a98c-0b7b-4f32-9c93-13a74fcf8201")));
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		if (responseCode > 299) {
			StringBuffer errMessage = new StringBuffer();
			errMessage.append("Failed : HTTP error code : ");
			errMessage.append(responseCode);
			if (null != httpResponse.getEntity()) {
				errMessage.append(" Error Message :");
				errMessage.append(EntityUtils.toString(httpResponse.getEntity()));
			}
			throw new AviApiException(errMessage.toString());
		}
	}

	@Test
	public void testPostFileUpload() throws org.apache.http.ParseException, IOException, AviApiException {
		File f = new File("/mnt/files/hsmpackages/safenet.tar");
		CloseableHttpClient httpClient = HttpClients.createDefault();

		stubFor(post(urlEqualTo("/api/fileservice/hsmpackages?hsmtype=safenet"))
				.withMultipartRequestBody(aMultipart().withName("uri").withBody(containing("controller://hsmpackages")))
				.withMultipartRequestBody(aMultipart().withName("file").withBody(binaryEqualTo(f.getName().getBytes())))
				.willReturn(ok()));

		HttpUriRequest request = RequestBuilder
				.post("http://localhost:8090/api/fileservice/hsmpackages?hsmtype=safenet")
				.setEntity(MultipartEntityBuilder.create()
						.addTextBody("uri", "controller://hsmpackages", ContentType.TEXT_PLAIN)
						.addBinaryBody("file", f.getName().getBytes()).build())
				.build();
		HttpResponse response = httpClient.execute(request);
		verify(postRequestedFor(urlEqualTo("/api/fileservice/hsmpackages?hsmtype=safenet")));
		int responseCode = response.getStatusLine().getStatusCode();
		if (responseCode > 299) {
			StringBuffer errMessage = new StringBuffer();
			errMessage.append("Failed : HTTP error code : ");
			errMessage.append(responseCode);
			if (null != response.getEntity()) {
				errMessage.append(" Error Message :");
				errMessage.append(EntityUtils.toString(response.getEntity()));
			}
			throw new AviApiException(errMessage.toString());
		}
	}

	private String convertHttpResponseToString(HttpResponse httpResponse) throws IOException {
		InputStream inputStream = httpResponse.getEntity().getContent();
		return convertInputStreamToString(inputStream);
	}

	private String convertInputStreamToString(InputStream inputStream) {
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String string = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return string;
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path), encoding);
		return String.join(System.lineSeparator(), lines);
	}

}
