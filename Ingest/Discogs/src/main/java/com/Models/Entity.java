package com.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    @JsonProperty("id")
    private Long discogs_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("members")
    private Members members;

}
