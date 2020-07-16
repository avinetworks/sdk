package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DosRateLimitProfile is a POJO class extends AviRestResource that used for creating
 * DosRateLimitProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DosRateLimitProfile  {
    @JsonProperty("dos_profile")
    private DosThresholdProfile dosProfile = null;

    @JsonProperty("rl_profile")
    private RateLimiterProfile rlProfile = null;



  /**
   * This is the getter method this will return the attribute value.
   * Profile for dos attack detection.
   * @return dosProfile
   */
  public DosThresholdProfile getDosProfile() {
    return dosProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Profile for dos attack detection.
   * @param dosProfile set the dosProfile.
   */
  public void setDosProfile(DosThresholdProfile dosProfile) {
    this.dosProfile = dosProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Profile for connections/requests rate limiting.
   * @return rlProfile
   */
  public RateLimiterProfile getRlProfile() {
    return rlProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Profile for connections/requests rate limiting.
   * @param rlProfile set the rlProfile.
   */
  public void setRlProfile(RateLimiterProfile rlProfile) {
    this.rlProfile = rlProfile;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DosRateLimitProfile objDosRateLimitProfile = (DosRateLimitProfile) o;
  return   Objects.equals(this.rlProfile, objDosRateLimitProfile.rlProfile)&&
  Objects.equals(this.dosProfile, objDosRateLimitProfile.dosProfile);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DosRateLimitProfile {\n");
      sb.append("    dosProfile: ").append(toIndentedString(dosProfile)).append("\n");
        sb.append("    rlProfile: ").append(toIndentedString(rlProfile)).append("\n");
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

