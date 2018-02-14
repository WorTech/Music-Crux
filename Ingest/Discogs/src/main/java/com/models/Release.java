package com.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {

    @JsonProperty("genres")
    private Collection <Genre> genres;
    @JsonProperty("identifiers")
    private Identifiers identifiers;
    private String status;
    @JsonProperty("labels")
    private Labels labels;
    @JsonProperty("companies")
    private Companies companies;
    @JsonProperty("styles")
    private Collection<Style> styles;
    private String country;
    private String id;
    private String released;
    @JsonProperty("artists")
    private Artists artists;
    private String title;
    private String master_id;
    @JsonProperty("extraartists")
    private ExtraArtists extraartists;
    @JsonProperty("tracklist")
    private TrackList tracklist;
//    @JsonProperty("notes")
//    private String notes;


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Style{
        @JsonProperty("style")
        private String[] style;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Identifiers {
        @JsonProperty("identifier")
        private Collection<Identifier> identifiers;
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
        private Collection<Track> track;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Track {
        @JsonProperty("position")
        private String position;
        @JsonProperty("title")
        private String title;
        @JsonProperty("duration")
        private String duration;
        @JsonProperty("extraartists")
        private ExtraArtists extraartists;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExtraArtists{
        @JsonProperty("artist")
        private Collection<Artist> artist;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Artists{
        @JsonProperty("artist")
        private Collection<Artist> artists;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
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
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Labels {
        @JsonProperty("label")
        private Collection<Label> labels;
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
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        @JsonProperty("genre")
        private String[] genre;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Companies {
        @JsonProperty("company")
        private Collection<Company> companies;
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

