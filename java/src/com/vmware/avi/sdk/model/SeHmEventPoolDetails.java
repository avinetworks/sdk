package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SeHmEventPoolDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventPoolDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventPoolDetails  {
    @JsonProperty("ha_reason")
    private String haReason = null;

    @JsonProperty("percent_servers_up")
    private String percentServersUp = null;

    @JsonProperty("pool")
    private String pool = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("server")
    private SeHmEventServerDetails server = null;

    @JsonProperty("src_uuid")
    private String srcUuid = null;

    @JsonProperty("virtual_service")
    private String virtualService = null;



    /**
     * This is the getter method this will return the attribute value.
     * Ha compromised reason.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return haReason
     */
    public String getHaReason() {
        return haReason;
    }

    /**
     * This is the setter method to the attribute.
     * Ha compromised reason.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param haReason set the haReason.
     */
    public void setHaReason(String  haReason) {
        this.haReason = haReason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Percentage of servers up.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return percentServersUp
     */
    public String getPercentServersUp() {
        return percentServersUp;
    }

    /**
     * This is the setter method to the attribute.
     * Percentage of servers up.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param percentServersUp set the percentServersUp.
     */
    public void setPercentServersUp(String  percentServersUp) {
        this.percentServersUp = percentServersUp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Pool name.
     * It is a reference to an object of type pool.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return pool
     */
    public String getPool() {
        return pool;
    }

    /**
     * This is the setter method to the attribute.
     * Pool name.
     * It is a reference to an object of type pool.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param pool set the pool.
     */
    public void setPool(String  pool) {
        this.pool = pool;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Service engine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seName
     */
    public String getSeName() {
        return seName;
    }

    /**
     * This is the setter method to the attribute.
     * Service engine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seName set the seName.
     */
    public void setSeName(String  seName) {
        this.seName = seName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Server details.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return server
     */
    public SeHmEventServerDetails getServer() {
        return server;
    }

    /**
     * This is the setter method to the attribute.
     * Server details.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param server set the server.
     */
    public void setServer(SeHmEventServerDetails server) {
        this.server = server;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the event generator.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return srcUuid
     */
    public String getSrcUuid() {
        return srcUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the event generator.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param srcUuid set the srcUuid.
     */
    public void setSrcUuid(String  srcUuid) {
        this.srcUuid = srcUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Virtual service name.
     * It is a reference to an object of type virtualservice.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return virtualService
     */
    public String getVirtualService() {
        return virtualService;
    }

    /**
     * This is the setter method to the attribute.
     * Virtual service name.
     * It is a reference to an object of type virtualservice.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param virtualService set the virtualService.
     */
    public void setVirtualService(String  virtualService) {
        this.virtualService = virtualService;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SeHmEventPoolDetails objSeHmEventPoolDetails = (SeHmEventPoolDetails) o;
      return   Objects.equals(this.pool, objSeHmEventPoolDetails.pool)&&
  Objects.equals(this.server, objSeHmEventPoolDetails.server)&&
  Objects.equals(this.virtualService, objSeHmEventPoolDetails.virtualService)&&
  Objects.equals(this.seName, objSeHmEventPoolDetails.seName)&&
  Objects.equals(this.haReason, objSeHmEventPoolDetails.haReason)&&
  Objects.equals(this.percentServersUp, objSeHmEventPoolDetails.percentServersUp)&&
  Objects.equals(this.srcUuid, objSeHmEventPoolDetails.srcUuid);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SeHmEventPoolDetails {\n");
                  sb.append("    haReason: ").append(toIndentedString(haReason)).append("\n");
                        sb.append("    percentServersUp: ").append(toIndentedString(percentServersUp)).append("\n");
                        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
                        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
                        sb.append("    server: ").append(toIndentedString(server)).append("\n");
                        sb.append("    srcUuid: ").append(toIndentedString(srcUuid)).append("\n");
                        sb.append("    virtualService: ").append(toIndentedString(virtualService)).append("\n");
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
