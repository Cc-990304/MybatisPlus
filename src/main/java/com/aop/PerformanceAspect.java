package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    public PerformanceAspect() {
        System.out.println("insert method");
    }

    // 定义切入点，匹配指定包下的insert方法
    @Pointcut("execution(public * com.controller.*.insert(..))")
    public void insertMethod() {
    }

    // 环绕通知，记录方法执行时间
    @Around("insertMethod()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            // 执行目标方法
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;

            // 输出方法执行时间
            logger.info("Method {} executed in {} ms",
                    joinPoint.getSignature().toShortString(),
                    executionTime);
        }
    }
}