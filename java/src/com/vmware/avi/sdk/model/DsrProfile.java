package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DsrProfile is a POJO class extends AviRestResource that used for creating
 * DsrProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DsrProfile  {
    @JsonProperty("dsr_encap_type")
    private String dsrEncapType = "ENCAP_IPINIP";

    @JsonProperty("dsr_type")
    private String dsrType = "DSR_TYPE_L3";



  /**
   * This is the getter method this will return the attribute value.
   * Encapsulation type to use when dsr is l3.
   * Enum options - ENCAP_IPINIP.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as ENCAP_IPINIP.
   * @return dsrEncapType
   */
  public String getDsrEncapType() {
    return dsrEncapType;
  }

  /**
   * This is the setter method to the attribute.
   * Encapsulation type to use when dsr is l3.
   * Enum options - ENCAP_IPINIP.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as ENCAP_IPINIP.
   * @param dsrEncapType set the dsrEncapType.
   */
  public void setDsrEncapType(String  dsrEncapType) {
    this.dsrEncapType = dsrEncapType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dsr type l2/l3.
   * Enum options - DSR_TYPE_L2, DSR_TYPE_L3.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as DSR_TYPE_L3.
   * @return dsrType
   */
  public String getDsrType() {
    return dsrType;
  }

  /**
   * This is the setter method to the attribute.
   * Dsr type l2/l3.
   * Enum options - DSR_TYPE_L2, DSR_TYPE_L3.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as DSR_TYPE_L3.
   * @param dsrType set the dsrType.
   */
  public void setDsrType(String  dsrType) {
    this.dsrType = dsrType;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DsrProfile objDsrProfile = (DsrProfile) o;
  return   Objects.equals(this.dsrType, objDsrProfile.dsrType)&&
  Objects.equals(this.dsrEncapType, objDsrProfile.dsrEncapType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DsrProfile {\n");
      sb.append("    dsrEncapType: ").append(toIndentedString(dsrEncapType)).append("\n");
        sb.append("    dsrType: ").append(toIndentedString(dsrType)).append("\n");
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

