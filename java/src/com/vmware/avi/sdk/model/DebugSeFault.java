package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugSeFault is a POJO class extends AviRestResource that used for creating
 * DebugSeFault.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugSeFault  {
    @JsonProperty("faults")
    private List<SeFault> faults = null;

    @JsonProperty("se_malloc_fail_frequency")
    private Integer seMallocFailFrequency = 0;

    @JsonProperty("se_malloc_fail_type")
    private Integer seMallocFailType = 0;

    @JsonProperty("se_mbuf_cl_sanity")
    private Boolean seMbufClSanity = false;

    @JsonProperty("se_shm_malloc_fail_frequency")
    private Integer seShmMallocFailFrequency = 0;

    @JsonProperty("se_shm_malloc_fail_type")
    private Integer seShmMallocFailType = 0;

    @JsonProperty("se_waf_alloc_fail_frequency")
    private Integer seWafAllocFailFrequency = 0;

    @JsonProperty("se_waf_learning_alloc_fail_frequency")
    private Integer seWafLearningAllocFailFrequency = 0;


  /**
   * This is the getter method this will return the attribute value.
   * Set of faults to enable/disable.
   * Field introduced in 20.1.1.
   * @return faults
   */
  public List<SeFault> getFaults() {
    return faults;
  }

  /**
   * This is the setter method. this will set the faults
   * Set of faults to enable/disable.
   * Field introduced in 20.1.1.
   * @return faults
   */
  public void setFaults(List<SeFault>  faults) {
    this.faults = faults;
  }

  /**
   * This is the setter method this will set the faults
   * Set of faults to enable/disable.
   * Field introduced in 20.1.1.
   * @return faults
   */
  public DebugSeFault addFaultsItem(SeFault faultsItem) {
    if (this.faults == null) {
      this.faults = new ArrayList<SeFault>();
    }
    this.faults.add(faultsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail se malloc type at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seMallocFailFrequency
   */
  public Integer getSeMallocFailFrequency() {
    return seMallocFailFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Fail se malloc type at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seMallocFailFrequency set the seMallocFailFrequency.
   */
  public void setSeMallocFailFrequency(Integer  seMallocFailFrequency) {
    this.seMallocFailFrequency = seMallocFailFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail this se malloc type.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seMallocFailType
   */
  public Integer getSeMallocFailType() {
    return seMallocFailType;
  }

  /**
   * This is the setter method to the attribute.
   * Fail this se malloc type.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seMallocFailType set the seMallocFailType.
   */
  public void setSeMallocFailType(Integer  seMallocFailType) {
    this.seMallocFailType = seMallocFailType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Toggle assert on mbuf cluster sanity check fail.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seMbufClSanity
   */
  public Boolean getSeMbufClSanity() {
    return seMbufClSanity;
  }

  /**
   * This is the setter method to the attribute.
   * Toggle assert on mbuf cluster sanity check fail.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seMbufClSanity set the seMbufClSanity.
   */
  public void setSeMbufClSanity(Boolean  seMbufClSanity) {
    this.seMbufClSanity = seMbufClSanity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail se shm malloc type at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seShmMallocFailFrequency
   */
  public Integer getSeShmMallocFailFrequency() {
    return seShmMallocFailFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Fail se shm malloc type at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seShmMallocFailFrequency set the seShmMallocFailFrequency.
   */
  public void setSeShmMallocFailFrequency(Integer  seShmMallocFailFrequency) {
    this.seShmMallocFailFrequency = seShmMallocFailFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail this se shm malloc type.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seShmMallocFailType
   */
  public Integer getSeShmMallocFailType() {
    return seShmMallocFailType;
  }

  /**
   * This is the setter method to the attribute.
   * Fail this se shm malloc type.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seShmMallocFailType set the seShmMallocFailType.
   */
  public void setSeShmMallocFailType(Integer  seShmMallocFailType) {
    this.seShmMallocFailType = seShmMallocFailType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail se waf allocation at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seWafAllocFailFrequency
   */
  public Integer getSeWafAllocFailFrequency() {
    return seWafAllocFailFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Fail se waf allocation at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seWafAllocFailFrequency set the seWafAllocFailFrequency.
   */
  public void setSeWafAllocFailFrequency(Integer  seWafAllocFailFrequency) {
    this.seWafAllocFailFrequency = seWafAllocFailFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fail se waf learning allocation at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seWafLearningAllocFailFrequency
   */
  public Integer getSeWafLearningAllocFailFrequency() {
    return seWafLearningAllocFailFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Fail se waf learning allocation at this frequency.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seWafLearningAllocFailFrequency set the seWafLearningAllocFailFrequency.
   */
  public void setSeWafLearningAllocFailFrequency(Integer  seWafLearningAllocFailFrequency) {
    this.seWafLearningAllocFailFrequency = seWafLearningAllocFailFrequency;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugSeFault objDebugSeFault = (DebugSeFault) o;
  return   Objects.equals(this.seMallocFailType, objDebugSeFault.seMallocFailType)&&
  Objects.equals(this.seMallocFailFrequency, objDebugSeFault.seMallocFailFrequency)&&
  Objects.equals(this.seShmMallocFailType, objDebugSeFault.seShmMallocFailType)&&
  Objects.equals(this.seShmMallocFailFrequency, objDebugSeFault.seShmMallocFailFrequency)&&
  Objects.equals(this.seWafAllocFailFrequency, objDebugSeFault.seWafAllocFailFrequency)&&
  Objects.equals(this.seWafLearningAllocFailFrequency, objDebugSeFault.seWafLearningAllocFailFrequency)&&
  Objects.equals(this.seMbufClSanity, objDebugSeFault.seMbufClSanity)&&
  Objects.equals(this.faults, objDebugSeFault.faults);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugSeFault {\n");
      sb.append("    faults: ").append(toIndentedString(faults)).append("\n");
        sb.append("    seMallocFailFrequency: ").append(toIndentedString(seMallocFailFrequency)).append("\n");
        sb.append("    seMallocFailType: ").append(toIndentedString(seMallocFailType)).append("\n");
        sb.append("    seMbufClSanity: ").append(toIndentedString(seMbufClSanity)).append("\n");
        sb.append("    seShmMallocFailFrequency: ").append(toIndentedString(seShmMallocFailFrequency)).append("\n");
        sb.append("    seShmMallocFailType: ").append(toIndentedString(seShmMallocFailType)).append("\n");
        sb.append("    seWafAllocFailFrequency: ").append(toIndentedString(seWafAllocFailFrequency)).append("\n");
        sb.append("    seWafLearningAllocFailFrequency: ").append(toIndentedString(seWafLearningAllocFailFrequency)).append("\n");
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

