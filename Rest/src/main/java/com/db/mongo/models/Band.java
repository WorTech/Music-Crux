package com.db.mongo.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@ToString(callSuper=true, includeFieldNames=true)
public class Band extends Entity{
	@Data
	@Document
	public static class Members{
		private List<Long> id = new ArrayList<Long>();
		private List<String> name = new ArrayList<String>();
	}

	public Band(){
		super(EntityType.BAND);
	}

	private Members members;
}