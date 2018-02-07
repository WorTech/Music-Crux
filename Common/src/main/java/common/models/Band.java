package common.models;

import lombok.Data;

@Data
public class Band extends Entity {

    public Band() {
        super(EntityType.BAND);
    }
}