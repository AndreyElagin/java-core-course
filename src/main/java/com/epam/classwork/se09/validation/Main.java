package com.epam.classwork.se09.validation;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        File schemaLocation = new File("/opt/xml/docbook/xsd/students.xsd");
        Schema schema = factory.newSchema(schemaLocation);

        Validator validator = schema.newValidator();

        Source source = new StreamSource(args[0]);

        try {
            validator.validate(source);
            System.out.println(args[0] + " is valid.");
        } catch (SAXException ex) {
            System.out.println(args[0] + " is not valid because ");
            System.out.println(ex.getMessage());
        }

    }
}

