package com.luxoft.springioc.lab1.model;

import java.util.List;

public interface Person {

    int getId();

    String getName();

    CountryImpl getCountryImpl();

    int getAge();

    Person setAge(int age);

    float getHeight();

    boolean isProgrammer();

    List<String> getContacts();

    default void sayHello(Person person) {
        System.out.printf(
            "Hello, %s. I'm %s.\n",
            person.getName(),
            this.getName());
    }
}