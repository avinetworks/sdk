package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLRating is a POJO class extends AviRestResource that used for creating
 * SSLRating.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLRating  {
    @JsonProperty("compatibility_rating")
    private String compatibilityRating = null;

    @JsonProperty("performance_rating")
    private String performanceRating = null;

    @JsonProperty("security_score")
    private String securityScore = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_SCORE_NOT_SECURE, SSL_SCORE_VERY_BAD, SSL_SCORE_BAD, SSL_SCORE_AVERAGE, SSL_SCORE_GOOD, SSL_SCORE_EXCELLENT.
   * @return compatibilityRating
   */
  public String getCompatibilityRating() {
    return compatibilityRating;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_SCORE_NOT_SECURE, SSL_SCORE_VERY_BAD, SSL_SCORE_BAD, SSL_SCORE_AVERAGE, SSL_SCORE_GOOD, SSL_SCORE_EXCELLENT.
   * @param compatibilityRating set the compatibilityRating.
   */
  public void setCompatibilityRating(String  compatibilityRating) {
    this.compatibilityRating = compatibilityRating;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_SCORE_NOT_SECURE, SSL_SCORE_VERY_BAD, SSL_SCORE_BAD, SSL_SCORE_AVERAGE, SSL_SCORE_GOOD, SSL_SCORE_EXCELLENT.
   * @return performanceRating
   */
  public String getPerformanceRating() {
    return performanceRating;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_SCORE_NOT_SECURE, SSL_SCORE_VERY_BAD, SSL_SCORE_BAD, SSL_SCORE_AVERAGE, SSL_SCORE_GOOD, SSL_SCORE_EXCELLENT.
   * @param performanceRating set the performanceRating.
   */
  public void setPerformanceRating(String  performanceRating) {
    this.performanceRating = performanceRating;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property security_score of obj type sslrating field type str  type string.
   * @return securityScore
   */
  public String getSecurityScore() {
    return securityScore;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property security_score of obj type sslrating field type str  type string.
   * @param securityScore set the securityScore.
   */
  public void setSecurityScore(String  securityScore) {
    this.securityScore = securityScore;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLRating objSSLRating = (SSLRating) o;
  return   Objects.equals(this.securityScore, objSSLRating.securityScore)&&
  Objects.equals(this.performanceRating, objSSLRating.performanceRating)&&
  Objects.equals(this.compatibilityRating, objSSLRating.compatibilityRating);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLRating {\n");
      sb.append("    compatibilityRating: ").append(toIndentedString(compatibilityRating)).append("\n");
        sb.append("    performanceRating: ").append(toIndentedString(performanceRating)).append("\n");
        sb.append("    securityScore: ").append(toIndentedString(securityScore)).append("\n");
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

