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

    private Map<String, Long> methodInvocationTimestamps = new HashMap<>();
    private final int limit = 2; // Максимальна кількість викликів за хвилину
    private final long interval = 60 * 1000; // Інтервал часу в мілісекундах (1 хв)

    @Before("execution(public String com.cyber_chill.controller.LoginController.login(..))")
    public void rateLimiting(JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().toShortString();

        long now = System.currentTimeMillis();
        long timestamp = methodInvocationTimestamps.getOrDefault(methodName, 0L);
        long elapsedTime = now - timestamp;

        if (elapsedTime < interval && methodInvocationTimestamps.containsKey(methodName)) {
            if (methodInvocationTimestamps.get(methodName) >= limit) {
                throw new Exception("Rate limit exceeded for method: " + methodName);
            }
            methodInvocationTimestamps.put(methodName, methodInvocationTimestamps.get(methodName) + 1);
        } else {
            methodInvocationTimestamps.put(methodName, 1L);
        }
    }
}