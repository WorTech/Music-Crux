package application.discogsDB.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Release {

	private Long discogs_id;
	private String country;
	private String title;
	private String released;

	private List<Track> tracks;
	private List<Artist> contributors;
	private List<Label> labels;
	private List<Artist> creators;
	private List<String> genres;
	private List<String> styles;

	private static class Track {
		private String title;
		private String position;
		private String duration;

		@Override
		public String toString() {
			return "Track [title=" + title + ", position=" + position + ", duration=" + duration + "]";
		}
	}

	private static class Label {
		private long id;
		private String name;
		private String catno;

		@Override
		public String toString() {
			return "Label [id=" + id + ", name=" + name + ", catno=" + catno + "]";
		}
	}

	public Long getDiscogs_id() {
		return discogs_id;
	}

	public String getCountry() {
		return country;
	}

	public String getTitle() {
		return title;
	}

	public String getReleased() {
		return released;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public List<Artist> getcontributors() {
		return contributors;
	}

	public List<Label> getLabels() {
		return labels;
	}

	@Override
	public String toString() {
		return "Release [discogs_id=" + discogs_id + ", country=" + country + ", title=" + title + ", released="
				+ released + ", tracks=" + tracks + ", contributors=" + contributors + ", labels=" + labels
				+ ", creators=" + creators + ", genres=" + genres + ", styles=" + styles + "]";
	}

}