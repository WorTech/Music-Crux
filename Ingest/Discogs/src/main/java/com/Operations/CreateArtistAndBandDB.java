package com.Operations;

import com.Models.Artist;
import com.Models.Band;
import com.Models.Entity;
import com.PostRequests.DiscogsPostReq;
import com.Services.XmlFileReader;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//C:\Users\eclouhi\Desktop\artist.xml


@Component
//@Order(value =2)
//=======
//@Component
//@Order(value =1)

public class CreateArtistAndBandDB implements CommandLineRunner{

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

               if (mapper.readValue(entityJson.toString(), Entity.class).getMembers() == null){
                   Artist artist = mapper.readValue(entityJson.toString(), Artist.class);
                   //Posts the Artist to the Music-Crux REST endpoint
                   DiscogsPostReq artistPost = new DiscogsPostReq();
                   artistPost.postArtistEntity(artist);
               }else{
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
