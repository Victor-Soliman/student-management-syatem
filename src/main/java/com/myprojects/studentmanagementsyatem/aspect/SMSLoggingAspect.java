package com.myprojects.studentmanagementsyatem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class SMSLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.myprojects.studentmanagementsyatem.controller.*.*(..))")
    private void forControllerPackage() {
    }

    // do the same for service and repository
    @Pointcut("execution(* com.myprojects.studentmanagementsyatem.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.myprojects.studentmanagementsyatem.repository.*.*(..))")
    private void forRepositoryPackage() {
    }

    // combine all point cuts sto match everything in controller,service and repository packages
    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {
    }

    // add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint) {

        // display method we are calling
        String theMethod = theJointPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method: " + theMethod);

        // display the arguments

        // 1.get the arguments

        Object[] args = theJointPoint.getArgs();

        // 2.loop thru the arg

        for (Object temp : args) {
            System.out.println(" ====> argument : " + temp);
        }

    }


    // add AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====> AfterReturning : from method : " + theMethod);

        // display data returned

        myLogger.info("======= result: " + theResult);

    }
}
