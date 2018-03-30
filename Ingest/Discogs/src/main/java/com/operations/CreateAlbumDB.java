package com.operations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.models.Release;
import com.postrequests.DiscogsPostReq;
import com.services.XmlFileReader;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.io.IOException;
/**
 * This class creates the Album DB, using the ObjectMapper to map the JSON objected
 * extracted by the XmlFileReader from the album.xml (albumXmlFileString) file from Discogs data dump
 * These JSON files are nest JSON objects and JSON arrays of JSON objects, or other arrays
 * Mapping the objects to the class models required more deserialization
 */
@Component
@Order(value = 4)
public class CreateAlbumDB implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        try {
            //Using multiple deserialization features due to the nested JSON objects
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            //Creates a blank module to be injected into the ObjectMapper
            SimpleModule module = new SimpleModule();

            //Adds additional deserialization for parsing nest JSON objects
            module.addDeserializer(String.class, new StdDeserializer<String>(String.class) {
                @Override
                public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                    String result = StringDeserializer.instance.deserialize(p, ctxt);
                    if (StringUtils.isEmpty(result)) {
                        return null;
                    }
                    return result;
                }
            });
            //Adds the module to the mapper object
            mapper.registerModule(module);

            String releaseXmlFileString = arg0[0].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(releaseXmlFileString);

            while (xmlFileReader.hasNext()) {

                JSONObject releaseJson = XML.toJSONObject(xmlFileReader.next()).getJSONObject("release");
                Release release = mapper.readValue(releaseJson.toString(), Release.class);

                //Posts the Release to the Music-Crux REST endpoint
                DiscogsPostReq releasePost = new DiscogsPostReq();
                releasePost.postReleaseEntity(release);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
