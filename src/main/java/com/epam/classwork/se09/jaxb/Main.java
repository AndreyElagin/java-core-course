package com.epam.classwork.se09.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Throwable {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();

            Student.Address addr = new Student.Address("BLR", "Minsk", "Skoriny 4");
            Student student = new Student("mendig", "Dmitry Terenya", "rfe", 2066394, addr);

            try (FileOutputStream out = new FileOutputStream("stud.xml")) {
//                marshaller.marshal(student, out);
                marshaller.marshal(student, System.out);
            }
            System.out.println("XML-файл создан");
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не найден");
            e.printStackTrace();
        }
    }
}

