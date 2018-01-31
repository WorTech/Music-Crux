package models;

import lombok.Data;

@Data
public class Artist extends Entity {

    public Artist() {
        super(EntityType.ARTIST);
    }
}