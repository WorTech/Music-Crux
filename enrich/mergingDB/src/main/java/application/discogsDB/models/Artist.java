package application.discogsDB.models;

/**
 * Represents an actual artist. In most cases this are musicians, however
 * sound-engineers, producers, and bands etc. may also appear as artists.
 * 
 */


public final class Artist {

	private Long discogs_id;
	private String name;
	private Members members;

	/**
	 * 
	 * @return The id of the Artist given by Discogs
	 */
	public long getDiscogsId() {
		return discogs_id;
	}

	/**
	 * 
	 * @return The name of the Artist
	 */
	public String getName() {
		return name;
	}

	/**
	 * Note that if an "Artist" has a member property then it is actually a Band and
	 * not an actual individual Artist.
	 * 
	 * @return The members of the
	 */
	public Members getMembers() {
		return members;
	}

	@Override
	public String toString() {
		return "Artist [discogs_id=" + discogs_id + ", name=" + name + ", members=" + members + "]";
	}

}