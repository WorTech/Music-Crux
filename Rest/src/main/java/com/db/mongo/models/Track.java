package com.db.mongo.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@ToString(callSuper=true, includeFieldNames=true)

public class Track extends Entity {

    public Track(){
        super(EntityType.TRACK);
    }
}
