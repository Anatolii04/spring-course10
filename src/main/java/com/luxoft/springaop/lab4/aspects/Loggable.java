package com.luxoft.springaop.lab4.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @see LoggingAspect#logg(ProceedingJoinPoint)
 */
@Retention(RUNTIME)
public @interface Loggable {
}
