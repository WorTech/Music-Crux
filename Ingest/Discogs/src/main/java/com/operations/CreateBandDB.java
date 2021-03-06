package com.operations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Band;
import com.models.Entity;
import com.postrequests.DiscogsPostReq;
import com.services.XmlFileReader;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * This class creates the Band DB, using the ObjectMapper to map the JSON objected
 * extracted by the XmlFileReader from the band.xml (bandXmlFileString) file from Discogs data dump
 */
@Component
@Order(value=2)
public class CreateBandDB implements CommandLineRunner{
    @Override
    public void run(String... arg0) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            String artistXmlFileString = arg0[0].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(artistXmlFileString);

            while (xmlFileReader.hasNext()) {
                String artistXmlString = xmlFileReader.next();

                //Transforms the xml object to a JSON, then to an Artist object
                JSONObject xmlJsonObj = XML.toJSONObject(artistXmlString);
                JSONObject entityJson = xmlJsonObj.getJSONObject("artist");

                if (mapper.readValue(entityJson.toString(), Entity.class).getMembers() != null) {
                    Band band = mapper.readValue(entityJson.toString(), Band.class);
                    //Posts the Bands to the Music-Crux REST endpoint
                    DiscogsPostReq bandPost = new DiscogsPostReq();
                    bandPost.postBandEntity(band);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
