package com.models;

import lombok.Data;
@Data
public class Label extends Entity {
    public Label(){
        super(EntityType.LABEL);
    }
}
