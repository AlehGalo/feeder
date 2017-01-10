
package com.alan.feeder.model.upwork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "server_time",
    "auth_user",
    "jobs",
    "profile_access",
    "paging"
})
@Getter
@Setter
public class JobRequest implements Serializable {

    @JsonProperty("server_time")
    private long serverTime;
    @JsonProperty("auth_user")
    private AuthUser authUser;
    @JsonProperty("jobs")
    private List<Job> jobs = new ArrayList<Job>();
    @JsonProperty("profile_access")
    private String profileAccess;
    @JsonProperty("paging")
    private Paging paging;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JobRequest() {
    }

    /**
     * 
     * @param jobs
     * @param authUser
     * @param profileAccess
     * @param serverTime
     * @param paging
     */
    public JobRequest(long serverTime, AuthUser authUser, List<Job> jobs, String profileAccess, Paging paging) {
        this.serverTime = serverTime;
        this.authUser = authUser;
        this.jobs = jobs;
        this.profileAccess = profileAccess;
        this.paging = paging;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serverTime).append(authUser).append(jobs).append(profileAccess).append(paging).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobRequest) == false) {
            return false;
        }
        JobRequest rhs = ((JobRequest) other);
        return new EqualsBuilder().append(serverTime, rhs.serverTime).append(authUser, rhs.authUser).append(jobs, rhs.jobs).append(profileAccess, rhs.profileAccess).append(paging, rhs.paging).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}