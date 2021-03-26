package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotManagementLog is a POJO class extends AviRestResource that used for creating
 * BotManagementLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotManagementLog  {
    @JsonProperty("classification")
    private BotClassification classification = null;

    @JsonProperty("results")
    private List<BotEvaluationResult> results = null;



    /**
     * This is the getter method this will return the attribute value.
     * The final classification of the bot management module.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return classification
     */
    public BotClassification getClassification() {
        return classification;
    }

    /**
     * This is the setter method to the attribute.
     * The final classification of the bot management module.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param classification set the classification.
     */
    public void setClassification(BotClassification classification) {
        this.classification = classification;
    }
    /**
     * This is the getter method this will return the attribute value.
     * The evaluation results of the various bot module components.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return results
     */
    public List<BotEvaluationResult> getResults() {
        return results;
    }

    /**
     * This is the setter method. this will set the results
     * The evaluation results of the various bot module components.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return results
     */
    public void setResults(List<BotEvaluationResult>  results) {
        this.results = results;
    }

    /**
     * This is the setter method this will set the results
     * The evaluation results of the various bot module components.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return results
     */
    public BotManagementLog addResultsItem(BotEvaluationResult resultsItem) {
      if (this.results == null) {
        this.results = new ArrayList<BotEvaluationResult>();
      }
      this.results.add(resultsItem);
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
      BotManagementLog objBotManagementLog = (BotManagementLog) o;
      return   Objects.equals(this.results, objBotManagementLog.results)&&
  Objects.equals(this.classification, objBotManagementLog.classification);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotManagementLog {\n");
                  sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
                        sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
