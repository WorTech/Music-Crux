package com.db.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Track extends Entity {

    public Track(){
        super(EntityType.LABEL);
    }
}
