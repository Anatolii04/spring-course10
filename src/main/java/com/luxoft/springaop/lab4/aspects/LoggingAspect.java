package com.luxoft.springaop.lab4.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Around("@annotation(LogExecutionTime)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    var proceed = joinPoint.proceed();

    long executionTime = System.currentTimeMillis() - start;

    System.out.printf("%s executed in %dms\n",
        joinPoint.getSignature(),
        executionTime);

    return proceed;
  }

  @Pointcut("@annotation(Loggable)")
  public void loggableAnnotatedMethod() {
  }

  @Around("loggableAnnotatedMethod()")
  public Object logIt(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    Object[] methodArgs = joinPoint.getArgs();

    log.info("Call method {} with args {} ", methodName, methodArgs);
    Object result = joinPoint.proceed();
    log.info("Method {} returns {}", methodName, result);
    return result;
  }


}
