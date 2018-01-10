package models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Album {

	private String country;
	private String title;
	private String releaseDate;

	private List<Track> tracks;
	private List<Artist> contributors;
	private List<Label> labels;
	private List<Entity> creators;
	private List<String> genres;
	private List<String> subGenres;

	private static class Track {
		private String title;
		private String position;
		private String duration;

		@Override
		public String toString() {
			return "Track [title=" + title + ", position=" + position + ", duration=" + duration + "]";
		}
	}

	// TODO: replace this class with Ati's label
	//
	private static class Label {
		private long id;
		private String name;
		private String catno;

		@Override
		public String toString() {
			return "Label [id=" + id + ", name=" + name + ", catno=" + catno + "]";
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Artist> getContributors() {
		return contributors;
	}

	public void setContributors(List<Artist> contributors) {
		this.contributors = contributors;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public List<Entity> getCreators() {
		return creators;
	}

	public void setCreators(List<Entity> creators) {
		this.creators = creators;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getSubGenres() {
		return subGenres;
	}

	public void setSubGenres(List<String> subGenres) {
		this.subGenres = subGenres;
	}

	@Override
	public String toString() {
		return "Album [country=" + country + ", title=" + title + ", releaseDate=" + releaseDate + ", tracks=" + tracks
				+ ", contributors=" + contributors + ", labels=" + labels + ", creators=" + creators + ", genres="
				+ genres + ", subGenres=" + subGenres + "]";
	}

	
	

}
