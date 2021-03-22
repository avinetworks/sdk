package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotEvaluationResult is a POJO class extends AviRestResource that used for creating
 * BotEvaluationResult.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotEvaluationResult  {
    @JsonProperty("component")
    private String component = null;

    @JsonProperty("confidence")
    private String confidence = null;

    @JsonProperty("identification")
    private BotIdentification identification = null;

    @JsonProperty("notes")
    private List<String> notes = null;



    /**
     * This is the getter method this will return the attribute value.
     * The component of the bot module that made this evaluation.
     * Enum options - BOT_DECIDER_CONSOLIDATION, BOT_DECIDER_USER_AGENT, BOT_DECIDER_IP_REPUTATION, BOT_DECIDER_IP_NETWORK_LOCATION.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * This is the setter method to the attribute.
     * The component of the bot module that made this evaluation.
     * Enum options - BOT_DECIDER_CONSOLIDATION, BOT_DECIDER_USER_AGENT, BOT_DECIDER_IP_REPUTATION, BOT_DECIDER_IP_NETWORK_LOCATION.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param component set the component.
     */
    public void setComponent(String  component) {
        this.component = component;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The confidence of this evaluation.
     * Enum options - LOW_CONFIDENCE, MEDIUM_CONFIDENCE, HIGH_CONFIDENCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return confidence
     */
    public String getConfidence() {
        return confidence;
    }

    /**
     * This is the setter method to the attribute.
     * The confidence of this evaluation.
     * Enum options - LOW_CONFIDENCE, MEDIUM_CONFIDENCE, HIGH_CONFIDENCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param confidence set the confidence.
     */
    public void setConfidence(String  confidence) {
        this.confidence = confidence;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The resultion bot identification.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return identification
     */
    public BotIdentification getIdentification() {
        return identification;
    }

    /**
     * This is the setter method to the attribute.
     * The resultion bot identification.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param identification set the identification.
     */
    public void setIdentification(BotIdentification identification) {
        this.identification = identification;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Additional notes for this result.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return notes
     */
    public List<String> getNotes() {
        return notes;
    }

    /**
     * This is the setter method. this will set the notes
     * Additional notes for this result.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return notes
     */
    public void setNotes(List<String>  notes) {
        this.notes = notes;
    }

    /**
     * This is the setter method this will set the notes
     * Additional notes for this result.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return notes
     */
    public BotEvaluationResult addNotesItem(String notesItem) {
      if (this.notes == null) {
        this.notes = new ArrayList<String>();
      }
      this.notes.add(notesItem);
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
      BotEvaluationResult objBotEvaluationResult = (BotEvaluationResult) o;
      return   Objects.equals(this.component, objBotEvaluationResult.component)&&
  Objects.equals(this.identification, objBotEvaluationResult.identification)&&
  Objects.equals(this.confidence, objBotEvaluationResult.confidence)&&
  Objects.equals(this.notes, objBotEvaluationResult.notes);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotEvaluationResult {\n");
                  sb.append("    component: ").append(toIndentedString(component)).append("\n");
                        sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
                        sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
                        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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
