package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The CloudStackConfiguration is a POJO class extends AviRestResource that used for creating
 * CloudStackConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudStackConfiguration  {
    @JsonProperty("access_key_id")
    private String accessKeyId = null;

    @JsonProperty("api_url")
    private String apiUrl = null;

    @JsonProperty("cntr_public_ip")
    private String cntrPublicIp = null;

    @JsonProperty("hypervisor")
    private String hypervisor = "KVM";

    @JsonProperty("mgmt_network_name")
    private String mgmtNetworkName = null;

    @JsonProperty("mgmt_network_uuid")
    private String mgmtNetworkUuid = null;

    @JsonProperty("secret_access_key")
    private String secretAccessKey = null;



    /**
     * This is the getter method this will return the attribute value.
     * Cloudstack api key.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return accessKeyId
     */
    public String getAccessKeyId() {
        return accessKeyId;
    }

    /**
     * This is the setter method to the attribute.
     * Cloudstack api key.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param accessKeyId set the accessKeyId.
     */
    public void setAccessKeyId(String  accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cloudstack api url.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return apiUrl
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * This is the setter method to the attribute.
     * Cloudstack api url.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param apiUrl set the apiUrl.
     */
    public void setApiUrl(String  apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If controller's management ip is in a private network, a publicly accessible ip to reach the controller.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cntrPublicIp
     */
    public String getCntrPublicIp() {
        return cntrPublicIp;
    }

    /**
     * This is the setter method to the attribute.
     * If controller's management ip is in a private network, a publicly accessible ip to reach the controller.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cntrPublicIp set the cntrPublicIp.
     */
    public void setCntrPublicIp(String  cntrPublicIp) {
        this.cntrPublicIp = cntrPublicIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Default hypervisor type.
     * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
     * Default value when not specified in API or module is interpreted by Avi Controller as "KVM".
     * @return hypervisor
     */
    public String getHypervisor() {
        return hypervisor;
    }

    /**
     * This is the setter method to the attribute.
     * Default hypervisor type.
     * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
     * Default value when not specified in API or module is interpreted by Avi Controller as "KVM".
     * @param hypervisor set the hypervisor.
     */
    public void setHypervisor(String  hypervisor) {
        this.hypervisor = hypervisor;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Avi management network name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mgmtNetworkName
     */
    public String getMgmtNetworkName() {
        return mgmtNetworkName;
    }

    /**
     * This is the setter method to the attribute.
     * Avi management network name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mgmtNetworkName set the mgmtNetworkName.
     */
    public void setMgmtNetworkName(String  mgmtNetworkName) {
        this.mgmtNetworkName = mgmtNetworkName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Avi management network name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mgmtNetworkUuid
     */
    public String getMgmtNetworkUuid() {
        return mgmtNetworkUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Avi management network name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mgmtNetworkUuid set the mgmtNetworkUuid.
     */
    public void setMgmtNetworkUuid(String  mgmtNetworkUuid) {
        this.mgmtNetworkUuid = mgmtNetworkUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cloudstack secret key.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return secretAccessKey
     */
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    /**
     * This is the setter method to the attribute.
     * Cloudstack secret key.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param secretAccessKey set the secretAccessKey.
     */
    public void setSecretAccessKey(String  secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      CloudStackConfiguration objCloudStackConfiguration = (CloudStackConfiguration) o;
      return   Objects.equals(this.apiUrl, objCloudStackConfiguration.apiUrl)&&
  Objects.equals(this.accessKeyId, objCloudStackConfiguration.accessKeyId)&&
  Objects.equals(this.secretAccessKey, objCloudStackConfiguration.secretAccessKey)&&
  Objects.equals(this.mgmtNetworkName, objCloudStackConfiguration.mgmtNetworkName)&&
  Objects.equals(this.mgmtNetworkUuid, objCloudStackConfiguration.mgmtNetworkUuid)&&
  Objects.equals(this.cntrPublicIp, objCloudStackConfiguration.cntrPublicIp)&&
  Objects.equals(this.hypervisor, objCloudStackConfiguration.hypervisor);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CloudStackConfiguration {\n");
                  sb.append("    accessKeyId: ").append(toIndentedString(accessKeyId)).append("\n");
                        sb.append("    apiUrl: ").append(toIndentedString(apiUrl)).append("\n");
                        sb.append("    cntrPublicIp: ").append(toIndentedString(cntrPublicIp)).append("\n");
                        sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
                        sb.append("    mgmtNetworkName: ").append(toIndentedString(mgmtNetworkName)).append("\n");
                        sb.append("    mgmtNetworkUuid: ").append(toIndentedString(mgmtNetworkUuid)).append("\n");
                        sb.append("    secretAccessKey: ").append(toIndentedString(secretAccessKey)).append("\n");
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
