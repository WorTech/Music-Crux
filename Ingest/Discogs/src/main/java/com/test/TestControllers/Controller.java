package com.test.TestControllers;
import com.models.Artist;
import com.models.Band;
import com.models.Label;
import com.test.TestServices.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    EntityService service = new EntityService();

    @RequestMapping(value = "/Artist", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        HttpStatus status = artist == null ? HttpStatus.BAD_REQUEST : HttpStatus.ACCEPTED;
        service.entity(artist);
        return new ResponseEntity<Artist>(artist, status);
    }

    @RequestMapping(value = "/Band", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Band> addBand(@RequestBody Band band){
        HttpStatus status = band == null ? HttpStatus.BAD_REQUEST : HttpStatus.ACCEPTED;
        service.entity(band);
        return new ResponseEntity<Band>(band, status);
    }


    @RequestMapping(value = "/Album", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Release> addAlbum(@RequestBody Release release){
        HttpStatus status = release == null ? HttpStatus.BAD_REQUEST : HttpStatus.ACCEPTED;
        service.entity(release);
        return new ResponseEntity<Release>(release, status);
    }

  @RequestMapping(value = "/Label", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Label> addArtist(@RequestBody Label label) {
        HttpStatus status = label == null ? HttpStatus.BAD_REQUEST : HttpStatus.ACCEPTED;
        service.entity(label);
        return new ResponseEntity<Label>(label, status);
    }

}
