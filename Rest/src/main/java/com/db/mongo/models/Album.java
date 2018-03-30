package com.db.mongo.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true, includeFieldNames=true)
@Document(collection = "Albums")
public class Album extends Entity{

	@Indexed
	private String discogs_id;
	@Indexed
	private Labels labels;
	private List<Genre> genres;
	private Identifiers identifiers;
	private Companies companies;
	private List<Style> styles;

	@Data
	public static class Style{
		private List <String> style;

	}

	@Data
	public static class Identifiers {
		private List<Identifier> identifiers;
	}

	@Data
	public static class Identifier{
		private String type;
		private String value;
	}

	@Data
	public static class TrackList{
		private List<Track> track;
	}

	@Data
	public static class Track {
		private String position;
		private String title;
		private String duration;
		private ExtraArtists extraartists;
	}

	@Data
	public static class ExtraArtists{
		private List<Artist> artist;
	}

	@Data
	public static class Artists{
		private List<Artist> artists;

	}

	@Data
	public static class Artist {
		private String id;
		private String name;
		private String role;
		/*Tracks is mostly found to be empty, but might be of some use
          at a late time.
        */
		private String tracks;
	}
	@Data
	public static class Labels {
		private List<Label> labels;
	}

	@Data
	public static class Label {
		private String catno;
		private String id;
		private String name;
		private String entityTypeName;
	}

	@Data
	public static class Genre {
		private List<String> genre;
	}

	@Data
	public static class Companies {
		private List<Company> companies;
	}

	@Data
	public static class Company {
		private String id;
		private String catno;
		private String name;
		private String entity_type_name;
		private String entity_type;
		private String resource_url;
	}




	public Album(){
		super(EntityType.ALBUM);
	}
}