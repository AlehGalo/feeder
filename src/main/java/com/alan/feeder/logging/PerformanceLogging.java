package com.alan.feeder.logging;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by aleh_bahatyrou on 11/30/16.
 */
@Aspect
@Component
@Slf4j
public class PerformanceLogging {

    @Pointcut("execution(public String com.alan.feeder.service.UpworkService.getJobs(..))")
    public void servicePointCut() {

    }


    @Around("servicePointCut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object obj = pjp.proceed();
        log.debug("Completed: " + (System.nanoTime() - start) + " ns");
        return obj;
    }
}
