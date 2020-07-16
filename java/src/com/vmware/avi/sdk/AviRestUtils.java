package com.vmware.avi.sdk;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpCookie;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AviRestUtils {

	static final Logger LOGGER = Logger.getLogger(AviRestUtils.class.getName());
	private static HashMap<String, RestTemplate> sessionPool = new HashMap<String, RestTemplate>();
	private static final String API_PREFIX = "/api/";

	public static RestTemplate getRestTemplate(AviCredentials creds) {
		LOGGER.info("__INIT__ Rest template initialization..");
		RestTemplate restTemplate = null;
		if (creds != null) {
			if (sessionPool.containsKey(getSessionKey(creds))) {
				return sessionPool.get(getSessionKey(creds));
			}
			try {
				restTemplate = getInitializedRestTemplate(creds);
				DefaultUriTemplateHandler templateHandler = new DefaultUriTemplateHandler();
				templateHandler.setBaseUrl(getControllerURL(creds)+ API_PREFIX);
				restTemplate.setUriTemplateHandler(templateHandler);
				List<ClientHttpRequestInterceptor> interceptors = 
						Collections.<ClientHttpRequestInterceptor>singletonList(
								new AviAuthorizationInterceptor(creds));
				restTemplate.setInterceptors(interceptors);
				restTemplate.setMessageConverters(getMessageConverters(restTemplate));
				AviRestUtils.sessionPool.put(getSessionKey(creds), restTemplate);
				LOGGER.info("__DONE__ Rest template initialize.");
				return restTemplate;
			} catch (Exception e) {
				LOGGER.severe("Exception during rest template initialization");

			}
		}
		return restTemplate;
	}

	private static List<HttpMessageConverter<?>> getMessageConverters(RestTemplate restTemplate) {
        // Get existing message converters
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.clear();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MappingJackson2HttpMessageConverter mycov = new MappingJackson2HttpMessageConverter(objectMapper);
        mycov.setPrettyPrint(true);
        messageConverters.add(mycov);
        return messageConverters;
    }

	private static RestTemplate getInitializedRestTemplate(AviCredentials creds) {
		try {
			CloseableHttpClient client = buildHttpClient(creds);
			return new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));

		} catch (Exception e) {
			LOGGER.severe("Exception in creating rest template for AVI connection");
		}
		return null;
	}
	
	/**
	 * This method sets a custom HttpRequestRetryHandler in order to enable a custom
	 * exception recovery mechanism.
	 * 
	 * @return A HttpRequestRetryHandler representing handling of the retryHandler.
	 */
	private static HttpRequestRetryHandler retryHandler(AviCredentials creds) {
		return (exception, executionCount, context) -> {
			LOGGER.info("__INIT__ Inside retry_handler..");
			if (executionCount >= creds.getNumApiRetries()) {
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
			LOGGER.info("__DONE__ Retry handler.");
			return false;
		};
	}


	public static CloseableHttpClient buildHttpClient(AviCredentials creds) {
		LOGGER.info("__INIT__ Inside buildHttpClient..");
		CloseableHttpClient httpClient = null;
		if (!creds.getVerify()) {
			SSLContext sslcontext = null;
			try {
				sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			} catch (Exception e) {
				e.printStackTrace();
			}

			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext,
					(s, sslSession) -> true);

			httpClient = HttpClients.custom().setRetryHandler(retryHandler(creds))
					.setSSLSocketFactory(sslConnectionSocketFactory)
					.setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy(
							creds.getNumApiRetries(), creds.getRetryWaitTime())).disableCookieManagement()
					.build();
		} else {
			httpClient = HttpClients.custom().setRetryHandler(retryHandler(creds))
					.setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy(
							creds.getNumApiRetries(), creds.getRetryWaitTime())).disableCookieManagement()
					.build();
		}
		LOGGER.info("__DONE__ BuildHttpClient completed");
		return httpClient;
	}

	/**
	 * This method authenticates user based on the credentials and update the
	 * csrftoken and session id for this session.
	 */
	public static void authenticateSession(AviCredentials aviCredentials) {
		LOGGER.info("__INIT__ Inside authentication session for.. " + aviCredentials.getUsername());
		JSONObject body = new JSONObject();
		body.put("username", aviCredentials.getUsername());
		if (aviCredentials.getPassword() != null && !aviCredentials.getPassword().isEmpty()) {
			body.put("password", aviCredentials.getPassword());
		} else if (aviCredentials.getToken() != null && !aviCredentials.getToken().isEmpty()) {
			body.put("token", aviCredentials.getToken());
		}
		CloseableHttpClient httpClient = buildHttpClient(aviCredentials);
		try {
			String postUrl = getControllerURL(aviCredentials) + "/login";
			HttpPost postRequest = new HttpPost(postUrl);
			StringEntity input = new StringEntity(body.toString());
			input.setContentType("application/json");
			postRequest.addHeader("X-Avi-Version", aviCredentials.getVersion());
			postRequest.addHeader("X-Avi-Tenant", aviCredentials.getTenant());
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode > 299) {
				LOGGER.severe("Login faild with status code " + statusCode);
				throw new IOException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			String output = EntityUtils.toString(response.getEntity());
			JSONObject result = new JSONObject(output);
			String sessionCookieName = result.get("session_cookie_name").toString();
			String csrftoken = null;
			String sessionCookie = null;
			for (Header header : response.getHeaders("Set-Cookie")) {
				List<HttpCookie> httpCookies = HttpCookie.parse(header.getValue());
				for (HttpCookie cookie : httpCookies) {
					if (cookie.getName().equals("csrftoken")) {
						csrftoken = cookie.getValue();
					} else if (cookie.getName().equals(sessionCookieName)) {
						sessionCookie = cookie.getValue();
					}
				}
			}
			aviCredentials.setCsrftoken(csrftoken);
			aviCredentials.setSessionID(sessionCookie);
			LOGGER.info("__DONE__ Authentication session success for:: " + aviCredentials.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	public static String getSessionKey(AviCredentials aviCredentials) {
		return aviCredentials.getController() + ":" + aviCredentials.getUsername() + ":"
				+ aviCredentials.getPort();
	}

	/**
	 * This method returns the controller URL based on controller IP and controller
	 * port.
	 * 
	 * @return A String representing the controller URL.
	 */
	public static String getControllerURL(AviCredentials aviCredentials) {
		StringBuffer sb = new StringBuffer();
		if (aviCredentials.getController().startsWith("http")) {
			if (Arrays.asList(80, 443).contains(aviCredentials.getPort())) {
				sb.append(aviCredentials.getController());
			} else {
				sb.append(aviCredentials.getController());
				sb.append(":");
				sb.append(aviCredentials.getPort());
			}
		} else {
			if (aviCredentials.getPort() == 443) {
				sb.append("https://");
				sb.append(aviCredentials.getController());
			} else if (aviCredentials.getPort() == 80) {
				sb.append("http://");
				sb.append(aviCredentials.getController());
			} else {
				sb.append("https://");
				sb.append(aviCredentials.getController());
				sb.append(":");
				sb.append(aviCredentials.getPort());
			}
		}
		return sb.toString();
	}

	/**
	 * This method sets all HTTP request headers.
	 * 
	 * @param request A HttpRequestBase containing all require headers.
	 * @throws Exception
	 */
	public static void buildHeaders(HttpRequestBase request, HashMap<String, String> userHeaders, AviCredentials aviCredentials) throws Exception {
		LOGGER.info("__INIT__ Inside buildHeaders..");
		if (null == aviCredentials.getSessionID() || aviCredentials.getSessionID().isEmpty()) {
			authenticateSession(aviCredentials);
		}
		request.addHeader("Content-Type", "application/json");
		request.addHeader("X-Avi-Version", aviCredentials.getVersion());
		request.addHeader("X-Avi-Tenant", aviCredentials.getTenant());
		request.addHeader("X-CSRFToken", aviCredentials.getCsrftoken());
		request.addHeader("Referer", getControllerURL(aviCredentials));

		request.addHeader("Cookie", "csrftoken=" + aviCredentials.getCsrftoken() + "; " + "avi-sessionid="
				+ aviCredentials.getSessionID());

		if ((null != userHeaders) && (!userHeaders.isEmpty())) {
			for (String key : userHeaders.keySet()) {
				request.addHeader(key, userHeaders.get(key));
			}
		}
		LOGGER.info("__DONE__ Inside buildHeaders..");
	}
}
