package com.epam.classwork.se09.jdom;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;

public class JDOMWriter {

    public static void main(String[] args) {
        JDOMWriter.lookForElement("students.xml", "telephone", "09", "mit");
        System.out.println("Изменение произведено успешно.");
    }

    private static void lookForElement(String filename, String targetElement, String content, String login) {
        try {
            Document document = new SAXBuilder().build(filename);

            document.getRootElement()
                    .getChildren()
                    .stream()
                    .filter(element -> element.getAttributeValue("login").equals(login))
                    .forEachOrdered(element -> element.getChild(targetElement).setText(content));

            XMLOutputter serializer = new XMLOutputter();
            try (FileOutputStream out = new FileOutputStream(filename)) {
                serializer.output(document, out);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи XML-файла" + e);
        } catch (JDOMException e) {
            System.err.println("Ошибка при разборе доку-мента" + e);
        }
    }
}

