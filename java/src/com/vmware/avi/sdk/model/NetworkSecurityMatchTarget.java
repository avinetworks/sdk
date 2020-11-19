package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NetworkSecurityMatchTarget is a POJO class extends AviRestResource that used for creating
 * NetworkSecurityMatchTarget.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSecurityMatchTarget  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("client_port")
    private PortMatchGeneric clientPort = null;

    @JsonProperty("ip_reputation_type")
    private IPReputationTypeMatch ipReputationType = null;

    @JsonProperty("microservice")
    private MicroServiceMatch microservice = null;

    @JsonProperty("vs_port")
    private PortMatch vsPort = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property client_ip of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientIp
     */
    public IpAddrMatch getClientIp() {
        return clientIp;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property client_ip of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clientIp set the clientIp.
     */
    public void setClientIp(IpAddrMatch clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Matches the source port of incoming packets in the client side traffic.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientPort
     */
    public PortMatchGeneric getClientPort() {
        return clientPort;
    }

    /**
     * This is the setter method to the attribute.
     * Matches the source port of incoming packets in the client side traffic.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clientPort set the clientPort.
     */
    public void setClientPort(PortMatchGeneric clientPort) {
        this.clientPort = clientPort;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationType
     */
    public IPReputationTypeMatch getIpReputationType() {
        return ipReputationType;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipReputationType set the ipReputationType.
     */
    public void setIpReputationType(IPReputationTypeMatch ipReputationType) {
        this.ipReputationType = ipReputationType;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property microservice of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return microservice
     */
    public MicroServiceMatch getMicroservice() {
        return microservice;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property microservice of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param microservice set the microservice.
     */
    public void setMicroservice(MicroServiceMatch microservice) {
        this.microservice = microservice;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property vs_port of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vsPort
     */
    public PortMatch getVsPort() {
        return vsPort;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property vs_port of obj type networksecuritymatchtarget field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vsPort set the vsPort.
     */
    public void setVsPort(PortMatch vsPort) {
        this.vsPort = vsPort;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      NetworkSecurityMatchTarget objNetworkSecurityMatchTarget = (NetworkSecurityMatchTarget) o;
      return   Objects.equals(this.clientIp, objNetworkSecurityMatchTarget.clientIp)&&
  Objects.equals(this.vsPort, objNetworkSecurityMatchTarget.vsPort)&&
  Objects.equals(this.microservice, objNetworkSecurityMatchTarget.microservice)&&
  Objects.equals(this.ipReputationType, objNetworkSecurityMatchTarget.ipReputationType)&&
  Objects.equals(this.clientPort, objNetworkSecurityMatchTarget.clientPort);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NetworkSecurityMatchTarget {\n");
                  sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
                        sb.append("    clientPort: ").append(toIndentedString(clientPort)).append("\n");
                        sb.append("    ipReputationType: ").append(toIndentedString(ipReputationType)).append("\n");
                        sb.append("    microservice: ").append(toIndentedString(microservice)).append("\n");
                        sb.append("    vsPort: ").append(toIndentedString(vsPort)).append("\n");
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
