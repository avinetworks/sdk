package com.vmware.avi.sdk;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

public class AviApiRestUtils {
	
	
	private static class AviAuthorizationInterceptor implements ClientHttpRequestInterceptor {

        private final AviCredentials creds;


        public AviAuthorizationInterceptor(AviCredentials creds) {
            this.creds = creds;
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            if (creds.getUsername() != null) {
                byte[] token = org.apache.commons.codec.binary.Base64
                        .encodeBase64((this.creds.getUsername() + ":" + this.creds.getPassword()).getBytes());
                request.getHeaders().add("Authorization", "Basic " + new String(token));
            }
            return execution.execute(request, body);
        }
        
        private void buildHeaders(HttpRequestBase request) {
    		if (null == this.creds.getSessionID() || this.creds.getSessionID().isEmpty()) {
    			this.authenticateSession();
    		}
    		request.addHeader("Content-Type", "application/json");
    		request.addHeader("X-Avi-Version", this.creds.getVersion());
    		request.addHeader("X-Avi-Tenant", this.creds.getTenant());
    		request.addHeader("X-CSRFToken", this.creds.getCsrftoken());
    		request.addHeader("Referer", this.getControllerURL());
    		request.addHeader("Cookie", "csrftoken=" + this.creds.getCsrftoken() + "; " + "avi-sessionid="
    				+ this.creds.getSessionID());
    	}
        
        private void authenticateSession() {
    		JSONObject body = new JSONObject();
    		body.put("username", this.creds.getUsername());
    		if (this.creds.getPassword() != null && !this.creds.getPassword().isEmpty()) {
    			body.put("password", this.creds.getPassword());
    		} else if (this.creds.getToken() != null && !this.creds.getToken().isEmpty()) {
    			body.put("token", this.creds.getToken());
    		}
    		LOGGER.info("Authentication session for " + this.creds.getUsername());
    		CloseableHttpClient httpClient = this.buildHttpClient();
    		try {
    			String postUrl = this.getControllerURL() + "/login";
    			HttpPost postRequest = new HttpPost(postUrl);
    			StringEntity input = new StringEntity(body.toString());
    			input.setContentType("application/json");
    			postRequest.addHeader("X-Avi-Version", this.creds.getVersion());
    			postRequest.addHeader("X-Avi-Tenant", this.creds.getTenant());
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
    			this.creds.setCsrftoken(csrftoken);
    			this.creds.setSessionID(sessionCookie);
    			AviApi.sessionPool.put(this.sessionKey, this);
    		} catch (IOException e) {
    			e.printStackTrace();
    		} finally {
    			if (null != httpClient) {
    				try {
    					httpClient.close();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	}
        
        
        private String getControllerURL() {
    		StringBuffer sb = new StringBuffer();
    		if (this.creds.getController().startsWith("http")) {
    			if (Arrays.asList(80, 443).contains(this.creds.getPort())) {
    				sb.append(this.creds.getController());
    			} else {
    				sb.append(creds.getController());
    				sb.append(":");
    				sb.append(this.creds.getPort());
    			}
    		} else {
    			if (this.creds.getPort() == 443) {
    				sb.append("https://");
    				sb.append(this.creds.getController());
    			} else if (this.creds.getPort() == 80) {
    				sb.append("http://");
    				sb.append(this.creds.getController());
    			} else {
    				sb.append("https://");
    				sb.append(this.creds.getController());
    				sb.append(":");
    				sb.append(this.creds.getPort());
    			}
    		}
    		return sb.toString();
    	}
    }
	
	
	public static RestTemplate getRestTemplate(AviCredentials creds) {
		String sessionKey = creds.getController() + ":" + creds.getUsername() + ":"
				+ creds.getPort();
        if (creds.getUsername() != null) {
            try {
                RestTemplate restTemplate = getInitializedRestTemplate(sessionKey, true);
                List<ClientHttpRequestInterceptor> interceptors = Collections
                        .<ClientHttpRequestInterceptor>singletonList(
                                new AviAuthorizationInterceptor(creds));
                restTemplate.setInterceptors(interceptors);
                return restTemplate;
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else {
            RestTemplate restTemplate = getInitializedRestTemplate(sessionKey, false);
            return restTemplate;
        }
        return null;
    }
	
	
	private static RestTemplate getInitializedRestTemplate(String thumbprint, boolean defaultKeystore) {
        try {
            RequestConfig config = RequestConfig.custom().setSocketTimeout(socketTimeOut * 1000)
                    .setConnectTimeout(connectionTimeOut * 1000).build();

            CloseableHttpClient client = HttpClients.custom()
                    .setConnectionManager(getConnectionManager(thumbprint, defaultKeystore))
                    .setDefaultRequestConfig(config)
                    .build();
            return new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
        } catch (Exception e) {
            logger.error(Logger.SYSLOG_MARKER,
                    com.vmware.nsx.management.policy.policyframework.exceptions.ErrorCode.CONDITION_PARAMETER_NULL
                            .getId(),
                    e, "Exception in creating rest template for NSX t connection");
        }
        return null;
    }

}
