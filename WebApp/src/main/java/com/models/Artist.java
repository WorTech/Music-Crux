package com.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)


public class Artist extends Entity {
    public Artist(){
        super(EntityType.ARTIST);
    }
}
