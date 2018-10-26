package com.luxoft.data;

import com.luxoft.springioc.lab1.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends CrudRepository<Person, Long> {
}
