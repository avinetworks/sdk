package com.vmware.avi.sdk;

import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.function.Supplier;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RestTemplateFactory {
	private final RestTemplate restTemplate;
	class MyRequestFactorySupplier implements Supplier<ClientHttpRequestFactory> {
		@Override
		public ClientHttpRequestFactory get() {
			// Using Apache HTTP client.
			SSLContext sslcontext = null;
			try {
				sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			} catch (Exception e) {
				e.printStackTrace();
			}

			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext,
					(s, sslSession) -> true);

			CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(this.retryHandler())
					.setSSLSocketFactory(sslConnectionSocketFactory)
					.setServiceUnavailableRetryStrategy(new DefaultServiceUnavailableRetryStrategy(
							3, 10))
					.build();
			HttpComponentsClientHttpRequestFactory requestFactory =
					new HttpComponentsClientHttpRequestFactory(httpClient);
			requestFactory.setBufferRequestBody(false);
			// When sending large amounts of data via POST or PUT, it is recommended to change this property to false, so as not to run out of memory.
			return requestFactory;
		}
		
		private HttpRequestRetryHandler retryHandler() {
			return (exception, executionCount, context) -> {

				if (executionCount >= 3) {
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
	}
	public RestTemplateFactory(RestTemplateBuilder templateBuilder) {
		this.restTemplate = templateBuilder.requestFactory(new MyRequestFactorySupplier()).build();
	}
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
}