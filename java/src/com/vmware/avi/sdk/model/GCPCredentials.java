package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPCredentials is a POJO class extends AviRestResource that used for creating
 * GCPCredentials.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPCredentials  {
    @JsonProperty("service_account_keyfile_data")
    private String serviceAccountKeyfileData = null;



  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform service account keyfile data in json format.
   * Field introduced in 18.2.1.
   * @return serviceAccountKeyfileData
   */
  public String getServiceAccountKeyfileData() {
    return serviceAccountKeyfileData;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform service account keyfile data in json format.
   * Field introduced in 18.2.1.
   * @param serviceAccountKeyfileData set the serviceAccountKeyfileData.
   */
  public void setServiceAccountKeyfileData(String  serviceAccountKeyfileData) {
    this.serviceAccountKeyfileData = serviceAccountKeyfileData;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GCPCredentials objGCPCredentials = (GCPCredentials) o;
  return   Objects.equals(this.serviceAccountKeyfileData, objGCPCredentials.serviceAccountKeyfileData);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPCredentials {\n");
      sb.append("    serviceAccountKeyfileData: ").append(toIndentedString(serviceAccountKeyfileData)).append("\n");
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

