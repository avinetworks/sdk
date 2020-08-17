package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIFaultInjection is a POJO class extends AviRestResource that used for creating
 * VIFaultInjection.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIFaultInjection  {
    @JsonProperty("api")
    private String api = null;

    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("status")
    private String status = "SEVM_CREATE_FAILURE";



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - INITIAL_VALUE, CREATE_SE, MODIFY_VNIC, VM_MONITOR, RESOURCE_MONITOR, PERF_MONITOR, SET_MGMT_IP, MODIFY_MGMT_IP, SIM_VM_BULK_NOTIF,
   * RESYNC_ERROR, SIMULATE_OVA_ERR, VCENTER_NO_OBJECTS, CREATE_VM_RUNTIME_ERR, VERSION_NULL_ERR, DISC_PGNAME_ERR, DISC_DCDETAILS_ERR, DISC_DC_ERR,
   * DISC_HOST_ERR, DISC_CLUSTER_ERR, DISC_PG_ERR...
   * @return api
   */
  public String getApi() {
    return api;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - INITIAL_VALUE, CREATE_SE, MODIFY_VNIC, VM_MONITOR, RESOURCE_MONITOR, PERF_MONITOR, SET_MGMT_IP, MODIFY_MGMT_IP, SIM_VM_BULK_NOTIF,
   * RESYNC_ERROR, SIMULATE_OVA_ERR, VCENTER_NO_OBJECTS, CREATE_VM_RUNTIME_ERR, VERSION_NULL_ERR, DISC_PGNAME_ERR, DISC_DCDETAILS_ERR, DISC_DC_ERR,
   * DISC_HOST_ERR, DISC_CLUSTER_ERR, DISC_PG_ERR...
   * @param api set the api.
   */
  public void setApi(String  api) {
    this.api = api;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property count of obj type vifaultinjection field type str  type integer.
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property count of obj type vifaultinjection field type str  type integer.
   * @param count set the count.
   */
  public void setCount(Integer  count) {
    this.count = count;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return networkUuid
   */
  public String getNetworkUuid() {
    return networkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param networkUuid set the networkUuid.
   */
  public void setNetworkUuid(String  networkUuid) {
    this.networkUuid = networkUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SEVM_SUCCESS, SEVM_CREATE_FAIL_NO_HW_INFO, SEVM_CREATE_FAIL_DUPLICATE_NAME, SEVM_CREATE_FAIL_NO_MGMT_NW, SEVM_CREATE_FAIL_NO_CPU,
   * SEVM_CREATE_FAIL_NO_MEM, SEVM_CREATE_FAIL_NO_LEASE, SEVM_CREATE_FAIL_OVF_ERROR, SEVM_CREATE_NO_HOST_VM_NETWORK, SEVM_CREATE_FAIL_NO_PROGRESS,
   * SEVM_CREATE_FAIL_ABORTED, SEVM_CREATE_FAILURE, SEVM_CREATE_FAIL_POWER_ON, SEVM_VNIC_NO_VM, SEVM_VNIC_MAC_ADDR_ERROR, SEVM_VNIC_FAILURE,
   * SEVM_VNIC_NO_PG_PORTS, SEVM_DELETE_FAILURE, SEVM_CREATE_LIMIT_REACHED, SEVM_SET_MGMT_IP_FAILED...
   * Default value when not specified in API or module is interpreted by Avi Controller as SEVM_CREATE_FAILURE.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SEVM_SUCCESS, SEVM_CREATE_FAIL_NO_HW_INFO, SEVM_CREATE_FAIL_DUPLICATE_NAME, SEVM_CREATE_FAIL_NO_MGMT_NW, SEVM_CREATE_FAIL_NO_CPU,
   * SEVM_CREATE_FAIL_NO_MEM, SEVM_CREATE_FAIL_NO_LEASE, SEVM_CREATE_FAIL_OVF_ERROR, SEVM_CREATE_NO_HOST_VM_NETWORK, SEVM_CREATE_FAIL_NO_PROGRESS,
   * SEVM_CREATE_FAIL_ABORTED, SEVM_CREATE_FAILURE, SEVM_CREATE_FAIL_POWER_ON, SEVM_VNIC_NO_VM, SEVM_VNIC_MAC_ADDR_ERROR, SEVM_VNIC_FAILURE,
   * SEVM_VNIC_NO_PG_PORTS, SEVM_DELETE_FAILURE, SEVM_CREATE_LIMIT_REACHED, SEVM_SET_MGMT_IP_FAILED...
   * Default value when not specified in API or module is interpreted by Avi Controller as SEVM_CREATE_FAILURE.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIFaultInjection objVIFaultInjection = (VIFaultInjection) o;
  return   Objects.equals(this.api, objVIFaultInjection.api)&&
  Objects.equals(this.status, objVIFaultInjection.status)&&
  Objects.equals(this.count, objVIFaultInjection.count)&&
  Objects.equals(this.networkUuid, objVIFaultInjection.networkUuid)&&
  Objects.equals(this.cloudUuid, objVIFaultInjection.cloudUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIFaultInjection {\n");
      sb.append("    api: ").append(toIndentedString(api)).append("\n");
        sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

