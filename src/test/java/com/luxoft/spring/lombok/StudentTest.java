package com.luxoft.spring.lombok;// import com.luxoft.spring.lombok.Student

import lombok.SneakyThrows;
import org.assertj.core.api.AssertionsForClassTypes;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class StudentTest {
  @Test
  @SneakyThrows
  @DisplayName("\"ToString\" method works correctly")
  void testToString() {
    // given
    int x, y, z;
    x = 5 + 6;

    Student student = new Student(1, "")
        .setAge(19)
        .setName("Вася");

    student.setAge(55);

    AssertionsForClassTypes.assertThat(student.getAge())
        .isEqualTo(55);

    MatcherAssert.assertThat(student.getName(), Is.is("Вася"));
  }

}