package com.github.alexeysa83.spring.bean_postprocessor;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

    @Profiling
    public void annotatedMethod() {
        sleepAndWrite("THIS METHOD IS ANNOTATED");
    }

    public void withoutAnnotationMethod() {
        sleepAndWrite("THIS METHOD WITHOUT ANNOTATION");
        System.out.println();
    }

    @Profiling
    public int annotatedMethodWithParam(String name) {
        sleepAndWrite(name);
        return 1;
    }

    public String withoutAnnotationMethodWithParams(String name) {
        sleepAndWrite(name);
        System.out.println();
        return "SUCCESS";
    }

    private void sleepAndWrite(String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name);
            }
}
