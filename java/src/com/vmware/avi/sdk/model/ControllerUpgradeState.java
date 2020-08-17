package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerUpgradeState is a POJO class extends AviRestResource that used for creating
 * ControllerUpgradeState.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerUpgradeState  {
    @JsonProperty("controller_progress")
    private Integer controllerProgress = null;

    @JsonProperty("in_progress")
    private Boolean inProgress = null;

    @JsonProperty("notes")
    private List<String> notes = null;

    @JsonProperty("rollback")
    private Boolean rollback = null;

    @JsonProperty("state")
    private String state = null;

    @JsonProperty("tasks_completed")
    private List<UpgradeTask> tasksCompleted = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property controller_progress of obj type controllerupgradestate field type str  type integer.
   * @return controllerProgress
   */
  public Integer getControllerProgress() {
    return controllerProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_progress of obj type controllerupgradestate field type str  type integer.
   * @param controllerProgress set the controllerProgress.
   */
  public void setControllerProgress(Integer  controllerProgress) {
    this.controllerProgress = controllerProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property in_progress of obj type controllerupgradestate field type str  type boolean.
   * @return inProgress
   */
  public Boolean getInProgress() {
    return inProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property in_progress of obj type controllerupgradestate field type str  type boolean.
   * @param inProgress set the inProgress.
   */
  public void setInProgress(Boolean  inProgress) {
    this.inProgress = inProgress;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property notes of obj type controllerupgradestate field type str  type array.
   * @return notes
   */
  public List<String> getNotes() {
    return notes;
  }

  /**
   * This is the setter method. this will set the notes
   * Placeholder for description of property notes of obj type controllerupgradestate field type str  type array.
   * @return notes
   */
  public void setNotes(List<String>  notes) {
    this.notes = notes;
  }

  /**
   * This is the setter method this will set the notes
   * Placeholder for description of property notes of obj type controllerupgradestate field type str  type array.
   * @return notes
   */
  public ControllerUpgradeState addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<String>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rollback of obj type controllerupgradestate field type str  type boolean.
   * @return rollback
   */
  public Boolean getRollback() {
    return rollback;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rollback of obj type controllerupgradestate field type str  type boolean.
   * @param rollback set the rollback.
   */
  public void setRollback(Boolean  rollback) {
    this.rollback = rollback;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - UPGRADE_STARTED, UPGRADE_WAITING, UPGRADE_IN_PROGRESS, UPGRADE_CONTROLLER_COMPLETED, UPGRADE_COMPLETED, UPGRADE_ABORT_IN_PROGRESS,
   * UPGRADE_ABORTED, UPGRADE_DUMMY_1, UPGRADE_DUMMY_2, UPGRADE_DUMMY_3, UPGRADE_DUMMY_4, UPGRADE_DUMMY_5.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - UPGRADE_STARTED, UPGRADE_WAITING, UPGRADE_IN_PROGRESS, UPGRADE_CONTROLLER_COMPLETED, UPGRADE_COMPLETED, UPGRADE_ABORT_IN_PROGRESS,
   * UPGRADE_ABORTED, UPGRADE_DUMMY_1, UPGRADE_DUMMY_2, UPGRADE_DUMMY_3, UPGRADE_DUMMY_4, UPGRADE_DUMMY_5.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tasks_completed of obj type controllerupgradestate field type str  type array.
   * @return tasksCompleted
   */
  public List<UpgradeTask> getTasksCompleted() {
    return tasksCompleted;
  }

  /**
   * This is the setter method. this will set the tasksCompleted
   * Placeholder for description of property tasks_completed of obj type controllerupgradestate field type str  type array.
   * @return tasksCompleted
   */
  public void setTasksCompleted(List<UpgradeTask>  tasksCompleted) {
    this.tasksCompleted = tasksCompleted;
  }

  /**
   * This is the setter method this will set the tasksCompleted
   * Placeholder for description of property tasks_completed of obj type controllerupgradestate field type str  type array.
   * @return tasksCompleted
   */
  public ControllerUpgradeState addTasksCompletedItem(UpgradeTask tasksCompletedItem) {
    if (this.tasksCompleted == null) {
      this.tasksCompleted = new ArrayList<UpgradeTask>();
    }
    this.tasksCompleted.add(tasksCompletedItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ControllerUpgradeState objControllerUpgradeState = (ControllerUpgradeState) o;
  return   Objects.equals(this.inProgress, objControllerUpgradeState.inProgress)&&
  Objects.equals(this.state, objControllerUpgradeState.state)&&
  Objects.equals(this.tasksCompleted, objControllerUpgradeState.tasksCompleted)&&
  Objects.equals(this.controllerProgress, objControllerUpgradeState.controllerProgress)&&
  Objects.equals(this.rollback, objControllerUpgradeState.rollback)&&
  Objects.equals(this.notes, objControllerUpgradeState.notes);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerUpgradeState {\n");
      sb.append("    controllerProgress: ").append(toIndentedString(controllerProgress)).append("\n");
        sb.append("    inProgress: ").append(toIndentedString(inProgress)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    rollback: ").append(toIndentedString(rollback)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    tasksCompleted: ").append(toIndentedString(tasksCompleted)).append("\n");
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

