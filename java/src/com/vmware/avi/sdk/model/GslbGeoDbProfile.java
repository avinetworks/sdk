package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GslbGeoDbProfile is a POJO class extends AviRestResource that used for creating
 * GslbGeoDbProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbGeoDbProfile extends AviRestResource  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("entries")
    private List<GslbGeoDbEntry> entries = null;

    @JsonProperty("is_federated")
    private Boolean isFederated = true;

    @JsonProperty("labels")
    private List<KeyValue> labels = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }
    /**
     * This is the getter method this will return the attribute value.
     * List of geodb entries.
     * An entry can either be a geodb file or an ip address group with geo properties.
     * Field introduced in 17.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return entries
     */
    public List<GslbGeoDbEntry> getEntries() {
        return entries;
    }

    /**
     * This is the setter method. this will set the entries
     * List of geodb entries.
     * An entry can either be a geodb file or an ip address group with geo properties.
     * Field introduced in 17.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return entries
     */
    public void setEntries(List<GslbGeoDbEntry>  entries) {
        this.entries = entries;
    }

    /**
     * This is the setter method this will set the entries
     * List of geodb entries.
     * An entry can either be a geodb file or an ip address group with geo properties.
     * Field introduced in 17.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return entries
     */
    public GslbGeoDbProfile addEntriesItem(GslbGeoDbEntry entriesItem) {
      if (this.entries == null) {
        this.entries = new ArrayList<GslbGeoDbEntry>();
      }
      this.entries.add(entriesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * This field indicates that this object is replicated across gslb federation.
     * Field introduced in 17.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return isFederated
     */
    public Boolean getIsFederated() {
        return isFederated;
    }

    /**
     * This is the setter method to the attribute.
     * This field indicates that this object is replicated across gslb federation.
     * Field introduced in 17.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param isFederated set the isFederated.
     */
    public void setIsFederated(Boolean  isFederated) {
        this.isFederated = isFederated;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public List<KeyValue> getLabels() {
        return labels;
    }

    /**
     * This is the setter method. this will set the labels
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public void setLabels(List<KeyValue>  labels) {
        this.labels = labels;
    }

    /**
     * This is the setter method this will set the labels
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public GslbGeoDbProfile addLabelsItem(KeyValue labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<KeyValue>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * A user-friendly name for the geodb profile.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * A user-friendly name for the geodb profile.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Avi controller URL of the object.
     * @return url
     */
    public String getUrl() {
        return url;
    }

   /**
    * This is the setter method. this will set the url
    * Avi controller URL of the object.
    * @return url
    */
   public void setUrl(String  url) {
     this.url = url;
   }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the geodb profile.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the geodb profile.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GslbGeoDbProfile objGslbGeoDbProfile = (GslbGeoDbProfile) o;
      return   Objects.equals(this.uuid, objGslbGeoDbProfile.uuid)&&
  Objects.equals(this.name, objGslbGeoDbProfile.name)&&
  Objects.equals(this.entries, objGslbGeoDbProfile.entries)&&
  Objects.equals(this.labels, objGslbGeoDbProfile.labels)&&
  Objects.equals(this.isFederated, objGslbGeoDbProfile.isFederated)&&
  Objects.equals(this.description, objGslbGeoDbProfile.description)&&
  Objects.equals(this.tenantRef, objGslbGeoDbProfile.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GslbGeoDbProfile {\n");
                  sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
                        sb.append("    isFederated: ").append(toIndentedString(isFederated)).append("\n");
                        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                                    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
