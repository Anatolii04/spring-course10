package com.luxoft.springioc.lab1.model;

import java.util.List;

public interface Person {

    int getId();

    String getName();

    Country getCountry();

    int getAge();

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