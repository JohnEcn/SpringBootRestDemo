package com.JohnEcon.SpringBootTutorial.controller.Logger;

import com.JohnEcon.SpringBootTutorial.controller.DepartmentController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggerAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(* com.JohnEcon.SpringBootTutorial.controller.*Controller.*(..))")
    private void aroundEveryApiRequest(){}

    @Before("aroundEveryApiRequest()")
    public void logApiRequest(JoinPoint jp)
    {
        LOGGER.info(LocalDateTime.now().format(dateFormat) + " : " + jp.getSignature().getName());
    }
}
