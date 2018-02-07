package com.util;

import com.db.mongo.models.Band;
import com.db.mongo.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SerializeRelationships implements CommandLineRunner{
    @Autowired
    BandRepository band_repo;
    public void run(String... arg0) throws Exception{
        System.out.println("hello World");
        List<Band> bands = band_repo.findAll();
        for(Band band : bands){
            System.out.println(band);
        }
    }
}
