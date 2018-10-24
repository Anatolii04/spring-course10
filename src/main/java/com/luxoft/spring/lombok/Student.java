package com.luxoft.spring.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Wither;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder // @AllArgsConstructor(AccessLevel.PRIVATE)
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @NoArgsConstructor
//@Value // @Getter, @ToString, @EqualsAndHashCode, @AllArgsConstructor, @FieldDefaults(level = PRIVATE, makeFinal = true)
public final class Student {

  @Builder.Default
  int age = 19;

  @Wither
  String name;

  @Singular
  List<Integer> marks;

  public static void main(String... __) {
    log.info("55 = {}", 55);
  }
}
