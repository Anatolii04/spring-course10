package com.luxoft.springioc.lab1.model;

import com.luxoft.JavaConfig;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.assertEquals;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ExtendWith(SpringExtension.class) //@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:application-context.xml")
@ContextConfiguration(classes = JavaConfig.class)
class SpringTCFAppTest {

	Person person;

	@NonFinal
	Person expectedPerson = HelloWorldTest.getExpectedPerson();

	@Test
	void testInitPerson() {
		assertEquals(expectedPerson, person);
	}

}
