package com.musiccrux.discogs_xml_consumption.operations;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musiccrux.discogs_xml_consumption.models.Release;
import com.musiccrux.discogs_xml_consumption.repositories.ReleaseRepository;
import com.musiccrux.discogs_xml_consumption.utils.DiscogsXmlFileReader;

/**
 * Reads from an Releases XML source file and adds the releases from that file into
 * a collection in the Discogs database.
 * 
 * 
 *
 */

//@Component
public class CreateReleasesDB implements CommandLineRunner {
	
	@Autowired 
	private ReleaseRepository releaseRepository;
	@Override
	public void run(String... arg0) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);	

		String releaseXmlFileString = arg0[0].toString();
		DiscogsXmlFileReader xmlFileReader = new DiscogsXmlFileReader(releaseXmlFileString);

		
		while (xmlFileReader.hasNext()) {
			
			String releaseXmlString = xmlFileReader.next();
			
			JSONObject xmlJsonObj = XML.toJSONObject(releaseXmlString);
			System.out.println(xmlJsonObj.toString());
			JSONObject releaseJson = xmlJsonObj.getJSONObject("release");
			
			Release release = mapper.readValue(releaseJson.toString(), Release.class);
			releaseRepository.save(release);
			System.out.println(release.toString());

		
		}
	}
	
}
