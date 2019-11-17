package com.github.alexeysa83.spring.bean_postprocessor.springAOP;

import com.github.alexeysa83.spring.bean_postprocessor.Profiling;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class TimeMethodBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        final Method[] methods = bean.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Profiling.class)) {
                return wrapBean(bean);
            }
        }
        return bean;
    }

    private Object wrapBean(Object bean) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new TimeMethodSniffer());
        proxyFactory.setTarget(bean);
        return proxyFactory.getProxy();
    }

}
