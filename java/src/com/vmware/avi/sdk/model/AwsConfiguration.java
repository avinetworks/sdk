package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AwsConfiguration is a POJO class extends AviRestResource that used for creating
 * AwsConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwsConfiguration  {
    @JsonProperty("access_key_id")
    private String accessKeyId = null;

    @JsonProperty("asg_poll_interval")
    private Integer asgPollInterval = 600;

    @JsonProperty("ebs_encryption")
    private AwsEncryption ebsEncryption = null;

    @JsonProperty("free_elasticips")
    private Boolean freeElasticips = true;

    @JsonProperty("iam_assume_role")
    private String iamAssumeRole = null;

    @JsonProperty("publish_vip_to_public_zone")
    private Boolean publishVipToPublicZone = false;

    @JsonProperty("region")
    private String region = "us-west-1";

    @JsonProperty("route53_integration")
    private Boolean route53Integration = false;

    @JsonProperty("s3_encryption")
    private AwsEncryption s3Encryption = null;

    @JsonProperty("secret_access_key")
    private String secretAccessKey = null;

    @JsonProperty("sqs_encryption")
    private AwsEncryption sqsEncryption = null;

    @JsonProperty("ttl")
    private Integer ttl = 60;

    @JsonProperty("use_iam_roles")
    private Boolean useIamRoles = false;

    @JsonProperty("use_sns_sqs")
    private Boolean useSnsSqs = false;

    @JsonProperty("vpc")
    private String vpc = null;

    @JsonProperty("vpc_id")
    private String vpcId = null;

    @JsonProperty("wildcard_access")
    private Boolean wildcardAccess = null;

    @JsonProperty("zones")
    private List<AwsZoneConfig> zones = null;



  /**
   * This is the getter method this will return the attribute value.
   * Aws access key id.
   * @return accessKeyId
   */
  public String getAccessKeyId() {
    return accessKeyId;
  }

  /**
   * This is the setter method to the attribute.
   * Aws access key id.
   * @param accessKeyId set the accessKeyId.
   */
  public void setAccessKeyId(String  accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time interval between periodic polling of all auto scaling groups.
   * Allowed values are 60-1800.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return asgPollInterval
   */
  public Integer getAsgPollInterval() {
    return asgPollInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Time interval between periodic polling of all auto scaling groups.
   * Allowed values are 60-1800.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param asgPollInterval set the asgPollInterval.
   */
  public void setAsgPollInterval(Integer  asgPollInterval) {
    this.asgPollInterval = asgPollInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ebs encryption mode and the master key to be used for encrypting se ami, volumes, and snapshots.
   * Field introduced in 17.2.3.
   * @return ebsEncryption
   */
  public AwsEncryption getEbsEncryption() {
    return ebsEncryption;
  }

  /**
   * This is the setter method to the attribute.
   * Ebs encryption mode and the master key to be used for encrypting se ami, volumes, and snapshots.
   * Field introduced in 17.2.3.
   * @param ebsEncryption set the ebsEncryption.
   */
  public void setEbsEncryption(AwsEncryption ebsEncryption) {
    this.ebsEncryption = ebsEncryption;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Free unused elastic ip addresses.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return freeElasticips
   */
  public Boolean getFreeElasticips() {
    return freeElasticips;
  }

  /**
   * This is the setter method to the attribute.
   * Free unused elastic ip addresses.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param freeElasticips set the freeElasticips.
   */
  public void setFreeElasticips(Boolean  freeElasticips) {
    this.freeElasticips = freeElasticips;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Iam assume role for cross-account access.
   * @return iamAssumeRole
   */
  public String getIamAssumeRole() {
    return iamAssumeRole;
  }

  /**
   * This is the setter method to the attribute.
   * Iam assume role for cross-account access.
   * @param iamAssumeRole set the iamAssumeRole.
   */
  public void setIamAssumeRole(String  iamAssumeRole) {
    this.iamAssumeRole = iamAssumeRole;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If enabled and the virtual service is not floating ip capable, vip will be published to both private and public zones.
   * Field introduced in 17.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return publishVipToPublicZone
   */
  public Boolean getPublishVipToPublicZone() {
    return publishVipToPublicZone;
  }

  /**
   * This is the setter method to the attribute.
   * If enabled and the virtual service is not floating ip capable, vip will be published to both private and public zones.
   * Field introduced in 17.2.10.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param publishVipToPublicZone set the publishVipToPublicZone.
   */
  public void setPublishVipToPublicZone(Boolean  publishVipToPublicZone) {
    this.publishVipToPublicZone = publishVipToPublicZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Aws region.
   * Default value when not specified in API or module is interpreted by Avi Controller as us-west-1.
   * @return region
   */
  public String getRegion() {
    return region;
  }

  /**
   * This is the setter method to the attribute.
   * Aws region.
   * Default value when not specified in API or module is interpreted by Avi Controller as us-west-1.
   * @param region set the region.
   */
  public void setRegion(String  region) {
    this.region = region;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If enabled, create/update dns entries in amazon route 53 zones.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return route53Integration
   */
  public Boolean getRoute53Integration() {
    return route53Integration;
  }

  /**
   * This is the setter method to the attribute.
   * If enabled, create/update dns entries in amazon route 53 zones.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param route53Integration set the route53Integration.
   */
  public void setRoute53Integration(Boolean  route53Integration) {
    this.route53Integration = route53Integration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * S3 encryption mode and the master key to be used for encrypting s3 buckets during se ami upload.
   * Only sse-kms mode is supported.
   * Field introduced in 17.2.3.
   * @return s3Encryption
   */
  public AwsEncryption getS3Encryption() {
    return s3Encryption;
  }

  /**
   * This is the setter method to the attribute.
   * S3 encryption mode and the master key to be used for encrypting s3 buckets during se ami upload.
   * Only sse-kms mode is supported.
   * Field introduced in 17.2.3.
   * @param s3Encryption set the s3Encryption.
   */
  public void setS3Encryption(AwsEncryption s3Encryption) {
    this.s3Encryption = s3Encryption;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Aws secret access key.
   * @return secretAccessKey
   */
  public String getSecretAccessKey() {
    return secretAccessKey;
  }

  /**
   * This is the setter method to the attribute.
   * Aws secret access key.
   * @param secretAccessKey set the secretAccessKey.
   */
  public void setSecretAccessKey(String  secretAccessKey) {
    this.secretAccessKey = secretAccessKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server side encryption to be used for encrypting sqs queues.
   * Field introduced in 17.2.8.
   * @return sqsEncryption
   */
  public AwsEncryption getSqsEncryption() {
    return sqsEncryption;
  }

  /**
   * This is the setter method to the attribute.
   * Server side encryption to be used for encrypting sqs queues.
   * Field introduced in 17.2.8.
   * @param sqsEncryption set the sqsEncryption.
   */
  public void setSqsEncryption(AwsEncryption sqsEncryption) {
    this.sqsEncryption = sqsEncryption;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default ttl for all records.
   * Allowed values are 1-172800.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Default ttl for all records.
   * Allowed values are 1-172800.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use iam roles instead of access and secret key.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useIamRoles
   */
  public Boolean getUseIamRoles() {
    return useIamRoles;
  }

  /**
   * This is the setter method to the attribute.
   * Use iam roles instead of access and secret key.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useIamRoles set the useIamRoles.
   */
  public void setUseIamRoles(Boolean  useIamRoles) {
    this.useIamRoles = useIamRoles;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use sns/sqs based notifications for monitoring auto scaling groups.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useSnsSqs
   */
  public Boolean getUseSnsSqs() {
    return useSnsSqs;
  }

  /**
   * This is the setter method to the attribute.
   * Use sns/sqs based notifications for monitoring auto scaling groups.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useSnsSqs set the useSnsSqs.
   */
  public void setUseSnsSqs(Boolean  useSnsSqs) {
    this.useSnsSqs = useSnsSqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vpc name.
   * @return vpc
   */
  public String getVpc() {
    return vpc;
  }

  /**
   * This is the setter method to the attribute.
   * Vpc name.
   * @param vpc set the vpc.
   */
  public void setVpc(String  vpc) {
    this.vpc = vpc;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vpc id.
   * @return vpcId
   */
  public String getVpcId() {
    return vpcId;
  }

  /**
   * This is the setter method to the attribute.
   * Vpc id.
   * @param vpcId set the vpcId.
   */
  public void setVpcId(String  vpcId) {
    this.vpcId = vpcId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If enabled, program se security group with ingress rule to allow ssh (port 22) access from 0.0.0.0/0.
   * Field deprecated in 17.1.5.
   * Field introduced in 17.1.3.
   * @return wildcardAccess
   */
  public Boolean getWildcardAccess() {
    return wildcardAccess;
  }

  /**
   * This is the setter method to the attribute.
   * If enabled, program se security group with ingress rule to allow ssh (port 22) access from 0.0.0.0/0.
   * Field deprecated in 17.1.5.
   * Field introduced in 17.1.3.
   * @param wildcardAccess set the wildcardAccess.
   */
  public void setWildcardAccess(Boolean  wildcardAccess) {
    this.wildcardAccess = wildcardAccess;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property zones of obj type awsconfiguration field type str  type array.
   * @return zones
   */
  public List<AwsZoneConfig> getZones() {
    return zones;
  }

  /**
   * This is the setter method. this will set the zones
   * Placeholder for description of property zones of obj type awsconfiguration field type str  type array.
   * @return zones
   */
  public void setZones(List<AwsZoneConfig>  zones) {
    this.zones = zones;
  }

  /**
   * This is the setter method this will set the zones
   * Placeholder for description of property zones of obj type awsconfiguration field type str  type array.
   * @return zones
   */
  public AwsConfiguration addZonesItem(AwsZoneConfig zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<AwsZoneConfig>();
    }
    this.zones.add(zonesItem);
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
  AwsConfiguration objAwsConfiguration = (AwsConfiguration) o;
  return   Objects.equals(this.useIamRoles, objAwsConfiguration.useIamRoles)&&
  Objects.equals(this.wildcardAccess, objAwsConfiguration.wildcardAccess)&&
  Objects.equals(this.sqsEncryption, objAwsConfiguration.sqsEncryption)&&
  Objects.equals(this.publishVipToPublicZone, objAwsConfiguration.publishVipToPublicZone)&&
  Objects.equals(this.s3Encryption, objAwsConfiguration.s3Encryption)&&
  Objects.equals(this.ebsEncryption, objAwsConfiguration.ebsEncryption)&&
  Objects.equals(this.route53Integration, objAwsConfiguration.route53Integration)&&
  Objects.equals(this.ttl, objAwsConfiguration.ttl)&&
  Objects.equals(this.region, objAwsConfiguration.region)&&
  Objects.equals(this.freeElasticips, objAwsConfiguration.freeElasticips)&&
  Objects.equals(this.secretAccessKey, objAwsConfiguration.secretAccessKey)&&
  Objects.equals(this.zones, objAwsConfiguration.zones)&&
  Objects.equals(this.asgPollInterval, objAwsConfiguration.asgPollInterval)&&
  Objects.equals(this.useSnsSqs, objAwsConfiguration.useSnsSqs)&&
  Objects.equals(this.vpc, objAwsConfiguration.vpc)&&
  Objects.equals(this.accessKeyId, objAwsConfiguration.accessKeyId)&&
  Objects.equals(this.iamAssumeRole, objAwsConfiguration.iamAssumeRole)&&
  Objects.equals(this.vpcId, objAwsConfiguration.vpcId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AwsConfiguration {\n");
      sb.append("    accessKeyId: ").append(toIndentedString(accessKeyId)).append("\n");
        sb.append("    asgPollInterval: ").append(toIndentedString(asgPollInterval)).append("\n");
        sb.append("    ebsEncryption: ").append(toIndentedString(ebsEncryption)).append("\n");
        sb.append("    freeElasticips: ").append(toIndentedString(freeElasticips)).append("\n");
        sb.append("    iamAssumeRole: ").append(toIndentedString(iamAssumeRole)).append("\n");
        sb.append("    publishVipToPublicZone: ").append(toIndentedString(publishVipToPublicZone)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    route53Integration: ").append(toIndentedString(route53Integration)).append("\n");
        sb.append("    s3Encryption: ").append(toIndentedString(s3Encryption)).append("\n");
        sb.append("    secretAccessKey: ").append(toIndentedString(secretAccessKey)).append("\n");
        sb.append("    sqsEncryption: ").append(toIndentedString(sqsEncryption)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    useIamRoles: ").append(toIndentedString(useIamRoles)).append("\n");
        sb.append("    useSnsSqs: ").append(toIndentedString(useSnsSqs)).append("\n");
        sb.append("    vpc: ").append(toIndentedString(vpc)).append("\n");
        sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
        sb.append("    wildcardAccess: ").append(toIndentedString(wildcardAccess)).append("\n");
        sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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

