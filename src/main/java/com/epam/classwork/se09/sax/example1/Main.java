package com.epam.classwork.se09.sax.example1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        SAXParser parser = factory.newSAXParser();
        parser.parse(Main.class.getResource("../../../../../../web.xml").getFile(), new SimpleSAXExample());
    }
}

