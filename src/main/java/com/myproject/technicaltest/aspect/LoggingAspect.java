package com.myproject.technicaltest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Aspect for logging execution of controller Spring components.
 *
 * @author Yasmine MANSOURI
 */

@Aspect
@Component
public class LoggingAspect {

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Pointcut that match the execution of any method of any class with any argument in the
     * controller package.
     */

    @Pointcut(value = "execution(* com.myproject.technicaltest.controller.*.*(..) )")
    public void myPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param pjp for advice
     * @return object
     * @throws Throwable
     */

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

        //t1 to register the time when the execution started
        long t1 = System.currentTimeMillis();

        ObjectMapper mapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();

        String className = pjp.getTarget().getClass().toString();

        Object[] array = pjp.getArgs();

        //logging the arguments given in the input
        log.info("Input for " + className + " : " + methodName + "()" + "Arguments : "
                + mapper.writeValueAsString(array));

        Object object = pjp.proceed();

        //logging the response received as an output
        log.info("Output for " + className + " : " + methodName + "()" + "Response : "
                + mapper.writeValueAsString(object));

        //t2 to register the time when the execution ended
        long t2 = System.currentTimeMillis();

        log.info("Processing Time: " + (t2 - t1) + " ms");

        return object;
    }

}