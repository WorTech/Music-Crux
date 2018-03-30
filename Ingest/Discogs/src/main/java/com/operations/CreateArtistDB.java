package com.operations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Artist;
import com.models.Band;
import com.models.Entity;
import com.postrequests.DiscogsPostReq;
import com.services.XmlFileReader;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class CreateArtistDB implements CommandLineRunner {
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

                if (mapper.readValue(entityJson.toString(), Entity.class).getMembers() == null) {
                    Artist artist = mapper.readValue(entityJson.toString(), Artist.class);
                    //Posts the Artist to the Music-Crux REST endpoint
                    DiscogsPostReq artistPost = new DiscogsPostReq();
                    artistPost.postArtistEntity(artist);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
