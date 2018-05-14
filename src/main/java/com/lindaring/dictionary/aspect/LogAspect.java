package com.lindaring.dictionary.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger log = Logger.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.lindaring.dictionary.annotation.LogExecutionTime)")
    public void LogExecutionTime() {
    }

    @Pointcut("@annotation(com.lindaring.dictionary.annotation.LogMethod)")
    public void logMethod() {
    }

    @Around("LogExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(String.format("Method '%s': completed in %s(ms)", methodName, executionTime));
        return proceed;
    }

    @Before("logMethod()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        String args = getArgs(joinPoint.getArgs());

        log.info(String.format("Method '%s': entered with args '%s'", methodName, args));
    }

    @AfterReturning(value = "logMethod()", returning = "response")
    public void logMethodSuccess(JoinPoint joinPoint, Object response) {
        String methodName = joinPoint.getSignature().getName();

        log.info(String.format("Method '%s': returned '%s'", methodName, response));
    }

    @AfterThrowing(value = "logMethod()", throwing = "exception")
    public void logMethodSuccess(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();

        log.error(String.format("Method '%s': throw '%s'", methodName, exception.getMessage()));
    }

    private String getArgs(Object[] args) {
        StringBuffer argsResult = new StringBuffer();

        for (int i = 0; i < args.length; i++) {
            argsResult.append("[").append((i + 1)).append("] ").append(args[i]);
            if ((i + 1) < args.length)
                argsResult.append(", ");
        }

        return argsResult.toString();
    }

}