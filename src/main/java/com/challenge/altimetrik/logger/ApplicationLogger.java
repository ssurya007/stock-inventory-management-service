package com.challenge.altimetrik.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ApplicationLogger {

    @Pointcut(value = "execution(* com.challenge.altimetrik.*.*.*(..))" )
    public void applicationPointcut(){}

    @Around(value = "applicationPointcut()")
    public Object logTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        Object[] args = joinPoint.getArgs();
        log.info("invoking method  : {} in class {} with args {}", method, className, args);
        Object result = joinPoint.proceed();
        log.info("printing result after invoking method  : {} in class {} with args {} : {}", method, className, args, result);
        return result;
    }
}
