package com.cyber_chill.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* com.cyber_chill.service.*.*(..))", throwing = "exception")
    public void handleException(Exception exception) {
        System.out.println("Exception handled: " + exception.getMessage());
    }
}