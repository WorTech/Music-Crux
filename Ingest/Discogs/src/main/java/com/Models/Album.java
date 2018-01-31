package com.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

//GSON nested JSON to Java Objects
@Data
public class Album {

    @Expose
    String country;
    @SerializedName("tracklist")
    @Expose
    TrackList trackList;
//    @Expose
//    Identifiers identifiers;
    @SerializedName("extraArtists")
    @Expose
    ExtraArtists extraArtists;
    @Expose
    String title;
//    @Expose
//    Companies companies;
    @Expose
    Artists artist;
//    @Expose
//    Genre genres;
    @Expose
    Styles style;


    @Data
    public static class TrackList {
        @Expose
        List<Track> track = new ArrayList<Track>();
    }

    @Data
    public static class Identifiers {
        @Expose
        List<Identifier> identifier = new ArrayList<Identifier>();
    }

    @Data
    public static class Identifier {
        @Expose
        String description;
        @Expose
        String type;
        @Expose
        String value;
    }

    @Data
    public static class ExtraArtists {
        @Expose
        List<Artist> artist = new ArrayList<Artist>();
    }

    @Data
    public static class Artist {
        @Expose
        String role;
        @Expose
        String name;
        @Expose
        String tracks;
    }

    @Data
    public static class Artists {
        @Expose
        Artist artist;
    }

    @Data
    public static class Genres {
        @Expose
        List<Genre> genre = new ArrayList<Genre>();
    }

    @Data
    public static class Genre {
        @Expose
        String genre;
    }

    @Data
    public static class Styles {
        @Expose
        List<Style> style = new ArrayList<Style>();
    }

    @Data
    public static class Style {
        @Expose
        String style;
    }

    @Data
    public static class Companies {
        @Expose
        List<Label> company = new ArrayList<Label>();
    }


    @Data
    public static class Label {
        @Expose
        private long id;
        @Expose
        private String name;
        @Expose
        private String catno;
        @Expose
        private String entity_type_name;


    }

}
