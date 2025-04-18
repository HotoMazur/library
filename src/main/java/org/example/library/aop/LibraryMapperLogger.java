package org.example.library.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LibraryMapperLogger {
    @Pointcut("execution(* org.example.library.mapper..*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        log.info("Entering method: {} with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturningControllerMethods(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {} with result: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
    public void logAfterThrowingControllerMethods(JoinPoint joinPoint, Throwable exception) {
        log.info("Exception in method: {} with message: {}", joinPoint.getSignature(), exception.getMessage());
    }
}
