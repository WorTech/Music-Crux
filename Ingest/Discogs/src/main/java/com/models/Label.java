package com.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
/**
 * These are our DB models for internal storage use only
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Label {
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Sublabel{
        @JsonProperty("label")
        private String[] names;
    }
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class URL{
        @JsonProperty("url")
        private String[] urls;
    }

    @JsonProperty("id")
    private long discogs_id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("contactinfo")
    private String contactinfo;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("urls")
    private URL urls;
    @JsonProperty("sublabels")
    private Sublabel sublabels;
    @JsonProperty("parentLabel")
    private String parentLabel;
    private List<String> locations;

    public Label(){
        this.locations = new ArrayList<String>();
    }
}