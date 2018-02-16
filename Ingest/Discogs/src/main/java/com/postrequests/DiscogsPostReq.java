package com.postrequests;

import com.models.Artist;
import com.models.Band;
import com.models.Label;
import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Data
@Component
public class DiscogsPostReq {

    //    private EntityType type;
    private RestTemplate restTemplate = new RestTemplate();
    private String URI;

    public HttpStatus postArtistEntity(Artist artist) {

        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Artist> artistEntity = new HttpEntity(artist, headers);
        URI = "http://localhost:8081/artist";
        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            ResponseEntity<Artist> entityOut = restTemplate.postForEntity(URI, artistEntity, Artist.class);
            if (entityOut.getBody() != null) {
                status = entityOut.getStatusCode();
            } else {
                status = entityOut.getStatusCode();
            }

        } catch (HttpClientErrorException e) {
            System.out.println("Error with client request.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        } catch (HttpServerErrorException e) {
            System.out.println("Error with server.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        }
        System.out.println(status);
        return status;
    }

    public HttpStatus postBandEntity(Band band) {

        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Band> bandEntity = new HttpEntity(band, headers);
        URI = "http://localhost:8081/band";
        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            ResponseEntity<Band> entityOut = restTemplate.postForEntity(URI, bandEntity, Band.class);
            if (entityOut.getBody() != null) {
                status = entityOut.getStatusCode();
            } else {
                status = entityOut.getStatusCode();
            }

        } catch (HttpClientErrorException e) {
            System.out.println("Error with client request.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        } catch (HttpServerErrorException e) {
            System.out.println("Error with server.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        }
        System.out.println(status);
        return status;
    }


    public HttpStatus postAlbumEntity(Release release) {

        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Release> albumEntity = new HttpEntity(release, headers);
        URI = "http://localhost:8080/Release";

        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            ResponseEntity<Release> entityOut = restTemplate.postForEntity(URI, albumEntity, Release.class);
            if (entityOut.getBody() != null) {
                status = entityOut.getStatusCode();
            } else {
                status = entityOut.getStatusCode();
            }

        } catch (HttpClientErrorException e) {
            System.out.println("Error with client request.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();

        } catch (HttpServerErrorException e) {
            System.out.println("Error with server.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        }
        System.out.println(status);
        return status;
    }

    public HttpStatus postLabelEntity(Label label) {
        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Label> labelEntity = new HttpEntity(label, headers);
        URI = "http://localhost:8081/label";
        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            ResponseEntity<Label> entityOut = restTemplate.postForEntity(URI, labelEntity, Label.class);
            status = entityOut.getStatusCode();
        } catch (HttpClientErrorException e) {
            System.out.println("Error with client request.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();

        } catch (HttpServerErrorException e) {
            System.out.println("Error with server.");
            System.out.println(e.getMostSpecificCause());
            System.out.println(e.getResponseBodyAsString());
            e.printStackTrace();
        }
        System.out.println(status);
        return status;
    }
}

