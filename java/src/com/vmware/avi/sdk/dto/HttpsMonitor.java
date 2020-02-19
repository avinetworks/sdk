package com.vmware.avi.sdk.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "exact_http_request", "http_request", "http_response_code", "ssl_attributes" })
public class HttpsMonitor implements Serializable {

	@JsonProperty("exact_http_request")
	private Boolean exactHttpRequest;
	@JsonProperty("http_request")
	private String httpRequest;
	@JsonProperty("http_response_code")
	@Valid
	private List<String> httpResponseCode = null;
	@JsonProperty("ssl_attributes")
	@Valid
	private SslAttributes sslAttributes;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -401865671519261498L;

	@JsonProperty("exact_http_request")
	public Boolean getExactHttpRequest() {
		return exactHttpRequest;
	}

	@JsonProperty("exact_http_request")
	public void setExactHttpRequest(Boolean exactHttpRequest) {
		this.exactHttpRequest = exactHttpRequest;
	}

	public HttpsMonitor withExactHttpRequest(Boolean exactHttpRequest) {
		this.exactHttpRequest = exactHttpRequest;
		return this;
	}

	@JsonProperty("http_request")
	public String getHttpRequest() {
		return httpRequest;
	}

	@JsonProperty("http_request")
	public void setHttpRequest(String httpRequest) {
		this.httpRequest = httpRequest;
	}

	public HttpsMonitor withHttpRequest(String httpRequest) {
		this.httpRequest = httpRequest;
		return this;
	}

	@JsonProperty("http_response_code")
	public List<String> getHttpResponseCode() {
		return httpResponseCode;
	}

	@JsonProperty("http_response_code")
	public void setHttpResponseCode(List<String> httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}

	public HttpsMonitor withHttpResponseCode(List<String> httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
		return this;
	}

	@JsonProperty("ssl_attributes")
	public SslAttributes getSslAttributes() {
		return sslAttributes;
	}

	@JsonProperty("ssl_attributes")
	public void setSslAttributes(SslAttributes sslAttributes) {
		this.sslAttributes = sslAttributes;
	}

	public HttpsMonitor withSslAttributes(SslAttributes sslAttributes) {
		this.sslAttributes = sslAttributes;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public HttpsMonitor withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("exactHttpRequest", exactHttpRequest).append("httpRequest", httpRequest)
				.append("httpResponseCode", httpResponseCode).append("sslAttributes", sslAttributes)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(exactHttpRequest).append(httpRequest).append(httpResponseCode)
				.append(additionalProperties).append(sslAttributes).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HttpsMonitor) == false) {
			return false;
		}
		HttpsMonitor rhs = ((HttpsMonitor) other);
		return new EqualsBuilder().append(exactHttpRequest, rhs.exactHttpRequest).append(httpRequest, rhs.httpRequest)
				.append(httpResponseCode, rhs.httpResponseCode).append(additionalProperties, rhs.additionalProperties)
				.append(sslAttributes, rhs.sslAttributes).isEquals();
	}

}
