package com.db.mongo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames=true)
public class Members {
    private long[] discogs_ids;
    private String[] names;
}
