package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ALBServicesAccountUser is a POJO class extends AviRestResource that used for creating
 * ALBServicesAccountUser.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ALBServicesAccountUser  {
    @JsonProperty("email")
    private String email = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("phone")
    private String phone = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param email set the email.
   */
  public void setEmail(String  email) {
    this.email = email;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param phone set the phone.
   */
  public void setPhone(String  phone) {
    this.phone = phone;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ALBServicesAccountUser objALBServicesAccountUser = (ALBServicesAccountUser) o;
  return   Objects.equals(this.phone, objALBServicesAccountUser.phone)&&
  Objects.equals(this.name, objALBServicesAccountUser.name)&&
  Objects.equals(this.email, objALBServicesAccountUser.email);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ALBServicesAccountUser {\n");
      sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

