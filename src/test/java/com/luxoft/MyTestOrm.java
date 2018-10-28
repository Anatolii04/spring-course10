package com.luxoft;

import com.luxoft.data.CountryDao;
import com.luxoft.springioc.lab1.model.Country;
import com.luxoft.springioc.lab1.model.Person;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Period;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(onConstructor =  @__(@Autowired))
@FieldDefaults(level = PRIVATE, makeFinal = true)
@ExtendWith(SpringExtension.class) //@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@FixMethodOrder
public class MyTestOrm {
    CountryDao countryJpaDao;

    Person person;

    @Test
    public void testName(){
        Country country1 = new Country("Australia", "3");
        countryJpaDao.save(country1);
        Country country2 = countryJpaDao.getCountryByName("Australia");
        MatcherAssert.assertThat(country2.getName(), Is.is(country1.getName()));
    }

    @Test
    public void testSizeInDb(){
        Country country1 = new Country("2", "3");
        Country country2 = new Country("21", "31");
        countryJpaDao.save(country1);
        countryJpaDao.save(country2);
        List<Country> countryList = countryJpaDao.getAllCountries();
        MatcherAssert.assertThat(countryList.size(), Is.is(3));
        countryList.stream().forEach(e -> System.out.println(e));
    }
}
