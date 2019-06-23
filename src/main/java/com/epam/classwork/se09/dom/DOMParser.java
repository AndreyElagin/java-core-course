package com.epam.classwork.se09.dom;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParser {

    public static ArrayList<Student> listBuilder(Element root) {
        ArrayList<Student> students = new ArrayList<>();
        NodeList studentsNodes = root.getElementsByTagName("student");

        for (int i = 0; i < studentsNodes.getLength(); i++) {
            Element studentElement = (Element) studentsNodes.item(i);

            String faculty = studentElement.getAttribute("faculty");
            String login = studentElement.getAttribute("login");
            String name = getChildValue(studentElement, "name");
            Integer telephone = Integer.valueOf(getChildValue(studentElement, "telephone"));

            Element addressElement = getChild(studentElement, "address");
            String country = getChildValue(addressElement, "country");
            String city = getChildValue(addressElement, "city");
            String street = getChildValue(addressElement, "street");
            students.add(new Student(login, name, faculty, telephone, new Student.Address(country, city, street)));
        }
        return students;
    }

    private static Element getChild(Element parent, String childName) {
        return (Element) parent.getElementsByTagName(childName).item(0);
    }

    private static String getChildValue(Element parent, String childName) {
        return getChild(parent, childName).getFirstChild().getNodeValue();
    }
}

