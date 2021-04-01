package com.infosys.springboot.utility;

import com.infosys.springboot.DTO.CustomerDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // after throwing advice
    @AfterThrowing("execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))")
    public void logAfterThrowingAdvice(JoinPoint joinPoint) {
        logger.info("In after throwing advice, join point signature:{}", joinPoint.getSignature());

    }

    @AfterThrowing(pointcut = "execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))", throwing = "exception")
    public void logAfterThrowingAdviceDetails(JoinPoint joinPoint, Exception exception) {
        logger.info("In after throwing advice, Joinpoint signature :{}", joinPoint.getSignature());
        logger.error(exception.getMessage(), exception);
    }

    @After("execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))")
    public void logAfterAdvice(JoinPoint joinPoint) {
        logger.info("Ina after advice, Joinpoint signature :{}", joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}", date);
    }

    @Before("execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        logger.info("In before advice, JoinPoint signature :{}", joinPoint.getSignature());
        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}", date);
    }

    @AfterReturning(pointcut = "execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))")
    public void logAfterReturningAdvice(JoinPoint joinPoint) {

        logger.info("In before advice, JoinPoint signature :{}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))", returning = "result")
    public void logAfterReturningAdvice(JoinPoint joinPoint, List<CustomerDTO> result) {

        logger.info("In before advice, JoinPoint signature :{}", joinPoint.getSignature());

        System.out.println(result);

        long time = System.currentTimeMillis();
        String date = DateFormat.getDateTimeInstance().format(time);
        logger.info("Report generated at time {}", date);
    }

    @Around("execution(* com.infosys.springboot.service.CustomerServiceImpl.fetchCustomer(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before proceeding part of the around advice.");
        Object cust = joinPoint.proceed();
        System.out.println("After proceeding part of the around advice");
        return cust;
    }


}
