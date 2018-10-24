package com.luxoft.spring.lombok;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class StudentProxy {

  @Delegate
  Student student;

  public boolean isRightStudent() {
    return student.getMarks().stream()
        .allMatch(mark -> mark.equals(5));
  }
}
