package com.Operations;

import com.Models.Label;
import com.PostRequests.DiscogsPostReq;
import com.Services.XmlFileReader;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
//Change this value when done.
//@Order(value = 1)
public class CreateLabelDB implements CommandLineRunner{

    @Override
    public void run(String... arg0) throws Exception{
        try{
            // Initialize OpenNLP tokenizers and models
            InputStream inputStreamTokenizer = new FileInputStream(arg0[1].toString());
            TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
            TokenizerME tokenizer = new TokenizerME(tokenModel);

            InputStream inputStreamNameFinder = new FileInputStream(arg0[2].toString());
            TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
            NameFinderME nameFinder = new NameFinderME(model);

            // Initialize Jackson parsers
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            String labelXmlFileString = arg0[0].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(labelXmlFileString);

            while (xmlFileReader.hasNext()) {

                String labelXmlString = xmlFileReader.next();
                JSONObject xmlJsonObj = XML.toJSONObject(labelXmlString);
                JSONObject LabelJson = xmlJsonObj.getJSONObject("label");

                Label label = mapper.readValue(LabelJson.toString(), Label.class);
                //System.out.println(label);
                //If the contactinfo xml tag is not empty, extract the  location via OpenNLP
                if(label.getContactinfo() != null) {
                    String XMLContactTag = label.getContactinfo();
                    String tokens[] = tokenizer.tokenize(XMLContactTag);
                    Span nameSpans[] = nameFinder.find(tokens);
                    for (Span s: nameSpans) {
                        if( (!(label.getLocations().contains(tokens[s.getStart()])) && tokens[s.getStart()] != "Tel")) {
                            label.getLocations().add(tokens[s.getStart()]);
                        }
                    }
                    //System.out.println("Locations: " + label.getLocations() + " for label: " + label.getName());
                }
                //HTTP:POST Request goes here
                DiscogsPostReq labelPost = new DiscogsPostReq();
                labelPost.postLabelEntity(label);
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}
