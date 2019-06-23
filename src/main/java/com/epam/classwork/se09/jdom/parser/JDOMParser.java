package com.epam.classwork.se09.jdom.parser;

import com.epam.classwork.se09.jdom.Student;
import org.jdom2.Document;
import org.jdom2.Element;

import java.util.stream.Stream;

public class JDOMParser {

    public static Stream<Student> parseStudents(Document document) {
        return document.getRootElement()
                       .getChildren()
                       .stream()
                       .map(JDOMParser::parseStudent);
    }

    private static Student parseStudent(Element element) {
        return Student.builder()
                      .login(element.getAttributeValue("login"))
                      .faculty(element.getAttributeValue("faculty"))
                      .name(element.getChildText("name"))
                      .telephone(Integer.parseInt(element.getChildText("telephone")))
                      .address(parseAddress(element.getChild("address")))
                      .build();
    }

    private static Student.Address parseAddress(Element element) {
        return Student.Address.builder()
                              .country(element.getChildText("country"))
                              .city(element.getChildText("city"))
                              .street(element.getChildText("street"))
                              .build();
    }
}
