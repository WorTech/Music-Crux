package com.Operations;

import com.Models.Album;
import com.PostRequests.DiscogsPostReq;
import com.Services.XmlFileReader;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(value = 1)
public class CreateAlbumDB implements CommandLineRunner {


    @Override
    public void run(String... arg0) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            String releaseXmlFileString = arg0[3].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(releaseXmlFileString);

            while (xmlFileReader.hasNext()) {

                String releaseXmlString = xmlFileReader.next();
                JSONObject xmlJsonObj = XML.toJSONObject(releaseXmlString);

                JSONObject releaseJson = xmlJsonObj.getJSONObject("release");
                Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

                Album album = gson.fromJson(releaseJson.toString(), Album.class);
                String json = gson.toJson(album);
                System.out.println(album.toString());
//                System.out.println(json);
                //Posts the Album to the Music-Crux REST endpoint

//                DiscogsPostReq albumPost = new DiscogsPostReq();
//                albumPost.postAlbumEntity(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
