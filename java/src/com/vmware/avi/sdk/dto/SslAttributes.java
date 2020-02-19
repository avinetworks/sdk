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
@JsonPropertyOrder({ "ssl_profile_ref" })
public class SslAttributes implements Serializable {

	@JsonProperty("ssl_profile_ref")
	private String sslProfileRef;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7171334132777353916L;

	@JsonProperty("ssl_profile_ref")
	public String getSslProfileRef() {
		return sslProfileRef;
	}

	@JsonProperty("ssl_profile_ref")
	public void setSslProfileRef(String sslProfileRef) {
		this.sslProfileRef = sslProfileRef;
	}

	public SslAttributes withSslProfileRef(String sslProfileRef) {
		this.sslProfileRef = sslProfileRef;
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

	public SslAttributes withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("sslProfileRef", sslProfileRef)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(sslProfileRef).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SslAttributes) == false) {
			return false;
		}
		SslAttributes rhs = ((SslAttributes) other);
		return new EqualsBuilder().append(sslProfileRef, rhs.sslProfileRef)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}