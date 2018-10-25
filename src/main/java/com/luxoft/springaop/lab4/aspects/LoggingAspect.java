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

  @Pointcut("@annotation(Loggable)")
  public void loggableAnnotatedMethod() {
  }

  @Around("loggableAnnotatedMethod() ")
  public Object logg(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    String methodName = thisJoinPoint.getSignature().getName();
    Object[] methodArgs = thisJoinPoint.getArgs();

    StringBuilder args = new StringBuilder();
    for (Object arg : methodArgs) {
      if (args.length() > 0) args.append(", ");
      args.append(arg.toString());
    }

    log.info("Call method {} with args {} ", methodName, args);
    Object result = thisJoinPoint.proceed();
    log.info("Method {} returns {}", methodName, result);
    return result;
  }
}
