package com.luxoft.springaop.lab4.aspects;

import com.luxoft.springioc.lab1.model.Drink;
import com.luxoft.springioc.lab1.model.Person;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Aspect
@Component
public final class Politeness {

  @Pointcut("execution(com.luxoft.springioc.lab1.model.Drink com.luxoft.springioc.lab1.model.ApuBar.sellSquishee(com.luxoft.springioc.lab1.model.Person))")
  void sellSquishee() {
  }

  @Before("sellSquishee() && args(person)")
  public final void sayHello(Person person) {
    log.info("Hello, {}! How are you doing?\n", person.getName());
  }

  @AfterReturning(pointcut = "sellSquishee()", returning = "drink")
  public final void askOpinion(Drink drink) {
    log.info("Is {} good enough?\n", drink.getName());
  }

  @AfterThrowing("sellSquishee()")
  public final void sayYouAreNotAllowed() {
    log.info("Hmmmmmmm...");
  }

  @After("sellSquishee()")
  public final void sayGoodBye() {
    log.info("Goodbye!");
  }
}
