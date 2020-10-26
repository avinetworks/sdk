package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DnsCnameRdata is a POJO class extends AviRestResource that used for creating
 * DnsCnameRdata.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsCnameRdata  {
    @JsonProperty("cname")
    private String cname = null;



    /**
     * This is the getter method this will return the attribute value.
     * Canonical name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * This is the setter method to the attribute.
     * Canonical name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cname set the cname.
     */
    public void setCname(String  cname) {
        this.cname = cname;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DnsCnameRdata objDnsCnameRdata = (DnsCnameRdata) o;
      return   Objects.equals(this.cname, objDnsCnameRdata.cname);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DnsCnameRdata {\n");
                  sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
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
