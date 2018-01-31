package com.Test.TestServices;

import com.Models.Album;
import com.Models.Artist;
import com.Models.Band;
import com.Models.Label;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EntityService {

    public ResponseEntity<Artist> entity(Artist artist){
        System.out.println("Artist:");
        System.out.println(artist.toString());
        return null;
    }

    public ResponseEntity<Band> entity(Band band){
        System.out.println("Band:");
        System.out.println(band.toString());
        return null;
    }


    public ResponseEntity<Album> entity(Album album){
        System.out.println("Album:");
        System.out.println(album.toString());
        return null;
    }


    public ResponseEntity<Label> entity(Label label){
        System.out.println("Label:");
        System.out.println(label.toString());
        return null;
    }
}

