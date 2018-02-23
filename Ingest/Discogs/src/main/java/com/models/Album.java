package com.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class Album {

    @JsonProperty("genres")
    private List <Genre> genres;
    @JsonProperty("identifiers")
    private Identifiers identifiers;
    @JsonProperty("labels")
    private Labels labels;
    @JsonProperty("companies")
    private Companies companies;
    @JsonProperty("styles")
    private List<Style> styles;
    private String country;
    @JsonProperty("id")
    private String discogs_id;
    @JsonProperty("released")
    private String released;
    @JsonProperty("artists")
    private Artists artists;
    @JsonProperty("title")
    private String title;
    @JsonProperty("extraartists")
    private ExtraArtists extraartists;
    @JsonProperty("tracklist")
    private TrackList tracklist;
    @JsonProperty("notes")
    private String notes;

//Only Deserializing a single string into the array
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Style{
        @JsonProperty("style")
        private List <String> style;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Identifiers {
        @JsonProperty("identifier")
        private List<Identifier> identifiers;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Identifier{
        @JsonProperty("type")
        private String type;
        @JsonProperty("value")
        private String value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TrackList{
        @JsonProperty("track")
        private List<Track> track;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraArtists{
        @JsonProperty("artist")
        private List<Artist> artist;
    }

    //Error: Field Null in REST model
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonSerialize
    public static class Artists{
        @JsonProperty("artist")
        private List<Artist> artists;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonSerialize
    public static class Artist {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("role")
        private String role;
        /*Tracks is mostly found to be empty, but might be of some use
          at a late time.
        */
        @JsonProperty("tracks")
        private String tracks;
    }
    //Error: Field Null in REST model
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Labels {
        @JsonProperty("label")
        private List<Label> labels;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Label {
        @JsonProperty("catno")
        private String catno;
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("entity_type_name")
        private String entityTypeName;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        @JsonProperty("genre")
        private List<String> genre;
    }

    //Error: Field Null in REST model
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Companies {
        @JsonProperty("company")
        private List<Company> companies;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Company {
        @JsonProperty("id")
        private String id;
        @JsonProperty("catno")
        private String catno;
        @JsonProperty("name")
        private String name;
        @JsonProperty("entity_type_name")
        private String entity_type_name;
        @JsonProperty("entity_type")
        private String entity_type;
        @JsonProperty("resource_url")
        private String resource_url;
    }

}

