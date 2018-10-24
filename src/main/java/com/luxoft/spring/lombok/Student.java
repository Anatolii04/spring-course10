package com.luxoft.spring.lombok;

import lombok.*;

//@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @NoArgsConstructor
@Value // @Getter, @ToString, @EqualsAndHashCode, @AllArgsConstructor, @FieldDefaults(level = PRIVATE, makeFinal = true)
public final class Student {
  int age;
  String name;
}
