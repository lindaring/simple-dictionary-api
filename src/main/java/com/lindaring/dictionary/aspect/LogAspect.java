package com.lindaring.dictionary.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Aspect
@Component
public class LogAspect {

    private static final Logger log = Logger.getLogger(LogAspect.class);

    @Around("@annotation(com.lindaring.dictionary.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(String.format("Method '%s': completed in %s ms", joinPoint.getSignature().getName(), executionTime));
        return proceed;
    }

}