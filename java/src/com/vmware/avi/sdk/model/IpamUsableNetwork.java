package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The IpamUsableNetwork is a POJO class extends AviRestResource that used for creating
 * IpamUsableNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamUsableNetwork  {
    @JsonProperty("labels")
    private List<KeyValueTuple> labels = null;

    @JsonProperty("nw_ref")
    private String nwRef = null;


    /**
     * This is the getter method this will return the attribute value.
     * Labels as key value pairs, used for selection of ipam networks.
     * Field introduced in 20.1.3.
     * Maximum of 1 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public List<KeyValueTuple> getLabels() {
        return labels;
    }

    /**
     * This is the setter method. this will set the labels
     * Labels as key value pairs, used for selection of ipam networks.
     * Field introduced in 20.1.3.
     * Maximum of 1 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public void setLabels(List<KeyValueTuple>  labels) {
        this.labels = labels;
    }

    /**
     * This is the setter method this will set the labels
     * Labels as key value pairs, used for selection of ipam networks.
     * Field introduced in 20.1.3.
     * Maximum of 1 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public IpamUsableNetwork addLabelsItem(KeyValueTuple labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<KeyValueTuple>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Network.
     * It is a reference to an object of type network.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nwRef
     */
    public String getNwRef() {
        return nwRef;
    }

    /**
     * This is the setter method to the attribute.
     * Network.
     * It is a reference to an object of type network.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param nwRef set the nwRef.
     */
    public void setNwRef(String  nwRef) {
        this.nwRef = nwRef;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      IpamUsableNetwork objIpamUsableNetwork = (IpamUsableNetwork) o;
      return   Objects.equals(this.nwRef, objIpamUsableNetwork.nwRef)&&
  Objects.equals(this.labels, objIpamUsableNetwork.labels);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IpamUsableNetwork {\n");
                  sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
                        sb.append("    nwRef: ").append(toIndentedString(nwRef)).append("\n");
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
