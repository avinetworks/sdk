package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClusterNode is a POJO class extends AviRestResource that used for creating
 * ClusterNode.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterNode  {
    @JsonProperty("categories")
    private List<String> categories = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("name")
    private String name = "node";

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("public_ip_or_name")
    private IpAddr publicIpOrName = null;

    @JsonProperty("vm_hostname")
    private String vmHostname = null;

    @JsonProperty("vm_mor")
    private String vmMor = null;

    @JsonProperty("vm_name")
    private String vmName = null;

    @JsonProperty("vm_uuid")
    private String vmUuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Optional service categories that a node can be assigned (e.g.
   * System, infrastructure or analytics).
   * Field introduced in 18.1.1.
   * @return categories
   */
  public List<String> getCategories() {
    return categories;
  }

  /**
   * This is the setter method. this will set the categories
   * Optional service categories that a node can be assigned (e.g.
   * System, infrastructure or analytics).
   * Field introduced in 18.1.1.
   * @return categories
   */
  public void setCategories(List<String>  categories) {
    this.categories = categories;
  }

  /**
   * This is the setter method this will set the categories
   * Optional service categories that a node can be assigned (e.g.
   * System, infrastructure or analytics).
   * Field introduced in 18.1.1.
   * @return categories
   */
  public ClusterNode addCategoriesItem(String categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<String>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of controller vm.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of controller vm.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * Default value when not specified in API or module is interpreted by Avi Controller as node.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * Default value when not specified in API or module is interpreted by Avi Controller as node.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password we will use when authenticating with this node (not persisted).
   * Field introduced in 18.2.3.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * The password we will use when authenticating with this node (not persisted).
   * Field introduced in 18.2.3.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Public ip address or hostname of the controller vm.
   * Field introduced in 17.2.3.
   * @return publicIpOrName
   */
  public IpAddr getPublicIpOrName() {
    return publicIpOrName;
  }

  /**
   * This is the setter method to the attribute.
   * Public ip address or hostname of the controller vm.
   * Field introduced in 17.2.3.
   * @param publicIpOrName set the publicIpOrName.
   */
  public void setPublicIpOrName(IpAddr publicIpOrName) {
    this.publicIpOrName = publicIpOrName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Hostname assigned to this controller vm.
   * @return vmHostname
   */
  public String getVmHostname() {
    return vmHostname;
  }

  /**
   * This is the setter method to the attribute.
   * Hostname assigned to this controller vm.
   * @param vmHostname set the vmHostname.
   */
  public void setVmHostname(String  vmHostname) {
    this.vmHostname = vmHostname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Managed object reference of this controller vm.
   * @return vmMor
   */
  public String getVmMor() {
    return vmMor;
  }

  /**
   * This is the setter method to the attribute.
   * Managed object reference of this controller vm.
   * @param vmMor set the vmMor.
   */
  public void setVmMor(String  vmMor) {
    this.vmMor = vmMor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the controller vm.
   * @return vmName
   */
  public String getVmName() {
    return vmName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the controller vm.
   * @param vmName set the vmName.
   */
  public void setVmName(String  vmName) {
    this.vmName = vmName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid on the controller vm.
   * @return vmUuid
   */
  public String getVmUuid() {
    return vmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid on the controller vm.
   * @param vmUuid set the vmUuid.
   */
  public void setVmUuid(String  vmUuid) {
    this.vmUuid = vmUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClusterNode objClusterNode = (ClusterNode) o;
  return   Objects.equals(this.name, objClusterNode.name)&&
  Objects.equals(this.ip, objClusterNode.ip)&&
  Objects.equals(this.vmUuid, objClusterNode.vmUuid)&&
  Objects.equals(this.vmName, objClusterNode.vmName)&&
  Objects.equals(this.vmMor, objClusterNode.vmMor)&&
  Objects.equals(this.vmHostname, objClusterNode.vmHostname)&&
  Objects.equals(this.publicIpOrName, objClusterNode.publicIpOrName)&&
  Objects.equals(this.categories, objClusterNode.categories)&&
  Objects.equals(this.password, objClusterNode.password);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClusterNode {\n");
      sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    publicIpOrName: ").append(toIndentedString(publicIpOrName)).append("\n");
        sb.append("    vmHostname: ").append(toIndentedString(vmHostname)).append("\n");
        sb.append("    vmMor: ").append(toIndentedString(vmMor)).append("\n");
        sb.append("    vmName: ").append(toIndentedString(vmName)).append("\n");
        sb.append("    vmUuid: ").append(toIndentedString(vmUuid)).append("\n");
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

