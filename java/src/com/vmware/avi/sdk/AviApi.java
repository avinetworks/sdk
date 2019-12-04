package com.vmware.avi.sdk;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AviApi {

	static final Logger logger = Logger.getLogger(AviApi.class.getName());

	public AviApi(AviCredentials aviCredentials) {
		this.aviCredentials = aviCredentials;
		this.sessionKey = aviCredentials.getController()+":"+aviCredentials.getUsername()+
				":"+aviCredentials.getPort();
	}

	private static HashMap<String, AviApi> sessionPool = new HashMap<String, AviApi>();
	int numApiExecCount = 0;
	private AviCredentials aviCredentials;
	private String sessionKey;

	public static AviApi getSession(AviCredentials aviCredentials) throws IOException {
		String sessionKey = aviCredentials.getController()+":"+aviCredentials.getUsername()+
				":"+aviCredentials.getPort();
		if (sessionPool.containsKey(sessionKey)) {
			return sessionPool.get(sessionKey);
		} else {
			AviApi session = new AviApi(aviCredentials);
			if (!aviCredentials.getLazyAuthentication()) {
				session.authenticateSession();
			}
			sessionPool.put(session.sessionKey, session);
			return session;
		}
	}

	public String getControllerURL() {
		if (this.aviCredentials.getController().startsWith("http")) {
			if (Arrays.asList(80, 443).contains(this.aviCredentials.getPort())) {
				return this.aviCredentials.getController();
			} else {
				return this.aviCredentials.getController()+":"+this.aviCredentials.getPort();
			}
		} else {
			if (this.aviCredentials.getPort() == 443) {
				return "https://"+this.aviCredentials.getController();
			} else if(this.aviCredentials.getPort() == 80) {
				return "http://"+this.aviCredentials.getController();
			} else {
				return "https://"+this.aviCredentials.getController()+
						":"+this.aviCredentials.getPort();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void authenticateSession() {
		JSONObject body = new JSONObject();
		body.put("username", this.aviCredentials.getUsername());
		if (this.aviCredentials.getPassword() != "" || this.aviCredentials.getPassword() != null) {
			body.put("password", this.aviCredentials.getPassword());
		}else if (this.aviCredentials.getToken() != "" || this.aviCredentials.getToken() != null) {
			body.put("token", this.aviCredentials.getToken());
		}
		logger.info("Authentication session for "+ this.aviCredentials.getUsername());
		CloseableHttpClient httpClient = this.buildHttpClient();
		try {
			String postUrl = this.getControllerURL() + "/login";

			HttpPost postRequest = new HttpPost(postUrl);
			StringEntity input = new StringEntity(body.toString());
			input.setContentType("application/json");
			postRequest.addHeader("X-Avi-Version", this.aviCredentials.getVersion());
			postRequest.addHeader("X-Avi-Tenant", this.aviCredentials.getTenant());
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode > 299) {
				logger.severe("Login faild with status code "+ statusCode);
				throw new IOException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			String output = EntityUtils.toString(response.getEntity());
			JSONParser parser = new JSONParser();
			JSONObject result = (JSONObject) parser.parse(output);
			String sessionCookieName = result.get("session_cookie_name").toString();
			String csrftoken = null;
			String sessionCookie = null;
			for (Header header : response.getHeaders("Set-Cookie")) {
				List<HttpCookie> httpCookies = HttpCookie.parse(header.getValue());
				for (HttpCookie cookie : httpCookies) {
					if (cookie.getName().equals("csrftoken")){
						csrftoken = cookie.getValue();
					}
					else if (cookie.getName().equals(sessionCookieName)) {
						sessionCookie = cookie.getValue();
					}
				}
			}
			this.aviCredentials.setCsrftoken(csrftoken);
			this.aviCredentials.setSessionID(sessionCookie);
			AviApi.sessionPool.put(this.sessionKey, this);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		finally {
			if(null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public JSONObject get(String path, Map<String, String> params) throws AviApiException{
		CloseableHttpClient httpClient = null;
		try {
			String getUrl = this.getControllerURL() + "/api/"+ path;
			URIBuilder uriBuilder = new URIBuilder(getUrl);

			if (null != params && !params.isEmpty()) {
				List<NameValuePair> urlParameters = new ArrayList<>();
				for (String key : params.keySet()) {
					urlParameters.add(new BasicNameValuePair(key, params.get(key)));
				}
				uriBuilder.addParameters(urlParameters);
			}

			httpClient = this.buildHttpClient();
			HttpGet request = new HttpGet(uriBuilder.build());
			this.buildHeaders(request);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] {path, params};
			Class[] mParams = new Class[] {String.class, Map.class};
			Method m = AviApi.class.getMethod("get", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		}catch (IOException | URISyntaxException | NoSuchMethodException | SecurityException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.severe("Exception in GET : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
		finally {
			if(null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public JSONObject put(String path, JSONObject body) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = this.buildHttpClient();
			String putUrl = this.getControllerURL() + "/api/"+ path +"/" + body.get("uuid");
			HttpPut request = new HttpPut(putUrl);
			StringEntity input = new StringEntity(body.toString());
			request.setEntity(input);
			this.buildHeaders(request);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] {path, body};
			Class[] mParams = new Class[] {String.class, JSONObject.class};
			Method m = AviApi.class.getMethod("put", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.severe("Exception in PUT : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
		finally {
			if(null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}


	@SuppressWarnings("rawtypes")
	public JSONObject post(String path, JSONObject body) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			httpClient = this.buildHttpClient();
			String postUrl = this.getControllerURL() + "/api/"+ path;
			HttpPost request = new HttpPost(postUrl);
			StringEntity input = new StringEntity(body.toString());
			request.setEntity(input);
			this.buildHeaders(request);
			HttpResponse response = httpClient.execute(request);

			Object[] args = new Object[] {path, body};
			Class[] mParams = new Class[] {String.class, JSONObject.class};
			Method m = AviApi.class.getMethod("post", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.severe("Exception in POST : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
		finally {
			if(null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public JSONObject delete(String path, String uuid) throws AviApiException {
		CloseableHttpClient httpClient = null;
		try {
			String deleteUrl = this.getControllerURL() + "/api/"+path+"/"+ uuid;
			httpClient = this.buildHttpClient();
			HttpDelete request = new HttpDelete(deleteUrl);
			this.buildHeaders(request);
			HttpResponse response = httpClient.execute(request);
			Object[] args = new Object[] {path, uuid};
			Class[] mParams = new Class[] {String.class, String.class};
			Method m = AviApi.class.getMethod("delete", mParams);
			JSONObject result = this.parseResponse(response, m, args);
			return result;

		}catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.severe("Exception in DELETE : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
		finally {
			if(null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private JSONObject parseResponse(HttpResponse response, Method m, Object[] args) throws AviApiException {
		try {
			int responseCode = response.getStatusLine().getStatusCode();
			if (Arrays.asList(419, 401).contains(responseCode)) {
				this.numApiExecCount++;
				if (numApiExecCount < this.aviCredentials.getNumApiRetries()) {
					this.authenticateSession();
					JSONObject result = (JSONObject) m.invoke(this, args);
					this.numApiExecCount = 0;
					return result;
				}
			}
			else if (responseCode > 299) {
				StringBuffer errMessage = new StringBuffer();
				errMessage.append("Failed : HTTP error code : ");
				errMessage.append(responseCode);
				if (null != response.getEntity()) {
					errMessage.append(" Error Message :");
					errMessage.append(EntityUtils.toString(response.getEntity()));
				}
				throw new AviApiException(errMessage.toString());
			}
			if (null != response.getEntity()) {
				String output = EntityUtils.toString(response.getEntity());
				JSONParser parser = new JSONParser();
				JSONObject result = (JSONObject) parser.parse(output);
				return result;
			} else {
				if (m.getName().equals("delete")){
					JSONObject result = new JSONObject();
					result.put("Message", "Object deleted successfully");
					return result;
				}else {
					return null;
				}
			}
		}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | ParseException | IOException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.severe("Exception in parsing response : " + e.getMessage() + sw.toString());
			throw new AviApiException(e);
		}
	}

	private HttpRequestRetryHandler retryHandler(){
		return (exception, executionCount, context) -> {

			if (executionCount >= this.aviCredentials.getNumApiRetries()) {
				// Do not retry if over max retry count
				return false;
			}
			if (exception instanceof InterruptedIOException) {
				// Timeout
				return false;
			}
			if (exception instanceof UnknownHostException) {
				// Unknown host
				return false;
			}
			if (exception instanceof SSLException) {
				// SSL handshake exception
				return false;
			}
			if (exception instanceof HttpHostConnectException) {
				return true;
			}
			HttpClientContext clientContext = HttpClientContext.adapt(context);
			HttpRequest request = clientContext.getRequest();
			boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
			if (idempotent) {
				// Retry if the request is considered idempotent
				return true;
			}
			return false;
		};
	}

	public void buildHeaders(HttpRequestBase request) {
		if (null == this.aviCredentials.getSessionID() || this.aviCredentials.getSessionID().isEmpty()) {
			this.authenticateSession();
		}
		request.addHeader("Content-Type", "application/json");
		request.addHeader("X-Avi-Version", this.aviCredentials.getVersion());
		request.addHeader("X-Avi-Tenant", this.aviCredentials.getTenant());
		request.addHeader("X-CSRFToken", this.aviCredentials.getCsrftoken());
		request.addHeader("Referer", this.getControllerURL());
		request.addHeader("Cookie", "csrftoken="+this.aviCredentials.getCsrftoken()+
				"; "+"avi-sessionid="+this.aviCredentials.getSessionID());
	}

	private CloseableHttpClient buildHttpClient() {
		CloseableHttpClient httpClient = null;
		if (!this.aviCredentials.getVerify()) {
			SSLContext sslcontext = null;
			try {
				sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			} catch (Exception e) {
				e.printStackTrace();
			}

			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext,
					(s, sslSession) -> true);

			httpClient = HttpClients.custom()
					.setRetryHandler(this.retryHandler()).setSSLSocketFactory(sslConnectionSocketFactory)
					.setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy(
							this.aviCredentials.getNumApiRetries(), this.aviCredentials.getRetryWaitTime()))
					.build();
		}else {
			httpClient = HttpClients.custom()
					.setRetryHandler(this.retryHandler()).
					setServiceUnavailableRetryStrategy(
							new DefaultServiceUnavailableRetryStrategy(
									this.aviCredentials.getNumApiRetries(), this.aviCredentials.getRetryWaitTime()))
					.build();
		}
		return httpClient;
	}
}
