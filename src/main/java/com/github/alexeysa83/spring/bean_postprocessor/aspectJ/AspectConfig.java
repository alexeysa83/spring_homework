package com.github.alexeysa83.spring.bean_postprocessor.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AspectConfig {

    @Pointcut("@annotation(com.github.alexeysa83.spring.bean_postprocessor.Profiling)")
    public void measureWorkTime() {
    }

    @Around("measureWorkTime()")
    Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("Method named: " + joinPoint.getSignature().getName() + " started at:" + start);
        try {
            final Object methodReturn = joinPoint.proceed();
            long finish = System.currentTimeMillis();
            System.out.println("Method named: " + joinPoint.getSignature().getName() + "finished at:" + finish);
            long workTime = finish - start;
            System.out.println("Method work time (ms): " + workTime+ "\n");
            return methodReturn;
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
