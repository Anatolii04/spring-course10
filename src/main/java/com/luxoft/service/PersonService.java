package com.luxoft.service;

import com.luxoft.data.PersonDao;
import com.luxoft.springioc.lab1.model.Person;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

//@Service
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class PersonService {

  PersonDao personDao;

  @SneakyThrows
  public final Optional<Person> getById(Long id) {
      return personDao.findById(id);
  }


}
