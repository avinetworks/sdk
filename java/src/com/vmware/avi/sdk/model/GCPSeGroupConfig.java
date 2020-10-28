package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GCPSeGroupConfig is a POJO class extends AviRestResource that used for creating
 * GCPSeGroupConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPSeGroupConfig  {
    @JsonProperty("backend_data_vpc_network_name")
    private String backendDataVpcNetworkName = null;

    @JsonProperty("backend_data_vpc_subnet_name")
    private String backendDataVpcSubnetName = null;



    /**
     * This is the getter method this will return the attribute value.
     * Service engine backend data network name, used only for gcp cloud.overrides the cloud level setting for backend data network in gcp two arm mode.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return backendDataVpcNetworkName
     */
    public String getBackendDataVpcNetworkName() {
        return backendDataVpcNetworkName;
    }

    /**
     * This is the setter method to the attribute.
     * Service engine backend data network name, used only for gcp cloud.overrides the cloud level setting for backend data network in gcp two arm mode.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param backendDataVpcNetworkName set the backendDataVpcNetworkName.
     */
    public void setBackendDataVpcNetworkName(String  backendDataVpcNetworkName) {
        this.backendDataVpcNetworkName = backendDataVpcNetworkName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Service engine backend data subnet name, used only for gcp cloud.overrides the cloud level setting for backend data subnet in gcp two arm mode.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return backendDataVpcSubnetName
     */
    public String getBackendDataVpcSubnetName() {
        return backendDataVpcSubnetName;
    }

    /**
     * This is the setter method to the attribute.
     * Service engine backend data subnet name, used only for gcp cloud.overrides the cloud level setting for backend data subnet in gcp two arm mode.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param backendDataVpcSubnetName set the backendDataVpcSubnetName.
     */
    public void setBackendDataVpcSubnetName(String  backendDataVpcSubnetName) {
        this.backendDataVpcSubnetName = backendDataVpcSubnetName;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GCPSeGroupConfig objGCPSeGroupConfig = (GCPSeGroupConfig) o;
      return   Objects.equals(this.backendDataVpcNetworkName, objGCPSeGroupConfig.backendDataVpcNetworkName)&&
  Objects.equals(this.backendDataVpcSubnetName, objGCPSeGroupConfig.backendDataVpcSubnetName);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GCPSeGroupConfig {\n");
                  sb.append("    backendDataVpcNetworkName: ").append(toIndentedString(backendDataVpcNetworkName)).append("\n");
                        sb.append("    backendDataVpcSubnetName: ").append(toIndentedString(backendDataVpcSubnetName)).append("\n");
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
