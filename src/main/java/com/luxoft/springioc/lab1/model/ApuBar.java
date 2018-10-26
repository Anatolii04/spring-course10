package com.luxoft.springioc.lab1.model;

import com.luxoft.springaop.lab4.aspects.LogExecutionTime;
import com.luxoft.springaop.lab4.aspects.Loggable;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Component
@FieldDefaults(level = PRIVATE)
public final class ApuBar implements Bar {

  @NotNull
  @Override
  @Loggable
  @LogExecutionTime
  public Drink sellSquishee(@NotNull Person person) {
    if (person.isBroken())
      throw new CustomerBrokenException();
    log.info("Here is your squishee.");
    return () -> "Squishee";
  }
}
