package com.epam.classwork.se09.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXParser {

    public void parse(InputStream input) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            process(factory.createXMLStreamReader(input));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void process(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    writeStudentFeature(name);
                    StudentsEnum enumName = StudentsEnum.valueOf(name.toUpperCase());
                    studentInfoHandle(enumName, reader);
                    break;

                case XMLStreamConstants.CHARACTERS:
                    System.out.println(reader.getText().trim());
                    break;
            }
        }
    }

    private void studentInfoHandle(StudentsEnum enumName, XMLStreamReader reader) {
        switch (enumName) {
            case STUDENTS:
                System.out.println("Students:");
                break;

            case STUDENT:
                String login = reader.getAttributeValue(null, StudentsEnum.LOGIN.name().toLowerCase());
                String faculty = reader.getAttributeValue(null, StudentsEnum.FACULTY.name().toLowerCase());
                System.out.println("Student: Login: " + login + " Faculty: " + faculty);
            break;

            case ADDRESS:
                System.out.println(" Address: ");
                break;
        }
    }


    public void writeStudentFeature(String elementName) {
        switch (StudentsEnum.valueOf(elementName.toUpperCase())) {
            case STREET:
                System.out.print(" Street: ");
                break;

            case CITY:
                System.out.print(" City: ");
                break;

            case COUNTRY:
                System.out.print("Country: ");
                break;

            case TELEPHONE:
                System.out.print(" Telephone: ");
                break;

            case NAME:
                System.out.print("Name: ");
                break;
        }
    }
}


