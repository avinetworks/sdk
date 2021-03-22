package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AttackDnsAmplification is a POJO class extends AviRestResource that used for creating
 * AttackDnsAmplification.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttackDnsAmplification  {
    @JsonProperty("record_type")
    private String recordType = null;

    @JsonProperty("src_port")
    private Integer srcPort = null;



    /**
     * This is the getter method this will return the attribute value.
     * The record type in the dns query.
     * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
     * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
     * DNS_RECORD_ANY.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return recordType
     */
    public String getRecordType() {
        return recordType;
    }

    /**
     * This is the setter method to the attribute.
     * The record type in the dns query.
     * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
     * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
     * DNS_RECORD_ANY.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param recordType set the recordType.
     */
    public void setRecordType(String  recordType) {
        this.recordType = recordType;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The source port for the dns query.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return srcPort
     */
    public Integer getSrcPort() {
        return srcPort;
    }

    /**
     * This is the setter method to the attribute.
     * The source port for the dns query.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param srcPort set the srcPort.
     */
    public void setSrcPort(Integer  srcPort) {
        this.srcPort = srcPort;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      AttackDnsAmplification objAttackDnsAmplification = (AttackDnsAmplification) o;
      return   Objects.equals(this.srcPort, objAttackDnsAmplification.srcPort)&&
  Objects.equals(this.recordType, objAttackDnsAmplification.recordType);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AttackDnsAmplification {\n");
                  sb.append("    recordType: ").append(toIndentedString(recordType)).append("\n");
                        sb.append("    srcPort: ").append(toIndentedString(srcPort)).append("\n");
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
