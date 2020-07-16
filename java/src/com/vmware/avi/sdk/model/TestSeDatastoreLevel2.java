package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TestSeDatastoreLevel2 is a POJO class extends AviRestResource that used for creating
 * TestSeDatastoreLevel2.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestSeDatastoreLevel2 extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("test_se_datastore_level_3_refs")
    private List<String> testSeDatastoreLevel3Refs = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type testsedatastorelevel3.
   * Field introduced in 18.2.6.
   * @return testSeDatastoreLevel3Refs
   */
  public List<String> getTestSeDatastoreLevel3Refs() {
    return testSeDatastoreLevel3Refs;
  }

  /**
   * This is the setter method. this will set the testSeDatastoreLevel3Refs
   * It is a reference to an object of type testsedatastorelevel3.
   * Field introduced in 18.2.6.
   * @return testSeDatastoreLevel3Refs
   */
  public void setTestSeDatastoreLevel3Refs(List<String>  testSeDatastoreLevel3Refs) {
    this.testSeDatastoreLevel3Refs = testSeDatastoreLevel3Refs;
  }

  /**
   * This is the setter method this will set the testSeDatastoreLevel3Refs
   * It is a reference to an object of type testsedatastorelevel3.
   * Field introduced in 18.2.6.
   * @return testSeDatastoreLevel3Refs
   */
  public TestSeDatastoreLevel2 addTestSeDatastoreLevel3RefsItem(String testSeDatastoreLevel3RefsItem) {
    if (this.testSeDatastoreLevel3Refs == null) {
      this.testSeDatastoreLevel3Refs = new ArrayList<String>();
    }
    this.testSeDatastoreLevel3Refs.add(testSeDatastoreLevel3RefsItem);
    return this;
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
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  TestSeDatastoreLevel2 objTestSeDatastoreLevel2 = (TestSeDatastoreLevel2) o;
  return   Objects.equals(this.testSeDatastoreLevel3Refs, objTestSeDatastoreLevel2.testSeDatastoreLevel3Refs)&&
  Objects.equals(this.tenantRef, objTestSeDatastoreLevel2.tenantRef)&&
  Objects.equals(this.uuid, objTestSeDatastoreLevel2.uuid)&&
  Objects.equals(this.name, objTestSeDatastoreLevel2.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TestSeDatastoreLevel2 {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    testSeDatastoreLevel3Refs: ").append(toIndentedString(testSeDatastoreLevel3Refs)).append("\n");
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

