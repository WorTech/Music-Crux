package com.musiccrux.discogs_xml_consumption.operations;

import opennlp.tools.namefind.NameFinderME; 
import opennlp.tools.namefind.TokenNameFinderModel; 
import opennlp.tools.tokenize.TokenizerME; 
import opennlp.tools.tokenize.TokenizerModel; 
import opennlp.tools.util.Span;  


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;





import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musiccrux.discogs_xml_consumption.models.Label;
import com.musiccrux.discogs_xml_consumption.repositories.LabelRepository;
import com.musiccrux.discogs_xml_consumption.utils.DiscogsXmlFileReader;

@Component
public class CreateLabelsDB implements CommandLineRunner{

	@Autowired
	private LabelRepository labelRepository;

	@Override
	public void run(String... arg0) throws Exception {

		// Initialize OpenNLP tokenizers and models
		InputStream inputStreamTokenizer = new FileInputStream("C:/Users/asok/Downloads/en-token.bin");
		TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
		TokenizerME tokenizer = new TokenizerME(tokenModel); 

		InputStream inputStreamNameFinder = new FileInputStream("C:/Users/asok/Downloads/en-ner-location.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
		NameFinderME nameFinder = new NameFinderME(model);      

		// Initialize Jackson parsers
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		String labelXmlFileString = arg0[0].toString();
		DiscogsXmlFileReader xmlFileReader = new DiscogsXmlFileReader(labelXmlFileString);

		while (xmlFileReader.hasNext()) {
			
			String labelXmlString = xmlFileReader.next();

			JSONObject xmlJsonObj = XML.toJSONObject(labelXmlString);
			JSONObject LabelJson = xmlJsonObj.getJSONObject("label");

			Label label = mapper.readValue(LabelJson.toString(), Label.class);
			
			//If the contactinfo xml tag is not empty, extract the location via OpenNLP
			if(label.getContactinfo() != null) {
				String XMLContactTag = label.getContactinfo();
				String tokens[] = tokenizer.tokenize(XMLContactTag);
				Span nameSpans[] = nameFinder.find(tokens);
				for (Span s: nameSpans) {
					if( (!(label.getLocations().contains(tokens[s.getStart()])) && tokens[s.getStart()] != "Tel")) {
						label.getLocations().add(tokens[s.getStart()]);
					}
				}
				System.out.println("Locations: " + label.getLocations() + " for label: " + label.getName());
			}
			labelRepository.save(label);
		}
	}
}