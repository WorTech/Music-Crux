package com.services;

		import java.net.URI;
		import java.util.ArrayList;
		import java.util.List;

		import com.models.*;
		import org.springframework.http.HttpEntity;
		import org.springframework.http.HttpHeaders;
		import org.springframework.http.HttpMethod;
		import org.springframework.http.MediaType;
		import org.springframework.stereotype.Service;
		import org.springframework.web.client.RestTemplate;
		import org.springframework.web.util.UriComponents;
		import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EntityService {

	private RestTemplate restTemplate = new RestTemplate();
	// TODO: Update this function to reflect the changes to the Relationship models

	/**
	 * Creates a molecule from the provided labels.
	 * The Molecule consists of the entities and relationships corresponding to the labels
	 * //@param entities
	 *
	 * @return Molecule
	 */

	//Service makes the GET requests to Music-Crux RESTful API
	public List<Entity> getEntitySearchResults(String type, String name, int limit) {
		//Type parameter will be one of -> {'Artist', 'Band', 'Label', 'Album', 'Track'}
		String URL = "http://localhost:8081/" + type;
		System.out.println("Request made to: " + URL);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
				.queryParam("name", name)
				.queryParam("limit", limit);
		UriComponents components = builder.build(true);
		URI uri = components.toUri();
		List<Entity> entities = restTemplate.getForObject(uri, List.class);
		return entities;
	}
}
