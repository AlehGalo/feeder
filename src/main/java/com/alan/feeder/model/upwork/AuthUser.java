package com.alan.feeder.model.upwork;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "timezone",
        "timezone_offset",
        "last_name",
        "first_name"
})
@Getter
@Setter
public class AuthUser implements Serializable {

    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_offset")
    private String timezoneOffset;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("first_name")
    private String firstName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuthUser() {
    }

    /**
     * @param lastName
     * @param timezone
     * @param timezoneOffset
     * @param firstName
     */
    public AuthUser(String timezone, String timezoneOffset, String lastName, String firstName) {
        this.timezone = timezone;
        this.timezoneOffset = timezoneOffset;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timezone).append(timezoneOffset).append(lastName).append(firstName).append(
                additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthUser) == false) {
            return false;
        }
        AuthUser rhs = ((AuthUser) other);
        return new EqualsBuilder().append(timezone, rhs.timezone).append(timezoneOffset, rhs.timezoneOffset).append(
                lastName,
                rhs.lastName).append(firstName, rhs.firstName).append(additionalProperties,
                                                                      rhs.additionalProperties).isEquals();
    }

}
