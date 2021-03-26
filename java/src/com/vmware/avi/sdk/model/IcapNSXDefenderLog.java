package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The IcapNSXDefenderLog is a POJO class extends AviRestResource that used for creating
 * IcapNSXDefenderLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IcapNSXDefenderLog  {
    @JsonProperty("score")
    private Integer score = null;

    @JsonProperty("task_uuid")
    private String taskUuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Score associated with the uploaded file, if known, value is in between 0 and 100.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This is the setter method to the attribute.
     * Score associated with the uploaded file, if known, value is in between 0 and 100.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param score set the score.
     */
    public void setScore(Integer  score) {
        this.score = score;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The nsx defender task uuid associated with the analysis of the file.
     * It is possible to use this uuid in order to access the analysis details from the nsx defender portal/manager web ui.
     * Url to access this information is https //user.lastline.com/portal#/analyst/task/<uuid>/overview.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return taskUuid
     */
    public String getTaskUuid() {
        return taskUuid;
    }

    /**
     * This is the setter method to the attribute.
     * The nsx defender task uuid associated with the analysis of the file.
     * It is possible to use this uuid in order to access the analysis details from the nsx defender portal/manager web ui.
     * Url to access this information is https //user.lastline.com/portal#/analyst/task/<uuid>/overview.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param taskUuid set the taskUuid.
     */
    public void setTaskUuid(String  taskUuid) {
        this.taskUuid = taskUuid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      IcapNSXDefenderLog objIcapNSXDefenderLog = (IcapNSXDefenderLog) o;
      return   Objects.equals(this.score, objIcapNSXDefenderLog.score)&&
  Objects.equals(this.taskUuid, objIcapNSXDefenderLog.taskUuid);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IcapNSXDefenderLog {\n");
                  sb.append("    score: ").append(toIndentedString(score)).append("\n");
                        sb.append("    taskUuid: ").append(toIndentedString(taskUuid)).append("\n");
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
