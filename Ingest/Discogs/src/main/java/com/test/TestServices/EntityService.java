package com.test.TestServices;

import com.models.Artist;
import com.models.Band;
import com.models.Label;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EntityService {

    public ResponseEntity<Artist> entity(Artist artist){
        //System.out.println("Artist:");
        System.out.println(artist.toString());
        return null;
    }

    public ResponseEntity<Band> entity(Band band){
        //System.out.println("Band:");
        System.out.println(band.toString());
        return null;
    }


    public ResponseEntity<Release> entity(Release release){
        //System.out.println("Release:");
        System.out.println(release.toString());
        return null;
    }


    public ResponseEntity<Label> entity(Label label){
        //System.out.println("Label:");
        System.out.println(label.toString());
        return null;
    }
}

