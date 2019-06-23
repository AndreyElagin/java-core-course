package com.epam.classwork.se09.jdom;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Student {

    String login;
    String name;
    String faculty;
    int telephone;
    Address address;

    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nTelephone: " + telephone + "\nFaculty:" + faculty + address;
    }

    @Value
    @Builder
    public static class Address {
        String country;
        String city;
        String street;

        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country + "\n\tCity: " + city + "\n\tStreet:" + street + "\n ";
        }
    }
}

