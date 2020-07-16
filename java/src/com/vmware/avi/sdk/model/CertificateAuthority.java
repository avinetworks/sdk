package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CertificateAuthority is a POJO class extends AviRestResource that used for creating
 * CertificateAuthority.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificateAuthority  {
    @JsonProperty("ca_ref")
    private String caRef = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return caRef
   */
  public String getCaRef() {
    return caRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type sslkeyandcertificate.
   * @param caRef set the caRef.
   */
  public void setCaRef(String  caRef) {
    this.caRef = caRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CertificateAuthority objCertificateAuthority = (CertificateAuthority) o;
  return   Objects.equals(this.caRef, objCertificateAuthority.caRef)&&
  Objects.equals(this.name, objCertificateAuthority.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CertificateAuthority {\n");
      sb.append("    caRef: ").append(toIndentedString(caRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

