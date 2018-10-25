package com.luxoft;

import com.luxoft.springioc.lab1.model.Country;
import com.luxoft.springioc.lab1.model.Person;
import com.luxoft.springioc.lab1.model.UsualPerson;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Configuration
@ImportResource(locations = "classpath:application-context.xml")
@FieldDefaults(level = PRIVATE)
public class JavaConfig {

  @Autowired
  Country country;

  @Bean
  List<String> contacts() {
//    return Arrays.asList();
    return List.of("222-33-22", "kjhdfg@kjhsdf.com");
  }

  @Bean
  Person person() {
    return UsualPerson.builder()
        .age(35)
        .name("John Smith")
        .height(1.78f)
        .programmer(true)
        .country(country)
        .contacts(contacts())
        .broken(false)
        .build();
  }
}
