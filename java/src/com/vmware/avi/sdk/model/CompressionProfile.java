package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The CompressionProfile is a POJO class extends AviRestResource that used for creating
 * CompressionProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompressionProfile  {
    @JsonProperty("buf_num")
    private Integer bufNum = 128;

    @JsonProperty("buf_size")
    private Integer bufSize = 4096;

    @JsonProperty("compressible_content_ref")
    private String compressibleContentRef = null;

    @JsonProperty("compression")
    private Boolean compression = false;

    @JsonProperty("filter")
    private List<CompressionFilter> filter = null;

    @JsonProperty("hash_size")
    private Integer hashSize = 16384;

    @JsonProperty("level_aggressive")
    private Integer levelAggressive = 5;

    @JsonProperty("level_normal")
    private Integer levelNormal = 1;

    @JsonProperty("max_low_rtt")
    private Integer maxLowRtt = 10;

    @JsonProperty("min_high_rtt")
    private Integer minHighRtt = 200;

    @JsonProperty("min_length")
    private Integer minLength = 128;

    @JsonProperty("mobile_str_ref")
    private String mobileStrRef = null;

    @JsonProperty("remove_accept_encoding_header")
    private Boolean removeAcceptEncodingHeader = true;

    @JsonProperty("type")
    private String type = "AUTO_COMPRESSION";

    @JsonProperty("window_size")
    private Integer windowSize = 4096;



    /**
     * This is the getter method this will return the attribute value.
     * Number of buffers to use for compression output.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @return bufNum
     */
    public Integer getBufNum() {
        return bufNum;
    }

    /**
     * This is the setter method to the attribute.
     * Number of buffers to use for compression output.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @param bufNum set the bufNum.
     */
    public void setBufNum(Integer  bufNum) {
        this.bufNum = bufNum;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Size of each buffer used for compression output, this should ideally be a multiple of pagesize.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
     * @return bufSize
     */
    public Integer getBufSize() {
        return bufSize;
    }

    /**
     * This is the setter method to the attribute.
     * Size of each buffer used for compression output, this should ideally be a multiple of pagesize.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
     * @param bufSize set the bufSize.
     */
    public void setBufSize(Integer  bufSize) {
        this.bufSize = bufSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Compress only content types listed in this string group.
     * Content types not present in this list are not compressed.
     * It is a reference to an object of type stringgroup.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return compressibleContentRef
     */
    public String getCompressibleContentRef() {
        return compressibleContentRef;
    }

    /**
     * This is the setter method to the attribute.
     * Compress only content types listed in this string group.
     * Content types not present in this list are not compressed.
     * It is a reference to an object of type stringgroup.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param compressibleContentRef set the compressibleContentRef.
     */
    public void setCompressibleContentRef(String  compressibleContentRef) {
        this.compressibleContentRef = compressibleContentRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Compress http response content if it wasn't already compressed.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return compression
     */
    public Boolean getCompression() {
        return compression;
    }

    /**
     * This is the setter method to the attribute.
     * Compress http response content if it wasn't already compressed.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param compression set the compression.
     */
    public void setCompression(Boolean  compression) {
        this.compression = compression;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Custom filters used when auto compression is not selected.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filter
     */
    public List<CompressionFilter> getFilter() {
        return filter;
    }

    /**
     * This is the setter method. this will set the filter
     * Custom filters used when auto compression is not selected.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filter
     */
    public void setFilter(List<CompressionFilter>  filter) {
        this.filter = filter;
    }

    /**
     * This is the setter method this will set the filter
     * Custom filters used when auto compression is not selected.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filter
     */
    public CompressionProfile addFilterItem(CompressionFilter filterItem) {
      if (this.filter == null) {
        this.filter = new ArrayList<CompressionFilter>();
      }
      this.filter.add(filterItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Hash size used by compression, rounded to the last power of 2.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
     * @return hashSize
     */
    public Integer getHashSize() {
        return hashSize;
    }

    /**
     * This is the setter method to the attribute.
     * Hash size used by compression, rounded to the last power of 2.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
     * @param hashSize set the hashSize.
     */
    public void setHashSize(Integer  hashSize) {
        this.hashSize = hashSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Level of compression to apply on content selected for aggressive compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @return levelAggressive
     */
    public Integer getLevelAggressive() {
        return levelAggressive;
    }

    /**
     * This is the setter method to the attribute.
     * Level of compression to apply on content selected for aggressive compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @param levelAggressive set the levelAggressive.
     */
    public void setLevelAggressive(Integer  levelAggressive) {
        this.levelAggressive = levelAggressive;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Level of compression to apply on content selected for normal compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @return levelNormal
     */
    public Integer getLevelNormal() {
        return levelNormal;
    }

    /**
     * This is the setter method to the attribute.
     * Level of compression to apply on content selected for normal compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @param levelNormal set the levelNormal.
     */
    public void setLevelNormal(Integer  levelNormal) {
        this.levelNormal = levelNormal;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If client rtt is higher than this threshold, enable normal compression on the response.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @return maxLowRtt
     */
    public Integer getMaxLowRtt() {
        return maxLowRtt;
    }

    /**
     * This is the setter method to the attribute.
     * If client rtt is higher than this threshold, enable normal compression on the response.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @param maxLowRtt set the maxLowRtt.
     */
    public void setMaxLowRtt(Integer  maxLowRtt) {
        this.maxLowRtt = maxLowRtt;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If client rtt is higher than this threshold, enable aggressive compression on the response.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 200.
     * @return minHighRtt
     */
    public Integer getMinHighRtt() {
        return minHighRtt;
    }

    /**
     * This is the setter method to the attribute.
     * If client rtt is higher than this threshold, enable aggressive compression on the response.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 200.
     * @param minHighRtt set the minHighRtt.
     */
    public void setMinHighRtt(Integer  minHighRtt) {
        this.minHighRtt = minHighRtt;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum response content length to enable compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @return minLength
     */
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum response content length to enable compression.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @param minLength set the minLength.
     */
    public void setMinLength(Integer  minLength) {
        this.minLength = minLength;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Values that identify mobile browsers in order to enable aggressive compression.
     * It is a reference to an object of type stringgroup.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mobileStrRef
     */
    public String getMobileStrRef() {
        return mobileStrRef;
    }

    /**
     * This is the setter method to the attribute.
     * Values that identify mobile browsers in order to enable aggressive compression.
     * It is a reference to an object of type stringgroup.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mobileStrRef set the mobileStrRef.
     */
    public void setMobileStrRef(String  mobileStrRef) {
        this.mobileStrRef = mobileStrRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Offload compression from the servers to avi.
     * Saves compute cycles on the servers.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return removeAcceptEncodingHeader
     */
    public Boolean getRemoveAcceptEncodingHeader() {
        return removeAcceptEncodingHeader;
    }

    /**
     * This is the setter method to the attribute.
     * Offload compression from the servers to avi.
     * Saves compute cycles on the servers.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param removeAcceptEncodingHeader set the removeAcceptEncodingHeader.
     */
    public void setRemoveAcceptEncodingHeader(Boolean  removeAcceptEncodingHeader) {
        this.removeAcceptEncodingHeader = removeAcceptEncodingHeader;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Compress content automatically or add custom filters to define compressible content and compression levels.
     * Enum options - AUTO_COMPRESSION, CUSTOM_COMPRESSION.
     * Default value when not specified in API or module is interpreted by Avi Controller as "AUTO_COMPRESSION".
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Compress content automatically or add custom filters to define compressible content and compression levels.
     * Enum options - AUTO_COMPRESSION, CUSTOM_COMPRESSION.
     * Default value when not specified in API or module is interpreted by Avi Controller as "AUTO_COMPRESSION".
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Window size used by compression, rounded to the last power of 2.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
     * @return windowSize
     */
    public Integer getWindowSize() {
        return windowSize;
    }

    /**
     * This is the setter method to the attribute.
     * Window size used by compression, rounded to the last power of 2.
     * Field introduced in 21.1.1.
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
      CompressionProfile objCompressionProfile = (CompressionProfile) o;
      return   Objects.equals(this.compression, objCompressionProfile.compression)&&
  Objects.equals(this.removeAcceptEncodingHeader, objCompressionProfile.removeAcceptEncodingHeader)&&
  Objects.equals(this.compressibleContentRef, objCompressionProfile.compressibleContentRef)&&
  Objects.equals(this.type, objCompressionProfile.type)&&
  Objects.equals(this.filter, objCompressionProfile.filter)&&
  Objects.equals(this.bufNum, objCompressionProfile.bufNum)&&
  Objects.equals(this.bufSize, objCompressionProfile.bufSize)&&
  Objects.equals(this.levelNormal, objCompressionProfile.levelNormal)&&
  Objects.equals(this.levelAggressive, objCompressionProfile.levelAggressive)&&
  Objects.equals(this.windowSize, objCompressionProfile.windowSize)&&
  Objects.equals(this.hashSize, objCompressionProfile.hashSize)&&
  Objects.equals(this.minLength, objCompressionProfile.minLength)&&
  Objects.equals(this.maxLowRtt, objCompressionProfile.maxLowRtt)&&
  Objects.equals(this.minHighRtt, objCompressionProfile.minHighRtt)&&
  Objects.equals(this.mobileStrRef, objCompressionProfile.mobileStrRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CompressionProfile {\n");
                  sb.append("    bufNum: ").append(toIndentedString(bufNum)).append("\n");
                        sb.append("    bufSize: ").append(toIndentedString(bufSize)).append("\n");
                        sb.append("    compressibleContentRef: ").append(toIndentedString(compressibleContentRef)).append("\n");
                        sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
                        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
                        sb.append("    hashSize: ").append(toIndentedString(hashSize)).append("\n");
                        sb.append("    levelAggressive: ").append(toIndentedString(levelAggressive)).append("\n");
                        sb.append("    levelNormal: ").append(toIndentedString(levelNormal)).append("\n");
                        sb.append("    maxLowRtt: ").append(toIndentedString(maxLowRtt)).append("\n");
                        sb.append("    minHighRtt: ").append(toIndentedString(minHighRtt)).append("\n");
                        sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
                        sb.append("    mobileStrRef: ").append(toIndentedString(mobileStrRef)).append("\n");
                        sb.append("    removeAcceptEncodingHeader: ").append(toIndentedString(removeAcceptEncodingHeader)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
