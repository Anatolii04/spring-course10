package com.luxoft.springioc.lab1.model;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@FieldDefaults(level = PRIVATE)
public class HelloWorldTest {

	static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

	Person expectedPerson = getExpectedPerson();
	BeanFactory context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);

	@Test
	void testInitPerson() {
		Person person = (UsualPerson) context.getBean("person", Person.class);
		assertEquals(expectedPerson, person);
	}

	static Person getExpectedPerson() {
		return UsualPerson.builder()
				.age(35)
				.name("John Smith")
				.country(Country.builder()
						.id(1)
						.name("Russia")
						.codeName("RU").build())
				.contact("222-33-22")
				.contact("kjhdfg@kjhsdf.com")
				.build();
	}
}
