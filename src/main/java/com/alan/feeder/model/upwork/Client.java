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
        "feedback",
        "country",
        "past_hires",
        "payment_verification_status",
        "jobs_posted",
        "reviews_count"
})
@Setter
@Getter
public class Client implements Serializable{

    @JsonProperty("feedback")
    private float feedback;
    @JsonProperty("country")
    private String country;
    @JsonProperty("past_hires")
    private long pastHires;
    @JsonProperty("payment_verification_status")
    private String paymentVerificationStatus;
    @JsonProperty("jobs_posted")
    private long jobsPosted;
    @JsonProperty("reviews_count")
    private long reviewsCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Client() {
    }

    /**
     * @param feedback
     * @param jobsPosted
     * @param pastHires
     * @param paymentVerificationStatus
     * @param reviewsCount
     * @param country
     */
    public Client(long feedback,
                  String country,
                  long pastHires,
                  String paymentVerificationStatus,
                  long jobsPosted,
                  long reviewsCount) {
        this.feedback = feedback;
        this.country = country;
        this.pastHires = pastHires;
        this.paymentVerificationStatus = paymentVerificationStatus;
        this.jobsPosted = jobsPosted;
        this.reviewsCount = reviewsCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(feedback).append(country).append(pastHires).append(paymentVerificationStatus).append(
                jobsPosted).append(reviewsCount).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Client) == false) {
            return false;
        }
        Client rhs = ((Client) other);
        return new EqualsBuilder().append(feedback, rhs.feedback).append(country, rhs.country).append(pastHires,
                                                                                                      rhs.pastHires).append(
                paymentVerificationStatus,
                rhs.paymentVerificationStatus).append(jobsPosted, rhs.jobsPosted).append(reviewsCount,
                                                                                         rhs.reviewsCount).append(
                additionalProperties,
                rhs.additionalProperties).isEquals();
    }

}
