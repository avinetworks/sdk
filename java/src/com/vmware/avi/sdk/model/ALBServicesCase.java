package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ALBServicesCase is a POJO class extends AviRestResource that used for creating
 * ALBServicesCase.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ALBServicesCase  {
    @JsonProperty("asset_id")
    private String assetId = null;

    @JsonProperty("case_attachments")
    private List<ALBServicesCaseAttachment> caseAttachments = null;

    @JsonProperty("case_created_by")
    private String caseCreatedBy = null;

    @JsonProperty("case_number")
    private String caseNumber = null;

    @JsonProperty("case_status")
    private String caseStatus = null;

    @JsonProperty("contact_info")
    private ALBServicesUser contactInfo = null;

    @JsonProperty("created_date")
    private String createdDate = null;

    @JsonProperty("custom_tag")
    private String customTag = null;

    @JsonProperty("deployment_environment")
    private String deploymentEnvironment = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("environment")
    private String environment = null;

    @JsonProperty("fr_business_justification")
    private String frBusinessJustification = null;

    @JsonProperty("fr_current_solution")
    private String frCurrentSolution = null;

    @JsonProperty("fr_timing")
    private String frTiming = null;

    @JsonProperty("fr_use_cases")
    private String frUseCases = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("last_modified_date")
    private String lastModifiedDate = null;

    @JsonProperty("patch_version")
    private String patchVersion = null;

    @JsonProperty("severity")
    private String severity = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("subject")
    private String subject = null;

    @JsonProperty("time")
    private String time = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return assetId
   */
  public String getAssetId() {
    return assetId;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param assetId set the assetId.
   */
  public void setAssetId(String  assetId) {
    this.assetId = assetId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return caseAttachments
   */
  public List<ALBServicesCaseAttachment> getCaseAttachments() {
    return caseAttachments;
  }

  /**
   * This is the setter method. this will set the caseAttachments
   * Field introduced in 18.2.6.
   * @return caseAttachments
   */
  public void setCaseAttachments(List<ALBServicesCaseAttachment>  caseAttachments) {
    this.caseAttachments = caseAttachments;
  }

  /**
   * This is the setter method this will set the caseAttachments
   * Field introduced in 18.2.6.
   * @return caseAttachments
   */
  public ALBServicesCase addCaseAttachmentsItem(ALBServicesCaseAttachment caseAttachmentsItem) {
    if (this.caseAttachments == null) {
      this.caseAttachments = new ArrayList<ALBServicesCaseAttachment>();
    }
    this.caseAttachments.add(caseAttachmentsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return caseCreatedBy
   */
  public String getCaseCreatedBy() {
    return caseCreatedBy;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param caseCreatedBy set the caseCreatedBy.
   */
  public void setCaseCreatedBy(String  caseCreatedBy) {
    this.caseCreatedBy = caseCreatedBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return caseNumber
   */
  public String getCaseNumber() {
    return caseNumber;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param caseNumber set the caseNumber.
   */
  public void setCaseNumber(String  caseNumber) {
    this.caseNumber = caseNumber;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return caseStatus
   */
  public String getCaseStatus() {
    return caseStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param caseStatus set the caseStatus.
   */
  public void setCaseStatus(String  caseStatus) {
    this.caseStatus = caseStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Contact information associated to particular case.
   * Field introduced in 20.1.1.
   * @return contactInfo
   */
  public ALBServicesUser getContactInfo() {
    return contactInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Contact information associated to particular case.
   * Field introduced in 20.1.1.
   * @param contactInfo set the contactInfo.
   */
  public void setContactInfo(ALBServicesUser contactInfo) {
    this.contactInfo = contactInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param createdDate set the createdDate.
   */
  public void setCreatedDate(String  createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return customTag
   */
  public String getCustomTag() {
    return customTag;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param customTag set the customTag.
   */
  public void setCustomTag(String  customTag) {
    this.customTag = customTag;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return deploymentEnvironment
   */
  public String getDeploymentEnvironment() {
    return deploymentEnvironment;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param deploymentEnvironment set the deploymentEnvironment.
   */
  public void setDeploymentEnvironment(String  deploymentEnvironment) {
    this.deploymentEnvironment = deploymentEnvironment;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Email of the point of contact for a particular support case.
   * Field introduced in 20.1.1.
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * This is the setter method to the attribute.
   * Email of the point of contact for a particular support case.
   * Field introduced in 20.1.1.
   * @param email set the email.
   */
  public void setEmail(String  email) {
    this.email = email;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param environment set the environment.
   */
  public void setEnvironment(String  environment) {
    this.environment = environment;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Business justification for a feature request.
   * Field introduced in 20.1.1.
   * @return frBusinessJustification
   */
  public String getFrBusinessJustification() {
    return frBusinessJustification;
  }

  /**
   * This is the setter method to the attribute.
   * Business justification for a feature request.
   * Field introduced in 20.1.1.
   * @param frBusinessJustification set the frBusinessJustification.
   */
  public void setFrBusinessJustification(String  frBusinessJustification) {
    this.frBusinessJustification = frBusinessJustification;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current solution/workaround for a feature request.
   * Field introduced in 20.1.1.
   * @return frCurrentSolution
   */
  public String getFrCurrentSolution() {
    return frCurrentSolution;
  }

  /**
   * This is the setter method to the attribute.
   * Current solution/workaround for a feature request.
   * Field introduced in 20.1.1.
   * @param frCurrentSolution set the frCurrentSolution.
   */
  public void setFrCurrentSolution(String  frCurrentSolution) {
    this.frCurrentSolution = frCurrentSolution;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Expected date of delivery for a feature request in yyyy-mm-dd format.
   * Field introduced in 20.1.1.
   * @return frTiming
   */
  public String getFrTiming() {
    return frTiming;
  }

  /**
   * This is the setter method to the attribute.
   * Expected date of delivery for a feature request in yyyy-mm-dd format.
   * Field introduced in 20.1.1.
   * @param frTiming set the frTiming.
   */
  public void setFrTiming(String  frTiming) {
    this.frTiming = frTiming;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Possible use cases for a feature request.
   * Field introduced in 20.1.1.
   * @return frUseCases
   */
  public String getFrUseCases() {
    return frUseCases;
  }

  /**
   * This is the setter method to the attribute.
   * Possible use cases for a feature request.
   * Field introduced in 20.1.1.
   * @param frUseCases set the frUseCases.
   */
  public void setFrUseCases(String  frUseCases) {
    this.frUseCases = frUseCases;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return lastModifiedDate
   */
  public String getLastModifiedDate() {
    return lastModifiedDate;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param lastModifiedDate set the lastModifiedDate.
   */
  public void setLastModifiedDate(String  lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return patchVersion
   */
  public String getPatchVersion() {
    return patchVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param patchVersion set the patchVersion.
   */
  public void setPatchVersion(String  patchVersion) {
    this.patchVersion = patchVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return severity
   */
  public String getSeverity() {
    return severity;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param severity set the severity.
   */
  public void setSeverity(String  severity) {
    this.severity = severity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param subject set the subject.
   */
  public void setSubject(String  subject) {
    this.subject = subject;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return time
   */
  public String getTime() {
    return time;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param time set the time.
   */
  public void setTime(String  time) {
    this.time = time;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ALBServicesCase objALBServicesCase = (ALBServicesCase) o;
  return   Objects.equals(this.assetId, objALBServicesCase.assetId)&&
  Objects.equals(this.id, objALBServicesCase.id)&&
  Objects.equals(this.caseNumber, objALBServicesCase.caseNumber)&&
  Objects.equals(this.caseStatus, objALBServicesCase.caseStatus)&&
  Objects.equals(this.subject, objALBServicesCase.subject)&&
  Objects.equals(this.caseCreatedBy, objALBServicesCase.caseCreatedBy)&&
  Objects.equals(this.createdDate, objALBServicesCase.createdDate)&&
  Objects.equals(this.lastModifiedDate, objALBServicesCase.lastModifiedDate)&&
  Objects.equals(this.status, objALBServicesCase.status)&&
  Objects.equals(this.version, objALBServicesCase.version)&&
  Objects.equals(this.patchVersion, objALBServicesCase.patchVersion)&&
  Objects.equals(this.description, objALBServicesCase.description)&&
  Objects.equals(this.type, objALBServicesCase.type)&&
  Objects.equals(this.environment, objALBServicesCase.environment)&&
  Objects.equals(this.deploymentEnvironment, objALBServicesCase.deploymentEnvironment)&&
  Objects.equals(this.severity, objALBServicesCase.severity)&&
  Objects.equals(this.time, objALBServicesCase.time)&&
  Objects.equals(this.customTag, objALBServicesCase.customTag)&&
  Objects.equals(this.caseAttachments, objALBServicesCase.caseAttachments)&&
  Objects.equals(this.email, objALBServicesCase.email)&&
  Objects.equals(this.contactInfo, objALBServicesCase.contactInfo)&&
  Objects.equals(this.frUseCases, objALBServicesCase.frUseCases)&&
  Objects.equals(this.frCurrentSolution, objALBServicesCase.frCurrentSolution)&&
  Objects.equals(this.frBusinessJustification, objALBServicesCase.frBusinessJustification)&&
  Objects.equals(this.frTiming, objALBServicesCase.frTiming);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ALBServicesCase {\n");
      sb.append("    assetId: ").append(toIndentedString(assetId)).append("\n");
        sb.append("    caseAttachments: ").append(toIndentedString(caseAttachments)).append("\n");
        sb.append("    caseCreatedBy: ").append(toIndentedString(caseCreatedBy)).append("\n");
        sb.append("    caseNumber: ").append(toIndentedString(caseNumber)).append("\n");
        sb.append("    caseStatus: ").append(toIndentedString(caseStatus)).append("\n");
        sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
        sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
        sb.append("    customTag: ").append(toIndentedString(customTag)).append("\n");
        sb.append("    deploymentEnvironment: ").append(toIndentedString(deploymentEnvironment)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
        sb.append("    frBusinessJustification: ").append(toIndentedString(frBusinessJustification)).append("\n");
        sb.append("    frCurrentSolution: ").append(toIndentedString(frCurrentSolution)).append("\n");
        sb.append("    frTiming: ").append(toIndentedString(frTiming)).append("\n");
        sb.append("    frUseCases: ").append(toIndentedString(frUseCases)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");
        sb.append("    patchVersion: ").append(toIndentedString(patchVersion)).append("\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

