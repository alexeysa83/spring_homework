package com.github.alexeysa83.spring.bean_postprocessor.springAOP;

import com.github.alexeysa83.spring.bean_postprocessor.Profiling;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeMethodSniffer implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        if (!invocation.getMethod().isAnnotationPresent(Profiling.class)) {
            return invocation.proceed();
        }
        long start = System.currentTimeMillis();
        System.out.println("Method named: " + invocation.getMethod().getName() + " started at:" + start);

        final Object methodReturn = invocation.proceed();

        long finish = System.currentTimeMillis();
        System.out.println("Method named: " + invocation.getMethod().getName() + " finished at:" + finish);
        long executionTime = finish - start;
        System.out.println("Method work time (ms): " + executionTime + "\n");
        return methodReturn;
    }
}
