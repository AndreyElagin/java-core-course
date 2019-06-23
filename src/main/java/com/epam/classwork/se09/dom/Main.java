package com.epam.classwork.se09.dom;

import java.util.ArrayList;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) {
        try {
            // создание DOM-анализатора(JSDK)
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // распознавание XML-документа
            Document document = db.parse("students.xml");
            // создание DOM-анализатора (Xerces)
            /*
             * DOMParser parser = new DOMParser(); parser.parse("students.xml");
             * Document document = parser.getDocument();
             */

            Element root = document.getDocumentElement();
            ArrayList<Student> students = DOMParser.listBuilder(root);
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("ошибка SAX парсера");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.print("ошибка конфигурации");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/О потока");
        }
    }
}

