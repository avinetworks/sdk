package com.vmware.avi.sdk;




import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


import com.vmware.avi.sdk.dto.HealthMonitor;
import com.vmware.avi.sdk.dto.HealthMonitors;
import com.vmware.avi.sdk.dto.HttpMonitor;


public class AviNsxSdkTest {

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