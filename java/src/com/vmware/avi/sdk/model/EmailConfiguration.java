package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The EmailConfiguration is a POJO class extends AviRestResource that used for creating
 * EmailConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailConfiguration  {
    @JsonProperty("auth_password")
    private String authPassword = null;

    @JsonProperty("auth_username")
    private String authUsername = null;

    @JsonProperty("disable_tls")
    private Boolean disableTls = false;

    @JsonProperty("from_email")
    private String fromEmail = "admin@avicontroller.net";

    @JsonProperty("mail_server_name")
    private String mailServerName = "localhost";

    @JsonProperty("mail_server_port")
    private Integer mailServerPort = 25;

    @JsonProperty("smtp_type")
    private String smtpType = "SMTP_LOCAL_HOST";



  /**
   * This is the getter method this will return the attribute value.
   * Password for mail server.
   * @return authPassword
   */
  public String getAuthPassword() {
    return authPassword;
  }

  /**
   * This is the setter method to the attribute.
   * Password for mail server.
   * @param authPassword set the authPassword.
   */
  public void setAuthPassword(String  authPassword) {
    this.authPassword = authPassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username for mail server.
   * @return authUsername
   */
  public String getAuthUsername() {
    return authUsername;
  }

  /**
   * This is the setter method to the attribute.
   * Username for mail server.
   * @param authUsername set the authUsername.
   */
  public void setAuthUsername(String  authUsername) {
    this.authUsername = authUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set, disables tls on the connection to the mail server.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableTls
   */
  public Boolean getDisableTls() {
    return disableTls;
  }

  /**
   * This is the setter method to the attribute.
   * When set, disables tls on the connection to the mail server.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableTls set the disableTls.
   */
  public void setDisableTls(Boolean  disableTls) {
    this.disableTls = disableTls;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Email address in from field.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin@avicontroller.net.
   * @return fromEmail
   */
  public String getFromEmail() {
    return fromEmail;
  }

  /**
   * This is the setter method to the attribute.
   * Email address in from field.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin@avicontroller.net.
   * @param fromEmail set the fromEmail.
   */
  public void setFromEmail(String  fromEmail) {
    this.fromEmail = fromEmail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mail server host.
   * Default value when not specified in API or module is interpreted by Avi Controller as localhost.
   * @return mailServerName
   */
  public String getMailServerName() {
    return mailServerName;
  }

  /**
   * This is the setter method to the attribute.
   * Mail server host.
   * Default value when not specified in API or module is interpreted by Avi Controller as localhost.
   * @param mailServerName set the mailServerName.
   */
  public void setMailServerName(String  mailServerName) {
    this.mailServerName = mailServerName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mail server port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @return mailServerPort
   */
  public Integer getMailServerPort() {
    return mailServerPort;
  }

  /**
   * This is the setter method to the attribute.
   * Mail server port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @param mailServerPort set the mailServerPort.
   */
  public void setMailServerPort(Integer  mailServerPort) {
    this.mailServerPort = mailServerPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of smtp mail service.
   * Enum options - SMTP_NONE, SMTP_LOCAL_HOST, SMTP_SERVER, SMTP_ANONYMOUS_SERVER.
   * Default value when not specified in API or module is interpreted by Avi Controller as SMTP_LOCAL_HOST.
   * @return smtpType
   */
  public String getSmtpType() {
    return smtpType;
  }

  /**
   * This is the setter method to the attribute.
   * Type of smtp mail service.
   * Enum options - SMTP_NONE, SMTP_LOCAL_HOST, SMTP_SERVER, SMTP_ANONYMOUS_SERVER.
   * Default value when not specified in API or module is interpreted by Avi Controller as SMTP_LOCAL_HOST.
   * @param smtpType set the smtpType.
   */
  public void setSmtpType(String  smtpType) {
    this.smtpType = smtpType;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  EmailConfiguration objEmailConfiguration = (EmailConfiguration) o;
  return   Objects.equals(this.mailServerPort, objEmailConfiguration.mailServerPort)&&
  Objects.equals(this.disableTls, objEmailConfiguration.disableTls)&&
  Objects.equals(this.fromEmail, objEmailConfiguration.fromEmail)&&
  Objects.equals(this.smtpType, objEmailConfiguration.smtpType)&&
  Objects.equals(this.authPassword, objEmailConfiguration.authPassword)&&
  Objects.equals(this.authUsername, objEmailConfiguration.authUsername)&&
  Objects.equals(this.mailServerName, objEmailConfiguration.mailServerName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class EmailConfiguration {\n");
      sb.append("    authPassword: ").append(toIndentedString(authPassword)).append("\n");
        sb.append("    authUsername: ").append(toIndentedString(authUsername)).append("\n");
        sb.append("    disableTls: ").append(toIndentedString(disableTls)).append("\n");
        sb.append("    fromEmail: ").append(toIndentedString(fromEmail)).append("\n");
        sb.append("    mailServerName: ").append(toIndentedString(mailServerName)).append("\n");
        sb.append("    mailServerPort: ").append(toIndentedString(mailServerPort)).append("\n");
        sb.append("    smtpType: ").append(toIndentedString(smtpType)).append("\n");
      sb.append("}");
  return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(java.lang.Object o) {
  if (o == null) {
    return "null";
  }
  return o.toString().replace("\n", "\n    ");
}
}

