
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
    "snippet",
    "category2",
    "job_type",
    "date_created",
    "workload",
    "title",
    "url",
    "skills",
    "duration",
    "subcategory2",
    "job_status",
    "client",
    "id",
    "budget"
})
@Getter
@Setter
public class Job implements Serializable {

    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("category2")
    private String category2;
    @JsonProperty("job_type")
    private String jobType;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("workload")
    private String workload;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("skills")
    private List<String> skills = new ArrayList<String>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("subcategory2")
    private String subcategory2;
    @JsonProperty("job_status")
    private String jobStatus;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("id")
    private String id;
    @JsonProperty("budget")
    private long budget;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Job() {
    }

    /**
     * 
     * @param skills
     * @param budget
     * @param jobType
     * @param workload
     * @param client
     * @param jobStatus
     * @param snippet
     * @param subcategory2
     * @param category2
     * @param url
     * @param id
     * @param title
     * @param duration
     * @param dateCreated
     */
    public Job(String snippet, String category2, String jobType, String dateCreated, String workload, String title, String url, List<String> skills, String duration, String subcategory2, String jobStatus, Client client, String id, long budget) {
        this.snippet = snippet;
        this.category2 = category2;
        this.jobType = jobType;
        this.dateCreated = dateCreated;
        this.workload = workload;
        this.title = title;
        this.url = url;
        this.skills = skills;
        this.duration = duration;
        this.subcategory2 = subcategory2;
        this.jobStatus = jobStatus;
        this.client = client;
        this.id = id;
        this.budget = budget;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(snippet).append(category2).append(jobType).append(dateCreated).append(workload).append(title).append(url).append(skills).append(duration).append(subcategory2).append(jobStatus).append(client).append(id).append(budget).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Job) == false) {
            return false;
        }
        Job rhs = ((Job) other);
        return new EqualsBuilder().append(snippet, rhs.snippet).append(category2, rhs.category2).append(jobType, rhs.jobType).append(dateCreated, rhs.dateCreated).append(workload, rhs.workload).append(title, rhs.title).append(url, rhs.url).append(skills, rhs.skills).append(duration, rhs.duration).append(subcategory2, rhs.subcategory2).append(jobStatus, rhs.jobStatus).append(client, rhs.client).append(id, rhs.id).append(budget, rhs.budget).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
