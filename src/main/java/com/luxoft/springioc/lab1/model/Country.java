package com.luxoft.springioc.lab1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.checkerframework.checker.initialization.qual.Initialized;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Country {

  int id;

  String name;

  String codeName;

  public Country(String name, String codeName) {
    this.name = name;
    this.codeName = codeName;
  }
}
