package com.musiccrux.discogs_xml_consumption.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Reads XML files as formatted by Discogs and provides useful iteration operations
 * functionality
 * 
 * @author Taiwo Oyekanmi
 *
 */

public class DiscogsXmlFileReader {

	private XMLStreamReader xmlStreamReader;
	private Transformer xmlTransformer;

	/**
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 * @throws FactoryConfigurationError
	 * @throws TransformerConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 */
	public DiscogsXmlFileReader(String filePath) throws FileNotFoundException, XMLStreamException,
			FactoryConfigurationError, TransformerConfigurationException, TransformerFactoryConfigurationError {

		xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(filePath));
		xmlTransformer = TransformerFactory.newInstance().newTransformer();
		xmlStreamReader.nextTag(); // Advance to statements element
	}

	/**
	 * Iterates over the XML file
	 * 
	 * @return false if done or true if there is more to read
	 * 
	 * @throws XMLStreamException
	 */
	public boolean hasNext() throws XMLStreamException {
		return xmlStreamReader.nextTag() == XMLStreamConstants.START_ELEMENT;
	}

	/**
	 * Obtains the XML String of a node from the position of the XMLStreamReader
	 * 
	 * @return
	 * @throws TransformerException
	 */
	public String next() throws TransformerException {
		return getStringFromStream(xmlStreamReader);
	}

	/**
	 * Transforms the xml stream being read and returns the string.
	 * 
	 * @param xmlStreamReader
	 * @return
	 * @throws TransformerException
	 */
	private String getStringFromStream(XMLStreamReader xmlStreamReader) throws TransformerException {

		StAXSource stAXSource = new StAXSource(xmlStreamReader);
		StringWriter stringWriter = new StringWriter();

		this.xmlTransformer.transform(stAXSource, new StreamResult(stringWriter));
		return stringWriter.toString();
	}
}
