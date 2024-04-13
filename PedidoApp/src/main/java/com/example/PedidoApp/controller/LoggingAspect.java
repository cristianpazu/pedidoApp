package com.example.PedidoApp.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
/*

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(*  com.example.PedidoApp..*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        logger.info("{{LOG}} Before method execute: " + joinPoint.getSignature().toShortString());
        if (Arrays.stream(joinPoint.getArgs()).anyMatch(Objects::nonNull))
            logger.info("{{LOG}} Before method execute: " + Arrays.toString(Arrays.stream(joinPoint.getArgs()).toArray()));
    }

    @AfterReturning(pointcut = "execution(*  com.example.PedidoApp..*.*(..))", returning = "result")
    public void logAfterMethodExecution(JoinPoint joinPoint, Object result) {
        logger.info("{{LOG}} After method execute: " + joinPoint.getSignature().toShortString());
        if (Arrays.stream(joinPoint.getArgs()).anyMatch(Objects::nonNull))
            logger.info("{{LOG}} After method execute: " + Arrays.toString(joinPoint.getArgs()));
        logger.info("{{LOG}} Result : " + result);
    }
} */
