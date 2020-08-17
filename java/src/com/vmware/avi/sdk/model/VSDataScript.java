package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VSDataScript is a POJO class extends AviRestResource that used for creating
 * VSDataScript.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VSDataScript  {
    @JsonProperty("evt")
    private String evt = null;

    @JsonProperty("script")
    private String script = null;



  /**
   * This is the getter method this will return the attribute value.
   * Event triggering execution of datascript.
   * Enum options - VS_DATASCRIPT_EVT_HTTP_REQ, VS_DATASCRIPT_EVT_HTTP_RESP, VS_DATASCRIPT_EVT_HTTP_RESP_DATA, VS_DATASCRIPT_EVT_HTTP_LB_FAILED,
   * VS_DATASCRIPT_EVT_HTTP_REQ_DATA, VS_DATASCRIPT_EVT_HTTP_RESP_FAILED, VS_DATASCRIPT_EVT_HTTP_LB_DONE, VS_DATASCRIPT_EVT_TCP_CLIENT_ACCEPT,
   * VS_DATASCRIPT_EVT_SSL_HANDSHAKE_DONE, VS_DATASCRIPT_EVT_DNS_REQ, VS_DATASCRIPT_EVT_DNS_RESP, VS_DATASCRIPT_EVT_L4_REQUEST,
   * VS_DATASCRIPT_EVT_L4_RESPONSE, VS_DATASCRIPT_EVT_MAX.
   * @return evt
   */
  public String getEvt() {
    return evt;
  }

  /**
   * This is the setter method to the attribute.
   * Event triggering execution of datascript.
   * Enum options - VS_DATASCRIPT_EVT_HTTP_REQ, VS_DATASCRIPT_EVT_HTTP_RESP, VS_DATASCRIPT_EVT_HTTP_RESP_DATA, VS_DATASCRIPT_EVT_HTTP_LB_FAILED,
   * VS_DATASCRIPT_EVT_HTTP_REQ_DATA, VS_DATASCRIPT_EVT_HTTP_RESP_FAILED, VS_DATASCRIPT_EVT_HTTP_LB_DONE, VS_DATASCRIPT_EVT_TCP_CLIENT_ACCEPT,
   * VS_DATASCRIPT_EVT_SSL_HANDSHAKE_DONE, VS_DATASCRIPT_EVT_DNS_REQ, VS_DATASCRIPT_EVT_DNS_RESP, VS_DATASCRIPT_EVT_L4_REQUEST,
   * VS_DATASCRIPT_EVT_L4_RESPONSE, VS_DATASCRIPT_EVT_MAX.
   * @param evt set the evt.
   */
  public void setEvt(String  evt) {
    this.evt = evt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Datascript to execute when the event triggers.
   * @return script
   */
  public String getScript() {
    return script;
  }

  /**
   * This is the setter method to the attribute.
   * Datascript to execute when the event triggers.
   * @param script set the script.
   */
  public void setScript(String  script) {
    this.script = script;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VSDataScript objVSDataScript = (VSDataScript) o;
  return   Objects.equals(this.evt, objVSDataScript.evt)&&
  Objects.equals(this.script, objVSDataScript.script);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VSDataScript {\n");
      sb.append("    evt: ").append(toIndentedString(evt)).append("\n");
        sb.append("    script: ").append(toIndentedString(script)).append("\n");
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

