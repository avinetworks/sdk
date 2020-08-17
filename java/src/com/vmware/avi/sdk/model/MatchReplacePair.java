package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MatchReplacePair is a POJO class extends AviRestResource that used for creating
 * MatchReplacePair.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchReplacePair  {
    @JsonProperty("match_string")
    private String matchString = null;

    @JsonProperty("replacement_string")
    private ReplaceStringVar replacementString = null;



  /**
   * This is the getter method this will return the attribute value.
   * String to be matched.
   * @return matchString
   */
  public String getMatchString() {
    return matchString;
  }

  /**
   * This is the setter method to the attribute.
   * String to be matched.
   * @param matchString set the matchString.
   */
  public void setMatchString(String  matchString) {
    this.matchString = matchString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Replacement string.
   * @return replacementString
   */
  public ReplaceStringVar getReplacementString() {
    return replacementString;
  }

  /**
   * This is the setter method to the attribute.
   * Replacement string.
   * @param replacementString set the replacementString.
   */
  public void setReplacementString(ReplaceStringVar replacementString) {
    this.replacementString = replacementString;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MatchReplacePair objMatchReplacePair = (MatchReplacePair) o;
  return   Objects.equals(this.matchString, objMatchReplacePair.matchString)&&
  Objects.equals(this.replacementString, objMatchReplacePair.replacementString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MatchReplacePair {\n");
      sb.append("    matchString: ").append(toIndentedString(matchString)).append("\n");
        sb.append("    replacementString: ").append(toIndentedString(replacementString)).append("\n");
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

