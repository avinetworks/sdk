package com.vmware.avi.sdk.dto;

import java.io.Serializable;
import java.util.HashMap;
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
@JsonPropertyOrder({ "udp_request" })
public class UdpMonitor implements Serializable {

	@JsonProperty("udp_request")
	private String udpRequest;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4878001349161595846L;

	@JsonProperty("udp_request")
	public String getUdpRequest() {
		return udpRequest;
	}

	@JsonProperty("udp_request")
	public void setUdpRequest(String udpRequest) {
		this.udpRequest = udpRequest;
	}

	public UdpMonitor withUdpRequest(String udpRequest) {
		this.udpRequest = udpRequest;
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

	public UdpMonitor withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("udpRequest", udpRequest)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(udpRequest).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof UdpMonitor) == false) {
			return false;
		}
		UdpMonitor rhs = ((UdpMonitor) other);
		return new EqualsBuilder().append(udpRequest, rhs.udpRequest)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}