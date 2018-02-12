package com.db.mongo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@ToString(callSuper=true, includeFieldNames=true)

public class Album extends Entity{


	private String country;
	private String releaseDate;

	private List<Track> tracks;
	private List<Artist> contributors;
	private List<Label> labels;
	private List<Entity> creators;
	private List<String> genres;
	private List<String> subGenres;

	public Album(){
		super(EntityType.ALBUM);
	}
}
