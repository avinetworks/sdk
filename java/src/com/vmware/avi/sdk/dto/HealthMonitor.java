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
@JsonPropertyOrder({ "uuid", "receive_timeout", "_last_modified", "url", "tenant_ref", "is_federated", "failed_checks",
		"send_interval", "http_monitor", "successful_checks", "type", "name", "https_monitor", "tcp_monitor",
		"udp_monitor", "dns_monitor", "external_monitor", "monitor_port" })
public class HealthMonitor implements Serializable {

	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("receive_timeout")
	private Integer receiveTimeout;
	@JsonProperty("_last_modified")
	private String lastModified;
	@JsonProperty("url")
	private String url;
	@JsonProperty("tenant_ref")
	private String tenantRef;
	@JsonProperty("is_federated")
	private Boolean isFederated;
	@JsonProperty("failed_checks")
	private Integer failedChecks;
	@JsonProperty("send_interval")
	private Integer sendInterval;
	@JsonProperty("http_monitor")
	@Valid
	private HttpMonitor httpMonitor;
	@JsonProperty("successful_checks")
	private Integer successfulChecks;
	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	@JsonProperty("https_monitor")
	@Valid
	private HttpsMonitor httpsMonitor;
	@JsonProperty("tcp_monitor")
	@Valid
	private TcpMonitor tcpMonitor;
	@JsonProperty("udp_monitor")
	@Valid
	private UdpMonitor udpMonitor;
	@JsonProperty("dns_monitor")
	@Valid
	private DnsMonitor dnsMonitor;
	@JsonProperty("external_monitor")
	@Valid
	private ExternalMonitor externalMonitor;
	@JsonProperty("monitor_port")
	private Integer monitorPort;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1927094530368179004L;

	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}

	@JsonProperty("uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public HealthMonitor withUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	@JsonProperty("receive_timeout")
	public Integer getReceiveTimeout() {
		return receiveTimeout;
	}

	@JsonProperty("receive_timeout")
	public void setReceiveTimeout(Integer receiveTimeout) {
		this.receiveTimeout = receiveTimeout;
	}

	public HealthMonitor withReceiveTimeout(Integer receiveTimeout) {
		this.receiveTimeout = receiveTimeout;
		return this;
	}

	@JsonProperty("_last_modified")
	public String getLastModified() {
		return lastModified;
	}

	@JsonProperty("_last_modified")
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public HealthMonitor withLastModified(String lastModified) {
		this.lastModified = lastModified;
		return this;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	public HealthMonitor withUrl(String url) {
		this.url = url;
		return this;
	}

	@JsonProperty("tenant_ref")
	public String getTenantRef() {
		return tenantRef;
	}

	@JsonProperty("tenant_ref")
	public void setTenantRef(String tenantRef) {
		this.tenantRef = tenantRef;
	}

	public HealthMonitor withTenantRef(String tenantRef) {
		this.tenantRef = tenantRef;
		return this;
	}

	@JsonProperty("is_federated")
	public Boolean getIsFederated() {
		return isFederated;
	}

	@JsonProperty("is_federated")
	public void setIsFederated(Boolean isFederated) {
		this.isFederated = isFederated;
	}

	public HealthMonitor withIsFederated(Boolean isFederated) {
		this.isFederated = isFederated;
		return this;
	}

	@JsonProperty("failed_checks")
	public Integer getFailedChecks() {
		return failedChecks;
	}

	@JsonProperty("failed_checks")
	public void setFailedChecks(Integer failedChecks) {
		this.failedChecks = failedChecks;
	}

	public HealthMonitor withFailedChecks(Integer failedChecks) {
		this.failedChecks = failedChecks;
		return this;
	}

	@JsonProperty("send_interval")
	public Integer getSendInterval() {
		return sendInterval;
	}

	@JsonProperty("send_interval")
	public void setSendInterval(Integer sendInterval) {
		this.sendInterval = sendInterval;
	}

	public HealthMonitor withSendInterval(Integer sendInterval) {
		this.sendInterval = sendInterval;
		return this;
	}

	@JsonProperty("http_monitor")
	public HttpMonitor getHttpMonitor() {
		return httpMonitor;
	}

	@JsonProperty("http_monitor")
	public void setHttpMonitor(HttpMonitor httpMonitor) {
		this.httpMonitor = httpMonitor;
	}

	public HealthMonitor withHttpMonitor(HttpMonitor httpMonitor) {
		this.httpMonitor = httpMonitor;
		return this;
	}

	@JsonProperty("successful_checks")
	public Integer getSuccessfulChecks() {
		return successfulChecks;
	}

	@JsonProperty("successful_checks")
	public void setSuccessfulChecks(Integer successfulChecks) {
		this.successfulChecks = successfulChecks;
	}

	public HealthMonitor withSuccessfulChecks(Integer successfulChecks) {
		this.successfulChecks = successfulChecks;
		return this;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public HealthMonitor withType(String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public HealthMonitor withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("https_monitor")
	public HttpsMonitor getHttpsMonitor() {
		return httpsMonitor;
	}

	@JsonProperty("https_monitor")
	public void setHttpsMonitor(HttpsMonitor httpsMonitor) {
		this.httpsMonitor = httpsMonitor;
	}

	public HealthMonitor withHttpsMonitor(HttpsMonitor httpsMonitor) {
		this.httpsMonitor = httpsMonitor;
		return this;
	}

	@JsonProperty("tcp_monitor")
	public TcpMonitor getTcpMonitor() {
		return tcpMonitor;
	}

	@JsonProperty("tcp_monitor")
	public void setTcpMonitor(TcpMonitor tcpMonitor) {
		this.tcpMonitor = tcpMonitor;
	}

	public HealthMonitor withTcpMonitor(TcpMonitor tcpMonitor) {
		this.tcpMonitor = tcpMonitor;
		return this;
	}

	@JsonProperty("udp_monitor")
	public UdpMonitor getUdpMonitor() {
		return udpMonitor;
	}

	@JsonProperty("udp_monitor")
	public void setUdpMonitor(UdpMonitor udpMonitor) {
		this.udpMonitor = udpMonitor;
	}

	public HealthMonitor withUdpMonitor(UdpMonitor udpMonitor) {
		this.udpMonitor = udpMonitor;
		return this;
	}

	@JsonProperty("dns_monitor")
	public DnsMonitor getDnsMonitor() {
		return dnsMonitor;
	}

	@JsonProperty("dns_monitor")
	public void setDnsMonitor(DnsMonitor dnsMonitor) {
		this.dnsMonitor = dnsMonitor;
	}

	public HealthMonitor withDnsMonitor(DnsMonitor dnsMonitor) {
		this.dnsMonitor = dnsMonitor;
		return this;
	}

	@JsonProperty("external_monitor")
	public ExternalMonitor getExternalMonitor() {
		return externalMonitor;
	}

	@JsonProperty("external_monitor")
	public void setExternalMonitor(ExternalMonitor externalMonitor) {
		this.externalMonitor = externalMonitor;
	}

	public HealthMonitor withExternalMonitor(ExternalMonitor externalMonitor) {
		this.externalMonitor = externalMonitor;
		return this;
	}

	@JsonProperty("monitor_port")
	public Integer getMonitorPort() {
		return monitorPort;
	}

	@JsonProperty("monitor_port")
	public void setMonitorPort(Integer monitorPort) {
		this.monitorPort = monitorPort;
	}

	public HealthMonitor withMonitorPort(Integer monitorPort) {
		this.monitorPort = monitorPort;
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

	public HealthMonitor withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("uuid", uuid).append("receiveTimeout", receiveTimeout)
				.append("lastModified", lastModified).append("url", url).append("tenantRef", tenantRef)
				.append("isFederated", isFederated).append("failedChecks", failedChecks)
				.append("sendInterval", sendInterval).append("httpMonitor", httpMonitor)
				.append("successfulChecks", successfulChecks).append("type", type).append("name", name)
				.append("httpsMonitor", httpsMonitor).append("tcpMonitor", tcpMonitor).append("udpMonitor", udpMonitor)
				.append("dnsMonitor", dnsMonitor).append("externalMonitor", externalMonitor)
				.append("monitorPort", monitorPort).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(udpMonitor).append(sendInterval).append(type).append(uuid)
				.append(httpMonitor).append(url).append(isFederated).append(tcpMonitor).append(receiveTimeout)
				.append(externalMonitor).append(name).append(tenantRef).append(failedChecks).append(dnsMonitor)
				.append(lastModified).append(httpsMonitor).append(additionalProperties).append(successfulChecks)
				.append(monitorPort).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HealthMonitor) == false) {
			return false;
		}
		HealthMonitor rhs = ((HealthMonitor) other);
		return new EqualsBuilder().append(udpMonitor, rhs.udpMonitor).append(sendInterval, rhs.sendInterval)
				.append(type, rhs.type).append(uuid, rhs.uuid).append(httpMonitor, rhs.httpMonitor).append(url, rhs.url)
				.append(isFederated, rhs.isFederated).append(tcpMonitor, rhs.tcpMonitor)
				.append(receiveTimeout, rhs.receiveTimeout).append(externalMonitor, rhs.externalMonitor)
				.append(name, rhs.name).append(tenantRef, rhs.tenantRef).append(failedChecks, rhs.failedChecks)
				.append(dnsMonitor, rhs.dnsMonitor).append(lastModified, rhs.lastModified)
				.append(httpsMonitor, rhs.httpsMonitor).append(additionalProperties, rhs.additionalProperties)
				.append(successfulChecks, rhs.successfulChecks).append(monitorPort, rhs.monitorPort).isEquals();
	}

}