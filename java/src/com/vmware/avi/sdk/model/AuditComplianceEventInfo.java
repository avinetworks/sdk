package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AuditComplianceEventInfo is a POJO class extends AviRestResource that used for creating
 * AuditComplianceEventInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditComplianceEventInfo  {
    @JsonProperty("detailed_reason")
    private String detailedReason = null;

    @JsonProperty("location")
    private String location = null;

    @JsonProperty("protocol")
    private String protocol = null;

    @JsonProperty("result")
    private String result = null;

    @JsonProperty("subjects")
    private List<ACSubjectInfo> subjects = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("user_identities")
    private List<ACUserIdentity> userIdentities = null;



    /**
     * This is the getter method this will return the attribute value.
     * Detailed report of the audit event.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return detailedReason
     */
    public String getDetailedReason() {
        return detailedReason;
    }

    /**
     * This is the setter method to the attribute.
     * Detailed report of the audit event.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param detailedReason set the detailedReason.
     */
    public void setDetailedReason(String  detailedReason) {
        this.detailedReason = detailedReason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Information identifying physical location for audit event (e.g.
     * Santa clara (usa), bengaluru (india)).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * This is the setter method to the attribute.
     * Information identifying physical location for audit event (e.g.
     * Santa clara (usa), bengaluru (india)).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param location set the location.
     */
    public void setLocation(String  location) {
        this.location = location;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Protocol used for communication to the external entity.
     * Enum options - SSH1_0, TLS1_2, HTTPS1_0, HTTP_PLAIN_TEXT, HTTPS_INSECURE, SSH2_0.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * This is the setter method to the attribute.
     * Protocol used for communication to the external entity.
     * Enum options - SSH1_0, TLS1_2, HTTPS1_0, HTTP_PLAIN_TEXT, HTTPS_INSECURE, SSH2_0.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param protocol set the protocol.
     */
    public void setProtocol(String  protocol) {
        this.protocol = protocol;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Summarized failure of the transaction (e.g.
     * Invalid request, expired certificate).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * This is the setter method to the attribute.
     * Summarized failure of the transaction (e.g.
     * Invalid request, expired certificate).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param result set the result.
     */
    public void setResult(String  result) {
        this.result = result;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Subjects of audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subjects
     */
    public List<ACSubjectInfo> getSubjects() {
        return subjects;
    }

    /**
     * This is the setter method. this will set the subjects
     * Subjects of audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subjects
     */
    public void setSubjects(List<ACSubjectInfo>  subjects) {
        this.subjects = subjects;
    }

    /**
     * This is the setter method this will set the subjects
     * Subjects of audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subjects
     */
    public AuditComplianceEventInfo addSubjectsItem(ACSubjectInfo subjectsItem) {
      if (this.subjects == null) {
        this.subjects = new ArrayList<ACSubjectInfo>();
      }
      this.subjects.add(subjectsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Type of audit event.
     * Enum options - AUDIT_INVALID_CREDENTIALS, AUDIT_NAME_RESOLUTION_ERROR, AUDIT_DIAL_X509_ERROR, AUDIT_SECURE_KEY_EXCHANGE_BAD_REQUEST_FORMAT,
     * AUDIT_SECURE_KEY_EXCHANGE_BAD_CLIENT_TYPE, AUDIT_SECURE_KEY_EXCHANGE_FIELD_NOT_FOUND, AUDIT_SECURE_KEY_EXCHANGE_BAD_FIELD_VALUE,
     * AUDIT_SECURE_KEY_EXCHANGE_INVALID_AUTHORIZATION, AUDIT_SECURE_KEY_EXCHANGE_INTERNAL_ERROR, AUDIT_SECURE_KEY_EXCHANGE_CERTIFICATE_VERIFY_ERROR,
     * AUDIT_SECURE_KEY_EXCHANGE_RESPONSE_ERROR.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Type of audit event.
     * Enum options - AUDIT_INVALID_CREDENTIALS, AUDIT_NAME_RESOLUTION_ERROR, AUDIT_DIAL_X509_ERROR, AUDIT_SECURE_KEY_EXCHANGE_BAD_REQUEST_FORMAT,
     * AUDIT_SECURE_KEY_EXCHANGE_BAD_CLIENT_TYPE, AUDIT_SECURE_KEY_EXCHANGE_FIELD_NOT_FOUND, AUDIT_SECURE_KEY_EXCHANGE_BAD_FIELD_VALUE,
     * AUDIT_SECURE_KEY_EXCHANGE_INVALID_AUTHORIZATION, AUDIT_SECURE_KEY_EXCHANGE_INTERNAL_ERROR, AUDIT_SECURE_KEY_EXCHANGE_CERTIFICATE_VERIFY_ERROR,
     * AUDIT_SECURE_KEY_EXCHANGE_RESPONSE_ERROR.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }
    /**
     * This is the getter method this will return the attribute value.
     * List of users (username etc) related to the audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userIdentities
     */
    public List<ACUserIdentity> getUserIdentities() {
        return userIdentities;
    }

    /**
     * This is the setter method. this will set the userIdentities
     * List of users (username etc) related to the audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userIdentities
     */
    public void setUserIdentities(List<ACUserIdentity>  userIdentities) {
        this.userIdentities = userIdentities;
    }

    /**
     * This is the setter method this will set the userIdentities
     * List of users (username etc) related to the audit event.
     * Field introduced in 20.1.3.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userIdentities
     */
    public AuditComplianceEventInfo addUserIdentitiesItem(ACUserIdentity userIdentitiesItem) {
      if (this.userIdentities == null) {
        this.userIdentities = new ArrayList<ACUserIdentity>();
      }
      this.userIdentities.add(userIdentitiesItem);
      return this;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      AuditComplianceEventInfo objAuditComplianceEventInfo = (AuditComplianceEventInfo) o;
      return   Objects.equals(this.type, objAuditComplianceEventInfo.type)&&
  Objects.equals(this.location, objAuditComplianceEventInfo.location)&&
  Objects.equals(this.result, objAuditComplianceEventInfo.result)&&
  Objects.equals(this.userIdentities, objAuditComplianceEventInfo.userIdentities)&&
  Objects.equals(this.protocol, objAuditComplianceEventInfo.protocol)&&
  Objects.equals(this.subjects, objAuditComplianceEventInfo.subjects)&&
  Objects.equals(this.detailedReason, objAuditComplianceEventInfo.detailedReason);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AuditComplianceEventInfo {\n");
                  sb.append("    detailedReason: ").append(toIndentedString(detailedReason)).append("\n");
                        sb.append("    location: ").append(toIndentedString(location)).append("\n");
                        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
                        sb.append("    result: ").append(toIndentedString(result)).append("\n");
                        sb.append("    subjects: ").append(toIndentedString(subjects)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
                        sb.append("    userIdentities: ").append(toIndentedString(userIdentities)).append("\n");
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
