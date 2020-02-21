package com.vmware.avi.sdk;



import java.io.IOException;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vmware.avi.sdk.dto.HealthMonitor;
import com.vmware.avi.sdk.dto.HealthMonitors;
import com.vmware.avi.sdk.dto.HttpMonitor;

public class AviRestClient {

	//private static final String API_ROOT = "http://localhost:8080/api/portal/";
	
	private CredentialsProvider setAuthProvider(){
	    CredentialsProvider provider = new BasicCredentialsProvider();
	    provider.setCredentials(
	            AuthScope.ANY,
	            new UsernamePasswordCredentials("abc123", "abc123")
	            );
	    return provider;
	}
	

	private SSLContext getSSLContext() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
		return sslcontext;
	}
	
	private  HostnameVerifier  getHostNameVerifier() {
			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
			return allowAllHosts;
	}
	
    
    private HttpClient  getHttpClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
    	HttpClient httpClient = HttpClientBuilder.create().
				setDefaultCredentialsProvider(setAuthProvider()).setSSLHostnameVerifier(getHostNameVerifier())
				.setSslcontext(getSSLContext())
				.build();
    	return httpClient;
    }
	
	public <T> T invokeGetRestApi(String url, Class<T> classz) {
		try {
			HttpClient httpClient = getHttpClient();
			
			// Create new getRequest with below mentioned URL
			HttpGet getRequest = new HttpGet(url);
			
			getRequest.addHeader("content-type", "application/json");
			getRequest.addHeader("X-Avi-Version", "18.2.8");
			getRequest.addHeader("X-Avi-Tenant", "admin");
			
			HttpResponse response = httpClient.execute(getRequest);
			//String json = EntityUtils.toString(response.getEntity(), "UTF-8");
			//System.out.println("JSON "+json);
			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			ObjectMapper objectMapper = new ObjectMapper();
			//String obstr = response.getEntity().getContent().toString();
			
			T obj = objectMapper.readValue(response.getEntity().getContent(), classz);
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public <T,S> S invokePostRestApi(String url,Object postBody, Class<T> classz, Class<S> classy) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		try {
			HttpClient httpClient = getHttpClient();
			
			// Create new getRequest with below mentioned URL
			HttpPost postRequest = new HttpPost(url);
			
			postRequest.addHeader("content-type", "application/json");
			postRequest.addHeader("X-Avi-Version", "18.2.8");
			postRequest.addHeader("X-Avi-Tenant", "admin");
			

			ObjectMapper objectMapper = new ObjectMapper();
			StringWriter objStr = new StringWriter();
			T entity = classz.cast(postBody);
			objectMapper.writeValue(objStr, entity);
			//System.out.println("objStr JSON is\n"+objStr);
		    postRequest.setEntity(new StringEntity(objStr.toString()));
		    // send the post request
		    HttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 201) {
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}
			}
			objectMapper = new ObjectMapper();
			S obj = objectMapper.readValue(response.getEntity().getContent(), classy);
			//System.out.println(obj.toString());
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		String API_ROOT = "";
		AviRestClient restClient = new AviRestClient();
		HealthMonitors monitors = restClient.invokeGetRestApi(API_ROOT + "healthmonitor", HealthMonitors.class);
		System.out.println(monitors.toString());
		
		HealthMonitor httpHealthMonitor = new HealthMonitor();
		httpHealthMonitor.setName("manoj-alb-http-monitor");
		httpHealthMonitor.setReceiveTimeout(4);
		httpHealthMonitor.setIsFederated(false);
		httpHealthMonitor.setFailedChecks(2);
		httpHealthMonitor.setSendInterval(10);
		httpHealthMonitor.setType("HEALTH_MONITOR_HTTP");
		
		HttpMonitor httpMonitor = new HttpMonitor();
		httpMonitor.setExactHttpRequest(true);
		httpMonitor.setHttpRequest("POST");
		httpMonitor.setHttpResponseCode(Arrays.asList(new String[] { "HTTP_2XX", "HTTP_4XX" }));
		httpMonitor.setAdditionalProperty("maintenance_code", Arrays.asList(new String[] { "206", "409" }));
		httpMonitor.setAdditionalProperty("maintenance_response", 205);
		httpHealthMonitor.setHttpMonitor(httpMonitor);
		
		httpMonitor.setAdditionalProperty("name","manoj-http-monitor");
		httpMonitor.setAdditionalProperty("description","manoj-http-monitor");
		
		HealthMonitor hm1 = restClient.invokePostRestApi(API_ROOT + "healthmonitor", httpHealthMonitor, HealthMonitor.class, HealthMonitor.class);
		System.out.println("HM1 "+hm1.getUuid());
		
	}
	
	

}