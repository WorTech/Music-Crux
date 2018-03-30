package com.db.mongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Relationship {
	@Indexed
	private RelationshipType type;

	@Indexed
	@DBRef
	private Entity entityA, entityB;
}