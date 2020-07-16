package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeUpgradeParams is a POJO class extends AviRestResource that used for creating
 * SeUpgradeParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeUpgradeParams extends AviRestResource  {
    @JsonProperty("disruptive")
    private Boolean disruptive = false;

    @JsonProperty("force")
    private Boolean force = false;

    @JsonProperty("patch")
    private Boolean patch = false;

    @JsonProperty("patch_rollback")
    private Boolean patchRollback = false;

    @JsonProperty("resume_from_suspend")
    private Boolean resumeFromSuspend = false;

    @JsonProperty("rollback")
    private Boolean rollback = false;

    @JsonProperty("se_group_refs")
    private List<String> seGroupRefs = null;

    @JsonProperty("skip_suspended")
    private Boolean skipSuspended = false;

    @JsonProperty("suspend_on_failure")
    private Boolean suspendOnFailure = false;

    @JsonProperty("test")
    private Boolean test = false;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * This field is used to disable scale-in/scale out operations during upgrade operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disruptive
   */
  public Boolean getDisruptive() {
    return disruptive;
  }

  /**
   * This is the setter method to the attribute.
   * This field is used to disable scale-in/scale out operations during upgrade operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disruptive set the disruptive.
   */
  public void setDisruptive(Boolean  disruptive) {
    this.disruptive = disruptive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return force
   */
  public Boolean getForce() {
    return force;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param force set the force.
   */
  public void setForce(Boolean  force) {
    this.force = force;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade system with patch upgrade.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return patch
   */
  public Boolean getPatch() {
    return patch;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade system with patch upgrade.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param patch set the patch.
   */
  public void setPatch(Boolean  patch) {
    this.patch = patch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rollback system with patch upgrade.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return patchRollback
   */
  public Boolean getPatchRollback() {
    return patchRollback;
  }

  /**
   * This is the setter method to the attribute.
   * Rollback system with patch upgrade.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param patchRollback set the patchRollback.
   */
  public void setPatchRollback(Boolean  patchRollback) {
    this.patchRollback = patchRollback;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Resume from suspended state.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return resumeFromSuspend
   */
  public Boolean getResumeFromSuspend() {
    return resumeFromSuspend;
  }

  /**
   * This is the setter method to the attribute.
   * Resume from suspended state.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param resumeFromSuspend set the resumeFromSuspend.
   */
  public void setResumeFromSuspend(Boolean  resumeFromSuspend) {
    this.resumeFromSuspend = resumeFromSuspend;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is used in rollback operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return rollback
   */
  public Boolean getRollback() {
    return rollback;
  }

  /**
   * This is the setter method to the attribute.
   * It is used in rollback operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param rollback set the rollback.
   */
  public void setRollback(Boolean  rollback) {
    this.rollback = rollback;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 17.2.2.
   * @return seGroupRefs
   */
  public List<String> getSeGroupRefs() {
    return seGroupRefs;
  }

  /**
   * This is the setter method. this will set the seGroupRefs
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 17.2.2.
   * @return seGroupRefs
   */
  public void setSeGroupRefs(List<String>  seGroupRefs) {
    this.seGroupRefs = seGroupRefs;
  }

  /**
   * This is the setter method this will set the seGroupRefs
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 17.2.2.
   * @return seGroupRefs
   */
  public SeUpgradeParams addSeGroupRefsItem(String seGroupRefsItem) {
    if (this.seGroupRefs == null) {
      this.seGroupRefs = new ArrayList<String>();
    }
    this.seGroupRefs.add(seGroupRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set, this will skip upgrade on the service engine which is upgrade suspended state.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return skipSuspended
   */
  public Boolean getSkipSuspended() {
    return skipSuspended;
  }

  /**
   * This is the setter method to the attribute.
   * When set, this will skip upgrade on the service engine which is upgrade suspended state.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param skipSuspended set the skipSuspended.
   */
  public void setSkipSuspended(Boolean  skipSuspended) {
    this.skipSuspended = skipSuspended;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set to true, if there is any failure during the se upgrade, upgrade will be suspended for this se group and manual intervention would be
   * needed to resume the upgrade.
   * Field introduced in 17.1.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return suspendOnFailure
   */
  public Boolean getSuspendOnFailure() {
    return suspendOnFailure;
  }

  /**
   * This is the setter method to the attribute.
   * When set to true, if there is any failure during the se upgrade, upgrade will be suspended for this se group and manual intervention would be
   * needed to resume the upgrade.
   * Field introduced in 17.1.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param suspendOnFailure set the suspendOnFailure.
   */
  public void setSuspendOnFailure(Boolean  suspendOnFailure) {
    this.suspendOnFailure = suspendOnFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return test
   */
  public Boolean getTest() {
    return test;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param test set the test.
   */
  public void setTest(Boolean  test) {
    this.test = test;
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
  SeUpgradeParams objSeUpgradeParams = (SeUpgradeParams) o;
  return   Objects.equals(this.patchRollback, objSeUpgradeParams.patchRollback)&&
  Objects.equals(this.rollback, objSeUpgradeParams.rollback)&&
  Objects.equals(this.suspendOnFailure, objSeUpgradeParams.suspendOnFailure)&&
  Objects.equals(this.patch, objSeUpgradeParams.patch)&&
  Objects.equals(this.disruptive, objSeUpgradeParams.disruptive)&&
  Objects.equals(this.resumeFromSuspend, objSeUpgradeParams.resumeFromSuspend)&&
  Objects.equals(this.skipSuspended, objSeUpgradeParams.skipSuspended)&&
  Objects.equals(this.test, objSeUpgradeParams.test)&&
  Objects.equals(this.force, objSeUpgradeParams.force)&&
  Objects.equals(this.seGroupRefs, objSeUpgradeParams.seGroupRefs)&&
  Objects.equals(this.uuid, objSeUpgradeParams.uuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeUpgradeParams {\n");
      sb.append("    disruptive: ").append(toIndentedString(disruptive)).append("\n");
        sb.append("    force: ").append(toIndentedString(force)).append("\n");
        sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
        sb.append("    patchRollback: ").append(toIndentedString(patchRollback)).append("\n");
        sb.append("    resumeFromSuspend: ").append(toIndentedString(resumeFromSuspend)).append("\n");
        sb.append("    rollback: ").append(toIndentedString(rollback)).append("\n");
        sb.append("    seGroupRefs: ").append(toIndentedString(seGroupRefs)).append("\n");
        sb.append("    skipSuspended: ").append(toIndentedString(skipSuspended)).append("\n");
        sb.append("    suspendOnFailure: ").append(toIndentedString(suspendOnFailure)).append("\n");
        sb.append("    test: ").append(toIndentedString(test)).append("\n");
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

