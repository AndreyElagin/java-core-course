package com.epam.classwork.se09.sax.example2;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        org.xml.sax.XMLReader parser = XMLReaderFactory.createXMLReader();
        parser.setFeature("http://xml.org/sax/features/validation", false);
        ListSAXExample handler = new ListSAXExample();
        parser.setContentHandler(handler);
        parser.setErrorHandler(handler);
        org.xml.sax.InputSource input = new InputSource("web.xml");
        parser.parse(input);
    }
}

