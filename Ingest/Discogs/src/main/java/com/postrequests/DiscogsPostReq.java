package com.postrequests;

import com.models.Artist;
import com.models.Band;
import com.models.Label;
import com.models.Release;
import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
/**
 *This class acts as a controller on the Ingest side of the application
 * Possible implementation of the Feign framework would be a viable replacement
 * Each function is essentially the same
 */
@Data
@Component
public class DiscogsPostReq {


    private RestTemplate restTemplate = new RestTemplate();
    private String URI;

    /**
     * @param artist : Artist entity is passed into the function
     * @implNote : Creates a ResponseEntity out of the artist, the artist model(class), URI
     * and header information (Combined into a HttpEntity with the artist)
     * @return   : Returns the response status received from the server after making the
     * POST request to a specific URI in the REST layer of Music-Crux
     */
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
        //System.out.println(status);
        return status;
    }

    public HttpStatus postBandEntity(Band band) {
        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        System.out.println(band);
        HttpEntity<Band> bandEntity = new HttpEntity(band, headers);
        URI = "http://localhost:8081/band";
        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            //ServiceRequest request =
            System.out.println("1");
            Band entityOut = restTemplate.postForObject(URI, bandEntity, Band.class);
//            System.out.println(entityOut.toString());
            //if (entityOut.getBody() != null) {
            //    status = entityOut.getStatusCode();
            //} else {
            //    status = entityOut.getStatusCode();
            //}
            //System.out.println(entityOut);

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
        //System.out.println(status);
        return status;
    }

    public HttpStatus postReleaseEntity(Release release) {

        //Sets up the HTTP headers and content for the RestTemplate and the URI
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Release> releaseEntity = new HttpEntity(release, headers);

        URI = "http://localhost:8080/Release";

        HttpStatus status = HttpStatus.NO_CONTENT;

        try {
            ResponseEntity<Release> entityOut = restTemplate.postForEntity(URI, releaseEntity, Release.class);
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
        //System.out.println(status);
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
        //System.out.println(status);
        return status;
    }
}

