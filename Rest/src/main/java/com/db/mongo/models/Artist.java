package com.db.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Artist extends Entity {

    public Artist(){
        super(EntityType.ARTIST);
    }
}
