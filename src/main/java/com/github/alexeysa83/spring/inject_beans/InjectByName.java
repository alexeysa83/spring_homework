package com.github.alexeysa83.spring.inject_beans;

import com.github.alexeysa83.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InjectByName {

    @Autowired
    private BaseService javaService;

    public BaseService getFirst() {
        return javaService;
    }

    @Autowired
    @Qualifier ("anotherJavaService")
    private BaseService blabla;

    public BaseService getSecond() {
        return blabla;
    }
}
