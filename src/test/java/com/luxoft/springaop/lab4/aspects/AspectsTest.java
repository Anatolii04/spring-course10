package com.luxoft.springaop.lab4.aspects;

import com.luxoft.JavaConfig;
import com.luxoft.springioc.lab1.model.Bar;
import com.luxoft.springioc.lab1.model.CustomerBrokenException;
import com.luxoft.springioc.lab1.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLClientInfoException;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ExtendWith(SpringExtension.class) //@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class AspectsTest {

	Person person;

	Bar bar;

	@Test
	@DisplayName("Customer broken test")
	void customerBrokenTest() {
		assertThat(bar.sellSquishee(person).getName(),
				is("Squishee"));
	}

	@Test
	@DisplayName("\"Name\" method works correctly")
	void testName() {
		assertThrows(CustomerBrokenException.class,
				() -> bar.sellSquishee(person.withBroken(true)));
	}
}
