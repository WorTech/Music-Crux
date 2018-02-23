package com.db.mongo.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@ToString(callSuper=true, includeFieldNames=true)
public class Band extends Entity{

	public Members members;

	@Data
	public static class Members{
		public List<Long> id = new ArrayList<Long>();
		public List<String> name = new ArrayList<String>();
	}

	public Band(){
		super(EntityType.BAND);
	}
}