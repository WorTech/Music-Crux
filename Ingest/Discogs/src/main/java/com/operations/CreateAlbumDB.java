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
import com.services.XmlFileReader;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

//@Component
//@Order(value = 1)
public class CreateAlbumDB implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


            SimpleModule module = new SimpleModule();

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

            mapper.registerModule(module);
            String releaseXmlFileString = arg0[0].toString();
            XmlFileReader xmlFileReader = new XmlFileReader(releaseXmlFileString);

            while (xmlFileReader.hasNext()) {

                String releaseXmlString = xmlFileReader.next();
                System.out.println(releaseXmlString);
//                JSONObject releaseJson = XML.toJSONObject(releaseXmlString).getJSONObject("release");
//                Release release = mapper.readValue(releaseXmlString, Release.class);
//                System.out.println(release.toString());
                JAXBContext jaxbContext = JAXBContext.newInstance(Release.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                //Release album = (Release)jaxbUnmarshaller.unmarshal();
//
                //Posts the Release to the Music-Crux REST endpoint

//                DiscogsPostReq albumPost = new DiscogsPostReq();
//                albumPost.postAlbumEntity(album);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
