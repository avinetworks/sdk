package com.vmware.avi.sdk;

public class AviCredentials {

	public AviCredentials() {
	}

	public AviCredentials(String controller, String username, String password) {
		this.controller = controller;
		this.username = username;
		this.password = password;
	}

	public AviCredentials(String controller, String username, String password, String tenant, String version,
			String tenantUuid, Integer port, Integer timeout, String sessionID, String csrftoken, String token,
			Boolean verify, Boolean retryConxnErrors) {
		this.controller = controller;
		this.username = username;
		this.password = password;
		this.tenant = tenant;
		this.version = version;
		this.tenantUuid = tenantUuid;
		this.port = port;
		this.timeout = timeout;
		this.sessionID = sessionID;
		this.csrftoken = csrftoken;
		this.token = token;
		this.verify = verify;
		this.retryConxnErrors = retryConxnErrors;
	}

	private String controller;
	private String username;
	private String password;
	private String tenant = "admin";
	private String version;
	private String tenantUuid;
	private Integer port=443;
	private Integer timeout;
	private String sessionID;
	private String csrftoken;
	private String token;
	private Boolean verify = false;// for SSL and HTTPS
	private Boolean retryConxnErrors;
	private Integer numApiRetries = 3;
	private Integer retryWaitTime = 10;
	private Boolean lazyAuthentication = false; 



	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTenantUuid() {
		return tenantUuid;
	}
	public void setTenantUuid(String tenantUuid) {
		this.tenantUuid = tenantUuid;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getCsrftoken() {
		return csrftoken;
	}
	public void setCsrftoken(String csrftoken) {
		this.csrftoken = csrftoken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getVerify() {
		return verify;
	}
	public void setVerify(Boolean verify) {
		this.verify = verify;
	}
	public Boolean getRetryConxnErrors() {
		return retryConxnErrors;
	}
	public void setRetryConxnErrors(Boolean retryConxnErrors) {
		this.retryConxnErrors = retryConxnErrors;
	}

	public Integer getNumApiRetries() {
		return numApiRetries;
	}

	public void setNumApiRetries(Integer numApiRetries) {
		this.numApiRetries = numApiRetries;
	}

	public Integer getRetryWaitTime() {
		return retryWaitTime;
	}

	public void setRetryWaitTime(Integer retryWaitTime) {
		this.retryWaitTime = retryWaitTime;
	}

	public Boolean getLazyAuthentication() {
		return lazyAuthentication;
	}

	public void setLazyAuthentication(Boolean lazyAuthentication) {
		this.lazyAuthentication = lazyAuthentication;
	}
}
