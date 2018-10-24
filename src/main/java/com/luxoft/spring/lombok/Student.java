package com.luxoft.spring.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Accessors(chain = true)
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @NoArgsConstructor
//@Value // @Getter, @ToString, @EqualsAndHashCode, @AllArgsConstructor, @FieldDefaults(level = PRIVATE, makeFinal = true)
@FieldDefaults(level= PRIVATE)
@AllArgsConstructor
public final class Student {
  int age;
  String name;


}
