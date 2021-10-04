package com.jpmc.day15aopapp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.jpmc.*.*(..))")
    public void printTimeBeforeCalling(JoinPoint joinPoint) {
        System.out.println("*******Before calling " + joinPoint.getSignature() + " at " + Instant.now());
    }

    @After("execution(* Employee.work(..))")
    public void printTimeAfterCalling(JoinPoint joinPoint) {
        System.out.println("*******After calling " + joinPoint.getSignature() + " at " + Instant.now());
    }

    @Around("execution(* Employee.work(..))")
    public void blockEmployeeFromWorking(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Employee employee = (Employee)proceedingJoinPoint.getThis();
        if("Sam".equalsIgnoreCase(employee.getName())) {
            System.out.println("Bye Bye Sam! Go home!!!");
        } else {
            proceedingJoinPoint.proceed();
        }
    }

}
