package common.models;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class Band extends Entity {
    public Members members;

    @Data
    public static class Members{
        public List<Long> id = new ArrayList<Long>();
        public List<String> name = new ArrayList<String>();
    }
    public Band() {
        super(EntityType.BAND);
    }
}