package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeBootupCompressionProperties is a POJO class extends AviRestResource that used for creating
 * SeBootupCompressionProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeBootupCompressionProperties  {
    @JsonProperty("buf_num")
    private Integer bufNum = 128;

    @JsonProperty("buf_size")
    private Integer bufSize = 4096;

    @JsonProperty("hash_size")
    private Integer hashSize = 16384;

    @JsonProperty("level_aggressive")
    private Integer levelAggressive = 5;

    @JsonProperty("level_normal")
    private Integer levelNormal = 1;

    @JsonProperty("window_size")
    private Integer windowSize = 4096;



  /**
   * This is the getter method this will return the attribute value.
   * Number of buffers to use for compression output.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return bufNum
   */
  public Integer getBufNum() {
    return bufNum;
  }

  /**
   * This is the setter method to the attribute.
   * Number of buffers to use for compression output.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param bufNum set the bufNum.
   */
  public void setBufNum(Integer  bufNum) {
    this.bufNum = bufNum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Size of each buffer used for compression output, this should ideally be a multiple of pagesize.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @return bufSize
   */
  public Integer getBufSize() {
    return bufSize;
  }

  /**
   * This is the setter method to the attribute.
   * Size of each buffer used for compression output, this should ideally be a multiple of pagesize.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @param bufSize set the bufSize.
   */
  public void setBufSize(Integer  bufSize) {
    this.bufSize = bufSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Hash size used by compression, rounded to the last power of 2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @return hashSize
   */
  public Integer getHashSize() {
    return hashSize;
  }

  /**
   * This is the setter method to the attribute.
   * Hash size used by compression, rounded to the last power of 2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @param hashSize set the hashSize.
   */
  public void setHashSize(Integer  hashSize) {
    this.hashSize = hashSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Level of compression to apply on content selected for aggressive compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return levelAggressive
   */
  public Integer getLevelAggressive() {
    return levelAggressive;
  }

  /**
   * This is the setter method to the attribute.
   * Level of compression to apply on content selected for aggressive compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param levelAggressive set the levelAggressive.
   */
  public void setLevelAggressive(Integer  levelAggressive) {
    this.levelAggressive = levelAggressive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Level of compression to apply on content selected for normal compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return levelNormal
   */
  public Integer getLevelNormal() {
    return levelNormal;
  }

  /**
   * This is the setter method to the attribute.
   * Level of compression to apply on content selected for normal compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param levelNormal set the levelNormal.
   */
  public void setLevelNormal(Integer  levelNormal) {
    this.levelNormal = levelNormal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Window size used by compression, rounded to the last power of 2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @return windowSize
   */
  public Integer getWindowSize() {
    return windowSize;
  }

  /**
   * This is the setter method to the attribute.
   * Window size used by compression, rounded to the last power of 2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @param windowSize set the windowSize.
   */
  public void setWindowSize(Integer  windowSize) {
    this.windowSize = windowSize;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeBootupCompressionProperties objSeBootupCompressionProperties = (SeBootupCompressionProperties) o;
  return   Objects.equals(this.windowSize, objSeBootupCompressionProperties.windowSize)&&
  Objects.equals(this.bufSize, objSeBootupCompressionProperties.bufSize)&&
  Objects.equals(this.levelAggressive, objSeBootupCompressionProperties.levelAggressive)&&
  Objects.equals(this.bufNum, objSeBootupCompressionProperties.bufNum)&&
  Objects.equals(this.levelNormal, objSeBootupCompressionProperties.levelNormal)&&
  Objects.equals(this.hashSize, objSeBootupCompressionProperties.hashSize);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeBootupCompressionProperties {\n");
      sb.append("    bufNum: ").append(toIndentedString(bufNum)).append("\n");
        sb.append("    bufSize: ").append(toIndentedString(bufSize)).append("\n");
        sb.append("    hashSize: ").append(toIndentedString(hashSize)).append("\n");
        sb.append("    levelAggressive: ").append(toIndentedString(levelAggressive)).append("\n");
        sb.append("    levelNormal: ").append(toIndentedString(levelNormal)).append("\n");
        sb.append("    windowSize: ").append(toIndentedString(windowSize)).append("\n");
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

