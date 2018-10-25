package com.luxoft.springioc.lab1.model;

public interface Person {

    Person setName(String name);

    String getName ();

    default void sayHello(Person person) {
        System.out.printf(
            "Hello, %s. I'm %s.\n",
            person.getName(),
            this.getName());
    }
}