package com.models;

import lombok.Data;

@Data
public class Relationship {
	private RelationshipType type;
	private Entity entityA, entityB;
}