package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlSettings is a POJO class extends AviRestResource that used for creating
 * SamlSettings.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlSettings  {
    @JsonProperty("idp")
    private SamlIdentityProviderSettings idp = null;

    @JsonProperty("sp")
    private SamlServiceProviderSettings sp = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure remote identity provider settings.
   * Field introduced in 17.2.3.
   * @return idp
   */
  public SamlIdentityProviderSettings getIdp() {
    return idp;
  }

  /**
   * This is the setter method to the attribute.
   * Configure remote identity provider settings.
   * Field introduced in 17.2.3.
   * @param idp set the idp.
   */
  public void setIdp(SamlIdentityProviderSettings idp) {
    this.idp = idp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure service provider settings for the controller.
   * Field introduced in 17.2.3.
   * @return sp
   */
  public SamlServiceProviderSettings getSp() {
    return sp;
  }

  /**
   * This is the setter method to the attribute.
   * Configure service provider settings for the controller.
   * Field introduced in 17.2.3.
   * @param sp set the sp.
   */
  public void setSp(SamlServiceProviderSettings sp) {
    this.sp = sp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlSettings objSamlSettings = (SamlSettings) o;
  return   Objects.equals(this.idp, objSamlSettings.idp)&&
  Objects.equals(this.sp, objSamlSettings.sp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlSettings {\n");
      sb.append("    idp: ").append(toIndentedString(idp)).append("\n");
        sb.append("    sp: ").append(toIndentedString(sp)).append("\n");
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

