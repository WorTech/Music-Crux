package com.models;

import lombok.Data;


@Data
public class Track extends Entity {
    public Track(){
        super(EntityType.TRACK);
    }
}
