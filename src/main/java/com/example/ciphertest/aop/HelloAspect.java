package com.example.ciphertest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class HelloAspect {

    @Pointcut(value = "@annotation(com.example.ciphertest.aop.HelloPoint)")
    private void checkPoint() {}


    @Around(value = "checkPoint()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        log.info("~~~~~hello!");
        Object[] args = point.getArgs();
        return point.proceed(args);
    }
}
