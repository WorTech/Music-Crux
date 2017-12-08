package com.musiccrux.discogs_xml_consumption.models;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {

	private long master_id;
	private String country;
	private String title;
	
	private List<Track> tracks;
	@JsonProperty("tracklist")
	private void unpackTracksFromNestedObject(Map<String, List<Track>> trackList) {
		this.tracks = trackList.get("track");
	}

	private List<Artist> artists;
	@JsonProperty("extraartists")
	private void unpackArtistsFromNestedObject(Map<String, List<Artist>> extraartists) {
		this.artists = extraartists.get("artist");
	}

//	private List<Label> labels;
//	@JsonProperty("labels")
//	private void unpackLabelsFromNestedObject(Map<String, List<Label>> labels) {
//		this.labels= extraartists.get("artist");
//	}


	public static class Track {
		private String title;
		private String position;
		private String duration;
	}
	
	public static class Label {
		private long id;
		private String name;
		private String catno;
	}
}
