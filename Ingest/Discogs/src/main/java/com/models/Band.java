package com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * These are our DB models for internal storage use only
 * Each Artist entry in the artist.xml can either be an Artist or a Band
 * The determination is made by checking to see if the Artist has a "Members" field
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class Band extends Entity{

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Members {
        @JsonProperty("id")
        private List<Long> discogs_ids = new ArrayList<Long>();
        @JsonProperty("name")
        private List<String> names = new ArrayList<String>();
    }

    @JsonProperty("id")
    private Long discogs_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("members")
    private Members members;
}
