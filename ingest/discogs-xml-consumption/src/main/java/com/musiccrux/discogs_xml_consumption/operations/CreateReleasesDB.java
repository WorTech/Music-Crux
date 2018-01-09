package com.musiccrux.discogs_xml_consumption.operations;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

	@Override
	public void run(String... arg0) throws Exception {
	

		String releaseXmlFileString = arg0[0].toString();
		DiscogsXmlFileReader xmlFileReader = new DiscogsXmlFileReader(releaseXmlFileString);

		int i = 0;
		while (i != 2 && xmlFileReader.hasNext()) {

			String artistXmlString = xmlFileReader.next();

			JSONObject xmlJsonObj = XML.toJSONObject(artistXmlString);
			JSONObject releaseJson = xmlJsonObj.getJSONObject("release");
			JSONObject artistJson = releaseJson.getJSONObject("artists").getJSONObject("artist");
			JSONObject labelJson = releaseJson.getJSONObject("labels");
//			if (i == 1) {
//				 labelJson = 
//				 System.out.println(labelJson.toString());
//			}
			System.out.println(xmlJsonObj.toString());
			
			i++;
		}
	}
	
}
