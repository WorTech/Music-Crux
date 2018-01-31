package com.Services;

import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

public class XmlFileReader {
    private XMLStreamReader xmlStreamReader;
    private Transformer xmlTransformer;


    public XmlFileReader(String filePath) throws FileNotFoundException, XMLStreamException,
            FactoryConfigurationError, TransformerConfigurationException, TransformerFactoryConfigurationError {

        xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileReader(filePath));
        xmlTransformer = TransformerFactory.newInstance().newTransformer();
        xmlStreamReader.nextTag(); // Advance to statements element
    }

    public boolean hasNext() throws XMLStreamException {
        return xmlStreamReader.nextTag() == XMLStreamConstants.START_ELEMENT;
    }

    public String next() throws TransformerException {
        return getStringFromStream(xmlStreamReader);
    }

    private String getStringFromStream(XMLStreamReader xmlStreamReader) throws TransformerException {

        StAXSource stAXSource = new StAXSource(xmlStreamReader);
        StringWriter stringWriter = new StringWriter();

        this.xmlTransformer.transform(stAXSource, new StreamResult(stringWriter));
        return stringWriter.toString();
    }

}
