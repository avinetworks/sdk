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
@JsonPropertyOrder({ "rcode", "query_name", "qtype", "record_type" })
public class DnsMonitor implements Serializable {

	@JsonProperty("rcode")
	private String rcode;
	@JsonProperty("query_name")
	private String queryName;
	@JsonProperty("qtype")
	private String qtype;
	@JsonProperty("record_type")
	private String recordType;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 2124880182083940591L;

	@JsonProperty("rcode")
	public String getRcode() {
		return rcode;
	}

	@JsonProperty("rcode")
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public DnsMonitor withRcode(String rcode) {
		this.rcode = rcode;
		return this;
	}

	@JsonProperty("query_name")
	public String getQueryName() {
		return queryName;
	}

	@JsonProperty("query_name")
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public DnsMonitor withQueryName(String queryName) {
		this.queryName = queryName;
		return this;
	}

	@JsonProperty("qtype")
	public String getQtype() {
		return qtype;
	}

	@JsonProperty("qtype")
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public DnsMonitor withQtype(String qtype) {
		this.qtype = qtype;
		return this;
	}

	@JsonProperty("record_type")
	public String getRecordType() {
		return recordType;
	}

	@JsonProperty("record_type")
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public DnsMonitor withRecordType(String recordType) {
		this.recordType = recordType;
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

	public DnsMonitor withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("rcode", rcode).append("queryName", queryName).append("qtype", qtype)
				.append("recordType", recordType).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(queryName).append(rcode).append(additionalProperties).append(qtype)
				.append(recordType).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DnsMonitor) == false) {
			return false;
		}
		DnsMonitor rhs = ((DnsMonitor) other);
		return new EqualsBuilder().append(queryName, rhs.queryName).append(rcode, rhs.rcode)
				.append(additionalProperties, rhs.additionalProperties).append(qtype, rhs.qtype)
				.append(recordType, rhs.recordType).isEquals();
	}

}