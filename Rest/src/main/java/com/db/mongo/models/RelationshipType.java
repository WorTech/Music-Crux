package com.db.mongo.models;

public enum RelationshipType {
    UNKNOWN,
    //Artist to Band
    MEMBERSHIP,
    //Artist or Band to Track, Artist to Band
    FEATURED,
    //Artist or Band to Album
    RECORDED,
    //Artist or Band to Label
    SIGNED
}