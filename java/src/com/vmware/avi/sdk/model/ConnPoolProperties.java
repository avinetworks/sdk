package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConnPoolProperties is a POJO class extends AviRestResource that used for creating
 * ConnPoolProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnPoolProperties  {
    @JsonProperty("upstream_connpool_conn_idle_tmo")
    private Integer upstreamConnpoolConnIdleTmo = 60000;

    @JsonProperty("upstream_connpool_conn_life_tmo")
    private Integer upstreamConnpoolConnLifeTmo = 600000;

    @JsonProperty("upstream_connpool_conn_max_reuse")
    private Integer upstreamConnpoolConnMaxReuse = 0;

    @JsonProperty("upstream_connpool_server_max_cache")
    private Integer upstreamConnpoolServerMaxCache = 0;



  /**
   * This is the getter method this will return the attribute value.
   * Connection idle timeout.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60000.
   * @return upstreamConnpoolConnIdleTmo
   */
  public Integer getUpstreamConnpoolConnIdleTmo() {
    return upstreamConnpoolConnIdleTmo;
  }

  /**
   * This is the setter method to the attribute.
   * Connection idle timeout.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60000.
   * @param upstreamConnpoolConnIdleTmo set the upstreamConnpoolConnIdleTmo.
   */
  public void setUpstreamConnpoolConnIdleTmo(Integer  upstreamConnpoolConnIdleTmo) {
    this.upstreamConnpoolConnIdleTmo = upstreamConnpoolConnIdleTmo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Connection life timeout.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600000.
   * @return upstreamConnpoolConnLifeTmo
   */
  public Integer getUpstreamConnpoolConnLifeTmo() {
    return upstreamConnpoolConnLifeTmo;
  }

  /**
   * This is the setter method to the attribute.
   * Connection life timeout.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600000.
   * @param upstreamConnpoolConnLifeTmo set the upstreamConnpoolConnLifeTmo.
   */
  public void setUpstreamConnpoolConnLifeTmo(Integer  upstreamConnpoolConnLifeTmo) {
    this.upstreamConnpoolConnLifeTmo = upstreamConnpoolConnLifeTmo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of times a connection can be reused.
   * Special values are 0- 'unlimited'.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return upstreamConnpoolConnMaxReuse
   */
  public Integer getUpstreamConnpoolConnMaxReuse() {
    return upstreamConnpoolConnMaxReuse;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of times a connection can be reused.
   * Special values are 0- 'unlimited'.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param upstreamConnpoolConnMaxReuse set the upstreamConnpoolConnMaxReuse.
   */
  public void setUpstreamConnpoolConnMaxReuse(Integer  upstreamConnpoolConnMaxReuse) {
    this.upstreamConnpoolConnMaxReuse = upstreamConnpoolConnMaxReuse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections a server can cache.
   * Special values are 0- 'unlimited'.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return upstreamConnpoolServerMaxCache
   */
  public Integer getUpstreamConnpoolServerMaxCache() {
    return upstreamConnpoolServerMaxCache;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections a server can cache.
   * Special values are 0- 'unlimited'.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param upstreamConnpoolServerMaxCache set the upstreamConnpoolServerMaxCache.
   */
  public void setUpstreamConnpoolServerMaxCache(Integer  upstreamConnpoolServerMaxCache) {
    this.upstreamConnpoolServerMaxCache = upstreamConnpoolServerMaxCache;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConnPoolProperties objConnPoolProperties = (ConnPoolProperties) o;
  return   Objects.equals(this.upstreamConnpoolConnIdleTmo, objConnPoolProperties.upstreamConnpoolConnIdleTmo)&&
  Objects.equals(this.upstreamConnpoolConnLifeTmo, objConnPoolProperties.upstreamConnpoolConnLifeTmo)&&
  Objects.equals(this.upstreamConnpoolConnMaxReuse, objConnPoolProperties.upstreamConnpoolConnMaxReuse)&&
  Objects.equals(this.upstreamConnpoolServerMaxCache, objConnPoolProperties.upstreamConnpoolServerMaxCache);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConnPoolProperties {\n");
      sb.append("    upstreamConnpoolConnIdleTmo: ").append(toIndentedString(upstreamConnpoolConnIdleTmo)).append("\n");
        sb.append("    upstreamConnpoolConnLifeTmo: ").append(toIndentedString(upstreamConnpoolConnLifeTmo)).append("\n");
        sb.append("    upstreamConnpoolConnMaxReuse: ").append(toIndentedString(upstreamConnpoolConnMaxReuse)).append("\n");
        sb.append("    upstreamConnpoolServerMaxCache: ").append(toIndentedString(upstreamConnpoolServerMaxCache)).append("\n");
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

