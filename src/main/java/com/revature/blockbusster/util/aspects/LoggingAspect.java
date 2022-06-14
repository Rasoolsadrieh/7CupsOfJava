package com.revature.blockbusster.util.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

    @Pointcut("within(com.revature..*)")
    public void logAll(){};

    @Before("logAll()")
    public void logMethodStart(JoinPoint jp){
        String methodSignature = extractMethodSignature(jp);
        String methodArguments = Arrays.toString(jp.getArgs());
        logger.info("{} successfully invoked at {} with provided arguments: {}", methodSignature, LocalDateTime.now().toString(), methodArguments);
    }

    @AfterReturning(pointcut = "logAll()", returning = "returnedObject")
    public void logMethodReturn(JoinPoint jp, Object returnedObject){
        logger.info("{} successfully returned at {} with value: {}", extractMethodSignature(jp), LocalDateTime.now().toString(), returnedObject);
    }

    @AfterThrowing(pointcut = "logAll()", throwing = "t")
    public void logMethodException(JoinPoint jp, Throwable t){
        String methodSignature = extractMethodSignature(jp);
        String throwableName = t.getClass().getName();

        logger.info("{} was thrown in {} at {} with value: {}", throwableName, methodSignature, LocalDateTime.now().toString(), t.getMessage());
    }

    private String extractMethodSignature(JoinPoint jp){
        return jp.getTarget().getClass().toString() + "#" + jp.getSignature().getName();
    }
}
