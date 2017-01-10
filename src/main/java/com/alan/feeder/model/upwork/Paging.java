
package com.alan.feeder.model.upwork;

import java.io.Serializable;
import java.util.HashMap;
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
    "total",
    "offset",
    "count"
})
@Getter
@Setter
public class Paging implements Serializable {

    @JsonProperty("total")
    private long total;
    @JsonProperty("offset")
    private long offset;
    @JsonProperty("count")
    private long count;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Paging() {
    }

    /**
     * 
     * @param total
     * @param count
     * @param offset
     */
    public Paging(long total, long offset, long count) {
        this.total = total;
        this.offset = offset;
        this.count = count;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(offset).append(count).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Paging) == false) {
            return false;
        }
        Paging rhs = ((Paging) other);
        return new EqualsBuilder().append(total, rhs.total).append(offset, rhs.offset).append(count, rhs.count).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
