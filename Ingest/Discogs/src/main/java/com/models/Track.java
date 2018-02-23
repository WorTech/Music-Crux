package com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    @JsonProperty("position")
    private String position;
    @JsonProperty("title")
    private String title;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("extraartists")
    private Album.ExtraArtists extraartists;
}