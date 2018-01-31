package models;

import lombok.Data;

@Data
public class Band extends Entity {

    public Band() {
        super(EntityType.BAND);
    }
}