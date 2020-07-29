package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HSMSafenetLunaServer is a POJO class extends AviRestResource that used for creating
 * HSMSafenetLunaServer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HSMSafenetLunaServer  {
    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("partition_passwd")
    private String partitionPasswd = null;

    @JsonProperty("partition_serial_number")
    private String partitionSerialNumber = null;

    @JsonProperty("remote_ip")
    private String remoteIp = null;

    @JsonProperty("server_cert")
    private String serverCert = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 16.5.2,17.2.3.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 16.5.2,17.2.3.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password of the partition assigned to this client.
   * @return partitionPasswd
   */
  public String getPartitionPasswd() {
    return partitionPasswd;
  }

  /**
   * This is the setter method to the attribute.
   * Password of the partition assigned to this client.
   * @param partitionPasswd set the partitionPasswd.
   */
  public void setPartitionPasswd(String  partitionPasswd) {
    this.partitionPasswd = partitionPasswd;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Serial number of the partition assigned to this client.
   * Field introduced in 16.5.2,17.2.3.
   * @return partitionSerialNumber
   */
  public String getPartitionSerialNumber() {
    return partitionSerialNumber;
  }

  /**
   * This is the setter method to the attribute.
   * Serial number of the partition assigned to this client.
   * Field introduced in 16.5.2,17.2.3.
   * @param partitionSerialNumber set the partitionSerialNumber.
   */
  public void setPartitionSerialNumber(String  partitionSerialNumber) {
    this.partitionSerialNumber = partitionSerialNumber;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the safenet/gemalto hsm device.
   * @return remoteIp
   */
  public String getRemoteIp() {
    return remoteIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the safenet/gemalto hsm device.
   * @param remoteIp set the remoteIp.
   */
  public void setRemoteIp(String  remoteIp) {
    this.remoteIp = remoteIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ca certificate of the server.
   * @return serverCert
   */
  public String getServerCert() {
    return serverCert;
  }

  /**
   * This is the setter method to the attribute.
   * Ca certificate of the server.
   * @param serverCert set the serverCert.
   */
  public void setServerCert(String  serverCert) {
    this.serverCert = serverCert;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HSMSafenetLunaServer objHSMSafenetLunaServer = (HSMSafenetLunaServer) o;
  return   Objects.equals(this.remoteIp, objHSMSafenetLunaServer.remoteIp)&&
  Objects.equals(this.serverCert, objHSMSafenetLunaServer.serverCert)&&
  Objects.equals(this.partitionPasswd, objHSMSafenetLunaServer.partitionPasswd)&&
  Objects.equals(this.partitionSerialNumber, objHSMSafenetLunaServer.partitionSerialNumber)&&
  Objects.equals(this.index, objHSMSafenetLunaServer.index);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HSMSafenetLunaServer {\n");
      sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    partitionPasswd: ").append(toIndentedString(partitionPasswd)).append("\n");
        sb.append("    partitionSerialNumber: ").append(toIndentedString(partitionSerialNumber)).append("\n");
        sb.append("    remoteIp: ").append(toIndentedString(remoteIp)).append("\n");
        sb.append("    serverCert: ").append(toIndentedString(serverCert)).append("\n");
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

