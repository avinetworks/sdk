package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HttpCacheConfig is a POJO class extends AviRestResource that used for creating
 * HttpCacheConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpCacheConfig  {
    @JsonProperty("age_header")
    private Boolean ageHeader = true;

    @JsonProperty("aggressive")
    private Boolean aggressive = false;

    @JsonProperty("date_header")
    private Boolean dateHeader = true;

    @JsonProperty("default_expire")
    private Integer defaultExpire = 600;

    @JsonProperty("enabled")
    private Boolean enabled = false;

    @JsonProperty("heuristic_expire")
    private Boolean heuristicExpire = false;

    @JsonProperty("ignore_request_cache_control")
    private Boolean ignoreRequestCacheControl = false;

    @JsonProperty("max_cache_size")
    private Integer maxCacheSize = 0;

    @JsonProperty("max_object_size")
    private Integer maxObjectSize = 4194304;

    @JsonProperty("mime_types_black_group_refs")
    private List<String> mimeTypesBlackGroupRefs = null;

    @JsonProperty("mime_types_black_list")
    private List<String> mimeTypesBlackList = null;

    @JsonProperty("mime_types_group_refs")
    private List<String> mimeTypesGroupRefs = null;

    @JsonProperty("mime_types_list")
    private List<String> mimeTypesList = null;

    @JsonProperty("min_object_size")
    private Integer minObjectSize = 100;

    @JsonProperty("query_cacheable")
    private Boolean queryCacheable = false;

    @JsonProperty("uri_non_cacheable")
    private PathMatch uriNonCacheable = null;

    @JsonProperty("xcache_header")
    private Boolean xcacheHeader = true;



  /**
   * This is the getter method this will return the attribute value.
   * Add an age header to content served from cache, which indicates to the client the number of seconds the object has been in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return ageHeader
   */
  public Boolean getAgeHeader() {
    return ageHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Add an age header to content served from cache, which indicates to the client the number of seconds the object has been in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param ageHeader set the ageHeader.
   */
  public void setAgeHeader(Boolean  ageHeader) {
    this.ageHeader = ageHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable caching objects without cache-control headers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return aggressive
   */
  public Boolean getAggressive() {
    return aggressive;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable caching objects without cache-control headers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param aggressive set the aggressive.
   */
  public void setAggressive(Boolean  aggressive) {
    this.aggressive = aggressive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If a date header was not added by the server, add a date header to the object served from cache.
   * This indicates to the client when the object was originally sent by the server to the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return dateHeader
   */
  public Boolean getDateHeader() {
    return dateHeader;
  }

  /**
   * This is the setter method to the attribute.
   * If a date header was not added by the server, add a date header to the object served from cache.
   * This indicates to the client when the object was originally sent by the server to the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param dateHeader set the dateHeader.
   */
  public void setDateHeader(Boolean  dateHeader) {
    this.dateHeader = dateHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default expiration time of cache objects received from the server without a cache-control expiration header.
   * This value may be overwritten by the heuristic expire setting.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return defaultExpire
   */
  public Integer getDefaultExpire() {
    return defaultExpire;
  }

  /**
   * This is the setter method to the attribute.
   * Default expiration time of cache objects received from the server without a cache-control expiration header.
   * This value may be overwritten by the heuristic expire setting.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param defaultExpire set the defaultExpire.
   */
  public void setDefaultExpire(Integer  defaultExpire) {
    this.defaultExpire = defaultExpire;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable http object caching.when enabling caching for the first time, se group app_cache_percent must beset to allocate shared memory
   * required for caching (a service engine restart is needed after setting/resetting the se group value).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable http object caching.when enabling caching for the first time, se group app_cache_percent must beset to allocate shared memory
   * required for caching (a service engine restart is needed after setting/resetting the se group value).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If a response object from the server does not include the cache-control header, but does include a last-modified header, the system will use this
   * time to calculate the cache-control expiration.
   * If unable to solicit an last-modified header, then the system will fall back to the cache expire time value.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return heuristicExpire
   */
  public Boolean getHeuristicExpire() {
    return heuristicExpire;
  }

  /**
   * This is the setter method to the attribute.
   * If a response object from the server does not include the cache-control header, but does include a last-modified header, the system will use this
   * time to calculate the cache-control expiration.
   * If unable to solicit an last-modified header, then the system will fall back to the cache expire time value.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param heuristicExpire set the heuristicExpire.
   */
  public void setHeuristicExpire(Boolean  heuristicExpire) {
    this.heuristicExpire = heuristicExpire;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ignore client's cache control headers when fetching or storing from and to the cache.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignoreRequestCacheControl
   */
  public Boolean getIgnoreRequestCacheControl() {
    return ignoreRequestCacheControl;
  }

  /**
   * This is the setter method to the attribute.
   * Ignore client's cache control headers when fetching or storing from and to the cache.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignoreRequestCacheControl set the ignoreRequestCacheControl.
   */
  public void setIgnoreRequestCacheControl(Boolean  ignoreRequestCacheControl) {
    this.ignoreRequestCacheControl = ignoreRequestCacheControl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max size, in bytes, of the cache.
   * The default, zero, indicates auto configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxCacheSize
   */
  public Integer getMaxCacheSize() {
    return maxCacheSize;
  }

  /**
   * This is the setter method to the attribute.
   * Max size, in bytes, of the cache.
   * The default, zero, indicates auto configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxCacheSize set the maxCacheSize.
   */
  public void setMaxCacheSize(Integer  maxCacheSize) {
    this.maxCacheSize = maxCacheSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size of an object to store in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4194304.
   * @return maxObjectSize
   */
  public Integer getMaxObjectSize() {
    return maxObjectSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size of an object to store in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4194304.
   * @param maxObjectSize set the maxObjectSize.
   */
  public void setMaxObjectSize(Integer  maxObjectSize) {
    this.maxObjectSize = maxObjectSize;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Blacklist string group of non-cacheable mime types.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesBlackGroupRefs
   */
  public List<String> getMimeTypesBlackGroupRefs() {
    return mimeTypesBlackGroupRefs;
  }

  /**
   * This is the setter method. this will set the mimeTypesBlackGroupRefs
   * Blacklist string group of non-cacheable mime types.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesBlackGroupRefs
   */
  public void setMimeTypesBlackGroupRefs(List<String>  mimeTypesBlackGroupRefs) {
    this.mimeTypesBlackGroupRefs = mimeTypesBlackGroupRefs;
  }

  /**
   * This is the setter method this will set the mimeTypesBlackGroupRefs
   * Blacklist string group of non-cacheable mime types.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesBlackGroupRefs
   */
  public HttpCacheConfig addMimeTypesBlackGroupRefsItem(String mimeTypesBlackGroupRefsItem) {
    if (this.mimeTypesBlackGroupRefs == null) {
      this.mimeTypesBlackGroupRefs = new ArrayList<String>();
    }
    this.mimeTypesBlackGroupRefs.add(mimeTypesBlackGroupRefsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Blacklist of non-cacheable mime types.
   * @return mimeTypesBlackList
   */
  public List<String> getMimeTypesBlackList() {
    return mimeTypesBlackList;
  }

  /**
   * This is the setter method. this will set the mimeTypesBlackList
   * Blacklist of non-cacheable mime types.
   * @return mimeTypesBlackList
   */
  public void setMimeTypesBlackList(List<String>  mimeTypesBlackList) {
    this.mimeTypesBlackList = mimeTypesBlackList;
  }

  /**
   * This is the setter method this will set the mimeTypesBlackList
   * Blacklist of non-cacheable mime types.
   * @return mimeTypesBlackList
   */
  public HttpCacheConfig addMimeTypesBlackListItem(String mimeTypesBlackListItem) {
    if (this.mimeTypesBlackList == null) {
      this.mimeTypesBlackList = new ArrayList<String>();
    }
    this.mimeTypesBlackList.add(mimeTypesBlackListItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Whitelist string group of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesGroupRefs
   */
  public List<String> getMimeTypesGroupRefs() {
    return mimeTypesGroupRefs;
  }

  /**
   * This is the setter method. this will set the mimeTypesGroupRefs
   * Whitelist string group of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesGroupRefs
   */
  public void setMimeTypesGroupRefs(List<String>  mimeTypesGroupRefs) {
    this.mimeTypesGroupRefs = mimeTypesGroupRefs;
  }

  /**
   * This is the setter method this will set the mimeTypesGroupRefs
   * Whitelist string group of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * It is a reference to an object of type stringgroup.
   * @return mimeTypesGroupRefs
   */
  public HttpCacheConfig addMimeTypesGroupRefsItem(String mimeTypesGroupRefsItem) {
    if (this.mimeTypesGroupRefs == null) {
      this.mimeTypesGroupRefs = new ArrayList<String>();
    }
    this.mimeTypesGroupRefs.add(mimeTypesGroupRefsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Whitelist of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * @return mimeTypesList
   */
  public List<String> getMimeTypesList() {
    return mimeTypesList;
  }

  /**
   * This is the setter method. this will set the mimeTypesList
   * Whitelist of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * @return mimeTypesList
   */
  public void setMimeTypesList(List<String>  mimeTypesList) {
    this.mimeTypesList = mimeTypesList;
  }

  /**
   * This is the setter method this will set the mimeTypesList
   * Whitelist of cacheable mime types.
   * If both cacheable mime types string list and string group are empty, this defaults to *\/*.
   * @return mimeTypesList
   */
  public HttpCacheConfig addMimeTypesListItem(String mimeTypesListItem) {
    if (this.mimeTypesList == null) {
      this.mimeTypesList = new ArrayList<String>();
    }
    this.mimeTypesList.add(mimeTypesListItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum size of an object to store in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return minObjectSize
   */
  public Integer getMinObjectSize() {
    return minObjectSize;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum size of an object to store in the cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param minObjectSize set the minObjectSize.
   */
  public void setMinObjectSize(Integer  minObjectSize) {
    this.minObjectSize = minObjectSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow caching of objects whose uri included a query argument.
   * When disabled, these objects are not cached.
   * When enabled, the request must match the uri query to be considered a hit.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return queryCacheable
   */
  public Boolean getQueryCacheable() {
    return queryCacheable;
  }

  /**
   * This is the setter method to the attribute.
   * Allow caching of objects whose uri included a query argument.
   * When disabled, these objects are not cached.
   * When enabled, the request must match the uri query to be considered a hit.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param queryCacheable set the queryCacheable.
   */
  public void setQueryCacheable(Boolean  queryCacheable) {
    this.queryCacheable = queryCacheable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Non-cacheable uri configuration with match criteria.
   * Field introduced in 18.1.2.
   * @return uriNonCacheable
   */
  public PathMatch getUriNonCacheable() {
    return uriNonCacheable;
  }

  /**
   * This is the setter method to the attribute.
   * Non-cacheable uri configuration with match criteria.
   * Field introduced in 18.1.2.
   * @param uriNonCacheable set the uriNonCacheable.
   */
  public void setUriNonCacheable(PathMatch uriNonCacheable) {
    this.uriNonCacheable = uriNonCacheable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add an x-cache header to content served from cache, which indicates to the client that the object was served from an intermediate cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return xcacheHeader
   */
  public Boolean getXcacheHeader() {
    return xcacheHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Add an x-cache header to content served from cache, which indicates to the client that the object was served from an intermediate cache.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param xcacheHeader set the xcacheHeader.
   */
  public void setXcacheHeader(Boolean  xcacheHeader) {
    this.xcacheHeader = xcacheHeader;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HttpCacheConfig objHttpCacheConfig = (HttpCacheConfig) o;
  return   Objects.equals(this.uriNonCacheable, objHttpCacheConfig.uriNonCacheable)&&
  Objects.equals(this.minObjectSize, objHttpCacheConfig.minObjectSize)&&
  Objects.equals(this.mimeTypesBlackGroupRefs, objHttpCacheConfig.mimeTypesBlackGroupRefs)&&
  Objects.equals(this.queryCacheable, objHttpCacheConfig.queryCacheable)&&
  Objects.equals(this.xcacheHeader, objHttpCacheConfig.xcacheHeader)&&
  Objects.equals(this.ageHeader, objHttpCacheConfig.ageHeader)&&
  Objects.equals(this.mimeTypesList, objHttpCacheConfig.mimeTypesList)&&
  Objects.equals(this.enabled, objHttpCacheConfig.enabled)&&
  Objects.equals(this.defaultExpire, objHttpCacheConfig.defaultExpire)&&
  Objects.equals(this.maxCacheSize, objHttpCacheConfig.maxCacheSize)&&
  Objects.equals(this.mimeTypesGroupRefs, objHttpCacheConfig.mimeTypesGroupRefs)&&
  Objects.equals(this.heuristicExpire, objHttpCacheConfig.heuristicExpire)&&
  Objects.equals(this.dateHeader, objHttpCacheConfig.dateHeader)&&
  Objects.equals(this.aggressive, objHttpCacheConfig.aggressive)&&
  Objects.equals(this.maxObjectSize, objHttpCacheConfig.maxObjectSize)&&
  Objects.equals(this.mimeTypesBlackList, objHttpCacheConfig.mimeTypesBlackList)&&
  Objects.equals(this.ignoreRequestCacheControl, objHttpCacheConfig.ignoreRequestCacheControl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HttpCacheConfig {\n");
      sb.append("    ageHeader: ").append(toIndentedString(ageHeader)).append("\n");
        sb.append("    aggressive: ").append(toIndentedString(aggressive)).append("\n");
        sb.append("    dateHeader: ").append(toIndentedString(dateHeader)).append("\n");
        sb.append("    defaultExpire: ").append(toIndentedString(defaultExpire)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    heuristicExpire: ").append(toIndentedString(heuristicExpire)).append("\n");
        sb.append("    ignoreRequestCacheControl: ").append(toIndentedString(ignoreRequestCacheControl)).append("\n");
        sb.append("    maxCacheSize: ").append(toIndentedString(maxCacheSize)).append("\n");
        sb.append("    maxObjectSize: ").append(toIndentedString(maxObjectSize)).append("\n");
        sb.append("    mimeTypesBlackGroupRefs: ").append(toIndentedString(mimeTypesBlackGroupRefs)).append("\n");
        sb.append("    mimeTypesBlackList: ").append(toIndentedString(mimeTypesBlackList)).append("\n");
        sb.append("    mimeTypesGroupRefs: ").append(toIndentedString(mimeTypesGroupRefs)).append("\n");
        sb.append("    mimeTypesList: ").append(toIndentedString(mimeTypesList)).append("\n");
        sb.append("    minObjectSize: ").append(toIndentedString(minObjectSize)).append("\n");
        sb.append("    queryCacheable: ").append(toIndentedString(queryCacheable)).append("\n");
        sb.append("    uriNonCacheable: ").append(toIndentedString(uriNonCacheable)).append("\n");
        sb.append("    xcacheHeader: ").append(toIndentedString(xcacheHeader)).append("\n");
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

