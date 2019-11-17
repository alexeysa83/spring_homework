package com.github.alexeysa83.spring;

import com.github.alexeysa83.spring.bean_postprocessor.TestBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class PostprocessorTest {

    @Test
    void postprocessorSpringAopTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.alexeysa83.spring.bean_postprocessor.springAOP");
        context.register(TestBean.class);
        context.refresh();

        final TestBean bean = context.getBean(TestBean.class);
        System.out.println("-------------------\nSPRING AOP TEST:\n-------------------");

        bean.annotatedMethod();
        bean.withoutAnnotationMethod();

        bean.annotatedMethodWithParam("THIS METHOD IS ANNOTATED AND HAS STRING PARAM");
        bean.withoutAnnotationMethodWithParams("THIS METHOD WITHOUT ANNOTATION BUT HAS STRING PARAM");
    }

    @Test
    void postprocessorAspectJTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.alexeysa83.spring.bean_postprocessor.aspectJ");
        context.register(TestBean.class);
        context.refresh();

        final TestBean bean = context.getBean(TestBean.class);
        System.out.println("-------------------\nASPECTJ TEST:\n-------------------");

        bean.annotatedMethod();
        bean.withoutAnnotationMethod();

        bean.annotatedMethodWithParam("THIS METHOD IS ANNOTATED AND HAS STRING PARAM");
       bean.withoutAnnotationMethodWithParams("THIS METHOD WITHOUT ANNOTATION BUT HAS STRING PARAM");
    }
}
