package com.services;

import java.net.URI;
import java.util.List;

import com.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EntityService {

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Returns a list of entities from the provided arguments.
	 * This service method sends a request to the Music-Crux RESTful Service depending on the type (EntityType) passed in
	 * A limit parameter may be passed in to limit the number of search results returned
	 * @param type
	 * @param name
	 * @param limit
	 * @return List<Entity>
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