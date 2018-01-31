package com.db.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Label extends Entity {

    public Label(){
        super(EntityType.LABEL);
    }
}
