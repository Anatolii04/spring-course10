package com.luxoft.springaop.lab4.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class LoggingAspect {

  @Pointcut("execution(* *.set*(..))")
  public void setterMethod() {
  }

  @Around("setterMethod() ")
  public Object setterLogger(ProceedingJoinPoint thisJoinPoint) throws Throwable {
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
