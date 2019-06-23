package com.epam.classwork.se09.jdom.creator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.epam.classwork.se09.dom.Student;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class JDOMCreator {
    public static Document create(List<Student> list) { // создание корневого
        // элемента
        // <studentsnew>
        Element root = new Element("studentsnew");
        for (Student student : list) {
            // создание элемента <student> и его содержимого
            Element studentElement = new Element("student");
            // создание атрибутов и передача им значений
            studentElement.setAttribute("login", student.getLogin());
            studentElement.setAttribute("phone",
                    String.valueOf(student.getTelephone()));
            Element faculty = new Element("faculty");
            faculty.setText(student.getFaculty());
            // «вложение» элемента <faculty> в элемент <student>
            studentElement.addContent(faculty);
            Element name = new Element("name");
            name.setText(student.getName());
            studentElement.addContent(name);
            // создание элемента <address>
            Element addressElement = new Element("address");
            Student.Address address = student.getAddress();
            Element country = new Element("country");
            country.setText(address.getCountry());
            addressElement.addContent(country);
            Element city = new Element("city");
            city.setText(address.getCity());
            addressElement.addContent(city);
            Element street = new Element("street");
            street.setText(address.getStreet());

            // «вложение» элемента <street> в элемент <address>
            addressElement.addContent(street);
            // «вложение» элемента <address> в элемент <student>
            studentElement.addContent(addressElement);
            // «вложение» элемента <student> в элемент <students>
            root.addContent(studentElement);
        } // конец цикла while
        // создание основного дерева XML-документа
        return new Document(root);
    }

    public static void saveDocument(String fileName, Document doc) throws IOException {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            new XMLOutputter().output(doc, out);
        }
    }
}



