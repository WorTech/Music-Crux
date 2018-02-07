package common.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)

public class Track extends Entity {

    public Track() {
        super(EntityType.LABEL);
    }
}