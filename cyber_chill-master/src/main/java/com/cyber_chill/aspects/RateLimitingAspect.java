package com.cyber_chill.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class RateLimitingAspect {
    private int counter = 0;
    private long limitTime = 0;

    private Map<String, Long> methodInvocationTimestamps = new HashMap<>();
    private final long interval = 60 * 1000;

    @Before("execution(public String com.cyber_chill.controller.AdminController.getReserveInfoForAdmin())")
    public void rateLimiting(JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().toShortString();

        long now = System.currentTimeMillis();
        if (limitTime < now) {
            counter = 0;
        } else {
            counter++;
        }
        limitTime = now + interval;
        if (counter > 2) {
            throw new Exception("Rate limit exceeded for method: " + methodName);
        }


    }
}