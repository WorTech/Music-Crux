package com.musiccrux.discogs_xml_consumption.models;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sublabels {
	
	@JsonProperty("label")
	private String[] names;
	
	public String[] getNames() {
		return names;
	}

	@Override
	public String toString() {
		return "Sublabels:  [" + "names=" + Arrays.toString(names) + "]";
	}
	
	
}