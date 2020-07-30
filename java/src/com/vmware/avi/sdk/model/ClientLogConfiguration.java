package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClientLogConfiguration is a POJO class extends AviRestResource that used for creating
 * ClientLogConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientLogConfiguration  {
    @JsonProperty("enable_significant_log_collection")
    private Boolean enableSignificantLogCollection = true;

    @JsonProperty("filtered_log_processing")
    private String filteredLogProcessing = "LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND";

    @JsonProperty("non_significant_log_processing")
    private String nonSignificantLogProcessing = "LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND";

    @JsonProperty("significant_log_processing")
    private String significantLogProcessing = "LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND";



  /**
   * This is the getter method this will return the attribute value.
   * Enable significant log collection.
   * By default, this flag is enabled, which means that avi ses collect significant logs and forward them to controller for further processing.
   * For example, these logs correspond to error conditions such as when the response code for a request is 500.
   * Users can disable this flag to turn off default significant log collection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableSignificantLogCollection
   */
  public Boolean getEnableSignificantLogCollection() {
    return enableSignificantLogCollection;
  }

  /**
   * This is the setter method to the attribute.
   * Enable significant log collection.
   * By default, this flag is enabled, which means that avi ses collect significant logs and forward them to controller for further processing.
   * For example, these logs correspond to error conditions such as when the response code for a request is 500.
   * Users can disable this flag to turn off default significant log collection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableSignificantLogCollection set the enableSignificantLogCollection.
   */
  public void setEnableSignificantLogCollection(Boolean  enableSignificantLogCollection) {
    this.enableSignificantLogCollection = enableSignificantLogCollection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Filtered logs are logs that match any client log filters or rules with logging enabled.
   * Such logs are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @return filteredLogProcessing
   */
  public String getFilteredLogProcessing() {
    return filteredLogProcessing;
  }

  /**
   * This is the setter method to the attribute.
   * Filtered logs are logs that match any client log filters or rules with logging enabled.
   * Such logs are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @param filteredLogProcessing set the filteredLogProcessing.
   */
  public void setFilteredLogProcessing(String  filteredLogProcessing) {
    this.filteredLogProcessing = filteredLogProcessing;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Logs that are neither significant nor filtered, are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @return nonSignificantLogProcessing
   */
  public String getNonSignificantLogProcessing() {
    return nonSignificantLogProcessing;
  }

  /**
   * This is the setter method to the attribute.
   * Logs that are neither significant nor filtered, are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @param nonSignificantLogProcessing set the nonSignificantLogProcessing.
   */
  public void setNonSignificantLogProcessing(String  nonSignificantLogProcessing) {
    this.nonSignificantLogProcessing = nonSignificantLogProcessing;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Significant logs are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @return significantLogProcessing
   */
  public String getSignificantLogProcessing() {
    return significantLogProcessing;
  }

  /**
   * This is the setter method to the attribute.
   * Significant logs are processed by the logs analytics system according to this setting.
   * Enum options - LOGS_PROCESSING_NONE, LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND, LOGS_PROCESSING_AUTO_SYNC_AND_INDEX,
   * LOGS_PROCESSING_AUTO_SYNC_BUT_INDEX_ON_DEMAND.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOGS_PROCESSING_SYNC_AND_INDEX_ON_DEMAND.
   * @param significantLogProcessing set the significantLogProcessing.
   */
  public void setSignificantLogProcessing(String  significantLogProcessing) {
    this.significantLogProcessing = significantLogProcessing;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClientLogConfiguration objClientLogConfiguration = (ClientLogConfiguration) o;
  return   Objects.equals(this.enableSignificantLogCollection, objClientLogConfiguration.enableSignificantLogCollection)&&
  Objects.equals(this.significantLogProcessing, objClientLogConfiguration.significantLogProcessing)&&
  Objects.equals(this.filteredLogProcessing, objClientLogConfiguration.filteredLogProcessing)&&
  Objects.equals(this.nonSignificantLogProcessing, objClientLogConfiguration.nonSignificantLogProcessing);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClientLogConfiguration {\n");
      sb.append("    enableSignificantLogCollection: ").append(toIndentedString(enableSignificantLogCollection)).append("\n");
        sb.append("    filteredLogProcessing: ").append(toIndentedString(filteredLogProcessing)).append("\n");
        sb.append("    nonSignificantLogProcessing: ").append(toIndentedString(nonSignificantLogProcessing)).append("\n");
        sb.append("    significantLogProcessing: ").append(toIndentedString(significantLogProcessing)).append("\n");
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

