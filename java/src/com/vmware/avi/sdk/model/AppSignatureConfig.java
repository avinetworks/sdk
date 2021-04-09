package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AppSignatureConfig is a POJO class extends AviRestResource that used for creating
 * AppSignatureConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppSignatureConfig  {
    @JsonProperty("app_signature_sync_interval")
    private Integer appSignatureSyncInterval = 1440;



    /**
     * This is the getter method this will return the attribute value.
     * Application signature db sync interval in minutes.
     * Allowed values are 60-10080.
     * Field introduced in 20.1.4.
     * Unit is min.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Special default for basic edition is 1440, essentials edition is 1440, enterprise is 1440.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
     * @return appSignatureSyncInterval
     */
    public Integer getAppSignatureSyncInterval() {
        return appSignatureSyncInterval;
    }

    /**
     * This is the setter method to the attribute.
     * Application signature db sync interval in minutes.
     * Allowed values are 60-10080.
     * Field introduced in 20.1.4.
     * Unit is min.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Special default for basic edition is 1440, essentials edition is 1440, enterprise is 1440.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
     * @param appSignatureSyncInterval set the appSignatureSyncInterval.
     */
    public void setAppSignatureSyncInterval(Integer  appSignatureSyncInterval) {
        this.appSignatureSyncInterval = appSignatureSyncInterval;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      AppSignatureConfig objAppSignatureConfig = (AppSignatureConfig) o;
      return   Objects.equals(this.appSignatureSyncInterval, objAppSignatureConfig.appSignatureSyncInterval);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AppSignatureConfig {\n");
                  sb.append("    appSignatureSyncInterval: ").append(toIndentedString(appSignatureSyncInterval)).append("\n");
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
