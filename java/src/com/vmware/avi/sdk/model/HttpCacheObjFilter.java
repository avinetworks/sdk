package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HttpCacheObjFilter is a POJO class extends AviRestResource that used for creating
 * HttpCacheObjFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpCacheObjFilter  {
    @JsonProperty("key")
    private String key = null;

    @JsonProperty("raw_key")
    private String rawKey = null;

    @JsonProperty("resource_name")
    private String resourceName = null;

    @JsonProperty("resource_type")
    private String resourceType = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Http cache object's exact key.
   * @return key
   */
  public String getKey() {
    return key;
  }

  /**
   * This is the setter method to the attribute.
   * Http cache object's exact key.
   * @param key set the key.
   */
  public void setKey(String  key) {
    this.key = key;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http cache object's exact raw key.
   * @return rawKey
   */
  public String getRawKey() {
    return rawKey;
  }

  /**
   * This is the setter method to the attribute.
   * Http cache object's exact raw key.
   * @param rawKey set the rawKey.
   */
  public void setRawKey(String  rawKey) {
    this.rawKey = rawKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http cache object's resource name.
   * @return resourceName
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * This is the setter method to the attribute.
   * Http cache object's resource name.
   * @param resourceName set the resourceName.
   */
  public void setResourceName(String  resourceName) {
    this.resourceName = resourceName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Objects with resource type.
   * @return resourceType
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * This is the setter method to the attribute.
   * Objects with resource type.
   * @param resourceType set the resourceType.
   */
  public void setResourceType(String  resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http cache object type.
   * Enum options - CO_ALL, CO_IN, CO_OUT.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Http cache object type.
   * Enum options - CO_ALL, CO_IN, CO_OUT.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HttpCacheObjFilter objHttpCacheObjFilter = (HttpCacheObjFilter) o;
  return   Objects.equals(this.type, objHttpCacheObjFilter.type)&&
  Objects.equals(this.key, objHttpCacheObjFilter.key)&&
  Objects.equals(this.rawKey, objHttpCacheObjFilter.rawKey)&&
  Objects.equals(this.resourceName, objHttpCacheObjFilter.resourceName)&&
  Objects.equals(this.resourceType, objHttpCacheObjFilter.resourceType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HttpCacheObjFilter {\n");
      sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    rawKey: ").append(toIndentedString(rawKey)).append("\n");
        sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

