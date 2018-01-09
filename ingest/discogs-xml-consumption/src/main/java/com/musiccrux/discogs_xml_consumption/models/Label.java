package com.musiccrux.discogs_xml_consumption.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mockito.internal.util.collections.ArrayUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Label {
	@JsonProperty("id")
	private long discogs_id;
	@Indexed
	private String name;
	private Sublabels sublabels;
	private String contactinfo;
	private String[] parsedInfo;
	private List<String> locations;

	public Label() {
		this.locations = new ArrayList<String>();
	}
	public String getContactinfo() {
		return contactinfo;
	}
	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}
	public void setSublabels(Sublabels sublabels) {
		this.sublabels = sublabels;
	}
	public long getDiscogs_id() {
		return discogs_id;
	}
	public void setDiscogs_id(long discogs_id) {
		this.discogs_id = discogs_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Sublabels getSublabels() {
		return sublabels;
	}

	public List<String> getLocations() {
		return locations;
	}

	@Override
	public String toString() {
		return "Label [discogs_id=" + discogs_id + ", name=" + name + ", sublabels=" + sublabels + ", contactinfo="
				+ contactinfo + "]";
	}
}