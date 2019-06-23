package com.epam.classwork.se09.jdom.creator;

import java.io.IOException;
import java.util.ArrayList;

import com.epam.classwork.se09.dom.Student;
import org.jdom2.Document;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int j = 1; j < 3; j++) {
            Student st = new Student();
            st.setName("Petrov" + j);
            st.setLogin("petr" + j);
            st.setFaculty("mmf");
            st.setTelephone(454556 + j * 3);
            Student.Address adr = st.getAddress();
            adr.setCity("Minsk");
            adr.setCountry("BLR");
            adr.setStreet("Gaja, " + j);
            st.setAddress(adr);
            students.add(st);
        }
        Document doc = JDOMCreator.create(students);
        try {
            JDOMCreator.saveDocument("studentsnew.xml", doc);
            System.out.println("Документ создан");
        } catch (IOException ex) {
            System.out.println("Документ НЕ создан");

        }
    }
}

