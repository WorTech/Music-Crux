package com.operations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.models.Album;
import com.postrequests.DiscogsPostReq;
import com.services.XmlFileReader;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.io.IOException;

@Component
@Order(value = 4)
public class CreateAlbumDB implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.disable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

            String releaseXmlFileString = arg0[0].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(releaseXmlFileString);

            while (xmlFileReader.hasNext()) {

                JSONObject releaseJson = XML.toJSONObject(xmlFileReader.next()).getJSONObject("release");
                Album album = mapper.readValue(releaseJson.toString(), Album.class);

                //Posts the Release to the Music-Crux REST endpoint
                DiscogsPostReq albumPost = new DiscogsPostReq();
                albumPost.postAlbumEntity(album);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
