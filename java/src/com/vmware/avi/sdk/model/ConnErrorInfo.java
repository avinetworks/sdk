package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConnErrorInfo is a POJO class extends AviRestResource that used for creating
 * ConnErrorInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnErrorInfo  {
    @JsonProperty("num_syn_retransmit")
    private Integer numSynRetransmit = null;

    @JsonProperty("num_window_shrink")
    private Integer numWindowShrink = null;

    @JsonProperty("out_of_orders")
    private Integer outOfOrders = null;

    @JsonProperty("retransmits")
    private Integer retransmits = null;

    @JsonProperty("rx_pkts")
    private Integer rxPkts = null;

    @JsonProperty("server_num_window_shrink")
    private Integer serverNumWindowShrink = null;

    @JsonProperty("server_out_of_orders")
    private Integer serverOutOfOrders = null;

    @JsonProperty("server_retransmits")
    private Integer serverRetransmits = null;

    @JsonProperty("server_rx_pkts")
    private Integer serverRxPkts = null;

    @JsonProperty("server_timeouts")
    private Integer serverTimeouts = null;

    @JsonProperty("server_tx_pkts")
    private Integer serverTxPkts = null;

    @JsonProperty("server_zero_window_size_events")
    private Integer serverZeroWindowSizeEvents = null;

    @JsonProperty("timeouts")
    private Integer timeouts = null;

    @JsonProperty("tx_pkts")
    private Integer txPkts = null;

    @JsonProperty("zero_window_size_events")
    private Integer zeroWindowSizeEvents = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_syn_retransmit of obj type connerrorinfo field type str  type integer.
   * @return numSynRetransmit
   */
  public Integer getNumSynRetransmit() {
    return numSynRetransmit;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_syn_retransmit of obj type connerrorinfo field type str  type integer.
   * @param numSynRetransmit set the numSynRetransmit.
   */
  public void setNumSynRetransmit(Integer  numSynRetransmit) {
    this.numSynRetransmit = numSynRetransmit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_window_shrink of obj type connerrorinfo field type str  type integer.
   * @return numWindowShrink
   */
  public Integer getNumWindowShrink() {
    return numWindowShrink;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_window_shrink of obj type connerrorinfo field type str  type integer.
   * @param numWindowShrink set the numWindowShrink.
   */
  public void setNumWindowShrink(Integer  numWindowShrink) {
    this.numWindowShrink = numWindowShrink;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property out_of_orders of obj type connerrorinfo field type str  type integer.
   * @return outOfOrders
   */
  public Integer getOutOfOrders() {
    return outOfOrders;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property out_of_orders of obj type connerrorinfo field type str  type integer.
   * @param outOfOrders set the outOfOrders.
   */
  public void setOutOfOrders(Integer  outOfOrders) {
    this.outOfOrders = outOfOrders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property retransmits of obj type connerrorinfo field type str  type integer.
   * @return retransmits
   */
  public Integer getRetransmits() {
    return retransmits;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property retransmits of obj type connerrorinfo field type str  type integer.
   * @param retransmits set the retransmits.
   */
  public void setRetransmits(Integer  retransmits) {
    this.retransmits = retransmits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rx_pkts of obj type connerrorinfo field type str  type integer.
   * @return rxPkts
   */
  public Integer getRxPkts() {
    return rxPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rx_pkts of obj type connerrorinfo field type str  type integer.
   * @param rxPkts set the rxPkts.
   */
  public void setRxPkts(Integer  rxPkts) {
    this.rxPkts = rxPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_num_window_shrink of obj type connerrorinfo field type str  type integer.
   * @return serverNumWindowShrink
   */
  public Integer getServerNumWindowShrink() {
    return serverNumWindowShrink;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_num_window_shrink of obj type connerrorinfo field type str  type integer.
   * @param serverNumWindowShrink set the serverNumWindowShrink.
   */
  public void setServerNumWindowShrink(Integer  serverNumWindowShrink) {
    this.serverNumWindowShrink = serverNumWindowShrink;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_out_of_orders of obj type connerrorinfo field type str  type integer.
   * @return serverOutOfOrders
   */
  public Integer getServerOutOfOrders() {
    return serverOutOfOrders;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_out_of_orders of obj type connerrorinfo field type str  type integer.
   * @param serverOutOfOrders set the serverOutOfOrders.
   */
  public void setServerOutOfOrders(Integer  serverOutOfOrders) {
    this.serverOutOfOrders = serverOutOfOrders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_retransmits of obj type connerrorinfo field type str  type integer.
   * @return serverRetransmits
   */
  public Integer getServerRetransmits() {
    return serverRetransmits;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_retransmits of obj type connerrorinfo field type str  type integer.
   * @param serverRetransmits set the serverRetransmits.
   */
  public void setServerRetransmits(Integer  serverRetransmits) {
    this.serverRetransmits = serverRetransmits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_rx_pkts of obj type connerrorinfo field type str  type integer.
   * @return serverRxPkts
   */
  public Integer getServerRxPkts() {
    return serverRxPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_rx_pkts of obj type connerrorinfo field type str  type integer.
   * @param serverRxPkts set the serverRxPkts.
   */
  public void setServerRxPkts(Integer  serverRxPkts) {
    this.serverRxPkts = serverRxPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_timeouts of obj type connerrorinfo field type str  type integer.
   * @return serverTimeouts
   */
  public Integer getServerTimeouts() {
    return serverTimeouts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_timeouts of obj type connerrorinfo field type str  type integer.
   * @param serverTimeouts set the serverTimeouts.
   */
  public void setServerTimeouts(Integer  serverTimeouts) {
    this.serverTimeouts = serverTimeouts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_tx_pkts of obj type connerrorinfo field type str  type integer.
   * @return serverTxPkts
   */
  public Integer getServerTxPkts() {
    return serverTxPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_tx_pkts of obj type connerrorinfo field type str  type integer.
   * @param serverTxPkts set the serverTxPkts.
   */
  public void setServerTxPkts(Integer  serverTxPkts) {
    this.serverTxPkts = serverTxPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_zero_window_size_events of obj type connerrorinfo field type str  type integer.
   * @return serverZeroWindowSizeEvents
   */
  public Integer getServerZeroWindowSizeEvents() {
    return serverZeroWindowSizeEvents;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_zero_window_size_events of obj type connerrorinfo field type str  type integer.
   * @param serverZeroWindowSizeEvents set the serverZeroWindowSizeEvents.
   */
  public void setServerZeroWindowSizeEvents(Integer  serverZeroWindowSizeEvents) {
    this.serverZeroWindowSizeEvents = serverZeroWindowSizeEvents;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property timeouts of obj type connerrorinfo field type str  type integer.
   * @return timeouts
   */
  public Integer getTimeouts() {
    return timeouts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property timeouts of obj type connerrorinfo field type str  type integer.
   * @param timeouts set the timeouts.
   */
  public void setTimeouts(Integer  timeouts) {
    this.timeouts = timeouts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tx_pkts of obj type connerrorinfo field type str  type integer.
   * @return txPkts
   */
  public Integer getTxPkts() {
    return txPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tx_pkts of obj type connerrorinfo field type str  type integer.
   * @param txPkts set the txPkts.
   */
  public void setTxPkts(Integer  txPkts) {
    this.txPkts = txPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property zero_window_size_events of obj type connerrorinfo field type str  type integer.
   * @return zeroWindowSizeEvents
   */
  public Integer getZeroWindowSizeEvents() {
    return zeroWindowSizeEvents;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property zero_window_size_events of obj type connerrorinfo field type str  type integer.
   * @param zeroWindowSizeEvents set the zeroWindowSizeEvents.
   */
  public void setZeroWindowSizeEvents(Integer  zeroWindowSizeEvents) {
    this.zeroWindowSizeEvents = zeroWindowSizeEvents;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConnErrorInfo objConnErrorInfo = (ConnErrorInfo) o;
  return   Objects.equals(this.serverRetransmits, objConnErrorInfo.serverRetransmits)&&
  Objects.equals(this.numSynRetransmit, objConnErrorInfo.numSynRetransmit)&&
  Objects.equals(this.rxPkts, objConnErrorInfo.rxPkts)&&
  Objects.equals(this.serverZeroWindowSizeEvents, objConnErrorInfo.serverZeroWindowSizeEvents)&&
  Objects.equals(this.timeouts, objConnErrorInfo.timeouts)&&
  Objects.equals(this.serverNumWindowShrink, objConnErrorInfo.serverNumWindowShrink)&&
  Objects.equals(this.zeroWindowSizeEvents, objConnErrorInfo.zeroWindowSizeEvents)&&
  Objects.equals(this.numWindowShrink, objConnErrorInfo.numWindowShrink)&&
  Objects.equals(this.serverTxPkts, objConnErrorInfo.serverTxPkts)&&
  Objects.equals(this.serverOutOfOrders, objConnErrorInfo.serverOutOfOrders)&&
  Objects.equals(this.serverRxPkts, objConnErrorInfo.serverRxPkts)&&
  Objects.equals(this.retransmits, objConnErrorInfo.retransmits)&&
  Objects.equals(this.txPkts, objConnErrorInfo.txPkts)&&
  Objects.equals(this.serverTimeouts, objConnErrorInfo.serverTimeouts)&&
  Objects.equals(this.outOfOrders, objConnErrorInfo.outOfOrders);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConnErrorInfo {\n");
      sb.append("    numSynRetransmit: ").append(toIndentedString(numSynRetransmit)).append("\n");
        sb.append("    numWindowShrink: ").append(toIndentedString(numWindowShrink)).append("\n");
        sb.append("    outOfOrders: ").append(toIndentedString(outOfOrders)).append("\n");
        sb.append("    retransmits: ").append(toIndentedString(retransmits)).append("\n");
        sb.append("    rxPkts: ").append(toIndentedString(rxPkts)).append("\n");
        sb.append("    serverNumWindowShrink: ").append(toIndentedString(serverNumWindowShrink)).append("\n");
        sb.append("    serverOutOfOrders: ").append(toIndentedString(serverOutOfOrders)).append("\n");
        sb.append("    serverRetransmits: ").append(toIndentedString(serverRetransmits)).append("\n");
        sb.append("    serverRxPkts: ").append(toIndentedString(serverRxPkts)).append("\n");
        sb.append("    serverTimeouts: ").append(toIndentedString(serverTimeouts)).append("\n");
        sb.append("    serverTxPkts: ").append(toIndentedString(serverTxPkts)).append("\n");
        sb.append("    serverZeroWindowSizeEvents: ").append(toIndentedString(serverZeroWindowSizeEvents)).append("\n");
        sb.append("    timeouts: ").append(toIndentedString(timeouts)).append("\n");
        sb.append("    txPkts: ").append(toIndentedString(txPkts)).append("\n");
        sb.append("    zeroWindowSizeEvents: ").append(toIndentedString(zeroWindowSizeEvents)).append("\n");
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

