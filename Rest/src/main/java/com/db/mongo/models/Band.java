package com.db.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Band extends Entity{

	public Band(){
		super(EntityType.BAND);
	}
}