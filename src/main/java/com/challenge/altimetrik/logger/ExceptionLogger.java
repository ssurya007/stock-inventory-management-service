package com.challenge.altimetrik.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Aspect
@Component
@Slf4j
public class ExceptionLogger {
    @Pointcut(value = "execution(* com.challenge.altimetrik.exceptions.StockTransactExceptionHandler.*(..))" )
    public void exceptionPointcut(){}

    @Before(value = "exceptionPointcut()")
    public void logExceptions(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        WebRequest webRequest = (WebRequest)args[1];
        Exception exception = (Exception)args[0];
        String uri = ((ServletWebRequest)webRequest).getRequest().getRequestURI();
        log.error("exception while accessing uri : {} ::: transactionId: {} ::: error message : {} "
                , uri, webRequest.getHeader("transactionId"), exception.getMessage());
    }
}
