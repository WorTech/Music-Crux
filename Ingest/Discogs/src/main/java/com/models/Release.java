package com.models;

import com.fasterxml.jackson.annotation.JsonCreator;
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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Release {

    @XmlElementWrapper(name = "genres")
    private Collection <Genre> genres;

    @XmlElementWrapper(name = "identifiers")
    private Collection <Identifier> identifiers;

    private String status;

    @XmlElementWrapper(name = "labels")
    private Collection<Label> labels;

    @XmlElementWrapper(name = "companies")
    private Collection<Company> companies;

    @XmlElementWrapper(name = "styles")
    private Collection<Style> styles;

    private String country;

    private String id;

    private String released;

    @XmlElementWrapper(name = "artists")
    private Collection<Artist> artists;

    private String title;

    private String master_id;

    @XmlElementWrapper(name = "extraartists")
    private Collection<Artist> extraartists;

    @XmlElementWrapper(name = "tracklist")
    private Collection<Track> tracklist;

    private String notes;

    @Data
    public class Style{
        private String style;
    }

    @Data
    public class Identifier{
        private String type;
        private String value;
    }

    @Data
    public class Track {
        private Long position;
        private String title;
        private String duration;
        @XmlElementWrapper(name = "extraartists")
        private Collection<Artist> extraartists;
    }

    @Data
    public class Artist {
        private Long id;
        private String name;
        private String role;
        /*Tracks is mostly found to be empty, but might be of some use
          at a late time.
        */
        private String tracks;
    }

//    @Data
//    public class Styles {
//        private String[] style;
//    }

    @Data
    public class Label {
        private Long catno;
        private Long id;
        private String name;
    }

    @Data
    public class Genre {
        private String genre;
    }

    @Data
    public class Company {
        private Long id;

        private Long catno;

        private String name;

        private String entity_type_name;

        private String entity_type;

        private String resource_url;
    }

}

