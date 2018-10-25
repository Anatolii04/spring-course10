package com.luxoft.springioc.lab1.model;

import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class) //@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@FieldDefaults(level = PRIVATE)
public class SpringTCFAppTest {
	
	@Autowired
	Person person;

	Person expectedPerson = HelloWorldTest.getExpectedPerson();

	@Test
	public void testInitPerson() {
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

}
