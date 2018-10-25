package com.luxoft.springioc.lab1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder // @AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UsualPerson implements Person {
    int id;

    String name;

    Country country;

    int age;
    float height;
    boolean programmer;

    @Wither
    boolean broken;

    @Singular
    List<String> contacts;
}