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
@JsonPropertyOrder({ "tcp_half_open" })
public class TcpMonitor implements Serializable {

	@JsonProperty("tcp_half_open")
	private Boolean tcpHalfOpen;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6153250520155327570L;

	@JsonProperty("tcp_half_open")
	public Boolean getTcpHalfOpen() {
		return tcpHalfOpen;
	}

	@JsonProperty("tcp_half_open")
	public void setTcpHalfOpen(Boolean tcpHalfOpen) {
		this.tcpHalfOpen = tcpHalfOpen;
	}

	public TcpMonitor withTcpHalfOpen(Boolean tcpHalfOpen) {
		this.tcpHalfOpen = tcpHalfOpen;
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

	public TcpMonitor withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tcpHalfOpen", tcpHalfOpen)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tcpHalfOpen).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof TcpMonitor) == false) {
			return false;
		}
		TcpMonitor rhs = ((TcpMonitor) other);
		return new EqualsBuilder().append(tcpHalfOpen, rhs.tcpHalfOpen)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}