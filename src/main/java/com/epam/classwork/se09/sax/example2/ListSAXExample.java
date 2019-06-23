package com.epam.classwork.se09.sax.example2;

import java.util.*;
import java.util.function.Function;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import static java.util.stream.Collectors.joining;

public class ListSAXExample extends DefaultHandler {

    private Map<String, String> nameToClass;
    private Map<String, List<String>> nameToPatterns;
    private StringBuilder accumulator;

    private String servletName;
    private String servletClass;
    private String servletPattern;

    @Override
    public void startDocument() {
        accumulator = new StringBuilder();
        nameToPatterns = new HashMap<>();
        nameToClass = new HashMap<>();
    }

    @Override
    public void startElement(String namespaceURL, String localName, String qname, Attributes attributes) {
        accumulator.setLength(0);
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void endElement(String namespaceURL, String localName, String qname) {
        switch (localName) {
            case "servlet-name":
                servletName = accumulator.toString().trim();
                break;

            case "servlet-class":
                servletClass = accumulator.toString().trim();
                break;

            case "url-pattern":
                servletPattern = accumulator.toString().trim();
                break;

            case "servlet":
                nameToClass.put(servletName, servletClass);
                break;

            case "servlet-mapping":
                nameToPatterns.compute(servletName, (key, value) -> {
                    List<String> result = value == null ? new ArrayList<>() : value;
                    result.add(servletPattern);
                    return result;
                });
                break;
        }
    }

    @Override
    public void endDocument() {
        nameToClass.keySet()
                   .stream()
                   .sorted()
                   .map(this::prepareInfoAboutServlet)
                   .forEachOrdered(System.out::println);
    }

    private String prepareInfoAboutServlet(String name) {
        StringBuilder result = new StringBuilder();
        result.append("Servlet: ").append(name);
        result.append("Class: ").append(nameToClass.get(name));
        Optional.ofNullable(nameToPatterns.get(name))
                .ifPresent(patterns -> result.append("Patterns: ").append(patterns.stream().collect(joining("\t" + System.lineSeparator()))));
        return result.toString();
    }

    @Override
    public void warning(SAXParseException exception) {
        System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
        throw (exception);
    }
}
