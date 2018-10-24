package com.luxoft.spring.lombok;// import com.luxoft.spring.lombok.Student

import lombok.SneakyThrows;
import lombok.val;
import org.assertj.core.api.AssertionsForClassTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class StudentTest {


  public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext(
      "application-context.xml");

  @Test
  @SneakyThrows
  @DisplayName("\"ToString\" method works correctly")
  void testToString() {

//    val student = Student.builder()
//        .age(17)
//        .name("Вася")
////        .marks(List.of(1, 2, 3))
//        .mark(1)
//        .mark(2)
//        .mark(3)
//        .mark(4)
//        .build();

    val student = CONTEXT
        .getBean("student", Student.class);

//    Class.forName("org.apache.logging.log4j.core.impl.Log4jContextFactory");

//        .setAge(19)
//        .setName("Вася");

//    student.setAge(55);

    AssertionsForClassTypes.assertThat(student.getAge())
        .isEqualTo(22);

    MatcherAssert.assertThat(student.getName(),
        Is.is("Иванов Иван"));

    Student student1 = student.withName("Федя");

    AssertionsForClassTypes.assertThat(student1.getAge())
        .isEqualTo(22);

    MatcherAssert.assertThat(student1.getName(),
        Is.is("Федя"));

  }

}