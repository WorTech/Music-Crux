package com.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Artist {

    @JsonProperty("id")
    private Long discogs_id;
    @JsonProperty("name")
    private String name;

}
