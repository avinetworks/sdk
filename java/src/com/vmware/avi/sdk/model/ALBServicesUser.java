package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ALBServicesUser is a POJO class extends AviRestResource that used for creating
 * ALBServicesUser.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ALBServicesUser  {
    @JsonProperty("account_id")
    private String accountId = null;

    @JsonProperty("account_name")
    private String accountName = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("managed_accounts")
    private List<ALBServicesAccount> managedAccounts = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("phone")
    private String phone = null;



  /**
   * This is the getter method this will return the attribute value.
   * Id of primary account of the portal user.
   * Field introduced in 20.1.1.
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * This is the setter method to the attribute.
   * Id of primary account of the portal user.
   * Field introduced in 20.1.1.
   * @param accountId set the accountId.
   */
  public void setAccountId(String  accountId) {
    this.accountId = accountId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of primary account of the portal user.
   * Field introduced in 20.1.1.
   * @return accountName
   */
  public String getAccountName() {
    return accountName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of primary account of the portal user.
   * Field introduced in 20.1.1.
   * @param accountName set the accountName.
   */
  public void setAccountName(String  accountName) {
    this.accountName = accountName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Email id of the portal user.
   * Field introduced in 20.1.1.
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * This is the setter method to the attribute.
   * Email id of the portal user.
   * Field introduced in 20.1.1.
   * @param email set the email.
   */
  public void setEmail(String  email) {
    this.email = email;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Information about all the accounts managed by user in the customer portal.
   * Field introduced in 20.1.1.
   * @return managedAccounts
   */
  public List<ALBServicesAccount> getManagedAccounts() {
    return managedAccounts;
  }

  /**
   * This is the setter method. this will set the managedAccounts
   * Information about all the accounts managed by user in the customer portal.
   * Field introduced in 20.1.1.
   * @return managedAccounts
   */
  public void setManagedAccounts(List<ALBServicesAccount>  managedAccounts) {
    this.managedAccounts = managedAccounts;
  }

  /**
   * This is the setter method this will set the managedAccounts
   * Information about all the accounts managed by user in the customer portal.
   * Field introduced in 20.1.1.
   * @return managedAccounts
   */
  public ALBServicesUser addManagedAccountsItem(ALBServicesAccount managedAccountsItem) {
    if (this.managedAccounts == null) {
      this.managedAccounts = new ArrayList<ALBServicesAccount>();
    }
    this.managedAccounts.add(managedAccountsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the portal user.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the portal user.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Phone number of the user.
   * Field introduced in 20.1.1.
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * This is the setter method to the attribute.
   * Phone number of the user.
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
  ALBServicesUser objALBServicesUser = (ALBServicesUser) o;
  return   Objects.equals(this.name, objALBServicesUser.name)&&
  Objects.equals(this.email, objALBServicesUser.email)&&
  Objects.equals(this.phone, objALBServicesUser.phone)&&
  Objects.equals(this.accountName, objALBServicesUser.accountName)&&
  Objects.equals(this.managedAccounts, objALBServicesUser.managedAccounts)&&
  Objects.equals(this.accountId, objALBServicesUser.accountId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ALBServicesUser {\n");
      sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    managedAccounts: ").append(toIndentedString(managedAccounts)).append("\n");
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

