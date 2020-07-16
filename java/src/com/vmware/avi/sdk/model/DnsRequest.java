package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRequest is a POJO class extends AviRestResource that used for creating
 * DnsRequest.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRequest  {
    @JsonProperty("additional_records_count")
    private Integer additionalRecordsCount = null;

    @JsonProperty("answer_records_count")
    private Integer answerRecordsCount = null;

    @JsonProperty("authentic_data")
    private Boolean authenticData = null;

    @JsonProperty("checking_disabled")
    private Boolean checkingDisabled = null;

    @JsonProperty("client_location")
    private GeoLocation clientLocation = null;

    @JsonProperty("identifier")
    private Integer identifier = null;

    @JsonProperty("nameserver_records_count")
    private Integer nameserverRecordsCount = null;

    @JsonProperty("opcode")
    private String opcode = null;

    @JsonProperty("opt_record")
    private DnsOptRecord optRecord = null;

    @JsonProperty("query_or_response")
    private Boolean queryOrResponse = null;

    @JsonProperty("question_count")
    private Integer questionCount = null;

    @JsonProperty("recursion_desired")
    private Boolean recursionDesired = null;



  /**
   * This is the getter method this will return the attribute value.
   * Number of additional records.
   * Field introduced in 17.1.1.
   * @return additionalRecordsCount
   */
  public Integer getAdditionalRecordsCount() {
    return additionalRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of additional records.
   * Field introduced in 17.1.1.
   * @param additionalRecordsCount set the additionalRecordsCount.
   */
  public void setAdditionalRecordsCount(Integer  additionalRecordsCount) {
    this.additionalRecordsCount = additionalRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of answer records in the client dns request.
   * Field introduced in 17.1.1.
   * @return answerRecordsCount
   */
  public Integer getAnswerRecordsCount() {
    return answerRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of answer records in the client dns request.
   * Field introduced in 17.1.1.
   * @param answerRecordsCount set the answerRecordsCount.
   */
  public void setAnswerRecordsCount(Integer  answerRecordsCount) {
    this.answerRecordsCount = answerRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating client understands ad bit and is interested in the value of ad bit in the response.
   * Field introduced in 17.1.1.
   * @return authenticData
   */
  public Boolean getAuthenticData() {
    return authenticData;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating client understands ad bit and is interested in the value of ad bit in the response.
   * Field introduced in 17.1.1.
   * @param authenticData set the authenticData.
   */
  public void setAuthenticData(Boolean  authenticData) {
    this.authenticData = authenticData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating client does not want dnssec validation of the response.
   * Field introduced in 17.1.1.
   * @return checkingDisabled
   */
  public Boolean getCheckingDisabled() {
    return checkingDisabled;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating client does not want dnssec validation of the response.
   * Field introduced in 17.1.1.
   * @param checkingDisabled set the checkingDisabled.
   */
  public void setCheckingDisabled(Boolean  checkingDisabled) {
    this.checkingDisabled = checkingDisabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Geo location of client.
   * Field introduced in 17.1.1.
   * @return clientLocation
   */
  public GeoLocation getClientLocation() {
    return clientLocation;
  }

  /**
   * This is the setter method to the attribute.
   * Geo location of client.
   * Field introduced in 17.1.1.
   * @param clientLocation set the clientLocation.
   */
  public void setClientLocation(GeoLocation clientLocation) {
    this.clientLocation = clientLocation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the dns request.
   * Field introduced in 17.1.1.
   * @return identifier
   */
  public Integer getIdentifier() {
    return identifier;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the dns request.
   * Field introduced in 17.1.1.
   * @param identifier set the identifier.
   */
  public void setIdentifier(Integer  identifier) {
    this.identifier = identifier;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of nameserver records in the client dns request.
   * Field introduced in 17.1.1.
   * @return nameserverRecordsCount
   */
  public Integer getNameserverRecordsCount() {
    return nameserverRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of nameserver records in the client dns request.
   * Field introduced in 17.1.1.
   * @param nameserverRecordsCount set the nameserverRecordsCount.
   */
  public void setNameserverRecordsCount(Integer  nameserverRecordsCount) {
    this.nameserverRecordsCount = nameserverRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns request operation code e.g.
   * Query, notify, etc.
   * Enum options - DNS_OPCODE_QUERY, DNS_OPCODE_IQUERY, DNS_OPCODE_STATUS, DNS_OPCODE_NOTIFY, DNS_OPCODE_UPDATE.
   * Field introduced in 17.1.1.
   * @return opcode
   */
  public String getOpcode() {
    return opcode;
  }

  /**
   * This is the setter method to the attribute.
   * Dns request operation code e.g.
   * Query, notify, etc.
   * Enum options - DNS_OPCODE_QUERY, DNS_OPCODE_IQUERY, DNS_OPCODE_STATUS, DNS_OPCODE_NOTIFY, DNS_OPCODE_UPDATE.
   * Field introduced in 17.1.1.
   * @param opcode set the opcode.
   */
  public void setOpcode(String  opcode) {
    this.opcode = opcode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Opt resource records in the request.
   * Field introduced in 17.1.1.
   * @return optRecord
   */
  public DnsOptRecord getOptRecord() {
    return optRecord;
  }

  /**
   * This is the setter method to the attribute.
   * Opt resource records in the request.
   * Field introduced in 17.1.1.
   * @param optRecord set the optRecord.
   */
  public void setOptRecord(DnsOptRecord optRecord) {
    this.optRecord = optRecord;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating request is a client query (false) or server response (true).
   * Field introduced in 17.1.1.
   * @return queryOrResponse
   */
  public Boolean getQueryOrResponse() {
    return queryOrResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating request is a client query (false) or server response (true).
   * Field introduced in 17.1.1.
   * @param queryOrResponse set the queryOrResponse.
   */
  public void setQueryOrResponse(Boolean  queryOrResponse) {
    this.queryOrResponse = queryOrResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of questions in the client dns request.
   * Field introduced in 17.1.1.
   * @return questionCount
   */
  public Integer getQuestionCount() {
    return questionCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of questions in the client dns request.
   * Field introduced in 17.1.1.
   * @param questionCount set the questionCount.
   */
  public void setQuestionCount(Integer  questionCount) {
    this.questionCount = questionCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating client request for recursive resolution.
   * Field introduced in 17.1.1.
   * @return recursionDesired
   */
  public Boolean getRecursionDesired() {
    return recursionDesired;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating client request for recursive resolution.
   * Field introduced in 17.1.1.
   * @param recursionDesired set the recursionDesired.
   */
  public void setRecursionDesired(Boolean  recursionDesired) {
    this.recursionDesired = recursionDesired;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRequest objDnsRequest = (DnsRequest) o;
  return   Objects.equals(this.identifier, objDnsRequest.identifier)&&
  Objects.equals(this.optRecord, objDnsRequest.optRecord)&&
  Objects.equals(this.checkingDisabled, objDnsRequest.checkingDisabled)&&
  Objects.equals(this.answerRecordsCount, objDnsRequest.answerRecordsCount)&&
  Objects.equals(this.clientLocation, objDnsRequest.clientLocation)&&
  Objects.equals(this.opcode, objDnsRequest.opcode)&&
  Objects.equals(this.recursionDesired, objDnsRequest.recursionDesired)&&
  Objects.equals(this.authenticData, objDnsRequest.authenticData)&&
  Objects.equals(this.nameserverRecordsCount, objDnsRequest.nameserverRecordsCount)&&
  Objects.equals(this.queryOrResponse, objDnsRequest.queryOrResponse)&&
  Objects.equals(this.additionalRecordsCount, objDnsRequest.additionalRecordsCount)&&
  Objects.equals(this.questionCount, objDnsRequest.questionCount);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRequest {\n");
      sb.append("    additionalRecordsCount: ").append(toIndentedString(additionalRecordsCount)).append("\n");
        sb.append("    answerRecordsCount: ").append(toIndentedString(answerRecordsCount)).append("\n");
        sb.append("    authenticData: ").append(toIndentedString(authenticData)).append("\n");
        sb.append("    checkingDisabled: ").append(toIndentedString(checkingDisabled)).append("\n");
        sb.append("    clientLocation: ").append(toIndentedString(clientLocation)).append("\n");
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
        sb.append("    nameserverRecordsCount: ").append(toIndentedString(nameserverRecordsCount)).append("\n");
        sb.append("    opcode: ").append(toIndentedString(opcode)).append("\n");
        sb.append("    optRecord: ").append(toIndentedString(optRecord)).append("\n");
        sb.append("    queryOrResponse: ").append(toIndentedString(queryOrResponse)).append("\n");
        sb.append("    questionCount: ").append(toIndentedString(questionCount)).append("\n");
        sb.append("    recursionDesired: ").append(toIndentedString(recursionDesired)).append("\n");
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

