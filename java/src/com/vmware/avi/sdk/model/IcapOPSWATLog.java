package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The IcapOPSWATLog is a POJO class extends AviRestResource that used for creating
 * IcapOPSWATLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IcapOPSWATLog  {
    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("threat_id")
    private String threatId = null;

    @JsonProperty("violations")
    private List<IcapViolation> violations = null;



    /**
     * This is the getter method this will return the attribute value.
     * Blocking reason for the content.
     * It is available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Blocking reason for the content.
     * It is available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Short description of the threat found in the content.
     * Available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return threatId
     */
    public String getThreatId() {
        return threatId;
    }

    /**
     * This is the setter method to the attribute.
     * Short description of the threat found in the content.
     * Available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param threatId set the threatId.
     */
    public void setThreatId(String  threatId) {
        this.threatId = threatId;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Threat found in the content.
     * Available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return violations
     */
    public List<IcapViolation> getViolations() {
        return violations;
    }

    /**
     * This is the setter method. this will set the violations
     * Threat found in the content.
     * Available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return violations
     */
    public void setViolations(List<IcapViolation>  violations) {
        this.violations = violations;
    }

    /**
     * This is the setter method this will set the violations
     * Threat found in the content.
     * Available only if content was scanned by icap server and some violations were found.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return violations
     */
    public IcapOPSWATLog addViolationsItem(IcapViolation violationsItem) {
      if (this.violations == null) {
        this.violations = new ArrayList<IcapViolation>();
      }
      this.violations.add(violationsItem);
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
      IcapOPSWATLog objIcapOPSWATLog = (IcapOPSWATLog) o;
      return   Objects.equals(this.reason, objIcapOPSWATLog.reason)&&
  Objects.equals(this.threatId, objIcapOPSWATLog.threatId)&&
  Objects.equals(this.violations, objIcapOPSWATLog.violations);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IcapOPSWATLog {\n");
                  sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
                        sb.append("    threatId: ").append(toIndentedString(threatId)).append("\n");
                        sb.append("    violations: ").append(toIndentedString(violations)).append("\n");
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
