package com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * These are our DB models for internal storage use only
 * This is the parent (super class) of all the entities
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    @JsonProperty("id")
    private Long discogs_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("members")
    private Band.Members members;
}
