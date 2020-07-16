package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsResponse is a POJO class extends AviRestResource that used for creating
 * DnsResponse.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsResponse  {
    @JsonProperty("additional_records_count")
    private Integer additionalRecordsCount = null;

    @JsonProperty("answer_records_count")
    private Integer answerRecordsCount = null;

    @JsonProperty("authoritative_answer")
    private Boolean authoritativeAnswer = null;

    @JsonProperty("fallback_algorithm_used")
    private Boolean fallbackAlgorithmUsed = null;

    @JsonProperty("is_wildcard")
    private Boolean isWildcard = null;

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

    @JsonProperty("records")
    private List<DnsResourceRecord> records = null;

    @JsonProperty("recursion_available")
    private Boolean recursionAvailable = null;

    @JsonProperty("recursion_desired")
    private Boolean recursionDesired = null;

    @JsonProperty("response_code")
    private String responseCode = null;

    @JsonProperty("truncation")
    private Boolean truncation = null;



  /**
   * This is the getter method this will return the attribute value.
   * Number of additional records.
   * @return additionalRecordsCount
   */
  public Integer getAdditionalRecordsCount() {
    return additionalRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of additional records.
   * @param additionalRecordsCount set the additionalRecordsCount.
   */
  public void setAdditionalRecordsCount(Integer  additionalRecordsCount) {
    this.additionalRecordsCount = additionalRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of answer records.
   * @return answerRecordsCount
   */
  public Integer getAnswerRecordsCount() {
    return answerRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of answer records.
   * @param answerRecordsCount set the answerRecordsCount.
   */
  public void setAnswerRecordsCount(Integer  answerRecordsCount) {
    this.answerRecordsCount = answerRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to indicate the responding dns is an authority for the requested fqdn.
   * @return authoritativeAnswer
   */
  public Boolean getAuthoritativeAnswer() {
    return authoritativeAnswer;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to indicate the responding dns is an authority for the requested fqdn.
   * @param authoritativeAnswer set the authoritativeAnswer.
   */
  public void setAuthoritativeAnswer(Boolean  authoritativeAnswer) {
    this.authoritativeAnswer = authoritativeAnswer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to indicate whether fallback algorithm was used to serve this request.
   * Field introduced in 18.2.3.
   * @return fallbackAlgorithmUsed
   */
  public Boolean getFallbackAlgorithmUsed() {
    return fallbackAlgorithmUsed;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to indicate whether fallback algorithm was used to serve this request.
   * Field introduced in 18.2.3.
   * @param fallbackAlgorithmUsed set the fallbackAlgorithmUsed.
   */
  public void setFallbackAlgorithmUsed(Boolean  fallbackAlgorithmUsed) {
    this.fallbackAlgorithmUsed = fallbackAlgorithmUsed;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Resource records in the response are generated based on wildcard match.
   * Field introduced in 18.2.1.
   * @return isWildcard
   */
  public Boolean getIsWildcard() {
    return isWildcard;
  }

  /**
   * This is the setter method to the attribute.
   * Resource records in the response are generated based on wildcard match.
   * Field introduced in 18.2.1.
   * @param isWildcard set the isWildcard.
   */
  public void setIsWildcard(Boolean  isWildcard) {
    this.isWildcard = isWildcard;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of nameserver records.
   * @return nameserverRecordsCount
   */
  public Integer getNameserverRecordsCount() {
    return nameserverRecordsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of nameserver records.
   * @param nameserverRecordsCount set the nameserverRecordsCount.
   */
  public void setNameserverRecordsCount(Integer  nameserverRecordsCount) {
    this.nameserverRecordsCount = nameserverRecordsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns response operation code e.g.
   * Query, notify, etc.
   * Enum options - DNS_OPCODE_QUERY, DNS_OPCODE_IQUERY, DNS_OPCODE_STATUS, DNS_OPCODE_NOTIFY, DNS_OPCODE_UPDATE.
   * Field introduced in 17.1.3.
   * @return opcode
   */
  public String getOpcode() {
    return opcode;
  }

  /**
   * This is the setter method to the attribute.
   * Dns response operation code e.g.
   * Query, notify, etc.
   * Enum options - DNS_OPCODE_QUERY, DNS_OPCODE_IQUERY, DNS_OPCODE_STATUS, DNS_OPCODE_NOTIFY, DNS_OPCODE_UPDATE.
   * Field introduced in 17.1.3.
   * @param opcode set the opcode.
   */
  public void setOpcode(String  opcode) {
    this.opcode = opcode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Opt resource records in the response.
   * Field introduced in 17.1.1.
   * @return optRecord
   */
  public DnsOptRecord getOptRecord() {
    return optRecord;
  }

  /**
   * This is the setter method to the attribute.
   * Opt resource records in the response.
   * Field introduced in 17.1.1.
   * @param optRecord set the optRecord.
   */
  public void setOptRecord(DnsOptRecord optRecord) {
    this.optRecord = optRecord;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating response is a client query (false) or server response (true).
   * Field introduced in 17.1.3.
   * @return queryOrResponse
   */
  public Boolean getQueryOrResponse() {
    return queryOrResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating response is a client query (false) or server response (true).
   * Field introduced in 17.1.3.
   * @param queryOrResponse set the queryOrResponse.
   */
  public void setQueryOrResponse(Boolean  queryOrResponse) {
    this.queryOrResponse = queryOrResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of questions in the client dns request eliciting this dns response.
   * Field introduced in 17.1.3.
   * @return questionCount
   */
  public Integer getQuestionCount() {
    return questionCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of questions in the client dns request eliciting this dns response.
   * Field introduced in 17.1.3.
   * @param questionCount set the questionCount.
   */
  public void setQuestionCount(Integer  questionCount) {
    this.questionCount = questionCount;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Resource records in the response.
   * @return records
   */
  public List<DnsResourceRecord> getRecords() {
    return records;
  }

  /**
   * This is the setter method. this will set the records
   * Resource records in the response.
   * @return records
   */
  public void setRecords(List<DnsResourceRecord>  records) {
    this.records = records;
  }

  /**
   * This is the setter method this will set the records
   * Resource records in the response.
   * @return records
   */
  public DnsResponse addRecordsItem(DnsResourceRecord recordsItem) {
    if (this.records == null) {
      this.records = new ArrayList<DnsResourceRecord>();
    }
    this.records.add(recordsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating the dns query is fully answered.
   * @return recursionAvailable
   */
  public Boolean getRecursionAvailable() {
    return recursionAvailable;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating the dns query is fully answered.
   * @param recursionAvailable set the recursionAvailable.
   */
  public void setRecursionAvailable(Boolean  recursionAvailable) {
    this.recursionAvailable = recursionAvailable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag copied from the dns query's recursion desired field by the responding dns.
   * Field introduced in 17.1.3.
   * @return recursionDesired
   */
  public Boolean getRecursionDesired() {
    return recursionDesired;
  }

  /**
   * This is the setter method to the attribute.
   * Flag copied from the dns query's recursion desired field by the responding dns.
   * Field introduced in 17.1.3.
   * @param recursionDesired set the recursionDesired.
   */
  public void setRecursionDesired(Boolean  recursionDesired) {
    this.recursionDesired = recursionDesired;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Response code in the response.
   * Enum options - DNS_RCODE_NOERROR, DNS_RCODE_FORMERR, DNS_RCODE_SERVFAIL, DNS_RCODE_NXDOMAIN, DNS_RCODE_NOTIMP, DNS_RCODE_REFUSED,
   * DNS_RCODE_YXDOMAIN, DNS_RCODE_YXRRSET, DNS_RCODE_NXRRSET, DNS_RCODE_NOTAUTH, DNS_RCODE_NOTZONE.
   * @return responseCode
   */
  public String getResponseCode() {
    return responseCode;
  }

  /**
   * This is the setter method to the attribute.
   * Response code in the response.
   * Enum options - DNS_RCODE_NOERROR, DNS_RCODE_FORMERR, DNS_RCODE_SERVFAIL, DNS_RCODE_NXDOMAIN, DNS_RCODE_NOTIMP, DNS_RCODE_REFUSED,
   * DNS_RCODE_YXDOMAIN, DNS_RCODE_YXRRSET, DNS_RCODE_NXRRSET, DNS_RCODE_NOTAUTH, DNS_RCODE_NOTZONE.
   * @param responseCode set the responseCode.
   */
  public void setResponseCode(String  responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to indicate if the answer received from dns is truncated (original answer exceeds 512 bytes udp limit).
   * @return truncation
   */
  public Boolean getTruncation() {
    return truncation;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to indicate if the answer received from dns is truncated (original answer exceeds 512 bytes udp limit).
   * @param truncation set the truncation.
   */
  public void setTruncation(Boolean  truncation) {
    this.truncation = truncation;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsResponse objDnsResponse = (DnsResponse) o;
  return   Objects.equals(this.recursionAvailable, objDnsResponse.recursionAvailable)&&
  Objects.equals(this.isWildcard, objDnsResponse.isWildcard)&&
  Objects.equals(this.records, objDnsResponse.records)&&
  Objects.equals(this.responseCode, objDnsResponse.responseCode)&&
  Objects.equals(this.optRecord, objDnsResponse.optRecord)&&
  Objects.equals(this.fallbackAlgorithmUsed, objDnsResponse.fallbackAlgorithmUsed)&&
  Objects.equals(this.answerRecordsCount, objDnsResponse.answerRecordsCount)&&
  Objects.equals(this.opcode, objDnsResponse.opcode)&&
  Objects.equals(this.questionCount, objDnsResponse.questionCount)&&
  Objects.equals(this.nameserverRecordsCount, objDnsResponse.nameserverRecordsCount)&&
  Objects.equals(this.authoritativeAnswer, objDnsResponse.authoritativeAnswer)&&
  Objects.equals(this.queryOrResponse, objDnsResponse.queryOrResponse)&&
  Objects.equals(this.additionalRecordsCount, objDnsResponse.additionalRecordsCount)&&
  Objects.equals(this.recursionDesired, objDnsResponse.recursionDesired)&&
  Objects.equals(this.truncation, objDnsResponse.truncation);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsResponse {\n");
      sb.append("    additionalRecordsCount: ").append(toIndentedString(additionalRecordsCount)).append("\n");
        sb.append("    answerRecordsCount: ").append(toIndentedString(answerRecordsCount)).append("\n");
        sb.append("    authoritativeAnswer: ").append(toIndentedString(authoritativeAnswer)).append("\n");
        sb.append("    fallbackAlgorithmUsed: ").append(toIndentedString(fallbackAlgorithmUsed)).append("\n");
        sb.append("    isWildcard: ").append(toIndentedString(isWildcard)).append("\n");
        sb.append("    nameserverRecordsCount: ").append(toIndentedString(nameserverRecordsCount)).append("\n");
        sb.append("    opcode: ").append(toIndentedString(opcode)).append("\n");
        sb.append("    optRecord: ").append(toIndentedString(optRecord)).append("\n");
        sb.append("    queryOrResponse: ").append(toIndentedString(queryOrResponse)).append("\n");
        sb.append("    questionCount: ").append(toIndentedString(questionCount)).append("\n");
        sb.append("    records: ").append(toIndentedString(records)).append("\n");
        sb.append("    recursionAvailable: ").append(toIndentedString(recursionAvailable)).append("\n");
        sb.append("    recursionDesired: ").append(toIndentedString(recursionDesired)).append("\n");
        sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
        sb.append("    truncation: ").append(toIndentedString(truncation)).append("\n");
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

