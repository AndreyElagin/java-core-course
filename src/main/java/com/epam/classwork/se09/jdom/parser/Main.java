package com.epam.classwork.se09.jdom.parser;

import com.epam.classwork.se09.jdom.Student;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build("students.xml");

            try (Stream<Student> stream = JDOMParser.parseStudents(document)) {
                stream.forEachOrdered(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            System.err.print("Ошибка при разборе документа" + e);
        }
    }
}

