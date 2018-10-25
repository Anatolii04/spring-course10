package com.luxoft.springioc.lab1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@Component
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Country {

  int id;

  String name;

  String codeName;

  public Country(String name, String codeName) {
    this.name = name;
    this.codeName = codeName;
  }
}
