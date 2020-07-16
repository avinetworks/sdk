package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackHypervisorProperties is a POJO class extends AviRestResource that used for creating
 * OpenStackHypervisorProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackHypervisorProperties  {
    @JsonProperty("hypervisor")
    private String hypervisor = null;

    @JsonProperty("image_properties")
    private List<Property> imageProperties = null;



  /**
   * This is the getter method this will return the attribute value.
   * Hypervisor type.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * Field introduced in 17.2.1.
   * @return hypervisor
   */
  public String getHypervisor() {
    return hypervisor;
  }

  /**
   * This is the setter method to the attribute.
   * Hypervisor type.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * Field introduced in 17.2.1.
   * @param hypervisor set the hypervisor.
   */
  public void setHypervisor(String  hypervisor) {
    this.hypervisor = hypervisor;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Custom properties to be associated with the se image in glance for this hypervisor type.
   * Field introduced in 17.2.1.
   * @return imageProperties
   */
  public List<Property> getImageProperties() {
    return imageProperties;
  }

  /**
   * This is the setter method. this will set the imageProperties
   * Custom properties to be associated with the se image in glance for this hypervisor type.
   * Field introduced in 17.2.1.
   * @return imageProperties
   */
  public void setImageProperties(List<Property>  imageProperties) {
    this.imageProperties = imageProperties;
  }

  /**
   * This is the setter method this will set the imageProperties
   * Custom properties to be associated with the se image in glance for this hypervisor type.
   * Field introduced in 17.2.1.
   * @return imageProperties
   */
  public OpenStackHypervisorProperties addImagePropertiesItem(Property imagePropertiesItem) {
    if (this.imageProperties == null) {
      this.imageProperties = new ArrayList<Property>();
    }
    this.imageProperties.add(imagePropertiesItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackHypervisorProperties objOpenStackHypervisorProperties = (OpenStackHypervisorProperties) o;
  return   Objects.equals(this.hypervisor, objOpenStackHypervisorProperties.hypervisor)&&
  Objects.equals(this.imageProperties, objOpenStackHypervisorProperties.imageProperties);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackHypervisorProperties {\n");
      sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
        sb.append("    imageProperties: ").append(toIndentedString(imageProperties)).append("\n");
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

