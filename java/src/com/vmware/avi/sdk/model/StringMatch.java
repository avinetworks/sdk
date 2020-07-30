package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The StringMatch is a POJO class extends AviRestResource that used for creating
 * StringMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("match_str")
    private List<String> matchStr = null;

    @JsonProperty("string_group_refs")
    private List<String> stringGroupRefs = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for string matching the http request.
   * Enum options - BEGINS_WITH, DOES_NOT_BEGIN_WITH, CONTAINS, DOES_NOT_CONTAIN, ENDS_WITH, DOES_NOT_END_WITH, EQUALS, DOES_NOT_EQUAL, REGEX_MATCH,
   * REGEX_DOES_NOT_MATCH.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for string matching the http request.
   * Enum options - BEGINS_WITH, DOES_NOT_BEGIN_WITH, CONTAINS, DOES_NOT_CONTAIN, ENDS_WITH, DOES_NOT_END_WITH, EQUALS, DOES_NOT_EQUAL, REGEX_MATCH,
   * REGEX_DOES_NOT_MATCH.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }
  /**
   * This is the getter method this will return the attribute value.
   * String value(s).
   * @return matchStr
   */
  public List<String> getMatchStr() {
    return matchStr;
  }

  /**
   * This is the setter method. this will set the matchStr
   * String value(s).
   * @return matchStr
   */
  public void setMatchStr(List<String>  matchStr) {
    this.matchStr = matchStr;
  }

  /**
   * This is the setter method this will set the matchStr
   * String value(s).
   * @return matchStr
   */
  public StringMatch addMatchStrItem(String matchStrItem) {
    if (this.matchStr == null) {
      this.matchStr = new ArrayList<String>();
    }
    this.matchStr.add(matchStrItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the string group(s).
   * It is a reference to an object of type stringgroup.
   * @return stringGroupRefs
   */
  public List<String> getStringGroupRefs() {
    return stringGroupRefs;
  }

  /**
   * This is the setter method. this will set the stringGroupRefs
   * Uuid of the string group(s).
   * It is a reference to an object of type stringgroup.
   * @return stringGroupRefs
   */
  public void setStringGroupRefs(List<String>  stringGroupRefs) {
    this.stringGroupRefs = stringGroupRefs;
  }

  /**
   * This is the setter method this will set the stringGroupRefs
   * Uuid of the string group(s).
   * It is a reference to an object of type stringgroup.
   * @return stringGroupRefs
   */
  public StringMatch addStringGroupRefsItem(String stringGroupRefsItem) {
    if (this.stringGroupRefs == null) {
      this.stringGroupRefs = new ArrayList<String>();
    }
    this.stringGroupRefs.add(stringGroupRefsItem);
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
  StringMatch objStringMatch = (StringMatch) o;
  return   Objects.equals(this.matchCriteria, objStringMatch.matchCriteria)&&
  Objects.equals(this.matchStr, objStringMatch.matchStr)&&
  Objects.equals(this.stringGroupRefs, objStringMatch.stringGroupRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class StringMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    matchStr: ").append(toIndentedString(matchStr)).append("\n");
        sb.append("    stringGroupRefs: ").append(toIndentedString(stringGroupRefs)).append("\n");
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

