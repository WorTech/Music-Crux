package api.model.search.artist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 *  Representation of the page returned from the endPoint: "/database/search?type=artist"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSearchPage {
	
	@JsonProperty("pagination")
	private ArtistSearchPageInfo pageInfo;
	
	@JsonProperty("results")
	private ArtistSearchResult[] artistSearchResults;

	public ArtistSearchResult[] getArtistSearchResults() {
		return artistSearchResults;
	}

	public void setArtistSearchResults(ArtistSearchResult[] artistSearchResults) {
		this.artistSearchResults = artistSearchResults;
	}
	
	public boolean hasNextPage() {
		return pageInfo.getCurrentPage() < pageInfo.getTotalPages();
	}
	
//	public PageRequest nextPage() {
//		return new PageRequest(pageInfo.getCurrentPage() + 1,
//				pageInfo.getItemsPerPage());
//	}
	
	
}
