package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The JWTClaimMatch is a POJO class extends AviRestResource that used for creating
 * JWTClaimMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTClaimMatch  {
    @JsonProperty("bool_match")
    private Boolean boolMatch = null;

    @JsonProperty("int_match")
    private Integer intMatch = null;

    @JsonProperty("is_mandatory")
    private Boolean isMandatory = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("string_match")
    private StringMatch stringMatch = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("validate")
    private Boolean validate = null;



    /**
     * This is the getter method this will return the attribute value.
     * Boolean value against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return boolMatch
     */
    public Boolean getBoolMatch() {
        return boolMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Boolean value against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param boolMatch set the boolMatch.
     */
    public void setBoolMatch(Boolean  boolMatch) {
        this.boolMatch = boolMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Integer value against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return intMatch
     */
    public Integer getIntMatch() {
        return intMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Integer value against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param intMatch set the intMatch.
     */
    public void setIntMatch(Integer  intMatch) {
        this.intMatch = intMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Specified claim should be present in the jwt.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return isMandatory
     */
    public Boolean getIsMandatory() {
        return isMandatory;
    }

    /**
     * This is the setter method to the attribute.
     * Specified claim should be present in the jwt.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param isMandatory set the isMandatory.
     */
    public void setIsMandatory(Boolean  isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Jwt claim name to be validated.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Jwt claim name to be validated.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * String values against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return stringMatch
     */
    public StringMatch getStringMatch() {
        return stringMatch;
    }

    /**
     * This is the setter method to the attribute.
     * String values against which the claim is matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param stringMatch set the stringMatch.
     */
    public void setStringMatch(StringMatch stringMatch) {
        this.stringMatch = stringMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Specifies the type of the claim.
     * Enum options - JWT_CLAIM_TYPE_BOOL, JWT_CLAIM_TYPE_INT, JWT_CLAIM_TYPE_STRING.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Specifies the type of the claim.
     * Enum options - JWT_CLAIM_TYPE_BOOL, JWT_CLAIM_TYPE_INT, JWT_CLAIM_TYPE_STRING.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Specifies whether to validate the claim value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return validate
     */
    public Boolean getValidate() {
        return validate;
    }

    /**
     * This is the setter method to the attribute.
     * Specifies whether to validate the claim value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param validate set the validate.
     */
    public void setValidate(Boolean  validate) {
        this.validate = validate;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      JWTClaimMatch objJWTClaimMatch = (JWTClaimMatch) o;
      return   Objects.equals(this.name, objJWTClaimMatch.name)&&
  Objects.equals(this.isMandatory, objJWTClaimMatch.isMandatory)&&
  Objects.equals(this.validate, objJWTClaimMatch.validate)&&
  Objects.equals(this.type, objJWTClaimMatch.type)&&
  Objects.equals(this.intMatch, objJWTClaimMatch.intMatch)&&
  Objects.equals(this.boolMatch, objJWTClaimMatch.boolMatch)&&
  Objects.equals(this.stringMatch, objJWTClaimMatch.stringMatch);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class JWTClaimMatch {\n");
                  sb.append("    boolMatch: ").append(toIndentedString(boolMatch)).append("\n");
                        sb.append("    intMatch: ").append(toIndentedString(intMatch)).append("\n");
                        sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    stringMatch: ").append(toIndentedString(stringMatch)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
                        sb.append("    validate: ").append(toIndentedString(validate)).append("\n");
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
