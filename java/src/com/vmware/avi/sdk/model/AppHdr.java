package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AppHdr is a POJO class extends AviRestResource that used for creating
 * AppHdr.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppHdr  {
    @JsonProperty("hdr_match_case")
    private String hdrMatchCase = null;

    @JsonProperty("hdr_name")
    private String hdrName = null;

    @JsonProperty("hdr_string_op")
    private String hdrStringOp = null;



    /**
     * This is the getter method this will return the attribute value.
     * Enum options - SENSITIVE, INSENSITIVE.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hdrMatchCase
     */
    public String getHdrMatchCase() {
        return hdrMatchCase;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - SENSITIVE, INSENSITIVE.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param hdrMatchCase set the hdrMatchCase.
     */
    public void setHdrMatchCase(String  hdrMatchCase) {
        this.hdrMatchCase = hdrMatchCase;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property hdr_name of obj type apphdr field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hdrName
     */
    public String getHdrName() {
        return hdrName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property hdr_name of obj type apphdr field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param hdrName set the hdrName.
     */
    public void setHdrName(String  hdrName) {
        this.hdrName = hdrName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - BEGINS_WITH, DOES_NOT_BEGIN_WITH, CONTAINS, DOES_NOT_CONTAIN, ENDS_WITH, DOES_NOT_END_WITH, EQUALS, DOES_NOT_EQUAL, REGEX_MATCH,
     * REGEX_DOES_NOT_MATCH.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hdrStringOp
     */
    public String getHdrStringOp() {
        return hdrStringOp;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - BEGINS_WITH, DOES_NOT_BEGIN_WITH, CONTAINS, DOES_NOT_CONTAIN, ENDS_WITH, DOES_NOT_END_WITH, EQUALS, DOES_NOT_EQUAL, REGEX_MATCH,
     * REGEX_DOES_NOT_MATCH.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param hdrStringOp set the hdrStringOp.
     */
    public void setHdrStringOp(String  hdrStringOp) {
        this.hdrStringOp = hdrStringOp;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      AppHdr objAppHdr = (AppHdr) o;
      return   Objects.equals(this.hdrName, objAppHdr.hdrName)&&
  Objects.equals(this.hdrMatchCase, objAppHdr.hdrMatchCase)&&
  Objects.equals(this.hdrStringOp, objAppHdr.hdrStringOp);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AppHdr {\n");
                  sb.append("    hdrMatchCase: ").append(toIndentedString(hdrMatchCase)).append("\n");
                        sb.append("    hdrName: ").append(toIndentedString(hdrName)).append("\n");
                        sb.append("    hdrStringOp: ").append(toIndentedString(hdrStringOp)).append("\n");
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
