package com.db.mongo.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Relationship {
	@Indexed
	private RelationshipType type;

	@DBRef
	private Entity entityA, entityB;
}