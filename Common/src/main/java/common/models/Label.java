package common.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true, includeFieldNames=true)

public class Label extends Entity {

    public Label() {
        super(EntityType.LABEL);
    }
}