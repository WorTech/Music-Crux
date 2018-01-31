package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Members {
    @JsonProperty("id")
    private long[] discogs_ids;
    @JsonProperty("name")
    private String[] names;

}
