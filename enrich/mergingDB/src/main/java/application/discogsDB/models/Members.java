package application.discogsDB.models;

import java.util.Arrays;

/**
 * Represents a person that is member of an {@link Artist}.
 * 
 */
public class Members {
	
	private long[] discogs_ids;
	private String[] names;

	public long[] getDiscogs_Ids() {
		return discogs_ids;
	}

	public String[] getNames() {
		return names;
	}

	@Override
	public String toString() {
		return "Members [discogs_ids=" + Arrays.toString(discogs_ids) + ", names=" + Arrays.toString(names) + "]";
	}

}