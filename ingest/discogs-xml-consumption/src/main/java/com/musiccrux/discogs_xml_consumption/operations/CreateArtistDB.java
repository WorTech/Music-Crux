package com.musiccrux.discogs_xml_consumption.operations;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musiccrux.discogs_xml_consumption.models.Artist;
import com.musiccrux.discogs_xml_consumption.repositories.ArtistRepository;
import com.musiccrux.discogs_xml_consumption.utils.DiscogsXmlFileReader;

/**
 * Reads from an Artist XML source file and adds the artist from that file into
 * the collection in the Discogs database Artist database.
 * 
 * NOTES: 1) The Artist XML file should have "<?xml version="1.0"
 * encoding="URF-8"?>" at the top
 * 
 * @author Taiwo Oyekanmi
 *
 */
//@Component
public class CreateArtistDB implements CommandLineRunner {

	@Autowired
	private ArtistRepository ArtistRepository;

	@Override
	public void run(String... arg0) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		String artistXmlFileString = arg0[0].toString();
		DiscogsXmlFileReader xmlFileReader = new DiscogsXmlFileReader(artistXmlFileString);

		while (xmlFileReader.hasNext()) {

			String artistXmlString = xmlFileReader.next();

			JSONObject xmlJsonObj = XML.toJSONObject(artistXmlString);
			JSONObject artistJson = xmlJsonObj.getJSONObject("artist");

			Artist artist = mapper.readValue(artistJson.toString(), Artist.class);
			ArtistRepository.save(artist);
			System.out.println(artist.toString());
		}
	}
}
